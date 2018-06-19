package com.xunlei.downloadprovider.download.player.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.player.a;

/* compiled from: VipAccelerateTryController */
final class bu implements OnClickListener {
    final /* synthetic */ bn a;

    bu(bn bnVar) {
        this.a = bnVar;
    }

    public final void onClick(View view) {
        if (this.a.f() != null) {
            a.a(this.a.f().r(), "long_video", "accelerate");
        }
    }
}
