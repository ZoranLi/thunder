package com.umeng.message.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.proguard.h;
import java.net.URLEncoder;

/* compiled from: NetworkHelper */
public class c {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    private static final String i = "com.umeng.message.util.c";
    private final int d = 1;
    private String e;
    private String f = "10.0.0.172";
    private int g = 80;
    private Context h;

    public c(Context context) {
        this.h = context;
        this.e = a(context);
    }

    private boolean a() {
        if (this.h.getPackageManager().checkPermission(MsgConstant.PERMISSION_ACCESS_NETWORK_STATE, this.h.getPackageName()) != 0) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.h.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo == null || activeNetworkInfo.getType() == 1)) {
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo == null || (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap") && !extraInfo.equals("uniwap"))) {
                    return false;
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] a(byte[] r5, java.lang.String r6) {
        /*
        r4 = this;
        r0 = 0;
        r1 = new java.net.URL;	 Catch:{ Exception -> 0x0060 }
        r1.<init>(r6);	 Catch:{ Exception -> 0x0060 }
        r6 = r1.openConnection();	 Catch:{ Exception -> 0x0060 }
        r6 = (java.net.HttpURLConnection) r6;	 Catch:{ Exception -> 0x0060 }
        r1 = "POST";
        r6.setRequestMethod(r1);	 Catch:{ Exception -> 0x0059, all -> 0x0057 }
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r6.setReadTimeout(r1);	 Catch:{ Exception -> 0x0059, all -> 0x0057 }
        r6.setConnectTimeout(r1);	 Catch:{ Exception -> 0x0059, all -> 0x0057 }
        r1 = "Msg-Type";
        r2 = "envelope";
        r6.setRequestProperty(r1, r2);	 Catch:{ Exception -> 0x0059, all -> 0x0057 }
        r1 = 1;
        r6.setDoOutput(r1);	 Catch:{ Exception -> 0x0059, all -> 0x0057 }
        r1 = 0;
        r6.setChunkedStreamingMode(r1);	 Catch:{ Exception -> 0x0059, all -> 0x0057 }
        r1 = new java.io.BufferedOutputStream;	 Catch:{ Exception -> 0x0059, all -> 0x0057 }
        r2 = r6.getOutputStream();	 Catch:{ Exception -> 0x0059, all -> 0x0057 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0059, all -> 0x0057 }
        r1.write(r5);	 Catch:{ Exception -> 0x0059, all -> 0x0057 }
        r1.flush();	 Catch:{ Exception -> 0x0059, all -> 0x0057 }
        r1.close();	 Catch:{ Exception -> 0x0059, all -> 0x0057 }
        r5 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0059, all -> 0x0057 }
        r1 = r6.getInputStream();	 Catch:{ Exception -> 0x0059, all -> 0x0057 }
        r5.<init>(r1);	 Catch:{ Exception -> 0x0059, all -> 0x0057 }
        r1 = com.umeng.message.proguard.h.a(r5);	 Catch:{ all -> 0x0052 }
        com.umeng.message.proguard.h.b(r5);	 Catch:{ Exception -> 0x0050, all -> 0x0057 }
        if (r6 == 0) goto L_0x0081;
    L_0x004c:
        r6.disconnect();
        goto L_0x0081;
    L_0x0050:
        r5 = move-exception;
        goto L_0x005b;
    L_0x0052:
        r1 = move-exception;
        com.umeng.message.proguard.h.b(r5);	 Catch:{ Exception -> 0x0059, all -> 0x0057 }
        throw r1;	 Catch:{ Exception -> 0x0059, all -> 0x0057 }
    L_0x0057:
        r5 = move-exception;
        goto L_0x0082;
    L_0x0059:
        r5 = move-exception;
        r1 = r0;
    L_0x005b:
        r0 = r6;
        goto L_0x0062;
    L_0x005d:
        r5 = move-exception;
        r6 = r0;
        goto L_0x0082;
    L_0x0060:
        r5 = move-exception;
        r1 = r0;
    L_0x0062:
        r6 = i;	 Catch:{ all -> 0x005d }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005d }
        r3 = "sendMessage:";
        r2.<init>(r3);	 Catch:{ all -> 0x005d }
        r3 = r5.getMessage();	 Catch:{ all -> 0x005d }
        r2.append(r3);	 Catch:{ all -> 0x005d }
        r2 = r2.toString();	 Catch:{ all -> 0x005d }
        com.umeng.message.common.UmLog.e(r6, r2);	 Catch:{ all -> 0x005d }
        r5.printStackTrace();	 Catch:{ all -> 0x005d }
        if (r0 == 0) goto L_0x0081;
    L_0x007e:
        r0.disconnect();
    L_0x0081:
        return r1;
    L_0x0082:
        if (r6 == 0) goto L_0x0087;
    L_0x0084:
        r6.disconnect();
    L_0x0087:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.util.c.a(byte[], java.lang.String):byte[]");
    }

    private String a(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(MsgConstant.SDK_VERSION);
        stringBuffer.append("/");
        stringBuffer.append(MsgConstant.SDK_VERSION);
        stringBuffer.append(" ");
        try {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(UmengMessageDeviceConfig.getApplicationLable(context));
            stringBuffer2.append("/");
            stringBuffer2.append(UmengMessageDeviceConfig.getAppVersionName(context));
            stringBuffer2.append(" ");
            stringBuffer2.append(Build.MODEL);
            stringBuffer2.append("/");
            stringBuffer2.append(VERSION.RELEASE);
            stringBuffer2.append(" ");
            stringBuffer2.append(h.a(PushAgent.getInstance(context).getMessageAppkey()));
            stringBuffer.append(URLEncoder.encode(stringBuffer2.toString(), "UTF-8"));
        } catch (Context context2) {
            context2.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
