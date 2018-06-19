package me.iwf.photopicker.d;

import android.content.Context;
import android.provider.MediaStore.Images.Media;
import android.support.v4.content.CursorLoader;
import com.xunlei.download.Downloads.Impl;

/* compiled from: PhotoDirectoryLoader */
public final class g extends CursorLoader {
    final String[] a = new String[]{"_id", Impl._DATA, "bucket_id", "bucket_display_name", "date_added", "_size"};

    public g(Context context, boolean z) {
        super(context);
        setProjection(this.a);
        setUri(Media.EXTERNAL_CONTENT_URI);
        setSortOrder("date_added DESC");
        context = new StringBuilder("mime_type=? or mime_type=? or mime_type=? ");
        context.append(z ? "or mime_type=?" : "");
        setSelection(context.toString());
        setSelectionArgs(z ? new String[]{"image/jpeg", "image/png", "image/jpg", "image/gif"} : new String[]{"image/jpeg", "image/png", "image/jpg"});
    }
}
