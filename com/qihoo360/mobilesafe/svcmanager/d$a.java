package com.qihoo360.mobilesafe.svcmanager;

import android.os.IBinder;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/* compiled from: PluginServiceReferenceManager */
class d$a extends PhantomReference<IBinder> {
    final String a;
    final String b;

    public d$a(String str, String str2, IBinder iBinder, ReferenceQueue<? super IBinder> referenceQueue) {
        super(iBinder, referenceQueue);
        this.a = str;
        this.b = str2;
    }
}
