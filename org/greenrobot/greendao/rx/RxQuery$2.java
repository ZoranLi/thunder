package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;

class RxQuery$2 implements Callable<T> {
    final /* synthetic */ RxQuery this$0;

    RxQuery$2(RxQuery rxQuery) {
        this.this$0 = rxQuery;
    }

    public T call() throws Exception {
        return RxQuery.access$000(this.this$0).forCurrentThread().unique();
    }
}
