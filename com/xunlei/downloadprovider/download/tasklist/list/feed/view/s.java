package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.ad.common.browser.WebViewToutiaoActivity;
import com.xunlei.downloadprovider.download.tasklist.list.feed.b;
import com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.a;

/* compiled from: TouTiaoViewHolder */
final class s implements OnClickListener {
    final /* synthetic */ r a;

    s(r rVar) {
        this.a = rVar;
    }

    public final void onClick(View view) {
        boolean z;
        a aVar;
        String str;
        String str2;
        String str3;
        Context context;
        String b;
        String c;
        String stringBuilder;
        String stringBuilder2;
        view = this.a.b;
        int itemViewType = this.a.getItemViewType();
        com.xunlei.downloadprovider.download.tasklist.list.feed.c.a aVar2 = this.a.a;
        if (!(itemViewType == 300 || itemViewType == 301)) {
            if (itemViewType != 302) {
                z = false;
                if (z && aVar2 != null) {
                    aVar = (a) aVar2;
                    str = aVar.a.g;
                    str2 = aVar2.d() ? "ad" : aVar2.e() ? "video" : "news";
                    str3 = str2;
                    context = view.a;
                    b = aVar2.b();
                    c = b.c(view.b);
                    view = new StringBuilder();
                    view.append(System.currentTimeMillis());
                    stringBuilder = view.toString();
                    view = new StringBuilder();
                    view.append(System.currentTimeMillis());
                    stringBuilder2 = view.toString();
                    if (aVar.a == null) {
                        view = aVar.a.c;
                    } else {
                        view = "";
                    }
                    WebViewToutiaoActivity.a(context, str, b, c, str3, stringBuilder, stringBuilder2, view, "toutiao");
                }
                r.a(this.a, this.a.a, this.a.e);
                if (this.a.mAdapter.g != null) {
                    this.a.mAdapter.g.k = false;
                }
            }
        }
        z = true;
        aVar = (a) aVar2;
        str = aVar.a.g;
        if (aVar2.d()) {
        }
        str3 = str2;
        context = view.a;
        b = aVar2.b();
        c = b.c(view.b);
        view = new StringBuilder();
        view.append(System.currentTimeMillis());
        stringBuilder = view.toString();
        view = new StringBuilder();
        view.append(System.currentTimeMillis());
        stringBuilder2 = view.toString();
        if (aVar.a == null) {
            view = "";
        } else {
            view = aVar.a.c;
        }
        WebViewToutiaoActivity.a(context, str, b, c, str3, stringBuilder, stringBuilder2, view, "toutiao");
        r.a(this.a, this.a.a, this.a.e);
        if (this.a.mAdapter.g != null) {
            this.a.mAdapter.g.k = false;
        }
    }
}
