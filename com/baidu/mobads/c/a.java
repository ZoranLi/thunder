package com.baidu.mobads.c;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.d.c;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.vo.a.b;
import com.baidu.mobads.vo.a.d;
import com.igexin.assist.sdk.AssistPushConsts;
import com.umeng.message.MsgConstant;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.download.DownloadManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class a {
    public static volatile String b = "";
    public static volatile String c = "";
    private static a d = new a();
    private static boolean f = false;
    protected final IXAdLogger a = XAdSDKFoundationFacade.getInstance().getAdLogger();
    private Context e;

    public void a(com.baidu.mobads.command.a aVar) {
    }

    public static a a() {
        return d;
    }

    private a() {
        new Handler(Looper.getMainLooper()).postDelayed(new b(this), 2000);
    }

    public void a(Context context) {
        if (this.e == null) {
            this.e = context;
        }
    }

    public void a(Context context, com.baidu.mobads.command.a aVar) {
        a(context, "9", aVar);
    }

    public void a(Context context, IXAppInfo iXAppInfo) {
        a(context, "11", iXAppInfo);
    }

    public void b(Context context, IXAppInfo iXAppInfo) {
        a(context, "10", iXAppInfo);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("temp_for_feed_response_html")) {
            a(str, "400", null);
        } else if (f == null) {
            String str2 = AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b);
            stringBuilder.append("___");
            stringBuilder.append(c);
            a("temp_for_feed_response_html", str2, stringBuilder.toString());
            f = true;
        }
    }

    public void a(String str, String str2, String str3) {
        try {
            Builder appendQueryParameter = new Builder().appendQueryParameter("stacktrace", str2);
            appendQueryParameter.appendQueryParameter("ad", str3);
            for (Entry entry : new b().c().entrySet()) {
                appendQueryParameter.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
            a(str, "404", appendQueryParameter);
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(e);
        }
    }

    private void a(String str, String str2, Builder builder) {
        IXAdConstants adConstants = XAdSDKFoundationFacade.getInstance().getAdConstants();
        IXAdCommonUtils commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        if (builder == null) {
            builder = new Builder();
        }
        try {
            StringBuilder stringBuilder = new StringBuilder("android_");
            stringBuilder.append(com.baidu.mobads.a.a.c);
            stringBuilder.append("_4.1.30");
            str = builder.appendQueryParameter("type", str2).appendQueryParameter(IXAdRequestInfo.P_VER, "8.7036").appendQueryParameter("appsid", adConstants.getAppSid()).appendQueryParameter("v", stringBuilder.toString()).appendQueryParameter(DownloadManager.COLUMN_REASON, str).appendQueryParameter(IXAdRequestInfo.OSV, VERSION.RELEASE);
            str2 = IXAdRequestInfo.BDR;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(VERSION.SDK_INT);
            str = str.appendQueryParameter(str2, stringBuilder2.toString());
            str2 = IXAdRequestInfo.BRAND;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(commonUtils.getTextEncoder(Build.BRAND));
            str.appendQueryParameter(str2, stringBuilder2.toString()).appendQueryParameter("pack", adConstants.getAppPackageNameOfPublisher());
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(e);
        }
        c cVar = new c("https://mobads-logs.baidu.com/brwhis.log", "");
        cVar.a(builder);
        cVar.a((int) null);
        new com.baidu.mobads.openad.d.a().a(cVar);
    }

    private void a(Context context, String str, com.baidu.mobads.command.a aVar) {
        IXAppInfo a = com.baidu.mobads.command.a.a.a(aVar);
        if (a != null) {
            a(context, str, a);
        }
    }

    private void a(Context context, String str, IXAppInfo iXAppInfo) {
        com.baidu.mobads.vo.a.c cVar = new com.baidu.mobads.vo.a.c(context, iXAppInfo);
        cVar.b = iXAppInfo.getAdId();
        b(a(context, str, cVar.c()));
    }

    public void a(Context context, String str, IXAdInstanceInfo iXAdInstanceInfo, IXAdProdInfo iXAdProdInfo, Object... objArr) {
        a(0.1d, context, str, iXAdInstanceInfo, iXAdProdInfo, objArr);
    }

    public void a(double d, Context context, String str, IXAdInstanceInfo iXAdInstanceInfo, IXAdProdInfo iXAdProdInfo, Object... objArr) {
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i < objArr.length) {
            try {
                StringBuilder stringBuilder = new StringBuilder("custom_");
                stringBuilder.append(i);
                hashMap.put(stringBuilder.toString(), String.valueOf(objArr[i]));
                i++;
            } catch (Throwable e) {
                l.a().e(e);
                return;
            }
        }
        a(d, context, str, iXAdInstanceInfo, iXAdProdInfo, hashMap);
    }

    public void a(Context context, String str, IXAdInstanceInfo iXAdInstanceInfo, IXAdProdInfo iXAdProdInfo, HashMap<String, String> hashMap) {
        a(1.0d, context, str, iXAdInstanceInfo, iXAdProdInfo, (HashMap) hashMap);
    }

    public void a(double d, Context context, String str, IXAdInstanceInfo iXAdInstanceInfo, IXAdProdInfo iXAdProdInfo, HashMap<String, String> hashMap) {
        try {
            if (d > new Random().nextDouble()) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put("probability", String.valueOf(d));
                b(new d(str, iXAdInstanceInfo, iXAdProdInfo, hashMap).a(context));
            }
        } catch (Throwable e) {
            l.a().e(e);
        }
    }

    private void b(String str) {
        a(1, str);
    }

    private void a(int i, String str) {
        com.baidu.mobads.openad.d.a aVar = new com.baidu.mobads.openad.d.a();
        c cVar = new c(str, "");
        cVar.e = i;
        aVar.a(cVar, Boolean.valueOf(1));
    }

    private String a(Context context, String str, Map<String, String> map) {
        try {
            StringBuilder stringBuilder = new StringBuilder("type=");
            stringBuilder.append(str);
            stringBuilder.append("&");
            context = new StringBuilder(stringBuilder.toString());
            str = new StringBuilder();
            String str2 = MsgConstant.KEY_TS;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(System.currentTimeMillis());
            map.put(str2, stringBuilder2.toString());
            IXAdCommonUtils commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            for (String str3 : map.keySet()) {
                String str32;
                String str4 = (String) map.get(str32);
                if (!(str32 == null || str4 == null)) {
                    str32 = commonUtils.encodeURIComponent(str32);
                    str4 = commonUtils.encodeURIComponent(str4);
                    context.append(str32);
                    context.append("=");
                    context.append(str4);
                    context.append("&");
                    str.append(str4);
                    str.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            str.append("mobads,");
            map = commonUtils.getMD5(str.toString());
            IXAdLogger iXAdLogger = this.a;
            stringBuilder2 = new StringBuilder("ExtraQuery.allValue:");
            stringBuilder2.append(str);
            iXAdLogger.d(stringBuilder2.toString());
            str = new StringBuilder("vd=");
            str.append(map);
            str.append("&");
            context.append(str.toString());
            str = this.a;
            map = new StringBuilder("ExtraQuery.params:");
            map.append(context);
            str.d(map.toString());
            map = new StringBuilder();
            map.append("https://mobads-logs.baidu.com/dz.zb");
            map.append("?");
            map.append(context.toString());
            return map.toString();
        } catch (Throwable e) {
            this.a.d(e);
            return "";
        }
    }
}
