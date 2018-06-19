package android.support.transition;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.View;
import java.lang.reflect.Method;

@RequiresApi(19)
class ViewUtilsApi19 extends ViewUtilsApi18 {
    private static final String TAG = "ViewUtilsApi19";
    private static Method sGetTransitionAlphaMethod;
    private static boolean sGetTransitionAlphaMethodFetched;
    private static Method sSetTransitionAlphaMethod;
    private static boolean sSetTransitionAlphaMethodFetched;

    public void clearNonTransitionAlpha(@NonNull View view) {
    }

    public void saveNonTransitionAlpha(@NonNull View view) {
    }

    ViewUtilsApi19() {
    }

    public void setTransitionAlpha(@android.support.annotation.NonNull android.view.View r4, float r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.fetchSetTransitionAlphaMethod();
        r0 = sSetTransitionAlphaMethod;
        if (r0 == 0) goto L_0x0023;
    L_0x0007:
        r0 = sSetTransitionAlphaMethod;	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0017 }
        r1 = 1;	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0017 }
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0017 }
        r2 = 0;	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0017 }
        r5 = java.lang.Float.valueOf(r5);	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0017 }
        r1[r2] = r5;	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0017 }
        r0.invoke(r4, r1);	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0017 }
        return;
    L_0x0017:
        r4 = move-exception;
        r5 = new java.lang.RuntimeException;
        r4 = r4.getCause();
        r5.<init>(r4);
        throw r5;
    L_0x0022:
        return;
    L_0x0023:
        r4.setAlpha(r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewUtilsApi19.setTransitionAlpha(android.view.View, float):void");
    }

    public float getTransitionAlpha(@android.support.annotation.NonNull android.view.View r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r2.fetchGetTransitionAlphaMethod();
        r0 = sGetTransitionAlphaMethod;
        if (r0 == 0) goto L_0x0022;
    L_0x0007:
        r0 = sGetTransitionAlphaMethod;	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0017 }
        r1 = 0;	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0017 }
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0017 }
        r0 = r0.invoke(r3, r1);	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0017 }
        r0 = (java.lang.Float) r0;	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0017 }
        r0 = r0.floatValue();	 Catch:{ IllegalAccessException -> 0x0022, InvocationTargetException -> 0x0017 }
        return r0;
    L_0x0017:
        r3 = move-exception;
        r0 = new java.lang.RuntimeException;
        r3 = r3.getCause();
        r0.<init>(r3);
        throw r0;
    L_0x0022:
        r3 = super.getTransitionAlpha(r3);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewUtilsApi19.getTransitionAlpha(android.view.View):float");
    }

    private void fetchSetTransitionAlphaMethod() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = sSetTransitionAlphaMethodFetched;
        if (r0 != 0) goto L_0x001b;
    L_0x0004:
        r0 = 1;
        r1 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r2 = "setTransitionAlpha";	 Catch:{ NoSuchMethodException -> 0x0019 }
        r3 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0019 }
        r4 = 0;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r5 = java.lang.Float.TYPE;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r3[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r1 = r1.getDeclaredMethod(r2, r3);	 Catch:{ NoSuchMethodException -> 0x0019 }
        sSetTransitionAlphaMethod = r1;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r1.setAccessible(r0);	 Catch:{ NoSuchMethodException -> 0x0019 }
    L_0x0019:
        sSetTransitionAlphaMethodFetched = r0;
    L_0x001b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewUtilsApi19.fetchSetTransitionAlphaMethod():void");
    }

    private void fetchGetTransitionAlphaMethod() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = sGetTransitionAlphaMethodFetched;
        if (r0 != 0) goto L_0x0017;
    L_0x0004:
        r0 = 1;
        r1 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x0015 }
        r2 = "getTransitionAlpha";	 Catch:{ NoSuchMethodException -> 0x0015 }
        r3 = 0;	 Catch:{ NoSuchMethodException -> 0x0015 }
        r3 = new java.lang.Class[r3];	 Catch:{ NoSuchMethodException -> 0x0015 }
        r1 = r1.getDeclaredMethod(r2, r3);	 Catch:{ NoSuchMethodException -> 0x0015 }
        sGetTransitionAlphaMethod = r1;	 Catch:{ NoSuchMethodException -> 0x0015 }
        r1.setAccessible(r0);	 Catch:{ NoSuchMethodException -> 0x0015 }
    L_0x0015:
        sGetTransitionAlphaMethodFetched = r0;
    L_0x0017:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewUtilsApi19.fetchGetTransitionAlphaMethod():void");
    }
}
