package com.xunlei.common.register.b;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.register.XLRegErrorCode;
import com.xunlei.common.register.a.d;
import com.xunlei.common.register.a.e;
import com.xunlei.common.register.a.e.a;
import com.xunlei.common.register.a.f;
import org.apache.http.Header;
import org.json.JSONObject;

/* compiled from: XLCheckNeedVerifyCodeTask */
public final class b extends e {
    public b(f fVar) {
        super(fVar);
    }

    public final void d() {
        if (this.a != a.c) {
            this.a = a.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("op=needValidate");
            stringBuilder.append("&");
            StringBuilder stringBuilder2 = new StringBuilder("ip=");
            stringBuilder2.append(c());
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append("&");
            stringBuilder2 = new StringBuilder("v=");
            stringBuilder2.append(b().e());
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append("&");
            stringBuilder.append(a(true));
            stringBuilder.append("&");
            stringBuilder.append("callback=");
            XLLog.v("XLCheckNeedVerifyCodeTask", stringBuilder.toString());
            d.a().b(null, stringBuilder.toString(), new BaseHttpClientListener(this) {
                private /* synthetic */ b a;

                {
                    this.a = r1;
                }

                public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    if (i == 200) {
                        i = new String(bArr);
                        XLLog.v("XLCheckNeedVerifyCodeTask", i);
                        try {
                            JSONObject jSONObject = new JSONObject(i);
                            i = jSONObject.optInt("result");
                            int i2 = jSONObject.getInt("need");
                            String optString = jSONObject.optString("verifyType");
                            this.a.a(4, Integer.valueOf(i), XLRegErrorCode.getErrorDesc(i), Integer.valueOf(this.a.a()), Integer.valueOf(i2), optString);
                        } catch (int i3) {
                            i3.printStackTrace();
                            this.a.a(4, Integer.valueOf(-2), XLRegErrorCode.getErrorDesc(-2), Integer.valueOf(this.a.a()), Integer.valueOf(-1), "");
                        }
                    }
                }

                public final void onFailure(Throwable th, byte[] bArr) {
                    StringBuilder stringBuilder = new StringBuilder("error = ");
                    stringBuilder.append(th.getMessage());
                    XLLog.e("XLCheckNeedVerifyCodeTask", stringBuilder.toString());
                    this.a.a(4, Integer.valueOf(-1), XLRegErrorCode.getErrorDesc(-1), Integer.valueOf(this.a.a()), Integer.valueOf(-1), "");
                }
            });
            this.a = a.d;
        }
    }
}
