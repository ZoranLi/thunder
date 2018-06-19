package anet.channel.strategy;

/* compiled from: Taobao */
class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ StrategyInfoHolder b;

    e(StrategyInfoHolder strategyInfoHolder, String str) {
        this.b = strategyInfoHolder;
        this.a = str;
    }

    public void run() {
        this.b.a(StrategyInfoHolder.b(this.a), this.a);
    }
}
