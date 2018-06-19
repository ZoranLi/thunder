package com.alibaba.baichuan.android.trade.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class j {

    public static class a implements Serializable {
        public String a;
        public Boolean b;
        public Boolean c;
        public String[] d;
        public String[] e;
    }

    private static void a(String str, String str2, Set set, Map map) {
        Set<String> set2 = (Set) map.get(str2);
        if (set2 != null && !set2.contains(str)) {
            for (String str3 : set2) {
                if (set.add(str3)) {
                    a(str, str3, set, map);
                }
            }
        }
    }

    public static void a(a[] aVarArr) {
        int i;
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        int i2 = 0;
        for (a aVar : aVarArr) {
            if (aVar.d != null) {
                for (Object obj : aVar.d) {
                    Set set = (Set) hashMap.get(obj);
                    if (set == null) {
                        set = new HashSet();
                        hashMap.put(obj, set);
                    }
                    set.add(aVar.a);
                }
            }
            Collection collection = (Set) hashMap.get(aVar.a);
            if (collection == null) {
                collection = new HashSet();
                hashMap.put(aVar.a, collection);
            }
            if (aVar.e != null) {
                Collections.addAll(collection, aVar.e);
            }
            hashMap2.put(aVar.a, aVar);
        }
        Object hashSet = new HashSet();
        for (a aVar2 : aVarArr) {
            a(aVar2.a, aVar2.a, hashSet, hashMap);
            ((Set) hashMap.get(aVar2.a)).addAll(hashSet);
            hashSet.clear();
        }
        Collection hashSet2 = new HashSet();
        Object<String> hashSet3 = new HashSet();
        for (a aVar3 : aVarArr) {
            String str = aVar3.a;
            if (aVar3.b != null && aVar3.b.booleanValue()) {
                hashSet2.add(str);
                hashSet2.addAll((Set) hashMap.get(str));
            } else if (aVar3.c != null && aVar3.c.booleanValue()) {
                hashSet3.add(str);
                for (Entry entry : hashMap.entrySet()) {
                    if (((Set) entry.getValue()).contains(str)) {
                        hashSet3.add(entry.getKey());
                    }
                }
            }
        }
        for (Entry entry2 : hashMap.entrySet()) {
            if (!hashSet2.contains(entry2.getKey())) {
                ((Set) entry2.getValue()).addAll(hashSet2);
            }
        }
        hashSet2 = new HashSet(hashMap.keySet());
        hashSet2.removeAll(hashSet3);
        for (String str2 : hashSet3) {
            ((Set) hashMap.get(str2)).addAll(hashSet2);
        }
        hashSet = new HashSet();
        Set hashSet4 = new HashSet();
        List<String> arrayList = new ArrayList(aVarArr.length);
        while (hashMap.size() > 0) {
            Iterator it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry3 = (Entry) it.next();
                ((Set) entry3.getValue()).removeAll(hashSet4);
                ((Set) entry3.getValue()).retainAll(hashMap.keySet());
                if (((Set) entry3.getValue()).size() == 0) {
                    hashSet.add(entry3.getKey());
                    arrayList.add(entry3.getKey());
                    it.remove();
                }
            }
            if (hashSet.size() == 0) {
                StringBuilder stringBuilder = new StringBuilder("Circular found for ");
                stringBuilder.append(hashMap);
                throw new IllegalStateException(stringBuilder.toString());
            }
            hashSet4.clear();
            hashSet4.addAll(hashSet);
            hashSet.clear();
        }
        for (String str3 : arrayList) {
            a aVar4 = (a) hashMap2.get(str3);
            if (aVar4 != null) {
                i = i2 + 1;
                aVarArr[i2] = aVar4;
                i2 = i;
            }
        }
    }
}
