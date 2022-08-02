package wannabit.io.cosmostaion.base.chains;

import static wannabit.io.cosmostaion.base.BaseConstant.COINGECKO_URL;
import static wannabit.io.cosmostaion.base.BaseConstant.EXPLORER_BASE_URL;
import static wannabit.io.cosmostaion.base.BaseConstant.MONIKER_URL;
import static wannabit.io.cosmostaion.base.BaseConstant.UNKNOWN_RELAYER_URL;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.ArrayList;

import wannabit.io.cosmostaion.R;
import wannabit.io.cosmostaion.base.BaseChain;

public class Tgrade extends ChainConfig {

    public BaseChain baseChain() { return BaseChain.TGRADE_MAIN; }
    public int chainImg() { return R.drawable.chain_tgrade; }
    public int chainInfoImg() { return R.drawable.infoicon_tgrade; }
    public int chainInfoTitle() { return R.string.str_front_guide_title_tgrade; }
    public int chainInfoMsg() { return R.string.str_front_guide_msg_tgrade; }
    public int chainColor() { return R.color.color_tgrade; }
    public int chainBgColor() { return R.color.colorTransBgTgrade; }
    public int chainTabColor() { return R.color.color_tab_myvalidator_tgrade; }
    public String chainName() { return "tgrade"; }
    public String chainIdPrefix() { return "tgrade-mainnet-"; }

    public int mainDenomImg() { return R.drawable.token_tgrade; }
    public String mainDenom() { return "utgd"; }
    public String addressPrefix() { return "tgrade"; }

    public boolean pushSupport() { return false; }
    public boolean dexSupport() { return false; }
    public boolean wcSupport() { return false; }

    public String grpcUrl() { return "lcd-tgrade-app.cosmostation.io"; }
    public String apiUrl() { return "https://api-tgrade.cosmostation.io/"; }

    public BigDecimal blockTime() { return new BigDecimal("5.804"); }
    public String explorerUrl() { return EXPLORER_BASE_URL + "tgrade/"; }
    public String monikerUrl() { return MONIKER_URL + "tgrade/"; }
    public String relayerImgUrl() { return UNKNOWN_RELAYER_URL + "tgrade/relay-tgrade-unknown.png"; }
    public String homeInfoLink() { return  "https://tgrade.finance/"; }
    public String blogInfoLink() { return  "https://medium.com/tgradefinance"; }
    public String coingeckoLink() { return  COINGECKO_URL + "tgrade"; }

    public ArrayList<String> gasRates() {
        return Lists.newArrayList("0.05utgd");
    }

    public int gasDefault() { return 0;}

    public ArrayList<String> supportHdPaths() {
        return Lists.newArrayList("m/44'/118'/0'/0/X");
    }
}
