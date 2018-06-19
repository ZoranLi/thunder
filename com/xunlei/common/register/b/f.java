package com.xunlei.common.register.b;

import android.text.TextUtils;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.register.XLRegErrorCode;
import com.xunlei.common.register.a.d;
import com.xunlei.common.register.a.e;
import com.xunlei.common.register.a.e.a;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: XLOldUserNameRegisterTask */
public final class f extends e {
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

    public final void d(String str) {
    }

    public final void a(String str, String str2, String str3, String str4, String str5) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
    }

    public f(com.xunlei.common.register.a.f fVar) {
        super(fVar);
    }

    public final void d() {
        if (this.a != a.c) {
            this.a = a.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("op=usernameReg");
            stringBuilder.append("&");
            StringBuilder stringBuilder2 = new StringBuilder("username=");
            stringBuilder2.append(this.b);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append("&");
            stringBuilder2 = new StringBuilder("pwd=");
            stringBuilder2.append(this.c);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append("&");
            stringBuilder.append("checkPwdStrength=1&");
            if (!(e.c(this.e) || e.c(this.f))) {
                stringBuilder2 = new StringBuilder("verify_key=");
                stringBuilder2.append(this.e);
                stringBuilder.append(stringBuilder2.toString());
                stringBuilder.append("&");
                stringBuilder2 = new StringBuilder("verify_type=");
                stringBuilder2.append(this.f);
                stringBuilder.append(stringBuilder2.toString());
                stringBuilder.append("&");
                if (!TextUtils.isEmpty(this.d)) {
                    stringBuilder2 = new StringBuilder("code=");
                    stringBuilder2.append(this.d);
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
            stringBuilder2.append(com.xunlei.common.register.a.f.f());
            stringBuilder.append(stringBuilder2.toString());
            StringBuilder stringBuilder3 = new StringBuilder("param = ");
            stringBuilder3.append(stringBuilder.toString());
            XLLog.v("XLOldUserNameRegisterTask", stringBuilder3.toString());
            d.a().a(new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, stringBuilder.toString(), new BaseHttpClientListener(this) {
                private /* synthetic */ f a;

                {
                    this.a = r1;
                }

                public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    AnonymousClass1 anonymousClass1 = this;
                    if (i == 200) {
                        String str = new String(bArr);
                        XLLog.v("XLOldUserNameRegisterTask", str);
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            int optInt = jSONObject.optInt("result");
                            long optLong = jSONObject.optLong("uid");
                            String optString = jSONObject.optString("sessionid");
                            anonymousClass1.a.a(9, Integer.valueOf(optInt), XLRegErrorCode.getErrorDesc(optInt), Integer.valueOf(anonymousClass1.a.a()), Long.valueOf(optLong), optString, "", "");
                        } catch (JSONException e) {
                            e.printStackTrace();
                            anonymousClass1.a.a(9, Integer.valueOf(-2), XLRegErrorCode.getErrorDesc(-2), Integer.valueOf(anonymousClass1.a.a()), Long.valueOf(0), "", "", "");
                        }
                    }
                }

                public final void onFailure(Throwable th, byte[] bArr) {
                    StringBuilder stringBuilder = new StringBuilder("error = ");
                    stringBuilder.append(th.getMessage());
                    XLLog.e("XLOldUserNameRegisterTask", stringBuilder.toString());
                    this.a.a(9, Integer.valueOf(-1), XLRegErrorCode.getErrorDesc(-1), Integer.valueOf(this.a.a()), Long.valueOf(0), "", "", "");
                }
            });
            this.a = a.d;
        }
    }
}
