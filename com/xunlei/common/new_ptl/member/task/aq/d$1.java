package com.xunlei.common.new_ptl.member.task.aq;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import org.apache.http.Header;
import org.json.JSONObject;

/* compiled from: UserAqSendMessageTask */
final class d$1 implements BaseHttpClientListener {
    private /* synthetic */ d a;

    d$1(d dVar) {
        this.a = dVar;
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        i = new String(bArr);
        headerArr = d.a(this.a);
        bArr = new StringBuilder("UserAqSendMessageTask send message result = ");
        bArr.append(i);
        XLLog.v(headerArr, bArr.toString());
        try {
            i = new JSONObject(i).getInt("result");
            if (i == 0) {
                d.a(this.a, null);
            } else if (i == 1102) {
                d.a(this.a, 16781277);
            } else if (i == 1104) {
                d.a(this.a, 16781276);
            } else if (i == 3003) {
                d.a(this.a, 16781272);
            } else if (i == 3005) {
                d.a(this.a, 16781271);
            } else if (i == 3009) {
                d.a(this.a, 16781270);
            } else if (i == 6002) {
                d.a(this.a, 16781279);
            } else if (i == 6004) {
                d.a(this.a, 16781278);
            } else {
                d.a(this.a, 16781281);
            }
        } catch (int i2) {
            i2.printStackTrace();
            d.a(this.a, 16781314);
        }
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        d.a(this.a, 16781295);
    }
}
