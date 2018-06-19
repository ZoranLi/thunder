package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.b;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a.d;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.q;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.s;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.a;
import java.util.ArrayList;
import java.util.List;

public class SingleChatDialog extends a implements IChatDialog {
    private static final String TAG = "chat.SingleChatDialog";
    private int dialogId = 0;
    private String draftMessage = "";
    private boolean isBlocking = false;
    private boolean isFollow = false;
    private IChatMessage mLastMessage = null;
    private IChatMessage mLastServerMessage = null;
    private long mSyncTime;
    private boolean sendBefore = false;
    private IChatUser targetUser;
    private int unreadCount = 0;

    public int getCategoryPriority() {
        return 100;
    }

    public int getItemType() {
        return 100;
    }

    public void getMessage(long j, c<IChatMessage> cVar) {
    }

    public int getUserSize() {
        return 2;
    }

    public int type() {
        return 1;
    }

    public SingleChatDialog(int i) {
        this.dialogId = i;
    }

    public int getId() {
        return this.dialogId;
    }

    public int getUpdateTime() {
        return lastMessage() != null ? lastMessage().createdAt() : 0;
    }

    public int getDialogId() {
        return this.dialogId;
    }

    public void setDialogId(int i) {
        this.dialogId = i;
    }

    public boolean isBlocking() {
        return this.isBlocking;
    }

    public void setBlocking(boolean z) {
        this.isBlocking = z;
    }

    public boolean isFollow() {
        return this.isFollow;
    }

    public boolean sendBefore() {
        return this.sendBefore;
    }

    public void setSendBefore(boolean z) {
        this.sendBefore = z;
    }

    public void setFollow(boolean z) {
        this.isFollow = z;
    }

    public void setTargetUser(IChatUser iChatUser) {
        this.targetUser = iChatUser;
    }

    public int dialogId() {
        return this.dialogId;
    }

    public String getTitle() {
        return this.targetUser.nickname();
    }

    public String getDesc() {
        return this.mLastMessage.messageContent().previewText();
    }

    public String getAvatarUrl() {
        return this.targetUser.avatarUrl();
    }

    public IChatMessage lastMessage() {
        return this.mLastMessage;
    }

    public IChatMessage lastServerMessage() {
        return this.mLastServerMessage;
    }

    public long syncTime() {
        return this.mSyncTime;
    }

    public int getUnreadCount() {
        return this.unreadCount;
    }

    public void clearUnreadCount() {
        this.unreadCount = 0;
        q.a().execute(new d(b.a(), this));
        com.xunlei.downloadprovider.personal.message.chat.chatengine.b.b.a();
        com.xunlei.downloadprovider.personal.message.chat.chatengine.b.b.b((IChatDialog) this, new q.a());
    }

    public String draftMessage() {
        return this.draftMessage;
    }

    public void updateDraftMessage(String str) {
        this.draftMessage = str;
    }

    public IChatUser targetUser() {
        return this.targetUser;
    }

    public void listPreviousMessages(@Nullable IChatMessage iChatMessage, int i, c<List<IChatMessage>> cVar) {
        i iVar = new i();
        if (iChatMessage != null) {
            iVar.c = iChatMessage.createdAt();
        }
        iVar.e = i;
        s.a().a(this, iVar, new j(this, iChatMessage, i, cVar));
    }

    private void mergeServerAndLocalPreviousChatMessages(@Nullable IChatMessage iChatMessage, int i, @NonNull IChatDialog iChatDialog, @NonNull List<IChatMessage> list, c<List<IChatMessage>> cVar) {
        q.a().execute(new k(this, new ArrayList(list), iChatMessage, i, iChatDialog, cVar));
    }

    public void listNextMessages(IChatMessage iChatMessage, int i, c<List<IChatMessage>> cVar) {
        i iVar = new i();
        if (iChatMessage != null) {
            iVar.b = iChatMessage.createdAt();
        }
        iVar.e = i;
        s.a().a(this, iVar, new n(this, cVar));
    }

    public void setUnreadCount(int i) {
        this.unreadCount = i;
    }

    public void increaseUnreadCount(int i) {
        this.unreadCount += i;
    }

    public void decreaseUnreadCount(int i) {
        this.unreadCount -= i;
    }

    private void setLastMessage(IChatMessage iChatMessage) {
        this.mLastMessage = iChatMessage;
    }

    private void setLastServerMessage(IChatMessage iChatMessage) {
        this.mLastServerMessage = iChatMessage;
    }

    public void tryUpdateAllLastMessage(IChatMessage iChatMessage) {
        tryUpdateLastMessage(iChatMessage);
        tryUpdateLastServerMessage(iChatMessage);
    }

    public void tryUpdateLastMessage(IChatMessage iChatMessage) {
        if (iChatMessage != null) {
            if (lastMessage() == null || iChatMessage.createdAt() > lastMessage().createdAt()) {
                setLastMessage(iChatMessage);
            }
        }
    }

    public void tryUpdateLastServerMessage(IChatMessage iChatMessage) {
        if (iChatMessage != null && com.xunlei.downloadprovider.personal.message.chat.chatengine.d.d.a(iChatMessage)) {
            if (lastServerMessage() == null || iChatMessage.createdAt() > lastServerMessage().createdAt()) {
                setLastServerMessage(iChatMessage);
            }
        }
    }

    public void setSyncTime(long j) {
        this.mSyncTime = j;
    }

    public int compareTo(@Nullable com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b bVar) {
        int compareTo = super.compareTo(bVar);
        if (compareTo != 0) {
            return compareTo;
        }
        if (bVar instanceof com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.d) {
            return ((com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.d) bVar).getUpdateTime() - getUpdateTime();
        }
        return 1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SingleChatDialog{dialogId=");
        stringBuilder.append(this.dialogId);
        stringBuilder.append(", isBlocking=");
        stringBuilder.append(this.isBlocking);
        stringBuilder.append(", isFollow=");
        stringBuilder.append(this.isFollow);
        stringBuilder.append(", sendBefore=");
        stringBuilder.append(this.sendBefore);
        stringBuilder.append(", targetUser=");
        stringBuilder.append(this.targetUser);
        stringBuilder.append(", unreadCount=");
        stringBuilder.append(this.unreadCount);
        stringBuilder.append(", draftMessage='");
        stringBuilder.append(this.draftMessage);
        stringBuilder.append('\'');
        stringBuilder.append(", lastMessage=");
        stringBuilder.append(this.mLastMessage);
        stringBuilder.append(", lastServerMessage=");
        stringBuilder.append(this.mLastServerMessage);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
