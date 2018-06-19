package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

class ObjectAnimatorUtils {
    private static final ObjectAnimatorUtilsImpl IMPL;

    ObjectAnimatorUtils() {
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            IMPL = new ObjectAnimatorUtilsApi21();
        } else {
            IMPL = new ObjectAnimatorUtilsApi14();
        }
    }

    static <T> ObjectAnimator ofPointF(T t, Property<T, PointF> property, Path path) {
        return IMPL.ofPointF(t, property, path);
    }
}
