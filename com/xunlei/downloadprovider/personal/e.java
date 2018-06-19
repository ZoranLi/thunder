package com.xunlei.downloadprovider.personal;

import com.xunlei.downloadprovider.member.payment.bean.PayResultBean;
import com.xunlei.downloadprovider.member.payment.external.i;
import java.util.Observable;

/* compiled from: UserCenterFragment */
final class e extends i {
    final /* synthetic */ UserCenterFragment a;

    e(UserCenterFragment userCenterFragment) {
        this.a = userCenterFragment;
    }

    public final void update(Observable observable, Object obj) {
        if (((PayResultBean) obj).isSuccess() != null) {
            this.a.h.sendEmptyMessage(1003);
        }
    }
}
