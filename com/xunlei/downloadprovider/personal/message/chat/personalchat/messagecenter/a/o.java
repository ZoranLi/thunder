package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a;

import com.xunlei.downloadprovider.R;

/* compiled from: MessageCenterVisitItemInfo */
public final class o extends a {
    public int a = 0;
    public int b = 0;

    public final int getCategoryPriority() {
        return 1003;
    }

    public final int getId() {
        return 0;
    }

    public final int getItemType() {
        return 5;
    }

    public final String getTitle() {
        return "谁看过我";
    }

    public final int getUnreadCount() {
        return this.a;
    }

    public static Integer a() {
        return Integer.valueOf(R.drawable.icon_message_center_visit);
    }
}
