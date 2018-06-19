package com.ali.auth.third.core.exception;

import com.ali.auth.third.core.e.a;

public class AlibabaSDKException extends RuntimeException {
    private static final long serialVersionUID = 1357689949294215654L;
    private a message;

    public AlibabaSDKException(a aVar) {
        super(aVar == null ? "" : aVar.c);
        this.message = aVar;
    }

    public AlibabaSDKException(a aVar, Throwable th) {
        super(aVar == null ? "" : aVar.c, th);
        this.message = aVar;
    }

    public a getSDKMessage() {
        return this.message;
    }
}
