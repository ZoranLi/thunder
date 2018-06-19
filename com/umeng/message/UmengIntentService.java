package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.entity.UMessage;
import java.util.Map.Entry;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

public class UmengIntentService extends UmengBaseIntentService {
    private static final String a = "com.umeng.message.UmengIntentService";

    protected void onMessage(final Context context, Intent intent) {
        super.onMessage(context, intent);
        try {
            String stringExtra = intent.getStringExtra(AgooConstants.MESSAGE_BODY);
            String stringExtra2 = intent.getStringExtra(AgooConstants.MESSAGE_ID);
            intent = intent.getStringExtra(AgooConstants.MESSAGE_TASK_ID);
            final UMessage uMessage = new UMessage(new JSONObject(stringExtra));
            if (!UMessage.DISPLAY_TYPE_PULLAPP.equals(uMessage.display_type)) {
                String pushIntentServiceClass = MessageSharedPrefs.getInstance(context).getPushIntentServiceClass();
                if (pushIntentServiceClass.equalsIgnoreCase("")) {
                    Intent intent2 = new Intent();
                    intent2.setPackage(context.getPackageName());
                    intent2.setAction(MsgConstant.MESSAGE_MESSAGE_HANDLER_ACTION);
                    intent2.putExtra(AgooConstants.MESSAGE_BODY, stringExtra);
                    intent2.putExtra(AgooConstants.MESSAGE_ID, stringExtra2);
                    intent2.putExtra(AgooConstants.MESSAGE_TASK_ID, intent);
                    context.startService(intent2);
                    return;
                }
                Intent intent3 = new Intent();
                intent3.setClassName(context, pushIntentServiceClass);
                intent3.setPackage(context.getPackageName());
                intent3.putExtra(AgooConstants.MESSAGE_BODY, stringExtra);
                intent3.putExtra(AgooConstants.MESSAGE_ID, stringExtra2);
                intent3.putExtra(AgooConstants.MESSAGE_TASK_ID, intent);
                context.startService(intent3);
            } else if (UmengMessageDeviceConfig.isServiceWork(context, uMessage.pulled_service, uMessage.pulled_package) != null) {
                UTrack.getInstance(context).trackMsgPulled(uMessage, 52);
            } else if (UmengMessageDeviceConfig.getDataData(uMessage.pulled_package) == null) {
                UTrack.getInstance(context).trackMsgPulled(uMessage, 53);
            } else {
                intent = new Intent();
                intent.setClassName(uMessage.pulled_package, uMessage.pulled_service);
                a(intent, uMessage);
                startService(intent);
                new Thread(new Runnable(this) {
                    final /* synthetic */ UmengIntentService c;

                    public void run() {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (UmengMessageDeviceConfig.isServiceWork(context, uMessage.pulled_service, uMessage.pulled_package)) {
                            UTrack.getInstance(context).trackMsgPulled(uMessage, 51);
                        } else {
                            UTrack.getInstance(context).trackMsgPulled(uMessage, 50);
                        }
                    }
                }).start();
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    private Intent a(Intent intent, UMessage uMessage) {
        if (!(intent == null || uMessage == null)) {
            if (uMessage.extra != null) {
                for (Entry entry : uMessage.extra.entrySet()) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    if (str != null) {
                        intent.putExtra(str, str2);
                    }
                }
                return intent;
            }
        }
        return intent;
    }
}
