package com.xunlei.downloadprovider.personal.message.chat.chatkit.messages;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.a.b;

/* compiled from: MessageHolders */
final class c implements OnLongClickListener {
    final /* synthetic */ IChatMessage a;
    final /* synthetic */ b b;

    c(b bVar, IChatMessage iChatMessage) {
        this.b = bVar;
        this.a = iChatMessage;
    }

    public final boolean onLongClick(View view) {
        if (!(this.a == null || this.b.b == null)) {
            this.b.b.a(this.a);
        }
        return true;
    }
}
