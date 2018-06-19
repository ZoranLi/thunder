package com.igexin.push.core;

public enum c {
    start,
    analyze,
    determine,
    connectASNL,
    check,
    retire,
    stop;

    public static c[] a() {
        return (c[]) h.clone();
    }
}
