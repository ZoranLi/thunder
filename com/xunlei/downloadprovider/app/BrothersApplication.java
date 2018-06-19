package com.xunlei.downloadprovider.app;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.os.SystemClock;
import android.support.annotation.Keep;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.RePluginEventCallbacks;
import com.tencent.bugly.beta.Beta;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.xunlei.common.XLCommonModule;
import com.xunlei.downloadprovider.download.c.a;
import com.xunlei.downloadprovider.download.openwith.ApkFinishIntallReceiver;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.launch.e.b;
import com.xunlei.downloadprovider.member.payment.external.l;
import com.xunlei.downloadprovider.member.payment.paymentfloat.m;
import com.xunlei.downloadprovider.plugin.a.d;
import com.xunlei.downloadprovider.service.DownloadService;
import com.xunlei.xllib.android.XLIntent;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BrothersApplication extends DefaultApplicationLike {
    public static final String COM_XUNLEI_DOWNLOADPROVIDER = "com.xunlei.downloadprovider";
    private static String TAG = "BrothersApplication";
    public static long mStartTime;
    private static Application sApplicationInstance;
    private static long sElapsedTimeStart = SystemClock.elapsedRealtime();
    public static final b sLaunchAnalysisReport = new b();
    private static BrothersApplication sSingletonInstance;
    private static long sUptimeStart = SystemClock.uptimeMillis();
    public boolean hasLaunched = null;
    private BroadcastReceiver mApkStateReceiver;
    @Keep
    private XLCommonModule mCommonModuleKeeper = XLCommonModule.getInstance();

    public static Application getApplicationInstance() {
        return sApplicationInstance;
    }

    public static BrothersApplication getSingletonInstance() {
        return sSingletonInstance;
    }

    public BrothersApplication(Application application, int i, boolean z, long j, long j2, Intent intent) {
        super(application, i, z, j, j2, intent);
        sApplicationInstance = getApplication();
        sSingletonInstance = this;
    }

    public void killMyself() {
        com.xunlei.downloadprovider.discovery.kuainiao.a.b.a().b();
        m a = m.a();
        l.a().b(a.c);
        a.a.removeCallbacksAndMessages(null);
        a a2 = a.a();
        if (a2.k != null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (Entry value : a2.k.entrySet()) {
                a.a aVar = (a.a) value.getValue();
                if (aVar.b > a.a) {
                    aVar.d = a.c;
                }
                jSONArray.put(aVar.a());
            }
            try {
                jSONObject.put("tasks", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            f.a(getApplicationInstance(), "trialed_tasks", jSONObject.toString());
        }
        DownloadService.c();
        stopServiceForName("com.qq.e.comm.DownloadService");
        stopServiceForName(com.taobao.accs.utl.a.msgService);
        stopServiceForName("org.android.agoo.accs.AgooService");
        stopServiceForName("com.getui.gtc.GtcService");
        Process.killProcess(Process.myPid());
    }

    private static void stopServiceForName(String str) {
        Intent xLIntent = new XLIntent();
        xLIntent.setClassName(getApplicationInstance(), str);
        try {
            getApplicationInstance().stopService(xLIntent);
        } catch (String str2) {
            str2.printStackTrace();
        }
    }

    public static String timeTag() {
        long uptimeMillis = SystemClock.uptimeMillis() - sUptimeStart;
        long elapsedRealtime = SystemClock.elapsedRealtime() - sElapsedTimeStart;
        sUptimeStart += uptimeMillis;
        StringBuilder stringBuilder = new StringBuilder(" deltats:[");
        stringBuilder.append(uptimeMillis);
        stringBuilder.append("] elapsed:[");
        stringBuilder.append(elapsedRealtime);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void onTerminate() {
        getApplication().unregisterActivityLifecycleCallbacks(AppStatusChgObserver.b().b);
        com.xunlei.downloadprovider.broadcast.a a = com.xunlei.downloadprovider.broadcast.a.a();
        Context application = getApplication();
        a aVar = a.a;
        application = application.getApplicationContext();
        if (aVar.a != null) {
            application.unregisterReceiver(aVar.a);
            aVar.a = null;
        }
        super.onTerminate();
    }

    public void onBaseContextAttached(Context context) {
        super.onBaseContextAttached(context);
        RePlugin.a.a(getApplication(), createConfig());
        RePlugin.registerHostBinder(new d());
        Beta.installTinker(this);
    }

    protected com.qihoo360.replugin.f createConfig() {
        com.qihoo360.replugin.f fVar = new com.qihoo360.replugin.f();
        if (com.qihoo360.replugin.f.a()) {
            fVar.e = false;
        }
        if (com.qihoo360.replugin.f.a()) {
            fVar.d = false;
        }
        RePluginEventCallbacks cVar = new c(this, getApplication());
        if (com.qihoo360.replugin.f.a()) {
            fVar.b = cVar;
        }
        fVar.a(new d(this, getApplication()));
        return fVar;
    }

    public void registerActivityLifeCycle() {
        getApplication().registerActivityLifecycleCallbacks(AppStatusChgObserver.b().b);
    }

    public void onCreate() {
        super.onCreate();
        RePlugin.a.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(timeTag());
        stringBuilder.append(" onCreate super");
        mStartTime = SystemClock.uptimeMillis();
        getApplicationInstance();
        getApplicationInstance();
        com.a.a.a aVar = com.a.a.a.a;
        XLCommonModule.init(getApplicationInstance());
        com.xunlei.downloadprovider.app.a.d.a().a(0, null);
        stringBuilder = new StringBuilder();
        stringBuilder.append(timeTag());
        stringBuilder.append(" onCreate end");
    }

    public void onLowMemory() {
        uninitKuaiNiaoServer();
        super.onLowMemory();
        RePlugin.a.b();
    }

    public void registerBroadcastReceiver() {
        this.mApkStateReceiver = new ApkFinishIntallReceiver();
        getApplication().registerReceiver(this.mApkStateReceiver, ApkFinishIntallReceiver.a());
    }

    private void unregisterBroadcastReceiver() {
        if (this.mApkStateReceiver != null) {
            getApplication().unregisterReceiver(this.mApkStateReceiver);
        }
    }

    private void uninitKuaiNiaoServer() {
        com.xunlei.downloadprovider.discovery.kuainiao.a.b.a().b();
    }
}
