package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.a;

import com.xunlei.downloadprovider.personal.message.chat.chatkit.utils.DateFormatter;
import java.util.Calendar;
import java.util.Date;

/* compiled from: PersonalChatDateFormatter */
public final class a implements com.xunlei.downloadprovider.personal.message.chat.chatkit.utils.DateFormatter.a {
    public final String a(Date date) {
        if (DateFormatter.a(date)) {
            return DateFormatter.a(date, "HH:mm");
        }
        if (DateFormatter.b(date)) {
            return DateFormatter.a(date, "MM-dd");
        }
        return DateFormatter.a(date, "yyyy-MM-dd");
    }

    public final String b(Date date) {
        if (DateFormatter.a(date)) {
            return DateFormatter.a(date, "HH:mm");
        }
        Calendar instance = Calendar.getInstance();
        instance.add(5, -1);
        if (DateFormatter.a(date, instance.getTime())) {
            StringBuilder stringBuilder = new StringBuilder("昨天");
            stringBuilder.append(DateFormatter.a(date, "HH:mm"));
            return stringBuilder.toString();
        } else if (DateFormatter.b(date)) {
            return DateFormatter.a(date, "MM-dd HH:mm");
        } else {
            return DateFormatter.a(date, "yyyy-MM-dd HH:mm");
        }
    }
}
