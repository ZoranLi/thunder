package okhttp3.internal;

import com.xiaomi.mipush.sdk.Constants;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import okhttp3.ag;
import okhttp3.ak;
import okio.ByteString;

/* compiled from: Util */
public final class c {
    public static final byte[] a = new byte[0];
    public static final String[] b = new String[0];
    public static final ak c = ak.a(a);
    public static final ag d;
    public static final Charset e = Charset.forName("UTF-8");
    public static final TimeZone f = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> g = new d();
    private static final ByteString h = ByteString.decodeHex("efbbbf");
    private static final ByteString i = ByteString.decodeHex("feff");
    private static final ByteString j = ByteString.decodeHex("fffe");
    private static final ByteString k = ByteString.decodeHex("0000ffff");
    private static final ByteString l = ByteString.decodeHex("ffff0000");
    private static final Charset m = Charset.forName("UTF-16BE");
    private static final Charset n = Charset.forName("UTF-16LE");
    private static final Charset o = Charset.forName("UTF-32BE");
    private static final Charset p = Charset.forName("UTF-32LE");
    private static final Pattern q = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    static {
        byte[] bArr = a;
        d = ag.a(null, bArr, bArr.length);
    }

    public static void a(long j, long j2) {
        if ((0 | j2) >= 0 && 0 <= j) {
            if (j - 0 >= j2) {
                return;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    public static void a(java.io.Closeable r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0008;
    L_0x0002:
        r0.close();	 Catch:{ RuntimeException -> 0x0006, Exception -> 0x0008 }
        return;
    L_0x0006:
        r0 = move-exception;
        throw r0;
    L_0x0008:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.c.a(java.io.Closeable):void");
    }

    public static void a(java.net.Socket r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r1 == 0) goto L_0x0011;
    L_0x0002:
        r1.close();	 Catch:{ AssertionError -> 0x0008, RuntimeException -> 0x0006, Exception -> 0x0011 }
        return;
    L_0x0006:
        r1 = move-exception;
        throw r1;
    L_0x0008:
        r1 = move-exception;
        r0 = a(r1);
        if (r0 != 0) goto L_0x0010;
    L_0x000f:
        throw r1;
    L_0x0010:
        return;
    L_0x0011:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.c.a(java.net.Socket):void");
    }

    public static boolean a(okio.v r1, java.util.concurrent.TimeUnit r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 100;
        r1 = a(r1, r0, r2);	 Catch:{ IOException -> 0x0007 }
        return r1;
    L_0x0007:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.c.a(okio.v, java.util.concurrent.TimeUnit):boolean");
    }

    public static boolean a(okio.v r11, int r12, java.util.concurrent.TimeUnit r13) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.System.nanoTime();
        r2 = r11.a();
        r2 = r2.w_();
        r3 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        if (r2 == 0) goto L_0x001e;
    L_0x0013:
        r2 = r11.a();
        r5 = r2.c();
        r7 = r5 - r0;
        goto L_0x001f;
    L_0x001e:
        r7 = r3;
    L_0x001f:
        r2 = r11.a();
        r5 = (long) r12;
        r12 = r13.toNanos(r5);
        r12 = java.lang.Math.min(r7, r12);
        r5 = r0 + r12;
        r2.a(r5);
        r12 = new okio.e;	 Catch:{ InterruptedIOException -> 0x0074, all -> 0x005d }
        r12.<init>();	 Catch:{ InterruptedIOException -> 0x0074, all -> 0x005d }
    L_0x0036:
        r5 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;	 Catch:{ InterruptedIOException -> 0x0074, all -> 0x005d }
        r5 = r11.a(r12, r5);	 Catch:{ InterruptedIOException -> 0x0074, all -> 0x005d }
        r9 = -1;	 Catch:{ InterruptedIOException -> 0x0074, all -> 0x005d }
        r13 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1));	 Catch:{ InterruptedIOException -> 0x0074, all -> 0x005d }
        if (r13 == 0) goto L_0x0046;	 Catch:{ InterruptedIOException -> 0x0074, all -> 0x005d }
    L_0x0042:
        r12.n();	 Catch:{ InterruptedIOException -> 0x0074, all -> 0x005d }
        goto L_0x0036;
    L_0x0046:
        r12 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        if (r12 != 0) goto L_0x0052;
    L_0x004a:
        r11 = r11.a();
        r11.x_();
        goto L_0x005b;
    L_0x0052:
        r11 = r11.a();
        r12 = r0 + r7;
        r11.a(r12);
    L_0x005b:
        r11 = 1;
        return r11;
    L_0x005d:
        r12 = move-exception;
        r13 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        if (r13 != 0) goto L_0x006a;
    L_0x0062:
        r11 = r11.a();
        r11.x_();
        goto L_0x0073;
    L_0x006a:
        r11 = r11.a();
        r2 = r0 + r7;
        r11.a(r2);
    L_0x0073:
        throw r12;
    L_0x0074:
        r12 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        if (r12 != 0) goto L_0x0080;
    L_0x0078:
        r11 = r11.a();
        r11.x_();
        goto L_0x0089;
    L_0x0080:
        r11 = r11.a();
        r12 = r0 + r7;
        r11.a(r12);
    L_0x0089:
        r11 = 0;
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.c.a(okio.v, int, java.util.concurrent.TimeUnit):boolean");
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory a(String str, boolean z) {
        return new e(str, z);
    }

    public static String[] a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        List arrayList = new ArrayList();
        for (Object obj : strArr) {
            for (Object compare : strArr2) {
                if (comparator.compare(obj, compare) == 0) {
                    arrayList.add(obj);
                    break;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0)) {
            if (strArr2.length != 0) {
                for (Object obj : strArr) {
                    for (Object compare : strArr2) {
                        if (comparator.compare(obj, compare) == 0) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || assertionError.getMessage().contains("getsockname failed") == null) ? null : true;
    }

    public static int a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static String[] a(String[] strArr, String str) {
        Object obj = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, obj, 0, strArr.length);
        obj[obj.length - 1] = str;
        return obj;
    }

    public static int a(String str, int i, int i2) {
        while (i < i2) {
            switch (str.charAt(i)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i++;
                default:
                    return i;
            }
        }
        return i2;
    }

    public static int b(String str, int i, int i2) {
        i2--;
        while (i2 >= i) {
            switch (str.charAt(i2)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i2--;
                default:
                    return i2 + 1;
            }
        }
        return i;
    }

    public static String c(String str, int i, int i2) {
        i = a(str, i, i2);
        return str.substring(i, b(str, i, i2));
    }

    public static int a(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int a(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static java.lang.String a(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r6 = java.net.IDN.toASCII(r6);	 Catch:{ IllegalArgumentException -> 0x003a }
        r1 = java.util.Locale.US;	 Catch:{ IllegalArgumentException -> 0x003a }
        r6 = r6.toLowerCase(r1);	 Catch:{ IllegalArgumentException -> 0x003a }
        r1 = r6.isEmpty();	 Catch:{ IllegalArgumentException -> 0x003a }
        if (r1 == 0) goto L_0x0012;	 Catch:{ IllegalArgumentException -> 0x003a }
    L_0x0011:
        return r0;	 Catch:{ IllegalArgumentException -> 0x003a }
    L_0x0012:
        r1 = 0;	 Catch:{ IllegalArgumentException -> 0x003a }
        r2 = r1;	 Catch:{ IllegalArgumentException -> 0x003a }
    L_0x0014:
        r3 = r6.length();	 Catch:{ IllegalArgumentException -> 0x003a }
        r4 = 1;	 Catch:{ IllegalArgumentException -> 0x003a }
        if (r2 >= r3) goto L_0x0035;	 Catch:{ IllegalArgumentException -> 0x003a }
    L_0x001b:
        r3 = r6.charAt(r2);	 Catch:{ IllegalArgumentException -> 0x003a }
        r5 = 31;	 Catch:{ IllegalArgumentException -> 0x003a }
        if (r3 <= r5) goto L_0x0036;	 Catch:{ IllegalArgumentException -> 0x003a }
    L_0x0023:
        r5 = 127; // 0x7f float:1.78E-43 double:6.27E-322;	 Catch:{ IllegalArgumentException -> 0x003a }
        if (r3 < r5) goto L_0x0028;	 Catch:{ IllegalArgumentException -> 0x003a }
    L_0x0027:
        goto L_0x0036;	 Catch:{ IllegalArgumentException -> 0x003a }
    L_0x0028:
        r5 = " #%/:?@[\\]";	 Catch:{ IllegalArgumentException -> 0x003a }
        r3 = r5.indexOf(r3);	 Catch:{ IllegalArgumentException -> 0x003a }
        r5 = -1;
        if (r3 == r5) goto L_0x0032;
    L_0x0031:
        goto L_0x0036;
    L_0x0032:
        r2 = r2 + 1;
        goto L_0x0014;
    L_0x0035:
        r4 = r1;
    L_0x0036:
        if (r4 == 0) goto L_0x0039;
    L_0x0038:
        return r0;
    L_0x0039:
        return r6;
    L_0x003a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.c.a(java.lang.String):java.lang.String");
    }

    public static int b(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt > '\u001f') {
                if (charAt < '') {
                    i++;
                }
            }
            return i;
        }
        return -1;
    }

    public static boolean c(String str) {
        return q.matcher(str).matches();
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String a(HttpUrl httpUrl, boolean z) {
        String stringBuilder;
        if (httpUrl.b.contains(Constants.COLON_SEPARATOR)) {
            StringBuilder stringBuilder2 = new StringBuilder("[");
            stringBuilder2.append(httpUrl.b);
            stringBuilder2.append("]");
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = httpUrl.b;
        }
        if (!z) {
            if (httpUrl.c == HttpUrl.a(httpUrl.a)) {
                return stringBuilder;
            }
        }
        z = new StringBuilder();
        z.append(stringBuilder);
        z.append(Constants.COLON_SEPARATOR);
        z.append(httpUrl.c);
        return z.toString();
    }
}
