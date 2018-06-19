package mtopsdk.mtop.a;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.a.a;
import mtopsdk.common.util.d;
import mtopsdk.common.util.e;
import mtopsdk.common.util.h;
import mtopsdk.common.util.i;
import mtopsdk.common.util.j;

public final class g {
    private static final g a = new g();
    private static final mtopsdk.common.util.g b = h.a;
    private static final d c = e.a;
    private static a d = null;
    private static long e = 10;
    private static Map f = new ConcurrentHashMap();

    private g() {
    }

    public static long a(String str) {
        if (i.b(str)) {
            return 0;
        }
        String str2 = (String) f.get(str);
        if (i.b(str2)) {
            return 0;
        }
        try {
            return Long.parseLong(str2);
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("[getIndividualApiLockInterval]parse individual apiLock interval error.apiKey=");
            stringBuilder.append(str);
            stringBuilder.append(" ---");
            stringBuilder.append(e.toString());
            j.e(stringBuilder.toString());
            return 0;
        }
    }

    public static g a() {
        return a;
    }

    public static void b() {
    }

    public static boolean c() {
        return c.c && b.c;
    }

    public static long d() {
        long j = b.d;
        e = j;
        return j;
    }

    public static boolean e() {
        return c.b && b.b;
    }
}
