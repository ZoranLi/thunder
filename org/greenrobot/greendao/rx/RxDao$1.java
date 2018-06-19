package org.greenrobot.greendao.rx;

import java.util.List;
import java.util.concurrent.Callable;

class RxDao$1 implements Callable<List<T>> {
    final /* synthetic */ RxDao this$0;

    RxDao$1(RxDao rxDao) {
        this.this$0 = rxDao;
    }

    public List<T> call() throws Exception {
        return RxDao.access$000(this.this$0).loadAll();
    }
}
