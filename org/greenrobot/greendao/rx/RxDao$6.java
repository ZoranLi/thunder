package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;

class RxDao$6 implements Callable<Object[]> {
    final /* synthetic */ RxDao this$0;
    final /* synthetic */ Object[] val$entities;

    RxDao$6(RxDao rxDao, Object[] objArr) {
        this.this$0 = rxDao;
        this.val$entities = objArr;
    }

    public Object[] call() throws Exception {
        RxDao.access$000(this.this$0).insertInTx(this.val$entities);
        return this.val$entities;
    }
}
