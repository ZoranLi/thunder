package com.xiaomi.mipush.sdk;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.MiPushClient.MiPushClientCallback;
import com.xiaomi.xmpush.thrift.au;
import com.xiaomi.xmpush.thrift.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class PushMessageHandler extends IntentService {
    private static List<MiPushClientCallback> a = new ArrayList();

    interface a extends Serializable {
    }

    public PushMessageHandler() {
        super("mipush message handler");
    }

    protected static void a() {
        synchronized (a) {
            a.clear();
        }
    }

    public static void a(long j, String str, String str2) {
        synchronized (a) {
            for (MiPushClientCallback onInitializeResult : a) {
                onInitializeResult.onInitializeResult(j, str, str2);
            }
        }
    }

    public static void a(Context context, MiPushMessage miPushMessage) {
        synchronized (a) {
            for (MiPushClientCallback miPushClientCallback : a) {
                if (a(miPushMessage.getCategory(), miPushClientCallback.getCategory())) {
                    miPushClientCallback.onReceiveMessage(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                    miPushClientCallback.onReceiveMessage(miPushMessage);
                }
            }
        }
    }

    public static void a(Context context, a aVar) {
        if (aVar instanceof MiPushMessage) {
            a(context, (MiPushMessage) aVar);
            return;
        }
        if (aVar instanceof MiPushCommandMessage) {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) aVar;
            String command = miPushCommandMessage.getCommand();
            String str = null;
            if ("register".equals(command)) {
                List commandArguments = miPushCommandMessage.getCommandArguments();
                if (!(commandArguments == null || commandArguments.isEmpty())) {
                    str = (String) commandArguments.get(0);
                }
                a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                return;
            }
            if (!(MiPushClient.COMMAND_SET_ALIAS.equals(command) || MiPushClient.COMMAND_UNSET_ALIAS.equals(command))) {
                if (!MiPushClient.COMMAND_SET_ACCEPT_TIME.equals(command)) {
                    List commandArguments2;
                    Context context2;
                    if (MiPushClient.COMMAND_SUBSCRIBE_TOPIC.equals(command)) {
                        commandArguments2 = miPushCommandMessage.getCommandArguments();
                        if (!(commandArguments2 == null || commandArguments2.isEmpty())) {
                            str = (String) commandArguments2.get(0);
                        }
                        context2 = context;
                        a(context2, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                        return;
                    } else if (MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC.equals(command)) {
                        commandArguments2 = miPushCommandMessage.getCommandArguments();
                        if (!(commandArguments2 == null || commandArguments2.isEmpty())) {
                            str = (String) commandArguments2.get(0);
                        }
                        context2 = context;
                        b(context2, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
                        return;
                    }
                }
            }
            a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
        }
    }

    protected static void a(Context context, String str, long j, String str2, String str3) {
        synchronized (a) {
            for (MiPushClientCallback miPushClientCallback : a) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onSubscribeResult(j, str2, str3);
                }
            }
        }
    }

    protected static void a(Context context, String str, String str2, long j, String str3, List<String> list) {
        synchronized (a) {
            for (MiPushClientCallback miPushClientCallback : a) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onCommandResult(str2, j, str3, list);
                }
            }
        }
    }

    private void a(Intent intent, ResolveInfo resolveInfo) {
        try {
            MessageHandleService.addJob(new com.xiaomi.mipush.sdk.MessageHandleService.a(intent, (PushMessageReceiver) Class.forName(resolveInfo.activityInfo.name).newInstance()));
            MessageHandleService.a(this, new Intent(getApplicationContext(), MessageHandleService.class));
        } catch (Throwable th) {
            b.a(th);
        }
    }

    protected static void a(MiPushClientCallback miPushClientCallback) {
        synchronized (a) {
            if (!a.contains(miPushClientCallback)) {
                a.add(miPushClientCallback);
            }
        }
    }

    protected static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    protected static void b(Context context, String str, long j, String str2, String str3) {
        synchronized (a) {
            for (MiPushClientCallback miPushClientCallback : a) {
                if (a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onUnsubscribeResult(j, str2, str3);
                }
            }
        }
    }

    public static boolean b() {
        return a.isEmpty();
    }

    protected void onHandleIntent(Intent intent) {
        try {
            if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                if (c.a((Context) this).i()) {
                    ac.a((Context) this).a();
                    CharSequence stringExtra = intent.getStringExtra("waker_pkgname");
                    JSONObject jSONObject = new JSONObject();
                    if (TextUtils.isEmpty(stringExtra)) {
                        jSONObject.put("wakerPkgName", stringExtra);
                    }
                    jSONObject.put("selfPkgName", getPackageName());
                    MiTinyDataClient.upload(this, "system_running_log", "wake_up_app", 1, jSONObject.toString());
                }
            } else if ("com.xiaomi.mipush.SEND_TINYDATA".equals(intent.getAction())) {
                org.apache.thrift.a fVar = new f();
                au.a(fVar, intent.getByteArrayExtra("mipush_payload"));
                StringBuilder stringBuilder = new StringBuilder("PushMessageHandler.onHandleIntent ");
                stringBuilder.append(fVar.d());
                b.c(stringBuilder.toString());
                MiTinyDataClient.upload(this, fVar);
            } else if ("com.xiaomi.mipush.sdk.HYBRID_NOTIFICATION_CLICK".equals(intent.getAction())) {
                MiPushMessage miPushMessage = (MiPushMessage) intent.getSerializableExtra("mipush_payload");
                String stringExtra2 = intent.getStringExtra("mipush_hybrid_app_pkg");
                MiPushClient.reportMessageClicked(getApplicationContext(), miPushMessage);
                MiPushClient4Hybrid.onNotificationMessageClicked(getApplicationContext(), stringExtra2, miPushMessage);
            } else if (1 != PushMessageHelper.getPushMode(this)) {
                Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent2.setPackage(getPackageName());
                intent2.putExtras(intent);
                List<ResolveInfo> queryBroadcastReceivers = getPackageManager().queryBroadcastReceivers(intent2, 32);
                ResolveInfo resolveInfo = null;
                if (queryBroadcastReceivers != null) {
                    for (ResolveInfo resolveInfo2 : queryBroadcastReceivers) {
                        if (resolveInfo2.activityInfo != null && resolveInfo2.activityInfo.packageName.equals(getPackageName())) {
                            resolveInfo = resolveInfo2;
                            break;
                        }
                    }
                }
                if (resolveInfo != null) {
                    a(intent2, resolveInfo);
                } else {
                    b.d("cannot find the receiver to handler this message, check your manifest");
                }
            } else if (b()) {
                b.d("receive a message before application calling initialize");
            } else {
                a a = aa.a(this).a(intent);
                if (a != null) {
                    a((Context) this, a);
                }
            }
        } catch (Throwable e) {
            b.a(e);
        } catch (Throwable e2) {
            b.a(e2);
        }
    }
}
