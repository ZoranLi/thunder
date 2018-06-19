package com.taobao.accs.net;

import anet.channel.strategy.StrategyCenter;

/* compiled from: Taobao */
class j implements Runnable {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public void run() {
        StrategyCenter.getInstance().saveData();
    }
}
