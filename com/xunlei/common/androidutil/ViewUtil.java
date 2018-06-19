package com.xunlei.common.androidutil;

import android.view.View;
import android.view.ViewGroup;

public class ViewUtil {
    public static String getViewAddress(View view) {
        return Integer.toHexString(System.identityHashCode(view));
    }

    public static void removeViewFromParent(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }
}
