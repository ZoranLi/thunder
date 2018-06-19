package com.umeng.message;

import android.content.Intent;
import android.os.Bundle;
import com.taobao.agoo.BaseNotifyClickActivity;
import com.umeng.message.common.UmLog;
import com.umeng.message.entity.UMessage;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

public class UmengNotifyClickActivity extends BaseNotifyClickActivity {
    private static final String a = "com.umeng.message.UmengNotifyClickActivity";

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onStart() {
        super.onStart();
    }

    public void onMessage(Intent intent) {
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
            UTrack.getInstance(this).trackMiPushMsgClick(uMessage);
        } catch (Intent intent2) {
            intent2.printStackTrace();
            UmLog.d(a, intent2.toString());
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
