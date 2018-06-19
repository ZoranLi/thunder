package com.xunlei.downloadprovider.dialog;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: XLAlarmDialogActivity */
final class b implements OnClickListener {
    final /* synthetic */ XLAlarmDialogActivity a;

    b(XLAlarmDialogActivity xLAlarmDialogActivity) {
        this.a = xLAlarmDialogActivity;
    }

    public final void onClick(View view) {
        this.a.finish();
    }
}
