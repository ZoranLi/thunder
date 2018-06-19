package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.BaseCommentReplyMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.ChatTaskCommentReplyMessageContent;

/* compiled from: TaskCommentReplyMessageResourceItem */
public final class o extends a<b, ChatTaskCommentReplyMessageContent> {
    private ImageView h = null;
    private TextView i = null;

    public final /* synthetic */ void a(BaseCommentReplyMessageContent baseCommentReplyMessageContent) {
        super.a((ChatTaskCommentReplyMessageContent) baseCommentReplyMessageContent);
        this.h.setVisibility(8);
        this.i.setVisibility(8);
    }

    public o(View view, b bVar) {
        super(view, bVar);
        a();
        b();
    }

    protected final void a() {
        super.a();
        this.h = (ImageView) this.a.findViewById(R.id.iv_resource_poster);
        this.i = (TextView) this.a.findViewById(R.id.tv_resource_title);
    }
}
