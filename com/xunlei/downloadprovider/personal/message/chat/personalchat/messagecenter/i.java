package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.f;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.g;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.k;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.l;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.m;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.o;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.r;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.s;
import java.util.List;

/* compiled from: MessageCenterListAdapter */
public final class i extends a<b> {
    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public i() {
        this(f.a().f);
    }

    private i(List<b> list) {
        super(list);
    }

    public final r a(ViewGroup viewGroup, int i) {
        r a = super.a(viewGroup, i);
        if (a != null) {
            return a;
        }
        if (i == 100) {
            return new g(a.a((int) R.layout.list_item_message_center_acquaintance_chat_dialog, viewGroup));
        }
        switch (i) {
            case 1:
                return new k(a.a((int) R.layout.list_item_message_center_stable, viewGroup));
            case 2:
                return new m(a.a((int) R.layout.list_item_message_center_hi, viewGroup));
            case 3:
                return new o(a.a((int) R.layout.list_item_message_center_stable, viewGroup));
            case 4:
                return new l(a.a((int) R.layout.list_item_message_center_stable, viewGroup));
            case 5:
                return new s(a.a((int) R.layout.list_item_message_center_visit, viewGroup));
            default:
                return a;
        }
    }
}
