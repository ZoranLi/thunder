package com.xunlei.downloadprovider.publiser.campaign;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.publiser.campaign.a.a;

/* compiled from: DownloadXLLiveDialog */
final class b implements OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ a b;

    b(a aVar, a aVar2) {
        this.b = aVar;
        this.a = aVar2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.a(this.b);
        this.b.dismiss();
    }
}
