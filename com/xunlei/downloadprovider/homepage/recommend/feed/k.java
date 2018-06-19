package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: FeedItemBottomSpHelper */
public final class k {
    public static SharedPreferences a;
    private static k b;

    private k() {
        a = BrothersApplication.getApplicationInstance().getSharedPreferences("feed_movie_click_nice", 0);
    }

    public static k a() {
        if (b == null) {
            b = new k();
        }
        return b;
    }

    public static String a(int i, String str) {
        StringBuilder stringBuilder = new StringBuilder("click_nice_state");
        stringBuilder.append(i);
        stringBuilder.append("_");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static String b(int i, String str) {
        StringBuilder stringBuilder = new StringBuilder("click_nice_count");
        stringBuilder.append(i);
        stringBuilder.append("_");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static boolean c(int i, String str) {
        return (str == null || a == null || a.getBoolean(a(i, str), false) == 0) ? false : true;
    }

    public static int d(int i, String str) {
        if (str == null || a == null) {
            return 0;
        }
        return a.getInt(b(i, str), 0);
    }

    public static void a(String str, long j) {
        if (str != null) {
            if (a != null) {
                Editor edit = a.edit();
                StringBuilder stringBuilder = new StringBuilder("hot_comment_thumb_num_");
                stringBuilder.append(str);
                edit.putLong(stringBuilder.toString(), j);
                edit.apply();
            }
        }
    }
}
