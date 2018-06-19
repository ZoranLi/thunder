package com.xunlei.common.new_ptl.member.task.j;

import android.os.Bundle;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import org.apache.http.Header;
import org.apache.http.client.HttpResponseException;

/* compiled from: UserVerifyedCodeTask */
final class c$1 implements BaseHttpClientListener {
    private /* synthetic */ c a;

    c$1(c cVar) {
        this.a = cVar;
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        c.a(this.a, "/verify/%s/%s?t=%s&header=true");
        i = new Bundle();
        headerArr = new String(bArr);
        StringBuilder stringBuilder = new StringBuilder("verify code ");
        stringBuilder.append(headerArr);
        XLLog.v("UserVerifyedCodeTask", stringBuilder.toString());
        bArr = Integer.valueOf(headerArr.replace("\r\n", "")).intValue();
        if (bArr == 200) {
            bArr = null;
        }
        i.putInt("errorCode", bArr);
        i.putString("action", "UserVerifyedCodeTask");
        i.putString("errorDesc", headerArr);
        this.a.d().a(this.a, i);
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder("error code = ");
        stringBuilder.append(th.getMessage());
        XLLog.e("UserVerifyedCodeTask", stringBuilder.toString());
        c.a(this.a, "/verify/%s/%s?t=%s&header=true");
        bArr = "未知错误";
        if (th instanceof HttpResponseException) {
            HttpResponseException httpResponseException = (HttpResponseException) th;
            byte[] statusCode = httpResponseException.getStatusCode();
            bArr = httpResponseException.getMessage();
            th = statusCode;
        } else {
            th = XLErrorCode.UNKNOWN_ERROR;
        }
        Bundle bundle = new Bundle();
        bundle.putString("action", "UserVerifyedCodeTask");
        bundle.putInt("errorCode", th);
        bundle.putString("errorDesc", bArr);
        this.a.d().a(this.a, bundle);
    }
}
