package com.alibaba.mtl.appmonitor.c;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ReuseItemPool */
public final class c<T extends b> {
    static AtomicLong c = new AtomicLong(0);
    static AtomicLong d = new AtomicLong(0);
    AtomicLong a = new AtomicLong(0);
    AtomicLong b = new AtomicLong(0);
    ConcurrentLinkedQueue<T> e = new ConcurrentLinkedQueue();
    Set<Integer> f = new HashSet();
    private Integer g = null;
    private final int h = 20;
}
