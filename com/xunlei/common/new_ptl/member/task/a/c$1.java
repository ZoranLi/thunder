package com.xunlei.common.new_ptl.member.task.a;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import org.apache.http.Header;
import org.json.JSONObject;

/* compiled from: UserSetAvatarTask */
final class c$1 implements BaseHttpClientListener {
    private /* synthetic */ c a;

    c$1(c cVar) {
        this.a = cVar;
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        headerArr = c.a(this.a);
        StringBuilder stringBuilder = new StringBuilder("set avatar response status = ");
        stringBuilder.append(i);
        XLLog.v(headerArr, stringBuilder.toString());
        if (i == 200) {
            i = new String(bArr);
            headerArr = c.b(this.a);
            bArr = new StringBuilder("set avatar response body = ");
            bArr.append(i);
            XLLog.v(headerArr, bArr.toString());
            try {
                headerArr = new JSONObject(i);
                i = c.a(this.a, headerArr.getInt("result"));
                if (i == 0 && headerArr.optInt("autoaudit", 100) == null) {
                    i = XLErrorCode.AVATAR_MANUAL_AUDIT;
                }
                c.b(this.a, i);
                return;
            } catch (int i2) {
                i2.printStackTrace();
                c.b(this.a, 16781314);
                return;
            }
        }
        c.b(this.a, 16781295);
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        bArr = c.c(this.a);
        StringBuilder stringBuilder = new StringBuilder("set avatar onFailure message = ");
        stringBuilder.append(th.getMessage());
        XLLog.v(bArr, stringBuilder.toString());
        c.b(this.a, 16781295);
    }
}
