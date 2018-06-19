package com.xunlei.common.new_ptl.pay.c;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants.KEYS;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.base.XLUtilTools;
import com.xunlei.common.new_ptl.pay.XLPayErrorCode;
import com.xunlei.common.new_ptl.pay.a.h;
import com.xunlei.common.new_ptl.pay.b.a.b;
import org.json.JSONObject;

/* compiled from: XLWxPayTask */
final class d$1 extends b {
    final /* synthetic */ d a;

    d$1(d dVar) {
        this.a = dVar;
    }

    public final void a(String str) {
        String g = d.g();
        StringBuilder stringBuilder = new StringBuilder("getPayBusinessOrder buffer = ");
        stringBuilder.append(str);
        XLLog.v(g, stringBuilder.toString());
        str = XLUtilTools.parseJSONPString(str);
        XLLog.v(d.g(), "weixin pay task final succeed!");
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(KEYS.RET, XLPayErrorCode.XLP_GET_ORDER_ERROR) == -1) {
                d.a(this.a, jSONObject.optString("msg"));
                d.a(this.a, jSONObject.optInt("errcode", XLPayErrorCode.XLP_GET_ORDER_ERROR));
                return;
            }
            str = jSONObject.getJSONObject("data");
            Object string = str.getString("payInfo");
            d.b(this.a, str.getString("orderId"));
            if (TextUtils.isEmpty(string) == null) {
                d.c(this.a, string);
                d.b(this.a, 1);
                d.e().c().post(new Runnable(this) {
                    private /* synthetic */ d$1 a;

                    {
                        this.a = r1;
                    }

                    public final void run() {
                        this.a.a.c();
                    }
                });
                return;
            }
            d.b(this.a, 2);
            d.a(this.a, XLPayErrorCode.XLP_GET_ORDER_ERROR);
        } catch (String str2) {
            str2.printStackTrace();
            XLLog.e(d.g(), "getPayBusinessOrder json error.");
        }
    }

    public final void a(Throwable th) {
        String g = d.g();
        StringBuilder stringBuilder = new StringBuilder("getPayBusinessOrder error = ");
        stringBuilder.append(th.getMessage());
        XLLog.e(g, stringBuilder.toString());
        g = d.g();
        stringBuilder = new StringBuilder("weixin pay task final failed error = ");
        stringBuilder.append(th.getMessage());
        XLLog.v(g, stringBuilder.toString());
        d.a(this.a, h.a(th));
    }
}
