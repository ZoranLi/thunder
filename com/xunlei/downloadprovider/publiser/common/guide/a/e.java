package com.xunlei.downloadprovider.publiser.common.guide.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.create.m;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.c.h;
import com.xunlei.downloadprovider.publiser.common.guide.a.a.a;
import com.xunlei.downloadprovider.publiser.common.guide.follow.GuideFollowActivity;
import com.xunlei.downloadprovider.publiser.common.guide.follow.a.b;
import com.xunlei.downloadprovider.publiser.common.guide.follow.a.f;
import com.xunlei.downloadprovider.publiser.common.guide.follow.a.g;
import com.xunlei.downloadprovider.publiser.common.guide.follow.a.j;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: GuideFollowBusiness */
public final class e extends a {
    b c = null;
    private boolean d = false;
    private boolean e = false;

    public final boolean c() {
        return false;
    }

    public final int f() {
        return 1;
    }

    public final boolean a() {
        StringBuilder stringBuilder = new StringBuilder("shouldExecute. isUserNeedGuideByLocal(): ");
        stringBuilder.append(i());
        stringBuilder.append(" \nisUserNeedGuideByServer(followInfo): ");
        stringBuilder.append(a(this.c));
        stringBuilder.append(" \nLoginHelper.getInstance().isLogined: ");
        LoginHelper.a();
        stringBuilder.append(l.c());
        if (super.a()) {
            LoginHelper.a();
            if (l.c() && i() && a(this.c)) {
                new StringBuilder("shouldExecute. !followInfo.isPubsEmpty(): ").append(this.c.a() ^ 1);
                return this.c.a() ^ 1;
            }
        }
        return false;
    }

    public final boolean b() {
        new StringBuilder("isNeedRequestCert isUserNeedGuideByLocal(): ").append(i());
        return super.b() && i();
    }

    public final boolean d() {
        if (!this.d) {
            if (this.b.c()) {
                this.e = d.a().b.c();
            } else {
                this.e = d.a().b.b();
            }
            boolean z = this.e && j();
            this.e = z;
            this.d = true;
        }
        return this.e;
    }

    public final Object g() {
        return this.c;
    }

    static void h() {
        LoginHelper.a();
        if (l.c()) {
            h.a().a("key_guide_follow");
        }
    }

    private static boolean i() {
        LoginHelper.a();
        return l.c() && !h.a().b("key_guide_follow");
    }

    private static boolean j() {
        try {
            String d = d.a().b.d();
            Calendar a = a(d);
            String e = d.a().b.e();
            Calendar a2 = a(e);
            StringBuilder stringBuilder = new StringBuilder("isTimeSwitchOn. begin: ");
            stringBuilder.append(d);
            stringBuilder.append(" end: ");
            stringBuilder.append(e);
            if (a2.before(a)) {
                return true;
            }
            Calendar k = k();
            StringBuilder stringBuilder2 = new StringBuilder("beginTimeInMillis: ");
            stringBuilder2.append(a.getTimeInMillis());
            stringBuilder2.append(" endTimeInMillis: ");
            stringBuilder2.append(a2.getTimeInMillis());
            stringBuilder2.append(" currentTimeInMillis: ");
            stringBuilder2.append(k.getTimeInMillis());
            if (k.getTimeInMillis() < a.getTimeInMillis() || k.getTimeInMillis() > a2.getTimeInMillis()) {
                return false;
            }
            return true;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    @NonNull
    private static Calendar a(String str) {
        str = b(str);
        Calendar k = k();
        k.set(11, str.a);
        k.set(12, str.b);
        k.set(13, str.c);
        return k;
    }

    private static Calendar k() {
        return Calendar.getInstance(TimeZone.getDefault(), Locale.CHINA);
    }

    private static a b(String str) {
        StringBuilder stringBuilder;
        try {
            String[] split = str.split(":|：");
            int length = split.length;
            if (length < 2) {
                stringBuilder = new StringBuilder("timeText error. timeText: ");
                stringBuilder.append(str);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            String str2 = split[length - 2];
            String str3 = split[length - 1];
            length = Integer.valueOf(str2).intValue();
            int intValue = Integer.valueOf(str3).intValue();
            if (length <= 24 && length >= 0 && intValue <= 60) {
                if (intValue >= 0) {
                    return new a(length, intValue);
                }
            }
            stringBuilder = new StringBuilder("timeText error. timeText: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            stringBuilder = new StringBuilder("timeText error. timeText: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public final void a(Context context) {
        GuideFollowActivity.a(context);
        m.a().b();
    }

    public final void a(int i, @Nullable a aVar) {
        XLThreadPool.execute(new g(new f(), new f(this, aVar)));
    }

    public final void e() {
        LoginHelper.a();
        if (l.c()) {
            XLThreadPool.execute(new j(new f(), new g(this)));
        }
        h();
    }

    static boolean a(b bVar) {
        if (bVar != null) {
            if ((bVar.b == 1 ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }
}
