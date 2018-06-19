package com.xunlei.download.proguard;

import java.io.PrintWriter;
import java.io.Writer;

/* compiled from: IndentingPrintWriter */
public class m extends PrintWriter {
    private final String a;
    private final int b;
    private StringBuilder c;
    private char[] d;
    private int e;
    private boolean f;

    public m(Writer writer, String str) {
        this(writer, str, -1);
    }

    public m(Writer writer, String str, int i) {
        super(writer);
        this.c = new StringBuilder();
        this.f = true;
        this.a = str;
        this.b = i;
    }

    public void a() {
        this.c.append(this.a);
        this.d = null;
    }

    public void b() {
        this.c.delete(0, this.a.length());
        this.d = null;
    }

    public void a(String str, Object obj) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("=");
        stringBuilder.append(String.valueOf(obj));
        stringBuilder.append(" ");
        print(stringBuilder.toString());
    }

    public void a(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("=0x");
        stringBuilder.append(Integer.toHexString(i));
        stringBuilder.append(" ");
        print(stringBuilder.toString());
    }

    public void write(char[] cArr, int i, int i2) {
        int length = this.c.length();
        i2 += i;
        int i3 = i;
        while (i < i2) {
            int i4 = i + 1;
            i = cArr[i];
            this.e++;
            if (i == 10) {
                c();
                super.write(cArr, i3, i4 - i3);
                this.f = true;
                this.e = 0;
                i3 = i4;
            }
            if (this.b > 0 && this.e >= this.b - length) {
                if (this.f == 0) {
                    super.write(10);
                    this.f = true;
                    this.e = i4 - i3;
                } else {
                    c();
                    super.write(cArr, i3, i4 - i3);
                    super.write(10);
                    this.f = true;
                    this.e = 0;
                    i3 = i4;
                }
            }
            i = i4;
        }
        if (i3 != i) {
            c();
            super.write(cArr, i3, i - i3);
        }
    }

    private void c() {
        if (this.f) {
            this.f = false;
            if (this.c.length() != 0) {
                if (this.d == null) {
                    this.d = this.c.toString().toCharArray();
                }
                super.write(this.d, 0, this.d.length);
            }
        }
    }
}
