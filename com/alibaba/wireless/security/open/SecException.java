package com.alibaba.wireless.security.open;

import java.io.PrintStream;
import java.io.PrintWriter;

public class SecException extends Exception {
    public static final int ERROR_NULL_CONTEXT = -100;
    private int a;

    public SecException(int i) {
        this.a = i;
    }

    public SecException(String str, int i) {
        super(str);
        this.a = i;
    }

    public SecException(String str, Throwable th, int i) {
        super(str, th);
        this.a = i;
    }

    public SecException(Throwable th, int i) {
        super(th);
        this.a = i;
    }

    public int getErrorCode() {
        return this.a;
    }

    public void printStackTrace(PrintStream printStream) {
        StringBuilder stringBuilder = new StringBuilder("ErrorCode = ");
        stringBuilder.append(getErrorCode());
        printStream.println(stringBuilder.toString());
        super.printStackTrace(printStream);
    }

    public void printStackTrace(PrintWriter printWriter) {
        StringBuilder stringBuilder = new StringBuilder("ErrorCode = ");
        stringBuilder.append(getErrorCode());
        printWriter.println(stringBuilder.toString());
        super.printStackTrace(printWriter);
    }

    public void setErrorCode(int i) {
        this.a = i;
    }
}
