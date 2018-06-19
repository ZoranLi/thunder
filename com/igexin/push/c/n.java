package com.igexin.push.c;

import java.util.Comparator;
import java.util.Map.Entry;

class n implements Comparator<Entry<String, j>> {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
    }

    public int a(Entry<String, j> entry, Entry<String, j> entry2) {
        return (int) (((j) entry.getValue()).e() - ((j) entry2.getValue()).e());
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((Entry) obj, (Entry) obj2);
    }
}
