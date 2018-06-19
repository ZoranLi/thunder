package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.RequiresApi;
import android.util.Property;

@RequiresApi(21)
class ObjectAnimatorUtilsApi21 implements ObjectAnimatorUtilsImpl {
    ObjectAnimatorUtilsApi21() {
    }

    public <T> ObjectAnimator ofPointF(T t, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofObject(t, property, null, path);
    }
}
