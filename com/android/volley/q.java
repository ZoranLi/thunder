package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: VolleyLog */
public class q {
    public static String a = "Volley";
    public static boolean b = Log.isLoggable("Volley", 2);

    /* compiled from: VolleyLog */
    static class a {
        public static final boolean a = q.b;
        private final List<a> b = new ArrayList();
        private boolean c = false;

        /* compiled from: VolleyLog */
        private static class a {
            public final String a;
            public final long b;
            public final long c;

            public a(String str, long j, long j2) {
                this.a = str;
                this.b = j;
                this.c = j2;
            }
        }

        a() {
        }

        public final synchronized void a(String str, long j) {
            if (this.c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.b.add(new a(str, j, SystemClock.elapsedRealtime()));
        }

        public final synchronized void a(String str) {
            long j;
            this.c = true;
            if (this.b.size() == 0) {
                j = 0;
            } else {
                j = ((a) this.b.get(this.b.size() - 1)).c - ((a) this.b.get(0)).c;
            }
            if (j > 0) {
                long j2 = ((a) this.b.get(0)).c;
                q.b("(%-4d ms) %s", Long.valueOf(j), str);
                for (a aVar : this.b) {
                    q.b("(+%-4d) [%2d] %s", Long.valueOf(aVar.c - j2), Long.valueOf(aVar.b), aVar.a);
                    j2 = aVar.c;
                }
            }
        }

        protected final void finalize() throws Throwable {
            if (!this.c) {
                a("Request on the loose");
                q.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    public static void a(String str, Object... objArr) {
        if (b) {
            f(str, objArr);
        }
    }

    public static void b(String str, Object... objArr) {
        f(str, objArr);
    }

    public static void c(String str, Object... objArr) {
        f(str, objArr);
    }

    public static void d(String str, Object... objArr) {
        f(str, objArr);
    }

    public static void e(String str, Object... objArr) {
        Log.wtf(a, f(str, objArr));
    }

    private static String f(String str, Object... objArr) {
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        objArr = new Throwable().fillInStackTrace().getStackTrace();
        String str2 = "<unknown>";
        for (int i = 2; i < objArr.length; i++) {
            if (!objArr[i].getClass().equals(q.class)) {
                str2 = objArr[i].getClassName();
                str2 = str2.substring(str2.lastIndexOf(46) + 1);
                str2 = str2.substring(str2.lastIndexOf(36) + 1);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str2);
                stringBuilder.append(".");
                stringBuilder.append(objArr[i].getMethodName());
                str2 = stringBuilder.toString();
                break;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
