package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a.a;

import android.content.Context;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.BaseCommentReplyMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.ChatVideoCommentReplyMessageContent;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.a;

/* compiled from: VideoCommentReplyMessageController */
public final class c extends a<ChatVideoCommentReplyMessageContent> {
    public final /* bridge */ /* synthetic */ void a(IChatMessage iChatMessage, BaseCommentReplyMessageContent baseCommentReplyMessageContent) {
        a(iChatMessage, (ChatVideoCommentReplyMessageContent) baseCommentReplyMessageContent, From.PERSONAL_CHAT_COMMENT_REPLY_MESSAGE_REPLY);
    }

    public final /* synthetic */ void b(IChatMessage iChatMessage, BaseCommentReplyMessageContent baseCommentReplyMessageContent) {
        a(iChatMessage, (ChatVideoCommentReplyMessageContent) baseCommentReplyMessageContent, From.PERSONAL_CHAT_COMMENT_REPLY_MESSAGE_RESOURCE);
    }

    public c(Context context) {
        super(context);
    }

    private void a(IChatMessage iChatMessage, ChatVideoCommentReplyMessageContent chatVideoCommentReplyMessageContent, From from) {
        com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.c cVar = (com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.c) chatVideoCommentReplyMessageContent.getMessageContent();
        a aVar = new a();
        aVar.u = from;
        aVar.a = cVar.d;
        aVar.s = true;
        aVar.b = cVar.c;
        com.xunlei.downloadprovider.personal.message.chat.personalchat.c.a(iChatMessage, "replay", true);
        ShortMovieDetailActivity.a(this.a, aVar);
    }
}
