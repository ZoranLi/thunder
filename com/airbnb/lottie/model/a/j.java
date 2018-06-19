package com.airbnb.lottie.model.a;

import android.graphics.Color;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.airbnb.lottie.a.b.o;
import com.airbnb.lottie.model.d;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.xunlei.downloadprovider.ad.home.a.f;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AnimatableTextFrame */
public final class j extends o<d, d> {

    /* compiled from: AnimatableTextFrame */
    private static class a implements com.airbnb.lottie.model.a.m.a<d> {
        private static final a a = new a();

        private a() {
        }

        public final /* synthetic */ Object a(Object obj, float f) {
            int i;
            int argb;
            JSONObject jSONObject = (JSONObject) obj;
            String optString = jSONObject.optString(DispatchConstants.TIMESTAMP);
            String optString2 = jSONObject.optString(f.a);
            int optInt = jSONObject.optInt("s");
            int optInt2 = jSONObject.optInt("j");
            int optInt3 = jSONObject.optInt("tr");
            double optDouble = jSONObject.optDouble(IXAdRequestInfo.QUERY_HEIGHT);
            JSONArray optJSONArray = jSONObject.optJSONArray("fc");
            String str = optString;
            int argb2 = Color.argb(255, (int) (optJSONArray.optDouble(0) * 255.0d), (int) (optJSONArray.optDouble(1) * 255.0d), (int) (optJSONArray.optDouble(2) * 255.0d));
            optJSONArray = jSONObject.optJSONArray("sc");
            if (optJSONArray != null) {
                i = argb2;
                argb = Color.argb(255, (int) (optJSONArray.optDouble(0) * 255.0d), (int) (optJSONArray.optDouble(1) * 255.0d), (int) (optJSONArray.optDouble(2) * 255.0d));
            } else {
                i = argb2;
                argb = 0;
            }
            return new d(str, optString2, optInt, optInt2, optInt3, optDouble, i, argb, jSONObject.optInt(IXAdRequestInfo.SCREEN_WIDTH), jSONObject.optBoolean("of"));
        }
    }

    public final /* synthetic */ com.airbnb.lottie.a.b.a a() {
        return c();
    }

    public j(List<com.airbnb.lottie.a.a<d>> list, d dVar) {
        super(list, dVar);
    }

    public final o c() {
        return new o(this.a);
    }
}
