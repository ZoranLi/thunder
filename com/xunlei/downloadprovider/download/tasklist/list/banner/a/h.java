package com.xunlei.downloadprovider.download.tasklist.list.banner.a;

import com.xunlei.downloadprovider.member.login.LoginHelper;
import java.util.HashSet;

/* compiled from: TendayGiftShowRecorder */
public final class h {
    private static HashSet<String> a = new HashSet();

    public static void a(String str) {
        a.add(d(str));
    }

    public static void b(String str) {
        a.remove(d(str));
    }

    public static boolean c(String str) {
        return a.contains(d(str));
    }

    private static String d(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LoginHelper.a().g.c());
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
