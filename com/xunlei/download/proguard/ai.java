package com.xunlei.download.proguard;

import android.text.TextUtils;
import com.alipay.sdk.util.h;
import java.util.HashSet;

/* compiled from: SetUtils */
public class ai {
    public static HashSet<Long> a(String str) {
        HashSet<Long> hashSet = new HashSet();
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        try {
            for (String parseLong : str.split(h.b)) {
                hashSet.add(Long.valueOf(Long.parseLong(parseLong)));
            }
        } catch (Throwable e) {
            e.printStackTrace();
            an.a(e);
        }
        return hashSet;
    }

    public static String a(HashSet<Long> hashSet) {
        if (hashSet == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        hashSet = hashSet.iterator();
        while (hashSet.hasNext()) {
            stringBuilder.append((Long) hashSet.next());
            stringBuilder.append(h.b);
        }
        return stringBuilder.toString();
    }

    public static String a(long[] jArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (long append : jArr) {
            stringBuilder.append(append);
            stringBuilder.append(h.b);
        }
        return stringBuilder.toString();
    }

    public static String a(String str, long j) {
        HashSet a = a(str);
        a.add(Long.valueOf(j));
        return a(a);
    }

    public static String b(String str, long j) {
        HashSet a = a(str);
        a.remove(Long.valueOf(j));
        return a(a);
    }
}
