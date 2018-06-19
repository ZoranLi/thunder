package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: UploadTask */
final class y implements Runnable {
    private static boolean a = false;
    private static Map<Integer, y> e;
    private int b = 180000;
    private int c;
    private long d;

    private static int a(int i) {
        if (i == 65133) {
            return 11;
        }
        switch (i) {
            case 65501:
                return 6;
            case 65502:
                return 9;
            case 65503:
                return 10;
            default:
                return 0;
        }
    }

    static void a() {
        if (!a) {
            Object[] objArr = new Object[1];
            int i = 0;
            objArr[0] = "init StatisticsAlarmEvent";
            i.a("CommitTask", objArr);
            e = new ConcurrentHashMap();
            f[] a = f.a();
            int length = a.length;
            while (i < length) {
                f fVar = a[i];
                if (fVar.isOpen()) {
                    int a2 = fVar.a();
                    Runnable yVar = new y(a2, 1000 * fVar.c());
                    e.put(Integer.valueOf(a2), yVar);
                    r.a().a(a(a2), yVar, (long) yVar.b);
                }
                i++;
            }
            a = true;
        }
    }

    static void b() {
        for (f a : f.a()) {
            r.a().a(a(a.a()));
        }
        a = false;
        e = null;
    }

    static void a(int i, int i2) {
        Object[] objArr = new Object[1];
        StringBuilder stringBuilder = new StringBuilder("[setStatisticsInterval] eventId");
        stringBuilder.append(i);
        stringBuilder.append(" statisticsInterval:");
        stringBuilder.append(i2);
        objArr[0] = stringBuilder.toString();
        i.a("CommitTask", objArr);
        synchronized (e) {
            y yVar = (y) e.get(Integer.valueOf(i));
            Object[] objArr2;
            if (yVar == null) {
                if (i2 > 0) {
                    Runnable yVar2 = new y(i, 1000 * i2);
                    e.put(Integer.valueOf(i), yVar2);
                    objArr2 = new Object[1];
                    stringBuilder = new StringBuilder("post next eventId");
                    stringBuilder.append(i);
                    stringBuilder.append(": uploadTask.interval ");
                    stringBuilder.append(yVar2.b);
                    objArr2[0] = stringBuilder.toString();
                    i.a("CommitTask", objArr2);
                    r.a().a(a(i), yVar2, (long) yVar2.b);
                }
            } else if (i2 > 0) {
                i2 *= 1000;
                if (yVar.b != i2) {
                    r.a().a(a(i));
                    yVar.b = i2;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = ((long) yVar.b) - (currentTimeMillis - yVar.d);
                    long j2 = 0;
                    if (j >= 0) {
                        j2 = j;
                    }
                    objArr2 = new Object[1];
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(yVar);
                    stringBuilder.append("post next eventId");
                    stringBuilder.append(i);
                    stringBuilder.append(" next:");
                    stringBuilder.append(j2);
                    stringBuilder.append("  uploadTask.interval: ");
                    stringBuilder.append(yVar.b);
                    objArr2[0] = stringBuilder.toString();
                    i.a("CommitTask", objArr2);
                    r.a().a(a(i), yVar, j2);
                    yVar.d = currentTimeMillis;
                }
            } else {
                objArr = new Object[1];
                stringBuilder = new StringBuilder("uploadTasks.size:");
                stringBuilder.append(e.size());
                objArr[0] = stringBuilder.toString();
                i.a("CommitTask", objArr);
                e.remove(Integer.valueOf(i));
                Object[] objArr3 = new Object[1];
                StringBuilder stringBuilder2 = new StringBuilder("uploadTasks.size:");
                stringBuilder2.append(e.size());
                objArr3[0] = stringBuilder2.toString();
                i.a("CommitTask", objArr3);
            }
        }
    }

    private y(int i, int i2) {
        this.c = i;
        this.b = i2;
        this.d = System.currentTimeMillis();
    }

    public final void run() {
        i.a("CommitTask", "check&commit event:", Integer.valueOf(this.c));
        e.a().b(this.c);
        if (e.containsValue(this)) {
            this.d = System.currentTimeMillis();
            Object[] objArr = new Object[1];
            StringBuilder stringBuilder = new StringBuilder("next:");
            stringBuilder.append(this.c);
            objArr[0] = stringBuilder.toString();
            i.a("CommitTask", objArr);
            r.a().a(a(this.c), this, (long) this.b);
        }
    }

    static void c() {
        for (f a : f.a()) {
            e.a().b(a.a());
        }
    }
}
