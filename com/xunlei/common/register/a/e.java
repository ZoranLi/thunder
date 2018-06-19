package com.xunlei.common.register.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.xunlei.common.device.XLDeviceGen;
import com.xunlei.common.encrypt.URLCoder;

/* compiled from: XLRegisterTask */
public abstract class e {
    private static int e = 1000000;
    protected int a = a.a;
    private f b;
    private int c;
    private String d;
    private String f;

    /* compiled from: XLRegisterTask */
    public enum a {
        ;

        static {
            e = new int[]{1, 2, 3, 4};
        }

        private static int[] a() {
            return (int[]) e.clone();
        }
    }

    public final void b(String str) {
    }

    public abstract void d();

    protected e(f fVar) {
        int i = e;
        e = i + 1;
        this.c = i;
        this.f = "";
        this.b = fVar;
    }

    public final int a() {
        return this.c;
    }

    private void f() {
        this.a = a.c;
    }

    public final void a(int i, Object... objArr) {
        this.b.a(i, objArr);
    }

    public final f b() {
        return this.b;
    }

    public final void a(String str) {
        this.f = str;
    }

    public final String c() {
        return this.f;
    }

    public static boolean c(String str) {
        if (str != null) {
            if (str.length() != null) {
                return null;
            }
        }
        return true;
    }

    private String g() {
        StringBuilder stringBuilder = new StringBuilder("ANDROID-");
        stringBuilder.append(this.b.h());
        return stringBuilder.toString();
    }

    private static String a(int i) {
        return String.valueOf(i);
    }

    protected final String a(boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("platformVersion=10&");
        stringBuffer.append("appid=");
        stringBuffer.append(String.valueOf(this.b.d()));
        stringBuffer.append("&");
        StringBuilder stringBuilder = new StringBuilder("ANDROID-");
        stringBuilder.append(this.b.h());
        String stringBuilder2 = stringBuilder.toString();
        if (z) {
            stringBuilder2 = URLCoder.encode(stringBuilder2, "UTF-8");
        }
        stringBuffer.append("appName=");
        stringBuffer.append(stringBuilder2);
        stringBuffer.append("&");
        stringBuilder2 = this.b.g();
        if (z) {
            stringBuilder2 = URLCoder.encode(stringBuilder2, "UTF-8");
        }
        stringBuffer.append("clientVersion=");
        stringBuffer.append(stringBuilder2);
        stringBuffer.append("&");
        stringBuffer.append("protocolVersion=3.1&");
        stringBuilder2 = c.c();
        if (z) {
            stringBuilder2 = URLCoder.encode(stringBuilder2, "UTF-8");
        }
        stringBuffer.append("deviceName=");
        stringBuffer.append(stringBuilder2);
        stringBuffer.append("&");
        stringBuilder2 = Build.MODEL;
        if (TextUtils.isEmpty(stringBuilder2)) {
            stringBuilder2 = "NONE";
        }
        if (z) {
            stringBuilder2 = URLCoder.encode(stringBuilder2, "UTF-8");
        }
        stringBuffer.append("deviceModel=");
        stringBuffer.append(stringBuilder2);
        stringBuffer.append("&");
        stringBuilder2 = VERSION.RELEASE;
        if (z) {
            stringBuilder2 = URLCoder.encode(stringBuilder2, "UTF-8");
        }
        stringBuffer.append("OSVersion=");
        stringBuffer.append(stringBuilder2);
        stringBuffer.append("&");
        stringBuffer.append("devicesign=");
        stringBuffer.append(XLDeviceGen.getInstance().getDeviceIdSign());
        stringBuffer.append("&");
        stringBuffer.append("netWorkType=");
        stringBuffer.append(this.b.j());
        stringBuffer.append("&");
        stringBuffer.append("providerName=");
        stringBuffer.append(this.b.k());
        stringBuffer.append("&");
        stringBuffer.append("sdkVersion=");
        stringBuffer.append(String.valueOf(this.b.i()));
        return stringBuffer.toString();
    }

    protected final String e() {
        return a(false);
    }
}
