package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.d;
import java.io.Serializable;
import java.util.List;

public interface IChatDialog extends b, d, Serializable {
    public static final int CHAT_USER_RELATION_ACQUAINTANCE = 3;
    public static final int CHAT_USER_RELATION_IGNORE = 1;
    public static final int CHAT_USER_RELATION_STRANGER = 2;
    public static final int DIALOG_STATUS_DELETE = 2;
    public static final int DIALOG_STATUS_NORMAL = 1;
    public static final int DIALOG_TYPE_GROUP = 2;
    public static final int DIALOG_TYPE_SINGLE_CHAT = 1;
    public static final int DIALOG_TYPE_UNKNOWN = -1;

    public static class a {
        public static boolean a(Integer num, IChatDialog iChatDialog) {
            if (iChatDialog == null) {
                return null;
            }
            switch (num.intValue()) {
                case 1:
                    break;
                case 2:
                    return com.xunlei.downloadprovider.personal.message.chat.chatengine.d.a.b(iChatDialog);
                case 3:
                    return com.xunlei.downloadprovider.personal.message.chat.chatengine.d.a.a(iChatDialog);
                default:
                    break;
            }
            return true;
        }
    }

    void clearUnreadCount();

    int dialogId();

    String draftMessage();

    String getAvatarUrl();

    void getMessage(long j, c<IChatMessage> cVar);

    String getTitle();

    int getUnreadCount();

    int getUserSize();

    boolean isBlocking();

    boolean isFollow();

    IChatMessage lastMessage();

    IChatMessage lastServerMessage();

    void listNextMessages(IChatMessage iChatMessage, int i, c<List<IChatMessage>> cVar);

    void listPreviousMessages(@Nullable IChatMessage iChatMessage, int i, c<List<IChatMessage>> cVar);

    boolean sendBefore();

    void setBlocking(boolean z);

    void setFollow(boolean z);

    void setSendBefore(boolean z);

    long syncTime();

    IChatUser targetUser();

    int type();

    void updateDraftMessage(String str);
}
