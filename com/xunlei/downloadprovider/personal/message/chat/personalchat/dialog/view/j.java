package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.view;

import android.widget.PopupWindow.OnDismissListener;

/* compiled from: DialogContentFragment */
final class j implements OnDismissListener {
    final /* synthetic */ DialogContentFragment a;

    j(DialogContentFragment dialogContentFragment) {
        this.a = dialogContentFragment;
    }

    public final void onDismiss() {
        DialogContentFragment.a(this.a.getActivity(), 1.0f);
    }
}
