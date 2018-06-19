package com.xunlei.common.new_ptl.member.task.a;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import org.apache.http.Header;
import org.json.JSONObject;

/* compiled from: UserSelectRecommendAvatarTask */
final class b$1 implements BaseHttpClientListener {
    private /* synthetic */ b a;

    b$1(b bVar) {
        this.a = bVar;
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        if (i == 200) {
            i = new String(bArr);
            headerArr = b.a(this.a);
            bArr = new StringBuilder("select recommend avatar body = ");
            bArr.append(i);
            XLLog.v(headerArr, bArr.toString());
            try {
                b.b(this.a, b.a(this.a, new JSONObject(i).getInt("result")));
                return;
            } catch (int i2) {
                i2.printStackTrace();
                b.b(this.a, 16781314);
                return;
            }
        }
        b.b(this.a, 16781295);
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        XLLog.v(b.b(this.a), "select recommend avatar onFailure");
        b.b(this.a, 16781295);
    }
}
