package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public class ResourceManager {
    private static final String DRAWABLE = "drawable";
    private static final String DRAWABLE_HDPI = "drawable-hdpi";
    private static final String DRAWABLE_LDPI = "drawable-ldpi";
    private static final String DRAWABLE_MDPI = "drawable-mdpi";
    private static final String DRAWABLE_XHDPI = "drawable-xhdpi";
    private static final String DRAWABLE_XXHDPI = "drawable-xxhdpi";
    private static final String[] PRE_INSTALL_DRAWBLE_PATHS = new String[]{DRAWABLE_XXHDPI, DRAWABLE_XHDPI, DRAWABLE_HDPI, DRAWABLE_MDPI, DRAWABLE_LDPI, DRAWABLE};
    private static final String TAG = "com.sina.weibo.sdk.utils.ResourceManager";

    public static String getString(Context context, String str, String str2, String str3) {
        context = getLanguage();
        if (!Locale.SIMPLIFIED_CHINESE.equals(context)) {
            if (!"zh".equals(context.getLanguage()) || !context.getCountry().contains("CN")) {
                if (Locale.TRADITIONAL_CHINESE.equals(context) == null) {
                    if ("zh".equals(context.getLanguage()) == null || context.getCountry().contains("TW") == null) {
                        return str;
                    }
                }
                return str3;
            }
        }
        return str2;
    }

    public static Drawable getDrawable(Context context, String str) {
        return getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, str), false);
    }

    public static Drawable getNinePatchDrawable(Context context, String str) {
        return getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, str), true);
    }

    public static Locale getLanguage() {
        Locale locale = Locale.getDefault();
        if (!(Locale.SIMPLIFIED_CHINESE.equals(locale) || Locale.TRADITIONAL_CHINESE.equals(locale))) {
            if (locale.getLanguage().equals("zh")) {
                if (!locale.getCountry().contains("CN")) {
                    if (locale.getCountry().contains("TW")) {
                    }
                }
            }
            return Locale.ENGLISH;
        }
        return locale;
    }

    private static String getAppropriatePathOfDrawable(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            LogUtil.e(TAG, "id is NOT correct!");
            return null;
        }
        String currentDpiFolder = getCurrentDpiFolder(context);
        LogUtil.d(TAG, "find Appropriate path...");
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        int i4 = i3;
        while (i < PRE_INSTALL_DRAWBLE_PATHS.length) {
            if (PRE_INSTALL_DRAWBLE_PATHS[i].equals(currentDpiFolder)) {
                i3 = i;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(PRE_INSTALL_DRAWBLE_PATHS[i]);
            stringBuilder.append("/");
            stringBuilder.append(str);
            String stringBuilder2 = stringBuilder.toString();
            if (isFileExisted(context, stringBuilder2)) {
                if (i3 != i) {
                    if (i3 >= 0) {
                        break;
                    }
                    i4 = i;
                } else {
                    return stringBuilder2;
                }
            }
            i++;
        }
        i = -1;
        if (i4 <= 0 || i <= 0) {
            if (i4 <= 0 || i >= 0) {
                if (i4 >= 0 || i <= 0) {
                    LogUtil.e(TAG, "Not find the appropriate path for drawable");
                    if (i2 >= 0) {
                        LogUtil.e(TAG, "Not find the appropriate path for drawable");
                        return null;
                    }
                    context = new StringBuilder();
                    context.append(PRE_INSTALL_DRAWBLE_PATHS[i2]);
                    context.append("/");
                    context.append(str);
                    return context.toString();
                }
                i2 = i;
                if (i2 >= 0) {
                    context = new StringBuilder();
                    context.append(PRE_INSTALL_DRAWBLE_PATHS[i2]);
                    context.append("/");
                    context.append(str);
                    return context.toString();
                }
                LogUtil.e(TAG, "Not find the appropriate path for drawable");
                return null;
            }
        } else if (Math.abs(i3 - i) <= Math.abs(i3 - i4)) {
            i2 = i;
            if (i2 >= 0) {
                LogUtil.e(TAG, "Not find the appropriate path for drawable");
                return null;
            }
            context = new StringBuilder();
            context.append(PRE_INSTALL_DRAWBLE_PATHS[i2]);
            context.append("/");
            context.append(str);
            return context.toString();
        }
        i2 = i4;
        if (i2 >= 0) {
            context = new StringBuilder();
            context.append(PRE_INSTALL_DRAWBLE_PATHS[i2]);
            context.append("/");
            context.append(str);
            return context.toString();
        }
        LogUtil.e(TAG, "Not find the appropriate path for drawable");
        return null;
    }

    private static Drawable getDrawableFromAssert(Context context, String str, boolean z) {
        Drawable drawable = null;
        try {
            str = context.getAssets().open(str);
            if (str != null) {
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(str);
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    if (z) {
                        drawable = new NinePatchDrawable(new Resources(context.getAssets(), displayMetrics, context.getResources().getConfiguration()), decodeStream, decodeStream.getNinePatchChunk(), new Rect(0, 0, 0, 0), null);
                    } else {
                        decodeStream.setDensity(displayMetrics.densityDpi);
                        drawable = new BitmapDrawable(context.getResources(), decodeStream);
                    }
                } catch (IOException e) {
                    context = e;
                    try {
                        context.printStackTrace();
                        if (str != null) {
                            str.close();
                        }
                        return drawable;
                    } catch (Throwable th) {
                        context = th;
                        if (str != null) {
                            try {
                                str.close();
                            } catch (String str2) {
                                str2.printStackTrace();
                            }
                        }
                        throw context;
                    }
                }
            }
            if (str2 != null) {
                try {
                    str2.close();
                } catch (Context context2) {
                    context2.printStackTrace();
                }
            }
        } catch (IOException e2) {
            context2 = e2;
            str2 = null;
            context2.printStackTrace();
            if (str2 != null) {
                str2.close();
            }
            return drawable;
        } catch (Throwable th2) {
            context2 = th2;
            str2 = null;
            if (str2 != null) {
                str2.close();
            }
            throw context2;
        }
        return drawable;
    }

    private static boolean isFileExisted(android.content.Context r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r4 == 0) goto L_0x006c;
    L_0x0003:
        r1 = android.text.TextUtils.isEmpty(r5);
        if (r1 == 0) goto L_0x000a;
    L_0x0009:
        goto L_0x006c;
    L_0x000a:
        r4 = r4.getAssets();
        r1 = 0;
        r4 = r4.open(r5);	 Catch:{ IOException -> 0x003e }
        r1 = TAG;	 Catch:{ IOException -> 0x003a, all -> 0x0037 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x003a, all -> 0x0037 }
        r3 = "file [";	 Catch:{ IOException -> 0x003a, all -> 0x0037 }
        r2.<init>(r3);	 Catch:{ IOException -> 0x003a, all -> 0x0037 }
        r2.append(r5);	 Catch:{ IOException -> 0x003a, all -> 0x0037 }
        r3 = "] existed";	 Catch:{ IOException -> 0x003a, all -> 0x0037 }
        r2.append(r3);	 Catch:{ IOException -> 0x003a, all -> 0x0037 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x003a, all -> 0x0037 }
        com.sina.weibo.sdk.utils.LogUtil.d(r1, r2);	 Catch:{ IOException -> 0x003a, all -> 0x0037 }
        if (r4 == 0) goto L_0x0035;
    L_0x002d:
        r4.close();	 Catch:{ IOException -> 0x0031 }
        goto L_0x0035;
    L_0x0031:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0035:
        r4 = 1;
        return r4;
    L_0x0037:
        r5 = move-exception;
        r1 = r4;
        goto L_0x0061;
    L_0x003a:
        r1 = r4;
        goto L_0x003e;
    L_0x003c:
        r5 = move-exception;
        goto L_0x0061;
    L_0x003e:
        r4 = TAG;	 Catch:{ all -> 0x003c }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003c }
        r3 = "file [";	 Catch:{ all -> 0x003c }
        r2.<init>(r3);	 Catch:{ all -> 0x003c }
        r2.append(r5);	 Catch:{ all -> 0x003c }
        r5 = "] NOT existed";	 Catch:{ all -> 0x003c }
        r2.append(r5);	 Catch:{ all -> 0x003c }
        r5 = r2.toString();	 Catch:{ all -> 0x003c }
        com.sina.weibo.sdk.utils.LogUtil.d(r4, r5);	 Catch:{ all -> 0x003c }
        if (r1 == 0) goto L_0x0060;
    L_0x0058:
        r1.close();	 Catch:{ IOException -> 0x005c }
        goto L_0x0060;
    L_0x005c:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0060:
        return r0;
    L_0x0061:
        if (r1 == 0) goto L_0x006b;
    L_0x0063:
        r1.close();	 Catch:{ IOException -> 0x0067 }
        goto L_0x006b;
    L_0x0067:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x006b:
        throw r5;
    L_0x006c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.ResourceManager.isFileExisted(android.content.Context, java.lang.String):boolean");
    }

    private static String getCurrentDpiFolder(Context context) {
        context = context.getResources().getDisplayMetrics().densityDpi;
        if (context <= 120) {
            return DRAWABLE_LDPI;
        }
        if (context > 120 && context <= 160) {
            return DRAWABLE_MDPI;
        }
        if (context <= 160 || context > 240) {
            return (context <= 240 || context > 320) ? DRAWABLE_XXHDPI : DRAWABLE_XHDPI;
        } else {
            return DRAWABLE_HDPI;
        }
    }

    private static View extractView(Context context, String str, ViewGroup viewGroup) throws Exception {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(context.getAssets().openXmlResourceParser(str), viewGroup);
    }

    private static Drawable extractDrawable(Context context, String str) throws Exception {
        InputStream open = context.getAssets().open(str);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TypedValue typedValue = new TypedValue();
        typedValue.density = displayMetrics.densityDpi;
        context = Drawable.createFromResourceStream(context.getResources(), typedValue, open, str);
        open.close();
        return context;
    }

    public static int dp2px(Context context, int i) {
        return (int) (((double) (((float) i) * context.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    public static ColorStateList createColorStateList(int i, int i2) {
        int[] iArr = new int[]{i2, i2, i2, i};
        i = new int[4][];
        i[0] = new int[]{16842919};
        i[1] = new int[]{16842913};
        i[2] = new int[]{16842908};
        i[3] = StateSet.WILD_CARD;
        return new ColorStateList(i, iArr);
    }

    public static StateListDrawable createStateListDrawable(Context context, String str, String str2) {
        if (str.indexOf(".9") >= 0) {
            str = getNinePatchDrawable(context, str);
        } else {
            str = getDrawable(context, str);
        }
        if (str2.indexOf(".9") >= 0) {
            context = getNinePatchDrawable(context, str2);
        } else {
            context = getDrawable(context, str2);
        }
        str2 = new StateListDrawable();
        str2.addState(new int[]{16842919}, context);
        str2.addState(new int[]{16842913}, context);
        str2.addState(new int[]{16842908}, context);
        str2.addState(StateSet.WILD_CARD, str);
        return str2;
    }

    public static StateListDrawable createStateListDrawable(Context context, String str, String str2, String str3) {
        if (str.indexOf(".9") >= 0) {
            str = getNinePatchDrawable(context, str);
        } else {
            str = getDrawable(context, str);
        }
        if (str3.indexOf(".9") >= 0) {
            str3 = getNinePatchDrawable(context, str3);
        } else {
            str3 = getDrawable(context, str3);
        }
        if (str2.indexOf(".9") >= 0) {
            context = getNinePatchDrawable(context, str2);
        } else {
            context = getDrawable(context, str2);
        }
        str2 = new StateListDrawable();
        str2.addState(new int[]{16842919}, context);
        str2.addState(new int[]{16842913}, context);
        str2.addState(new int[]{16842908}, context);
        str2.addState(new int[]{16842766}, str3);
        str2.addState(StateSet.WILD_CARD, str);
        return str2;
    }

    public static String readCountryFromAsset(Context context, String str) {
        String str2 = "";
        try {
            context = context.getAssets().open(str);
            if (context == null) {
                return str2;
            }
            str = new DataInputStream(context);
            byte[] bArr = new byte[str.available()];
            str.read(bArr);
            str = new String(bArr, "UTF-8");
            try {
                context.close();
                return str;
            } catch (IOException e) {
                context = e;
                context.printStackTrace();
                return str;
            }
        } catch (IOException e2) {
            context = e2;
            str = str2;
            context.printStackTrace();
            return str;
        }
    }
}
