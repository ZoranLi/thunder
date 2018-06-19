package com.xunlei.common.new_ptl.member.task.b;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.new_ptl.member.XLBindedOtherAccountItem;
import org.apache.http.Header;
import org.json.JSONObject;

/* compiled from: UserCheckBindOtherAccountTask */
final class b$1 implements BaseHttpClientListener {
    private /* synthetic */ b a;

    b$1(b bVar) {
        this.a = bVar;
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        i = new String(bArr);
        headerArr = b.a(this.a);
        bArr = new StringBuilder("UserCheckBindOtherAccountTask http body = ");
        bArr.append(i);
        XLLog.v(headerArr, bArr.toString());
        try {
            headerArr = new JSONObject(i);
            i = b.a(this.a, headerArr.getInt("code"));
            if (i == 0) {
                headerArr = headerArr.optJSONObject("data");
                if (headerArr != null) {
                    b.a(this.a, new XLBindedOtherAccountItem[headerArr.length()]);
                    bArr = headerArr.keys();
                    int i2 = 0;
                    while (bArr.hasNext()) {
                        String str = (String) bArr.next();
                        int i3 = i2 + 1;
                        b.b(this.a)[i2] = new XLBindedOtherAccountItem(b.a(this.a, str), headerArr.getInt(str));
                        i2 = i3;
                    }
                }
            }
            headerArr = b.c(this.a);
            bArr = new StringBuilder("UserCheckBindOtherAccountTask http error code = ");
            bArr.append(i);
            XLLog.v(headerArr, bArr.toString());
            b.b(this.a, i);
        } catch (int i4) {
            i4.printStackTrace();
            b.b(this.a, 16781314);
        }
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        bArr = b.d(this.a);
        StringBuilder stringBuilder = new StringBuilder("UserCheckBindOtherAccountTask http error = ");
        stringBuilder.append(th.getMessage());
        XLLog.v(bArr, stringBuilder.toString());
        b.b(this.a, 16781295);
    }
}
