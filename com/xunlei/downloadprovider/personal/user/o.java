package com.xunlei.downloadprovider.personal.user;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.xllib.android.b;

/* compiled from: ReportActivity */
final class o implements OnClickListener {
    final /* synthetic */ ReportActivity a;

    o(ReportActivity reportActivity) {
        this.a = reportActivity;
    }

    public final void onClick(View view) {
        if (b.a(this.a) == null) {
            XLToast.showToast(this.a, "无网络连接");
            return;
        }
        view = ReportActivity.e(this.a).a;
        switch (view) {
            case -2:
                ReportActivity.g(this.a);
                break;
            case -1:
                ReportActivity.f(this.a);
                break;
            default:
                ReportActivity.b(this.a, view);
                break;
        }
        ReportActivity.h(this.a);
    }
}
