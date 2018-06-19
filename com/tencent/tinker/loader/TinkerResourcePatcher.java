package com.tencent.tinker.loader;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;

/* compiled from: BUGLY */
class TinkerResourcePatcher {
    private static final String TAG = "Tinker.ResourcePatcher";
    private static final String TEST_ASSETS_VALUE = "only_use_to_test_tinker_resource.txt";
    private static Method addAssetPathMethod;
    private static Field assetsFiled;
    private static Object currentActivityThread;
    private static Method ensureStringBlocksMethod;
    private static AssetManager newAssetManager;
    private static Field packagesFiled;
    private static Field publicSourceDirField;
    private static Collection<WeakReference<Resources>> references;
    private static Field resDir;
    private static Field resourcePackagesFiled;
    private static Field resourcesImplFiled;

    TinkerResourcePatcher() {
    }

    public static void isResourceCanPatch(android.content.Context r6) throws java.lang.Throwable {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "android.app.ActivityThread";
        r0 = java.lang.Class.forName(r0);
        r1 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.getActivityThread(r6, r0);
        currentActivityThread = r1;
        r1 = "android.app.LoadedApk";	 Catch:{ ClassNotFoundException -> 0x0013 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0013 }
        goto L_0x0019;
    L_0x0013:
        r1 = "android.app.ActivityThread$PackageInfo";
        r1 = java.lang.Class.forName(r1);
    L_0x0019:
        r2 = "mResDir";
        r1 = r1.getDeclaredField(r2);
        resDir = r1;
        r2 = 1;
        r1.setAccessible(r2);
        r1 = "mPackages";
        r1 = r0.getDeclaredField(r1);
        packagesFiled = r1;
        r1.setAccessible(r2);
        r1 = "mResourcePackages";
        r1 = r0.getDeclaredField(r1);
        resourcePackagesFiled = r1;
        r1.setAccessible(r2);
        r6 = r6.getAssets();
        r6 = r6.getClass();
        r6 = r6.getName();
        r1 = "android.content.res.BaiduAssetManager";
        r6 = r6.equals(r1);
        r1 = 0;
        if (r6 == 0) goto L_0x0067;
    L_0x0050:
        r6 = "android.content.res.BaiduAssetManager";
        r6 = java.lang.Class.forName(r6);
        r3 = new java.lang.Class[r1];
        r6 = r6.getConstructor(r3);
        r3 = new java.lang.Object[r1];
        r6 = r6.newInstance(r3);
        r6 = (android.content.res.AssetManager) r6;
        newAssetManager = r6;
        goto L_0x0079;
    L_0x0067:
        r6 = android.content.res.AssetManager.class;
        r3 = new java.lang.Class[r1];
        r6 = r6.getConstructor(r3);
        r3 = new java.lang.Object[r1];
        r6 = r6.newInstance(r3);
        r6 = (android.content.res.AssetManager) r6;
        newAssetManager = r6;
    L_0x0079:
        r6 = android.content.res.AssetManager.class;
        r3 = "addAssetPath";
        r4 = new java.lang.Class[r2];
        r5 = java.lang.String.class;
        r4[r1] = r5;
        r6 = r6.getDeclaredMethod(r3, r4);
        addAssetPathMethod = r6;
        r6.setAccessible(r2);
        r6 = android.content.res.AssetManager.class;
        r3 = "ensureStringBlocks";
        r4 = new java.lang.Class[r1];
        r6 = r6.getDeclaredMethod(r3, r4);
        ensureStringBlocksMethod = r6;
        r6.setAccessible(r2);
        r6 = android.os.Build.VERSION.SDK_INT;
        r3 = 19;
        if (r6 < r3) goto L_0x00e1;
    L_0x00a1:
        r6 = "android.app.ResourcesManager";
        r6 = java.lang.Class.forName(r6);
        r0 = "getInstance";
        r3 = new java.lang.Class[r1];
        r0 = r6.getDeclaredMethod(r0, r3);
        r0.setAccessible(r2);
        r3 = 0;
        r1 = new java.lang.Object[r1];
        r0 = r0.invoke(r3, r1);
        r1 = "mActiveResources";	 Catch:{ NoSuchFieldException -> 0x00cf }
        r1 = r6.getDeclaredField(r1);	 Catch:{ NoSuchFieldException -> 0x00cf }
        r1.setAccessible(r2);	 Catch:{ NoSuchFieldException -> 0x00cf }
        r1 = r1.get(r0);	 Catch:{ NoSuchFieldException -> 0x00cf }
        r1 = (android.util.ArrayMap) r1;	 Catch:{ NoSuchFieldException -> 0x00cf }
        r1 = r1.values();	 Catch:{ NoSuchFieldException -> 0x00cf }
        references = r1;	 Catch:{ NoSuchFieldException -> 0x00cf }
        goto L_0x00f8;
    L_0x00cf:
        r1 = "mResourceReferences";
        r6 = r6.getDeclaredField(r1);
        r6.setAccessible(r2);
        r6 = r6.get(r0);
        r6 = (java.util.Collection) r6;
        references = r6;
        goto L_0x00f8;
    L_0x00e1:
        r6 = "mActiveResources";
        r6 = r0.getDeclaredField(r6);
        r6.setAccessible(r2);
        r0 = currentActivityThread;
        r6 = r6.get(r0);
        r6 = (java.util.HashMap) r6;
        r6 = r6.values();
        references = r6;
    L_0x00f8:
        r6 = references;
        if (r6 != 0) goto L_0x0104;
    L_0x00fc:
        r6 = new java.lang.IllegalStateException;
        r0 = "resource references is null";
        r6.<init>(r0);
        throw r6;
    L_0x0104:
        r6 = android.os.Build.VERSION.SDK_INT;
        r0 = 24;
        if (r6 < r0) goto L_0x0126;
    L_0x010a:
        r6 = android.content.res.Resources.class;	 Catch:{ Throwable -> 0x0118 }
        r0 = "mResourcesImpl";	 Catch:{ Throwable -> 0x0118 }
        r6 = r6.getDeclaredField(r0);	 Catch:{ Throwable -> 0x0118 }
        resourcesImplFiled = r6;	 Catch:{ Throwable -> 0x0118 }
        r6.setAccessible(r2);	 Catch:{ Throwable -> 0x0118 }
        goto L_0x0133;
    L_0x0118:
        r6 = android.content.res.Resources.class;
        r0 = "mAssets";
        r6 = r6.getDeclaredField(r0);
        assetsFiled = r6;
        r6.setAccessible(r2);
        goto L_0x0133;
    L_0x0126:
        r6 = android.content.res.Resources.class;
        r0 = "mAssets";
        r6 = r6.getDeclaredField(r0);
        assetsFiled = r6;
        r6.setAccessible(r2);
    L_0x0133:
        r6 = android.content.pm.ApplicationInfo.class;	 Catch:{ NoSuchFieldException -> 0x013e }
        r0 = "publicSourceDir";	 Catch:{ NoSuchFieldException -> 0x013e }
        r6 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findField(r6, r0);	 Catch:{ NoSuchFieldException -> 0x013e }
        publicSourceDirField = r6;	 Catch:{ NoSuchFieldException -> 0x013e }
        return;
    L_0x013e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.TinkerResourcePatcher.isResourceCanPatch(android.content.Context):void");
    }

    public static void monkeyPatchExistingResources(android.content.Context r8, java.lang.String r9) throws java.lang.Throwable {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r9 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = 2;
        r1 = new java.lang.reflect.Field[r0];
        r2 = packagesFiled;
        r3 = 0;
        r1[r3] = r2;
        r2 = resourcePackagesFiled;
        r4 = 1;
        r1[r4] = r2;
        r2 = r3;
    L_0x0011:
        if (r2 >= r0) goto L_0x0048;
    L_0x0013:
        r5 = r1[r2];
        r6 = currentActivityThread;
        r5 = r5.get(r6);
        r5 = (java.util.Map) r5;
        r5 = r5.entrySet();
        r5 = r5.iterator();
    L_0x0025:
        r6 = r5.hasNext();
        if (r6 == 0) goto L_0x0045;
    L_0x002b:
        r6 = r5.next();
        r6 = (java.util.Map.Entry) r6;
        r6 = r6.getValue();
        r6 = (java.lang.ref.WeakReference) r6;
        r6 = r6.get();
        if (r6 == 0) goto L_0x0025;
    L_0x003d:
        if (r9 == 0) goto L_0x0025;
    L_0x003f:
        r7 = resDir;
        r7.set(r6, r9);
        goto L_0x0025;
    L_0x0045:
        r2 = r2 + 1;
        goto L_0x0011;
    L_0x0048:
        r0 = addAssetPathMethod;
        r1 = newAssetManager;
        r2 = new java.lang.Object[r4];
        r2[r3] = r9;
        r0 = r0.invoke(r1, r2);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        if (r0 != 0) goto L_0x0064;
    L_0x005c:
        r8 = new java.lang.IllegalStateException;
        r9 = "Could not create new AssetManager";
        r8.<init>(r9);
        throw r8;
    L_0x0064:
        r0 = ensureStringBlocksMethod;
        r1 = newAssetManager;
        r2 = new java.lang.Object[r3];
        r0.invoke(r1, r2);
        r0 = references;
        r0 = r0.iterator();
    L_0x0073:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x00b2;
    L_0x0079:
        r1 = r0.next();
        r1 = (java.lang.ref.WeakReference) r1;
        r1 = r1.get();
        r1 = (android.content.res.Resources) r1;
        if (r1 == 0) goto L_0x0073;
    L_0x0087:
        r2 = assetsFiled;	 Catch:{ Throwable -> 0x008f }
        r3 = newAssetManager;	 Catch:{ Throwable -> 0x008f }
        r2.set(r1, r3);	 Catch:{ Throwable -> 0x008f }
        goto L_0x00a3;
    L_0x008f:
        r2 = resourcesImplFiled;
        r2 = r2.get(r1);
        r3 = "mAssets";
        r3 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findField(r2, r3);
        r3.setAccessible(r4);
        r5 = newAssetManager;
        r3.set(r2, r5);
    L_0x00a3:
        clearPreloadTypedArrayIssue(r1);
        r2 = r1.getConfiguration();
        r3 = r1.getDisplayMetrics();
        r1.updateConfiguration(r2, r3);
        goto L_0x0073;
    L_0x00b2:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 24;
        if (r0 < r1) goto L_0x00c5;
    L_0x00b8:
        r0 = publicSourceDirField;	 Catch:{ Throwable -> 0x00c5 }
        if (r0 == 0) goto L_0x00c5;	 Catch:{ Throwable -> 0x00c5 }
    L_0x00bc:
        r0 = publicSourceDirField;	 Catch:{ Throwable -> 0x00c5 }
        r1 = r8.getApplicationInfo();	 Catch:{ Throwable -> 0x00c5 }
        r0.set(r1, r9);	 Catch:{ Throwable -> 0x00c5 }
    L_0x00c5:
        r8 = checkResUpdate(r8);
        if (r8 != 0) goto L_0x00d3;
    L_0x00cb:
        r8 = new com.tencent.tinker.loader.TinkerRuntimeException;
        r9 = "checkResInstall failed";
        r8.<init>(r9);
        throw r8;
    L_0x00d3:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.TinkerResourcePatcher.monkeyPatchExistingResources(android.content.Context, java.lang.String):void");
    }

    private static void clearPreloadTypedArrayIssue(Resources resources) {
        try {
            Field findField = ShareReflectUtil.findField(Resources.class, "mTypedArrayPool");
            Object obj = findField.get(resources);
            Field findField2 = ShareReflectUtil.findField(obj, "mPool");
            Constructor constructor = obj.getClass().getConstructor(new Class[]{Integer.TYPE});
            constructor.setAccessible(true);
            findField.set(resources, constructor.newInstance(new Object[]{Integer.valueOf(((Object[]) findField2.get(obj)).length)}));
        } catch (Resources resources2) {
            new StringBuilder("clearPreloadTypedArrayIssue failed, ignore error: ").append(resources2);
        }
    }

    private static boolean checkResUpdate(Context context) {
        try {
            context.getAssets().open(TEST_ASSETS_VALUE);
            return true;
        } catch (Context context2) {
            new StringBuilder("checkResUpdate failed, can't find test resource assets file only_use_to_test_tinker_resource.txt e:").append(context2.getMessage());
            return null;
        }
    }
}
