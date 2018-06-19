package com.xunlei.common.new_ptl.pay.c;

import android.text.TextUtils;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.pay.XLPayErrorCode;
import com.xunlei.common.new_ptl.pay.XLPayType;
import com.xunlei.common.new_ptl.pay.a.e;
import com.xunlei.common.new_ptl.pay.a.f;
import com.xunlei.common.new_ptl.pay.a.g;
import com.xunlei.common.new_ptl.pay.a.h;
import com.xunlei.common.new_ptl.pay.a.i;
import com.xunlei.common.new_ptl.pay.param.XLAlipayParam;
import com.xunlei.common.new_ptl.pay.param.XLPayParam;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/* compiled from: XLAlipayTask */
public class a extends h {
    private static final String e = "a";
    private static int f = 0;
    private static int g = 1;
    private static int h = 2;
    private XLAlipayParam i;
    private e j;
    private int k;
    private String l;
    private String m;

    public a(int i) {
        this.i = null;
        this.j = null;
        this.k = 0;
        this.l = null;
        this.m = "";
        this.a = XLPayType.XL_ALI_PAY;
    }

    public final void c() {
        if (this.k == 0) {
            String str = "https://agent-paycenter-ssl.xunlei.com/newsdk/order";
            if (this.d) {
                str = "https://agent-paycenter-ssl.xunlei.com/newsdk/act";
            }
            String a = this.j.a(this.a);
            String str2 = e;
            StringBuilder stringBuilder = new StringBuilder("getPayBusinessOrder ali param = ");
            stringBuilder.append(a);
            XLLog.v(str2, stringBuilder.toString());
            com.xunlei.common.new_ptl.pay.b.a.a.a().a(str, a.getBytes(), new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, new 1(this));
            return;
        }
        if (this.k == 1) {
            XLLog.v(e, "start alipay app to xlAliPay");
            new Thread(new 2(this)).start();
        }
    }

    public final void a(XLPayParam xLPayParam) {
        this.i = (XLAlipayParam) xLPayParam;
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
        String str2 = e;
        StringBuilder stringBuilder = new StringBuilder("getPayBusinessOrder ali param = ");
        stringBuilder.append(a);
        XLLog.v(str2, stringBuilder.toString());
        com.xunlei.common.new_ptl.pay.b.a.a.a().a(str, a.getBytes(), new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, new 1(this));
    }

    private void a(int i) {
        if (this.b != null) {
            XLLog.v(e, "xlAliPay callBack To local listener");
            this.b.onAliPay(i, XLPayErrorCode.getErrorDesc(i), f(), this.m, b());
            return;
        }
        if (TextUtils.isEmpty(this.c)) {
            this.c = XLPayErrorCode.getErrorDesc(i);
        }
        String str = e;
        StringBuilder stringBuilder = new StringBuilder("xlAliPay callBack To global listener errorcode = ");
        stringBuilder.append(i);
        XLLog.v(str, stringBuilder.toString());
        i.a().a(Integer.valueOf(this.a), Integer.valueOf(i), this.c, f(), this.m, Integer.valueOf(b()));
    }

    private void i() {
        XLLog.v(e, "start alipay app to xlAliPay");
        new Thread(new 2(this)).start();
    }

    private void a(g gVar) {
        String str = e;
        StringBuilder stringBuilder = new StringBuilder("xlAliPay acceptAlipayResult ");
        stringBuilder.append(gVar.toString());
        XLLog.v(str, stringBuilder.toString());
        if (gVar.a.equals("9000")) {
            if (gVar.b.indexOf("success=\"true\"") != -1) {
                a((int) null);
                return;
            }
            XLLog.v(e, "xlAliPay acceptAlipayResult not 9000");
        }
        if (gVar.a.equals("6001") != null) {
            a(101);
        } else {
            a(100);
        }
    }

    static /* synthetic */ void a(a aVar, g gVar) {
        String str = e;
        StringBuilder stringBuilder = new StringBuilder("xlAliPay acceptAlipayResult ");
        stringBuilder.append(gVar.toString());
        XLLog.v(str, stringBuilder.toString());
        if (gVar.a.equals("9000")) {
            if (gVar.b.indexOf("success=\"true\"") != -1) {
                aVar.a((int) null);
                return;
            }
            XLLog.v(e, "xlAliPay acceptAlipayResult not 9000");
        }
        if (gVar.a.equals("6001") != null) {
            aVar.a(101);
        } else {
            aVar.a(100);
        }
    }
}
