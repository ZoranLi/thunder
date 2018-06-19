package android.support.v4.os;

import android.os.Build.VERSION;
import android.support.annotation.GuardedBy;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.Size;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

@RequiresApi(14)
@RestrictTo({Scope.LIBRARY_GROUP})
final class LocaleListHelper {
    private static final Locale EN_LATN = LocaleHelper.forLanguageTag("en-Latn");
    private static final Locale LOCALE_AR_XB = new Locale("ar", "XB");
    private static final Locale LOCALE_EN_XA = new Locale(SocializeProtocolConstants.PROTOCOL_KEY_EN, "XA");
    private static final int NUM_PSEUDO_LOCALES = 2;
    private static final String STRING_AR_XB = "ar-XB";
    private static final String STRING_EN_XA = "en-XA";
    @GuardedBy("sLock")
    private static LocaleListHelper sDefaultAdjustedLocaleList;
    @GuardedBy("sLock")
    private static LocaleListHelper sDefaultLocaleList;
    private static final Locale[] sEmptyList = new Locale[0];
    private static final LocaleListHelper sEmptyLocaleList = new LocaleListHelper(new Locale[0]);
    @GuardedBy("sLock")
    private static Locale sLastDefaultLocale;
    @GuardedBy("sLock")
    private static LocaleListHelper sLastExplicitlySetLocaleList;
    private static final Object sLock = new Object();
    private final Locale[] mList;
    @NonNull
    private final String mStringRepresentation;

    @RestrictTo({Scope.LIBRARY_GROUP})
    final Locale get(int i) {
        return (i < 0 || i >= this.mList.length) ? 0 : this.mList[i];
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    final boolean isEmpty() {
        return this.mList.length == 0;
    }

    @IntRange(from = 0)
    @RestrictTo({Scope.LIBRARY_GROUP})
    final int size() {
        return this.mList.length;
    }

    @IntRange(from = -1)
    @RestrictTo({Scope.LIBRARY_GROUP})
    final int indexOf(Locale locale) {
        for (int i = 0; i < this.mList.length; i++) {
            if (this.mList[i].equals(locale)) {
                return i;
            }
        }
        return -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocaleListHelper)) {
            return false;
        }
        obj = ((LocaleListHelper) obj).mList;
        if (this.mList.length != obj.length) {
            return false;
        }
        for (int i = 0; i < this.mList.length; i++) {
            if (!this.mList[i].equals(obj[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (Locale hashCode : this.mList) {
            i = hashCode.hashCode() + (31 * i);
        }
        return i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < this.mList.length; i++) {
            stringBuilder.append(this.mList[i]);
            if (i < this.mList.length - 1) {
                stringBuilder.append(',');
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @NonNull
    final String toLanguageTags() {
        return this.mStringRepresentation;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    LocaleListHelper(@NonNull Locale... localeArr) {
        if (localeArr.length == 0) {
            this.mList = sEmptyList;
            this.mStringRepresentation = "";
            return;
        }
        Locale[] localeArr2 = new Locale[localeArr.length];
        HashSet hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < localeArr.length) {
            Locale locale = localeArr[i];
            StringBuilder stringBuilder2;
            if (locale == null) {
                stringBuilder2 = new StringBuilder("list[");
                stringBuilder2.append(i);
                stringBuilder2.append("] is null");
                throw new NullPointerException(stringBuilder2.toString());
            } else if (hashSet.contains(locale)) {
                stringBuilder2 = new StringBuilder("list[");
                stringBuilder2.append(i);
                stringBuilder2.append("] is a repetition");
                throw new IllegalArgumentException(stringBuilder2.toString());
            } else {
                locale = (Locale) locale.clone();
                localeArr2[i] = locale;
                stringBuilder.append(LocaleHelper.toLanguageTag(locale));
                if (i < localeArr.length - 1) {
                    stringBuilder.append(',');
                }
                hashSet.add(locale);
                i++;
            }
        }
        this.mList = localeArr2;
        this.mStringRepresentation = stringBuilder.toString();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    LocaleListHelper(@NonNull Locale locale, LocaleListHelper localeListHelper) {
        if (locale == null) {
            throw new NullPointerException("topLocale is null");
        }
        int i;
        int i2 = 0;
        if (localeListHelper == null) {
            i = 0;
        } else {
            i = localeListHelper.mList.length;
        }
        int i3 = 0;
        while (i3 < i) {
            if (locale.equals(localeListHelper.mList[i3])) {
                break;
            }
            i3++;
        }
        i3 = -1;
        int i4 = (i3 == -1 ? 1 : 0) + i;
        Locale[] localeArr = new Locale[i4];
        localeArr[0] = (Locale) locale.clone();
        if (i3 == -1) {
            locale = null;
            while (locale < i) {
                i3 = locale + 1;
                localeArr[i3] = (Locale) localeListHelper.mList[locale].clone();
                locale = i3;
            }
        } else {
            locale = null;
            while (locale < i3) {
                int i5 = locale + 1;
                localeArr[i5] = (Locale) localeListHelper.mList[locale].clone();
                locale = i5;
            }
            for (i3++; i3 < i; i3++) {
                localeArr[i3] = (Locale) localeListHelper.mList[i3].clone();
            }
        }
        locale = new StringBuilder();
        while (i2 < i4) {
            locale.append(LocaleHelper.toLanguageTag(localeArr[i2]));
            if (i2 < i4 - 1) {
                locale.append(',');
            }
            i2++;
        }
        this.mList = localeArr;
        this.mStringRepresentation = locale.toString();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @NonNull
    static LocaleListHelper getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @NonNull
    static LocaleListHelper forLanguageTags(@Nullable String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                str = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                Locale[] localeArr = new Locale[str.length];
                for (int i = 0; i < localeArr.length; i++) {
                    localeArr[i] = LocaleHelper.forLanguageTag(str[i]);
                }
                return new LocaleListHelper(localeArr);
            }
        }
        return getEmptyLocaleList();
    }

    private static String getLikelyScript(Locale locale) {
        if (VERSION.SDK_INT < 21) {
            return "";
        }
        locale = locale.getScript();
        return !locale.isEmpty() ? locale : "";
    }

    private static boolean isPseudoLocale(String str) {
        if (!STRING_EN_XA.equals(str)) {
            if (STRING_AR_XB.equals(str) == null) {
                return null;
            }
        }
        return true;
    }

    private static boolean isPseudoLocale(Locale locale) {
        if (!LOCALE_EN_XA.equals(locale)) {
            if (LOCALE_AR_XB.equals(locale) == null) {
                return null;
            }
        }
        return true;
    }

    @IntRange(from = 0, to = 1)
    private static int matchScore(Locale locale, Locale locale2) {
        if (locale.equals(locale2)) {
            return 1;
        }
        if (locale.getLanguage().equals(locale2.getLanguage()) && !isPseudoLocale(locale)) {
            if (!isPseudoLocale(locale2)) {
                String likelyScript = getLikelyScript(locale);
                if (likelyScript.isEmpty()) {
                    locale = locale.getCountry();
                    if (!locale.isEmpty()) {
                        if (locale.equals(locale2.getCountry()) == null) {
                            return 0;
                        }
                    }
                    return 1;
                } else if (likelyScript.equals(getLikelyScript(locale2)) != null) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
        return 0;
    }

    private int findFirstMatchIndex(Locale locale) {
        for (int i = 0; i < this.mList.length; i++) {
            if (matchScore(locale, this.mList[i]) > 0) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }

    private int computeFirstMatchIndex(Collection<String> collection, boolean z) {
        if (this.mList.length == 1) {
            return 0;
        }
        if (this.mList.length == 0) {
            return -1;
        }
        boolean findFirstMatchIndex;
        if (z) {
            z = findFirstMatchIndex(EN_LATN);
            if (!z) {
                return 0;
            }
            if (z < true) {
                for (String forLanguageTag : collection) {
                    findFirstMatchIndex = findFirstMatchIndex(LocaleHelper.forLanguageTag(forLanguageTag));
                    if (!findFirstMatchIndex) {
                        return 0;
                    }
                    if (findFirstMatchIndex < z) {
                        z = findFirstMatchIndex;
                    }
                }
                if (!z) {
                    return 0;
                }
                return z;
            }
        }
        z = true;
        while (collection.hasNext()) {
            findFirstMatchIndex = findFirstMatchIndex(LocaleHelper.forLanguageTag(forLanguageTag));
            if (!findFirstMatchIndex) {
                return 0;
            }
            if (findFirstMatchIndex < z) {
                z = findFirstMatchIndex;
            }
        }
        if (!z) {
            return z;
        }
        return 0;
    }

    private Locale computeFirstMatch(Collection<String> collection, boolean z) {
        collection = computeFirstMatchIndex(collection, z);
        if (collection == true) {
            return null;
        }
        return this.mList[collection];
    }

    @Nullable
    @RestrictTo({Scope.LIBRARY_GROUP})
    final Locale getFirstMatch(String[] strArr) {
        return computeFirstMatch(Arrays.asList(strArr), false);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    final int getFirstMatchIndex(String[] strArr) {
        return computeFirstMatchIndex(Arrays.asList(strArr), false);
    }

    @Nullable
    @RestrictTo({Scope.LIBRARY_GROUP})
    final Locale getFirstMatchWithEnglishSupported(String[] strArr) {
        return computeFirstMatch(Arrays.asList(strArr), true);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    final int getFirstMatchIndexWithEnglishSupported(Collection<String> collection) {
        return computeFirstMatchIndex(collection, true);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    final int getFirstMatchIndexWithEnglishSupported(String[] strArr) {
        return getFirstMatchIndexWithEnglishSupported(Arrays.asList(strArr));
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    static boolean isPseudoLocalesOnly(@Nullable String[] strArr) {
        if (strArr == null) {
            return true;
        }
        if (strArr.length > 3) {
            return false;
        }
        for (String str : strArr) {
            if (!str.isEmpty() && !isPseudoLocale(str)) {
                return false;
            }
        }
        return true;
    }

    @Size(min = 1)
    @RestrictTo({Scope.LIBRARY_GROUP})
    @NonNull
    static LocaleListHelper getDefault() {
        Locale locale = Locale.getDefault();
        synchronized (sLock) {
            LocaleListHelper localeListHelper;
            if (!locale.equals(sLastDefaultLocale)) {
                sLastDefaultLocale = locale;
                if (sDefaultLocaleList == null || !locale.equals(sDefaultLocaleList.get(0))) {
                    LocaleListHelper localeListHelper2 = new LocaleListHelper(locale, sLastExplicitlySetLocaleList);
                    sDefaultLocaleList = localeListHelper2;
                    sDefaultAdjustedLocaleList = localeListHelper2;
                } else {
                    localeListHelper = sDefaultLocaleList;
                    return localeListHelper;
                }
            }
            localeListHelper = sDefaultLocaleList;
            return localeListHelper;
        }
    }

    @Size(min = 1)
    @NonNull
    static LocaleListHelper getAdjustedDefault() {
        LocaleListHelper localeListHelper;
        getDefault();
        synchronized (sLock) {
            localeListHelper = sDefaultAdjustedLocaleList;
        }
        return localeListHelper;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    static void setDefault(@Size(min = 1) @NonNull LocaleListHelper localeListHelper) {
        setDefault(localeListHelper, 0);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    static void setDefault(@Size(min = 1) @NonNull LocaleListHelper localeListHelper, int i) {
        if (localeListHelper == null) {
            throw new NullPointerException("locales is null");
        } else if (localeListHelper.isEmpty()) {
            throw new IllegalArgumentException("locales is empty");
        } else {
            synchronized (sLock) {
                Locale locale = localeListHelper.get(i);
                sLastDefaultLocale = locale;
                Locale.setDefault(locale);
                sLastExplicitlySetLocaleList = localeListHelper;
                sDefaultLocaleList = localeListHelper;
                if (i == 0) {
                    sDefaultAdjustedLocaleList = sDefaultLocaleList;
                } else {
                    sDefaultAdjustedLocaleList = new LocaleListHelper(sLastDefaultLocale, sDefaultLocaleList);
                }
            }
        }
    }
}
