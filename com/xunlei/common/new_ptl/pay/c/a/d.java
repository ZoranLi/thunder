package com.xunlei.common.new_ptl.pay.c.a;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants.KEYS;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.base.XLUtilTools;
import com.xunlei.common.new_ptl.pay.XLContractResp;
import com.xunlei.common.new_ptl.pay.XLContractor$XLContractOperate;
import com.xunlei.common.new_ptl.pay.XLContractor$XLContractStatus;
import com.xunlei.common.new_ptl.pay.XLOnPayListener;
import com.xunlei.common.new_ptl.pay.XLPayErrorCode;
import com.xunlei.common.new_ptl.pay.XLPayType;
import com.xunlei.common.new_ptl.pay.a.e;
import com.xunlei.common.new_ptl.pay.a.f;
import com.xunlei.common.new_ptl.pay.a.h;
import com.xunlei.common.new_ptl.pay.a.i;
import com.xunlei.common.new_ptl.pay.b.a.a;
import com.xunlei.common.new_ptl.pay.b.a.b;
import com.xunlei.common.new_ptl.pay.param.XLAliContractQueryParam;
import com.xunlei.common.new_ptl.pay.param.XLPayParam;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;

/* compiled from: XLAlipayContractQueryTask */
public class d extends h {
    private static final String e = "d";
    private static int f = 268435462;
    private static int h = 0;
    private static int i = 1;
    private XLAliContractQueryParam g = null;
    private int j = 0;
    private e k = null;
    private XLOnPayListener l = null;

    public final void c() {
        if (this.j == 0) {
            String d = this.k.d(f);
            String str = e;
            StringBuilder stringBuilder = new StringBuilder("generateQuerycontractUrl ali param = ");
            stringBuilder.append(d);
            XLLog.v(str, stringBuilder.toString());
            byte[] bytes = d.getBytes();
            Header[] headerArr = new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)};
            a.a().a("https://agent-paycenter-ssl.xunlei.com/newsdk/monthQuerySignServlet", bytes, headerArr, new b(this) {
                private /* synthetic */ d a;

                {
                    this.a = r1;
                }

                public final void a(String str) {
                    String g = d.e;
                    StringBuilder stringBuilder = new StringBuilder("generateQuerycontractUrl buffer = ");
                    stringBuilder.append(str);
                    XLLog.v(g, stringBuilder.toString());
                    try {
                        JSONObject jSONObject = new JSONObject(XLUtilTools.parseJSONPString(str));
                        if (jSONObject.optInt(KEYS.RET, 104) == -1) {
                            this.a.c = jSONObject.optString("msg");
                            d.a(this.a, jSONObject.optInt("errcode", 104), 0);
                            return;
                        }
                        str = jSONObject.getJSONObject("data").optString("status");
                        int i = XLContractor$XLContractStatus.XL_CONTRACT_SYSTEMERROR;
                        if ("UNSIGN".compareTo(str) == 0) {
                            i = XLContractor$XLContractStatus.XL_CONTRACT_NO;
                        }
                        if ("SIGN".compareTo(str) == null) {
                            i = XLContractor$XLContractStatus.XL_CONTRACT_NORMAL;
                        }
                        d.a(this.a, 0, i);
                    } catch (String str2) {
                        str2.printStackTrace();
                        XLLog.e(d.e, "getPayBusinessOrder json error.");
                        this.a.j = 1;
                        d.a(this.a, 104, 0);
                    }
                }

                public final void a(Throwable th) {
                    String g = d.e;
                    StringBuilder stringBuilder = new StringBuilder("getPayBusinessOrder error = ");
                    stringBuilder.append(th.getMessage());
                    XLLog.e(g, stringBuilder.toString());
                    d.a(this.a, h.a(th), 0);
                }
            });
        }
    }

    public final void a(XLPayParam xLPayParam) {
        this.g = (XLAliContractQueryParam) xLPayParam;
        f = XLPayType.XL_ALIPAY_CONTRACT;
        this.k = f.a(this.g);
    }

    public final XLPayParam d() {
        return this.g;
    }

    public final void b(XLOnPayListener xLOnPayListener) {
        this.l = xLOnPayListener;
    }

    private void h() {
        String d = this.k.d(f);
        String str = e;
        StringBuilder stringBuilder = new StringBuilder("generateQuerycontractUrl ali param = ");
        stringBuilder.append(d);
        XLLog.v(str, stringBuilder.toString());
        byte[] bytes = d.getBytes();
        Header[] headerArr = new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)};
        a.a().a("https://agent-paycenter-ssl.xunlei.com/newsdk/monthQuerySignServlet", bytes, headerArr, /* anonymous class already generated */);
    }

    private void a(int i, int i2) {
        XLContractResp xLContractResp = new XLContractResp();
        xLContractResp.mContractType = 4096;
        xLContractResp.mOperateType = XLContractor$XLContractOperate.XL_OPERATE_QUERY;
        xLContractResp.mContractStatus = i2;
        if (TextUtils.isEmpty(this.c) != 0) {
            this.c = XLPayErrorCode.getErrorDesc(i);
        }
        if (this.l == 0) {
            i.a().a(new Object[]{Integer.valueOf(f), Integer.valueOf(i), this.c, f(), Integer.valueOf(b()), xLContractResp});
            return;
        }
        this.l.onContractOperate(i, this.c, f(), b(), xLContractResp);
    }

    static /* synthetic */ void a(d dVar, int i, int i2) {
        XLContractResp xLContractResp = new XLContractResp();
        xLContractResp.mContractType = 4096;
        xLContractResp.mOperateType = XLContractor$XLContractOperate.XL_OPERATE_QUERY;
        xLContractResp.mContractStatus = i2;
        if (TextUtils.isEmpty(dVar.c) != 0) {
            dVar.c = XLPayErrorCode.getErrorDesc(i);
        }
        if (dVar.l == 0) {
            i.a().a(new Object[]{Integer.valueOf(f), Integer.valueOf(i), dVar.c, dVar.f(), Integer.valueOf(dVar.b()), xLContractResp});
            return;
        }
        dVar.l.onContractOperate(i, dVar.c, dVar.f(), dVar.b(), xLContractResp);
    }
}
