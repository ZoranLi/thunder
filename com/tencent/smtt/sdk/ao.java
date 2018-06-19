package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

class ao implements FileFilter {
    final /* synthetic */ am a;

    ao(am amVar) {
        this.a = amVar;
    }

    public boolean accept(File file) {
        return file.getName().endsWith("tbs.conf");
    }
}
