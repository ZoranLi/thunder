package com.xunlei.downloadprovider.download.center.widget;

import android.os.Build.VERSION;

/* compiled from: DownloadStorageView */
final class ad extends a {
    final /* synthetic */ DownloadStorageView a;

    ad(DownloadStorageView downloadStorageView) {
        this.a = downloadStorageView;
        super();
    }

    protected final /* bridge */ /* synthetic */ void onCancelled(Object obj) {
        super.onCancelled((b) obj);
        this.a.a = null;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        b bVar = (b) obj;
        this.a.a = null;
        if (VERSION.SDK_INT < 19 || this.a.isAttachedToWindow()) {
            DownloadStorageView.a(this.a, bVar);
        }
    }

    protected final void onCancelled() {
        super.onCancelled();
        this.a.a = null;
    }
}
