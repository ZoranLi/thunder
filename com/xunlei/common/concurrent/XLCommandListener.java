package com.xunlei.common.concurrent;

public interface XLCommandListener<T> {
    void onResponse(XLCommandResult<T> xLCommandResult);
}
