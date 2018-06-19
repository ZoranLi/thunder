package org.greenrobot.greendao.rx;

import java.util.Iterator;
import org.greenrobot.greendao.query.LazyList;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.exceptions.Exceptions;

class RxQuery$3 implements OnSubscribe<T> {
    final /* synthetic */ RxQuery this$0;

    RxQuery$3(RxQuery rxQuery) {
        this.this$0 = rxQuery;
    }

    public void call(Subscriber<? super T> subscriber) {
        LazyList listLazyUncached;
        try {
            listLazyUncached = RxQuery.access$000(this.this$0).forCurrentThread().listLazyUncached();
            Iterator it = listLazyUncached.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(next);
                }
            }
            listLazyUncached.close();
            if (!subscriber.isUnsubscribed()) {
                subscriber.onCompleted();
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            subscriber.onError(th);
        }
    }
}
