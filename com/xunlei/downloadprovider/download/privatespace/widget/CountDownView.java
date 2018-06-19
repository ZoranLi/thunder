package com.xunlei.downloadprovider.download.privatespace.widget;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.view.InputDeviceCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class CountDownView extends AppCompatTextView {
    public int a;
    public int b;
    public int c;
    public CountDownTimer d;
    private a e;

    public interface a {
        void a();

        void a(long j);
    }

    public CountDownView(Context context) {
        this(context, null, 0);
    }

    public CountDownView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CountDownView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = InputDeviceCompat.SOURCE_KEYBOARD;
        this.b = 1;
    }

    public boolean performClick() {
        if (this.a != InputDeviceCompat.SOURCE_KEYBOARD) {
            return false;
        }
        return super.performClick();
    }

    public final void a() {
        this.a = InputDeviceCompat.SOURCE_KEYBOARD;
        if (this.d != null) {
            this.d.cancel();
        }
    }

    public void setMaxCountDown(int i) {
        if (i > 0) {
            this.c = i;
        }
    }

    public void setCountDownInterval(int i) {
        if (i > 0) {
            this.b = i;
        }
    }

    protected void onDetachedFromWindow() {
        a();
        if (this.e != null) {
            this.e = null;
        }
        super.onDetachedFromWindow();
    }

    public void setICountDownCallback(a aVar) {
        this.e = aVar;
    }
}
