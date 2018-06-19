package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;

public class ChatNonsupportMessageContent extends ChatTextMessageContent {
    public ChatNonsupportMessageContent() {
        super(BrothersApplication.getApplicationInstance().getString(R.string.personal_chat_dialog_message_nonsupport));
    }
}
