package okhttp3.internal.b;

import okhttp3.HttpUrl;

/* compiled from: RequestLine */
public final class j {
    public static String a(HttpUrl httpUrl) {
        String e = httpUrl.e();
        httpUrl = httpUrl.g();
        if (httpUrl == null) {
            return e;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e);
        stringBuilder.append('?');
        stringBuilder.append(httpUrl);
        return stringBuilder.toString();
    }
}
