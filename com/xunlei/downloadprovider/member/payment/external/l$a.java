package com.xunlei.downloadprovider.member.payment.external;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: XLPaySDKManager */
public final class l$a {
    public String a;
    public String b;
    public String c;
    public PayUtil$OrderType d;
    public int e;
    public boolean f;
    public int g;
    public int h;
    public float i;
    public float j;
    public String k;

    public l$a(int i, int i2, PayUtil$OrderType payUtil$OrderType, int i3, float f, boolean z) {
        this.h = i;
        this.e = i2;
        this.d = payUtil$OrderType;
        this.g = i3;
        this.i = f;
        this.f = z;
    }

    public final JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.a)) {
                jSONObject.put("key:voucher", this.a);
            }
            if (!TextUtils.isEmpty(this.b)) {
                this.b = l.a(this.b);
                jSONObject.put("key:ext", this.b);
            }
            if (!TextUtils.isEmpty(this.c)) {
                jSONObject.put("key:activity_id", this.c);
            }
            if (!TextUtils.isEmpty(this.k)) {
                jSONObject.put("key:aid_from", this.k);
            }
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final int b() {
        if (TextUtils.isEmpty(this.a)) {
            return 0;
        }
        return (int) this.j;
    }
}
