package com.tencent.tinker.loader;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Build.VERSION;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
public class SystemClassLoaderAdder {
    public static final String CHECK_DEX_CLASS = "com.tencent.tinker.loader.TinkerTestDexLoad";
    public static final String CHECK_DEX_FIELD = "isPatch";
    private static final String TAG = "Tinker.ClassLoaderAdder";
    private static int sPatchDexCount;

    /* compiled from: BUGLY */
    final class AnonymousClass1 implements Comparator<File> {
        final /* synthetic */ Map val$matchesClassNPatternMemo;

        AnonymousClass1(Map map) {
            this.val$matchesClassNPatternMemo = map;
        }

        public final int compare(File file, File file2) {
            if (file == null && file2 == null) {
                return 0;
            }
            if (file == null) {
                return -1;
            }
            if (file2 == null) {
                return 1;
            }
            file = file.getName();
            file2 = file2.getName();
            if (file.equals(file2)) {
                return 0;
            }
            if (file.startsWith(ShareConstants.TEST_DEX_NAME)) {
                return 1;
            }
            if (file2.startsWith(ShareConstants.TEST_DEX_NAME)) {
                return -1;
            }
            boolean booleanValue = ((Boolean) this.val$matchesClassNPatternMemo.get(file)).booleanValue();
            boolean booleanValue2 = ((Boolean) this.val$matchesClassNPatternMemo.get(file2)).booleanValue();
            if (booleanValue && booleanValue2) {
                int indexOf = file.indexOf(46);
                int indexOf2 = file2.indexOf(46);
                file = indexOf > 7 ? Integer.parseInt(file.substring(7, indexOf)) : 1;
                file2 = indexOf2 > 7 ? Integer.parseInt(file2.substring(7, indexOf2)) : 1;
                if (file == file2) {
                    return 0;
                }
                return file < file2 ? -1 : 1;
            } else if (booleanValue) {
                return -1;
            } else {
                if (booleanValue2) {
                    return 1;
                }
                return file.compareTo(file2);
            }
        }
    }

    /* compiled from: BUGLY */
    private static final class V14 {
        private V14() {
        }

        private static void install(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            classLoader = ShareReflectUtil.findField((Object) classLoader, "pathList").get(classLoader);
            ShareReflectUtil.expandFieldArray(classLoader, "dexElements", makeDexElements(classLoader, new ArrayList(list), file));
        }

        private static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) ShareReflectUtil.findMethod(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList, file});
        }
    }

    /* compiled from: BUGLY */
    private static final class V19 {
        private V19() {
        }

        private static void install(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            classLoader = ShareReflectUtil.findField((Object) classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ShareReflectUtil.expandFieldArray(classLoader, "dexElements", makeDexElements(classLoader, new ArrayList(list), file, arrayList));
            if (arrayList.size() > null) {
                classLoader = arrayList.iterator();
                if (classLoader.hasNext() != null) {
                    throw ((IOException) classLoader.next());
                }
            }
        }

        private static java.lang.Object[] makeDexElements(java.lang.Object r7, java.util.ArrayList<java.io.File> r8, java.io.File r9, java.util.ArrayList<java.io.IOException> r10) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = 2;
            r1 = 1;
            r2 = 0;
            r3 = 3;
            r4 = "makeDexElements";	 Catch:{ NoSuchMethodException -> 0x0019 }
            r5 = new java.lang.Class[r3];	 Catch:{ NoSuchMethodException -> 0x0019 }
            r6 = java.util.ArrayList.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r5[r2] = r6;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r6 = java.io.File.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r5[r1] = r6;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r6 = java.util.ArrayList.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r5[r0] = r6;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r4 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findMethod(r7, r4, r5);	 Catch:{ NoSuchMethodException -> 0x0019 }
            goto L_0x002d;
        L_0x0019:
            r4 = "makeDexElements";	 Catch:{ NoSuchMethodException -> 0x003c }
            r5 = new java.lang.Class[r3];	 Catch:{ NoSuchMethodException -> 0x003c }
            r6 = java.util.List.class;	 Catch:{ NoSuchMethodException -> 0x003c }
            r5[r2] = r6;	 Catch:{ NoSuchMethodException -> 0x003c }
            r6 = java.io.File.class;	 Catch:{ NoSuchMethodException -> 0x003c }
            r5[r1] = r6;	 Catch:{ NoSuchMethodException -> 0x003c }
            r6 = java.util.List.class;	 Catch:{ NoSuchMethodException -> 0x003c }
            r5[r0] = r6;	 Catch:{ NoSuchMethodException -> 0x003c }
            r4 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findMethod(r7, r4, r5);	 Catch:{ NoSuchMethodException -> 0x003c }
        L_0x002d:
            r3 = new java.lang.Object[r3];
            r3[r2] = r8;
            r3[r1] = r9;
            r3[r0] = r10;
            r7 = r4.invoke(r7, r3);
            r7 = (java.lang.Object[]) r7;
            return r7;
        L_0x003c:
            r7 = move-exception;
            throw r7;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.SystemClassLoaderAdder.V19.makeDexElements(java.lang.Object, java.util.ArrayList, java.io.File, java.util.ArrayList):java.lang.Object[]");
        }
    }

    /* compiled from: BUGLY */
    private static final class V23 {
        private V23() {
        }

        private static void install(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            classLoader = ShareReflectUtil.findField((Object) classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ShareReflectUtil.expandFieldArray(classLoader, "dexElements", makePathElements(classLoader, new ArrayList(list), file, arrayList));
            if (arrayList.size() > null) {
                classLoader = arrayList.iterator();
                if (classLoader.hasNext() != null) {
                    throw ((IOException) classLoader.next());
                }
            }
        }

        private static java.lang.Object[] makePathElements(java.lang.Object r7, java.util.ArrayList<java.io.File> r8, java.io.File r9, java.util.ArrayList<java.io.IOException> r10) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = 2;
            r1 = 1;
            r2 = 0;
            r3 = 3;
            r4 = "makePathElements";	 Catch:{ NoSuchMethodException -> 0x0019 }
            r5 = new java.lang.Class[r3];	 Catch:{ NoSuchMethodException -> 0x0019 }
            r6 = java.util.List.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r5[r2] = r6;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r6 = java.io.File.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r5[r1] = r6;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r6 = java.util.List.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r5[r0] = r6;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r4 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findMethod(r7, r4, r5);	 Catch:{ NoSuchMethodException -> 0x0019 }
            goto L_0x002d;
        L_0x0019:
            r4 = "makePathElements";	 Catch:{ NoSuchMethodException -> 0x003c }
            r5 = new java.lang.Class[r3];	 Catch:{ NoSuchMethodException -> 0x003c }
            r6 = java.util.ArrayList.class;	 Catch:{ NoSuchMethodException -> 0x003c }
            r5[r2] = r6;	 Catch:{ NoSuchMethodException -> 0x003c }
            r6 = java.io.File.class;	 Catch:{ NoSuchMethodException -> 0x003c }
            r5[r1] = r6;	 Catch:{ NoSuchMethodException -> 0x003c }
            r6 = java.util.ArrayList.class;	 Catch:{ NoSuchMethodException -> 0x003c }
            r5[r0] = r6;	 Catch:{ NoSuchMethodException -> 0x003c }
            r4 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findMethod(r7, r4, r5);	 Catch:{ NoSuchMethodException -> 0x003c }
        L_0x002d:
            r3 = new java.lang.Object[r3];
            r3[r2] = r8;
            r3[r1] = r9;
            r3[r0] = r10;
            r7 = r4.invoke(r7, r3);
            r7 = (java.lang.Object[]) r7;
            return r7;
        L_0x003c:
            r7 = com.tencent.tinker.loader.SystemClassLoaderAdder.V19.makeDexElements(r7, r8, r9, r10);	 Catch:{ NoSuchMethodException -> 0x0041 }
            return r7;
        L_0x0041:
            r7 = move-exception;
            throw r7;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.SystemClassLoaderAdder.V23.makePathElements(java.lang.Object, java.util.ArrayList, java.io.File, java.util.ArrayList):java.lang.Object[]");
        }
    }

    /* compiled from: BUGLY */
    private static final class V4 {
        private V4() {
        }

        private static void install(java.lang.ClassLoader r10, java.util.List<java.io.File> r11, java.io.File r12) throws java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.io.IOException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = r11.size();
            r1 = "path";
            r1 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findField(r10, r1);
            r2 = new java.lang.StringBuilder;
            r3 = r1.get(r10);
            r3 = (java.lang.String) r3;
            r2.<init>(r3);
            r3 = new java.lang.String[r0];
            r4 = new java.io.File[r0];
            r5 = new java.util.zip.ZipFile[r0];
            r0 = new dalvik.system.DexFile[r0];
            r11 = r11.listIterator();
        L_0x0021:
            r6 = r11.hasNext();
            if (r6 == 0) goto L_0x0054;
        L_0x0027:
            r6 = r11.next();
            r6 = (java.io.File) r6;
            r7 = r6.getAbsolutePath();
            r8 = 58;
            r2.append(r8);
            r2.append(r7);
            r8 = r11.previousIndex();
            r3[r8] = r7;
            r4[r8] = r6;
            r9 = new java.util.zip.ZipFile;
            r9.<init>(r6);
            r5[r8] = r9;
            r6 = com.tencent.tinker.loader.shareutil.SharePatchFileUtil.optimizedPathFor(r6, r12);
            r9 = 0;
            r6 = dalvik.system.DexFile.loadDex(r7, r6, r9);
            r0[r8] = r6;
            goto L_0x0021;
        L_0x0054:
            r11 = r2.toString();
            r1.set(r10, r11);
            r11 = "mPaths";
            com.tencent.tinker.loader.shareutil.ShareReflectUtil.expandFieldArray(r10, r11, r3);
            r11 = "mFiles";
            com.tencent.tinker.loader.shareutil.ShareReflectUtil.expandFieldArray(r10, r11, r4);
            r11 = "mZips";
            com.tencent.tinker.loader.shareutil.ShareReflectUtil.expandFieldArray(r10, r11, r5);
            r11 = "mDexs";	 Catch:{ Exception -> 0x0070 }
            com.tencent.tinker.loader.shareutil.ShareReflectUtil.expandFieldArray(r10, r11, r0);	 Catch:{ Exception -> 0x0070 }
            return;
        L_0x0070:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.SystemClassLoaderAdder.V4.install(java.lang.ClassLoader, java.util.List, java.io.File):void");
        }
    }

    @SuppressLint({"NewApi"})
    public static void installDexes(Application application, PathClassLoader pathClassLoader, File file, List<File> list) throws Throwable {
        StringBuilder stringBuilder = new StringBuilder("installDexes dexOptDir: ");
        stringBuilder.append(file.getAbsolutePath());
        stringBuilder.append(", dex size:");
        stringBuilder.append(list.size());
        if (!list.isEmpty()) {
            list = createSortedAdditionalPathEntries(list);
            if (VERSION.SDK_INT >= 24 && !checkIsProtectedApp(list)) {
                pathClassLoader = AndroidNClassLoader.inject(pathClassLoader, application);
            }
            if (VERSION.SDK_INT >= 23) {
                V23.install(pathClassLoader, list, file);
            } else if (VERSION.SDK_INT >= 19) {
                V19.install(pathClassLoader, list, file);
            } else if (VERSION.SDK_INT >= 14) {
                V14.install(pathClassLoader, list, file);
            } else {
                V4.install(pathClassLoader, list, file);
            }
            sPatchDexCount = list.size();
            application = new StringBuilder("after loaded classloader: ");
            application.append(pathClassLoader);
            application.append(", dex size:");
            application.append(sPatchDexCount);
            if (checkDexInstall(pathClassLoader) == null) {
                uninstallPatchDex(pathClassLoader);
                throw new TinkerRuntimeException(ShareConstants.CHECK_DEX_INSTALL_FAIL);
            }
        }
    }

    public static void uninstallPatchDex(java.lang.ClassLoader r2) throws java.lang.Throwable {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = sPatchDexCount;
        if (r0 > 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 14;
        if (r0 < r1) goto L_0x001d;
    L_0x000b:
        r0 = "pathList";
        r0 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findField(r2, r0);
        r2 = r0.get(r2);
        r0 = "dexElements";
        r1 = sPatchDexCount;
        com.tencent.tinker.loader.shareutil.ShareReflectUtil.reduceFieldArray(r2, r0, r1);
        return;
    L_0x001d:
        r0 = "mPaths";
        r1 = sPatchDexCount;
        com.tencent.tinker.loader.shareutil.ShareReflectUtil.reduceFieldArray(r2, r0, r1);
        r0 = "mFiles";
        r1 = sPatchDexCount;
        com.tencent.tinker.loader.shareutil.ShareReflectUtil.reduceFieldArray(r2, r0, r1);
        r0 = "mZips";
        r1 = sPatchDexCount;
        com.tencent.tinker.loader.shareutil.ShareReflectUtil.reduceFieldArray(r2, r0, r1);
        r0 = "mDexs";	 Catch:{ Exception -> 0x003a }
        r1 = sPatchDexCount;	 Catch:{ Exception -> 0x003a }
        com.tencent.tinker.loader.shareutil.ShareReflectUtil.reduceFieldArray(r2, r0, r1);	 Catch:{ Exception -> 0x003a }
        return;
    L_0x003a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.SystemClassLoaderAdder.uninstallPatchDex(java.lang.ClassLoader):void");
    }

    private static boolean checkDexInstall(ClassLoader classLoader) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return ((Boolean) ShareReflectUtil.findField(Class.forName(CHECK_DEX_CLASS, true, classLoader), CHECK_DEX_FIELD).get(null)).booleanValue();
    }

    private static boolean checkIsProtectedApp(List<File> list) {
        if (!list.isEmpty()) {
            for (File file : list) {
                if (file != null && file.getName().startsWith(ShareConstants.CHANGED_CLASSES_DEX_NAME)) {
                    return true;
                }
            }
        }
        return null;
    }

    private static List<File> createSortedAdditionalPathEntries(List<File> list) {
        List<File> arrayList = new ArrayList(list);
        list = new HashMap();
        for (File name : arrayList) {
            CharSequence name2 = name.getName();
            list.put(name2, Boolean.valueOf(ShareConstants.CLASS_N_PATTERN.matcher(name2).matches()));
        }
        Collections.sort(arrayList, new AnonymousClass1(list));
        return arrayList;
    }
}
