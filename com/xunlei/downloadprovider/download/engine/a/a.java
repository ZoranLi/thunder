package com.xunlei.downloadprovider.download.engine.a;

import android.content.Context;
import android.content.Intent;
import com.alipay.sdk.cons.c;
import com.xunlei.xllib.android.XLIntent;

/* compiled from: ThirdPartCallDownload */
public final class a {
    public static void a(Context context, String str, String str2, boolean z) {
        if (str != null) {
            if (context != null) {
                Intent xLIntent = new XLIntent("com.xunlei.downloadprovider.ACTION_DOWNLOAD_STATUS");
                xLIntent.putExtra("status", z ? "CREATE_SUCCESS" : "CREATE_FAIL");
                xLIntent.putExtra("url", str);
                xLIntent.putExtra(c.e, str2);
                xLIntent.putExtra("return", null);
                context.sendBroadcast(xLIntent);
            }
        }
    }
}
