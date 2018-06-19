package com.xunlei.downloadprovider.personal.message.chat.chatkit.commons;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

/* compiled from: ViewHolder */
public abstract class c<DATA> extends ViewHolder {
    private Context a = null;

    public abstract void a(DATA data);

    public c(Context context, View view) {
        super(view);
        this.a = context;
    }
}
