package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import rx.Observable;
import rx.Scheduler;

@Experimental
public class RxTransaction extends RxBase {
    private final AbstractDaoSession daoSession;

    @Experimental
    public /* bridge */ /* synthetic */ Scheduler getScheduler() {
        return super.getScheduler();
    }

    public RxTransaction(AbstractDaoSession abstractDaoSession) {
        this.daoSession = abstractDaoSession;
    }

    public RxTransaction(AbstractDaoSession abstractDaoSession, Scheduler scheduler) {
        super(scheduler);
        this.daoSession = abstractDaoSession;
    }

    @Experimental
    public Observable<Void> run(Runnable runnable) {
        return wrap(new 1(this, runnable));
    }

    @Experimental
    public <T> Observable<T> call(Callable<T> callable) {
        return wrap(new 2(this, callable));
    }

    @Experimental
    public AbstractDaoSession getDaoSession() {
        return this.daoSession;
    }
}
