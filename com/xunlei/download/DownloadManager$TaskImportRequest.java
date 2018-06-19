package com.xunlei.download;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.xunlei.download.Downloads.Impl;

public class DownloadManager$TaskImportRequest extends DownloadManager$Request {
    private long g;
    private long h;

    public DownloadManager$TaskImportRequest(Uri uri, long j, long j2) {
        super(uri);
        if (j > 0) {
            if (j2 == -1 || j2 >= j) {
                this.g = j;
                this.h = j2;
                return;
            }
        }
        throw new IllegalArgumentException("Illegal Argumment (currentBytes<=0 || (totalBytes != -1 && totalBytes<currentBytes)");
    }

    ContentValues a(Context context, String str) {
        if (this.b == null) {
            throw new IllegalArgumentException("Destination need to be set using setDestinationUri");
        }
        setDownloadSpdy(true);
        context = super.a(context, str);
        context.put(Impl._DATA, this.b.getPath());
        context.put("total_bytes", Long.valueOf(this.h));
        context.put(Impl.COLUMN_CURRENT_BYTES, Long.valueOf(this.g));
        return context;
    }
}
