package com.xunlei.downloadprovider.web.website;

import com.xunlei.downloadprovider.web.website.view.CollectionUserSyncTipBottomView;

/* compiled from: CollectionCloudSyncHelper */
public class a {
    private static a c;
    public CollectionUserSyncTipBottomView a;
    public boolean b;

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    private a() {
    }

    public final void b() {
        if (this.a != null) {
            this.a.setVisibility(8);
        }
    }

    public final void c() {
        this.a = null;
        c = null;
    }
}
