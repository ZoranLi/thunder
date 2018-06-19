package com.xunlei.common.new_ptl.pay.a;

import com.xunlei.common.new_ptl.pay.XLOnPayListener;
import com.xunlei.common.new_ptl.pay.XLPayErrorCode;
import com.xunlei.common.new_ptl.pay.param.XLPayParam;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;

/* compiled from: XLPayTask */
public abstract class h {
    private static int e = 8000000;
    protected int a = 0;
    protected XLOnPayListener b = null;
    protected String c;
    protected boolean d = false;
    private int f = 0;
    private int g = 0;
    private Object h = null;

    private int h() {
        return 0;
    }

    public abstract void a(XLPayParam xLPayParam);

    public abstract void c();

    public abstract XLPayParam d();

    public final void a() {
        int i = e;
        e = i + 1;
        this.f = i;
    }

    public final int b() {
        return this.f;
    }

    private int g() {
        return this.a;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final void a(Object obj) {
        this.h = obj;
    }

    public final void a(XLOnPayListener xLOnPayListener) {
        this.b = xLOnPayListener;
    }

    public static i e() {
        return i.a();
    }

    public final Object f() {
        return this.h;
    }

    public static int a(Throwable th) {
        if (th instanceof SocketException) {
            return 10000;
        }
        if (th instanceof NoRouteToHostException) {
            return 10001;
        }
        if (th instanceof PortUnreachableException) {
            return 10002;
        }
        if (th instanceof ConnectException) {
            return 10003;
        }
        if (th instanceof SocketTimeoutException) {
            return 10010;
        }
        if (th instanceof ConnectTimeoutException) {
            return 10011;
        }
        if (th instanceof UnknownHostException) {
            return 10012;
        }
        if (th instanceof SSLException) {
            return 10013;
        }
        if (th instanceof NoHttpResponseException) {
            return 10020;
        }
        if (th instanceof HttpResponseException) {
            return 10021;
        }
        return (th instanceof ClientProtocolException) != null ? 10022 : XLPayErrorCode.XLP_GET_ORDER_ERROR;
    }

    public final void a(Object... objArr) {
        i.a().a(objArr);
    }
}
