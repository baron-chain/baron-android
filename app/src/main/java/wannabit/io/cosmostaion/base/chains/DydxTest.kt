package wannabit.io.cosmostaion.base.chains

import wannabit.io.cosmostaion.R
import wannabit.io.cosmostaion.base.BaseChain
import wannabit.io.cosmostaion.base.BaseConstant

class DydxTest : ChainConfig() {

    override fun baseChain(): BaseChain { return BaseChain.DYDX_TEST }
    override fun chainImg(): Int { return R.drawable.chain_dydx }
    override fun chainInfoImg(): Int { return R.drawable.infoicon_dydx }
    override fun chainInfoTitle(): Int { return R.string.str_front_guide_title_dydx }
    override fun chainInfoMsg(): Int { return R.string.str_front_guide_msg_dydx }
    override fun chainColor(): Int { return R.color.color_dydx }
    override fun chainBgColor(): Int { return R.color.colorTransBgDydx }
    override fun chainTabColor(): Int { return R.color.color_tab_myvalidator_dydx }
    override fun chainName(): String { return "dydx-testnet" }
    override fun chainKoreanName(): String { return "디와이디엑스 테스트넷" }
    override fun chainTitle(): String { return "dYdX-testnet" }
    override fun chainTitleToUp(): String { return "dYdX-TESTNET" }
    override fun chainIdPrefix(): String { return "dydx-testnet-" }

    override fun mainDenomImg(): Int { return R.drawable.token_dydx }
    override fun mainDenom(): String { return "dv4tnt" }
    override fun mainSymbol(): String { return "DYDX" }
    override fun addressPrefix(): String { return "dydx" }

    override fun dexSupport(): Boolean { return false }
    override fun wcSupport(): Boolean { return false }

    override fun grpcUrl(): String { return "grpc-office-dydx-testnet.cosmostation.io" }
    override fun explorerUrl(): String { return BaseConstant.EXPLORER_TESTNET_URL + "dydx-testnet/" }
    override fun homeInfoLink(): String { return "" }
    override fun blogInfoLink(): String { return "" }
    override fun coingeckoLink(): String { return "" }
}