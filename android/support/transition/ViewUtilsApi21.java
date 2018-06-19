package android.support.transition;

import android.support.annotation.RequiresApi;
import java.lang.reflect.Method;

@RequiresApi(21)
class ViewUtilsApi21 extends ViewUtilsApi19 {
    private static final String TAG = "ViewUtilsApi21";
    private static Method sSetAnimationMatrixMethod;
    private static boolean sSetAnimationMatrixMethodFetched;
    private static Method sTransformMatrixToGlobalMethod;
    private static boolean sTransformMatrixToGlobalMethodFetched;
    private static Method sTransformMatrixToLocalMethod;
    private static boolean sTransformMatrixToLocalMethodFetched;

    ViewUtilsApi21() {
    }

    public void transformMatrixToGlobal(@android.support.annotation.NonNull android.view.View r4, @android.support.annotation.NonNull android.graphics.Matrix r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.fetchTransformMatrixToGlobalMethod();
        r0 = sTransformMatrixToGlobalMethod;
        if (r0 == 0) goto L_0x001f;
    L_0x0007:
        r0 = sTransformMatrixToGlobalMethod;	 Catch:{ IllegalAccessException -> 0x001e, InvocationTargetException -> 0x0013 }
        r1 = 1;	 Catch:{ IllegalAccessException -> 0x001e, InvocationTargetException -> 0x0013 }
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x001e, InvocationTargetException -> 0x0013 }
        r2 = 0;	 Catch:{ IllegalAccessException -> 0x001e, InvocationTargetException -> 0x0013 }
        r1[r2] = r5;	 Catch:{ IllegalAccessException -> 0x001e, InvocationTargetException -> 0x0013 }
        r0.invoke(r4, r1);	 Catch:{ IllegalAccessException -> 0x001e, InvocationTargetException -> 0x0013 }
        return;
    L_0x0013:
        r4 = move-exception;
        r5 = new java.lang.RuntimeException;
        r4 = r4.getCause();
        r5.<init>(r4);
        throw r5;
    L_0x001e:
        return;
    L_0x001f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewUtilsApi21.transformMatrixToGlobal(android.view.View, android.graphics.Matrix):void");
    }

    public void transformMatrixToLocal(@android.support.annotation.NonNull android.view.View r4, @android.support.annotation.NonNull android.graphics.Matrix r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.fetchTransformMatrixToLocalMethod();
        r0 = sTransformMatrixToLocalMethod;
        if (r0 == 0) goto L_0x001f;
    L_0x0007:
        r0 = sTransformMatrixToLocalMethod;	 Catch:{ IllegalAccessException -> 0x001e, InvocationTargetException -> 0x0013 }
        r1 = 1;	 Catch:{ IllegalAccessException -> 0x001e, InvocationTargetException -> 0x0013 }
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x001e, InvocationTargetException -> 0x0013 }
        r2 = 0;	 Catch:{ IllegalAccessException -> 0x001e, InvocationTargetException -> 0x0013 }
        r1[r2] = r5;	 Catch:{ IllegalAccessException -> 0x001e, InvocationTargetException -> 0x0013 }
        r0.invoke(r4, r1);	 Catch:{ IllegalAccessException -> 0x001e, InvocationTargetException -> 0x0013 }
        return;
    L_0x0013:
        r4 = move-exception;
        r5 = new java.lang.RuntimeException;
        r4 = r4.getCause();
        r5.<init>(r4);
        throw r5;
    L_0x001e:
        return;
    L_0x001f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewUtilsApi21.transformMatrixToLocal(android.view.View, android.graphics.Matrix):void");
    }

    public void setAnimationMatrix(@android.support.annotation.NonNull android.view.View r4, android.graphics.Matrix r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.fetchSetAnimationMatrix();
        r0 = sSetAnimationMatrixMethod;
        if (r0 == 0) goto L_0x001f;
    L_0x0007:
        r0 = sSetAnimationMatrixMethod;	 Catch:{ InvocationTargetException -> 0x001e, IllegalAccessException -> 0x0013 }
        r1 = 1;	 Catch:{ InvocationTargetException -> 0x001e, IllegalAccessException -> 0x0013 }
        r1 = new java.lang.Object[r1];	 Catch:{ InvocationTargetException -> 0x001e, IllegalAccessException -> 0x0013 }
        r2 = 0;	 Catch:{ InvocationTargetException -> 0x001e, IllegalAccessException -> 0x0013 }
        r1[r2] = r5;	 Catch:{ InvocationTargetException -> 0x001e, IllegalAccessException -> 0x0013 }
        r0.invoke(r4, r1);	 Catch:{ InvocationTargetException -> 0x001e, IllegalAccessException -> 0x0013 }
        return;
    L_0x0013:
        r4 = move-exception;
        r5 = new java.lang.RuntimeException;
        r4 = r4.getCause();
        r5.<init>(r4);
        throw r5;
    L_0x001e:
        return;
    L_0x001f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewUtilsApi21.setAnimationMatrix(android.view.View, android.graphics.Matrix):void");
    }

    private void fetchTransformMatrixToGlobalMethod() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = sTransformMatrixToGlobalMethodFetched;
        if (r0 != 0) goto L_0x001b;
    L_0x0004:
        r0 = 1;
        r1 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r2 = "transformMatrixToGlobal";	 Catch:{ NoSuchMethodException -> 0x0019 }
        r3 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0019 }
        r4 = 0;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r5 = android.graphics.Matrix.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r3[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r1 = r1.getDeclaredMethod(r2, r3);	 Catch:{ NoSuchMethodException -> 0x0019 }
        sTransformMatrixToGlobalMethod = r1;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r1.setAccessible(r0);	 Catch:{ NoSuchMethodException -> 0x0019 }
    L_0x0019:
        sTransformMatrixToGlobalMethodFetched = r0;
    L_0x001b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewUtilsApi21.fetchTransformMatrixToGlobalMethod():void");
    }

    private void fetchTransformMatrixToLocalMethod() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = sTransformMatrixToLocalMethodFetched;
        if (r0 != 0) goto L_0x001b;
    L_0x0004:
        r0 = 1;
        r1 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r2 = "transformMatrixToLocal";	 Catch:{ NoSuchMethodException -> 0x0019 }
        r3 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0019 }
        r4 = 0;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r5 = android.graphics.Matrix.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r3[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r1 = r1.getDeclaredMethod(r2, r3);	 Catch:{ NoSuchMethodException -> 0x0019 }
        sTransformMatrixToLocalMethod = r1;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r1.setAccessible(r0);	 Catch:{ NoSuchMethodException -> 0x0019 }
    L_0x0019:
        sTransformMatrixToLocalMethodFetched = r0;
    L_0x001b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewUtilsApi21.fetchTransformMatrixToLocalMethod():void");
    }

    private void fetchSetAnimationMatrix() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = sSetAnimationMatrixMethodFetched;
        if (r0 != 0) goto L_0x001b;
    L_0x0004:
        r0 = 1;
        r1 = android.view.View.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r2 = "setAnimationMatrix";	 Catch:{ NoSuchMethodException -> 0x0019 }
        r3 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0019 }
        r4 = 0;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r5 = android.graphics.Matrix.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r3[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r1 = r1.getDeclaredMethod(r2, r3);	 Catch:{ NoSuchMethodException -> 0x0019 }
        sSetAnimationMatrixMethod = r1;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r1.setAccessible(r0);	 Catch:{ NoSuchMethodException -> 0x0019 }
    L_0x0019:
        sSetAnimationMatrixMethodFetched = r0;
    L_0x001b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ViewUtilsApi21.fetchSetAnimationMatrix():void");
    }
}
