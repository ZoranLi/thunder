package com.qihoo360.replugin.ext.parser.c.a;

import java.io.IOException;
import java.io.Writer;

/* compiled from: CodePointTranslator */
abstract class c extends b {
    public abstract boolean a(int i, Writer writer) throws IOException;

    c() {
    }

    public final int a(CharSequence charSequence, int i, Writer writer) throws IOException {
        return a(Character.codePointAt(charSequence, i), writer) != null ? 1 : null;
    }
}
