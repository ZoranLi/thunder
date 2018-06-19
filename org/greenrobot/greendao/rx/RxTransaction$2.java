package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;

class RxTransaction$2 implements Callable<T> {
    final /* synthetic */ RxTransaction this$0;
    final /* synthetic */ Callable val$callable;

    RxTransaction$2(RxTransaction rxTransaction, Callable callable) {
        this.this$0 = rxTransaction;
        this.val$callable = callable;
    }

    public T call() throws Exception {
        return RxTransaction.access$000(this.this$0).callInTx(this.val$callable);
    }
}
