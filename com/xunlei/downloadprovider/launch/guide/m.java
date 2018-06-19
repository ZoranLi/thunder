package com.xunlei.downloadprovider.launch.guide;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.launch.guide.p.a;
import com.xunlei.downloadprovider.launch.guide.p.b;
import com.xunlei.downloadprovider.loading.c;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: GuidePresenter */
public class m implements a {
    public static final int[] a = new int[]{0, 1};
    public static final int[] b = new int[]{2};
    public static final int[] c = new int[(a.length + b.length)];
    public static final int d = c.length;
    private static final String g = "m";
    b e = null;
    a f = null;
    private q h = null;
    private boolean i = false;
    private d j = null;
    private boolean k;
    private boolean l = false;

    protected static void m() {
    }

    public final int b(int i) {
        return i == 0 ? R.drawable.guide_normal_bg_search : i == 1 ? R.drawable.guide_normal_bg_main_page : -1;
    }

    static {
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
    }

    public m(q qVar, b bVar) {
        this.h = qVar;
        this.e = bVar;
        this.e.a(this);
        LoginHelper.a();
        this.i = l.c();
        this.f = this.h.a();
        if (this.i == null) {
            this.j = new d(this, this.e);
            qVar = this.j;
            qVar.d = new g(qVar);
            LoginHelper.a().a(qVar.d);
            qVar.c = new h(qVar);
            LoginHelper.a().a(qVar.c);
            o.a().a = new j(qVar);
        }
    }

    public final void b() {
        this.e.g();
    }

    public final void c() {
        this.e.h();
    }

    public final void a(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder("onActivityResult requestCode: ");
        stringBuilder.append(i);
        stringBuilder.append(" resultCode: ");
        stringBuilder.append(i2);
        if (!this.k && i == 1000 && i2 != 0) {
            this.k = true;
            f();
        }
    }

    public final void e() {
        r();
        c.d();
    }

    public final void f() {
        if (d.a().e.a()) {
            LoginHelper.a();
            if (l.c()) {
                n();
            }
            return;
        }
        n();
    }

    public final void g() {
        a("start");
        n();
    }

    public final void h() {
        a("try");
        n();
    }

    public final void i() {
        a("wechat_login");
        com.xunlei.downloadprovider.member.register.a.a(Token.WX_TOKEN_PLATFORMID_VALUE, "install_guide");
        if (this.j != null) {
            d dVar = this.j;
            dVar.b.a(new e(dVar));
        }
    }

    public final void j() {
        a("qq_login");
        com.xunlei.downloadprovider.member.register.a.a(Constants.SOURCE_QQ, "install_guide");
        if (this.j != null) {
            d dVar = this.j;
            dVar.b.b(new f(dVar));
        }
    }

    public final void k() {
        a("login");
        if (this.j != null) {
            m mVar = this.j.a;
            if (!mVar.o()) {
                mVar.e.b();
            } else if (mVar.f.a != null) {
                String[] q = mVar.q();
                mVar.e.b(q[0], q[1], q[2], q[3]);
            } else {
                mVar.e.b();
            }
        }
    }

    @NonNull
    public final a l() {
        return this.f;
    }

    public final void a(boolean z) {
        this.f.b = z;
    }

    private void n() {
        if (!o()) {
            this.e.a();
        } else if (this.f.a != null) {
            String[] q = q();
            this.e.a(q[0], q[1], q[2], q[3]);
        } else {
            this.e.a();
        }
    }

    private boolean o() {
        return this.f.a() && this.f.b;
    }

    @NonNull
    private String p() {
        return this.i ? "1" : "0";
    }

    private void a(String str) {
        k.a(p(), str);
    }

    private String[] q() {
        CooperationItem cooperationItem = this.f.a;
        String appDownloadUrl = cooperationItem.getAppDownloadUrl();
        String c = com.xunlei.downloadprovider.cooperation.l.c(cooperationItem.getDisplayLocation());
        String appName = cooperationItem.getAppName();
        if (!(TextUtils.isEmpty(appName) || appName.endsWith(ShareConstants.PATCH_SUFFIX))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(appName);
            stringBuilder.append(ShareConstants.PATCH_SUFFIX);
            appName = stringBuilder.toString();
        }
        String appIconUrl = TextUtils.isEmpty(cooperationItem.getAppSelfIconUrl()) ? cooperationItem.getAppIconUrl() : cooperationItem.getAppSelfIconUrl();
        String a = com.xunlei.downloadprovider.download.report.c.a(c, cooperationItem.getAppPackageName());
        return new String[]{appDownloadUrl, appName, appIconUrl, a};
    }

    private void r() {
        if (this.j != null) {
            d dVar = this.j;
            LoginHelper.a().b(dVar.d);
            LoginHelper.a().b(dVar.c);
            o.a().a = null;
            o.b();
            this.j.b();
            this.j = null;
        }
    }

    public final void a() {
        int i = 0;
        this.e.b(c[0]);
        this.e.a(this.i);
        b bVar = this.e;
        boolean b = f.b(BrothersApplication.getApplicationInstance(), "key_is_new_user");
        if (this.i) {
            b = false;
        } else if (!d.a().e.a()) {
            b = true;
        }
        if (!b) {
            i = 4;
        }
        bVar.a(i);
        k.a(p());
    }

    public final void d() {
        String str = this.f.d ? !this.f.a() ? "1" : "-1000" : !this.f.a() ? "0" : "2";
        String str2 = this.f.d ? !this.f.a() ? "3" : "-1000" : !this.f.a() ? "0" : o() ? "1" : "2";
        k.b(str, str2);
        r();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r7) {
        /*
        r6 = this;
        r0 = b;
        r1 = 0;
        r2 = r0.length;
        r3 = r1;
    L_0x0005:
        r4 = 1;
        if (r3 >= r2) goto L_0x0011;
    L_0x0008:
        r5 = r0[r3];
        if (r5 != r7) goto L_0x000e;
    L_0x000c:
        r0 = r4;
        goto L_0x0012;
    L_0x000e:
        r3 = r3 + 1;
        goto L_0x0005;
    L_0x0011:
        r0 = r1;
    L_0x0012:
        if (r0 == 0) goto L_0x0016;
    L_0x0014:
        r6.l = r4;
    L_0x0016:
        r0 = r6.l;
        if (r0 != 0) goto L_0x002d;
    L_0x001a:
        r0 = d;
        r2 = 2;
        if (r0 < r2) goto L_0x0026;
    L_0x001f:
        r0 = d;
        r0 = r0 - r2;
        if (r7 != r0) goto L_0x002d;
    L_0x0024:
        r1 = r4;
        goto L_0x002d;
    L_0x0026:
        r0 = c;
        r0 = r0[r1];
        if (r7 != r0) goto L_0x002d;
    L_0x002c:
        goto L_0x0024;
    L_0x002d:
        if (r1 == 0) goto L_0x003b;
    L_0x002f:
        r7 = r6.h;
        r0 = r6.f;
        r7.a(r0);
        r7 = r6.e;
        r7.d();
    L_0x003b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.launch.guide.m.a(int):void");
    }
}
