package com.alibaba.sdk.android.feedback.xblink.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xunlei.download.DownloadManager;

class b extends BroadcastReceiver {
    final /* synthetic */ XBBaseHybridActivity a;

    b(XBBaseHybridActivity xBBaseHybridActivity) {
        this.a = xBBaseHybridActivity;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
                String stringExtra = intent.getStringExtra(DownloadManager.COLUMN_REASON);
                if (stringExtra != null) {
                    if (!stringExtra.equals("homekey")) {
                        stringExtra.equals("recentapps");
                    } else if (!(this.a.mWebView == null || this.a.mWebView.getWVCallBackContext() == null)) {
                        this.a.mWebView.getWVCallBackContext().a("WXPage.onPaused", "{}");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
