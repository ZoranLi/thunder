package org.json.alipay;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;

public final class c {
    private int a;
    private Reader b;
    private char c;
    private boolean d;

    private c(Reader reader) {
        if (!reader.markSupported()) {
            reader = new BufferedReader(reader);
        }
        this.b = reader;
        this.d = false;
        this.a = 0;
    }

    public c(String str) {
        this(new StringReader(str));
    }

    private String a(int i) {
        if (i == 0) {
            return "";
        }
        char[] cArr = new char[i];
        int i2 = 0;
        if (this.d) {
            this.d = false;
            cArr[0] = this.c;
            i2 = 1;
        }
        while (i2 < i) {
            try {
                int read = this.b.read(cArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            } catch (Throwable e) {
                throw new JSONException(e);
            }
        }
        this.a += i2;
        if (i2 < i) {
            throw a("Substring bounds error");
        }
        this.c = cArr[i - 1];
        return new String(cArr);
    }

    public final JSONException a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(toString());
        return new JSONException(stringBuilder.toString());
    }

    public final void a() {
        if (!this.d) {
            if (this.a > 0) {
                this.a--;
                this.d = true;
                return;
            }
        }
        throw new JSONException("Stepping back two steps is not supported");
    }

    public final char b() {
        if (this.d) {
            this.d = false;
            if (this.c != '\u0000') {
                this.a++;
            }
            return this.c;
        }
        try {
            int read = this.b.read();
            if (read <= 0) {
                this.c = '\u0000';
                return '\u0000';
            }
            this.a++;
            this.c = (char) read;
            return this.c;
        } catch (Throwable e) {
            throw new JSONException(e);
        }
    }

    public final char c() {
        char b;
        while (true) {
            b = b();
            if (b == '/') {
                b = b();
                if (b != '*') {
                    if (b == '/') {
                        do {
                            b = b();
                            if (b == '\n' || b == '\r') {
                                break;
                            }
                        } while (b != '\u0000');
                    } else {
                        a();
                        return '/';
                    }
                }
                while (true) {
                    b = b();
                    if (b != '\u0000') {
                        if (b == '*') {
                            if (b() == '/') {
                                break;
                            }
                            a();
                        }
                    } else {
                        throw a("Unclosed comment");
                    }
                }
            } else if (b == '#') {
                do {
                    b = b();
                    if (b == '\n' || b == '\r') {
                        break;
                    }
                } while (b != '\u0000');
            } else if (b == '\u0000' || b > ' ') {
                return b;
            }
        }
        return b;
    }

    public final java.lang.Object d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = r10.c();
        r1 = 34;
        r2 = 8;
        r3 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        r4 = 16;
        r5 = 2;
        if (r0 == r1) goto L_0x00d9;
    L_0x000f:
        r1 = 91;
        if (r0 == r1) goto L_0x00d0;
    L_0x0013:
        r1 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        if (r0 == r1) goto L_0x00c7;
    L_0x0017:
        switch(r0) {
            case 39: goto L_0x00d9;
            case 40: goto L_0x00d0;
            default: goto L_0x001a;
        };
    L_0x001a:
        r1 = new java.lang.StringBuffer;
        r1.<init>();
        r6 = r0;
    L_0x0020:
        r7 = 32;
        if (r6 < r7) goto L_0x0034;
    L_0x0024:
        r7 = ",:]}/\\\"[{;=#";
        r7 = r7.indexOf(r6);
        if (r7 >= 0) goto L_0x0034;
    L_0x002c:
        r1.append(r6);
        r6 = r10.b();
        goto L_0x0020;
    L_0x0034:
        r10.a();
        r1 = r1.toString();
        r1 = r1.trim();
        r6 = "";
        r6 = r1.equals(r6);
        if (r6 == 0) goto L_0x004e;
    L_0x0047:
        r0 = "Missing value";
        r0 = r10.a(r0);
        throw r0;
    L_0x004e:
        r6 = "true";
        r6 = r1.equalsIgnoreCase(r6);
        if (r6 == 0) goto L_0x0059;
    L_0x0056:
        r0 = java.lang.Boolean.TRUE;
        return r0;
    L_0x0059:
        r6 = "false";
        r6 = r1.equalsIgnoreCase(r6);
        if (r6 == 0) goto L_0x0064;
    L_0x0061:
        r0 = java.lang.Boolean.FALSE;
        return r0;
    L_0x0064:
        r6 = "null";
        r6 = r1.equalsIgnoreCase(r6);
        if (r6 == 0) goto L_0x006f;
    L_0x006c:
        r0 = org.json.alipay.b.a;
        return r0;
    L_0x006f:
        r6 = 48;
        if (r0 < r6) goto L_0x0077;
    L_0x0073:
        r7 = 57;
        if (r0 <= r7) goto L_0x0085;
    L_0x0077:
        r7 = 46;
        if (r0 == r7) goto L_0x0085;
    L_0x007b:
        r7 = 45;
        if (r0 == r7) goto L_0x0085;
    L_0x007f:
        r7 = 43;
        if (r0 != r7) goto L_0x0084;
    L_0x0083:
        goto L_0x0085;
    L_0x0084:
        return r1;
    L_0x0085:
        if (r0 != r6) goto L_0x00b4;
    L_0x0087:
        r0 = r1.length();
        if (r0 <= r5) goto L_0x00aa;
    L_0x008d:
        r0 = 1;
        r6 = r1.charAt(r0);
        if (r6 == r3) goto L_0x009c;
    L_0x0094:
        r0 = r1.charAt(r0);
        r3 = 88;
        if (r0 != r3) goto L_0x00aa;
    L_0x009c:
        r0 = new java.lang.Integer;	 Catch:{ Exception -> 0x00b4 }
        r2 = r1.substring(r5);	 Catch:{ Exception -> 0x00b4 }
        r2 = java.lang.Integer.parseInt(r2, r4);	 Catch:{ Exception -> 0x00b4 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x00b4 }
        return r0;	 Catch:{ Exception -> 0x00b4 }
    L_0x00aa:
        r0 = new java.lang.Integer;	 Catch:{ Exception -> 0x00b4 }
        r2 = java.lang.Integer.parseInt(r1, r2);	 Catch:{ Exception -> 0x00b4 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x00b4 }
        return r0;
    L_0x00b4:
        r0 = new java.lang.Integer;	 Catch:{ Exception -> 0x00ba }
        r0.<init>(r1);	 Catch:{ Exception -> 0x00ba }
        return r0;
    L_0x00ba:
        r0 = new java.lang.Long;	 Catch:{ Exception -> 0x00c0 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x00c0 }
        return r0;
    L_0x00c0:
        r0 = new java.lang.Double;	 Catch:{ Exception -> 0x00c6 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x00c6 }
        return r0;
    L_0x00c6:
        return r1;
    L_0x00c7:
        r10.a();
        r0 = new org.json.alipay.b;
        r0.<init>(r10);
        return r0;
    L_0x00d0:
        r10.a();
        r0 = new org.json.alipay.a;
        r0.<init>(r10);
        return r0;
    L_0x00d9:
        r1 = new java.lang.StringBuffer;
        r1.<init>();
    L_0x00de:
        r6 = r10.b();
        if (r6 == 0) goto L_0x0137;
    L_0x00e4:
        r7 = 10;
        if (r6 == r7) goto L_0x0137;
    L_0x00e8:
        r8 = 13;
        if (r6 == r8) goto L_0x0137;
    L_0x00ec:
        r9 = 92;
        if (r6 == r9) goto L_0x00fb;
    L_0x00f0:
        if (r6 != r0) goto L_0x00f7;
    L_0x00f2:
        r0 = r1.toString();
        return r0;
    L_0x00f7:
        r1.append(r6);
        goto L_0x00de;
    L_0x00fb:
        r6 = r10.b();
        r9 = 98;
        if (r6 == r9) goto L_0x0133;
    L_0x0103:
        r9 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r6 == r9) goto L_0x0130;
    L_0x0107:
        r9 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        if (r6 == r9) goto L_0x012c;
    L_0x010b:
        r7 = 114; // 0x72 float:1.6E-43 double:5.63E-322;
        if (r6 == r7) goto L_0x0128;
    L_0x010f:
        if (r6 == r3) goto L_0x0123;
    L_0x0111:
        switch(r6) {
            case 116: goto L_0x0120;
            case 117: goto L_0x0115;
            default: goto L_0x0114;
        };
    L_0x0114:
        goto L_0x00f7;
    L_0x0115:
        r6 = 4;
        r6 = r10.a(r6);
    L_0x011a:
        r6 = java.lang.Integer.parseInt(r6, r4);
        r6 = (char) r6;
        goto L_0x00f7;
    L_0x0120:
        r6 = 9;
        goto L_0x00f7;
    L_0x0123:
        r6 = r10.a(r5);
        goto L_0x011a;
    L_0x0128:
        r1.append(r8);
        goto L_0x00de;
    L_0x012c:
        r1.append(r7);
        goto L_0x00de;
    L_0x0130:
        r6 = 12;
        goto L_0x00f7;
    L_0x0133:
        r1.append(r2);
        goto L_0x00de;
    L_0x0137:
        r0 = "Unterminated string";
        r0 = r10.a(r0);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.alipay.c.d():java.lang.Object");
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(" at character ");
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }
}
