package com.xunlei.common.httpclient.request;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

/* compiled from: RetryHandler */
public final class c implements HttpRequestRetryHandler {
    private static final int a = 1000;
    private static HashSet<Class<?>> b = new HashSet();
    private static HashSet<Class<?>> c = new HashSet();
    private final int d = 5;

    static {
        b.add(NoHttpResponseException.class);
        b.add(UnknownHostException.class);
        b.add(SocketException.class);
        b.add(SSLException.class);
        c.add(InterruptedIOException.class);
    }

    public c(int i) {
    }

    public final boolean retryRequest(IOException iOException, int i, HttpContext httpContext) {
        Boolean bool = (Boolean) httpContext.getAttribute("http.request_sent");
        boolean z = false;
        if (bool == null || !bool.booleanValue()) {
            Object obj = null;
        } else {
            int i2 = 1;
        }
        if (i <= this.d) {
            if (a(c, iOException) == 0) {
                i = a(b, iOException);
                z = true;
            }
        }
        if (z) {
            z = ((HttpUriRequest) httpContext.getAttribute("http.request")).getMethod().equals("POST") ^ 1;
        }
        if (z) {
            SystemClock.sleep(1000);
        } else {
            iOException.printStackTrace();
        }
        return z;
    }

    private static boolean a(HashSet<Class<?>> hashSet, Throwable th) {
        hashSet = hashSet.iterator();
        while (hashSet.hasNext()) {
            if (((Class) hashSet.next()).isInstance(th)) {
                return true;
            }
        }
        return null;
    }
}
