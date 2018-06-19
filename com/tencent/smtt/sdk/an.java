package com.tencent.smtt.sdk;

import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.FileFilter;

class an implements FileFilter {
    final /* synthetic */ am a;

    an(am amVar) {
        this.a = amVar;
    }

    public boolean accept(File file) {
        return file.getName().endsWith(ShareConstants.DEX_SUFFIX);
    }
}
