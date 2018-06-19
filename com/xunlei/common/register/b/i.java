package com.xunlei.common.register.b;

import com.umeng.message.util.HttpRequest;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.encrypt.MD5;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.register.XLRegErrorCode;
import com.xunlei.common.register.a.d;
import com.xunlei.common.register.a.e;
import com.xunlei.common.register.a.e.a;
import com.xunlei.common.register.a.f;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;

/* compiled from: XLSendMessageTask */
public final class i extends e {
    private final String b;
    private String c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private int g = 1;
    private boolean h = true;

    public i(f fVar) {
        super(fVar);
    }

    public final void d(String str) {
        if (str != null) {
            this.f = str;
        }
    }

    public final void a(String str, String str2, String str3) {
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    public final void a(int i) {
        this.g = i;
    }

    public final void b(boolean z) {
        this.h = z;
    }

    private String f() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f);
        stringBuilder.append("17c5bc4b8fabd847b010c49d9d174aec");
        return MD5.encrypt(stringBuilder.toString());
    }

    public final void d() {
        if (this.a != a.c) {
            this.a = a.b;
            StringBuilder stringBuilder = new StringBuilder();
            if (this.h) {
                stringBuilder.append("op=sendSmsSignLimit");
            } else {
                stringBuilder.append("op=sendSmsSign");
            }
            stringBuilder.append("&");
            stringBuilder.append("sign=");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(this.f);
            stringBuilder2.append("17c5bc4b8fabd847b010c49d9d174aec");
            stringBuilder.append(MD5.encrypt(stringBuilder2.toString()));
            stringBuilder.append("&");
            stringBuilder2 = new StringBuilder("mobile=");
            stringBuilder2.append(this.f);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append("&");
            stringBuilder.append("type=");
            stringBuilder.append(this.g);
            stringBuilder.append("&");
            stringBuilder2 = new StringBuilder("ip=");
            stringBuilder2.append(c());
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append("&");
            stringBuilder.append("verifyKey=");
            stringBuilder.append(this.c);
            stringBuilder.append("&");
            stringBuilder.append("verifyCode=");
            stringBuilder.append(this.d);
            stringBuilder.append("&");
            stringBuilder.append("verifyType=");
            stringBuilder.append(this.e);
            stringBuilder.append("&");
            stringBuilder.append(e());
            stringBuilder.append("&");
            stringBuilder2 = new StringBuilder("v=");
            stringBuilder2.append(f.f());
            stringBuilder.append(stringBuilder2.toString());
            StringBuilder stringBuilder3 = new StringBuilder("param = ");
            stringBuilder3.append(stringBuilder.toString());
            XLLog.v("XLSendMessageTask", stringBuilder3.toString());
            d.a().a(new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, stringBuilder.toString(), new BaseHttpClientListener(this) {
                private /* synthetic */ i a;

                {
                    this.a = r1;
                }

                public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    if (i == 200) {
                        i = new String(bArr);
                        XLLog.v("XLSendMessageTask", i);
                        try {
                            JSONObject jSONObject = new JSONObject(i);
                            String str = "";
                            if (jSONObject.optInt("result") == 409) {
                                str = jSONObject.getString("verifyType");
                            }
                            this.a.a(3, Integer.valueOf(i), XLRegErrorCode.getErrorDesc(i), Integer.valueOf(this.a.a()), Integer.valueOf(this.a.g), str);
                        } catch (int i2) {
                            i2.printStackTrace();
                            this.a.a(3, Integer.valueOf(-2), XLRegErrorCode.getErrorDesc(-2), Integer.valueOf(this.a.a()), Integer.valueOf(this.a.g), "");
                        }
                    }
                }

                public final void onFailure(Throwable th, byte[] bArr) {
                    StringBuilder stringBuilder = new StringBuilder("error = ");
                    stringBuilder.append(th.getMessage());
                    XLLog.e("XLSendMessageTask", stringBuilder.toString());
                    this.a.a(3, Integer.valueOf(-1), XLRegErrorCode.getErrorDesc(-1), Integer.valueOf(this.a.a()), Integer.valueOf(this.a.g), "");
                }
            });
            this.a = a.d;
        }
    }
}
