package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

/* compiled from: BaseMessageCenterStyleStableViewHolder */
public abstract class b<DATA extends com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b> extends r<DATA> {
    protected View a = null;
    protected ImageView b = null;
    protected TextView c = null;
    protected TextView d = null;

    public b(View view) {
        super(view);
    }

    protected final void a(View view) {
        this.a = view.findViewById(R.id.root_view);
        this.b = (ImageView) view.findViewById(R.id.iv_avatar);
        this.c = (TextView) view.findViewById(R.id.tv_name);
        this.d = (TextView) view.findViewById(R.id.tv_unread_count);
    }

    public void a(DATA data) {
        com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.a.b.a(this.d, data.getUnreadCount());
    }
}
