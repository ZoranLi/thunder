package com.qihoo360.loader2;

import com.qihoo360.replugin.b.c;
import java.io.File;
import java.util.ArrayList;

/* compiled from: V5Finder */
public final class as {
    static final void a(File file, ArrayList<ar> arrayList) {
        file = file.listFiles();
        if (file == null) {
            if (c.a != null) {
                c.a("ws001", "search v5 plugin: nothing");
            }
            return;
        }
        for (File file2 : file) {
            if (!file2.isDirectory() && file2.length() > 0) {
                ar a = ar.a(file2, 1);
                if (a != null) {
                    arrayList.add(a);
                } else {
                    ar a2 = ar.a(file2, 3);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
            }
        }
    }
}
