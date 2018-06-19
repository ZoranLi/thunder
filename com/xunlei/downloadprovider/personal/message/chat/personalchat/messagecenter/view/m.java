package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view;

import android.view.View;
import android.widget.TextView;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.f;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.k;

/* compiled from: MessageCenterHiViewHolder */
public final class m extends a<k> {
    public final /* synthetic */ void a(b bVar) {
        bVar = (k) bVar;
        super.a(bVar);
        this.b.setImageResource(k.a().intValue());
        this.c.setText(bVar.getTitle());
        TextView textView = this.d;
        IChatMessage b = bVar.b();
        textView.setText(b != null ? b.messageContent().previewText() : "");
        this.e.setText(this.g.a(f.a(bVar.getUpdateTime())));
        this.e.setVisibility(bVar.getUpdateTime() == null ? 8 : null);
    }

    public m(View view) {
        super(view);
        a(view);
    }
}
