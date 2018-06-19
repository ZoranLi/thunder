package com.qihoo360.replugin.utils;

import java.nio.charset.Charset;

/* compiled from: Charsets */
public final class a {
    @Deprecated
    public static final Charset a = Charset.forName("UTF-8");

    public static Charset a(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }
}
