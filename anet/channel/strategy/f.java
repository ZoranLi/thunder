package anet.channel.strategy;

import java.io.Serializable;
import java.util.Map.Entry;

/* compiled from: Taobao */
class f implements Runnable {
    final /* synthetic */ Entry a;
    final /* synthetic */ LruStrategyMap b;

    f(LruStrategyMap lruStrategyMap, Entry entry) {
        this.b = lruStrategyMap;
        this.a = entry;
    }

    public void run() {
        l.a((Serializable) this.a.getValue(), StrategyInfoHolder.b(((StrategyTable) this.a.getValue()).a));
    }
}
