package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info.custommessagecontent;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessageContent.IChatCustomMessageContent;
import org.json.JSONObject;

public abstract class BaseChatCustomMessageContent<T> implements IChatCustomMessageContent<T> {
    protected String contentText = null;

    public int type() {
        return 3;
    }

    public BaseChatCustomMessageContent(JSONObject jSONObject, String str) {
        this.contentText = str;
    }

    public String content() {
        return this.contentText;
    }
}
