package com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.a;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.f;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.r;
import java.util.List;

/* compiled from: PersonalChatStrangersAdapter */
public final class c extends a<b> {
    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public c() {
        this(f.a().b(2));
    }

    public final r a(ViewGroup viewGroup, int i) {
        r a = super.a(viewGroup, i);
        if (a == null) {
            return i != 100 ? a : new com.xunlei.downloadprovider.personal.message.chat.personalchat.strangers.view.a(a.a((int) R.layout.list_item_message_center_stranger_chat_dialog, viewGroup));
        } else {
            return a;
        }
    }

    private c(List<b> list) {
        super(list);
    }
}
