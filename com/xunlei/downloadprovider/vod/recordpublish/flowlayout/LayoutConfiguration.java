package com.xunlei.downloadprovider.vod.recordpublish.flowlayout;

import android.content.Context;
import android.util.AttributeSet;
import com.xunlei.downloadprovider.R;

class LayoutConfiguration {
    int a = 0;
    boolean b = false;
    float c = 0.0f;
    int d = 51;
    int e = 0;
    int f = -1;
    int g;
    int h;

    public LayoutConfiguration(Context context, AttributeSet attributeSet) {
        context = context.obtainStyledAttributes(attributeSet, R.styleable.XlpsFlowLayout);
        try {
            a(context.getInteger(1, 0));
            this.b = context.getBoolean(3, false);
            a(context.getFloat(4, 0.0f));
            b(context.getInteger(0, 0));
            c(context.getInteger(2, 0));
            this.f = context.getInteger(5, -1);
            this.g = context.getDimensionPixelSize(6, 0);
            this.h = context.getDimensionPixelSize(7, 0);
        } finally {
            context.recycle();
        }
    }

    public final void a(int i) {
        if (i == 1) {
            this.a = i;
        } else {
            this.a = 0;
        }
    }

    public final void a(float f) {
        this.c = Math.max(0.0f, f);
    }

    public final void b(int i) {
        if ((i & 7) == 0) {
            i |= 3;
        }
        if ((i & 112) == 0) {
            i |= 48;
        }
        this.d = i;
    }

    public final void c(int i) {
        if (i == 1) {
            this.e = i;
        } else {
            this.e = 0;
        }
    }
}
