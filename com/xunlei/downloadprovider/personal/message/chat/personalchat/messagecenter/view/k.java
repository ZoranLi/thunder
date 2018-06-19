package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view;

import android.view.View;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.e;

/* compiled from: MessageCenterCommentViewHolder */
public final class k extends b<e> {
    public final /* synthetic */ void a(b bVar) {
        bVar = (e) bVar;
        super.a(bVar);
        this.b.setImageResource(e.a().intValue());
        this.c.setText(bVar.getTitle());
    }

    public k(View view) {
        super(view);
        a(view);
    }
}
