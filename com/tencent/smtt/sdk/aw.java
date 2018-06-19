package com.tencent.smtt.sdk;

import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.FileFilter;

final class aw implements FileFilter {
    aw() {
    }

    public final boolean accept(File file) {
        return !file.getName().endsWith(ShareConstants.DEX_SUFFIX);
    }
}
