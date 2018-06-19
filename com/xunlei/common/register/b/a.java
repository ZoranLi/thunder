package com.xunlei.common.register.b;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.register.XLRegErrorCode;
import com.xunlei.common.register.a.d;
import com.xunlei.common.register.a.e;
import com.xunlei.common.register.a.f;
import org.apache.http.Header;
import org.json.JSONObject;

/* compiled from: XLCheckBindTask */
public final class a extends e {
    private String b = "";
    private int c = 1;

    public a(f fVar) {
        super(fVar);
    }

    public final void d(String str) {
        if (str != null) {
            this.b = str;
        }
    }

    public final void a(int i) {
        this.c = i;
    }

    public final void d() {
        if (this.a != com.xunlei.common.register.a.e.a.c) {
            this.a = com.xunlei.common.register.a.e.a.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("op=checkBind");
            stringBuilder.append("&");
            StringBuilder stringBuilder2 = new StringBuilder("account=");
            stringBuilder2.append(this.b);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append("&");
            stringBuilder.append("type=");
            stringBuilder.append(this.c);
            stringBuilder.append("&");
            stringBuilder.append(a(true));
            stringBuilder.append("&");
            stringBuilder.append("callback=");
            XLLog.v("XLCheckBindTask", stringBuilder.toString());
            d.a().b(null, stringBuilder.toString(), new BaseHttpClientListener(this) {
                private /* synthetic */ a a;

                {
                    this.a = r1;
                }

                public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    if (i == 200) {
                        i = new String(bArr);
                        XLLog.v("XLCheckBindTask", i);
                        try {
                            bArr = new JSONObject(i);
                            bArr = bArr.optInt("result") == 200 ? bArr.getInt("binded") : null;
                            this.a.a(2, Integer.valueOf(bArr.optInt("result")), XLRegErrorCode.getErrorDesc(bArr.optInt("result")), Integer.valueOf(this.a.a()), Integer.valueOf(bArr));
                            return;
                        } catch (int i2) {
                            i2.printStackTrace();
                            this.a.a(2, Integer.valueOf(-2), XLRegErrorCode.getErrorDesc(-2), Integer.valueOf(this.a.a()), Integer.valueOf(-1));
                            return;
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder("error = ");
                    stringBuilder.append(i2);
                    XLLog.v("XLCheckBindTask", stringBuilder.toString());
                    this.a.a(2, Integer.valueOf(-2), XLRegErrorCode.getErrorDesc(-2), Integer.valueOf(this.a.a()), Integer.valueOf(-1));
                }

                public final void onFailure(Throwable th, byte[] bArr) {
                    StringBuilder stringBuilder = new StringBuilder("error = ");
                    stringBuilder.append(th.getMessage());
                    XLLog.e("XLCheckBindTask", stringBuilder.toString());
                    this.a.a(2, Integer.valueOf(-1), XLRegErrorCode.getErrorDesc(-1), Integer.valueOf(this.a.a()), Integer.valueOf(-1));
                }
            });
            this.a = com.xunlei.common.register.a.e.a.d;
        }
    }
}
