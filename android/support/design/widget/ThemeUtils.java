package android.support.design.widget;

import android.content.Context;
import android.support.v7.appcompat.R;

class ThemeUtils {
    private static final int[] APPCOMPAT_CHECK_ATTRS = new int[]{R.attr.colorPrimary};

    ThemeUtils() {
    }

    static void checkAppCompatTheme(Context context) {
        context = context.obtainStyledAttributes(APPCOMPAT_CHECK_ATTRS);
        int hasValue = context.hasValue(0) ^ 1;
        context.recycle();
        if (hasValue != 0) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
