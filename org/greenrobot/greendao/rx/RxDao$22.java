package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;

class RxDao$22 implements Callable<Void> {
    final /* synthetic */ RxDao this$0;
    final /* synthetic */ Object[] val$keys;

    RxDao$22(RxDao rxDao, Object[] objArr) {
        this.this$0 = rxDao;
        this.val$keys = objArr;
    }

    public Void call() throws Exception {
        RxDao.access$000(this.this$0).deleteByKeyInTx(this.val$keys);
        return null;
    }
}
