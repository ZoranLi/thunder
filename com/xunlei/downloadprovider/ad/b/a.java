package com.xunlei.downloadprovider.ad.b;

import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: RedPointCtr */
public final class a {
    public static a d;
    public WeakReference<View> a;
    public WeakReference<View> b;
    public WeakReference<View> c;

    private a() {
    }

    public static a a() {
        if (d == null) {
            d = new a();
        }
        return d;
    }

    public static void a(WeakReference<View> weakReference) {
        if (weakReference != null && weakReference.get() != null) {
            ((View) weakReference.get()).setVisibility(8);
        }
    }
}
