package com.xunlei.common.new_ptl.pay.c.b;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants.KEYS;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbiz.OpenWebview.Req;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.base.XLUtilTools;
import com.xunlei.common.new_ptl.pay.XLAllContractResp;
import com.xunlei.common.new_ptl.pay.XLContractResp;
import com.xunlei.common.new_ptl.pay.XLOnPayListener;
import com.xunlei.common.new_ptl.pay.XLPayErrorCode;
import com.xunlei.common.new_ptl.pay.XLPayType;
import com.xunlei.common.new_ptl.pay.a.e;
import com.xunlei.common.new_ptl.pay.a.f;
import com.xunlei.common.new_ptl.pay.a.h;
import com.xunlei.common.new_ptl.pay.a.i;
import com.xunlei.common.new_ptl.pay.b.a.a;
import com.xunlei.common.new_ptl.pay.b.a.b;
import com.xunlei.common.new_ptl.pay.param.XLPayParam;
import com.xunlei.common.new_ptl.pay.param.XLWxContractParam;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;

/* compiled from: XLWxContractTask */
public class c extends h {
    private static final String f = "c";
    private static int g = 268435463;
    private static int j = 0;
    private static int k = 1;
    private static int l = 2;
    private static int m = 3;
    private XLOnPayListener e = new XLOnPayListener(this) {
        final /* synthetic */ c a;

        public final void onAliPay(int i, String str, Object obj, String str2, int i2) {
        }

        public final void onGetPrice(int i, String str, Object obj, int i2, String str2) {
        }

        public final void onQueryContract(int i, String str, Object obj, int i2, XLAllContractResp xLAllContractResp) {
        }

        public final void onWxPay(int i, String str, Object obj, String str2, int i2) {
        }

        {
            this.a = r1;
        }

        public final void onContractOperate(int i, String str, Object obj, int i2, XLContractResp xLContractResp) {
            if (xLContractResp.mOperateType == 8193) {
                if (i == 0) {
                    c.a(this.a, xLContractResp);
                }
                this.a.n = 1;
                c.e().c().post(new Runnable(this) {
                    private /* synthetic */ AnonymousClass1 a;

                    {
                        this.a = r1;
                    }

                    public final void run() {
                        this.a.a.c();
                    }
                });
            }
        }
    };
    private XLWxContractParam h = null;
    private XLContractResp i;
    private int n = 0;
    private String o = null;
    private e p = null;
    private IWXAPI q = null;
    private String r = "";

    static /* synthetic */ XLContractResp a(c cVar, XLContractResp xLContractResp) {
        return xLContractResp;
    }

    public final void c() {
        if (this.n != 1) {
            if (this.n == 2) {
                String str = this.o;
                BaseReq req = new Req();
                req.url = str;
                StringBuilder stringBuilder = new StringBuilder("xl_sdk_contract#");
                stringBuilder.append(b());
                req.transaction = stringBuilder.toString();
                this.q.sendReq(req);
                a(0);
            }
        } else if (this.q.isWXAppInstalled()) {
            String b = this.p.b(g);
            String str2 = f;
            StringBuilder stringBuilder2 = new StringBuilder("generateContractUrl wx param = ");
            stringBuilder2.append(b);
            XLLog.v(str2, stringBuilder2.toString());
            byte[] bytes = b.getBytes();
            Header[] headerArr = new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)};
            a.a().a("https://agent-paycenter-ssl.xunlei.com/newsdk/order", bytes, headerArr, new b(this) {
                final /* synthetic */ c a;

                {
                    this.a = r1;
                }

                public final void a(String str) {
                    String g = c.f;
                    StringBuilder stringBuilder = new StringBuilder("getPayBusinessOrder buffer = ");
                    stringBuilder.append(str);
                    XLLog.v(g, stringBuilder.toString());
                    try {
                        JSONObject jSONObject = new JSONObject(XLUtilTools.parseJSONPString(str));
                        if (jSONObject.optInt(KEYS.RET, XLPayErrorCode.XLP_GET_ORDER_ERROR) == -1) {
                            this.a.c = jSONObject.optString("msg");
                            this.a.a(jSONObject.optInt("errcode", XLPayErrorCode.XLP_GET_ORDER_ERROR));
                            return;
                        }
                        str = jSONObject.getJSONObject("data");
                        Object string = str.getString("url");
                        this.a.r = str.optString("orderId");
                        if (TextUtils.isEmpty(string) == null) {
                            this.a.o = string;
                            this.a.n = 2;
                            c.e().c().post(new Runnable(this) {
                                private /* synthetic */ AnonymousClass2 a;

                                {
                                    this.a = r1;
                                }

                                public final void run() {
                                    this.a.a.c();
                                }
                            });
                            return;
                        }
                        this.a.a(55);
                    } catch (String str2) {
                        str2.printStackTrace();
                        XLLog.e(c.f, "getPayBusinessOrder json error.");
                        this.a.n = 3;
                        this.a.a((int) XLPayErrorCode.XLP_GET_ORDER_ERROR);
                    }
                }

                public final void a(Throwable th) {
                    String g = c.f;
                    StringBuilder stringBuilder = new StringBuilder("getPayBusinessOrder error = ");
                    stringBuilder.append(th.getMessage());
                    XLLog.e(g, stringBuilder.toString());
                    this.a.a((int) XLPayErrorCode.XLP_GET_ORDER_ERROR);
                }
            });
        } else {
            a(54);
        }
    }

    public final void a(XLPayParam xLPayParam) {
        this.h = (XLWxContractParam) xLPayParam;
        g = XLPayType.XL_WX_CONTRACT;
        this.p = f.a(this.h);
        this.q = WXAPIFactory.createWXAPI(i.a().d(), this.h.mWxAppId, false);
        this.q.registerApp(this.h.mWxAppId);
        this.n = 1;
    }

    public final XLPayParam d() {
        return this.h;
    }

    private void h() {
        String b = this.p.b(g);
        String str = f;
        StringBuilder stringBuilder = new StringBuilder("generateContractUrl wx param = ");
        stringBuilder.append(b);
        XLLog.v(str, stringBuilder.toString());
        byte[] bytes = b.getBytes();
        Header[] headerArr = new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)};
        a.a().a("https://agent-paycenter-ssl.xunlei.com/newsdk/order", bytes, headerArr, /* anonymous class already generated */);
    }

    private void a(int i) {
        XLContractResp xLContractResp = new XLContractResp();
        xLContractResp.mContractType = 4097;
        xLContractResp.mOperateType = 8192;
        xLContractResp.mContractOrderId = this.r;
        if (TextUtils.isEmpty(this.c)) {
            this.c = XLPayErrorCode.getErrorDesc(i);
        }
        i.a().a(new Object[]{Integer.valueOf(g), Integer.valueOf(i), this.c, f(), Integer.valueOf(b()), xLContractResp});
    }

    private void a(String str) {
        BaseReq req = new Req();
        req.url = str;
        str = new StringBuilder("xl_sdk_contract#");
        str.append(b());
        req.transaction = str.toString();
        this.q.sendReq(req);
    }

    private void i() {
        XLPayParam xLWxContractParam = new XLWxContractParam();
        xLWxContractParam.mUserId = this.h.mUserId;
        xLWxContractParam.mSessionId = this.h.mSessionId;
        xLWxContractParam.mBizNo = "";
        h bVar = new b();
        bVar.a();
        bVar.a(xLWxContractParam);
        bVar.b(this.e);
        bVar.a("xl-query-contract");
        i.a().a(bVar);
    }
}
