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

/* compiled from: XLPhoneRegAndLoginTask */
public final class g extends e {
    private String b = "";
    private String c = "";
    private String d = "";

    public final void a(String str, String str2, String str3) {
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public g(f fVar) {
        super(fVar);
    }

    public final void d() {
        if (this.a != a.c) {
            this.a = a.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("op=mobileRegPwd");
            stringBuilder.append("&");
            StringBuilder stringBuilder2 = new StringBuilder("mobile=");
            stringBuilder2.append(this.b);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append("&");
            stringBuilder2 = new StringBuilder("code=");
            stringBuilder2.append(this.c);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append("&");
            stringBuilder2 = new StringBuilder("pwd=");
            stringBuilder2.append(this.d);
            stringBuilder.append(stringBuilder2.toString());
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
            XLLog.v("XLPhoneRegAndLoginTask", stringBuilder3.toString());
            d.a().a(new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, stringBuilder.toString(), new BaseHttpClientListener(this) {
                private /* synthetic */ g a;

                {
                    this.a = r1;
                }

                public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    if (i == 200) {
                        i = new String(bArr);
                        XLLog.v("XLPhoneRegAndLoginTask", i);
                        try {
                            JSONObject jSONObject = new JSONObject(i);
                            i = jSONObject.optInt("result");
                            long optLong = jSONObject.optLong("uid");
                            String optString = jSONObject.optString("sessionid");
                            this.a.a(8, Integer.valueOf(i), XLRegErrorCode.getErrorDesc(i), Integer.valueOf(this.a.a()), Long.valueOf(optLong), optString);
                        } catch (int i2) {
                            i2.printStackTrace();
                            this.a.a(8, Integer.valueOf(-2), XLRegErrorCode.getErrorDesc(-2), Integer.valueOf(this.a.a()), Long.valueOf(0), "");
                        }
                    }
                }

                public final void onFailure(Throwable th, byte[] bArr) {
                    StringBuilder stringBuilder = new StringBuilder("error = ");
                    stringBuilder.append(th.getMessage());
                    XLLog.e("XLPhoneRegAndLoginTask", stringBuilder.toString());
                    this.a.a(8, Integer.valueOf(-1), XLRegErrorCode.getErrorDesc(-1), Integer.valueOf(this.a.a()), Long.valueOf(0), "");
                }
            });
            this.a = a.d;
        }
    }
}
