package com.sina.weibo.sdk.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.util.Pair;
import com.igexin.sdk.PushConsts;

public class NetStateManager {
    public static NetState CUR_NETSTATE = NetState.Mobile;
    private static Context mContext;

    public enum NetState {
        Mobile,
        WIFI,
        NOWAY
    }

    public class NetStateReceive extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            NetStateManager.mContext = context;
            if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction()) != null) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                intent = wifiManager.getConnectionInfo();
                if (wifiManager.isWifiEnabled() == null || -1 == intent.getNetworkId()) {
                    NetStateManager.CUR_NETSTATE = NetState.Mobile;
                }
            }
        }
    }

    public static Pair<String, Integer> getAPN() {
        Pair<String, Integer> pair = null;
        Cursor query = mContext != null ? mContext.getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null) : null;
        if (query != null && query.moveToFirst()) {
            String string = query.getString(query.getColumnIndex("proxy"));
            if (string != null && string.trim().length() > 0) {
                pair = new Pair(string, Integer.valueOf(80));
            }
            query.close();
        }
        return pair;
    }

    public static boolean isNetworkConnected(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r4 != 0) goto L_0x000b;
    L_0x0003:
        r4 = "Weibosdk";
        r1 = "unexpected null context in isNetworkConnected";
        com.sina.weibo.sdk.utils.LogUtil.e(r4, r1);
        return r0;
    L_0x000b:
        r1 = r4.getPackageManager();
        r2 = "android.permission.ACCESS_NETWORK_STATE";
        r3 = r4.getPackageName();
        r1 = r1.checkPermission(r2, r3);
        if (r1 == 0) goto L_0x001c;
    L_0x001b:
        return r0;
    L_0x001c:
        r1 = "connectivity";
        r4 = r4.getSystemService(r1);
        r4 = (android.net.ConnectivityManager) r4;
        r1 = 0;
        r4 = r4.getActiveNetworkInfo();	 Catch:{ NullPointerException -> 0x002a }
        goto L_0x002b;
    L_0x002a:
        r4 = r1;
    L_0x002b:
        if (r4 == 0) goto L_0x0036;
    L_0x002d:
        r4 = r4.isAvailable();
        if (r4 != 0) goto L_0x0034;
    L_0x0033:
        goto L_0x0036;
    L_0x0034:
        r4 = 1;
        return r4;
    L_0x0036:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.net.NetStateManager.isNetworkConnected(android.content.Context):boolean");
    }
}
