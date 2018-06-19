package anetwork.channel.e;

import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.DefaultFinishEvent;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: Taobao */
final class b implements Future<Object> {
    private i a;
    private boolean b;

    public b(i iVar) {
        this.a = iVar;
    }

    public final boolean cancel(boolean z) {
        if (!this.b) {
            z = this.a;
            if (z.a.e.compareAndSet(false, true)) {
                if (ALog.isPrintLog(2)) {
                    ALog.i("anet.UnifiedRequestTask", "task cancelled", z.a.c, new Object[0]);
                }
                z.a.b();
                z.a.a();
                z.a.d.resultCode = ErrorConstant.ERROR_REQUEST_CANCEL;
                z.a.b.a(new DefaultFinishEvent(ErrorConstant.ERROR_REQUEST_CANCEL, null, z.a.d));
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_REQUEST_CANCEL, null, z.a.a.f, null));
            }
            this.b = true;
        }
        return true;
    }

    public final boolean isCancelled() {
        return this.b;
    }

    public final boolean isDone() {
        throw new RuntimeException("NOT SUPPORT!");
    }

    public final /* synthetic */ Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        throw new RuntimeException("NOT SUPPORT!");
    }

    public final /* synthetic */ Object get() throws InterruptedException, ExecutionException {
        throw new RuntimeException("NOT SUPPORT!");
    }
}
