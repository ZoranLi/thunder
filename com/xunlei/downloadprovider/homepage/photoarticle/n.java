package com.xunlei.downloadprovider.homepage.photoarticle;

import android.text.TextUtils;
import com.xunlei.downloadprovider.e.a.e;
import com.xunlei.downloadprovider.homepage.recommend.a.v;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import java.util.LinkedList;

/* compiled from: PhotoArticleDetailActivity */
final class n implements e {
    final /* synthetic */ PhotoArticleDetailActivity a;

    n(PhotoArticleDetailActivity photoArticleDetailActivity) {
        this.a = photoArticleDetailActivity;
    }

    public final void a(String str, int i) {
        if (!(this.a.c() || TextUtils.equals(str, this.a.g.a) == null)) {
            this.a.g.h = i + 1;
            this.a.g.g = true;
            this.a.d();
            str = this.a.j;
            LoginHelper.a();
            if (l.c() != 0) {
                i = LoginHelper.a();
                v vVar = new v();
                vVar.a = i.g.c();
                vVar.c = i.e();
                vVar.e = true;
                vVar.b = i.g.d();
                vVar.d = i.h();
                if (str.i == 0) {
                    str.i = new LinkedList();
                }
                str.i.add(0, vVar);
            }
            if (str.f != 0) {
                i = str.a.indexOf(str.f);
                if (i >= 0) {
                    str.notifyItemChanged(i);
                }
            }
        }
    }
}
