package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableCompat {
    static final DrawableCompatBaseImpl IMPL;

    static class DrawableCompatBaseImpl {
        public void applyTheme(Drawable drawable, Theme theme) {
        }

        public boolean canApplyTheme(Drawable drawable) {
            return false;
        }

        public int getAlpha(Drawable drawable) {
            return 0;
        }

        public ColorFilter getColorFilter(Drawable drawable) {
            return null;
        }

        public int getLayoutDirection(Drawable drawable) {
            return 0;
        }

        public boolean isAutoMirrored(Drawable drawable) {
            return false;
        }

        public void setAutoMirrored(Drawable drawable, boolean z) {
        }

        public void setHotspot(Drawable drawable, float f, float f2) {
        }

        public void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public boolean setLayoutDirection(Drawable drawable, int i) {
            return false;
        }

        DrawableCompatBaseImpl() {
        }

        public void jumpToCurrentState(Drawable drawable) {
            drawable.jumpToCurrentState();
        }

        public void setTint(Drawable drawable, int i) {
            if (drawable instanceof TintAwareDrawable) {
                ((TintAwareDrawable) drawable).setTint(i);
            }
        }

        public void setTintList(Drawable drawable, ColorStateList colorStateList) {
            if (drawable instanceof TintAwareDrawable) {
                ((TintAwareDrawable) drawable).setTintList(colorStateList);
            }
        }

        public void setTintMode(Drawable drawable, Mode mode) {
            if (drawable instanceof TintAwareDrawable) {
                ((TintAwareDrawable) drawable).setTintMode(mode);
            }
        }

        public Drawable wrap(Drawable drawable) {
            return !(drawable instanceof TintAwareDrawable) ? new DrawableWrapperApi14(drawable) : drawable;
        }

        public void clearColorFilter(Drawable drawable) {
            drawable.clearColorFilter();
        }

        public void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws IOException, XmlPullParserException {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    @RequiresApi(17)
    static class DrawableCompatApi17Impl extends DrawableCompatBaseImpl {
        private static final String TAG = "DrawableCompatApi17";
        private static Method sGetLayoutDirectionMethod;
        private static boolean sGetLayoutDirectionMethodFetched;
        private static Method sSetLayoutDirectionMethod;
        private static boolean sSetLayoutDirectionMethodFetched;

        DrawableCompatApi17Impl() {
        }

        public boolean setLayoutDirection(android.graphics.drawable.Drawable r7, int r8) {
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
            r6 = this;
            r0 = sSetLayoutDirectionMethodFetched;
            r1 = 0;
            r2 = 1;
            if (r0 != 0) goto L_0x001b;
        L_0x0006:
            r0 = android.graphics.drawable.Drawable.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r3 = "setLayoutDirection";	 Catch:{ NoSuchMethodException -> 0x0019 }
            r4 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0019 }
            r5 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r4[r1] = r5;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r0 = r0.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0019 }
            sSetLayoutDirectionMethod = r0;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r0.setAccessible(r2);	 Catch:{ NoSuchMethodException -> 0x0019 }
        L_0x0019:
            sSetLayoutDirectionMethodFetched = r2;
        L_0x001b:
            r0 = sSetLayoutDirectionMethod;
            if (r0 == 0) goto L_0x0030;
        L_0x001f:
            r0 = sSetLayoutDirectionMethod;	 Catch:{ Exception -> 0x002d }
            r3 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x002d }
            r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x002d }
            r3[r1] = r8;	 Catch:{ Exception -> 0x002d }
            r0.invoke(r7, r3);	 Catch:{ Exception -> 0x002d }
            return r2;
        L_0x002d:
            r7 = 0;
            sSetLayoutDirectionMethod = r7;
        L_0x0030:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatApi17Impl.setLayoutDirection(android.graphics.drawable.Drawable, int):boolean");
        }

        public int getLayoutDirection(android.graphics.drawable.Drawable r6) {
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
            r5 = this;
            r0 = sGetLayoutDirectionMethodFetched;
            r1 = 0;
            if (r0 != 0) goto L_0x0017;
        L_0x0005:
            r0 = 1;
            r2 = android.graphics.drawable.Drawable.class;	 Catch:{ NoSuchMethodException -> 0x0015 }
            r3 = "getLayoutDirection";	 Catch:{ NoSuchMethodException -> 0x0015 }
            r4 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x0015 }
            r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0015 }
            sGetLayoutDirectionMethod = r2;	 Catch:{ NoSuchMethodException -> 0x0015 }
            r2.setAccessible(r0);	 Catch:{ NoSuchMethodException -> 0x0015 }
        L_0x0015:
            sGetLayoutDirectionMethodFetched = r0;
        L_0x0017:
            r0 = sGetLayoutDirectionMethod;
            if (r0 == 0) goto L_0x002d;
        L_0x001b:
            r0 = sGetLayoutDirectionMethod;	 Catch:{ Exception -> 0x002a }
            r2 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x002a }
            r6 = r0.invoke(r6, r2);	 Catch:{ Exception -> 0x002a }
            r6 = (java.lang.Integer) r6;	 Catch:{ Exception -> 0x002a }
            r6 = r6.intValue();	 Catch:{ Exception -> 0x002a }
            return r6;
        L_0x002a:
            r6 = 0;
            sGetLayoutDirectionMethod = r6;
        L_0x002d:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.drawable.DrawableCompat.DrawableCompatApi17Impl.getLayoutDirection(android.graphics.drawable.Drawable):int");
        }
    }

    @RequiresApi(19)
    static class DrawableCompatApi19Impl extends DrawableCompatApi17Impl {
        DrawableCompatApi19Impl() {
        }

        public void setAutoMirrored(Drawable drawable, boolean z) {
            drawable.setAutoMirrored(z);
        }

        public boolean isAutoMirrored(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        public Drawable wrap(Drawable drawable) {
            return !(drawable instanceof TintAwareDrawable) ? new DrawableWrapperApi19(drawable) : drawable;
        }

        public int getAlpha(Drawable drawable) {
            return drawable.getAlpha();
        }
    }

    @RequiresApi(21)
    static class DrawableCompatApi21Impl extends DrawableCompatApi19Impl {
        DrawableCompatApi21Impl() {
        }

        public void setHotspot(Drawable drawable, float f, float f2) {
            drawable.setHotspot(f, f2);
        }

        public void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }

        public void setTint(Drawable drawable, int i) {
            drawable.setTint(i);
        }

        public void setTintList(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        public void setTintMode(Drawable drawable, Mode mode) {
            drawable.setTintMode(mode);
        }

        public Drawable wrap(Drawable drawable) {
            return !(drawable instanceof TintAwareDrawable) ? new DrawableWrapperApi21(drawable) : drawable;
        }

        public void applyTheme(Drawable drawable, Theme theme) {
            drawable.applyTheme(theme);
        }

        public boolean canApplyTheme(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        public ColorFilter getColorFilter(Drawable drawable) {
            return drawable.getColorFilter();
        }

        public void clearColorFilter(Drawable drawable) {
            drawable.clearColorFilter();
            if (drawable instanceof InsetDrawable) {
                clearColorFilter(((InsetDrawable) drawable).getDrawable());
            } else if (drawable instanceof DrawableWrapper) {
                clearColorFilter(((DrawableWrapper) drawable).getWrappedDrawable());
            } else {
                if (drawable instanceof DrawableContainer) {
                    DrawableContainerState drawableContainerState = (DrawableContainerState) ((DrawableContainer) drawable).getConstantState();
                    if (drawableContainerState != null) {
                        int childCount = drawableContainerState.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            Drawable child = drawableContainerState.getChild(i);
                            if (child != null) {
                                clearColorFilter(child);
                            }
                        }
                    }
                }
            }
        }

        public void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws IOException, XmlPullParserException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }
    }

    @RequiresApi(23)
    static class DrawableCompatApi23Impl extends DrawableCompatApi21Impl {
        public Drawable wrap(Drawable drawable) {
            return drawable;
        }

        DrawableCompatApi23Impl() {
        }

        public boolean setLayoutDirection(Drawable drawable, int i) {
            return drawable.setLayoutDirection(i);
        }

        public int getLayoutDirection(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        public void clearColorFilter(Drawable drawable) {
            drawable.clearColorFilter();
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            IMPL = new DrawableCompatApi23Impl();
        } else if (VERSION.SDK_INT >= 21) {
            IMPL = new DrawableCompatApi21Impl();
        } else if (VERSION.SDK_INT >= 19) {
            IMPL = new DrawableCompatApi19Impl();
        } else if (VERSION.SDK_INT >= 17) {
            IMPL = new DrawableCompatApi17Impl();
        } else {
            IMPL = new DrawableCompatBaseImpl();
        }
    }

    public static void jumpToCurrentState(@NonNull Drawable drawable) {
        IMPL.jumpToCurrentState(drawable);
    }

    public static void setAutoMirrored(@NonNull Drawable drawable, boolean z) {
        IMPL.setAutoMirrored(drawable, z);
    }

    public static boolean isAutoMirrored(@NonNull Drawable drawable) {
        return IMPL.isAutoMirrored(drawable);
    }

    public static void setHotspot(@NonNull Drawable drawable, float f, float f2) {
        IMPL.setHotspot(drawable, f, f2);
    }

    public static void setHotspotBounds(@NonNull Drawable drawable, int i, int i2, int i3, int i4) {
        IMPL.setHotspotBounds(drawable, i, i2, i3, i4);
    }

    public static void setTint(@NonNull Drawable drawable, @ColorInt int i) {
        IMPL.setTint(drawable, i);
    }

    public static void setTintList(@NonNull Drawable drawable, @Nullable ColorStateList colorStateList) {
        IMPL.setTintList(drawable, colorStateList);
    }

    public static void setTintMode(@NonNull Drawable drawable, @Nullable Mode mode) {
        IMPL.setTintMode(drawable, mode);
    }

    public static int getAlpha(@NonNull Drawable drawable) {
        return IMPL.getAlpha(drawable);
    }

    public static void applyTheme(@NonNull Drawable drawable, @NonNull Theme theme) {
        IMPL.applyTheme(drawable, theme);
    }

    public static boolean canApplyTheme(@NonNull Drawable drawable) {
        return IMPL.canApplyTheme(drawable);
    }

    public static ColorFilter getColorFilter(@NonNull Drawable drawable) {
        return IMPL.getColorFilter(drawable);
    }

    public static void clearColorFilter(@NonNull Drawable drawable) {
        IMPL.clearColorFilter(drawable);
    }

    public static void inflate(@NonNull Drawable drawable, @NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Theme theme) throws XmlPullParserException, IOException {
        IMPL.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static Drawable wrap(@NonNull Drawable drawable) {
        return IMPL.wrap(drawable);
    }

    public static <T extends Drawable> T unwrap(@NonNull Drawable drawable) {
        return drawable instanceof DrawableWrapper ? ((DrawableWrapper) drawable).getWrappedDrawable() : drawable;
    }

    public static boolean setLayoutDirection(@NonNull Drawable drawable, int i) {
        return IMPL.setLayoutDirection(drawable, i);
    }

    public static int getLayoutDirection(@NonNull Drawable drawable) {
        return IMPL.getLayoutDirection(drawable);
    }

    private DrawableCompat() {
    }
}
