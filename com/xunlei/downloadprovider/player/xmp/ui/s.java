package com.xunlei.downloadprovider.player.xmp.ui;

import android.view.View;
import android.view.ViewStub;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.player.xmp.aj;

/* compiled from: PlayerControlDefault */
final class s extends aj {
    final /* synthetic */ q a;

    s(q qVar) {
        this.a = qVar;
    }

    public final void a(String str) {
        super.a(str);
        if (this.a.g == null) {
            str = this.a;
            PlayerControl playerControl = this.a;
            View inflate = ((ViewStub) playerControl.b.findViewById(R.id.error_view)).inflate();
            inflate.findViewById(R.id.retry_btn).setOnClickListener(new t(playerControl));
            str.g = inflate;
        }
        this.a.g.setVisibility(0);
    }

    public final void a(int i, int i2) {
        super.a(i, i2);
        if (this.a.g != 0) {
            this.a.g.setVisibility(8);
        }
    }
}
