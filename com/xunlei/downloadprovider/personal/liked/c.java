package com.xunlei.downloadprovider.personal.liked;

import com.xunlei.downloadprovider.member.payment.a.e$d;
import com.xunlei.downloadprovider.publiser.per.model.d;
import java.util.List;

/* compiled from: LikeCinecismFragment */
final class c implements e$d<Boolean, List<d>> {
    final /* synthetic */ int a;
    final /* synthetic */ LikeCinecismFragment b;

    c(LikeCinecismFragment likeCinecismFragment, int i) {
        this.b = likeCinecismFragment;
        this.a = i;
    }

    public final /* synthetic */ void a(Object obj, Object obj2) {
        Boolean bool = (Boolean) obj;
        List list = (List) obj2;
        if (this.b.a != null) {
            if (this.a == 0) {
                this.b.a.a.clear();
            }
            if (list == null) {
                this.b.b(1);
                return;
            }
            if (this.b.b != null && (bool.booleanValue() == null || list.size() < 20)) {
                this.b.g.post(new d(this, list));
            }
            this.b.g.post(new e(this, LikeCinecismFragment.a(this.b, list)));
        }
    }

    public final void a(String str) {
        this.b.b(1);
    }
}
