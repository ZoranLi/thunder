package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.string.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;

public class u {
    private static u a;
    private Context b;
    private List<String> c = new ArrayList();
    private final List<String> d = new ArrayList();
    private final List<String> e = new ArrayList();

    private u(Context context) {
        this.b = context.getApplicationContext();
        if (this.b == null) {
            this.b = context;
        }
        int i = 0;
        SharedPreferences sharedPreferences = this.b.getSharedPreferences("mipush_app_info", 0);
        for (CharSequence charSequence : sharedPreferences.getString("unregistered_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (TextUtils.isEmpty(charSequence)) {
                this.c.add(charSequence);
            }
        }
        for (CharSequence charSequence2 : sharedPreferences.getString("disable_push_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(charSequence2)) {
                this.d.add(charSequence2);
            }
        }
        String[] split = sharedPreferences.getString("disable_push_pkg_names_cache", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        int length = split.length;
        while (i < length) {
            CharSequence charSequence3 = split[i];
            if (!TextUtils.isEmpty(charSequence3)) {
                this.e.add(charSequence3);
            }
            i++;
        }
    }

    public static u a(Context context) {
        if (a == null) {
            a = new u(context);
        }
        return a;
    }

    public boolean a(String str) {
        boolean contains;
        synchronized (this.c) {
            contains = this.c.contains(str);
        }
        return contains;
    }

    public boolean b(String str) {
        boolean contains;
        synchronized (this.d) {
            contains = this.d.contains(str);
        }
        return contains;
    }

    public boolean c(String str) {
        boolean contains;
        synchronized (this.e) {
            contains = this.e.contains(str);
        }
        return contains;
    }

    public void d(String str) {
        synchronized (this.c) {
            if (!this.c.contains(str)) {
                this.c.add(str);
                this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", d.a(this.c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.d) {
            if (!this.d.contains(str)) {
                this.d.add(str);
                this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", d.a(this.d, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.e) {
            if (!this.e.contains(str)) {
                this.e.add(str);
                this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", d.a(this.e, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void g(String str) {
        synchronized (this.c) {
            if (this.c.contains(str)) {
                this.c.remove(str);
                this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", d.a(this.c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void h(String str) {
        synchronized (this.d) {
            if (this.d.contains(str)) {
                this.d.remove(str);
                this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", d.a(this.d, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void i(String str) {
        synchronized (this.e) {
            if (this.e.contains(str)) {
                this.e.remove(str);
                this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", d.a(this.e, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }
}
