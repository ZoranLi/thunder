package com.xunlei.downloadprovider.download;

import android.annotation.SuppressLint;
import java.io.File;
import java.io.FileFilter;

/* compiled from: XLFileExploreActivity */
final class d implements FileFilter {
    final /* synthetic */ XLFileExploreActivity a;

    d(XLFileExploreActivity xLFileExploreActivity) {
        this.a = xLFileExploreActivity;
    }

    @SuppressLint({"DefaultLocale"})
    public final boolean accept(File file) {
        String name = file.getName();
        if (file.isDirectory() != null) {
            return true;
        }
        if (this.a.b(name) == null || name.toLowerCase().startsWith(".") != null) {
            return null;
        }
        return true;
    }
}
