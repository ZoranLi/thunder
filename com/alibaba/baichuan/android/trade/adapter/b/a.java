package com.alibaba.baichuan.android.trade.adapter.b;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.f.c;
import com.alibaba.baichuan.android.trade.utils.d.b;
import com.taobao.applink.TBAppLinkParam;
import com.taobao.applink.TBAppLinkSDK;
import com.taobao.applink.param.TBDetailParam;
import com.taobao.applink.param.TBShopParam;
import com.taobao.applink.param.TBURIParam;
import com.taobao.applink.util.TBAppLinkUtil;
import java.util.HashMap;
import java.util.Map;

public class a {
    private static final String b = "a";
    private static volatile a d;
    public TBAppLinkSDK a = TBAppLinkSDK.getInstance();
    private boolean c;

    private a() {
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.taobao.applink.param.TBBaseParam a(java.util.Map r4, java.lang.String r5) {
        /*
        r0 = 0;
        if (r4 == 0) goto L_0x011d;
    L_0x0003:
        r1 = r4.size();
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r1 = -1;
        r2 = r5.hashCode();
        r3 = 2544374; // 0x26d2f6 float:3.565427E-39 double:1.257088E-317;
        if (r2 == r3) goto L_0x0033;
    L_0x0014:
        r3 = 79626270; // 0x4bf001e float:4.4903992E-36 double:3.93406045E-316;
        if (r2 == r3) goto L_0x0029;
    L_0x0019:
        r3 = 2013072465; // 0x77fd0c51 float:1.0264851E34 double:9.945899475E-315;
        if (r2 == r3) goto L_0x001f;
    L_0x001e:
        goto L_0x003c;
    L_0x001f:
        r2 = "DETAIL";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x003c;
    L_0x0027:
        r1 = 1;
        goto L_0x003c;
    L_0x0029:
        r2 = "TBURI";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x003c;
    L_0x0031:
        r1 = 2;
        goto L_0x003c;
    L_0x0033:
        r2 = "SHOP";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x003c;
    L_0x003b:
        r1 = 0;
    L_0x003c:
        switch(r1) {
            case 0: goto L_0x0064;
            case 1: goto L_0x0052;
            case 2: goto L_0x0040;
            default: goto L_0x003f;
        };
    L_0x003f:
        return r0;
    L_0x0040:
        r1 = "url";
        r1 = b(r4, r1);
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 != 0) goto L_0x0076;
    L_0x004c:
        r2 = new com.taobao.applink.param.TBURIParam;
        r2.<init>(r1);
        goto L_0x0077;
    L_0x0052:
        r1 = "itemId";
        r1 = b(r4, r1);
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 != 0) goto L_0x0076;
    L_0x005e:
        r2 = new com.taobao.applink.param.TBDetailParam;
        r2.<init>(r1);
        goto L_0x0077;
    L_0x0064:
        r1 = "shopId";
        r1 = b(r4, r1);
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 != 0) goto L_0x0076;
    L_0x0070:
        r2 = new com.taobao.applink.param.TBShopParam;
        r2.<init>(r1);
        goto L_0x0077;
    L_0x0076:
        r2 = r0;
    L_0x0077:
        if (r2 != 0) goto L_0x007a;
    L_0x0079:
        return r0;
    L_0x007a:
        r0 = "backURL";
        r0 = b(r4, r0);
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x008a;
    L_0x0086:
        r2.setBackUrl(r0);
        goto L_0x008d;
    L_0x008a:
        r0 = "alisdk://";
        goto L_0x0086;
    L_0x008d:
        r0 = "e";
        r0 = b(r4, r0);
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x009c;
    L_0x0099:
        r2.setE(r0);
    L_0x009c:
        r0 = "sign";
        r0 = b(r4, r0);
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x00ab;
    L_0x00a8:
        r2.setSign(r0);
    L_0x00ab:
        r0 = "type";
        r0 = b(r4, r0);
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x00ba;
    L_0x00b7:
        r2.setType(r0);
    L_0x00ba:
        r0 = "addParams";
        r0 = r4.get(r0);
        if (r0 == 0) goto L_0x00cf;
    L_0x00c2:
        r1 = r0 instanceof java.util.HashMap;
        if (r1 == 0) goto L_0x00cf;
    L_0x00c6:
        r0 = (java.util.HashMap) r0;
        r1 = r0.size();
        if (r1 <= 0) goto L_0x00cf;
    L_0x00ce:
        goto L_0x00d4;
    L_0x00cf:
        r0 = new java.util.HashMap;
        r0.<init>();
    L_0x00d4:
        r1 = "ybhpss";
        r1 = b(r4, r1);
        r3 = android.text.TextUtils.isEmpty(r1);
        if (r3 != 0) goto L_0x00eb;
    L_0x00e0:
        r3 = r0.containsKey(r1);
        if (r3 != 0) goto L_0x00eb;
    L_0x00e6:
        r3 = "ybhpss";
        r0.put(r3, r1);
    L_0x00eb:
        r2.addExtraParams(r0);
        r0 = "TBAuth";
        r5 = r5.equals(r0);
        if (r5 != 0) goto L_0x010d;
    L_0x00f6:
        r5 = "jsonParams";
        r5 = r4.get(r5);
        if (r5 == 0) goto L_0x010d;
    L_0x00fe:
        r0 = r5 instanceof org.json.JSONObject;
        if (r0 == 0) goto L_0x010d;
    L_0x0102:
        r5 = (org.json.JSONObject) r5;
        r0 = r5.length();
        if (r0 <= 0) goto L_0x010d;
    L_0x010a:
        r2.setParams(r5);
    L_0x010d:
        r5 = "appType";
        r4 = b(r4, r5);
        r5 = android.text.TextUtils.isEmpty(r4);
        if (r5 != 0) goto L_0x011c;
    L_0x0119:
        r2.setAppType(r4);
    L_0x011c:
        return r2;
    L_0x011d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.trade.adapter.b.a.a(java.util.Map, java.lang.String):com.taobao.applink.param.TBBaseParam");
    }

    private static void a(Object obj, boolean z) {
        Map hashMap = new HashMap();
        if (!TextUtils.isEmpty(AlibcContext.c())) {
            hashMap.put("appkey", AlibcContext.c());
        }
        hashMap.put("ybhpss", (String) b.a("trade", "ybhpss"));
        hashMap.put(com.alipay.sdk.authjs.a.f, com.alibaba.baichuan.android.trade.utils.f.a.a(com.alipay.sdk.authjs.a.f, obj));
        hashMap.put("from", "nbsdk");
        hashMap.put("isSuccess", z ? "1" : "0");
        com.alibaba.baichuan.android.trade.adapter.ut.a.a();
        com.alibaba.baichuan.android.trade.adapter.ut.a.a(c.b, "", hashMap);
    }

    private static String b(Map map, String str) {
        Object obj = map.get(str);
        return (obj == null || !(obj instanceof String)) ? null : (String) obj;
    }

    public final void b() {
        if (!this.c) {
            TBAppLinkParam tBAppLinkParam = new TBAppLinkParam(AlibcContext.c(), null, "backurl", "");
            tBAppLinkParam.setUtdid(AlibcContext.a());
            tBAppLinkParam.setTTID(com.alibaba.baichuan.android.trade.e.a.g().e());
            tBAppLinkParam.setSource(com.alibaba.baichuan.android.trade.e.a.g().b);
            this.a.init(AlibcContext.a, tBAppLinkParam);
            this.c = true;
        }
    }

    public static boolean a(String str) {
        if (TBAppLinkUtil.isSupportAppLinkSDK(AlibcContext.a, str) != null) {
            return true;
        }
        AlibcContext.b();
        return null;
    }

    public final boolean a(Context context, Map map) {
        new StringBuilder("调用applink jumpshop方法,传入参数为:params=").append(map);
        AlibcContext.b();
        b();
        TBShopParam tBShopParam = (TBShopParam) a(map, "SHOP");
        boolean z = false;
        if (tBShopParam != null) {
            try {
                this.a.jumpShop(context, tBShopParam);
                z = true;
            } catch (Context context2) {
                new StringBuilder("Applink調用jumpShop失败：").append(context2.getMessage());
                com.alibaba.baichuan.android.trade.utils.g.a.b();
            }
        }
        a((Object) map, z);
        new StringBuilder("Applink調用jumpShop").append(z ? "成功" : "失败");
        AlibcContext.b();
        return z;
    }

    public final boolean b(Context context, Map map) {
        new StringBuilder("调用applink jumpdetail方法,传入参数为:params=").append(map);
        AlibcContext.b();
        b();
        TBDetailParam tBDetailParam = (TBDetailParam) a(map, "DETAIL");
        boolean z = false;
        if (tBDetailParam != null) {
            try {
                this.a.jumpDetail(context, tBDetailParam);
                z = true;
            } catch (Context context2) {
                new StringBuilder("Applink調用jumpDetail失败：").append(context2.getMessage());
                com.alibaba.baichuan.android.trade.utils.g.a.b();
            }
        }
        a((Object) map, z);
        new StringBuilder("Applink調用jumpDetail").append(z ? "成功" : "失败");
        AlibcContext.b();
        return z;
    }

    public final boolean c(Context context, Map map) {
        new StringBuilder("调用applink jumpuri方法,传入参数为:params=").append(map);
        AlibcContext.b();
        b();
        TBURIParam tBURIParam = (TBURIParam) a(map, "TBURI");
        boolean z = false;
        if (tBURIParam != null) {
            try {
                this.a.jumpTBURI(context, tBURIParam);
                z = true;
            } catch (Context context2) {
                new StringBuilder("Applink調用jumpTBURI失败：").append(context2.getMessage());
                com.alibaba.baichuan.android.trade.utils.g.a.b();
            }
        }
        a((Object) map, z);
        new StringBuilder("Applink調用jumpTBURI").append(z ? "成功" : "失败");
        AlibcContext.b();
        return z;
    }
}
