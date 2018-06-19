package com.xunlei.downloadprovider.frame;

import com.xunlei.downloadprovider.d.d;

public final class MainTabSpec {
    public static final Tab[] a;

    static {
        if (d.a().o.b()) {
            a = new Tab[]{Tab.THUNDER, Tab.XLLIVE, Tab.FIND, Tab.USER};
            return;
        }
        a = new Tab[]{Tab.THUNDER, Tab.FIND, Tab.USER};
    }
}
