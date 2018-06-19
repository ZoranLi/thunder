package com.xunlei.downloadprovider.personal.user.account;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.login.LoginHelper;

/* compiled from: UserAccountSpHelper */
public final class l {
    private static l b;
    public SharedPreferences a = BrothersApplication.getApplicationInstance().getSharedPreferences("user_account_sp_name", 0);

    private l() {
    }

    public static l a() {
        if (b == null) {
            b = new l();
        }
        return b;
    }

    public static String a(int i, String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append('_');
        stringBuilder.append(i);
        stringBuilder.append('_');
        stringBuilder.append(LoginHelper.a().g.c());
        return stringBuilder.toString();
    }

    public final void b(int i, String str) {
        StringBuilder stringBuilder = new StringBuilder("xlThirdTypeId, thirdNickname = ");
        stringBuilder.append(i);
        stringBuilder.append(", ");
        stringBuilder.append(str);
        if (str != null && this.a != null) {
            Editor edit = this.a.edit();
            edit.putString(a(i, "nickname"), str);
            edit.apply();
        }
    }

    public final String a(int i) {
        if (this.a != null) {
            return this.a.getString(a(i, "head_url"), null);
        }
        return null;
    }

    public final String b(int i) {
        return this.a != null ? this.a.getString(a(i, "nickname"), "") : 0;
    }

    public final void a(int i, int i2) {
        Editor edit = this.a.edit();
        edit.putInt(a(i, "third_bind_state"), i2);
        edit.apply();
    }

    public final int c(int i) {
        return this.a.getInt(a(i, "third_bind_state"), -1);
    }
}
