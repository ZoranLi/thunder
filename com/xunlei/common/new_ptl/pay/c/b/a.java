package com.xunlei.common.new_ptl.pay.c.b;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants.KEYS;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.base.XLUtilTools;
import com.xunlei.common.new_ptl.pay.XLContractResp;
import com.xunlei.common.new_ptl.pay.XLPayErrorCode;
import com.xunlei.common.new_ptl.pay.XLPayType;
import com.xunlei.common.new_ptl.pay.a.e;
import com.xunlei.common.new_ptl.pay.a.f;
import com.xunlei.common.new_ptl.pay.a.h;
import com.xunlei.common.new_ptl.pay.a.i;
import com.xunlei.common.new_ptl.pay.b.a.b;
import com.xunlei.common.new_ptl.pay.param.XLPayParam;
import com.xunlei.common.new_ptl.pay.param.XLWxDisContractParam;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;

/* compiled from: XLWxContractCancleTask */
public class a extends h {
    private static final String e = "a";
    private static int f = 268435463;
    private static int h = 0;
    private static int i = 1;
    private XLWxDisContractParam g = null;
    private int j = 0;
    private e k = null;

    public final void c() {
        if (this.j == 0) {
            String c = this.k.c(f);
            String str = e;
            StringBuilder stringBuilder = new StringBuilder("generateDiscontractUrl wx param = ");
            stringBuilder.append(c);
            XLLog.v(str, stringBuilder.toString());
            byte[] bytes = c.getBytes();
            Header[] headerArr = new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)};
            com.xunlei.common.new_ptl.pay.b.a.a.a().a("https://agent-paycenter-ssl.xunlei.com/newsdk/monthUnsignServlet", bytes, headerArr, new b(this) {
                private /* synthetic */ a a;

                {
                    this.a = r1;
                }

                public final void a(String str) {
                    String g = a.e;
                    StringBuilder stringBuilder = new StringBuilder("getPayBusinessOrder buffer = ");
                    stringBuilder.append(str);
                    XLLog.v(g, stringBuilder.toString());
                    try {
                        JSONObject jSONObject = new JSONObject(XLUtilTools.parseJSONPString(str));
                        str = jSONObject.optInt(KEYS.RET, 56);
                        if (str == -1) {
                            this.a.c = jSONObject.optString("msg");
                            a.a(this.a, jSONObject.optInt("errcode", 56));
                        }
                        if (str == 200) {
                            a.a(this.a, 0);
                        } else {
                            a.a(this.a, 103);
                        }
                    } catch (String str2) {
                        str2.printStackTrace();
                        XLLog.e(a.e, "getPayBusinessOrder json error.");
                        this.a.j = 1;
                        a.a(this.a, 56);
                    }
                }

                public final void a(Throwable th) {
                    String g = a.e;
                    StringBuilder stringBuilder = new StringBuilder("getPayBusinessOrder error = ");
                    stringBuilder.append(th.getMessage());
                    XLLog.e(g, stringBuilder.toString());
                    a.a(this.a, h.a(th));
                }
            });
        }
    }

    public final void a(XLPayParam xLPayParam) {
        this.g = (XLWxDisContractParam) xLPayParam;
        f = XLPayType.XL_WX_CONTRACT;
        this.k = f.a(this.g);
    }

    public final XLPayParam d() {
        return this.g;
    }

    private void h() {
        String c = this.k.c(f);
        String str = e;
        StringBuilder stringBuilder = new StringBuilder("generateDiscontractUrl wx param = ");
        stringBuilder.append(c);
        XLLog.v(str, stringBuilder.toString());
        byte[] bytes = c.getBytes();
        Header[] headerArr = new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)};
        com.xunlei.common.new_ptl.pay.b.a.a.a().a("https://agent-paycenter-ssl.xunlei.com/newsdk/monthUnsignServlet", bytes, headerArr, /* anonymous class already generated */);
    }

    private void a(int i) {
        XLContractResp xLContractResp = new XLContractResp();
        xLContractResp.mContractType = 4097;
        xLContractResp.mOperateType = 8194;
        if (TextUtils.isEmpty(this.c)) {
            this.c = XLPayErrorCode.getErrorDesc(i);
        }
        i.a().a(new Object[]{Integer.valueOf(f), Integer.valueOf(i), this.c, f(), Integer.valueOf(b()), xLContractResp});
    }

    static /* synthetic */ void a(a aVar, int i) {
        XLContractResp xLContractResp = new XLContractResp();
        xLContractResp.mContractType = 4097;
        xLContractResp.mOperateType = 8194;
        if (TextUtils.isEmpty(aVar.c)) {
            aVar.c = XLPayErrorCode.getErrorDesc(i);
        }
        i.a().a(new Object[]{Integer.valueOf(f), Integer.valueOf(i), aVar.c, aVar.f(), Integer.valueOf(aVar.b()), xLContractResp});
    }
}
