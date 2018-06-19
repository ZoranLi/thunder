package com.tencent.wxop.stat.common;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.a;
import com.tencent.wxop.stat.au;
import java.util.Locale;
import java.util.TimeZone;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

class d {
    String a;
    String b;
    DisplayMetrics c;
    int d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    int l;
    String m;
    String n;
    Context o;
    private String p;
    private String q;
    private String r;
    private String s;

    private d(Context context) {
        this.b = StatConstants.VERSION;
        this.d = VERSION.SDK_INT;
        this.e = Build.MODEL;
        this.f = Build.MANUFACTURER;
        this.g = Locale.getDefault().getLanguage();
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.o = context.getApplicationContext();
        this.c = l.d(this.o);
        this.a = l.h(this.o);
        this.h = StatConfig.getInstallChannel(this.o);
        this.i = l.g(this.o);
        this.j = TimeZone.getDefault().getID();
        this.l = l.m(this.o);
        this.k = l.n(this.o);
        this.m = this.o.getPackageName();
        if (this.d >= 14) {
            this.p = l.t(this.o);
        }
        this.q = l.s(this.o).toString();
        this.r = l.r(this.o);
        this.s = l.d();
        this.n = l.A(this.o);
    }

    void a(JSONObject jSONObject, Thread thread) {
        String str;
        String str2;
        if (thread == null) {
            if (this.c != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.c.widthPixels);
                stringBuilder.append("*");
                stringBuilder.append(this.c.heightPixels);
                jSONObject.put("sr", stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.c.xdpi);
                stringBuilder.append("*");
                stringBuilder.append(this.c.ydpi);
                jSONObject.put("dpi", stringBuilder.toString());
            }
            if (a.a(this.o).e()) {
                JSONObject jSONObject2 = new JSONObject();
                r.a(jSONObject2, "bs", r.d(this.o));
                r.a(jSONObject2, "ss", r.e(this.o));
                if (jSONObject2.length() > 0) {
                    r.a(jSONObject, "wf", jSONObject2.toString());
                }
            }
            JSONArray a = r.a(this.o, 10);
            if (a != null && a.length() > 0) {
                r.a(jSONObject, "wflist", a.toString());
            }
            str = "sen";
            str2 = this.p;
        } else {
            r.a(jSONObject, "thn", thread.getName());
            r.a(jSONObject, "qq", StatConfig.getQQ(this.o));
            r.a(jSONObject, "cui", StatConfig.getCustomUserId(this.o));
            if (l.c(this.r) && this.r.split("/").length == 2) {
                r.a(jSONObject, "fram", this.r.split("/")[0]);
            }
            if (l.c(this.s) && this.s.split("/").length == 2) {
                r.a(jSONObject, "from", this.s.split("/")[0]);
            }
            if (au.a(this.o).b(this.o) != null) {
                jSONObject.put("ui", au.a(this.o).b(this.o).b());
            }
            str = "mid";
            str2 = StatConfig.getLocalMidOnly(this.o);
        }
        r.a(jSONObject, str, str2);
        r.a(jSONObject, "pcn", l.o(this.o));
        r.a(jSONObject, "osn", VERSION.RELEASE);
        r.a(jSONObject, com.alipay.sdk.sys.a.k, this.a);
        r.a(jSONObject, "ch", this.h);
        r.a(jSONObject, "mf", this.f);
        r.a(jSONObject, com.alipay.sdk.sys.a.h, this.b);
        r.a(jSONObject, "osd", Build.DISPLAY);
        r.a(jSONObject, "prod", Build.PRODUCT);
        r.a(jSONObject, "tags", Build.TAGS);
        r.a(jSONObject, AgooConstants.MESSAGE_ID, Build.ID);
        r.a(jSONObject, "fng", Build.FINGERPRINT);
        r.a(jSONObject, "lch", this.n);
        r.a(jSONObject, "ov", Integer.toString(this.d));
        jSONObject.put("os", 1);
        r.a(jSONObject, "op", this.i);
        r.a(jSONObject, "lg", this.g);
        r.a(jSONObject, IXAdRequestInfo.TEST_MODE, this.e);
        r.a(jSONObject, "tz", this.j);
        if (this.l != 0) {
            jSONObject.put("jb", this.l);
        }
        r.a(jSONObject, "sd", this.k);
        r.a(jSONObject, "apn", this.m);
        r.a(jSONObject, "cpu", this.q);
        r.a(jSONObject, "abi", Build.CPU_ABI);
        r.a(jSONObject, "abi2", Build.CPU_ABI2);
        r.a(jSONObject, "ram", this.r);
        r.a(jSONObject, "rom", this.s);
    }
}
