package com.android.volley;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* compiled from: NetworkResponse */
public final class j {
    public final int a;
    public final byte[] b;
    public final Map<String, String> c;
    public final List<g> d;
    public final boolean e;
    public final long f;

    @Deprecated
    private j(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, a((Map) map), false, 0);
    }

    public j(int i, byte[] bArr, boolean z, long j, List<g> list) {
        this(i, bArr, a((List) list), list, z, j);
    }

    @Deprecated
    public j(byte[] bArr, Map<String, String> map, byte b) {
        this(bArr, map);
    }

    private j(int i, byte[] bArr, Map<String, String> map, List<g> list, boolean z, long j) {
        this.a = i;
        this.b = bArr;
        this.c = map;
        if (list == null) {
            this.d = 0;
        } else {
            this.d = Collections.unmodifiableList(list);
        }
        this.e = z;
        this.f = j;
    }

    private static Map<String, String> a(List<g> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        Map<String, String> treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (g gVar : list) {
            treeMap.put(gVar.a, gVar.b);
        }
        return treeMap;
    }

    private static List<g> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        List<g> arrayList = new ArrayList(map.size());
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            arrayList.add(new g((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }
}
