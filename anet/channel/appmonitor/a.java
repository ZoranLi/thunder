package anet.channel.appmonitor;

import anet.channel.statist.AlarmObject;
import anet.channel.statist.CountObject;
import anet.channel.statist.StatObject;

/* compiled from: Taobao */
final class a implements IAppMonitor {
    final /* synthetic */ IAppMonitor a;

    @Deprecated
    public final void register() {
    }

    @Deprecated
    public final void register(Class<?> cls) {
    }

    a(IAppMonitor iAppMonitor) {
        this.a = iAppMonitor;
    }

    public final void commitStat(StatObject statObject) {
        if (this.a != null) {
            this.a.commitStat(statObject);
        }
    }

    public final void commitAlarm(AlarmObject alarmObject) {
        if (this.a != null) {
            this.a.commitAlarm(alarmObject);
        }
    }

    public final void commitCount(CountObject countObject) {
        if (this.a != null) {
            this.a.commitCount(countObject);
        }
    }
}
