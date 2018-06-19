package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import com.xunlei.downloadprovider.personal.message.chat.c;
import java.io.Serializable;

public interface IChatMessage extends Serializable, Comparable<IChatMessage> {
    public static final int CREATOR_TYPE_LOCAL_SYSTEM = 3;
    public static final int CREATOR_TYPE_SERVER_SYSTEM = 2;
    public static final int CREATOR_TYPE_UNKNOWN = 0;
    public static final int CREATOR_TYPE_USER = 1;
    public static final int MESSAGE_STATUS_BLOCK = 5;
    public static final int MESSAGE_STATUS_DELETED = 3;
    public static final int MESSAGE_STATUS_FAILED = 4;
    public static final int MESSAGE_STATUS_SENDING = 1;
    public static final int MESSAGE_STATUS_SENT = 2;
    public static final int MESSAGE_STATUS_UNKNOWN = 0;

    IChatDialog chatDialog();

    int createdAt();

    int creatorType();

    void delete(c<Void> cVar);

    long localMessageId();

    IChatMessageContent messageContent();

    long messageId();

    int messageStatus();

    void sendTo(IChatDialog iChatDialog, c<IChatMessage> cVar);

    IChatUser sender();
}
