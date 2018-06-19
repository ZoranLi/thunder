package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import com.xunlei.downloadprovider.homepage.follow.aa;
import java.util.List;

/* compiled from: ChoicenessRecommendUserView */
final class aj implements aa {
    final /* synthetic */ b a;

    aj(b bVar) {
        this.a = bVar;
    }

    public final void a(boolean z, List<String> list) {
        if (this.a.e != null) {
            if (this.a.e.c != null) {
                String uid = this.a.e.c.getUid();
                if (!(list == null || list.isEmpty() || list.contains(uid) == null)) {
                    if (z) {
                        this.a.a((boolean) null);
                        return;
                    }
                    this.a.a(true);
                }
            }
        }
    }
}
