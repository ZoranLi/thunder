package com.xunlei.downloadprovider.player.xmp;

import android.content.Context;
import com.xunlei.downloadprovider.cooperation.ui.a;
import com.xunlei.xllib.android.b;

/* compiled from: XmpPlayerManager */
final class al implements a {
    final /* synthetic */ a a;
    final /* synthetic */ Context b;
    final /* synthetic */ ak c;

    public final void b() {
    }

    al(ak akVar, a aVar, Context context) {
        this.c = akVar;
        this.a = aVar;
        this.b = context;
    }

    public final void onCancel() {
        this.c.g = false;
        if (this.a != null) {
            this.a.b();
        }
    }

    public final void a() {
        if (b.d(this.b)) {
            this.c.g = true;
        }
        if (this.a != null) {
            this.a.a();
        }
    }
}
