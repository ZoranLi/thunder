package com.xunlei.downloadprovider.publiser.campaign;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.publiser.campaign.d.a;

/* compiled from: DownloadYouLiaoDialog */
final class f implements OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ d b;

    f(d dVar, a aVar) {
        this.b = dVar;
        this.a = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.b.dismiss();
    }
}
