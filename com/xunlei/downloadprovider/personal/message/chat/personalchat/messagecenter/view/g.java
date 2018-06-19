package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view;

import android.view.View;
import com.xunlei.downloadprovider.personal.message.chat.a;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.f;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b;

/* compiled from: MessageCenterAcquaintanceViewHolder */
public final class g extends a<IChatDialog> {
    public final /* synthetic */ void a(b bVar) {
        bVar = (IChatDialog) bVar;
        super.a(bVar);
        a.a(this.b.getContext(), bVar.getAvatarUrl(), this.b);
        this.c.setText(bVar.getTitle());
        this.d.setText(bVar.lastMessage() != null ? bVar.lastMessage().messageContent().previewText() : "");
        this.e.setText(this.g.a(f.a(bVar.lastMessage())));
        this.e.setVisibility(bVar.lastMessage().createdAt() == null ? 8 : null);
    }

    public g(View view) {
        super(view);
        a(view);
    }
}
