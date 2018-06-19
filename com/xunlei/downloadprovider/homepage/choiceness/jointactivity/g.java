package com.xunlei.downloadprovider.homepage.choiceness.jointactivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: JointActivityHelper */
public final class g {
    boolean a = false;
    boolean b = false;
    private Context c;
    private XRecyclerView d;
    private SharedPreferences e;
    private JointActivityItemView f;
    private boolean g = false;

    public g(Context context) {
        boolean z = false;
        this.c = context;
        this.a = b().getBoolean("close_flag", false);
        this.g = b().getBoolean("banner_show", false);
        if (b().getInt(SocializeConstants.TENCENT_UID, 0) == 1) {
            z = true;
        }
        this.b = z;
    }

    public final void a(XRecyclerView xRecyclerView) {
        this.d = xRecyclerView;
        a();
    }

    public final SharedPreferences b() {
        if (this.e == null) {
            this.e = this.c.getSharedPreferences("Joint_Activity", 0);
        }
        return this.e;
    }

    private boolean e() {
        return (!d.a().h.i() || this.g || this.a) ? false : true;
    }

    final void c() {
        if (this.d != null && this.f != null) {
            this.d.b(this.f);
        }
    }

    public final void d() {
        if (e()) {
            int i = 0;
            if (b().getInt(SocializeConstants.TENCENT_UID, 0) == 0) {
                i = 1;
            }
            if (i != 0) {
                XLThreadPool.execute(new c(new b(), new i(this)));
            }
        }
    }

    final void a() {
        LoginHelper.a();
        boolean z = l.c() && e() && !TextUtils.equals(new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date()), b().getString("renew_banner_show", "")) && this.b;
        if (z) {
            if (this.d != null) {
                if (this.f == null) {
                    this.f = new JointActivityItemView(this.c);
                    this.f.setIJointActivityItemCallback(new h(this));
                }
                if (!this.d.c(this.f)) {
                    this.d.a(this.f);
                    b().edit().putBoolean("banner_show", true).apply();
                    StatEvent a = f.a("home_collect_caomei_show");
                    a.add("type", "newuser_guide");
                    ThunderReport.reportEvent(a);
                }
            }
            return;
        }
        c();
    }
}
