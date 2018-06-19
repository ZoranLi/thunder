package com.android.volley.toolbox;

import java.io.Serializable;
import java.nio.CharBuffer;

/* compiled from: CharArrayBuffer */
public final class f implements Serializable, CharSequence {
    private char[] a;
    private int b;

    public f(int i) {
        String str = "Buffer capacity";
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" may not be negative");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.a = new char[i];
    }

    private void b(int i) {
        i = new char[Math.max(this.a.length << 1, i)];
        System.arraycopy(this.a, 0, i, 0, this.b);
        this.a = i;
    }

    public final void a(String str) {
        if (str == null) {
            str = "null";
        }
        int length = str.length();
        int i = this.b + length;
        if (i > this.a.length) {
            b(i);
        }
        str.getChars(0, length, this.a, this.b);
        this.b = i;
    }

    public final void a() {
        this.b = 0;
    }

    public final char charAt(int i) {
        return this.a[i];
    }

    public final int length() {
        return this.b;
    }

    public final void a(int i) {
        if (i > 0 && i > this.a.length - this.b) {
            b(this.b + i);
        }
    }

    public final CharSequence subSequence(int i, int i2) {
        StringBuilder stringBuilder;
        if (i < 0) {
            stringBuilder = new StringBuilder("Negative beginIndex: ");
            stringBuilder.append(i);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        } else if (i2 > this.b) {
            stringBuilder = new StringBuilder("endIndex: ");
            stringBuilder.append(i2);
            stringBuilder.append(" > length: ");
            stringBuilder.append(this.b);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        } else if (i <= i2) {
            return CharBuffer.wrap(this.a, i, i2);
        } else {
            StringBuilder stringBuilder2 = new StringBuilder("beginIndex: ");
            stringBuilder2.append(i);
            stringBuilder2.append(" > endIndex: ");
            stringBuilder2.append(i2);
            throw new IndexOutOfBoundsException(stringBuilder2.toString());
        }
    }

    public final String toString() {
        return new String(this.a, 0, this.b);
    }
}
