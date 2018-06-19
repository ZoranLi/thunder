package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class PopupWindowCompat {
    static final PopupWindowCompatBaseImpl IMPL;

    static class PopupWindowCompatBaseImpl {
        private static Method sGetWindowLayoutTypeMethod;
        private static boolean sGetWindowLayoutTypeMethodAttempted;
        private static Method sSetWindowLayoutTypeMethod;
        private static boolean sSetWindowLayoutTypeMethodAttempted;

        public boolean getOverlapAnchor(PopupWindow popupWindow) {
            return false;
        }

        public void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
        }

        PopupWindowCompatBaseImpl() {
        }

        public void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            if ((GravityCompat.getAbsoluteGravity(i3, ViewCompat.getLayoutDirection(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }

        public void setWindowLayoutType(android.widget.PopupWindow r7, int r8) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r6 = this;
            r0 = sSetWindowLayoutTypeMethodAttempted;
            r1 = 0;
            r2 = 1;
            if (r0 != 0) goto L_0x001b;
        L_0x0006:
            r0 = android.widget.PopupWindow.class;	 Catch:{ Exception -> 0x0019 }
            r3 = "setWindowLayoutType";	 Catch:{ Exception -> 0x0019 }
            r4 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0019 }
            r5 = java.lang.Integer.TYPE;	 Catch:{ Exception -> 0x0019 }
            r4[r1] = r5;	 Catch:{ Exception -> 0x0019 }
            r0 = r0.getDeclaredMethod(r3, r4);	 Catch:{ Exception -> 0x0019 }
            sSetWindowLayoutTypeMethod = r0;	 Catch:{ Exception -> 0x0019 }
            r0.setAccessible(r2);	 Catch:{ Exception -> 0x0019 }
        L_0x0019:
            sSetWindowLayoutTypeMethodAttempted = r2;
        L_0x001b:
            r0 = sSetWindowLayoutTypeMethod;
            if (r0 == 0) goto L_0x002d;
        L_0x001f:
            r0 = sSetWindowLayoutTypeMethod;	 Catch:{ Exception -> 0x002d }
            r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x002d }
            r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x002d }
            r2[r1] = r8;	 Catch:{ Exception -> 0x002d }
            r0.invoke(r7, r2);	 Catch:{ Exception -> 0x002d }
            return;
        L_0x002d:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl.setWindowLayoutType(android.widget.PopupWindow, int):void");
        }

        public int getWindowLayoutType(android.widget.PopupWindow r6) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r5 = this;
            r0 = sGetWindowLayoutTypeMethodAttempted;
            r1 = 0;
            if (r0 != 0) goto L_0x0017;
        L_0x0005:
            r0 = 1;
            r2 = android.widget.PopupWindow.class;	 Catch:{ Exception -> 0x0015 }
            r3 = "getWindowLayoutType";	 Catch:{ Exception -> 0x0015 }
            r4 = new java.lang.Class[r1];	 Catch:{ Exception -> 0x0015 }
            r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ Exception -> 0x0015 }
            sGetWindowLayoutTypeMethod = r2;	 Catch:{ Exception -> 0x0015 }
            r2.setAccessible(r0);	 Catch:{ Exception -> 0x0015 }
        L_0x0015:
            sGetWindowLayoutTypeMethodAttempted = r0;
        L_0x0017:
            r0 = sGetWindowLayoutTypeMethod;
            if (r0 == 0) goto L_0x002a;
        L_0x001b:
            r0 = sGetWindowLayoutTypeMethod;	 Catch:{ Exception -> 0x002a }
            r2 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x002a }
            r6 = r0.invoke(r6, r2);	 Catch:{ Exception -> 0x002a }
            r6 = (java.lang.Integer) r6;	 Catch:{ Exception -> 0x002a }
            r6 = r6.intValue();	 Catch:{ Exception -> 0x002a }
            return r6;
        L_0x002a:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl.getWindowLayoutType(android.widget.PopupWindow):int");
        }
    }

    @RequiresApi(19)
    static class PopupWindowCompatApi19Impl extends PopupWindowCompatBaseImpl {
        PopupWindowCompatApi19Impl() {
        }

        public void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2, i3);
        }
    }

    @RequiresApi(21)
    static class PopupWindowCompatApi21Impl extends PopupWindowCompatApi19Impl {
        private static final String TAG = "PopupWindowCompatApi21";
        private static Field sOverlapAnchorField;

        PopupWindowCompatApi21Impl() {
        }

        static {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r0 = android.widget.PopupWindow.class;	 Catch:{ NoSuchFieldException -> 0x000f }
            r1 = "mOverlapAnchor";	 Catch:{ NoSuchFieldException -> 0x000f }
            r0 = r0.getDeclaredField(r1);	 Catch:{ NoSuchFieldException -> 0x000f }
            sOverlapAnchorField = r0;	 Catch:{ NoSuchFieldException -> 0x000f }
            r1 = 1;	 Catch:{ NoSuchFieldException -> 0x000f }
            r0.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x000f }
            return;
        L_0x000f:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.PopupWindowCompat.PopupWindowCompatApi21Impl.<clinit>():void");
        }

        public void setOverlapAnchor(android.widget.PopupWindow r2, boolean r3) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r1 = this;
            r0 = sOverlapAnchorField;
            if (r0 == 0) goto L_0x000e;
        L_0x0004:
            r0 = sOverlapAnchorField;	 Catch:{ IllegalAccessException -> 0x000e }
            r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ IllegalAccessException -> 0x000e }
            r0.set(r2, r3);	 Catch:{ IllegalAccessException -> 0x000e }
            return;
        L_0x000e:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.PopupWindowCompat.PopupWindowCompatApi21Impl.setOverlapAnchor(android.widget.PopupWindow, boolean):void");
        }

        public boolean getOverlapAnchor(android.widget.PopupWindow r2) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r1 = this;
            r0 = sOverlapAnchorField;
            if (r0 == 0) goto L_0x0011;
        L_0x0004:
            r0 = sOverlapAnchorField;	 Catch:{ IllegalAccessException -> 0x0011 }
            r2 = r0.get(r2);	 Catch:{ IllegalAccessException -> 0x0011 }
            r2 = (java.lang.Boolean) r2;	 Catch:{ IllegalAccessException -> 0x0011 }
            r2 = r2.booleanValue();	 Catch:{ IllegalAccessException -> 0x0011 }
            return r2;
        L_0x0011:
            r2 = 0;
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.PopupWindowCompat.PopupWindowCompatApi21Impl.getOverlapAnchor(android.widget.PopupWindow):boolean");
        }
    }

    @RequiresApi(23)
    static class PopupWindowCompatApi23Impl extends PopupWindowCompatApi21Impl {
        PopupWindowCompatApi23Impl() {
        }

        public void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }

        public boolean getOverlapAnchor(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        public void setWindowLayoutType(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }

        public int getWindowLayoutType(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            IMPL = new PopupWindowCompatApi23Impl();
        } else if (VERSION.SDK_INT >= 21) {
            IMPL = new PopupWindowCompatApi21Impl();
        } else if (VERSION.SDK_INT >= 19) {
            IMPL = new PopupWindowCompatApi19Impl();
        } else {
            IMPL = new PopupWindowCompatBaseImpl();
        }
    }

    private PopupWindowCompat() {
    }

    public static void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        IMPL.showAsDropDown(popupWindow, view, i, i2, i3);
    }

    public static void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
        IMPL.setOverlapAnchor(popupWindow, z);
    }

    public static boolean getOverlapAnchor(PopupWindow popupWindow) {
        return IMPL.getOverlapAnchor(popupWindow);
    }

    public static void setWindowLayoutType(PopupWindow popupWindow, int i) {
        IMPL.setWindowLayoutType(popupWindow, i);
    }

    public static int getWindowLayoutType(PopupWindow popupWindow) {
        return IMPL.getWindowLayoutType(popupWindow);
    }
}
