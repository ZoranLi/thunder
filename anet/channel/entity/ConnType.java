package anet.channel.entity;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.strategy.ConnProtocol;
import anet.channel.util.HttpConstant;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class ConnType {
    public static ConnType HTTP = new ConnType(HttpConstant.HTTP);
    public static final String HTTP2 = "http2";
    public static ConnType HTTPS = new ConnType("https");
    public static final String PK_ACS = "acs";
    public static final String PK_CDN = "cdn";
    public static final String PK_OPEN = "open";
    public static final String RTT_0 = "0rtt";
    public static final String RTT_1 = "1rtt";
    public static final String SPDY = "spdy";
    private static Map<ConnProtocol, ConnType> connTypeMap = new HashMap();
    private String name = "";
    private String publicKey;
    private int spdyProtocol;

    /* compiled from: Taobao */
    public enum TypeLevel {
        SPDY,
        HTTP
    }

    private ConnType(String str) {
        this.name = str;
    }

    public static ConnType valueOf(ConnProtocol connProtocol) {
        if (connProtocol == null) {
            return null;
        }
        if (HttpConstant.HTTP.equalsIgnoreCase(connProtocol.protocol)) {
            return HTTP;
        }
        if ("https".equalsIgnoreCase(connProtocol.protocol)) {
            return HTTPS;
        }
        synchronized (connTypeMap) {
            if (connTypeMap.containsKey(connProtocol)) {
                ConnType connType = (ConnType) connTypeMap.get(connProtocol);
                return connType;
            }
            ConnType connType2 = new ConnType(connProtocol.toString());
            connType2.publicKey = connProtocol.publicKey;
            if (HTTP2.equalsIgnoreCase(connProtocol.protocol)) {
                connType2.spdyProtocol |= 8;
            } else if (SPDY.equalsIgnoreCase(connProtocol.protocol)) {
                connType2.spdyProtocol |= 2;
            }
            if (connType2.spdyProtocol == 0) {
                return null;
            }
            if (!TextUtils.isEmpty(connProtocol.publicKey)) {
                connType2.spdyProtocol |= 128;
                if (RTT_1.equalsIgnoreCase(connProtocol.rtt)) {
                    connType2.spdyProtocol |= 8192;
                } else if (RTT_0.equalsIgnoreCase(connProtocol.rtt)) {
                    connType2.spdyProtocol |= 4096;
                } else {
                    return null;
                }
                if (connProtocol.l7) {
                    connType2.spdyProtocol |= 16384;
                }
            }
            connTypeMap.put(connProtocol, connType2);
            return connType2;
        }
    }

    public int getTnetConType() {
        return this.spdyProtocol;
    }

    public int getTnetPublicKey(boolean z) {
        if (PK_CDN.equals(this.publicKey)) {
            return true;
        }
        if (GlobalAppRuntimeInfo.getEnv() == ENV.TEST) {
            return false;
        }
        if ("open".equals(this.publicKey)) {
            return z ? true : true;
        } else {
            if (PK_ACS.equals(this.publicKey)) {
                return z ? true : true;
            } else {
                return true;
            }
        }
    }

    public boolean isHttpType() {
        if (!equals(HTTP)) {
            if (!equals(HTTPS)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSSL() {
        if (!equals(HTTPS)) {
            if ((this.spdyProtocol & 128) == 0) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof ConnType) {
                return this == obj || this.name.equals(((ConnType) obj).name) != null;
            }
        }
        return false;
    }

    public TypeLevel getTypeLevel() {
        if (isHttpType()) {
            return TypeLevel.HTTP;
        }
        return TypeLevel.SPDY;
    }

    private int getPriority() {
        if (isHttpType()) {
            return 1;
        }
        return (this.spdyProtocol & 8) == 0 ? 0 : -1;
    }

    public static int compare(ConnType connType, ConnType connType2) {
        return connType.getPriority() - connType2.getPriority();
    }
}
