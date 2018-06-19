package com.taobao.accs.data;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: Taobao */
class MessageHandler$1 extends LinkedHashMap<String, String> {
    final /* synthetic */ a a;

    MessageHandler$1(a aVar) {
        this.a = aVar;
    }

    protected boolean removeEldestEntry(Entry<String, String> entry) {
        return size() > 50 ? true : null;
    }
}
