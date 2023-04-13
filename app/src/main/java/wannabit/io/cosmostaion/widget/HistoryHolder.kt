package wannabit.io.cosmostaion.widget

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.TextUtils
import android.view.View
import androidx.core.content.ContextCompat
import wannabit.io.cosmostaion.R
import wannabit.io.cosmostaion.activities.MainActivity
import wannabit.io.cosmostaion.base.BaseData
import wannabit.io.cosmostaion.base.chains.ChainConfig
import wannabit.io.cosmostaion.databinding.ItemHistoryViewBinding
import wannabit.io.cosmostaion.model.type.BnbHistory
import wannabit.io.cosmostaion.network.res.ResApiNewTxListCustom
import wannabit.io.cosmostaion.network.res.ResOkHistory.Data.transactionData
import wannabit.io.cosmostaion.utils.WDp
import java.text.SimpleDateFormat
import java.util.*

class HistoryHolder(itemView: View) : BaseHolder(itemView) {

    private lateinit var binding: ItemHistoryViewBinding

    fun onBindNewHistory(mainActivity: MainActivity, baseData: BaseData, chainConfig: ChainConfig, history: ResApiNewTxListCustom) {
        binding = ItemHistoryViewBinding.bind(itemView)
        binding.apply {
            history.getMsgType(mainActivity, mainActivity.mAccount.address)?.let { type ->
                historyType.text = type

                if (history.isSuccess) historyStatus.setImageResource(R.drawable.icon_success)
                else historyStatus.setImageResource(R.drawable.icon_fail)
                historyHash.text = history.data.txhash
                historyHeight.text = getGrpcTime(mainActivity, history.data.timestamp) + " (" + history.data.height + ")"

                val txCoin = history.getDpCoin(mainActivity.mBaseChain)
                if (type == mainActivity.getString(R.string.tx_vote)) {
                    historyEventAmount.text = ""
                    historyEventSymbol.text = history.voteOption
                } else if (txCoin != null) {
                    WDp.setDpCoin(mainActivity, baseData, chainConfig, txCoin, historyEventSymbol, historyEventAmount)
                    historyEventSymbol.setTextColor(ContextCompat.getColor(mainActivity, R.color.colorBlackDayNight))
                } else {
                    historyEventAmount.text = ""
                    historyEventSymbol.text = "-"
                }

                cardHistory.setOnClickListener {
                    val url = chainConfig.explorerHistoryLink(history.data.txhash)
                    Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                        mainActivity.startActivity(this)
                    }
                }
            }
        }
    }

    fun onBindBnbHistory(mainActivity: MainActivity, chainConfig: ChainConfig, history: BnbHistory) {
        binding = ItemHistoryViewBinding.bind(itemView)
        binding.apply {
            historyType.text = WDp.DpBNBTxType(mainActivity, history, mainActivity.mAccount.address)
            historyHash.text = history.txHash
            historyHeight.text = getBnbTime(mainActivity, history.timeStamp) + " (" + history.blockHeight.toString() + ")"

            if (history.code > 0) historyStatus.setImageResource(R.drawable.icon_fail)
            else historyStatus.setImageResource(R.drawable.icon_success)

            history.txAsset?.let {
                WDp.setDpCoin(mainActivity, mainActivity.baseDao, chainConfig, it, history.value, historyEventSymbol, historyEventAmount)
            } ?: run {
                historyEventAmount.text = ""
                historyEventSymbol.text = "-"
            }

            cardHistory.setOnClickListener {
                val url = chainConfig.explorerHistoryLink(history.txHash)
                Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                    mainActivity.startActivity(this)
                }
            }
        }
    }

    fun onBindOkHistory(mainActivity: MainActivity, chainConfig: ChainConfig, history: transactionData) {
        binding = ItemHistoryViewBinding.bind(itemView)
        binding.apply {
            historyType.ellipsize = TextUtils.TruncateAt.MIDDLE
            historyType.text = history.txId

            historyEventAmount.text = ""
            historyEventSymbol.text = "-"
            historyHash.text = history.blockHash
            historyHeight.text = getOkcTime(mainActivity, history.transactionTime) + " (" + history.height + ")"

            if (history.state == "success") historyStatus.setImageResource(R.drawable.icon_success)
            else historyStatus.setImageResource(R.drawable.icon_fail)
        }
    }

    private fun getGrpcTime(c: Context, timeStamp: String): String {
        val txTimeFormat = SimpleDateFormat(c.getString(R.string.str_tx_time_format))
        val myFormat = SimpleDateFormat(c.getString(R.string.str_dp_time_format6))
        txTimeFormat.timeZone = TimeZone.getTimeZone("UTC")
        return myFormat.format(txTimeFormat.parse(timeStamp))
    }

    private fun getBnbTime(c: Context, timeStamp: String): String {
        val txTimeFormat = SimpleDateFormat(c.getString(R.string.str_block_time_format))
        val myFormat = SimpleDateFormat(c.getString(R.string.str_dp_time_format6))
        txTimeFormat.timeZone = TimeZone.getTimeZone("UTC")
        return myFormat.format(txTimeFormat.parse(timeStamp))
    }

    private fun getOkcTime(c: Context, timeStamp: String): String {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeStamp.toLong()
        val simpleFormat = SimpleDateFormat(c.getString(R.string.str_dp_time_format6))
        return simpleFormat.format(calendar.timeInMillis)
    }
}