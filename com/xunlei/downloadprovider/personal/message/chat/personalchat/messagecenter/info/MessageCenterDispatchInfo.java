package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.info;

import android.content.Intent;
import java.io.Serializable;

public class MessageCenterDispatchInfo implements Serializable {
    private int mChatDialogId;
    private String mFrom;
    private int mTo;

    public MessageCenterDispatchInfo(String str, int i) {
        this.mFrom = str;
        this.mTo = i;
    }

    public MessageCenterDispatchInfo(String str, int i, int i2) {
        this.mFrom = str;
        this.mTo = i;
        this.mChatDialogId = i2;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void setTo(int i) {
        this.mTo = i;
    }

    public void setChatDialogId(int i) {
        this.mChatDialogId = i;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public int getTo() {
        return this.mTo;
    }

    public int getChatDialogId() {
        return this.mChatDialogId;
    }

    public void buildIntent(Intent intent) {
        intent.putExtra("message_center_dispatch_info", this);
    }
}
