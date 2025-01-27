package wannabit.io.cosmostaion.base.chains;

import static wannabit.io.cosmostaion.base.BaseConstant.COINGECKO_URL;
import static wannabit.io.cosmostaion.base.BaseConstant.EXPLORER_BASE_URL;

import wannabit.io.cosmostaion.R;
import wannabit.io.cosmostaion.base.BaseChain;

public class Chihuahua extends ChainConfig {

    public BaseChain baseChain() { return BaseChain.CHIHUAHUA_MAIN; }
    public int chainImg() { return R.drawable.chain_chihuahua; }
    public int chainInfoImg() { return R.drawable.infoicon_chihuahua; }
    public int chainInfoTitle() { return R.string.str_front_guide_title_chihuahua; }
    public int chainInfoMsg() { return R.string.str_front_guide_msg_chihuahua; }
    public int chainColor() { return R.color.color_chihuahua; }
    public int chainBgColor() { return R.color.colorTransBgChihuahua; }
    public int chainTabColor() { return R.color.color_tab_myvalidator_chihuahua; }
    public String chainName() { return "chihuahua"; }
    public String chainKoreanName() { return "치와와"; }
    public String chainIdPrefix() { return "chihuahua-"; }

    public int mainDenomImg() { return R.drawable.token_chihuahua; }
    public String mainDenom() { return "uhuahua"; }
    public String addressPrefix() { return "chihuahua"; }

    public boolean dexSupport() { return false; }
    public boolean wcSupport() { return true; }
    public boolean authzSupport() { return true; }

    public String grpcUrl() { return "grpc-chihuahua.cosmostation.io"; }

    public String explorerUrl() { return EXPLORER_BASE_URL + "chihuahua/"; }
    public String homeInfoLink() { return  "https://chi.huahua.wtf"; }
    public String blogInfoLink() { return  "https://chihuahuachain.medium.com/"; }
    public String coingeckoLink() { return  COINGECKO_URL + "chihuahua-chain"; }
}
