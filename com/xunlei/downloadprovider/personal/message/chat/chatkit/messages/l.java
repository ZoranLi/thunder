package com.xunlei.downloadprovider.personal.message.chat.chatkit.messages;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;

/* compiled from: MessagesListAdapter */
final class l implements OnClickListener {
    final /* synthetic */ c a;
    final /* synthetic */ k b;

    l(k kVar, c cVar) {
        this.b = kVar;
        this.a = cVar;
    }

    public final void onClick(View view) {
        if (this.b.k != null && k.b != null) {
            this.a.b ^= 1;
            if (this.a.b != null) {
                r1.j++;
            } else {
                k.c(this.b);
            }
            this.b.notifyItemChanged(this.b.a(String.valueOf(((IChatMessage) this.a.a).messageId())));
        }
    }
}
