package com.xunlei.android.shortvideo.a;

import android.content.ContentValues;

/* compiled from: ShortVideoStat */
public final class c implements Runnable {
    final /* synthetic */ ContentValues a;
    final /* synthetic */ a b;

    public c(a aVar, ContentValues contentValues) {
        this.b = aVar;
        this.a = contentValues;
    }

    public final void run() {
        a.a(this.b, this.a);
        if (this.b.j) {
            a.b(this.b, this.a);
        }
    }
}
