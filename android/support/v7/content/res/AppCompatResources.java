package android.support.v7.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

public final class AppCompatResources {
    private static final String LOG_TAG = "AppCompatResources";
    private static final ThreadLocal<TypedValue> TL_TYPED_VALUE = new ThreadLocal();
    private static final Object sColorStateCacheLock = new Object();
    private static final WeakHashMap<Context, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = new WeakHashMap(0);

    private static class ColorStateListCacheEntry {
        final Configuration configuration;
        final ColorStateList value;

        ColorStateListCacheEntry(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration) {
            this.value = colorStateList;
            this.configuration = configuration;
        }
    }

    private AppCompatResources() {
    }

    public static ColorStateList getColorStateList(@NonNull Context context, @ColorRes int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList cachedColorStateList = getCachedColorStateList(context, i);
        if (cachedColorStateList != null) {
            return cachedColorStateList;
        }
        cachedColorStateList = inflateColorStateList(context, i);
        if (cachedColorStateList == null) {
            return ContextCompat.getColorStateList(context, i);
        }
        addColorStateListToCache(context, i, cachedColorStateList);
        return cachedColorStateList;
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context context, @DrawableRes int i) {
        return AppCompatDrawableManager.get().getDrawable(context, i);
    }

    @android.support.annotation.Nullable
    private static android.content.res.ColorStateList inflateColorStateList(android.content.Context r2, int r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = isColorInt(r2, r3);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = r2.getResources();
        r3 = r0.getXml(r3);
        r2 = r2.getTheme();	 Catch:{ Exception -> 0x0019 }
        r2 = android.support.v7.content.res.AppCompatColorStateListInflater.createFromXml(r0, r3, r2);	 Catch:{ Exception -> 0x0019 }
        return r2;
    L_0x0019:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.content.res.AppCompatResources.inflateColorStateList(android.content.Context, int):android.content.res.ColorStateList");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.Nullable
    private static android.content.res.ColorStateList getCachedColorStateList(@android.support.annotation.NonNull android.content.Context r4, @android.support.annotation.ColorRes int r5) {
        /*
        r0 = sColorStateCacheLock;
        monitor-enter(r0);
        r1 = sColorStateCaches;	 Catch:{ all -> 0x0035 }
        r1 = r1.get(r4);	 Catch:{ all -> 0x0035 }
        r1 = (android.util.SparseArray) r1;	 Catch:{ all -> 0x0035 }
        if (r1 == 0) goto L_0x0032;
    L_0x000d:
        r2 = r1.size();	 Catch:{ all -> 0x0035 }
        if (r2 <= 0) goto L_0x0032;
    L_0x0013:
        r2 = r1.get(r5);	 Catch:{ all -> 0x0035 }
        r2 = (android.support.v7.content.res.AppCompatResources.ColorStateListCacheEntry) r2;	 Catch:{ all -> 0x0035 }
        if (r2 == 0) goto L_0x0032;
    L_0x001b:
        r3 = r2.configuration;	 Catch:{ all -> 0x0035 }
        r4 = r4.getResources();	 Catch:{ all -> 0x0035 }
        r4 = r4.getConfiguration();	 Catch:{ all -> 0x0035 }
        r4 = r3.equals(r4);	 Catch:{ all -> 0x0035 }
        if (r4 == 0) goto L_0x002f;
    L_0x002b:
        r4 = r2.value;	 Catch:{ all -> 0x0035 }
        monitor-exit(r0);	 Catch:{ all -> 0x0035 }
        return r4;
    L_0x002f:
        r1.remove(r5);	 Catch:{ all -> 0x0035 }
    L_0x0032:
        monitor-exit(r0);	 Catch:{ all -> 0x0035 }
        r4 = 0;
        return r4;
    L_0x0035:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0035 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.content.res.AppCompatResources.getCachedColorStateList(android.content.Context, int):android.content.res.ColorStateList");
    }

    private static void addColorStateListToCache(@NonNull Context context, @ColorRes int i, @NonNull ColorStateList colorStateList) {
        synchronized (sColorStateCacheLock) {
            SparseArray sparseArray = (SparseArray) sColorStateCaches.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                sColorStateCaches.put(context, sparseArray);
            }
            sparseArray.append(i, new ColorStateListCacheEntry(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static boolean isColorInt(@NonNull Context context, @ColorRes int i) {
        context = context.getResources();
        TypedValue typedValue = getTypedValue();
        context.getValue(i, typedValue, true);
        if (typedValue.type < 28 || typedValue.type > 31) {
            return null;
        }
        return true;
    }

    @NonNull
    private static TypedValue getTypedValue() {
        TypedValue typedValue = (TypedValue) TL_TYPED_VALUE.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        TL_TYPED_VALUE.set(typedValue);
        return typedValue;
    }
}
