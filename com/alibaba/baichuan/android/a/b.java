package com.alibaba.baichuan.android.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class b {
    private static List a = Collections.synchronizedList(new ArrayList());

    public interface a {
        boolean a();
    }

    public static List a() {
        return a;
    }
}
