package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a.a.c;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.c.a;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.BaseCommentReplyMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.ChatVideoCommentReplyMessageContent;

/* compiled from: VideoCommentReplyMessageResourceItem */
public final class p extends a<c, ChatVideoCommentReplyMessageContent> {
    private ImageView h = null;
    private TextView i = null;

    public final /* synthetic */ void a(BaseCommentReplyMessageContent baseCommentReplyMessageContent) {
        ChatVideoCommentReplyMessageContent chatVideoCommentReplyMessageContent = (ChatVideoCommentReplyMessageContent) baseCommentReplyMessageContent;
        super.a(chatVideoCommentReplyMessageContent);
        this.c.a(this.h, ((a) ((com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.c) chatVideoCommentReplyMessageContent.getMessageContent()).e).a, R.drawable.choiceness_icon_default);
        this.i.setText(((a) ((com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.c) chatVideoCommentReplyMessageContent.getMessageContent()).e).b);
    }

    public p(View view, c cVar) {
        super(view, cVar);
        a();
        b();
    }

    protected final void a() {
        super.a();
        this.h = (ImageView) this.a.findViewById(R.id.iv_resource_poster);
        this.i = (TextView) this.a.findViewById(R.id.tv_resource_title);
    }
}
