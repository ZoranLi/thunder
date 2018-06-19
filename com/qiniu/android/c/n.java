package com.qiniu.android.c;

import com.qiniu.android.http.l;

/* compiled from: ResumeUploader */
final class n implements l {
    final /* synthetic */ long a;
    final /* synthetic */ k b;

    n(k kVar, long j) {
        this.b = kVar;
        this.a = j;
    }

    public final void a(long j, long j2) {
        j = ((double) (this.a + j)) / ((double) j2);
        if (j > 4606732058837280358L) {
            j = 4606732058837280358L;
        }
        this.b.d.d.a(j);
    }
}
