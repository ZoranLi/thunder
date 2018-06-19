package com.xunlei.downloadprovider.personal.a.c;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: UserFixedBtnViewHolder */
final class m implements OnClickListener {
    final /* synthetic */ i a;

    m(i iVar) {
        this.a = iVar;
    }

    public final void onClick(View view) {
        i.d(this.a);
        view = this.a;
        if (view.a.getVisibility() == 0) {
            view.a.setVisibility(8);
        }
    }
}
