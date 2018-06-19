package com.alibaba.mtl.appmonitor.model;

import java.util.ArrayList;
import java.util.List;

/* compiled from: MetricRepo */
public final class j {
    private static j b;
    public List<i> a = new ArrayList(3);

    public static j a() {
        if (b == null) {
            b = new j();
        }
        return b;
    }

    private j() {
    }

    public final void a(i iVar) {
        if (!this.a.contains(iVar)) {
            this.a.add(iVar);
        }
    }

    public final i a(String str, String str2) {
        if (!(str == null || str2 == null)) {
            if (this.a != null) {
                int size = this.a.size();
                for (int i = 0; i < size; i++) {
                    i iVar = (i) this.a.get(i);
                    if (iVar != null && iVar.a.equals(str) && iVar.b.equals(str2)) {
                        return iVar;
                    }
                }
                return null;
            }
        }
        return null;
    }
}
