package android.support.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipFile;

public final class MultiDex {
    private static final String CODE_CACHE_NAME = "code_cache";
    private static final String CODE_CACHE_SECONDARY_FOLDER_NAME = "secondary-dexes";
    private static final boolean IS_VM_MULTIDEX_CAPABLE = isVMMultidexCapable(System.getProperty("java.vm.version"));
    private static final int MAX_SUPPORTED_SDK_VERSION = 20;
    private static final int MIN_SDK_VERSION = 4;
    private static final String NO_KEY_PREFIX = "";
    private static final String OLD_SECONDARY_FOLDER_NAME = "secondary-dexes";
    static final String TAG = "MultiDex";
    private static final int VM_WITH_MULTIDEX_VERSION_MAJOR = 2;
    private static final int VM_WITH_MULTIDEX_VERSION_MINOR = 1;
    private static final Set<File> installedApk = new HashSet();

    private static final class V14 {
        private V14() {
        }

        private static void install(ClassLoader classLoader, List<? extends File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            classLoader = MultiDex.findField(classLoader, "pathList").get(classLoader);
            MultiDex.expandFieldArray(classLoader, "dexElements", makeDexElements(classLoader, new ArrayList(list), file));
        }

        private static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) MultiDex.findMethod(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList, file});
        }
    }

    private static final class V19 {
        private V19() {
        }

        private static void install(ClassLoader classLoader, List<? extends File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            classLoader = MultiDex.findField(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            MultiDex.expandFieldArray(classLoader, "dexElements", makeDexElements(classLoader, new ArrayList(list), file, arrayList));
            if (arrayList.size() > null) {
                list = arrayList.iterator();
                while (list.hasNext() != null) {
                    list.next();
                }
                list = MultiDex.findField(classLoader, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr = (IOException[]) list.get(classLoader);
                if (iOExceptionArr == null) {
                    file = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    File file2 = new IOException[(arrayList.size() + iOExceptionArr.length)];
                    arrayList.toArray(file2);
                    System.arraycopy(iOExceptionArr, 0, file2, arrayList.size(), iOExceptionArr.length);
                    file = file2;
                }
                list.set(classLoader, file);
            }
        }

        private static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) MultiDex.findMethod(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    private static final class V4 {
        private V4() {
        }

        private static void install(ClassLoader classLoader, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            int size = list.size();
            Field access$300 = MultiDex.findField(classLoader, "path");
            StringBuilder stringBuilder = new StringBuilder((String) access$300.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            list = list.listIterator();
            while (list.hasNext()) {
                File file = (File) list.next();
                String absolutePath = file.getAbsolutePath();
                stringBuilder.append(':');
                stringBuilder.append(absolutePath);
                int previousIndex = list.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = file;
                zipFileArr[previousIndex] = new ZipFile(file);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(absolutePath);
                stringBuilder2.append(ShareConstants.DEX_SUFFIX);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, stringBuilder2.toString(), 0);
            }
            access$300.set(classLoader, stringBuilder.toString());
            MultiDex.expandFieldArray(classLoader, "mPaths", strArr);
            MultiDex.expandFieldArray(classLoader, "mFiles", fileArr);
            MultiDex.expandFieldArray(classLoader, "mZips", zipFileArr);
            MultiDex.expandFieldArray(classLoader, "mDexs", dexFileArr);
        }
    }

    private MultiDex() {
    }

    public static void install(Context context) {
        if (!IS_VM_MULTIDEX_CAPABLE) {
            if (VERSION.SDK_INT < 4) {
                StringBuilder stringBuilder = new StringBuilder("MultiDex installation failed. SDK ");
                stringBuilder.append(VERSION.SDK_INT);
                stringBuilder.append(" is unsupported. Min SDK version is 4.");
                throw new RuntimeException(stringBuilder.toString());
            }
            try {
                ApplicationInfo applicationInfo = getApplicationInfo(context);
                if (applicationInfo != null) {
                    doInstallation(context, new File(applicationInfo.sourceDir), new File(applicationInfo.dataDir), "secondary-dexes", "");
                }
            } catch (Context context2) {
                StringBuilder stringBuilder2 = new StringBuilder("MultiDex installation failed (");
                stringBuilder2.append(context2.getMessage());
                stringBuilder2.append(").");
                throw new RuntimeException(stringBuilder2.toString());
            }
        }
    }

    public static void installInstrumentation(Context context, Context context2) {
        if (!IS_VM_MULTIDEX_CAPABLE) {
            if (VERSION.SDK_INT < 4) {
                context2 = new StringBuilder("MultiDex installation failed. SDK ");
                context2.append(VERSION.SDK_INT);
                context2.append(" is unsupported. Min SDK version is 4.");
                throw new RuntimeException(context2.toString());
            }
            StringBuilder stringBuilder;
            try {
                ApplicationInfo applicationInfo = getApplicationInfo(context);
                if (applicationInfo != null) {
                    ApplicationInfo applicationInfo2 = getApplicationInfo(context2);
                    if (applicationInfo2 != null) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(context.getPackageName());
                        stringBuilder2.append(".");
                        context = stringBuilder2.toString();
                        File file = new File(applicationInfo2.dataDir);
                        File file2 = new File(applicationInfo.sourceDir);
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(context);
                        stringBuilder.append("secondary-dexes");
                        doInstallation(context2, file2, file, stringBuilder.toString(), context);
                        doInstallation(context2, new File(applicationInfo2.sourceDir), file, "secondary-dexes", "");
                    }
                }
            } catch (Context context3) {
                stringBuilder = new StringBuilder("MultiDex installation failed (");
                stringBuilder.append(context3.getMessage());
                stringBuilder.append(").");
                throw new RuntimeException(stringBuilder.toString());
            }
        }
    }

    private static void doInstallation(android.content.Context r3, java.io.File r4, java.io.File r5, java.lang.String r6, java.lang.String r7) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = installedApk;
        monitor-enter(r0);
        r1 = installedApk;	 Catch:{ all -> 0x0052 }
        r1 = r1.contains(r4);	 Catch:{ all -> 0x0052 }
        if (r1 == 0) goto L_0x000d;	 Catch:{ all -> 0x0052 }
    L_0x000b:
        monitor-exit(r0);	 Catch:{ all -> 0x0052 }
        return;	 Catch:{ all -> 0x0052 }
    L_0x000d:
        r1 = installedApk;	 Catch:{ all -> 0x0052 }
        r1.add(r4);	 Catch:{ all -> 0x0052 }
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0052 }
        r2 = 20;	 Catch:{ all -> 0x0052 }
        if (r1 <= r2) goto L_0x0037;	 Catch:{ all -> 0x0052 }
    L_0x0018:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0052 }
        r2 = "MultiDex is not guaranteed to work in SDK version ";	 Catch:{ all -> 0x0052 }
        r1.<init>(r2);	 Catch:{ all -> 0x0052 }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x0052 }
        r1.append(r2);	 Catch:{ all -> 0x0052 }
        r2 = ": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"";	 Catch:{ all -> 0x0052 }
        r1.append(r2);	 Catch:{ all -> 0x0052 }
        r2 = "java.vm.version";	 Catch:{ all -> 0x0052 }
        r2 = java.lang.System.getProperty(r2);	 Catch:{ all -> 0x0052 }
        r1.append(r2);	 Catch:{ all -> 0x0052 }
        r2 = "\"";	 Catch:{ all -> 0x0052 }
        r1.append(r2);	 Catch:{ all -> 0x0052 }
    L_0x0037:
        r1 = r3.getClassLoader();	 Catch:{ RuntimeException -> 0x0050 }
        if (r1 != 0) goto L_0x003f;
    L_0x003d:
        monitor-exit(r0);	 Catch:{ all -> 0x0052 }
        return;
    L_0x003f:
        clearOldDexDir(r3);	 Catch:{ Throwable -> 0x0042 }
    L_0x0042:
        r5 = getDexDir(r3, r5, r6);	 Catch:{ all -> 0x0052 }
        r6 = 0;	 Catch:{ all -> 0x0052 }
        r3 = android.support.multidex.MultiDexExtractor.load(r3, r4, r5, r7, r6);	 Catch:{ all -> 0x0052 }
        installSecondaryDexes(r1, r5, r3);	 Catch:{ all -> 0x0052 }
        monitor-exit(r0);	 Catch:{ all -> 0x0052 }
        return;	 Catch:{ all -> 0x0052 }
    L_0x0050:
        monitor-exit(r0);	 Catch:{ all -> 0x0052 }
        return;	 Catch:{ all -> 0x0052 }
    L_0x0052:
        r3 = move-exception;	 Catch:{ all -> 0x0052 }
        monitor-exit(r0);	 Catch:{ all -> 0x0052 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.multidex.MultiDex.doInstallation(android.content.Context, java.io.File, java.io.File, java.lang.String, java.lang.String):void");
    }

    private static android.content.pm.ApplicationInfo getApplicationInfo(android.content.Context r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = r0.getApplicationInfo();	 Catch:{ RuntimeException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.multidex.MultiDex.getApplicationInfo(android.content.Context):android.content.pm.ApplicationInfo");
    }

    static boolean isVMMultidexCapable(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = 0;
        if (r5 == 0) goto L_0x002c;
    L_0x0003:
        r1 = "(\\d+)\\.(\\d+)(\\.\\d+)?";
        r1 = java.util.regex.Pattern.compile(r1);
        r1 = r1.matcher(r5);
        r2 = r1.matches();
        if (r2 == 0) goto L_0x002c;
    L_0x0013:
        r2 = 1;
        r3 = r1.group(r2);	 Catch:{ NumberFormatException -> 0x002c }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x002c }
        r4 = 2;	 Catch:{ NumberFormatException -> 0x002c }
        r1 = r1.group(r4);	 Catch:{ NumberFormatException -> 0x002c }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x002c }
        if (r3 > r4) goto L_0x002b;
    L_0x0027:
        if (r3 != r4) goto L_0x002c;
    L_0x0029:
        if (r1 <= 0) goto L_0x002c;
    L_0x002b:
        r0 = r2;
    L_0x002c:
        r1 = new java.lang.StringBuilder;
        r2 = "VM with version ";
        r1.<init>(r2);
        r1.append(r5);
        if (r0 == 0) goto L_0x003b;
    L_0x0038:
        r5 = " has multidex support";
        goto L_0x003d;
    L_0x003b:
        r5 = " does not have multidex support";
    L_0x003d:
        r1.append(r5);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.multidex.MultiDex.isVMMultidexCapable(java.lang.String):boolean");
    }

    private static void installSecondaryDexes(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
        if (!list.isEmpty()) {
            if (VERSION.SDK_INT >= 19) {
                V19.install(classLoader, list, file);
            } else if (VERSION.SDK_INT >= 14) {
                V14.install(classLoader, list, file);
            } else {
                V4.install(classLoader, list);
            }
        }
    }

    private static java.lang.reflect.Field findField(java.lang.Object r3, java.lang.String r4) throws java.lang.NoSuchFieldException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = r3.getClass();
    L_0x0004:
        if (r0 == 0) goto L_0x001a;
    L_0x0006:
        r1 = r0.getDeclaredField(r4);	 Catch:{ NoSuchFieldException -> 0x0015 }
        r2 = r1.isAccessible();	 Catch:{ NoSuchFieldException -> 0x0015 }
        if (r2 != 0) goto L_0x0014;	 Catch:{ NoSuchFieldException -> 0x0015 }
    L_0x0010:
        r2 = 1;	 Catch:{ NoSuchFieldException -> 0x0015 }
        r1.setAccessible(r2);	 Catch:{ NoSuchFieldException -> 0x0015 }
    L_0x0014:
        return r1;
    L_0x0015:
        r0 = r0.getSuperclass();
        goto L_0x0004;
    L_0x001a:
        r0 = new java.lang.NoSuchFieldException;
        r1 = new java.lang.StringBuilder;
        r2 = "Field ";
        r1.<init>(r2);
        r1.append(r4);
        r4 = " not found in ";
        r1.append(r4);
        r3 = r3.getClass();
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.multidex.MultiDex.findField(java.lang.Object, java.lang.String):java.lang.reflect.Field");
    }

    private static java.lang.reflect.Method findMethod(java.lang.Object r3, java.lang.String r4, java.lang.Class<?>... r5) throws java.lang.NoSuchMethodException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = r3.getClass();
    L_0x0004:
        if (r0 == 0) goto L_0x001a;
    L_0x0006:
        r1 = r0.getDeclaredMethod(r4, r5);	 Catch:{ NoSuchMethodException -> 0x0015 }
        r2 = r1.isAccessible();	 Catch:{ NoSuchMethodException -> 0x0015 }
        if (r2 != 0) goto L_0x0014;	 Catch:{ NoSuchMethodException -> 0x0015 }
    L_0x0010:
        r2 = 1;	 Catch:{ NoSuchMethodException -> 0x0015 }
        r1.setAccessible(r2);	 Catch:{ NoSuchMethodException -> 0x0015 }
    L_0x0014:
        return r1;
    L_0x0015:
        r0 = r0.getSuperclass();
        goto L_0x0004;
    L_0x001a:
        r0 = new java.lang.NoSuchMethodException;
        r1 = new java.lang.StringBuilder;
        r2 = "Method ";
        r1.<init>(r2);
        r1.append(r4);
        r4 = " with parameters ";
        r1.append(r4);
        r4 = java.util.Arrays.asList(r5);
        r1.append(r4);
        r4 = " not found in ";
        r1.append(r4);
        r3 = r3.getClass();
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.multidex.MultiDex.findMethod(java.lang.Object, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    private static void expandFieldArray(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        str = findField(obj, str);
        Object[] objArr2 = (Object[]) str.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        str.set(obj, objArr3);
    }

    private static void clearOldDexDir(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory() != null) {
            context = new StringBuilder("Clearing old secondary dex dir (");
            context.append(file.getPath());
            context.append(").");
            context = file.listFiles();
            if (context == null) {
                context = new StringBuilder("Failed to list secondary dex dir content (");
                context.append(file.getPath());
                context.append(").");
                return;
            }
            for (File file2 : context) {
                StringBuilder stringBuilder = new StringBuilder("Trying to delete old file ");
                stringBuilder.append(file2.getPath());
                stringBuilder.append(" of size ");
                stringBuilder.append(file2.length());
                if (file2.delete()) {
                    new StringBuilder("Deleted old file ").append(file2.getPath());
                } else {
                    new StringBuilder("Failed to delete old file ").append(file2.getPath());
                }
            }
            if (file.delete() == null) {
                new StringBuilder("Failed to delete secondary dex dir ").append(file.getPath());
                return;
            }
            new StringBuilder("Deleted old secondary dex dir ").append(file.getPath());
        }
    }

    private static java.io.File getDexDir(android.content.Context r2, java.io.File r3, java.lang.String r4) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = new java.io.File;
        r1 = "code_cache";
        r0.<init>(r3, r1);
        mkdirChecked(r0);	 Catch:{ IOException -> 0x000b }
        goto L_0x0019;
    L_0x000b:
        r0 = new java.io.File;
        r2 = r2.getFilesDir();
        r3 = "code_cache";
        r0.<init>(r2, r3);
        mkdirChecked(r0);
    L_0x0019:
        r2 = new java.io.File;
        r2.<init>(r0, r4);
        mkdirChecked(r2);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.multidex.MultiDex.getDexDir(android.content.Context, java.io.File, java.lang.String):java.io.File");
    }

    private static void mkdirChecked(File file) throws IOException {
        file.mkdir();
        if (!file.isDirectory()) {
            StringBuilder stringBuilder;
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                StringBuilder stringBuilder2 = new StringBuilder("Failed to create dir ");
                stringBuilder2.append(file.getPath());
                stringBuilder2.append(". Parent file is null.");
            } else {
                stringBuilder = new StringBuilder("Failed to create dir ");
                stringBuilder.append(file.getPath());
                stringBuilder.append(". parent file is a dir ");
                stringBuilder.append(parentFile.isDirectory());
                stringBuilder.append(", a file ");
                stringBuilder.append(parentFile.isFile());
                stringBuilder.append(", exists ");
                stringBuilder.append(parentFile.exists());
                stringBuilder.append(", readable ");
                stringBuilder.append(parentFile.canRead());
                stringBuilder.append(", writable ");
                stringBuilder.append(parentFile.canWrite());
            }
            stringBuilder = new StringBuilder("Failed to create directory ");
            stringBuilder.append(file.getPath());
            throw new IOException(stringBuilder.toString());
        }
    }
}
