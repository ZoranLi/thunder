package com.umeng.message.common;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.proguard.c;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;

/* compiled from: Header */
public class b {
    public static final String E = "Android";
    public static final String F = "Android";
    private static final String G = "com.umeng.message.common.b";
    public String A;
    public String B;
    public String C;
    public String D;
    private final String H = "appkey";
    private final String I = "channel";
    private final String J = "device_id";
    private final String K = a.e;
    private final String L = "mc";
    private final String M = "umid";
    private final String N = "din";
    private final String O = "req_time";
    private final String P = SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID;
    private final String Q = "serial_number";
    private final String R = "device_model";
    private final String S = "os";
    private final String T = SocializeProtocolConstants.PROTOCOL_KEY_OS_VERSION;
    private final String U = "resolution";
    private final String V = "cpu";
    private final String W = "gpu_vender";
    private final String X = "gpu_renderer";
    private final String Y = "app_version";
    private final String Z = a.f;
    public String a;
    private final String aa = Constants.PACKAGE_NAME;
    private final String ab = "sdk_type";
    private final String ac = a.h;
    private final String ad = "timezone";
    private final String ae = "country";
    private final String af = "language";
    private final String ag = "access";
    private final String ah = "access_subtype";
    private final String ai = DispatchConstants.CARRIER;
    private final String aj = "wrapper_type";
    private final String ak = "wrapper_version";
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public long h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public int w;
    public String x;
    public String y;
    public String z;

    public b(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    private void d(JSONObject jSONObject) throws Exception {
        this.a = jSONObject.getString("appkey");
        this.c = jSONObject.getString("device_id");
        this.d = jSONObject.getString(a.e);
        if (jSONObject.has("mc")) {
            this.e = jSONObject.getString("mc");
        }
        if (jSONObject.has("channel")) {
            this.b = jSONObject.getString("channel");
        }
        if (jSONObject.has("req_time")) {
            this.h = jSONObject.getLong("req_time");
        }
    }

    private void e(JSONObject jSONObject) throws Exception {
        String str = null;
        this.k = jSONObject.has("device_model") ? jSONObject.getString("device_model") : null;
        this.l = jSONObject.has("os") ? jSONObject.getString("os") : null;
        this.m = jSONObject.has(SocializeProtocolConstants.PROTOCOL_KEY_OS_VERSION) ? jSONObject.getString(SocializeProtocolConstants.PROTOCOL_KEY_OS_VERSION) : null;
        this.n = jSONObject.has("resolution") ? jSONObject.getString("resolution") : null;
        this.o = jSONObject.has("cpu") ? jSONObject.getString("cpu") : null;
        this.p = jSONObject.has("gpu_vender") ? jSONObject.getString("gpu_vender") : null;
        this.q = jSONObject.has("gpu_renderer") ? jSONObject.getString("gpu_renderer") : null;
        this.i = jSONObject.has(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID) ? jSONObject.getString(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID) : null;
        if (jSONObject.has("serial_number")) {
            str = jSONObject.getString("serial_number");
        }
        this.j = str;
    }

    private void f(JSONObject jSONObject) throws Exception {
        String str = null;
        this.r = jSONObject.has("app_version") ? jSONObject.getString("app_version") : null;
        this.s = jSONObject.has(a.f) ? jSONObject.getString(a.f) : null;
        if (jSONObject.has(Constants.PACKAGE_NAME)) {
            str = jSONObject.getString(Constants.PACKAGE_NAME);
        }
        this.t = str;
    }

    private void g(JSONObject jSONObject) throws Exception {
        this.u = jSONObject.getString("sdk_type");
        this.v = jSONObject.getString(a.h);
    }

    private void h(JSONObject jSONObject) throws Exception {
        this.w = jSONObject.has("timezone") ? jSONObject.getInt("timezone") : 8;
        String str = null;
        this.x = jSONObject.has("country") ? jSONObject.getString("country") : null;
        if (jSONObject.has("language")) {
            str = jSONObject.getString("language");
        }
        this.y = str;
    }

    private void i(JSONObject jSONObject) throws Exception {
        String str = null;
        this.z = jSONObject.has("access") ? jSONObject.getString("access") : null;
        this.A = jSONObject.has("access_subtype") ? jSONObject.getString("access_subtype") : null;
        if (jSONObject.has(DispatchConstants.CARRIER)) {
            str = jSONObject.getString(DispatchConstants.CARRIER);
        }
        this.B = str;
    }

    private void j(JSONObject jSONObject) throws Exception {
        String str = null;
        this.C = jSONObject.has("wrapper_type") ? jSONObject.getString("wrapper_type") : null;
        if (jSONObject.has("wrapper_version")) {
            str = jSONObject.getString("wrapper_version");
        }
        this.D = str;
    }

    public void a(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            d(jSONObject);
            e(jSONObject);
            f(jSONObject);
            g(jSONObject);
            h(jSONObject);
            i(jSONObject);
            j(jSONObject);
        }
    }

    private void k(JSONObject jSONObject) throws Exception {
        jSONObject.put("appkey", this.a);
        if (this.a == null || 24 != this.a.length()) {
            this.c = c.a(new String[]{this.c, "utf-8"});
            this.g = c.a(new String[]{this.g, "utf-8"});
        } else {
            this.c = c.a(new String[]{this.c, "utf-8", this.a.substring(0, 16)});
            this.g = c.a(new String[]{this.g, "utf-8", this.a.substring(0, 16)});
        }
        jSONObject.put("device_id", this.c);
        jSONObject.put(a.e, this.d);
        if (this.b != null) {
            jSONObject.put("channel", this.b);
        }
        if (this.e != null) {
            jSONObject.put("mc", this.e);
        }
        if (this.h > 0) {
            jSONObject.put("req_time", this.h);
        }
        if (this.i != null) {
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, this.i);
        }
        if (this.j != null) {
            jSONObject.put("serial_number", this.j);
        }
        jSONObject.put("umid", this.f);
        jSONObject.put("din", this.g);
    }

    private void l(JSONObject jSONObject) throws Exception {
        jSONObject.put("appkey", this.a);
        if (this.a == null || 24 != this.a.length()) {
            this.g = c.a(new String[]{this.g, "utf-8"});
        } else {
            this.g = c.a(new String[]{this.g, "utf-8", this.a.substring(0, 16)});
        }
        if (this.b != null) {
            jSONObject.put("channel", this.b);
        }
        jSONObject.put("umid", this.f);
        jSONObject.put("din", this.g);
    }

    private void m(JSONObject jSONObject) throws Exception {
        if (this.k != null) {
            jSONObject.put("device_model", this.k);
        }
        if (this.l != null) {
            jSONObject.put("os", this.l);
        }
        if (this.m != null) {
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_OS_VERSION, this.m);
        }
        if (this.n != null) {
            jSONObject.put("resolution", this.n);
        }
        if (this.o != null) {
            jSONObject.put("cpu", this.o);
        }
        if (this.p != null) {
            jSONObject.put("gpu_vender", this.p);
        }
        if (this.q != null) {
            jSONObject.put("gpu_vender", this.q);
        }
    }

    private void n(JSONObject jSONObject) throws Exception {
        if (this.k != null) {
            jSONObject.put("device_model", this.k);
        }
        if (this.l != null) {
            jSONObject.put("os", this.l);
        }
        if (this.m != null) {
            jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_OS_VERSION, this.m);
        }
    }

    private void o(JSONObject jSONObject) throws Exception {
        if (this.r != null) {
            jSONObject.put("app_version", this.r);
        }
        if (this.s != null) {
            jSONObject.put(a.f, this.s);
        }
        if (this.t != null) {
            jSONObject.put(Constants.PACKAGE_NAME, this.t);
        }
    }

    private void p(JSONObject jSONObject) throws Exception {
        if (this.r != null) {
            jSONObject.put("app_version", this.r);
        }
        if (this.s != null) {
            jSONObject.put(a.f, this.s);
        }
    }

    private void q(JSONObject jSONObject) throws Exception {
        jSONObject.put("sdk_type", this.u);
        jSONObject.put(a.h, this.v);
    }

    private void r(JSONObject jSONObject) throws Exception {
        jSONObject.put("timezone", this.w);
        if (this.x != null) {
            jSONObject.put("country", this.x);
        }
        if (this.y != null) {
            jSONObject.put("language", this.y);
        }
    }

    private void s(JSONObject jSONObject) throws Exception {
        if (this.z != null) {
            jSONObject.put("access", this.z);
        }
        if (this.A != null) {
            jSONObject.put("access_subtype", this.A);
        }
        if (this.B != null) {
            jSONObject.put(DispatchConstants.CARRIER, this.B);
        }
    }

    private void t(JSONObject jSONObject) throws Exception {
        if (this.C != null) {
            jSONObject.put("wrapper_type", this.C);
        }
        if (this.D != null) {
            jSONObject.put("wrapper_version", this.D);
        }
    }

    public void b(JSONObject jSONObject) throws Exception {
        k(jSONObject);
        m(jSONObject);
        o(jSONObject);
        q(jSONObject);
        r(jSONObject);
        s(jSONObject);
        t(jSONObject);
    }

    public void c(JSONObject jSONObject) throws Exception {
        l(jSONObject);
        n(jSONObject);
        p(jSONObject);
        q(jSONObject);
        s(jSONObject);
    }

    public boolean a() {
        if (this.a == null) {
            UmLog.e(G, "missing appkey ");
            return false;
        }
        if (this.c != null) {
            if (this.d != null) {
                return true;
            }
        }
        UmLog.e(G, "missing device id");
        return false;
    }

    public void a(Context context, String... strArr) {
        if (strArr != null && strArr.length == 2) {
            this.a = strArr[0];
            this.b = strArr[1];
        }
        if (this.a == null) {
            this.a = PushAgent.getInstance(context).getMessageAppkey();
        }
        if (this.b == null) {
            this.b = PushAgent.getInstance(context).getMessageChannel();
        }
        this.c = UmengMessageDeviceConfig.getDeviceId(context);
        this.d = UmengMessageDeviceConfig.getDeviceIdMD5(context);
        this.e = UmengMessageDeviceConfig.getMac(context);
        this.g = UmengMessageDeviceConfig.getDIN(context);
        this.f = UmengMessageDeviceConfig.getUmid(context);
    }

    public void a(Context context) {
        this.k = Build.MODEL;
        this.l = "Android";
        this.m = VERSION.RELEASE;
        this.n = UmengMessageDeviceConfig.getResolution(context);
        this.o = UmengMessageDeviceConfig.getCPU();
        this.i = UmengMessageDeviceConfig.getAndroidId(context);
        this.j = UmengMessageDeviceConfig.getSerial_number();
    }

    public void b(Context context) {
        this.r = UmengMessageDeviceConfig.getAppVersionName(context);
        this.s = UmengMessageDeviceConfig.getAppVersionCode(context);
        this.t = UmengMessageDeviceConfig.getPackageName(context);
    }

    public void c(Context context) {
        this.u = "Android";
        this.v = MsgConstant.SDK_VERSION;
    }

    public void d(Context context) {
        this.w = UmengMessageDeviceConfig.getTimeZone(context);
        context = UmengMessageDeviceConfig.getLocaleInfo(context);
        this.x = context[0];
        this.y = context[1];
    }

    public void e(Context context) {
        String[] networkAccessMode = UmengMessageDeviceConfig.getNetworkAccessMode(context);
        this.z = networkAccessMode[0];
        this.A = networkAccessMode[1];
        this.B = UmengMessageDeviceConfig.getOperator(context);
    }

    public void b(Context context, String... strArr) {
        a(context, strArr);
        a(context);
        b(context);
        c(context);
        d(context);
        e(context);
    }

    public void c(Context context, String... strArr) {
        a(context, strArr);
        a(context);
        b(context);
        c(context);
        e(context);
    }

    public boolean b() {
        return (this.a == null || this.c == null) ? false : true;
    }
}
