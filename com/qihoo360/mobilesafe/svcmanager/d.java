package com.qihoo360.mobilesafe.svcmanager;

import android.content.Context;
import android.os.IBinder;
import com.qihoo360.mobilesafe.a.a;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

/* compiled from: PluginServiceReferenceManager */
class d {
    private static final boolean a;
    private static final String b;
    private static Context c;
    private static ArrayList<a> d = new ArrayList();
    private static ReferenceQueue<IBinder> e = new ReferenceQueue();
    private static Thread f;

    d() {
    }

    static {
        boolean z = a.a;
        a = z;
        b = z ? "PluginServiceReferenceManager" : d.class.getSimpleName();
    }

    static synchronized void a(Context context, String str, String str2, IBinder iBinder) {
        synchronized (d.class) {
            c = context.getApplicationContext();
            synchronized (d) {
                d.add(new a(str, str2, iBinder, e));
            }
            if (f == null) {
                g();
            }
        }
    }

    private static synchronized void g() {
        synchronized (d.class) {
            Thread eVar = new e();
            f = eVar;
            eVar.setPriority(5);
            f.start();
        }
    }
}
