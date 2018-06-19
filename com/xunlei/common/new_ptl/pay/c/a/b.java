package com.xunlei.common.new_ptl.pay.c.a;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.util.k;
import com.qq.e.comm.constants.Constants.KEYS;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.base.XLUtilTools;
import com.xunlei.common.encrypt.URLCoder;
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
import com.xunlei.common.new_ptl.pay.param.XLAliPayContractParam;
import com.xunlei.common.new_ptl.pay.param.XLPayParam;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;

/* compiled from: XLAliPayContractTask */
public class b extends h {
    private static final String f = "b";
    private static int g = 268435462;
    private static int j = 0;
    private static int k = 1;
    private static int l = 2;
    private static int m = 3;
    private XLOnPayListener e = new XLOnPayListener(this) {
        final /* synthetic */ b a;

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
                    b.a(this.a, xLContractResp);
                }
                this.a.n = 1;
                b.e().c().post(new Runnable(this) {
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
    private XLAliPayContractParam h = null;
    private XLContractResp i;
    private int n = 0;
    private String o = null;
    private e p = null;
    private String q = "";

    static /* synthetic */ XLContractResp a(b bVar, XLContractResp xLContractResp) {
        return xLContractResp;
    }

    public final void c() {
        if (this.n != 1) {
            if (this.n == 2) {
                String encode = URLCoder.encode(this.o, "UTF-8");
                Intent intent = new Intent("android.intent.action.VIEW");
                StringBuilder stringBuilder = new StringBuilder("alipays://platformapi/startapp?appId=20000067&url=");
                stringBuilder.append(encode);
                intent.setData(Uri.parse(stringBuilder.toString()));
                intent.addFlags(268435456);
                i.a().d().startActivity(intent);
                a(0);
            }
        } else if (XLUtilTools.isApplicationInstalled(i.a().d(), k.b)) {
            String b = this.p.b(g);
            String str = f;
            StringBuilder stringBuilder2 = new StringBuilder("generateContractUrl ali param = ");
            stringBuilder2.append(b);
            XLLog.v(str, stringBuilder2.toString());
            byte[] bytes = b.getBytes();
            Header[] headerArr = new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)};
            a.a().a("https://agent-paycenter-ssl.xunlei.com/newsdk/order", bytes, headerArr, new com.xunlei.common.new_ptl.pay.b.a.b(this) {
                final /* synthetic */ b a;

                {
                    this.a = r1;
                }

                public final void a(String str) {
                    String g = b.f;
                    StringBuilder stringBuilder = new StringBuilder("getPayBusinessOrder buffer = ");
                    stringBuilder.append(str);
                    XLLog.v(g, stringBuilder.toString());
                    try {
                        JSONObject jSONObject = new JSONObject(XLUtilTools.parseJSONPString(str));
                        if (jSONObject.optInt(KEYS.RET, XLPayErrorCode.XLP_GET_ORDER_ERROR) == -1) {
                            this.a.c = jSONObject.optString("msg");
                            this.a.a(jSONObject.optInt("errcode", 103));
                            return;
                        }
                        str = jSONObject.getJSONObject("data");
                        Object string = str.getString("url");
                        this.a.q = str.optString("orderId");
                        if (TextUtils.isEmpty(string) == null) {
                            this.a.o = string;
                            this.a.n = 2;
                            b.e().c().post(new Runnable(this) {
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
                        this.a.a(105);
                    } catch (String str2) {
                        str2.printStackTrace();
                        XLLog.e(b.f, "getPayBusinessOrder json error.");
                        this.a.n = 3;
                        this.a.a((int) XLPayErrorCode.XLP_GET_ORDER_ERROR);
                    }
                }

                public final void a(Throwable th) {
                    String g = b.f;
                    StringBuilder stringBuilder = new StringBuilder("getPayBusinessOrder error = ");
                    stringBuilder.append(th.getMessage());
                    XLLog.e(g, stringBuilder.toString());
                    this.a.a(h.a(th));
                }
            });
        } else {
            a(102);
        }
    }

    public final void a(XLPayParam xLPayParam) {
        this.h = (XLAliPayContractParam) xLPayParam;
        g = XLPayType.XL_ALIPAY_CONTRACT;
        this.p = f.a(this.h);
        this.n = 1;
    }

    public final XLPayParam d() {
        return this.h;
    }

    private void h() {
        String b = this.p.b(g);
        String str = f;
        StringBuilder stringBuilder = new StringBuilder("generateContractUrl ali param = ");
        stringBuilder.append(b);
        XLLog.v(str, stringBuilder.toString());
        byte[] bytes = b.getBytes();
        Header[] headerArr = new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)};
        a.a().a("https://agent-paycenter-ssl.xunlei.com/newsdk/order", bytes, headerArr, /* anonymous class already generated */);
    }

    private void a(int i) {
        XLContractResp xLContractResp = new XLContractResp();
        xLContractResp.mContractType = 4096;
        xLContractResp.mOperateType = 8192;
        xLContractResp.mContractOrderId = this.q;
        if (TextUtils.isEmpty(this.c)) {
            this.c = XLPayErrorCode.getErrorDesc(i);
        }
        i.a().a(new Object[]{Integer.valueOf(g), Integer.valueOf(i), this.c, f(), Integer.valueOf(b()), xLContractResp});
    }

    private static void a(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        StringBuilder stringBuilder = new StringBuilder("alipays://platformapi/startapp?appId=20000067&url=");
        stringBuilder.append(str);
        intent.setData(Uri.parse(stringBuilder.toString()));
        intent.addFlags(268435456);
        i.a().d().startActivity(intent);
    }

    private void i() {
        XLPayParam xLAliPayContractParam = new XLAliPayContractParam();
        xLAliPayContractParam.mUserId = this.h.mUserId;
        xLAliPayContractParam.mSessionId = this.h.mSessionId;
        xLAliPayContractParam.mBizNo = "";
        h dVar = new d();
        dVar.a();
        dVar.a(xLAliPayContractParam);
        dVar.b(this.e);
        dVar.a("xl-query-contract");
        i.a().a(dVar);
    }
}
