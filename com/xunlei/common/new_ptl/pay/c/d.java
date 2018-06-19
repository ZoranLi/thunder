package com.xunlei.common.new_ptl.pay.c;

import android.text.TextUtils;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.pay.XLPayErrorCode;
import com.xunlei.common.new_ptl.pay.XLPayType;
import com.xunlei.common.new_ptl.pay.a.e;
import com.xunlei.common.new_ptl.pay.a.f;
import com.xunlei.common.new_ptl.pay.a.h;
import com.xunlei.common.new_ptl.pay.a.i;
import com.xunlei.common.new_ptl.pay.b.a.a;
import com.xunlei.common.new_ptl.pay.param.XLPayParam;
import com.xunlei.common.new_ptl.pay.param.XLWxPayParam;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;

/* compiled from: XLWxPayTask */
public class d extends h {
    private static int e = 0;
    private static int f = 1;
    private static int g = 2;
    private static final String h = "d";
    private XLWxPayParam i;
    private e j;
    private int k;
    private String l;
    private String m;

    public d() {
        this.i = null;
        this.j = null;
        this.k = 0;
        this.l = null;
        this.m = "";
        this.a = XLPayType.XL_WX_PAY;
    }

    public final void a(int i) {
        String str = h;
        StringBuilder stringBuilder = new StringBuilder("xlWxPay acceptWxPayResult errorcode = ");
        stringBuilder.append(i);
        XLLog.v(str, stringBuilder.toString());
        int i2 = i == 0 ? 0 : 53;
        if (i == -2) {
            i2 = 51;
        }
        if (i == -4) {
            i2 = 52;
        }
        b(i2);
    }

    public final void c() {
        if (this.k == 0) {
            String str = "https://agent-paycenter-ssl.xunlei.com/newsdk/order";
            if (this.d) {
                str = "https://agent-paycenter-ssl.xunlei.com/newsdk/act";
            }
            String a = this.j.a(this.a);
            String str2 = h;
            StringBuilder stringBuilder = new StringBuilder("getPayBusinessOrder wx pay param = ");
            stringBuilder.append(a);
            XLLog.v(str2, stringBuilder.toString());
            a.a().a(str, a.getBytes(), new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, new 1(this));
            return;
        }
        if (this.k == 1) {
            a(this.l);
        }
    }

    public final void a(XLPayParam xLPayParam) {
        this.i = (XLWxPayParam) xLPayParam;
        a((boolean) this.i.mActPay);
        this.j = f.a(this.i);
    }

    public final XLPayParam d() {
        return this.i;
    }

    private void h() {
        String str = "https://agent-paycenter-ssl.xunlei.com/newsdk/order";
        if (this.d) {
            str = "https://agent-paycenter-ssl.xunlei.com/newsdk/act";
        }
        String a = this.j.a(this.a);
        String str2 = h;
        StringBuilder stringBuilder = new StringBuilder("getPayBusinessOrder wx pay param = ");
        stringBuilder.append(a);
        XLLog.v(str2, stringBuilder.toString());
        a.a().a(str, a.getBytes(), new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, new 1(this));
    }

    private void b(int i) {
        if (this.b != null) {
            XLLog.v(h, "xlWxPay callBack To local listener");
            this.b.onWxPay(i, XLPayErrorCode.getErrorDesc(i), f(), this.m, b());
            return;
        }
        if (TextUtils.isEmpty(this.c)) {
            this.c = XLPayErrorCode.getErrorDesc(i);
        }
        String str = h;
        StringBuilder stringBuilder = new StringBuilder("xlWxPay callBack To global listener errorcode = ");
        stringBuilder.append(i);
        XLLog.v(str, stringBuilder.toString());
        i.a().a(Integer.valueOf(XLPayType.XL_WX_PAY), Integer.valueOf(i), this.c, f(), this.m, Integer.valueOf(b()));
    }

    private boolean a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = new PayReq();
            str.appId = jSONObject.getString("appId");
            str.partnerId = jSONObject.getString("partnerId");
            str.prepayId = jSONObject.getString("prepayId");
            str.nonceStr = jSONObject.getString("nonceStr");
            str.timeStamp = jSONObject.getString("timeStamp");
            str.packageValue = jSONObject.getString("packageValue");
            str.sign = jSONObject.getString("sign");
            str.extData = String.valueOf(b());
            str.transaction = "xl_sdk_wx_pay_req";
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(i.a().d(), this.i.mAppId);
            if (createWXAPI.isWXAppInstalled()) {
                createWXAPI.registerApp(this.i.mAppId);
                createWXAPI.sendReq(str);
                return true;
            }
            b(54);
            return false;
        } catch (String str2) {
            str2.printStackTrace();
            String str3 = h;
            StringBuilder stringBuilder = new StringBuilder("sendWeiXinReq error = ");
            stringBuilder.append(str2.getMessage());
            XLLog.e(str3, stringBuilder.toString());
            b(50);
            return false;
        }
    }
}
