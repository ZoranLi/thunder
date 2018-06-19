package com.xunlei.common.concurrent;

public class XLCommandResult<T> {
    public T data;
    public ResultCode resultCode;

    public enum ResultCode {
        SUCCESSFUL,
        FAILED
    }

    public XLCommandResult() {
        this.resultCode = ResultCode.SUCCESSFUL;
    }

    public XLCommandResult(ResultCode resultCode, T t) {
        this.resultCode = resultCode;
        this.data = t;
    }

    public boolean isSuccessful() {
        return this.resultCode == ResultCode.SUCCESSFUL;
    }
}
