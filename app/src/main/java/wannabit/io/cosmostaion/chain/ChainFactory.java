package wannabit.io.cosmostaion.chain;

import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_AKASH;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_ATOM;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_AXELAR;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_BAND;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_BITCANNA;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_BNB;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_IRIS;

import wannabit.io.cosmostaion.base.BaseChain;

public class ChainFactory {

    public static Chain getChain(BaseChain baseChain) {
        switch (baseChain) {
            case COSMOS_MAIN:

            case COSMOS_TEST:
                return new Cosmos();
            case IRIS_MAIN:

            case IRIS_TEST:
                return new Iris();

            case AKASH_MAIN:
                return new Akash();

            case AXELAR_MAIN:
                return new Axelar();

            case BAND_MAIN:
                return new Band();

            case BNB_MAIN:
                return new Bnb();

            case BITCANNA_MAIN:
                return new Bitcanna();
        }
        return new Cosmos();
    }

    public static Chain getChain(String chainInfo) {
        if (chainInfo.startsWith("cosmoshub-") || chainInfo.startsWith("cosmos1") || chainInfo.equalsIgnoreCase(TOKEN_ATOM)) {
            return new Cosmos();
        } else if (chainInfo.startsWith("irishub-") || chainInfo.startsWith("iaa1") || chainInfo.equalsIgnoreCase(TOKEN_IRIS)) {
            return new Iris();
        } else if (chainInfo.startsWith("akashnet-") || chainInfo.startsWith("akash1") || chainInfo.equalsIgnoreCase(TOKEN_AKASH)) {
            return new Akash();
        } else if (chainInfo.startsWith("axelar-") || chainInfo.startsWith("axelar1") || chainInfo.equalsIgnoreCase(TOKEN_AXELAR)) {
            return new Axelar();
        } else if (chainInfo.startsWith("laozi-mainnet") || chainInfo.startsWith("band1") || chainInfo.equalsIgnoreCase(TOKEN_BAND)) {
            return new Band();
        } else if (chainInfo.startsWith("bnb1") || chainInfo.equalsIgnoreCase(TOKEN_BNB)) {
            return new Bnb();
        } else if (chainInfo.startsWith("bitcanna-") || chainInfo.startsWith("bcna") || chainInfo.equalsIgnoreCase(TOKEN_BITCANNA)) {
            return new Bitcanna();
        }
        return new Cosmos();
    }
}
