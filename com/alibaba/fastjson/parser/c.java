package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.c.e;
import com.xiaomi.push.service.av;
import java.io.Closeable;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: JSONLexerBase */
public abstract class c implements b, Closeable {
    protected static final char[] p;
    protected static final int[] q = new int[103];
    private static final ThreadLocal<SoftReference<char[]>> s = new ThreadLocal();
    protected int a;
    protected int b;
    protected int c;
    protected char d;
    protected int e;
    protected int f;
    protected char[] g;
    protected int h;
    protected int i;
    protected boolean j;
    protected Calendar k = null;
    protected TimeZone l = a.defaultTimeZone;
    protected Locale m = a.defaultLocale;
    public int n = 0;
    protected String o = null;
    private final SoftReference<char[]> r;

    private static boolean e(char c) {
        return c <= ' ' && (c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b');
    }

    public abstract boolean B();

    public abstract String a(int i, int i2);

    public abstract String a(int i, int i2, int i3, h hVar);

    protected abstract void a(int i, int i2, char[] cArr);

    protected abstract void a(int i, char[] cArr, int i2);

    public abstract char b(int i);

    public abstract int c(int i);

    public abstract char f();

    protected abstract boolean h(char[] cArr);

    public abstract String l();

    public abstract String u();

    public String z() {
        return "";
    }

    static {
        int i;
        StringBuilder stringBuilder = new StringBuilder("\"");
        stringBuilder.append(a.DEFAULT_TYPE_KEY);
        stringBuilder.append("\":\"");
        p = stringBuilder.toString().toCharArray();
        for (i = 48; i <= 57; i++) {
            q[i] = i - 48;
        }
        for (i = 97; i <= 102; i++) {
            q[i] = (i - 97) + 10;
        }
        for (i = 65; i <= 70; i++) {
            q[i] = (i - 65) + 10;
        }
    }

    public c(int i) {
        this.c = i;
        if ((i & Feature.InitStringFieldAsEmpty.mask) != 0) {
            this.o = "";
        }
        this.r = (SoftReference) s.get();
        if (this.r != 0) {
            this.g = (char[]) this.r.get();
            s.set(null);
        }
        if (this.g == 0) {
            this.g = new char[256];
        }
    }

    public final void d() {
        this.h = 0;
        while (true) {
            r0.b = r0.e;
            if (r0.d == '/') {
                E();
            } else if (r0.d == '\"') {
                m();
                return;
            } else if (r0.d == ',') {
                f();
                r0.a = 16;
                return;
            } else if (r0.d < '0' || r0.d > '9') {
                if (r0.d != '-') {
                    switch (r0.d) {
                        case '\b':
                        case '\t':
                        case '\n':
                        case '\f':
                        case '\r':
                        case ' ':
                            f();
                            break;
                        case '\'':
                            if (a(Feature.AllowSingleQuotes)) {
                                r0.i = r0.e;
                                r0.j = false;
                                while (true) {
                                    char f = f();
                                    if (f == '\'') {
                                        r0.a = 4;
                                        f();
                                        return;
                                    } else if (f == '\u001a') {
                                        if (B()) {
                                            throw new JSONException("unclosed single-quote string");
                                        }
                                        d('\u001a');
                                    } else if (f == '\\') {
                                        if (!r0.j) {
                                            r0.j = true;
                                            if (r0.h > r0.g.length) {
                                                Object obj = new char[(r0.h * 2)];
                                                System.arraycopy(r0.g, 0, obj, 0, r0.g.length);
                                                r0.g = obj;
                                            }
                                            a(r0.i + 1, r0.h, r0.g);
                                        }
                                        f = f();
                                        switch (f) {
                                            case '/':
                                                d('/');
                                                break;
                                            case '0':
                                                d('\u0000');
                                                break;
                                            case '1':
                                                d('\u0001');
                                                break;
                                            case '2':
                                                d('\u0002');
                                                break;
                                            case '3':
                                                d('\u0003');
                                                break;
                                            case '4':
                                                d('\u0004');
                                                break;
                                            case '5':
                                                d('\u0005');
                                                break;
                                            case '6':
                                                d('\u0006');
                                                break;
                                            case '7':
                                                d('\u0007');
                                                break;
                                            default:
                                                switch (f) {
                                                    case 't':
                                                        d('\t');
                                                        break;
                                                    case 'u':
                                                        d((char) Integer.parseInt(new String(new char[]{f(), f(), f(), f()}), 16));
                                                        break;
                                                    case 'v':
                                                        d('\u000b');
                                                        break;
                                                    default:
                                                        switch (f) {
                                                            case '\"':
                                                                d('\"');
                                                                break;
                                                            case '\'':
                                                                d('\'');
                                                                break;
                                                            case 'F':
                                                            case 'f':
                                                                d('\f');
                                                                break;
                                                            case '\\':
                                                                d('\\');
                                                                break;
                                                            case 'b':
                                                                d('\b');
                                                                break;
                                                            case 'n':
                                                                d('\n');
                                                                break;
                                                            case 'r':
                                                                d('\r');
                                                                break;
                                                            case 'x':
                                                                d((char) ((q[f()] * 16) + q[f()]));
                                                                break;
                                                            default:
                                                                r0.d = f;
                                                                throw new JSONException("unclosed single-quote string");
                                                        }
                                                }
                                        }
                                    } else if (!r0.j) {
                                        r0.h++;
                                    } else if (r0.h == r0.g.length) {
                                        d(f);
                                    } else {
                                        char[] cArr = r0.g;
                                        int i = r0.h;
                                        r0.h = i + 1;
                                        cArr[i] = f;
                                    }
                                }
                            } else {
                                throw new JSONException("Feature.AllowSingleQuotes is false");
                            }
                        case '(':
                            f();
                            r0.a = 10;
                            return;
                        case ')':
                            f();
                            r0.a = 11;
                            return;
                        case ':':
                            f();
                            r0.a = 17;
                            return;
                        case 'N':
                            if (r0.d != 'N') {
                                throw new JSONException("error parse NULL");
                            }
                            f();
                            if (r0.d != 'U') {
                                throw new JSONException("error parse NULL");
                            }
                            f();
                            if (r0.d != 'L') {
                                throw new JSONException("error parse NULL");
                            }
                            f();
                            if (r0.d != 'L') {
                                throw new JSONException("error parse NULL");
                            }
                            f();
                            if (!(r0.d == ' ' || r0.d == ',' || r0.d == '}' || r0.d == ']' || r0.d == '\n' || r0.d == '\r' || r0.d == '\t' || r0.d == '\u001a' || r0.d == '\f')) {
                                if (r0.d != '\b') {
                                    throw new JSONException("scan NULL error");
                                }
                            }
                            r0.a = 8;
                            return;
                        case 'S':
                            if (r0.d != 'S') {
                                throw new JSONException("error parse set");
                            }
                            f();
                            if (r0.d != 'e') {
                                throw new JSONException("error parse set");
                            }
                            f();
                            if (r0.d != 't') {
                                throw new JSONException("error parse set");
                            }
                            f();
                            if (!(r0.d == ' ' || r0.d == '\n' || r0.d == '\r' || r0.d == '\t' || r0.d == '\f' || r0.d == '\b' || r0.d == '[')) {
                                if (r0.d != '(') {
                                    throw new JSONException("scan set error");
                                }
                            }
                            r0.a = 21;
                            return;
                        case 'T':
                            if (r0.d != 'T') {
                                throw new JSONException("error parse treeSet");
                            }
                            f();
                            if (r0.d != 'r') {
                                throw new JSONException("error parse treeSet");
                            }
                            f();
                            if (r0.d != 'e') {
                                throw new JSONException("error parse treeSet");
                            }
                            f();
                            if (r0.d != 'e') {
                                throw new JSONException("error parse treeSet");
                            }
                            f();
                            if (r0.d != 'S') {
                                throw new JSONException("error parse treeSet");
                            }
                            f();
                            if (r0.d != 'e') {
                                throw new JSONException("error parse treeSet");
                            }
                            f();
                            if (r0.d != 't') {
                                throw new JSONException("error parse treeSet");
                            }
                            f();
                            if (!(r0.d == ' ' || r0.d == '\n' || r0.d == '\r' || r0.d == '\t' || r0.d == '\f' || r0.d == '\b' || r0.d == '[')) {
                                if (r0.d != '(') {
                                    throw new JSONException("scan treeSet error");
                                }
                            }
                            r0.a = 22;
                            return;
                        case '[':
                            f();
                            r0.a = 14;
                            return;
                        case ']':
                            f();
                            r0.a = 15;
                            return;
                        case 'f':
                            if (r0.d != 'f') {
                                throw new JSONException("error parse false");
                            }
                            f();
                            if (r0.d != 'a') {
                                throw new JSONException("error parse false");
                            }
                            f();
                            if (r0.d != 'l') {
                                throw new JSONException("error parse false");
                            }
                            f();
                            if (r0.d != 's') {
                                throw new JSONException("error parse false");
                            }
                            f();
                            if (r0.d != 'e') {
                                throw new JSONException("error parse false");
                            }
                            f();
                            if (!(r0.d == ' ' || r0.d == ',' || r0.d == '}' || r0.d == ']' || r0.d == '\n' || r0.d == '\r' || r0.d == '\t' || r0.d == '\u001a' || r0.d == '\f' || r0.d == '\b')) {
                                if (r0.d != ':') {
                                    throw new JSONException("scan false error");
                                }
                            }
                            r0.a = 7;
                            return;
                        case 'n':
                            if (r0.d != 'n') {
                                throw new JSONException("error parse null or new");
                            }
                            f();
                            if (r0.d == 'u') {
                                f();
                                if (r0.d != 'l') {
                                    throw new JSONException("error parse null");
                                }
                                f();
                                if (r0.d != 'l') {
                                    throw new JSONException("error parse null");
                                }
                                f();
                                if (!(r0.d == ' ' || r0.d == ',' || r0.d == '}' || r0.d == ']' || r0.d == '\n' || r0.d == '\r' || r0.d == '\t' || r0.d == '\u001a' || r0.d == '\f')) {
                                    if (r0.d != '\b') {
                                        throw new JSONException("scan null error");
                                    }
                                }
                                r0.a = 8;
                                return;
                            } else if (r0.d != 'e') {
                                throw new JSONException("error parse new");
                            } else {
                                f();
                                if (r0.d != 'w') {
                                    throw new JSONException("error parse new");
                                }
                                f();
                                if (!(r0.d == ' ' || r0.d == ',' || r0.d == '}' || r0.d == ']' || r0.d == '\n' || r0.d == '\r' || r0.d == '\t' || r0.d == '\u001a' || r0.d == '\f')) {
                                    if (r0.d != '\b') {
                                        throw new JSONException("scan new error");
                                    }
                                }
                                r0.a = 9;
                                return;
                            }
                        case 't':
                            if (r0.d != 't') {
                                throw new JSONException("error parse true");
                            }
                            f();
                            if (r0.d != 'r') {
                                throw new JSONException("error parse true");
                            }
                            f();
                            if (r0.d != 'u') {
                                throw new JSONException("error parse true");
                            }
                            f();
                            if (r0.d != 'e') {
                                throw new JSONException("error parse true");
                            }
                            f();
                            if (!(r0.d == ' ' || r0.d == ',' || r0.d == '}' || r0.d == ']' || r0.d == '\n' || r0.d == '\r' || r0.d == '\t' || r0.d == '\u001a' || r0.d == '\f' || r0.d == '\b')) {
                                if (r0.d != ':') {
                                    throw new JSONException("scan true error");
                                }
                            }
                            r0.a = 6;
                            return;
                        case 'u':
                            if (r0.d != 'u') {
                                throw new JSONException("error parse undefined");
                            }
                            f();
                            if (r0.d != 'n') {
                                throw new JSONException("error parse undefined");
                            }
                            f();
                            if (r0.d != 'd') {
                                throw new JSONException("error parse undefined");
                            }
                            f();
                            if (r0.d != 'e') {
                                throw new JSONException("error parse undefined");
                            }
                            f();
                            if (r0.d != 'f') {
                                throw new JSONException("error parse undefined");
                            }
                            f();
                            if (r0.d != 'i') {
                                throw new JSONException("error parse undefined");
                            }
                            f();
                            if (r0.d != 'n') {
                                throw new JSONException("error parse undefined");
                            }
                            f();
                            if (r0.d != 'e') {
                                throw new JSONException("error parse undefined");
                            }
                            f();
                            if (r0.d != 'd') {
                                throw new JSONException("error parse undefined");
                            }
                            f();
                            if (!(r0.d == ' ' || r0.d == ',' || r0.d == '}' || r0.d == ']' || r0.d == '\n' || r0.d == '\r' || r0.d == '\t' || r0.d == '\u001a' || r0.d == '\f')) {
                                if (r0.d != '\b') {
                                    throw new JSONException("scan undefined error");
                                }
                            }
                            r0.a = 23;
                            return;
                        case '{':
                            f();
                            r0.a = 12;
                            return;
                        case '}':
                            f();
                            r0.a = 13;
                            return;
                        default:
                            if (!B()) {
                                if (r0.d > '\u001f') {
                                    if (r0.d != '') {
                                        new Object[1][0] = String.valueOf(r0.d);
                                        r0.a = 1;
                                        f();
                                        return;
                                    }
                                }
                                f();
                                break;
                            } else if (r0.a == 20) {
                                throw new JSONException("EOF error");
                            } else {
                                r0.a = 20;
                                int i2 = r0.f;
                                r0.e = i2;
                                r0.b = i2;
                                return;
                            }
                    }
                }
                h();
                return;
            } else {
                h();
                return;
            }
        }
    }

    public final void a(int i) {
        this.h = 0;
        while (true) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 12) {
                        if (i != 18) {
                            if (i != 20) {
                                switch (i) {
                                    case 14:
                                        if (this.d == '[') {
                                            this.a = 14;
                                            f();
                                            return;
                                        } else if (this.d == '{') {
                                            this.a = 12;
                                            f();
                                            return;
                                        }
                                        break;
                                    case 15:
                                        if (this.d == ']') {
                                            this.a = 15;
                                            f();
                                            return;
                                        }
                                        break;
                                    case 16:
                                        if (this.d == ',') {
                                            this.a = 16;
                                            f();
                                            return;
                                        } else if (this.d == '}') {
                                            this.a = 13;
                                            f();
                                            return;
                                        } else if (this.d == ']') {
                                            this.a = 15;
                                            f();
                                            return;
                                        } else if (this.d == '\u001a') {
                                            this.a = 20;
                                            return;
                                        }
                                        break;
                                    default:
                                        break;
                                }
                            }
                            if (this.d == '\u001a') {
                                this.a = 20;
                                return;
                            }
                        }
                        while (e(this.d) != 0) {
                            f();
                        }
                        if (this.d != 95) {
                            if (Character.isLetter(this.d) == 0) {
                                d();
                                return;
                            }
                        }
                        this.i = this.e - 1;
                        this.j = false;
                        do {
                            this.h++;
                            f();
                        } while (Character.isLetterOrDigit(this.d) != 0);
                        i = l();
                        if ("null".equals(i)) {
                            this.a = 8;
                            return;
                        } else if ("new".equals(i)) {
                            this.a = 9;
                            return;
                        } else if ("true".equals(i)) {
                            this.a = 6;
                            return;
                        } else if (av.b.equals(i)) {
                            this.a = 7;
                            return;
                        } else if ("undefined".equals(i) != 0) {
                            this.a = 23;
                            return;
                        } else {
                            this.a = 18;
                            return;
                        }
                    } else if (this.d == '{') {
                        this.a = 12;
                        f();
                        return;
                    } else if (this.d == '[') {
                        this.a = 14;
                        f();
                        return;
                    }
                } else if (this.d == '\"') {
                    this.b = this.e;
                    m();
                    return;
                } else if (this.d >= '0' && this.d <= '9') {
                    this.b = this.e;
                    h();
                    return;
                } else if (this.d == '[') {
                    this.a = 14;
                    f();
                    return;
                } else if (this.d == '{') {
                    this.a = 12;
                    f();
                    return;
                }
            } else if (this.d >= '0' && this.d <= '9') {
                this.b = this.e;
                h();
                return;
            } else if (this.d == '\"') {
                this.b = this.e;
                m();
                return;
            } else if (this.d == '[') {
                this.a = 14;
                f();
                return;
            } else if (this.d == '{') {
                this.a = 12;
                f();
                return;
            }
            if (!(this.d == ' ' || this.d == '\n' || this.d == '\r' || this.d == '\t' || this.d == '\f')) {
                if (this.d != '\b') {
                    d();
                    return;
                }
            }
            f();
        }
    }

    public final void o() {
        D();
    }

    private void D() {
        this.h = 0;
        while (this.d != ':') {
            if (!(this.d == ' ' || this.d == '\n' || this.d == '\r' || this.d == '\t' || this.d == '\f')) {
                if (this.d != '\b') {
                    StringBuilder stringBuilder = new StringBuilder("not match : - ");
                    stringBuilder.append(this.d);
                    throw new JSONException(stringBuilder.toString());
                }
            }
            f();
        }
        f();
        d();
    }

    public final int a() {
        return this.a;
    }

    public final String b() {
        return e.a(this.a);
    }

    public final int i() {
        return this.b;
    }

    public final int r() {
        return this.e;
    }

    public final String A() {
        return this.o;
    }

    public final Number j() throws NumberFormatException {
        long j;
        long j2;
        int i = 0;
        if (this.i == -1) {
            r0.i = 0;
        }
        int i2 = r0.i;
        int i3 = r0.i + r0.h;
        int i4 = 32;
        char b = b(i3 - 1);
        if (b == 'B') {
            i3--;
            i4 = 66;
        } else if (b == 'L') {
            i3--;
            i4 = 76;
        } else if (b == 'S') {
            i3--;
            i4 = 83;
        }
        if (b(r0.i) == '-') {
            j = Long.MIN_VALUE;
            i2++;
            i = 1;
        } else {
            j = -9223372036854775807L;
        }
        if (i2 < i3) {
            j2 = (long) (-q[b(i2)]);
            i2++;
        } else {
            j2 = 0;
        }
        while (i2 < i3) {
            int i5 = i2 + 1;
            i2 = q[b(i2)];
            if (j2 < -922337203685477580L) {
                return new BigInteger(u());
            }
            j2 *= 10;
            int i6 = i5;
            long j3 = (long) i2;
            if (j2 < j + j3) {
                return new BigInteger(u());
            }
            j2 -= j3;
            i2 = i6;
        }
        if (i == 0) {
            long j4 = -j2;
            if (j4 > 2147483647L || i4 == 76) {
                return Long.valueOf(j4);
            }
            if (i4 == 83) {
                return Short.valueOf((short) ((int) j4));
            }
            if (i4 == 66) {
                return Byte.valueOf((byte) ((int) j4));
            }
            return Integer.valueOf((int) j4);
        } else if (i2 <= r0.i + 1) {
            throw new NumberFormatException(u());
        } else if (j2 < -2147483648L || i4 == 76) {
            return Long.valueOf(j2);
        } else {
            if (i4 == 83) {
                return Short.valueOf((short) ((int) j2));
            }
            if (i4 == 66) {
                return Byte.valueOf((byte) ((int) j2));
            }
            return Integer.valueOf((int) j2);
        }
    }

    public final void p() {
        D();
    }

    public final float w() {
        return Float.parseFloat(u());
    }

    public final boolean a(Feature feature) {
        return (feature.mask & this.c) != null ? true : null;
    }

    public final char e() {
        return this.d;
    }

    private void E() {
        f();
        if (this.d == '/') {
            do {
                f();
            } while (this.d != '\n');
            f();
        } else if (this.d == '*') {
            while (true) {
                f();
                if (this.d == '*') {
                    f();
                    if (this.d == '/') {
                        f();
                        return;
                    }
                }
            }
        } else {
            throw new JSONException("invalid comment");
        }
    }

    public final String a(h hVar) {
        c();
        if (this.d == '\"') {
            return a(hVar, '\"');
        }
        if (this.d == '\'') {
            if (a(Feature.AllowSingleQuotes)) {
                return a(hVar, '\'');
            }
            throw new JSONException("syntax error");
        } else if (this.d == '}') {
            f();
            this.a = 13;
            return null;
        } else if (this.d == ',') {
            f();
            this.a = 16;
            return null;
        } else if (this.d == '\u001a') {
            this.a = 20;
            return null;
        } else if (a(Feature.AllowUnQuotedFieldNames)) {
            return b(hVar);
        } else {
            throw new JSONException("syntax error");
        }
    }

    public final String a(h hVar, char c) {
        h hVar2 = hVar;
        this.i = this.e;
        this.h = 0;
        char c2 = '\u0000';
        int i = c2;
        while (true) {
            char f = f();
            int i2;
            if (f == c) {
                String a;
                r0.a = 4;
                if (c2 == '\u0000') {
                    if (r0.i == -1) {
                        i2 = 0;
                    } else {
                        i2 = r0.i + 1;
                    }
                    a = a(i2, r0.h, i, hVar2);
                } else {
                    a = hVar2.a(r0.g, r0.h, i);
                }
                r0.h = 0;
                f();
                return a;
            } else if (f == '\u001a') {
                throw new JSONException("unclosed.str");
            } else if (f == '\\') {
                if (c2 == '\u0000') {
                    if (r0.h >= r0.g.length) {
                        i2 = r0.g.length * 2;
                        if (r0.h > i2) {
                            i2 = r0.h;
                        }
                        Object obj = new char[i2];
                        System.arraycopy(r0.g, 0, obj, 0, r0.g.length);
                        r0.g = obj;
                    }
                    a(r0.i + 1, r0.g, r0.h);
                    c2 = '\u0001';
                }
                char f2 = f();
                switch (f2) {
                    case '/':
                        i = (31 * i) + 47;
                        d('/');
                        break;
                    case '0':
                        i = (31 * i) + f2;
                        d('\u0000');
                        break;
                    case '1':
                        i = (31 * i) + f2;
                        d('\u0001');
                        break;
                    case '2':
                        i = (31 * i) + f2;
                        d('\u0002');
                        break;
                    case '3':
                        i = (31 * i) + f2;
                        d('\u0003');
                        break;
                    case '4':
                        i = (31 * i) + f2;
                        d('\u0004');
                        break;
                    case '5':
                        i = (31 * i) + f2;
                        d('\u0005');
                        break;
                    case '6':
                        i = (31 * i) + f2;
                        d('\u0006');
                        break;
                    case '7':
                        i = (31 * i) + f2;
                        d('\u0007');
                        break;
                    default:
                        int parseInt;
                        switch (f2) {
                            case 't':
                                i = (31 * i) + 9;
                                d('\t');
                                continue;
                            case 'u':
                                char f3 = f();
                                f2 = f();
                                char f4 = f();
                                char f5 = f();
                                parseInt = Integer.parseInt(new String(new char[]{f3, f2, f4, f5}), 16);
                                i = (31 * i) + parseInt;
                                d((char) parseInt);
                                continue;
                            case 'v':
                                parseInt = (31 * i) + 11;
                                d('\u000b');
                                break;
                            default:
                                switch (f2) {
                                    case '\"':
                                        parseInt = (31 * i) + 34;
                                        d('\"');
                                        break;
                                    case '\'':
                                        parseInt = (31 * i) + 39;
                                        d('\'');
                                        break;
                                    case 'F':
                                    case 'f':
                                        parseInt = (31 * i) + 12;
                                        d('\f');
                                        break;
                                    case '\\':
                                        i = (31 * i) + 92;
                                        d('\\');
                                        continue;
                                    case 'b':
                                        parseInt = (31 * i) + 8;
                                        d('\b');
                                        break;
                                    case 'n':
                                        parseInt = (31 * i) + 10;
                                        d('\n');
                                        break;
                                    case 'r':
                                        parseInt = (31 * i) + 13;
                                        d('\r');
                                        break;
                                    case 'x':
                                        f = f();
                                        r0.d = f;
                                        char f6 = f();
                                        r0.d = f6;
                                        f = (char) ((q[f] * 16) + q[f6]);
                                        i = (31 * i) + f;
                                        d(f);
                                        continue;
                                        continue;
                                    default:
                                        r0.d = f2;
                                        throw new JSONException("unclosed.str.lit");
                                }
                        }
                        i = parseInt;
                        break;
                }
            } else {
                i = (31 * i) + f;
                if (c2 == '\u0000') {
                    r0.h++;
                } else if (r0.h == r0.g.length) {
                    d(f);
                } else {
                    char[] cArr = r0.g;
                    int i3 = r0.h;
                    r0.h = i3 + 1;
                    cArr[i3] = f;
                }
            }
        }
    }

    public final void g() {
        this.h = 0;
    }

    public final String b(h hVar) {
        int i;
        char f;
        boolean[] zArr = e.b;
        int i2 = this.d;
        if (this.d < zArr.length) {
            if (!zArr[i2]) {
                i = 0;
                if (i != 0) {
                    StringBuilder stringBuilder = new StringBuilder("illegal identifier : ");
                    stringBuilder.append(this.d);
                    stringBuilder.append(z());
                    throw new JSONException(stringBuilder.toString());
                }
                zArr = e.c;
                this.i = this.e;
                this.h = 1;
                while (true) {
                    f = f();
                    if (f >= zArr.length) {
                        if (zArr[f]) {
                            break;
                        }
                    }
                    i2 = (31 * i2) + f;
                    this.h++;
                }
                this.d = b(this.e);
                this.a = 18;
                if (this.h != 4 && i2 == 3392903 && b(this.i) == 'n' && b(this.i + 1) == 'u' && b(this.i + 2) == 'l' && b(this.i + 3) == 'l') {
                    return null;
                }
                return a(this.i, this.h, i2, hVar);
            }
        }
        i = 1;
        if (i != 0) {
            zArr = e.c;
            this.i = this.e;
            this.h = 1;
            while (true) {
                f = f();
                if (f >= zArr.length) {
                    if (zArr[f]) {
                        break;
                    }
                }
                i2 = (31 * i2) + f;
                this.h++;
            }
            this.d = b(this.e);
            this.a = 18;
            if (this.h != 4) {
            }
            return a(this.i, this.h, i2, hVar);
        }
        StringBuilder stringBuilder2 = new StringBuilder("illegal identifier : ");
        stringBuilder2.append(this.d);
        stringBuilder2.append(z());
        throw new JSONException(stringBuilder2.toString());
    }

    public final void m() {
        this.i = this.e;
        this.j = false;
        while (true) {
            char f = f();
            if (f == '\"') {
                this.a = 4;
                this.d = f();
                return;
            } else if (f == '\u001a') {
                if (B()) {
                    r2 = new StringBuilder("unclosed string : ");
                    r2.append(f);
                    throw new JSONException(r2.toString());
                }
                d('\u001a');
            } else if (f == '\\') {
                if (!this.j) {
                    this.j = true;
                    if (this.h >= this.g.length) {
                        int length = this.g.length * 2;
                        if (this.h > length) {
                            length = this.h;
                        }
                        Object obj = new char[length];
                        System.arraycopy(this.g, 0, obj, 0, this.g.length);
                        this.g = obj;
                    }
                    a(this.i + 1, this.h, this.g);
                }
                f = f();
                switch (f) {
                    case '/':
                        d('/');
                        break;
                    case '0':
                        d('\u0000');
                        break;
                    case '1':
                        d('\u0001');
                        break;
                    case '2':
                        d('\u0002');
                        break;
                    case '3':
                        d('\u0003');
                        break;
                    case '4':
                        d('\u0004');
                        break;
                    case '5':
                        d('\u0005');
                        break;
                    case '6':
                        d('\u0006');
                        break;
                    case '7':
                        d('\u0007');
                        break;
                    default:
                        switch (f) {
                            case 't':
                                d('\t');
                                break;
                            case 'u':
                                f = f();
                                char f2 = f();
                                char f3 = f();
                                char f4 = f();
                                d((char) Integer.parseInt(new String(new char[]{f, f2, f3, f4}), 16));
                                break;
                            case 'v':
                                d('\u000b');
                                break;
                            default:
                                switch (f) {
                                    case '\"':
                                        d('\"');
                                        break;
                                    case '\'':
                                        d('\'');
                                        break;
                                    case 'F':
                                    case 'f':
                                        d('\f');
                                        break;
                                    case '\\':
                                        d('\\');
                                        break;
                                    case 'b':
                                        d('\b');
                                        break;
                                    case 'n':
                                        d('\n');
                                        break;
                                    case 'r':
                                        d('\r');
                                        break;
                                    case 'x':
                                        d((char) ((q[f()] * 16) + q[f()]));
                                        break;
                                    default:
                                        this.d = f;
                                        r2 = new StringBuilder("unclosed string : ");
                                        r2.append(f);
                                        throw new JSONException(r2.toString());
                                }
                        }
                }
            } else if (!this.j) {
                this.h++;
            } else if (this.h == this.g.length) {
                d(f);
            } else {
                char[] cArr = this.g;
                int i = this.h;
                this.h = i + 1;
                cArr[i] = f;
            }
        }
    }

    public final Calendar C() {
        return this.k;
    }

    public final TimeZone x() {
        return this.l;
    }

    public final Locale y() {
        return this.m;
    }

    public final int n() {
        int i;
        int i2;
        int i3 = 0;
        if (this.i == -1) {
            this.i = 0;
        }
        int i4 = this.i;
        int i5 = this.i + this.h;
        if (b(this.i) == '-') {
            i4++;
            i = Integer.MIN_VALUE;
            i2 = 1;
        } else {
            i = -2147483647;
            i2 = 0;
        }
        if (i4 < i5) {
            int i6 = i4 + 1;
            i3 = -q[b(i4)];
            i4 = i6;
        }
        if (i4 < i5) {
            i6 = i4 + 1;
            char b = b(i4);
            if (b != 'L' || b == 'S' || b == 'B') {
                i4 = i6;
            } else {
                i4 = q[b];
                if (((long) i3) >= -214748364) {
                    i3 *= 10;
                    if (i3 >= i + i4) {
                        i3 -= i4;
                        i4 = i6;
                        if (i4 < i5) {
                            i6 = i4 + 1;
                            char b2 = b(i4);
                            if (b2 != 'L') {
                            }
                            i4 = i6;
                        }
                    }
                    throw new NumberFormatException(u());
                }
                throw new NumberFormatException(u());
            }
        }
        if (i2 == 0) {
            return -i3;
        }
        if (i4 > this.i + 1) {
            return i3;
        }
        throw new NumberFormatException(u());
    }

    public void close() {
        if (this.g.length <= 8192) {
            Object obj;
            if (this.r != null) {
                if (this.r.get() == this.g) {
                    obj = this.r;
                    s.set(obj);
                }
            }
            obj = new SoftReference(this.g);
            s.set(obj);
        }
        this.g = null;
    }

    public final boolean t() {
        if (this.h == 4 && b(this.i + 1) == '$' && b(this.i + 2) == 'r' && b(this.i + 3) == 'e' && b(this.i + 4) == 'f') {
            return true;
        }
        return false;
    }

    public final boolean a(char[] cArr) {
        if (!h(cArr)) {
            return null;
        }
        this.e += cArr.length;
        this.d = b(this.e);
        if (this.d == 123) {
            f();
            this.a = 12;
        } else if (this.d == 91) {
            f();
            this.a = 14;
        } else if (this.d == 83 && b(this.e + 1) == 101 && b(this.e + 2) == 116 && b(this.e + 3) == 91) {
            this.e += 3;
            this.d = b(this.e);
            this.a = 21;
        } else {
            d();
        }
        return true;
    }

    public String b(char[] cArr) {
        int i = 0;
        this.n = 0;
        if (h(cArr)) {
            int length = cArr.length;
            int i2 = length + 1;
            if (b(this.e + length) != '\"') {
                this.n = -1;
                return this.o;
            }
            length = c((this.e + cArr.length) + 1);
            if (length == -1) {
                throw new JSONException("unclosed str");
            }
            int length2 = (this.e + cArr.length) + 1;
            String a = a(length2, length - length2);
            for (int length3 = (this.e + cArr.length) + 1; length3 < length; length3++) {
                if (b(length3) == '\\') {
                    i = 1;
                    break;
                }
            }
            if (i != 0) {
                this.n = -1;
                return this.o;
            }
            i2 += (length - ((this.e + cArr.length) + 1)) + 1;
            i = i2 + 1;
            cArr = b(this.e + i2);
            if (cArr == 44) {
                this.e += i - 1;
                f();
                this.n = 3;
                return a;
            } else if (cArr == 125) {
                i2 = i + 1;
                cArr = b(this.e + i);
                if (cArr == 44) {
                    this.a = 16;
                    this.e += i2 - 1;
                    f();
                } else if (cArr == 93) {
                    this.a = 15;
                    this.e += i2 - 1;
                    f();
                } else if (cArr == 125) {
                    this.a = 13;
                    this.e += i2 - 1;
                    f();
                } else if (cArr == 26) {
                    this.a = 20;
                    this.e += i2 - 1;
                    this.d = '\u001a';
                } else {
                    this.n = -1;
                    return this.o;
                }
                this.n = 4;
                return a;
            } else {
                this.n = -1;
                return this.o;
            }
        }
        this.n = -2;
        return this.o;
    }

    public final String c(char c) {
        int i = 0;
        this.n = 0;
        char b = b(this.e + 0);
        if (b == 'n') {
            if (b(this.e + 1) != 'u' || b((this.e + 1) + 1) != 'l' || b((this.e + 1) + 2) != 'l') {
                this.n = -1;
                return null;
            } else if (b(this.e + 4) == c) {
                this.e += 4;
                f();
                this.n = 3;
                return null;
            } else {
                this.n = -1;
                return null;
            }
        } else if (b != '\"') {
            this.n = -1;
            return this.o;
        } else {
            int i2 = this.e + 1;
            int c2 = c(i2);
            if (c2 == -1) {
                throw new JSONException("unclosed str");
            }
            int i3;
            String a = a(this.e + 1, c2 - i2);
            for (i3 = this.e + 1; i3 < c2; i3++) {
                if (b(i3) == '\\') {
                    i = 1;
                    break;
                }
            }
            if (i != 0) {
                this.n = -1;
                return this.o;
            }
            c2 = ((c2 - (this.e + 1)) + 1) + 1;
            i3 = c2 + 1;
            if (b(this.e + c2) == c) {
                this.e += i3 - 1;
                f();
                this.n = 3;
                return a;
            }
            this.n = -1;
            return a;
        }
    }

    public String a(char[] cArr, h hVar) {
        int i = 0;
        this.n = 0;
        if (h(cArr)) {
            int length = cArr.length;
            int i2 = length + 1;
            if (b(this.e + length) != '\"') {
                this.n = -1;
                return null;
            }
            int i3;
            while (true) {
                i3 = i2 + 1;
                char b = b(this.e + i2);
                if (b == '\"') {
                    break;
                }
                i = (31 * i) + b;
                if (b == '\\') {
                    this.n = -1;
                    return null;
                }
                i2 = i3;
            }
            int length2 = (this.e + cArr.length) + 1;
            cArr = a(length2, ((this.e + i3) - length2) - 1, i, hVar);
            i = i3 + 1;
            hVar = b(this.e + i3);
            if (hVar == 44) {
                this.e += i - 1;
                f();
                this.n = 3;
                return cArr;
            } else if (hVar == 125) {
                i3 = i + 1;
                hVar = b(this.e + i);
                if (hVar == 44) {
                    this.a = 16;
                    this.e += i3 - 1;
                    f();
                } else if (hVar == 93) {
                    this.a = 15;
                    this.e += i3 - 1;
                    f();
                } else if (hVar == 125) {
                    this.a = 13;
                    this.e += i3 - 1;
                    f();
                } else if (hVar == 26) {
                    this.a = 20;
                    this.e += i3 - 1;
                    this.d = '\u001a';
                } else {
                    this.n = -1;
                    return null;
                }
                this.n = 4;
                return cArr;
            } else {
                this.n = -1;
                return null;
            }
        }
        this.n = -2;
        return null;
    }

    public int c(char[] cArr) {
        this.n = 0;
        if (h(cArr)) {
            cArr = cArr.length;
            int i = cArr + 1;
            cArr = b(this.e + cArr);
            if (cArr < 48 || cArr > 57) {
                this.n = -1;
                return 0;
            }
            int i2;
            char b;
            cArr = q[cArr];
            while (true) {
                i2 = i + 1;
                b = b(this.e + i);
                if (b >= '0' && b <= '9') {
                    cArr = (cArr * 10) + q[b];
                    i = i2;
                }
            }
            if (b == '.') {
                this.n = -1;
                return 0;
            } else if (cArr < null) {
                this.n = -1;
                return 0;
            } else if (b == ',') {
                this.e += i2 - 1;
                f();
                this.n = 3;
                this.a = 16;
                return cArr;
            } else if (b == '}') {
                int i3 = i2 + 1;
                b = b(this.e + i2);
                if (b == ',') {
                    this.a = 16;
                    this.e += i3 - 1;
                    f();
                } else if (b == ']') {
                    this.a = 15;
                    this.e += i3 - 1;
                    f();
                } else if (b == '}') {
                    this.a = 13;
                    this.e += i3 - 1;
                    f();
                } else if (b == '\u001a') {
                    this.a = 20;
                    this.e += i3 - 1;
                    this.d = '\u001a';
                } else {
                    this.n = -1;
                    return 0;
                }
                this.n = 4;
                return cArr;
            } else {
                this.n = -1;
                return 0;
            }
        }
        this.n = -2;
        return 0;
    }

    public final int b(char c) {
        this.n = 0;
        char b = b(this.e + 0);
        if (b < '0' || b > '9') {
            this.n = -1;
            return 0;
        }
        int i = q[b];
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            b = b(this.e + i2);
            if (b >= '0' && b <= '9') {
                i = (i * 10) + q[b];
                i2 = i3;
            }
        }
        if (b == '.') {
            this.n = -1;
            return 0;
        } else if (i < 0) {
            this.n = -1;
            return 0;
        } else if (b == c) {
            this.e += i3 - 1;
            f();
            this.n = '\u0003';
            this.a = '\u0010';
            return i;
        } else {
            this.n = -1;
            return i;
        }
    }

    public boolean d(char[] cArr) {
        this.n = 0;
        if (h(cArr)) {
            int i;
            cArr = cArr.length;
            int i2 = cArr + 1;
            cArr = b(this.e + cArr);
            if (cArr == 116) {
                i = i2 + 1;
                if (b(this.e + i2) != 114) {
                    this.n = -1;
                    return false;
                }
                i2 = i + 1;
                if (b(this.e + i) != 117) {
                    this.n = -1;
                    return false;
                }
                i = i2 + 1;
                if (b(this.e + i2) != 101) {
                    this.n = -1;
                    return false;
                }
                cArr = 1;
            } else if (cArr == 102) {
                i = i2 + 1;
                if (b(this.e + i2) != 97) {
                    this.n = -1;
                    return false;
                }
                i2 = i + 1;
                if (b(this.e + i) != 108) {
                    this.n = -1;
                    return false;
                }
                i = i2 + 1;
                if (b(this.e + i2) != 115) {
                    this.n = -1;
                    return false;
                }
                i2 = i + 1;
                if (b(this.e + i) != 101) {
                    this.n = -1;
                    return false;
                }
                cArr = null;
                i = i2;
            } else {
                this.n = -1;
                return false;
            }
            i2 = i + 1;
            char b = b(this.e + i);
            if (b == ',') {
                this.e += i2 - 1;
                f();
                this.n = 3;
                this.a = 16;
                return cArr;
            } else if (b == '}') {
                int i3 = i2 + 1;
                b = b(this.e + i2);
                if (b == ',') {
                    this.a = 16;
                    this.e += i3 - 1;
                    f();
                } else if (b == ']') {
                    this.a = 15;
                    this.e += i3 - 1;
                    f();
                } else if (b == '}') {
                    this.a = 13;
                    this.e += i3 - 1;
                    f();
                } else if (b == '\u001a') {
                    this.a = 20;
                    this.e += i3 - 1;
                    this.d = '\u001a';
                } else {
                    this.n = -1;
                    return false;
                }
                this.n = 4;
                return cArr;
            } else {
                this.n = -1;
                return false;
            }
        }
        this.n = -2;
        return false;
    }

    public long e(char[] cArr) {
        this.n = 0;
        if (h(cArr)) {
            cArr = cArr.length;
            int i = cArr + 1;
            cArr = b(this.e + cArr);
            if (cArr < 48 || cArr > 57) {
                this.n = -1;
                return 0;
            }
            int i2;
            long j = (long) q[cArr];
            while (true) {
                i2 = i + 1;
                cArr = b(this.e + i);
                if (cArr >= 48 && cArr <= 57) {
                    i = i2;
                    j = (j * 10) + ((long) q[cArr]);
                }
            }
            if (cArr == 46) {
                this.n = -1;
                return 0;
            } else if (j < 0) {
                this.n = -1;
                return 0;
            } else if (cArr == 44) {
                this.e += i2 - 1;
                f();
                this.n = 3;
                this.a = 16;
                return j;
            } else if (cArr == 125) {
                int i3 = i2 + 1;
                cArr = b(this.e + i2);
                if (cArr == 44) {
                    this.a = 16;
                    this.e += i3 - 1;
                    f();
                } else if (cArr == 93) {
                    this.a = 15;
                    this.e += i3 - 1;
                    f();
                } else if (cArr == 125) {
                    this.a = 13;
                    this.e += i3 - 1;
                    f();
                } else if (cArr == 26) {
                    this.a = 20;
                    this.e += i3 - 1;
                    this.d = '\u001a';
                } else {
                    this.n = -1;
                    return 0;
                }
                this.n = 4;
                return j;
            } else {
                this.n = -1;
                return 0;
            }
        }
        this.n = -2;
        return 0;
    }

    public final long a(char c) {
        this.n = 0;
        char b = b(this.e + 0);
        if (b < '0' || b > '9') {
            r0.n = -1;
            return 0;
        }
        long j = (long) q[b];
        int i = 1;
        while (true) {
            int i2 = i + 1;
            char b2 = b(r0.e + i);
            if (b2 >= '0' && b2 <= '9') {
                i = i2;
                j = (j * 10) + ((long) q[b2]);
            }
        }
        if (b2 == '.') {
            r0.n = -1;
            return 0;
        } else if (j < 0) {
            r0.n = -1;
            return 0;
        } else if (b2 == c) {
            r0.e += i2 - 1;
            f();
            r0.n = 3;
            r0.a = 16;
            return j;
        } else {
            r0.n = -1;
            return j;
        }
    }

    public final float f(char[] cArr) {
        this.n = 0;
        if (h(cArr)) {
            int length = cArr.length;
            int i = length + 1;
            char b = b(this.e + length);
            if (b < '0' || b > '9') {
                this.n = -1;
                return 0.0f;
            }
            int i2;
            while (true) {
                i2 = i + 1;
                b = b(this.e + i);
                if (b < '0') {
                    break;
                } else if (b > '9') {
                    break;
                } else {
                    i = i2;
                }
            }
            if (b == '.') {
                i = i2 + 1;
                b = b(this.e + i2);
                if (b >= '0' && b <= '9') {
                    while (true) {
                        i2 = i + 1;
                        b = b(this.e + i);
                        if (b < '0' || b > '9') {
                            break;
                        }
                        i = i2;
                    }
                } else {
                    this.n = -1;
                    return 0.0f;
                }
            }
            int length2 = this.e + cArr.length;
            cArr = Float.parseFloat(a(length2, ((this.e + i2) - length2) - 1));
            if (b == ',') {
                this.e += i2 - 1;
                f();
                this.n = 3;
                this.a = 16;
                return cArr;
            } else if (b == '}') {
                int i3 = i2 + 1;
                b = b(this.e + i2);
                if (b == ',') {
                    this.a = 16;
                    this.e += i3 - 1;
                    f();
                } else if (b == ']') {
                    this.a = 15;
                    this.e += i3 - 1;
                    f();
                } else if (b == '}') {
                    this.a = 13;
                    this.e += i3 - 1;
                    f();
                } else if (b == '\u001a') {
                    this.e += i3 - 1;
                    this.a = 20;
                    this.d = '\u001a';
                } else {
                    this.n = -1;
                    return 0.0f;
                }
                this.n = 4;
                return cArr;
            } else {
                this.n = -1;
                return 0.0f;
            }
        }
        this.n = -2;
        return 0.0f;
    }

    public final double g(char[] r12) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r11 = this;
        r0 = 0;
        r11.n = r0;
        r0 = r11.h(r12);
        r1 = 0;
        if (r0 != 0) goto L_0x000f;
    L_0x000b:
        r12 = -2;
        r11.n = r12;
        return r1;
    L_0x000f:
        r0 = -1;
        r3 = 48;
        r4 = r12.length;
        r5 = r11.e;
        r6 = r4 + 1;
        r5 = r5 + r4;
        r4 = r11.b(r5);
        if (r4 < r3) goto L_0x010f;
    L_0x001e:
        r5 = 57;
        if (r4 > r5) goto L_0x010f;
    L_0x0022:
        r4 = r11.e;
        r7 = r6 + 1;
        r4 = r4 + r6;
        r4 = r11.b(r4);
        if (r4 < r3) goto L_0x0032;
    L_0x002d:
        if (r4 <= r5) goto L_0x0030;
    L_0x002f:
        goto L_0x0032;
    L_0x0030:
        r6 = r7;
        goto L_0x0022;
    L_0x0032:
        r6 = 46;
        if (r4 != r6) goto L_0x0055;
    L_0x0036:
        r4 = r11.e;
        r6 = r7 + 1;
        r4 = r4 + r7;
        r4 = r11.b(r4);
        if (r4 < r3) goto L_0x0052;
    L_0x0041:
        if (r4 > r5) goto L_0x0052;
    L_0x0043:
        r4 = r11.e;
        r7 = r6 + 1;
        r4 = r4 + r6;
        r4 = r11.b(r4);
        if (r4 < r3) goto L_0x0055;
    L_0x004e:
        if (r4 > r5) goto L_0x0055;
    L_0x0050:
        r6 = r7;
        goto L_0x0043;
    L_0x0052:
        r11.n = r0;
        return r1;
    L_0x0055:
        r6 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r4 == r6) goto L_0x0062;
    L_0x0059:
        r6 = 69;
        if (r4 != r6) goto L_0x005e;
    L_0x005d:
        goto L_0x0062;
    L_0x005e:
        r6 = r7;
        r7 = r12;
        r12 = r11;
        goto L_0x008c;
    L_0x0062:
        r4 = r11.e;
        r6 = r7 + 1;
        r4 = r4 + r7;
        r4 = r11.b(r4);
        r7 = 43;
        if (r4 == r7) goto L_0x0077;
    L_0x006f:
        r7 = 45;
        if (r4 != r7) goto L_0x0074;
    L_0x0073:
        goto L_0x0077;
    L_0x0074:
        r7 = r12;
        r12 = r11;
        goto L_0x0085;
    L_0x0077:
        r4 = r12;
        r12 = r11;
    L_0x0079:
        r7 = r12.e;
        r8 = r6 + 1;
        r7 = r7 + r6;
        r6 = r12.b(r7);
        r7 = r4;
        r4 = r6;
        r6 = r8;
    L_0x0085:
        if (r4 < r3) goto L_0x008c;
    L_0x0087:
        if (r4 <= r5) goto L_0x008a;
    L_0x0089:
        goto L_0x008c;
    L_0x008a:
        r4 = r7;
        goto L_0x0079;
    L_0x008c:
        r3 = r12.e;
        r5 = r7.length;
        r3 = r3 + r5;
        r5 = r12.e;
        r5 = r5 + r6;
        r5 = r5 - r3;
        r5 = r5 + -1;
        r3 = r12.a(r3, r5);
        r7 = java.lang.Double.parseDouble(r3);
        r3 = 16;
        r5 = 44;
        if (r4 != r5) goto L_0x00b4;
    L_0x00a4:
        r0 = r12.e;
        r6 = r6 + -1;
        r0 = r0 + r6;
        r12.e = r0;
        r12.f();
        r0 = 3;
        r12.n = r0;
        r12.a = r3;
        return r7;
    L_0x00b4:
        r9 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        if (r4 != r9) goto L_0x010c;
    L_0x00b8:
        r4 = r12.e;
        r10 = r6 + 1;
        r4 = r4 + r6;
        r4 = r12.b(r4);
        if (r4 != r5) goto L_0x00d0;
    L_0x00c3:
        r12.a = r3;
        r0 = r12.e;
        r10 = r10 + -1;
        r0 = r0 + r10;
        r12.e = r0;
        r12.f();
        goto L_0x0105;
    L_0x00d0:
        r3 = 93;
        if (r4 != r3) goto L_0x00e3;
    L_0x00d4:
        r0 = 15;
        r12.a = r0;
        r0 = r12.e;
        r10 = r10 + -1;
        r0 = r0 + r10;
        r12.e = r0;
        r12.f();
        goto L_0x0105;
    L_0x00e3:
        if (r4 != r9) goto L_0x00f4;
    L_0x00e5:
        r0 = 13;
        r12.a = r0;
        r0 = r12.e;
        r10 = r10 + -1;
        r0 = r0 + r10;
        r12.e = r0;
        r12.f();
        goto L_0x0105;
    L_0x00f4:
        r3 = 26;
        if (r4 != r3) goto L_0x0109;
    L_0x00f8:
        r0 = 20;
        r12.a = r0;
        r0 = r12.e;
        r10 = r10 + -1;
        r0 = r0 + r10;
        r12.e = r0;
        r12.d = r3;
    L_0x0105:
        r0 = 4;
        r12.n = r0;
        return r7;
    L_0x0109:
        r12.n = r0;
        return r1;
    L_0x010c:
        r12.n = r0;
        return r1;
    L_0x010f:
        r11.n = r0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.c.g(char[]):double");
    }

    public final boolean q() {
        int i = 0;
        while (true) {
            char b = b(i);
            if (b == '\u001a') {
                return true;
            }
            if (!e(b)) {
                return false;
            }
            i++;
        }
    }

    public final void c() {
        while (this.d <= '/') {
            if (!(this.d == ' ' || this.d == '\r' || this.d == '\n' || this.d == '\t' || this.d == '\f')) {
                if (this.d != '\b') {
                    if (this.d == '/') {
                        E();
                    } else {
                        return;
                    }
                }
            }
            f();
        }
    }

    private void d(char c) {
        if (this.h == this.g.length) {
            Object obj = new char[(this.g.length * 2)];
            System.arraycopy(this.g, 0, obj, 0, this.g.length);
            this.g = obj;
        }
        char[] cArr = this.g;
        int i = this.h;
        this.h = i + 1;
        cArr[i] = c;
    }

    public final void h() {
        this.i = this.e;
        if (this.d == '-') {
            this.h++;
            f();
        }
        while (this.d >= '0' && this.d <= '9') {
            this.h++;
            f();
        }
        int i = 0;
        if (this.d == '.') {
            this.h++;
            f();
            while (this.d >= '0' && this.d <= '9') {
                this.h++;
                f();
            }
            i = 1;
        }
        if (this.d == 'L') {
            this.h++;
            f();
        } else if (this.d == 'S') {
            this.h++;
            f();
        } else if (this.d == 'B') {
            this.h++;
            f();
        } else {
            if (this.d == 'F') {
                this.h++;
                f();
            } else if (this.d == 'D') {
                this.h++;
                f();
            } else if (this.d == 'e' || this.d == 'E') {
                this.h++;
                f();
                if (this.d == '+' || this.d == '-') {
                    this.h++;
                    f();
                }
                while (this.d >= '0' && this.d <= '9') {
                    this.h++;
                    f();
                }
                if (this.d == 'D' || this.d == 'F') {
                    this.h++;
                    f();
                }
            }
            i = 1;
        }
        if (i != 0) {
            this.a = 3;
        } else {
            this.a = 2;
        }
    }

    public final long s() throws NumberFormatException {
        long j;
        long j2;
        int i = 0;
        if (this.i == -1) {
            this.i = 0;
        }
        int i2 = this.i;
        int i3 = this.i + this.h;
        if (b(this.i) == '-') {
            j = Long.MIN_VALUE;
            i2++;
            i = 1;
        } else {
            j = -9223372036854775807L;
        }
        if (i2 < i3) {
            j2 = (long) (-q[b(i2)]);
            i2++;
        } else {
            j2 = 0;
        }
        while (i2 < i3) {
            int i4 = i2 + 1;
            char b = b(i2);
            if (b == 'L' || b == 'S' || b == 'B') {
                i2 = i4;
                break;
            }
            i2 = q[b];
            if (j2 < -922337203685477580L) {
                throw new NumberFormatException(u());
            }
            j2 *= 10;
            long j3 = (long) i2;
            if (j2 < j + j3) {
                throw new NumberFormatException(u());
            }
            i2 = i4;
            j2 -= j3;
        }
        if (i == 0) {
            return -j2;
        }
        if (i2 > this.i + 1) {
            return j2;
        }
        throw new NumberFormatException(u());
    }

    public final Number a(boolean z) {
        char b = b((this.i + this.h) - 1);
        if (b == 'F') {
            return Float.valueOf(Float.parseFloat(u()));
        }
        if (b == 'D') {
            return Double.valueOf(Double.parseDouble(u()));
        }
        if (z) {
            return k();
        }
        return Double.valueOf(Double.parseDouble(u()));
    }

    public final BigDecimal k() {
        return new BigDecimal(u());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Enum<?> a(java.lang.Class<?> r11, com.alibaba.fastjson.parser.h r12, char r13) {
        /*
        r10 = this;
        r0 = 0;
        r10.n = r0;
        r1 = r10.e;
        r1 = r1 + r0;
        r1 = r10.b(r1);
        r2 = 3;
        r3 = -1;
        r4 = 0;
        r5 = 1;
        r6 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        if (r1 != r6) goto L_0x0051;
    L_0x0012:
        r12 = r10.e;
        r12 = r12 + r5;
        r12 = r10.b(r12);
        r0 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        if (r12 != r0) goto L_0x004d;
    L_0x001d:
        r12 = r10.e;
        r12 = r12 + r5;
        r12 = r12 + r5;
        r12 = r10.b(r12);
        r0 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        if (r12 != r0) goto L_0x004d;
    L_0x0029:
        r12 = r10.e;
        r12 = r12 + r5;
        r12 = r12 + 2;
        r12 = r10.b(r12);
        if (r12 != r0) goto L_0x004d;
    L_0x0034:
        r12 = r10.e;
        r12 = r12 + 4;
        r12 = r10.b(r12);
        if (r12 != r13) goto L_0x004a;
    L_0x003e:
        r12 = r10.e;
        r12 = r12 + 4;
        r10.e = r12;
        r10.f();
        r10.n = r2;
        goto L_0x004f;
    L_0x004a:
        r10.n = r3;
        goto L_0x004f;
    L_0x004d:
        r10.n = r3;
    L_0x004f:
        r12 = r4;
        goto L_0x0098;
    L_0x0051:
        r6 = 34;
        if (r1 == r6) goto L_0x0058;
    L_0x0055:
        r10.n = r3;
        goto L_0x004f;
    L_0x0058:
        r7 = r0;
        r1 = r5;
    L_0x005a:
        r8 = r10.e;
        r9 = r1 + 1;
        r8 = r8 + r1;
        r1 = r10.b(r8);
        if (r1 != r6) goto L_0x008c;
    L_0x0065:
        r1 = r10.e;
        r1 = r1 + r0;
        r1 = r1 + r5;
        r0 = r10.e;
        r0 = r0 + r9;
        r0 = r0 - r1;
        r0 = r0 - r5;
        r12 = r10.a(r1, r0, r7, r12);
        r0 = r10.e;
        r1 = r9 + 1;
        r0 = r0 + r9;
        r0 = r10.b(r0);
        if (r0 != r13) goto L_0x0089;
    L_0x007d:
        r13 = r10.e;
        r1 = r1 - r5;
        r13 = r13 + r1;
        r10.e = r13;
        r10.f();
        r10.n = r2;
        goto L_0x0098;
    L_0x0089:
        r10.n = r3;
        goto L_0x0098;
    L_0x008c:
        r8 = 31;
        r8 = r8 * r7;
        r7 = r8 + r1;
        r8 = 92;
        if (r1 != r8) goto L_0x00a0;
    L_0x0095:
        r10.n = r3;
        goto L_0x004f;
    L_0x0098:
        if (r12 != 0) goto L_0x009b;
    L_0x009a:
        return r4;
    L_0x009b:
        r11 = java.lang.Enum.valueOf(r11, r12);
        return r11;
    L_0x00a0:
        r1 = r9;
        goto L_0x005a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.c.a(java.lang.Class, com.alibaba.fastjson.parser.h, char):java.lang.Enum<?>");
    }
}
