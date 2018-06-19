package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.q;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.s;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.c.g;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.d;

public class ChatMessage implements IChatMessage {
    private static final String TAG = "chat.ChatMessage";
    private IChatDialog mChatDialog = null;
    private int mCreateAt;
    private int mCreatorType = 0;
    private long mLocalMessageId = 0;
    private IChatMessageContent mMessageContent = null;
    private long mMessageId = 0;
    private IChatUser mSender = null;
    private int mStatus = 0;

    public void delete(c<Void> cVar) {
    }

    public IChatDialog chatDialog() {
        return this.mChatDialog;
    }

    public long localMessageId() {
        return this.mLocalMessageId;
    }

    public long messageId() {
        return getValidMessageId(this);
    }

    private long getValidMessageId(IChatMessage iChatMessage) {
        if (d.a(iChatMessage) == null) {
            return this.mLocalMessageId;
        }
        return this.mMessageId;
    }

    public void sendTo(IChatDialog iChatDialog, c<IChatMessage> cVar) {
        int i = this.mStatus == 4 ? 1 : 0;
        this.mStatus = 1;
        setChatDialog(iChatDialog);
        if (i == 0) {
            s.a().a((IChatMessage) this);
        }
        q.a().execute(new g(com.xunlei.downloadprovider.personal.message.chat.chatengine.c.d.a(), iChatDialog.type(), new c(this, iChatDialog, cVar), iChatDialog.targetUser().userId(), this));
    }

    public IChatUser sender() {
        return this.mSender;
    }

    public int creatorType() {
        return this.mCreatorType;
    }

    public int createdAt() {
        return this.mCreateAt;
    }

    public IChatMessageContent messageContent() {
        return this.mMessageContent;
    }

    public int messageStatus() {
        return this.mStatus;
    }

    public void setMessageId(long j) {
        this.mMessageId = j;
    }

    public void setCreateAt(int i) {
        this.mCreateAt = i;
    }

    public void setCreatorType(int i) {
        this.mCreatorType = i;
    }

    public void setChatDialog(IChatDialog iChatDialog) {
        this.mChatDialog = iChatDialog;
    }

    public void setSender(IChatUser iChatUser) {
        this.mSender = iChatUser;
    }

    public void setMessageContent(IChatMessageContent iChatMessageContent) {
        this.mMessageContent = iChatMessageContent;
    }

    public void setLocalMessageId(long j) {
        this.mLocalMessageId = j;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public static boolean isServerMessage(IChatMessage iChatMessage) {
        return (iChatMessage == null || iChatMessage.creatorType() == 3 || iChatMessage.messageStatus() != 2) ? null : true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                ChatMessage chatMessage = (ChatMessage) obj;
                if (messageId() != chatMessage.messageId()) {
                    return false;
                }
                return this.mChatDialog.equals(chatMessage.mChatDialog);
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * this.mChatDialog.hashCode()) + ((int) (messageId() ^ (messageId() >>> 32)));
    }

    public int compareTo(@NonNull IChatMessage iChatMessage) {
        return createdAt() - iChatMessage.createdAt();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ChatMessage{mChatDialog.dialogId=");
        stringBuilder.append(this.mChatDialog.dialogId());
        stringBuilder.append(", mMessageId=");
        stringBuilder.append(this.mMessageId);
        stringBuilder.append(", mSender=");
        stringBuilder.append(this.mSender);
        stringBuilder.append(", mCreatorType=");
        stringBuilder.append(this.mCreatorType);
        stringBuilder.append(", mCreateAt=");
        stringBuilder.append(this.mCreateAt);
        stringBuilder.append(", mMessageContent=");
        stringBuilder.append(this.mMessageContent);
        stringBuilder.append(", mStatus=");
        stringBuilder.append(this.mStatus);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
