package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a;

import android.view.View;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a.a.a;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.BaseCommentReplyMessageContent;

/* compiled from: CommentReplyMessageItem */
public final class e {
    a a = null;
    com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.a b = null;
    IChatMessage c = null;
    BaseCommentReplyMessageContent d = null;
    private View e = null;
    private a f = null;
    private View g = null;
    private TextView h = null;

    public e(View view, a aVar, a aVar2) {
        this.e = view;
        this.a = aVar;
        this.f = aVar2;
        this.g = this.e.findViewById(R.id.fl_reply);
        this.h = (TextView) this.e.findViewById(R.id.tv_reply);
        this.g.setOnClickListener(new f(this));
    }

    public final void a(IChatMessage iChatMessage) {
        this.c = iChatMessage;
        this.f.c = this.b;
        this.f.f = iChatMessage;
    }

    public final void a(BaseCommentReplyMessageContent baseCommentReplyMessageContent) {
        this.d = baseCommentReplyMessageContent;
        this.f.a(baseCommentReplyMessageContent);
        this.h.setText(baseCommentReplyMessageContent.getMessageContent().b);
    }
}
