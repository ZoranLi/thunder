package com.xunlei.downloadprovider.personal.message.chat.chatkit.messages;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;

/* compiled from: MessageHolders */
final class b implements OnClickListener {
    final /* synthetic */ IChatMessage a;
    final /* synthetic */ com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.a.b b;

    b(com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.a.b bVar, IChatMessage iChatMessage) {
        this.b = bVar;
        this.a = iChatMessage;
    }

    public final void onClick(View view) {
        if (this.a != null && this.b.b != null) {
            this.b.b.onClick(0, this.a);
        }
    }
}
