package com.xunlei.downloadprovider.homepage.cinecism;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.androidutil.ClipboardUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: CinecismDetailActivity */
final class e implements OnClickListener {
    final /* synthetic */ CinecismDetailActivity a;

    e(CinecismDetailActivity cinecismDetailActivity) {
        this.a = cinecismDetailActivity;
    }

    public final void onClick(View view) {
        this.a.i.dismiss();
        view = this.a.i.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        ClipboardUtil.copyToClipboard(this.a, view.getContent(), "text");
        XLToast.showToast(this.a, "复制成功");
        String h = this.a.e;
        String m = this.a.c();
        long id = view.getId();
        LoginHelper.a();
        z.a(h, m, id, l.b(), "copy");
    }
}
