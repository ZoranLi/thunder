package com.duiba.maila.sdk;

import android.view.View;
import android.view.View.OnClickListener;

final class m implements OnClickListener {
    final /* synthetic */ ViewCore a;

    m(ViewCore viewCore) {
        this.a = viewCore;
    }

    public final void onClick(View view) {
        ViewCore viewCore = this.a;
        if (viewCore.a != null ? viewCore.a.canGoBack() : false) {
            view = this.a;
            if (view.a != null) {
                view.a.goBack();
            }
            return;
        }
        if (this.a.h != null) {
            this.a.h.onClick(view);
        }
    }
}
