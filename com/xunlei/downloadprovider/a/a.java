package com.xunlei.downloadprovider.a;

import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.downloadprovider.d.a.h;
import java.util.ArrayList;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ActivityConfig */
public final class a extends h {
    private static a c;
    public g[] a;
    public boolean b = false;

    private a() {
        super("http://api-shoulei-ssl.xunlei.com/pss/static/popup_activity/config.json");
    }

    public static a a() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    protected final void a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            this.b = true;
            return;
        }
        int length = jSONArray.length();
        this.a = new g[length];
        for (int i = 0; i < length; i++) {
            g[] gVarArr = this.a;
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            g gVar = new g();
            gVar.a = optJSONObject.optInt(AgooConstants.MESSAGE_ID);
            gVar.b = optJSONObject.optString("title");
            gVar.c = optJSONObject.optString(SocializeConstants.KEY_PIC);
            gVar.d = optJSONObject.optString(SocializeConstants.KEY_TEXT);
            gVar.e = optJSONObject.optString("url");
            gVar.f = optJSONObject.optLong("begin_time");
            gVar.g = optJSONObject.optLong("end_time");
            JSONArray optJSONArray = optJSONObject.optJSONArray("version");
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("channel");
            if (optJSONArray != null) {
                gVar.h = new ArrayList(optJSONArray.length());
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    gVar.h.add(Integer.valueOf(optJSONArray.optInt(i2)));
                }
            }
            if (optJSONArray2 != null) {
                gVar.i = new ArrayList(optJSONArray2.length());
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    gVar.i.add(optJSONArray2.optString(i3));
                }
            }
            gVarArr[i] = gVar;
        }
        this.b = false;
    }
}
