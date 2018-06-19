package android.support.v4.content.res;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.AnyRes;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StyleableRes;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({Scope.LIBRARY_GROUP})
public class TypedArrayUtils {
    private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";

    public static boolean hasAttribute(@NonNull XmlPullParser xmlPullParser, @NonNull String str) {
        return xmlPullParser.getAttributeValue(NAMESPACE, str) != null ? true : null;
    }

    public static float getNamedFloat(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, @NonNull String str, @StyleableRes int i, float f) {
        if (hasAttribute(xmlPullParser, str) == null) {
            return f;
        }
        return typedArray.getFloat(i, f);
    }

    public static boolean getNamedBoolean(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, String str, @StyleableRes int i, boolean z) {
        if (hasAttribute(xmlPullParser, str) == null) {
            return z;
        }
        return typedArray.getBoolean(i, z);
    }

    public static int getNamedInt(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, String str, @StyleableRes int i, int i2) {
        if (hasAttribute(xmlPullParser, str) == null) {
            return i2;
        }
        return typedArray.getInt(i, i2);
    }

    @ColorInt
    public static int getNamedColor(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, String str, @StyleableRes int i, @ColorInt int i2) {
        if (hasAttribute(xmlPullParser, str) == null) {
            return i2;
        }
        return typedArray.getColor(i, i2);
    }

    @AnyRes
    public static int getNamedResourceId(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, String str, @StyleableRes int i, @AnyRes int i2) {
        if (hasAttribute(xmlPullParser, str) == null) {
            return i2;
        }
        return typedArray.getResourceId(i, i2);
    }

    public static String getNamedString(@NonNull TypedArray typedArray, @NonNull XmlPullParser xmlPullParser, String str, @StyleableRes int i) {
        if (hasAttribute(xmlPullParser, str) == null) {
            return null;
        }
        return typedArray.getString(i);
    }

    public static TypedValue peekNamedValue(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (hasAttribute(xmlPullParser, str) == null) {
            return null;
        }
        return typedArray.peekValue(i);
    }

    public static TypedArray obtainAttributes(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static boolean getBoolean(TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2, boolean z) {
        return typedArray.getBoolean(i, typedArray.getBoolean(i2, z));
    }

    public static Drawable getDrawable(TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2) {
        i = typedArray.getDrawable(i);
        return i == 0 ? typedArray.getDrawable(i2) : i;
    }

    public static int getInt(TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2, int i3) {
        return typedArray.getInt(i, typedArray.getInt(i2, i3));
    }

    @AnyRes
    public static int getResourceId(TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2, @AnyRes int i3) {
        return typedArray.getResourceId(i, typedArray.getResourceId(i2, i3));
    }

    public static String getString(TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2) {
        i = typedArray.getString(i);
        return i == 0 ? typedArray.getString(i2) : i;
    }

    public static CharSequence getText(TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2) {
        i = typedArray.getText(i);
        return i == 0 ? typedArray.getText(i2) : i;
    }

    public static CharSequence[] getTextArray(TypedArray typedArray, @StyleableRes int i, @StyleableRes int i2) {
        i = typedArray.getTextArray(i);
        return i == 0 ? typedArray.getTextArray(i2) : i;
    }

    public static int getAttr(Context context, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId != null ? i : i2;
    }
}
