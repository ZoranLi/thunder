package com.xunlei.common.new_ptl.member.task.b;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.new_ptl.member.XLThirdUserInfo;
import org.apache.http.Header;
import org.json.JSONObject;

/* compiled from: UserGetOtherAccountInfoTask */
final class c$1 implements BaseHttpClientListener {
    private /* synthetic */ c a;

    c$1(c cVar) {
        this.a = cVar;
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        i = new String(bArr);
        headerArr = c.a(this.a);
        bArr = new StringBuilder("UserGetOtherAccountInfoTask http body = ");
        bArr.append(i);
        XLLog.v(headerArr, bArr.toString());
        try {
            headerArr = new JSONObject(i);
            i = headerArr.getInt("code");
            headerArr = headerArr.optJSONObject("thirdinfo");
            if (headerArr != null) {
                c.a(this.a, new XLThirdUserInfo(headerArr));
            }
            c.b(this.a, c.a(this.a, i));
        } catch (int i2) {
            i2.printStackTrace();
            c.b(this.a, 16781314);
        }
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        bArr = c.b(this.a);
        StringBuilder stringBuilder = new StringBuilder("UserGetOtherAccountInfoTask http error = ");
        stringBuilder.append(th.getMessage());
        XLLog.v(bArr, stringBuilder.toString());
        c.b(this.a, 16781295);
    }
}
