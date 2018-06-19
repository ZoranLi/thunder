package com.xunlei.downloadprovider.homepage.choiceness;

import android.content.Context;
import android.text.TextUtils;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.homepage.choiceness.jointactivity.g;
import com.xunlei.downloadprovider.homepage.choiceness.ui.items.ChoicenessVipRenewalRemindItemView;
import com.xunlei.downloadprovider.member.b.c;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: ChoicenessVipRenewalHelper */
public final class k {
    Context a;
    public XRecyclerView b;
    public boolean c = false;
    com.xunlei.downloadprovider.member.b.a d;
    ChoicenessVipRenewalRemindItemView e;
    boolean f;
    public a g;
    com.xunlei.downloadprovider.member.b.a.a h = new l(this);
    public g i;
    private PreferenceHelper j;

    /* compiled from: ChoicenessVipRenewalHelper */
    public interface a {
        void a();

        void b();
    }

    public k(Context context) {
        this.a = context;
    }

    public final PreferenceHelper a() {
        if (this.j == null) {
            this.j = new PreferenceHelper(this.a, "vip_renew_homePage");
        }
        return this.j;
    }

    public final void c() {
        if (this.b != null) {
            this.b.b(this.e);
            if (!(this.g == null || this.f)) {
                this.g.b();
            }
        }
    }

    public final boolean d() {
        return (this.e == null || this.b == null) ? false : this.b.c(this.e);
    }

    public final void b() {
        if (d.a().h.e()) {
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            PreferenceHelper a = a();
            StringBuilder stringBuilder = new StringBuilder("dateAndUser");
            stringBuilder.append(LoginHelper.a().g.c());
            CharSequence string = a.getString(stringBuilder.toString(), "");
            stringBuilder = new StringBuilder();
            stringBuilder.append(format);
            stringBuilder.append(LoginHelper.a().g.c());
            if (!TextUtils.equals(stringBuilder.toString(), string)) {
                this.c = true;
                if (this.c) {
                    LoginHelper.a();
                    if (l.c()) {
                        this.d = c.a(this.h);
                        this.d.c("13");
                    }
                }
            }
        }
        this.c = false;
        if (this.c) {
            LoginHelper.a();
            if (l.c()) {
                this.d = c.a(this.h);
                this.d.c("13");
            }
        }
    }
}
