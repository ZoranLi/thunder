package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener;
import anet.channel.status.NetworkStatusHelper.NetworkStatus;
import anet.channel.strategy.k.c;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.strategy.utils.a;
import anet.channel.util.StringUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: Taobao */
class StrategyInfoHolder implements INetworkStatusChangeListener {
    static final String a = b(UnitMap.class.getSimpleName());
    static final String b = b(SafeAislesMap.class.getSimpleName());
    Map<String, StrategyTable> c = new LruStrategyMap();
    UnitMap d = null;
    SafeAislesMap e = null;
    final a f = new a();
    private final StrategyTable g = new StrategyTable("Unknown");
    private final Set<String> h = new HashSet();
    private volatile String i = "";

    /* compiled from: Taobao */
    private static class LruStrategyMap extends SerialLruCache<String, StrategyTable> {
        public LruStrategyMap() {
            super(3);
        }

        protected boolean a(Entry<String, StrategyTable> entry) {
            a.a(new f(this, entry));
            return true;
        }
    }

    public static StrategyInfoHolder a() {
        return new StrategyInfoHolder();
    }

    private StrategyInfoHolder() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r2.<init>();
        r0 = new anet.channel.strategy.StrategyInfoHolder$LruStrategyMap;
        r0.<init>();
        r2.c = r0;
        r0 = 0;
        r2.d = r0;
        r2.e = r0;
        r0 = new anet.channel.strategy.a;
        r0.<init>();
        r2.f = r0;
        r0 = new anet.channel.strategy.StrategyTable;
        r1 = "Unknown";
        r0.<init>(r1);
        r2.g = r0;
        r0 = new java.util.HashSet;
        r0.<init>();
        r2.h = r0;
        r0 = "";
        r2.i = r0;
        r2.e();	 Catch:{ Throwable -> 0x0039, all -> 0x0034 }
        r2.g();	 Catch:{ Throwable -> 0x0039, all -> 0x0034 }
        r2.f();
        return;
    L_0x0034:
        r0 = move-exception;
        r2.f();
        throw r0;
    L_0x0039:
        r2.f();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.StrategyInfoHolder.<init>():void");
    }

    void b() {
        NetworkStatusHelper.b(this);
    }

    private void e() {
        NetworkStatusHelper.a((INetworkStatusChangeListener) this);
        this.i = a(NetworkStatusHelper.a());
    }

    private void f() {
        for (Entry value : this.c.entrySet()) {
            ((StrategyTable) value.getValue()).a();
        }
        if (this.d == null) {
            this.d = new UnitMap();
        } else {
            this.d.a();
        }
        if (this.e == null) {
            this.e = new SafeAislesMap();
        } else {
            this.e.a();
        }
        this.e.a(this);
    }

    private void g() {
        String b = b(this.i);
        if (!TextUtils.isEmpty(this.i)) {
            a(b, this.i);
        }
        this.d = (UnitMap) l.b(a);
        this.e = (SafeAislesMap) l.b(b);
        a.a(new d(this, b));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r7, java.lang.String r8) {
        /*
        r6 = this;
        r0 = r6.h;
        monitor-enter(r0);
        r1 = r6.h;	 Catch:{ all -> 0x0086 }
        r1 = r1.contains(r7);	 Catch:{ all -> 0x0086 }
        if (r1 != 0) goto L_0x0084;
    L_0x000b:
        r1 = r6.h;	 Catch:{ all -> 0x0086 }
        r1.add(r7);	 Catch:{ all -> 0x0086 }
        monitor-exit(r0);
        r0 = anet.channel.strategy.l.b(r7);
        r0 = (anet.channel.strategy.StrategyTable) r0;
        if (r0 == 0) goto L_0x002b;
    L_0x0019:
        r0.a();
        r1 = r6.c;
        monitor-enter(r1);
        r2 = r6.c;	 Catch:{ all -> 0x0028 }
        r3 = r0.a;	 Catch:{ all -> 0x0028 }
        r2.put(r3, r0);	 Catch:{ all -> 0x0028 }
        monitor-exit(r1);	 Catch:{ all -> 0x0028 }
        goto L_0x002b;
    L_0x0028:
        r7 = move-exception;
        monitor-exit(r1);
        throw r7;
    L_0x002b:
        r1 = r6.h;
        monitor-enter(r1);
        r2 = r6.h;	 Catch:{ all -> 0x0081 }
        r2.remove(r7);	 Catch:{ all -> 0x0081 }
        monitor-exit(r1);	 Catch:{ all -> 0x0081 }
        r7 = android.text.TextUtils.isEmpty(r8);
        if (r7 != 0) goto L_0x0080;
    L_0x003a:
        r7 = 0;
        r8 = 1;
        if (r0 == 0) goto L_0x0040;
    L_0x003e:
        r0 = r8;
        goto L_0x0041;
    L_0x0040:
        r0 = r7;
    L_0x0041:
        r1 = "awcn.StrategyInfoHolder";
        r2 = "restore strategy file";
        r3 = 0;
        r4 = 4;
        r4 = new java.lang.Object[r4];
        r5 = "id";
        r4[r7] = r5;
        r7 = r6.i;
        r4[r8] = r7;
        r7 = 2;
        r8 = "result";
        r4[r7] = r8;
        r7 = 3;
        r8 = java.lang.Boolean.valueOf(r0);
        r4[r7] = r8;
        anet.channel.util.ALog.i(r1, r2, r3, r4);
        r7 = new anet.channel.statist.AlarmObject;
        r7.<init>();
        r8 = "networkPrefer";
        r7.module = r8;
        r8 = "strategy_load_stat";
        r7.modulePoint = r8;
        r7.isSuccess = r0;
        r8 = r6.i;
        r7.arg = r8;
        r8 = anet.channel.GlobalAppRuntimeInfo.isTargetProcess();
        if (r8 == 0) goto L_0x0080;
    L_0x0079:
        r8 = anet.channel.appmonitor.AppMonitor.getInstance();
        r8.commitAlarm(r7);
    L_0x0080:
        return;
    L_0x0081:
        r7 = move-exception;
        monitor-exit(r1);
        throw r7;
    L_0x0084:
        monitor-exit(r0);	 Catch:{ all -> 0x0086 }
        return;
    L_0x0086:
        r7 = move-exception;
        monitor-exit(r0);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.StrategyInfoHolder.a(java.lang.String, java.lang.String):void");
    }

    void c() {
        synchronized (this) {
            for (StrategyTable strategyTable : this.c.values()) {
                l.a(strategyTable, b(strategyTable.a));
            }
            l.a(this.d, a);
            l.a(this.e, b);
        }
    }

    StrategyTable d() {
        StrategyTable strategyTable = this.g;
        if (TextUtils.isEmpty(this.i)) {
            return strategyTable;
        }
        StrategyTable strategyTable2;
        synchronized (this.c) {
            strategyTable2 = (StrategyTable) this.c.get(this.i);
            if (strategyTable2 == null) {
                strategyTable2 = new StrategyTable(this.i);
                this.c.put(this.i, strategyTable2);
            }
        }
        return strategyTable2;
    }

    private static String b(String str) {
        Object md5ToHex = StringUtils.md5ToHex(str);
        return !TextUtils.isEmpty(md5ToHex) ? md5ToHex : StringUtils.bytesToHexString(str.getBytes());
    }

    private String a(NetworkStatus networkStatus) {
        String str = "";
        if (networkStatus.isWifi()) {
            str = NetworkStatusHelper.f();
            StringBuilder stringBuilder = new StringBuilder(networkStatus.getType());
            stringBuilder.append("$");
            stringBuilder.append(str);
            return stringBuilder.toString();
        } else if (!networkStatus.isMobile()) {
            return str;
        } else {
            StringBuilder stringBuilder2 = new StringBuilder(networkStatus.getType());
            stringBuilder2.append("$");
            stringBuilder2.append(NetworkStatusHelper.c());
            return stringBuilder2.toString();
        }
    }

    void a(c cVar) {
        if (cVar.g != 0) {
            anet.channel.strategy.dispatch.a.a(cVar.g, cVar.h);
        }
        synchronized (this) {
            d().update(cVar);
            this.e.a(cVar);
            this.d.a(cVar);
        }
    }

    public void onNetworkStatusChanged(NetworkStatus networkStatus) {
        this.i = a(networkStatus);
        if (TextUtils.isEmpty(this.i) == null) {
            synchronized (this.c) {
                if (!this.c.containsKey(this.i)) {
                    a.a(new e(this, this.i));
                }
            }
        }
    }
}
