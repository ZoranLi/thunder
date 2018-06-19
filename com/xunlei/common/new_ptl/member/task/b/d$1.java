package com.xunlei.common.new_ptl.member.task.b;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import org.apache.http.Header;
import org.json.JSONObject;

/* compiled from: UserUnBindOtherAccountTask */
final class d$1 implements BaseHttpClientListener {
    private /* synthetic */ d a;

    d$1(d dVar) {
        this.a = dVar;
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        i = new String(bArr);
        headerArr = d.a(this.a);
        bArr = new StringBuilder("UserUnBindOtherAccountTask http body = ");
        bArr.append(i);
        XLLog.v(headerArr, bArr.toString());
        try {
            d.b(this.a, d.a(this.a, new JSONObject(i).getInt("code")));
        } catch (int i2) {
            i2.printStackTrace();
            d.b(this.a, 16781314);
        }
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        bArr = d.b(this.a);
        StringBuilder stringBuilder = new StringBuilder("UserUnBindOtherAccountTask http error = ");
        stringBuilder.append(th.getMessage());
        XLLog.v(bArr, stringBuilder.toString());
        d.b(this.a, 16781295);
    }
}
