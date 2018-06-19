package com.xunlei.downloadprovider.publiser.per;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.contentpublish.website.a.b;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.publiser.common.o;

/* compiled from: HistoryPublishItemFragment */
final class am implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ HistoryPublishItemFragment b;

    am(HistoryPublishItemFragment historyPublishItemFragment, String str) {
        this.b = historyPublishItemFragment;
        this.a = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        a.f(this.a, o.a(this.b.e), "web_url");
        if (TextUtils.isEmpty(this.a) != null) {
            XLToast.showToast(this.b.i, "删除失败");
        } else {
            new b().a(this.a, new an(this));
        }
    }
}
