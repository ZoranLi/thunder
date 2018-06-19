package com.taobao.accs.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.a.a.a;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.IBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.Constants.Operate;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.net.r;
import com.taobao.accs.ut.monitor.ElectionRateMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.l;
import com.xunlei.download.DownloadManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
public abstract class b implements IBaseService {
    public static final String ELECTION_KEY_BLACKLIST = "blacklist";
    public static final String ELECTION_KEY_HOST = "host";
    public static final String ELECTION_KEY_SDKVS = "sdkvs";
    public static final String ELECTION_KEY_VERSION = "elversion";
    public static final String ELECTION_SERVICE_ID = "accs_election";
    public static final int ELE_ERROR_EXCEPTION = -901;
    public static final int ELE_ERROR_SERVER = -900;
    public static final int ELE_LIST_NULL = -902;
    protected static ConcurrentHashMap<String, com.taobao.accs.net.b> a = new ConcurrentHashMap(2);
    private static int g = 0;
    private static boolean h = false;
    private Context b;
    private boolean c = false;
    private boolean d = true;
    private Map<String, Integer> e = null;
    private ScheduledThreadPoolExecutor f;
    private Service i = null;
    private ElectionRateMonitor j;
    private ElectionRateMonitor k;
    private ScheduledFuture<?> l;
    private ScheduledFuture<?> m;
    private AccsAbstractDataListener n = new c(this);
    private a o;
    private boolean p = false;
    private boolean q = false;
    private ScheduledFuture<?> r;

    public abstract int a(Intent intent);

    public abstract void a();

    public IBinder onBind(Intent intent) {
        return null;
    }

    public boolean onUnbind(Intent intent) {
        return false;
    }

    public b(Service service) {
        this.i = service;
        this.b = service.getApplicationContext();
        this.e = new HashMap();
        this.f = ThreadPoolExecutorFactory.getScheduledExecutor();
        AppMonitor.getInstance().register(ElectionRateMonitor.class);
    }

    public void onCreate() {
        ALog.i("ElectionServiceImpl", "onCreate,", new Object[]{"sdkv", Integer.valueOf(221)});
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        b bVar = this;
        Intent intent2 = intent;
        if (intent2 == null) {
            return 2;
        }
        CharSequence action = intent.getAction();
        CharSequence packageName = bVar.b.getPackageName();
        ALog.i("ElectionServiceImpl", "onStartCommand begin", new Object[]{"action", action});
        if (com.taobao.accs.a.a.b()) {
            try {
                if (TextUtils.equals(action, "android.intent.action.PACKAGE_REMOVED")) {
                    packageName = intent.getData().getSchemeSpecificPart();
                    boolean booleanExtra = intent2.getBooleanExtra("android.intent.extra.REPLACING", false);
                    a a = com.taobao.accs.a.a.a(bVar.b);
                    CharSequence charSequence = a.a;
                    ALog.w("ElectionServiceImpl", "onstartcommand PACKAGE_REMOVED", new Object[]{Constants.KEY_ELECTION_PKG, packageName, "host", charSequence, "replaced", Boolean.valueOf(booleanExtra)});
                    if (TextUtils.isEmpty(charSequence) || !TextUtils.equals(charSequence, packageName)) {
                        ALog.i("ElectionServiceImpl", "onstartcommand PACKAGE_REMOVED no need election", new Object[0]);
                    } else if (bVar.b.getPackageName().equals(com.taobao.accs.a.a.e(bVar.b))) {
                        a.b = 0;
                        com.taobao.accs.a.a.a(bVar.b, a);
                        a(bVar.b, "host removed");
                    } else {
                        ALog.i("ElectionServiceImpl", "onstartcommand PACKAGE_REMOVED no need election", new Object[0]);
                    }
                } else if (TextUtils.equals(action, com.taobao.accs.a.a.c())) {
                    ALog.i("ElectionServiceImpl", "operate is receive", new Object[]{"operate", (Operate) intent2.getSerializableExtra("operate")});
                    int i3 = 221;
                    String stringExtra;
                    int intExtra;
                    Intent intent3;
                    CharSequence stringExtra2;
                    switch ((Operate) intent2.getSerializableExtra("operate")) {
                        case TRY_ELECTION:
                            d();
                            break;
                        case START_ELECTION:
                            a(bVar.b, intent2.getStringExtra(DownloadManager.COLUMN_REASON));
                            break;
                        case ASK_VERSION:
                            stringExtra = intent2.getStringExtra(Constants.KEY_PACKAGE_NAME);
                            intExtra = intent2.getIntExtra(ELECTION_KEY_VERSION, 0);
                            intent3 = new Intent(com.taobao.accs.a.a.c());
                            intent3.putExtra("operate", Operate.REPORT_VERSION);
                            intent3.putExtra(Constants.KEY_PACKAGE_NAME, bVar.b.getPackageName());
                            intent3.setPackage(stringExtra);
                            intent3.setClassName(stringExtra, com.taobao.accs.utl.a.channelService);
                            if (com.taobao.accs.a.a.a(bVar.b, bVar.b.getPackageName(), intExtra)) {
                                intent3.putExtra(Constants.KEY_SDK_VERSION, 221);
                            } else {
                                i3 = 0;
                            }
                            bVar.b.startService(intent3);
                            ALog.i("ElectionServiceImpl", AgooConstants.MESSAGE_REPORT, new Object[]{"sdkv", Integer.valueOf(i3), "from pkg", bVar.b.getPackageName(), "to pkg", stringExtra});
                            break;
                        case REPORT_VERSION:
                            if (!bVar.c) {
                                ALog.e("ElectionServiceImpl", "not electioning, but receive report", new Object[0]);
                                break;
                            }
                            stringExtra = intent2.getStringExtra(Constants.KEY_PACKAGE_NAME);
                            intExtra = intent2.getIntExtra(Constants.KEY_SDK_VERSION, 0);
                            g--;
                            if (intExtra != 0) {
                                bVar.e.put(stringExtra, Integer.valueOf(intExtra));
                            }
                            ALog.i("ElectionServiceImpl", "collect info", new Object[]{"sdkv", Integer.valueOf(intExtra), "election pkg", stringExtra, "electionPackCount", Integer.valueOf(g)});
                            if (g == 0) {
                                e();
                                break;
                            }
                            break;
                        case RESULT_ELECTION:
                            bVar.d = true;
                            if (bVar.m != null) {
                                bVar.m.cancel(true);
                                bVar.m = null;
                            }
                            stringExtra2 = intent2.getStringExtra("sudoPack");
                            ALog.i("ElectionServiceImpl", "election result", new Object[]{"host", stringExtra2, "curr pkg", packageName});
                            com.taobao.accs.utl.b.a("accs", BaseMonitor.COUNT_ELECTION_PKG_TIMES, stringExtra2, 0.0d);
                            com.taobao.accs.a.a.b(bVar.b);
                            if (!TextUtils.isEmpty(stringExtra2)) {
                                if (!TextUtils.equals(stringExtra2, packageName)) {
                                    a(true);
                                    break;
                                }
                                a();
                                break;
                            }
                            break;
                        case PING_ELECTION:
                            stringExtra2 = com.taobao.accs.a.a.a(bVar.b).a;
                            CharSequence stringExtra3 = intent2.getStringExtra("pingPack");
                            if (!(TextUtils.isEmpty(stringExtra2) || TextUtils.isEmpty(stringExtra3) || !TextUtils.equals(stringExtra2, packageName))) {
                                ALog.i("ElectionServiceImpl", "host receive ping, and report ping", new Object[]{"to pkg", stringExtra3, "host", stringExtra2});
                                intent3 = new Intent(com.taobao.accs.a.a.c());
                                intent3.setPackage(stringExtra3);
                                intent3.setClassName(stringExtra3, com.taobao.accs.utl.a.channelService);
                                intent3.putExtra("operate", Operate.PING_ELECTION);
                                intent3.putExtra("isPing", true);
                                intent3.putExtra("pingPack", stringExtra3);
                                intent3.putExtra(Constants.KEY_SDK_VERSION, 221);
                                bVar.b.startService(intent3);
                                a();
                            }
                            if (TextUtils.equals(stringExtra3, packageName)) {
                                ALog.i("ElectionServiceImpl", "receive host's ping back", new Object[]{"host", stringExtra2});
                                h = intent2.getBooleanExtra("isPing", false);
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                    return 2;
                }
            } catch (Throwable th) {
                ALog.e("ElectionServiceImpl", "onStartCommand", th, new Object[0]);
            }
        } else if (TextUtils.equals(action, com.taobao.accs.a.a.c())) {
            ALog.e("ElectionServiceImpl", "election disabled", new Object[0]);
            return 2;
        }
        if (TextUtils.equals(action, Constants.ACTION_START_SERVICE)) {
            try {
                Object stringExtra4 = intent2.getStringExtra(Constants.KEY_PACKAGE_NAME);
                Object stringExtra5 = intent2.getStringExtra("appKey");
                String stringExtra6 = intent2.getStringExtra(Constants.KEY_TTID);
                String stringExtra7 = intent2.getStringExtra("app_sercet");
                String stringExtra8 = intent2.getStringExtra(Constants.KEY_CONFIG_TAG);
                int intExtra2 = intent2.getIntExtra(Constants.KEY_MODE, 0);
                ALog.i("ElectionServiceImpl", "try to saveAppKey", new Object[]{Constants.KEY_CONFIG_TAG, stringExtra8, "appkey", stringExtra5, "appSecret", stringExtra7, Constants.KEY_TTID, stringExtra6, Constants.KEY_ELECTION_PKG, stringExtra4});
                if (!(TextUtils.isEmpty(stringExtra4) || TextUtils.isEmpty(stringExtra5) || !stringExtra4.equals(bVar.b.getPackageName()))) {
                    l.a(bVar.b, intExtra2);
                    com.taobao.accs.net.b a2 = a(bVar.b, stringExtra8, false, -1);
                    if (a2 != null) {
                        a2.a = stringExtra6;
                    } else {
                        ALog.e("ElectionServiceImpl", "start action, no connection", new Object[]{Constants.KEY_CONFIG_TAG, stringExtra8});
                    }
                    UtilityImpl.saveAppKey(bVar.b, stringExtra5, stringExtra7);
                }
            } catch (Throwable th2) {
                ALog.e("ElectionServiceImpl", "start action", th2, new Object[0]);
            }
            if (com.taobao.accs.a.a.b()) {
                return 2;
            }
        }
        packageName = com.taobao.accs.a.a.a(bVar.b).a;
        if (!(TextUtils.isEmpty(packageName) || TextUtils.equals(packageName, bVar.b.getPackageName()))) {
            if (com.taobao.accs.a.a.b()) {
                if (!(bVar.c || TextUtils.equals(action, "android.intent.action.PACKAGE_REMOVED"))) {
                    ALog.i("ElectionServiceImpl", "not electioning and not host, stop", new Object[0]);
                    a(true);
                }
                return 2;
            }
        }
        ALog.i("ElectionServiceImpl", "deliver to channelservice", new Object[]{"host pkg", packageName});
        return a(intent);
    }

    public void onDestroy() {
        ALog.e("ElectionServiceImpl", "Service onDestroy", new Object[0]);
        this.b = null;
        this.i = null;
    }

    private String c() {
        int i;
        Object obj;
        Throwable th;
        Throwable th2;
        Object th3;
        String a;
        CharSequence charSequence = null;
        try {
            if (this.e == null || this.e.size() <= 0) {
                i = ELE_LIST_NULL;
                try {
                    obj = "apps is null";
                } catch (Throwable th4) {
                    th2 = th4;
                    obj = null;
                    if (this.k != null) {
                        if (TextUtils.isEmpty(obj)) {
                            this.k.errorCode = i;
                            this.k.errorMsg = obj;
                        }
                        this.k.ret = TextUtils.isEmpty(charSequence) ^ 1;
                        AppMonitor.getInstance().commitStat(this.k);
                    }
                    throw th2;
                }
            }
            obj = null;
            a = com.taobao.accs.a.a.a(this.b, this.e);
            i = 0;
            try {
                ALog.i("ElectionServiceImpl", "localElection", new Object[]{"host", a});
                if (this.k != null) {
                    if (!TextUtils.isEmpty(obj)) {
                        this.k.errorCode = i;
                        this.k.errorMsg = obj;
                    }
                    this.k.ret = TextUtils.isEmpty(a) ^ 1;
                    AppMonitor.getInstance().commitStat(this.k);
                }
            } catch (Throwable th5) {
                th = th5;
                ALog.e("ElectionServiceImpl", "localElection error", th, new Object[0]);
                th3 = th.toString();
                if (this.k != null) {
                    if (TextUtils.isEmpty(th3)) {
                        this.k.errorCode = ELE_ERROR_EXCEPTION;
                        this.k.errorMsg = th3;
                    }
                    this.k.ret = TextUtils.isEmpty(a) ^ 1;
                    AppMonitor.getInstance().commitStat(this.k);
                }
                return a;
            }
        } catch (Throwable th6) {
            th2 = th6;
            obj = null;
            i = 0;
            if (this.k != null) {
                if (TextUtils.isEmpty(obj)) {
                    this.k.errorCode = i;
                    this.k.errorMsg = obj;
                }
                this.k.ret = TextUtils.isEmpty(charSequence) ^ 1;
                AppMonitor.getInstance().commitStat(this.k);
            }
            throw th2;
        }
        return a;
    }

    private void a(Map<String, Integer> map) {
        ALog.i("ElectionServiceImpl", "serverElection start", new Object[]{Constants.KEY_ELECTION_PACKS, map.toString()});
        this.j = new ElectionRateMonitor();
        try {
            this.j.type = "server";
            if (this.k != null) {
                this.j.reason = this.k.reason;
            }
            GlobalClientInfo.getInstance(this.b).registerListener(ELECTION_SERVICE_ID, this.n);
            Intent intent = new Intent();
            intent.setAction(Constants.ACTION_COMMAND);
            intent.putExtra(Constants.KEY_PACKAGE_NAME, this.b.getPackageName());
            intent.putExtra("command", 105);
            intent.putExtra(Constants.KEY_ELECTION_PACKS, (HashMap) map);
            a(intent);
        } catch (Map<String, Integer> map2) {
            this.j.errorCode = ELE_ERROR_EXCEPTION;
            this.j.errorMsg = map2.toString();
        }
    }

    protected static com.taobao.accs.net.b a(Context context, String str, boolean z, int i) {
        com.taobao.accs.net.b bVar = null;
        try {
            if (TextUtils.isEmpty(str)) {
                ALog.i("ElectionServiceImpl", "getConnection configTag null or env invalid", new Object[]{"command", Integer.valueOf(i), "conns:", Integer.valueOf(a.size())});
                return a.size() > null ? (com.taobao.accs.net.b) a.elements().nextElement() : null;
            }
            ALog.i("ElectionServiceImpl", "getConnection", new Object[]{Constants.KEY_CONFIG_TAG, str});
            i = AccsClientConfig.getConfigByTag(str);
            if (i == 0 || i.getDisableChannel() == 0) {
                i = l.a(context);
                StringBuilder stringBuilder = new StringBuilder(str);
                stringBuilder.append("|");
                stringBuilder.append(i);
                String stringBuilder2 = stringBuilder.toString();
                com.taobao.accs.net.b bVar2 = (com.taobao.accs.net.b) a.get(stringBuilder2);
                if (bVar2 == null) {
                    try {
                        AccsClientConfig.mEnv = i;
                        bVar = new r(context, 0, str);
                        if (z) {
                            bVar.a();
                        }
                        if (a.size() < 10) {
                            a.put(stringBuilder2, bVar);
                        } else {
                            ALog.e("ElectionServiceImpl", "to many conns!!!", new Object[0]);
                        }
                    } catch (Throwable th) {
                        context = th;
                        bVar = bVar2;
                        ALog.e("ElectionServiceImpl", "getConnection", context, new Object[0]);
                        return bVar;
                    }
                }
                bVar = bVar2;
                return bVar;
            }
            ALog.e("ElectionServiceImpl", "channel disabled!", new Object[]{Constants.KEY_CONFIG_TAG, str});
            return null;
        } catch (Throwable th2) {
            context = th2;
            ALog.e("ElectionServiceImpl", "getConnection", context, new Object[0]);
            return bVar;
        }
    }

    private void d() {
        String str;
        try {
            if (UtilityImpl.isFirstStart(this.b)) {
                b(this.b, "first start");
                UtilityImpl.setSdkStart(this.b);
                return;
            }
            str = com.taobao.accs.a.a.a(this.b).a;
            Object packageName = this.b.getPackageName();
            ALog.i("ElectionServiceImpl", "tryElection begin", new Object[]{"isFirstStart", Boolean.valueOf(UtilityImpl.isFirstStart(this.b)), "currentPack", packageName, "currentElectionPack", str});
            if (TextUtils.isEmpty(str)) {
                ALog.i("ElectionServiceImpl", "host is empty, try selectAppToElection", new Object[0]);
                b(this.b, "host null");
            } else if (TextUtils.equals(str, packageName)) {
                ALog.i("ElectionServiceImpl", "curr is host, no need election", new Object[0]);
                a();
            } else {
                try {
                    Intent intent = new Intent(com.taobao.accs.a.a.c());
                    intent.setPackage(str);
                    intent.putExtra("operate", Operate.PING_ELECTION);
                    intent.setClassName(str, com.taobao.accs.utl.a.channelService);
                    intent.putExtra("pingPack", packageName);
                    this.b.startService(intent);
                    ALog.i("ElectionServiceImpl", "tryElection send PING_ELECTION", new Object[]{"to pkg", str});
                    this.f.schedule(new d(this, str), 5, TimeUnit.SECONDS);
                } catch (Throwable th) {
                    ALog.e("ElectionServiceImpl", "tryElection startService error", new Object[]{"currentElectionPack", str, th});
                    this.f.schedule(new d(this, str), 5, TimeUnit.SECONDS);
                }
            }
        } catch (Throwable th2) {
            ALog.e("ElectionServiceImpl", "tryElection error", th2, new Object[0]);
        }
    }

    private void b(Context context, String str) {
        String e = com.taobao.accs.a.a.e(context);
        ALog.i("ElectionServiceImpl", "selectAppToElection", new Object[]{Constants.KEY_ELECTION_PKG, e});
        com.taobao.accs.a.a.b = false;
        this.d = false;
        Intent intent = new Intent(com.taobao.accs.a.a.c());
        if (TextUtils.isEmpty(e)) {
            intent.putExtra("operate", Operate.START_ELECTION);
            intent.putExtra(DownloadManager.COLUMN_REASON, str);
            intent.setPackage(context.getPackageName());
            intent.setClassName(context.getPackageName(), com.taobao.accs.utl.a.channelService);
        } else {
            intent.putExtra("operate", Operate.START_ELECTION);
            intent.putExtra(DownloadManager.COLUMN_REASON, str);
            intent.setPackage(e);
            intent.setClassName(e, com.taobao.accs.utl.a.channelService);
        }
        if (this.m != null) {
            this.m.cancel(true);
            this.m = null;
        }
        this.m = this.f.schedule(new e(this, context), 30, TimeUnit.SECONDS);
        context.startService(intent);
    }

    public void a(Context context, String str) {
        try {
            if (this.c) {
                ALog.w("ElectionServiceImpl", "isElectioning return", new Object[0]);
                return;
            }
            this.o = com.taobao.accs.a.a.a(context);
            if (this.o.b > 20) {
                ALog.w("ElectionServiceImpl", "startElection too many times, return", new Object[]{"times", Integer.valueOf(this.o.b)});
                String str2 = BaseMonitor.COUNT_ELECTION_OVER_MAX;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(UtilityImpl.getDeviceId(context));
                com.taobao.accs.utl.b.a("accs", str2, stringBuilder.toString(), 0.0d);
                return;
            }
            String str3;
            this.k = new ElectionRateMonitor();
            this.k.type = AgooConstants.MESSAGE_LOCAL;
            this.k.reason = str;
            com.taobao.accs.utl.b.a("accs", BaseMonitor.COUNT_ELECTION_START_TIMES, str, 0.0d);
            String<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(com.taobao.accs.a.a.c()), 32);
            this.c = true;
            if (queryIntentServices != null) {
                if (queryIntentServices.size() >= 2) {
                    g = 0;
                    ALog.i("ElectionServiceImpl", "startElection begin", new Object[]{"locallist", queryIntentServices.toString(), "size", Integer.valueOf(queryIntentServices.size())});
                    for (ResolveInfo resolveInfo : queryIntentServices) {
                        if (!(resolveInfo == null || resolveInfo.serviceInfo == null)) {
                            str3 = resolveInfo.serviceInfo.packageName;
                            if (TextUtils.isEmpty(str3)) {
                                ALog.i("ElectionServiceImpl", "startElection unvailable app", new Object[]{Constants.KEY_ELECTION_PKG, str3});
                            } else {
                                Intent intent = new Intent(com.taobao.accs.a.a.c());
                                intent.putExtra("operate", Operate.ASK_VERSION);
                                intent.setPackage(str3);
                                intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
                                intent.putExtra(ELECTION_KEY_VERSION, 1);
                                intent.setClassName(str3, com.taobao.accs.utl.a.channelService);
                                ALog.i("ElectionServiceImpl", "startElection askversion", new Object[]{"receive pkg", str3});
                                context.startService(intent);
                                g++;
                            }
                        }
                    }
                    this.p = false;
                    this.l = this.f.schedule(new f(this), 3, TimeUnit.SECONDS);
                    return;
                }
            }
            context = "ElectionServiceImpl";
            str3 = "startElection apps < 2";
            Object[] objArr = new Object[2];
            objArr[0] = "services";
            objArr[1] = queryIntentServices == null ? "null" : queryIntentServices.toString();
            ALog.i(context, str3, objArr);
            e();
        } catch (Context context2) {
            ALog.e("ElectionServiceImpl", "startElection error", context2, new Object[0]);
            this.c = false;
            if (this.k != null) {
                this.k.errorCode = ELE_ERROR_EXCEPTION;
                this.k.errorMsg = context2.toString();
            }
        }
    }

    private void e() {
        try {
            if (this.l != null) {
                this.l.cancel(true);
                this.l = null;
            }
            if (this.p) {
                ALog.i("ElectionServiceImpl", "reportcompleted, return", new Object[0]);
                return;
            }
            this.p = true;
            ALog.i("ElectionServiceImpl", "onReportComplete", new Object[0]);
            if (this.e == null) {
                this.e = new HashMap();
            }
            this.e.put(this.b.getPackageName(), Integer.valueOf(221));
            if (this.e.size() == 1) {
                String str = ((String[]) this.e.keySet().toArray(new String[0]))[0];
                if (this.k != null) {
                    this.k.ret = 1 ^ TextUtils.isEmpty(str);
                    AppMonitor.getInstance().commitStat(this.k);
                }
                a(str);
            } else {
                a(this.e);
                this.q = false;
                this.r = this.f.schedule(new g(this), 20, TimeUnit.SECONDS);
            }
            this.c = false;
        } catch (Throwable th) {
            if (this.k != null) {
                this.k.errorCode = ELE_ERROR_EXCEPTION;
                this.k.errorMsg = th.toString();
            }
            ALog.e("ElectionServiceImpl", "onReportComplete", th, new Object[0]);
        } finally {
            this.c = false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(byte[] r9, int r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.taobao.accs.internal.b.a(byte[], int):void. bs: [B:8:0x001b, B:26:0x0061]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
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
        r8 = this;
        r0 = r8.q;
        r1 = 0;
        if (r0 == 0) goto L_0x000f;
    L_0x0005:
        r9 = "ElectionServiceImpl";
        r10 = "server election handled, return";
        r0 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.i(r9, r10, r0);
        return;
    L_0x000f:
        r0 = 1;
        r8.q = r0;
        r2 = 0;
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r4 = 2;
        if (r10 != r3) goto L_0x0061;
    L_0x0018:
        if (r9 != 0) goto L_0x001b;
    L_0x001a:
        goto L_0x0061;
    L_0x001b:
        r10 = new java.lang.String;	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        r10.<init>(r9);	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        r3 = "ElectionServiceImpl";	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        r5 = "handleServerElectionResult";	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        r6 = "json";	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        r4[r1] = r6;	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        r4[r0] = r10;	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        com.taobao.accs.utl.ALog.i(r3, r5, r4);	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        r3 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        r3.<init>(r10);	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        r10 = "host";	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        r10 = r3.getString(r10);	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        r2 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Throwable -> 0x005e, all -> 0x005c }
        r4 = "blacklist";	 Catch:{ Throwable -> 0x005e, all -> 0x0059 }
        r3 = r3.getJSONArray(r4);	 Catch:{ Throwable -> 0x005e, all -> 0x0059 }
        if (r3 == 0) goto L_0x0052;	 Catch:{ Throwable -> 0x005e, all -> 0x0059 }
    L_0x0046:
        r3 = r3.length();	 Catch:{ Throwable -> 0x005e, all -> 0x0059 }
        if (r3 <= 0) goto L_0x0052;	 Catch:{ Throwable -> 0x005e, all -> 0x0059 }
    L_0x004c:
        r3 = r8.b;	 Catch:{ Throwable -> 0x005e, all -> 0x0059 }
        com.taobao.accs.a.a.a(r3, r9);	 Catch:{ Throwable -> 0x005e, all -> 0x0059 }
        goto L_0x0057;	 Catch:{ Throwable -> 0x005e, all -> 0x0059 }
    L_0x0052:
        r9 = r8.b;	 Catch:{ Throwable -> 0x005e, all -> 0x0059 }
        com.taobao.accs.a.a.c(r9);	 Catch:{ Throwable -> 0x005e, all -> 0x0059 }
    L_0x0057:
        r9 = r2;
        goto L_0x008a;
    L_0x0059:
        r9 = move-exception;
        goto L_0x00e2;
    L_0x005c:
        r9 = move-exception;
        goto L_0x00b0;
    L_0x005e:
        r9 = move-exception;
        r2 = r10;
        goto L_0x00b3;
    L_0x0061:
        r9 = "ElectionServiceImpl";	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        r3 = "handleServerElectionResult fail, start local election";	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        r5 = "error";	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        r4[r1] = r5;	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        r5 = java.lang.Integer.valueOf(r10);	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        r4[r0] = r5;	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        com.taobao.accs.utl.ALog.e(r9, r3, r4);	 Catch:{ Throwable -> 0x00b2, all -> 0x00ae }
        r9 = 201; // 0xc9 float:2.82E-43 double:9.93E-322;
        if (r10 == r9) goto L_0x007a;
    L_0x0078:
        r9 = r0;
        goto L_0x007b;
    L_0x007a:
        r9 = r1;
    L_0x007b:
        r3 = r8.j;	 Catch:{ Throwable -> 0x00b2, all -> 0x00a8 }
        if (r3 == 0) goto L_0x0089;	 Catch:{ Throwable -> 0x00b2, all -> 0x00a8 }
    L_0x007f:
        r3 = r8.j;	 Catch:{ Throwable -> 0x00b2, all -> 0x00a8 }
        r3.errorCode = r10;	 Catch:{ Throwable -> 0x00b2, all -> 0x00a8 }
        r10 = r8.j;	 Catch:{ Throwable -> 0x00b2, all -> 0x00a8 }
        r3 = "server status error";	 Catch:{ Throwable -> 0x00b2, all -> 0x00a8 }
        r10.errorMsg = r3;	 Catch:{ Throwable -> 0x00b2, all -> 0x00a8 }
    L_0x0089:
        r10 = r2;
    L_0x008a:
        if (r9 == 0) goto L_0x0090;
    L_0x008c:
        r10 = r8.c();
    L_0x0090:
        r8.a(r10);
        r10 = r8.j;
        if (r10 == 0) goto L_0x00de;
    L_0x0097:
        r10 = r8.j;
        if (r9 == 0) goto L_0x009c;
    L_0x009b:
        r0 = r1;
    L_0x009c:
        r10.ret = r0;
    L_0x009e:
        r9 = anet.channel.appmonitor.AppMonitor.getInstance();
        r10 = r8.j;
        r9.commitStat(r10);
        return;
    L_0x00a8:
        r10 = move-exception;
        r7 = r2;
        r2 = r9;
        r9 = r10;
        r10 = r7;
        goto L_0x00e2;
    L_0x00ae:
        r9 = move-exception;
        r10 = r2;
    L_0x00b0:
        r2 = r1;
        goto L_0x00e2;
    L_0x00b2:
        r9 = move-exception;
    L_0x00b3:
        r10 = "ElectionServiceImpl";	 Catch:{ all -> 0x00df }
        r3 = "handleServerElectionResult";	 Catch:{ all -> 0x00df }
        r4 = new java.lang.Object[r1];	 Catch:{ all -> 0x00df }
        com.taobao.accs.utl.ALog.e(r10, r3, r9, r4);	 Catch:{ all -> 0x00df }
        r10 = r8.j;	 Catch:{ all -> 0x00df }
        if (r10 == 0) goto L_0x00ce;	 Catch:{ all -> 0x00df }
    L_0x00c0:
        r10 = r8.j;	 Catch:{ all -> 0x00df }
        r3 = -901; // 0xfffffffffffffc7b float:NaN double:NaN;	 Catch:{ all -> 0x00df }
        r10.errorCode = r3;	 Catch:{ all -> 0x00df }
        r10 = r8.j;	 Catch:{ all -> 0x00df }
        r9 = r9.toString();	 Catch:{ all -> 0x00df }
        r10.errorMsg = r9;	 Catch:{ all -> 0x00df }
    L_0x00ce:
        r9 = r8.c();
        r8.a(r9);
        r9 = r8.j;
        if (r9 == 0) goto L_0x00de;
    L_0x00d9:
        r9 = r8.j;
        r9.ret = r1;
        goto L_0x009e;
    L_0x00de:
        return;
    L_0x00df:
        r9 = move-exception;
        r10 = r2;
        r2 = r0;
    L_0x00e2:
        if (r2 == 0) goto L_0x00e8;
    L_0x00e4:
        r10 = r8.c();
    L_0x00e8:
        r8.a(r10);
        r10 = r8.j;
        if (r10 == 0) goto L_0x00ff;
    L_0x00ef:
        r10 = r8.j;
        if (r2 == 0) goto L_0x00f4;
    L_0x00f3:
        r0 = r1;
    L_0x00f4:
        r10.ret = r0;
        r10 = anet.channel.appmonitor.AppMonitor.getInstance();
        r0 = r8.j;
        r10.commitStat(r0);
    L_0x00ff:
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.internal.b.a(byte[], int):void");
    }

    private void a(String str) {
        try {
            if (this.o == null) {
                this.o = com.taobao.accs.a.a.a(this.b);
            }
            this.o.a = str;
            a aVar = this.o;
            aVar.b++;
            com.taobao.accs.a.a.a(this.b, this.o);
            ALog.i("ElectionServiceImpl", "handleResult notify result", new Object[]{"host", str, "packMap", this.e});
            for (String str2 : this.e.keySet()) {
                if (!TextUtils.isEmpty(str2)) {
                    Intent intent = new Intent(com.taobao.accs.a.a.c());
                    intent.setPackage(str2);
                    intent.putExtra("operate", Operate.RESULT_ELECTION);
                    intent.putExtra("sudoPack", str);
                    intent.setClassName(str2, com.taobao.accs.utl.a.channelService);
                    this.b.startService(intent);
                }
            }
        } catch (String str3) {
            ALog.e("ElectionServiceImpl", "handleResult", str3, new Object[0]);
        }
    }

    public void a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("shouldStopSelf, kill:");
        stringBuilder.append(z);
        ALog.e("ElectionServiceImpl", stringBuilder.toString(), new Object[0]);
        if (this.i != null) {
            this.i.stopSelf();
        }
        if (z) {
            Process.killProcess(Process.myPid());
        }
    }
}
