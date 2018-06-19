package com.xunlei.downloadprovider.member.payment.ui.widget;

import android.content.Context;
import com.xunlei.downloadprovider.R;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

/* compiled from: PayAutoRenewDlg */
final class d extends XLBaseDialog {
    d(Context context) {
        super(context, R.style.ThunderTheme.Dialog);
        setContentView(R.layout.pay_auto_renew_alert_dlg);
        findViewById(R.id.pay_i_know_tv).setOnClickListener(new e(this));
    }
}
