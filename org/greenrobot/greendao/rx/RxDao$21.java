package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;

class RxDao$21 implements Callable<Void> {
    final /* synthetic */ RxDao this$0;
    final /* synthetic */ Iterable val$keys;

    RxDao$21(RxDao rxDao, Iterable iterable) {
        this.this$0 = rxDao;
        this.val$keys = iterable;
    }

    public Void call() throws Exception {
        RxDao.access$000(this.this$0).deleteByKeyInTx(this.val$keys);
        return null;
    }
}
