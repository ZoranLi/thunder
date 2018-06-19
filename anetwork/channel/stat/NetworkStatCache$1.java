package anetwork.channel.stat;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: Taobao */
class NetworkStatCache$1 extends LinkedHashMap<String, String> {
    final /* synthetic */ b this$0;

    NetworkStatCache$1(b bVar) {
        this.this$0 = bVar;
    }

    protected boolean removeEldestEntry(Entry<String, String> entry) {
        return size() > 100 ? true : null;
    }
}
