package com.baidu.mobads.utils;

import java.io.File;
import java.util.Comparator;

class j implements Comparator<File> {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((File) obj, (File) obj2);
    }

    public int a(File file, File file2) {
        return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
    }
}
