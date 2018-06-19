package com.bumptech.glide.load.data;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Thumbnails;
import android.provider.MediaStore.Video;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.download.Downloads.Impl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MediaStoreThumbFetcher implements DataFetcher<InputStream> {
    private static final ThumbnailStreamOpenerFactory DEFAULT_FACTORY = new ThumbnailStreamOpenerFactory();
    private static final int MINI_HEIGHT = 384;
    private static final int MINI_WIDTH = 512;
    private static final String TAG = "MediaStoreThumbFetcher";
    private final Context context;
    private final DataFetcher<InputStream> defaultFetcher;
    private final ThumbnailStreamOpenerFactory factory;
    private final int height;
    private InputStream inputStream;
    private final Uri mediaStoreUri;
    private final int width;

    static class FileService {
        FileService() {
        }

        public boolean exists(File file) {
            return file.exists();
        }

        public long length(File file) {
            return file.length();
        }

        public File get(String str) {
            return new File(str);
        }
    }

    interface ThumbnailQuery {
        Cursor queryPath(Context context, Uri uri);
    }

    static class ThumbnailStreamOpener {
        private static final FileService DEFAULT_SERVICE = new FileService();
        private ThumbnailQuery query;
        private final FileService service;

        public ThumbnailStreamOpener(ThumbnailQuery thumbnailQuery) {
            this(DEFAULT_SERVICE, thumbnailQuery);
        }

        public ThumbnailStreamOpener(FileService fileService, ThumbnailQuery thumbnailQuery) {
            this.service = fileService;
            this.query = thumbnailQuery;
        }

        public int getOrientation(android.content.Context r3, android.net.Uri r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = 0;
            r3 = r3.getContentResolver();	 Catch:{ IOException -> 0x001f }
            r3 = r3.openInputStream(r4);	 Catch:{ IOException -> 0x001f }
            r0 = new com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;	 Catch:{ IOException -> 0x001b, all -> 0x0018 }
            r0.<init>(r3);	 Catch:{ IOException -> 0x001b, all -> 0x0018 }
            r0 = r0.getOrientation();	 Catch:{ IOException -> 0x001b, all -> 0x0018 }
            if (r3 == 0) goto L_0x0038;
        L_0x0014:
            r3.close();	 Catch:{ IOException -> 0x0038 }
            goto L_0x0038;
        L_0x0018:
            r4 = move-exception;
            r0 = r3;
            goto L_0x0039;
        L_0x001b:
            r0 = r3;
            goto L_0x001f;
        L_0x001d:
            r4 = move-exception;
            goto L_0x0039;
        L_0x001f:
            r3 = "MediaStoreThumbFetcher";	 Catch:{ all -> 0x001d }
            r1 = 3;	 Catch:{ all -> 0x001d }
            r3 = android.util.Log.isLoggable(r3, r1);	 Catch:{ all -> 0x001d }
            if (r3 == 0) goto L_0x0032;	 Catch:{ all -> 0x001d }
        L_0x0028:
            r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x001d }
            r1 = "Failed to open uri: ";	 Catch:{ all -> 0x001d }
            r3.<init>(r1);	 Catch:{ all -> 0x001d }
            r3.append(r4);	 Catch:{ all -> 0x001d }
        L_0x0032:
            if (r0 == 0) goto L_0x0037;
        L_0x0034:
            r0.close();	 Catch:{ IOException -> 0x0037 }
        L_0x0037:
            r0 = -1;
        L_0x0038:
            return r0;
        L_0x0039:
            if (r0 == 0) goto L_0x003e;
        L_0x003b:
            r0.close();	 Catch:{ IOException -> 0x003e }
        L_0x003e:
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.MediaStoreThumbFetcher.ThumbnailStreamOpener.getOrientation(android.content.Context, android.net.Uri):int");
        }

        public InputStream open(Context context, Uri uri) throws FileNotFoundException {
            Uri parseThumbUri;
            uri = this.query.queryPath(context, uri);
            if (uri != null) {
                try {
                    if (uri.moveToFirst()) {
                        parseThumbUri = parseThumbUri(uri);
                        if (uri != null) {
                            uri.close();
                        }
                        if (parseThumbUri == null) {
                            return context.getContentResolver().openInputStream(parseThumbUri);
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    if (uri != null) {
                        uri.close();
                    }
                }
            }
            parseThumbUri = null;
            if (uri != null) {
                uri.close();
            }
            if (parseThumbUri == null) {
                return null;
            }
            return context.getContentResolver().openInputStream(parseThumbUri);
        }

        private Uri parseThumbUri(Cursor cursor) {
            cursor = cursor.getString(0);
            if (!TextUtils.isEmpty(cursor)) {
                cursor = this.service.get(cursor);
                if (this.service.exists(cursor) && this.service.length(cursor) > 0) {
                    return Uri.fromFile(cursor);
                }
            }
            return null;
        }
    }

    static class ThumbnailStreamOpenerFactory {
        ThumbnailStreamOpenerFactory() {
        }

        public ThumbnailStreamOpener build(Uri uri, int i, int i2) {
            if (MediaStoreThumbFetcher.isMediaStoreUri(uri) && i <= 512) {
                if (i2 <= MediaStoreThumbFetcher.MINI_HEIGHT) {
                    if (MediaStoreThumbFetcher.isMediaStoreVideo(uri) != null) {
                        return new ThumbnailStreamOpener(new VideoThumbnailQuery());
                    }
                    return new ThumbnailStreamOpener(new ImageThumbnailQuery());
                }
            }
            return null;
        }
    }

    static class ImageThumbnailQuery implements ThumbnailQuery {
        private static final String[] PATH_PROJECTION = new String[]{Impl._DATA};
        private static final String PATH_SELECTION = "kind = 1 AND image_id = ?";

        ImageThumbnailQuery() {
        }

        public Cursor queryPath(Context context, Uri uri) {
            uri = uri.getLastPathSegment();
            return context.getContentResolver().query(Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new String[]{uri}, null);
        }
    }

    static class VideoThumbnailQuery implements ThumbnailQuery {
        private static final String[] PATH_PROJECTION = new String[]{Impl._DATA};
        private static final String PATH_SELECTION = "kind = 1 AND video_id = ?";

        VideoThumbnailQuery() {
        }

        public Cursor queryPath(Context context, Uri uri) {
            uri = uri.getLastPathSegment();
            return context.getContentResolver().query(Video.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new String[]{uri}, null);
        }
    }

    public void cancel() {
    }

    public MediaStoreThumbFetcher(Context context, Uri uri, DataFetcher<InputStream> dataFetcher, int i, int i2) {
        this(context, uri, dataFetcher, i, i2, DEFAULT_FACTORY);
    }

    MediaStoreThumbFetcher(Context context, Uri uri, DataFetcher<InputStream> dataFetcher, int i, int i2, ThumbnailStreamOpenerFactory thumbnailStreamOpenerFactory) {
        this.context = context;
        this.mediaStoreUri = uri;
        this.defaultFetcher = dataFetcher;
        this.width = i;
        this.height = i2;
        this.factory = thumbnailStreamOpenerFactory;
    }

    public InputStream loadData(Priority priority) throws Exception {
        ThumbnailStreamOpener build = this.factory.build(this.mediaStoreUri, this.width, this.height);
        if (build != null) {
            this.inputStream = openThumbInputStream(build);
        }
        if (this.inputStream == null) {
            this.inputStream = (InputStream) this.defaultFetcher.loadData(priority);
        }
        return this.inputStream;
    }

    private java.io.InputStream openThumbInputStream(com.bumptech.glide.load.data.MediaStoreThumbFetcher.ThumbnailStreamOpener r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.context;	 Catch:{ FileNotFoundException -> 0x0009 }
        r1 = r4.mediaStoreUri;	 Catch:{ FileNotFoundException -> 0x0009 }
        r0 = r5.open(r0, r1);	 Catch:{ FileNotFoundException -> 0x0009 }
        goto L_0x000a;
    L_0x0009:
        r0 = 0;
    L_0x000a:
        r1 = -1;
        if (r0 == 0) goto L_0x0016;
    L_0x000d:
        r2 = r4.context;
        r3 = r4.mediaStoreUri;
        r5 = r5.getOrientation(r2, r3);
        goto L_0x0017;
    L_0x0016:
        r5 = r1;
    L_0x0017:
        if (r5 == r1) goto L_0x001f;
    L_0x0019:
        r1 = new com.bumptech.glide.load.data.ExifOrientationStream;
        r1.<init>(r0, r5);
        r0 = r1;
    L_0x001f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.MediaStoreThumbFetcher.openThumbInputStream(com.bumptech.glide.load.data.MediaStoreThumbFetcher$ThumbnailStreamOpener):java.io.InputStream");
    }

    public void cleanup() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.inputStream;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r1.inputStream;	 Catch:{ IOException -> 0x0009 }
        r0.close();	 Catch:{ IOException -> 0x0009 }
    L_0x0009:
        r0 = r1.defaultFetcher;
        r0.cleanup();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.MediaStoreThumbFetcher.cleanup():void");
    }

    public String getId() {
        return this.mediaStoreUri.toString();
    }

    private static boolean isMediaStoreUri(Uri uri) {
        return (uri == null || !"content".equals(uri.getScheme()) || SocializeConstants.KEY_PLATFORM.equals(uri.getAuthority()) == null) ? null : true;
    }

    private static boolean isMediaStoreVideo(Uri uri) {
        return (!isMediaStoreUri(uri) || uri.getPathSegments().contains("video") == null) ? null : true;
    }
}
