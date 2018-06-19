package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.taobao.agoo.TaobaoBaseIntentService;
import com.umeng.message.common.UmLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.l;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

public abstract class UmengBaseIntentService extends TaobaoBaseIntentService {
    private static final String a = "com.umeng.message.UmengBaseIntentService";

    protected void onRegistered(Context context, String str) {
    }

    protected void onUnregistered(Context context, String str) {
    }

    protected void onMessage(Context context, Intent intent) {
        if (Process.getElapsedCpuTime() < 3000) {
            UmLog.i(a, "App is launched by push message");
            PushAgent.setAppLaunchByMessage();
        }
        String stringExtra = intent.getStringExtra(AgooConstants.MESSAGE_BODY);
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("onMessage():[");
        stringBuilder.append(stringExtra);
        stringBuilder.append("]");
        UmLog.d(str, stringBuilder.toString());
        try {
            UMessage uMessage = new UMessage(new JSONObject(stringExtra));
            uMessage.message_id = intent.getStringExtra(AgooConstants.MESSAGE_ID);
            uMessage.task_id = intent.getStringExtra(AgooConstants.MESSAGE_TASK_ID);
            UTrack.getInstance(getApplicationContext()).trackMsgArrival(uMessage);
            l.a(context).a(uMessage.msg_id, uMessage.display_type);
            l.a(context).a(uMessage.message_id, uMessage.task_id, uMessage.display_type);
            if (TextUtils.equals(UMessage.DISPLAY_TYPE_AUTOUPDATE, uMessage.display_type)) {
                str = intent.getStringExtra(AgooConstants.MESSAGE_ID);
                intent = intent.getStringExtra(AgooConstants.MESSAGE_TASK_ID);
                Intent intent2 = new Intent();
                intent2.setPackage(context.getPackageName());
                intent2.setAction(MsgConstant.MESSAGE_AUTOUPDATE_HANDLER_ACTION);
                intent2.putExtra(AgooConstants.MESSAGE_BODY, stringExtra);
                intent2.putExtra(AgooConstants.MESSAGE_ID, str);
                intent2.putExtra(AgooConstants.MESSAGE_TASK_ID, intent);
                context.startService(intent2);
            }
        } catch (Context context2) {
            context2.printStackTrace();
            UmLog.d(a, context2.toString());
        }
    }

    protected void onError(Context context, String str) {
        context = a;
        StringBuilder stringBuilder = new StringBuilder("onError()[");
        stringBuilder.append(str);
        stringBuilder.append("]");
        UmLog.d(context, stringBuilder.toString());
    }
}
