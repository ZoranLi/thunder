package anet.channel.strategy;

import java.util.Comparator;

/* compiled from: Taobao */
class j implements Comparator<IPConnStrategy> {
    final /* synthetic */ StrategyList a;

    j(StrategyList strategyList) {
        this.a = strategyList;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((IPConnStrategy) obj, (IPConnStrategy) obj2);
    }

    public int a(IPConnStrategy iPConnStrategy, IPConnStrategy iPConnStrategy2) {
        ConnHistoryItem connHistoryItem = (ConnHistoryItem) this.a.b.get(Integer.valueOf(iPConnStrategy2.getUniqueId()));
        int a = ((ConnHistoryItem) this.a.b.get(Integer.valueOf(iPConnStrategy.getUniqueId()))).a();
        int a2 = connHistoryItem.a();
        int i = iPConnStrategy.a + a;
        int i2 = iPConnStrategy2.a + a2;
        if (i != i2) {
            return i - i2;
        }
        if (a != a2) {
            return a - a2;
        }
        return iPConnStrategy.protocol.isHttp - iPConnStrategy2.protocol.isHttp;
    }
}
