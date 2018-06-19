package com.qiniu.android.http;

import com.umeng.message.util.HttpRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.af;
import okhttp3.aj;
import okhttp3.b;
import okio.ByteString;

/* compiled from: ProxyConfiguration */
final class n implements b {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
    }

    public final af a(aj ajVar) throws IOException {
        String str = this.a.c;
        String str2 = this.a.d;
        Charset forName = Charset.forName("ISO-8859-1");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(str2);
        str = ByteString.of(stringBuilder.toString().getBytes(forName)).base64();
        StringBuilder stringBuilder2 = new StringBuilder("Basic ");
        stringBuilder2.append(str);
        return ajVar.a.a().a(HttpRequest.HEADER_PROXY_AUTHORIZATION, stringBuilder2.toString()).a("Proxy-Connection", "Keep-Alive").a();
    }
}
