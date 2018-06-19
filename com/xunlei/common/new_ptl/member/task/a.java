package com.xunlei.common.new_ptl.member.task;

import android.os.Build.VERSION;
import android.os.Bundle;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.common.Constants;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.device.XLDeviceGen;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.a.g;
import com.xunlei.common.new_ptl.member.a.o;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.c.i;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.SSLException;
import org.apache.http.HttpException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserTask */
public abstract class a {
    private static int b = 1000000;
    private int a = a.a;
    private int c = 0;
    private p d = null;
    private Object e = null;
    private List<XLOnUserListener> f = new LinkedList();
    private boolean g = true;

    /* compiled from: UserTask */
    public enum a {
        ;

        static {
            e = new int[]{1, 2, 3, 4};
        }

        private static int[] a() {
            return (int[]) e.clone();
        }
    }

    protected static boolean b(int i) {
        if (!(i == 2 || i == 3 || i == 7 || i == 12 || i == 14)) {
            if (i != 15) {
                return false;
            }
        }
        return true;
    }

    protected static boolean c(int i) {
        if (!(i == 2 || i == 3 || i == 7 || i == 12 || i == 14 || i == 15)) {
            if (i != 6) {
                return false;
            }
        }
        return true;
    }

    protected static int e(int i) {
        return i == 9001 ? XLErrorCode.TUSER_CANCLE_BIND_MOBILE_ERROR : i < 10000 ? i : i == XLErrorCode.TUSER_CANCLE_BIND_MOBILE_ERROR ? XLErrorCode.TUSER_CANCLE_BIND_MOBILE_ERROR : XLErrorCode.TUSER_BIND_MOBILE_ERROR;
    }

    public void a(int i, i iVar) {
    }

    public void a(int i, String str) {
    }

    public void a(int i, String str, String str2) {
    }

    public void a(int i, String str, String str2, String str3, String str4) {
    }

    public abstract boolean a(XLOnUserListener xLOnUserListener, Bundle bundle);

    public abstract boolean h();

    public a(p pVar) {
        this.d = pVar;
        pVar = b;
        b = pVar + 1;
        this.c = pVar;
    }

    public void a() {
        this.a = a.a;
        this.f.clear();
    }

    public final boolean b() {
        return this.g;
    }

    public final void a(boolean z) {
        this.g = false;
    }

    public final void a(int i) {
        this.a = i;
    }

    public final int c() {
        return this.a;
    }

    public final p d() {
        return this.d;
    }

    public final o e() {
        return (o) this.d.i();
    }

    public final void a(Object obj) {
        this.e = obj;
    }

    public final Object f() {
        return this.e;
    }

    public final int g() {
        return this.c;
    }

    public final synchronized void a(XLOnUserListener xLOnUserListener) {
        if (xLOnUserListener != null) {
            this.f.add(xLOnUserListener);
        }
    }

    private synchronized void b(XLOnUserListener xLOnUserListener) {
        this.f.remove(xLOnUserListener);
    }

    public final synchronized boolean a(Bundle bundle) {
        if (a.d == this.a) {
            return false;
        }
        this.a = a.c;
        for (int i = 0; i < this.f.size(); i++) {
            XLOnUserListener xLOnUserListener = (XLOnUserListener) this.f.get(i);
            String simpleName = getClass().getSimpleName();
            StringBuilder stringBuilder = new StringBuilder("notify local listener index = ");
            stringBuilder.append(i);
            stringBuilder.append("# listener = ");
            stringBuilder.append(xLOnUserListener.toString());
            XLLog.v(simpleName, stringBuilder.toString());
            if (!a(xLOnUserListener, bundle)) {
                return false;
            }
        }
        return true;
    }

    protected final JSONObject i() {
        return f(203);
    }

    protected final JSONObject j() {
        return f(300);
    }

    private JSONObject f(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("protocolVersion", String.valueOf(i));
            jSONObject.put("sequenceNo", String.valueOf(this.c));
            jSONObject.put(DispatchConstants.PLATFORM_VERSION, "10");
            jSONObject.put("isCompressed", "0");
            jSONObject.put("appid", String.valueOf(this.d.d()));
            jSONObject.put("clientVersion", this.d.e());
            jSONObject.put("peerID", this.d.g());
            StringBuilder stringBuilder = new StringBuilder("ANDROID-");
            stringBuilder.append(this.d.m());
            jSONObject.put("appName", stringBuilder.toString());
            jSONObject.put(Constants.KEY_SDK_VERSION, String.valueOf(this.d.f()));
            jSONObject.put("devicesign", XLDeviceGen.getInstance().getDeviceIdSign());
            jSONObject.put("netWorkType", this.d.C());
            jSONObject.put("providerName", this.d.D());
            jSONObject.put("deviceModel", g.b());
            jSONObject.put("deviceName", g.c());
            jSONObject.put("OSVersion", VERSION.RELEASE);
        } catch (int i2) {
            i2.printStackTrace();
        }
        return jSONObject;
    }

    protected final JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DispatchConstants.PLATFORM_VERSION, 10);
            jSONObject.put("lastSequence", 0);
            jSONObject.put("accept", "");
            jSONObject.put("businessType", this.d.d());
            jSONObject.put("clientVersion", this.d.e());
            StringBuilder stringBuilder = new StringBuilder("ANDROID-");
            stringBuilder.append(this.d.m());
            jSONObject.put("appName", stringBuilder.toString());
            jSONObject.put(Constants.KEY_SDK_VERSION, String.valueOf(this.d.f()));
            jSONObject.put("devicesign", XLDeviceGen.getInstance().getDeviceIdSign());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static int a(Throwable th) {
        if (th instanceof NoRouteToHostException) {
            return 10001;
        }
        if (th instanceof ConnectException) {
            return 10003;
        }
        if (th instanceof PortUnreachableException) {
            return 10002;
        }
        if (th instanceof SocketException) {
            return 10000;
        }
        if (th instanceof SSLException) {
            return 10013;
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
        if (th instanceof NoHttpResponseException) {
            return 10020;
        }
        if (th instanceof HttpResponseException) {
            return 10021;
        }
        if (th instanceof ClientProtocolException) {
            return 10022;
        }
        if (th instanceof HttpException) {
            return XLErrorCode.HTTP_ERROR;
        }
        if (th instanceof JSONException) {
            return XLErrorCode.UNPACKAGE_ERROR;
        }
        return (th instanceof com.xunlei.common.new_ptl.member.b.a) != null ? 8 : XLErrorCode.UNKNOWN_ERROR;
    }

    protected final String l() {
        return getClass().getSimpleName();
    }

    private static int a(String str) {
        return Integer.valueOf(str).intValue();
    }

    protected static String d(int i) {
        return String.valueOf(i);
    }

    protected static String a(long j) {
        return String.valueOf(j);
    }

    private String n() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("platformVersion=10&appid=");
        stringBuffer.append(String.valueOf(this.d.d()));
        stringBuffer.append("&appName=");
        StringBuilder stringBuilder = new StringBuilder("ANDROID-");
        stringBuilder.append(this.d.m());
        stringBuffer.append(stringBuilder.toString());
        stringBuffer.append("&clientVersion=");
        stringBuffer.append(this.d.e());
        stringBuffer.append("&protocolVersion=203&deviceName=");
        stringBuffer.append(g.c());
        stringBuffer.append("&deviceModel=");
        stringBuffer.append(g.b());
        stringBuffer.append("&OSVersion=");
        stringBuffer.append(VERSION.RELEASE);
        stringBuffer.append("&devicesign=");
        stringBuffer.append(XLDeviceGen.getInstance().getDeviceIdSign());
        stringBuffer.append("&netWorkType=");
        stringBuffer.append(this.d.C());
        stringBuffer.append("&providerName=");
        stringBuffer.append(this.d.D());
        stringBuffer.append("&sdkVersion=");
        stringBuffer.append(String.valueOf(this.d.f()));
        return stringBuffer.toString();
    }

    private boolean m() {
        if (this.a == a.c) {
            return false;
        }
        this.a = a.d;
        return true;
    }
}
