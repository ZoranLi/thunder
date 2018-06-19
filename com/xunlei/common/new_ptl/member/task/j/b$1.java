package com.xunlei.common.new_ptl.member.task.j;

import android.os.Bundle;
import anet.channel.util.HttpConstant;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import org.apache.http.Header;
import org.apache.http.HeaderElement;

/* compiled from: UserVerifyCodeTask */
final class b$1 implements BaseHttpClientListener {
    private /* synthetic */ String a;
    private /* synthetic */ b b;

    b$1(b bVar, String str) {
        this.b = bVar;
        this.a = str;
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        Bundle bundle = new Bundle();
        String str = "";
        int i2 = 1;
        for (Header header : headerArr) {
            if (header.getName().compareToIgnoreCase(HttpConstant.SET_COOKIE) == 0) {
                HeaderElement[] elements = header.getElements();
                String str2 = str;
                for (HeaderElement headerElement : elements) {
                    if (headerElement.getName().compareToIgnoreCase("VERIFY_KEY") == 0) {
                        str2 = headerElement.getValue();
                        StringBuilder stringBuilder = new StringBuilder("VERIFY_KEY = ");
                        stringBuilder.append(str2);
                        XLLog.v("UserVerifyCodeTask", stringBuilder.toString());
                    }
                }
                str = str2;
            }
            if (header.getName().compareToIgnoreCase("Content-Type") == 0) {
                i2 = header.getValue().compareToIgnoreCase("image/jpeg") == 0 ? 1 : header.getValue().compareToIgnoreCase("image/png") == 0 ? 2 : header.getValue().compareToIgnoreCase("image/bmp") == 0 ? 3 : 4;
            }
        }
        b.a(this.b, this.a);
        bundle.putString("verifyKey", str);
        bundle.putInt("imageType", i2);
        bundle.putByteArray("imageContent", bArr);
        bundle.putInt("errorCode", 0);
        bundle.putString("action", "UserVerifyCodeTask");
        this.b.d().a(this.b, bundle);
        XLLog.v("UserVerifyCodeTask", "get verify code.");
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        if (b.n() < b.o().length) {
            this.b.h();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("error = ");
        stringBuilder.append(th.getMessage());
        XLLog.e("UserVerifyCodeTask", stringBuilder.toString());
        b.a(this.b, this.a);
        th = new Bundle();
        th.putString("verifyKey", "");
        th.putInt("imageType", -1);
        th.putString("imageContent", null);
        th.putInt("errorCode", XLErrorCode.UNKNOWN_ERROR);
        th.putString("action", "UserVerifyCodeTask");
        this.b.d().a(this.b, th);
    }
}
