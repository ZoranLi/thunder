package android.support.v4.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.compat.R;
import android.support.v4.provider.FontRequest;
import android.util.Base64;
import android.util.Xml;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({Scope.LIBRARY_GROUP})
public class FontResourcesParserCompat {
    private static final int DEFAULT_TIMEOUT_MILLIS = 500;
    public static final int FETCH_STRATEGY_ASYNC = 1;
    public static final int FETCH_STRATEGY_BLOCKING = 0;
    public static final int INFINITE_TIMEOUT_VALUE = -1;
    private static final int ITALIC = 1;
    private static final int NORMAL_WEIGHT = 400;

    public interface FamilyResourceEntry {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FetchStrategy {
    }

    public static final class FontFileResourceEntry {
        @NonNull
        private final String mFileName;
        private boolean mItalic;
        private int mResourceId;
        private int mWeight;

        public FontFileResourceEntry(@NonNull String str, int i, boolean z, int i2) {
            this.mFileName = str;
            this.mWeight = i;
            this.mItalic = z;
            this.mResourceId = i2;
        }

        @NonNull
        public final String getFileName() {
            return this.mFileName;
        }

        public final int getWeight() {
            return this.mWeight;
        }

        public final boolean isItalic() {
            return this.mItalic;
        }

        public final int getResourceId() {
            return this.mResourceId;
        }
    }

    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {
        @NonNull
        private final FontFileResourceEntry[] mEntries;

        public FontFamilyFilesResourceEntry(@NonNull FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.mEntries = fontFileResourceEntryArr;
        }

        @NonNull
        public final FontFileResourceEntry[] getEntries() {
            return this.mEntries;
        }
    }

    public static final class ProviderResourceEntry implements FamilyResourceEntry {
        @NonNull
        private final FontRequest mRequest;
        private final int mStrategy;
        private final int mTimeoutMs;

        public ProviderResourceEntry(@NonNull FontRequest fontRequest, int i, int i2) {
            this.mRequest = fontRequest;
            this.mStrategy = i;
            this.mTimeoutMs = i2;
        }

        @NonNull
        public final FontRequest getRequest() {
            return this.mRequest;
        }

        public final int getFetchStrategy() {
            return this.mStrategy;
        }

        public final int getTimeout() {
            return this.mTimeoutMs;
        }
    }

    @Nullable
    public static FamilyResourceEntry parse(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return readFamilies(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    @Nullable
    private static FamilyResourceEntry readFamilies(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return readFamily(xmlPullParser, resources);
        }
        skip(xmlPullParser);
        return null;
    }

    @Nullable
    private static FamilyResourceEntry readFamily(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamily);
        String string = obtainAttributes.getString(R.styleable.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            List arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(readFont(xmlPullParser, resources));
                    } else {
                        skip(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty() != null) {
                return null;
            }
            return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) arrayList.toArray(new FontFileResourceEntry[arrayList.size()]));
        }
        while (xmlPullParser.next() != 3) {
            skip(xmlPullParser);
        }
        return new ProviderResourceEntry(new FontRequest(string, string2, string3, readCerts(resources, resourceId)), integer, integer2);
    }

    public static List<List<byte[]>> readCerts(Resources resources, @ArrayRes int i) {
        List<List<byte[]>> list = null;
        if (i != 0) {
            TypedArray obtainTypedArray = resources.obtainTypedArray(i);
            if (obtainTypedArray.length() > 0) {
                list = new ArrayList();
                if ((obtainTypedArray.getResourceId(0, 0) != 0 ? 1 : 0) != 0) {
                    for (i = 0; i < obtainTypedArray.length(); i++) {
                        list.add(toByteArrayList(resources.getStringArray(obtainTypedArray.getResourceId(i, 0))));
                    }
                } else {
                    list.add(toByteArrayList(resources.getStringArray(i)));
                }
            }
            obtainTypedArray.recycle();
        }
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }

    private static List<byte[]> toByteArrayList(String[] strArr) {
        List<byte[]> arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }

    private static FontFileResourceEntry readFont(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        resources = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamilyFont);
        int i = resources.getInt(R.styleable.FontFamilyFont_fontWeight, 400);
        boolean z = true;
        if (1 != resources.getInt(R.styleable.FontFamilyFont_fontStyle, 0)) {
            z = false;
        }
        int resourceId = resources.getResourceId(R.styleable.FontFamilyFont_font, 0);
        String string = resources.getString(R.styleable.FontFamilyFont_font);
        resources.recycle();
        while (xmlPullParser.next() != 3) {
            skip(xmlPullParser);
        }
        return new FontFileResourceEntry(string, i, z, resourceId);
    }

    private static void skip(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
                default:
                    break;
            }
        }
    }
}
