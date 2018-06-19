package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;

class RxDao$18 implements Callable<Void> {
    final /* synthetic */ RxDao this$0;

    RxDao$18(RxDao rxDao) {
        this.this$0 = rxDao;
    }

    public Void call() throws Exception {
        RxDao.access$000(this.this$0).deleteAll();
        return null;
    }
}
