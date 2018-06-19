package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.c.c;
import com.alibaba.fastjson.c.e;
import com.xunlei.common.androidutil.DateTimeUtil;
import java.util.Calendar;
import java.util.TimeZone;

/* compiled from: JSONScanner */
public final class d extends c {
    public final int r;
    public final int s;
    public final int t;
    private final String u;
    private final int v;

    private static boolean a(char c, char c2, char c3, char c4, char c5, char c6, int i, int i2) {
        if ((c == '1' || c == '2') && c2 >= '0') {
            if (c2 <= '9') {
                if (c3 >= '0') {
                    if (c3 <= '9') {
                        if (c4 >= '0') {
                            if (c4 <= '9') {
                                if (c5 == '0') {
                                    if (c6 < '1' || c6 > '9') {
                                        return false;
                                    }
                                } else if (c5 != '1') {
                                    return false;
                                } else {
                                    if (!(c6 == '0' || c6 == '1' || c6 == '2')) {
                                        return false;
                                    }
                                }
                                if (i != 48) {
                                    if (i != 49) {
                                        if (i != 50) {
                                            if (i != 51) {
                                                return false;
                                            }
                                            if (!(i2 == 48 || i2 == 49)) {
                                                return false;
                                            }
                                        }
                                    }
                                    if (i2 >= 48) {
                                        if (i2 > 57) {
                                        }
                                    }
                                    return false;
                                } else if (i2 < 49 || i2 > 57) {
                                    return false;
                                }
                                return true;
                            }
                        }
                        return false;
                    }
                }
                return false;
            }
        }
        return false;
    }

    private static boolean b(char c, char c2, char c3, char c4, char c5, char c6) {
        if (c == '0') {
            if (c2 < '0' || c2 > '9') {
                return false;
            }
        } else if (c != '1') {
            if (c == '2' && c2 >= '0') {
                if (c2 > '4') {
                }
            }
            return false;
        } else if (c2 < '0' || c2 > '9') {
            return false;
        }
        if (c3 < '0' || c3 > '5') {
            if (!(c3 == '6' && c4 == '0')) {
                return false;
            }
        } else if (c4 < '0' || c4 > '9') {
            return false;
        }
        if (c5 < '0' || c5 > '5') {
            if (!(c5 == '6' && c6 == '0')) {
                return false;
            }
        } else if (c6 < '0' || c6 > '9') {
            return false;
        }
        return true;
    }

    public d(String str) {
        this(str, a.DEFAULT_PARSER_FEATURE);
    }

    public d(String str, int i) {
        super(i);
        this.r = 10;
        this.s = 19;
        this.t = 23;
        this.u = str;
        this.v = this.u.length();
        this.e = -1;
        f();
        if (this.d == 65279) {
            f();
        }
    }

    public final char b(int i) {
        if (i >= this.v) {
            return '\u001a';
        }
        return this.u.charAt(i);
    }

    public final char f() {
        int i = this.e + 1;
        this.e = i;
        char b = b(i);
        this.d = b;
        return b;
    }

    public d(char[] cArr, int i, int i2) {
        this(new String(cArr, 0, i), i2);
    }

    protected final void a(int i, int i2, char[] cArr) {
        this.u.getChars(i, i2 + i, cArr, 0);
    }

    private static boolean a(String str, int i, char[] cArr) {
        int length = cArr.length;
        if (length + i > str.length()) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (cArr[i2] != str.charAt(i + i2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean h(char[] cArr) {
        return a(this.u, this.e, cArr);
    }

    public final int c(int i) {
        return this.u.indexOf(34, i);
    }

    public final String a(int i, int i2, int i3, h hVar) {
        return hVar.a(this.u, i, i2, i3);
    }

    public final byte[] v() {
        return e.a(this.u, this.i + 1, this.h);
    }

    public final String l() {
        if (this.j) {
            return new String(this.g, 0, this.h);
        }
        return a(this.i + 1, this.h);
    }

    public final String a(int i, int i2) {
        if (!c.b) {
            return this.u.substring(i, i2 + i);
        }
        if (i2 < this.g.length) {
            this.u.getChars(i, i + i2, this.g, 0);
            return new String(this.g, 0, i2);
        }
        char[] cArr = new char[i2];
        this.u.getChars(i, i2 + i, cArr, 0);
        return new String(cArr);
    }

    public final String u() {
        char b = b((this.i + this.h) - 1);
        int i = this.h;
        if (b == 'L' || b == 'S' || b == 'B' || b == 'F' || b == 'D') {
            i--;
        }
        return a(this.i, i);
    }

    public final boolean D() {
        return b(true);
    }

    public final boolean b(boolean z) {
        char b;
        char b2;
        char b3;
        int i;
        int i2;
        char b4;
        char b5;
        int i3;
        char b6;
        int i4 = this.v - this.e;
        if (!z && i4 > 13) {
            b = b(r9.e);
            char b7 = b(r9.e + 1);
            b2 = b(r9.e + 2);
            char b8 = b(r9.e + 3);
            char b9 = b(r9.e + 4);
            char b10 = b(r9.e + 5);
            b3 = b((r9.e + i4) - 1);
            char b11 = b((r9.e + i4) - 2);
            if (b == '/' && b7 == 'D' && b2 == 'a' && b8 == 't' && b9 == 'e' && b10 == '(' && b3 == '/' && b11 == ')') {
                i = -1;
                for (i2 = 6; i2 < i4; i2++) {
                    b2 = b(r9.e + i2);
                    if (b2 != '+') {
                        if (b2 < '0' || b2 > '9') {
                            break;
                        }
                    } else {
                        i = i2;
                    }
                }
                if (i == -1) {
                    return false;
                }
                i2 = r9.e + 6;
                long parseLong = Long.parseLong(a(i2, i - i2));
                r9.k = Calendar.getInstance(r9.l, r9.m);
                r9.k.setTimeInMillis(parseLong);
                r9.a = 5;
                return true;
            }
        }
        if (!(i4 == 8 || i4 == 14)) {
            if (i4 != 17) {
                if (i4 < r9.r || b(r9.e + 4) != '-' || b(r9.e + 7) != '-') {
                    return false;
                }
                b7 = b(r9.e);
                b2 = b(r9.e + 1);
                b8 = b(r9.e + 2);
                b9 = b(r9.e + 3);
                b4 = b(r9.e + 5);
                char b12 = b(r9.e + 6);
                char b13 = b(r9.e + 8);
                char b14 = b(r9.e + 9);
                if (!a(b7, b2, b8, b9, b4, b12, (int) b13, (int) b14)) {
                    return false;
                }
                boolean z2 = false;
                b3 = '0';
                a(b7, b2, b8, b9, b4, b12, b13, b14);
                b11 = b(r9.e + 10);
                if (b11 != 'T') {
                    if (b11 != ' ' || z) {
                        if (b11 != '\"') {
                            if (b11 != '\u001a') {
                                if (b11 != '+') {
                                    if (b11 != '-') {
                                        return z2;
                                    }
                                }
                                if (r9.v == 16 && b(r9.e + 13) == ':' && b(r9.e + 14) == b3) {
                                    if (b(r9.e + 15) == b3) {
                                        a('0', '0', '0', '0', '0', '0');
                                        r9.k.set(14, z2);
                                        a(b11, b(r9.e + 11), b(r9.e + 12));
                                        return true;
                                    }
                                }
                                return z2;
                            }
                        }
                        r9.k.set(11, z2);
                        r9.k.set(12, z2);
                        r9.k.set(13, z2);
                        r9.k.set(14, z2);
                        i2 = r9.e + 10;
                        r9.e = i2;
                        r9.d = b(i2);
                        r9.a = 5;
                        return true;
                    }
                }
                if (i4 < r9.s || b(r9.e + 13) != ':' || b(r9.e + 16) != ':') {
                    return z2;
                }
                b11 = b(r9.e + 11);
                b5 = b(r9.e + 12);
                b10 = b(r9.e + 14);
                char b15 = b(r9.e + 15);
                b4 = b(r9.e + 17);
                char b16 = b(r9.e + 18);
                if (!b(b11, b5, b10, b15, b4, b16)) {
                    return z2;
                }
                a(b11, b5, b10, b15, b4, b16);
                b = b(r9.e + 19);
                if (b != '.') {
                    r9.k.set(14, z2);
                    i = r9.e + 19;
                    r9.e = i;
                    r9.d = b(i);
                    r9.a = 5;
                    if (b == 'Z' && r9.k.getTimeZone().getRawOffset() != 0) {
                        String[] availableIDs = TimeZone.getAvailableIDs(z2);
                        if (availableIDs.length > 0) {
                            r9.k.setTimeZone(TimeZone.getTimeZone(availableIDs[z2]));
                        }
                    }
                    return true;
                } else if (i4 < r9.t) {
                    return z2;
                } else {
                    b = b(r9.e + 20);
                    if (b >= b3) {
                        if (b <= '9') {
                            int i5;
                            i2 = q[b];
                            b2 = b(r9.e + 21);
                            if (b2 < b3 || b2 > '9') {
                                i3 = i2;
                                i2 = true;
                            } else {
                                i3 = (i2 * 10) + q[b2];
                                i2 = 2;
                            }
                            if (i2 == 2) {
                                b8 = b(r9.e + 22);
                                if (b8 >= b3 && b8 <= '9') {
                                    i3 = (i3 * 10) + q[b8];
                                    i2 = 3;
                                }
                            }
                            r9.k.set(14, i3);
                            b2 = b((r9.e + 20) + i2);
                            if (b2 != '+') {
                                if (b2 != '-') {
                                    if (b2 == 'Z') {
                                        if (r9.k.getTimeZone().getRawOffset() != 0) {
                                            String[] availableIDs2 = TimeZone.getAvailableIDs(z2);
                                            if (availableIDs2.length > 0) {
                                                r9.k.setTimeZone(TimeZone.getTimeZone(availableIDs2[z2]));
                                            }
                                        }
                                        i5 = 1;
                                    } else {
                                        i5 = z2;
                                    }
                                    i = (20 + i2) + i5;
                                    b = b(r9.e + i);
                                    if (b == '\u001a' && b != '\"') {
                                        return z2;
                                    }
                                    i2 = r9.e + i;
                                    r9.e = i2;
                                    r9.d = b(i2);
                                    r9.a = 5;
                                    return true;
                                }
                            }
                            b8 = b(((r9.e + 20) + i2) + 1);
                            if (b8 >= b3) {
                                if (b8 <= '1') {
                                    b9 = b(((r9.e + 20) + i2) + 2);
                                    if (b9 >= b3) {
                                        if (b9 <= '9') {
                                            b6 = b(((r9.e + 20) + i2) + 3);
                                            if (b6 == ':') {
                                                if (b(((r9.e + 20) + i2) + 4) != b3 || b(((r9.e + 20) + i2) + 5) != b3) {
                                                    return z2;
                                                }
                                                i5 = 6;
                                            } else if (b6 != b3) {
                                                i5 = 3;
                                            } else if (b(((r9.e + 20) + i2) + 4) != b3) {
                                                return z2;
                                            } else {
                                                i5 = 5;
                                            }
                                            a(b2, b8, b9);
                                            i = (20 + i2) + i5;
                                            b = b(r9.e + i);
                                            if (b == '\u001a') {
                                            }
                                            i2 = r9.e + i;
                                            r9.e = i2;
                                            r9.d = b(i2);
                                            r9.a = 5;
                                            return true;
                                        }
                                    }
                                    return z2;
                                }
                            }
                            return z2;
                        }
                    }
                    return z2;
                }
            }
        }
        int i6 = 0;
        b3 = '0';
        int i7 = 57;
        if (z) {
            return i6;
        }
        b7 = b(r9.e);
        b2 = b(r9.e + 1);
        b8 = b(r9.e + 2);
        b9 = b(r9.e + 3);
        b6 = b(r9.e + 4);
        char b17 = b(r9.e + 5);
        b5 = b(r9.e + 6);
        char b18 = b(r9.e + 7);
        if (!a(b7, b2, b8, b9, b6, b17, (int) b5, (int) b18)) {
            return i6;
        }
        int i8;
        b11 = b5;
        int i9 = 5;
        a(b7, b2, b8, b9, b6, b17, b11, b18);
        if (i4 != 8) {
            b = b(r9.e + 8);
            b11 = b(r9.e + 9);
            char b19 = b(r9.e + 10);
            b18 = b(r9.e + 11);
            b4 = b(r9.e + 12);
            char b20 = b(r9.e + 13);
            if (!b(b, b11, b19, b18, b4, b20)) {
                return i6;
            }
            if (i4 == 17) {
                b7 = b(r9.e + 14);
                b2 = b(r9.e + 15);
                b8 = b(r9.e + 16);
                if (b7 >= b3) {
                    if (b7 <= '9') {
                        if (b2 >= b3) {
                            if (b2 <= '9') {
                                if (b8 >= b3) {
                                    if (b8 <= '9') {
                                        i8 = ((q[b7] * 100) + (q[b2] * 10)) + q[b8];
                                    }
                                }
                                return i6;
                            }
                        }
                        return i6;
                    }
                }
                return i6;
            }
            i8 = i6;
            i = (q[b19] * 10) + q[b18];
            i3 = (q[b4] * 10) + q[b20];
            i6 = (q[b] * 10) + q[b11];
        } else {
            i = i6;
            i3 = i;
            i8 = i3;
        }
        r9.k.set(11, i6);
        r9.k.set(12, i);
        r9.k.set(13, i3);
        r9.k.set(14, i8);
        r9.a = i9;
        return true;
    }

    private void a(char c, char c2, char c3, char c4, char c5, char c6) {
        c = (q[c] * 10) + q[c2];
        c2 = (q[c3] * 10) + q[c4];
        c3 = (q[c5] * 10) + q[c6];
        this.k.set('\u000b', c);
        this.k.set('\f', c2);
        this.k.set('\r', c3);
    }

    private void a(char c, char c2, char c3) {
        c2 = (((q[c2] * 10) + q[c3]) * DateTimeUtil.HOUR_SECOND) * 1000;
        if (c == '-') {
            c2 = -c2;
        }
        if (this.k.getTimeZone().getRawOffset() != c2) {
            c = TimeZone.getAvailableIDs(c2);
            if (c.length > '\u0000') {
                this.k.setTimeZone(TimeZone.getTimeZone(c['\u0000']));
            }
        }
    }

    private void a(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        this.k = Calendar.getInstance(this.l, this.m);
        c = (((q[c] * 1000) + (q[c2] * 100)) + (q[c3] * 10)) + q[c4];
        c2 = ((q[c5] * 10) + q[c6]) - '\u0001';
        c4 = (q[c7] * 10) + q[c8];
        this.k.set(1, c);
        this.k.set('\u0002', c2);
        this.k.set('\u0005', c4);
    }

    public final boolean B() {
        if (this.e != this.v) {
            if (this.d != '\u001a' || this.e + 1 != this.v) {
                return false;
            }
        }
        return true;
    }

    public final int c(char[] cArr) {
        this.n = 0;
        int i = this.e;
        char c = this.d;
        if (a(this.u, this.e, cArr)) {
            int length = this.e + cArr.length;
            int i2 = length + 1;
            char b = b(length);
            if (b < '0' || b > '9') {
                this.n = -1;
                return 0;
            }
            int i3;
            length = q[b];
            while (true) {
                i3 = i2 + 1;
                cArr = b(i2);
                if (cArr >= 48 && cArr <= 57) {
                    length = (length * 10) + q[cArr];
                    i2 = i3;
                }
            }
            if (cArr == 46) {
                this.n = -1;
                return 0;
            } else if (length < 0) {
                this.n = -1;
                return 0;
            } else {
                if (cArr == 44 || cArr == 125) {
                    this.e = i3 - 1;
                }
                if (cArr == 44) {
                    i2 = this.e + 1;
                    this.e = i2;
                    this.d = b(i2);
                    this.n = 3;
                    this.a = 16;
                    return length;
                }
                if (cArr == 125) {
                    i2 = this.e + 1;
                    this.e = i2;
                    cArr = b(i2);
                    if (cArr == 44) {
                        this.a = 16;
                        i2 = this.e + 1;
                        this.e = i2;
                        this.d = b(i2);
                    } else if (cArr == 93) {
                        this.a = 15;
                        i2 = this.e + 1;
                        this.e = i2;
                        this.d = b(i2);
                    } else if (cArr == 125) {
                        this.a = 13;
                        i2 = this.e + 1;
                        this.e = i2;
                        this.d = b(i2);
                    } else if (cArr == 26) {
                        this.a = 20;
                    } else {
                        this.e = i;
                        this.d = c;
                        this.n = -1;
                        return 0;
                    }
                    this.n = 4;
                }
                return length;
            }
        }
        this.n = -2;
        return 0;
    }

    public final String b(char[] cArr) {
        int i = 0;
        this.n = 0;
        int i2 = this.e;
        char c = this.d;
        if (a(this.u, this.e, cArr)) {
            int length = this.e + cArr.length;
            int i3 = length + 1;
            if (b(length) != '\"') {
                this.n = -1;
                return A();
            }
            length = this.u.indexOf(34, i3);
            if (length == -1) {
                throw new JSONException("unclosed str");
            }
            cArr = a(i3, length - i3);
            for (int i4 = 0; i4 < cArr.length(); i4++) {
                if (cArr.charAt(i4) == '\\') {
                    i = 1;
                    break;
                }
            }
            if (i != 0) {
                this.n = -1;
                return A();
            }
            length++;
            char b = b(length);
            if (b != ',') {
                if (b != '}') {
                    this.n = -1;
                    return A();
                }
            }
            this.e = length;
            this.d = b;
            if (b == ',') {
                i = this.e + 1;
                this.e = i;
                this.d = b(i);
                this.n = 3;
                return cArr;
            } else if (b == '}') {
                i = this.e + 1;
                this.e = i;
                b = b(i);
                if (b == ',') {
                    this.a = 16;
                    i = this.e + 1;
                    this.e = i;
                    this.d = b(i);
                } else if (b == ']') {
                    this.a = 15;
                    i = this.e + 1;
                    this.e = i;
                    this.d = b(i);
                } else if (b == '}') {
                    this.a = 13;
                    i = this.e + 1;
                    this.e = i;
                    this.d = b(i);
                } else if (b == '\u001a') {
                    this.a = 20;
                } else {
                    this.e = i2;
                    this.d = c;
                    this.n = -1;
                    return A();
                }
                this.n = 4;
                return cArr;
            } else {
                this.n = -1;
                return A();
            }
        }
        this.n = -2;
        return A();
    }

    public final String a(char[] cArr, h hVar) {
        this.n = 0;
        if (a(this.u, this.e, cArr)) {
            int length = this.e + cArr.length;
            cArr = length + 1;
            if (b(length) != '\"') {
                this.n = -1;
                return null;
            }
            int i;
            char b;
            length = 0;
            int i2 = cArr;
            while (true) {
                i = i2 + 1;
                b = b(i2);
                if (b == '\"') {
                    break;
                }
                length = (31 * length) + b;
                if (b == '\\') {
                    this.n = -1;
                    return null;
                }
                i2 = i;
            }
            this.e = i;
            b = b(this.e);
            this.d = b;
            cArr = hVar.a(this.u, cArr, (i - cArr) - 1, length);
            int i3;
            if (b == ',') {
                i3 = this.e + 1;
                this.e = i3;
                this.d = b(i3);
                this.n = 3;
                return cArr;
            } else if (b == '}') {
                i2 = this.e + 1;
                this.e = i2;
                b = b(i2);
                if (b == ',') {
                    this.a = 16;
                    i3 = this.e + 1;
                    this.e = i3;
                    this.d = b(i3);
                } else if (b == ']') {
                    this.a = 15;
                    i3 = this.e + 1;
                    this.e = i3;
                    this.d = b(i3);
                } else if (b == '}') {
                    this.a = 13;
                    i3 = this.e + 1;
                    this.e = i3;
                    this.d = b(i3);
                } else if (b == '\u001a') {
                    this.a = 20;
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

    public final long e(char[] cArr) {
        this.n = 0;
        int i = this.e;
        char c = this.d;
        if (a(this.u, this.e, cArr)) {
            int length = this.e + cArr.length;
            int i2 = length + 1;
            char b = b(length);
            if (b < '0' || b > '9') {
                this.e = i;
                this.d = c;
                this.n = -1;
                return 0;
            }
            long j = (long) q[b];
            while (true) {
                length = i2 + 1;
                cArr = b(i2);
                if (cArr >= 48 && cArr <= 57) {
                    i2 = length;
                    j = (j * 10) + ((long) q[cArr]);
                }
            }
            if (cArr == 46) {
                this.n = -1;
                return 0;
            }
            if (cArr == 44 || cArr == 125) {
                this.e = length - 1;
            }
            if (j < 0) {
                this.e = i;
                this.d = c;
                this.n = -1;
                return 0;
            } else if (cArr == 44) {
                i2 = this.e + 1;
                this.e = i2;
                this.d = b(i2);
                this.n = 3;
                this.a = 16;
                return j;
            } else if (cArr == 125) {
                i2 = this.e + 1;
                this.e = i2;
                cArr = b(i2);
                if (cArr == 44) {
                    this.a = 16;
                    i2 = this.e + 1;
                    this.e = i2;
                    this.d = b(i2);
                } else if (cArr == 93) {
                    this.a = 15;
                    i2 = this.e + 1;
                    this.e = i2;
                    this.d = b(i2);
                } else if (cArr == 125) {
                    this.a = 13;
                    i2 = this.e + 1;
                    this.e = i2;
                    this.d = b(i2);
                } else if (cArr == 26) {
                    this.a = 20;
                } else {
                    this.e = i;
                    this.d = c;
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

    public final boolean d(char[] cArr) {
        this.n = 0;
        if (a(this.u, this.e, cArr)) {
            boolean z;
            int length = this.e + cArr.length;
            int i = length + 1;
            char b = b(length);
            if (b == 't') {
                length = i + 1;
                if (b(i) != 114) {
                    this.n = -1;
                    return false;
                }
                i = length + 1;
                if (b(length) != 'u') {
                    this.n = -1;
                    return false;
                }
                length = i + 1;
                if (b(i) != 101) {
                    this.n = -1;
                    return false;
                }
                this.e = length;
                cArr = b(this.e);
                z = true;
            } else if (b == 'f') {
                length = i + 1;
                if (b(i) != 97) {
                    this.n = -1;
                    return false;
                }
                i = length + 1;
                if (b(length) != 'l') {
                    this.n = -1;
                    return false;
                }
                length = i + 1;
                if (b(i) != 115) {
                    this.n = -1;
                    return false;
                }
                cArr = length + 1;
                if (b(length) != 'e') {
                    this.n = -1;
                    return false;
                }
                this.e = cArr;
                cArr = b(this.e);
                z = false;
            } else {
                this.n = -1;
                return false;
            }
            if (cArr == 44) {
                i = this.e + 1;
                this.e = i;
                this.d = b(i);
                this.n = 3;
                this.a = 16;
            } else if (cArr == 125) {
                i = this.e + 1;
                this.e = i;
                cArr = b(i);
                if (cArr == 44) {
                    this.a = 16;
                    i = this.e + 1;
                    this.e = i;
                    this.d = b(i);
                } else if (cArr == 93) {
                    this.a = 15;
                    i = this.e + 1;
                    this.e = i;
                    this.d = b(i);
                } else if (cArr == 125) {
                    this.a = 13;
                    i = this.e + 1;
                    this.e = i;
                    this.d = b(i);
                } else if (cArr == 26) {
                    this.a = 20;
                } else {
                    this.n = -1;
                    return false;
                }
                this.n = 4;
            } else {
                this.n = -1;
                return false;
            }
            return z;
        }
        this.n = -2;
        return false;
    }

    protected final void a(int i, char[] cArr, int i2) {
        this.u.getChars(i, i2 + i, cArr, 0);
    }

    public final String z() {
        String str;
        StringBuilder stringBuilder = new StringBuilder("pos ");
        stringBuilder.append(this.e);
        stringBuilder.append(", json : ");
        if (this.u.length() < 65536) {
            str = this.u;
        } else {
            str = this.u.substring(0, 65536);
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
