package android.support.v4.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

@RequiresApi(26)
@RestrictTo({Scope.LIBRARY_GROUP})
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    private static final String ABORT_CREATION_METHOD = "abortCreation";
    private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
    private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String FREEZE_METHOD = "freeze";
    private static final int RESOLVE_BY_FONT_TABLE = -1;
    private static final String TAG = "TypefaceCompatApi26Impl";
    private static final Method sAbortCreation;
    private static final Method sAddFontFromAssetManager;
    private static final Method sAddFontFromBuffer;
    private static final Method sCreateFromFamiliesWithDefault;
    private static final Class sFontFamily;
    private static final Constructor sFontFamilyCtor;
    private static final Method sFreeze;

    static {
        Class cls;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method declaredMethod;
        Constructor constructor = null;
        try {
            cls = Class.forName(FONT_FAMILY_CLASS);
            Constructor constructor2 = cls.getConstructor(new Class[0]);
            method = cls.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class});
            method2 = cls.getMethod(ADD_FONT_FROM_BUFFER_METHOD, new Class[]{ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE});
            method3 = cls.getMethod(FREEZE_METHOD, new Class[0]);
            method4 = cls.getMethod(ABORT_CREATION_METHOD, new Class[0]);
            Object newInstance = Array.newInstance(cls, 1);
            declaredMethod = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{newInstance.getClass(), Integer.TYPE, Integer.TYPE});
            declaredMethod.setAccessible(true);
            constructor = constructor2;
        } catch (ClassNotFoundException e) {
            new StringBuilder("Unable to collect necessary methods for class ").append(e.getClass().getName());
            cls = null;
            declaredMethod = cls;
            method = declaredMethod;
            method2 = method;
            method3 = method2;
            method4 = method3;
        }
        sFontFamilyCtor = constructor;
        sFontFamily = cls;
        sAddFontFromAssetManager = method;
        sAddFontFromBuffer = method2;
        sFreeze = method3;
        sAbortCreation = method4;
        sCreateFromFamiliesWithDefault = declaredMethod;
    }

    private static boolean isFontFamilyPrivateAPIAvailable() {
        return sAddFontFromAssetManager != null;
    }

    private static Object newFamily() {
        try {
            return sFontFamilyCtor.newInstance(new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean addFontFromAssetManager(Context context, Object obj, String str, int i, int i2, int i3) {
        try {
            return ((Boolean) sAddFontFromAssetManager.invoke(obj, new Object[]{context.getAssets(), str, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), null})).booleanValue();
        } catch (Context context2) {
            throw new RuntimeException(context2);
        }
    }

    private static boolean addFontFromBuffer(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) sAddFontFromBuffer.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), 0, Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
        } catch (Object obj2) {
            throw new RuntimeException(obj2);
        }
    }

    private static Typeface createFromFamiliesWithDefault(Object obj) {
        try {
            Array.set(Array.newInstance(sFontFamily, 1), 0, obj);
            return (Typeface) sCreateFromFamiliesWithDefault.invoke(null, new Object[]{r0, Integer.valueOf(-1), Integer.valueOf(-1)});
        } catch (Object obj2) {
            throw new RuntimeException(obj2);
        }
    }

    private static boolean freeze(Object obj) {
        try {
            return ((Boolean) sFreeze.invoke(obj, new Object[0])).booleanValue();
        } catch (Object obj2) {
            throw new RuntimeException(obj2);
        }
    }

    private static boolean abortCreation(Object obj) {
        try {
            return ((Boolean) sAbortCreation.invoke(obj, new Object[0])).booleanValue();
        } catch (Object obj2) {
            throw new RuntimeException(obj2);
        }
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromFontFamilyFilesResourceEntry(context, fontFamilyFilesResourceEntry, resources, i);
        }
        resources = newFamily();
        fontFamilyFilesResourceEntry = fontFamilyFilesResourceEntry.getEntries();
        i = fontFamilyFilesResourceEntry.length;
        int i2 = 0;
        while (i2 < i) {
            FontFileResourceEntry fontFileResourceEntry = fontFamilyFilesResourceEntry[i2];
            if (addFontFromAssetManager(context, resources, fontFileResourceEntry.getFileName(), 0, fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic())) {
                i2++;
            } else {
                abortCreation(resources);
                return null;
            }
        }
        if (freeze(resources) == null) {
            return null;
        }
        return createFromFamiliesWithDefault(resources);
    }

    public android.graphics.Typeface createFromFontInfo(android.content.Context r8, @android.support.annotation.Nullable android.os.CancellationSignal r9, @android.support.annotation.NonNull android.support.v4.provider.FontsContractCompat.FontInfo[] r10, int r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = 0;
        r1 = r10.length;
        if (r1 > 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r1 = isFontFamilyPrivateAPIAvailable();
        if (r1 != 0) goto L_0x005b;
    L_0x000b:
        r10 = r7.findBestInfo(r10, r11);
        r8 = r8.getContentResolver();
        r11 = r10.getUri();	 Catch:{ IOException -> 0x005a }
        r1 = "r";	 Catch:{ IOException -> 0x005a }
        r8 = r8.openFileDescriptor(r11, r1, r9);	 Catch:{ IOException -> 0x005a }
        r9 = new android.graphics.Typeface$Builder;	 Catch:{ Throwable -> 0x0043, all -> 0x0040 }
        r11 = r8.getFileDescriptor();	 Catch:{ Throwable -> 0x0043, all -> 0x0040 }
        r9.<init>(r11);	 Catch:{ Throwable -> 0x0043, all -> 0x0040 }
        r11 = r10.getWeight();	 Catch:{ Throwable -> 0x0043, all -> 0x0040 }
        r9 = r9.setWeight(r11);	 Catch:{ Throwable -> 0x0043, all -> 0x0040 }
        r10 = r10.isItalic();	 Catch:{ Throwable -> 0x0043, all -> 0x0040 }
        r9 = r9.setItalic(r10);	 Catch:{ Throwable -> 0x0043, all -> 0x0040 }
        r9 = r9.build();	 Catch:{ Throwable -> 0x0043, all -> 0x0040 }
        if (r8 == 0) goto L_0x003f;
    L_0x003c:
        r8.close();	 Catch:{ IOException -> 0x005a }
    L_0x003f:
        return r9;
    L_0x0040:
        r9 = move-exception;
        r10 = r0;
        goto L_0x0049;
    L_0x0043:
        r9 = move-exception;
        throw r9;	 Catch:{ all -> 0x0045 }
    L_0x0045:
        r10 = move-exception;
        r6 = r10;
        r10 = r9;
        r9 = r6;
    L_0x0049:
        if (r8 == 0) goto L_0x0059;
    L_0x004b:
        if (r10 == 0) goto L_0x0056;
    L_0x004d:
        r8.close();	 Catch:{ Throwable -> 0x0051 }
        goto L_0x0059;
    L_0x0051:
        r8 = move-exception;
        r10.addSuppressed(r8);	 Catch:{ IOException -> 0x005a }
        goto L_0x0059;	 Catch:{ IOException -> 0x005a }
    L_0x0056:
        r8.close();	 Catch:{ IOException -> 0x005a }
    L_0x0059:
        throw r9;	 Catch:{ IOException -> 0x005a }
    L_0x005a:
        return r0;
    L_0x005b:
        r8 = android.support.v4.provider.FontsContractCompat.prepareFontData(r8, r10, r9);
        r9 = newFamily();
        r11 = 0;
        r1 = r10.length;
        r2 = r11;
    L_0x0066:
        if (r11 >= r1) goto L_0x0090;
    L_0x0068:
        r3 = r10[r11];
        r4 = r3.getUri();
        r4 = r8.get(r4);
        r4 = (java.nio.ByteBuffer) r4;
        if (r4 == 0) goto L_0x008d;
    L_0x0076:
        r2 = r3.getTtcIndex();
        r5 = r3.getWeight();
        r3 = r3.isItalic();
        r2 = addFontFromBuffer(r9, r4, r2, r5, r3);
        if (r2 != 0) goto L_0x008c;
    L_0x0088:
        abortCreation(r9);
        return r0;
    L_0x008c:
        r2 = 1;
    L_0x008d:
        r11 = r11 + 1;
        goto L_0x0066;
    L_0x0090:
        if (r2 != 0) goto L_0x0096;
    L_0x0092:
        abortCreation(r9);
        return r0;
    L_0x0096:
        r8 = freeze(r9);
        if (r8 != 0) goto L_0x009d;
    L_0x009c:
        return r0;
    L_0x009d:
        r8 = createFromFamiliesWithDefault(r9);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi26Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, android.support.v4.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    @Nullable
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromResourcesFontFile(context, resources, i, str, i2);
        }
        resources = newFamily();
        if (addFontFromAssetManager(context, resources, str, 0, -1, -1) == null) {
            abortCreation(resources);
            return null;
        } else if (freeze(resources) == null) {
            return null;
        } else {
            return createFromFamiliesWithDefault(resources);
        }
    }
}
