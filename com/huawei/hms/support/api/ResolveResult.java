package com.huawei.hms.support.api;

import com.huawei.hms.support.api.client.Result;

public class ResolveResult<T> extends Result {
    private T a;

    public ResolveResult() {
        this.a = null;
    }

    public ResolveResult(T t) {
        this.a = t;
    }

    public T getValue() {
        return this.a;
    }
}
