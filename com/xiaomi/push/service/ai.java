package com.xiaomi.push.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.xiaomi.channel.commonutils.string.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ai {
    private static Object a = new Object();
    private static Map<String, Queue<String>> b = new HashMap();

    public static boolean a(XMPushService xMPushService, String str, String str2) {
        synchronized (a) {
            SharedPreferences sharedPreferences = xMPushService.getSharedPreferences("push_message_ids", 0);
            Collection collection = (Queue) b.get(str);
            if (collection == null) {
                String[] split = sharedPreferences.getString(str, "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                Queue linkedList = new LinkedList();
                for (Object add : split) {
                    linkedList.add(add);
                }
                b.put(str, linkedList);
                collection = linkedList;
            }
            if (collection.contains(str2)) {
                return true;
            }
            collection.add(str2);
            if (collection.size() > 25) {
                collection.poll();
            }
            str2 = d.a(collection, Constants.ACCEPT_TIME_SEPARATOR_SP);
            Editor edit = sharedPreferences.edit();
            edit.putString(str, str2);
            edit.commit();
            return false;
        }
    }
}
