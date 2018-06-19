package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.xmpush.thrift.an;
import com.xiaomi.xmpush.thrift.u;
import java.util.List;

public class PushMessageHelper {
    public static final String KEY_COMMAND = "key_command";
    public static final String KEY_MESSAGE = "key_message";
    public static final int MESSAGE_COMMAND = 3;
    public static final int MESSAGE_QUIT = 4;
    public static final int MESSAGE_RAW = 1;
    public static final int MESSAGE_SENDMESSAGE = 2;
    public static final String MESSAGE_TYPE = "message_type";
    public static final int PUSH_MODE_BROADCAST = 2;
    public static final int PUSH_MODE_CALLBACK = 1;
    private static int pushMode;

    public static MiPushCommandMessage generateCommandMessage(String str, List<String> list, long j, String str2, String str3) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.setCommand(str);
        miPushCommandMessage.setCommandArguments(list);
        miPushCommandMessage.setResultCode(j);
        miPushCommandMessage.setReason(str2);
        miPushCommandMessage.setCategory(str3);
        return miPushCommandMessage;
    }

    public static MiPushMessage generateMessage(an anVar, u uVar, boolean z) {
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.setMessageId(anVar.c());
        if (!TextUtils.isEmpty(anVar.j())) {
            miPushMessage.setMessageType(1);
            miPushMessage.setAlias(anVar.j());
        } else if (!TextUtils.isEmpty(anVar.h())) {
            miPushMessage.setMessageType(2);
            miPushMessage.setTopic(anVar.h());
        } else if (TextUtils.isEmpty(anVar.r())) {
            miPushMessage.setMessageType(0);
        } else {
            miPushMessage.setMessageType(3);
            miPushMessage.setUserAccount(anVar.r());
        }
        miPushMessage.setCategory(anVar.p());
        if (anVar.l() != null) {
            miPushMessage.setContent(anVar.l().f());
        }
        if (uVar != null) {
            if (TextUtils.isEmpty(miPushMessage.getMessageId())) {
                miPushMessage.setMessageId(uVar.b());
            }
            if (TextUtils.isEmpty(miPushMessage.getTopic())) {
                miPushMessage.setTopic(uVar.f());
            }
            miPushMessage.setDescription(uVar.j());
            miPushMessage.setTitle(uVar.h());
            miPushMessage.setNotifyType(uVar.l());
            miPushMessage.setNotifyId(uVar.q());
            miPushMessage.setPassThrough(uVar.o());
            miPushMessage.setExtra(uVar.s());
        }
        miPushMessage.setNotified(z);
        return miPushMessage;
    }

    public static int getPushMode(Context context) {
        if (pushMode == 0) {
            setPushMode(isUseCallbackPushMode(context) ? 1 : 2);
        }
        return pushMode;
    }

    private static boolean isIntentAvailable(android.content.Context r2, android.content.Intent r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = r2.getPackageManager();
        r0 = 32;
        r1 = 1;
        r2 = r2.queryBroadcastReceivers(r3, r0);	 Catch:{ Exception -> 0x0016 }
        if (r2 == 0) goto L_0x0014;	 Catch:{ Exception -> 0x0016 }
    L_0x000d:
        r2 = r2.isEmpty();	 Catch:{ Exception -> 0x0016 }
        if (r2 != 0) goto L_0x0014;
    L_0x0013:
        return r1;
    L_0x0014:
        r2 = 0;
        return r2;
    L_0x0016:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.PushMessageHelper.isIntentAvailable(android.content.Context, android.content.Intent):boolean");
    }

    public static boolean isUseCallbackPushMode(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return isIntentAvailable(context, intent);
    }

    public static void sendCommandMessageBroadcast(Context context, MiPushCommandMessage miPushCommandMessage) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra(MESSAGE_TYPE, 3);
        intent.putExtra(KEY_COMMAND, miPushCommandMessage);
        new PushServiceReceiver().onReceive(context, intent);
    }

    public static void sendQuitMessageBroadcast(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra(MESSAGE_TYPE, 4);
        new PushServiceReceiver().onReceive(context, intent);
    }

    private static void setPushMode(int i) {
        pushMode = i;
    }
}
