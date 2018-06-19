package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.d;
import org.json.JSONObject;

public class ChatWebsiteCommentReplyMessageContent extends BaseCommentReplyMessageContent<d> {
    public int customType() {
        return 3;
    }

    public String previewText() {
        return "站点评论回复";
    }

    public String reportType() {
        return "link_reply";
    }

    public ChatWebsiteCommentReplyMessageContent(IChatUser iChatUser, IChatUser iChatUser2, JSONObject jSONObject, String str) {
        super(iChatUser, iChatUser2, jSONObject, str);
        this.mCommentReplyInfo = d.a(jSONObject);
        setOriginalUser(iChatUser, iChatUser2);
    }

    public d getMessageContent() {
        return (d) this.mCommentReplyInfo;
    }

    public String reportContentId() {
        return getMessageContent().d;
    }
}
