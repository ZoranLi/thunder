package anet.channel.entity;

import anet.channel.strategy.IConnStrategy;

/* compiled from: Taobao */
public class a {
    public final IConnStrategy a;
    public int b = 0;
    public int c = 0;
    private String d;
    private String e;

    public a(String str, String str2, IConnStrategy iConnStrategy) {
        this.a = iConnStrategy;
        this.d = str;
        this.e = str2;
    }

    public String a() {
        return this.a != null ? this.a.getIp() : null;
    }

    public int b() {
        return this.a != null ? this.a.getPort() : 0;
    }

    public ConnType c() {
        if (this.a != null) {
            return ConnType.valueOf(this.a.getProtocol());
        }
        return ConnType.HTTP;
    }

    public int d() {
        if (this.a == null || this.a.getConnectionTimeout() == 0) {
            return 20000;
        }
        return this.a.getConnectionTimeout();
    }

    public int e() {
        if (this.a == null || this.a.getReadTimeout() == 0) {
            return 20000;
        }
        return this.a.getReadTimeout();
    }

    public String f() {
        return this.d;
    }

    public int g() {
        return this.a != null ? this.a.getHeartbeat() : 45000;
    }

    public String h() {
        return this.e;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ConnInfo [ip=");
        stringBuilder.append(a());
        stringBuilder.append(",port=");
        stringBuilder.append(b());
        stringBuilder.append(",type=");
        stringBuilder.append(c());
        stringBuilder.append(",hb");
        stringBuilder.append(g());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
