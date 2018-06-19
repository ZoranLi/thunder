package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.common.l;
import com.tencent.wxop.stat.common.q;
import com.tencent.wxop.stat.event.e;

class aq {
    private static volatile long f;
    private e a;
    private StatReportStrategy b = null;
    private boolean c = false;
    private Context d = null;
    private long e = System.currentTimeMillis();

    public aq(e eVar) {
        this.a = eVar;
        this.b = StatConfig.getStatSendStrategy();
        this.c = eVar.f();
        this.d = eVar.e();
    }

    private void a(h hVar) {
        i.b(StatServiceImpl.t).a(this.a, hVar);
    }

    private void b() {
        if (this.a.d() != null && this.a.d().isSendImmediately()) {
            this.b = StatReportStrategy.INSTANT;
        }
        if (StatConfig.j && a.a(StatServiceImpl.t).e()) {
            this.b = StatReportStrategy.INSTANT;
        }
        if (StatConfig.isDebugEnable()) {
            StatLogger f = StatServiceImpl.q;
            StringBuilder stringBuilder = new StringBuilder("strategy=");
            stringBuilder.append(this.b.name());
            f.i(stringBuilder.toString());
        }
        switch (ag.a[this.b.ordinal()]) {
            case 1:
                c();
                break;
            case 2:
                au.a(this.d).a(this.a, null, this.c, false);
                if (StatConfig.isDebugEnable()) {
                    f = StatServiceImpl.q;
                    stringBuilder = new StringBuilder("PERIOD currTime=");
                    stringBuilder.append(this.e);
                    stringBuilder.append(",nextPeriodSendTs=");
                    stringBuilder.append(StatServiceImpl.c);
                    stringBuilder.append(",difftime=");
                    stringBuilder.append(StatServiceImpl.c - this.e);
                    f.i(stringBuilder.toString());
                }
                if (StatServiceImpl.c == 0) {
                    StatServiceImpl.c = q.a(this.d, "last_period_ts", 0);
                    if (this.e > StatServiceImpl.c) {
                        StatServiceImpl.e(this.d);
                    }
                    long sendPeriodMinutes = this.e + ((long) ((StatConfig.getSendPeriodMinutes() * 60) * 1000));
                    if (StatServiceImpl.c > sendPeriodMinutes) {
                        StatServiceImpl.c = sendPeriodMinutes;
                    }
                    d.a(this.d).a();
                }
                if (StatConfig.isDebugEnable()) {
                    f = StatServiceImpl.q;
                    stringBuilder = new StringBuilder("PERIOD currTime=");
                    stringBuilder.append(this.e);
                    stringBuilder.append(",nextPeriodSendTs=");
                    stringBuilder.append(StatServiceImpl.c);
                    stringBuilder.append(",difftime=");
                    stringBuilder.append(StatServiceImpl.c - this.e);
                    f.i(stringBuilder.toString());
                }
                if (this.e > StatServiceImpl.c) {
                    StatServiceImpl.e(this.d);
                    return;
                }
                break;
            case 3:
            case 4:
                au.a(this.d).a(this.a, null, this.c, false);
                return;
            case 5:
                au.a(this.d).a(this.a, new ar(this), this.c, true);
                return;
            case 6:
                if (a.a(StatServiceImpl.t).c() == 1) {
                    c();
                    return;
                } else {
                    au.a(this.d).a(this.a, null, this.c, false);
                    return;
                }
            case 7:
                if (l.e(this.d)) {
                    a(new as(this));
                    return;
                }
                break;
            default:
                f = StatServiceImpl.q;
                stringBuilder = new StringBuilder("Invalid stat strategy:");
                stringBuilder.append(StatConfig.getStatSendStrategy());
                f.error(stringBuilder.toString());
                return;
        }
    }

    private void c() {
        if (au.b().a <= 0 || !StatConfig.l) {
            a(new at(this));
            return;
        }
        au.b().a(this.a, null, this.c, true);
        au.b().a(-1);
    }

    private boolean d() {
        if (StatConfig.h > 0) {
            StatLogger f;
            if (this.e > StatServiceImpl.h) {
                StatServiceImpl.g.clear();
                StatServiceImpl.h = this.e + StatConfig.i;
                if (StatConfig.isDebugEnable()) {
                    f = StatServiceImpl.q;
                    StringBuilder stringBuilder = new StringBuilder("clear methodsCalledLimitMap, nextLimitCallClearTime=");
                    stringBuilder.append(StatServiceImpl.h);
                    f.i(stringBuilder.toString());
                }
            }
            Integer valueOf = Integer.valueOf(this.a.a().a());
            Integer num = (Integer) StatServiceImpl.g.get(valueOf);
            if (num != null) {
                StatServiceImpl.g.put(valueOf, Integer.valueOf(num.intValue() + 1));
                if (num.intValue() > StatConfig.h) {
                    if (StatConfig.isDebugEnable()) {
                        f = StatServiceImpl.q;
                        StringBuilder stringBuilder2 = new StringBuilder("event ");
                        stringBuilder2.append(this.a.g());
                        stringBuilder2.append(" was discard, cause of called limit, current:");
                        stringBuilder2.append(num);
                        stringBuilder2.append(", limit:");
                        stringBuilder2.append(StatConfig.h);
                        stringBuilder2.append(", period:");
                        stringBuilder2.append(StatConfig.i);
                        stringBuilder2.append(" ms");
                        f.e(stringBuilder2.toString());
                    }
                    return true;
                }
            }
            StatServiceImpl.g.put(valueOf, Integer.valueOf(1));
        }
        return false;
    }

    public void a() {
        if (!d()) {
            StatLogger f;
            if (StatConfig.m > 0 && this.e >= f) {
                StatServiceImpl.flushDataToDB(this.d);
                f = this.e + StatConfig.n;
                if (StatConfig.isDebugEnable()) {
                    f = StatServiceImpl.q;
                    StringBuilder stringBuilder = new StringBuilder("nextFlushTime=");
                    stringBuilder.append(f);
                    f.i(stringBuilder.toString());
                }
            }
            if (a.a(this.d).f()) {
                if (StatConfig.isDebugEnable()) {
                    f = StatServiceImpl.q;
                    StringBuilder stringBuilder2 = new StringBuilder("sendFailedCount=");
                    stringBuilder2.append(StatServiceImpl.a);
                    f.i(stringBuilder2.toString());
                }
                if (StatServiceImpl.a()) {
                    au.a(this.d).a(this.a, null, this.c, false);
                    if (this.e - StatServiceImpl.b > 1800000) {
                        StatServiceImpl.d(this.d);
                    }
                    return;
                }
                b();
                return;
            }
            au.a(this.d).a(this.a, null, this.c, false);
        }
    }
}
