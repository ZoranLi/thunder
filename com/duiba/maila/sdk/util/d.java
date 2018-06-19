package com.duiba.maila.sdk.util;

import java.util.Map;
import java.util.TreeMap;

public final class d {
    public String a;
    public String b;
    public Map<String, String> c = new TreeMap();

    public d() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        this.b = stringBuilder.toString();
    }
}
