package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view;

import android.view.View;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.j;

/* compiled from: MessageCenterFollowViewHolder */
public final class l extends b<j> {
    public final /* synthetic */ void a(b bVar) {
        bVar = (j) bVar;
        super.a(bVar);
        this.b.setImageResource(j.a().intValue());
        this.c.setText(bVar.getTitle());
    }

    public l(View view) {
        super(view);
        a(view);
    }
}
