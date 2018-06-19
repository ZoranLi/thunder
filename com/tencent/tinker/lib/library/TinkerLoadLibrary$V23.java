package com.tencent.tinker.lib.library;

import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BUGLY */
final class TinkerLoadLibrary$V23 {
    private TinkerLoadLibrary$V23() {
    }

    private static void install(ClassLoader classLoader, File file) throws Throwable {
        classLoader = ShareReflectUtil.findField(classLoader, "pathList").get(classLoader);
        List list = (List) ShareReflectUtil.findField(classLoader, "nativeLibraryDirectories").get(classLoader);
        list.add(0, file);
        List list2 = (List) ShareReflectUtil.findField(classLoader, "systemNativeLibraryDirectories").get(classLoader);
        Method findMethod = ShareReflectUtil.findMethod(classLoader, "makePathElements", new Class[]{List.class, File.class, List.class});
        ArrayList arrayList = new ArrayList();
        list.addAll(list2);
        Object[] objArr = (Object[]) findMethod.invoke(classLoader, new Object[]{list, null, arrayList});
        Field findField = ShareReflectUtil.findField(classLoader, "nativeLibraryPathElements");
        findField.setAccessible(true);
        findField.set(classLoader, objArr);
    }
}
