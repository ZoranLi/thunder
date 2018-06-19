package anet.channel.strategy;

/* compiled from: Taobao */
public class StrategyCenter {
    private static volatile IStrategyInstance instance;

    public static IStrategyInstance getInstance() {
        if (instance == null) {
            synchronized (StrategyCenter.class) {
                if (instance == null) {
                    instance = new g();
                }
            }
        }
        return instance;
    }

    public static void setInstance(IStrategyInstance iStrategyInstance) {
        instance = iStrategyInstance;
    }

    private StrategyCenter() {
    }
}
