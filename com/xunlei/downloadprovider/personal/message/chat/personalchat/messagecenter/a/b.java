package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a;

/* compiled from: IMessageCenterItemInfo */
public interface b extends Comparable<b> {
    int getCategoryPriority();

    int getId();

    int getItemType();

    String getTitle();

    int getUnreadCount();
}
