package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;

class RxDao$17 implements Callable<Void> {
    final /* synthetic */ RxDao this$0;
    final /* synthetic */ Object val$key;

    RxDao$17(RxDao rxDao, Object obj) {
        this.this$0 = rxDao;
        this.val$key = obj;
    }

    public Void call() throws Exception {
        RxDao.access$000(this.this$0).deleteByKey(this.val$key);
        return null;
    }
}
