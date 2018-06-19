package com.umeng.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.umeng.message.common.UmLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.entity.UNotificationItem;
import org.json.JSONObject;

public class NotificationProxyBroadcastReceiver extends BroadcastReceiver {
    public static final int EXTRA_ACTION_CLICK = 10;
    public static final int EXTRA_ACTION_DISMISS = 11;
    public static final int EXTRA_ACTION_NOT_EXIST = -1;
    public static final String EXTRA_KEY_ACTION = "ACTION";
    public static final String EXTRA_KEY_MESSAGE_ID = "MESSAGE_ID";
    public static final String EXTRA_KEY_MSG = "MSG";
    public static final String EXTRA_KEY_NOTIFICATION_ID = "NOTIFICATION_ID";
    public static final String EXTRA_KEY_TASK_ID = "TASK_ID";
    public static final int LOCAL_ACTION_CLICK = 12;
    private static final String a = "com.umeng.message.NotificationProxyBroadcastReceiver";
    private UHandler b;

    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(EXTRA_KEY_MSG);
        try {
            int intExtra = intent.getIntExtra(EXTRA_KEY_ACTION, -1);
            UmLog.d(a, String.format("onReceive[msg=%s, action=%d]", new Object[]{stringExtra, Integer.valueOf(intExtra)}));
            if (intExtra == 12) {
                a(context);
                return;
            }
            UMessage uMessage = new UMessage(new JSONObject(stringExtra));
            int intExtra2 = intent.getIntExtra(EXTRA_KEY_NOTIFICATION_ID, -1);
            uMessage.message_id = intent.getStringExtra(EXTRA_KEY_MESSAGE_ID);
            uMessage.task_id = intent.getStringExtra(EXTRA_KEY_TASK_ID);
            switch (intExtra) {
                case 10:
                    UmLog.d(a, "click notification");
                    UTrack.getInstance(context).setClearPrevMessage(true);
                    UTrack.getInstance(context).trackMsgClick(uMessage);
                    this.b = PushAgent.getInstance(context).getNotificationClickHandler();
                    if (this.b != null) {
                        uMessage.clickOrDismiss = true;
                        this.b.handleMessage(context, uMessage);
                        break;
                    }
                    break;
                case 11:
                    UmLog.d(a, "dismiss notification");
                    UTrack.getInstance(context).setClearPrevMessage(true);
                    UTrack.getInstance(context).trackMsgDismissed(uMessage);
                    this.b = PushAgent.getInstance(context).getNotificationClickHandler();
                    if (this.b != null) {
                        uMessage.clickOrDismiss = false;
                        this.b.handleMessage(context, uMessage);
                        break;
                    }
                    break;
                default:
                    break;
            }
            if (MessageSharedPrefs.getInstance(context).getDisplayNotificationNumber() > null) {
                MessageNotificationQueue.getInstance().remove(new UNotificationItem(intExtra2, uMessage));
            }
        } catch (Context context2) {
            context2.printStackTrace();
        } catch (Context context22) {
            context22.printStackTrace();
        }
    }

    private void a(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            String str = a;
            StringBuilder stringBuilder = new StringBuilder("handleMessage(): cannot find app: ");
            stringBuilder.append(context.getPackageName());
            UmLog.e(str, stringBuilder.toString());
            return;
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(268435456);
        context.startActivity(launchIntentForPackage);
        str = a;
        stringBuilder = new StringBuilder("handleMessage(): lunach app: ");
        stringBuilder.append(context.getPackageName());
        UmLog.d(str, stringBuilder.toString());
    }
}
