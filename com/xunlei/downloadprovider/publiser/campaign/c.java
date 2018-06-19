package com.xunlei.downloadprovider.publiser.campaign;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.publiser.campaign.a.a;

/* compiled from: DownloadXLLiveDialog */
final class c implements OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ a b;

    c(a aVar, a aVar2) {
        this.b = aVar;
        this.a = aVar2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.b.dismiss();
    }
}
