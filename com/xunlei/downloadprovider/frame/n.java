package com.xunlei.downloadprovider.frame;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.download.a;
import com.xunlei.downloadprovider.download.report.DLCenterEntry;

/* compiled from: MainTabActivity */
final class n implements OnClickListener {
    final /* synthetic */ MainTabActivity a;

    n(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        XLToast.setNoNetworkToastForbidden(null);
        a.a(this.a, DLCenterEntry.home.toString());
    }
}
