package com.qiniu.android.c;

import android.os.Looper;
import com.qiniu.android.d.a;

/* compiled from: UploadOptions */
final class aa implements i {
    final /* synthetic */ x a;

    aa(x xVar) {
        this.a = xVar;
    }

    public final void a() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            int i = 0;
            while (i < 6) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!a.a()) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
