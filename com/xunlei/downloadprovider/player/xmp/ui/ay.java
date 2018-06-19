package com.xunlei.downloadprovider.player.xmp.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.player.a;

/* compiled from: PlayerOperationViewDetail */
final class ay implements OnClickListener {
    final /* synthetic */ PlayerOperationViewDetail a;

    ay(PlayerOperationViewDetail playerOperationViewDetail) {
        this.a = playerOperationViewDetail;
    }

    public final void onClick(View view) {
        if (this.a.a != null) {
            view = this.a.a.g();
            if (view == 4) {
                this.a.a.a(true, false);
                a.a("videodetail", "pause", "online_shortvideo", "");
            } else if (view == 3) {
                this.a.a.e();
                a.a("videodetail", "play", "online_shortvideo", "");
            } else {
                this.a.a.f();
            }
        }
    }
}
