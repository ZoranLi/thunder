package com.xunlei.common.new_ptl.member.task.i;

import android.text.TextUtils;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserSetUserInfoTask */
final class f$1 implements BaseHttpClientListener {
    private /* synthetic */ f a;

    f$1(f fVar) {
        this.a = fVar;
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        String str;
        headerArr = f.a(this.a);
        StringBuilder stringBuilder = new StringBuilder("xl user set info http status = ");
        stringBuilder.append(i);
        XLLog.v(headerArr, stringBuilder.toString());
        if (i == 200) {
            i = "unpack error";
            try {
                str = new String(bArr, "UTF-8");
                try {
                    i = new JSONObject(str);
                    bArr = f.a(this.a, i.getInt("result"));
                } catch (UnsupportedEncodingException e) {
                    i = e;
                    bArr = 16781314;
                    i.printStackTrace();
                    i = f.a(this.a);
                    headerArr = new StringBuilder("xl user set info response = ");
                    headerArr.append(str);
                    XLLog.v(i, headerArr.toString());
                    f.b(this.a, bArr);
                    return;
                } catch (JSONException e2) {
                    i = e2;
                    bArr = 16781314;
                    i.printStackTrace();
                    i = f.a(this.a);
                    headerArr = new StringBuilder("xl user set info response = ");
                    headerArr.append(str);
                    XLLog.v(i, headerArr.toString());
                    f.b(this.a, bArr);
                    return;
                }
                try {
                    i = i.optString("verifytype");
                    if (TextUtils.isEmpty(i) == null) {
                        this.a.d().c(i);
                    }
                } catch (UnsupportedEncodingException e3) {
                    i = e3;
                    i.printStackTrace();
                    i = f.a(this.a);
                    headerArr = new StringBuilder("xl user set info response = ");
                    headerArr.append(str);
                    XLLog.v(i, headerArr.toString());
                    f.b(this.a, bArr);
                    return;
                } catch (JSONException e4) {
                    i = e4;
                    i.printStackTrace();
                    i = f.a(this.a);
                    headerArr = new StringBuilder("xl user set info response = ");
                    headerArr.append(str);
                    XLLog.v(i, headerArr.toString());
                    f.b(this.a, bArr);
                    return;
                }
            } catch (byte[] bArr2) {
                str = i;
                i = bArr2;
                bArr2 = 16781314;
                i.printStackTrace();
                i = f.a(this.a);
                headerArr = new StringBuilder("xl user set info response = ");
                headerArr.append(str);
                XLLog.v(i, headerArr.toString());
                f.b(this.a, bArr2);
                return;
            } catch (byte[] bArr22) {
                str = i;
                i = bArr22;
                bArr22 = 16781314;
                i.printStackTrace();
                i = f.a(this.a);
                headerArr = new StringBuilder("xl user set info response = ");
                headerArr.append(str);
                XLLog.v(i, headerArr.toString());
                f.b(this.a, bArr22);
                return;
            }
            i = f.a(this.a);
            headerArr = new StringBuilder("xl user set info response = ");
            headerArr.append(str);
            XLLog.v(i, headerArr.toString());
            f.b(this.a, bArr22);
            return;
        }
        f.b(this.a, 16781295);
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        bArr = f.a(this.a);
        StringBuilder stringBuilder = new StringBuilder("xl user set info error = ");
        stringBuilder.append(th.getMessage());
        XLLog.v(bArr, stringBuilder.toString());
        f.b(this.a, 16781295);
    }
}
