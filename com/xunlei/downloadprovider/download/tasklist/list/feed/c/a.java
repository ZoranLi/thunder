package com.xunlei.downloadprovider.download.tasklist.list.feed.c;

import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import java.util.HashSet;

/* compiled from: TaskListFeedInfo */
public class a extends e {
    private static HashSet<Integer> a = null;
    private static int b = -1;

    static {
        HashSet hashSet = new HashSet();
        a = hashSet;
        hashSet.add(Integer.valueOf(37));
        a.add(Integer.valueOf(38));
        a.add(Integer.valueOf(16));
        a.add(Integer.valueOf(18));
        a.add(Integer.valueOf(36));
        a.add(Integer.valueOf(39));
        a.add(Integer.valueOf(7));
        a.add(Integer.valueOf(20));
        a.add(Integer.valueOf(41));
        a.add(Integer.valueOf(42));
    }

    public static boolean a(int i) {
        return a.contains(Integer.valueOf(i)) != 0;
    }

    public static int a() {
        int i = b + 1;
        b = i;
        if (i >= Integer.MAX_VALUE) {
            b = 0;
        }
        return b;
    }
}
