package com.xunlei.downloadprovider.personal.user.account.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.i;
import com.xunlei.xllib.android.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: UserAccountEditActivity */
final class h implements OnClickListener {
    final /* synthetic */ UserAccountEditActivity a;

    h(UserAccountEditActivity userAccountEditActivity) {
        this.a = userAccountEditActivity;
    }

    public final void onClick(View view) {
        if (b.a(this.a.getBaseContext()) != null) {
            this.a.c = true;
            LoginHelper d;
            i iVar;
            XLOnUserListener xLOnUserListener;
            Map hashMap;
            if (this.a.d == 1) {
                view = this.a.e.getText();
                new StringBuilder("newNickname==>").append(view);
                d = this.a.i;
                view = view.toString();
                iVar = d.g;
                xLOnUserListener = d.q;
                hashMap = new HashMap();
                hashMap.put(USERINFOKEY.NickName, view.trim());
                i.a(xLOnUserListener, hashMap, null);
                return;
            } else if (this.a.d == 2) {
                view = this.a.f.getText();
                new StringBuilder("personSign==>").append(view);
                d = this.a.i;
                view = view.toString();
                iVar = d.g;
                xLOnUserListener = d.q;
                if (!TextUtils.isEmpty(view)) {
                    hashMap = new HashMap();
                    hashMap.put(USERINFOKEY.PersonalSign, view.trim());
                    i.a(xLOnUserListener, hashMap, null);
                }
                return;
            }
        }
        XLToast.showToast(this.a.getApplicationContext(), "无网络连接");
    }
}
