package android.support.transition;

import android.support.annotation.RequiresApi;
import java.lang.reflect.Method;

@RequiresApi(22)
class ViewUtilsApi22 extends ViewUtilsApi21 {
    private static final String TAG = "ViewUtilsApi22";
    private static Method sSetLeftTopRightBottomMethod;
    private static boolean sSetLeftTopRightBottomMethodFetched;

    ViewUtilsApi22() {
    }

    public void setLeftTopRightBottom(android.view.View r4, int r5, int r6, int r7, int r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.fetchSetLeftTopRightBottomMethod();
        r0 = sSetLeftTopRightBottomMethod;
        if (r0 == 0) goto L_0x0038;
    L_0x0007:
        r0 = sSetLeftTopRightBottomMethod;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r1 = 4;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r2 = 0;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r1[r2] = r5;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r5 = 1;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r1[r5] = r6;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r5 = 2;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r6 = java.lang.Integer.valueOf(r7);	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r1[r5] = r6;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r5 = 3;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r6 = java.lang.Integer.valueOf(r8);	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r1[r5] = r6;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        r0.invoke(r4, r1);	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x002c }
        return;
    L_0x002c:
        r4 = move-exception;
        r5 = new java.lang.RuntimeException;
        r4 = r4.getCause();
        r5.<init>(r4);
        throw r5;
    L_0x0037:
        return;
    L_0x0038:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewUtilsApi22.setLeftTopRightBottom(android.view.View, int, int, int, int):void");
    }

    @android.annotation.SuppressLint({"PrivateApi"})
    private void fetchSetLeftTopRightBottomMethod() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = sSetLeftTopRightBottomMethodFetched;
        if (r0 != 0) goto L_0x002a;
    L_0x0004:
        r0 = 1;
        r1 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x0028 }
        r2 = "setLeftTopRightBottom";	 Catch:{ NoSuchMethodException -> 0x0028 }
        r3 = 4;	 Catch:{ NoSuchMethodException -> 0x0028 }
        r3 = new java.lang.Class[r3];	 Catch:{ NoSuchMethodException -> 0x0028 }
        r4 = 0;	 Catch:{ NoSuchMethodException -> 0x0028 }
        r5 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x0028 }
        r3[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x0028 }
        r4 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x0028 }
        r3[r0] = r4;	 Catch:{ NoSuchMethodException -> 0x0028 }
        r4 = 2;	 Catch:{ NoSuchMethodException -> 0x0028 }
        r5 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x0028 }
        r3[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x0028 }
        r4 = 3;	 Catch:{ NoSuchMethodException -> 0x0028 }
        r5 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x0028 }
        r3[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x0028 }
        r1 = r1.getDeclaredMethod(r2, r3);	 Catch:{ NoSuchMethodException -> 0x0028 }
        sSetLeftTopRightBottomMethod = r1;	 Catch:{ NoSuchMethodException -> 0x0028 }
        r1.setAccessible(r0);	 Catch:{ NoSuchMethodException -> 0x0028 }
    L_0x0028:
        sSetLeftTopRightBottomMethodFetched = r0;
    L_0x002a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewUtilsApi22.fetchSetLeftTopRightBottomMethod():void");
    }
}
