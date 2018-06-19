package com.xunlei.downloadprovider.member.register.ui;

import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.downloadprovider.member.login.b.h;

/* compiled from: RegisterSuccessActivity */
final class au implements h {
    final /* synthetic */ RegisterSuccessActivity a;

    au(RegisterSuccessActivity registerSuccessActivity) {
        this.a = registerSuccessActivity;
    }

    public final void onRefreshUserInfoCompleted(boolean z, int i) {
        z = new StringBuilder("OnRefreshUserInfoCompleted errorCode=");
        z.append(i);
        z.append(" errorDesc=");
        z.append(XLErrorCode.getErrorDesc(i));
        if (i == 0) {
            this.a.d.sendEmptyMessage(109);
        }
    }
}
