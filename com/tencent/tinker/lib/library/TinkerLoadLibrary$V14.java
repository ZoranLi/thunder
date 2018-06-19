package com.tencent.tinker.lib.library;

import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.io.File;

/* compiled from: BUGLY */
final class TinkerLoadLibrary$V14 {
    private TinkerLoadLibrary$V14() {
    }

    private static void install(ClassLoader classLoader, File file) throws Throwable {
        ShareReflectUtil.expandFieldArray(ShareReflectUtil.findField(classLoader, "pathList").get(classLoader), "nativeLibraryDirectories", new File[]{file});
    }
}
