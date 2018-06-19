package com.huawei.hms.support.api.client;

import android.os.Looper;
import java.util.concurrent.TimeUnit;

public abstract class PendingResult<R extends Result> {
    public abstract R await();

    public abstract R await(long j, TimeUnit timeUnit);

    public abstract void setResultCallback(Looper looper, ResultCallback<R> resultCallback);

    public abstract void setResultCallback(ResultCallback<R> resultCallback);
}
