package com.xiaomi.channel.commonutils.file;

import java.io.File;
import java.io.FileFilter;

final class b implements FileFilter {
    b() {
    }

    public final boolean accept(File file) {
        return file.isDirectory();
    }
}
