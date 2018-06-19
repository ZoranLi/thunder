package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;

class RxDao$20 implements Callable<Void> {
    final /* synthetic */ RxDao this$0;
    final /* synthetic */ Object[] val$entities;

    RxDao$20(RxDao rxDao, Object[] objArr) {
        this.this$0 = rxDao;
        this.val$entities = objArr;
    }

    public Void call() throws Exception {
        RxDao.access$000(this.this$0).deleteInTx(this.val$entities);
        return null;
    }
}
