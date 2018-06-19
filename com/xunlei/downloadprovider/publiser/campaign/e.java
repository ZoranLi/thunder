package com.xunlei.downloadprovider.publiser.campaign;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.publiser.campaign.d.a;

/* compiled from: DownloadYouLiaoDialog */
final class e implements OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ d b;

    e(d dVar, a aVar) {
        this.b = dVar;
        this.a = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        d.a(this.b, d.a, "http://7xt0pj.com1.z0.glb.clouddn.com/2017052401.png", "有料短视频");
        if (this.a != null) {
            this.a.a();
        }
        this.b.dismiss();
    }
}
