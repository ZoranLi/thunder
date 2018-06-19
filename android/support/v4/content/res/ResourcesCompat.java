package android.support.v4.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.FontRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.util.TypedValue;
import android.widget.TextView;

public final class ResourcesCompat {
    private static final String TAG = "ResourcesCompat";

    @Nullable
    public static Drawable getDrawable(@NonNull Resources resources, @DrawableRes int i, @Nullable Theme theme) throws NotFoundException {
        if (VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i, theme);
        }
        return resources.getDrawable(i);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources resources, @DrawableRes int i, int i2, @Nullable Theme theme) throws NotFoundException {
        if (VERSION.SDK_INT >= 21) {
            return resources.getDrawableForDensity(i, i2, theme);
        }
        if (VERSION.SDK_INT >= 15) {
            return resources.getDrawableForDensity(i, i2);
        }
        return resources.getDrawable(i);
    }

    @ColorInt
    public static int getColor(@NonNull Resources resources, @ColorRes int i, @Nullable Theme theme) throws NotFoundException {
        if (VERSION.SDK_INT >= 23) {
            return resources.getColor(i, theme);
        }
        return resources.getColor(i);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i, @Nullable Theme theme) throws NotFoundException {
        if (VERSION.SDK_INT >= 23) {
            return resources.getColorStateList(i, theme);
        }
        return resources.getColorStateList(i);
    }

    @Nullable
    public static Typeface getFont(@NonNull Context context, @FontRes int i) throws NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, new TypedValue(), 0, null);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static Typeface getFont(@NonNull Context context, @FontRes int i, TypedValue typedValue, int i2, @Nullable TextView textView) throws NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, typedValue, i2, textView);
    }

    private static Typeface loadFont(@NonNull Context context, int i, TypedValue typedValue, int i2, @Nullable TextView textView) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        context = loadFont(context, resources, typedValue, i, i2, textView);
        if (context != null) {
            return context;
        }
        typedValue = new StringBuilder("Font resource ID #0x");
        typedValue.append(Integer.toHexString(i));
        throw new NotFoundException(typedValue.toString());
    }

    private static android.graphics.Typeface loadFont(@android.support.annotation.NonNull android.content.Context r8, android.content.res.Resources r9, android.util.TypedValue r10, int r11, int r12, @android.support.annotation.Nullable android.widget.TextView r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = r10.string;
        if (r0 != 0) goto L_0x0030;
    L_0x0004:
        r8 = new android.content.res.Resources$NotFoundException;
        r12 = new java.lang.StringBuilder;
        r13 = "Resource \"";
        r12.<init>(r13);
        r9 = r9.getResourceName(r11);
        r12.append(r9);
        r9 = "\" (";
        r12.append(r9);
        r9 = java.lang.Integer.toHexString(r11);
        r12.append(r9);
        r9 = ") is not a Font: ";
        r12.append(r9);
        r12.append(r10);
        r9 = r12.toString();
        r8.<init>(r9);
        throw r8;
    L_0x0030:
        r10 = r10.string;
        r10 = r10.toString();
        r0 = "res/";
        r0 = r10.startsWith(r0);
        r1 = 0;
        if (r0 != 0) goto L_0x0040;
    L_0x003f:
        return r1;
    L_0x0040:
        r0 = android.support.v4.graphics.TypefaceCompat.findFromCache(r9, r11, r12);
        if (r0 == 0) goto L_0x0047;
    L_0x0046:
        return r0;
    L_0x0047:
        r0 = r10.toLowerCase();	 Catch:{ XmlPullParserException -> 0x006d, XmlPullParserException -> 0x006d }
        r2 = ".xml";	 Catch:{ XmlPullParserException -> 0x006d, XmlPullParserException -> 0x006d }
        r0 = r0.endsWith(r2);	 Catch:{ XmlPullParserException -> 0x006d, XmlPullParserException -> 0x006d }
        if (r0 == 0) goto L_0x0068;	 Catch:{ XmlPullParserException -> 0x006d, XmlPullParserException -> 0x006d }
    L_0x0053:
        r10 = r9.getXml(r11);	 Catch:{ XmlPullParserException -> 0x006d, XmlPullParserException -> 0x006d }
        r3 = android.support.v4.content.res.FontResourcesParserCompat.parse(r10, r9);	 Catch:{ XmlPullParserException -> 0x006d, XmlPullParserException -> 0x006d }
        if (r3 != 0) goto L_0x005e;	 Catch:{ XmlPullParserException -> 0x006d, XmlPullParserException -> 0x006d }
    L_0x005d:
        return r1;	 Catch:{ XmlPullParserException -> 0x006d, XmlPullParserException -> 0x006d }
    L_0x005e:
        r2 = r8;	 Catch:{ XmlPullParserException -> 0x006d, XmlPullParserException -> 0x006d }
        r4 = r9;	 Catch:{ XmlPullParserException -> 0x006d, XmlPullParserException -> 0x006d }
        r5 = r11;	 Catch:{ XmlPullParserException -> 0x006d, XmlPullParserException -> 0x006d }
        r6 = r12;	 Catch:{ XmlPullParserException -> 0x006d, XmlPullParserException -> 0x006d }
        r7 = r13;	 Catch:{ XmlPullParserException -> 0x006d, XmlPullParserException -> 0x006d }
        r8 = android.support.v4.graphics.TypefaceCompat.createFromResourcesFamilyXml(r2, r3, r4, r5, r6, r7);	 Catch:{ XmlPullParserException -> 0x006d, XmlPullParserException -> 0x006d }
        return r8;	 Catch:{ XmlPullParserException -> 0x006d, XmlPullParserException -> 0x006d }
    L_0x0068:
        r8 = android.support.v4.graphics.TypefaceCompat.createFromResourcesFontFile(r8, r9, r11, r10, r12);	 Catch:{ XmlPullParserException -> 0x006d, XmlPullParserException -> 0x006d }
        return r8;
    L_0x006d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.res.ResourcesCompat.loadFont(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, android.widget.TextView):android.graphics.Typeface");
    }

    private ResourcesCompat() {
    }
}
