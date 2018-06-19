package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.r;
import java.util.Arrays;
import java.util.List;

/* compiled from: DialogListAdapter */
public abstract class a<MessageCenterItemInfo extends com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b> extends Adapter<r> {
    public com.xunlei.downloadprovider.personal.message.chat.chatkit.utils.DateFormatter.a a = null;
    protected a<MessageCenterItemInfo> b = null;
    protected b<MessageCenterItemInfo> c = null;
    private final List<MessageCenterItemInfo> d;

    /* compiled from: DialogListAdapter */
    public interface a<MessageCenterItemInfo> {
        void b(MessageCenterItemInfo messageCenterItemInfo);
    }

    /* compiled from: DialogListAdapter */
    public interface b<MessageCenterItemInfo> {
        void c(MessageCenterItemInfo messageCenterItemInfo);
    }

    public r a(ViewGroup viewGroup, int i) {
        return null;
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        r rVar = (r) viewHolder;
        com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b bVar = (com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b) this.d.get(i);
        rVar.a(this.a);
        rVar.itemView.setOnClickListener(new b(this, bVar));
        rVar.itemView.setOnLongClickListener(new c(this, bVar));
        rVar.a(bVar);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public a(List<MessageCenterItemInfo> list) {
        this.d = list;
    }

    public int getItemCount() {
        return this.d.size();
    }

    public int getItemViewType(int i) {
        if (this.d.get(i) != null) {
            return ((com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b) this.d.get(i)).getItemType();
        }
        StringBuilder stringBuilder = new StringBuilder("chat.DialogListAdapter getItemViewType, but item is null. position: ");
        stringBuilder.append(i);
        stringBuilder.append(" mItems.size(): ");
        stringBuilder.append(this.d.size());
        stringBuilder.append(" mItems: ");
        stringBuilder.append(Arrays.toString(this.d.toArray()));
        throw new NullPointerException(stringBuilder.toString());
    }

    protected static View a(@LayoutRes int i, ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
    }

    public final void a(a<MessageCenterItemInfo> aVar) {
        this.b = aVar;
    }

    public final void a(b<MessageCenterItemInfo> bVar) {
        this.c = bVar;
    }

    static /* synthetic */ void a(a aVar, com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b bVar) {
        if (aVar.b != null) {
            aVar.b.b(bVar);
        }
    }

    static /* synthetic */ void b(a aVar, com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b bVar) {
        if (aVar.c != null) {
            aVar.c.c(bVar);
        }
    }
}
