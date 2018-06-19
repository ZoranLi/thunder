package com.alibaba.mtl.appmonitor;

import android.app.Application;
import android.os.RemoteException;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.d.j;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.q.b;
import com.alibaba.mtl.appmonitor.q.c;
import com.alibaba.mtl.appmonitor.r.a;
import com.alibaba.mtl.log.e.i;
import java.util.Map;

/* compiled from: Monitor */
public final class s extends a {
    private Application a;

    s(Application application) {
        this.a = application;
    }

    public final void a() throws RemoteException {
        q.a(this.a);
    }

    public final void d() throws RemoteException {
        q.a();
    }

    public final void b() throws RemoteException {
        q.b();
    }

    public final void a(int i) throws RemoteException {
        q.b(i);
    }

    public final void a(boolean z) throws RemoteException {
        q.a(z);
    }

    public final void a(boolean z, String str, String str2, String str3) throws RemoteException {
        q.a(z, str, str2, str3);
    }

    public final void a(String str) throws RemoteException {
        q.a(str);
    }

    public final void a(Map map) throws RemoteException {
        q.a(map);
    }

    public final void c() throws RemoteException {
        q.c();
    }

    public final void a(String str, String str2, String str3, double d) throws RemoteException {
        b.a(str, str2, str3, d);
    }

    public final void a(String str, String str2, String str3) throws RemoteException {
        q.a.a(str, str2, str3);
    }

    public final void a(String str, String str2, String str3, String str4, String str5) throws RemoteException {
        q.a.a(str, str2, str3, str4, str5);
    }

    public final void b(int i) throws RemoteException {
        q.a(i);
    }

    public final void a(String str, String str2, MeasureSet measureSet) throws RemoteException {
        q.a(str, str2, measureSet);
    }

    public final void a(String str, String str2, MeasureSet measureSet, boolean z) throws RemoteException {
        q.a(str, str2, measureSet, z);
    }

    public final void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) throws RemoteException {
        q.a(str, str2, measureSet, dimensionSet);
    }

    public final void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) throws RemoteException {
        q.a(str, str2, measureSet, dimensionSet, z);
    }

    public final void a(String str, String str2, DimensionValueSet dimensionValueSet, double d) throws RemoteException {
        c.a(str, str2, dimensionValueSet, d);
    }

    public final void a(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) throws RemoteException {
        i.a("Monitor", "[stat_commit3]");
        c.a(str, str2, dimensionValueSet, measureValueSet);
    }

    public final void a(Transaction transaction, String str) throws RemoteException {
        v.a(transaction, str);
    }

    public final void b(Transaction transaction, String str) throws RemoteException {
        v.b(transaction, str);
    }

    public final void a(int i, int i2) throws RemoteException {
        q.a(f.a(i), i2);
    }

    public final void c(int i) throws RemoteException {
        f.COUNTER.setStatisticsInterval(i);
        q.a(f.COUNTER, i);
    }

    public final void d(int i) throws RemoteException {
        j.a().a(f.COUNTER, i);
    }

    public final boolean a(String str, String str2) throws RemoteException {
        return j.a(f.COUNTER, str, str2);
    }

    public final void a(String str, String str2, double d) throws RemoteException {
        b.a(str, str2, null, d);
    }

    public final void g(int i) throws RemoteException {
        f.ALARM.setStatisticsInterval(i);
        q.a(f.ALARM, i);
    }

    public final void h(int i) throws RemoteException {
        j.a().a(f.ALARM, i);
    }

    public final boolean c(String str, String str2) throws RemoteException {
        return j.a(f.ALARM, str, str2);
    }

    public final void d(String str, String str2) throws RemoteException {
        q.a.a(str, str2, null);
    }

    public final void a(String str, String str2, String str3, String str4) throws RemoteException {
        q.a.a(str, str2, null, str3, str4);
    }

    public final void e(int i) throws RemoteException {
        f.OFFLINE_COUNTER.setStatisticsInterval(i);
        q.a(f.OFFLINE_COUNTER, i);
    }

    public final void f(int i) throws RemoteException {
        j.a().a(f.OFFLINE_COUNTER, i);
    }

    public final boolean b(String str, String str2) throws RemoteException {
        return j.a(f.OFFLINE_COUNTER, str, str2);
    }

    public final void b(String str, String str2, double d) throws RemoteException {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    com.alibaba.mtl.log.b.a.e();
                    if (q.b && com.alibaba.mtl.log.a.a.b() && f.OFFLINE_COUNTER.isOpen() && (q.a || j.a(f.OFFLINE_COUNTER, str, str2))) {
                        i.a("AppMonitorDelegate", "commitOffLineCount module: ", str, " monitorPoint: ", str2, " value: ", Double.valueOf(d));
                        com.alibaba.mtl.log.b.a.f();
                        e.a().a(f.OFFLINE_COUNTER.a(), str, str2, null, d);
                    }
                    return;
                }
            }
            i.b("AppMonitorDelegate", "module & monitorPoint must not null");
        } catch (String str3) {
            com.alibaba.mtl.appmonitor.b.b.a(str3);
        }
    }

    public final void b(String str, String str2, String str3) throws RemoteException {
        try {
            if (q.b && com.alibaba.mtl.log.a.a.b() && f.STAT.isOpen() && (q.a || j.a(f.STAT, str, str2))) {
                i.a("AppMonitorDelegate", "statEvent begin. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                e a = e.a();
                Integer valueOf = Integer.valueOf(f.STAT.a());
                String a2 = e.a(str, str2);
                if (a2 != null) {
                    a.a(a2, valueOf, str, str2, str3);
                }
            }
        } catch (String str4) {
            com.alibaba.mtl.appmonitor.b.b.a(str4);
        }
    }

    public final void c(String str, String str2, String str3) throws RemoteException {
        try {
            if (q.b && com.alibaba.mtl.log.a.a.b() && f.STAT.isOpen() && (q.a || j.a(f.STAT, str, str2))) {
                i.a("AppMonitorDelegate", "statEvent end. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                e a = e.a();
                str = e.a(str, str2);
                if (str != null) {
                    a.a(str, str3, true);
                }
            }
        } catch (String str4) {
            com.alibaba.mtl.appmonitor.b.b.a(str4);
        }
    }

    public final void i(int i) throws RemoteException {
        f.STAT.setStatisticsInterval(i);
        q.a(f.STAT, i);
    }

    public final void j(int i) throws RemoteException {
        j.a().a(f.STAT, i);
    }

    public final boolean e(String str, String str2) throws RemoteException {
        return j.a(f.STAT, str, str2);
    }

    public final void c(String str, String str2, double d) throws RemoteException {
        c.a(str, str2, null, d);
    }
}
