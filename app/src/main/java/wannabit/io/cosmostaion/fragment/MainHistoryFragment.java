package wannabit.io.cosmostaion.fragment;

import static wannabit.io.cosmostaion.base.BaseChain.BNB_MAIN;
import static wannabit.io.cosmostaion.base.BaseChain.OKEX_MAIN;
import static wannabit.io.cosmostaion.base.BaseChain.isGRPC;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.gms.common.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import wannabit.io.cosmostaion.R;
import wannabit.io.cosmostaion.activities.MainActivity;
import wannabit.io.cosmostaion.base.BaseChain;
import wannabit.io.cosmostaion.base.BaseConstant;
import wannabit.io.cosmostaion.base.BaseFragment;
import wannabit.io.cosmostaion.base.chains.ChainConfig;
import wannabit.io.cosmostaion.dao.Account;
import wannabit.io.cosmostaion.model.type.BnbHistory;
import wannabit.io.cosmostaion.network.res.ResApiNewTxListCustom;
import wannabit.io.cosmostaion.network.res.ResOkHistory;
import wannabit.io.cosmostaion.task.FetchTask.ApiAccountTxsHistoryTask;
import wannabit.io.cosmostaion.task.FetchTask.BnbHistoryTask;
import wannabit.io.cosmostaion.task.FetchTask.OkHistoryTask;
import wannabit.io.cosmostaion.task.TaskListener;
import wannabit.io.cosmostaion.task.TaskResult;
import wannabit.io.cosmostaion.utils.WDp;
import wannabit.io.cosmostaion.widget.HistoryHolder;


public class MainHistoryFragment extends BaseFragment implements TaskListener {
    private CardView mCardView;
    private ImageView itemKeyStatus;
    private TextView mWalletAddress, mEthAddress;
    private TextView mTotalValue;

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private LinearLayout mEmptyHistory;
    private HistoryAdapter mHistoryAdapter;

    private ArrayList<BnbHistory> mBnbHistory = new ArrayList<>();
    private ArrayList<ResOkHistory.Data.transactionData> mOkHistory = new ArrayList<>();
    private ArrayList<ResApiNewTxListCustom> mApiNewTxCustomHistory = new ArrayList<>();

    private Account mAccount;
    private BaseChain mBaseChain;
    private ChainConfig mChainConfig;
    private View rootView;
    private int mId = 0;
    private boolean mHasMore = false;
    private boolean isLoading = false;

    public static MainHistoryFragment newInstance() {
        return new MainHistoryFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main_history, container, false);
        initView();
        onUpdateView();
        return rootView;
    }

    private void initView() {
        mCardView = rootView.findViewById(R.id.card_root);
        itemKeyStatus = rootView.findViewById(R.id.img_account);
        mWalletAddress = rootView.findViewById(R.id.wallet_address);
        mEthAddress = rootView.findViewById(R.id.eth_address);
        mTotalValue = rootView.findViewById(R.id.total_value);
        mSwipeRefreshLayout = rootView.findViewById(R.id.layer_refresher);
        mRecyclerView = rootView.findViewById(R.id.recycler);
        mEmptyHistory = rootView.findViewById(R.id.empty_history);

        mCardView.setOnClickListener(v -> getMainActivity().onClickQrCopy(mChainConfig, mAccount));

        mSwipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(getMainActivity(), R.color.colorPrimary));
        mSwipeRefreshLayout.setOnRefreshListener(this::onRefreshTab);

        initRecyclerView();
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
        mHistoryAdapter = new HistoryAdapter();
        mRecyclerView.setAdapter(mHistoryAdapter);
        RecyclerViewHeader recyclerViewHeader = new RecyclerViewHeader(getMainActivity(), true, getSectionCall());
        mRecyclerView.addItemDecoration(recyclerViewHeader);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (recyclerView.getAdapter() != null && recyclerView.getAdapter().getItemCount() == 0) {
                    return;
                }

                int lastVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                int itemTotalCount = recyclerView.getAdapter().getItemCount() - 1;
                if (lastVisibleItemPosition == itemTotalCount && isGRPC(mBaseChain)) {
                    if (mHasMore) {
                        mHasMore = false;
                        onFetchHistory();
                    }
                }
            }
        });
    }

    private void onUpdateView() {
        if (getMainActivity() == null || getMainActivity().mAccount == null) return;
        mAccount = getMainActivity().mAccount;
        mBaseChain = BaseChain.getChain(mAccount.baseChain);
        mChainConfig = getMainActivity().mChainConfig;

        mCardView.setCardBackgroundColor(ContextCompat.getColor(getActivity(), mChainConfig.chainBgColor()));
        getMainActivity().setAccountKeyStatus(getActivity(), mAccount, mChainConfig, itemKeyStatus);
        mWalletAddress.setText(mAccount.address);
        getMainActivity().setEthAddress(mChainConfig, mEthAddress);
        mTotalValue.setText(WDp.dpAllAssetValue(mBaseChain, getBaseDao(), mChainConfig));
    }

    @Override
    public void onRefreshTab() {
        if (!isAdded()) return;
        mId = 0;
        mApiNewTxCustomHistory.clear();
        mHistoryAdapter.notifyDataSetChanged();
        onUpdateView();
        onFetchHistory();
    }

    private void onFetchHistory() {
        if (getMainActivity() == null || getMainActivity().mAccount == null) return;
        if (isLoading) {
            return;
        }
        isLoading = true;
        if (mBaseChain.equals(BNB_MAIN)) {
            new BnbHistoryTask(getBaseApplication(), this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, mAccount.address, WDp.threeMonthAgoTimeString(), WDp.cTimeString());
        } else if (mBaseChain.equals(OKEX_MAIN)) {
            new OkHistoryTask(getBaseApplication(), this, mAccount.address).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            new ApiAccountTxsHistoryTask(getBaseApplication(), this, mChainConfig.chainName(), mAccount.address, mId).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
    }

    @Override
    public void onTaskResponse(TaskResult result) {
        if (!isAdded()) return;
        if (isLoading) {
            isLoading = false;
        }
        mSwipeRefreshLayout.setRefreshing(false);
        if (result == null || result.resultData == null) {
            return;
        }

        if (result.taskType == BaseConstant.TASK_FETCH_BNB_HISTORY) {
            mBnbHistory = (ArrayList<BnbHistory>) result.resultData;
            if (!CollectionUtils.isEmpty(mBnbHistory)) {
                mEmptyHistory.setVisibility(View.GONE);
                mRecyclerView.setVisibility(View.VISIBLE);
                mHistoryAdapter.notifyDataSetChanged();
            } else {
                mEmptyHistory.setVisibility(View.VISIBLE);
                mRecyclerView.setVisibility(View.GONE);
            }

        } else if (result.taskType == BaseConstant.TASK_FETCH_OK_HISTORY) {
            mOkHistory = (ArrayList<ResOkHistory.Data.transactionData>) result.resultData;
            if (!CollectionUtils.isEmpty(mOkHistory)) {
                mEmptyHistory.setVisibility(View.GONE);
                mRecyclerView.setVisibility(View.VISIBLE);
                mHistoryAdapter.notifyDataSetChanged();
            } else {
                mEmptyHistory.setVisibility(View.VISIBLE);
                mRecyclerView.setVisibility(View.GONE);
            }

        } else if (result.taskType == BaseConstant.TASK_FETCH_API_ADDRESS_HISTORY) {
            mApiNewTxCustomHistory.addAll((ArrayList<ResApiNewTxListCustom>) result.resultData);
            ArrayList<ResApiNewTxListCustom> tempList = (ArrayList<ResApiNewTxListCustom>) result.resultData;
            if (!CollectionUtils.isEmpty(mApiNewTxCustomHistory)) {
                if (tempList.size() >= 30) {
                    mId = mApiNewTxCustomHistory.get(mApiNewTxCustomHistory.size() - 1).header.id;
                    mHasMore = true;
                } else {
                    mId = 0;
                    mHasMore = false;
                }
                mEmptyHistory.setVisibility(View.GONE);
                mRecyclerView.setVisibility(View.VISIBLE);
                mHistoryAdapter.notifyDataSetChanged();
            } else {
                mEmptyHistory.setVisibility(View.VISIBLE);
                mRecyclerView.setVisibility(View.GONE);
            }
        }
    }

    public MainActivity getMainActivity() {
        return (MainActivity) getBaseActivity();
    }

    private class HistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            return new HistoryHolder(getLayoutInflater().inflate(R.layout.item_history_view, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
            HistoryHolder holder = (HistoryHolder) viewHolder;
            if (isGRPC(mBaseChain)) {
                final ResApiNewTxListCustom history = mApiNewTxCustomHistory.get(position);
                holder.onBindNewHistory(getMainActivity(), getBaseDao(), mChainConfig, history);
            } else {
                final BnbHistory history = mBnbHistory.get(position);
                holder.onBindBnbHistory(getMainActivity(), mChainConfig, history);
            }
        }

        @Override
        public int getItemCount() {
            if (mBaseChain.equals(BNB_MAIN)) {
                return mBnbHistory.size();
            } else if (mBaseChain.equals(OKEX_MAIN)) {
                return mOkHistory.size();
            } else {
                return mApiNewTxCustomHistory.size();
            }
        }
    }

    public class RecyclerViewHeader extends RecyclerView.ItemDecoration {
        private final int topPadding;
        private final boolean sticky;
        private final SectionCallback sectionCallback;

        private View headerView;
        private TextView mTitle, mItemCnt;

        public RecyclerViewHeader(Context context, boolean sticky, @NonNull SectionCallback sectionCallback) {
            this.sticky = sticky;
            this.sectionCallback = sectionCallback;
            topPadding = dpToPx(context, 32);
        }

        private int dpToPx(Context context, int dp) {
            return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
        }

        @Override
        public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.onDrawOver(c, parent, state);

            if (headerView == null) {
                headerView = inflateHeaderView(parent);
                mTitle = (TextView) headerView.findViewById(R.id.header_title);
                mItemCnt = (TextView) headerView.findViewById(R.id.recycler_cnt);
                fixLayoutSize(headerView, parent);
            }

            CharSequence previousHeader = "";
            for (int i = 0; i < parent.getChildCount(); i++) {
                View child = parent.getChildAt(i);
                final int position = parent.getChildAdapterPosition(child);
                if (position == RecyclerView.NO_POSITION) {
                    return;
                }

                CharSequence title = sectionCallback.SectionHeader(position);
                mTitle.setText(title);
                mItemCnt.setVisibility(View.GONE);
                if (!previousHeader.equals(title) || sectionCallback.isSection(position)) {
                    drawHeader(c, child, headerView);
                    previousHeader = title;
                }
            }
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            int position = parent.getChildAdapterPosition(view);
            if (sectionCallback.isSection(position)) {
                outRect.top = topPadding;
            }
        }

        private View inflateHeaderView(RecyclerView parent) {
            return LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sticky_header, parent, false);
        }

        private void drawHeader(Canvas c, View child, View headerView) {
            c.save();
            if (sticky) {
                c.translate(0, Math.max(0, child.getTop() - headerView.getHeight()));
            } else {
                c.translate(0, child.getTop() - headerView.getHeight());
            }
            headerView.draw(c);
            c.restore();
        }

        private void fixLayoutSize(View view, ViewGroup parent) {
            int widthSpec = View.MeasureSpec.makeMeasureSpec(parent.getWidth(),
                    View.MeasureSpec.EXACTLY);
            int heightSpec = View.MeasureSpec.makeMeasureSpec(parent.getHeight(),
                    View.MeasureSpec.UNSPECIFIED);

            int childWidth = ViewGroup.getChildMeasureSpec(widthSpec,
                    parent.getPaddingLeft() + parent.getPaddingRight(),
                    view.getLayoutParams().width);
            int childHeight = ViewGroup.getChildMeasureSpec(heightSpec,
                    parent.getPaddingTop() + parent.getPaddingBottom(),
                    view.getLayoutParams().height);

            view.measure(childWidth, childHeight);
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public interface SectionCallback {
        boolean isSection(int position);

        CharSequence SectionHeader(int position);
    }

    private SectionCallback getSectionCall() {
        return new SectionCallback() {
            @Override
            public boolean isSection(int position) {
                if (isGRPC(mBaseChain)) {
                    return position == 0 || !getGrpcTxTimeFormat(mApiNewTxCustomHistory.get(position).data.timestamp)
                            .equals(getGrpcTxTimeFormat(mApiNewTxCustomHistory.get(position - 1).data.timestamp));
                } else {
                    return position == 0 || !getBnbTxTimeFormat(mBnbHistory.get(position).getTimeStamp())
                            .equals(getBnbTxTimeFormat(mBnbHistory.get(position - 1).getTimeStamp()));
                }
            }

            @Override
            public CharSequence SectionHeader(int position) {
                Date date = new Date(System.currentTimeMillis());
                SimpleDateFormat nowDateFormat = new SimpleDateFormat(getString(R.string.str_dp_time_format4));
                String getNowTime = nowDateFormat.format(date);

                if (isGRPC(mBaseChain)) {
                    if (getNowTime.equalsIgnoreCase(getGrpcTxTimeFormat(mApiNewTxCustomHistory.get(position).data.timestamp))) {
                        return "Today";
                    } else {
                        return getGrpcTxTimeFormat(mApiNewTxCustomHistory.get(position).data.timestamp);
                    }
                } else {
                    if (mBnbHistory != null && mBnbHistory.size() > 0) {
                        if (getNowTime.equalsIgnoreCase(getBnbTxTimeFormat(mBnbHistory.get(position).getTimeStamp()))) {
                            return "Today";
                        } else {
                            return getBnbTxTimeFormat(mBnbHistory.get(position).getTimeStamp());
                        }
                    } else {
                        return "";
                    }
                }
            }
        };
    }

    private String getGrpcTxTimeFormat(String rawValue) {
        String result = "??";
        try {
            SimpleDateFormat blockDateFormat = new SimpleDateFormat(getString(R.string.str_tx_time_format));
            SimpleDateFormat myFormat = new SimpleDateFormat(getString(R.string.str_dp_time_format4));
            blockDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            result = myFormat.format(blockDateFormat.parse(rawValue));
        } catch (Exception e) { }
        return result;
    }

    private String getBnbTxTimeFormat(String rawValue) {
        String result = "??";
        try {
            SimpleDateFormat blockDateFormat = new SimpleDateFormat(getString(R.string.str_block_time_format));
            SimpleDateFormat myFormat = new SimpleDateFormat(getString(R.string.str_dp_time_format4));
            blockDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            result = myFormat.format(blockDateFormat.parse(rawValue));
        } catch (Exception e) { }
        return result;
    }
}

