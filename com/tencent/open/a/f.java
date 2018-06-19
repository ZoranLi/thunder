package com.tencent.open.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.open.a.d.a;
import com.tencent.open.a.d.b;
import com.tencent.open.a.d.c;
import com.tencent.open.utils.d;
import java.io.File;

/* compiled from: ProGuard */
public class f {
    public static f a = null;
    protected static final b c = new b(c(), c.m, c.g, c.h, c.c, (long) c.i, 10, c.e, c.n);
    private static boolean d = false;
    protected a b = new a(c);

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                    d = true;
                }
            }
        }
        return a;
    }

    private f() {
    }

    protected void a(int i, String str, String str2, Throwable th) {
        if (d) {
            Object b = d.b();
            if (!TextUtils.isEmpty(b)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(b);
                stringBuilder.append(" SDK_VERSION:3.2.0.lite");
                String stringBuilder2 = stringBuilder.toString();
                if (this.b != null) {
                    String str3 = stringBuilder2;
                    e.a.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                    this.b.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                    d = false;
                } else {
                    return;
                }
            }
        }
        e.a.b(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (a.a(c.b, i) && this.b != null) {
            this.b.b(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        }
    }

    public static final void a(String str, String str2) {
        a().a(1, str, str2, null);
    }

    public static final void b(String str, String str2) {
        a().a(2, str, str2, null);
    }

    public static final void a(String str, String str2, Throwable th) {
        a().a(2, str, str2, th);
    }

    public static final void c(String str, String str2) {
        a().a(4, str, str2, null);
    }

    public static final void d(String str, String str2) {
        a().a(8, str, str2, null);
    }

    public static final void e(String str, String str2) {
        a().a(16, str, str2, null);
    }

    public static final void b(String str, String str2, Throwable th) {
        a().a(16, str, str2, th);
    }

    public static void b() {
        synchronized (f.class) {
            a().d();
            if (a != null) {
                a = null;
            }
        }
    }

    protected static File c() {
        String str = c.d;
        c b = b.b();
        Object obj = (b == null || b.c() <= c.f) ? null : 1;
        if (obj != null) {
            return new File(Environment.getExternalStorageDirectory(), str);
        }
        return new File(d.c(), str);
    }

    protected void d() {
        if (this.b != null) {
            this.b.a();
            this.b.b();
            this.b = null;
        }
    }
}
