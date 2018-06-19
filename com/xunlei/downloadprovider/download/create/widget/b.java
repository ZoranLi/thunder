package com.xunlei.downloadprovider.download.create.widget;

import java.io.File;
import java.util.Comparator;

/* compiled from: FileManagerListView */
final class b implements Comparator<File> {
    final /* synthetic */ FileManagerListView a;

    b(FileManagerListView fileManagerListView) {
        this.a = fileManagerListView;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        File file = (File) obj;
        File file2 = (File) obj2;
        if (file.isDirectory()) {
            if (file2.isDirectory() != null) {
                return 0;
            }
        } else if (file2.isDirectory()) {
            return 1;
        } else {
            if (file.length() <= file2.length()) {
                if (file.length() < file2.length()) {
                    return 1;
                }
                return 0;
            }
        }
        return -1;
    }
}
