package com.xunlei.common.new_ptl.member.task.b;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.new_ptl.member.XLThirdUserInfo;
import org.apache.http.Header;
import org.json.JSONObject;

/* compiled from: UserBindOtherAccountTask */
final class a$1 implements BaseHttpClientListener {
    private /* synthetic */ a a;

    a$1(a aVar) {
        this.a = aVar;
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        i = new String(bArr);
        headerArr = a.a(this.a);
        bArr = new StringBuilder("UserBindOtherAccountTask http body = ");
        bArr.append(i);
        XLLog.v(headerArr, bArr.toString());
        try {
            headerArr = new JSONObject(i);
            i = headerArr.getInt("code");
            headerArr = headerArr.optJSONObject("thirdinfo");
            if (headerArr != null) {
                a.a(this.a, new XLThirdUserInfo(headerArr));
            }
            a.b(this.a, a.a(this.a, i));
        } catch (int i2) {
            i2.printStackTrace();
            a.b(this.a, 16781314);
        }
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        bArr = a.b(this.a);
        StringBuilder stringBuilder = new StringBuilder("UserBindOtherAccountTask http error = ");
        stringBuilder.append(th.getMessage());
        XLLog.v(bArr, stringBuilder.toString());
        a.b(this.a, 16781295);
    }
}
