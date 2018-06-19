package com.alibaba.wireless.security.framework.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.alibaba.wireless.security.framework.b;
import com.alibaba.wireless.security.framework.b.c;

public class d {
    protected b a;
    private String b;
    private String c;
    private c d;
    private b e;
    private AssetManager f;
    private Resources g;
    private Theme h;
    private ActivityInfo i;
    private Activity j;

    public d(Activity activity) {
        this.j = activity;
    }

    private void f() {
        PackageInfo packageInfo = this.d.f;
        if (packageInfo.activities != null && packageInfo.activities.length > 0) {
            int i = 0;
            if (this.b == null) {
                this.b = packageInfo.activities[0].name;
            }
            int i2 = packageInfo.applicationInfo.theme;
            ActivityInfo[] activityInfoArr = packageInfo.activities;
            int length = activityInfoArr.length;
            while (i < length) {
                ActivityInfo activityInfo = activityInfoArr[i];
                if (activityInfo.name.equals(this.b)) {
                    this.i = activityInfo;
                    if (this.i.theme == 0) {
                        if (i2 != 0) {
                            this.i.theme = i2;
                        } else {
                            int i3;
                            if (VERSION.SDK_INT >= 14) {
                                activityInfo = this.i;
                                i3 = 16974120;
                            } else {
                                activityInfo = this.i;
                                i3 = 16973829;
                            }
                            activityInfo.theme = i3;
                        }
                    }
                }
                i++;
            }
        }
    }

    private void g() {
        new StringBuilder("handleActivityInfo, theme=").append(this.i.theme);
        if (this.i.theme > 0) {
            this.j.setTheme(this.i.theme);
        }
        Theme theme = this.j.getTheme();
        this.h = this.g.newTheme();
        this.h.setTo(theme);
        try {
            this.h.applyStyle(this.i.theme, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @TargetApi(14)
    protected void a() {
        try {
            Object newInstance = b().loadClass(this.b).getConstructor(new Class[0]).newInstance(new Object[0]);
            this.a = (b) newInstance;
            ((a) this.j).attach(this.a, this.e);
            new StringBuilder("instance = ").append(newInstance);
            this.a.attach(this.j, this.d);
            Bundle bundle = new Bundle();
            bundle.putInt("extra.from", 1);
            this.a.onCreate(bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(Intent intent) {
        intent.setExtrasClassLoader(c.a);
        this.c = intent.getStringExtra("extra.package");
        this.b = intent.getStringExtra("extra.class");
        StringBuilder stringBuilder = new StringBuilder("mClass=");
        stringBuilder.append(this.b);
        stringBuilder.append(" mPackageName=");
        stringBuilder.append(this.c);
        this.e = b.a(this.j);
        this.d = this.e.b(this.c);
        this.f = this.d.d;
        this.g = this.d.e;
        f();
        g();
        a();
    }

    public ClassLoader b() {
        return this.d.c;
    }

    public AssetManager c() {
        return this.f;
    }

    public Resources d() {
        return this.g;
    }

    public Theme e() {
        return this.h;
    }
}
