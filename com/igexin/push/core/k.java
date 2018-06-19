package com.igexin.push.core;

public enum k {
    HEARTBEAT_OK,
    HEARTBEAT_TIMEOUT,
    NETWORK_ERROR,
    NETWORK_SWITCH;

    public static k[] a() {
        return (k[]) e.clone();
    }
}
