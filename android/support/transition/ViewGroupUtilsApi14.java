package android.support.transition;

import android.animation.LayoutTransition;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@RequiresApi(14)
class ViewGroupUtilsApi14 implements ViewGroupUtilsImpl {
    private static final int LAYOUT_TRANSITION_CHANGING = 4;
    private static final String TAG = "ViewGroupUtilsApi14";
    private static Method sCancelMethod;
    private static boolean sCancelMethodFetched;
    private static LayoutTransition sEmptyLayoutTransition;
    private static Field sLayoutSuppressedField;
    private static boolean sLayoutSuppressedFieldFetched;

    ViewGroupUtilsApi14() {
    }

    public ViewGroupOverlayImpl getOverlay(@NonNull ViewGroup viewGroup) {
        return ViewGroupOverlayApi14.createFrom(viewGroup);
    }

    public void suppressLayout(@android.support.annotation.NonNull android.view.ViewGroup r6, boolean r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = sEmptyLayoutTransition;
        r1 = 1;
        r2 = 0;
        r3 = 0;
        if (r0 != 0) goto L_0x0028;
    L_0x0007:
        r0 = new android.support.transition.ViewGroupUtilsApi14$1;
        r0.<init>();
        sEmptyLayoutTransition = r0;
        r4 = 2;
        r0.setAnimator(r4, r3);
        r0 = sEmptyLayoutTransition;
        r0.setAnimator(r2, r3);
        r0 = sEmptyLayoutTransition;
        r0.setAnimator(r1, r3);
        r0 = sEmptyLayoutTransition;
        r4 = 3;
        r0.setAnimator(r4, r3);
        r0 = sEmptyLayoutTransition;
        r4 = 4;
        r0.setAnimator(r4, r3);
    L_0x0028:
        if (r7 == 0) goto L_0x0048;
    L_0x002a:
        r7 = r6.getLayoutTransition();
        if (r7 == 0) goto L_0x0042;
    L_0x0030:
        r0 = r7.isRunning();
        if (r0 == 0) goto L_0x0039;
    L_0x0036:
        cancelLayoutTransition(r7);
    L_0x0039:
        r0 = sEmptyLayoutTransition;
        if (r7 == r0) goto L_0x0042;
    L_0x003d:
        r0 = android.support.transition.R.id.transition_layout_save;
        r6.setTag(r0, r7);
    L_0x0042:
        r7 = sEmptyLayoutTransition;
        r6.setLayoutTransition(r7);
        return;
    L_0x0048:
        r6.setLayoutTransition(r3);
        r7 = sLayoutSuppressedFieldFetched;
        if (r7 != 0) goto L_0x005e;
    L_0x004f:
        r7 = android.view.ViewGroup.class;	 Catch:{ NoSuchFieldException -> 0x005c }
        r0 = "mLayoutSuppressed";	 Catch:{ NoSuchFieldException -> 0x005c }
        r7 = r7.getDeclaredField(r0);	 Catch:{ NoSuchFieldException -> 0x005c }
        sLayoutSuppressedField = r7;	 Catch:{ NoSuchFieldException -> 0x005c }
        r7.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x005c }
    L_0x005c:
        sLayoutSuppressedFieldFetched = r1;
    L_0x005e:
        r7 = sLayoutSuppressedField;
        if (r7 == 0) goto L_0x0070;
    L_0x0062:
        r7 = sLayoutSuppressedField;	 Catch:{ IllegalAccessException -> 0x0070 }
        r7 = r7.getBoolean(r6);	 Catch:{ IllegalAccessException -> 0x0070 }
        if (r7 == 0) goto L_0x006f;
    L_0x006a:
        r0 = sLayoutSuppressedField;	 Catch:{ IllegalAccessException -> 0x006f }
        r0.setBoolean(r6, r2);	 Catch:{ IllegalAccessException -> 0x006f }
    L_0x006f:
        r2 = r7;
    L_0x0070:
        if (r2 == 0) goto L_0x0075;
    L_0x0072:
        r6.requestLayout();
    L_0x0075:
        r7 = android.support.transition.R.id.transition_layout_save;
        r7 = r6.getTag(r7);
        r7 = (android.animation.LayoutTransition) r7;
        if (r7 == 0) goto L_0x0087;
    L_0x007f:
        r0 = android.support.transition.R.id.transition_layout_save;
        r6.setTag(r0, r3);
        r6.setLayoutTransition(r7);
    L_0x0087:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewGroupUtilsApi14.suppressLayout(android.view.ViewGroup, boolean):void");
    }

    private static void cancelLayoutTransition(android.animation.LayoutTransition r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = sCancelMethodFetched;
        r1 = 0;
        if (r0 != 0) goto L_0x0017;
    L_0x0005:
        r0 = 1;
        r2 = android.animation.LayoutTransition.class;	 Catch:{ NoSuchMethodException -> 0x0015 }
        r3 = "cancel";	 Catch:{ NoSuchMethodException -> 0x0015 }
        r4 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x0015 }
        r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0015 }
        sCancelMethod = r2;	 Catch:{ NoSuchMethodException -> 0x0015 }
        r2.setAccessible(r0);	 Catch:{ NoSuchMethodException -> 0x0015 }
    L_0x0015:
        sCancelMethodFetched = r0;
    L_0x0017:
        r0 = sCancelMethod;
        if (r0 == 0) goto L_0x0023;
    L_0x001b:
        r0 = sCancelMethod;	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0023 }
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0023 }
        r0.invoke(r5, r1);	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0023 }
    L_0x0022:
        return;
    L_0x0023:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewGroupUtilsApi14.cancelLayoutTransition(android.animation.LayoutTransition):void");
    }
}
