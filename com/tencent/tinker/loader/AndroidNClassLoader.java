package com.tencent.tinker.loader;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

@TargetApi(14)
/* compiled from: BUGLY */
class AndroidNClassLoader extends PathClassLoader {
    private static final String TAG = "Tinker.NClassLoader";
    private String applicationClassName;
    private final PathClassLoader originClassLoader;

    private AndroidNClassLoader(String str, PathClassLoader pathClassLoader, Application application) {
        super(str, pathClassLoader.getParent());
        this.originClassLoader = pathClassLoader;
        str = application.getClass().getName();
        if (str != null && str.equals("android.app.Application") == null) {
            this.applicationClassName = str;
        }
    }

    private static Object recreateDexPathList(Object obj, ClassLoader classLoader) throws Exception {
        Object[] objArr = (Object[]) ShareReflectUtil.findField(obj, "dexElements").get(obj);
        List<File> list = (List) ShareReflectUtil.findField(obj, "nativeLibraryDirectories").get(obj);
        StringBuilder stringBuilder = new StringBuilder();
        Field findField = ShareReflectUtil.findField(objArr.getClass().getComponentType(), "dexFile");
        int i = 1;
        for (Object obj2 : objArr) {
            DexFile dexFile = (DexFile) findField.get(obj2);
            if (dexFile != null) {
                if (i != 0) {
                    i = 0;
                } else {
                    stringBuilder.append(File.pathSeparator);
                }
                stringBuilder.append(dexFile.getName());
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        int i2 = 1;
        for (File file : list) {
            if (file != null) {
                if (i2 != 0) {
                    i2 = 0;
                } else {
                    stringBuilder.append(File.pathSeparator);
                }
                stringBuilder.append(file.getAbsolutePath());
            }
        }
        String stringBuilder3 = stringBuilder.toString();
        return ShareReflectUtil.findConstructor(obj, ClassLoader.class, String.class, String.class, File.class).newInstance(new Object[]{classLoader, stringBuilder2, stringBuilder3, null});
    }

    private static AndroidNClassLoader createAndroidNClassLoader(PathClassLoader pathClassLoader, Application application) throws Exception {
        ClassLoader androidNClassLoader = new AndroidNClassLoader("", pathClassLoader, application);
        application = ShareReflectUtil.findField((Object) pathClassLoader, "pathList");
        application.set(androidNClassLoader, recreateDexPathList(application.get(pathClassLoader), androidNClassLoader));
        return androidNClassLoader;
    }

    private static void reflectPackageInfoClassloader(Application application, ClassLoader classLoader) throws Exception {
        Object obj = (Context) ShareReflectUtil.findField((Object) application, "mBase").get(application);
        obj = ShareReflectUtil.findField(obj, "mPackageInfo").get(obj);
        Field findField = ShareReflectUtil.findField(obj, "mClassLoader");
        Thread.currentThread().setContextClassLoader(classLoader);
        findField.set(obj, classLoader);
    }

    public static AndroidNClassLoader inject(PathClassLoader pathClassLoader, Application application) throws Exception {
        pathClassLoader = createAndroidNClassLoader(pathClassLoader, application);
        reflectPackageInfoClassloader(application, pathClassLoader);
        return pathClassLoader;
    }

    public Class<?> findClass(String str) throws ClassNotFoundException {
        if ((str == null || !str.startsWith("com.tencent.tinker.loader.") || str.equals(SystemClassLoaderAdder.CHECK_DEX_CLASS)) && (this.applicationClassName == null || !this.applicationClassName.equals(str))) {
            return super.findClass(str);
        }
        return this.originClassLoader.loadClass(str);
    }

    public String findLibrary(String str) {
        return super.findLibrary(str);
    }
}
