package com.tencent.smtt.sdk;

import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.FileFilter;

class aq implements FileFilter {
    final /* synthetic */ aj a;

    aq(aj ajVar) {
        this.a = ajVar;
    }

    public boolean accept(File file) {
        return file.getName().endsWith(ShareConstants.JAR_SUFFIX);
    }
}
