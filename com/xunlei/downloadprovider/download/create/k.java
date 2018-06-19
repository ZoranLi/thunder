package com.xunlei.downloadprovider.download.create;

import android.annotation.SuppressLint;
import java.io.File;
import java.io.FileFilter;

/* compiled from: BaseCreateBtTaskActivity */
final class k implements FileFilter {
    final /* synthetic */ BaseCreateBtTaskActivity a;

    k(BaseCreateBtTaskActivity baseCreateBtTaskActivity) {
        this.a = baseCreateBtTaskActivity;
    }

    @SuppressLint({"DefaultLocale"})
    public final boolean accept(File file) {
        String name = file.getName();
        if (file.isDirectory() != null) {
            return true;
        }
        if (name.toLowerCase().endsWith(".torrent") == null || name.toLowerCase().startsWith(".") != null) {
            return null;
        }
        return true;
    }
}
