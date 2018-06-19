package com.igexin.a;

import java.io.File;
import java.io.FilenameFilter;

class i implements FilenameFilter {
    final /* synthetic */ String a;
    final /* synthetic */ h b;

    i(h hVar, String str) {
        this.b = hVar;
        this.a = str;
    }

    public boolean accept(File file, String str) {
        return str.startsWith(this.a);
    }
}
