package com.xunlei.downloadprovider.download.engine.task.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader.OnLoadCompleteListener;
import com.xunlei.download.DownloadManager$Query;
import com.xunlei.downloadprovider.download.engine.kernel.f;

/* compiled from: TaskCursorLoaderHelper */
public final class x {
    protected CursorLoader a;

    public final void a(Context context, Uri uri, OnLoadCompleteListener<Cursor> onLoadCompleteListener) {
        try {
            DownloadManager$Query downloadManager$Query = new DownloadManager$Query();
            downloadManager$Query.setFilterByStatus(31);
            downloadManager$Query.orderBy("_id", 2);
            this.a = new f(context, uri, downloadManager$Query.getProjection(), downloadManager$Query.getSelection(), downloadManager$Query.getSelectionArgs(), downloadManager$Query.getSortOrder());
            this.a.registerListener(null, onLoadCompleteListener);
            this.a.startLoading();
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public final void a() {
        if (this.a != null) {
            this.a.stopLoading();
        }
    }

    public final boolean b() {
        if (this.a == null || !this.a.isStarted() || this.a.isReset()) {
            return false;
        }
        return true;
    }
}
