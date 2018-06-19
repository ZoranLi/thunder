package com.xiaomi.channel.commonutils.string;

import android.net.Uri;
import android.text.TextUtils;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class b {
    public static String a(String str) {
        try {
            return String.valueOf(a.a(MessageDigest.getInstance("SHA1").digest(str.getBytes("UTF-8"))));
        } catch (Throwable e) {
            com.xiaomi.channel.commonutils.logger.b.a("CloudCoder.hash4SHA1 ", e);
            throw new IllegalStateException("failed to SHA1");
        }
    }

    public static String a(String str, String str2, Map<String, String> map, String str3) {
        if (TextUtils.isEmpty(str3)) {
            throw new InvalidParameterException("security is not nullable");
        }
        List<String> arrayList = new ArrayList();
        if (str != null) {
            arrayList.add(str.toUpperCase());
        }
        if (str2 != null) {
            arrayList.add(Uri.parse(str2).getEncodedPath());
        }
        int i = 1;
        if (!(map == null || map.isEmpty())) {
            for (Entry entry : new TreeMap(map).entrySet()) {
                arrayList.add(String.format("%s=%s", new Object[]{entry.getKey(), entry.getValue()}));
            }
        }
        arrayList.add(str3);
        StringBuilder stringBuilder = new StringBuilder();
        for (String str4 : arrayList) {
            if (i == 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(str4);
            i = 0;
        }
        return a(stringBuilder.toString());
    }
}
