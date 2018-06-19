package com.xunlei.downloadprovider.frame;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.common.commonview.XLToast;

/* compiled from: MainTabActivity */
final class m implements OnClickListener {
    final /* synthetic */ MainTabActivity a;

    m(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        XLToast.setNoNetworkToastForbidden(null);
    }
}
