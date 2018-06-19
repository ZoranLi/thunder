package com.xunlei.downloadprovider.member.payment.activity;

import android.text.TextUtils;
import com.alipay.sdk.packet.d;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.downloadprovider.member.payment.bean.IPayMeal;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import org.json.JSONObject;

/* compiled from: ActivityConfigItem */
public final class b implements IPayMeal {
    public int a;
    public double b;
    public double c;
    public String d;
    public String e;
    public String f;
    public String g;
    public int h;
    public String i;
    public String j;
    public boolean k;
    public float l;
    public float m;
    public boolean n = true;
    public int o = -1;
    public int p = -1;
    public String q;
    public int r;
    public String s;
    public boolean t;

    public final int getType() {
        return 1;
    }

    public final int getRealPayMonth() {
        if (a()) {
            return Integer.MAX_VALUE;
        }
        return this.n ? this.a : this.h;
    }

    public final float getRealPayPrice() {
        if (a()) {
            return (float) this.b;
        }
        return (float) (this.n ? this.b : (double) this.l);
    }

    public final float getSaveAmount() {
        if (a()) {
            return 0.0f;
        }
        if (!TextUtils.isEmpty(this.e) && this.n) {
            return 0.0f;
        }
        if (this.n) {
            return (float) (this.c - this.b);
        }
        return PayUtil.a(this.h, this.m, this.l);
    }

    public final int getLocateMonth() {
        return this.h;
    }

    public final void setIsTotalPriceMode(boolean z) {
        this.t = z;
    }

    static b a(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.a = jSONObject.getInt("month");
        bVar.b = jSONObject.optDouble("price", 0.0d);
        bVar.c = jSONObject.optDouble("orgin_price", 0.0d);
        bVar.d = jSONObject.optString("tips");
        bVar.e = jSONObject.optString("pay_award");
        bVar.f = jSONObject.optString(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND);
        bVar.g = jSONObject.getString("activeid");
        bVar.h = jSONObject.optInt("locate_month");
        bVar.i = jSONObject.optString("avg_price");
        bVar.j = jSONObject.optString("month_name");
        JSONObject optJSONObject = jSONObject.optJSONObject("limit");
        if (optJSONObject != null) {
            bVar.o = optJSONObject.optInt(MessageInfo.USER);
            bVar.p = optJSONObject.optInt(d.n);
        }
        bVar.q = jSONObject.optString("side_tips");
        return bVar;
    }

    public final boolean a() {
        if (!TextUtils.equals("vip2017bjautorenew", this.s)) {
            if (!TextUtils.equals("vip2017svipautorenew", this.s)) {
                return false;
            }
        }
        return true;
    }
}
