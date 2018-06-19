package com.xunlei.downloadprovider.publiser.common.guide.a;

import android.content.Context;
import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.publiser.common.guide.b.g;

/* compiled from: Business */
public abstract class a {
    protected String a = null;
    protected g b = null;

    /* compiled from: Business */
    public interface a {
        void a();
    }

    public void a(int i, @Nullable a aVar) {
    }

    public abstract void a(Context context);

    public void a(@Nullable a aVar) {
    }

    public abstract boolean d();

    public abstract void e();

    public abstract int f();

    public Object g() {
        return null;
    }

    public a() {
        StringBuilder stringBuilder = new StringBuilder("guide.");
        stringBuilder.append(getClass().getSimpleName());
        this.a = stringBuilder.toString();
    }

    public void a(g gVar) {
        this.b = gVar;
    }

    public boolean a() {
        StringBuilder stringBuilder = new StringBuilder("shouldExecute: \nisSwitchOn: ");
        stringBuilder.append(d());
        stringBuilder.append("\n!isGuideTimeout(): ");
        stringBuilder.append(this.b.b ^ true);
        if (!d() || this.b.b) {
            return false;
        }
        return true;
    }

    public boolean b() {
        StringBuilder stringBuilder = new StringBuilder("isNeedRequestCert: \nisSwitchOn: ");
        stringBuilder.append(d());
        stringBuilder.append("\n!isGuideTimeout(): ");
        stringBuilder.append(this.b.b ^ true);
        stringBuilder.append("\nLoginHelper.getInstance().isLogined: ");
        LoginHelper.a();
        stringBuilder.append(l.c());
        if (d() && !this.b.b) {
            LoginHelper.a();
            if (l.c()) {
                return true;
            }
        }
        return false;
    }

    public boolean c() {
        StringBuilder stringBuilder = new StringBuilder("isNeedRequestCert: \nisSwitchOn: ");
        stringBuilder.append(d());
        stringBuilder.append("\n!isGuideTimeout(): ");
        stringBuilder.append(this.b.b ^ true);
        if (!d() || this.b.b) {
            return false;
        }
        return true;
    }
}
