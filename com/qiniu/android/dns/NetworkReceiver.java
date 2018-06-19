package com.qiniu.android.dns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.text.TextUtils;
import com.qiniu.android.dns.NetworkInfo.NetSatus;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import java.util.Locale;

public final class NetworkReceiver extends BroadcastReceiver {
    private static final Uri a = Uri.parse("content://telephony/carriers/preferapn");
    private static a b;

    public final void onReceive(Context context, Intent intent) {
        if (b != null) {
            intent = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (intent == null) {
                context = NetworkInfo.a;
            } else {
                NetSatus netSatus;
                if (intent.getType() == 1) {
                    netSatus = NetSatus.WIFI;
                    context = null;
                } else {
                    int i;
                    netSatus = NetSatus.MOBILE;
                    context = context.getContentResolver().query(a, null, null, null, null);
                    if (context != null) {
                        context.moveToFirst();
                        String string = context.getString(context.getColumnIndex(MessageInfo.USER));
                        if (!TextUtils.isEmpty(string) && (string.startsWith("ctwap") || string.startsWith("ctnet"))) {
                            i = 1;
                            context.close();
                            if (i != 1) {
                                context = intent.getExtraInfo();
                                if (context != null) {
                                    context = context.toLowerCase(Locale.getDefault());
                                    if (context.equals("cmwap") == null) {
                                        if (context.equals("cmnet") != null) {
                                            if (!(context.equals("3gnet") == null && context.equals("uninet") == null && context.equals("3gwap") == null && context.equals("uniwap") == null)) {
                                                context = 2;
                                            }
                                        }
                                    }
                                    context = 3;
                                }
                            }
                            context = i;
                        }
                    }
                    i = 0;
                    context.close();
                    if (i != 1) {
                        context = intent.getExtraInfo();
                        if (context != null) {
                            context = context.toLowerCase(Locale.getDefault());
                            if (context.equals("cmwap") == null) {
                                if (context.equals("cmnet") != null) {
                                    context = 2;
                                }
                            }
                            context = 3;
                        }
                    }
                    context = i;
                }
                context = new NetworkInfo(netSatus, context);
            }
            intent = b;
            synchronized (intent.b) {
                intent.b.clear();
            }
            if (context == null) {
                context = NetworkInfo.b;
            }
            intent.d = context;
            synchronized (intent.a) {
                intent.e = 0;
            }
        }
    }
}
