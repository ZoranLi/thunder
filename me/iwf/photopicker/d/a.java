package me.iwf.photopicker.d;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;

/* compiled from: AndroidLifecycleUtils */
public final class a {
    public static boolean a(Context context) {
        if (context != null && (context instanceof Activity)) {
            return a((Activity) context);
        }
        return true;
    }

    public static boolean a(Activity activity) {
        if (activity == null) {
            return true;
        }
        boolean z = VERSION.SDK_INT >= 17 && activity.isDestroyed();
        if (!z) {
            if (activity.isFinishing() == null) {
                return true;
            }
        }
        return false;
    }
}
