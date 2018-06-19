package com.umeng.message.util;

import android.content.Context;
import com.alibaba.sdk.android.httpdns.HttpDns;
import com.alibaba.sdk.android.httpdns.HttpDnsService;
import com.umeng.message.MsgConstant;

/* compiled from: HttpDnsManager */
public class b {
    private static HttpDnsService a(Context context) {
        context = HttpDns.getService(context, MsgConstant.ACCOUNT_ID);
        context.setExpiredIPEnabled(true);
        return context;
    }

    public static String a(Context context, String str) {
        return a(context).getIpByHost(str);
    }
}
