package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.string.d;
import com.xiaomi.mipush.sdk.c.a;
import com.xiaomi.xmpush.thrift.ai;
import com.xiaomi.xmpush.thrift.aj;
import com.xiaomi.xmpush.thrift.ak;
import com.xiaomi.xmpush.thrift.aq;
import com.xiaomi.xmpush.thrift.ar;
import com.xiaomi.xmpush.thrift.au;
import com.xiaomi.xmpush.thrift.r;
import com.xiaomi.xmpush.thrift.w;
import com.xiaomi.xmpush.thrift.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiPushClient4Hybrid {
    private static Map<String, a> a = new HashMap();
    private static Map<String, Long> b = new HashMap();
    private static MiPushClientCallbackV2 c;

    private static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder stringBuilder = new StringBuilder("last_pull_notification_");
        stringBuilder.append(str);
        sharedPreferences.edit().putLong(stringBuilder.toString(), System.currentTimeMillis()).commit();
    }

    public static void ackPassThroughMsg(Context context, MiPushMessage miPushMessage) {
        if (miPushMessage != null) {
            if (miPushMessage.getExtra() != null) {
                try {
                    org.apache.thrift.a zVar = new z();
                    String str = (String) miPushMessage.getExtra().get(Constants.EXTRA_KEY_MINA_APPID);
                    zVar.b(str);
                    zVar.a(miPushMessage.getMessageId());
                    zVar.a(Long.valueOf((String) miPushMessage.getExtra().get(Constants.EXTRA_KEY_MINA_MESSAGE_TS)).longValue());
                    zVar.a(Short.valueOf((String) miPushMessage.getExtra().get(Constants.EXTRA_KEY_MINA_DEVICE_STATUS)).shortValue());
                    if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
                        zVar.c(miPushMessage.getTopic());
                    }
                    ac.a(context).a(zVar, com.xiaomi.xmpush.thrift.a.f, false, null);
                    StringBuilder stringBuilder = new StringBuilder("MiPushClient4Hybrid ack mina pass through message, appId is :");
                    stringBuilder.append(str);
                    stringBuilder.append(", messageId is ");
                    stringBuilder.append(miPushMessage.getMessageId());
                    b.b(stringBuilder.toString());
                    miPushMessage.getExtra().remove(Constants.EXTRA_KEY_MINA_APPID);
                    miPushMessage.getExtra().remove(Constants.EXTRA_KEY_MINA_MESSAGE_TS);
                    miPushMessage.getExtra().remove(Constants.EXTRA_KEY_MINA_DEVICE_STATUS);
                    return;
                } catch (Throwable th) {
                    miPushMessage.getExtra().remove(Constants.EXTRA_KEY_MINA_APPID);
                    miPushMessage.getExtra().remove(Constants.EXTRA_KEY_MINA_MESSAGE_TS);
                    miPushMessage.getExtra().remove(Constants.EXTRA_KEY_MINA_DEVICE_STATUS);
                }
            }
        }
        b.a("do not ack pass through message, message is null");
    }

    private static boolean b(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder stringBuilder = new StringBuilder("last_pull_notification_");
        stringBuilder.append(str);
        return Math.abs(System.currentTimeMillis() - sharedPreferences.getLong(stringBuilder.toString(), -1)) > 300000;
    }

    public static void onNotificationMessageArrived(Context context, String str, MiPushMessage miPushMessage) {
        if (!(TextUtils.isEmpty(str) || c == null)) {
            c.onNotificationMessageArrived(str, miPushMessage);
        }
    }

    public static void onNotificationMessageClicked(Context context, String str, MiPushMessage miPushMessage) {
        if (!(TextUtils.isEmpty(str) || c == null)) {
            c.onNotificationMessageClicked(str, miPushMessage);
        }
    }

    public static void onReceivePassThroughMessage(Context context, String str, MiPushMessage miPushMessage) {
        if (!(TextUtils.isEmpty(str) || c == null)) {
            c.onReceivePassThroughMessage(str, miPushMessage);
        }
    }

    public static void onReceiveRegisterResult(Context context, ak akVar) {
        String k = akVar.k();
        if (akVar.f() == 0) {
            a aVar = (a) a.get(k);
            if (aVar != null) {
                aVar.b(akVar.h, akVar.i);
                c.a(context).a(k, aVar);
            }
        }
        List list = null;
        if (!TextUtils.isEmpty(akVar.h)) {
            list = new ArrayList();
            list.add(akVar.h);
        }
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage("register", list, akVar.f, akVar.g, null);
        if (c != null) {
            c.onReceiveRegisterResult(k, generateCommandMessage);
        }
    }

    public static void onReceiveUnregisterResult(Context context, ar arVar) {
        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(MiPushClient.COMMAND_UNREGISTER, null, arVar.f, arVar.g, null);
        String h = arVar.h();
        if (c != null) {
            c.onReceiveUnregisterResult(h, generateCommandMessage);
        }
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        if (c.a(context).b(str2, str3, str)) {
            List arrayList = new ArrayList();
            a b = c.a(context).b(str);
            if (b != null) {
                arrayList.add(b.c);
                MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage("register", arrayList, 0, null, null);
                if (c != null) {
                    c.onReceiveRegisterResult(str, generateCommandMessage);
                }
            }
            if (b(context, str)) {
                org.apache.thrift.a aiVar = new ai();
                aiVar.b(str2);
                aiVar.c(r.j.W);
                aiVar.a(MiPushClient.generatePacketID());
                aiVar.a(false);
                ac.a(context).a(aiVar, com.xiaomi.xmpush.thrift.a.i, false, true, null, false, str, str2);
                b.b("MiPushClient4Hybrid pull offline pass through message");
                a(context, str);
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - (b.get(str) != null ? ((Long) b.get(str)).longValue() : 0)) < 5000) {
            b.a("MiPushClient4Hybrid  Could not send register message within 5s repeatedly.");
            return;
        }
        b.put(str, Long.valueOf(currentTimeMillis));
        String a = d.a(6);
        a aVar = new a(context);
        aVar.b(str2, str3, a);
        a.put(str, aVar);
        aiVar = new aj();
        aiVar.a(MiPushClient.generatePacketID());
        aiVar.b(str2);
        aiVar.e(str3);
        aiVar.d(str);
        aiVar.f(a);
        aiVar.c(com.xiaomi.channel.commonutils.android.a.a(context, context.getPackageName()));
        aiVar.b(com.xiaomi.channel.commonutils.android.a.b(context, context.getPackageName()));
        aiVar.g("3_5_1");
        aiVar.a(30501);
        aiVar.h(com.xiaomi.channel.commonutils.android.d.b(context));
        aiVar.a(w.c);
        str = com.xiaomi.channel.commonutils.android.d.d(context);
        if (!TextUtils.isEmpty(str)) {
            if (f.b()) {
                aiVar.i(str);
            }
            aiVar.k(d.a(str));
        }
        aiVar.j(com.xiaomi.channel.commonutils.android.d.a());
        int b2 = com.xiaomi.channel.commonutils.android.d.b();
        if (b2 >= 0) {
            aiVar.c(b2);
        }
        org.apache.thrift.a aiVar2 = new ai();
        aiVar2.c(r.Q.W);
        aiVar2.b(c.a(context).c());
        aiVar2.d(context.getPackageName());
        aiVar2.a(au.a(aiVar));
        aiVar2.a(MiPushClient.generatePacketID());
        ac.a(context).a(aiVar2, com.xiaomi.xmpush.thrift.a.i, null);
    }

    public static void removeDuplicateCache(Context context, MiPushMessage miPushMessage) {
        String str = miPushMessage.getExtra() != null ? (String) miPushMessage.getExtra().get("jobkey") : null;
        if (TextUtils.isEmpty(str)) {
            str = miPushMessage.getMessageId();
        }
        aa.a(context, str);
    }

    public static void setCallback(MiPushClientCallbackV2 miPushClientCallbackV2) {
        c = miPushClientCallbackV2;
    }

    public static void unregisterPush(Context context, String str) {
        a b = c.a(context).b(str);
        if (b != null) {
            org.apache.thrift.a aqVar = new aq();
            aqVar.a(MiPushClient.generatePacketID());
            aqVar.d(str);
            aqVar.b(b.a);
            aqVar.c(b.c);
            aqVar.e(b.b);
            org.apache.thrift.a aiVar = new ai();
            aiVar.c(r.S.W);
            aiVar.b(c.a(context).c());
            aiVar.d(context.getPackageName());
            aiVar.a(au.a(aqVar));
            aiVar.a(MiPushClient.generatePacketID());
            ac.a(context).a(aiVar, com.xiaomi.xmpush.thrift.a.i, null);
            c.a(context).c(str);
            MIPushNotificationHelper4Hybrid.clearNotification(context, str);
        }
    }
}
