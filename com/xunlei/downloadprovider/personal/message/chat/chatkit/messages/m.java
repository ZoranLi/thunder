package com.xunlei.downloadprovider.personal.message.chat.chatkit.messages;

import android.view.View;
import android.view.View.OnLongClickListener;

/* compiled from: MessagesListAdapter */
final class m implements OnLongClickListener {
    final /* synthetic */ c a;
    final /* synthetic */ k b;

    m(k kVar, c cVar) {
        this.b = kVar;
        this.a = cVar;
    }

    public final boolean onLongClick(View view) {
        if (this.b.k == null) {
            return true;
        }
        k.b = true;
        view.callOnClick();
        return true;
    }
}
