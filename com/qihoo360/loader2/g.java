package com.qihoo360.loader2;

import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.model.PluginInfo;
import java.io.File;
import java.util.HashSet;

/* compiled from: Finder */
public final class g {
    static final void a(File file, a aVar, HashSet<File> hashSet) {
        file = file.listFiles();
        if (file == null) {
            if (c.a != null) {
                c.a("ws001", "search local plugin: nothing");
            }
            return;
        }
        for (File file2 : file) {
            if (!file2.isDirectory()) {
                StringBuilder stringBuilder;
                if (file2.length() <= 0) {
                    if (c.a) {
                        stringBuilder = new StringBuilder("search local plugin: zero length, file=");
                        stringBuilder.append(file2.getAbsolutePath());
                        c.a("ws001", stringBuilder.toString());
                    }
                    hashSet.add(file2);
                } else {
                    PluginInfo build = PluginInfo.build(file2);
                    if (build == null) {
                        hashSet.add(file2);
                    } else if (build.match()) {
                        aVar.b(build);
                    } else {
                        if (c.a) {
                            stringBuilder = new StringBuilder("search local plugin: mismatch, file=");
                            stringBuilder.append(file2.getAbsolutePath());
                            c.a("ws001", stringBuilder.toString());
                        }
                        hashSet.add(file2);
                    }
                }
            }
        }
    }
}
