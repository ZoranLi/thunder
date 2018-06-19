package com.xunlei.common.register.b;

import com.umeng.message.util.HttpRequest;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.register.XLRegErrorCode;
import com.xunlei.common.register.a.d;
import com.xunlei.common.register.a.e;
import com.xunlei.common.register.a.e.a;
import com.xunlei.common.register.a.f;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;

/* compiled from: XLPhoneRegisterTask */
public final class h extends e {
    private static int b = 0;
    private static int c = 1;
    private String d = "";
    private String e = "";
    private String f = "";
    private int g = null;

    public h(f fVar) {
        super(fVar);
    }

    public final void a(int i) {
        this.g = 0;
    }

    public final void d(String str) {
        if (str != null) {
            this.d = str;
        }
    }

    public final void e(String str) {
        if (str != null) {
            this.e = str;
        }
    }

    private void f(String str) {
        if (str != null) {
            this.f = str;
        }
    }

    public final void d() {
        if (this.a != a.c) {
            this.a = a.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("op=mobileReg");
            stringBuilder.append("&");
            StringBuilder stringBuilder2 = new StringBuilder("mobile=");
            stringBuilder2.append(this.d);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append("&");
            stringBuilder2 = new StringBuilder("code=");
            stringBuilder2.append(this.e);
            stringBuilder.append(stringBuilder2.toString());
            if (this.g == 1) {
                stringBuilder.append("&");
                stringBuilder2 = new StringBuilder("pwd=");
                stringBuilder2.append(this.f);
                stringBuilder.append(stringBuilder2.toString());
            }
            stringBuilder.append("&");
            stringBuilder.append("checkPwdStrength=1&");
            stringBuilder2 = new StringBuilder("ip=");
            stringBuilder2.append(c());
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append("&");
            stringBuilder.append(e());
            stringBuilder.append("&");
            stringBuilder2 = new StringBuilder("v=");
            stringBuilder2.append(f.f());
            stringBuilder.append(stringBuilder2.toString());
            StringBuilder stringBuilder3 = new StringBuilder("param = ");
            stringBuilder3.append(stringBuilder.toString());
            XLLog.v("XLPhoneRegisterTask", stringBuilder3.toString());
            d.a().a(new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, stringBuilder.toString(), new BaseHttpClientListener(this) {
                private /* synthetic */ h a;

                {
                    this.a = r1;
                }

                public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    if (i == 200) {
                        i = new String(bArr);
                        XLLog.v("XLPhoneRegisterTask", i);
                        try {
                            JSONObject jSONObject = new JSONObject(i);
                            i = jSONObject.optInt("result");
                            long optLong = jSONObject.optLong("uid");
                            String optString = jSONObject.optString("sessionid");
                            this.a.a(0, Integer.valueOf(i), XLRegErrorCode.getErrorDesc(i), Integer.valueOf(this.a.a()), Long.valueOf(optLong), optString);
                        } catch (int i2) {
                            i2.printStackTrace();
                            this.a.a(0, Integer.valueOf(-2), XLRegErrorCode.getErrorDesc(-2), Integer.valueOf(this.a.a()), Long.valueOf(0), "");
                        }
                    }
                }

                public final void onFailure(Throwable th, byte[] bArr) {
                    StringBuilder stringBuilder = new StringBuilder("error = ");
                    stringBuilder.append(th.getMessage());
                    XLLog.e("XLPhoneRegisterTask", stringBuilder.toString());
                    this.a.a(0, Integer.valueOf(-1), XLRegErrorCode.getErrorDesc(-1), Integer.valueOf(this.a.a()), Long.valueOf(0), "");
                }
            });
            this.a = a.d;
        }
    }
}
