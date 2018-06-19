package com.xunlei.downloadprovider.comment.entity;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.alipay.sdk.cons.b;
import com.alipay.sdk.packet.d;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: SendCommentRequest */
public class k extends a {
    private static final String j = "k";
    public String a;
    public int b;
    public String c;
    public long d;
    public String e;
    public String f;
    public long g;
    public String h;
    public int i;

    public final /* bridge */ /* synthetic */ String a() {
        return super.a();
    }

    public final /* bridge */ /* synthetic */ String a(HashMap hashMap) {
        return super.a(hashMap);
    }

    protected final HashMap<String, String> b() {
        LoginHelper.a();
        if (l.c()) {
            HashMap<String, String> hashMap = new HashMap();
            hashMap.put(Constants.APP_ID, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_GROUP);
            hashMap.put("v", "1.0");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(super.a());
            hashMap.put("call_id", stringBuilder.toString());
            stringBuilder = new StringBuilder("40:");
            stringBuilder.append(LoginHelper.a().c());
            hashMap.put("session_id", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(LoginHelper.a().g.c());
            hashMap.put("userid", stringBuilder.toString());
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
            hashMap.put("comment", this.e);
            stringBuilder = new StringBuilder("comment");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.e);
            stringBuilder2.append(System.currentTimeMillis() / 10000);
            stringBuilder2.append(LoginHelper.a().g.c());
            stringBuilder.append(stringBuilder2.toString().hashCode());
            hashMap.put("trigger_id", stringBuilder.toString());
            if (!TextUtils.isEmpty(this.f)) {
                hashMap.put(d.n, this.f);
            }
            if (this.d > 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.d);
                hashMap.put("cid", stringBuilder.toString());
            }
            if (!TextUtils.isEmpty(this.h)) {
                hashMap.put("downloadspeed", this.h);
            }
            hashMap.put("extParams", "play_position");
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.i);
            hashMap.put("play_position", stringBuilder.toString());
            return hashMap;
        }
        throw new IllegalStateException("You are not login !!");
    }

    public final JSONObject c() {
        Map b = b();
        String a = a(b);
        b.put("comment", Uri.encode(this.e));
        if (this.d > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.g);
            b.put("ref_uid", stringBuilder.toString());
            b.put("username", LoginHelper.a().g.d());
        }
        b.put(INoCaptchaComponent.sig, a);
        return new JSONObject(b);
    }
}
