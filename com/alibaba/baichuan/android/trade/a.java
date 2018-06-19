package com.alibaba.baichuan.android.trade;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.baichuan.android.trade.adapter.ut.e;
import com.alibaba.baichuan.android.trade.callback.AlibcFailureCallback;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeCallback;
import com.alibaba.baichuan.android.trade.g.b;
import com.alibaba.baichuan.android.trade.model.AlibcTaokeParams;
import com.alibaba.baichuan.android.trade.utils.c;
import com.alibaba.baichuan.android.trade.utils.f;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class a {
    private static com.alibaba.baichuan.android.trade.model.a a = null;
    private static AlibcTaokeParams b = null;
    private static Map c = null;
    private static Map d = null;
    private static String e = "com.alibaba.baichuan.android.trade.a";

    private static void a(b bVar, String str) {
        if (bVar == null) {
            c.a(e, "sendUsabilityFailure", "tradePage is null!");
            com.alibaba.baichuan.android.trade.utils.g.a.b();
            return;
        }
        boolean a = bVar.a(a);
        String e = bVar.e();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e);
        stringBuilder.append(a ? "_Native" : "_H5");
        e.a(stringBuilder.toString(), str);
    }

    private static void a(b bVar, Map map) {
        if (bVar.b() != null) {
            Map hashMap = new HashMap();
            hashMap.putAll(map);
            if (!TextUtils.isEmpty(AlibcContext.c())) {
                hashMap.put("appkey", AlibcContext.c());
            }
            hashMap.put("taokeParam", b == null ? "{}" : b.toString());
            com.alibaba.baichuan.android.trade.adapter.ut.a.a();
            com.alibaba.baichuan.android.trade.adapter.ut.a.a(bVar.b(), "", hashMap);
        }
    }

    public static int a(Activity activity, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, b bVar, com.alibaba.baichuan.android.trade.model.a aVar, AlibcTaokeParams alibcTaokeParams, Map map, AlibcTradeCallback alibcTradeCallback) {
        Activity activity2 = activity;
        b bVar2 = bVar;
        com.alibaba.baichuan.android.trade.model.a aVar2 = aVar;
        AlibcTaokeParams alibcTaokeParams2 = alibcTaokeParams;
        Map map2 = map;
        AlibcFailureCallback alibcFailureCallback = alibcTradeCallback;
        StringBuilder stringBuilder = new StringBuilder("AlibcTrade.show(): AlibcPage: ");
        stringBuilder.append(bVar.toString());
        stringBuilder.append(" taoke.pid: ");
        stringBuilder.append(alibcTaokeParams2.pid);
        stringBuilder.append(" activity:");
        stringBuilder.append(activity2 == null ? "null" : activity2.toString());
        AlibcContext.b();
        com.alibaba.baichuan.android.trade.model.b bVar3 = b.b;
        if (bVar3 == null || bVar3.a) {
            if ((b.a.a == 1 ? 1 : 0) != 0) {
                f.a(alibcFailureCallback, 1002, "初始化未完成,请稍后!");
                return -1;
            }
            Object[] objArr;
            int i;
            boolean a;
            StringBuilder stringBuilder2;
            String e;
            StringBuilder stringBuilder3;
            a = aVar2;
            com.alibaba.baichuan.android.trade.b.a aVar3 = new com.alibaba.baichuan.android.trade.b.a(bVar2, a);
            aVar3.a("allTime");
            aVar3.a("analysisTime");
            if (activity2 == null) {
                objArr = new Object[]{"Activity"};
            } else if (bVar.a()) {
                i = 1;
                if (i != 0) {
                    com.alibaba.baichuan.android.trade.utils.g.a.b();
                    a(bVar2, "参数不合法");
                    return -1;
                }
                AlibcContext.j = aVar2.e;
                if (map2.get("isv_code") == null) {
                    AlibcContext.h = (String) map2.get("isv_code");
                } else {
                    AlibcContext.h = null;
                }
                c = map2;
                d = com.alibaba.baichuan.android.trade.utils.a.a(map);
                new StringBuilder("url 参数为 mUrlParams=").append(d);
                AlibcContext.b();
                aVar3.e = alibcFailureCallback;
                b = alibcTaokeParams2;
                a = bVar2.a(a);
                com.alibaba.baichuan.android.trade.adapter.b.a.a();
                if (!com.alibaba.baichuan.android.trade.adapter.b.a.a(a.c)) {
                    AlibcContext.b();
                    a = false;
                }
                aVar3.b("analysisTime");
                if (a) {
                    stringBuilder2 = new StringBuilder("通过native打开，打开参数为taokeparamers=");
                    stringBuilder2.append(b);
                    stringBuilder2.append(" showparamers=");
                    stringBuilder2.append(a);
                    stringBuilder2.append(" urlParamers=");
                    stringBuilder2.append(d);
                    AlibcContext.b();
                    aVar3.a("goTaobaoTime");
                    if (bVar2.a(b, a, d, activity2)) {
                        a(bVar2, "applink调用失败");
                        aVar3.a(bVar2);
                    } else {
                        AlibcContext.b();
                        aVar3.b("goTaobaoTime");
                        aVar3.b("allTime");
                        e.a(aVar3.b);
                        a(bVar2, d);
                        a = bVar2.a(a);
                        e = bVar.e();
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(e);
                        stringBuilder3.append(a ? "_Native" : "_H5");
                        e.a(stringBuilder3.toString());
                        return 0;
                    }
                }
                if (bVar2.a(b)) {
                    b(activity2, webView, webViewClient, webChromeClient, bVar2.a(null, d, aVar3), bVar2, aVar3);
                } else {
                    AlibcContext.b();
                    bVar2.a(b, aVar3, new c(bVar2, activity2, webView, webViewClient, webChromeClient, aVar3, aVar2));
                }
                a(bVar2, d);
                return 1;
            } else {
                objArr = new Object[]{"AlibcPage"};
            }
            f.a(alibcFailureCallback, com.alibaba.baichuan.android.trade.utils.a.a.a(14, objArr));
            i = 0;
            if (i != 0) {
                AlibcContext.j = aVar2.e;
                if (map2.get("isv_code") == null) {
                    AlibcContext.h = null;
                } else {
                    AlibcContext.h = (String) map2.get("isv_code");
                }
                c = map2;
                d = com.alibaba.baichuan.android.trade.utils.a.a(map);
                new StringBuilder("url 参数为 mUrlParams=").append(d);
                AlibcContext.b();
                aVar3.e = alibcFailureCallback;
                b = alibcTaokeParams2;
                a = bVar2.a(a);
                com.alibaba.baichuan.android.trade.adapter.b.a.a();
                if (com.alibaba.baichuan.android.trade.adapter.b.a.a(a.c)) {
                    AlibcContext.b();
                    a = false;
                }
                aVar3.b("analysisTime");
                if (a) {
                    stringBuilder2 = new StringBuilder("通过native打开，打开参数为taokeparamers=");
                    stringBuilder2.append(b);
                    stringBuilder2.append(" showparamers=");
                    stringBuilder2.append(a);
                    stringBuilder2.append(" urlParamers=");
                    stringBuilder2.append(d);
                    AlibcContext.b();
                    aVar3.a("goTaobaoTime");
                    if (bVar2.a(b, a, d, activity2)) {
                        a(bVar2, "applink调用失败");
                        aVar3.a(bVar2);
                    } else {
                        AlibcContext.b();
                        aVar3.b("goTaobaoTime");
                        aVar3.b("allTime");
                        e.a(aVar3.b);
                        a(bVar2, d);
                        a = bVar2.a(a);
                        e = bVar.e();
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(e);
                        if (a) {
                        }
                        stringBuilder3.append(a ? "_Native" : "_H5");
                        e.a(stringBuilder3.toString());
                        return 0;
                    }
                }
                if (bVar2.a(b)) {
                    b(activity2, webView, webViewClient, webChromeClient, bVar2.a(null, d, aVar3), bVar2, aVar3);
                } else {
                    AlibcContext.b();
                    bVar2.a(b, aVar3, new c(bVar2, activity2, webView, webViewClient, webChromeClient, aVar3, aVar2));
                }
                a(bVar2, d);
                return 1;
            }
            com.alibaba.baichuan.android.trade.utils.g.a.b();
            a(bVar2, "参数不合法");
            return -1;
        }
        StringBuilder stringBuilder4 = new StringBuilder("初始化失败, ");
        stringBuilder4.append(bVar3.b);
        f.a(alibcFailureCallback, 1001, stringBuilder4.toString());
        return -1;
    }

    private static void b(Activity activity, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, String str, b bVar, com.alibaba.baichuan.android.trade.b.a aVar) {
        com.alibaba.baichuan.android.trade.b.a aVar2 = aVar;
        Map hashMap = new HashMap();
        hashMap.put("trade_taokeParam", b);
        hashMap.put("ui_contextParams", d);
        hashMap.put("show_by_h5", String.valueOf(bVar.a(a) ^ 1));
        hashMap.put("backLoginFail", String.valueOf(bVar.g()));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bVar.e());
        stringBuilder.append("_H5");
        hashMap.put("u_label", stringBuilder.toString());
        new StringBuilder("h5打开，上下文参数为params=").append(hashMap);
        AlibcContext.b();
        aVar2.a("urlLoadTime");
        if (webView == null || AlibcContext.b == null) {
            AlibcContext.b();
            com.alibaba.baichuan.android.trade.d.a aVar3 = com.alibaba.baichuan.android.trade.d.a.a;
            com.alibaba.baichuan.android.trade.d.a.a(activity, str, (Serializable) hashMap, aVar2);
            return;
        }
        AlibcContext.b();
        AlibcContext.b.b(new com.alibaba.baichuan.android.trade.d.c(com.alibaba.baichuan.android.trade.d.a.a, activity, aVar2, webView, hashMap, webViewClient, webChromeClient, str, bVar.h()));
    }
}
