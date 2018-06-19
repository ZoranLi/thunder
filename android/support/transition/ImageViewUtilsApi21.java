package android.support.transition;

import android.animation.Animator;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;
import java.lang.reflect.Method;

@RequiresApi(21)
class ImageViewUtilsApi21 implements ImageViewUtilsImpl {
    private static final String TAG = "ImageViewUtilsApi21";
    private static Method sAnimateTransformMethod;
    private static boolean sAnimateTransformMethodFetched;

    public void reserveEndAnimateTransform(ImageView imageView, Animator animator) {
    }

    public void startAnimateTransform(ImageView imageView) {
    }

    ImageViewUtilsApi21() {
    }

    public void animateTransform(android.widget.ImageView r4, android.graphics.Matrix r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.fetchAnimateTransformMethod();
        r0 = sAnimateTransformMethod;
        if (r0 == 0) goto L_0x001f;
    L_0x0007:
        r0 = sAnimateTransformMethod;	 Catch:{ IllegalAccessException -> 0x001e, InvocationTargetException -> 0x0013 }
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ImageViewUtilsApi21.animateTransform(android.widget.ImageView, android.graphics.Matrix):void");
    }

    private void fetchAnimateTransformMethod() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = sAnimateTransformMethodFetched;
        if (r0 != 0) goto L_0x001b;
    L_0x0004:
        r0 = 1;
        r1 = android.widget.ImageView.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r2 = "animateTransform";	 Catch:{ NoSuchMethodException -> 0x0019 }
        r3 = new java.lang.Class[r0];	 Catch:{ NoSuchMethodException -> 0x0019 }
        r4 = 0;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r5 = android.graphics.Matrix.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r3[r4] = r5;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r1 = r1.getDeclaredMethod(r2, r3);	 Catch:{ NoSuchMethodException -> 0x0019 }
        sAnimateTransformMethod = r1;	 Catch:{ NoSuchMethodException -> 0x0019 }
        r1.setAccessible(r0);	 Catch:{ NoSuchMethodException -> 0x0019 }
    L_0x0019:
        sAnimateTransformMethodFetched = r0;
    L_0x001b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.ImageViewUtilsApi21.fetchAnimateTransformMethod():void");
    }
}
