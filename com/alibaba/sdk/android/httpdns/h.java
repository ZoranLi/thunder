package com.alibaba.sdk.android.httpdns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.igexin.sdk.PushConsts;

public class h {
    private static Context b = null;
    private static String c = null;
    static boolean f6c = false;

    private static String b() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) b.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return "None_Network";
        }
        String typeName = activeNetworkInfo.getTypeName();
        StringBuilder stringBuilder = new StringBuilder("[detectCurrentNetwork] - Network name:");
        stringBuilder.append(typeName);
        stringBuilder.append(" subType name: ");
        stringBuilder.append(activeNetworkInfo.getSubtypeName());
        e.d(stringBuilder.toString());
        return typeName == null ? "None_Network" : typeName;
    }

    public static void setContext(Context context) {
        if (context == null) {
            throw new IllegalStateException("Context can't be null");
        }
        b = context;
        BroadcastReceiver iVar = new i();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        b.registerReceiver(iVar, intentFilter);
    }
}
