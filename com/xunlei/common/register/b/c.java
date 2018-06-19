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

/* compiled from: XLCheckPswStrengthTask */
public final class c extends e {
    private String b = "";

    public final void d(String str) {
        this.b = str;
    }

    public c(f fVar) {
        super(fVar);
    }

    public final void d() {
        if (this.a != a.c) {
            this.a = a.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("op=pwdStrength");
            stringBuilder.append("&");
            StringBuilder stringBuilder2 = new StringBuilder("pwd=");
            stringBuilder2.append(this.b);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append("&");
            stringBuilder.append(e());
            stringBuilder.append("&");
            stringBuilder2 = new StringBuilder("v=");
            stringBuilder2.append(b().e());
            stringBuilder.append(stringBuilder2.toString());
            d.a().a(new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, stringBuilder.toString(), new BaseHttpClientListener(this) {
                private /* synthetic */ c a;

                {
                    this.a = r1;
                }

                public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    if (i == 200) {
                        i = new String(bArr);
                        XLLog.v("XLCheckPswStrengthTask", i);
                        try {
                            JSONObject jSONObject = new JSONObject(i);
                            i = jSONObject.optInt("result");
                            int optInt = jSONObject.optInt("strength");
                            this.a.a(7, Integer.valueOf(i), XLRegErrorCode.getErrorDesc(i), Integer.valueOf(this.a.a()), Integer.valueOf(optInt));
                        } catch (int i2) {
                            i2.printStackTrace();
                            this.a.a(7, Integer.valueOf(-2), XLRegErrorCode.getErrorDesc(-2), Integer.valueOf(this.a.a()), Integer.valueOf(-1));
                        }
                    }
                }

                public final void onFailure(Throwable th, byte[] bArr) {
                    StringBuilder stringBuilder = new StringBuilder("error = ");
                    stringBuilder.append(th.getMessage());
                    XLLog.e("XLCheckPswStrengthTask", stringBuilder.toString());
                    this.a.a(7, Integer.valueOf(-1), XLRegErrorCode.getErrorDesc(-1), Integer.valueOf(this.a.a()), Integer.valueOf(-1));
                }
            });
            this.a = a.d;
        }
    }
}
