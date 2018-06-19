package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;

class RxTransaction$1 implements Callable<Void> {
    final /* synthetic */ RxTransaction this$0;
    final /* synthetic */ Runnable val$runnable;

    RxTransaction$1(RxTransaction rxTransaction, Runnable runnable) {
        this.this$0 = rxTransaction;
        this.val$runnable = runnable;
    }

    public Void call() throws Exception {
        RxTransaction.access$000(this.this$0).runInTx(this.val$runnable);
        return null;
    }
}
