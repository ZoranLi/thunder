package com.xunlei.download.proguard;

import com.xunlei.download.Downloads.Impl;

/* compiled from: StopRequestException */
public class p extends Exception {
    private final int a;

    public p(int i, String str) {
        super(str);
        this.a = i;
    }

    public p(int i, Throwable th) {
        super(th);
        this.a = i;
    }

    public p(int i, String str, Throwable th) {
        super(str, th);
        this.a = i;
    }

    public int getFinalStatus() {
        return this.a;
    }

    public static p throwUnhandledHttpError(int i, String str) throws p {
        StringBuilder stringBuilder = new StringBuilder("Unhandled HTTP response: ");
        stringBuilder.append(i);
        stringBuilder.append(" ");
        stringBuilder.append(str);
        str = stringBuilder.toString();
        if (i >= 400 && i < 600) {
            throw new p(i, str);
        } else if (i < 300 || i >= 400) {
            throw new p((int) Impl.STATUS_UNHANDLED_HTTP_CODE, str);
        } else {
            throw new p((int) Impl.STATUS_UNHANDLED_REDIRECT, str);
        }
    }
}
