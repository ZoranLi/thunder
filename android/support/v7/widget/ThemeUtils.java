package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.util.TypedValue;

class ThemeUtils {
    static final int[] ACTIVATED_STATE_SET = new int[]{16843518};
    static final int[] CHECKED_STATE_SET = new int[]{16842912};
    static final int[] DISABLED_STATE_SET = new int[]{-16842910};
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] FOCUSED_STATE_SET = new int[]{16842908};
    static final int[] NOT_PRESSED_OR_FOCUSED_STATE_SET = new int[]{-16842919, -16842908};
    static final int[] PRESSED_STATE_SET = new int[]{16842919};
    static final int[] SELECTED_STATE_SET = new int[]{16842913};
    private static final int[] TEMP_ARRAY = new int[1];
    private static final ThreadLocal<TypedValue> TL_TYPED_VALUE = new ThreadLocal();

    ThemeUtils() {
    }

    public static ColorStateList createDisabledStateList(int i, int i2) {
        r1 = new int[2][];
        int[] iArr = new int[]{DISABLED_STATE_SET, i2};
        r1[1] = EMPTY_STATE_SET;
        iArr[1] = i;
        return new ColorStateList(r1, iArr);
    }

    public static int getThemeAttrColor(Context context, int i) {
        TEMP_ARRAY[0] = i;
        context = TintTypedArray.obtainStyledAttributes(context, null, TEMP_ARRAY);
        try {
            i = context.getColor(0, 0);
            return i;
        } finally {
            context.recycle();
        }
    }

    public static ColorStateList getThemeAttrColorStateList(Context context, int i) {
        TEMP_ARRAY[0] = i;
        context = TintTypedArray.obtainStyledAttributes(context, null, TEMP_ARRAY);
        try {
            i = context.getColorStateList(0);
            return i;
        } finally {
            context.recycle();
        }
    }

    public static int getDisabledThemeAttrColor(Context context, int i) {
        ColorStateList themeAttrColorStateList = getThemeAttrColorStateList(context, i);
        if (themeAttrColorStateList != null && themeAttrColorStateList.isStateful()) {
            return themeAttrColorStateList.getColorForState(DISABLED_STATE_SET, themeAttrColorStateList.getDefaultColor());
        }
        TypedValue typedValue = getTypedValue();
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        return getThemeAttrColor(context, i, typedValue.getFloat());
    }

    private static TypedValue getTypedValue() {
        TypedValue typedValue = (TypedValue) TL_TYPED_VALUE.get();
        if (typedValue != null) {
            return typedValue;
        }
        typedValue = new TypedValue();
        TL_TYPED_VALUE.set(typedValue);
        return typedValue;
    }

    static int getThemeAttrColor(Context context, int i, float f) {
        context = getThemeAttrColor(context, i);
        return ColorUtils.setAlphaComponent(context, Math.round(((float) Color.alpha(context)) * f));
    }
}
