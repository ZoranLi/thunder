package mtopsdk.mtop.domain;

import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.HttpConstant;
import com.taobao.accs.common.Constants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;

public enum MtopHeaderFieldEnum {
    ACT("x-act", "accessToken"),
    WUAT("x-wuat", "wua"),
    SID("x-sid", "sid"),
    TIME("x-t", DispatchConstants.TIMESTAMP),
    APPKEY("x-appkey", "appKey"),
    TTID("x-ttid", Constants.KEY_TTID),
    UTDID("x-utdid", "utdid"),
    SIGN("x-sign", "sign"),
    NQ("x-nq", "nq"),
    NETTYPE("x-nettype", DispatchConstants.NET_TYPE),
    PV(HttpConstant.X_PV, SocializeProtocolConstants.PROTOCOL_KEY_PV),
    UID("x-uid", "uid"),
    UMID("x-umt", "umt"),
    MTOP_FEATURE("x-features", "x-features"),
    X_APP_VER("x-app-ver", "x-app-ver"),
    USER_AGENT("user-agent", "user-agent");
    
    private String headField;
    private String xstateKey;

    private MtopHeaderFieldEnum(String str, String str2) {
        this.headField = str;
        this.xstateKey = str2;
    }

    public final String getHeadField() {
        return this.headField;
    }

    public final String getXstateKey() {
        return this.xstateKey;
    }
}
