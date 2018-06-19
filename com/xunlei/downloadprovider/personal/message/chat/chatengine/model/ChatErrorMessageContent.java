package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;

public class ChatErrorMessageContent extends ChatTextMessageContent {
    public ChatErrorMessageContent() {
        super(BrothersApplication.getApplicationInstance().getString(R.string.personal_chat_dialog_message_error));
    }
}
