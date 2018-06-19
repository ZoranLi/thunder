package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a.a;

import android.content.Context;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteDetailActivity;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.c;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.BaseCommentReplyMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.ChatWebsiteCommentReplyMessageContent;

/* compiled from: WebsiteCommentReplyMessageController */
public final class d extends a<ChatWebsiteCommentReplyMessageContent> {
    public final /* bridge */ /* synthetic */ void a(IChatMessage iChatMessage, BaseCommentReplyMessageContent baseCommentReplyMessageContent) {
        a(iChatMessage, (ChatWebsiteCommentReplyMessageContent) baseCommentReplyMessageContent, "personal_chat_reply");
    }

    public final /* synthetic */ void b(IChatMessage iChatMessage, BaseCommentReplyMessageContent baseCommentReplyMessageContent) {
        a(iChatMessage, (ChatWebsiteCommentReplyMessageContent) baseCommentReplyMessageContent, "personal_chat_link");
    }

    public d(Context context) {
        super(context);
    }

    private void a(IChatMessage iChatMessage, ChatWebsiteCommentReplyMessageContent chatWebsiteCommentReplyMessageContent, String str) {
        c.a(iChatMessage, "replay", true);
        WebsiteDetailActivity.a(this.a, null, (WebsiteInfo) chatWebsiteCommentReplyMessageContent.getMessageContent().e, str, false);
    }
}
