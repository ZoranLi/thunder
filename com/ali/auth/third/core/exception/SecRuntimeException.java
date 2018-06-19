package com.ali.auth.third.core.exception;

public class SecRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -2429061914258524220L;
    private int secCode;

    public SecRuntimeException(int i, Throwable th) {
        super(th);
        this.secCode = i;
    }

    public int getErrorCode() {
        return this.secCode;
    }

    public String getMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getMessage());
        stringBuilder.append(" secCode = ");
        stringBuilder.append(this.secCode);
        return stringBuilder.toString();
    }
}
