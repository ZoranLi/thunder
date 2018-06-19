package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.utils.DateFormatter.a;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b;

/* compiled from: MessageCenterViewHolder */
public abstract class r<DATA extends b> extends ViewHolder {
    protected a g = null;
    protected Context h = null;

    public abstract void a(DATA data);

    public r(View view) {
        super(view);
        this.h = view.getContext();
    }

    public final void a(a aVar) {
        this.g = aVar;
    }
}
