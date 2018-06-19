package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessageContent.IChatCustomMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.d;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.ChatVideoCommentReplyMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent.ChatWebsiteCommentReplyMessageContent;
import org.json.JSONObject;

/* compiled from: ChatCustomMessageParser */
public final class a extends com.xunlei.downloadprovider.personal.message.chat.chatengine.model.a {
    protected final IChatMessageContent a(IChatUser iChatUser, IChatUser iChatUser2, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("type");
            jSONObject = jSONObject.optJSONObject("data");
            if (jSONObject != null) {
                switch (optInt) {
                    case 1:
                        return new ChatVideoCommentReplyMessageContent(iChatUser, iChatUser2, jSONObject, str);
                    case 2:
                        return d.b();
                    case 3:
                        return new ChatWebsiteCommentReplyMessageContent(iChatUser, iChatUser2, jSONObject, str);
                    default:
                        return d.b();
                }
            }
        } catch (IChatUser iChatUser3) {
            iChatUser3.printStackTrace();
        }
        return d.c();
    }

    public final boolean a(IChatCustomMessageContent iChatCustomMessageContent) {
        return iChatCustomMessageContent.customType() != 1 ? null : true;
    }
}
