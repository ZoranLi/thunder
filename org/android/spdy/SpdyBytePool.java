package org.android.spdy;

import java.util.Random;
import java.util.TreeSet;

public class SpdyBytePool {
    private static volatile SpdyBytePool gInstance;
    private static Object lock = new Object();
    private static Random rand = new Random();
    private TreeSet<SpdyByteArray> pool;
    private long reused;
    private SpdyByteArray std;

    private SpdyBytePool() {
        this.pool = null;
        this.std = new SpdyByteArray();
        this.reused = 0;
        this.pool = new TreeSet();
    }

    public static SpdyBytePool getInstance() {
        if (gInstance == null) {
            synchronized (lock) {
                if (gInstance == null) {
                    gInstance = new SpdyBytePool();
                }
            }
        }
        return gInstance;
    }

    SpdyByteArray getSpdyByteArray(int i) {
        SpdyByteArray spdyByteArray;
        synchronized (lock) {
            this.std.length = i;
            spdyByteArray = (SpdyByteArray) this.pool.ceiling(this.std);
            if (spdyByteArray == null) {
                spdyByteArray = new SpdyByteArray(i);
            } else {
                this.pool.remove(spdyByteArray);
                this.reused += (long) i;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("getSpdyByteArray: ");
        stringBuilder.append(spdyByteArray);
        spduLog.Logi("libeasy", stringBuilder.toString());
        stringBuilder = new StringBuilder("reused: ");
        stringBuilder.append(this.reused);
        spduLog.Logi("libeasy", stringBuilder.toString());
        return spdyByteArray;
    }

    void recycle(SpdyByteArray spdyByteArray) {
        synchronized (lock) {
            this.pool.add(spdyByteArray);
            while (this.pool.size() > 100) {
                if (rand.nextBoolean() != null) {
                    this.pool.pollFirst();
                } else {
                    this.pool.pollLast();
                }
            }
        }
    }
}
