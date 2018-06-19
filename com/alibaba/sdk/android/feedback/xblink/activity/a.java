package com.alibaba.sdk.android.feedback.xblink.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

class a extends BroadcastReceiver {
    final /* synthetic */ XBBaseHybridActivity a;

    a(XBBaseHybridActivity xBBaseHybridActivity) {
        this.a = xBBaseHybridActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("data");
            Object stringExtra2 = this.a.getIntent().getStringExtra("APPKEY");
            String stringBuilder;
            if (TextUtils.isEmpty(stringExtra2)) {
                StringBuilder stringBuilder2 = new StringBuilder("WXCOMMUNICATIONPUSH");
                stringBuilder2.append(this.a.url);
                stringBuilder = stringBuilder2.toString();
            } else {
                StringBuilder stringBuilder3 = new StringBuilder("WXCOMMUNICATIONPUSH");
                stringBuilder3.append(stringExtra2);
                stringBuilder = stringBuilder3.toString();
            }
            if (this.a.url != null && r0.equals(action)) {
                this.a.onBroadcast(this.a.mWebView, stringExtra);
            }
        }
    }
}
