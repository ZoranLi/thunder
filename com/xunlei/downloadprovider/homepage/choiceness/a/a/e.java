package com.xunlei.downloadprovider.homepage.choiceness.a.a;

import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChoicenessInfo */
public class e extends a {
    public int k;
    public String l;
    public String m;

    public boolean e() {
        return "short_video".equals(this.l);
    }

    public boolean d() {
        return "advertisement".equals(this.l);
    }

    public final boolean g() {
        return "live".equals(this.l);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ChoicenessInfo{mDisplayType=");
        stringBuilder.append(this.k);
        stringBuilder.append(", mResType='");
        stringBuilder.append(this.l);
        stringBuilder.append('\'');
        stringBuilder.append(", mResId='");
        stringBuilder.append(b());
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final e h() throws CloneNotSupportedException {
        return (e) super.f();
    }

    protected static void a(e eVar, JSONObject jSONObject) throws JSONException {
        eVar.k = jSONObject.getInt(PushResult.DISPLAY_TYPE);
        eVar.l = jSONObject.getString(PushResult.RES_TYPE);
        eVar.i = jSONObject.optString("res_id");
        eVar.m = jSONObject.optString("ext_data");
    }

    public final /* bridge */ /* synthetic */ a f() throws CloneNotSupportedException {
        return (e) super.f();
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (e) super.f();
    }
}
