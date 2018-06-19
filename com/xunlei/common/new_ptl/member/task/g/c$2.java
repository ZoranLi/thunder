package com.xunlei.common.new_ptl.member.task.g;

import android.support.v4.view.InputDeviceCompat;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import java.net.SocketTimeoutException;
import org.apache.http.Header;
import org.json.JSONObject;

/* compiled from: UserQRCodeLoginTask */
final class c$2 implements BaseHttpClientListener {
    final /* synthetic */ c a;

    c$2(c cVar) {
        this.a = cVar;
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        headerArr = c.a(this.a);
        StringBuilder stringBuilder = new StringBuilder("sub message return code = ");
        stringBuilder.append(i);
        XLLog.v(headerArr, stringBuilder.toString());
        if (i == 200) {
            i = new String(bArr);
            bArr = c.a(this.a);
            StringBuilder stringBuilder2 = new StringBuilder("sub message body = ");
            stringBuilder2.append(i);
            XLLog.v(bArr, stringBuilder2.toString());
            bArr = null;
            try {
                bArr = new JSONObject(i);
            } catch (int i2) {
                i2.printStackTrace();
            }
            if (bArr == null) {
                c.a(this.a, XLErrorCode.QR_LOGIN_ERROR);
                return;
            } else if (1024 == c.b(this.a)) {
                c.b(this.a, InputDeviceCompat.SOURCE_GAMEPAD);
                c.a(this.a, System.currentTimeMillis());
                if ("scan".equals(bArr.optString("action")) == 0) {
                    c.a(this.a, XLErrorCode.QR_LOGIN_ERROR);
                    return;
                } else {
                    this.a.d().n().post(new Runnable(this) {
                        private /* synthetic */ c$2 a;

                        {
                            this.a = r1;
                        }

                        public final void run() {
                            this.a.a.h();
                        }
                    });
                    return;
                }
            } else {
                if (InputDeviceCompat.SOURCE_GAMEPAD == c.b(this.a)) {
                    c.b(this.a, 1026);
                    if (bArr.optInt("result") != 200) {
                        c.a(this.a, XLErrorCode.QR_LOGIN_ERROR);
                        return;
                    }
                    c.b(this.a, bArr.optLong("userid"));
                    c.a(this.a, bArr.optString("clientsessionid"));
                    c.c(this.a);
                }
                return;
            }
        }
        c.a(this.a, XLErrorCode.QR_LOGIN_ERROR);
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        if ((th instanceof SocketTimeoutException) == null || System.currentTimeMillis() - c.d(this.a) >= c.e(this.a)) {
            bArr = c.a(this.a);
            StringBuilder stringBuilder = new StringBuilder("qr login error msg = ");
            stringBuilder.append(th.getMessage());
            XLLog.v(bArr, stringBuilder.toString());
            c.a(this.a, 50331654);
            return;
        }
        this.a.d().n().post(new Runnable(this) {
            private /* synthetic */ c$2 a;

            {
                this.a = r1;
            }

            public final void run() {
                this.a.a.h();
            }
        });
    }
}
