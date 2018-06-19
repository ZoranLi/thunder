package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import java.lang.reflect.Field;

class ResourcesFlusher {
    private static final String TAG = "ResourcesFlusher";
    private static Field sDrawableCacheField;
    private static boolean sDrawableCacheFieldFetched;
    private static Field sResourcesImplField;
    private static boolean sResourcesImplFieldFetched;
    private static Class sThemedResourceCacheClazz;
    private static boolean sThemedResourceCacheClazzFetched;
    private static Field sThemedResourceCache_mUnthemedEntriesField;
    private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;

    ResourcesFlusher() {
    }

    static boolean flush(@NonNull Resources resources) {
        if (VERSION.SDK_INT >= 24) {
            return flushNougats(resources);
        }
        if (VERSION.SDK_INT >= 23) {
            return flushMarshmallows(resources);
        }
        return VERSION.SDK_INT >= 21 ? flushLollipops(resources) : null;
    }

    @android.support.annotation.RequiresApi(21)
    private static boolean flushLollipops(@android.support.annotation.NonNull android.content.res.Resources r3) {
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
        r0 = sDrawableCacheFieldFetched;
        r1 = 1;
        if (r0 != 0) goto L_0x0014;
    L_0x0005:
        r0 = android.content.res.Resources.class;	 Catch:{ NoSuchFieldException -> 0x0012 }
        r2 = "mDrawableCache";	 Catch:{ NoSuchFieldException -> 0x0012 }
        r0 = r0.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0012 }
        sDrawableCacheField = r0;	 Catch:{ NoSuchFieldException -> 0x0012 }
        r0.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x0012 }
    L_0x0012:
        sDrawableCacheFieldFetched = r1;
    L_0x0014:
        r0 = sDrawableCacheField;
        if (r0 == 0) goto L_0x0029;
    L_0x0018:
        r0 = 0;
        r2 = sDrawableCacheField;	 Catch:{ IllegalAccessException -> 0x0022 }
        r3 = r2.get(r3);	 Catch:{ IllegalAccessException -> 0x0022 }
        r3 = (java.util.Map) r3;	 Catch:{ IllegalAccessException -> 0x0022 }
        goto L_0x0023;
    L_0x0022:
        r3 = r0;
    L_0x0023:
        if (r3 == 0) goto L_0x0029;
    L_0x0025:
        r3.clear();
        return r1;
    L_0x0029:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.ResourcesFlusher.flushLollipops(android.content.res.Resources):boolean");
    }

    @android.support.annotation.RequiresApi(23)
    private static boolean flushMarshmallows(@android.support.annotation.NonNull android.content.res.Resources r3) {
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
        r0 = sDrawableCacheFieldFetched;
        r1 = 1;
        if (r0 != 0) goto L_0x0014;
    L_0x0005:
        r0 = android.content.res.Resources.class;	 Catch:{ NoSuchFieldException -> 0x0012 }
        r2 = "mDrawableCache";	 Catch:{ NoSuchFieldException -> 0x0012 }
        r0 = r0.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0012 }
        sDrawableCacheField = r0;	 Catch:{ NoSuchFieldException -> 0x0012 }
        r0.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x0012 }
    L_0x0012:
        sDrawableCacheFieldFetched = r1;
    L_0x0014:
        r0 = 0;
        r2 = sDrawableCacheField;
        if (r2 == 0) goto L_0x0020;
    L_0x0019:
        r2 = sDrawableCacheField;	 Catch:{ IllegalAccessException -> 0x0020 }
        r3 = r2.get(r3);	 Catch:{ IllegalAccessException -> 0x0020 }
        goto L_0x0021;
    L_0x0020:
        r3 = r0;
    L_0x0021:
        r0 = 0;
        if (r3 != 0) goto L_0x0025;
    L_0x0024:
        return r0;
    L_0x0025:
        if (r3 == 0) goto L_0x002e;
    L_0x0027:
        r3 = flushThemedResourcesCache(r3);
        if (r3 == 0) goto L_0x002e;
    L_0x002d:
        return r1;
    L_0x002e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.ResourcesFlusher.flushMarshmallows(android.content.res.Resources):boolean");
    }

    @android.support.annotation.RequiresApi(24)
    private static boolean flushNougats(@android.support.annotation.NonNull android.content.res.Resources r5) {
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
        r0 = sResourcesImplFieldFetched;
        r1 = 1;
        if (r0 != 0) goto L_0x0014;
    L_0x0005:
        r0 = android.content.res.Resources.class;	 Catch:{ NoSuchFieldException -> 0x0012 }
        r2 = "mResourcesImpl";	 Catch:{ NoSuchFieldException -> 0x0012 }
        r0 = r0.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0012 }
        sResourcesImplField = r0;	 Catch:{ NoSuchFieldException -> 0x0012 }
        r0.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x0012 }
    L_0x0012:
        sResourcesImplFieldFetched = r1;
    L_0x0014:
        r0 = sResourcesImplField;
        r2 = 0;
        if (r0 != 0) goto L_0x001a;
    L_0x0019:
        return r2;
    L_0x001a:
        r0 = 0;
        r3 = sResourcesImplField;	 Catch:{ IllegalAccessException -> 0x0022 }
        r5 = r3.get(r5);	 Catch:{ IllegalAccessException -> 0x0022 }
        goto L_0x0023;
    L_0x0022:
        r5 = r0;
    L_0x0023:
        if (r5 != 0) goto L_0x0026;
    L_0x0025:
        return r2;
    L_0x0026:
        r3 = sDrawableCacheFieldFetched;
        if (r3 != 0) goto L_0x003b;
    L_0x002a:
        r3 = r5.getClass();	 Catch:{ NoSuchFieldException -> 0x0039 }
        r4 = "mDrawableCache";	 Catch:{ NoSuchFieldException -> 0x0039 }
        r3 = r3.getDeclaredField(r4);	 Catch:{ NoSuchFieldException -> 0x0039 }
        sDrawableCacheField = r3;	 Catch:{ NoSuchFieldException -> 0x0039 }
        r3.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x0039 }
    L_0x0039:
        sDrawableCacheFieldFetched = r1;
    L_0x003b:
        r3 = sDrawableCacheField;
        if (r3 == 0) goto L_0x0046;
    L_0x003f:
        r3 = sDrawableCacheField;	 Catch:{ IllegalAccessException -> 0x0046 }
        r5 = r3.get(r5);	 Catch:{ IllegalAccessException -> 0x0046 }
        goto L_0x0047;
    L_0x0046:
        r5 = r0;
    L_0x0047:
        if (r5 == 0) goto L_0x0050;
    L_0x0049:
        r5 = flushThemedResourcesCache(r5);
        if (r5 == 0) goto L_0x0050;
    L_0x004f:
        return r1;
    L_0x0050:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.ResourcesFlusher.flushNougats(android.content.res.Resources):boolean");
    }

    @android.support.annotation.RequiresApi(16)
    private static boolean flushThemedResourcesCache(@android.support.annotation.NonNull java.lang.Object r4) {
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
        r0 = sThemedResourceCacheClazzFetched;
        r1 = 1;
        if (r0 != 0) goto L_0x000f;
    L_0x0005:
        r0 = "android.content.res.ThemedResourceCache";	 Catch:{ ClassNotFoundException -> 0x000d }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x000d }
        sThemedResourceCacheClazz = r0;	 Catch:{ ClassNotFoundException -> 0x000d }
    L_0x000d:
        sThemedResourceCacheClazzFetched = r1;
    L_0x000f:
        r0 = sThemedResourceCacheClazz;
        r2 = 0;
        if (r0 != 0) goto L_0x0015;
    L_0x0014:
        return r2;
    L_0x0015:
        r0 = sThemedResourceCache_mUnthemedEntriesFieldFetched;
        if (r0 != 0) goto L_0x0028;
    L_0x0019:
        r0 = sThemedResourceCacheClazz;	 Catch:{ NoSuchFieldException -> 0x0026 }
        r3 = "mUnthemedEntries";	 Catch:{ NoSuchFieldException -> 0x0026 }
        r0 = r0.getDeclaredField(r3);	 Catch:{ NoSuchFieldException -> 0x0026 }
        sThemedResourceCache_mUnthemedEntriesField = r0;	 Catch:{ NoSuchFieldException -> 0x0026 }
        r0.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x0026 }
    L_0x0026:
        sThemedResourceCache_mUnthemedEntriesFieldFetched = r1;
    L_0x0028:
        r0 = sThemedResourceCache_mUnthemedEntriesField;
        if (r0 != 0) goto L_0x002d;
    L_0x002c:
        return r2;
    L_0x002d:
        r0 = 0;
        r3 = sThemedResourceCache_mUnthemedEntriesField;	 Catch:{ IllegalAccessException -> 0x0037 }
        r4 = r3.get(r4);	 Catch:{ IllegalAccessException -> 0x0037 }
        r4 = (android.util.LongSparseArray) r4;	 Catch:{ IllegalAccessException -> 0x0037 }
        goto L_0x0038;
    L_0x0037:
        r4 = r0;
    L_0x0038:
        if (r4 == 0) goto L_0x003e;
    L_0x003a:
        r4.clear();
        return r1;
    L_0x003e:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.ResourcesFlusher.flushThemedResourcesCache(java.lang.Object):boolean");
    }
}
