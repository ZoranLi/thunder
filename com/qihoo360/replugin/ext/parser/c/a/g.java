package com.qihoo360.replugin.ext.parser.c.a;

import java.io.IOException;
import java.io.Writer;

/* compiled from: UnicodeUnpairedSurrogateRemover */
final class g extends c {
    public final boolean a(int i, Writer writer) throws IOException {
        return i >= 55296 && i <= 57343;
    }

    g() {
    }
}
