package com.xunlei.downloadprovider.homepage.choiceness.a.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: ChoicenessInfo */
public class e$a {
    private static HashSet<Integer> a = new HashSet();
    private static HashMap<String, Integer> b = new HashMap();

    static {
        a.add(Integer.valueOf(5));
        a.add(Integer.valueOf(6));
        a.add(Integer.valueOf(7));
        a.add(Integer.valueOf(8));
        a.add(Integer.valueOf(9));
        a.add(Integer.valueOf(16));
        a.add(Integer.valueOf(17));
        a.add(Integer.valueOf(45));
        a.add(Integer.valueOf(43));
        a.add(Integer.valueOf(44));
        a.add(Integer.valueOf(18));
        a.add(Integer.valueOf(22));
        a.add(Integer.valueOf(28));
        a.add(Integer.valueOf(36));
        a.add(Integer.valueOf(20));
        a.add(Integer.valueOf(47));
        a.add(Integer.valueOf(49));
        b.put("short_video", Integer.valueOf(18));
        b.put("advertisement", Integer.valueOf(-1));
        b.put("live", Integer.valueOf(17));
        b.put("live_pool", Integer.valueOf(45));
        b.put("live_box_left", Integer.valueOf(43));
        b.put("live_box_right", Integer.valueOf(44));
        b.put("recommend_user", Integer.valueOf(28));
        b.put("website", Integer.valueOf(36));
        b.put("website_topic", Integer.valueOf(46));
        b.put("photo_article", Integer.valueOf(20));
        b.put("cinecism", Integer.valueOf(47));
    }

    public static boolean a(int i) {
        return a.contains(Integer.valueOf(i)) != 0;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b.containsKey(str);
    }

    public static int b(String str) {
        return ((Integer) b.get(str)).intValue();
    }
}
