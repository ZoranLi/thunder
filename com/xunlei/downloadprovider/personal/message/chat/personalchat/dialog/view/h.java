package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.view;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

/* compiled from: DialogContentFragment */
final class h implements OnLayoutChangeListener {
    final /* synthetic */ DialogContentFragment a;

    h(DialogContentFragment dialogContentFragment) {
        this.a = dialogContentFragment;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i4 < i8) {
            this.a.c.postDelayed(new i(this), 100);
        }
    }
}
