package com.android.volley.toolbox;

/* compiled from: ParserCursor */
public final class am {
    final int a;
    int b;
    private final int c;

    public am(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        }
        this.c = 0;
        this.a = i;
        this.b = 0;
    }

    public final void a(int i) {
        StringBuilder stringBuilder;
        if (i < this.c) {
            stringBuilder = new StringBuilder("pos: ");
            stringBuilder.append(i);
            stringBuilder.append(" < lowerBound: ");
            stringBuilder.append(this.c);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        } else if (i > this.a) {
            stringBuilder = new StringBuilder("pos: ");
            stringBuilder.append(i);
            stringBuilder.append(" > upperBound: ");
            stringBuilder.append(this.a);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        } else {
            this.b = i;
        }
    }

    public final boolean a() {
        return this.b >= this.a;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        stringBuilder.append(Integer.toString(this.c));
        stringBuilder.append('>');
        stringBuilder.append(Integer.toString(this.b));
        stringBuilder.append('>');
        stringBuilder.append(Integer.toString(this.a));
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
