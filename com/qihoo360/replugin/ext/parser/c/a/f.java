package com.qihoo360.replugin.ext.parser.c.a;

import java.io.IOException;
import java.io.Writer;

/* compiled from: NumericEntityEscaper */
final class f extends c {
    private final int a;
    private final int b;
    private final boolean c;

    private f(int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = true;
    }

    public f() {
        this(0, Integer.MAX_VALUE);
    }

    public static f a(int i, int i2) {
        return new f(i, i2);
    }

    public final boolean a(int i, Writer writer) throws IOException {
        if (this.c) {
            if (i < this.a || i > this.b) {
                return false;
            }
        } else if (i >= this.a && i <= this.b) {
            return false;
        }
        writer.write("&#");
        writer.write(Integer.toString(i, 10));
        writer.write(59);
        return true;
    }
}
