package com.xunlei.downloadprovider.comment.entity;

import com.alipay.sdk.cons.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;

/* compiled from: ReportCommentRequest */
public class j extends a {
    private static final String f = "j";
    public String a;
    public String b;
    public int c;
    public long d;
    public int e;

    public final /* bridge */ /* synthetic */ String a() {
        return super.a();
    }

    public final /* bridge */ /* synthetic */ String a(HashMap hashMap) {
        return super.a(hashMap);
    }

    protected final HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put(Constants.APP_ID, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_GROUP);
        hashMap.put("v", "1.0");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.a());
        hashMap.put("call_id", stringBuilder.toString());
        String str = b.c;
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        hashMap.put(str, stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.b);
        hashMap.put("source_id", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        hashMap.put("type_id", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.d);
        hashMap.put("cid", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.e);
        hashMap.put("type", stringBuilder.toString());
        return hashMap;
    }

    public final String c() {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap b = b();
        String a = a(b);
        for (String str : b.keySet()) {
            String str2 = (String) b.get(str);
            stringBuilder.append(str);
            stringBuilder.append("=");
            stringBuilder.append(str2);
            stringBuilder.append("&");
        }
        stringBuilder.append("sig=");
        stringBuilder.append(a);
        return stringBuilder.toString();
    }
}
