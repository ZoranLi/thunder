package com.xunlei.downloadprovider.homepage.youliao;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.homepage.a;
import com.xunlei.downloadprovider.homepage.youliao.flow.c;
import com.xunlei.xllib.android.b;
import com.xunlei.xllib.b.d;
import java.util.Collection;
import java.util.List;

/* compiled from: YouliaoVideoFragment */
final class l implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ boolean b;
    final /* synthetic */ YouliaoVideoFragment c;

    l(YouliaoVideoFragment youliaoVideoFragment, List list, boolean z) {
        this.c = youliaoVideoFragment;
        this.a = list;
        this.b = z;
    }

    public final void run() {
        if (this.c.i != null) {
            a j = this.c.i;
            d.a(this.a);
            j.a = false;
        }
        if (this.c.d != null) {
            this.c.d.setEmptyView(this.c.h);
            this.c.d.b();
        }
        if (this.c.e != null) {
            if (this.b) {
                c a = this.c.e;
                Collection collection = this.a;
                if (!d.a(collection)) {
                    a.a.addAll(collection);
                    a.f = System.currentTimeMillis();
                    a.notifyDataSetChanged();
                }
            } else if (!d.a(this.a)) {
                YouliaoVideoFragment.a(this.c, this.a.size());
                this.c.e.a(this.a);
                if (!(this.c.l || this.c.c == null)) {
                    this.c.d.a(this.c.c);
                    this.c.l = true;
                }
            }
        }
        boolean a2 = b.a(BrothersApplication.getApplicationInstance());
        if (this.c.isResumed() && this.c.mIsUserVisible) {
            if (!a2) {
                XLToast.showNoNetworkToast(this.c.getActivity());
            } else if (d.a(this.a)) {
                XLToast.showToast(this.c.getActivity(), "网络异常");
            }
        }
    }
}
