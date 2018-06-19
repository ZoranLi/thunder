package com.xunlei.downloadprovider.publiser.per.model;

import com.xunlei.downloadprovider.homepage.cinecism.data.CinecismInfo;

/* compiled from: PublishCinecismInfo */
public final class f extends g {
    public CinecismInfo a;

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof f)) {
            return false;
        }
        return this.a.a.equals(((f) obj).a.a);
    }
}
