package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;

class RxDao$2 implements Callable<T> {
    final /* synthetic */ RxDao this$0;
    final /* synthetic */ Object val$key;

    RxDao$2(RxDao rxDao, Object obj) {
        this.this$0 = rxDao;
        this.val$key = obj;
    }

    public T call() throws Exception {
        return RxDao.access$000(this.this$0).load(this.val$key);
    }
}
