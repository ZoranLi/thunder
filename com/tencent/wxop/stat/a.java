package com.tencent.wxop.stat;

import android.content.Context;
import android.content.IntentFilter;
import com.alipay.sdk.util.h;
import com.igexin.sdk.PushConsts;
import com.tencent.wxop.stat.common.StatConstants;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.common.e;
import com.tencent.wxop.stat.common.l;
import com.tencent.wxop.stat.common.r;
import com.xiaomi.mipush.sdk.Constants;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public class a {
    private static a g;
    private List<String> a = null;
    private volatile int b = 2;
    private volatile String c = "";
    private volatile HttpHost d = null;
    private e e = null;
    private int f = 0;
    private Context h = null;
    private StatLogger i = null;

    private a(Context context) {
        this.h = context.getApplicationContext();
        this.e = new e();
        i.a(context);
        this.i = l.b();
        l();
        i();
        g();
    }

    public static a a(Context context) {
        if (g == null) {
            synchronized (a.class) {
                if (g == null) {
                    g = new a(context);
                }
            }
        }
        return g;
    }

    private boolean b(String str) {
        return Pattern.compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})").matcher(str).matches();
    }

    private void i() {
        this.a = new ArrayList(10);
        this.a.add("117.135.169.101");
        this.a.add("140.207.54.125");
        this.a.add("180.153.8.53");
        this.a.add("120.198.203.175");
        this.a.add("14.17.43.18");
        this.a.add("163.177.71.186");
        this.a.add("111.30.131.31");
        this.a.add("123.126.121.167");
        this.a.add("123.151.152.111");
        this.a.add("113.142.45.79");
        this.a.add("123.138.162.90");
        this.a.add("103.7.30.94");
    }

    private String j() {
        try {
            String str = StatConstants.MTA_SERVER_HOST;
            if (!b(str)) {
                return InetAddress.getByName(str).getHostAddress();
            }
        } catch (Throwable e) {
            this.i.e(e);
        }
        return "";
    }

    private void k() {
        String j = j();
        if (StatConfig.isDebugEnable()) {
            StatLogger statLogger = this.i;
            StringBuilder stringBuilder = new StringBuilder("remoteIp ip is ");
            stringBuilder.append(j);
            statLogger.i(stringBuilder.toString());
        }
        if (l.c(j)) {
            if (!this.a.contains(j)) {
                String str = (String) this.a.get(this.f);
                if (StatConfig.isDebugEnable()) {
                    StatLogger statLogger2 = this.i;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(j);
                    stringBuilder2.append(" not in ip list, change to:");
                    stringBuilder2.append(str);
                    statLogger2.w(stringBuilder2.toString());
                }
                j = str;
            }
            StringBuilder stringBuilder3 = new StringBuilder("http://");
            stringBuilder3.append(j);
            stringBuilder3.append(":80/mstat/report");
            StatConfig.setStatReportUrl(stringBuilder3.toString());
        }
    }

    private void l() {
        this.b = 0;
        this.d = null;
        this.c = null;
    }

    public HttpHost a() {
        return this.d;
    }

    public void a(String str) {
        if (StatConfig.isDebugEnable()) {
            StatLogger statLogger = this.i;
            StringBuilder stringBuilder = new StringBuilder("updateIpList ");
            stringBuilder.append(str);
            statLogger.i(stringBuilder.toString());
        }
        try {
            if (l.c(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() > 0) {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String string = jSONObject.getString((String) keys.next());
                        if (l.c(string)) {
                            for (String str2 : string.split(h.b)) {
                                String str22;
                                if (l.c(str22)) {
                                    String[] split = str22.split(Constants.COLON_SEPARATOR);
                                    if (split.length > 1) {
                                        str22 = split[0];
                                        if (b(str22) && !this.a.contains(str22)) {
                                            if (StatConfig.isDebugEnable()) {
                                                StatLogger statLogger2 = this.i;
                                                StringBuilder stringBuilder2 = new StringBuilder("add new ip:");
                                                stringBuilder2.append(str22);
                                                statLogger2.i(stringBuilder2.toString());
                                            }
                                            this.a.add(str22);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable e) {
            this.i.e(e);
        }
        this.f = new Random().nextInt(this.a.size());
    }

    public String b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public void d() {
        this.f = (this.f + 1) % this.a.size();
    }

    public boolean e() {
        return this.b == 1;
    }

    public boolean f() {
        return this.b != 0;
    }

    void g() {
        if (r.f(this.h)) {
            if (StatConfig.g) {
                k();
            }
            this.c = l.j(this.h);
            if (StatConfig.isDebugEnable()) {
                StatLogger statLogger = this.i;
                StringBuilder stringBuilder = new StringBuilder("NETWORK name:");
                stringBuilder.append(this.c);
                statLogger.i(stringBuilder.toString());
            }
            if (l.c(this.c)) {
                this.b = "WIFI".equalsIgnoreCase(this.c) ? 1 : 2;
                this.d = l.a(this.h);
            }
            if (StatServiceImpl.a()) {
                StatServiceImpl.d(this.h);
                return;
            }
        }
        if (StatConfig.isDebugEnable()) {
            this.i.i("NETWORK TYPE: network is close.");
        }
        l();
    }

    public void h() {
        this.h.getApplicationContext().registerReceiver(new b(this), new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
    }
}
