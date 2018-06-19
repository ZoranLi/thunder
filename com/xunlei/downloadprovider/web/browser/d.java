package com.xunlei.downloadprovider.web.browser;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.web.website.g.b;

/* compiled from: BrowserActivity */
final class d implements OnClickListener {
    final /* synthetic */ BrowserActivity a;

    d(BrowserActivity browserActivity) {
        this.a = browserActivity;
    }

    public final void onClick(View view) {
        if (this.a.m != null) {
            try {
                String g = this.a.m.g();
                if (b.a().a(g) != null) {
                    b.a().a(g, "browser_bottom", "click_star", new ap(this.a.q.a, g));
                    return;
                }
                if (TextUtils.isEmpty(g) == null) {
                    view = TextUtils.isEmpty(this.a.z) != null ? this.a.D : this.a.z;
                    String str = TextUtils.isEmpty(view) ? g : view;
                    view = this.a.q.a;
                    String i = this.a.E;
                    b.a().a(g, str, i, "browser_bottom", new am(view, g, this.a.z, i));
                }
            } catch (View view2) {
                view2.printStackTrace();
            }
        }
    }
}
