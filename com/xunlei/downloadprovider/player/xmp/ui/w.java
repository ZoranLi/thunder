package com.xunlei.downloadprovider.player.xmp.ui;

import android.view.View;
import android.view.ViewStub;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.player.xmp.aj;

/* compiled from: PlayerControlDetail */
final class w extends aj {
    final /* synthetic */ u a;

    w(u uVar) {
        this.a = uVar;
    }

    public final void a(String str) {
        super.a(str);
        if (this.a.h == null) {
            str = this.a;
            PlayerControl playerControl = this.a;
            View inflate = ((ViewStub) playerControl.b.findViewById(R.id.error_view)).inflate();
            inflate.setOnTouchListener(new x(playerControl));
            inflate.findViewById(R.id.retry_btn).setOnClickListener(new y(playerControl));
            str.h = inflate;
        }
        this.a.h.setVisibility(0);
    }

    public final void a(int i, int i2) {
        super.a(i, i2);
        if (this.a.h != 0) {
            this.a.h.setVisibility(8);
        }
    }
}
