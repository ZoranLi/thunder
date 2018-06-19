package com.xunlei.downloadprovider.homepage.recommend.a;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LikedVideoInfo */
public final class w implements Comparable<w> {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public long f;
    public String g;
    public long h;
    public String i;
    public long j;
    public long k;
    public String l;
    public long m;
    public boolean n = false;
    private long o;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        w wVar = (w) obj;
        if (this.m > wVar.m) {
            return 1;
        }
        return this.m < wVar.m ? -1 : null;
    }

    public static w a(JSONObject jSONObject) throws JSONException {
        w wVar = new w();
        wVar.a = jSONObject.getString("gcid");
        wVar.b = jSONObject.getString("movieid");
        wVar.c = jSONObject.getString("title");
        wVar.d = jSONObject.optString("play_url");
        wVar.e = jSONObject.optString("poster");
        wVar.f = jSONObject.optLong("duration_sec");
        wVar.h = jSONObject.optLong("publisher_id");
        wVar.g = jSONObject.optString("publisher_name");
        wVar.i = jSONObject.optString("publisher_icon_url");
        wVar.k = jSONObject.optLong("praise_num");
        wVar.o = jSONObject.optLong("share_num");
        wVar.j = jSONObject.optLong("play_num");
        wVar.l = jSONObject.optString("row_key");
        wVar.m = jSONObject.optLong("praise_time");
        return wVar;
    }
}
