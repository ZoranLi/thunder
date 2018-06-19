package com.xunlei.downloadprovider.personal.playrecord;

import android.text.TextUtils;

/* compiled from: PlayRecordDataManager */
final class z implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;
    final /* synthetic */ v d;

    z(v vVar, String str, String str2, boolean z) {
        this.d = vVar;
        this.a = str;
        this.b = str2;
        this.c = z;
    }

    public final void run() {
        VideoPlayRecord a = af.a(this.a);
        VideoPlayRecord a2 = TextUtils.isEmpty(this.b) ? null : af.a(v.b(this.b));
        if (a == null || (a.h < 500 && a2 != null)) {
            a = a2;
        }
        if (a != null && this.c) {
            synchronized (v.a(this.d)) {
                v.a(this.d).put(this.a, a);
            }
        }
        if (v.b(this.d) != null) {
            v.b(this.d).a(a);
        }
    }
}
