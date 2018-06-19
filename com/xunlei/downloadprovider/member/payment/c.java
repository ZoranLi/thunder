package com.xunlei.downloadprovider.member.payment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.common.new_ptl.pay.param.XLPayParam;
import com.xunlei.downloadprovider.member.payment.external.l;

/* compiled from: PayHelper */
public final class c implements OnClickListener {
    final /* synthetic */ XLPayParam a;
    final /* synthetic */ Activity b;
    final /* synthetic */ XLAlertDialog c;

    public c(XLPayParam xLPayParam, Activity activity, XLAlertDialog xLAlertDialog) {
        this.a = xLPayParam;
        this.b = activity;
        this.c = xLAlertDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.a != null) {
            l.a().a(this.a.getBizNo(), this.a.getNum(), this.a.getReferFrom(), l.a(this.a.getCash(), this.a.getParamExt(), this.a.getAidFrom()), this.b, null);
        }
        this.c.cancel();
    }
}
