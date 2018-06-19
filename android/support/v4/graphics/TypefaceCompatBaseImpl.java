package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import android.support.v4.provider.FontsContractCompat.FontInfo;

@RequiresApi(14)
@RestrictTo({Scope.LIBRARY_GROUP})
class TypefaceCompatBaseImpl implements TypefaceCompatImpl {
    private static final String CACHE_FILE_PREFIX = "cached_font_";
    private static final String TAG = "TypefaceCompatBaseImpl";

    private interface StyleExtractor<T> {
        int getWeight(T t);

        boolean isItalic(T t);
    }

    TypefaceCompatBaseImpl() {
    }

    private static <T> T findBestFont(T[] tArr, int i, StyleExtractor<T> styleExtractor) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        int i3 = Integer.MAX_VALUE;
        T t = null;
        for (T t2 : tArr) {
            int abs = (Math.abs(styleExtractor.getWeight(t2) - i2) * 2) + (styleExtractor.isItalic(t2) == z ? 0 : 1);
            if (t == null || r6 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    protected FontInfo findBestInfo(FontInfo[] fontInfoArr, int i) {
        return (FontInfo) findBestFont(fontInfoArr, i, new StyleExtractor<FontInfo>() {
            public int getWeight(FontInfo fontInfo) {
                return fontInfo.getWeight();
            }

            public boolean isItalic(FontInfo fontInfo) {
                return fontInfo.isItalic();
            }
        });
    }

    protected android.graphics.Typeface createFromInputStream(android.content.Context r2, java.io.InputStream r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r2 = android.support.v4.graphics.TypefaceCompatUtil.getTempFile(r2);
        r0 = 0;
        if (r2 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r3 = android.support.v4.graphics.TypefaceCompatUtil.copyToFile(r2, r3);	 Catch:{ RuntimeException -> 0x0023, all -> 0x001e }
        if (r3 != 0) goto L_0x0012;
    L_0x000e:
        r2.delete();
        return r0;
    L_0x0012:
        r3 = r2.getPath();	 Catch:{ RuntimeException -> 0x0023, all -> 0x001e }
        r3 = android.graphics.Typeface.createFromFile(r3);	 Catch:{ RuntimeException -> 0x0023, all -> 0x001e }
        r2.delete();
        return r3;
    L_0x001e:
        r3 = move-exception;
        r2.delete();
        throw r3;
    L_0x0023:
        r2.delete();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatBaseImpl.createFromInputStream(android.content.Context, java.io.InputStream):android.graphics.Typeface");
    }

    public android.graphics.Typeface createFromFontInfo(android.content.Context r2, @android.support.annotation.Nullable android.os.CancellationSignal r3, @android.support.annotation.NonNull android.support.v4.provider.FontsContractCompat.FontInfo[] r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r3 = 0;
        r0 = r4.length;
        if (r0 > 0) goto L_0x0005;
    L_0x0004:
        return r3;
    L_0x0005:
        r4 = r1.findBestInfo(r4, r5);
        r5 = r2.getContentResolver();	 Catch:{ IOException -> 0x0025, all -> 0x0020 }
        r4 = r4.getUri();	 Catch:{ IOException -> 0x0025, all -> 0x0020 }
        r4 = r5.openInputStream(r4);	 Catch:{ IOException -> 0x0025, all -> 0x0020 }
        r2 = r1.createFromInputStream(r2, r4);	 Catch:{ IOException -> 0x0026, all -> 0x001d }
        android.support.v4.graphics.TypefaceCompatUtil.closeQuietly(r4);
        return r2;
    L_0x001d:
        r2 = move-exception;
        r3 = r4;
        goto L_0x0021;
    L_0x0020:
        r2 = move-exception;
    L_0x0021:
        android.support.v4.graphics.TypefaceCompatUtil.closeQuietly(r3);
        throw r2;
    L_0x0025:
        r4 = r3;
    L_0x0026:
        android.support.v4.graphics.TypefaceCompatUtil.closeQuietly(r4);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatBaseImpl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, android.support.v4.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    private FontFileResourceEntry findBestEntry(FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i) {
        return (FontFileResourceEntry) findBestFont(fontFamilyFilesResourceEntry.getEntries(), i, new StyleExtractor<FontFileResourceEntry>() {
            public int getWeight(FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.getWeight();
            }

            public boolean isItalic(FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.isItalic();
            }
        });
    }

    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        fontFamilyFilesResourceEntry = findBestEntry(fontFamilyFilesResourceEntry, i);
        if (fontFamilyFilesResourceEntry == null) {
            return null;
        }
        return TypefaceCompat.createFromResourcesFontFile(context, resources, fontFamilyFilesResourceEntry.getResourceId(), fontFamilyFilesResourceEntry.getFileName(), i);
    }

    @android.support.annotation.Nullable
    public android.graphics.Typeface createFromResourcesFontFile(android.content.Context r1, android.content.res.Resources r2, int r3, java.lang.String r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r1 = android.support.v4.graphics.TypefaceCompatUtil.getTempFile(r1);
        r4 = 0;
        if (r1 != 0) goto L_0x0008;
    L_0x0007:
        return r4;
    L_0x0008:
        r2 = android.support.v4.graphics.TypefaceCompatUtil.copyToFile(r1, r2, r3);	 Catch:{ RuntimeException -> 0x0023, all -> 0x001e }
        if (r2 != 0) goto L_0x0012;
    L_0x000e:
        r1.delete();
        return r4;
    L_0x0012:
        r2 = r1.getPath();	 Catch:{ RuntimeException -> 0x0023, all -> 0x001e }
        r2 = android.graphics.Typeface.createFromFile(r2);	 Catch:{ RuntimeException -> 0x0023, all -> 0x001e }
        r1.delete();
        return r2;
    L_0x001e:
        r2 = move-exception;
        r1.delete();
        throw r2;
    L_0x0023:
        r1.delete();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatBaseImpl.createFromResourcesFontFile(android.content.Context, android.content.res.Resources, int, java.lang.String, int):android.graphics.Typeface");
    }
}
