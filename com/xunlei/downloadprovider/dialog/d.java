package com.xunlei.downloadprovider.dialog;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: XLAlarmDialogActivity */
final class d implements OnClickListener {
    final /* synthetic */ XLAlarmDialogActivity a;

    d(XLAlarmDialogActivity xLAlarmDialogActivity) {
        this.a = xLAlarmDialogActivity;
    }

    public final void onClick(View view) {
        this.a.finish();
    }
}
