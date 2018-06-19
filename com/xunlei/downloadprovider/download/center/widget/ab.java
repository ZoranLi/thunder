package com.xunlei.downloadprovider.download.center.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.cooperation.a.a;
import com.xunlei.downloadprovider.cooperation.l;
import com.xunlei.downloadprovider.personal.settings.RoomCleanActivity;

/* compiled from: DownloadStorageExchangeDialogPPW */
final class ab implements OnClickListener {
    final /* synthetic */ aa a;

    ab(aa aaVar) {
        this.a = aaVar;
    }

    public final void onClick(View view) {
        this.a.dismiss();
        a.b(l.c(1003), "");
        RoomCleanActivity.a(this.a.b, 1003);
    }
}
