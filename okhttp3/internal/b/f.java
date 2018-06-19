package okhttp3.internal.b;

import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import okhttp3.aj;
import okhttp3.o;
import okhttp3.p;
import okhttp3.y;

/* compiled from: HttpHeaders */
public final class f {
    private static final Pattern a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static long a(y yVar) {
        return a(yVar.a("Content-Length"));
    }

    private static long a(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = -1;
        if (r4 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = java.lang.Long.parseLong(r4);	 Catch:{ NumberFormatException -> 0x000a }
        return r2;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.b.f.a(java.lang.String):long");
    }

    public static void a(p pVar, HttpUrl httpUrl, y yVar) {
        if (pVar != p.a && o.a(httpUrl, yVar).isEmpty() == null) {
            pVar.a();
        }
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != '\t') {
                break;
            }
            i++;
        }
        return i;
    }

    public static int b(java.lang.String r3, int r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.Long.parseLong(r3);	 Catch:{ NumberFormatException -> 0x0019 }
        r3 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r2 <= 0) goto L_0x000f;
    L_0x000b:
        r3 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        return r3;
    L_0x000f:
        r3 = 0;
        r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r2 >= 0) goto L_0x0017;
    L_0x0015:
        r3 = 0;
        return r3;
    L_0x0017:
        r3 = (int) r0;
        return r3;
    L_0x0019:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.b.f.b(java.lang.String, int):int");
    }

    public static long a(aj ajVar) {
        return a(ajVar.f);
    }

    public static boolean b(aj ajVar) {
        if (ajVar.a.b.equals("HEAD")) {
            return false;
        }
        int i = ajVar.c;
        if (((i >= 100 && i < 200) || i == 204 || i == 304) && a(ajVar.f) == -1) {
            if ("chunked".equalsIgnoreCase(ajVar.a("Transfer-Encoding", null)) == null) {
                return false;
            }
        }
        return true;
    }
}
