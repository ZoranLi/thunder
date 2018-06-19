package com.xunlei.downloadprovider.member.payment.c;

import android.text.TextUtils;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ThreadHelper */
public final class c {
    public static ExecutorService a(String str) {
        ThreadFactory threadFactory;
        String str2 = TextUtils.isEmpty(str) ? "xl-pool" : str;
        a aVar = new a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("-%d");
        aVar.a = stringBuilder.toString();
        String str3 = aVar.a;
        Boolean bool = aVar.b;
        Integer num = aVar.c;
        UncaughtExceptionHandler uncaughtExceptionHandler = aVar.d;
        if (aVar.e != null) {
            threadFactory = aVar.e;
        } else {
            threadFactory = Executors.defaultThreadFactory();
        }
        return new ThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1024), new b(threadFactory, str3, str3 != null ? new AtomicLong(0) : null, bool, num, uncaughtExceptionHandler), new AbortPolicy());
    }
}
