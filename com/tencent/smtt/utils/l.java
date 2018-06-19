package com.tencent.smtt.utils;

import com.tencent.smtt.utils.k.b;
import java.io.InputStream;
import java.util.zip.ZipEntry;

final class l implements b {
    final /* synthetic */ String a;

    l(String str) {
        this.a = str;
    }

    public final boolean a(InputStream inputStream, ZipEntry zipEntry, String str) {
        try {
            return k.b(inputStream, zipEntry, this.a, str);
        } catch (Throwable e) {
            throw new Exception("copyFileIfChanged Exception", e);
        }
    }
}
