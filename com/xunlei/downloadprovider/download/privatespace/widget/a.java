package com.xunlei.downloadprovider.download.privatespace.widget;

import android.os.CountDownTimer;
import android.support.v4.view.InputDeviceCompat;

/* compiled from: CountDownView */
public final class a extends CountDownTimer {
    final /* synthetic */ CountDownView a;

    public a(CountDownView countDownView, long j, long j2) {
        this.a = countDownView;
        super(j, j2);
    }

    public final void onTick(long j) {
        if (this.a.e != null) {
            this.a.e.a(j / 1000);
        }
    }

    public final void onFinish() {
        this.a.a = InputDeviceCompat.SOURCE_KEYBOARD;
        if (this.a.e != null) {
            this.a.e.a();
        }
    }
}
