package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public final class ViewParentCompat {
    static final ViewParentCompatBaseImpl IMPL;
    private static final String TAG = "ViewParentCompat";

    static class ViewParentCompatBaseImpl {
        public void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i) {
        }

        ViewParentCompatBaseImpl() {
        }

        public boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i) {
            return viewParent instanceof NestedScrollingParent ? ((NestedScrollingParent) viewParent).onStartNestedScroll(view, view2, i) : null;
        }

        public void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }

        public void onStopNestedScroll(ViewParent viewParent, View view) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onStopNestedScroll(view);
            }
        }

        public void onNestedScroll(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        public void onNestedPreScroll(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof NestedScrollingParent) {
                ((NestedScrollingParent) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        public boolean onNestedFling(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return viewParent instanceof NestedScrollingParent ? ((NestedScrollingParent) viewParent).onNestedFling(view, f, f2, z) : null;
        }

        public boolean onNestedPreFling(ViewParent viewParent, View view, float f, float f2) {
            return viewParent instanceof NestedScrollingParent ? ((NestedScrollingParent) viewParent).onNestedPreFling(view, f, f2) : null;
        }
    }

    @RequiresApi(19)
    static class ViewParentCompatApi19Impl extends ViewParentCompatBaseImpl {
        ViewParentCompatApi19Impl() {
        }

        public void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i);
        }
    }

    @RequiresApi(21)
    static class ViewParentCompatApi21Impl extends ViewParentCompatApi19Impl {
        ViewParentCompatApi21Impl() {
        }

        public boolean onStartNestedScroll(android.view.ViewParent r1, android.view.View r2, android.view.View r3, int r4) {
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
            r2 = r1.onStartNestedScroll(r2, r3, r4);	 Catch:{ AbstractMethodError -> 0x0005 }
            return r2;
        L_0x0005:
            r2 = new java.lang.StringBuilder;
            r3 = "ViewParent ";
            r2.<init>(r3);
            r2.append(r1);
            r1 = " does not implement interface method onStartNestedScroll";
            r2.append(r1);
            r1 = 0;
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewParentCompat.ViewParentCompatApi21Impl.onStartNestedScroll(android.view.ViewParent, android.view.View, android.view.View, int):boolean");
        }

        public void onNestedScrollAccepted(android.view.ViewParent r1, android.view.View r2, android.view.View r3, int r4) {
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
            r1.onNestedScrollAccepted(r2, r3, r4);	 Catch:{ AbstractMethodError -> 0x0004 }
            return;
        L_0x0004:
            r2 = new java.lang.StringBuilder;
            r3 = "ViewParent ";
            r2.<init>(r3);
            r2.append(r1);
            r1 = " does not implement interface method onNestedScrollAccepted";
            r2.append(r1);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewParentCompat.ViewParentCompatApi21Impl.onNestedScrollAccepted(android.view.ViewParent, android.view.View, android.view.View, int):void");
        }

        public void onStopNestedScroll(android.view.ViewParent r2, android.view.View r3) {
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
            r2.onStopNestedScroll(r3);	 Catch:{ AbstractMethodError -> 0x0004 }
            return;
        L_0x0004:
            r3 = new java.lang.StringBuilder;
            r0 = "ViewParent ";
            r3.<init>(r0);
            r3.append(r2);
            r2 = " does not implement interface method onStopNestedScroll";
            r3.append(r2);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewParentCompat.ViewParentCompatApi21Impl.onStopNestedScroll(android.view.ViewParent, android.view.View):void");
        }

        public void onNestedScroll(android.view.ViewParent r1, android.view.View r2, int r3, int r4, int r5, int r6) {
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
            r1.onNestedScroll(r2, r3, r4, r5, r6);	 Catch:{ AbstractMethodError -> 0x0004 }
            return;
        L_0x0004:
            r2 = new java.lang.StringBuilder;
            r3 = "ViewParent ";
            r2.<init>(r3);
            r2.append(r1);
            r1 = " does not implement interface method onNestedScroll";
            r2.append(r1);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewParentCompat.ViewParentCompatApi21Impl.onNestedScroll(android.view.ViewParent, android.view.View, int, int, int, int):void");
        }

        public void onNestedPreScroll(android.view.ViewParent r1, android.view.View r2, int r3, int r4, int[] r5) {
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
            r1.onNestedPreScroll(r2, r3, r4, r5);	 Catch:{ AbstractMethodError -> 0x0004 }
            return;
        L_0x0004:
            r2 = new java.lang.StringBuilder;
            r3 = "ViewParent ";
            r2.<init>(r3);
            r2.append(r1);
            r1 = " does not implement interface method onNestedPreScroll";
            r2.append(r1);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewParentCompat.ViewParentCompatApi21Impl.onNestedPreScroll(android.view.ViewParent, android.view.View, int, int, int[]):void");
        }

        public boolean onNestedFling(android.view.ViewParent r1, android.view.View r2, float r3, float r4, boolean r5) {
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
            r2 = r1.onNestedFling(r2, r3, r4, r5);	 Catch:{ AbstractMethodError -> 0x0005 }
            return r2;
        L_0x0005:
            r2 = new java.lang.StringBuilder;
            r3 = "ViewParent ";
            r2.<init>(r3);
            r2.append(r1);
            r1 = " does not implement interface method onNestedFling";
            r2.append(r1);
            r1 = 0;
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewParentCompat.ViewParentCompatApi21Impl.onNestedFling(android.view.ViewParent, android.view.View, float, float, boolean):boolean");
        }

        public boolean onNestedPreFling(android.view.ViewParent r1, android.view.View r2, float r3, float r4) {
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
            r2 = r1.onNestedPreFling(r2, r3, r4);	 Catch:{ AbstractMethodError -> 0x0005 }
            return r2;
        L_0x0005:
            r2 = new java.lang.StringBuilder;
            r3 = "ViewParent ";
            r2.<init>(r3);
            r2.append(r1);
            r1 = " does not implement interface method onNestedPreFling";
            r2.append(r1);
            r1 = 0;
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewParentCompat.ViewParentCompatApi21Impl.onNestedPreFling(android.view.ViewParent, android.view.View, float, float):boolean");
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            IMPL = new ViewParentCompatApi21Impl();
        } else if (VERSION.SDK_INT >= 19) {
            IMPL = new ViewParentCompatApi19Impl();
        } else {
            IMPL = new ViewParentCompatBaseImpl();
        }
    }

    private ViewParentCompat() {
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i) {
        return onStartNestedScroll(viewParent, view, view2, i, 0);
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i) {
        onNestedScrollAccepted(viewParent, view, view2, i, 0);
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view) {
        onStopNestedScroll(viewParent, view, 0);
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        onNestedScroll(viewParent, view, i, i2, i3, i4, 0);
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(viewParent, view, i, i2, iArr, 0);
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) viewParent).onStartNestedScroll(view, view2, i, i2);
        }
        return i2 == 0 ? IMPL.onStartNestedScroll(viewParent, view, view2, i) : null;
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScrollAccepted(view, view2, i, i2);
            return;
        }
        if (i2 == 0) {
            IMPL.onNestedScrollAccepted(viewParent, view, view2, i);
        }
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view, int i) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onStopNestedScroll(view, i);
            return;
        }
        if (i == 0) {
            IMPL.onStopNestedScroll(viewParent, view);
        }
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScroll(view, i, i2, i3, i4, i5);
            return;
        }
        if (i5 == 0) {
            IMPL.onNestedScroll(viewParent, view, i, i2, i3, i4);
        }
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedPreScroll(view, i, i2, iArr, i3);
            return;
        }
        if (i3 == 0) {
            IMPL.onNestedPreScroll(viewParent, view, i, i2, iArr);
        }
    }

    public static boolean onNestedFling(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return IMPL.onNestedFling(viewParent, view, f, f2, z);
    }

    public static boolean onNestedPreFling(ViewParent viewParent, View view, float f, float f2) {
        return IMPL.onNestedPreFling(viewParent, view, f, f2);
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i) {
        IMPL.notifySubtreeAccessibilityStateChanged(viewParent, view, view2, i);
    }
}
