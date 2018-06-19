package com.xunlei.downloadprovider.publiser.per;

import com.xunlei.downloadprovider.member.payment.a.e$d;
import com.xunlei.downloadprovider.publiser.per.model.PersonalFeedInfo;
import java.util.List;

/* compiled from: HistoryPublishItemFragment */
final class az implements e$d<Integer, List<PersonalFeedInfo>> {
    final /* synthetic */ HistoryPublishItemFragment a;

    az(HistoryPublishItemFragment historyPublishItemFragment) {
        this.a = historyPublishItemFragment;
    }

    public final /* synthetic */ void a(Object obj, Object obj2) {
        Integer num = (Integer) obj;
        List list = (List) obj2;
        this.a.s = false;
        this.a.f.hide();
        this.a.g.setVisibility(8);
        this.a.h.a = false;
        this.a.u = num.intValue();
        if (list != null) {
            if (!list.isEmpty()) {
                if (this.a.t == 0 && this.a.j != null && this.a.k.getItemCount() == 0) {
                    this.a.k.a(this.a.j);
                }
                this.a.k.a(this.a.a(list));
                if (this.a.t == 0 && this.a.m != null) {
                    this.a.m.c(num.intValue());
                }
                this.a.t = ((PersonalFeedInfo) list.get(list.size() - 1)).getCursor();
                return;
            }
        }
        this.a.h.setLoadingMoreEnabled(false);
        if (this.a.k.getItemCount() == null) {
            this.a.c();
            this.a.m.c(num.intValue());
        }
    }

    public final void a(String str) {
        this.a.s = false;
        this.a.h.a();
        if (this.a.t == 0) {
            this.a.f.hide();
            this.a.d();
        }
    }
}
