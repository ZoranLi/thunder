package com.hianalytics.android.v1;

import android.content.Context;
import android.os.Handler;
import com.hianalytics.android.b.a.a;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HiAnalytics {
    private static int reportPeriod = 0;
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private static boolean timerOn = false;

    public static void onEvent(Context context, String str, String str2) {
        if (context == null) {
            a.h();
            return;
        }
        if (str != null) {
            if (!str.equals("")) {
                if (str2 != null) {
                    if (!str2.equals("")) {
                        Handler g = a.g();
                        if (g != null) {
                            g.post(new a(context, str, str2, System.currentTimeMillis()));
                        }
                        a.h();
                        return;
                    }
                }
                a.h();
                return;
            }
        }
        a.h();
    }

    public static void onPause(Context context) {
        if (context == null) {
            a.h();
            return;
        }
        Handler g = a.g();
        if (g != null) {
            g.post(new d(context, 0, System.currentTimeMillis()));
        }
        a.h();
    }

    public static void onReport(Context context) {
        if (context == null) {
            a.h();
            return;
        }
        Handler g = a.g();
        if (g != null) {
            g.post(new d(context, 2, System.currentTimeMillis()));
        }
        a.h();
    }

    public static void onResume(Context context) {
        if (context == null) {
            a.h();
            return;
        }
        Handler g = a.g();
        if (g != null) {
            g.post(new d(context, 1, System.currentTimeMillis()));
        }
        a.h();
    }

    public static void setEventSize(int i) {
        if (i >= 0) {
            a.a(i);
        }
    }

    public static void setMaxMsg(Long l) {
        if (l.longValue() >= 1000) {
            a.c(l);
        }
    }

    public static void setMaxSessionIDTimeOut(long j) {
        if (j >= 30) {
            a.d(Long.valueOf(j * 60));
        }
    }

    public static void setRecordExpireTimeOut(Long l) {
        if (l.longValue() >= 24) {
            a.b(Long.valueOf((l.longValue() * 60) * 60));
        }
    }

    public static void setReportTimer(Context context, int i) {
        if (i == 0) {
            try {
                timerOn = false;
                scheduler.shutdown();
                scheduler = Executors.newScheduledThreadPool(1);
            } catch (Exception e) {
                e.getMessage();
                a.h();
                e.printStackTrace();
            }
        } else if (timerOn) {
            if (timerOn && i != reportPeriod) {
                reportPeriod = i;
                a.h();
                scheduler.shutdown();
                ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
                scheduler = newScheduledThreadPool;
                r7 = (long) i;
                newScheduledThreadPool.scheduleAtFixedRate(new d(context, 2, System.currentTimeMillis()), r7, r7, TimeUnit.SECONDS);
            }
        } else {
            timerOn = true;
            a.h();
            r7 = (long) i;
            scheduler.scheduleAtFixedRate(new d(context, 2, System.currentTimeMillis()), r7, r7, TimeUnit.SECONDS);
        }
    }

    public static void setReportWhenFull(boolean z) {
        a.a(z);
    }

    public static void setSessionExpireTimeOut(Long l) {
        if (l.longValue() >= 30) {
            a.a(l);
        }
    }
}
