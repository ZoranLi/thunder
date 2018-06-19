package com.xunlei.common.new_ptl.pay.c;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants.KEYS;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.base.XLUtilTools;
import com.xunlei.common.new_ptl.pay.XLPayErrorCode;
import com.xunlei.common.new_ptl.pay.a.h;
import com.xunlei.common.new_ptl.pay.b.a.b;
import org.json.JSONObject;

/* compiled from: XLAlipayTask */
final class a$1 extends b {
    final /* synthetic */ a a;

    a$1(a aVar) {
        this.a = aVar;
    }

    public final void a(String str) {
        String g = a.g();
        StringBuilder stringBuilder = new StringBuilder("getPayBusinessOrder buffer = ");
        stringBuilder.append(str);
        XLLog.v(g, stringBuilder.toString());
        try {
            JSONObject jSONObject = new JSONObject(XLUtilTools.parseJSONPString(str));
            if (jSONObject.optInt(KEYS.RET, XLPayErrorCode.XLP_GET_ORDER_ERROR) == -1) {
                a.a(this.a, jSONObject.optString("msg"));
                a.a(this.a, jSONObject.optInt("errcode", XLPayErrorCode.XLP_GET_ORDER_ERROR));
                return;
            }
            str = jSONObject.getJSONObject("data");
            Object string = str.getString("payInfo");
            a.b(this.a, str.getString("orderId"));
            if (TextUtils.isEmpty(string) == null) {
                a.c(this.a, string);
                a.b(this.a, 1);
                a.e().c().post(new Runnable(this) {
                    private /* synthetic */ a$1 a;

                    {
                        this.a = r1;
                    }

                    public final void run() {
                        this.a.a.c();
                    }
                });
                return;
            }
            a.b(this.a, 2);
            a.a(this.a, XLPayErrorCode.XLP_GET_ORDER_ERROR);
        } catch (String str2) {
            str2.printStackTrace();
            XLLog.e(a.g(), "getPayBusinessOrder json error.");
        }
    }

    public final void a(Throwable th) {
        String g = a.g();
        StringBuilder stringBuilder = new StringBuilder("getPayBusinessOrder error = ");
        stringBuilder.append(th.getMessage());
        XLLog.e(g, stringBuilder.toString());
        a.a(this.a, h.a(th));
    }
}
