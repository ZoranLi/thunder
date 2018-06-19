package com.xunlei.downloadprovider.publiser.per;

import com.xunlei.downloadprovider.member.payment.a.e$d;
import com.xunlei.downloadprovider.publiser.per.model.PersonalFeedInfo;
import java.util.List;

/* compiled from: HistoryPublishItemFragment */
final class ar implements e$d<Integer, List<PersonalFeedInfo>> {
    final /* synthetic */ aq a;

    public final void a(String str) {
    }

    ar(aq aqVar) {
        this.a = aqVar;
    }

    public final /* synthetic */ void a(Object obj, Object obj2) {
        Integer num = (Integer) obj;
        List list = (List) obj2;
        this.a.a.u = num.intValue();
        this.a.a.m.c(num.intValue());
        if (num.intValue() > null) {
            this.a.a.f.hide();
            this.a.a.g.setVisibility(8);
        }
        if (this.a.a.t > 0) {
            obj = HistoryPublishItemFragment.a(this.a.a, list, this.a.a.k.a);
        } else {
            obj = this.a.a.a(list);
            this.a.a.t = ((PersonalFeedInfo) list.get(list.size() - 1)).getCursor();
        }
        if (obj != null && obj.isEmpty() == null) {
            if (((bp) obj.get(0)).a != 100) {
                this.a.a.k.a(0, obj);
                return;
            }
            this.a.a.k.a(1, obj);
        }
    }
}
