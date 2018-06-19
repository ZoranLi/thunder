package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: Taobao */
class BaseConnection$1 extends LinkedHashMap<Integer, Message> {
    final /* synthetic */ b a;

    BaseConnection$1(b bVar) {
        this.a = bVar;
    }

    protected boolean removeEldestEntry(Entry<Integer, Message> entry) {
        return size() > 10 ? true : null;
    }
}
