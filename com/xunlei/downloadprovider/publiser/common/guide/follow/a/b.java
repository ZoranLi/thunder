package com.xunlei.downloadprovider.publiser.common.guide.follow.a;

import java.util.List;

/* compiled from: GuideFollowInfo */
public final class b {
    public List<a> a = null;
    public int b = 0;
    private String c = "";

    public final boolean a() {
        List<a> list = this.a;
        if (list != null && list.size() > 0) {
            for (a aVar : list) {
                if (aVar != null) {
                    List list2 = aVar.a;
                    if (!(list2 == null || list2.isEmpty())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
