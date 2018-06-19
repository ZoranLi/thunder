package com.xunlei.common.new_ptl.pay.b.a;

import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.new_ptl.pay.a.i;
import com.xunlei.common.new_ptl.pay.b.a.a.a;
import org.apache.http.Header;
import org.apache.http.NoHttpResponseException;

/* compiled from: AsyncHttpProxy */
final class a$a$1 implements BaseHttpClientListener {
    final /* synthetic */ a a;

    a$a$1(a aVar) {
        this.a = aVar;
    }

    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
        XLLog.v(a.b(), "http request succeed");
        a.a(this.a).a(new String(bArr));
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        bArr = a.b();
        StringBuilder stringBuilder = new StringBuilder("http request fail, message = ");
        stringBuilder.append(th.getMessage());
        XLLog.v(bArr, stringBuilder.toString());
        if (a.b(this.a) < 3) {
            if ((th instanceof NoHttpResponseException) != null) {
                new Thread(new Runnable(this) {
                    private /* synthetic */ a$a$1 a;

                    {
                        this.a = r1;
                    }

                    public final void run() {
                        XLLog.v(a.b(), "NoHttpResponseException clearInvalidConnections and restry");
                        i.a().e().clearInvalidConnections();
                        this.a.a.a();
                    }
                }).start();
                return;
            }
            this.a.a();
        }
    }
}
