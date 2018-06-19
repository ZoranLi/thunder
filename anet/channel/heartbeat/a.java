package anet.channel.heartbeat;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.Session;
import anet.channel.a.c;
import anet.channel.util.ALog;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class a implements IHeartbeat, Runnable {
    private final Session a;
    private volatile long b = 0;
    private volatile boolean c = false;
    private int d = 0;
    private long e = 0;

    public a(Session session) {
        this.a = session;
        this.e = (long) session.getConnStrategy().getHeartbeat();
    }

    public void start() {
        ALog.i("awcn.DefaultHeartbeatImpl", "heartbeat start", this.a.mSeq, "session", this.a);
        a(this.e);
    }

    public void stop() {
        ALog.i("awcn.DefaultHeartbeatImpl", "heartbeat stop", this.a.mSeq, "session", this.a);
        this.c = true;
    }

    public long getInterval() {
        return this.e;
    }

    public void heartbeat() {
        this.a.ping(true);
    }

    public void reSchedule() {
        long currentTimeMillis = System.currentTimeMillis() + this.e;
        if (this.b + 1000 < currentTimeMillis) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.DefaultHeartbeatImpl", "reSchedule", this.a.mSeq, "session", this.a, "delay", Long.valueOf(currentTimeMillis - this.b));
            }
            this.b = currentTimeMillis;
        }
    }

    public void run() {
        if (!this.c) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < this.b) {
                a(this.b - currentTimeMillis);
                return;
            }
            boolean isAppBackground = GlobalAppRuntimeInfo.isAppBackground();
            int i = 0;
            if (isAppBackground) {
                ALog.e("awcn.DefaultHeartbeatImpl", "close session in background", this.a.mSeq, "session", this.a);
                this.a.close(false);
                return;
            }
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.DefaultHeartbeatImpl", "heartbeat", this.a.mSeq, "session", this.a);
            }
            heartbeat();
            if (isAppBackground) {
                i = this.d + 1;
            }
            this.d = i;
            a(this.e);
        }
    }

    private void a(long j) {
        try {
            this.b = System.currentTimeMillis() + j;
            c.a(this, j + 50, TimeUnit.MILLISECONDS);
        } catch (long j2) {
            ALog.e("awcn.DefaultHeartbeatImpl", "Submit heartbeat task to thread pool failed.", this.a.mSeq, j2, new Object[0]);
        }
    }
}
