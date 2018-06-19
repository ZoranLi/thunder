package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a;

import com.xunlei.downloadprovider.R;

/* compiled from: MessageCenterFollowItemInfo */
public final class j extends a {
    public int a = 0;

    public final int getCategoryPriority() {
        return 1000;
    }

    public final int getId() {
        return 0;
    }

    public final int getItemType() {
        return 4;
    }

    public final String getTitle() {
        return "粉丝";
    }

    public final int getUnreadCount() {
        return this.a;
    }

    public static Integer a() {
        return Integer.valueOf(R.drawable.icon_message_center_follow);
    }
}
