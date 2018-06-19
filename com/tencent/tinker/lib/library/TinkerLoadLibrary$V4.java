package com.tencent.tinker.lib.library;

import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

/* compiled from: BUGLY */
final class TinkerLoadLibrary$V4 {
    private TinkerLoadLibrary$V4() {
    }

    private static void install(ClassLoader classLoader, File file) throws Throwable {
        file = file.getPath();
        Field findField = ShareReflectUtil.findField(classLoader, "libPath");
        StringBuilder stringBuilder = new StringBuilder((String) findField.get(classLoader));
        stringBuilder.append(':');
        stringBuilder.append(file);
        findField.set(classLoader, stringBuilder.toString());
        findField = ShareReflectUtil.findField(classLoader, "libraryPathElements");
        List list = (List) findField.get(classLoader);
        list.add(0, file);
        findField.set(classLoader, list);
    }
}
