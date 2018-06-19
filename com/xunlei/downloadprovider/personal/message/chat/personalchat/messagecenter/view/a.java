package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b;

/* compiled from: BaseMessageCenterStyleChatViewHolder */
public abstract class a<DATA extends b> extends r<DATA> {
    protected View a = null;
    protected ImageView b = null;
    protected TextView c = null;
    protected TextView d = null;
    protected TextView e = null;
    protected TextView f = null;

    public a(View view) {
        super(view);
    }

    protected final void a(View view) {
        this.a = view.findViewById(R.id.root_view);
        this.b = (ImageView) view.findViewById(R.id.iv_avatar);
        this.c = (TextView) view.findViewById(R.id.tv_name);
        this.d = (TextView) view.findViewById(R.id.tv_desc);
        this.e = (TextView) view.findViewById(R.id.tv_date);
        this.f = (TextView) view.findViewById(R.id.tv_unread_count);
    }

    public void a(DATA data) {
        com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.a.b.a(this.f, data.getUnreadCount());
    }
}
