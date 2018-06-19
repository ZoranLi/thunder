package com.tencent.smtt.sdk;

final class ak extends ThreadLocal<Integer> {
    ak() {
    }

    public final Integer a() {
        return Integer.valueOf(0);
    }

    public final /* synthetic */ Object initialValue() {
        return a();
    }
}
