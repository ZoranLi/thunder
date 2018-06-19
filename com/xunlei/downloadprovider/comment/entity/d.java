package com.xunlei.downloadprovider.comment.entity;

import com.alipay.sdk.cons.b;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import java.util.HashMap;

/* compiled from: CommentListRequest */
public class d extends a {
    private static final String h = "d";
    public String a;
    public int b;
    public long c;
    public String d;
    public int e;
    public String f;
    public String g;

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
        LoginHelper.a();
        if (l.c()) {
            stringBuilder = new StringBuilder("40:");
            stringBuilder.append(LoginHelper.a().c());
            hashMap.put("session_id", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(LoginHelper.a().g.c());
            hashMap.put("userid", stringBuilder.toString());
        }
        String str = b.c;
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        hashMap.put(str, stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.b);
        hashMap.put("type_id", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        hashMap.put("last_id", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.d);
        hashMap.put("source_id", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.g);
        hashMap.put("type", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.e);
        hashMap.put("page_size", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.f);
        hashMap.put("category", stringBuilder.toString());
        return hashMap;
    }

    public final String c() {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap b = b();
        for (String str : b.keySet()) {
            String str2 = (String) b.get(str);
            stringBuilder.append(str);
            stringBuilder.append("=");
            stringBuilder.append(str2);
            stringBuilder.append("&");
        }
        stringBuilder.append("sig=");
        stringBuilder.append(a(b));
        return stringBuilder.toString();
    }
}
