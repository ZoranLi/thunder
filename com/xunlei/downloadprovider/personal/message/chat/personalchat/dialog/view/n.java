package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;

/* compiled from: DialogContentFragment */
final class n implements OnClickListener {
    final /* synthetic */ IChatMessage a;
    final /* synthetic */ DialogContentFragment b;

    n(DialogContentFragment dialogContentFragment, IChatMessage iChatMessage) {
        this.b = dialogContentFragment;
        this.a = iChatMessage;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.b.h.dismiss();
        this.b.a.c(this.a);
    }
}
