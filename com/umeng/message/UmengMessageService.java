package com.umeng.message;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.umeng.message.common.UmLog;
import org.android.agoo.common.AgooConstants;

public abstract class UmengMessageService extends IntentService {
    private static final String a = "UmengMessageService";

    public abstract void onMessage(Context context, Intent intent);

    public UmengMessageService() {
        super(a);
    }

    public void onCreate() {
        super.onCreate();
    }

    protected void onHandleIntent(Intent intent) {
        onMessage(this, intent);
        intent = intent.getStringExtra(AgooConstants.MESSAGE_BODY);
        String str = a;
        StringBuilder stringBuilder = new StringBuilder("message:");
        stringBuilder.append(intent);
        UmLog.i(str, stringBuilder.toString());
    }
}
