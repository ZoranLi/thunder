package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a.a.d;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.BaseCommentReplyMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.ChatWebsiteCommentReplyMessageContent;

/* compiled from: WebsiteCommentReplyMessageResourceItem */
public final class q extends a<d, ChatWebsiteCommentReplyMessageContent> {
    private ImageView h = null;
    private TextView i = null;

    public final /* synthetic */ void a(BaseCommentReplyMessageContent baseCommentReplyMessageContent) {
        ChatWebsiteCommentReplyMessageContent chatWebsiteCommentReplyMessageContent = (ChatWebsiteCommentReplyMessageContent) baseCommentReplyMessageContent;
        super.a(chatWebsiteCommentReplyMessageContent);
        this.c.a(this.h, ((WebsiteInfo) chatWebsiteCommentReplyMessageContent.getMessageContent().e).g, R.drawable.website_icon_default_square);
        this.i.setText(((WebsiteInfo) chatWebsiteCommentReplyMessageContent.getMessageContent().e).e);
    }

    public q(View view, d dVar) {
        super(view, dVar);
        a();
        b();
    }

    protected final void a() {
        super.a();
        this.h = (ImageView) this.a.findViewById(R.id.iv_resource_poster);
        this.i = (TextView) this.a.findViewById(R.id.tv_resource_title);
    }
}
