package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.a.a;

import android.content.Context;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.BaseCommentReplyMessageContent;

/* compiled from: BaseCommentReplyMessageController */
public abstract class a<MESSAGE_CONTENT extends BaseCommentReplyMessageContent> {
    protected Context a = null;

    public abstract void a(IChatMessage iChatMessage, MESSAGE_CONTENT message_content);

    public abstract void b(IChatMessage iChatMessage, MESSAGE_CONTENT message_content);

    public a(Context context) {
        this.a = context;
    }
}
