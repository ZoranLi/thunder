package com.xunlei.common.httpclient.request;

import android.os.SystemClock;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.handler.HttpResponseHandler;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

/* compiled from: AsyncHttpRequest */
public final class a implements Runnable {
    private final AbstractHttpClient a;
    private final HttpContext b;
    private final HttpUriRequest c;
    private final HttpResponseHandler d;

    public a(AbstractHttpClient abstractHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, HttpResponseHandler httpResponseHandler) {
        this.a = abstractHttpClient;
        this.b = httpContext;
        this.c = httpUriRequest;
        this.d = httpResponseHandler;
    }

    public final void run() {
        try {
            if (this.d != null) {
                this.d.sendStartMessage();
            }
            StringBuilder stringBuilder = new StringBuilder("thread name:");
            stringBuilder.append(Thread.currentThread().getName());
            XLLog.v("AsyncHttpRequest", stringBuilder.toString());
            b();
            if (this.d != null) {
                this.d.sendFinishMessage();
            }
        } catch (Throwable e) {
            e.printStackTrace();
            if (this.d != null) {
                this.d.sendFinishMessage();
                this.d.sendFailureMessage(e, null);
            }
        }
    }

    private void a() throws IOException {
        if (!Thread.currentThread().isInterrupted()) {
            try {
                HttpResponse execute = this.a.execute(this.c, this.b);
                if (!(Thread.currentThread().isInterrupted() || this.d == null)) {
                    this.d.sendResponseMessage(execute);
                }
            } catch (IOException e) {
                e.printStackTrace();
                StringBuilder stringBuilder = new StringBuilder("IOException real error = ");
                stringBuilder.append(e.getMessage());
                XLLog.e("AsyncHttpRequest", stringBuilder.toString());
                if (!Thread.currentThread().isInterrupted()) {
                    throw e;
                }
            }
        }
    }

    private void b() throws IOException {
        IOException iOException = new IOException("asyn httpclient make request exception!");
        Object obj = null;
        do {
            try {
                if (!Thread.currentThread().isInterrupted()) {
                    HttpResponse execute = this.a.execute(this.c, this.b);
                    if (!(Thread.currentThread().isInterrupted() || this.d == null)) {
                        this.d.sendResponseMessage(execute);
                    }
                    return;
                }
                return;
            } catch (IOException e) {
                e.printStackTrace();
                StringBuilder stringBuilder = new StringBuilder("IOException real error = ");
                stringBuilder.append(e.getMessage());
                XLLog.e("AsyncHttpRequest", stringBuilder.toString());
                if (!Thread.currentThread().isInterrupted()) {
                    throw e;
                }
                return;
            } catch (Throwable e2) {
                e2.printStackTrace();
                if (this.d != null) {
                    this.d.sendFailureMessage(e2, "can't resolve host".getBytes());
                }
                return;
            } catch (Throwable e22) {
                e22.printStackTrace();
                if (this.d != null) {
                    this.d.sendFailureMessage(e22, "can't resolve host".getBytes());
                }
                return;
            } catch (Throwable e222) {
                e222.printStackTrace();
                if (this.d != null) {
                    this.d.sendFailureMessage(e222, "socket read time out".getBytes());
                }
                return;
            } catch (Throwable e3) {
                if (obj != null) {
                    if (this.d != null) {
                        this.d.sendFailureMessage(e3, "ssl socket error".getBytes());
                    }
                    return;
                }
                SystemClock.sleep(1000);
                obj = 1;
                XLLog.e("AsyncHttpRequest", "ssl socket hanshake error, retry once!");
                continue;
            } catch (IOException e4) {
                iOException = e4;
                iOException.printStackTrace();
                obj = null;
                continue;
            } catch (NullPointerException e5) {
                e5.printStackTrace();
                StringBuilder stringBuilder2 = new StringBuilder("NPE in HttpClient");
                stringBuilder2.append(e5.getMessage());
                iOException = new IOException(stringBuilder2.toString());
                obj = null;
                continue;
            }
        } while (obj != null);
        throw iOException;
    }
}
