package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ScaleGestureDetector;

public final class ScaleGestureDetectorCompat {
    private ScaleGestureDetectorCompat() {
    }

    @Deprecated
    public static void setQuickScaleEnabled(Object obj, boolean z) {
        setQuickScaleEnabled((ScaleGestureDetector) obj, z);
    }

    public static void setQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector, boolean z) {
        if (VERSION.SDK_INT >= 19) {
            scaleGestureDetector.setQuickScaleEnabled(z);
        }
    }

    @Deprecated
    public static boolean isQuickScaleEnabled(Object obj) {
        return isQuickScaleEnabled((ScaleGestureDetector) obj);
    }

    public static boolean isQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector) {
        return VERSION.SDK_INT >= 19 ? scaleGestureDetector.isQuickScaleEnabled() : null;
    }
}
