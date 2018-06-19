package com.xunlei.common.register.b;

import anet.channel.util.HttpConstant;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.register.XLRegErrorCode;
import com.xunlei.common.register.a.d;
import com.xunlei.common.register.a.e.a;
import com.xunlei.common.register.a.f;
import org.apache.http.Header;
import org.apache.http.HeaderElement;

/* compiled from: XLGetVerifyCodeTask */
public final class e extends com.xunlei.common.register.a.e {
    private String b = "M";

    public e(f fVar) {
        super(fVar);
    }

    public final void d(String str) {
        if (!com.xunlei.common.register.a.e.c(str)) {
            this.b = str;
        }
    }

    public final void d() {
        if (this.a != a.c) {
            this.a = a.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("op=validateImg");
            stringBuilder.append("&");
            stringBuilder.append(a(true));
            stringBuilder.append("&");
            StringBuilder stringBuilder2 = new StringBuilder("size=");
            stringBuilder2.append(this.b);
            stringBuilder.append(stringBuilder2.toString());
            XLLog.v("XLGetVerifyCodeTask", stringBuilder.toString());
            d.a().b(null, stringBuilder.toString(), new BaseHttpClientListener(this) {
                private /* synthetic */ e a;

                {
                    this.a = r1;
                }

                public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    StringBuilder stringBuilder = new StringBuilder("get verify code return code = ");
                    stringBuilder.append(i);
                    stringBuilder.append("#data length=");
                    stringBuilder.append(bArr.length);
                    XLLog.v("XLGetVerifyCodeTask", stringBuilder.toString());
                    Object obj = "";
                    Object obj2 = "";
                    String str = "";
                    for (Header header : headerArr) {
                        if (header.getName().compareToIgnoreCase(HttpConstant.SET_COOKIE) == 0) {
                            HeaderElement[] elements = header.getElements();
                            String str2 = obj;
                            String str3 = obj2;
                            for (HeaderElement headerElement : elements) {
                                if (headerElement.getName().compareToIgnoreCase("VERIFY_KEY") == 0) {
                                    str3 = headerElement.getValue();
                                } else if (headerElement.getName().compareToIgnoreCase("VERIFY_TYPE") == 0) {
                                    str2 = headerElement.getValue();
                                }
                            }
                            obj2 = str3;
                            obj = str2;
                        }
                        if (header.getName().compareToIgnoreCase("Content-Type") == 0) {
                            str = header.getValue();
                        }
                        XLLog.v("XLGetVerifyCodeTask", "get verify code.");
                    }
                    this.a.a(5, Integer.valueOf(200), XLRegErrorCode.getErrorDesc(200), Integer.valueOf(this.a.a()), bArr, this.a.b, str, obj2, obj);
                }

                public final void onFailure(Throwable th, byte[] bArr) {
                    StringBuilder stringBuilder = new StringBuilder("error code = ");
                    stringBuilder.append(th.getMessage());
                    XLLog.e("XLGetVerifyCodeTask", stringBuilder.toString());
                    this.a.a(5, Integer.valueOf(-1), XLRegErrorCode.getErrorDesc(-1), Integer.valueOf(this.a.a()), null, "", "", "", "");
                }
            });
            this.a = a.d;
        }
    }
}
