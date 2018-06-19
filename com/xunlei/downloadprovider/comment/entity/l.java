package com.xunlei.downloadprovider.comment.entity;

import com.alipay.sdk.cons.b;
import com.android.volley.Request;
import com.android.volley.n;
import com.android.volley.n.a;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: SendLikeRequest */
public class l extends a {
    private static final String f = "l";
    public String a;
    public int b;
    public String c;
    public long d;
    public long e;

    public final /* bridge */ /* synthetic */ String a() {
        return super.a();
    }

    public final /* bridge */ /* synthetic */ String a(HashMap hashMap) {
        return super.a(hashMap);
    }

    protected HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put(Constants.APP_ID, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_GROUP);
        hashMap.put("v", "1.0");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.a());
        hashMap.put("call_id", stringBuilder.toString());
        LoginHelper.a();
        if (com.xunlei.downloadprovider.member.login.b.l.c()) {
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
        hashMap.put("source_id", stringBuilder.toString());
        hashMap.put("type", "1");
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.d);
        hashMap.put("cid", stringBuilder.toString());
        return hashMap;
    }

    private final String c() {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap b = b();
        String a = a(b);
        LoginHelper.a();
        if (com.xunlei.downloadprovider.member.login.b.l.c()) {
            b.put("username", LoginHelper.a().g.d());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.e);
        b.put("ref_uid", stringBuilder2.toString());
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

    public final Request<JSONObject> a(n.b<JSONObject> bVar, a aVar) {
        StringBuilder stringBuilder = new StringBuilder("https://comment-shoulei-ssl.xunlei.com/comment/api/comment_count?");
        stringBuilder.append(c());
        return new h(0, stringBuilder.toString(), null, bVar, aVar);
    }
}
