package com.xunlei.downloadprovider.ad.splash.downloader;

import com.tencent.tinker.android.dex.DebugInfoItem;

/* compiled from: DefaultRetryPolicy */
public final class a implements j {
    private int a;
    private int b;
    private final int c;
    private final float d;

    public a() {
        this((byte) 0);
    }

    private a(byte b) {
        this.a = (byte) -120;
        this.c = (byte) 1;
        this.d = DebugInfoItem.DBG_END_SEQUENCE;
    }

    public final int a() {
        return this.a;
    }

    public final void b() throws RetryError {
        int i = 1;
        this.b++;
        this.a = (int) (((float) this.a) + (((float) this.a) * this.d));
        if (this.b > this.c) {
            i = 0;
        }
        if (i == 0) {
            throw new RetryError();
        }
    }
}
