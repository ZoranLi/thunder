package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.downloadprovider.web.a;

/* compiled from: HistoryCommentWebsiteViewHolder */
final class p implements OnClickListener {
    final /* synthetic */ m a;

    p(m mVar) {
        this.a = mVar;
    }

    public final void onClick(View view) {
        if (this.a.i == null) {
            XLToast.showToast(view.getContext(), "该链接已删除");
            return;
        }
        a.a();
        a.a(view.getContext(), this.a.i.f, true, BrowserFrom.SHORTVIDEO_USERCENTER_URL);
    }
}
