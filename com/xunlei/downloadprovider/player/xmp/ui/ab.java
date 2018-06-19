package com.xunlei.downloadprovider.player.xmp.ui;

import android.view.View;
import android.view.ViewStub;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.player.xmp.aj;

/* compiled from: PlayerControlSlide */
final class ab extends aj {
    final /* synthetic */ z a;

    ab(z zVar) {
        this.a = zVar;
    }

    public final void a(String str) {
        super.a(str);
        if (this.a.f == null) {
            str = this.a;
            PlayerControl playerControl = this.a;
            View inflate = ((ViewStub) playerControl.b.findViewById(R.id.error_view)).inflate();
            inflate.findViewById(R.id.retry_btn).setOnClickListener(new ac(playerControl));
            str.f = inflate;
        }
        this.a.f.setVisibility(0);
    }

    public final void a(int i, int i2) {
        super.a(i, i2);
        if (this.a.f != 0) {
            this.a.f.setVisibility(8);
        }
    }
}
