package okhttp3;

import anet.channel.util.HttpConstant;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.c;
import okio.e;

public final class HttpUrl {
    private static final char[] e = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public final String a;
    public final String b;
    public final int c;
    @Nullable
    public final List<String> d;
    private final String f;
    private final String g;
    private final List<String> h;
    @Nullable
    private final String i;
    private final String j;

    public static final class Builder {
        @Nullable
        String a;
        String b = "";
        String c = "";
        @Nullable
        String d;
        int e = -1;
        final List<String> f = new ArrayList();
        @Nullable
        List<String> g;
        @Nullable
        String h;

        public Builder() {
            this.f.add("");
        }

        final int a() {
            return this.e != -1 ? this.e : HttpUrl.a(this.a);
        }

        public final Builder a(@Nullable String str) {
            if (str != null) {
                str = HttpUrl.b(HttpUrl.a(str, " \"'<>#", true, false, true, true));
            } else {
                str = null;
            }
            this.g = str;
            return this;
        }

        public final HttpUrl b() {
            if (this.a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.d != null) {
                return new HttpUrl(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(HttpConstant.SCHEME_SPLIT);
            if (!(this.b.isEmpty() && this.c.isEmpty())) {
                stringBuilder.append(this.b);
                if (!this.c.isEmpty()) {
                    stringBuilder.append(':');
                    stringBuilder.append(this.c);
                }
                stringBuilder.append('@');
            }
            if (this.d.indexOf(58) != -1) {
                stringBuilder.append('[');
                stringBuilder.append(this.d);
                stringBuilder.append(']');
            } else {
                stringBuilder.append(this.d);
            }
            int a = a();
            if (a != HttpUrl.a(this.a)) {
                stringBuilder.append(':');
                stringBuilder.append(a);
            }
            HttpUrl.a(stringBuilder, this.f);
            if (this.g != null) {
                stringBuilder.append('?');
                HttpUrl.b(stringBuilder, this.g);
            }
            if (this.h != null) {
                stringBuilder.append('#');
                stringBuilder.append(this.h);
            }
            return stringBuilder.toString();
        }

        final ParseResult a(@Nullable HttpUrl httpUrl, String str) {
            int i;
            char charAt;
            int i2;
            char c;
            char charAt2;
            char c2;
            int i3;
            int a;
            int i4;
            int a2;
            char charAt3;
            int i5;
            char c3;
            String a3;
            Builder builder = this;
            HttpUrl httpUrl2 = httpUrl;
            String str2 = str;
            int a4 = c.a(str2, 0, str.length());
            int b = c.b(str2, a4, str.length());
            char c4 = ':';
            if (b - a4 >= 2) {
                char charAt4 = str2.charAt(a4);
                if (charAt4 < 'a' || charAt4 > 'z') {
                    if (charAt4 >= 'A') {
                        if (charAt4 > 'Z') {
                        }
                    }
                }
                i = a4 + 1;
                while (i < b) {
                    charAt = str2.charAt(i);
                    if ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || ((charAt >= '0' && charAt <= '9') || charAt == '+' || charAt == '-' || charAt == '.'))) {
                        i++;
                    } else if (charAt == ':') {
                        if (i != -1) {
                            if (str2.regionMatches(true, a4, "https:", 0, 6)) {
                                if (str2.regionMatches(true, a4, "http:", 0, 5)) {
                                    return ParseResult.UNSUPPORTED_SCHEME;
                                }
                                builder.a = HttpConstant.HTTP;
                                a4 += 5;
                            } else {
                                builder.a = "https";
                                a4 += 6;
                            }
                        } else if (httpUrl2 != null) {
                            return ParseResult.MISSING_SCHEME;
                        } else {
                            builder.a = httpUrl2.a;
                        }
                        i2 = 0;
                        i = a4;
                        while (true) {
                            c = '/';
                            charAt = '\\';
                            if (i < b) {
                                break;
                            }
                            charAt2 = str2.charAt(i);
                            if (charAt2 == '\\' && charAt2 != '/') {
                                break;
                            }
                            i2++;
                            i++;
                        }
                        c2 = '#';
                        if (i2 < 2 && httpUrl2 != null) {
                            if (!httpUrl2.a.equals(builder.a)) {
                                builder.b = httpUrl.c();
                                builder.c = httpUrl.d();
                                builder.d = httpUrl2.b;
                                builder.e = httpUrl2.c;
                                builder.f.clear();
                                builder.f.addAll(httpUrl.f());
                                if (a4 == b || str2.charAt(a4) == '#') {
                                    a(httpUrl.g());
                                }
                                i3 = a4;
                                a = c.a(str2, i3, b, "?#");
                                b(str2, i3, a);
                                if (a < b && str2.charAt(a) == '?') {
                                    a4 = c.a(str2, a, b, '#');
                                    builder.g = HttpUrl.b(HttpUrl.a(str2, a + 1, a4, " \"'<>#", true, false, true, true));
                                    a = a4;
                                }
                                if (a < b && str2.charAt(a) == '#') {
                                    builder.h = HttpUrl.a(str2, a + 1, b, "", true, false, false, false);
                                }
                                return ParseResult.SUCCESS;
                            }
                        }
                        i4 = 0;
                        i = a4 + i2;
                        a4 = i4;
                        while (true) {
                            a2 = c.a(str2, i, b, "@/\\?#");
                            charAt3 = a2 == b ? str2.charAt(a2) : '￿';
                            if (!(charAt3 == '￿' || charAt3 == c2 || charAt3 == r15 || charAt3 == charAt)) {
                                switch (charAt3) {
                                    case '?':
                                        break;
                                    case '@':
                                        if (a4 != 0) {
                                            int a5 = c.a(str2, i, a2, c4);
                                            i5 = a5;
                                            c = c2;
                                            c3 = charAt;
                                            i3 = a2;
                                            a3 = HttpUrl.a(str2, i, a5, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                            if (i4 != 0) {
                                                StringBuilder stringBuilder = new StringBuilder();
                                                stringBuilder.append(builder.b);
                                                stringBuilder.append("%40");
                                                stringBuilder.append(a3);
                                                a3 = stringBuilder.toString();
                                            }
                                            builder.b = a3;
                                            if (i5 != i3) {
                                                builder.c = HttpUrl.a(str2, i5 + 1, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                                a4 = 1;
                                            }
                                            i4 = 1;
                                        } else {
                                            c3 = charAt;
                                            i3 = a2;
                                            StringBuilder stringBuilder2 = new StringBuilder();
                                            stringBuilder2.append(builder.c);
                                            stringBuilder2.append("%40");
                                            stringBuilder2.append(HttpUrl.a(str2, i, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true));
                                            builder.c = stringBuilder2.toString();
                                        }
                                        i = i3 + 1;
                                        charAt = c3;
                                        c2 = '#';
                                        c4 = ':';
                                        c = '/';
                                        continue;
                                        continue;
                                    default:
                                        continue;
                                        continue;
                                }
                            }
                            i3 = a2;
                            a = c(str2, i, i3);
                            i2 = a + 1;
                            if (i2 >= i3) {
                                builder.d = a(str2, i, a);
                                builder.e = e(str2, i2, i3);
                                if (builder.e == -1) {
                                    return ParseResult.INVALID_PORT;
                                }
                            }
                            builder.d = a(str2, i, a);
                            builder.e = HttpUrl.a(builder.a);
                            if (builder.d == null) {
                                return ParseResult.INVALID_HOST;
                            }
                            a = c.a(str2, i3, b, "?#");
                            b(str2, i3, a);
                            a4 = c.a(str2, a, b, '#');
                            builder.g = HttpUrl.b(HttpUrl.a(str2, a + 1, a4, " \"'<>#", true, false, true, true));
                            a = a4;
                            builder.h = HttpUrl.a(str2, a + 1, b, "", true, false, false, false);
                            return ParseResult.SUCCESS;
                        }
                    }
                }
            }
            i = -1;
            if (i != -1) {
                if (str2.regionMatches(true, a4, "https:", 0, 6)) {
                    if (str2.regionMatches(true, a4, "http:", 0, 5)) {
                        return ParseResult.UNSUPPORTED_SCHEME;
                    }
                    builder.a = HttpConstant.HTTP;
                    a4 += 5;
                } else {
                    builder.a = "https";
                    a4 += 6;
                }
            } else if (httpUrl2 != null) {
                return ParseResult.MISSING_SCHEME;
            } else {
                builder.a = httpUrl2.a;
            }
            i2 = 0;
            i = a4;
            while (true) {
                c = '/';
                charAt = '\\';
                if (i < b) {
                    break;
                }
                charAt2 = str2.charAt(i);
                if (charAt2 == '\\') {
                }
                i2++;
                i++;
            }
            c2 = '#';
            if (!httpUrl2.a.equals(builder.a)) {
                builder.b = httpUrl.c();
                builder.c = httpUrl.d();
                builder.d = httpUrl2.b;
                builder.e = httpUrl2.c;
                builder.f.clear();
                builder.f.addAll(httpUrl.f());
                a(httpUrl.g());
                i3 = a4;
                a = c.a(str2, i3, b, "?#");
                b(str2, i3, a);
                a4 = c.a(str2, a, b, '#');
                builder.g = HttpUrl.b(HttpUrl.a(str2, a + 1, a4, " \"'<>#", true, false, true, true));
                a = a4;
                builder.h = HttpUrl.a(str2, a + 1, b, "", true, false, false, false);
                return ParseResult.SUCCESS;
            }
            i4 = 0;
            i = a4 + i2;
            a4 = i4;
            while (true) {
                a2 = c.a(str2, i, b, "@/\\?#");
                if (a2 == b) {
                }
                switch (charAt3) {
                    case '?':
                        break;
                    case '@':
                        if (a4 != 0) {
                            c3 = charAt;
                            i3 = a2;
                            StringBuilder stringBuilder22 = new StringBuilder();
                            stringBuilder22.append(builder.c);
                            stringBuilder22.append("%40");
                            stringBuilder22.append(HttpUrl.a(str2, i, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true));
                            builder.c = stringBuilder22.toString();
                        } else {
                            int a52 = c.a(str2, i, a2, c4);
                            i5 = a52;
                            c = c2;
                            c3 = charAt;
                            i3 = a2;
                            a3 = HttpUrl.a(str2, i, a52, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            if (i4 != 0) {
                                StringBuilder stringBuilder3 = new StringBuilder();
                                stringBuilder3.append(builder.b);
                                stringBuilder3.append("%40");
                                stringBuilder3.append(a3);
                                a3 = stringBuilder3.toString();
                            }
                            builder.b = a3;
                            if (i5 != i3) {
                                builder.c = HttpUrl.a(str2, i5 + 1, i3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                a4 = 1;
                            }
                            i4 = 1;
                        }
                        i = i3 + 1;
                        charAt = c3;
                        c2 = '#';
                        c4 = ':';
                        c = '/';
                        continue;
                        continue;
                    default:
                        continue;
                        continue;
                }
                i3 = a2;
                a = c(str2, i, i3);
                i2 = a + 1;
                if (i2 >= i3) {
                    builder.d = a(str2, i, a);
                    builder.e = HttpUrl.a(builder.a);
                } else {
                    builder.d = a(str2, i, a);
                    builder.e = e(str2, i2, i3);
                    if (builder.e == -1) {
                        return ParseResult.INVALID_PORT;
                    }
                }
                if (builder.d == null) {
                    return ParseResult.INVALID_HOST;
                }
                a = c.a(str2, i3, b, "?#");
                b(str2, i3, a);
                a4 = c.a(str2, a, b, '#');
                builder.g = HttpUrl.b(HttpUrl.a(str2, a + 1, a4, " \"'<>#", true, false, true, true));
                a = a4;
                builder.h = HttpUrl.a(str2, a + 1, b, "", true, false, false, false);
                return ParseResult.SUCCESS;
            }
        }

        private void b(String str, int i, int i2) {
            if (i != i2) {
                int i3;
                int i4;
                int i5;
                String a;
                char charAt = str.charAt(i);
                if (charAt != '/') {
                    if (charAt != '\\') {
                        this.f.set(this.f.size() - 1, "");
                        while (true) {
                            i3 = i;
                            if (i3 < i2) {
                                i = c.a(str, i3, i2, "/\\");
                                i4 = 0;
                                i5 = i >= i2 ? 1 : 0;
                                a = HttpUrl.a(str, i3, i, " \"<>^`{}|/\\?#", true, false, false, true);
                                if (!a.equals(".")) {
                                    if (a.equalsIgnoreCase("%2e")) {
                                        i3 = 0;
                                        if (i3 == 0) {
                                            if (a.equals("..") || a.equalsIgnoreCase("%2e.") || a.equalsIgnoreCase(".%2e") || a.equalsIgnoreCase("%2e%2e")) {
                                                i4 = 1;
                                            }
                                            if (i4 != 0) {
                                                if (((String) this.f.get(this.f.size() - 1)).isEmpty()) {
                                                    this.f.add(a);
                                                } else {
                                                    this.f.set(this.f.size() - 1, a);
                                                }
                                                if (i5 != 0) {
                                                    this.f.add("");
                                                }
                                            } else if (((String) this.f.remove(this.f.size() - 1)).isEmpty() || this.f.isEmpty()) {
                                                this.f.add("");
                                            } else {
                                                this.f.set(this.f.size() - 1, "");
                                            }
                                        }
                                        if (i5 == 0) {
                                            i++;
                                        }
                                    }
                                }
                                i3 = 1;
                                if (i3 == 0) {
                                    i4 = 1;
                                    if (i4 != 0) {
                                        if (((String) this.f.get(this.f.size() - 1)).isEmpty()) {
                                            this.f.add(a);
                                        } else {
                                            this.f.set(this.f.size() - 1, a);
                                        }
                                        if (i5 != 0) {
                                            this.f.add("");
                                        }
                                    } else {
                                        if (((String) this.f.remove(this.f.size() - 1)).isEmpty()) {
                                        }
                                        this.f.add("");
                                    }
                                }
                                if (i5 == 0) {
                                    i++;
                                }
                            } else {
                                return;
                            }
                        }
                    }
                }
                this.f.clear();
                this.f.add("");
                i++;
                while (true) {
                    i3 = i;
                    if (i3 < i2) {
                        i = c.a(str, i3, i2, "/\\");
                        i4 = 0;
                        if (i >= i2) {
                        }
                        a = HttpUrl.a(str, i3, i, " \"<>^`{}|/\\?#", true, false, false, true);
                        if (a.equals(".")) {
                            if (a.equalsIgnoreCase("%2e")) {
                                i3 = 0;
                                if (i3 == 0) {
                                    i4 = 1;
                                    if (i4 != 0) {
                                        if (((String) this.f.remove(this.f.size() - 1)).isEmpty()) {
                                        }
                                        this.f.add("");
                                    } else {
                                        if (((String) this.f.get(this.f.size() - 1)).isEmpty()) {
                                            this.f.set(this.f.size() - 1, a);
                                        } else {
                                            this.f.add(a);
                                        }
                                        if (i5 != 0) {
                                            this.f.add("");
                                        }
                                    }
                                }
                                if (i5 == 0) {
                                    i++;
                                }
                            }
                        }
                        i3 = 1;
                        if (i3 == 0) {
                            i4 = 1;
                            if (i4 != 0) {
                                if (((String) this.f.get(this.f.size() - 1)).isEmpty()) {
                                    this.f.add(a);
                                } else {
                                    this.f.set(this.f.size() - 1, a);
                                }
                                if (i5 != 0) {
                                    this.f.add("");
                                }
                            } else {
                                if (((String) this.f.remove(this.f.size() - 1)).isEmpty()) {
                                }
                                this.f.add("");
                            }
                        }
                        if (i5 == 0) {
                            i++;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        private static int c(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        static String a(String str, int i, int i2) {
            int i3 = 0;
            str = HttpUrl.a(str, i, i2, false);
            if (str.contains(Constants.COLON_SEPARATOR) == 0) {
                return c.a(str);
            }
            if (str.startsWith("[") == 0 || str.endsWith("]") == 0) {
                str = d(str, 0, str.length());
            } else {
                str = d(str, 1, str.length() - 1);
            }
            if (str == null) {
                return null;
            }
            str = str.getAddress();
            if (str.length == 16) {
                int i4 = -1;
                i2 = 0;
                int i5 = i2;
                while (i2 < str.length) {
                    int i6 = i2;
                    while (i6 < 16 && str[i6] == (byte) 0 && str[i6 + 1] == (byte) 0) {
                        i6 += 2;
                    }
                    int i7 = i6 - i2;
                    if (i7 > i5 && i7 >= 4) {
                        i4 = i2;
                        i5 = i7;
                    }
                    i2 = i6 + 2;
                }
                i2 = new e();
                while (i3 < str.length) {
                    if (i3 == i4) {
                        i2.b(58);
                        i3 += i5;
                        if (i3 == 16) {
                            i2.b(58);
                        }
                    } else {
                        if (i3 > 0) {
                            i2.b(58);
                        }
                        i2.h((long) (((str[i3] & 255) << 8) | (str[i3 + 1] & 255)));
                        i3 += 2;
                    }
                }
                return i2.k();
            }
            throw new AssertionError();
        }

        @javax.annotation.Nullable
        private static java.net.InetAddress d(java.lang.String r17, int r18, int r19) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = r17;
            r1 = r19;
            r2 = 16;
            r3 = new byte[r2];
            r4 = -1;
            r5 = 0;
            r6 = r18;
            r8 = r4;
            r9 = r8;
            r7 = r5;
        L_0x000f:
            r10 = 0;
            if (r6 >= r1) goto L_0x00d7;
        L_0x0012:
            if (r7 != r2) goto L_0x0015;
        L_0x0014:
            return r10;
        L_0x0015:
            r11 = r6 + 2;
            r12 = 4;
            r13 = 255; // 0xff float:3.57E-43 double:1.26E-321;
            if (r11 > r1) goto L_0x0034;
        L_0x001c:
            r14 = "::";
            r15 = 2;
            r14 = r0.regionMatches(r6, r14, r5, r15);
            if (r14 == 0) goto L_0x0034;
        L_0x0025:
            if (r8 == r4) goto L_0x0028;
        L_0x0027:
            return r10;
        L_0x0028:
            r7 = r7 + 2;
            if (r11 != r1) goto L_0x0030;
        L_0x002c:
            r0 = r2;
            r8 = r7;
            goto L_0x00d8;
        L_0x0030:
            r8 = r7;
            r9 = r11;
            goto L_0x00a5;
        L_0x0034:
            if (r7 == 0) goto L_0x00a4;
        L_0x0036:
            r11 = ":";
            r14 = 1;
            r11 = r0.regionMatches(r6, r11, r5, r14);
            if (r11 == 0) goto L_0x0043;
        L_0x003f:
            r6 = r6 + 1;
            goto L_0x00a4;
        L_0x0043:
            r11 = ".";
            r6 = r0.regionMatches(r6, r11, r5, r14);
            if (r6 == 0) goto L_0x00a3;
        L_0x004b:
            r6 = r7 + -2;
            r11 = r6;
        L_0x004e:
            if (r9 >= r1) goto L_0x0095;
        L_0x0050:
            if (r11 != r2) goto L_0x0053;
        L_0x0052:
            goto L_0x009b;
        L_0x0053:
            if (r11 == r6) goto L_0x0060;
        L_0x0055:
            r15 = r0.charAt(r9);
            r14 = 46;
            if (r15 == r14) goto L_0x005e;
        L_0x005d:
            goto L_0x009b;
        L_0x005e:
            r9 = r9 + 1;
        L_0x0060:
            r15 = r5;
            r14 = r9;
        L_0x0062:
            if (r14 >= r1) goto L_0x0083;
        L_0x0064:
            r5 = r0.charAt(r14);
            r2 = 48;
            if (r5 < r2) goto L_0x0083;
        L_0x006c:
            r4 = 57;
            if (r5 > r4) goto L_0x0083;
        L_0x0070:
            if (r15 != 0) goto L_0x0075;
        L_0x0072:
            if (r9 == r14) goto L_0x0075;
        L_0x0074:
            goto L_0x0098;
        L_0x0075:
            r15 = r15 * 10;
            r15 = r15 + r5;
            r15 = r15 - r2;
            if (r15 <= r13) goto L_0x007c;
        L_0x007b:
            goto L_0x0098;
        L_0x007c:
            r14 = r14 + 1;
            r2 = 16;
            r4 = -1;
            r5 = 0;
            goto L_0x0062;
        L_0x0083:
            r2 = r14 - r9;
            if (r2 != 0) goto L_0x0088;
        L_0x0087:
            goto L_0x0098;
        L_0x0088:
            r2 = r11 + 1;
            r4 = (byte) r15;
            r3[r11] = r4;
            r11 = r2;
            r9 = r14;
            r2 = 16;
            r4 = -1;
            r5 = 0;
            r14 = 1;
            goto L_0x004e;
        L_0x0095:
            r6 = r6 + r12;
            if (r11 == r6) goto L_0x009a;
        L_0x0098:
            r5 = 0;
            goto L_0x009b;
        L_0x009a:
            r5 = 1;
        L_0x009b:
            if (r5 != 0) goto L_0x009e;
        L_0x009d:
            return r10;
        L_0x009e:
            r7 = r7 + 2;
            r0 = 16;
            goto L_0x00d8;
        L_0x00a3:
            return r10;
        L_0x00a4:
            r9 = r6;
        L_0x00a5:
            r6 = r9;
            r2 = 0;
        L_0x00a7:
            if (r6 >= r1) goto L_0x00ba;
        L_0x00a9:
            r4 = r0.charAt(r6);
            r4 = okhttp3.HttpUrl.a(r4);
            r5 = -1;
            if (r4 == r5) goto L_0x00ba;
        L_0x00b4:
            r2 = r2 << 4;
            r2 = r2 + r4;
            r6 = r6 + 1;
            goto L_0x00a7;
        L_0x00ba:
            r4 = r6 - r9;
            if (r4 == 0) goto L_0x00d6;
        L_0x00be:
            if (r4 <= r12) goto L_0x00c1;
        L_0x00c0:
            goto L_0x00d6;
        L_0x00c1:
            r4 = r7 + 1;
            r5 = r2 >>> 8;
            r5 = r5 & r13;
            r5 = (byte) r5;
            r3[r7] = r5;
            r7 = r4 + 1;
            r2 = r2 & 255;
            r2 = (byte) r2;
            r3[r4] = r2;
            r2 = 16;
            r4 = -1;
            r5 = 0;
            goto L_0x000f;
        L_0x00d6:
            return r10;
        L_0x00d7:
            r0 = r2;
        L_0x00d8:
            if (r7 == r0) goto L_0x00ec;
        L_0x00da:
            r1 = -1;
            if (r8 != r1) goto L_0x00de;
        L_0x00dd:
            return r10;
        L_0x00de:
            r1 = r7 - r8;
            r2 = 16 - r1;
            java.lang.System.arraycopy(r3, r8, r3, r2, r1);
            r2 = 16 - r7;
            r2 = r2 + r8;
            r0 = 0;
            java.util.Arrays.fill(r3, r8, r2, r0);
        L_0x00ec:
            r0 = java.net.InetAddress.getByAddress(r3);	 Catch:{ UnknownHostException -> 0x00f1 }
            return r0;
        L_0x00f1:
            r0 = new java.lang.AssertionError;
            r0.<init>();
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.d(java.lang.String, int, int):java.net.InetAddress");
        }

        private static int e(java.lang.String r9, int r10, int r11) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = -1;
            r4 = "";	 Catch:{ NumberFormatException -> 0x001b }
            r5 = 0;	 Catch:{ NumberFormatException -> 0x001b }
            r6 = 0;	 Catch:{ NumberFormatException -> 0x001b }
            r7 = 0;	 Catch:{ NumberFormatException -> 0x001b }
            r8 = 1;	 Catch:{ NumberFormatException -> 0x001b }
            r1 = r9;	 Catch:{ NumberFormatException -> 0x001b }
            r2 = r10;	 Catch:{ NumberFormatException -> 0x001b }
            r3 = r11;	 Catch:{ NumberFormatException -> 0x001b }
            r9 = okhttp3.HttpUrl.a(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ NumberFormatException -> 0x001b }
            r9 = java.lang.Integer.parseInt(r9);	 Catch:{ NumberFormatException -> 0x001b }
            if (r9 <= 0) goto L_0x001a;
        L_0x0014:
            r10 = 65535; // 0xffff float:9.1834E-41 double:3.23786E-319;
            if (r9 > r10) goto L_0x001a;
        L_0x0019:
            return r9;
        L_0x001a:
            return r0;
        L_0x001b:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.e(java.lang.String, int, int):int");
        }
    }

    static int a(char c) {
        return (c < '0' || c > '9') ? (c < 'a' || c > 'f') ? (c < 'A' || c > 'F') ? -1 : (c - 65) + 10 : (c - 97) + 10 : c - 48;
    }

    HttpUrl(Builder builder) {
        this.a = builder.a;
        this.f = a(builder.b, false);
        this.g = a(builder.c, false);
        this.b = builder.d;
        this.c = builder.a();
        this.h = a(builder.f, false);
        String str = null;
        this.d = builder.g != null ? a(builder.g, true) : null;
        if (builder.h != null) {
            str = a(builder.h, false);
        }
        this.i = str;
        this.j = builder.toString();
    }

    public final boolean b() {
        return this.a.equals("https");
    }

    public final String c() {
        if (this.f.isEmpty()) {
            return "";
        }
        int length = this.a.length() + 3;
        return this.j.substring(length, c.a(this.j, length, this.j.length(), ":@"));
    }

    public final String d() {
        if (this.g.isEmpty()) {
            return "";
        }
        return this.j.substring(this.j.indexOf(58, this.a.length() + 3) + 1, this.j.indexOf(64));
    }

    public static int a(String str) {
        if (str.equals(HttpConstant.HTTP)) {
            return 80;
        }
        return str.equals("https") != null ? com.taobao.accs.common.Constants.PORT : -1;
    }

    public final String e() {
        int indexOf = this.j.indexOf(47, this.a.length() + 3);
        return this.j.substring(indexOf, c.a(this.j, indexOf, this.j.length(), "?#"));
    }

    static void a(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append('/');
            stringBuilder.append((String) list.get(i));
        }
    }

    public final List<String> f() {
        int indexOf = this.j.indexOf(47, this.a.length() + 3);
        int a = c.a(this.j, indexOf, this.j.length(), "?#");
        List<String> arrayList = new ArrayList();
        while (indexOf < a) {
            indexOf++;
            int a2 = c.a(this.j, indexOf, a, '/');
            arrayList.add(this.j.substring(indexOf, a2));
            indexOf = a2;
        }
        return arrayList;
    }

    @Nullable
    public final String g() {
        if (this.d == null) {
            return null;
        }
        int indexOf = this.j.indexOf(63) + 1;
        return this.j.substring(indexOf, c.a(this.j, indexOf + 1, this.j.length(), '#'));
    }

    public static void b(StringBuilder stringBuilder, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = (String) list.get(i);
            String str2 = (String) list.get(i + 1);
            if (i > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(str);
            if (str2 != null) {
                stringBuilder.append('=');
                stringBuilder.append(str2);
            }
        }
    }

    static List<String> b(String str) {
        List<String> arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 != -1) {
                if (indexOf2 <= indexOf) {
                    arrayList.add(str.substring(i, indexOf2));
                    arrayList.add(str.substring(indexOf2 + 1, indexOf));
                    i = indexOf + 1;
                }
            }
            arrayList.add(str.substring(i, indexOf));
            arrayList.add(null);
            i = indexOf + 1;
        }
        return arrayList;
    }

    @Nullable
    public final Builder c(String str) {
        Builder builder = new Builder();
        return builder.a(this, str) == ParseResult.SUCCESS ? builder : null;
    }

    @Nullable
    public static HttpUrl d(String str) {
        Builder builder = new Builder();
        if (builder.a(null, str) == ParseResult.SUCCESS) {
            return builder.b();
        }
        return null;
    }

    public final boolean equals(@Nullable Object obj) {
        return (!(obj instanceof HttpUrl) || ((HttpUrl) obj).j.equals(this.j) == null) ? null : true;
    }

    public final int hashCode() {
        return this.j.hashCode();
    }

    public final String toString() {
        return this.j;
    }

    private static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private static List<String> a(List<String> list, boolean z) {
        int size = list.size();
        List arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = (String) list.get(i);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String a(String str, int i, int i2, boolean z) {
        int i3 = i;
        while (i3 < i2) {
            char charAt = str.charAt(i3);
            if (charAt != '%') {
                if (charAt != '+' || !z) {
                    i3++;
                }
            }
            e eVar = new e();
            eVar.a(str, i, i3);
            while (i3 < i2) {
                i = str.codePointAt(i3);
                if (i == 37) {
                    int i4 = i3 + 2;
                    if (i4 < i2) {
                        int a = a(str.charAt(i3 + 1));
                        int a2 = a(str.charAt(i4));
                        if (!(a == -1 || a2 == -1)) {
                            eVar.b((a << 4) + a2);
                            i3 = i4;
                            i3 += Character.charCount(i);
                        }
                        eVar.a(i);
                        i3 += Character.charCount(i);
                    }
                }
                if (i == 43 && z) {
                    eVar.b(32);
                    i3 += Character.charCount(i);
                }
                eVar.a(i);
                i3 += Character.charCount(i);
            }
            return eVar.k();
        }
        return str.substring(i, i2);
    }

    private static boolean a(String str, int i, int i2) {
        int i3 = i + 2;
        if (i3 >= i2 || str.charAt(i) != 37 || a(str.charAt(i + 1)) == -1 || a(str.charAt(i3)) == -1) {
            return null;
        }
        return true;
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        String str3 = str;
        int i3 = i2;
        String str4 = str2;
        int i4 = i;
        while (i4 < i3) {
            int codePointAt = str3.codePointAt(i4);
            int i5 = 43;
            if (codePointAt >= 32 && codePointAt != Opcodes.NEG_FLOAT && ((codePointAt < 128 || !z4) && str4.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || a(str3, i4, i3)))))) {
                if (codePointAt != 43 || !z3) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            e eVar = new e();
            eVar.a(str3, i, i4);
            e eVar2 = null;
            while (i4 < i3) {
                int codePointAt2 = str3.codePointAt(i4);
                if (z) {
                    if (!(codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13)) {
                    }
                    i4 += Character.charCount(codePointAt2);
                    i5 = 43;
                }
                if (codePointAt2 == i5 && z3) {
                    eVar.a(z ? "+" : "%2B");
                    i4 += Character.charCount(codePointAt2);
                    i5 = 43;
                } else {
                    if (codePointAt2 >= 32 && codePointAt2 != Opcodes.NEG_FLOAT && (codePointAt2 < 128 || !z4)) {
                        if (str4.indexOf(codePointAt2) == -1) {
                            if (codePointAt2 == 37) {
                                if (z) {
                                    if (z2 && !a(str3, i4, i3)) {
                                    }
                                }
                            }
                            eVar.a(codePointAt2);
                            i4 += Character.charCount(codePointAt2);
                            i5 = 43;
                        }
                    }
                    if (eVar2 == null) {
                        eVar2 = new e();
                    }
                    eVar2.a(codePointAt2);
                    while (!eVar2.c()) {
                        int d = eVar2.d() & 255;
                        eVar.b(37);
                        eVar.b(e[(d >> 4) & 15]);
                        eVar.b(e[d & 15]);
                    }
                    i4 += Character.charCount(codePointAt2);
                    i5 = 43;
                }
            }
            return eVar.k();
        }
        int i6 = i;
        return str.substring(i, i2);
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4);
    }

    public final java.net.URI a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = new okhttp3.HttpUrl$Builder;
        r0.<init>();
        r1 = r11.a;
        r0.a = r1;
        r1 = r11.c();
        r0.b = r1;
        r1 = r11.d();
        r0.c = r1;
        r1 = r11.b;
        r0.d = r1;
        r1 = r11.c;
        r2 = r11.a;
        r2 = a(r2);
        if (r1 == r2) goto L_0x0026;
    L_0x0023:
        r1 = r11.c;
        goto L_0x0027;
    L_0x0026:
        r1 = -1;
    L_0x0027:
        r0.e = r1;
        r1 = r0.f;
        r1.clear();
        r1 = r0.f;
        r2 = r11.f();
        r1.addAll(r2);
        r1 = r11.g();
        r0.a(r1);
        r1 = r11.i;
        if (r1 != 0) goto L_0x0044;
    L_0x0042:
        r1 = 0;
        goto L_0x0054;
    L_0x0044:
        r1 = r11.j;
        r2 = 35;
        r1 = r1.indexOf(r2);
        r1 = r1 + 1;
        r2 = r11.j;
        r1 = r2.substring(r1);
    L_0x0054:
        r0.h = r1;
        r1 = r0.f;
        r1 = r1.size();
        r2 = 0;
        r3 = r2;
    L_0x005e:
        if (r3 >= r1) goto L_0x007b;
    L_0x0060:
        r4 = r0.f;
        r4 = r4.get(r3);
        r5 = r4;
        r5 = (java.lang.String) r5;
        r4 = r0.f;
        r6 = "[]";
        r7 = 1;
        r8 = 1;
        r9 = 0;
        r10 = 1;
        r5 = a(r5, r6, r7, r8, r9, r10);
        r4.set(r3, r5);
        r3 = r3 + 1;
        goto L_0x005e;
    L_0x007b:
        r1 = r0.g;
        if (r1 == 0) goto L_0x00a4;
    L_0x007f:
        r1 = r0.g;
        r1 = r1.size();
    L_0x0085:
        if (r2 >= r1) goto L_0x00a4;
    L_0x0087:
        r3 = r0.g;
        r3 = r3.get(r2);
        r4 = r3;
        r4 = (java.lang.String) r4;
        if (r4 == 0) goto L_0x00a1;
    L_0x0092:
        r3 = r0.g;
        r5 = "\\^`{|}";
        r6 = 1;
        r7 = 1;
        r8 = 1;
        r9 = 1;
        r4 = a(r4, r5, r6, r7, r8, r9);
        r3.set(r2, r4);
    L_0x00a1:
        r2 = r2 + 1;
        goto L_0x0085;
    L_0x00a4:
        r1 = r0.h;
        if (r1 == 0) goto L_0x00b6;
    L_0x00a8:
        r2 = r0.h;
        r3 = " \"#<>\\^`{|}";
        r4 = 1;
        r5 = 1;
        r6 = 0;
        r7 = 0;
        r1 = a(r2, r3, r4, r5, r6, r7);
        r0.h = r1;
    L_0x00b6:
        r0 = r0.toString();
        r1 = new java.net.URI;	 Catch:{ URISyntaxException -> 0x00c0 }
        r1.<init>(r0);	 Catch:{ URISyntaxException -> 0x00c0 }
        return r1;
    L_0x00c0:
        r1 = move-exception;
        r2 = "[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]";	 Catch:{ Exception -> 0x00ce }
        r3 = "";	 Catch:{ Exception -> 0x00ce }
        r0 = r0.replaceAll(r2, r3);	 Catch:{ Exception -> 0x00ce }
        r0 = java.net.URI.create(r0);	 Catch:{ Exception -> 0x00ce }
        return r0;
    L_0x00ce:
        r0 = new java.lang.RuntimeException;
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.a():java.net.URI");
    }
}
