package com.xunlei.downloadprovider.comment.entity;

import com.alipay.sdk.cons.b;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import java.util.HashMap;

/* compiled from: SyncLikeRequest */
public final class m extends l {
    public boolean f;

    protected final HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put(Constants.APP_ID, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_START_GROUP);
        hashMap.put("v", "1.0");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a());
        hashMap.put("call_id", stringBuilder.toString());
        if (this.f) {
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
}
