package anet.channel;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import anet.channel.Config.Builder;
import anet.channel.entity.ConnType;
import anet.channel.entity.ConnType.TypeLevel;
import anet.channel.entity.ENV;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener;
import anet.channel.status.NetworkStatusHelper.NetworkStatus;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.k.b;
import anet.channel.strategy.k.c;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anet.channel.util.AppLifecycle.AppLifecycleListener;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import anet.channel.util.Utils;
import anet.channel.util.g;
import java.net.ConnectException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

/* compiled from: Taobao */
public class SessionCenter {
    public static final String TAG = "awcn.SessionCenter";
    static Map<Config, SessionCenter> instancesMap = new HashMap();
    private static boolean mInit = false;
    final AccsSessionManager accsSessionManager;
    final c attributeManager = new c();
    Config config;
    Context context = GlobalAppRuntimeInfo.getContext();
    final a innerListener = new a();
    String seqNum;
    final f sessionPool = new f();
    final LruCache<String, SessionRequest> srCache = new LruCache(32);

    /* compiled from: Taobao */
    private class a implements INetworkStatusChangeListener, IStrategyListener, AppLifecycleListener {
        boolean a;
        final /* synthetic */ SessionCenter b;

        private a(SessionCenter sessionCenter) {
            this.b = sessionCenter;
            this.a = null;
        }

        void a() {
            AppLifecycle.registerLifecycleListener(this);
            NetworkStatusHelper.a((INetworkStatusChangeListener) this);
            StrategyCenter.getInstance().registerListener(this);
        }

        void b() {
            StrategyCenter.getInstance().unregisterListener(this);
            AppLifecycle.unregisterLifecycleListener(this);
            NetworkStatusHelper.b(this);
        }

        public void onNetworkStatusChanged(NetworkStatus networkStatus) {
            ALog.e(SessionCenter.TAG, "onNetworkStatusChanged. reCreateSession", this.b.seqNum, "networkStatus", networkStatus);
            NetworkStatus<SessionRequest> a = this.b.sessionPool.a();
            if (a.isEmpty()) {
                ALog.i(SessionCenter.TAG, "recreate session failed: infos is empty", this.b.seqNum, new Object[0]);
            } else {
                for (SessionRequest sessionRequest : a) {
                    ALog.d(SessionCenter.TAG, "network change, try recreate session", this.b.seqNum, new Object[0]);
                    sessionRequest.a(null);
                }
            }
            this.b.accsSessionManager.checkAndStartSession();
        }

        public void onStrategyUpdated(c cVar) {
            this.b.checkEffectNow(cVar);
            this.b.accsSessionManager.checkAndStartSession();
        }

        public void forground() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r5 = this;
            r0 = "awcn.SessionCenter";
            r1 = "[forground]";
            r2 = r5.b;
            r2 = r2.seqNum;
            r3 = 0;
            r4 = new java.lang.Object[r3];
            anet.channel.util.ALog.i(r0, r1, r2, r4);
            r0 = r5.b;
            r0 = r0.context;
            if (r0 != 0) goto L_0x0015;
        L_0x0014:
            return;
        L_0x0015:
            r0 = r5.a;
            if (r0 == 0) goto L_0x001a;
        L_0x0019:
            return;
        L_0x001a:
            r0 = 1;
            r5.a = r0;
            r0 = anet.channel.SessionCenter.mInit;
            if (r0 != 0) goto L_0x0031;
        L_0x0023:
            r0 = "awcn.SessionCenter";
            r1 = "forground not inited!";
            r2 = r5.b;
            r2 = r2.seqNum;
            r3 = new java.lang.Object[r3];
            anet.channel.util.ALog.e(r0, r1, r2, r3);
            return;
        L_0x0031:
            r0 = new anet.channel.e;	 Catch:{ Exception -> 0x003a }
            r0.<init>(r5);	 Catch:{ Exception -> 0x003a }
            anet.channel.a.c.a(r0);	 Catch:{ Exception -> 0x003a }
            return;
        L_0x003a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: anet.channel.SessionCenter.a.forground():void");
        }

        public void background() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r5 = this;
            r0 = "awcn.SessionCenter";
            r1 = "[background]";
            r2 = r5.b;
            r2 = r2.seqNum;
            r3 = 0;
            r4 = new java.lang.Object[r3];
            anet.channel.util.ALog.i(r0, r1, r2, r4);
            r0 = anet.channel.SessionCenter.mInit;
            if (r0 != 0) goto L_0x0022;
        L_0x0014:
            r0 = "awcn.SessionCenter";
            r1 = "background not inited!";
            r2 = r5.b;
            r2 = r2.seqNum;
            r3 = new java.lang.Object[r3];
            anet.channel.util.ALog.e(r0, r1, r2, r3);
            return;
        L_0x0022:
            r0 = anet.channel.strategy.StrategyCenter.getInstance();	 Catch:{ Exception -> 0x0048 }
            r0.saveData();	 Catch:{ Exception -> 0x0048 }
            r0 = "OPPO";	 Catch:{ Exception -> 0x0048 }
            r1 = android.os.Build.BRAND;	 Catch:{ Exception -> 0x0048 }
            r0 = r0.equalsIgnoreCase(r1);	 Catch:{ Exception -> 0x0048 }
            if (r0 == 0) goto L_0x0047;	 Catch:{ Exception -> 0x0048 }
        L_0x0033:
            r0 = "awcn.SessionCenter";	 Catch:{ Exception -> 0x0048 }
            r1 = "close session for OPPO";	 Catch:{ Exception -> 0x0048 }
            r2 = r5.b;	 Catch:{ Exception -> 0x0048 }
            r2 = r2.seqNum;	 Catch:{ Exception -> 0x0048 }
            r4 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0048 }
            anet.channel.util.ALog.i(r0, r1, r2, r4);	 Catch:{ Exception -> 0x0048 }
            r0 = r5.b;	 Catch:{ Exception -> 0x0048 }
            r0 = r0.accsSessionManager;	 Catch:{ Exception -> 0x0048 }
            r0.forceCloseSession(r3);	 Catch:{ Exception -> 0x0048 }
        L_0x0047:
            return;
        L_0x0048:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: anet.channel.SessionCenter.a.background():void");
        }
    }

    public static synchronized void init(Context context) {
        synchronized (SessionCenter.class) {
            if (context == null) {
                ALog.e(TAG, "paramter context is null!", null, new Object[0]);
                throw new NullPointerException("init failed. paramter context is null");
            }
            GlobalAppRuntimeInfo.setContext(context.getApplicationContext());
            if (mInit == null) {
                instancesMap.put(Config.DEFAULT_CONFIG, new SessionCenter(Config.DEFAULT_CONFIG));
                AppLifecycle.initialize();
                StrategyCenter.getInstance().initialize(GlobalAppRuntimeInfo.getContext());
                mInit = true;
            }
        }
    }

    @Deprecated
    public static synchronized void init(Context context, String str) {
        synchronized (SessionCenter.class) {
            init(context, str, GlobalAppRuntimeInfo.getEnv());
        }
    }

    public static synchronized void init(Context context, String str, ENV env) {
        synchronized (SessionCenter.class) {
            if (context == null) {
                ALog.e(TAG, "paramter context is null!", null, new Object[0]);
                throw new NullPointerException("init failed. paramter context is null");
            }
            Config config = Config.getConfig(str, env);
            if (config == null) {
                config = new Builder().setAppkey(str).setEnv(env).build();
            }
            init(context, config);
        }
    }

    public static synchronized void init(Context context, Config config) {
        synchronized (SessionCenter.class) {
            if (context == null) {
                ALog.e(TAG, "paramter context is null!", null, new Object[0]);
                throw new NullPointerException("init failed. paramter context is null");
            } else if (config == null) {
                ALog.e(TAG, "paramter config is null!", null, new Object[0]);
                throw new NullPointerException("init failed. paramter config is null");
            } else {
                init(context);
                if (instancesMap.containsKey(config) == null) {
                    instancesMap.put(config, new SessionCenter(config));
                }
            }
        }
    }

    private SessionCenter(Config config) {
        this.config = config;
        this.seqNum = config.getAppkey();
        this.innerListener.a();
        this.accsSessionManager = new AccsSessionManager(this);
        if (anet.channel.strategy.dispatch.a.b() == null && !config.getAppkey().equals("[default]")) {
            anet.channel.strategy.dispatch.a.a(new d(this, config.getAppkey(), config.getSecurity()));
        }
    }

    private void dispose() {
        ALog.i(TAG, "instance dispose", this.seqNum, new Object[0]);
        this.accsSessionManager.forceCloseSession(false);
        this.innerListener.b();
    }

    @Deprecated
    public synchronized void switchEnv(ENV env) {
        switchEnvironment(env);
    }

    public static synchronized void switchEnvironment(ENV env) {
        synchronized (SessionCenter.class) {
            try {
                if (GlobalAppRuntimeInfo.getEnv() != env) {
                    ALog.i(TAG, "switch env", null, "old", GlobalAppRuntimeInfo.getEnv(), "new", env);
                    GlobalAppRuntimeInfo.setEnv(env);
                    StrategyCenter.getInstance().switchEnv();
                    SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION).switchAccsServer(env == ENV.TEST ? 0 : 1);
                }
                Iterator it = instancesMap.entrySet().iterator();
                while (it.hasNext()) {
                    SessionCenter sessionCenter = (SessionCenter) ((Entry) it.next()).getValue();
                    if (sessionCenter.config.getEnv() != env) {
                        ALog.i(TAG, "remove instance", sessionCenter.seqNum, "ENVIRONMENT", sessionCenter.config.getEnv());
                        sessionCenter.dispose();
                        it.remove();
                    }
                }
            } catch (ENV env2) {
                ALog.e(TAG, "switch env error.", null, env2, new Object[0]);
            }
        }
    }

    public static synchronized SessionCenter getInstance(String str) {
        synchronized (SessionCenter.class) {
            Config configByTag = Config.getConfigByTag(str);
            if (configByTag == null) {
                throw new RuntimeException("tag not exist!");
            }
            str = getInstance(configByTag);
        }
        return str;
    }

    public static synchronized SessionCenter getInstance(Config config) {
        SessionCenter sessionCenter;
        synchronized (SessionCenter.class) {
            if (config == null) {
                throw new NullPointerException("config is null!");
            }
            if (!mInit) {
                Context appContext = Utils.getAppContext();
                if (appContext != null) {
                    init(appContext);
                }
            }
            sessionCenter = (SessionCenter) instancesMap.get(config);
            if (sessionCenter == null) {
                sessionCenter = new SessionCenter(config);
                instancesMap.put(config, sessionCenter);
            }
        }
        return sessionCenter;
    }

    @Deprecated
    public static synchronized SessionCenter getInstance() {
        synchronized (SessionCenter.class) {
            if (!mInit) {
                Context appContext = Utils.getAppContext();
                if (appContext != null) {
                    init(appContext);
                }
            }
            SessionCenter sessionCenter = null;
            for (Entry entry : instancesMap.entrySet()) {
                SessionCenter sessionCenter2 = (SessionCenter) entry.getValue();
                if (entry.getKey() != Config.DEFAULT_CONFIG) {
                    return sessionCenter2;
                }
                sessionCenter = sessionCenter2;
            }
            return sessionCenter;
        }
    }

    public Session getThrowsException(String str, long j) throws Exception {
        return getThrowsException(str, null, j);
    }

    public Session getThrowsException(String str, TypeLevel typeLevel, long j) throws Exception {
        return getInternal(anet.channel.util.c.a(str), typeLevel, j);
    }

    public Session getThrowsException(anet.channel.util.c cVar, TypeLevel typeLevel, long j) throws Exception {
        return getInternal(cVar, typeLevel, j);
    }

    public Session get(String str, long j) {
        return get(str, null, j);
    }

    public Session get(String str, TypeLevel typeLevel, long j) {
        return get(anet.channel.util.c.a(str), typeLevel, j);
    }

    public anet.channel.Session get(anet.channel.util.c r7, anet.channel.entity.ConnType.TypeLevel r8, long r9) {
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
        r6 = this;
        r0 = 1;
        r1 = 0;
        r2 = 2;
        r8 = r6.getInternal(r7, r8, r9);	 Catch:{ InvalidParameterException -> 0x0087, TimeoutException -> 0x0070, NoNetworkException -> 0x005a, NoAvailStrategyException -> 0x0044, ConnectException -> 0x0021, Exception -> 0x0009 }
        goto L_0x009e;
    L_0x0009:
        r8 = move-exception;
        r9 = "awcn.SessionCenter";
        r10 = "[Get]exception";
        r3 = r6.seqNum;
        r2 = new java.lang.Object[r2];
        r4 = "url";
        r2[r1] = r4;
        r7 = r7.e();
        r2[r0] = r7;
        anet.channel.util.ALog.e(r9, r10, r3, r8, r2);
        goto L_0x009d;
    L_0x0021:
        r8 = move-exception;
        r9 = "awcn.SessionCenter";
        r10 = "[Get]connect exception";
        r3 = r6.seqNum;
        r4 = 4;
        r4 = new java.lang.Object[r4];
        r5 = "errMsg";
        r4[r1] = r5;
        r8 = r8.getMessage();
        r4[r0] = r8;
        r8 = "url";
        r4[r2] = r8;
        r8 = 3;
        r7 = r7.e();
        r4[r8] = r7;
        anet.channel.util.ALog.e(r9, r10, r3, r4);
        goto L_0x009d;
    L_0x0044:
        r8 = "awcn.SessionCenter";
        r9 = "[Get]no strategy";
        r10 = r6.seqNum;
        r2 = new java.lang.Object[r2];
        r3 = "url";
        r2[r1] = r3;
        r7 = r7.e();
        r2[r0] = r7;
        anet.channel.util.ALog.w(r8, r9, r10, r2);
        goto L_0x009d;
    L_0x005a:
        r8 = "awcn.SessionCenter";
        r9 = "[Get]no network";
        r10 = r6.seqNum;
        r2 = new java.lang.Object[r2];
        r3 = "url";
        r2[r1] = r3;
        r7 = r7.e();
        r2[r0] = r7;
        anet.channel.util.ALog.e(r8, r9, r10, r2);
        goto L_0x009d;
    L_0x0070:
        r8 = move-exception;
        r9 = "awcn.SessionCenter";
        r10 = "[Get]timeout exception";
        r3 = r6.seqNum;
        r2 = new java.lang.Object[r2];
        r4 = "url";
        r2[r1] = r4;
        r7 = r7.e();
        r2[r0] = r7;
        anet.channel.util.ALog.e(r9, r10, r3, r8, r2);
        goto L_0x009d;
    L_0x0087:
        r8 = move-exception;
        r9 = "awcn.SessionCenter";
        r10 = "[Get]param url is invaild";
        r3 = r6.seqNum;
        r2 = new java.lang.Object[r2];
        r4 = "url";
        r2[r1] = r4;
        r7 = r7.e();
        r2[r0] = r7;
        anet.channel.util.ALog.e(r9, r10, r3, r8, r2);
    L_0x009d:
        r8 = 0;
    L_0x009e:
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.SessionCenter.get(anet.channel.util.c, anet.channel.entity.ConnType$TypeLevel, long):anet.channel.Session");
    }

    public void registerSessionInfo(SessionInfo sessionInfo) {
        this.attributeManager.a(sessionInfo);
        if (sessionInfo.isKeepAlive != null) {
            this.accsSessionManager.checkAndStartSession();
        }
    }

    public void unregisterSessionInfo(String str) {
        if (this.attributeManager.a(str).isKeepAlive != null) {
            this.accsSessionManager.checkAndStartSession();
        }
    }

    public void registerPublicKey(String str, int i) {
        this.attributeManager.a(str, i);
    }

    public static void checkAndStartAccsSession() {
        for (SessionCenter sessionCenter : instancesMap.values()) {
            sessionCenter.accsSessionManager.checkAndStartSession();
        }
    }

    public void forceRecreateAccsSession() {
        this.accsSessionManager.forceReCreateSession();
    }

    protected Session getInternal(anet.channel.util.c cVar, TypeLevel typeLevel, long j) throws Exception {
        if (!mInit) {
            ALog.e(TAG, "getInternal not inited!", this.seqNum, new Object[0]);
            return null;
        } else if (cVar == null) {
            return null;
        } else {
            ALog.d(TAG, "getInternal", this.seqNum, "u", cVar.e(), "TypeClass", typeLevel, com.alipay.sdk.data.a.f, Long.valueOf(j));
            String cNameByHost = StrategyCenter.getInstance().getCNameByHost(cVar.b());
            if (cNameByHost == null) {
                cNameByHost = cVar.b();
            }
            String a = cVar.a();
            if (!cVar.h()) {
                a = StrategyCenter.getInstance().getSchemeByHost(cNameByHost, a);
            }
            SessionRequest sessionRequest = getSessionRequest(StringUtils.concatString(a, HttpConstant.SCHEME_SPLIT, cNameByHost));
            Session a2 = this.sessionPool.a(sessionRequest, typeLevel);
            if (a2 != null) {
                ALog.d(TAG, "get internal hit cache session", this.seqNum, "session", a2);
            } else if (this.config == Config.DEFAULT_CONFIG && typeLevel == TypeLevel.SPDY) {
                return null;
            } else {
                if (GlobalAppRuntimeInfo.isAppBackground() && typeLevel == TypeLevel.SPDY && a.a()) {
                    cVar = this.attributeManager.b(cVar.b());
                    if (!(cVar == null || cVar.isAccs == null)) {
                        ALog.w(TAG, "app background, forbid to create accs session", this.seqNum, new Object[0]);
                        throw new ConnectException("accs session connecting forbidden in background");
                    }
                }
                sessionRequest.a(this.context, typeLevel, g.a(this.seqNum));
                if (j > 0 && sessionRequest.b() == typeLevel) {
                    sessionRequest.a(j);
                    a2 = this.sessionPool.a(sessionRequest, typeLevel);
                    if (a2 == null) {
                        throw new ConnectException("session connecting failed or timeout");
                    }
                }
            }
            return a2;
        }
    }

    @Deprecated
    public void enterBackground() {
        AppLifecycle.onBackground();
    }

    @Deprecated
    public void enterForeground() {
        AppLifecycle.onForeground();
    }

    private void checkEffectNow(c cVar) {
        SessionCenter sessionCenter = this;
        b[] bVarArr = cVar.c;
        int i = 0;
        int i2 = 0;
        while (i2 < bVarArr.length) {
            b bVar = bVarArr[i2];
            if (bVar.l) {
                ALog.i(TAG, "find effectNow", sessionCenter.seqNum, "host", bVar.a);
                anet.channel.strategy.k.a[] aVarArr = bVar.g;
                String[] strArr = bVar.e;
                for (Session session : sessionCenter.sessionPool.a(getSessionRequest(StringUtils.buildKey(bVar.c, bVar.a)))) {
                    if (!session.getConnType().isHttpType()) {
                        int i3;
                        boolean z;
                        for (i3 = i; i3 < strArr.length; i3++) {
                            if (session.getIp().equals(strArr[i3])) {
                                z = true;
                                break;
                            }
                        }
                        z = i;
                        if (z) {
                            i3 = i;
                            while (i3 < aVarArr.length) {
                                if (session.getPort() == aVarArr[i3].a && session.getConnType().equals(ConnType.valueOf(ConnProtocol.valueOf(aVarArr[i3])))) {
                                    z = true;
                                    break;
                                }
                                i3++;
                            }
                            z = i;
                            if (z) {
                                ALog.i(TAG, "session matches, do nothing", null, new Object[0]);
                                i = 0;
                            } else {
                                if (ALog.isPrintLog(2)) {
                                    ALog.i(TAG, "aisle not match", sessionCenter.seqNum, "port", Integer.valueOf(session.getPort()), "connType", session.getConnType(), "aisle", Arrays.toString(aVarArr));
                                }
                                session.close(true);
                                i = 0;
                            }
                        } else {
                            if (ALog.isPrintLog(2)) {
                                ALog.i(TAG, "ip not match", sessionCenter.seqNum, "session ip", session.getIp(), "ips", Arrays.toString(strArr));
                            }
                            session.close(true);
                        }
                    }
                }
            }
            i2++;
            i = i;
        }
    }

    protected SessionRequest getSessionRequest(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SessionRequest sessionRequest;
        synchronized (this.srCache) {
            sessionRequest = (SessionRequest) this.srCache.get(str);
            if (sessionRequest == null) {
                sessionRequest = new SessionRequest(str, this);
                this.srCache.put(str, sessionRequest);
            }
        }
        return sessionRequest;
    }
}
