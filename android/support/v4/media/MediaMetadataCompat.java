package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

public final class MediaMetadataCompat implements Parcelable {
    public static final Creator<MediaMetadataCompat> CREATOR = new Creator<MediaMetadataCompat>() {
        public final MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        public final MediaMetadataCompat[] newArray(int i) {
            return new MediaMetadataCompat[i];
        }
    };
    static final ArrayMap<String, Integer> METADATA_KEYS_TYPE;
    public static final String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DOWNLOAD_STATUS = "android.media.metadata.DOWNLOAD_STATUS";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    static final int METADATA_TYPE_BITMAP = 2;
    static final int METADATA_TYPE_LONG = 0;
    static final int METADATA_TYPE_RATING = 3;
    static final int METADATA_TYPE_TEXT = 1;
    private static final String[] PREFERRED_BITMAP_ORDER = new String[]{METADATA_KEY_DISPLAY_ICON, METADATA_KEY_ART, METADATA_KEY_ALBUM_ART};
    private static final String[] PREFERRED_DESCRIPTION_ORDER = new String[]{METADATA_KEY_TITLE, METADATA_KEY_ARTIST, METADATA_KEY_ALBUM, METADATA_KEY_ALBUM_ARTIST, METADATA_KEY_WRITER, METADATA_KEY_AUTHOR, METADATA_KEY_COMPOSER};
    private static final String[] PREFERRED_URI_ORDER = new String[]{METADATA_KEY_DISPLAY_ICON_URI, METADATA_KEY_ART_URI, METADATA_KEY_ALBUM_ART_URI};
    private static final String TAG = "MediaMetadata";
    final Bundle mBundle;
    private MediaDescriptionCompat mDescription;
    private Object mMetadataObj;

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface BitmapKey {
    }

    public static final class Builder {
        private final Bundle mBundle;

        public Builder() {
            this.mBundle = new Bundle();
        }

        public Builder(MediaMetadataCompat mediaMetadataCompat) {
            this.mBundle = new Bundle(mediaMetadataCompat.mBundle);
        }

        @RestrictTo({Scope.LIBRARY_GROUP})
        public Builder(MediaMetadataCompat mediaMetadataCompat, int i) {
            this(mediaMetadataCompat);
            for (String str : this.mBundle.keySet()) {
                Object obj = this.mBundle.get(str);
                if (obj instanceof Bitmap) {
                    Bitmap bitmap = (Bitmap) obj;
                    if (bitmap.getHeight() > i || bitmap.getWidth() > i) {
                        putBitmap(str, scaleBitmap(bitmap, i));
                    }
                }
            }
        }

        public final Builder putText(String str, CharSequence charSequence) {
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str)).intValue() == 1) {
                this.mBundle.putCharSequence(str, charSequence);
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder("The ");
            stringBuilder.append(str);
            stringBuilder.append(" key cannot be used to put a CharSequence");
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public final Builder putString(String str, String str2) {
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str)).intValue() == 1) {
                this.mBundle.putCharSequence(str, str2);
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder("The ");
            stringBuilder.append(str);
            stringBuilder.append(" key cannot be used to put a String");
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public final Builder putLong(String str, long j) {
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str)).intValue() == 0) {
                this.mBundle.putLong(str, j);
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder("The ");
            stringBuilder.append(str);
            stringBuilder.append(" key cannot be used to put a long");
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public final Builder putRating(String str, RatingCompat ratingCompat) {
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str)).intValue() == 3) {
                if (VERSION.SDK_INT >= 19) {
                    this.mBundle.putParcelable(str, (Parcelable) ratingCompat.getRating());
                } else {
                    this.mBundle.putParcelable(str, ratingCompat);
                }
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder("The ");
            stringBuilder.append(str);
            stringBuilder.append(" key cannot be used to put a Rating");
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public final Builder putBitmap(String str, Bitmap bitmap) {
            if (!MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) || ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str)).intValue() == 2) {
                this.mBundle.putParcelable(str, bitmap);
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder("The ");
            stringBuilder.append(str);
            stringBuilder.append(" key cannot be used to put a Bitmap");
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public final MediaMetadataCompat build() {
            return new MediaMetadataCompat(this.mBundle);
        }

        private Bitmap scaleBitmap(Bitmap bitmap, int i) {
            i = (float) i;
            i = Math.min(i / ((float) bitmap.getWidth()), i / ((float) bitmap.getHeight()));
            return Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) * i), (int) (((float) bitmap.getHeight()) * i), true);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LongKey {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RatingKey {
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TextKey {
    }

    public final int describeContents() {
        return 0;
    }

    static {
        ArrayMap arrayMap = new ArrayMap();
        METADATA_KEYS_TYPE = arrayMap;
        arrayMap.put(METADATA_KEY_TITLE, Integer.valueOf(1));
        METADATA_KEYS_TYPE.put(METADATA_KEY_ARTIST, Integer.valueOf(1));
        METADATA_KEYS_TYPE.put(METADATA_KEY_DURATION, Integer.valueOf(0));
        METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM, Integer.valueOf(1));
        METADATA_KEYS_TYPE.put(METADATA_KEY_AUTHOR, Integer.valueOf(1));
        METADATA_KEYS_TYPE.put(METADATA_KEY_WRITER, Integer.valueOf(1));
        METADATA_KEYS_TYPE.put(METADATA_KEY_COMPOSER, Integer.valueOf(1));
        METADATA_KEYS_TYPE.put(METADATA_KEY_COMPILATION, Integer.valueOf(1));
        METADATA_KEYS_TYPE.put(METADATA_KEY_DATE, Integer.valueOf(1));
        METADATA_KEYS_TYPE.put(METADATA_KEY_YEAR, Integer.valueOf(0));
        METADATA_KEYS_TYPE.put(METADATA_KEY_GENRE, Integer.valueOf(1));
        METADATA_KEYS_TYPE.put(METADATA_KEY_TRACK_NUMBER, Integer.valueOf(0));
        METADATA_KEYS_TYPE.put(METADATA_KEY_NUM_TRACKS, Integer.valueOf(0));
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISC_NUMBER, Integer.valueOf(0));
        METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM_ARTIST, Integer.valueOf(1));
        METADATA_KEYS_TYPE.put(METADATA_KEY_ART, Integer.valueOf(2));
        METADATA_KEYS_TYPE.put(METADATA_KEY_ART_URI, Integer.valueOf(1));
        METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM_ART, Integer.valueOf(2));
        METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM_ART_URI, Integer.valueOf(1));
        METADATA_KEYS_TYPE.put(METADATA_KEY_USER_RATING, Integer.valueOf(3));
        METADATA_KEYS_TYPE.put(METADATA_KEY_RATING, Integer.valueOf(3));
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_TITLE, Integer.valueOf(1));
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_SUBTITLE, Integer.valueOf(1));
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_DESCRIPTION, Integer.valueOf(1));
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_ICON, Integer.valueOf(2));
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_ICON_URI, Integer.valueOf(1));
        METADATA_KEYS_TYPE.put(METADATA_KEY_MEDIA_ID, Integer.valueOf(1));
        METADATA_KEYS_TYPE.put(METADATA_KEY_BT_FOLDER_TYPE, Integer.valueOf(0));
        METADATA_KEYS_TYPE.put(METADATA_KEY_MEDIA_URI, Integer.valueOf(1));
        METADATA_KEYS_TYPE.put(METADATA_KEY_ADVERTISEMENT, Integer.valueOf(0));
        METADATA_KEYS_TYPE.put(METADATA_KEY_DOWNLOAD_STATUS, Integer.valueOf(0));
    }

    MediaMetadataCompat(Bundle bundle) {
        this.mBundle = new Bundle(bundle);
    }

    MediaMetadataCompat(Parcel parcel) {
        this.mBundle = parcel.readBundle();
    }

    public final boolean containsKey(String str) {
        return this.mBundle.containsKey(str);
    }

    public final CharSequence getText(String str) {
        return this.mBundle.getCharSequence(str);
    }

    public final String getString(String str) {
        str = this.mBundle.getCharSequence(str);
        return str != null ? str.toString() : null;
    }

    public final long getLong(String str) {
        return this.mBundle.getLong(str, 0);
    }

    public final android.support.v4.media.RatingCompat getRating(java.lang.String r3) {
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
        r2 = this;
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x001a }
        r1 = 19;	 Catch:{ Exception -> 0x001a }
        if (r0 < r1) goto L_0x0011;	 Catch:{ Exception -> 0x001a }
    L_0x0006:
        r0 = r2.mBundle;	 Catch:{ Exception -> 0x001a }
        r3 = r0.getParcelable(r3);	 Catch:{ Exception -> 0x001a }
        r3 = android.support.v4.media.RatingCompat.fromRating(r3);	 Catch:{ Exception -> 0x001a }
        goto L_0x001b;	 Catch:{ Exception -> 0x001a }
    L_0x0011:
        r0 = r2.mBundle;	 Catch:{ Exception -> 0x001a }
        r3 = r0.getParcelable(r3);	 Catch:{ Exception -> 0x001a }
        r3 = (android.support.v4.media.RatingCompat) r3;	 Catch:{ Exception -> 0x001a }
        goto L_0x001b;
    L_0x001a:
        r3 = 0;
    L_0x001b:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaMetadataCompat.getRating(java.lang.String):android.support.v4.media.RatingCompat");
    }

    public final android.graphics.Bitmap getBitmap(java.lang.String r2) {
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
        r1 = this;
        r0 = r1.mBundle;	 Catch:{ Exception -> 0x0009 }
        r2 = r0.getParcelable(r2);	 Catch:{ Exception -> 0x0009 }
        r2 = (android.graphics.Bitmap) r2;	 Catch:{ Exception -> 0x0009 }
        goto L_0x000a;
    L_0x0009:
        r2 = 0;
    L_0x000a:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaMetadataCompat.getBitmap(java.lang.String):android.graphics.Bitmap");
    }

    public final MediaDescriptionCompat getDescription() {
        if (this.mDescription != null) {
            return this.mDescription;
        }
        Uri uri;
        Bitmap bitmap;
        Object string;
        Uri parse;
        android.support.v4.media.MediaDescriptionCompat.Builder builder;
        Bundle bundle;
        String string2 = getString(METADATA_KEY_MEDIA_ID);
        CharSequence[] charSequenceArr = new CharSequence[3];
        CharSequence text = getText(METADATA_KEY_DISPLAY_TITLE);
        if (TextUtils.isEmpty(text)) {
            int i = 0;
            int i2 = i;
            while (i < 3 && i2 < PREFERRED_DESCRIPTION_ORDER.length) {
                int i3 = i2 + 1;
                CharSequence text2 = getText(PREFERRED_DESCRIPTION_ORDER[i2]);
                if (!TextUtils.isEmpty(text2)) {
                    int i4 = i + 1;
                    charSequenceArr[i] = text2;
                    i = i4;
                }
                i2 = i3;
            }
        } else {
            charSequenceArr[0] = text;
            charSequenceArr[1] = getText(METADATA_KEY_DISPLAY_SUBTITLE);
            charSequenceArr[2] = getText(METADATA_KEY_DISPLAY_DESCRIPTION);
        }
        int i5 = 0;
        while (true) {
            uri = null;
            if (i5 >= PREFERRED_BITMAP_ORDER.length) {
                break;
            }
            bitmap = getBitmap(PREFERRED_BITMAP_ORDER[i5]);
            if (bitmap != null) {
                break;
            }
            i5++;
            for (String string3 : PREFERRED_URI_ORDER) {
                string = getString(string3);
                if (!TextUtils.isEmpty(string)) {
                    parse = Uri.parse(string);
                    break;
                }
            }
            parse = null;
            string = getString(METADATA_KEY_MEDIA_URI);
            if (!TextUtils.isEmpty(string)) {
                uri = Uri.parse(string);
            }
            builder = new android.support.v4.media.MediaDescriptionCompat.Builder();
            builder.setMediaId(string2);
            builder.setTitle(charSequenceArr[0]);
            builder.setSubtitle(charSequenceArr[1]);
            builder.setDescription(charSequenceArr[2]);
            builder.setIconBitmap(bitmap);
            builder.setIconUri(parse);
            builder.setMediaUri(uri);
            bundle = new Bundle();
            if (this.mBundle.containsKey(METADATA_KEY_BT_FOLDER_TYPE)) {
                bundle.putLong(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE, getLong(METADATA_KEY_BT_FOLDER_TYPE));
            }
            if (this.mBundle.containsKey(METADATA_KEY_DOWNLOAD_STATUS)) {
                bundle.putLong(MediaDescriptionCompat.EXTRA_DOWNLOAD_STATUS, getLong(METADATA_KEY_DOWNLOAD_STATUS));
            }
            if (!bundle.isEmpty()) {
                builder.setExtras(bundle);
            }
            this.mDescription = builder.build();
            return this.mDescription;
        }
        bitmap = null;
        while (i5 < PREFERRED_URI_ORDER.length) {
            string = getString(string3);
            if (!TextUtils.isEmpty(string)) {
                parse = Uri.parse(string);
                break;
            }
        }
        parse = null;
        string = getString(METADATA_KEY_MEDIA_URI);
        if (TextUtils.isEmpty(string)) {
            uri = Uri.parse(string);
        }
        builder = new android.support.v4.media.MediaDescriptionCompat.Builder();
        builder.setMediaId(string2);
        builder.setTitle(charSequenceArr[0]);
        builder.setSubtitle(charSequenceArr[1]);
        builder.setDescription(charSequenceArr[2]);
        builder.setIconBitmap(bitmap);
        builder.setIconUri(parse);
        builder.setMediaUri(uri);
        bundle = new Bundle();
        if (this.mBundle.containsKey(METADATA_KEY_BT_FOLDER_TYPE)) {
            bundle.putLong(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE, getLong(METADATA_KEY_BT_FOLDER_TYPE));
        }
        if (this.mBundle.containsKey(METADATA_KEY_DOWNLOAD_STATUS)) {
            bundle.putLong(MediaDescriptionCompat.EXTRA_DOWNLOAD_STATUS, getLong(METADATA_KEY_DOWNLOAD_STATUS));
        }
        if (bundle.isEmpty()) {
            builder.setExtras(bundle);
        }
        this.mDescription = builder.build();
        return this.mDescription;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.mBundle);
    }

    public final int size() {
        return this.mBundle.size();
    }

    public final Set<String> keySet() {
        return this.mBundle.keySet();
    }

    public final Bundle getBundle() {
        return this.mBundle;
    }

    public static MediaMetadataCompat fromMediaMetadata(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        MediaMetadataCompatApi21.writeToParcel(obj, obtain, 0);
        obtain.setDataPosition(0);
        MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat) CREATOR.createFromParcel(obtain);
        obtain.recycle();
        mediaMetadataCompat.mMetadataObj = obj;
        return mediaMetadataCompat;
    }

    public final Object getMediaMetadata() {
        if (this.mMetadataObj == null && VERSION.SDK_INT >= 21) {
            Parcel obtain = Parcel.obtain();
            writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            this.mMetadataObj = MediaMetadataCompatApi21.createFromParcel(obtain);
            obtain.recycle();
        }
        return this.mMetadataObj;
    }
}
