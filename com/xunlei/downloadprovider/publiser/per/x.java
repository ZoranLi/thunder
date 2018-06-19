package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.androidutil.ClipboardUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.publiser.common.o;

/* compiled from: HistoryDynamicItemFragment */
final class x implements OnClickListener {
    final /* synthetic */ HistoryDynamicItemFragment a;

    x(HistoryDynamicItemFragment historyDynamicItemFragment) {
        this.a = historyDynamicItemFragment;
    }

    public final void onClick(View view) {
        this.a.j.dismiss();
        view = this.a.j.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        ClipboardUtil.copyToClipboard(this.a.b, view.getContent(), "text");
        XLToast.showToast(this.a.b, "复制成功");
        a.b("copy", view.getId(), o.a(this.a.h), "active");
    }
}
