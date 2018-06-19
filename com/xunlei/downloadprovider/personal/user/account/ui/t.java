package com.xunlei.downloadprovider.personal.user.account.ui;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.i;
import com.xunlei.downloadprovider.personal.user.account.k;
import com.xunlei.downloadprovider.personal.user.account.view.a.a;
import com.xunlei.xllib.android.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: UserAccountInfoActivity */
final class t implements a {
    final /* synthetic */ com.xunlei.downloadprovider.personal.user.account.view.a a;
    final /* synthetic */ UserAccountInfoActivity b;

    t(UserAccountInfoActivity userAccountInfoActivity, com.xunlei.downloadprovider.personal.user.account.view.a aVar) {
        this.b = userAccountInfoActivity;
        this.a = aVar;
    }

    public final void a() {
        this.a.dismiss();
        k.a("cancel");
    }

    public final void a(int i, int i2, int i3) {
        StringBuilder stringBuilder = new StringBuilder(" == ");
        stringBuilder.append(i);
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(i2);
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(i3);
        if (b.a(this.b.getApplicationContext())) {
            StringBuilder stringBuilder2;
            this.a.dismiss();
            if (i2 < 10) {
                stringBuilder2 = new StringBuilder("0");
                stringBuilder2.append(i2);
                i2 = stringBuilder2.toString();
            } else {
                i2 = String.valueOf(i2);
            }
            if (i3 < 10) {
                stringBuilder = new StringBuilder("0");
                stringBuilder.append(i3);
                i3 = stringBuilder.toString();
            } else {
                i3 = String.valueOf(i3);
            }
            LoginHelper g = this.b.u;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(i);
            stringBuilder2.append(i2);
            stringBuilder2.append(i3);
            i = stringBuilder2.toString();
            i2 = "user_data_birthday";
            i3 = g.g;
            i3 = g.q;
            if (!TextUtils.isEmpty(i)) {
                Map hashMap = new HashMap();
                hashMap.put(USERINFOKEY.Birthday, i);
                i.a(i3, hashMap, i2);
            }
            return;
        }
        XLToast.showToast(this.b.getApplicationContext(), "无网络连接");
        this.a.dismiss();
    }
}
