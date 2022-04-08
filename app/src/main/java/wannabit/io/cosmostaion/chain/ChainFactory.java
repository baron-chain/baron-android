package wannabit.io.cosmostaion.chain;

import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_AKASH;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_ATOM;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_AXELAR;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_BAND;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_BITCANNA;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_BITSONG;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_BNB;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_CERTIK;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_CHIHUAHUA;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_COMDEX;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_CRBRUS;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_CRO;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_DESMOS;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_EVMOS;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_FET;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_GRABRIDGE;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_INJ;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_IRIS;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_JUNO;
import static wannabit.io.cosmostaion.base.BaseConstant.TOKEN_NGM;

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

            case BITSONG_MAIN:
                return new Bitsong();

            case CERBERUS_MAIN:
                return new Cerberus();

            case CERTIK_MAIN:
                return new Certik();

            case CHIHUAHUA_MAIN:
                return new Chihuahua();

            case COMDEX_MAIN:
                return new Comdex();

            case CRYPTO_MAIN:
                return new Crypto();

            case DESMOS_MAIN:
                return new Desmos();

            case EMONEY_MAIN:
                return new Emoney();

            case EVMOS_MAIN:
                return new Evmos();

            case FETCHAI_MAIN:
                return new Fetchai();

            case GRABRIDGE_MAIN:
                return new GravityBridge();

            case INJ_MAIN:
                return new Injective();

            case JUNO_MAIN:
                return new Juno();
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
        } else if (chainInfo.startsWith("bitcanna-") || chainInfo.startsWith("bcna1") || chainInfo.equalsIgnoreCase(TOKEN_BITCANNA)) {
            return new Bitcanna();
        } else if (chainInfo.startsWith("bitsong-") || chainInfo.startsWith("bitsong1") || chainInfo.equalsIgnoreCase(TOKEN_BITSONG)) {
            return new Bitsong();
        } else if (chainInfo.startsWith("cerberus-") || chainInfo.startsWith("cerberus1") || chainInfo.equalsIgnoreCase(TOKEN_CRBRUS)) {
            return new Cerberus();
        } else if (chainInfo.startsWith("shentu-") || chainInfo.startsWith("certik1") || chainInfo.equalsIgnoreCase(TOKEN_CERTIK)) {
            return new Certik();
        } else if (chainInfo.startsWith("chihuahua-") || chainInfo.startsWith("chihuahua1") || chainInfo.equalsIgnoreCase(TOKEN_CHIHUAHUA)) {
            return new Chihuahua();
        } else if (chainInfo.startsWith("comdex-") || chainInfo.startsWith("comdex1") || chainInfo.equalsIgnoreCase(TOKEN_COMDEX)) {
            return new Comdex();
        } else if (chainInfo.startsWith("crypto-org-") || chainInfo.startsWith("cro1") || chainInfo.equalsIgnoreCase(TOKEN_CRO)) {
            return new Crypto();
        } else if (chainInfo.startsWith("desmos-") || chainInfo.startsWith("desmos1") || chainInfo.equalsIgnoreCase(TOKEN_DESMOS)) {
            return new Desmos();
        } else if (chainInfo.startsWith("emoney-") || chainInfo.startsWith("emoney1") || chainInfo.equalsIgnoreCase(TOKEN_NGM)) {
            return new Emoney();
        } else if (chainInfo.startsWith("evmos") || chainInfo.startsWith("evmos1") || chainInfo.equalsIgnoreCase(TOKEN_EVMOS)) {
            return new Evmos();
        } else if (chainInfo.startsWith("fetchhub-") || chainInfo.startsWith("fetch1") || chainInfo.equalsIgnoreCase(TOKEN_FET)) {
            return new Fetchai();
        } else if (chainInfo.startsWith("gravity-bridge-") || chainInfo.startsWith("gravity1") || chainInfo.equalsIgnoreCase(TOKEN_GRABRIDGE)) {
            return new GravityBridge();
        } else if (chainInfo.startsWith("injective-") || chainInfo.startsWith("inj1") || chainInfo.equalsIgnoreCase(TOKEN_INJ)) {
            return new Injective();
        } else if (chainInfo.startsWith("juno-") || chainInfo.startsWith("juno1") || chainInfo.equalsIgnoreCase(TOKEN_JUNO)) {
            return new Juno();
        }
        return new Cosmos();
    }
}
