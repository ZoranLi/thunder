package com.xunlei.downloadprovider.personal.user.account.ui;

import android.content.SharedPreferences.Editor;
import com.xunlei.downloadprovider.personal.user.account.l;

/* compiled from: UserAccountPortraitSettingActivity */
final class aj implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ UserAccountPortraitSettingActivity e;

    aj(UserAccountPortraitSettingActivity userAccountPortraitSettingActivity, int i, String str, String str2, String str3) {
        this.e = userAccountPortraitSettingActivity;
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public final void run() {
        l a = l.a();
        int i = this.a;
        if (a.a != null) {
            Editor edit = a.a.edit();
            edit.putInt("user_account_third_tag", i);
            edit.apply();
        }
        a = l.a();
        i = this.a;
        String str = this.b;
        String str2 = this.c;
        String str3 = this.d;
        StringBuilder stringBuilder = new StringBuilder("xlThirdTypeId, thirdHeadUrl = ");
        stringBuilder.append(i);
        stringBuilder.append(", ");
        stringBuilder.append(str);
        if (!(str == null || a.a == null)) {
            Editor edit2 = a.a.edit();
            edit2.putString(l.a(i, "head_url"), str);
            edit2.apply();
        }
        a.b(i, str2);
        StringBuilder stringBuilder2 = new StringBuilder("xlThirdTypeId, gender = ");
        stringBuilder2.append(i);
        stringBuilder2.append(", ");
        stringBuilder2.append(str3);
        if (str3 != null && a.a != null) {
            edit = a.a.edit();
            edit.putString(l.a(i, "gender"), str3);
            edit.apply();
        }
    }
}
