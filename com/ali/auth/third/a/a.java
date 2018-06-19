package com.ali.auth.third.a;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.ali.auth.third.core.f.d;
import com.ali.auth.third.core.h.e;
import com.ali.auth.third.core.rpc.protocol.RpcException;
import com.ali.auth.third.ui.LoginWebViewActivity;
import com.alipay.sdk.cons.c;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static final a b = new a();
    public volatile boolean a;

    private a() {
    }

    public static String a(String str) {
        com.ali.auth.third.core.c.a.a(e.class);
        TreeMap treeMap = new TreeMap();
        treeMap.put("appKey", com.ali.auth.third.core.c.a.a());
        treeMap.put("apkSign", str);
        treeMap.put(c.n, "taobao.oauth.code.create");
        str = a(treeMap);
        com.ali.auth.third.core.f.c cVar = new com.ali.auth.third.core.f.c();
        cVar.a = "com.alibaba.havana.login.applink.generateTopAppLinkToken";
        cVar.b = "1.0";
        String a = com.ali.auth.third.core.c.a.a();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appName", a);
            a = DispatchConstants.TIMESTAMP;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(System.currentTimeMillis());
            jSONObject.put(a, stringBuilder.toString());
            jSONObject.put("clientIp", com.ali.auth.third.core.j.a.c());
            if (com.ali.auth.third.core.c.a.a) {
                a = Constants.APP_ID;
                stringBuilder = new StringBuilder();
                stringBuilder.append(com.ali.auth.third.core.c.a.c.getPackageName());
                stringBuilder.append("|");
                stringBuilder.append(com.ali.auth.third.core.c.a.d());
                jSONObject.put(a, stringBuilder.toString());
            }
            jSONObject.put(com.taobao.accs.common.Constants.KEY_SDK_VERSION, com.ali.auth.third.core.c.a.b);
            cVar.a("baseInfo", jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        cVar.a("content", str);
        try {
            d a2 = ((com.ali.auth.third.core.h.c) com.ali.auth.third.core.c.a.a(com.ali.auth.third.core.h.c.class)).a();
            return a2 != null ? (String) a2.a : null;
        } catch (RpcException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String a(TreeMap<String, String> treeMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : treeMap.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
                stringBuilder.append(str);
                stringBuilder.append(str2);
            }
        }
        return stringBuilder.toString();
    }

    public final void a(Activity activity) {
        if (this.a) {
            b(activity);
        } else {
            new d(this, com.ali.auth.third.core.c.a.c(), activity).execute(new Void[0]);
        }
    }

    public static void b(Activity activity) {
        Intent intent = new Intent(activity, LoginWebViewActivity.class);
        LoginWebViewActivity.c = activity;
        intent.putExtra("url", com.ali.auth.third.core.config.a.e);
        intent.putExtra("title", com.ali.auth.third.core.j.e.a("com_taobao_tae_sdk_authorize_title"));
        activity.startActivityForResult(intent, c.b);
        activity = com.ali.auth.third.core.config.a.a;
    }
}
