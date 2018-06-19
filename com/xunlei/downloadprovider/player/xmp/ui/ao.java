package com.xunlei.downloadprovider.player.xmp.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.player.a;

/* compiled from: PlayerOperationViewDefault */
final class ao implements OnClickListener {
    final /* synthetic */ PlayerOperationViewDefault a;

    ao(PlayerOperationViewDefault playerOperationViewDefault) {
        this.a = playerOperationViewDefault;
    }

    public final void onClick(View view) {
        if (this.a.a != null) {
            view = this.a.a.g();
            if (view == 4) {
                this.a.a.a(true, false);
                a.a("videodetail", "pause", "online_shortvideo", "");
                return;
            }
            if (view == 3) {
                this.a.a.e();
                a.a("videodetail", "play", "online_shortvideo", "");
            }
        }
    }
}
