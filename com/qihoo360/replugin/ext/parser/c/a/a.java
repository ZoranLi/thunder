package com.qihoo360.replugin.ext.parser.c.a;

import java.io.IOException;
import java.io.Writer;

/* compiled from: AggregateTranslator */
final class a extends b {
    private final b[] a;

    public a(b... bVarArr) {
        this.a = bVarArr;
    }

    public final int a(CharSequence charSequence, int i, Writer writer) throws IOException {
        for (b a : this.a) {
            int a2 = a.a(charSequence, i, writer);
            if (a2 != 0) {
                return a2;
            }
        }
        return 0;
    }
}
