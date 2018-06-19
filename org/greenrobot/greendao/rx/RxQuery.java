package org.greenrobot.greendao.rx;

import java.util.List;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.query.Query;
import rx.Observable;
import rx.Scheduler;

@Experimental
public class RxQuery<T> extends RxBase {
    private final Query<T> query;

    @Experimental
    public /* bridge */ /* synthetic */ Scheduler getScheduler() {
        return super.getScheduler();
    }

    public RxQuery(Query<T> query) {
        this.query = query;
    }

    public RxQuery(Query<T> query, Scheduler scheduler) {
        super(scheduler);
        this.query = query;
    }

    @Experimental
    public Observable<List<T>> list() {
        return wrap(new 1(this));
    }

    @Experimental
    public Observable<T> unique() {
        return wrap(new 2(this));
    }

    public Observable<T> oneByOne() {
        return wrap(Observable.create(new 3(this)));
    }
}
