package android.support.transition;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.ViewGroup;
import java.lang.reflect.Method;

@RequiresApi(18)
class ViewGroupUtilsApi18 extends ViewGroupUtilsApi14 {
    private static final String TAG = "ViewUtilsApi18";
    private static Method sSuppressLayoutMethod;
    private static boolean sSuppressLayoutMethodFetched;

    ViewGroupUtilsApi18() {
    }

    public ViewGroupOverlayImpl getOverlay(@NonNull ViewGroup viewGroup) {
        return new ViewGroupOverlayApi18(viewGroup);
    }

    public void suppressLayout(@android.support.annotation.NonNull android.view.ViewGroup r4, boolean r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.fetchSuppressLayoutMethod();
        r0 = sSuppressLayoutMethod;
        if (r0 == 0) goto L_0x0017;
    L_0x0007:
        r0 = sSuppressLayoutMethod;	 Catch:{ IllegalAccessException -> 0x0016, InvocationTargetException -> 0x0017 }
        r1 = 1;	 Catch:{ IllegalAccessException -> 0x0016, InvocationTargetException -> 0x0017 }
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x0016, InvocationTargetException -> 0x0017 }
        r2 = 0;	 Catch:{ IllegalAccessException -> 0x0016, InvocationTargetException -> 0x0017 }
        r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ IllegalAccessException -> 0x0016, InvocationTargetException -> 0x0017 }
        r1[r2] = r5;	 Catch:{ IllegalAccessException -> 0x0016, InvocationTargetException -> 0x0017 }
        r0.invoke(r4, r1);	 Catch:{ IllegalAccessException -> 0x0016, InvocationTargetException -> 0x0017 }
    L_0x0016:
        return;
    L_0x0017:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewGroupUtilsApi18.suppressLayout(android.view.ViewGroup, boolean):void");
    }

    private void fetchSuppressLayoutMethod() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = sSuppressLayoutMethodFetched;
        if (r0 != 0) goto L_0x001b;
    L_0x0004:
        r0 = 1;
        r1 = android.view.ViewGroup.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r2 = "suppressLayout";	 Catch:{ NoSuchMethodException -> 0x0019 }
        r3 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0019 }
        r4 = 0;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r5 = java.lang.Boolean.TYPE;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r3[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r1 = r1.getDeclaredMethod(r2, r3);	 Catch:{ NoSuchMethodException -> 0x0019 }
        sSuppressLayoutMethod = r1;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r1.setAccessible(r0);	 Catch:{ NoSuchMethodException -> 0x0019 }
    L_0x0019:
        sSuppressLayoutMethodFetched = r0;
    L_0x001b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewGroupUtilsApi18.fetchSuppressLayoutMethod():void");
    }
}
