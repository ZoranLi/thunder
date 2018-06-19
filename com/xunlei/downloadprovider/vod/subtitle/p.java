package com.xunlei.downloadprovider.vod.subtitle;

import android.app.DownloadManager.Query;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.xunlei.download.DownloadManager;

/* compiled from: SubtitleManager */
final class p extends BroadcastReceiver {
    final /* synthetic */ g a;

    p(g gVar) {
        this.a = gVar;
    }

    public final void onReceive(Context context, Intent intent) {
        context = new Query();
        long longExtra = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, 0);
        context.setFilterById(new long[]{longExtra});
        context = this.a.f.query(context);
        if (context.moveToFirst() != null) {
            intent = context.getInt(context.getColumnIndex("status"));
            if (intent == 8) {
                context = context.getString(context.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
                if (this.a.i != null) {
                    this.a.i.a(Uri.parse(context).getPath());
                }
            } else if (intent == 16) {
                if (this.a.i != null) {
                    this.a.i.a(null);
                }
            }
        }
    }
}
