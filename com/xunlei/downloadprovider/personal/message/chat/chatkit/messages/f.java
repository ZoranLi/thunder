package com.xunlei.downloadprovider.personal.message.chat.chatkit.messages;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.messages.a.c;

/* compiled from: MessageHolders */
final class f implements OnLongClickListener {
    final /* synthetic */ IChatMessage a;
    final /* synthetic */ c b;

    f(c cVar, IChatMessage iChatMessage) {
        this.b = cVar;
        this.a = iChatMessage;
    }

    public final boolean onLongClick(View view) {
        if (!(this.a == null || this.b.b == null)) {
            this.b.b.a(this.a);
        }
        return true;
    }
}
