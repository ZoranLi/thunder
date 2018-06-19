package com.xunlei.downloadprovidershare.b;

import com.xunlei.downloadprovidershare.ShareOperationType;
import java.util.LinkedHashMap;

/* compiled from: SharePlatformItemSet */
public final class c {
    public LinkedHashMap<ShareOperationType, b> a = new LinkedHashMap();

    public final c a(b bVar) {
        this.a.put(bVar.d, bVar);
        return this;
    }

    public final c a(ShareOperationType shareOperationType) {
        this.a.remove(shareOperationType);
        return this;
    }
}
