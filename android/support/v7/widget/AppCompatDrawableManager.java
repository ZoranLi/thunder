package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.LruCache;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({Scope.LIBRARY_GROUP})
public final class AppCompatDrawableManager {
    private static final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light};
    private static final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
    private static final ColorFilterLruCache COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
    private static final boolean DEBUG = false;
    private static final Mode DEFAULT_MODE = Mode.SRC_IN;
    private static AppCompatDrawableManager INSTANCE = null;
    private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
    private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
    private static final String TAG = "AppCompatDrawableManager";
    private static final int[] TINT_CHECKABLE_BUTTON_LIST = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material};
    private static final int[] TINT_COLOR_CONTROL_NORMAL = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] TINT_COLOR_CONTROL_STATE_LIST = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
    private ArrayMap<String, InflateDelegate> mDelegates;
    private final Object mDrawableCacheLock = new Object();
    private final WeakHashMap<Context, LongSparseArray<WeakReference<ConstantState>>> mDrawableCaches = new WeakHashMap(0);
    private boolean mHasCheckedVectorDrawableSetup;
    private SparseArrayCompat<String> mKnownDrawableIdTags;
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> mTintLists;
    private TypedValue mTypedValue;

    private interface InflateDelegate {
        Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Theme theme);
    }

    @RequiresApi(11)
    private static class AvdcInflateDelegate implements InflateDelegate {
        AvdcInflateDelegate() {
        }

        public android.graphics.drawable.Drawable createFromXmlInner(@android.support.annotation.NonNull android.content.Context r2, @android.support.annotation.NonNull org.xmlpull.v1.XmlPullParser r3, @android.support.annotation.NonNull android.util.AttributeSet r4, @android.support.annotation.Nullable android.content.res.Resources.Theme r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r1 = this;
            r0 = r2.getResources();	 Catch:{ Exception -> 0x0009 }
            r2 = android.support.graphics.drawable.AnimatedVectorDrawableCompat.createFromXmlInner(r2, r0, r3, r4, r5);	 Catch:{ Exception -> 0x0009 }
            return r2;
        L_0x0009:
            r2 = 0;
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatDrawableManager.AvdcInflateDelegate.createFromXmlInner(android.content.Context, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.graphics.drawable.Drawable");
        }
    }

    private static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i) {
            super(i);
        }

        PorterDuffColorFilter get(int i, Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(generateCacheKey(i, mode)));
        }

        PorterDuffColorFilter put(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(generateCacheKey(i, mode)), porterDuffColorFilter);
        }

        private static int generateCacheKey(int i, Mode mode) {
            return (31 * (i + 31)) + mode.hashCode();
        }
    }

    private static class VdcInflateDelegate implements InflateDelegate {
        VdcInflateDelegate() {
        }

        public android.graphics.drawable.Drawable createFromXmlInner(@android.support.annotation.NonNull android.content.Context r1, @android.support.annotation.NonNull org.xmlpull.v1.XmlPullParser r2, @android.support.annotation.NonNull android.util.AttributeSet r3, @android.support.annotation.Nullable android.content.res.Resources.Theme r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r0 = this;
            r1 = r1.getResources();	 Catch:{ Exception -> 0x0009 }
            r1 = android.support.graphics.drawable.VectorDrawableCompat.createFromXmlInner(r1, r2, r3, r4);	 Catch:{ Exception -> 0x0009 }
            return r1;
        L_0x0009:
            r1 = 0;
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatDrawableManager.VdcInflateDelegate.createFromXmlInner(android.content.Context, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.graphics.drawable.Drawable");
        }
    }

    public static AppCompatDrawableManager get() {
        if (INSTANCE == null) {
            AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
            INSTANCE = appCompatDrawableManager;
            installDefaultInflateDelegates(appCompatDrawableManager);
        }
        return INSTANCE;
    }

    private static void installDefaultInflateDelegates(@NonNull AppCompatDrawableManager appCompatDrawableManager) {
        if (VERSION.SDK_INT < 24) {
            appCompatDrawableManager.addDelegate("vector", new VdcInflateDelegate());
            if (VERSION.SDK_INT >= 11) {
                appCompatDrawableManager.addDelegate("animated-vector", new AvdcInflateDelegate());
            }
        }
    }

    public final Drawable getDrawable(@NonNull Context context, @DrawableRes int i) {
        return getDrawable(context, i, false);
    }

    final Drawable getDrawable(@NonNull Context context, @DrawableRes int i, boolean z) {
        checkVectorDrawableSetup(context);
        Drawable loadDrawableFromDelegates = loadDrawableFromDelegates(context, i);
        if (loadDrawableFromDelegates == null) {
            loadDrawableFromDelegates = createDrawableIfNeeded(context, i);
        }
        if (loadDrawableFromDelegates == null) {
            loadDrawableFromDelegates = ContextCompat.getDrawable(context, i);
        }
        if (loadDrawableFromDelegates != null) {
            loadDrawableFromDelegates = tintDrawable(context, i, z, loadDrawableFromDelegates);
        }
        if (loadDrawableFromDelegates != null) {
            DrawableUtils.fixDrawable(loadDrawableFromDelegates);
        }
        return loadDrawableFromDelegates;
    }

    public final void onConfigurationChanged(@NonNull Context context) {
        synchronized (this.mDrawableCacheLock) {
            LongSparseArray longSparseArray = (LongSparseArray) this.mDrawableCaches.get(context);
            if (longSparseArray != null) {
                longSparseArray.clear();
            }
        }
    }

    private static long createCacheKey(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable createDrawableIfNeeded(@NonNull Context context, @DrawableRes int i) {
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        TypedValue typedValue = this.mTypedValue;
        context.getResources().getValue(i, typedValue, true);
        long createCacheKey = createCacheKey(typedValue);
        Drawable cachedDrawable = getCachedDrawable(context, createCacheKey);
        if (cachedDrawable != null) {
            return cachedDrawable;
        }
        if (i == R.drawable.abc_cab_background_top_material) {
            cachedDrawable = new LayerDrawable(new Drawable[]{getDrawable(context, R.drawable.abc_cab_background_internal_bg), getDrawable(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
        }
        if (cachedDrawable != null) {
            cachedDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            addDrawableToCache(context, createCacheKey, cachedDrawable);
        }
        return cachedDrawable;
    }

    private Drawable tintDrawable(@NonNull Context context, @DrawableRes int i, boolean z, @NonNull Drawable drawable) {
        ColorStateList tintList = getTintList(context, i);
        if (tintList != null) {
            if (DrawableUtils.canSafelyMutateDrawable(drawable) != null) {
                drawable = drawable.mutate();
            }
            drawable = DrawableCompat.wrap(drawable);
            DrawableCompat.setTintList(drawable, tintList);
            context = getTintMode(i);
            if (context == null) {
                return drawable;
            }
            DrawableCompat.setTintMode(drawable, context);
            return drawable;
        } else if (i == R.drawable.abc_seekbar_track_material) {
            r6 = (LayerDrawable) drawable;
            setPorterDuffColorFilter(r6.findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlNormal), DEFAULT_MODE);
            setPorterDuffColorFilter(r6.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlNormal), DEFAULT_MODE);
            setPorterDuffColorFilter(r6.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), DEFAULT_MODE);
            return drawable;
        } else {
            if (!(i == R.drawable.abc_ratingbar_material || i == R.drawable.abc_ratingbar_indicator_material)) {
                if (i != R.drawable.abc_ratingbar_small_material) {
                    if (tintDrawableUsingColorFilter(context, i, drawable) == null && z) {
                        return null;
                    }
                    return drawable;
                }
            }
            r6 = (LayerDrawable) drawable;
            setPorterDuffColorFilter(r6.findDrawableByLayerId(16908288), ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorControlNormal), DEFAULT_MODE);
            setPorterDuffColorFilter(r6.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), DEFAULT_MODE);
            setPorterDuffColorFilter(r6.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated), DEFAULT_MODE);
            return drawable;
        }
    }

    private android.graphics.drawable.Drawable loadDrawableFromDelegates(@android.support.annotation.NonNull android.content.Context r10, @android.support.annotation.DrawableRes int r11) {
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
        r9 = this;
        r0 = r9.mDelegates;
        r1 = 0;
        if (r0 == 0) goto L_0x00b0;
    L_0x0005:
        r0 = r9.mDelegates;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00b0;
    L_0x000d:
        r0 = r9.mKnownDrawableIdTags;
        if (r0 == 0) goto L_0x002c;
    L_0x0011:
        r0 = r9.mKnownDrawableIdTags;
        r0 = r0.get(r11);
        r0 = (java.lang.String) r0;
        r2 = "appcompat_skip_skip";
        r2 = r2.equals(r0);
        if (r2 != 0) goto L_0x002b;
    L_0x0021:
        if (r0 == 0) goto L_0x0033;
    L_0x0023:
        r2 = r9.mDelegates;
        r0 = r2.get(r0);
        if (r0 != 0) goto L_0x0033;
    L_0x002b:
        return r1;
    L_0x002c:
        r0 = new android.support.v4.util.SparseArrayCompat;
        r0.<init>();
        r9.mKnownDrawableIdTags = r0;
    L_0x0033:
        r0 = r9.mTypedValue;
        if (r0 != 0) goto L_0x003e;
    L_0x0037:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r9.mTypedValue = r0;
    L_0x003e:
        r0 = r9.mTypedValue;
        r1 = r10.getResources();
        r2 = 1;
        r1.getValue(r11, r0, r2);
        r3 = createCacheKey(r0);
        r5 = r9.getCachedDrawable(r10, r3);
        if (r5 == 0) goto L_0x0053;
    L_0x0052:
        return r5;
    L_0x0053:
        r6 = r0.string;
        if (r6 == 0) goto L_0x00a6;
    L_0x0057:
        r6 = r0.string;
        r6 = r6.toString();
        r7 = ".xml";
        r6 = r6.endsWith(r7);
        if (r6 == 0) goto L_0x00a6;
    L_0x0065:
        r1 = r1.getXml(r11);	 Catch:{ Exception -> 0x00a6 }
        r6 = android.util.Xml.asAttributeSet(r1);	 Catch:{ Exception -> 0x00a6 }
    L_0x006d:
        r7 = r1.next();	 Catch:{ Exception -> 0x00a6 }
        r8 = 2;	 Catch:{ Exception -> 0x00a6 }
        if (r7 == r8) goto L_0x0076;	 Catch:{ Exception -> 0x00a6 }
    L_0x0074:
        if (r7 != r2) goto L_0x006d;	 Catch:{ Exception -> 0x00a6 }
    L_0x0076:
        if (r7 == r8) goto L_0x0080;	 Catch:{ Exception -> 0x00a6 }
    L_0x0078:
        r10 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ Exception -> 0x00a6 }
        r0 = "No start tag found";	 Catch:{ Exception -> 0x00a6 }
        r10.<init>(r0);	 Catch:{ Exception -> 0x00a6 }
        throw r10;	 Catch:{ Exception -> 0x00a6 }
    L_0x0080:
        r2 = r1.getName();	 Catch:{ Exception -> 0x00a6 }
        r7 = r9.mKnownDrawableIdTags;	 Catch:{ Exception -> 0x00a6 }
        r7.append(r11, r2);	 Catch:{ Exception -> 0x00a6 }
        r7 = r9.mDelegates;	 Catch:{ Exception -> 0x00a6 }
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x00a6 }
        r2 = (android.support.v7.widget.AppCompatDrawableManager.InflateDelegate) r2;	 Catch:{ Exception -> 0x00a6 }
        if (r2 == 0) goto L_0x009c;	 Catch:{ Exception -> 0x00a6 }
    L_0x0093:
        r7 = r10.getTheme();	 Catch:{ Exception -> 0x00a6 }
        r1 = r2.createFromXmlInner(r10, r1, r6, r7);	 Catch:{ Exception -> 0x00a6 }
        r5 = r1;	 Catch:{ Exception -> 0x00a6 }
    L_0x009c:
        if (r5 == 0) goto L_0x00a6;	 Catch:{ Exception -> 0x00a6 }
    L_0x009e:
        r0 = r0.changingConfigurations;	 Catch:{ Exception -> 0x00a6 }
        r5.setChangingConfigurations(r0);	 Catch:{ Exception -> 0x00a6 }
        r9.addDrawableToCache(r10, r3, r5);	 Catch:{ Exception -> 0x00a6 }
    L_0x00a6:
        if (r5 != 0) goto L_0x00af;
    L_0x00a8:
        r10 = r9.mKnownDrawableIdTags;
        r0 = "appcompat_skip_skip";
        r10.append(r11, r0);
    L_0x00af:
        return r5;
    L_0x00b0:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatDrawableManager.loadDrawableFromDelegates(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable getCachedDrawable(@android.support.annotation.NonNull android.content.Context r5, long r6) {
        /*
        r4 = this;
        r0 = r4.mDrawableCacheLock;
        monitor-enter(r0);
        r1 = r4.mDrawableCaches;	 Catch:{ all -> 0x002f }
        r1 = r1.get(r5);	 Catch:{ all -> 0x002f }
        r1 = (android.support.v4.util.LongSparseArray) r1;	 Catch:{ all -> 0x002f }
        r2 = 0;
        if (r1 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r0);	 Catch:{ all -> 0x002f }
        return r2;
    L_0x0010:
        r3 = r1.get(r6);	 Catch:{ all -> 0x002f }
        r3 = (java.lang.ref.WeakReference) r3;	 Catch:{ all -> 0x002f }
        if (r3 == 0) goto L_0x002d;
    L_0x0018:
        r3 = r3.get();	 Catch:{ all -> 0x002f }
        r3 = (android.graphics.drawable.Drawable.ConstantState) r3;	 Catch:{ all -> 0x002f }
        if (r3 == 0) goto L_0x002a;
    L_0x0020:
        r5 = r5.getResources();	 Catch:{ all -> 0x002f }
        r5 = r3.newDrawable(r5);	 Catch:{ all -> 0x002f }
        monitor-exit(r0);	 Catch:{ all -> 0x002f }
        return r5;
    L_0x002a:
        r1.delete(r6);	 Catch:{ all -> 0x002f }
    L_0x002d:
        monitor-exit(r0);	 Catch:{ all -> 0x002f }
        return r2;
    L_0x002f:
        r5 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x002f }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatDrawableManager.getCachedDrawable(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    private boolean addDrawableToCache(@NonNull Context context, long j, @NonNull Drawable drawable) {
        drawable = drawable.getConstantState();
        if (drawable == null) {
            return null;
        }
        synchronized (this.mDrawableCacheLock) {
            LongSparseArray longSparseArray = (LongSparseArray) this.mDrawableCaches.get(context);
            if (longSparseArray == null) {
                longSparseArray = new LongSparseArray();
                this.mDrawableCaches.put(context, longSparseArray);
            }
            longSparseArray.put(j, new WeakReference(drawable));
        }
        return true;
    }

    final Drawable onDrawableLoadedFromResources(@NonNull Context context, @NonNull VectorEnabledTintResources vectorEnabledTintResources, @DrawableRes int i) {
        Drawable loadDrawableFromDelegates = loadDrawableFromDelegates(context, i);
        if (loadDrawableFromDelegates == null) {
            loadDrawableFromDelegates = vectorEnabledTintResources.superGetDrawable(i);
        }
        return loadDrawableFromDelegates != null ? tintDrawable(context, i, null, loadDrawableFromDelegates) : null;
    }

    static boolean tintDrawableUsingColorFilter(@NonNull Context context, @DrawableRes int i, @NonNull Drawable drawable) {
        int round;
        Mode mode = DEFAULT_MODE;
        int i2 = 16842801;
        if (arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i)) {
            i2 = R.attr.colorControlNormal;
        } else if (arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, i)) {
            i2 = R.attr.colorControlActivated;
        } else if (arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i)) {
            mode = Mode.MULTIPLY;
        } else if (i == R.drawable.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            round = Math.round(1109603123);
            i = 1;
            if (i != 0) {
                return false;
            }
            if (DrawableUtils.canSafelyMutateDrawable(drawable) != 0) {
                drawable = drawable.mutate();
            }
            drawable.setColorFilter(getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(context, i2), mode));
            if (round != -1) {
                drawable.setAlpha(round);
            }
            return true;
        } else if (i != R.drawable.abc_dialog_material_background) {
            round = -1;
            i = 0;
            i2 = i;
            if (i != 0) {
                return false;
            }
            if (DrawableUtils.canSafelyMutateDrawable(drawable) != 0) {
                drawable = drawable.mutate();
            }
            drawable.setColorFilter(getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(context, i2), mode));
            if (round != -1) {
                drawable.setAlpha(round);
            }
            return true;
        }
        round = -1;
        i = 1;
        if (i != 0) {
            return false;
        }
        if (DrawableUtils.canSafelyMutateDrawable(drawable) != 0) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(context, i2), mode));
        if (round != -1) {
            drawable.setAlpha(round);
        }
        return true;
    }

    private void addDelegate(@NonNull String str, @NonNull InflateDelegate inflateDelegate) {
        if (this.mDelegates == null) {
            this.mDelegates = new ArrayMap();
        }
        this.mDelegates.put(str, inflateDelegate);
    }

    private void removeDelegate(@NonNull String str, @NonNull InflateDelegate inflateDelegate) {
        if (this.mDelegates != null && this.mDelegates.get(str) == inflateDelegate) {
            this.mDelegates.remove(str);
        }
    }

    private static boolean arrayContains(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return 1;
            }
        }
        return false;
    }

    static Mode getTintMode(int i) {
        return i == R.drawable.abc_switch_thumb_material ? Mode.MULTIPLY : 0;
    }

    final ColorStateList getTintList(@NonNull Context context, @DrawableRes int i) {
        ColorStateList tintListFromCache = getTintListFromCache(context, i);
        if (tintListFromCache == null) {
            if (i == R.drawable.abc_edit_text_material) {
                tintListFromCache = AppCompatResources.getColorStateList(context, R.color.abc_tint_edittext);
            } else if (i == R.drawable.abc_switch_track_mtrl_alpha) {
                tintListFromCache = AppCompatResources.getColorStateList(context, R.color.abc_tint_switch_track);
            } else if (i == R.drawable.abc_switch_thumb_material) {
                tintListFromCache = createSwitchThumbColorStateList(context);
            } else if (i == R.drawable.abc_btn_default_mtrl_shape) {
                tintListFromCache = createDefaultButtonColorStateList(context);
            } else if (i == R.drawable.abc_btn_borderless_material) {
                tintListFromCache = createBorderlessButtonColorStateList(context);
            } else if (i == R.drawable.abc_btn_colored_material) {
                tintListFromCache = createColoredButtonColorStateList(context);
            } else {
                if (i != R.drawable.abc_spinner_mtrl_am_alpha) {
                    if (i != R.drawable.abc_spinner_textfield_background_material) {
                        if (arrayContains(TINT_COLOR_CONTROL_NORMAL, i)) {
                            tintListFromCache = ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorControlNormal);
                        } else if (arrayContains(TINT_COLOR_CONTROL_STATE_LIST, i)) {
                            tintListFromCache = AppCompatResources.getColorStateList(context, R.color.abc_tint_default);
                        } else if (arrayContains(TINT_CHECKABLE_BUTTON_LIST, i)) {
                            tintListFromCache = AppCompatResources.getColorStateList(context, R.color.abc_tint_btn_checkable);
                        } else if (i == R.drawable.abc_seekbar_thumb_material) {
                            tintListFromCache = AppCompatResources.getColorStateList(context, R.color.abc_tint_seek_thumb);
                        }
                    }
                }
                tintListFromCache = AppCompatResources.getColorStateList(context, R.color.abc_tint_spinner);
            }
            if (tintListFromCache != null) {
                addTintListToCache(context, i, tintListFromCache);
            }
        }
        return tintListFromCache;
    }

    private ColorStateList getTintListFromCache(@NonNull Context context, @DrawableRes int i) {
        if (this.mTintLists == null) {
            return null;
        }
        SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) this.mTintLists.get(context);
        if (sparseArrayCompat != null) {
            return (ColorStateList) sparseArrayCompat.get(i);
        }
        return null;
    }

    private void addTintListToCache(@NonNull Context context, @DrawableRes int i, @NonNull ColorStateList colorStateList) {
        if (this.mTintLists == null) {
            this.mTintLists = new WeakHashMap();
        }
        SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) this.mTintLists.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat();
            this.mTintLists.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.append(i, colorStateList);
    }

    private ColorStateList createDefaultButtonColorStateList(@NonNull Context context) {
        return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorButtonNormal));
    }

    private ColorStateList createBorderlessButtonColorStateList(@NonNull Context context) {
        return createButtonColorStateList(context, 0);
    }

    private ColorStateList createColoredButtonColorStateList(@NonNull Context context) {
        return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorAccent));
    }

    private ColorStateList createButtonColorStateList(@NonNull Context context, @ColorInt int i) {
        r1 = new int[4][];
        r0 = new int[4];
        int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlHighlight);
        context = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorButtonNormal);
        r1[0] = ThemeUtils.DISABLED_STATE_SET;
        r0[0] = context;
        r1[1] = ThemeUtils.PRESSED_STATE_SET;
        r0[1] = ColorUtils.compositeColors(themeAttrColor, i);
        r1[2] = ThemeUtils.FOCUSED_STATE_SET;
        r0[2] = ColorUtils.compositeColors(themeAttrColor, i);
        r1[3] = ThemeUtils.EMPTY_STATE_SET;
        r0[3] = i;
        return new ColorStateList(r1, r0);
    }

    private ColorStateList createSwitchThumbColorStateList(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorSwitchThumbNormal);
        if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
            iArr[0] = ThemeUtils.DISABLED_STATE_SET;
            iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
            iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
            iArr2[2] = ThemeUtils.getThemeAttrColor(context, R.attr.colorSwitchThumbNormal);
        } else {
            iArr[0] = ThemeUtils.DISABLED_STATE_SET;
            iArr2[0] = themeAttrColorStateList.getColorForState(iArr[0], 0);
            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
            iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
            iArr2[2] = themeAttrColorStateList.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        if (!DrawableUtils.canSafelyMutateDrawable(drawable) || drawable.mutate() == drawable) {
            if (!tintInfo.mHasTintList) {
                if (!tintInfo.mHasTintMode) {
                    drawable.clearColorFilter();
                    if (VERSION.SDK_INT <= 23) {
                        drawable.invalidateSelf();
                    }
                }
            }
            drawable.setColorFilter(createTintFilter(tintInfo.mHasTintList ? tintInfo.mTintList : null, tintInfo.mHasTintMode ? tintInfo.mTintMode : DEFAULT_MODE, iArr));
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    private static PorterDuffColorFilter createTintFilter(ColorStateList colorStateList, Mode mode, int[] iArr) {
        if (colorStateList != null) {
            if (mode != null) {
                return getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode);
            }
        }
        return null;
    }

    public static PorterDuffColorFilter getPorterDuffColorFilter(int i, Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter = COLOR_FILTER_CACHE.get(i, mode);
        if (porterDuffColorFilter != null) {
            return porterDuffColorFilter;
        }
        porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        COLOR_FILTER_CACHE.put(i, mode, porterDuffColorFilter);
        return porterDuffColorFilter;
    }

    private static void setPorterDuffColorFilter(Drawable drawable, int i, Mode mode) {
        if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = DEFAULT_MODE;
        }
        drawable.setColorFilter(getPorterDuffColorFilter(i, mode));
    }

    private void checkVectorDrawableSetup(@NonNull Context context) {
        if (!this.mHasCheckedVectorDrawableSetup) {
            this.mHasCheckedVectorDrawableSetup = true;
            context = getDrawable(context, R.drawable.abc_vector_test);
            if (context != null) {
                if (isVectorDrawable(context) != null) {
                    return;
                }
            }
            this.mHasCheckedVectorDrawableSetup = null;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static boolean isVectorDrawable(@NonNull Drawable drawable) {
        if (!(drawable instanceof VectorDrawableCompat)) {
            if (PLATFORM_VD_CLAZZ.equals(drawable.getClass().getName()) == null) {
                return null;
            }
        }
        return true;
    }
}
