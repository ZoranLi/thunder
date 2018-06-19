package anet.channel;

import android.text.TextUtils;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import java.util.Collections;
import java.util.Set;

/* compiled from: Taobao */
class AccsSessionManager {
    private static final String TAG = "awcn.AccsSessionManager";
    SessionCenter instance = null;
    Set<String> lastKeys = Collections.EMPTY_SET;

    AccsSessionManager(SessionCenter sessionCenter) {
        this.instance = sessionCenter;
    }

    public synchronized void checkAndStartSession() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = r8.instance;	 Catch:{ all -> 0x009a }
        r0 = r0.attributeManager;	 Catch:{ all -> 0x009a }
        r0 = r0.a();	 Catch:{ all -> 0x009a }
        r1 = java.util.Collections.EMPTY_SET;	 Catch:{ all -> 0x009a }
        r2 = r0.isEmpty();	 Catch:{ all -> 0x009a }
        if (r2 != 0) goto L_0x0016;	 Catch:{ all -> 0x009a }
    L_0x0011:
        r1 = new java.util.TreeSet;	 Catch:{ all -> 0x009a }
        r1.<init>();	 Catch:{ all -> 0x009a }
    L_0x0016:
        r0 = r0.iterator();	 Catch:{ all -> 0x009a }
    L_0x001a:
        r2 = r0.hasNext();	 Catch:{ all -> 0x009a }
        if (r2 == 0) goto L_0x0049;	 Catch:{ all -> 0x009a }
    L_0x0020:
        r2 = r0.next();	 Catch:{ all -> 0x009a }
        r2 = (anet.channel.SessionInfo) r2;	 Catch:{ all -> 0x009a }
        r3 = r2.isKeepAlive;	 Catch:{ all -> 0x009a }
        if (r3 == 0) goto L_0x001a;	 Catch:{ all -> 0x009a }
    L_0x002a:
        r3 = anet.channel.strategy.StrategyCenter.getInstance();	 Catch:{ all -> 0x009a }
        r4 = r2.host;	 Catch:{ all -> 0x009a }
        r5 = r2.isAccs;	 Catch:{ all -> 0x009a }
        if (r5 == 0) goto L_0x0037;	 Catch:{ all -> 0x009a }
    L_0x0034:
        r5 = "https";	 Catch:{ all -> 0x009a }
        goto L_0x0039;	 Catch:{ all -> 0x009a }
    L_0x0037:
        r5 = "http";	 Catch:{ all -> 0x009a }
    L_0x0039:
        r3 = r3.getSchemeByHost(r4, r5);	 Catch:{ all -> 0x009a }
        r4 = "://";	 Catch:{ all -> 0x009a }
        r2 = r2.host;	 Catch:{ all -> 0x009a }
        r2 = anet.channel.util.StringUtils.concatString(r3, r4, r2);	 Catch:{ all -> 0x009a }
        r1.add(r2);	 Catch:{ all -> 0x009a }
        goto L_0x001a;	 Catch:{ all -> 0x009a }
    L_0x0049:
        r0 = r8.lastKeys;	 Catch:{ all -> 0x009a }
        r0 = r0.iterator();	 Catch:{ all -> 0x009a }
    L_0x004f:
        r2 = r0.hasNext();	 Catch:{ all -> 0x009a }
        if (r2 == 0) goto L_0x0065;	 Catch:{ all -> 0x009a }
    L_0x0055:
        r2 = r0.next();	 Catch:{ all -> 0x009a }
        r2 = (java.lang.String) r2;	 Catch:{ all -> 0x009a }
        r3 = r1.contains(r2);	 Catch:{ all -> 0x009a }
        if (r3 != 0) goto L_0x004f;	 Catch:{ all -> 0x009a }
    L_0x0061:
        r8.closeSessions(r2);	 Catch:{ all -> 0x009a }
        goto L_0x004f;	 Catch:{ all -> 0x009a }
    L_0x0065:
        r0 = r8.isNeedCheckSession();	 Catch:{ all -> 0x009a }
        if (r0 != 0) goto L_0x006d;
    L_0x006b:
        monitor-exit(r8);
        return;
    L_0x006d:
        r0 = r1.iterator();	 Catch:{ all -> 0x009a }
    L_0x0071:
        r2 = r0.hasNext();	 Catch:{ all -> 0x009a }
        if (r2 == 0) goto L_0x0096;	 Catch:{ all -> 0x009a }
    L_0x0077:
        r2 = r0.next();	 Catch:{ all -> 0x009a }
        r2 = (java.lang.String) r2;	 Catch:{ all -> 0x009a }
        r3 = r8.instance;	 Catch:{ Exception -> 0x0087 }
        r4 = anet.channel.entity.ConnType.TypeLevel.SPDY;	 Catch:{ Exception -> 0x0087 }
        r5 = 0;	 Catch:{ Exception -> 0x0087 }
        r3.get(r2, r4, r5);	 Catch:{ Exception -> 0x0087 }
        goto L_0x0071;
    L_0x0087:
        r3 = "start session failed";	 Catch:{ all -> 0x009a }
        r4 = 0;	 Catch:{ all -> 0x009a }
        r5 = "host";	 Catch:{ all -> 0x009a }
        r6 = 1;	 Catch:{ all -> 0x009a }
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x009a }
        r7 = 0;	 Catch:{ all -> 0x009a }
        r6[r7] = r2;	 Catch:{ all -> 0x009a }
        anet.channel.util.ALog.e(r3, r4, r5, r6);	 Catch:{ all -> 0x009a }
        goto L_0x0071;	 Catch:{ all -> 0x009a }
    L_0x0096:
        r8.lastKeys = r1;	 Catch:{ all -> 0x009a }
        monitor-exit(r8);
        return;
    L_0x009a:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.AccsSessionManager.checkAndStartSession():void");
    }

    public synchronized void forceReCreateSession() {
        forceCloseSession(true);
    }

    public synchronized void forceCloseSession(boolean z) {
        if (ALog.isPrintLog(1)) {
            ALog.d(TAG, "forceCloseSession", this.instance.seqNum, "reCreate", Boolean.valueOf(z));
        }
        for (String closeSessions : this.lastKeys) {
            closeSessions(closeSessions);
        }
        if (z) {
            checkAndStartSession();
        }
    }

    private boolean isNeedCheckSession() {
        if (GlobalAppRuntimeInfo.isAppBackground()) {
            ALog.d(TAG, "app is background not need check accs session, return", this.instance.seqNum, "bg", Boolean.valueOf(true));
            return false;
        } else if (NetworkStatusHelper.g()) {
            return true;
        } else {
            ALog.d(TAG, "network is not available, not need check accs session, return", this.instance.seqNum, "network", Boolean.valueOf(NetworkStatusHelper.g()));
            return false;
        }
    }

    private void closeSessions(String str) {
        if (!TextUtils.isEmpty(str)) {
            ALog.d(TAG, "closeSessions", this.instance.seqNum, "host", str);
            this.instance.getSessionRequest(str).b(false);
        }
    }
}
