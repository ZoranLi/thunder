package com.alibaba.wireless.security.jaq;

import java.io.PrintStream;
import java.io.PrintWriter;

public class JAQException extends Exception {
    private int a;

    public JAQException(int i) {
        this.a = i;
    }

    public JAQException(String str, int i) {
        super(str);
        this.a = i;
    }

    public JAQException(String str, Throwable th, int i) {
        super(str, th);
        this.a = i;
    }

    public JAQException(Throwable th, int i) {
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
