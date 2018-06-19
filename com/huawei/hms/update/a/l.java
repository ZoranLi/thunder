package com.huawei.hms.update.a;

import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.update.a.a.b;
import com.huawei.hms.update.a.a.c;
import java.io.File;

/* compiled from: ThreadWrapper */
final class l implements b {
    final /* synthetic */ b a;

    l(b bVar) {
        this.a = bVar;
    }

    public final void a(int i, c cVar) {
        new Handler(Looper.getMainLooper()).post(new m(this, i, cVar));
    }

    public final void a(int i, int i2, int i3, File file) {
        new Handler(Looper.getMainLooper()).post(new n(this, i, i2, i3, file));
    }
}
