package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.view;

import android.widget.ImageView;
import com.xunlei.downloadprovider.ad.common.c;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.a;

/* compiled from: DialogContentFragment */
final class k implements a {
    final /* synthetic */ DialogContentFragment a;

    k(DialogContentFragment dialogContentFragment) {
        this.a = dialogContentFragment;
    }

    public final void a(ImageView imageView, String str, int i) {
        c.a(this.a.getActivity(), str).placeholder(i).error(i).fallback(i).into(imageView);
    }
}
