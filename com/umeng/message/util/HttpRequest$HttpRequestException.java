package com.umeng.message.util;

import java.io.IOException;

public class HttpRequest$HttpRequestException extends RuntimeException {
    private static final long serialVersionUID = -1170466989781746231L;

    public /* synthetic */ Throwable getCause() {
        return a();
    }

    protected HttpRequest$HttpRequestException(IOException iOException) {
        super(iOException);
    }

    public IOException a() {
        return (IOException) super.getCause();
    }
}
