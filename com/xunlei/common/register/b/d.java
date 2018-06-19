package com.xunlei.common.register.b;

import android.text.TextUtils;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.register.XLRegErrorCode;
import com.xunlei.common.register.a.e;
import com.xunlei.common.register.a.e.a;
import com.xunlei.common.register.a.f;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;

/* compiled from: XLEmailRegisterTask */
public final class d extends e {
    private String b = "";
    private String c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private String g;

    private static String f() {
        return "";
    }

    private static String g() {
        return "";
    }

    public final void f(String str) {
    }

    public d(f fVar) {
        super(fVar);
    }

    public final void d(String str) {
        if (str != null) {
            this.b = str;
        }
    }

    public final void e(String str) {
        if (str != null) {
            this.f = str;
        }
    }

    public final void g(String str) {
        if (str != null) {
            this.c = str;
        }
    }

    public final void h(String str) {
        if (str != null) {
            this.d = str;
        }
    }

    public final void i(String str) {
        if (str != null) {
            this.e = str;
        }
    }

    public final void d() {
        if (this.a != a.c) {
            this.a = a.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("op=emailReg");
            stringBuilder.append("&");
            StringBuilder stringBuilder2 = new StringBuilder("email=");
            stringBuilder2.append(this.b);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append("&");
            stringBuilder2 = new StringBuilder("pwd=");
            stringBuilder2.append(this.f);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append("&");
            stringBuilder.append("checkPwdStrength=1&");
            if (!(e.c(this.d) || e.c(this.e))) {
                stringBuilder2 = new StringBuilder("verify_key=");
                stringBuilder2.append(this.d);
                stringBuilder.append(stringBuilder2.toString());
                stringBuilder.append("&");
                stringBuilder2 = new StringBuilder("verify_type=");
                stringBuilder2.append(this.e);
                stringBuilder.append(stringBuilder2.toString());
                stringBuilder.append("&");
                if (!TextUtils.isEmpty(this.c)) {
                    stringBuilder2 = new StringBuilder("code=");
                    stringBuilder2.append(this.c);
                    stringBuilder.append(stringBuilder2.toString());
                    stringBuilder.append("&");
                }
            }
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
            XLLog.v("XLEmailRegisterTask", stringBuilder3.toString());
            com.xunlei.common.register.a.d.a().a(new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, stringBuilder.toString(), new BaseHttpClientListener(this) {
                private /* synthetic */ d a;

                {
                    this.a = r1;
                }

                public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    if (i == 200) {
                        i = new String(bArr);
                        XLLog.v("XLEmailRegisterTask", i);
                        try {
                            JSONObject jSONObject = new JSONObject(i);
                            i = jSONObject.optInt("result");
                            long optLong = jSONObject.optLong("uid");
                            String optString = jSONObject.optString("sessionid");
                            this.a.a(1, Integer.valueOf(i), XLRegErrorCode.getErrorDesc(i), Integer.valueOf(this.a.a()), Long.valueOf(optLong), optString, "", "");
                        } catch (int i2) {
                            i2.printStackTrace();
                            this.a.a(1, Integer.valueOf(-2), XLRegErrorCode.getErrorDesc(-2), Integer.valueOf(this.a.a()), Long.valueOf(0), "", "", "");
                        }
                    }
                }

                public final void onFailure(Throwable th, byte[] bArr) {
                    StringBuilder stringBuilder = new StringBuilder("error = ");
                    stringBuilder.append(th.getMessage());
                    XLLog.e("XLEmailRegisterTask", stringBuilder.toString());
                    this.a.a(1, Integer.valueOf(-1), XLRegErrorCode.getErrorDesc(-1), Integer.valueOf(this.a.a()), Long.valueOf(0), "", "", "");
                }
            });
            this.a = a.d;
        }
    }
}
