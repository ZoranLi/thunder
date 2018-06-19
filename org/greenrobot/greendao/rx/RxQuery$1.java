package org.greenrobot.greendao.rx;

import java.util.List;
import java.util.concurrent.Callable;

class RxQuery$1 implements Callable<List<T>> {
    final /* synthetic */ RxQuery this$0;

    RxQuery$1(RxQuery rxQuery) {
        this.this$0 = rxQuery;
    }

    public List<T> call() throws Exception {
        return RxQuery.access$000(this.this$0).forCurrentThread().list();
    }
}
