package com.xunlei.downloadprovider.homepage.follow.ui;

import com.xunlei.downloadprovider.homepage.follow.b.b;
import com.xunlei.downloadprovider.homepage.follow.ui.view.ap;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: FollowTabViewDataList */
final class ab {
    int a = -1;
    final List<ap> b = new ArrayList();
    final List<ap> c = new LinkedList();
    final List<ap> d = new ArrayList();
    ap e = new ap(0, this.f);
    b f = new b("我的关注");
    ap g = new ap(7);
    ap h = new ap(8);

    public ab() {
        LoginHelper.a();
        if (!l.c()) {
            this.a = 2;
        }
    }
}
