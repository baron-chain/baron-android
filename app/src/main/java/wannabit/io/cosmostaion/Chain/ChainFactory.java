package wannabit.io.cosmostaion.Chain;

import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_ATOM;
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
        }
        return new Cosmos();
    }

    public static Chain getChain(String chainInfo) {
        if (chainInfo.startsWith("cosmoshub-") || chainInfo.startsWith("cosmos1") || chainInfo.equalsIgnoreCase(TOKEN_ATOM)) {
            return new Cosmos();
        } else if (chainInfo.startsWith("irishub-") || chainInfo.startsWith("iaa1") || chainInfo.equalsIgnoreCase(TOKEN_IRIS)) {
            return new Iris();
        }
        return new Cosmos();
    }
}
