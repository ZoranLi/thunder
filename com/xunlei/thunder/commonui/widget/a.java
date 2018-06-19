package com.xunlei.thunder.commonui.widget;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* compiled from: RecycleBitmapDrawable */
public final class a extends BitmapDrawable implements b {
    private int a;
    private int b;
    private boolean c;

    public final void a(boolean z) {
        synchronized (this) {
            if (z) {
                this.b += true;
                this.c = true;
            } else {
                this.b -= true;
            }
            a();
        }
    }

    private synchronized void a() {
        if (this.a <= 0 && this.b <= 0 && this.c && b()) {
            getBitmap().recycle();
        }
    }

    private synchronized boolean b() {
        boolean z;
        Bitmap bitmap = getBitmap();
        z = (bitmap == null || bitmap.isRecycled()) ? false : true;
        return z;
    }
}
