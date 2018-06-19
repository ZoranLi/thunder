package com.xunlei.downloadprovider.homepage.choiceness.a.a;

import com.xunlei.downloadprovider.publiser.visitors.model.Gender;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import org.json.JSONObject;

/* compiled from: ChoicenessLiveGroupItemInfo */
public final class g {
    private Gender A;
    public String a;
    public int b;
    public String c;
    public int d;
    public String e;
    public int f;
    public String g;
    public String h;
    public String i;
    public int j;
    public long k;
    public String l;
    public int m;
    public String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private int s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private int y;
    private String z;

    public static g a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        g gVar = new g();
        gVar.i = jSONObject.optString(PushResult.ROOM_INFO);
        gVar.a = jSONObject.optString("userid");
        gVar.o = jSONObject.optString("uid");
        gVar.b = jSONObject.optInt("hosttype");
        gVar.m = jSONObject.optInt("sign");
        gVar.n = jSONObject.optString("tag");
        gVar.h = jSONObject.optString("room_gif");
        gVar.c = jSONObject.optString("livestat");
        gVar.f = jSONObject.optInt("recommend");
        gVar.g = jSONObject.optString("res_cover_url");
        gVar.l = jSONObject.optString("sdk_id");
        gVar.u = jSONObject.optString("push_start_time");
        gVar.v = jSONObject.optString("push_end_time");
        gVar.y = jSONObject.optInt("room_status");
        gVar.x = jSONObject.optString("res_title");
        gVar.q = jSONObject.optString("cover_item");
        gVar.e = jSONObject.optString("nickname").trim();
        gVar.w = jSONObject.optString("push_status");
        gVar.t = jSONObject.optString("icon");
        gVar.s = jSONObject.optInt("level");
        gVar.j = jSONObject.optInt("room_onlinenum");
        gVar.d = jSONObject.optInt("grayid");
        gVar.z = jSONObject.optString("roomid");
        gVar.p = jSONObject.optString("avatar_url");
        gVar.k = jSONObject.optLong("room_point");
        gVar.r = jSONObject.optString("expect_exposure_num");
        jSONObject = jSONObject.optInt("sex");
        if (jSONObject == 1) {
            gVar.A = Gender.MALE;
        } else if (jSONObject == 2) {
            gVar.A = Gender.FEMALE;
        } else {
            gVar.A = Gender.UNKNOWN;
        }
        return gVar;
    }
}
