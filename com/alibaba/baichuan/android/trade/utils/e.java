package com.alibaba.baichuan.android.trade.utils;

import com.alibaba.baichuan.android.trade.AlibcContext;
import java.util.concurrent.atomic.AtomicInteger;

public final class e {
    private static final AtomicInteger a = new AtomicInteger(59994);

    public static int a(String str) {
        int andIncrement = a.getAndIncrement();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(andIncrement);
        stringBuilder.append(" is allocated for onActivityResult request code for ");
        stringBuilder.append(str);
        AlibcContext.b();
        return andIncrement;
    }
}
