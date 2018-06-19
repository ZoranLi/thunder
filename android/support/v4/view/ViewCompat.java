package android.support.v4.view;

import android.animation.ValueAnimator;
import android.content.ClipData;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.Display;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.WeakHashMap;

public class ViewCompat {
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    static final ViewCompatBaseImpl IMPL;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    @Deprecated
    public static final int LAYER_TYPE_HARDWARE = 2;
    @Deprecated
    public static final int LAYER_TYPE_NONE = 0;
    @Deprecated
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYOUT_DIRECTION_INHERIT = 2;
    public static final int LAYOUT_DIRECTION_LOCALE = 3;
    public static final int LAYOUT_DIRECTION_LTR = 0;
    public static final int LAYOUT_DIRECTION_RTL = 1;
    @Deprecated
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    @Deprecated
    public static final int MEASURED_SIZE_MASK = 16777215;
    @Deprecated
    public static final int MEASURED_STATE_MASK = -16777216;
    @Deprecated
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;
    @Deprecated
    public static final int OVER_SCROLL_ALWAYS = 0;
    @Deprecated
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    @Deprecated
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int SCROLL_INDICATOR_BOTTOM = 2;
    public static final int SCROLL_INDICATOR_END = 32;
    public static final int SCROLL_INDICATOR_LEFT = 4;
    public static final int SCROLL_INDICATOR_RIGHT = 8;
    public static final int SCROLL_INDICATOR_START = 16;
    public static final int SCROLL_INDICATOR_TOP = 1;
    private static final String TAG = "ViewCompat";
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;

    @Retention(RetentionPolicy.SOURCE)
    private @interface AccessibilityLiveRegion {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusDirection {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRealDirection {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FocusRelativeDirection {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface ImportantForAccessibility {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface LayerType {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface LayoutDirectionMode {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface NestedScrollType {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface OverScroll {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface ResolvedLayoutDirectionMode {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollAxis {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollIndicators {
    }

    static class ViewCompatBaseImpl {
        static boolean sAccessibilityDelegateCheckFailed = false;
        static Field sAccessibilityDelegateField;
        private static Method sChildrenDrawingOrderMethod;
        private static Field sMinHeightField;
        private static boolean sMinHeightFieldFetched;
        private static Field sMinWidthField;
        private static boolean sMinWidthFieldFetched;
        private static WeakHashMap<View, String> sTransitionNameMap;
        private Method mDispatchFinishTemporaryDetach;
        private Method mDispatchStartTemporaryDetach;
        private boolean mTempDetachBound;
        WeakHashMap<View, ViewPropertyAnimatorCompat> mViewPropertyAnimatorCompatMap = null;

        public void addKeyboardNavigationClusters(@NonNull View view, @NonNull Collection<View> collection, int i) {
        }

        public void cancelDragAndDrop(View view) {
        }

        public WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public int getAccessibilityLiveRegion(View view) {
            return 0;
        }

        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
            return null;
        }

        public Rect getClipBounds(View view) {
            return null;
        }

        public float getElevation(View view) {
            return 0.0f;
        }

        public boolean getFitsSystemWindows(View view) {
            return false;
        }

        public int getImportantForAccessibility(View view) {
            return 0;
        }

        public int getLabelFor(View view) {
            return 0;
        }

        public int getLayoutDirection(View view) {
            return 0;
        }

        public int getNextClusterForwardId(@NonNull View view) {
            return -1;
        }

        public int getScrollIndicators(View view) {
            return 0;
        }

        public float getTranslationZ(View view) {
            return 0.0f;
        }

        public int getWindowSystemUiVisibility(View view) {
            return 0;
        }

        public boolean hasOnClickListeners(View view) {
            return false;
        }

        public boolean hasOverlappingRendering(View view) {
            return true;
        }

        public boolean hasTransientState(View view) {
            return false;
        }

        public boolean isFocusedByDefault(@NonNull View view) {
            return false;
        }

        public boolean isImportantForAccessibility(View view) {
            return true;
        }

        public boolean isInLayout(View view) {
            return false;
        }

        public boolean isKeyboardNavigationCluster(@NonNull View view) {
            return false;
        }

        public boolean isLayoutDirectionResolved(View view) {
            return false;
        }

        public boolean isPaddingRelative(View view) {
            return false;
        }

        public View keyboardNavigationClusterSearch(@NonNull View view, View view2, int i) {
            return null;
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return false;
        }

        public void requestApplyInsets(View view) {
        }

        public void setAccessibilityLiveRegion(View view, int i) {
        }

        public void setClipBounds(View view, Rect rect) {
        }

        public void setElevation(View view, float f) {
        }

        public void setFocusedByDefault(@NonNull View view, boolean z) {
        }

        public void setHasTransientState(View view, boolean z) {
        }

        public void setImportantForAccessibility(View view, int i) {
        }

        public void setKeyboardNavigationCluster(@NonNull View view, boolean z) {
        }

        public void setLabelFor(View view, int i) {
        }

        public void setLayoutDirection(View view, int i) {
        }

        public void setNextClusterForwardId(@NonNull View view, int i) {
        }

        public void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        }

        public void setPointerIcon(View view, PointerIconCompat pointerIconCompat) {
        }

        public void setScrollIndicators(View view, int i) {
        }

        public void setScrollIndicators(View view, int i, int i2) {
        }

        public void setTooltipText(View view, CharSequence charSequence) {
        }

        public void setTranslationZ(View view, float f) {
        }

        public void setZ(View view, float f) {
        }

        public void updateDragShadow(View view, DragShadowBuilder dragShadowBuilder) {
        }

        ViewCompatBaseImpl() {
        }

        public void setAccessibilityDelegate(View view, @Nullable AccessibilityDelegateCompat accessibilityDelegateCompat) {
            view.setAccessibilityDelegate(accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.getBridge());
        }

        public boolean hasAccessibilityDelegate(android.view.View r5) {
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
            r4 = this;
            r0 = sAccessibilityDelegateCheckFailed;
            r1 = 0;
            if (r0 == 0) goto L_0x0006;
        L_0x0005:
            return r1;
        L_0x0006:
            r0 = sAccessibilityDelegateField;
            r2 = 1;
            if (r0 != 0) goto L_0x001c;
        L_0x000b:
            r0 = android.view.View.class;	 Catch:{ Throwable -> 0x0019 }
            r3 = "mAccessibilityDelegate";	 Catch:{ Throwable -> 0x0019 }
            r0 = r0.getDeclaredField(r3);	 Catch:{ Throwable -> 0x0019 }
            sAccessibilityDelegateField = r0;	 Catch:{ Throwable -> 0x0019 }
            r0.setAccessible(r2);	 Catch:{ Throwable -> 0x0019 }
            goto L_0x001c;
        L_0x0019:
            sAccessibilityDelegateCheckFailed = r2;
            return r1;
        L_0x001c:
            r0 = sAccessibilityDelegateField;	 Catch:{ Throwable -> 0x0026 }
            r5 = r0.get(r5);	 Catch:{ Throwable -> 0x0026 }
            if (r5 == 0) goto L_0x0025;
        L_0x0024:
            return r2;
        L_0x0025:
            return r1;
        L_0x0026:
            sAccessibilityDelegateCheckFailed = r2;
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewCompat.ViewCompatBaseImpl.hasAccessibilityDelegate(android.view.View):boolean");
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat.unwrap());
        }

        public boolean startDragAndDrop(View view, ClipData clipData, DragShadowBuilder dragShadowBuilder, Object obj, int i) {
            return view.startDrag(clipData, dragShadowBuilder, obj, i);
        }

        public void postInvalidateOnAnimation(View view) {
            view.postInvalidate();
        }

        public void postInvalidateOnAnimation(View view, int i, int i2, int i3, int i4) {
            view.postInvalidate(i, i2, i3, i4);
        }

        public void postOnAnimation(View view, Runnable runnable) {
            view.postDelayed(runnable, getFrameTime());
        }

        public void postOnAnimationDelayed(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, getFrameTime() + j);
        }

        long getFrameTime() {
            return ValueAnimator.getFrameDelay();
        }

        public void setLayerPaint(View view, Paint paint) {
            view.setLayerType(view.getLayerType(), paint);
            view.invalidate();
        }

        public ViewParent getParentForAccessibility(View view) {
            return view.getParent();
        }

        public int getPaddingStart(View view) {
            return view.getPaddingLeft();
        }

        public int getPaddingEnd(View view) {
            return view.getPaddingRight();
        }

        public void setPaddingRelative(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        public void dispatchStartTemporaryDetach(android.view.View r3) {
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
            r2 = this;
            r0 = r2.mTempDetachBound;
            if (r0 != 0) goto L_0x0007;
        L_0x0004:
            r2.bindTempDetach();
        L_0x0007:
            r0 = r2.mDispatchStartTemporaryDetach;
            if (r0 == 0) goto L_0x0014;
        L_0x000b:
            r0 = r2.mDispatchStartTemporaryDetach;	 Catch:{ Exception -> 0x0013 }
            r1 = 0;	 Catch:{ Exception -> 0x0013 }
            r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0013 }
            r0.invoke(r3, r1);	 Catch:{ Exception -> 0x0013 }
        L_0x0013:
            return;
        L_0x0014:
            r3.onStartTemporaryDetach();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewCompat.ViewCompatBaseImpl.dispatchStartTemporaryDetach(android.view.View):void");
        }

        public void dispatchFinishTemporaryDetach(android.view.View r3) {
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
            r2 = this;
            r0 = r2.mTempDetachBound;
            if (r0 != 0) goto L_0x0007;
        L_0x0004:
            r2.bindTempDetach();
        L_0x0007:
            r0 = r2.mDispatchFinishTemporaryDetach;
            if (r0 == 0) goto L_0x0014;
        L_0x000b:
            r0 = r2.mDispatchFinishTemporaryDetach;	 Catch:{ Exception -> 0x0013 }
            r1 = 0;	 Catch:{ Exception -> 0x0013 }
            r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0013 }
            r0.invoke(r3, r1);	 Catch:{ Exception -> 0x0013 }
        L_0x0013:
            return;
        L_0x0014:
            r3.onFinishTemporaryDetach();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewCompat.ViewCompatBaseImpl.dispatchFinishTemporaryDetach(android.view.View):void");
        }

        private void bindTempDetach() {
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
            r4 = this;
            r0 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r1 = "dispatchStartTemporaryDetach";	 Catch:{ NoSuchMethodException -> 0x0019 }
            r2 = 0;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r3 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0019 }
            r0 = r0.getDeclaredMethod(r1, r3);	 Catch:{ NoSuchMethodException -> 0x0019 }
            r4.mDispatchStartTemporaryDetach = r0;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r0 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r1 = "dispatchFinishTemporaryDetach";	 Catch:{ NoSuchMethodException -> 0x0019 }
            r2 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0019 }
            r0 = r0.getDeclaredMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0019 }
            r4.mDispatchFinishTemporaryDetach = r0;	 Catch:{ NoSuchMethodException -> 0x0019 }
        L_0x0019:
            r0 = 1;
            r4.mTempDetachBound = r0;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewCompat.ViewCompatBaseImpl.bindTempDetach():void");
        }

        public int getMinimumWidth(android.view.View r4) {
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
            r3 = this;
            r0 = sMinWidthFieldFetched;
            if (r0 != 0) goto L_0x0014;
        L_0x0004:
            r0 = 1;
            r1 = android.view.View.class;	 Catch:{ NoSuchFieldException -> 0x0012 }
            r2 = "mMinWidth";	 Catch:{ NoSuchFieldException -> 0x0012 }
            r1 = r1.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0012 }
            sMinWidthField = r1;	 Catch:{ NoSuchFieldException -> 0x0012 }
            r1.setAccessible(r0);	 Catch:{ NoSuchFieldException -> 0x0012 }
        L_0x0012:
            sMinWidthFieldFetched = r0;
        L_0x0014:
            r0 = sMinWidthField;
            if (r0 == 0) goto L_0x0025;
        L_0x0018:
            r0 = sMinWidthField;	 Catch:{ Exception -> 0x0025 }
            r4 = r0.get(r4);	 Catch:{ Exception -> 0x0025 }
            r4 = (java.lang.Integer) r4;	 Catch:{ Exception -> 0x0025 }
            r4 = r4.intValue();	 Catch:{ Exception -> 0x0025 }
            return r4;
        L_0x0025:
            r4 = 0;
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewCompat.ViewCompatBaseImpl.getMinimumWidth(android.view.View):int");
        }

        public int getMinimumHeight(android.view.View r4) {
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
            r3 = this;
            r0 = sMinHeightFieldFetched;
            if (r0 != 0) goto L_0x0014;
        L_0x0004:
            r0 = 1;
            r1 = android.view.View.class;	 Catch:{ NoSuchFieldException -> 0x0012 }
            r2 = "mMinHeight";	 Catch:{ NoSuchFieldException -> 0x0012 }
            r1 = r1.getDeclaredField(r2);	 Catch:{ NoSuchFieldException -> 0x0012 }
            sMinHeightField = r1;	 Catch:{ NoSuchFieldException -> 0x0012 }
            r1.setAccessible(r0);	 Catch:{ NoSuchFieldException -> 0x0012 }
        L_0x0012:
            sMinHeightFieldFetched = r0;
        L_0x0014:
            r0 = sMinHeightField;
            if (r0 == 0) goto L_0x0025;
        L_0x0018:
            r0 = sMinHeightField;	 Catch:{ Exception -> 0x0025 }
            r4 = r0.get(r4);	 Catch:{ Exception -> 0x0025 }
            r4 = (java.lang.Integer) r4;	 Catch:{ Exception -> 0x0025 }
            r4 = r4.intValue();	 Catch:{ Exception -> 0x0025 }
            return r4;
        L_0x0025:
            r4 = 0;
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewCompat.ViewCompatBaseImpl.getMinimumHeight(android.view.View):int");
        }

        public ViewPropertyAnimatorCompat animate(View view) {
            if (this.mViewPropertyAnimatorCompatMap == null) {
                this.mViewPropertyAnimatorCompatMap = new WeakHashMap();
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) this.mViewPropertyAnimatorCompatMap.get(view);
            if (viewPropertyAnimatorCompat != null) {
                return viewPropertyAnimatorCompat;
            }
            viewPropertyAnimatorCompat = new ViewPropertyAnimatorCompat(view);
            this.mViewPropertyAnimatorCompatMap.put(view, viewPropertyAnimatorCompat);
            return viewPropertyAnimatorCompat;
        }

        public void setTransitionName(View view, String str) {
            if (sTransitionNameMap == null) {
                sTransitionNameMap = new WeakHashMap();
            }
            sTransitionNameMap.put(view, str);
        }

        public String getTransitionName(View view) {
            if (sTransitionNameMap == null) {
                return null;
            }
            return (String) sTransitionNameMap.get(view);
        }

        public void setChildrenDrawingOrderEnabled(android.view.ViewGroup r7, boolean r8) {
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
            r0 = sChildrenDrawingOrderMethod;
            r1 = 0;
            r2 = 1;
            if (r0 != 0) goto L_0x001b;
        L_0x0006:
            r0 = android.view.ViewGroup.class;	 Catch:{ NoSuchMethodException -> 0x0016 }
            r3 = "setChildrenDrawingOrderEnabled";	 Catch:{ NoSuchMethodException -> 0x0016 }
            r4 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0016 }
            r5 = java.lang.Boolean.TYPE;	 Catch:{ NoSuchMethodException -> 0x0016 }
            r4[r1] = r5;	 Catch:{ NoSuchMethodException -> 0x0016 }
            r0 = r0.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0016 }
            sChildrenDrawingOrderMethod = r0;	 Catch:{ NoSuchMethodException -> 0x0016 }
        L_0x0016:
            r0 = sChildrenDrawingOrderMethod;
            r0.setAccessible(r2);
        L_0x001b:
            r0 = sChildrenDrawingOrderMethod;	 Catch:{ IllegalAccessException -> 0x002a, IllegalAccessException -> 0x002a, InvocationTargetException -> 0x0029 }
            r2 = new java.lang.Object[r2];	 Catch:{ IllegalAccessException -> 0x002a, IllegalAccessException -> 0x002a, InvocationTargetException -> 0x0029 }
            r8 = java.lang.Boolean.valueOf(r8);	 Catch:{ IllegalAccessException -> 0x002a, IllegalAccessException -> 0x002a, InvocationTargetException -> 0x0029 }
            r2[r1] = r8;	 Catch:{ IllegalAccessException -> 0x002a, IllegalAccessException -> 0x002a, InvocationTargetException -> 0x0029 }
            r0.invoke(r7, r2);	 Catch:{ IllegalAccessException -> 0x002a, IllegalAccessException -> 0x002a, InvocationTargetException -> 0x0029 }
            return;
        L_0x0029:
            return;
        L_0x002a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewCompat.ViewCompatBaseImpl.setChildrenDrawingOrderEnabled(android.view.ViewGroup, boolean):void");
        }

        public void setNestedScrollingEnabled(View view, boolean z) {
            if (view instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view).setNestedScrollingEnabled(z);
            }
        }

        public boolean isNestedScrollingEnabled(View view) {
            return view instanceof NestedScrollingChild ? ((NestedScrollingChild) view).isNestedScrollingEnabled() : null;
        }

        public void setBackground(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }

        public ColorStateList getBackgroundTintList(View view) {
            return view instanceof TintableBackgroundView ? ((TintableBackgroundView) view).getSupportBackgroundTintList() : null;
        }

        public void setBackgroundTintList(View view, ColorStateList colorStateList) {
            if (view instanceof TintableBackgroundView) {
                ((TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
            }
        }

        public void setBackgroundTintMode(View view, Mode mode) {
            if (view instanceof TintableBackgroundView) {
                ((TintableBackgroundView) view).setSupportBackgroundTintMode(mode);
            }
        }

        public Mode getBackgroundTintMode(View view) {
            return view instanceof TintableBackgroundView ? ((TintableBackgroundView) view).getSupportBackgroundTintMode() : null;
        }

        public boolean startNestedScroll(View view, int i) {
            return view instanceof NestedScrollingChild ? ((NestedScrollingChild) view).startNestedScroll(i) : null;
        }

        public void stopNestedScroll(View view) {
            if (view instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view).stopNestedScroll();
            }
        }

        public boolean hasNestedScrollingParent(View view) {
            return view instanceof NestedScrollingChild ? ((NestedScrollingChild) view).hasNestedScrollingParent() : null;
        }

        public boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr) {
            return view instanceof NestedScrollingChild ? ((NestedScrollingChild) view).dispatchNestedScroll(i, i2, i3, i4, iArr) : null;
        }

        public boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2) {
            return view instanceof NestedScrollingChild ? ((NestedScrollingChild) view).dispatchNestedPreScroll(i, i2, iArr, iArr2) : null;
        }

        public boolean dispatchNestedFling(View view, float f, float f2, boolean z) {
            return view instanceof NestedScrollingChild ? ((NestedScrollingChild) view).dispatchNestedFling(f, f2, z) : null;
        }

        public boolean dispatchNestedPreFling(View view, float f, float f2) {
            return view instanceof NestedScrollingChild ? ((NestedScrollingChild) view).dispatchNestedPreFling(f, f2) : null;
        }

        public boolean isLaidOut(View view) {
            return (view.getWidth() <= 0 || view.getHeight() <= null) ? null : true;
        }

        public float getZ(View view) {
            return getTranslationZ(view) + getElevation(view);
        }

        public boolean isAttachedToWindow(View view) {
            return view.getWindowToken() != null ? true : null;
        }

        public void offsetLeftAndRight(View view, int i) {
            view.offsetLeftAndRight(i);
            if (view.getVisibility() == 0) {
                tickleInvalidationFlag(view);
                view = view.getParent();
                if ((view instanceof View) != 0) {
                    tickleInvalidationFlag(view);
                }
            }
        }

        public void offsetTopAndBottom(View view, int i) {
            view.offsetTopAndBottom(i);
            if (view.getVisibility() == 0) {
                tickleInvalidationFlag(view);
                view = view.getParent();
                if ((view instanceof View) != 0) {
                    tickleInvalidationFlag(view);
                }
            }
        }

        private static void tickleInvalidationFlag(View view) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
        }

        public Display getDisplay(View view) {
            return isAttachedToWindow(view) ? ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay() : null;
        }

        public boolean restoreDefaultFocus(@NonNull View view) {
            return view.requestFocus();
        }

        public boolean hasExplicitFocusable(@NonNull View view) {
            return view.hasFocusable();
        }
    }

    @RequiresApi(15)
    static class ViewCompatApi15Impl extends ViewCompatBaseImpl {
        ViewCompatApi15Impl() {
        }

        public boolean hasOnClickListeners(View view) {
            return view.hasOnClickListeners();
        }
    }

    @RequiresApi(16)
    static class ViewCompatApi16Impl extends ViewCompatApi15Impl {
        ViewCompatApi16Impl() {
        }

        public boolean hasTransientState(View view) {
            return view.hasTransientState();
        }

        public void setHasTransientState(View view, boolean z) {
            view.setHasTransientState(z);
        }

        public void postInvalidateOnAnimation(View view) {
            view.postInvalidateOnAnimation();
        }

        public void postInvalidateOnAnimation(View view, int i, int i2, int i3, int i4) {
            view.postInvalidateOnAnimation(i, i2, i3, i4);
        }

        public void postOnAnimation(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public void postOnAnimationDelayed(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        public int getImportantForAccessibility(View view) {
            return view.getImportantForAccessibility();
        }

        public void setImportantForAccessibility(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return view.performAccessibilityAction(i, bundle);
        }

        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
            view = view.getAccessibilityNodeProvider();
            return view != null ? new AccessibilityNodeProviderCompat(view) : null;
        }

        public ViewParent getParentForAccessibility(View view) {
            return view.getParentForAccessibility();
        }

        public int getMinimumWidth(View view) {
            return view.getMinimumWidth();
        }

        public int getMinimumHeight(View view) {
            return view.getMinimumHeight();
        }

        public void requestApplyInsets(View view) {
            view.requestFitSystemWindows();
        }

        public boolean getFitsSystemWindows(View view) {
            return view.getFitsSystemWindows();
        }

        public boolean hasOverlappingRendering(View view) {
            return view.hasOverlappingRendering();
        }

        public void setBackground(View view, Drawable drawable) {
            view.setBackground(drawable);
        }
    }

    @RequiresApi(17)
    static class ViewCompatApi17Impl extends ViewCompatApi16Impl {
        ViewCompatApi17Impl() {
        }

        public int getLabelFor(View view) {
            return view.getLabelFor();
        }

        public void setLabelFor(View view, int i) {
            view.setLabelFor(i);
        }

        public void setLayerPaint(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        public int getLayoutDirection(View view) {
            return view.getLayoutDirection();
        }

        public void setLayoutDirection(View view, int i) {
            view.setLayoutDirection(i);
        }

        public int getPaddingStart(View view) {
            return view.getPaddingStart();
        }

        public int getPaddingEnd(View view) {
            return view.getPaddingEnd();
        }

        public void setPaddingRelative(View view, int i, int i2, int i3, int i4) {
            view.setPaddingRelative(i, i2, i3, i4);
        }

        public int getWindowSystemUiVisibility(View view) {
            return view.getWindowSystemUiVisibility();
        }

        public boolean isPaddingRelative(View view) {
            return view.isPaddingRelative();
        }

        public Display getDisplay(View view) {
            return view.getDisplay();
        }
    }

    @RequiresApi(18)
    static class ViewCompatApi18Impl extends ViewCompatApi17Impl {
        ViewCompatApi18Impl() {
        }

        public void setClipBounds(View view, Rect rect) {
            view.setClipBounds(rect);
        }

        public Rect getClipBounds(View view) {
            return view.getClipBounds();
        }

        public boolean isInLayout(View view) {
            return view.isInLayout();
        }
    }

    @RequiresApi(19)
    static class ViewCompatApi19Impl extends ViewCompatApi18Impl {
        ViewCompatApi19Impl() {
        }

        public int getAccessibilityLiveRegion(View view) {
            return view.getAccessibilityLiveRegion();
        }

        public void setAccessibilityLiveRegion(View view, int i) {
            view.setAccessibilityLiveRegion(i);
        }

        public void setImportantForAccessibility(View view, int i) {
            view.setImportantForAccessibility(i);
        }

        public boolean isLaidOut(View view) {
            return view.isLaidOut();
        }

        public boolean isLayoutDirectionResolved(View view) {
            return view.isLayoutDirectionResolved();
        }

        public boolean isAttachedToWindow(View view) {
            return view.isAttachedToWindow();
        }
    }

    @RequiresApi(21)
    static class ViewCompatApi21Impl extends ViewCompatApi19Impl {
        private static ThreadLocal<Rect> sThreadLocalRect;

        ViewCompatApi21Impl() {
        }

        public void setTransitionName(View view, String str) {
            view.setTransitionName(str);
        }

        public String getTransitionName(View view) {
            return view.getTransitionName();
        }

        public void requestApplyInsets(View view) {
            view.requestApplyInsets();
        }

        public void setElevation(View view, float f) {
            view.setElevation(f);
        }

        public float getElevation(View view) {
            return view.getElevation();
        }

        public void setTranslationZ(View view, float f) {
            view.setTranslationZ(f);
        }

        public float getTranslationZ(View view) {
            return view.getTranslationZ();
        }

        public void setOnApplyWindowInsetsListener(View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        return (WindowInsets) WindowInsetsCompat.unwrap(onApplyWindowInsetsListener.onApplyWindowInsets(view, WindowInsetsCompat.wrap(windowInsets)));
                    }
                });
            }
        }

        public void setNestedScrollingEnabled(View view, boolean z) {
            view.setNestedScrollingEnabled(z);
        }

        public boolean isNestedScrollingEnabled(View view) {
            return view.isNestedScrollingEnabled();
        }

        public boolean startNestedScroll(View view, int i) {
            return view.startNestedScroll(i);
        }

        public void stopNestedScroll(View view) {
            view.stopNestedScroll();
        }

        public boolean hasNestedScrollingParent(View view) {
            return view.hasNestedScrollingParent();
        }

        public boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr) {
            return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
        }

        public boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }

        public boolean dispatchNestedFling(View view, float f, float f2, boolean z) {
            return view.dispatchNestedFling(f, f2, z);
        }

        public boolean dispatchNestedPreFling(View view, float f, float f2) {
            return view.dispatchNestedPreFling(f, f2);
        }

        public boolean isImportantForAccessibility(View view) {
            return view.isImportantForAccessibility();
        }

        public ColorStateList getBackgroundTintList(View view) {
            return view.getBackgroundTintList();
        }

        public void setBackgroundTintList(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
            if (VERSION.SDK_INT == 21) {
                colorStateList = view.getBackground();
                Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
                if (colorStateList != null && obj != null) {
                    if (colorStateList.isStateful()) {
                        colorStateList.setState(view.getDrawableState());
                    }
                    view.setBackground(colorStateList);
                }
            }
        }

        public void setBackgroundTintMode(View view, Mode mode) {
            view.setBackgroundTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                mode = view.getBackground();
                Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
                if (mode != null && obj != null) {
                    if (mode.isStateful()) {
                        mode.setState(view.getDrawableState());
                    }
                    view.setBackground(mode);
                }
            }
        }

        public Mode getBackgroundTintMode(View view) {
            return view.getBackgroundTintMode();
        }

        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat = (WindowInsets) WindowInsetsCompat.unwrap(windowInsetsCompat);
            view = view.onApplyWindowInsets(windowInsetsCompat);
            if (view != windowInsetsCompat) {
                windowInsetsCompat = new WindowInsets(view);
            }
            return WindowInsetsCompat.wrap(windowInsetsCompat);
        }

        public WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat = (WindowInsets) WindowInsetsCompat.unwrap(windowInsetsCompat);
            view = view.dispatchApplyWindowInsets(windowInsetsCompat);
            if (view != windowInsetsCompat) {
                windowInsetsCompat = new WindowInsets(view);
            }
            return WindowInsetsCompat.wrap(windowInsetsCompat);
        }

        public float getZ(View view) {
            return view.getZ();
        }

        public void setZ(View view, float f) {
            view.setZ(f);
        }

        public void offsetLeftAndRight(View view, int i) {
            int intersects;
            Rect emptyTempRect = getEmptyTempRect();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                emptyTempRect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                intersects = emptyTempRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ^ 1;
            } else {
                intersects = 0;
            }
            super.offsetLeftAndRight(view, i);
            if (intersects != 0 && emptyTempRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) != null) {
                ((View) parent).invalidate(emptyTempRect);
            }
        }

        public void offsetTopAndBottom(View view, int i) {
            int intersects;
            Rect emptyTempRect = getEmptyTempRect();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                emptyTempRect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                intersects = emptyTempRect.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ^ 1;
            } else {
                intersects = 0;
            }
            super.offsetTopAndBottom(view, i);
            if (intersects != 0 && emptyTempRect.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) != null) {
                ((View) parent).invalidate(emptyTempRect);
            }
        }

        private static Rect getEmptyTempRect() {
            if (sThreadLocalRect == null) {
                sThreadLocalRect = new ThreadLocal();
            }
            Rect rect = (Rect) sThreadLocalRect.get();
            if (rect == null) {
                rect = new Rect();
                sThreadLocalRect.set(rect);
            }
            rect.setEmpty();
            return rect;
        }
    }

    @RequiresApi(23)
    static class ViewCompatApi23Impl extends ViewCompatApi21Impl {
        ViewCompatApi23Impl() {
        }

        public void setScrollIndicators(View view, int i) {
            view.setScrollIndicators(i);
        }

        public void setScrollIndicators(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }

        public int getScrollIndicators(View view) {
            return view.getScrollIndicators();
        }

        public void offsetLeftAndRight(View view, int i) {
            view.offsetLeftAndRight(i);
        }

        public void offsetTopAndBottom(View view, int i) {
            view.offsetTopAndBottom(i);
        }
    }

    @RequiresApi(24)
    static class ViewCompatApi24Impl extends ViewCompatApi23Impl {
        ViewCompatApi24Impl() {
        }

        public void dispatchStartTemporaryDetach(View view) {
            view.dispatchStartTemporaryDetach();
        }

        public void dispatchFinishTemporaryDetach(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        public void setPointerIcon(View view, PointerIconCompat pointerIconCompat) {
            view.setPointerIcon((PointerIcon) (pointerIconCompat != null ? pointerIconCompat.getPointerIcon() : null));
        }

        public boolean startDragAndDrop(View view, ClipData clipData, DragShadowBuilder dragShadowBuilder, Object obj, int i) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
        }

        public void cancelDragAndDrop(View view) {
            view.cancelDragAndDrop();
        }

        public void updateDragShadow(View view, DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    @RequiresApi(26)
    static class ViewCompatApi26Impl extends ViewCompatApi24Impl {
        ViewCompatApi26Impl() {
        }

        public void setTooltipText(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }

        public int getNextClusterForwardId(@NonNull View view) {
            return view.getNextClusterForwardId();
        }

        public void setNextClusterForwardId(@NonNull View view, int i) {
            view.setNextClusterForwardId(i);
        }

        public boolean isKeyboardNavigationCluster(@NonNull View view) {
            return view.isKeyboardNavigationCluster();
        }

        public void setKeyboardNavigationCluster(@NonNull View view, boolean z) {
            view.setKeyboardNavigationCluster(z);
        }

        public boolean isFocusedByDefault(@NonNull View view) {
            return view.isFocusedByDefault();
        }

        public void setFocusedByDefault(@NonNull View view, boolean z) {
            view.setFocusedByDefault(z);
        }

        public View keyboardNavigationClusterSearch(@NonNull View view, View view2, int i) {
            return view.keyboardNavigationClusterSearch(view2, i);
        }

        public void addKeyboardNavigationClusters(@NonNull View view, @NonNull Collection<View> collection, int i) {
            view.addKeyboardNavigationClusters(collection, i);
        }

        public boolean restoreDefaultFocus(@NonNull View view) {
            return view.restoreDefaultFocus();
        }

        public boolean hasExplicitFocusable(@NonNull View view) {
            return view.hasExplicitFocusable();
        }
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            IMPL = new ViewCompatApi26Impl();
        } else if (VERSION.SDK_INT >= 24) {
            IMPL = new ViewCompatApi24Impl();
        } else if (VERSION.SDK_INT >= 23) {
            IMPL = new ViewCompatApi23Impl();
        } else if (VERSION.SDK_INT >= 21) {
            IMPL = new ViewCompatApi21Impl();
        } else if (VERSION.SDK_INT >= 19) {
            IMPL = new ViewCompatApi19Impl();
        } else if (VERSION.SDK_INT >= 18) {
            IMPL = new ViewCompatApi18Impl();
        } else if (VERSION.SDK_INT >= 17) {
            IMPL = new ViewCompatApi17Impl();
        } else if (VERSION.SDK_INT >= 16) {
            IMPL = new ViewCompatApi16Impl();
        } else if (VERSION.SDK_INT >= 15) {
            IMPL = new ViewCompatApi15Impl();
        } else {
            IMPL = new ViewCompatBaseImpl();
        }
    }

    @Deprecated
    public static boolean canScrollHorizontally(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    @Deprecated
    public static boolean canScrollVertically(View view, int i) {
        return view.canScrollVertically(i);
    }

    @Deprecated
    public static int getOverScrollMode(View view) {
        return view.getOverScrollMode();
    }

    @Deprecated
    public static void setOverScrollMode(View view, int i) {
        view.setOverScrollMode(i);
    }

    @Deprecated
    public static void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Deprecated
    public static void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        view.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public static void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        IMPL.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
    }

    public static void setAccessibilityDelegate(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        IMPL.setAccessibilityDelegate(view, accessibilityDelegateCompat);
    }

    public static boolean hasAccessibilityDelegate(View view) {
        return IMPL.hasAccessibilityDelegate(view);
    }

    public static boolean hasTransientState(View view) {
        return IMPL.hasTransientState(view);
    }

    public static void setHasTransientState(View view, boolean z) {
        IMPL.setHasTransientState(view, z);
    }

    public static void postInvalidateOnAnimation(View view) {
        IMPL.postInvalidateOnAnimation(view);
    }

    public static void postInvalidateOnAnimation(View view, int i, int i2, int i3, int i4) {
        IMPL.postInvalidateOnAnimation(view, i, i2, i3, i4);
    }

    public static void postOnAnimation(View view, Runnable runnable) {
        IMPL.postOnAnimation(view, runnable);
    }

    public static void postOnAnimationDelayed(View view, Runnable runnable, long j) {
        IMPL.postOnAnimationDelayed(view, runnable, j);
    }

    public static int getImportantForAccessibility(View view) {
        return IMPL.getImportantForAccessibility(view);
    }

    public static void setImportantForAccessibility(View view, int i) {
        IMPL.setImportantForAccessibility(view, i);
    }

    public static boolean isImportantForAccessibility(View view) {
        return IMPL.isImportantForAccessibility(view);
    }

    public static boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return IMPL.performAccessibilityAction(view, i, bundle);
    }

    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        return IMPL.getAccessibilityNodeProvider(view);
    }

    @Deprecated
    public static float getAlpha(View view) {
        return view.getAlpha();
    }

    @Deprecated
    public static void setLayerType(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    @Deprecated
    public static int getLayerType(View view) {
        return view.getLayerType();
    }

    public static int getLabelFor(View view) {
        return IMPL.getLabelFor(view);
    }

    public static void setLabelFor(View view, @IdRes int i) {
        IMPL.setLabelFor(view, i);
    }

    public static void setLayerPaint(View view, Paint paint) {
        IMPL.setLayerPaint(view, paint);
    }

    public static int getLayoutDirection(View view) {
        return IMPL.getLayoutDirection(view);
    }

    public static void setLayoutDirection(View view, int i) {
        IMPL.setLayoutDirection(view, i);
    }

    public static ViewParent getParentForAccessibility(View view) {
        return IMPL.getParentForAccessibility(view);
    }

    @Deprecated
    public static boolean isOpaque(View view) {
        return view.isOpaque();
    }

    @Deprecated
    public static int resolveSizeAndState(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    @Deprecated
    public static int getMeasuredWidthAndState(View view) {
        return view.getMeasuredWidthAndState();
    }

    @Deprecated
    public static int getMeasuredHeightAndState(View view) {
        return view.getMeasuredHeightAndState();
    }

    @Deprecated
    public static int getMeasuredState(View view) {
        return view.getMeasuredState();
    }

    @Deprecated
    public static int combineMeasuredStates(int i, int i2) {
        return View.combineMeasuredStates(i, i2);
    }

    public static int getAccessibilityLiveRegion(View view) {
        return IMPL.getAccessibilityLiveRegion(view);
    }

    public static void setAccessibilityLiveRegion(View view, int i) {
        IMPL.setAccessibilityLiveRegion(view, i);
    }

    public static int getPaddingStart(View view) {
        return IMPL.getPaddingStart(view);
    }

    public static int getPaddingEnd(View view) {
        return IMPL.getPaddingEnd(view);
    }

    public static void setPaddingRelative(View view, int i, int i2, int i3, int i4) {
        IMPL.setPaddingRelative(view, i, i2, i3, i4);
    }

    public static void dispatchStartTemporaryDetach(View view) {
        IMPL.dispatchStartTemporaryDetach(view);
    }

    public static void dispatchFinishTemporaryDetach(View view) {
        IMPL.dispatchFinishTemporaryDetach(view);
    }

    @Deprecated
    public static float getTranslationX(View view) {
        return view.getTranslationX();
    }

    @Deprecated
    public static float getTranslationY(View view) {
        return view.getTranslationY();
    }

    @Nullable
    @Deprecated
    public static Matrix getMatrix(View view) {
        return view.getMatrix();
    }

    public static int getMinimumWidth(View view) {
        return IMPL.getMinimumWidth(view);
    }

    public static int getMinimumHeight(View view) {
        return IMPL.getMinimumHeight(view);
    }

    public static ViewPropertyAnimatorCompat animate(View view) {
        return IMPL.animate(view);
    }

    @Deprecated
    public static void setTranslationX(View view, float f) {
        view.setTranslationX(f);
    }

    @Deprecated
    public static void setTranslationY(View view, float f) {
        view.setTranslationY(f);
    }

    @Deprecated
    public static void setAlpha(View view, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        view.setAlpha(f);
    }

    @Deprecated
    public static void setX(View view, float f) {
        view.setX(f);
    }

    @Deprecated
    public static void setY(View view, float f) {
        view.setY(f);
    }

    @Deprecated
    public static void setRotation(View view, float f) {
        view.setRotation(f);
    }

    @Deprecated
    public static void setRotationX(View view, float f) {
        view.setRotationX(f);
    }

    @Deprecated
    public static void setRotationY(View view, float f) {
        view.setRotationY(f);
    }

    @Deprecated
    public static void setScaleX(View view, float f) {
        view.setScaleX(f);
    }

    @Deprecated
    public static void setScaleY(View view, float f) {
        view.setScaleY(f);
    }

    @Deprecated
    public static float getPivotX(View view) {
        return view.getPivotX();
    }

    @Deprecated
    public static void setPivotX(View view, float f) {
        view.setPivotX(f);
    }

    @Deprecated
    public static float getPivotY(View view) {
        return view.getPivotY();
    }

    @Deprecated
    public static void setPivotY(View view, float f) {
        view.setPivotY(f);
    }

    @Deprecated
    public static float getRotation(View view) {
        return view.getRotation();
    }

    @Deprecated
    public static float getRotationX(View view) {
        return view.getRotationX();
    }

    @Deprecated
    public static float getRotationY(View view) {
        return view.getRotationY();
    }

    @Deprecated
    public static float getScaleX(View view) {
        return view.getScaleX();
    }

    @Deprecated
    public static float getScaleY(View view) {
        return view.getScaleY();
    }

    @Deprecated
    public static float getX(View view) {
        return view.getX();
    }

    @Deprecated
    public static float getY(View view) {
        return view.getY();
    }

    public static void setElevation(View view, float f) {
        IMPL.setElevation(view, f);
    }

    public static float getElevation(View view) {
        return IMPL.getElevation(view);
    }

    public static void setTranslationZ(View view, float f) {
        IMPL.setTranslationZ(view, f);
    }

    public static float getTranslationZ(View view) {
        return IMPL.getTranslationZ(view);
    }

    public static void setTransitionName(View view, String str) {
        IMPL.setTransitionName(view, str);
    }

    public static String getTransitionName(View view) {
        return IMPL.getTransitionName(view);
    }

    public static int getWindowSystemUiVisibility(View view) {
        return IMPL.getWindowSystemUiVisibility(view);
    }

    public static void requestApplyInsets(View view) {
        IMPL.requestApplyInsets(view);
    }

    public static void setChildrenDrawingOrderEnabled(ViewGroup viewGroup, boolean z) {
        IMPL.setChildrenDrawingOrderEnabled(viewGroup, z);
    }

    public static boolean getFitsSystemWindows(View view) {
        return IMPL.getFitsSystemWindows(view);
    }

    @Deprecated
    public static void setFitsSystemWindows(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    @Deprecated
    public static void jumpDrawablesToCurrentState(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        IMPL.setOnApplyWindowInsetsListener(view, onApplyWindowInsetsListener);
    }

    public static WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return IMPL.onApplyWindowInsets(view, windowInsetsCompat);
    }

    public static WindowInsetsCompat dispatchApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return IMPL.dispatchApplyWindowInsets(view, windowInsetsCompat);
    }

    @Deprecated
    public static void setSaveFromParentEnabled(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    @Deprecated
    public static void setActivated(View view, boolean z) {
        view.setActivated(z);
    }

    public static boolean hasOverlappingRendering(View view) {
        return IMPL.hasOverlappingRendering(view);
    }

    public static boolean isPaddingRelative(View view) {
        return IMPL.isPaddingRelative(view);
    }

    public static void setBackground(View view, Drawable drawable) {
        IMPL.setBackground(view, drawable);
    }

    public static ColorStateList getBackgroundTintList(View view) {
        return IMPL.getBackgroundTintList(view);
    }

    public static void setBackgroundTintList(View view, ColorStateList colorStateList) {
        IMPL.setBackgroundTintList(view, colorStateList);
    }

    public static Mode getBackgroundTintMode(View view) {
        return IMPL.getBackgroundTintMode(view);
    }

    public static void setBackgroundTintMode(View view, Mode mode) {
        IMPL.setBackgroundTintMode(view, mode);
    }

    public static void setNestedScrollingEnabled(@NonNull View view, boolean z) {
        IMPL.setNestedScrollingEnabled(view, z);
    }

    public static boolean isNestedScrollingEnabled(@NonNull View view) {
        return IMPL.isNestedScrollingEnabled(view);
    }

    public static boolean startNestedScroll(@NonNull View view, int i) {
        return IMPL.startNestedScroll(view, i);
    }

    public static void stopNestedScroll(@NonNull View view) {
        IMPL.stopNestedScroll(view);
    }

    public static boolean hasNestedScrollingParent(@NonNull View view) {
        return IMPL.hasNestedScrollingParent(view);
    }

    public static boolean dispatchNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, @Nullable int[] iArr) {
        return IMPL.dispatchNestedScroll(view, i, i2, i3, i4, iArr);
    }

    public static boolean dispatchNestedPreScroll(@NonNull View view, int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return IMPL.dispatchNestedPreScroll(view, i, i2, iArr, iArr2);
    }

    public static boolean startNestedScroll(@NonNull View view, int i, int i2) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).startNestedScroll(i, i2);
        }
        return i2 == 0 ? IMPL.startNestedScroll(view, i) : null;
    }

    public static void stopNestedScroll(@NonNull View view, int i) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).stopNestedScroll(i);
            return;
        }
        if (i == 0) {
            IMPL.stopNestedScroll(view);
        }
    }

    public static boolean hasNestedScrollingParent(@NonNull View view, int i) {
        if (view instanceof NestedScrollingChild2) {
            ((NestedScrollingChild2) view).hasNestedScrollingParent(i);
        } else if (i == 0) {
            return IMPL.hasNestedScrollingParent(view);
        }
        return null;
    }

    public static boolean dispatchNestedScroll(@NonNull View view, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
        }
        return i5 == 0 ? IMPL.dispatchNestedScroll(view, i, i2, i3, i4, iArr) : null;
    }

    public static boolean dispatchNestedPreScroll(@NonNull View view, int i, int i2, @Nullable int[] iArr, @Nullable int[] iArr2, int i3) {
        if (view instanceof NestedScrollingChild2) {
            return ((NestedScrollingChild2) view).dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
        }
        return i3 == 0 ? IMPL.dispatchNestedPreScroll(view, i, i2, iArr, iArr2) : null;
    }

    public static boolean dispatchNestedFling(@NonNull View view, float f, float f2, boolean z) {
        return IMPL.dispatchNestedFling(view, f, f2, z);
    }

    public static boolean dispatchNestedPreFling(@NonNull View view, float f, float f2) {
        return IMPL.dispatchNestedPreFling(view, f, f2);
    }

    public static boolean isInLayout(View view) {
        return IMPL.isInLayout(view);
    }

    public static boolean isLaidOut(View view) {
        return IMPL.isLaidOut(view);
    }

    public static boolean isLayoutDirectionResolved(View view) {
        return IMPL.isLayoutDirectionResolved(view);
    }

    public static float getZ(View view) {
        return IMPL.getZ(view);
    }

    public static void setZ(View view, float f) {
        IMPL.setZ(view, f);
    }

    public static void offsetTopAndBottom(View view, int i) {
        IMPL.offsetTopAndBottom(view, i);
    }

    public static void offsetLeftAndRight(View view, int i) {
        IMPL.offsetLeftAndRight(view, i);
    }

    public static void setClipBounds(View view, Rect rect) {
        IMPL.setClipBounds(view, rect);
    }

    public static Rect getClipBounds(View view) {
        return IMPL.getClipBounds(view);
    }

    public static boolean isAttachedToWindow(View view) {
        return IMPL.isAttachedToWindow(view);
    }

    public static boolean hasOnClickListeners(View view) {
        return IMPL.hasOnClickListeners(view);
    }

    public static void setScrollIndicators(@NonNull View view, int i) {
        IMPL.setScrollIndicators(view, i);
    }

    public static void setScrollIndicators(@NonNull View view, int i, int i2) {
        IMPL.setScrollIndicators(view, i, i2);
    }

    public static int getScrollIndicators(@NonNull View view) {
        return IMPL.getScrollIndicators(view);
    }

    public static void setPointerIcon(@NonNull View view, PointerIconCompat pointerIconCompat) {
        IMPL.setPointerIcon(view, pointerIconCompat);
    }

    public static Display getDisplay(@NonNull View view) {
        return IMPL.getDisplay(view);
    }

    public static void setTooltipText(@NonNull View view, @Nullable CharSequence charSequence) {
        IMPL.setTooltipText(view, charSequence);
    }

    public static boolean startDragAndDrop(View view, ClipData clipData, DragShadowBuilder dragShadowBuilder, Object obj, int i) {
        return IMPL.startDragAndDrop(view, clipData, dragShadowBuilder, obj, i);
    }

    public static void cancelDragAndDrop(View view) {
        IMPL.cancelDragAndDrop(view);
    }

    public static void updateDragShadow(View view, DragShadowBuilder dragShadowBuilder) {
        IMPL.updateDragShadow(view, dragShadowBuilder);
    }

    public static int getNextClusterForwardId(@NonNull View view) {
        return IMPL.getNextClusterForwardId(view);
    }

    public static void setNextClusterForwardId(@NonNull View view, int i) {
        IMPL.setNextClusterForwardId(view, i);
    }

    public static boolean isKeyboardNavigationCluster(@NonNull View view) {
        return IMPL.isKeyboardNavigationCluster(view);
    }

    public static void setKeyboardNavigationCluster(@NonNull View view, boolean z) {
        IMPL.setKeyboardNavigationCluster(view, z);
    }

    public static boolean isFocusedByDefault(@NonNull View view) {
        return IMPL.isFocusedByDefault(view);
    }

    public static void setFocusedByDefault(@NonNull View view, boolean z) {
        IMPL.setFocusedByDefault(view, z);
    }

    public static View keyboardNavigationClusterSearch(@NonNull View view, View view2, int i) {
        return IMPL.keyboardNavigationClusterSearch(view, view2, i);
    }

    public static void addKeyboardNavigationClusters(@NonNull View view, @NonNull Collection<View> collection, int i) {
        IMPL.addKeyboardNavigationClusters(view, collection, i);
    }

    public static boolean restoreDefaultFocus(@NonNull View view) {
        return IMPL.restoreDefaultFocus(view);
    }

    public static boolean hasExplicitFocusable(@NonNull View view) {
        return IMPL.hasExplicitFocusable(view);
    }

    protected ViewCompat() {
    }
}
