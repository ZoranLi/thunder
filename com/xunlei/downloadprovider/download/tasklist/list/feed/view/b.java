package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.ad.common.browser.WebViewToutiaoActivity;

/* compiled from: BaiduNewsViewHolder */
final class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.mAdapter.g != null) {
            this.a.mAdapter.g.k = false;
        }
        view = new StringBuilder();
        view.append(System.currentTimeMillis());
        String stringBuilder = view.toString();
        view = new StringBuilder();
        view.append(System.currentTimeMillis());
        WebViewToutiaoActivity.a(this.a.getContext(), this.a.c.b, this.a.c.c, com.xunlei.downloadprovider.download.tasklist.list.feed.b.c(this.a.getAdapter().a()), "baidu_img", stringBuilder, view.toString(), "", "baidu_img");
        view = new StringBuilder();
        view.append(this.a.mAdapter.b(this.a.d));
        com.xunlei.downloadprovider.download.tasklist.list.feed.b.b(this.a.c.c, this.a.mAdapter.a(), "baidu_img", "", "baidu_img", view.toString());
    }
}
