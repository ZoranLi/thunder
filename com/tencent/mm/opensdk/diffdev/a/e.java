package com.tencent.mm.opensdk.diffdev.a;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

public final class e {
    public static byte[] b(String str, int i) {
        if (str == null || str.length() == 0) {
            return null;
        }
        HttpClient defaultHttpClient = new DefaultHttpClient();
        HttpUriRequest httpGet = new HttpGet(str);
        if (i >= 0) {
            try {
                HttpConnectionParams.setSoTimeout(defaultHttpClient.getParams(), i);
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder("httpGet, Exception ex = ");
                str = e.getMessage();
                stringBuilder.append(str);
                return null;
            } catch (IncompatibleClassChangeError e2) {
                stringBuilder = new StringBuilder("httpGet, IncompatibleClassChangeError ex = ");
                str = e2.getMessage();
                stringBuilder.append(str);
                return null;
            } catch (Throwable th) {
                stringBuilder = new StringBuilder("httpGet, Throwable ex = ");
                str = th.getMessage();
                stringBuilder.append(str);
                return null;
            }
        }
        HttpResponse execute = defaultHttpClient.execute(httpGet);
        if (execute.getStatusLine().getStatusCode() == 200) {
            return EntityUtils.toByteArray(execute.getEntity());
        }
        new StringBuilder("httpGet fail, status code = ").append(execute.getStatusLine().getStatusCode());
        return null;
    }
}
