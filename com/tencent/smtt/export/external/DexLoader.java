package com.tencent.smtt.export.external;

import android.content.Context;
import android.text.TextUtils;
import dalvik.system.DexClassLoader;
import dalvik.system.VMStack;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;

public class DexLoader {
    private static final String JAVACORE_PACKAGE_PREFIX = "org.chromium";
    private static final String TAG = "DexLoader";
    private static final String TBS_FUSION_DEX = "tbs_jars_fusion_dex";
    private static final String TBS_WEBVIEW_DEX = "webview_dex";
    private static boolean mUseTbsCorePrivateClassLoader = false;
    private DexClassLoader mClassLoader;

    private static class TbsCorePrivateClassLoader extends DexClassLoader {
        public TbsCorePrivateClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
        }

        protected java.lang.Class<?> loadClass(java.lang.String r2, boolean r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            if (r2 == 0) goto L_0x0022;
        L_0x0002:
            r0 = "org.chromium";
            r0 = r2.startsWith(r0);
            if (r0 == 0) goto L_0x0022;
        L_0x000a:
            r3 = r1.findLoadedClass(r2);
            if (r3 != 0) goto L_0x0021;
        L_0x0010:
            r0 = r1.findClass(r2);	 Catch:{ ClassNotFoundException -> 0x0015 }
            r3 = r0;
        L_0x0015:
            if (r3 != 0) goto L_0x0021;
        L_0x0017:
            r0 = r1.getParent();
            if (r0 == 0) goto L_0x0021;
        L_0x001d:
            r3 = r0.loadClass(r2);
        L_0x0021:
            return r3;
        L_0x0022:
            r2 = super.loadClass(r2, r3);
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.export.external.DexLoader.TbsCorePrivateClassLoader.loadClass(java.lang.String, boolean):java.lang.Class<?>");
        }
    }

    public DexLoader(Context context, String str, String str2) {
        this(context, new String[]{str}, str2);
    }

    public DexLoader(Context context, String[] strArr, String str) {
        this(null, context, strArr, str);
    }

    public DexLoader(Context context, String[] strArr, String str, DexLoader dexLoader) {
        ClassLoader classLoader = dexLoader.getClassLoader();
        for (String createDexClassLoader : strArr) {
            classLoader = createDexClassLoader(createDexClassLoader, str, context.getApplicationInfo().nativeLibraryDir, classLoader);
            this.mClassLoader = classLoader;
        }
    }

    public DexLoader(Context context, String[] strArr, String str, String str2) {
        ClassLoader classLoader = context.getClassLoader();
        String str3 = context.getApplicationInfo().nativeLibraryDir;
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str3);
            stringBuilder.append(File.pathSeparator);
            stringBuilder.append(str2);
            str3 = stringBuilder.toString();
        }
        for (String createDexClassLoader : strArr) {
            classLoader = createDexClassLoader(createDexClassLoader, str, str3, classLoader);
            this.mClassLoader = classLoader;
        }
    }

    public DexLoader(String str, Context context, String[] strArr, String str2) {
        this(str, context, strArr, str2, null);
    }

    public DexLoader(String str, Context context, String[] strArr, String str2, Map<String, Object> map) {
        initTbsSettings(map);
        ClassLoader callingClassLoader = VMStack.getCallingClassLoader();
        if (callingClassLoader == null) {
            callingClassLoader = context.getClassLoader();
        }
        for (String createDexClassLoader : strArr) {
            callingClassLoader = createDexClassLoader(createDexClassLoader, str2, str, callingClassLoader);
            this.mClassLoader = callingClassLoader;
        }
    }

    private DexClassLoader createDexClassLoader(String str, String str2, String str3, ClassLoader classLoader) {
        return shouldUseTbsCorePrivateClassLoader(str) ? new TbsCorePrivateClassLoader(str, str2, str3, classLoader) : new DexClassLoader(str, str2, str3, classLoader);
    }

    public static void initTbsSettings(Map<String, Object> map) {
        if (map != null) {
            try {
                Object obj = map.get(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER);
                if (obj instanceof Boolean) {
                    mUseTbsCorePrivateClassLoader = ((Boolean) obj).booleanValue();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private boolean shouldUseTbsCorePrivateClassLoader(String str) {
        if (!mUseTbsCorePrivateClassLoader) {
            return false;
        }
        if (!str.contains(TBS_FUSION_DEX)) {
            if (!str.contains(TBS_WEBVIEW_DEX)) {
                return false;
            }
        }
        return true;
    }

    public DexClassLoader getClassLoader() {
        return this.mClassLoader;
    }

    public java.lang.Object getStaticField(java.lang.String r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = r3.mClassLoader;	 Catch:{ Throwable -> 0x0014 }
        r1 = r1.loadClass(r4);	 Catch:{ Throwable -> 0x0014 }
        r1 = r1.getField(r5);	 Catch:{ Throwable -> 0x0014 }
        r2 = 1;	 Catch:{ Throwable -> 0x0014 }
        r1.setAccessible(r2);	 Catch:{ Throwable -> 0x0014 }
        r1 = r1.get(r0);	 Catch:{ Throwable -> 0x0014 }
        return r1;
    L_0x0014:
        r1 = r3.getClass();
        r1.getSimpleName();
        r1 = new java.lang.StringBuilder;
        r2 = "'";
        r1.<init>(r2);
        r1.append(r4);
        r4 = "' get field '";
        r1.append(r4);
        r1.append(r5);
        r4 = "' failed";
        r1.append(r4);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.export.external.DexLoader.getStaticField(java.lang.String, java.lang.String):java.lang.Object");
    }

    public java.lang.Object invokeMethod(java.lang.Object r2, java.lang.String r3, java.lang.String r4, java.lang.Class<?>[] r5, java.lang.Object... r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.mClassLoader;	 Catch:{ Throwable -> 0x0013 }
        r0 = r0.loadClass(r3);	 Catch:{ Throwable -> 0x0013 }
        r5 = r0.getMethod(r4, r5);	 Catch:{ Throwable -> 0x0013 }
        r0 = 1;	 Catch:{ Throwable -> 0x0013 }
        r5.setAccessible(r0);	 Catch:{ Throwable -> 0x0013 }
        r2 = r5.invoke(r2, r6);	 Catch:{ Throwable -> 0x0013 }
        return r2;
    L_0x0013:
        r2 = r1.getClass();
        r2.getSimpleName();
        r2 = new java.lang.StringBuilder;
        r5 = "'";
        r2.<init>(r5);
        r2.append(r3);
        r3 = "' invoke method '";
        r2.append(r3);
        r2.append(r4);
        r3 = "' failed";
        r2.append(r3);
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.export.external.DexLoader.invokeMethod(java.lang.Object, java.lang.String, java.lang.String, java.lang.Class[], java.lang.Object[]):java.lang.Object");
    }

    public Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = this.mClassLoader.loadClass(str).getMethod(str2, clsArr);
            method.setAccessible(true);
            return method.invoke(null, objArr);
        } catch (Throwable th) {
            if (str2 == null || !str2.equalsIgnoreCase("initTesRuntimeEnvironment")) {
                getClass().getSimpleName();
                StringBuilder stringBuilder = new StringBuilder("'");
                stringBuilder.append(str);
                stringBuilder.append("' invoke static method '");
                stringBuilder.append(str2);
                stringBuilder.append("' failed");
                return null;
            }
            getClass().getSimpleName();
            StringBuilder stringBuilder2 = new StringBuilder("'");
            stringBuilder2.append(str);
            stringBuilder2.append("' invoke static method '");
            stringBuilder2.append(str2);
            stringBuilder2.append("' failed");
            return th;
        }
    }

    public java.lang.Class<?> loadClass(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mClassLoader;	 Catch:{ Throwable -> 0x0007 }
        r0 = r0.loadClass(r3);	 Catch:{ Throwable -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = r2.getClass();
        r0.getSimpleName();
        r0 = new java.lang.StringBuilder;
        r1 = "loadClass '";
        r0.<init>(r1);
        r0.append(r3);
        r3 = "' failed";
        r0.append(r3);
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.export.external.DexLoader.loadClass(java.lang.String):java.lang.Class<?>");
    }

    public java.lang.Object newInstance(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mClassLoader;	 Catch:{ Throwable -> 0x000b }
        r0 = r0.loadClass(r3);	 Catch:{ Throwable -> 0x000b }
        r0 = r0.newInstance();	 Catch:{ Throwable -> 0x000b }
        return r0;
    L_0x000b:
        r0 = r2.getClass();
        r0.getSimpleName();
        r0 = new java.lang.StringBuilder;
        r1 = "create ";
        r0.<init>(r1);
        r0.append(r3);
        r3 = " instance failed";
        r0.append(r3);
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.export.external.DexLoader.newInstance(java.lang.String):java.lang.Object");
    }

    public Object newInstance(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return this.mClassLoader.loadClass(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable th) {
            if ("com.tencent.smtt.webkit.adapter.X5WebViewAdapter".equalsIgnoreCase(str)) {
                getClass().getSimpleName();
                StringBuilder stringBuilder = new StringBuilder("'newInstance ");
                stringBuilder.append(str);
                stringBuilder.append(" failed");
                return th;
            }
            getClass().getSimpleName();
            StringBuilder stringBuilder2 = new StringBuilder("create '");
            stringBuilder2.append(str);
            stringBuilder2.append("' instance failed");
            return null;
        }
    }

    public void setStaticField(java.lang.String r3, java.lang.String r4, java.lang.Object r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mClassLoader;	 Catch:{ Throwable -> 0x0013 }
        r0 = r0.loadClass(r3);	 Catch:{ Throwable -> 0x0013 }
        r0 = r0.getField(r4);	 Catch:{ Throwable -> 0x0013 }
        r1 = 1;	 Catch:{ Throwable -> 0x0013 }
        r0.setAccessible(r1);	 Catch:{ Throwable -> 0x0013 }
        r1 = 0;	 Catch:{ Throwable -> 0x0013 }
        r0.set(r1, r5);	 Catch:{ Throwable -> 0x0013 }
        return;
    L_0x0013:
        r5 = r2.getClass();
        r5.getSimpleName();
        r5 = new java.lang.StringBuilder;
        r0 = "'";
        r5.<init>(r0);
        r5.append(r3);
        r3 = "' set field '";
        r5.append(r3);
        r5.append(r4);
        r3 = "' failed";
        r5.append(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.export.external.DexLoader.setStaticField(java.lang.String, java.lang.String, java.lang.Object):void");
    }
}
