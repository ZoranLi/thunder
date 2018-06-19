package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.am;
import com.xiaomi.xmpush.thrift.g;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class d {
    public static MiPushMessage a(String str) {
        MiPushMessage miPushMessage = new MiPushMessage();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(PushResult.MSG_ID)) {
                    miPushMessage.setMessageId(jSONObject.getString(PushResult.MSG_ID));
                }
                if (jSONObject.has("description")) {
                    miPushMessage.setDescription(jSONObject.getString("description"));
                }
                if (jSONObject.has("title")) {
                    miPushMessage.setTitle(jSONObject.getString("title"));
                }
                if (jSONObject.has("content")) {
                    miPushMessage.setContent(jSONObject.getString("content"));
                }
                if (jSONObject.has("passThrough")) {
                    miPushMessage.setPassThrough(jSONObject.getInt("passThrough"));
                }
                if (jSONObject.has("notifyType")) {
                    miPushMessage.setNotifyType(jSONObject.getInt("notifyType"));
                }
                if (jSONObject.has("messageType")) {
                    miPushMessage.setMessageType(jSONObject.getInt("messageType"));
                }
                if (jSONObject.has("alias")) {
                    miPushMessage.setAlias(jSONObject.getString("alias"));
                }
                if (jSONObject.has("topic")) {
                    miPushMessage.setTopic(jSONObject.getString("topic"));
                }
                if (jSONObject.has("user_account")) {
                    miPushMessage.setUserAccount(jSONObject.getString("user_account"));
                }
                if (jSONObject.has("notifyId")) {
                    miPushMessage.setNotifyId(jSONObject.getInt("notifyId"));
                }
                if (jSONObject.has("category")) {
                    miPushMessage.setCategory(jSONObject.getString("category"));
                }
                if (jSONObject.has("isNotified")) {
                    miPushMessage.setNotified(jSONObject.getBoolean("isNotified"));
                }
                if (jSONObject.has("extra")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("extra");
                    Iterator keys = jSONObject2.keys();
                    Map hashMap = new HashMap();
                    while (keys != null && keys.hasNext()) {
                        String str2 = (String) keys.next();
                        hashMap.put(str2, jSONObject2.getString(str2));
                    }
                    if (hashMap.size() > 0) {
                        miPushMessage.setExtra(hashMap);
                        return miPushMessage;
                    }
                }
            } catch (Exception e) {
                b.d(e.toString());
            }
        }
        return miPushMessage;
    }

    public static com.xiaomi.mipush.sdk.v a(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = r3.getPackageManager();	 Catch:{ Exception -> 0x001b }
        r0 = new android.content.ComponentName;	 Catch:{ Exception -> 0x001b }
        r1 = "com.huawei.hwid";	 Catch:{ Exception -> 0x001b }
        r2 = "com.huawei.hms.core.service.HMSCoreService";	 Catch:{ Exception -> 0x001b }
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x001b }
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Exception -> 0x001b }
        r3 = r3.getServiceInfo(r0, r1);	 Catch:{ Exception -> 0x001b }
        if (r3 == 0) goto L_0x0018;	 Catch:{ Exception -> 0x001b }
    L_0x0015:
        r3 = com.xiaomi.mipush.sdk.v.a;	 Catch:{ Exception -> 0x001b }
        return r3;
    L_0x0018:
        r3 = com.xiaomi.mipush.sdk.v.c;
        return r3;
    L_0x001b:
        r3 = com.xiaomi.mipush.sdk.v.c;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.d.a(android.content.Context):com.xiaomi.mipush.sdk.v");
    }

    public static boolean a() {
        return MiPushClient.getOpenHmsPush();
    }

    public static boolean b(Context context) {
        return am.a(context).a(g.AggregatePushSwitch.a(), true);
    }

    public static void c(Context context) {
        AbstractPushManager a = z.a(context);
        if (a != null) {
            a.register();
        }
    }

    public static void d(Context context) {
        AbstractPushManager a = z.a(context);
        if (a != null) {
            a.unregister();
        }
    }

    public static HashMap<String, String> e(Context context) {
        ApplicationInfo applicationInfo;
        HashMap<String, String> hashMap = new HashMap();
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (Exception e) {
            b.d(e.toString());
            applicationInfo = null;
        }
        int i = -1;
        if (applicationInfo != null) {
            i = applicationInfo.metaData.getInt(Constants.HUAWEI_HMS_CLIENT_APPID);
        }
        StringBuilder stringBuilder = new StringBuilder("brand:");
        stringBuilder.append(a(context).name());
        stringBuilder.append("~token:");
        stringBuilder.append(AssemblePushHelper.a(context));
        stringBuilder.append("~package_name:");
        stringBuilder.append(context.getPackageName());
        stringBuilder.append("~app_id:");
        stringBuilder.append(i);
        hashMap.put(Constants.ASSEMBLE_PUSH_REG_INFO, stringBuilder.toString());
        return hashMap;
    }
}
