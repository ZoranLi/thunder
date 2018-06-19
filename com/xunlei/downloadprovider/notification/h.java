package com.xunlei.downloadprovider.notification;

import android.app.NotificationManager;
import com.umeng.message.entity.UMessage;
import com.xunlei.downloadprovider.app.BrothersApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: PersonalChatNotification */
public final class h {
    private static List<Integer> a = new ArrayList();

    public static void a(Integer num) {
        int indexOf = a.indexOf(num);
        if (indexOf != -1) {
            a.remove(indexOf);
        }
        a.add(num);
        if (a.size() > 20) {
            num = (Integer) a.get(0);
            try {
                NotificationManager notificationManager = (NotificationManager) BrothersApplication.getApplicationInstance().getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
                if (notificationManager != null) {
                    new StringBuilder("cancelPersonalChatMessageNotification. notificationId: ").append(num);
                    notificationManager.cancel("single_chat_message", num.intValue());
                    b(num);
                }
            } catch (Integer num2) {
                num2.getLocalizedMessage();
            }
        }
    }

    public static void b(Integer num) {
        a.remove(num);
    }

    public static void a() {
        try {
            if (!a.isEmpty()) {
                NotificationManager notificationManager = (NotificationManager) BrothersApplication.getApplicationInstance().getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
                if (notificationManager != null) {
                    Iterator it = a.iterator();
                    while (it.hasNext()) {
                        notificationManager.cancel("single_chat_message", ((Integer) it.next()).intValue());
                        it.remove();
                    }
                }
            }
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
    }
}
