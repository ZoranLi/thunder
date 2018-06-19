package com.igexin.push.core.bean;

import android.os.Build;
import android.os.Build.VERSION;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.igexin.push.core.g;
import com.igexin.push.util.l;
import com.igexin.sdk.GTServiceManager;
import com.igexin.sdk.PushBuildConfig;
import com.umeng.message.MsgConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

public class a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f = "open";
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public long n;

    public a() {
        StringBuilder stringBuilder;
        if (g.e != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.f);
            stringBuilder.append(Constants.COLON_SEPARATOR);
            stringBuilder.append(g.e);
            this.f = stringBuilder.toString();
        }
        this.e = PushBuildConfig.sdk_conf_version;
        this.b = g.u;
        this.c = g.t;
        this.d = g.w;
        this.i = g.x;
        this.a = g.v;
        this.h = "ANDROID";
        stringBuilder = new StringBuilder(DispatchConstants.ANDROID);
        stringBuilder.append(VERSION.RELEASE);
        this.j = stringBuilder.toString();
        this.k = "MDP";
        this.g = g.y;
        this.n = System.currentTimeMillis();
        this.l = g.z;
        this.m = Build.BRAND;
    }

    public static String a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(com.taobao.accs.common.Constants.KEY_MODEL, aVar.a == null ? "" : aVar.a);
        jSONObject.put("sim", aVar.b == null ? "" : aVar.b);
        jSONObject.put("imei", aVar.c == null ? "" : aVar.c);
        jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_MAC, aVar.d == null ? "" : aVar.d);
        jSONObject.put("version", aVar.e == null ? "" : aVar.e);
        jSONObject.put("channelid", aVar.f == null ? "" : aVar.f);
        jSONObject.put("type", "ANDROID");
        jSONObject.put("app", aVar.k == null ? "" : aVar.k);
        String str = "deviceid";
        StringBuilder stringBuilder = new StringBuilder("ANDROID-");
        stringBuilder.append(aVar.g == null ? "" : aVar.g);
        jSONObject.put(str, stringBuilder.toString());
        jSONObject.put(MsgConstant.KEY_DEVICE_TOKEN, aVar.l == null ? "" : aVar.l);
        jSONObject.put("brand", aVar.m == null ? "" : aVar.m);
        jSONObject.put("system_version", aVar.j == null ? "" : aVar.j);
        jSONObject.put("cell", aVar.i == null ? "" : aVar.i);
        jSONObject.put("aid", l.b());
        jSONObject.put("adid", l.c());
        str = GTServiceManager.getInstance().getUserPushService(g.f).getName();
        if (!com.igexin.push.core.a.n.equals(str)) {
            jSONObject.put("us", str);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("action", "addphoneinfo");
        jSONObject2.put(AgooConstants.MESSAGE_ID, String.valueOf(aVar.n));
        jSONObject2.put("info", jSONObject);
        return jSONObject2.toString();
    }
}
