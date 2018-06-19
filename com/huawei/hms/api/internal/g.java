package com.huawei.hms.api.internal;

import java.util.List;

/* compiled from: ProtocolNegotiate */
public class g {
    private static g b = new g();
    private int a = 1;

    public static g a() {
        return b;
    }

    public int a(List<Integer> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                if (list.contains(Integer.valueOf(2))) {
                    this.a = 2;
                } else {
                    this.a = ((Integer) list.get(list.size() - 1)).intValue();
                }
                return this.a;
            }
        }
        this.a = 1;
        return this.a;
    }

    public int b() {
        return this.a;
    }
}
