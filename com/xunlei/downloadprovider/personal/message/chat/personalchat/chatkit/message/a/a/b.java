package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a.a;

import android.content.Context;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.a;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.c;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.BaseCommentReplyMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.ChatTaskCommentReplyMessageContent;

/* compiled from: TaskCommentReplyMessageController */
public final class b extends a<ChatTaskCommentReplyMessageContent> {
    public final /* bridge */ /* synthetic */ void a(IChatMessage iChatMessage, BaseCommentReplyMessageContent baseCommentReplyMessageContent) {
        a(iChatMessage, (ChatTaskCommentReplyMessageContent) baseCommentReplyMessageContent, "personal_chat_reply");
    }

    public final /* synthetic */ void b(IChatMessage iChatMessage, BaseCommentReplyMessageContent baseCommentReplyMessageContent) {
        a(iChatMessage, (ChatTaskCommentReplyMessageContent) baseCommentReplyMessageContent, "personal_chat_gcid");
    }

    public b(Context context) {
        super(context);
    }

    private void a(IChatMessage iChatMessage, ChatTaskCommentReplyMessageContent chatTaskCommentReplyMessageContent, String str) {
        n.a();
        long f = n.f(chatTaskCommentReplyMessageContent.getMessageContent().c);
        if (f == -1) {
            c.a(iChatMessage, "replay", (boolean) null);
            XLToast.showToast(this.a, this.a.getString(R.string.personal_chat_comment_reply_message_task_deleted));
            return;
        }
        c.a(iChatMessage, "replay", true);
        a.a();
        a.b(this.a, f, str);
    }
}
