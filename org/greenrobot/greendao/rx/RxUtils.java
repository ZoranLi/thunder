package org.greenrobot.greendao.rx;

import java.util.concurrent.Callable;
import org.greenrobot.greendao.annotation.apihint.Internal;
import rx.Observable;
import rx.functions.Func0;

@Internal
class RxUtils {

    final class AnonymousClass1 implements Func0<Observable<T>> {
        final /* synthetic */ Callable val$callable;

        AnonymousClass1(Callable callable) {
            this.val$callable = callable;
        }

        public final Observable<T> call() {
            try {
                return Observable.just(this.val$callable.call());
            } catch (Throwable e) {
                return Observable.error(e);
            }
        }
    }

    RxUtils() {
    }

    @Internal
    static <T> Observable<T> fromCallable(Callable<T> callable) {
        return Observable.defer(new AnonymousClass1(callable));
    }
}
