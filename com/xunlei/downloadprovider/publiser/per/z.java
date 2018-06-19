package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.publiser.common.o;
import com.xunlei.xllib.android.b;

/* compiled from: HistoryDynamicItemFragment */
final class z implements OnClickListener {
    final /* synthetic */ HistoryDynamicItemFragment a;

    z(HistoryDynamicItemFragment historyDynamicItemFragment) {
        this.a = historyDynamicItemFragment;
    }

    public final void onClick(View view) {
        this.a.j.dismiss();
        if (b.a(this.a.b) == null) {
            XLToast.showToast(this.a.b, "无网络连接");
            return;
        }
        CommentInfo commentInfo = this.a.j.a;
        if (commentInfo == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        this.a.a(commentInfo);
        this.a.k.a(commentInfo.getId());
        a.b("delete", commentInfo.getId(), o.a(this.a.h), "active");
    }
}
