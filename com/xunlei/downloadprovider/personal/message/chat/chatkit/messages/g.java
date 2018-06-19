package com.xunlei.downloadprovider.personal.message.chat.chatkit.messages;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.a.i;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.ChatHyperLinkHelper.a;

/* compiled from: MessageHolders */
final class g implements OnLongClickListener {
    final /* synthetic */ IChatMessage a;
    final /* synthetic */ i b;

    g(i iVar, IChatMessage iChatMessage) {
        this.b = iVar;
        this.a = iChatMessage;
    }

    public final boolean onLongClick(View view) {
        a.a(view);
        if (!(this.a == null || this.b.b == null)) {
            this.b.b.a(this.a);
        }
        return true;
    }
}
