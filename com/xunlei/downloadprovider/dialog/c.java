package com.xunlei.downloadprovider.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.a;

/* compiled from: XLAlarmDialogActivity */
final class c implements OnClickListener {
    final /* synthetic */ XLAlarmDialogActivity a;

    c(XLAlarmDialogActivity xLAlarmDialogActivity) {
        this.a = xLAlarmDialogActivity;
    }

    public final void onClick(View view) {
        this.a.finish();
        a.a(this.a, XLAlarmDialogActivity.a(this.a), "alarmDialog");
    }
}
