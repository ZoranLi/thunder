package com.xunlei.downloadprovider.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.discovery.kuainiao.h;
import com.xunlei.downloadprovider.discovery.kuainiao.i;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;

/* compiled from: XLAlarmDialogActivity */
final class e implements OnClickListener {
    final /* synthetic */ XLAlarmDialogActivity a;

    e(XLAlarmDialogActivity xLAlarmDialogActivity) {
        this.a = xLAlarmDialogActivity;
    }

    public final void onClick(View view) {
        this.a.finish();
        view = this.a;
        PayFrom payFrom = PayFrom.BIRD_TIP;
        LoginHelper.a();
        if (l.b()) {
            h.a(view, payFrom);
        } else {
            LoginHelper.a().a(view, new i(view, payFrom), LoginFrom.FIND_KUAINIAO, null);
        }
    }
}
