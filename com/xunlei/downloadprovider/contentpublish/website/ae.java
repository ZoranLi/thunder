package com.xunlei.downloadprovider.contentpublish.website;

import android.view.View;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.e$d;
import com.xunlei.downloadprovider.publiser.common.recommendfollow.d;
import java.util.List;

/* compiled from: WebsiteDetailFragment */
final class ae implements e$d<a, List<a>> {
    final /* synthetic */ long a;
    final /* synthetic */ String b;
    final /* synthetic */ View c;
    final /* synthetic */ WebsiteDetailFragment d;

    ae(WebsiteDetailFragment websiteDetailFragment, long j, String str, View view) {
        this.d = websiteDetailFragment;
        this.a = j;
        this.b = str;
        this.c = view;
    }

    public final /* synthetic */ void a(Object obj, Object obj2) {
        List list = (List) obj2;
        if (this.d.mActivity != null) {
            if (this.d.mActivity.isFinishing() == null) {
                this.d.b();
                obj = this.d.al.getKind();
                String str = this.d.i.a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.a);
                String stringBuilder2 = stringBuilder.toString();
                String str2 = (obj == null || obj.contentEquals("per") == null) ? "channel" : "personal";
                String str3 = str2;
                String str4 = this.b;
                this.d.Z;
                com.xunlei.downloadprovider.contentpublish.website.a.a.a(str, stringBuilder2, str3, str4, l.c(), "success", "");
                if (this.c != null) {
                    d.a(this.d.getActivity(), list, this.c, "follow_button");
                }
            }
        }
    }

    public final void a(String str) {
        this.d.a(true);
        String kind = this.d.al.getKind();
        String str2 = this.d.i.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        String stringBuilder2 = stringBuilder.toString();
        kind = (kind == null || !kind.contentEquals("per")) ? "channel" : "personal";
        String str3 = kind;
        String str4 = this.b;
        this.d.Z;
        com.xunlei.downloadprovider.contentpublish.website.a.a.a(str2, stringBuilder2, str3, str4, l.c(), "fail", str);
    }
}
