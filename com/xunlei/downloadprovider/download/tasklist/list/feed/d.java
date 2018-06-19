package com.xunlei.downloadprovider.download.tasklist.list.feed;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PageHelper */
public class d {
    private static d b = null;
    private static final String d = "d";
    public Map<Integer, Integer> a;
    private HandlerThread c = new HandlerThread("pagesyncthread");

    public d() {
        this.c.start();
        this.a = new HashMap();
    }

    public static d a() {
        if (b == null) {
            b = new d();
        }
        return b;
    }

    public final void b() {
        new Handler(this.c.getLooper()).post(new e(this));
    }

    static /* synthetic */ int a(d dVar, int i) {
        Integer num = (Integer) dVar.a.get(Integer.valueOf(i));
        if (num == null) {
            return null;
        }
        return num.intValue();
    }
}
