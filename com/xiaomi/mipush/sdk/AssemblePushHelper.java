package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.push.PushReceiver.BOUND_KEY;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.network.d;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AssemblePushHelper {
    private static boolean a = false;

    protected static synchronized String a(Context context) {
        String string;
        synchronized (AssemblePushHelper.class) {
            string = context.getSharedPreferences("mipush_extra", 0).getString("hms_push_token", "");
        }
        return string;
    }

    private static synchronized void a(Context context, String str) {
        synchronized (AssemblePushHelper.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putString("hms_push_token", str).commit();
        }
    }

    private static PushMessageReceiver b(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                    if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName.equals(context.getPackageName())) {
                        break;
                    }
                }
            }
            ResolveInfo resolveInfo2 = null;
            return resolveInfo2 != null ? (PushMessageReceiver) Class.forName(resolveInfo2.activityInfo.name).newInstance() : null;
        } catch (Exception e) {
            b.d(e.toString());
            return null;
        }
    }

    public static void convertMessage(Intent intent) {
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey(BOUND_KEY.pushMsgKey)) {
                intent.putExtra(PushMessageHelper.KEY_MESSAGE, d.a(extras.getString(BOUND_KEY.pushMsgKey)));
            }
        }
    }

    public static boolean hasNetwork(Context context) {
        return d.c(context);
    }

    public static boolean isHmsTokenSynced(Context context) {
        CharSequence a = a(context);
        CharSequence a2 = u.a(context).a(aj.UPLOAD_TOKEN);
        return (TextUtils.isEmpty(a) || TextUtils.isEmpty(a2) || !"synced".equals(a2)) ? false : true;
    }

    public static boolean needConnect() {
        return a;
    }

    public static void notifyHmsNotificationMessageClicked(Context context, String str) {
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject.has(BOUND_KEY.pushMsgKey)) {
                            str = jSONObject.getString(BOUND_KEY.pushMsgKey);
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                b.d(e.toString());
            }
        }
        str = str2;
        PushMessageReceiver b = b(context);
        if (b != null) {
            b.onNotificationMessageClicked(context, d.a(str));
        }
    }

    public static void notifyHmsPassThoughMessageArrived(Context context, String str) {
        String str2 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("content")) {
                    str2 = jSONObject.getString("content");
                }
            }
        } catch (Exception e) {
            b.d(e.toString());
        }
        PushMessageReceiver b = b(context);
        if (b != null) {
            b.onReceivePassThroughMessage(context, d.a(str2));
        }
    }

    public static void reportError(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder("error code = ");
        stringBuilder.append(i);
        MiTinyDataClient.upload("hms_push_error", str, 1, stringBuilder.toString());
    }

    public static synchronized void setConnectTime(Context context) {
        synchronized (AssemblePushHelper.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_connect_time", System.currentTimeMillis()).commit();
        }
    }

    public static synchronized void setGetTokenTime(Context context) {
        synchronized (AssemblePushHelper.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_get_token_time", System.currentTimeMillis()).commit();
        }
    }

    public static void setNeedConnect(boolean z) {
        a = z;
    }

    public static synchronized boolean shouldGetToken(Context context) {
        synchronized (AssemblePushHelper.class) {
            if (Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_get_token_time", -1)) > 172800000) {
                return true;
            }
            return false;
        }
    }

    public static synchronized boolean shouldTryConnect(Context context) {
        synchronized (AssemblePushHelper.class) {
            if (Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_connect_time", -1)) > 5000) {
                return true;
            }
            return false;
        }
    }

    public static void uploadToken(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence string = context.getSharedPreferences("mipush_extra", 0).getString("hms_push_token", "");
            if (TextUtils.isEmpty(string) || !str.equals(string)) {
                a(context, str);
                ac.a(context).c();
            }
        }
    }
}
