package com.xunlei.downloadprovider.download.center.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.cooperation.a.a;
import com.xunlei.downloadprovider.cooperation.l;
import com.xunlei.downloadprovider.personal.settings.RoomCleanActivity;

/* compiled from: DownloadStorageView */
final class ac implements OnClickListener {
    final /* synthetic */ DownloadStorageView a;

    ac(DownloadStorageView downloadStorageView) {
        this.a = downloadStorageView;
    }

    public final void onClick(View view) {
        a.b(l.c(1003), "");
        RoomCleanActivity.a(this.a.getContext(), 1003);
    }
}
