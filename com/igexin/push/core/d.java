package com.igexin.push.core;

public enum d {
    init,
    prepare,
    active,
    passive;

    public static d[] a() {
        return (d[]) e.clone();
    }
}
