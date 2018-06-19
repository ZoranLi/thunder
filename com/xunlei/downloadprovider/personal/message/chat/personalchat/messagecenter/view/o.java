package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view;

import android.view.View;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.l;

/* compiled from: MessageCenterLikeViewHolder */
public final class o extends b<l> {
    public final /* synthetic */ void a(b bVar) {
        bVar = (l) bVar;
        super.a(bVar);
        this.b.setImageResource(l.a().intValue());
        this.c.setText(bVar.getTitle());
    }

    public o(View view) {
        super(view);
        a(view);
    }
}
