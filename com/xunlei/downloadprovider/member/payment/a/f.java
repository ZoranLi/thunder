package com.xunlei.downloadprovider.member.payment.a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.volley.Request;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.common.net.volley.BaseStringRequest;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.payment.bean.PayConfigurationParam;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;
import com.xunlei.downloadprovider.member.payment.external.a;
import com.xunlei.downloadprovider.member.payment.external.e;
import com.xunlei.downloadprovider.search.b.b;
import java.util.ArrayList;
import java.util.Date;

/* compiled from: PayNetworkHelper */
public class f extends e {
    private static final String d;
    private static f f;
    public Handler a = new Handler(Looper.getMainLooper());
    public Runnable b;
    public b<ArrayList<PayConfigurationParam>> c;
    private ArrayList<PayConfigurationParam> g = null;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BrothersApplication.getApplicationInstance().getFilesDir().getPath());
        stringBuilder.append("/pay_config.ser");
        d = stringBuilder.toString();
    }

    private f() {
    }

    public static f a() {
        if (f == null) {
            synchronized (f.class) {
                if (f == null) {
                    f = new f();
                }
            }
        }
        return f;
    }

    private void c() {
        a("tag:quest_pay_config");
        Request baseStringRequest = new BaseStringRequest("http://act.vip.xunlei.com/payguide/android/1.0.0.js", new g(this), new h(this));
        baseStringRequest.setShouldCache(false);
        baseStringRequest.setTag("tag:quest_pay_config");
        a(baseStringRequest);
    }

    private void a(ArrayList<PayConfigurationParam> arrayList) {
        if (this.b == null) {
            this.b = new i(this, arrayList);
        }
        this.a.post(this.b);
    }

    public final void a(b<ArrayList<PayConfigurationParam>> bVar) {
        this.c = bVar;
        bVar = e().getString("pay_save_time", "");
        Object obj = 1;
        if (!TextUtils.isEmpty(bVar)) {
            if (PayUtil.a(PayUtil.c(bVar), new Date()) != null) {
                obj = null;
            }
        }
        if (obj != null) {
            c();
        } else if (this.g == null) {
            d();
        } else {
            a(this.g);
        }
    }

    private static PreferenceHelper e() {
        return new PreferenceHelper(BrothersApplication.getApplicationInstance(), "pf_configuration_param");
    }

    private void d() {
        try {
            this.g = e.a(a.b("xlvip.payment.config", com.xunlei.downloadprovider.h.e.a(d, "UTF-8").toString()));
            a(this.g);
        } catch (Exception e) {
            e.printStackTrace();
            c();
        }
    }

    static /* synthetic */ void a(String str) {
        try {
            com.xunlei.downloadprovider.h.e.b(d, a.a("xlvip.payment.config", str));
        } catch (String str2) {
            str2.printStackTrace();
        }
    }
}
