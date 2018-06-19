package com.xunlei.downloadprovider.personal.message.chat.chatkit.messages;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;

public class MessagesList extends RecyclerView {
    private n a;

    public MessagesList(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public MessagesList(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    public void setAdapter(Adapter adapter) {
        throw new IllegalArgumentException("You can't set adapter to MessagesList. Use #setAdapter(MessagesListAdapter) instead.");
    }

    public <MESSAGE extends IChatMessage> void setAdapter(k<MESSAGE> kVar) {
        ItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        setItemAnimator(defaultItemAnimator);
        setLayoutManager(linearLayoutManager);
        kVar.c = linearLayoutManager;
        kVar.d = this.a;
        super.setAdapter(kVar);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.a = n.a(context, attributeSet);
    }
}
