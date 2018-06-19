package com.alibaba.baichuan.android.trade.adapter.a;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import anet.channel.util.HttpConstant;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.a.d;
import com.alibaba.baichuan.android.trade.adapter.ut.e;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.model.AliPayResult;
import com.alibaba.baichuan.android.trade.ui.activity.AlibcWebViewActivity;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a {
    private static volatile a b;
    public final String a = "AlibcAlipay";

    private a() {
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    private static String b(AlibcTradeCallback alibcTradeCallback, WebView webView, String str) {
        try {
            return (String) com.alibaba.baichuan.android.trade.utils.c.a.a("com.alipay.sdk.app.PayTask", "pay", new String[]{"java.lang.String", "boolean"}, com.alibaba.baichuan.android.trade.utils.c.a.a("com.alipay.sdk.app.PayTask", new String[]{"android.app.Activity"}, new Object[]{webView.getContext()}), new Object[]{str, Boolean.TRUE});
        } catch (Exception e) {
            new StringBuilder("调用ApliPaySDK失败").append(e.getMessage());
            com.alibaba.baichuan.android.trade.utils.g.a.b();
            if (alibcTradeCallback != null) {
                alibcTradeCallback.onFailure(809, "使用Apliay SDK调用方法失败，请下载最新的ApliaySDK lib包或者使用H5方式付款");
            }
            if (webView.getContext() instanceof AlibcWebViewActivity) {
                ((AlibcWebViewActivity) webView.getContext()).finish();
            } else if (webView.getContext() instanceof Activity) {
                ((Activity) webView.getContext()).finish();
            }
            return null;
        }
    }

    private static String b(String str, String str2, String str3) {
        int indexOf = str.indexOf(str2) + str2.length();
        if (str3 == null) {
            return str.substring(indexOf);
        }
        try {
            return str.substring(indexOf, str.indexOf(str3));
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static boolean b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "com.alipay.sdk.app.PayTask";	 Catch:{ ClassNotFoundException -> 0x0007 }
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0007 }
        r0 = 1;
        return r0;
    L_0x0007:
        com.alibaba.baichuan.android.trade.utils.g.a.b();
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.trade.adapter.a.a.b():boolean");
    }

    static /* synthetic */ ArrayList a(Uri uri) {
        uri = uri.getQueryParameter("pay_order_id");
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(uri)) {
            for (String parseLong : uri.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                arrayList.add(Long.valueOf(Long.parseLong(parseLong)));
            }
        }
        return arrayList;
    }

    static /* synthetic */ AliPayResult a(ArrayList arrayList) {
        d dVar = new d();
        Map hashMap = new HashMap();
        hashMap.put("orderIdList", com.alibaba.baichuan.android.trade.utils.f.a.a((List) arrayList));
        arrayList = dVar.a(hashMap);
        if (arrayList == null || !arrayList.isSuccess()) {
            String str;
            String str2 = "160101";
            if (arrayList == null) {
                str = "查询失败";
            } else {
                StringBuilder stringBuilder = new StringBuilder("code = ");
                stringBuilder.append(arrayList.errorCode);
                stringBuilder.append(" ,errmsg=");
                stringBuilder.append(arrayList.errorMsg);
                str = stringBuilder.toString();
            }
            e.b("Pay_Result_Alipay", str, str2);
        }
        if (!(arrayList == null || arrayList.data == null)) {
            if (arrayList.errorCode.equals(HttpConstant.SUCCESS)) {
                return com.alibaba.baichuan.android.trade.utils.f.a.b(arrayList.jsonData);
            }
        }
        return null;
    }

    static /* synthetic */ void a(a aVar, AlibcTradeCallback alibcTradeCallback, WebView webView, AliPayResult aliPayResult) {
        if (alibcTradeCallback != null) {
            AlibcContext.b.b(new d(aVar, aliPayResult, alibcTradeCallback, webView));
        }
    }

    static /* synthetic */ void a(a aVar, AlibcTradeCallback alibcTradeCallback, String str, WebView webView) {
        com.alibaba.baichuan.android.trade.utils.g.a.b();
        AlibcContext.b.b(new c(aVar, str, alibcTradeCallback, webView));
    }
}
