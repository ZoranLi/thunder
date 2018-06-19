package com.xunlei.common.new_ptl.member.task.i;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserGetCityInfoTask */
final class b$1 implements BaseHttpClientListener {
    private /* synthetic */ b a;

    b$1(b bVar) {
        this.a = bVar;
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        headerArr = b.a(this.a);
        StringBuilder stringBuilder = new StringBuilder("xl user get city info http status = ");
        stringBuilder.append(i);
        XLLog.v(headerArr, stringBuilder.toString());
        if (i == 200) {
            String str;
            i = "unpack error";
            try {
                str = new String(bArr, "UTF-8");
                try {
                    i = new JSONObject(str);
                    bArr = b.a(this.a, i.getInt("result"));
                    if (bArr == null) {
                        try {
                            b.a(this.a, i.getJSONObject("cities"));
                            i.getInt("dataversion");
                        } catch (UnsupportedEncodingException e) {
                            i = e;
                            i.printStackTrace();
                            i = b.a(this.a);
                            headerArr = new StringBuilder("xl user get city info response = ");
                            headerArr.append(str);
                            XLLog.v(i, headerArr.toString());
                            b.b(this.a, bArr);
                            return;
                        } catch (JSONException e2) {
                            i = e2;
                            i.printStackTrace();
                            i = b.a(this.a);
                            headerArr = new StringBuilder("xl user get city info response = ");
                            headerArr.append(str);
                            XLLog.v(i, headerArr.toString());
                            b.b(this.a, bArr);
                            return;
                        }
                    }
                } catch (UnsupportedEncodingException e3) {
                    i = e3;
                    bArr = 16781314;
                    i.printStackTrace();
                    i = b.a(this.a);
                    headerArr = new StringBuilder("xl user get city info response = ");
                    headerArr.append(str);
                    XLLog.v(i, headerArr.toString());
                    b.b(this.a, bArr);
                    return;
                } catch (JSONException e4) {
                    i = e4;
                    bArr = 16781314;
                    i.printStackTrace();
                    i = b.a(this.a);
                    headerArr = new StringBuilder("xl user get city info response = ");
                    headerArr.append(str);
                    XLLog.v(i, headerArr.toString());
                    b.b(this.a, bArr);
                    return;
                }
            } catch (byte[] bArr2) {
                str = i;
                i = bArr2;
                bArr2 = 16781314;
                i.printStackTrace();
                i = b.a(this.a);
                headerArr = new StringBuilder("xl user get city info response = ");
                headerArr.append(str);
                XLLog.v(i, headerArr.toString());
                b.b(this.a, bArr2);
                return;
            } catch (byte[] bArr22) {
                str = i;
                i = bArr22;
                bArr22 = 16781314;
                i.printStackTrace();
                i = b.a(this.a);
                headerArr = new StringBuilder("xl user get city info response = ");
                headerArr.append(str);
                XLLog.v(i, headerArr.toString());
                b.b(this.a, bArr22);
                return;
            }
            i = b.a(this.a);
            headerArr = new StringBuilder("xl user get city info response = ");
            headerArr.append(str);
            XLLog.v(i, headerArr.toString());
            b.b(this.a, bArr22);
            return;
        }
        b.b(this.a, 16781295);
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        bArr = b.a(this.a);
        StringBuilder stringBuilder = new StringBuilder("xl user set info error = ");
        stringBuilder.append(th.getMessage());
        XLLog.v(bArr, stringBuilder.toString());
        b.b(this.a, 16781295);
    }
}
