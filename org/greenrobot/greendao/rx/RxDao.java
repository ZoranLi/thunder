package org.greenrobot.greendao.rx;

import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import rx.Observable;
import rx.Scheduler;

@Experimental
public class RxDao<T, K> extends RxBase {
    private final AbstractDao<T, K> dao;

    @Experimental
    public /* bridge */ /* synthetic */ Scheduler getScheduler() {
        return super.getScheduler();
    }

    @Experimental
    public RxDao(AbstractDao<T, K> abstractDao) {
        this(abstractDao, null);
    }

    @Experimental
    public RxDao(AbstractDao<T, K> abstractDao, Scheduler scheduler) {
        super(scheduler);
        this.dao = abstractDao;
    }

    @Experimental
    public Observable<List<T>> loadAll() {
        return wrap(new 1(this));
    }

    @Experimental
    public Observable<T> load(K k) {
        return wrap(new 2(this, k));
    }

    @Experimental
    public Observable<T> refresh(T t) {
        return wrap(new 3(this, t));
    }

    @Experimental
    public Observable<T> insert(T t) {
        return wrap(new 4(this, t));
    }

    @Experimental
    public Observable<Iterable<T>> insertInTx(Iterable<T> iterable) {
        return wrap(new 5(this, iterable));
    }

    @Experimental
    public Observable<Object[]> insertInTx(T... tArr) {
        return wrap(new 6(this, tArr));
    }

    @Experimental
    public Observable<T> insertOrReplace(T t) {
        return wrap(new 7(this, t));
    }

    @Experimental
    public Observable<Iterable<T>> insertOrReplaceInTx(Iterable<T> iterable) {
        return wrap(new 8(this, iterable));
    }

    @Experimental
    public Observable<Object[]> insertOrReplaceInTx(T... tArr) {
        return wrap(new 9(this, tArr));
    }

    @Experimental
    public Observable<T> save(T t) {
        return wrap(new 10(this, t));
    }

    @Experimental
    public Observable<Iterable<T>> saveInTx(Iterable<T> iterable) {
        return wrap(new 11(this, iterable));
    }

    @Experimental
    public Observable<Object[]> saveInTx(T... tArr) {
        return wrap(new 12(this, tArr));
    }

    @Experimental
    public Observable<T> update(T t) {
        return wrap(new 13(this, t));
    }

    @Experimental
    public Observable<Iterable<T>> updateInTx(Iterable<T> iterable) {
        return wrap(new 14(this, iterable));
    }

    @Experimental
    public Observable<Object[]> updateInTx(T... tArr) {
        return wrap(new 15(this, tArr));
    }

    @Experimental
    public Observable<Void> delete(T t) {
        return wrap(new 16(this, t));
    }

    @Experimental
    public Observable<Void> deleteByKey(K k) {
        return wrap(new 17(this, k));
    }

    @Experimental
    public Observable<Void> deleteAll() {
        return wrap(new 18(this));
    }

    @Experimental
    public Observable<Void> deleteInTx(Iterable<T> iterable) {
        return wrap(new 19(this, iterable));
    }

    @Experimental
    public Observable<Void> deleteInTx(T... tArr) {
        return wrap(new 20(this, tArr));
    }

    @Experimental
    public Observable<Void> deleteByKeyInTx(Iterable<K> iterable) {
        return wrap(new 21(this, iterable));
    }

    @Experimental
    public Observable<Void> deleteByKeyInTx(K... kArr) {
        return wrap(new 22(this, kArr));
    }

    @Experimental
    public Observable<Long> count() {
        return wrap(new 23(this));
    }

    @Experimental
    public AbstractDao<T, K> getDao() {
        return this.dao;
    }
}
