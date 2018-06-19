package com.xunlei.common.new_ptl.member.task.a;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.new_ptl.member.XLAvatarItem;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import org.apache.http.Header;
import org.json.JSONObject;

/* compiled from: UserGetRecommendAvatarsTask */
final class a$1 implements BaseHttpClientListener {
    private /* synthetic */ a a;

    a$1(a aVar) {
        this.a = aVar;
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        headerArr = a.a(this.a);
        StringBuilder stringBuilder = new StringBuilder("statusCode = ");
        stringBuilder.append(i);
        XLLog.v(headerArr, stringBuilder.toString());
        if (i == 200) {
            try {
                headerArr = new String(bArr, "UTF-8");
                bArr = a.b(this.a);
                stringBuilder = new StringBuilder("response from server body = ");
                stringBuilder.append(headerArr);
                XLLog.v(bArr, stringBuilder.toString());
                bArr = new JSONObject(headerArr);
                headerArr = a.a(this.a, bArr.getInt("result"));
                if (headerArr == null) {
                    headerArr = bArr.getJSONArray("data");
                    bArr = headerArr.length();
                    if (bArr > null) {
                        a.a(this.a, new XLAvatarItem[bArr]);
                        for (int i2 = 0; i2 < bArr; i2++) {
                            a.c(this.a)[i2] = new XLAvatarItem((JSONObject) headerArr.get(i2));
                        }
                        a.b(this.a, 0);
                        return;
                    }
                    a.b(this.a, 16781294);
                    return;
                }
                a.b(this.a, headerArr);
                return;
            } catch (Header[] headerArr2) {
                headerArr2.printStackTrace();
                a.b(this.a, XLErrorCode.UNPACKAGE_ERROR);
                return;
            } catch (Header[] headerArr22) {
                headerArr22.printStackTrace();
                a.b(this.a, XLErrorCode.UNPACKAGE_ERROR);
                return;
            }
        }
        a.b(this.a, 16781295);
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        a.b(this.a, 16781295);
        XLLog.v(a.d(this.a), "UserGetRecommendAvatarsTask onFailure");
    }
}
