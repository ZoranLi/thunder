package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.a;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.b;
import org.json.JSONObject;

public class ChatTaskCommentReplyMessageContent extends BaseCommentReplyMessageContent<b> {
    public int customType() {
        return 2;
    }

    public String previewText() {
        return "下载任务评论回复";
    }

    public String reportType() {
        return "gcid_reply";
    }

    public ChatTaskCommentReplyMessageContent(IChatUser iChatUser, IChatUser iChatUser2, JSONObject jSONObject, String str) {
        super(iChatUser, iChatUser2, jSONObject, str);
        if (jSONObject == null) {
            jSONObject = null;
        } else {
            str = new b();
            a.a(str, jSONObject);
            jSONObject = str;
        }
        this.mCommentReplyInfo = jSONObject;
        setOriginalUser(iChatUser, iChatUser2);
    }

    public b getMessageContent() {
        return (b) this.mCommentReplyInfo;
    }

    public String reportContentId() {
        return getMessageContent().c;
    }
}
