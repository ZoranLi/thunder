package com.qiniu.android.dns;

public final class NetworkInfo {
    public static final NetworkInfo a = new NetworkInfo(NetSatus.NO_NETWORK, 0);
    public static final NetworkInfo b = new NetworkInfo(NetSatus.WIFI, 0);
    public final int c;
    public final NetSatus d;

    public enum NetSatus {
        NO_NETWORK,
        WIFI,
        MOBILE
    }

    public NetworkInfo(NetSatus netSatus, int i) {
        this.d = netSatus;
        this.c = i;
    }
}
