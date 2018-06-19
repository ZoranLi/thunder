package com.xunlei.common.device.a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.alipay.sdk.packet.d;
import com.taobao.accs.common.Constants;
import com.umeng.message.MsgConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.base.XLPhoneInfo;
import com.xunlei.common.device.XLDeviceExecption;
import com.xunlei.common.device.XLDeviceGen;
import com.xunlei.common.httpclient.AsyncHttpClient;
import com.xunlei.common.httpclient.BaseHttpClient;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.stat.base.a.a;
import com.xunlei.downloadprovider.app.BrothersApplication;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONObject;

/* compiled from: XLDeviceGenImpl */
public class c extends XLDeviceGen {
    private static final int a = 203;
    private static final String b = "00000000000000000000000000000000";
    private static final String c = "00000000000000000000000000000000";
    private static final String d = "https://mobile-login.xunlei.com/checkdeviceid";
    private String e = c.class.getSimpleName();
    private int f = 0;
    private String g = "";
    private String h = "";
    private Context i = null;
    private int j = 101;
    private String k = "";
    private List<String> l = new ArrayList();
    private BaseHttpClient m = null;
    private boolean n = false;
    private int o = 1;
    private boolean p = false;
    private String q;
    private String r;
    private int s = 0;
    private boolean t = false;

    public void initialize(int i, @NonNull String str, @NonNull String str2, @NonNull Context context) throws XLDeviceExecption {
        if (i > 0 && !TextUtils.isEmpty(str)) {
            if (context != null) {
                if (!this.n) {
                    this.n = true;
                    this.l.add("com.xunlei.xlkdemo.test");
                    this.l.add(BrothersApplication.COM_XUNLEI_DOWNLOADPROVIDER);
                    this.l.add("com.xunlei.tdlive");
                    this.l.add("cn.kuaipan.android");
                    this.l.add("com.xunlei.filemail");
                    this.l.add("com.xunlei.vip.swjsq");
                    this.l.add("com.xunlei.vip.sxjsq");
                    this.l.add("com.xunlei.redcrystalandroid");
                    this.l.add("com.xunlei.cloud");
                    this.l.add("com.xunlei.timealbum");
                    this.f = i;
                    this.g = str;
                    this.h = str2;
                    this.i = context;
                    this.m = new AsyncHttpClient(this.h);
                    this.m.setSSLSocketFactory(SSLSocketFactory.getSocketFactory());
                    e();
                    return;
                }
                return;
            }
        }
        throw new XLDeviceExecption("XLDevice initialize param error!");
    }

    public String getDeviceId() {
        if (this.n) {
            return e();
        }
        return "00000000000000000000000000000000";
    }

    public String getDeviceIdWithFlag() {
        if (!this.n) {
            return "00000000000000000000000000000000#0";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(e());
        stringBuffer.append("#");
        Object obj = 1;
        if (!j()) {
            if (this.s == 1) {
                obj = null;
            }
        }
        if (obj != null) {
            stringBuffer.append("1");
        } else {
            stringBuffer.append("0");
        }
        return stringBuffer.toString();
    }

    public String getDeviceIdSign() {
        if (!this.n) {
            m();
        }
        this.t = true;
        String e = e();
        if (TextUtils.isEmpty(e)) {
            return m();
        }
        return c(e);
    }

    private void a() {
        this.m.setSSLSocketFactory(SSLSocketFactory.getSocketFactory());
    }

    private String b() {
        return this.k;
    }

    private void a(String str) {
        this.k = str;
    }

    private String a(Context context, int i) {
        try {
            Object string = context.getSharedPreferences("xl-acc-device-id", i).getString(d.n, "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            context = context.getSharedPreferences("DeviceInfo", i);
            String string2 = context.getString(d.n, "");
            if (!TextUtils.isEmpty(string2)) {
                String str = this.e;
                StringBuilder stringBuilder = new StringBuilder("getLocalDeviceId from old sdk device = ");
                stringBuilder.append(string2);
                XLLog.v(str, stringBuilder.toString());
                b(string2);
                context = context.edit();
                context.clear();
                context.apply();
                this.o = 2;
                return string2;
            }
            return "";
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    private void b(String str) {
        Editor edit = this.i.getSharedPreferences("xl-acc-device-id", 0).edit();
        edit.putString(d.n, str);
        edit.apply();
    }

    private String c() {
        CharSequence a;
        CharSequence charSequence;
        Exception e;
        String str = "";
        if (this.l.size() <= 0) {
            return str;
        }
        int i = 0;
        while (i < this.l.size()) {
            String str2 = (String) this.l.get(i);
            try {
                a = a(this.i.createPackageContext(str2, 2), f(this.i));
                try {
                    if (TextUtils.isEmpty(a)) {
                        charSequence = a;
                        i++;
                    } else {
                        this.o = 2;
                        str = this.e;
                        StringBuilder stringBuilder = new StringBuilder("get share deviceid from ");
                        stringBuilder.append(str2);
                        XLLog.v(str, stringBuilder.toString());
                        return a;
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    charSequence = a;
                    i++;
                }
            } catch (Exception e3) {
                a = str;
                e = e3;
                e.printStackTrace();
                charSequence = a;
                i++;
            }
        }
        return str;
    }

    private String d() {
        return a.a(a(this.i));
    }

    private String f() {
        return this.k;
    }

    private String g() {
        return c(this.k);
    }

    private void h() {
        StringBuilder stringBuilder;
        if (!j()) {
            boolean z;
            if (this.o == 2) {
                i();
                z = false;
            } else {
                z = true;
            }
            XLLog.v(this.e, "arbitrateDeviceId enter");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("protocolVersion", "203");
                jSONObject.put(DispatchConstants.PLATFORM_VERSION, "10");
                jSONObject.put("appid", String.valueOf(this.f));
                jSONObject.put("clientVersion", this.h);
                StringBuilder stringBuilder2 = new StringBuilder("ANDROID-");
                stringBuilder2.append(this.i.getApplicationInfo().packageName);
                jSONObject.put("appName", stringBuilder2.toString());
                jSONObject.put(Constants.KEY_SDK_VERSION, String.valueOf(q()));
                jSONObject.put("devicesign", c(this.k));
                jSONObject.put("deviceName", d.c());
                String str = "deviceModel";
                Object obj = Build.MODEL;
                if (TextUtils.isEmpty(obj)) {
                    obj = "NONE";
                }
                jSONObject.put(str, obj);
                jSONObject.put("OSVersion", VERSION.RELEASE);
                str = "netWorkType";
                String str2 = "NONE";
                switch (XLPhoneInfo.getNetworkType(this.i)) {
                    case 0:
                        str2 = "NONE";
                        break;
                    case 1:
                        str2 = "WIFI";
                        break;
                    case 2:
                        str2 = "2G";
                        break;
                    case 3:
                        str2 = "3G";
                        break;
                    case 4:
                        str2 = "4G";
                        break;
                    case 5:
                        str2 = "2G";
                        break;
                    default:
                        break;
                }
                this.q = str2;
                jSONObject.put(str, this.q);
                str = "providerName";
                int providersName = XLPhoneInfo.getProvidersName(this.i);
                str2 = "NONE";
                if (providersName != 0) {
                    switch (providersName) {
                        case 2:
                            str2 = "CUCC";
                            break;
                        case 3:
                            str2 = "CTC";
                            break;
                        case 4:
                            str2 = "OTHER";
                            break;
                        case 5:
                            str2 = "NONE";
                            break;
                        default:
                            break;
                    }
                }
                str2 = "CMCC";
                this.r = str2;
                jSONObject.put(str, this.r);
                jSONObject.put("peerID", this.k);
                jSONObject.put("sequenceNo", "20170109001");
                jSONObject.put("isCompressed", "0");
                jSONObject.put("deviceID", this.k);
                jSONObject.put("deviceMac", b(this.i));
                jSONObject.put("deviceImei", c(this.i));
                jSONObject.put("deviceSN", p());
                jSONObject.put("androidID", d(this.i));
                Context context = this.i;
                StringBuilder stringBuilder3 = new StringBuilder();
                DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
                stringBuilder3.append(Build.FINGERPRINT);
                stringBuilder3.append("|");
                stringBuilder3.append(displayMetrics.widthPixels);
                stringBuilder3.append("#");
                stringBuilder3.append(displayMetrics.heightPixels);
                stringBuilder3.append("#");
                stringBuilder3.append(displayMetrics.density);
                stringBuilder3.append("#");
                stringBuilder3.append(displayMetrics.xdpi);
                stringBuilder3.append("#");
                stringBuilder3.append(displayMetrics.ydpi);
                stringBuilder3.append("#");
                jSONObject.put("deviceRom", stringBuilder3.toString());
                jSONObject.put("checkflag", z);
                this.s = 1;
                String str3 = this.e;
                stringBuilder = new StringBuilder("arbitrateDeviceId req body = ");
                stringBuilder.append(jSONObject.toString());
                XLLog.v(str3, stringBuilder.toString());
                this.m.post(this.i, d, null, jSONObject.toString().getBytes(), new BaseHttpClientListener(this) {
                    private /* synthetic */ c a;

                    {
                        this.a = r1;
                    }

                    public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                        this.a.i();
                        i = new String(bArr);
                        headerArr = this.a.e;
                        bArr = new StringBuilder("arbitrateDeviceId resp raw string = ");
                        bArr.append(i);
                        XLLog.v(headerArr, bArr.toString());
                        try {
                            headerArr = new JSONObject(i);
                            i = headerArr.getInt("errorCode");
                            bArr = this.a.e;
                            StringBuilder stringBuilder = new StringBuilder("arbitrateDeviceId resp body = ");
                            stringBuilder.append(headerArr);
                            XLLog.v(bArr, stringBuilder.toString());
                            if (i == 0) {
                                String string = headerArr.getString("deviceID");
                                if (this.a.o == 1 && this.a.t == null && TextUtils.isEmpty(string) == null) {
                                    headerArr = this.a.e;
                                    bArr = new StringBuilder("arbitrateDeviceId accept arbitrate deviceid = ");
                                    bArr.append(string);
                                    XLLog.v(headerArr, bArr.toString());
                                    this.a.b(string);
                                    this.a.k = string;
                                }
                            }
                        } catch (int i2) {
                            i2.printStackTrace();
                        }
                    }

                    public final void onFailure(Throwable th, byte[] bArr) {
                        this.a.i();
                        bArr = this.a.e;
                        StringBuilder stringBuilder = new StringBuilder("arbitrateDeviceId resp error = ");
                        stringBuilder.append(th.getMessage());
                        XLLog.v(bArr, stringBuilder.toString());
                    }
                });
            } catch (Exception e) {
                i();
                e.printStackTrace();
                String str4 = this.e;
                stringBuilder = new StringBuilder("arbitrateDeviceId pack exception = ");
                stringBuilder.append(e.getMessage());
                XLLog.v(str4, stringBuilder.toString());
            }
        }
    }

    private void i() {
        this.s = 2;
        Editor edit = this.i.getSharedPreferences("xl-acc-device-id", 0).edit();
        edit.putString("arbitrate", "arbitrate");
        edit.apply();
    }

    private boolean j() {
        if (TextUtils.isEmpty(this.i.getSharedPreferences("xl-acc-device-id", 0).getString("arbitrate", ""))) {
            return false;
        }
        return true;
    }

    private void k() {
        Editor edit = this.i.getSharedPreferences("xl-acc-device-id", 0).edit();
        edit.putString("arbitrate", "arbitrate");
        edit.apply();
    }

    private void l() {
        this.l.add("com.xunlei.xlkdemo.test");
        this.l.add(BrothersApplication.COM_XUNLEI_DOWNLOADPROVIDER);
        this.l.add("com.xunlei.tdlive");
        this.l.add("cn.kuaipan.android");
        this.l.add("com.xunlei.filemail");
        this.l.add("com.xunlei.vip.swjsq");
        this.l.add("com.xunlei.vip.sxjsq");
        this.l.add("com.xunlei.redcrystalandroid");
        this.l.add("com.xunlei.cloud");
        this.l.add("com.xunlei.timealbum");
    }

    private String m() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("div");
        stringBuffer.append(this.j);
        stringBuffer.append(".0000000000000000000000000000000000000000000000000000000000000000");
        return stringBuffer.toString();
    }

    private String c(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("div");
        stringBuffer.append(this.j);
        stringBuffer.append(".");
        stringBuffer.append(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.i.getApplicationInfo().packageName);
        stringBuilder.append(this.f);
        stringBuilder.append(this.g);
        str = stringBuilder.toString();
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(str);
        stringBuffer.append(a.a(a.a(stringBuffer2.toString())));
        return stringBuffer.toString();
    }

    private boolean n() {
        if (!j() && this.s == 1) {
            return false;
        }
        return true;
    }

    private String d(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.i.getApplicationInfo().packageName);
        stringBuilder.append(this.f);
        stringBuilder.append(this.g);
        str = stringBuilder.toString();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        return a.a(a.a(stringBuffer.toString()));
    }

    private static java.lang.String a(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "android-";
        r0.append(r1);
        r1 = b(r4);	 Catch:{ Exception -> 0x0065 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0065 }
        if (r2 == 0) goto L_0x001a;	 Catch:{ Exception -> 0x0065 }
    L_0x0014:
        r1 = "wifi";	 Catch:{ Exception -> 0x0065 }
    L_0x0016:
        r0.append(r1);	 Catch:{ Exception -> 0x0065 }
        goto L_0x0023;	 Catch:{ Exception -> 0x0065 }
    L_0x001a:
        r2 = ":";	 Catch:{ Exception -> 0x0065 }
        r3 = "";	 Catch:{ Exception -> 0x0065 }
        r1 = r1.replace(r2, r3);	 Catch:{ Exception -> 0x0065 }
        goto L_0x0016;	 Catch:{ Exception -> 0x0065 }
    L_0x0023:
        r1 = "-";	 Catch:{ Exception -> 0x0065 }
        r0.append(r1);	 Catch:{ Exception -> 0x0065 }
        r1 = c(r4);	 Catch:{ Exception -> 0x0065 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0065 }
        if (r2 == 0) goto L_0x0034;	 Catch:{ Exception -> 0x0065 }
    L_0x0032:
        r1 = "imei";	 Catch:{ Exception -> 0x0065 }
    L_0x0034:
        r0.append(r1);	 Catch:{ Exception -> 0x0065 }
        r1 = "-";	 Catch:{ Exception -> 0x0065 }
        r0.append(r1);	 Catch:{ Exception -> 0x0065 }
        r1 = p();	 Catch:{ Exception -> 0x0065 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0065 }
        if (r2 == 0) goto L_0x0048;	 Catch:{ Exception -> 0x0065 }
    L_0x0046:
        r1 = "sn";	 Catch:{ Exception -> 0x0065 }
    L_0x0048:
        r0.append(r1);	 Catch:{ Exception -> 0x0065 }
        r1 = "-";	 Catch:{ Exception -> 0x0065 }
        r0.append(r1);	 Catch:{ Exception -> 0x0065 }
        r4 = d(r4);	 Catch:{ Exception -> 0x0065 }
        r1 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x0065 }
        if (r1 == 0) goto L_0x005c;	 Catch:{ Exception -> 0x0065 }
    L_0x005a:
        r4 = "android_id";	 Catch:{ Exception -> 0x0065 }
    L_0x005c:
        r0.append(r4);	 Catch:{ Exception -> 0x0065 }
        r4 = "-";	 Catch:{ Exception -> 0x0065 }
        r0.append(r4);	 Catch:{ Exception -> 0x0065 }
        goto L_0x006a;
    L_0x0065:
        r4 = "global-phone-identify";
        r0.append(r4);
    L_0x006a:
        r4 = "XLDeviceGenImpl";
        r1 = new java.lang.StringBuilder;
        r2 = "generate raw device id = ";
        r1.<init>(r2);
        r2 = r0.toString();
        r1.append(r2);
        r1 = r1.toString();
        com.xunlei.common.base.XLLog.v(r4, r1);
        r4 = r0.toString();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.device.a.c.a(android.content.Context):java.lang.String");
    }

    private static String o() {
        String str = "";
        String str2 = "02:00:00:00:00:00";
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream()));
            while (str != null) {
                str = lineNumberReader.readLine();
                if (str != null) {
                    str2 = str.trim();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str2 == null || "".equals(str2)) {
            try {
                Reader fileReader = new FileReader("/sys/class/net/eth0/address");
                str = a(fileReader);
                fileReader.close();
                return str.toUpperCase().substring(0, 17);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return str2;
    }

    private static String e(String str) throws Exception {
        Reader fileReader = new FileReader(str);
        str = a(fileReader);
        fileReader.close();
        return str;
    }

    private static String a(Reader reader) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        char[] cArr = new char[4096];
        int read = reader.read(cArr);
        while (read >= 0) {
            stringBuilder.append(cArr, 0, read);
            read = reader.read(cArr);
        }
        return stringBuilder.toString();
    }

    private static String b(Context context) {
        String str = "02:00:00:00:00:00";
        try {
            if (VERSION.SDK_INT < 23) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager == null) {
                    return str;
                }
                context = wifiManager.getConnectionInfo().getMacAddress();
            } else {
                context = o();
            }
            return context;
        } catch (Context context2) {
            context2.printStackTrace();
            return str;
        }
    }

    private static String c(Context context) throws Exception {
        String str = "imei";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (ContextCompat.checkSelfPermission(context, MsgConstant.PERMISSION_READ_PHONE_STATE) == null) {
                return telephonyManager.getDeviceId();
            }
            return str;
        } catch (Context context2) {
            context2.printStackTrace();
            return str;
        }
    }

    private static String p() {
        String str = "sn";
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.serialno"});
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private static String d(Context context) {
        return Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
    }

    private static String e(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        context = context.getApplicationContext().getResources().getDisplayMetrics();
        stringBuilder.append(Build.FINGERPRINT);
        stringBuilder.append("|");
        stringBuilder.append(context.widthPixels);
        stringBuilder.append("#");
        stringBuilder.append(context.heightPixels);
        stringBuilder.append("#");
        stringBuilder.append(context.density);
        stringBuilder.append("#");
        stringBuilder.append(context.xdpi);
        stringBuilder.append("#");
        stringBuilder.append(context.ydpi);
        stringBuilder.append("#");
        return stringBuilder.toString();
    }

    private static int f(Context context) {
        try {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
            StringBuilder stringBuilder = new StringBuilder("Build.VERSION.SDK_INT = ");
            stringBuilder.append(VERSION.SDK_INT);
            stringBuilder.append("# targetSdkVersion = ");
            stringBuilder.append(context);
            XLLog.v("XLDeviceGenImpl", stringBuilder.toString());
            if (VERSION.SDK_INT >= 24 && context >= 24) {
                return 0;
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
        return 1;
    }

    private int q() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.h;
        r1 = ".";
        r0 = r0.lastIndexOf(r1);
        r1 = -1;
        if (r0 == r1) goto L_0x001c;
    L_0x000b:
        r1 = r2.h;
        r0 = r0 + 1;
        r0 = r1.substring(r0);
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ NumberFormatException -> 0x001c }
        r0 = r0.intValue();	 Catch:{ NumberFormatException -> 0x001c }
        goto L_0x001d;
    L_0x001c:
        r0 = 0;
    L_0x001d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.device.a.c.q():int");
    }

    private String t() {
        String str = "NONE";
        switch (XLPhoneInfo.getNetworkType(this.i)) {
            case 0:
                return "NONE";
            case 1:
                return "WIFI";
            case 2:
                return "2G";
            case 3:
                return "3G";
            case 4:
                return "4G";
            case 5:
                return "2G";
            default:
                return str;
        }
    }

    private String u() {
        int providersName = XLPhoneInfo.getProvidersName(this.i);
        String str = "NONE";
        if (providersName == 0) {
            return "CMCC";
        }
        switch (providersName) {
            case 2:
                return "CUCC";
            case 3:
                return "CTC";
            case 4:
                return "OTHER";
            case 5:
                return "NONE";
            default:
                return str;
        }
    }

    private synchronized String e() {
        String str;
        String str2;
        StringBuilder stringBuilder;
        str = this.k;
        if (TextUtils.isEmpty(str)) {
            str = a(this.i, f(this.i));
            if (TextUtils.isEmpty(str)) {
                str = c();
                if (TextUtils.isEmpty(str)) {
                    str = d();
                    b(str);
                    this.k = str;
                    str2 = this.e;
                    stringBuilder = new StringBuilder("genRawDeviceId device = ");
                    stringBuilder.append(str);
                    XLLog.v(str2, stringBuilder.toString());
                } else {
                    str2 = this.e;
                    stringBuilder = new StringBuilder("getShareDeviceId device = ");
                    stringBuilder.append(str);
                    XLLog.v(str2, stringBuilder.toString());
                    b(str);
                    this.k = str;
                }
            } else {
                str2 = this.e;
                stringBuilder = new StringBuilder("getLocalDeviceId device = ");
                stringBuilder.append(str);
                XLLog.v(str2, stringBuilder.toString());
                this.k = str;
            }
        } else {
            str2 = this.e;
            stringBuilder = new StringBuilder("getMemeroyDeviceId device = ");
            stringBuilder.append(str);
            XLLog.v(str2, stringBuilder.toString());
        }
        if (!this.p) {
            this.p = true;
            if (!j()) {
                boolean z;
                if (this.o == 2) {
                    i();
                    z = false;
                } else {
                    z = true;
                }
                XLLog.v(this.e, "arbitrateDeviceId enter");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("protocolVersion", "203");
                    jSONObject.put(DispatchConstants.PLATFORM_VERSION, "10");
                    jSONObject.put("appid", String.valueOf(this.f));
                    jSONObject.put("clientVersion", this.h);
                    StringBuilder stringBuilder2 = new StringBuilder("ANDROID-");
                    stringBuilder2.append(this.i.getApplicationInfo().packageName);
                    jSONObject.put("appName", stringBuilder2.toString());
                    jSONObject.put(Constants.KEY_SDK_VERSION, String.valueOf(q()));
                    jSONObject.put("devicesign", c(this.k));
                    jSONObject.put("deviceName", d.c());
                    String str3 = "deviceModel";
                    Object obj = Build.MODEL;
                    if (TextUtils.isEmpty(obj)) {
                        obj = "NONE";
                    }
                    jSONObject.put(str3, obj);
                    jSONObject.put("OSVersion", VERSION.RELEASE);
                    str3 = "netWorkType";
                    String str4 = "NONE";
                    switch (XLPhoneInfo.getNetworkType(this.i)) {
                        case 0:
                            str4 = "NONE";
                            break;
                        case 1:
                            str4 = "WIFI";
                            break;
                        case 2:
                            str4 = "2G";
                            break;
                        case 3:
                            str4 = "3G";
                            break;
                        case 4:
                            str4 = "4G";
                            break;
                        case 5:
                            str4 = "2G";
                            break;
                        default:
                            break;
                    }
                    this.q = str4;
                    jSONObject.put(str3, this.q);
                    str3 = "providerName";
                    int providersName = XLPhoneInfo.getProvidersName(this.i);
                    str4 = "NONE";
                    if (providersName != 0) {
                        switch (providersName) {
                            case 2:
                                str4 = "CUCC";
                                break;
                            case 3:
                                str4 = "CTC";
                                break;
                            case 4:
                                str4 = "OTHER";
                                break;
                            case 5:
                                str4 = "NONE";
                                break;
                            default:
                                break;
                        }
                    }
                    str4 = "CMCC";
                    this.r = str4;
                    jSONObject.put(str3, this.r);
                    jSONObject.put("peerID", this.k);
                    jSONObject.put("sequenceNo", "20170109001");
                    jSONObject.put("isCompressed", "0");
                    jSONObject.put("deviceID", this.k);
                    jSONObject.put("deviceMac", b(this.i));
                    jSONObject.put("deviceImei", c(this.i));
                    jSONObject.put("deviceSN", p());
                    jSONObject.put("androidID", d(this.i));
                    Context context = this.i;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
                    stringBuilder3.append(Build.FINGERPRINT);
                    stringBuilder3.append("|");
                    stringBuilder3.append(displayMetrics.widthPixels);
                    stringBuilder3.append("#");
                    stringBuilder3.append(displayMetrics.heightPixels);
                    stringBuilder3.append("#");
                    stringBuilder3.append(displayMetrics.density);
                    stringBuilder3.append("#");
                    stringBuilder3.append(displayMetrics.xdpi);
                    stringBuilder3.append("#");
                    stringBuilder3.append(displayMetrics.ydpi);
                    stringBuilder3.append("#");
                    jSONObject.put("deviceRom", stringBuilder3.toString());
                    jSONObject.put("checkflag", z);
                    this.s = 1;
                    str2 = this.e;
                    stringBuilder = new StringBuilder("arbitrateDeviceId req body = ");
                    stringBuilder.append(jSONObject.toString());
                    XLLog.v(str2, stringBuilder.toString());
                    this.m.post(this.i, d, null, jSONObject.toString().getBytes(), /* anonymous class already generated */);
                } catch (Exception e) {
                    i();
                    e.printStackTrace();
                    String str5 = this.e;
                    StringBuilder stringBuilder4 = new StringBuilder("arbitrateDeviceId pack exception = ");
                    stringBuilder4.append(e.getMessage());
                    XLLog.v(str5, stringBuilder4.toString());
                }
            }
        }
        return str;
    }

    private String r() {
        String str = "NONE";
        switch (XLPhoneInfo.getNetworkType(this.i)) {
            case 0:
                str = "NONE";
                break;
            case 1:
                str = "WIFI";
                break;
            case 2:
                str = "2G";
                break;
            case 3:
                str = "3G";
                break;
            case 4:
                str = "4G";
                break;
            case 5:
                str = "2G";
                break;
            default:
                break;
        }
        this.q = str;
        return this.q;
    }

    private String s() {
        int providersName = XLPhoneInfo.getProvidersName(this.i);
        String str = "NONE";
        if (providersName != 0) {
            switch (providersName) {
                case 2:
                    str = "CUCC";
                    break;
                case 3:
                    str = "CTC";
                    break;
                case 4:
                    str = "OTHER";
                    break;
                case 5:
                    str = "NONE";
                    break;
                default:
                    break;
            }
        }
        str = "CMCC";
        this.r = str;
        return this.r;
    }
}
