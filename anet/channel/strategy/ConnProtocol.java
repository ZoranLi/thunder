package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.k.a;
import anet.channel.util.HttpConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class ConnProtocol implements Serializable {
    public static final ConnProtocol HTTP = valueOf(HttpConstant.HTTP, null, null, false);
    public static final ConnProtocol HTTPS = valueOf("https", null, null, false);
    private static Map<String, ConnProtocol> protocolMap = new HashMap();
    private static final long serialVersionUID = -3523201990674557001L;
    final int isHttp;
    public final boolean l7;
    public final String name;
    public final String protocol;
    public final String publicKey;
    public final String rtt;

    public static ConnProtocol valueOf(a aVar) {
        return aVar == null ? null : valueOf(aVar.b, aVar.g, aVar.j, aVar.i);
    }

    public static ConnProtocol valueOf(String str, String str2, String str3, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String buildName = buildName(str, str2, str3, z);
        synchronized (protocolMap) {
            if (protocolMap.containsKey(buildName)) {
                ConnProtocol connProtocol = (ConnProtocol) protocolMap.get(buildName);
                return connProtocol;
            }
            ConnProtocol connProtocol2 = new ConnProtocol(buildName, str, str2, str3, z);
            protocolMap.put(buildName, connProtocol2);
            return connProtocol2;
        }
    }

    private ConnProtocol(String str, String str2, String str3, String str4, boolean z) {
        this.name = str;
        this.protocol = str2;
        this.rtt = str3;
        this.publicKey = str4;
        this.l7 = z;
        if (HttpConstant.HTTP.equalsIgnoreCase(str2) == null) {
            if ("https".equalsIgnoreCase(str2) == null) {
                str = null;
                this.isHttp = str;
            }
        }
        str = true;
        this.isHttp = str;
    }

    private static String buildName(String str, String str2, String str3, boolean z) {
        if (TextUtils.isEmpty(str3)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(18);
        stringBuilder.append(str);
        if (TextUtils.isEmpty(str2) == null) {
            stringBuilder.append("_");
            stringBuilder.append(str2);
        } else {
            stringBuilder.append("_0rtt");
        }
        stringBuilder.append("_");
        stringBuilder.append(str3);
        if (z) {
            stringBuilder.append("_l7");
        }
        return stringBuilder.toString();
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (obj instanceof ConnProtocol) {
                return this.name.equals(((ConnProtocol) obj).name);
            }
        }
        return null;
    }

    public int hashCode() {
        int hashCode = 527 + this.protocol.hashCode();
        if (this.rtt != null) {
            hashCode = (hashCode * 31) + this.rtt.hashCode();
        }
        if (this.publicKey != null) {
            hashCode = (hashCode * 31) + this.publicKey.hashCode();
        }
        return (31 * hashCode) + this.l7;
    }
}
