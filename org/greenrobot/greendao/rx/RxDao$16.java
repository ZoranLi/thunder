package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;

class RxDao$16 implements Callable<Void> {
    final /* synthetic */ RxDao this$0;
    final /* synthetic */ Object val$entity;

    RxDao$16(RxDao rxDao, Object obj) {
        this.this$0 = rxDao;
        this.val$entity = obj;
    }

    public Void call() throws Exception {
        RxDao.access$000(this.this$0).delete(this.val$entity);
        return null;
    }
}
