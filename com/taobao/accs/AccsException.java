package com.taobao.accs;

import java.io.PrintStream;
import java.io.PrintWriter;

/* compiled from: Taobao */
public class AccsException extends Exception {
    private int mErrorCode;

    public AccsException(int i) {
        this.mErrorCode = i;
    }

    public AccsException(String str) {
        super(str);
    }

    public AccsException(String str, int i) {
        super(str);
        this.mErrorCode = i;
    }

    public AccsException(String str, Throwable th, int i) {
        super(str, th);
        this.mErrorCode = i;
    }

    public AccsException(Throwable th, int i) {
        super(th);
        this.mErrorCode = i;
    }

    public void printStackTrace(PrintStream printStream) {
        StringBuilder stringBuilder = new StringBuilder("errorCode = ");
        stringBuilder.append(this.mErrorCode);
        printStream.println(stringBuilder.toString());
        super.printStackTrace(printStream);
    }

    public void printStackTrace(PrintWriter printWriter) {
        StringBuilder stringBuilder = new StringBuilder("errorCode = ");
        stringBuilder.append(this.mErrorCode);
        printWriter.println(stringBuilder.toString());
        super.printStackTrace(printWriter);
    }
}
