package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import com.taobao.accs.AccsClientConfig;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessageContent.IChatTextMessageContent;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessageContent.a;

public class ChatTextMessageContent implements IChatTextMessageContent {
    private static final int TEXT_LENGTH_MAX = 1000;
    private static final int TEXT_LENGTH_MIN = 1;
    private String mText = "";

    public String reportType() {
        return AccsClientConfig.DEFAULT_CONFIGTAG;
    }

    public int type() {
        return 1;
    }

    public ChatTextMessageContent(String str) {
        this.mText = str.trim();
    }

    public String previewText() {
        return this.mText;
    }

    public String content() {
        return this.mText;
    }

    public a checkMyself() {
        a aVar = new a();
        if (text().length() <= 0) {
            aVar.a = false;
            aVar.b = BrothersApplication.getApplicationInstance().getString(R.string.personal_chat_dialog_message_empty);
        } else if (text().length() > 1000) {
            aVar.a = false;
            aVar.b = BrothersApplication.getApplicationInstance().getString(R.string.personal_chat_dialog_message_over_length);
        } else {
            aVar.a = true;
        }
        return aVar;
    }

    public String text() {
        return this.mText;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ChatTextMessageContent{mText='");
        stringBuilder.append(this.mText);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
