package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.p;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.e;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.a;
import org.json.JSONObject;

public abstract class BaseCommentReplyMessageContent<T extends a> extends BaseChatCustomMessageContent<T> {
    protected T mCommentReplyInfo = null;

    public abstract String reportContentId();

    public BaseCommentReplyMessageContent(IChatUser iChatUser, IChatUser iChatUser2, JSONObject jSONObject, String str) {
        super(jSONObject, str);
    }

    public T getMessageContent() {
        return this.mCommentReplyInfo;
    }

    public IChatMessageContent.a checkMyself() {
        return new IChatMessageContent.a(this.mCommentReplyInfo != null, this.mCommentReplyInfo != null ? "" : "消息体不能为空");
    }

    protected void setOriginalUser(IChatUser iChatUser, IChatUser iChatUser2) {
        if (this.mCommentReplyInfo != null) {
            if (e.a(iChatUser) == null) {
                iChatUser2 = ((com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a) p.a(com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a.class)).a;
            }
            this.mCommentReplyInfo.f = iChatUser2;
        }
    }
}
