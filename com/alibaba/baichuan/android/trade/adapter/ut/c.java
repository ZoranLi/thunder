package com.alibaba.baichuan.android.trade.adapter.ut;

import com.alibaba.baichuan.android.trade.utils.g.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class c {
    private static final String a = "c";
    private static Map b;
    private static Map c;
    private static Map d;
    private static Set e;

    static {
        b = new HashMap();
        c = new HashMap();
        d = new HashMap();
        Set hashSet = new HashSet();
        e = hashSet;
        hashSet.add("加载失败");
        e.add("网络错误");
        e.add("请求失败");
        b = a("{Init:\"10\",_Page_Native:\"11\",_Page_H5:\"12\",Fetch_Config:\"13\",Login:\"14\",InvokeMtop:\"15\",Pay_Result_Alipay:\"16\",Taoke_Trace_Async:\"17\",Taoke_Trace_Sync:\"17\"}");
        c = a("{Taoke_Trace_Async:\"01\",Init:\"01\",Detail_Page:\"01\",Fetch_Config:\"01\",Login:\"01\",Pay_Result_Alipay:\"01\",InvokeMtop:\"01\",Shop_Page:\"02\",Taoke_Trace_Sync:\"02\",Order_Page:\"03\",Cart_Page:\"04\",MyCarts_Page:\"05\",Other_Page:\"07\"}");
        d = a("{无安全图片:\"01\",安全图片不合法:\"02\",参数不合法:\"01\",applink不存在:\"02\",applink调用失败:\"03\",加载失败:\"网络错误码\",校验错误:\"01\",解析错误:\"02\",网络错误:\"网络错误码\",登陆失败:\"01\",查询失败:\"01\",支付失败:\"02\",请求失败:\"请求错误码\"}");
    }

    private static java.util.Map a(java.lang.String r2) {
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
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x000a }
        r0.<init>(r2);	 Catch:{ JSONException -> 0x000a }
        r2 = com.alibaba.baichuan.android.trade.utils.f.a.a(r0);	 Catch:{ JSONException -> 0x000a }
        return r2;
    L_0x000a:
        r2 = a;
        r0 = "getMap";
        r1 = "转换jsonStr为jsonObject失败";
        com.alibaba.baichuan.android.trade.utils.c.a(r2, r0, r1);
        com.alibaba.baichuan.android.trade.utils.g.a.b();
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.trade.adapter.ut.c.a(java.lang.String):java.util.Map");
    }

    public static d a(String str, String str2, String str3) {
        Object obj;
        if (str2 != null) {
            for (String equals : e) {
                if (equals.equals(str2)) {
                    obj = 1;
                    break;
                }
            }
        }
        com.alibaba.baichuan.android.trade.utils.c.a(a, "isContaionInNotNullList", "Param str is null!");
        a.b();
        obj = null;
        if (obj == null || str3 != null) {
            if (!(b == null || c == null)) {
                if (d != null) {
                    String str4;
                    if (b.get(str) != null) {
                        obj = b.get(str);
                    } else {
                        for (String str5 : b.keySet()) {
                            if (str.contains(str5)) {
                                obj = b.get(str5);
                            }
                        }
                        str4 = null;
                        if (c.get(str) == null) {
                            str = c.get(str);
                        } else {
                            for (String str6 : c.keySet()) {
                                if (str.contains(str6)) {
                                    str = c.get(str6);
                                }
                            }
                            str = null;
                            if (!e.contains(str2)) {
                                str3 = (String) d.get(str2);
                            }
                            if (!(str4 == null || str == null)) {
                                if (str3 != null) {
                                    return new d(str4, str, str3, str2);
                                }
                            }
                            com.alibaba.baichuan.android.trade.utils.c.a(a, "getUsabilityMsg", "modelCode/linkCode/errCode is null!");
                            return null;
                        }
                        str = str;
                        if (!e.contains(str2)) {
                            str3 = (String) d.get(str2);
                        }
                        if (str3 != null) {
                            return new d(str4, str, str3, str2);
                        }
                        com.alibaba.baichuan.android.trade.utils.c.a(a, "getUsabilityMsg", "modelCode/linkCode/errCode is null!");
                        return null;
                    }
                    str4 = (String) obj;
                    if (c.get(str) == null) {
                        for (String str62 : c.keySet()) {
                            if (str.contains(str62)) {
                                str = c.get(str62);
                            }
                        }
                        str = null;
                        if (!e.contains(str2)) {
                            str3 = (String) d.get(str2);
                        }
                        if (str3 != null) {
                            return new d(str4, str, str3, str2);
                        }
                        com.alibaba.baichuan.android.trade.utils.c.a(a, "getUsabilityMsg", "modelCode/linkCode/errCode is null!");
                        return null;
                    }
                    str = c.get(str);
                    str = str;
                    if (!e.contains(str2)) {
                        str3 = (String) d.get(str2);
                    }
                    if (str3 != null) {
                        return new d(str4, str, str3, str2);
                    }
                    com.alibaba.baichuan.android.trade.utils.c.a(a, "getUsabilityMsg", "modelCode/linkCode/errCode is null!");
                    return null;
                }
            }
            str = a;
            str2 = "getUsabilityMsg";
            str3 = "modelCodeMap/modelCodeMap/errCodeMap is null !";
        } else {
            str = a;
            str2 = "getUsabilityMsg";
            str3 = "errCode is not right!";
        }
        com.alibaba.baichuan.android.trade.utils.c.a(str, str2, str3);
        return null;
    }
}
