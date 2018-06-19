package com.qihoo360.mobilesafe.svcmanager;

import android.database.MatrixCursor;
import android.os.IBinder;
import com.qihoo360.mobilesafe.svcmanager.a.a;
import com.qihoo360.replugin.IBinderGetter;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ServiceChannelImpl */
class g {
    static a a;
    static MatrixCursor b;
    private static final boolean c;
    private static final String d;
    private static ConcurrentHashMap<String, IBinder> e = new ConcurrentHashMap();
    private static ConcurrentHashMap<String, IBinderGetter> f = new ConcurrentHashMap();

    g() {
    }

    static {
        boolean z = com.qihoo360.mobilesafe.a.a.a;
        c = z;
        d = z ? "ServiceChannelImpl" : g.class.getSimpleName();
        IBinder hVar = new h();
        a = hVar;
        b = f.a(hVar);
    }
}
