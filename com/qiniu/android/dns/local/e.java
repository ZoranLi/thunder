package com.qiniu.android.dns.local;

import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.b;
import java.util.Hashtable;
import java.util.LinkedList;

/* compiled from: Hosts */
public final class e {
    private final Hashtable<String, LinkedList<a>> a = new Hashtable();

    /* compiled from: Hosts */
    public static class a {
        public final String a;
        public final int b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return this.a.equals(aVar.a) && this.b == aVar.b;
                }
            }
            return false;
        }
    }

    public final synchronized String[] a(b bVar, NetworkInfo networkInfo) {
        LinkedList linkedList = (LinkedList) this.a.get(bVar.a);
        if (linkedList != null) {
            if (!linkedList.isEmpty()) {
                if (linkedList.size() > 1) {
                    a aVar = (a) linkedList.get(0);
                    linkedList.remove(0);
                    linkedList.add(aVar);
                }
                LinkedList linkedList2 = new LinkedList();
                LinkedList linkedList3 = new LinkedList();
                bVar = linkedList.iterator();
                while (bVar.hasNext()) {
                    a aVar2 = (a) bVar.next();
                    if (aVar2.b == 0) {
                        linkedList2.add(aVar2);
                    }
                    if (networkInfo.c != 0 && aVar2.b == networkInfo.c) {
                        linkedList3.add(aVar2);
                    }
                }
                if (linkedList3.size() != null) {
                    linkedList2 = linkedList3;
                }
                return a(linkedList2);
            }
        }
        return null;
    }

    private synchronized String[] a(LinkedList<a> linkedList) {
        String[] strArr;
        int size = linkedList.size();
        strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = ((a) linkedList.get(i)).a;
        }
        return strArr;
    }
}
