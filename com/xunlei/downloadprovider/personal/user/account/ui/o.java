package com.xunlei.downloadprovider.personal.user.account.ui;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.member.login.b.k;

/* compiled from: UserAccountInfoActivity */
final class o implements k {
    final /* synthetic */ UserAccountInfoActivity a;

    o(UserAccountInfoActivity userAccountInfoActivity) {
        this.a = userAccountInfoActivity;
    }

    public final void a(boolean z, int i, String str) {
        StringBuilder stringBuilder = new StringBuilder("setOnUserInfoListener errorCode, userdata ==");
        stringBuilder.append(i);
        stringBuilder.append(", ");
        stringBuilder.append(str);
        if (z) {
            this.a.u.b();
            if (str != null) {
                z = true;
                i = str.hashCode();
                if (i != 1203681492) {
                    if (i == 1218470398) {
                        if (str.equals("user_data_birthday") != 0) {
                            z = true;
                        }
                    }
                } else if (str.equals("user_data_sexy") != 0) {
                    z = false;
                }
                switch (z) {
                    case false:
                        UserAccountInfoActivity.p(this.a);
                        return;
                    case true:
                        com.xunlei.downloadprovider.personal.user.account.k.a("success");
                        break;
                    default:
                        break;
                }
                return;
            }
        }
        if (!"set_address_by_ip".equals(str)) {
            XLToast.showToast(this.a.getApplicationContext(), "提交失败");
        }
        UserAccountInfoActivity.a(str);
    }
}
