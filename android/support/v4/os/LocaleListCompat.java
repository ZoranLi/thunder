package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.LocaleList;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.Size;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;

public final class LocaleListCompat {
    static final LocaleListInterface IMPL;
    private static final LocaleListCompat sEmptyLocaleList = new LocaleListCompat();

    @RequiresApi(24)
    static class LocaleListCompatApi24Impl implements LocaleListInterface {
        private LocaleList mLocaleList = new LocaleList(new Locale[0]);

        LocaleListCompatApi24Impl() {
        }

        public void setLocaleList(@NonNull Locale... localeArr) {
            this.mLocaleList = new LocaleList(localeArr);
        }

        public Object getLocaleList() {
            return this.mLocaleList;
        }

        public Locale get(int i) {
            return this.mLocaleList.get(i);
        }

        public boolean isEmpty() {
            return this.mLocaleList.isEmpty();
        }

        @IntRange(from = 0)
        public int size() {
            return this.mLocaleList.size();
        }

        @IntRange(from = -1)
        public int indexOf(Locale locale) {
            return this.mLocaleList.indexOf(locale);
        }

        public boolean equals(Object obj) {
            return this.mLocaleList.equals(((LocaleListCompat) obj).unwrap());
        }

        public int hashCode() {
            return this.mLocaleList.hashCode();
        }

        public String toString() {
            return this.mLocaleList.toString();
        }

        public String toLanguageTags() {
            return this.mLocaleList.toLanguageTags();
        }

        @Nullable
        public Locale getFirstMatch(String[] strArr) {
            return this.mLocaleList != null ? this.mLocaleList.getFirstMatch(strArr) : null;
        }
    }

    static class LocaleListCompatBaseImpl implements LocaleListInterface {
        private LocaleListHelper mLocaleList = new LocaleListHelper(new Locale[0]);

        LocaleListCompatBaseImpl() {
        }

        public void setLocaleList(@NonNull Locale... localeArr) {
            this.mLocaleList = new LocaleListHelper(localeArr);
        }

        public Object getLocaleList() {
            return this.mLocaleList;
        }

        public Locale get(int i) {
            return this.mLocaleList.get(i);
        }

        public boolean isEmpty() {
            return this.mLocaleList.isEmpty();
        }

        @IntRange(from = 0)
        public int size() {
            return this.mLocaleList.size();
        }

        @IntRange(from = -1)
        public int indexOf(Locale locale) {
            return this.mLocaleList.indexOf(locale);
        }

        public boolean equals(Object obj) {
            return this.mLocaleList.equals(((LocaleListCompat) obj).unwrap());
        }

        public int hashCode() {
            return this.mLocaleList.hashCode();
        }

        public String toString() {
            return this.mLocaleList.toString();
        }

        public String toLanguageTags() {
            return this.mLocaleList.toLanguageTags();
        }

        @Nullable
        public Locale getFirstMatch(String[] strArr) {
            return this.mLocaleList != null ? this.mLocaleList.getFirstMatch(strArr) : null;
        }
    }

    static {
        if (VERSION.SDK_INT >= 24) {
            IMPL = new LocaleListCompatApi24Impl();
        } else {
            IMPL = new LocaleListCompatBaseImpl();
        }
    }

    private LocaleListCompat() {
    }

    @RequiresApi(24)
    public static LocaleListCompat wrap(Object obj) {
        LocaleListCompat localeListCompat = new LocaleListCompat();
        if (obj instanceof LocaleList) {
            localeListCompat.setLocaleList((LocaleList) obj);
        }
        return localeListCompat;
    }

    @Nullable
    public final Object unwrap() {
        return IMPL.getLocaleList();
    }

    public static LocaleListCompat create(@NonNull Locale... localeArr) {
        LocaleListCompat localeListCompat = new LocaleListCompat();
        localeListCompat.setLocaleListArray(localeArr);
        return localeListCompat;
    }

    public final Locale get(int i) {
        return IMPL.get(i);
    }

    public final boolean isEmpty() {
        return IMPL.isEmpty();
    }

    @IntRange(from = 0)
    public final int size() {
        return IMPL.size();
    }

    @IntRange(from = -1)
    public final int indexOf(Locale locale) {
        return IMPL.indexOf(locale);
    }

    @NonNull
    public final String toLanguageTags() {
        return IMPL.toLanguageTags();
    }

    public final Locale getFirstMatch(String[] strArr) {
        return IMPL.getFirstMatch(strArr);
    }

    @NonNull
    public static LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    @NonNull
    public static LocaleListCompat forLanguageTags(@Nullable String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                str = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                Locale[] localeArr = new Locale[str.length];
                for (int i = 0; i < localeArr.length; i++) {
                    Locale forLanguageTag;
                    if (VERSION.SDK_INT >= 21) {
                        forLanguageTag = Locale.forLanguageTag(str[i]);
                    } else {
                        forLanguageTag = LocaleHelper.forLanguageTag(str[i]);
                    }
                    localeArr[i] = forLanguageTag;
                }
                str = new LocaleListCompat();
                str.setLocaleListArray(localeArr);
                return str;
            }
        }
        return getEmptyLocaleList();
    }

    @Size(min = 1)
    @NonNull
    public static LocaleListCompat getAdjustedDefault() {
        if (VERSION.SDK_INT >= 24) {
            return wrap(LocaleList.getAdjustedDefault());
        }
        return create(Locale.getDefault());
    }

    @Size(min = 1)
    @NonNull
    public static LocaleListCompat getDefault() {
        if (VERSION.SDK_INT >= 24) {
            return wrap(LocaleList.getDefault());
        }
        return create(Locale.getDefault());
    }

    public final boolean equals(Object obj) {
        return IMPL.equals(obj);
    }

    public final int hashCode() {
        return IMPL.hashCode();
    }

    public final String toString() {
        return IMPL.toString();
    }

    @RequiresApi(24)
    private void setLocaleList(LocaleList localeList) {
        int size = localeList.size();
        if (size > 0) {
            Locale[] localeArr = new Locale[size];
            for (int i = 0; i < size; i++) {
                localeArr[i] = localeList.get(i);
            }
            IMPL.setLocaleList(localeArr);
        }
    }

    private void setLocaleListArray(Locale... localeArr) {
        IMPL.setLocaleList(localeArr);
    }
}
