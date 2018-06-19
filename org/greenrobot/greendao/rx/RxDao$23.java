package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;

class RxDao$23 implements Callable<Long> {
    final /* synthetic */ RxDao this$0;

    RxDao$23(RxDao rxDao) {
        this.this$0 = rxDao;
    }

    public Long call() throws Exception {
        return Long.valueOf(RxDao.access$000(this.this$0).count());
    }
}
