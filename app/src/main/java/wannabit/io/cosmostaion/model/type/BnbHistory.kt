package wannabit.io.cosmostaion.model.type

data class BnbHistory(
    var txHash: String,
    var blockHeight: Int,
    var txType: String,
    var timeStamp: String,
    var fromAddr: String,
    var toAddr: String,
    var value: String?,
    var txAsset: String?,
    var code: Int
)
