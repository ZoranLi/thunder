package com.xunlei.common.new_ptl.member.task.aq;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import org.apache.http.Header;
import org.json.JSONObject;

/* compiled from: UserAqBindMobileTask */
final class a$1 implements BaseHttpClientListener {
    private /* synthetic */ a a;

    a$1(a aVar) {
        this.a = aVar;
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        i = new String(bArr);
        headerArr = a.a(this.a);
        bArr = new StringBuilder("UserAqBindMobileTask bind mobile result = ");
        bArr.append(i);
        XLLog.v(headerArr, bArr.toString());
        try {
            i = new JSONObject(i).getInt("result");
            if (i == 0) {
                a.a(this.a, null);
            } else if (i == 1102) {
                a.a(this.a, 16781277);
            } else if (i == 1104) {
                a.a(this.a, 16781276);
            } else if (i == 3003) {
                a.a(this.a, 16781272);
            } else if (i == 3005) {
                a.a(this.a, 16781271);
            } else if (i == 3009) {
                a.a(this.a, 16781270);
            } else if (i == 6002) {
                a.a(this.a, 16781279);
            } else if (i == 6004) {
                a.a(this.a, 16781278);
            } else {
                a.a(this.a, 16781280);
            }
        } catch (int i2) {
            i2.printStackTrace();
            a.a(this.a, 16781314);
        }
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        a.a(this.a, 16781295);
    }
}
