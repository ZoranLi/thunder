package anet.channel.appmonitor;

import android.text.TextUtils;
import anet.channel.statist.AlarmObject;
import anet.channel.statist.CountObject;
import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import anet.channel.statist.StatObject;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import com.alibaba.mtl.appmonitor.AppMonitor.a;
import com.alibaba.mtl.appmonitor.AppMonitor.c;
import com.alibaba.mtl.appmonitor.AppMonitor.d;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
class b implements IAppMonitor {
    private static boolean a = false;
    private static Map<Class<?>, List<Field>> b = new HashMap();
    private static Map<Class<?>, List<Field>> c = new HashMap();
    private static Set<Class<?>> d = Collections.newSetFromMap(new ConcurrentHashMap());

    @Deprecated
    public void register() {
    }

    public void register(Class<?> cls) {
    }

    b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r1.<init>();
        r0 = "com.alibaba.mtl.appmonitor.AppMonitor";	 Catch:{ Exception -> 0x000c }
        java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x000c }
        r0 = 1;	 Catch:{ Exception -> 0x000c }
        a = r0;	 Catch:{ Exception -> 0x000c }
        return;
    L_0x000c:
        r0 = 0;
        a = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.appmonitor.b.<init>():void");
    }

    public void commitStat(StatObject statObject) {
        if (a) {
            if (statObject != null) {
                Class cls = statObject.getClass();
                Monitor monitor = (Monitor) cls.getAnnotation(Monitor.class);
                if (monitor != null) {
                    if (!d.contains(cls)) {
                        a(cls);
                    }
                    if (statObject.beforeCommit()) {
                        try {
                            DimensionValueSet a = DimensionValueSet.a();
                            MeasureValueSet a2 = MeasureValueSet.a();
                            List<Field> list = (List) b.get(cls);
                            Map hashMap = ALog.isPrintLog(1) ? new HashMap() : null;
                            Object obj;
                            if (list != null) {
                                for (Field field : list) {
                                    obj = field.get(statObject);
                                    a.a(field.getName(), obj == null ? "" : obj.toString());
                                }
                                for (Field field2 : (List) c.get(cls)) {
                                    Double valueOf = Double.valueOf(field2.getDouble(statObject));
                                    a2.a(field2.getName(), valueOf.doubleValue());
                                    if (hashMap != null) {
                                        hashMap.put(field2.getName(), valueOf);
                                    }
                                }
                            } else {
                                Field[] declaredFields = cls.getDeclaredFields();
                                for (Field field3 : declaredFields) {
                                    field3.setAccessible(true);
                                    if (field3.isAnnotationPresent(Dimension.class)) {
                                        obj = field3.get(statObject);
                                        a.a(field3.getName(), obj == null ? "" : obj.toString());
                                    } else if (field3.isAnnotationPresent(Measure.class)) {
                                        Double valueOf2 = Double.valueOf(field3.getDouble(statObject));
                                        a2.a(field3.getName(), valueOf2.doubleValue());
                                        if (hashMap != null) {
                                            hashMap.put(field3.getName(), valueOf2);
                                        }
                                    }
                                }
                            }
                            d.a(monitor.module(), monitor.monitorPoint(), a, a2);
                            if (ALog.isPrintLog(1) != null) {
                                StringBuilder stringBuilder = new StringBuilder("commit stat: ");
                                stringBuilder.append(monitor.monitorPoint());
                                ALog.d("awcn.DefaultAppMonitor", stringBuilder.toString(), null, "\nDimensions", a.b().toString(), "\nMeasures", hashMap.toString());
                            }
                        } catch (StatObject statObject2) {
                            ALog.e("awcn.DefaultAppMonitor", "commit monitor point failed", null, statObject2, new Object[0]);
                        }
                    }
                }
            }
        }
    }

    public void commitAlarm(AlarmObject alarmObject) {
        if (a) {
            if (alarmObject != null) {
                if (!TextUtils.isEmpty(alarmObject.module)) {
                    if (!TextUtils.isEmpty(alarmObject.modulePoint)) {
                        if (ALog.isPrintLog(1)) {
                            StringBuilder stringBuilder = new StringBuilder("commit alarm: ");
                            stringBuilder.append(alarmObject);
                            ALog.d("awcn.DefaultAppMonitor", stringBuilder.toString(), null, new Object[0]);
                        }
                        if (alarmObject.isSuccess) {
                            a.a(alarmObject.module, alarmObject.modulePoint, StringUtils.stringNull2Empty(alarmObject.arg));
                        } else {
                            a.a(alarmObject.module, alarmObject.modulePoint, StringUtils.stringNull2Empty(alarmObject.arg), StringUtils.stringNull2Empty(alarmObject.errorCode), StringUtils.stringNull2Empty(alarmObject.errorMsg));
                        }
                    }
                }
            }
        }
    }

    public void commitCount(CountObject countObject) {
        if (a) {
            if (countObject != null) {
                if (!TextUtils.isEmpty(countObject.module)) {
                    if (!TextUtils.isEmpty(countObject.modulePoint)) {
                        if (ALog.isPrintLog(2)) {
                            StringBuilder stringBuilder = new StringBuilder("commit count: ");
                            stringBuilder.append(countObject);
                            ALog.i("awcn.DefaultAppMonitor", stringBuilder.toString(), null, new Object[0]);
                        }
                        c.a(countObject.module, countObject.modulePoint, StringUtils.stringNull2Empty(countObject.arg), countObject.value);
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized void a(java.lang.Class<?> r20) {
        /*
        r19 = this;
        r1 = r20;
        monitor-enter(r19);
        if (r1 == 0) goto L_0x00e6;
    L_0x0005:
        r2 = a;	 Catch:{ all -> 0x00e2 }
        if (r2 != 0) goto L_0x000b;
    L_0x0009:
        goto L_0x00e6;
    L_0x000b:
        r3 = d;	 Catch:{ Exception -> 0x00d3 }
        r3 = r3.contains(r1);	 Catch:{ Exception -> 0x00d3 }
        if (r3 == 0) goto L_0x0015;
    L_0x0013:
        monitor-exit(r19);
        return;
    L_0x0015:
        r3 = anet.channel.statist.Monitor.class;
        r3 = r1.getAnnotation(r3);	 Catch:{ Exception -> 0x00d3 }
        r3 = (anet.channel.statist.Monitor) r3;	 Catch:{ Exception -> 0x00d3 }
        if (r3 != 0) goto L_0x0021;
    L_0x001f:
        monitor-exit(r19);
        return;
    L_0x0021:
        r4 = r20.getDeclaredFields();	 Catch:{ Exception -> 0x00d3 }
        r5 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00d3 }
        r5.<init>();	 Catch:{ Exception -> 0x00d3 }
        r6 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00d3 }
        r6.<init>();	 Catch:{ Exception -> 0x00d3 }
        r7 = com.alibaba.mtl.appmonitor.model.DimensionSet.a();	 Catch:{ Exception -> 0x00d3 }
        r8 = com.alibaba.mtl.appmonitor.model.MeasureSet.a();	 Catch:{ Exception -> 0x00d3 }
        r9 = 0;
    L_0x0038:
        r10 = r4.length;	 Catch:{ Exception -> 0x00d3 }
        if (r9 >= r10) goto L_0x00b3;
    L_0x003b:
        r10 = r4[r9];	 Catch:{ Exception -> 0x00d3 }
        r11 = anet.channel.statist.Dimension.class;
        r11 = r10.getAnnotation(r11);	 Catch:{ Exception -> 0x00d3 }
        r11 = (anet.channel.statist.Dimension) r11;	 Catch:{ Exception -> 0x00d3 }
        r12 = 1;
        if (r11 == 0) goto L_0x0056;
    L_0x0048:
        r10.setAccessible(r12);	 Catch:{ Exception -> 0x00d3 }
        r5.add(r10);	 Catch:{ Exception -> 0x00d3 }
        r10 = r10.getName();	 Catch:{ Exception -> 0x00d3 }
        r7.a(r10);	 Catch:{ Exception -> 0x00d3 }
        goto L_0x00a8;
    L_0x0056:
        r11 = anet.channel.statist.Measure.class;
        r11 = r10.getAnnotation(r11);	 Catch:{ Exception -> 0x00d3 }
        r11 = (anet.channel.statist.Measure) r11;	 Catch:{ Exception -> 0x00d3 }
        if (r11 == 0) goto L_0x00a8;
    L_0x0060:
        r10.setAccessible(r12);	 Catch:{ Exception -> 0x00d3 }
        r6.add(r10);	 Catch:{ Exception -> 0x00d3 }
        r12 = r11.max();	 Catch:{ Exception -> 0x00d3 }
        r14 = 9218868437227405311; // 0x7fefffffffffffff float:NaN double:1.7976931348623157E308;
        r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
        if (r16 == 0) goto L_0x009c;
    L_0x0073:
        r12 = new com.alibaba.mtl.appmonitor.model.Measure;	 Catch:{ Exception -> 0x00d3 }
        r10 = r10.getName();	 Catch:{ Exception -> 0x00d3 }
        r13 = r11.constantValue();	 Catch:{ Exception -> 0x00d3 }
        r13 = java.lang.Double.valueOf(r13);	 Catch:{ Exception -> 0x00d3 }
        r17 = r3;
        r2 = r11.min();	 Catch:{ Exception -> 0x00d3 }
        r2 = java.lang.Double.valueOf(r2);	 Catch:{ Exception -> 0x00d3 }
        r18 = r4;
        r3 = r11.max();	 Catch:{ Exception -> 0x00d3 }
        r3 = java.lang.Double.valueOf(r3);	 Catch:{ Exception -> 0x00d3 }
        r12.<init>(r10, r13, r2, r3);	 Catch:{ Exception -> 0x00d3 }
        r8.a(r12);	 Catch:{ Exception -> 0x00d3 }
        goto L_0x00ac;
    L_0x009c:
        r17 = r3;
        r18 = r4;
        r2 = r10.getName();	 Catch:{ Exception -> 0x00d3 }
        r8.a(r2);	 Catch:{ Exception -> 0x00d3 }
        goto L_0x00ac;
    L_0x00a8:
        r17 = r3;
        r18 = r4;
    L_0x00ac:
        r9 = r9 + 1;
        r3 = r17;
        r4 = r18;
        goto L_0x0038;
    L_0x00b3:
        r17 = r3;
        r2 = b;	 Catch:{ Exception -> 0x00d3 }
        r2.put(r1, r5);	 Catch:{ Exception -> 0x00d3 }
        r2 = c;	 Catch:{ Exception -> 0x00d3 }
        r2.put(r1, r6);	 Catch:{ Exception -> 0x00d3 }
        r3 = r17;
        r2 = r3.module();	 Catch:{ Exception -> 0x00d3 }
        r3 = r3.monitorPoint();	 Catch:{ Exception -> 0x00d3 }
        com.alibaba.mtl.appmonitor.AppMonitor.a(r2, r3, r8, r7);	 Catch:{ Exception -> 0x00d3 }
        r2 = d;	 Catch:{ Exception -> 0x00d3 }
        r2.add(r1);	 Catch:{ Exception -> 0x00d3 }
        monitor-exit(r19);
        return;
    L_0x00d3:
        r0 = move-exception;
        r1 = r0;
        r2 = "awcn.DefaultAppMonitor";
        r3 = "register fail";
        r4 = 0;
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00e2 }
        anet.channel.util.ALog.e(r2, r3, r4, r1, r5);	 Catch:{ all -> 0x00e2 }
        monitor-exit(r19);
        return;
    L_0x00e2:
        r0 = move-exception;
        r1 = r0;
        monitor-exit(r19);
        throw r1;
    L_0x00e6:
        monitor-exit(r19);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.appmonitor.b.a(java.lang.Class):void");
    }
}
