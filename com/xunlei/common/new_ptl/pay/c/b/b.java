package com.xunlei.common.new_ptl.pay.c.b;

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
import com.xunlei.common.new_ptl.pay.param.XLPayParam;
import com.xunlei.common.new_ptl.pay.param.XLWxContractQueryParam;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;

/* compiled from: XLWxContractQueryTask */
public class b extends h {
    private static final String e = "b";
    private static int f = 268435463;
    private static int i = 0;
    private static int j = 1;
    private XLWxContractQueryParam g = null;
    private XLOnPayListener h = null;
    private int k = 0;
    private e l = null;

    public final void c() {
        if (this.k == 0) {
            String d = this.l.d(f);
            String str = e;
            StringBuilder stringBuilder = new StringBuilder("generateQuerycontractUrl wx param = ");
            stringBuilder.append(d);
            XLLog.v(str, stringBuilder.toString());
            byte[] bytes = d.getBytes();
            Header[] headerArr = new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)};
            a.a().a("https://agent-paycenter-ssl.xunlei.com/newsdk/monthQuerySignServlet", bytes, headerArr, new com.xunlei.common.new_ptl.pay.b.a.b(this) {
                private /* synthetic */ b a;

                {
                    this.a = r1;
                }

                public final void a(String str) {
                    String g = b.e;
                    StringBuilder stringBuilder = new StringBuilder("getPayBusinessOrder buffer = ");
                    stringBuilder.append(str);
                    XLLog.v(g, stringBuilder.toString());
                    try {
                        JSONObject jSONObject = new JSONObject(XLUtilTools.parseJSONPString(str));
                        if (jSONObject.optInt(KEYS.RET, 57) == -1) {
                            this.a.c = jSONObject.optString("msg");
                            b.a(this.a, jSONObject.optInt("errcode", 57), 0);
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
                        b.a(this.a, 0, i);
                    } catch (String str2) {
                        str2.printStackTrace();
                        XLLog.e(b.e, "getPayBusinessOrder json error.");
                        this.a.k = 1;
                        b.a(this.a, 57, 0);
                    }
                }

                public final void a(Throwable th) {
                    String g = b.e;
                    StringBuilder stringBuilder = new StringBuilder("getPayBusinessOrder error = ");
                    stringBuilder.append(th.getMessage());
                    XLLog.e(g, stringBuilder.toString());
                    b.a(this.a, h.a(th), 0);
                }
            });
        }
    }

    public final void a(XLPayParam xLPayParam) {
        this.g = (XLWxContractQueryParam) xLPayParam;
        f = XLPayType.XL_WX_CONTRACT;
        this.l = f.a(this.g);
    }

    public final XLPayParam d() {
        return this.g;
    }

    public final void b(XLOnPayListener xLOnPayListener) {
        this.h = xLOnPayListener;
    }

    private void h() {
        String d = this.l.d(f);
        String str = e;
        StringBuilder stringBuilder = new StringBuilder("generateQuerycontractUrl wx param = ");
        stringBuilder.append(d);
        XLLog.v(str, stringBuilder.toString());
        byte[] bytes = d.getBytes();
        Header[] headerArr = new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)};
        a.a().a("https://agent-paycenter-ssl.xunlei.com/newsdk/monthQuerySignServlet", bytes, headerArr, /* anonymous class already generated */);
    }

    private void a(int i, int i2) {
        XLContractResp xLContractResp = new XLContractResp();
        xLContractResp.mContractType = 4097;
        xLContractResp.mOperateType = XLContractor$XLContractOperate.XL_OPERATE_QUERY;
        xLContractResp.mContractStatus = i2;
        if (TextUtils.isEmpty(this.c) != 0) {
            this.c = XLPayErrorCode.getErrorDesc(i);
        }
        if (this.h == 0) {
            i.a().a(new Object[]{Integer.valueOf(f), Integer.valueOf(i), this.c, f(), Integer.valueOf(b()), xLContractResp});
            return;
        }
        this.h.onContractOperate(i, this.c, f(), b(), xLContractResp);
    }

    static /* synthetic */ void a(b bVar, int i, int i2) {
        XLContractResp xLContractResp = new XLContractResp();
        xLContractResp.mContractType = 4097;
        xLContractResp.mOperateType = XLContractor$XLContractOperate.XL_OPERATE_QUERY;
        xLContractResp.mContractStatus = i2;
        if (TextUtils.isEmpty(bVar.c) != 0) {
            bVar.c = XLPayErrorCode.getErrorDesc(i);
        }
        if (bVar.h == 0) {
            i.a().a(new Object[]{Integer.valueOf(f), Integer.valueOf(i), bVar.c, bVar.f(), Integer.valueOf(bVar.b()), xLContractResp});
            return;
        }
        bVar.h.onContractOperate(i, bVar.c, bVar.f(), bVar.b(), xLContractResp);
    }
}
