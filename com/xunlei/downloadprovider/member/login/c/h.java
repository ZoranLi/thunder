package com.xunlei.downloadprovider.member.login.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.member.login.LoginHelper;

/* compiled from: LoginSpHelper */
public final class h {
    private static h b;
    public SharedPreferences a = BrothersApplication.getApplicationInstance().getSharedPreferences("login_sp", 0);

    private h() {
    }

    public static h a() {
        if (b == null) {
            b = new h();
        }
        return b;
    }

    public static String b() {
        StringBuilder stringBuilder = new StringBuilder("key_skip_bind_phone");
        stringBuilder.append(String.valueOf(LoginHelper.a().g.c()));
        return stringBuilder.toString();
    }

    public final void a(boolean z) {
        this.a.edit().putBoolean("key_third_login", z).apply();
    }

    public final void a(String str) {
        this.a.edit().putBoolean(d(str), true).apply();
    }

    public static String c() {
        StringBuilder stringBuilder = new StringBuilder("key_key_chat_new_user_report");
        stringBuilder.append(LoginHelper.a().g.c());
        return stringBuilder.toString();
    }

    public final boolean b(String str) {
        return this.a.getBoolean(d(str), false);
    }

    private static String d(String str) {
        long c = LoginHelper.a().g.c();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(String.valueOf(c));
        return stringBuilder.toString();
    }

    public final void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.a.edit().putString("key_user_account_name_v2", new String(Base64.encode(str.getBytes("utf-8"), 2))).apply();
            } catch (String str2) {
                str2.printStackTrace();
            }
        }
    }

    public final void d() {
        int b = d.a().e.b();
        if (LoginHelper.a().d && b != 2) {
            Editor edit = this.a.edit();
            StringBuilder stringBuilder = new StringBuilder("key_phone_auth_show_count");
            stringBuilder.append(LoginHelper.a().g.c());
            edit.putInt(stringBuilder.toString(), 1).apply();
        }
    }

    public final void a(int i) {
        Editor edit = this.a.edit();
        StringBuilder stringBuilder = new StringBuilder("key_report_not_download_state");
        stringBuilder.append(LoginHelper.a().g.c());
        edit.putInt(stringBuilder.toString(), i).apply();
    }

    public final int e() {
        SharedPreferences sharedPreferences = this.a;
        StringBuilder stringBuilder = new StringBuilder("key_report_not_download_state");
        stringBuilder.append(LoginHelper.a().g.c());
        return sharedPreferences.getInt(stringBuilder.toString(), 0);
    }
}
