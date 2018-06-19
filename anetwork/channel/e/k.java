package anetwork.channel.e;

import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.StatObject;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.DefaultFinishEvent;

/* compiled from: Taobao */
final class k implements Runnable {
    final /* synthetic */ i a;

    k(i iVar) {
        this.a = iVar;
    }

    public final void run() {
        if (this.a.a.e.compareAndSet(false, true)) {
            ALog.e("anet.UnifiedRequestTask", "task time out", this.a.a.c, new Object[0]);
            this.a.a.b();
            this.a.a.d.resultCode = ErrorConstant.ERROR_REQUEST_TIME_OUT;
            this.a.a.b.a(new DefaultFinishEvent(ErrorConstant.ERROR_REQUEST_TIME_OUT, null, this.a.a.d));
            StatObject statObject = this.a.a.a.f;
            statObject.statusCode = ErrorConstant.ERROR_REQUEST_TIME_OUT;
            statObject.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_REQUEST_TIME_OUT);
            AppMonitor.getInstance().commitStat(statObject);
            AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_REQUEST_TIME_OUT, null, statObject, null));
        }
    }
}
