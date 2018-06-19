package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.c.e;
import com.qihoo360.replugin.RePlugin;
import java.io.IOException;
import java.io.Writer;
import java.lang.ref.SoftReference;
import java.nio.charset.Charset;

/* compiled from: SerializeWriter */
public final class ax extends Writer {
    private static final ThreadLocal<SoftReference<char[]>> y = new ThreadLocal();
    protected char[] a;
    protected SoftReference<char[]> b;
    protected int c;
    protected int d;
    protected boolean e;
    protected boolean f;
    protected boolean g;
    protected boolean h;
    protected boolean i;
    protected boolean j;
    protected boolean k;
    protected boolean l;
    protected boolean m;
    protected boolean n;
    protected boolean o;
    protected boolean p;
    protected boolean q;
    protected boolean r;
    protected boolean s;
    protected boolean t;
    protected boolean u;
    protected boolean v;
    protected boolean w;
    protected char x;
    private final Writer z;

    public final /* synthetic */ Writer append(CharSequence charSequence) throws IOException {
        return a(charSequence);
    }

    public final /* synthetic */ Writer append(CharSequence charSequence, int i, int i2) throws IOException {
        return a(charSequence, i, i2);
    }

    public final /* synthetic */ Appendable m1append(CharSequence charSequence) throws IOException {
        return a(charSequence);
    }

    public final /* synthetic */ Appendable m2append(CharSequence charSequence, int i, int i2) throws IOException {
        return a(charSequence, i, i2);
    }

    public ax() {
        this(null);
    }

    public ax(Writer writer) {
        this.z = writer;
        this.d = a.DEFAULT_GENERATE_FEATURE;
        a();
        this.b = (SoftReference) y.get();
        if (this.b != null) {
            this.a = (char[]) this.b.get();
            y.set(null);
        }
        if (this.a == null) {
            this.a = new char[1024];
        }
    }

    public ax(int i, SerializerFeature... serializerFeatureArr) {
        this.z = null;
        this.b = (SoftReference) y.get();
        if (this.b != null) {
            this.a = (char[]) this.b.get();
            y.set(null);
        }
        if (this.a == null) {
            this.a = new char[1024];
        }
        for (SerializerFeature mask : serializerFeatureArr) {
            i |= mask.getMask();
        }
        this.d = i;
        a();
    }

    public final void a(SerializerFeature serializerFeature) {
        this.d |= serializerFeature.getMask();
        if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
            this.d &= SerializerFeature.WriteEnumUsingName.getMask() ^ -1;
        } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
            this.d &= SerializerFeature.WriteEnumUsingToString.getMask() ^ -1;
        }
        a();
    }

    private void a() {
        boolean z = false;
        this.e = (this.d & SerializerFeature.BrowserSecure.mask) != 0;
        this.f = (this.d & SerializerFeature.BrowserCompatible.mask) != 0;
        this.h = (this.d & SerializerFeature.QuoteFieldNames.mask) != 0;
        this.g = (this.d & SerializerFeature.UseSingleQuotes.mask) != 0;
        this.i = (this.d & SerializerFeature.SortField.mask) != 0;
        this.j = (this.d & SerializerFeature.DisableCircularReferenceDetect.mask) != 0;
        this.k = (this.d & SerializerFeature.BeanToArray.mask) != 0;
        this.l = (this.d & SerializerFeature.PrettyFormat.mask) != 0;
        this.m = (this.d & SerializerFeature.WriteClassName.mask) != 0;
        this.o = (this.d & SerializerFeature.NotWriteRootClassName.mask) != 0;
        this.n = (this.d & SerializerFeature.SkipTransientField.mask) != 0;
        this.p = (this.d & SerializerFeature.IgnoreNonFieldGetter.mask) != 0;
        this.q = (this.d & SerializerFeature.WriteNonStringValueAsString.mask) != 0;
        this.r = (this.d & SerializerFeature.NotWriteDefaultValue.mask) != 0;
        this.s = (this.d & SerializerFeature.WriteEnumUsingName.mask) != 0;
        this.t = (this.d & SerializerFeature.WriteEnumUsingToString.mask) != 0;
        this.u = (this.d & SerializerFeature.WriteMapNullValue.mask) != 0;
        this.v = (this.d & SerializerFeature.DisableCheckSpecialChar.mask) != 0;
        if (!(!this.h || this.g || this.f || this.e || this.f || !this.s || this.t || this.q || (this.d & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
            z = true;
        }
        this.w = z;
        this.x = this.g ? '\'' : '\"';
    }

    public final boolean b(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.d) != null ? true : null;
    }

    public final void write(int i) {
        int i2 = this.c + 1;
        if (i2 > this.a.length) {
            if (this.z == null) {
                b(i2);
            } else {
                flush();
                i2 = 1;
            }
        }
        this.a[this.c] = (char) i;
        this.c = i2;
    }

    public final void write(char[] cArr, int i, int i2) {
        if (i >= 0 && i <= cArr.length && i2 >= 0) {
            int i3 = i + i2;
            if (i3 <= cArr.length) {
                if (i3 >= 0) {
                    if (i2 != 0) {
                        i3 = this.c + i2;
                        if (i3 > this.a.length) {
                            if (this.z == null) {
                                b(i3);
                            } else {
                                do {
                                    i3 = this.a.length - this.c;
                                    System.arraycopy(cArr, i, this.a, this.c, i3);
                                    this.c = this.a.length;
                                    flush();
                                    i2 -= i3;
                                    i += i3;
                                } while (i2 > this.a.length);
                                i3 = i2;
                            }
                        }
                        System.arraycopy(cArr, i, this.a, this.c, i2);
                        this.c = i3;
                        return;
                    }
                    return;
                }
            }
        }
        throw new IndexOutOfBoundsException();
    }

    private void b(int i) {
        int length = ((this.a.length * 3) / 2) + 1;
        if (length >= i) {
            i = length;
        }
        i = new char[i];
        System.arraycopy(this.a, 0, i, 0, this.c);
        this.a = i;
    }

    public final void write(String str, int i, int i2) {
        int i3 = this.c + i2;
        if (i3 > this.a.length) {
            if (this.z == null) {
                b(i3);
            } else {
                int i4;
                while (true) {
                    i3 = this.a.length - this.c;
                    i4 = i + i3;
                    str.getChars(i, i4, this.a, this.c);
                    this.c = this.a.length;
                    flush();
                    i2 -= i3;
                    if (i2 <= this.a.length) {
                        break;
                    }
                    i = i4;
                }
                i3 = i2;
                i = i4;
            }
        }
        str.getChars(i, i2 + i, this.a, this.c);
        this.c = i3;
    }

    public final ax a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "null" : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    private ax a(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i, i2).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public final byte[] a(String str) {
        if (this.z != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        au auVar = new au(Charset.forName(str));
        str = this.a;
        int i = this.c;
        if (i == 0) {
            return new byte[null];
        }
        byte[] a;
        auVar.a.reset();
        int maxBytesPerChar = (int) (((double) i) * ((double) auVar.a.maxBytesPerChar()));
        SoftReference softReference = (SoftReference) au.b.get();
        if (softReference == null) {
            a = au.a(maxBytesPerChar);
        } else {
            byte[] bArr = (byte[]) softReference.get();
            if (bArr == null) {
                a = au.a(maxBytesPerChar);
            } else if (bArr.length < maxBytesPerChar) {
                a = au.a(maxBytesPerChar);
            } else {
                a = bArr;
            }
        }
        return auVar.a(str, i, a);
    }

    public final String toString() {
        return new String(this.a, 0, this.c);
    }

    public final void close() {
        if (this.z != null && this.c > 0) {
            flush();
        }
        if (this.a.length <= 8192) {
            Object obj;
            if (this.b != null) {
                if (this.b.get() == this.a) {
                    obj = this.b;
                    y.set(obj);
                }
            }
            obj = new SoftReference(this.a);
            y.set(obj);
        }
        this.a = null;
    }

    public final void write(String str) {
        while (str == null) {
            str = "null";
        }
        write(str, 0, str.length());
    }

    public final void a(int i) {
        if (i == Integer.MIN_VALUE) {
            write(RePlugin.PROCESS_AUTO);
            return;
        }
        int a = i < 0 ? e.a(-i) + 1 : e.a(i);
        int i2 = this.c + a;
        if (i2 > this.a.length) {
            if (this.z == null) {
                b(i2);
            } else {
                char[] cArr = new char[a];
                e.a(i, a, cArr);
                write(cArr, 0, cArr.length);
                return;
            }
        }
        e.a(i, i2, this.a);
        this.c = i2;
    }

    public final void a(byte[] bArr) {
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        int i = this.g ? '\'' : '\"';
        if (length == 0) {
            write(r0.g ? "''" : "\"\"");
            return;
        }
        char[] cArr = e.n;
        int i2 = (length / 3) * 3;
        int i3 = length - 1;
        int i4 = ((i3 / 3) + 1) << 2;
        int i5 = r0.c;
        int i6 = (r0.c + i4) + 2;
        int i7 = 0;
        if (i6 > r0.a.length) {
            if (r0.z != null) {
                write(i);
                i4 = 0;
                while (i4 < i2) {
                    i5 = i4 + 1;
                    i6 = i5 + 1;
                    i4 = ((bArr2[i4] & 255) << 16) | ((bArr2[i5] & 255) << 8);
                    i5 = i6 + 1;
                    i4 |= bArr2[i6] & 255;
                    write(cArr[(i4 >>> 18) & 63]);
                    write(cArr[(i4 >>> 12) & 63]);
                    write(cArr[(i4 >>> 6) & 63]);
                    write(cArr[i4 & 63]);
                    i4 = i5;
                }
                length -= i2;
                if (length > 0) {
                    i2 = (bArr2[i2] & 255) << 10;
                    if (length == 2) {
                        i7 = (bArr2[i3] & 255) << 2;
                    }
                    int i8 = i2 | i7;
                    write(cArr[i8 >> 12]);
                    write(cArr[(i8 >>> 6) & 63]);
                    write(length == 2 ? cArr[i8 & 63] : 61);
                    write(61);
                }
                write(i);
                return;
            }
            b(i6);
        }
        r0.c = i6;
        int i9 = i5 + 1;
        r0.a[i5] = i;
        i4 = 0;
        while (i4 < i2) {
            i5 = i4 + 1;
            int i10 = i5 + 1;
            i4 = ((bArr2[i4] & 255) << 16) | ((bArr2[i5] & 255) << 8);
            i5 = i10 + 1;
            i4 |= bArr2[i10] & 255;
            int i11 = i9 + 1;
            r0.a[i9] = cArr[(i4 >>> 18) & 63];
            i10 = i11 + 1;
            r0.a[i11] = cArr[(i4 >>> 12) & 63];
            i11 = i10 + 1;
            r0.a[i10] = cArr[(i4 >>> 6) & 63];
            i10 = i11 + 1;
            r0.a[i11] = cArr[i4 & 63];
            i4 = i5;
            i9 = i10;
        }
        length -= i2;
        if (length > 0) {
            i2 = (bArr2[i2] & 255) << 10;
            if (length == 2) {
                i7 = (bArr2[i3] & 255) << 2;
            }
            i8 = i2 | i7;
            r0.a[i6 - 5] = cArr[i8 >> 12];
            r0.a[i6 - 4] = cArr[(i8 >>> 6) & 63];
            r0.a[i6 - 3] = length == 2 ? cArr[i8 & 63] : '=';
            r0.a[i6 - 2] = '=';
        }
        r0.a[i6 - 1] = i;
    }

    public final void a(long j, char c) throws IOException {
        int i = (!this.f || b(SerializerFeature.WriteClassName) || (j <= 9007199254740991L && j >= -9007199254740991L)) ? 0 : 1;
        if (j == Long.MIN_VALUE) {
            if (i != 0) {
                write("\"-9223372036854775808\"");
            } else {
                write("-9223372036854775808");
            }
            write((int) c);
            return;
        }
        int a = this.c + (j < 0 ? e.a(-j) + 1 : e.a(j));
        if (i != 0) {
            a += 2;
        }
        int i2 = a + 1;
        if (i2 > this.a.length) {
            if (this.z != null) {
                a(j);
                write((int) c);
                return;
            }
            b(i2);
        }
        if (i != 0) {
            this.a[this.c] = '\"';
            i = a - 1;
            e.a(j, i, this.a);
            this.a[i] = 34;
        } else {
            e.a(j, a, this.a);
        }
        this.a[a] = c;
        this.c = i2;
    }

    public final void a(long j) {
        int i = (!this.f || b(SerializerFeature.WriteClassName) || (j <= 9007199254740991L && j >= -9007199254740991L)) ? 0 : 1;
        if (j != Long.MIN_VALUE) {
            int a = j < 0 ? e.a(-j) + 1 : e.a(j);
            int i2 = this.c + a;
            if (i != 0) {
                i2 += 2;
            }
            if (i2 > this.a.length) {
                if (this.z == null) {
                    b(i2);
                } else {
                    char[] cArr = new char[a];
                    e.a(j, a, cArr);
                    if (i != 0) {
                        write(34);
                        write(cArr, 0, cArr.length);
                        write(34);
                        return;
                    }
                    write(cArr, 0, cArr.length);
                    return;
                }
            }
            if (i != 0) {
                this.a[this.c] = '\"';
                i = i2 - 1;
                e.a(j, i, this.a);
                this.a[i] = 34;
            } else {
                e.a(j, i2, this.a);
            }
            this.c = i2;
        } else if (i != 0) {
            write("\"-9223372036854775808\"");
        } else {
            write("-9223372036854775808");
        }
    }

    public final void a(char c, String str, int i) {
        if (i != Integer.MIN_VALUE) {
            if (this.h) {
                int a = i < 0 ? e.a(-i) + 1 : e.a(i);
                int length = str.length();
                int i2 = ((this.c + length) + 4) + a;
                if (i2 > this.a.length) {
                    if (this.z != null) {
                        b(c, str, i);
                        return;
                    }
                    b(i2);
                }
                a = this.c;
                this.c = i2;
                this.a[a] = c;
                c = (a + length) + 1;
                this.a[a + 1] = this.x;
                str.getChars(0, length, this.a, a + 2);
                this.a[c + 1] = this.x;
                this.a[c + 2] = ':';
                e.a(i, this.c, this.a);
                return;
            }
        }
        b(c, str, i);
    }

    private void b(char c, String str, int i) {
        write((int) c);
        e(str);
        a(i);
    }

    public final void a(String str, long j) {
        if (j != Long.MIN_VALUE) {
            if (this.h) {
                int a = j < 0 ? e.a(-j) + 1 : e.a(j);
                int length = str.length();
                int i = ((this.c + length) + 4) + a;
                if (i > this.a.length) {
                    if (this.z != null) {
                        write(44);
                        e(str);
                        a(j);
                        return;
                    }
                    b(i);
                }
                a = this.c;
                this.c = i;
                this.a[a] = ',';
                int i2 = (a + length) + 1;
                this.a[a + 1] = this.x;
                str.getChars(0, length, this.a, a + 2);
                this.a[i2 + 1] = this.x;
                this.a[i2 + 2] = ':';
                e.a(j, this.c, this.a);
                return;
            }
        }
        write(44);
        e(str);
        a(j);
    }

    public final void a(char c, String str, double d) {
        write((int) c);
        e(str);
        if (d == '\u0000') {
            write((int) '0');
        } else if (Double.isNaN(d) != '\u0000') {
            write("null");
        } else if (Double.isInfinite(d) != '\u0000') {
            write("null");
        } else {
            String d2 = Double.toString(d);
            if (d2.endsWith(".0") != null) {
                d2 = d2.substring(null, d2.length() - 2);
            }
            write(d2);
        }
    }

    public final void a(char c, String str, String str2) {
        String str3 = str;
        String str4 = str2;
        if (!this.h) {
            write((int) c);
            e(str3);
            if (str4 == null) {
                write("null");
            } else {
                b(str4);
            }
        } else if (r0.g) {
            write((int) c);
            e(str3);
            if (str4 == null) {
                write("null");
            } else {
                b(str4);
            }
        } else if (r0.e) {
            write((int) c);
            a(str3, ':');
            a(str4, '\u0000');
        } else if (r0.f) {
            write((int) c);
            a(str3, ':');
            a(str4, '\u0000');
        } else {
            int i;
            int length = str.length();
            int i2 = r0.c;
            if (str4 == null) {
                i2 += length + 8;
                i = 4;
            } else {
                i = str2.length();
                i2 += (length + i) + 6;
            }
            if (i2 > r0.a.length) {
                if (r0.z != null) {
                    write((int) c);
                    a(str3, ':');
                    a(str4, '\u0000');
                    return;
                }
                b(i2);
            }
            r0.a[r0.c] = c;
            int i3 = r0.c + 2;
            int i4 = i3 + length;
            r0.a[r0.c + 1] = '\"';
            str3.getChars(0, length, r0.a, i3);
            r0.c = i2;
            r0.a[i4] = '\"';
            i4++;
            length = i4 + 1;
            r0.a[i4] = ':';
            int i5;
            if (str4 == null) {
                int i6 = length + 1;
                r0.a[length] = 'n';
                length = i6 + 1;
                r0.a[i6] = 'u';
                i5 = length + 1;
                r0.a[length] = 'l';
                r0.a[i5] = 'l';
                return;
            }
            i3 = length + 1;
            r0.a[length] = '\"';
            length = i3 + i;
            str4.getChars(0, i, r0.a, i3);
            if (!r0.v) {
                i4 = -1;
                int i7 = i4;
                int i8 = 0;
                i = i2;
                i2 = i8;
                for (int i9 = i3; i9 < length; i9++) {
                    char c2 = r0.a[i9];
                    if (c2 >= ']') {
                        if (c2 >= '' && (c2 == ' ' || c2 <= ' ')) {
                            if (i4 == -1) {
                                i4 = i9;
                            }
                            i2++;
                            i += 4;
                        }
                    } else if (a(c2, r0.d)) {
                        i2++;
                        if (c2 < e.d.length && e.d[c2] == (byte) 4) {
                            i += 4;
                        }
                        if (i4 == -1) {
                            i4 = i9;
                            i7 = i4;
                            i8 = c2;
                        }
                    } else {
                    }
                    i7 = i9;
                    i8 = c2;
                }
                if (i2 > 0) {
                    i += i2;
                    if (i > r0.a.length) {
                        b(i);
                    }
                    r0.c = i;
                    if (i2 == 1) {
                        if (i8 == 8232) {
                            i5 = i7 + 1;
                            System.arraycopy(r0.a, i5, r0.a, i7 + 6, (length - i7) - 1);
                            r0.a[i7] = '\\';
                            r0.a[i5] = 'u';
                            i5++;
                            r0.a[i5] = '2';
                            i5++;
                            r0.a[i5] = '0';
                            i5++;
                            r0.a[i5] = '2';
                            r0.a[i5 + 1] = '8';
                        } else if (i8 >= e.d.length || e.d[i8] != (byte) 4) {
                            i5 = i7 + 1;
                            System.arraycopy(r0.a, i5, r0.a, i7 + 2, (length - i7) - 1);
                            r0.a[i7] = '\\';
                            r0.a[i5] = e.h[i8];
                        } else {
                            i5 = i7 + 1;
                            System.arraycopy(r0.a, i5, r0.a, i7 + 6, (length - i7) - 1);
                            r0.a[i7] = '\\';
                            length = i5 + 1;
                            r0.a[i5] = 'u';
                            i5 = length + 1;
                            r0.a[length] = e.a[(i8 >>> 12) & 15];
                            length = i5 + 1;
                            r0.a[i5] = e.a[(i8 >>> 8) & 15];
                            i5 = length + 1;
                            r0.a[length] = e.a[(i8 >>> 4) & 15];
                            r0.a[i5] = e.a[i8 & 15];
                        }
                    } else if (i2 > 1) {
                        for (length = i4 - i3; length < str2.length(); length++) {
                            char charAt = str4.charAt(length);
                            if ((charAt < e.d.length && e.d[charAt] != (byte) 0) || (charAt == '/' && b(SerializerFeature.WriteSlashAsSpecial))) {
                                i2 = i4 + 1;
                                r0.a[i4] = '\\';
                                if (e.d[charAt] == (byte) 4) {
                                    i = i2 + 1;
                                    r0.a[i2] = 'u';
                                    i2 = i + 1;
                                    r0.a[i] = e.a[(charAt >>> 12) & 15];
                                    i = i2 + 1;
                                    r0.a[i2] = e.a[(charAt >>> 8) & 15];
                                    i2 = i + 1;
                                    r0.a[i] = e.a[(charAt >>> 4) & 15];
                                    i = i2 + 1;
                                    r0.a[i2] = e.a[charAt & 15];
                                } else {
                                    i = i2 + 1;
                                    r0.a[i2] = e.h[charAt];
                                }
                                i4 = i;
                            } else if (charAt == ' ') {
                                i2 = i4 + 1;
                                r0.a[i4] = '\\';
                                i = i2 + 1;
                                r0.a[i2] = 'u';
                                i2 = i + 1;
                                r0.a[i] = e.a[(charAt >>> 12) & 15];
                                i = i2 + 1;
                                r0.a[i2] = e.a[(charAt >>> 8) & 15];
                                i2 = i + 1;
                                r0.a[i] = e.a[(charAt >>> 4) & 15];
                                i = i2 + 1;
                                r0.a[i2] = e.a[charAt & 15];
                                i4 = i;
                            } else {
                                i2 = i4 + 1;
                                r0.a[i4] = charAt;
                                i4 = i2;
                            }
                        }
                    }
                }
            }
            r0.a[r0.c - 1] = '\"';
        }
    }

    private static boolean a(char c, int i) {
        if (c == ' ') {
            return false;
        }
        if (c == '/') {
            return (SerializerFeature.WriteSlashAsSpecial.mask & i) != '\u0000';
        } else {
            if (c > '#' && c != '\\') {
                return false;
            }
            if (c > '\u001f' && c != '\\') {
                if (c != '\"') {
                    return false;
                }
            }
            return true;
        }
    }

    public final void b(String str) {
        if (this.g) {
            c(str);
        } else {
            a(str, '\u0000');
        }
    }

    protected final void c(String str) {
        int i = 0;
        if (str == null) {
            int i2 = this.c + 4;
            if (i2 > this.a.length) {
                b(i2);
            }
            "null".getChars(0, 4, this.a, this.c);
            this.c = i2;
            return;
        }
        int length = str.length();
        int i3 = (this.c + length) + 2;
        if (i3 > this.a.length) {
            if (this.z != null) {
                write(39);
                while (i < str.length()) {
                    length = str.charAt(i);
                    if (!(length <= '\r' || length == '\\' || length == '\'')) {
                        if (length != '/' || !b(SerializerFeature.WriteSlashAsSpecial)) {
                            write(length);
                            i++;
                        }
                    }
                    write(92);
                    write(e.h[length]);
                    i++;
                }
                write(39);
                return;
            }
            b(i3);
        }
        int i4 = this.c + 1;
        int i5 = i4 + length;
        this.a[this.c] = '\'';
        str.getChars(0, length, this.a, i4);
        this.c = i3;
        length = -1;
        int i6 = 0;
        for (str = i4; str < i5; str++) {
            char c = this.a[str];
            if (c <= '\r' || c == '\\' || c == '\'' || (c == '/' && b(SerializerFeature.WriteSlashAsSpecial))) {
                i++;
                length = str;
                i6 = c;
            }
        }
        i3 += i;
        if (i3 > this.a.length) {
            b(i3);
        }
        this.c = i3;
        if (i == 1) {
            i = length + 1;
            System.arraycopy(this.a, i, this.a, length + 2, (i5 - length) - 1);
            this.a[length] = 92;
            this.a[i] = e.h[i6];
        } else if (i > 1) {
            i = length + 1;
            System.arraycopy(this.a, i, this.a, length + 2, (i5 - length) - 1);
            this.a[length] = 92;
            this.a[i] = e.h[i6];
            i5++;
            for (i -= 2; i >= i4; i--) {
                str = this.a[i];
                if (str <= 13 || str == 92 || str == 39 || (str == 47 && b(SerializerFeature.WriteSlashAsSpecial))) {
                    i3 = i + 1;
                    System.arraycopy(this.a, i3, this.a, i + 2, (i5 - i) - 1);
                    this.a[i] = '\\';
                    this.a[i3] = e.h[str];
                    i5++;
                }
            }
        }
        this.a[this.c - 1] = 39;
    }

    public final void d(String str) {
        e(str);
    }

    public final void e(String str) {
        ax axVar = this;
        String str2 = str;
        if (str2 == null) {
            write("null:");
            return;
        }
        int i = 0;
        int i2 = 1;
        int i3;
        int i4;
        if (!axVar.g) {
            char c = ':';
            if (axVar.h) {
                a(str2, c);
                return;
            }
            i3 = str.length() == 0 ? 1 : 0;
            for (i4 = 0; i4 < str.length(); i4++) {
                if (a(str2.charAt(i4), 0)) {
                    i3 = 1;
                    break;
                }
            }
            if (i3 != 0) {
                a(str2, ':');
                return;
            }
            write(str);
            write(58);
        } else if (axVar.h) {
            c(str);
            write(58);
        } else {
            byte[] bArr = e.e;
            int length = str.length();
            int i5 = (axVar.c + length) + 1;
            char c2 = '\'';
            if (i5 > axVar.a.length) {
                if (axVar.z == null) {
                    b(i5);
                } else if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                } else {
                    for (i5 = 0; i5 < length; i5++) {
                        char charAt = str2.charAt(i5);
                        if (charAt < bArr.length && bArr[charAt] != (byte) 0) {
                            break;
                        }
                    }
                    i2 = 0;
                    if (i2 != 0) {
                        write(39);
                    }
                    while (i < length) {
                        i5 = str2.charAt(i);
                        if (i5 >= bArr.length || bArr[i5] == (byte) 0) {
                            write(i5);
                        } else {
                            write(92);
                            write(e.h[i5]);
                        }
                        i++;
                    }
                    if (i2 != 0) {
                        write(39);
                    }
                    write(58);
                    return;
                }
            }
            if (length == 0) {
                if (axVar.c + 3 > axVar.a.length) {
                    b(axVar.c + 3);
                }
                char[] cArr = axVar.a;
                i3 = axVar.c;
                axVar.c = i3 + 1;
                cArr[i3] = '\'';
                cArr = axVar.a;
                i3 = axVar.c;
                axVar.c = i3 + 1;
                cArr[i3] = '\'';
                cArr = axVar.a;
                i3 = axVar.c;
                axVar.c = i3 + 1;
                cArr[i3] = ':';
                return;
            }
            int i6 = axVar.c;
            int i7 = i6 + length;
            str2.getChars(0, length, axVar.a, i6);
            axVar.c = i5;
            length = 0;
            int i8 = i6;
            while (i8 < i7) {
                int i9;
                char c3 = axVar.a[i8];
                if (c3 >= bArr.length || bArr[c3] == (byte) 0) {
                    i9 = i8;
                } else if (length == 0) {
                    i5 += 3;
                    if (i5 > axVar.a.length) {
                        b(i5);
                    }
                    axVar.c = i5;
                    i9 = i8 + 1;
                    System.arraycopy(axVar.a, i9, axVar.a, i8 + 3, (i7 - i8) - 1);
                    System.arraycopy(axVar.a, 0, axVar.a, 1, i8);
                    axVar.a[i6] = c2;
                    axVar.a[i9] = '\\';
                    i4 = i9 + 1;
                    axVar.a[i4] = e.h[c3];
                    i7 += 2;
                    axVar.a[axVar.c - 2] = c2;
                    i9 = i4;
                    length = 1;
                } else {
                    i5++;
                    if (i5 > axVar.a.length) {
                        b(i5);
                    }
                    axVar.c = i5;
                    i9 = i8 + 1;
                    System.arraycopy(axVar.a, i9, axVar.a, i8 + 2, i7 - i8);
                    axVar.a[i8] = '\\';
                    axVar.a[i9] = e.h[c3];
                    i7++;
                }
                i8 = i9 + 1;
                c2 = '\'';
            }
            axVar.a[i5 - 1] = ':';
        }
    }

    public final void flush() {
        if (this.z != null) {
            try {
                this.z.write(this.a, 0, this.c);
                this.z.flush();
                this.c = 0;
            } catch (Throwable e) {
                throw new JSONException(e.getMessage(), e);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r20, char r21) {
        /*
        r19 = this;
        r0 = r19;
        r1 = r20;
        r2 = r21;
        if (r1 != 0) goto L_0x0013;
    L_0x0008:
        r1 = "null";
        r0.write(r1);
        if (r2 == 0) goto L_0x0012;
    L_0x000f:
        r0.write(r2);
    L_0x0012:
        return;
    L_0x0013:
        r3 = r20.length();
        r4 = r0.c;
        r4 = r4 + r3;
        r4 = r4 + 2;
        if (r2 == 0) goto L_0x0020;
    L_0x001e:
        r4 = r4 + 1;
    L_0x0020:
        r5 = r0.a;
        r6 = 0;
        r7 = 47;
        r8 = 48;
        r9 = 8;
        r10 = 12;
        r11 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        r12 = 34;
        r13 = 4;
        r14 = 92;
        r15 = 1;
        r5 = r5.length;
        if (r4 <= r5) goto L_0x0184;
    L_0x0036:
        r5 = r0.z;
        if (r5 == 0) goto L_0x0181;
    L_0x003a:
        r0.write(r12);
    L_0x003d:
        r3 = r20.length();
        if (r6 >= r3) goto L_0x0178;
    L_0x0043:
        r3 = r1.charAt(r6);
        r4 = r0.e;
        if (r4 == 0) goto L_0x009f;
    L_0x004b:
        if (r3 < r8) goto L_0x0051;
    L_0x004d:
        r4 = 57;
        if (r3 <= r4) goto L_0x0171;
    L_0x0051:
        r4 = 97;
        if (r3 < r4) goto L_0x0059;
    L_0x0055:
        r4 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        if (r3 <= r4) goto L_0x0171;
    L_0x0059:
        r4 = 65;
        if (r3 < r4) goto L_0x0061;
    L_0x005d:
        r4 = 90;
        if (r3 <= r4) goto L_0x0171;
    L_0x0061:
        r4 = 44;
        if (r3 == r4) goto L_0x0171;
    L_0x0065:
        r4 = 46;
        if (r3 == r4) goto L_0x0171;
    L_0x0069:
        r4 = 95;
        if (r3 == r4) goto L_0x0171;
    L_0x006d:
        r0.write(r14);
        r0.write(r11);
        r4 = com.alibaba.fastjson.c.e.a;
        r5 = r3 >>> 12;
        r5 = r5 & 15;
        r4 = r4[r5];
        r0.write(r4);
        r4 = com.alibaba.fastjson.c.e.a;
        r5 = r3 >>> 8;
        r5 = r5 & 15;
        r4 = r4[r5];
        r0.write(r4);
        r4 = com.alibaba.fastjson.c.e.a;
        r5 = r3 >>> 4;
        r5 = r5 & 15;
        r4 = r4[r5];
        r0.write(r4);
        r4 = com.alibaba.fastjson.c.e.a;
        r3 = r3 & 15;
        r3 = r4[r3];
        r0.write(r3);
        goto L_0x0174;
    L_0x009f:
        r4 = r0.f;
        if (r4 == 0) goto L_0x011d;
    L_0x00a3:
        if (r3 == r9) goto L_0x0112;
    L_0x00a5:
        if (r3 == r10) goto L_0x0112;
    L_0x00a7:
        r4 = 10;
        if (r3 == r4) goto L_0x0112;
    L_0x00ab:
        r4 = 13;
        if (r3 == r4) goto L_0x0112;
    L_0x00af:
        r4 = 9;
        if (r3 == r4) goto L_0x0112;
    L_0x00b3:
        if (r3 == r12) goto L_0x0112;
    L_0x00b5:
        if (r3 == r7) goto L_0x0112;
    L_0x00b7:
        if (r3 != r14) goto L_0x00ba;
    L_0x00b9:
        goto L_0x0112;
    L_0x00ba:
        r4 = 32;
        if (r3 >= r4) goto L_0x00dd;
    L_0x00be:
        r0.write(r14);
        r0.write(r11);
        r0.write(r8);
        r0.write(r8);
        r4 = com.alibaba.fastjson.c.e.i;
        r3 = r3 * 2;
        r4 = r4[r3];
        r0.write(r4);
        r4 = com.alibaba.fastjson.c.e.i;
        r3 = r3 + r15;
        r3 = r4[r3];
        r0.write(r3);
        goto L_0x0174;
    L_0x00dd:
        r4 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        if (r3 < r4) goto L_0x0171;
    L_0x00e1:
        r0.write(r14);
        r0.write(r11);
        r4 = com.alibaba.fastjson.c.e.a;
        r5 = r3 >>> 12;
        r5 = r5 & 15;
        r4 = r4[r5];
        r0.write(r4);
        r4 = com.alibaba.fastjson.c.e.a;
        r5 = r3 >>> 8;
        r5 = r5 & 15;
        r4 = r4[r5];
        r0.write(r4);
        r4 = com.alibaba.fastjson.c.e.a;
        r5 = r3 >>> 4;
        r5 = r5 & 15;
        r4 = r4[r5];
        r0.write(r4);
        r4 = com.alibaba.fastjson.c.e.a;
        r3 = r3 & 15;
        r3 = r4[r3];
        r0.write(r3);
        goto L_0x0174;
    L_0x0112:
        r0.write(r14);
        r4 = com.alibaba.fastjson.c.e.h;
        r3 = r4[r3];
        r0.write(r3);
        goto L_0x0174;
    L_0x011d:
        r4 = com.alibaba.fastjson.c.e.d;
        r4 = r4.length;
        if (r3 >= r4) goto L_0x0128;
    L_0x0122:
        r4 = com.alibaba.fastjson.c.e.d;
        r4 = r4[r3];
        if (r4 != 0) goto L_0x0132;
    L_0x0128:
        if (r3 != r7) goto L_0x0171;
    L_0x012a:
        r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial;
        r4 = r0.b(r4);
        if (r4 == 0) goto L_0x0171;
    L_0x0132:
        r0.write(r14);
        r4 = com.alibaba.fastjson.c.e.d;
        r4 = r4[r3];
        if (r4 != r13) goto L_0x0169;
    L_0x013b:
        r0.write(r11);
        r4 = com.alibaba.fastjson.c.e.a;
        r5 = r3 >>> 12;
        r5 = r5 & 15;
        r4 = r4[r5];
        r0.write(r4);
        r4 = com.alibaba.fastjson.c.e.a;
        r5 = r3 >>> 8;
        r5 = r5 & 15;
        r4 = r4[r5];
        r0.write(r4);
        r4 = com.alibaba.fastjson.c.e.a;
        r5 = r3 >>> 4;
        r5 = r5 & 15;
        r4 = r4[r5];
        r0.write(r4);
        r4 = com.alibaba.fastjson.c.e.a;
        r3 = r3 & 15;
        r3 = r4[r3];
        r0.write(r3);
        goto L_0x0174;
    L_0x0169:
        r4 = com.alibaba.fastjson.c.e.h;
        r3 = r4[r3];
        r0.write(r3);
        goto L_0x0174;
    L_0x0171:
        r0.write(r3);
    L_0x0174:
        r6 = r6 + 1;
        goto L_0x003d;
    L_0x0178:
        r0.write(r12);
        if (r2 == 0) goto L_0x0180;
    L_0x017d:
        r0.write(r2);
    L_0x0180:
        return;
    L_0x0181:
        r0.b(r4);
    L_0x0184:
        r5 = r0.c;
        r5 = r5 + r15;
        r13 = r5 + r3;
        r10 = r0.a;
        r9 = r0.c;
        r10[r9] = r12;
        r9 = r0.a;
        r1.getChars(r6, r3, r9, r5);
        r0.c = r4;
        r3 = r0.e;
        r9 = -1;
        if (r3 == 0) goto L_0x0267;
    L_0x019b:
        r1 = r5;
    L_0x019c:
        if (r1 >= r13) goto L_0x01ca;
    L_0x019e:
        r3 = r0.a;
        r3 = r3[r1];
        if (r3 < r8) goto L_0x01a8;
    L_0x01a4:
        r6 = 57;
        if (r3 <= r6) goto L_0x01c7;
    L_0x01a8:
        r6 = 97;
        if (r3 < r6) goto L_0x01b0;
    L_0x01ac:
        r6 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        if (r3 <= r6) goto L_0x01c7;
    L_0x01b0:
        r6 = 65;
        if (r3 < r6) goto L_0x01b8;
    L_0x01b4:
        r6 = 90;
        if (r3 <= r6) goto L_0x01c7;
    L_0x01b8:
        r6 = 44;
        if (r3 == r6) goto L_0x01c7;
    L_0x01bc:
        r6 = 46;
        if (r3 == r6) goto L_0x01c7;
    L_0x01c0:
        r6 = 95;
        if (r3 == r6) goto L_0x01c7;
    L_0x01c4:
        r4 = r4 + 5;
        r9 = r1;
    L_0x01c7:
        r1 = r1 + 1;
        goto L_0x019c;
    L_0x01ca:
        r1 = r0.a;
        r1 = r1.length;
        if (r4 <= r1) goto L_0x01d2;
    L_0x01cf:
        r0.b(r4);
    L_0x01d2:
        r0.c = r4;
    L_0x01d4:
        if (r9 < r5) goto L_0x024d;
    L_0x01d6:
        r1 = r0.a;
        r1 = r1[r9];
        if (r1 < r8) goto L_0x01e0;
    L_0x01dc:
        r3 = 57;
        if (r1 <= r3) goto L_0x024a;
    L_0x01e0:
        r3 = 97;
        if (r1 < r3) goto L_0x01e8;
    L_0x01e4:
        r3 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        if (r1 <= r3) goto L_0x024a;
    L_0x01e8:
        r3 = 65;
        if (r1 < r3) goto L_0x01f0;
    L_0x01ec:
        r3 = 90;
        if (r1 <= r3) goto L_0x024a;
    L_0x01f0:
        r3 = 44;
        if (r1 == r3) goto L_0x024a;
    L_0x01f4:
        r3 = 46;
        if (r1 == r3) goto L_0x024a;
    L_0x01f8:
        r3 = 95;
        if (r1 == r3) goto L_0x024a;
    L_0x01fc:
        r3 = r0.a;
        r4 = r9 + 1;
        r6 = r0.a;
        r7 = r9 + 6;
        r10 = r13 - r9;
        r10 = r10 - r15;
        java.lang.System.arraycopy(r3, r4, r6, r7, r10);
        r3 = r0.a;
        r3[r9] = r14;
        r3 = r0.a;
        r3[r4] = r11;
        r3 = r0.a;
        r4 = r9 + 2;
        r6 = com.alibaba.fastjson.c.e.a;
        r7 = r1 >>> 12;
        r7 = r7 & 15;
        r6 = r6[r7];
        r3[r4] = r6;
        r3 = r0.a;
        r4 = r9 + 3;
        r6 = com.alibaba.fastjson.c.e.a;
        r7 = r1 >>> 8;
        r7 = r7 & 15;
        r6 = r6[r7];
        r3[r4] = r6;
        r3 = r0.a;
        r4 = r9 + 4;
        r6 = com.alibaba.fastjson.c.e.a;
        r7 = r1 >>> 4;
        r7 = r7 & 15;
        r6 = r6[r7];
        r3[r4] = r6;
        r3 = r0.a;
        r4 = r9 + 5;
        r6 = com.alibaba.fastjson.c.e.a;
        r1 = r1 & 15;
        r1 = r6[r1];
        r3[r4] = r1;
        r13 = r13 + 5;
    L_0x024a:
        r9 = r9 + -1;
        goto L_0x01d4;
    L_0x024d:
        if (r2 == 0) goto L_0x025f;
    L_0x024f:
        r1 = r0.a;
        r3 = r0.c;
        r3 = r3 + -2;
        r1[r3] = r12;
        r1 = r0.a;
        r3 = r0.c;
        r3 = r3 - r15;
        r1[r3] = r2;
        return;
    L_0x025f:
        r1 = r0.a;
        r2 = r0.c;
        r2 = r2 - r15;
        r1[r2] = r12;
        return;
    L_0x0267:
        r3 = r0.f;
        if (r3 == 0) goto L_0x03bd;
    L_0x026b:
        r1 = r5;
    L_0x026c:
        if (r1 >= r13) goto L_0x02a5;
    L_0x026e:
        r3 = r0.a;
        r3 = r3[r1];
        if (r3 == r12) goto L_0x029f;
    L_0x0274:
        if (r3 == r7) goto L_0x029f;
    L_0x0276:
        if (r3 != r14) goto L_0x0279;
    L_0x0278:
        goto L_0x029f;
    L_0x0279:
        r6 = 8;
        if (r3 == r6) goto L_0x029c;
    L_0x027d:
        r6 = 12;
        if (r3 == r6) goto L_0x029c;
    L_0x0281:
        r6 = 10;
        if (r3 == r6) goto L_0x029c;
    L_0x0285:
        r6 = 13;
        if (r3 == r6) goto L_0x029c;
    L_0x0289:
        r6 = 9;
        if (r3 != r6) goto L_0x028e;
    L_0x028d:
        goto L_0x029c;
    L_0x028e:
        r6 = 32;
        if (r3 >= r6) goto L_0x0295;
    L_0x0292:
        r4 = r4 + 5;
        goto L_0x02a1;
    L_0x0295:
        r6 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        if (r3 < r6) goto L_0x02a2;
    L_0x0299:
        r4 = r4 + 5;
        goto L_0x02a1;
    L_0x029c:
        r4 = r4 + 1;
        goto L_0x02a1;
    L_0x029f:
        r4 = r4 + 1;
    L_0x02a1:
        r9 = r1;
    L_0x02a2:
        r1 = r1 + 1;
        goto L_0x026c;
    L_0x02a5:
        r1 = r0.a;
        r1 = r1.length;
        if (r4 <= r1) goto L_0x02ad;
    L_0x02aa:
        r0.b(r4);
    L_0x02ad:
        r0.c = r4;
    L_0x02af:
        if (r9 < r5) goto L_0x03a3;
    L_0x02b1:
        r1 = r0.a;
        r1 = r1[r9];
        r3 = 8;
        if (r1 == r3) goto L_0x0381;
    L_0x02b9:
        r4 = 12;
        if (r1 == r4) goto L_0x0381;
    L_0x02bd:
        r6 = 10;
        if (r1 == r6) goto L_0x0381;
    L_0x02c1:
        r6 = 13;
        if (r1 == r6) goto L_0x0381;
    L_0x02c5:
        r6 = 9;
        if (r1 != r6) goto L_0x02cb;
    L_0x02c9:
        goto L_0x0381;
    L_0x02cb:
        if (r1 == r12) goto L_0x0368;
    L_0x02cd:
        if (r1 == r7) goto L_0x0368;
    L_0x02cf:
        if (r1 != r14) goto L_0x02d3;
    L_0x02d1:
        goto L_0x0368;
    L_0x02d3:
        r6 = 32;
        if (r1 >= r6) goto L_0x0315;
    L_0x02d7:
        r6 = r0.a;
        r10 = r9 + 1;
        r3 = r0.a;
        r4 = r9 + 6;
        r16 = r13 - r9;
        r7 = r16 + -1;
        java.lang.System.arraycopy(r6, r10, r3, r4, r7);
        r3 = r0.a;
        r3[r9] = r14;
        r3 = r0.a;
        r3[r10] = r11;
        r3 = r0.a;
        r4 = r9 + 2;
        r3[r4] = r8;
        r3 = r0.a;
        r4 = r9 + 3;
        r3[r4] = r8;
        r3 = r0.a;
        r4 = r9 + 4;
        r6 = com.alibaba.fastjson.c.e.i;
        r1 = r1 * 2;
        r6 = r6[r1];
        r3[r4] = r6;
        r3 = r0.a;
        r4 = r9 + 5;
        r6 = com.alibaba.fastjson.c.e.i;
        r1 = r1 + r15;
        r1 = r6[r1];
        r3[r4] = r1;
        r13 = r13 + 5;
        goto L_0x039d;
    L_0x0315:
        r3 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        if (r1 < r3) goto L_0x039d;
    L_0x0319:
        r3 = r0.a;
        r4 = r9 + 1;
        r6 = r0.a;
        r7 = r9 + 6;
        r10 = r13 - r9;
        r10 = r10 - r15;
        java.lang.System.arraycopy(r3, r4, r6, r7, r10);
        r3 = r0.a;
        r3[r9] = r14;
        r3 = r0.a;
        r3[r4] = r11;
        r3 = r0.a;
        r4 = r9 + 2;
        r6 = com.alibaba.fastjson.c.e.a;
        r7 = r1 >>> 12;
        r7 = r7 & 15;
        r6 = r6[r7];
        r3[r4] = r6;
        r3 = r0.a;
        r4 = r9 + 3;
        r6 = com.alibaba.fastjson.c.e.a;
        r7 = r1 >>> 8;
        r7 = r7 & 15;
        r6 = r6[r7];
        r3[r4] = r6;
        r3 = r0.a;
        r4 = r9 + 4;
        r6 = com.alibaba.fastjson.c.e.a;
        r7 = r1 >>> 4;
        r7 = r7 & 15;
        r6 = r6[r7];
        r3[r4] = r6;
        r3 = r0.a;
        r4 = r9 + 5;
        r6 = com.alibaba.fastjson.c.e.a;
        r1 = r1 & 15;
        r1 = r6[r1];
        r3[r4] = r1;
        r13 = r13 + 5;
        goto L_0x039d;
    L_0x0368:
        r3 = r0.a;
        r4 = r9 + 1;
        r6 = r0.a;
        r7 = r9 + 2;
        r10 = r13 - r9;
        r10 = r10 - r15;
        java.lang.System.arraycopy(r3, r4, r6, r7, r10);
        r3 = r0.a;
        r3[r9] = r14;
        r3 = r0.a;
        r3[r4] = r1;
        r13 = r13 + 1;
        goto L_0x039d;
    L_0x0381:
        r3 = r0.a;
        r4 = r9 + 1;
        r6 = r0.a;
        r7 = r9 + 2;
        r10 = r13 - r9;
        r10 = r10 - r15;
        java.lang.System.arraycopy(r3, r4, r6, r7, r10);
        r3 = r0.a;
        r3[r9] = r14;
        r3 = r0.a;
        r6 = com.alibaba.fastjson.c.e.h;
        r1 = r6[r1];
        r3[r4] = r1;
        r13 = r13 + 1;
    L_0x039d:
        r9 = r9 + -1;
        r7 = 47;
        goto L_0x02af;
    L_0x03a3:
        if (r2 == 0) goto L_0x03b5;
    L_0x03a5:
        r1 = r0.a;
        r3 = r0.c;
        r3 = r3 + -2;
        r1[r3] = r12;
        r1 = r0.a;
        r3 = r0.c;
        r3 = r3 - r15;
        r1[r3] = r2;
        return;
    L_0x03b5:
        r1 = r0.a;
        r2 = r0.c;
        r2 = r2 - r15;
        r1[r2] = r12;
        return;
    L_0x03bd:
        r3 = r5;
        r10 = r6;
        r7 = r9;
        r17 = r7;
    L_0x03c2:
        if (r3 >= r13) goto L_0x0410;
    L_0x03c4:
        r12 = r0.a;
        r12 = r12[r3];
        r8 = 8232; // 0x2028 float:1.1535E-41 double:4.067E-320;
        if (r12 != r8) goto L_0x03da;
    L_0x03cc:
        r6 = r6 + 1;
        r4 = r4 + 4;
        if (r7 != r9) goto L_0x03d6;
    L_0x03d2:
        r7 = r3;
        r17 = r7;
        goto L_0x03d8;
    L_0x03d6:
        r17 = r3;
    L_0x03d8:
        r10 = r12;
        goto L_0x0409;
    L_0x03da:
        r8 = 93;
        if (r12 < r8) goto L_0x03ee;
    L_0x03de:
        r8 = 127; // 0x7f float:1.78E-43 double:6.27E-322;
        if (r12 < r8) goto L_0x0409;
    L_0x03e2:
        r8 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        if (r12 > r8) goto L_0x0409;
    L_0x03e6:
        if (r7 != r9) goto L_0x03e9;
    L_0x03e8:
        r7 = r3;
    L_0x03e9:
        r6 = r6 + 1;
        r4 = r4 + 4;
        goto L_0x03d6;
    L_0x03ee:
        r8 = r0.d;
        r8 = a(r12, r8);
        if (r8 == 0) goto L_0x0409;
    L_0x03f6:
        r6 = r6 + 1;
        r8 = com.alibaba.fastjson.c.e.d;
        r8 = r8.length;
        if (r12 >= r8) goto L_0x0406;
    L_0x03fd:
        r8 = com.alibaba.fastjson.c.e.d;
        r8 = r8[r12];
        r10 = 4;
        if (r8 != r10) goto L_0x0406;
    L_0x0404:
        r4 = r4 + 4;
    L_0x0406:
        if (r7 != r9) goto L_0x03d6;
    L_0x0408:
        goto L_0x03d2;
    L_0x0409:
        r3 = r3 + 1;
        r8 = 48;
        r12 = 34;
        goto L_0x03c2;
    L_0x0410:
        if (r6 <= 0) goto L_0x059e;
    L_0x0412:
        r4 = r4 + r6;
        r3 = r0.a;
        r3 = r3.length;
        if (r4 <= r3) goto L_0x041b;
    L_0x0418:
        r0.b(r4);
    L_0x041b:
        r0.c = r4;
        if (r6 != r15) goto L_0x04cd;
    L_0x041f:
        r1 = 8232; // 0x2028 float:1.1535E-41 double:4.067E-320;
        if (r10 != r1) goto L_0x0457;
    L_0x0423:
        r1 = r17 + 1;
        r3 = r17 + 6;
        r13 = r13 - r17;
        r13 = r13 - r15;
        r4 = r0.a;
        r5 = r0.a;
        java.lang.System.arraycopy(r4, r1, r5, r3, r13);
        r3 = r0.a;
        r3[r17] = r14;
        r3 = r0.a;
        r3[r1] = r11;
        r3 = r0.a;
        r1 = r1 + r15;
        r4 = 50;
        r3[r1] = r4;
        r3 = r0.a;
        r1 = r1 + r15;
        r4 = 48;
        r3[r1] = r4;
        r3 = r0.a;
        r1 = r1 + r15;
        r4 = 50;
        r3[r1] = r4;
        r3 = r0.a;
        r1 = r1 + r15;
        r4 = 56;
        r3[r1] = r4;
        goto L_0x059e;
    L_0x0457:
        r1 = com.alibaba.fastjson.c.e.d;
        r1 = r1.length;
        if (r10 >= r1) goto L_0x04b1;
    L_0x045c:
        r1 = com.alibaba.fastjson.c.e.d;
        r1 = r1[r10];
        r3 = 4;
        if (r1 != r3) goto L_0x04b1;
    L_0x0463:
        r1 = r17 + 1;
        r3 = r17 + 6;
        r13 = r13 - r17;
        r13 = r13 - r15;
        r4 = r0.a;
        r5 = r0.a;
        java.lang.System.arraycopy(r4, r1, r5, r3, r13);
        r3 = r0.a;
        r3[r17] = r14;
        r3 = r0.a;
        r4 = r1 + 1;
        r3[r1] = r11;
        r1 = r0.a;
        r3 = r4 + 1;
        r5 = com.alibaba.fastjson.c.e.a;
        r6 = r10 >>> 12;
        r6 = r6 & 15;
        r5 = r5[r6];
        r1[r4] = r5;
        r1 = r0.a;
        r4 = r3 + 1;
        r5 = com.alibaba.fastjson.c.e.a;
        r6 = r10 >>> 8;
        r6 = r6 & 15;
        r5 = r5[r6];
        r1[r3] = r5;
        r1 = r0.a;
        r3 = r4 + 1;
        r5 = com.alibaba.fastjson.c.e.a;
        r6 = r10 >>> 4;
        r6 = r6 & 15;
        r5 = r5[r6];
        r1[r4] = r5;
        r1 = r0.a;
        r4 = com.alibaba.fastjson.c.e.a;
        r5 = r10 & 15;
        r4 = r4[r5];
        r1[r3] = r4;
        goto L_0x059e;
    L_0x04b1:
        r1 = r17 + 1;
        r3 = r17 + 2;
        r13 = r13 - r17;
        r13 = r13 - r15;
        r4 = r0.a;
        r5 = r0.a;
        java.lang.System.arraycopy(r4, r1, r5, r3, r13);
        r3 = r0.a;
        r3[r17] = r14;
        r3 = r0.a;
        r4 = com.alibaba.fastjson.c.e.h;
        r4 = r4[r10];
        r3[r1] = r4;
        goto L_0x059e;
    L_0x04cd:
        if (r6 <= r15) goto L_0x059e;
    L_0x04cf:
        r3 = r7 - r5;
    L_0x04d1:
        r4 = r20.length();
        if (r3 >= r4) goto L_0x059e;
    L_0x04d7:
        r4 = r1.charAt(r3);
        r5 = com.alibaba.fastjson.c.e.d;
        r5 = r5.length;
        if (r4 >= r5) goto L_0x04ea;
    L_0x04e0:
        r5 = com.alibaba.fastjson.c.e.d;
        r5 = r5[r4];
        if (r5 != 0) goto L_0x04e7;
    L_0x04e6:
        goto L_0x04ea;
    L_0x04e7:
        r5 = 47;
        goto L_0x04f6;
    L_0x04ea:
        r5 = 47;
        if (r4 != r5) goto L_0x054b;
    L_0x04ee:
        r6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial;
        r6 = r0.b(r6);
        if (r6 == 0) goto L_0x054b;
    L_0x04f6:
        r6 = r0.a;
        r8 = r7 + 1;
        r6[r7] = r14;
        r6 = com.alibaba.fastjson.c.e.d;
        r6 = r6[r4];
        r9 = 4;
        if (r6 != r9) goto L_0x0540;
    L_0x0503:
        r6 = r0.a;
        r7 = r8 + 1;
        r6[r8] = r11;
        r6 = r0.a;
        r8 = r7 + 1;
        r10 = com.alibaba.fastjson.c.e.a;
        r12 = r4 >>> 12;
        r12 = r12 & 15;
        r10 = r10[r12];
        r6[r7] = r10;
        r6 = r0.a;
        r7 = r8 + 1;
        r10 = com.alibaba.fastjson.c.e.a;
        r12 = r4 >>> 8;
        r12 = r12 & 15;
        r10 = r10[r12];
        r6[r8] = r10;
        r6 = r0.a;
        r8 = r7 + 1;
        r10 = com.alibaba.fastjson.c.e.a;
        r12 = r4 >>> 4;
        r12 = r12 & 15;
        r10 = r10[r12];
        r6[r7] = r10;
        r6 = r0.a;
        r7 = r8 + 1;
        r10 = com.alibaba.fastjson.c.e.a;
        r4 = r4 & 15;
        r4 = r10[r4];
        r6[r8] = r4;
        goto L_0x059a;
    L_0x0540:
        r6 = r0.a;
        r7 = r8 + 1;
        r10 = com.alibaba.fastjson.c.e.h;
        r4 = r10[r4];
        r6[r8] = r4;
        goto L_0x059a;
    L_0x054b:
        r9 = 4;
        r6 = 8232; // 0x2028 float:1.1535E-41 double:4.067E-320;
        if (r4 != r6) goto L_0x0593;
    L_0x0550:
        r6 = r0.a;
        r8 = r7 + 1;
        r6[r7] = r14;
        r6 = r0.a;
        r7 = r8 + 1;
        r6[r8] = r11;
        r6 = r0.a;
        r8 = r7 + 1;
        r10 = com.alibaba.fastjson.c.e.a;
        r12 = r4 >>> 12;
        r12 = r12 & 15;
        r10 = r10[r12];
        r6[r7] = r10;
        r6 = r0.a;
        r7 = r8 + 1;
        r10 = com.alibaba.fastjson.c.e.a;
        r12 = r4 >>> 8;
        r12 = r12 & 15;
        r10 = r10[r12];
        r6[r8] = r10;
        r6 = r0.a;
        r8 = r7 + 1;
        r10 = com.alibaba.fastjson.c.e.a;
        r12 = r4 >>> 4;
        r12 = r12 & 15;
        r10 = r10[r12];
        r6[r7] = r10;
        r6 = r0.a;
        r7 = r8 + 1;
        r10 = com.alibaba.fastjson.c.e.a;
        r4 = r4 & 15;
        r4 = r10[r4];
        r6[r8] = r4;
        goto L_0x059a;
    L_0x0593:
        r6 = r0.a;
        r8 = r7 + 1;
        r6[r7] = r4;
        r7 = r8;
    L_0x059a:
        r3 = r3 + 1;
        goto L_0x04d1;
    L_0x059e:
        if (r2 == 0) goto L_0x05b2;
    L_0x05a0:
        r1 = r0.a;
        r3 = r0.c;
        r3 = r3 + -2;
        r4 = 34;
        r1[r3] = r4;
        r1 = r0.a;
        r3 = r0.c;
        r3 = r3 - r15;
        r1[r3] = r2;
        return;
    L_0x05b2:
        r4 = 34;
        r1 = r0.a;
        r2 = r0.c;
        r2 = r2 - r15;
        r1[r2] = r4;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.ax.a(java.lang.String, char):void");
    }

    public final /* synthetic */ Writer append(char c) throws IOException {
        write((int) c);
        return this;
    }

    public final /* synthetic */ Appendable m0append(char c) throws IOException {
        write((int) c);
        return this;
    }
}
