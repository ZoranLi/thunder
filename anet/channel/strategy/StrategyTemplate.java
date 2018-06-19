package anet.channel.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class StrategyTemplate {
    Map<String, ConnProtocol> templateMap = new ConcurrentHashMap();

    /* compiled from: Taobao */
    static class a {
        static StrategyTemplate a = new StrategyTemplate();

        a() {
        }
    }

    public static StrategyTemplate getInstance() {
        return a.a;
    }

    public void registerConnProtocol(String str, ConnProtocol connProtocol) {
        if (connProtocol != null) {
            this.templateMap.put(str, connProtocol);
        }
    }

    public ConnProtocol getConnProtocol(String str) {
        return (ConnProtocol) this.templateMap.get(str);
    }
}
