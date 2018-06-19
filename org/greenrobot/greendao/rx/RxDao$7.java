package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;

class RxDao$7 implements Callable<T> {
    final /* synthetic */ RxDao this$0;
    final /* synthetic */ Object val$entity;

    RxDao$7(RxDao rxDao, Object obj) {
        this.this$0 = rxDao;
        this.val$entity = obj;
    }

    public T call() throws Exception {
        RxDao.access$000(this.this$0).insertOrReplace(this.val$entity);
        return this.val$entity;
    }
}
