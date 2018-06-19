package android.support.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.widget.ImageView;

class ImageViewUtils {
    private static final ImageViewUtilsImpl IMPL;

    ImageViewUtils() {
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            IMPL = new ImageViewUtilsApi21();
        } else {
            IMPL = new ImageViewUtilsApi14();
        }
    }

    static void startAnimateTransform(ImageView imageView) {
        IMPL.startAnimateTransform(imageView);
    }

    static void animateTransform(ImageView imageView, Matrix matrix) {
        IMPL.animateTransform(imageView, matrix);
    }

    static void reserveEndAnimateTransform(ImageView imageView, Animator animator) {
        IMPL.reserveEndAnimateTransform(imageView, animator);
    }
}
