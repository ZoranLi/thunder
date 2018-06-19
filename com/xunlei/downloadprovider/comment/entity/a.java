package com.xunlei.downloadprovider.comment.entity;

import com.xunlei.xllib.b.g;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

/* compiled from: AbsRequest */
abstract class a {
    private String a;
    private String b;

    protected abstract HashMap<String, String> b();

    a() {
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        String stringBuilder2 = stringBuilder.toString();
        this.a = stringBuilder2;
        return stringBuilder2;
    }

    public String a(HashMap<String, String> hashMap) {
        try {
            String str = "ed35b80ab6de3944a96466be405de2fc";
            hashMap = new TreeMap(hashMap).entrySet();
            StringBuilder stringBuilder = new StringBuilder();
            hashMap = hashMap.iterator();
            while (hashMap.hasNext()) {
                Entry entry = (Entry) hashMap.next();
                stringBuilder.append((String) entry.getKey());
                stringBuilder.append("=");
                stringBuilder.append((String) entry.getValue());
            }
            if (str.trim().length() > null) {
                stringBuilder.append(str);
            }
            this.b = g.a(stringBuilder.toString().getBytes());
        } catch (HashMap<String, String> hashMap2) {
            this.b = null;
            hashMap2.printStackTrace();
        }
        return this.b;
    }
}
