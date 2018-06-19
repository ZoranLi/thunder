package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

class ViewUtils {
    static final Property<View, Rect> CLIP_BOUNDS = new AnonymousClass2(Rect.class, "clipBounds");
    private static final ViewUtilsImpl IMPL;
    private static final String TAG = "ViewUtils";
    static final Property<View, Float> TRANSITION_ALPHA = new AnonymousClass1(Float.class, "translationAlpha");
    private static final int VISIBILITY_MASK = 12;
    private static Field sViewFlagsField;
    private static boolean sViewFlagsFieldFetched;

    final class AnonymousClass1 extends Property<View, Float> {
        AnonymousClass1(Class cls, String str) {
            super(cls, str);
        }

        public final Float get(View view) {
            return Float.valueOf(ViewUtils.getTransitionAlpha(view));
        }

        public final void set(View view, Float f) {
            ViewUtils.setTransitionAlpha(view, f.floatValue());
        }
    }

    final class AnonymousClass2 extends Property<View, Rect> {
        AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        public final Rect get(View view) {
            return ViewCompat.getClipBounds(view);
        }

        public final void set(View view, Rect rect) {
            ViewCompat.setClipBounds(view, rect);
        }
    }

    ViewUtils() {
    }

    static {
        if (VERSION.SDK_INT >= 22) {
            IMPL = new ViewUtilsApi22();
        } else if (VERSION.SDK_INT >= 21) {
            IMPL = new ViewUtilsApi21();
        } else if (VERSION.SDK_INT >= 19) {
            IMPL = new ViewUtilsApi19();
        } else if (VERSION.SDK_INT >= 18) {
            IMPL = new ViewUtilsApi18();
        } else {
            IMPL = new ViewUtilsApi14();
        }
    }

    static ViewOverlayImpl getOverlay(@NonNull View view) {
        return IMPL.getOverlay(view);
    }

    static WindowIdImpl getWindowId(@NonNull View view) {
        return IMPL.getWindowId(view);
    }

    static void setTransitionAlpha(@NonNull View view, float f) {
        IMPL.setTransitionAlpha(view, f);
    }

    static float getTransitionAlpha(@NonNull View view) {
        return IMPL.getTransitionAlpha(view);
    }

    static void saveNonTransitionAlpha(@NonNull View view) {
        IMPL.saveNonTransitionAlpha(view);
    }

    static void clearNonTransitionAlpha(@NonNull View view) {
        IMPL.clearNonTransitionAlpha(view);
    }

    static void setTransitionVisibility(@android.support.annotation.NonNull android.view.View r2, int r3) {
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
        fetchViewFlagsField();
        r0 = sViewFlagsField;
        if (r0 == 0) goto L_0x0016;
    L_0x0007:
        r0 = sViewFlagsField;	 Catch:{ IllegalAccessException -> 0x0016 }
        r0 = r0.getInt(r2);	 Catch:{ IllegalAccessException -> 0x0016 }
        r1 = sViewFlagsField;	 Catch:{ IllegalAccessException -> 0x0016 }
        r0 = r0 & -13;	 Catch:{ IllegalAccessException -> 0x0016 }
        r3 = r3 | r0;	 Catch:{ IllegalAccessException -> 0x0016 }
        r1.setInt(r2, r3);	 Catch:{ IllegalAccessException -> 0x0016 }
        return;
    L_0x0016:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewUtils.setTransitionVisibility(android.view.View, int):void");
    }

    static void transformMatrixToGlobal(@NonNull View view, @NonNull Matrix matrix) {
        IMPL.transformMatrixToGlobal(view, matrix);
    }

    static void transformMatrixToLocal(@NonNull View view, @NonNull Matrix matrix) {
        IMPL.transformMatrixToLocal(view, matrix);
    }

    static void setAnimationMatrix(@NonNull View view, @Nullable Matrix matrix) {
        IMPL.setAnimationMatrix(view, matrix);
    }

    static void setLeftTopRightBottom(@NonNull View view, int i, int i2, int i3, int i4) {
        IMPL.setLeftTopRightBottom(view, i, i2, i3, i4);
    }

    private static void fetchViewFlagsField() {
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
        r0 = sViewFlagsFieldFetched;
        if (r0 != 0) goto L_0x0014;
    L_0x0004:
        r0 = 1;
        r1 = android.view.View.class;	 Catch:{ NoSuchFieldException -> 0x0012 }
        r2 = "mViewFlags";	 Catch:{ NoSuchFieldException -> 0x0012 }
        r1 = r1.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0012 }
        sViewFlagsField = r1;	 Catch:{ NoSuchFieldException -> 0x0012 }
        r1.setAccessible(r0);	 Catch:{ NoSuchFieldException -> 0x0012 }
    L_0x0012:
        sViewFlagsFieldFetched = r0;
    L_0x0014:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewUtils.fetchViewFlagsField():void");
    }
}
