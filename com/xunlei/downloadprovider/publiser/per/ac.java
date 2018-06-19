package com.xunlei.downloadprovider.publiser.per;

import com.xunlei.downloadprovider.member.payment.a.e$d;
import com.xunlei.downloadprovider.publiser.per.model.PersonalFeedInfo;
import java.util.List;

/* compiled from: HistoryDynamicItemFragment */
final class ac implements e$d<Integer, List<PersonalFeedInfo>> {
    final /* synthetic */ HistoryDynamicItemFragment a;

    ac(HistoryDynamicItemFragment historyDynamicItemFragment) {
        this.a = historyDynamicItemFragment;
    }

    public final /* synthetic */ void a(Object obj, Object obj2) {
        Integer num = (Integer) obj;
        List list = (List) obj2;
        this.a.n = false;
        this.a.f.hide();
        this.a.g.setVisibility(4);
        this.a.c.a = false;
        this.a.p = num.intValue();
        if (list != null) {
            if (!list.isEmpty()) {
                this.a.d.a(HistoryDynamicItemFragment.a(list));
                if (this.a.o == 0 && this.a.l != null) {
                    this.a.l.a(num.intValue());
                }
                this.a.o = ((PersonalFeedInfo) list.get(list.size() - 1)).getCursor();
                return;
            }
        }
        this.a.c.setLoadingMoreEnabled(false);
        if (this.a.d.getItemCount() == null) {
            this.a.c();
        }
    }

    public final void a(String str) {
        this.a.n = false;
        this.a.c.a();
        this.a.f.hide();
        this.a.d();
        if (this.a.l != null) {
            this.a.l.a();
        }
    }
}
