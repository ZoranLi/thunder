package com.alibaba.sdk.android.feedback.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;

public class NetworkChangeReceiver extends BroadcastReceiver {
    private ConnectivityManager a;
    private boolean b = true;

    public boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (this.a == null) {
            this.a = (ConnectivityManager) context.getSystemService("connectivity");
        }
        NetworkInfo activeNetworkInfo = this.a.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == State.CONNECTED;
    }

    public void onReceive(Context context, Intent intent) {
        if (context != null && PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction()) && this.b && a(context) && TextUtils.isEmpty((CharSequence) FeedbackAPI.mFeedbackCustomInfoMap.get("conf"))) {
            FeedbackAPI.getFeedbackConf(null, null);
            this.b = false;
        }
    }
}
