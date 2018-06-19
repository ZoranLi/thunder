package com.xunlei.common.new_ptl.member.task.i;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserGetCityCodeByIpTask */
final class a$1 implements BaseHttpClientListener {
    private /* synthetic */ a a;

    a$1(a aVar) {
        this.a = aVar;
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        headerArr = a.a(this.a);
        StringBuilder stringBuilder = new StringBuilder("xl user set info http status = ");
        stringBuilder.append(i);
        XLLog.v(headerArr, stringBuilder.toString());
        if (i == 200) {
            String str;
            i = "unpack error";
            try {
                str = new String(bArr, "UTF-8");
                try {
                    i = new JSONObject(str);
                    bArr = a.a(this.a, i.getInt("result"));
                    if (bArr == null) {
                        try {
                            a.a(this.a, new JSONObject());
                            a.b(this.a).put("province", i.get("province"));
                            a.b(this.a).put("provincecode", i.get("provincecode"));
                            a.b(this.a).put("city", i.get("city"));
                            a.b(this.a).put("citycode", i.get("citycode"));
                        } catch (UnsupportedEncodingException e) {
                            i = e;
                            i.printStackTrace();
                            i = a.a(this.a);
                            headerArr = new StringBuilder("xl user set info response = ");
                            headerArr.append(str);
                            XLLog.v(i, headerArr.toString());
                            a.b(this.a, bArr);
                            return;
                        } catch (JSONException e2) {
                            i = e2;
                            i.printStackTrace();
                            i = a.a(this.a);
                            headerArr = new StringBuilder("xl user set info response = ");
                            headerArr.append(str);
                            XLLog.v(i, headerArr.toString());
                            a.b(this.a, bArr);
                            return;
                        }
                    }
                } catch (UnsupportedEncodingException e3) {
                    i = e3;
                    bArr = 16781314;
                    i.printStackTrace();
                    i = a.a(this.a);
                    headerArr = new StringBuilder("xl user set info response = ");
                    headerArr.append(str);
                    XLLog.v(i, headerArr.toString());
                    a.b(this.a, bArr);
                    return;
                } catch (JSONException e4) {
                    i = e4;
                    bArr = 16781314;
                    i.printStackTrace();
                    i = a.a(this.a);
                    headerArr = new StringBuilder("xl user set info response = ");
                    headerArr.append(str);
                    XLLog.v(i, headerArr.toString());
                    a.b(this.a, bArr);
                    return;
                }
            } catch (byte[] bArr2) {
                str = i;
                i = bArr2;
                bArr2 = 16781314;
                i.printStackTrace();
                i = a.a(this.a);
                headerArr = new StringBuilder("xl user set info response = ");
                headerArr.append(str);
                XLLog.v(i, headerArr.toString());
                a.b(this.a, bArr2);
                return;
            } catch (byte[] bArr22) {
                str = i;
                i = bArr22;
                bArr22 = 16781314;
                i.printStackTrace();
                i = a.a(this.a);
                headerArr = new StringBuilder("xl user set info response = ");
                headerArr.append(str);
                XLLog.v(i, headerArr.toString());
                a.b(this.a, bArr22);
                return;
            }
            i = a.a(this.a);
            headerArr = new StringBuilder("xl user set info response = ");
            headerArr.append(str);
            XLLog.v(i, headerArr.toString());
            a.b(this.a, bArr22);
            return;
        }
        a.b(this.a, 16781295);
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        bArr = a.a(this.a);
        StringBuilder stringBuilder = new StringBuilder("xl user set info error = ");
        stringBuilder.append(th.getMessage());
        XLLog.v(bArr, stringBuilder.toString());
        a.b(this.a, 16781295);
    }
}
