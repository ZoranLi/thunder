package com.duiba.maila.sdk;

import android.view.View;
import android.view.View.OnClickListener;

final class p implements OnClickListener {
    final /* synthetic */ ViewCore a;

    p(ViewCore viewCore) {
        this.a = viewCore;
    }

    public final void onClick(View view) {
        this.a.b = false;
        this.a.a.reload();
    }
}
