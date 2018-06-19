package com.xunlei.common.new_ptl.member.task.j;

import android.os.Bundle;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import org.apache.http.Header;
import org.apache.http.client.HttpResponseException;

/* compiled from: UserPreVerifyCodeTask */
final class a$1 implements BaseHttpClientListener {
    private /* synthetic */ a a;

    a$1(a aVar) {
        this.a = aVar;
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        a.a(this.a, a.m());
        i = new Bundle();
        headerArr = new String(bArr);
        XLLog.v("UserPreVerifyCodeTask", headerArr);
        bArr = Integer.valueOf(headerArr.replace("\r\n", "")).intValue();
        if (bArr == 200) {
            bArr = null;
        }
        i.putInt("errorCode", bArr);
        i.putString("action", "UserPreVerifyCodeTask");
        i.putString("errorDesc", headerArr);
        this.a.d().a(this.a, i);
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder("error = ");
        stringBuilder.append(th.getMessage());
        XLLog.e("UserPreVerifyCodeTask", stringBuilder.toString());
        a.a(this.a, a.m());
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
        bundle.putString("action", "UserPreVerifyCodeTask");
        bundle.putInt("errorCode", th);
        bundle.putString("errorDesc", bArr);
        this.a.d().a(this.a, bundle);
    }
}
