package com.umeng.socialize;

import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

public class SocializeException extends RuntimeException {
    private static final long b = 1;
    protected int a = ReaderCallback.GET_BAR_ANIMATING;
    private String c = "";

    public int getErrorCode() {
        return this.a;
    }

    public SocializeException(int i, String str) {
        super(str);
        this.a = i;
        this.c = str;
    }

    public SocializeException(String str, Throwable th) {
        super(str, th);
        this.c = str;
    }

    public SocializeException(String str) {
        super(str);
        this.c = str;
    }

    public String getMessage() {
        return this.c;
    }
}
