package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.a;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.c;
import org.json.JSONObject;

public class ChatVideoCommentReplyMessageContent extends BaseCommentReplyMessageContent<c> {
    public int customType() {
        return 1;
    }

    public String previewText() {
        return "视频评论回复";
    }

    public String reportType() {
        return "shortvideo_reply";
    }

    public ChatVideoCommentReplyMessageContent(IChatUser iChatUser, IChatUser iChatUser2, JSONObject jSONObject, String str) {
        super(iChatUser, iChatUser2, jSONObject, str);
        str = null;
        if (jSONObject != null) {
            Object obj;
            a cVar = new c();
            a.a(cVar, jSONObject);
            jSONObject = jSONObject.optJSONObject("resource");
            if (jSONObject == null) {
                obj = null;
            } else {
                obj = new c.a(jSONObject.optString("cover_url"), jSONObject.optString("title"));
            }
            if (obj != null) {
                cVar.e = obj;
                str = cVar;
            }
        }
        this.mCommentReplyInfo = str;
        setOriginalUser(iChatUser, iChatUser2);
    }

    public String reportContentId() {
        return ((c) getMessageContent()).d;
    }
}
