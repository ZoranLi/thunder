package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;

class RxDao$19 implements Callable<Void> {
    final /* synthetic */ RxDao this$0;
    final /* synthetic */ Iterable val$entities;

    RxDao$19(RxDao rxDao, Iterable iterable) {
        this.this$0 = rxDao;
        this.val$entities = iterable;
    }

    public Void call() throws Exception {
        RxDao.access$000(this.this$0).deleteInTx(this.val$entities);
        return null;
    }
}
