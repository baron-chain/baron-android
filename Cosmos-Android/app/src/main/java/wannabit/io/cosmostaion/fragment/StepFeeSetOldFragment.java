package wannabit.io.cosmostaion.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.addisonelliott.segmentedbutton.SegmentedButtonGroup;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import wannabit.io.cosmostaion.R;
import wannabit.io.cosmostaion.base.BaseBroadCastActivity;
import wannabit.io.cosmostaion.base.BaseChain;
import wannabit.io.cosmostaion.base.BaseFragment;
import wannabit.io.cosmostaion.model.type.Coin;
import wannabit.io.cosmostaion.model.type.Fee;
import wannabit.io.cosmostaion.utils.WDp;
import wannabit.io.cosmostaion.utils.WUtil;

import static wannabit.io.cosmostaion.base.BaseChain.BAND_MAIN;
import static wannabit.io.cosmostaion.base.BaseChain.KAVA_MAIN;
import static wannabit.io.cosmostaion.base.BaseChain.KAVA_TEST;

public class StepFeeSetOldFragment extends BaseFragment implements View.OnClickListener {

    private CardView                mFeeTotalCard;
    private TextView                mFeeDenom, mFeeAmount, mFeeValue;

    private CardView                mRateControlCard;
    private TextView                mGasAmount, mGasRate, mGasFee;
    private SegmentedButtonGroup    mButtonGroup;

    private LinearLayout            mSpeedLayer;
    private ImageView               mSpeedImg;
    private TextView                mSpeedTxt;

    private LinearLayout            mBottomControlCard;
    private Button                  mBtnBefore, mBtnNext;

    private int                     mSelectedGasPosition    = 1;
    private BigDecimal              mSelectedGasRate        = BigDecimal.ZERO;
    private BigDecimal              mEstimateGasAmount      = BigDecimal.ZERO;
    private BigDecimal              mFee                    = BigDecimal.ZERO;

    public static StepFeeSetOldFragment newInstance(Bundle bundle) {
        StepFeeSetOldFragment fragment = new StepFeeSetOldFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tx_step_fee_old, container, false);
        mFeeTotalCard = rootView.findViewById(R.id.card_fee_total);
        mFeeDenom = rootView.findViewById(R.id.fee_denom);
        mFeeAmount = rootView.findViewById(R.id.fee_amount);
        mFeeValue = rootView.findViewById(R.id.fee_value);

        mRateControlCard = rootView.findViewById(R.id.rate_control_layer);
        mGasAmount = rootView.findViewById(R.id.gas_amount);
        mGasRate = rootView.findViewById(R.id.gas_rate);
        mGasFee = rootView.findViewById(R.id.gas_fee);
        mButtonGroup = rootView.findViewById(R.id.btns_segmented);

        mSpeedLayer = rootView.findViewById(R.id.speed_layer);
        mSpeedImg = rootView.findViewById(R.id.speed_img);
        mSpeedTxt = rootView.findViewById(R.id.speed_txt);

        mBottomControlCard = rootView.findViewById(R.id.bottom_control_layer);
        mBtnBefore = rootView.findViewById(R.id.btn_before);
        mBtnNext = rootView.findViewById(R.id.btn_next);

        WDp.DpMainDenom(getContext(), getSActivity().mBaseChain, mFeeDenom);
        mFeeTotalCard.setCardBackgroundColor(WDp.getChainBgColor(getContext(), getSActivity().mBaseChain));
        mButtonGroup.setSelectedBackground(WDp.getChainColor(getContext(), getSActivity().mBaseChain));
        mButtonGroup.setRipple(WDp.getChainColor(getContext(), getSActivity().mBaseChain));

        mEstimateGasAmount = WUtil.getEstimateGasAmount(getContext(), getSActivity().mBaseChain, getSActivity().mTxType, (getSActivity().mValidators.size()));
        onUpdateView();

        mButtonGroup.setOnPositionChangedListener(new SegmentedButtonGroup.OnPositionChangedListener() {
            @Override
            public void onPositionChanged(int position) {
                mSelectedGasPosition = position;
                onUpdateView();
            }
        });
        mBtnBefore.setOnClickListener(this);
        mBtnNext.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onRefreshTab() {
        super.onRefreshTab();
        mFeeTotalCard.setVisibility(View.VISIBLE);
        if (getSActivity().mBaseChain.equals(KAVA_MAIN) || getSActivity().mBaseChain.equals(BAND_MAIN) || getSActivity().mBaseChain.equals(KAVA_TEST)) {
            mRateControlCard.setVisibility(View.VISIBLE);
        }
        mSpeedLayer.setVisibility(View.VISIBLE);
        mBottomControlCard.setVisibility(View.VISIBLE);
    }

    private void onCalculateFees() {
        mSelectedGasRate = WUtil.getGasRate(getSActivity().mBaseChain, mSelectedGasPosition);
        //TODO check OK
        mFee = mSelectedGasRate.multiply(mEstimateGasAmount).setScale(0, RoundingMode.UP);
    }

    private void onUpdateView() {
        onCalculateFees();

        mFeeAmount.setText(WDp.getDpAmount2(getContext(), mFee, WDp.mainDivideDecimal(getSActivity().mBaseChain), WDp.mainDivideDecimal(getSActivity().mBaseChain)));
        mFeeValue.setText(WDp.dpUserCurrencyValue(getBaseDao(), WDp.mainDenom(getSActivity().mBaseChain), mFee, WDp.mainDivideDecimal(getSActivity().mBaseChain)));

        mGasRate.setText(WDp.getDpGasRate(mSelectedGasRate.toPlainString()));
        mGasAmount.setText(mEstimateGasAmount.toPlainString());
        mGasFee.setText(mFee.toPlainString());

        if (getSActivity().mBaseChain.equals(KAVA_MAIN) || getSActivity().mBaseChain.equals(BAND_MAIN) || getSActivity().mBaseChain.equals(KAVA_TEST)) {
            if (mSelectedGasPosition == 0) {
                mSpeedImg.setImageDrawable(getResources().getDrawable(R.drawable.bycicle_img));
                mSpeedTxt.setText(getString(R.string.str_fee_speed_title_0));
            } else if (mSelectedGasPosition == 1) {
                mSpeedImg.setImageDrawable(getResources().getDrawable(R.drawable.car_img));
                mSpeedTxt.setText(getString(R.string.str_fee_speed_title_1));
            } else {
                mSpeedImg.setImageDrawable(getResources().getDrawable(R.drawable.rocket_img));
                mSpeedTxt.setText(getString(R.string.str_fee_speed_title_2));
            }

        } else {
            mSpeedImg.setImageDrawable(getResources().getDrawable(R.drawable.rocket_img));
            mSpeedTxt.setText(getString(R.string.str_fee_speed_title_2));
        }
    }

    @Override
    public void onClick(View v) {
        if (v.equals(mBtnBefore)) {
            getSActivity().onBeforeStep();

        } else if (v.equals(mBtnNext)) {
            if (onCheckValidate()) {
                onSetFee();
                getSActivity().onNextStep();
            }
        }
    }


    private boolean onCheckValidate() {
        return true;
    }

    private void onSetFee() {
        Fee fee = new Fee();
        Coin gasCoin = new Coin();
        gasCoin.denom = WDp.mainDenom(getSActivity().mBaseChain);
        gasCoin.amount = mFee.toPlainString();
        ArrayList<Coin> amount = new ArrayList<>();
        amount.add(gasCoin);
        fee.amount = amount;
        fee.gas = mEstimateGasAmount.toPlainString();
        getSActivity().mTxFee = fee;

    }


    private BaseBroadCastActivity getSActivity() {
        return (BaseBroadCastActivity)getBaseActivity();
    }
}
