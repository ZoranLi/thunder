package com.xunlei.downloadprovider.app.a;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.UserManager;
import com.igexin.sdk.PushConsts;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.smtt.sdk.QbSdk;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.ad.cache.task.ADCacheNetworkReceiver;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.splash.c.a;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.app.b.d;
import com.xunlei.downloadprovider.broadcast.XLBroadcastManager$BroadcastManagerImpl$1;
import com.xunlei.downloadprovider.cooperation.g;
import com.xunlei.downloadprovider.d.c;
import com.xunlei.downloadprovider.download.b.b;
import com.xunlei.downloadprovider.download.create.af;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.privatespace.aa;
import com.xunlei.downloadprovider.download.privatespace.v;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.payment.external.l;
import com.xunlei.downloadprovider.member.payment.paymentfloat.m;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.p;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.j;
import com.xunlei.downloadprovider.plugin.q;
import com.xunlei.downloadprovider.service.DownloadService;
import com.xunlei.tdlive.LivePlugin;
import com.xunlei.xllib.android.e;
import java.lang.reflect.InvocationTargetException;

/* compiled from: LaunchInitialization */
class i implements c {
    static final String a = "i";
    private boolean b;
    private boolean c;
    private Handler d = new Handler(Looper.getMainLooper());

    i() {
    }

    public final void a(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        z = new d(a);
        z.a = "initInMainThread";
        z.b = System.currentTimeMillis();
        z.c = z.b;
        new StringBuilder().append(z.a);
        a.a().c();
        z.a(null);
        ThunderReport.setShouleiMemberDeviceId(LoginHelper.q());
        z.a(null);
        l.a();
        m a = m.a();
        if (!a.b) {
            l.a().a(a.c);
            a.b = true;
            a.b();
        }
        z.a("member");
        c.a();
        c.a(BrothersApplication.getApplicationInstance());
        c.a();
        c.b();
        z.a("config");
        b.a();
        z.a(null);
        com.xunlei.downloadprovider.member.a aVar = new com.xunlei.downloadprovider.member.a();
        if (com.xunlei.downloadprovider.loading.c.b()) {
            f.a(BrothersApplication.getApplicationInstance(), "key_first_enter_thunder", System.currentTimeMillis());
            XLThreadPool.execute(new com.xunlei.downloadprovider.member.b(aVar));
        }
        q.a();
        q.c();
        z.a("plugins");
        com.xunlei.downloadprovider.ad.cache.b a2 = com.xunlei.downloadprovider.ad.cache.b.a();
        a2.c = new ADCacheNetworkReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        com.xunlei.downloadprovider.ad.a.a().registerReceiver(a2.c, intentFilter);
        a2.c();
        com.xunlei.downloadprovider.ad.home.a.f.a(BrothersApplication.getApplicationInstance()).a();
        com.xunlei.downloadprovider.ad.cache.b.a().a(STYLES_INFO.HOME_IMG);
        if (com.xunlei.downloadprovider.ad.d.f.b("effect")) {
            com.xunlei.downloadprovider.ad.cache.b.a().a(STYLES_INFO.SHORT_MOVIE_DETAIL_EFFECT);
        }
        z.a("ad init");
        if (VERSION.SDK_INT >= 17) {
            try {
                UserManager.class.getMethod("get", new Class[]{Context.class}).invoke(null, new Object[]{BrothersApplication.getApplicationInstance()});
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            }
        }
        if (com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.c()) {
            p.a();
            com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b.a();
        }
        j.a();
        this.d.postDelayed(new j(this), 800);
        af.a();
        this.b = true;
        long currentTimeMillis2 = System.currentTimeMillis() - z.b;
        StringBuilder stringBuilder = new StringBuilder("End ");
        stringBuilder.append(z.a);
        stringBuilder.append(" ");
        stringBuilder.append(currentTimeMillis2);
        stringBuilder.append("ms");
        z = new StringBuilder("End initInMainThread costTime = ");
        z.append(System.currentTimeMillis() - currentTimeMillis);
        z.append("ms");
    }

    public final void a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.c) {
            boolean z;
            Context applicationInstance = BrothersApplication.getApplicationInstance();
            e.a.a(applicationInstance);
            a aVar = com.xunlei.downloadprovider.broadcast.a.a().a;
            Context applicationContext = applicationInstance.getApplicationContext();
            aVar.a = new XLBroadcastManager$BroadcastManagerImpl$1(aVar);
            aVar.d = new IntentFilter();
            aVar.d.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            aVar.d.addAction("android.intent.action.SCREEN_ON");
            aVar.d.addAction("android.intent.action.SCREEN_OFF");
            aVar.d.addAction("android.media.VOLUME_CHANGED_ACTION");
            aVar.d.addAction("android.intent.action.BATTERY_CHANGED");
            applicationContext.registerReceiver(aVar.a, aVar.d);
            n.a(applicationInstance);
            if (DownloadService.a() == null) {
                DownloadService.a(null);
            }
            com.xunlei.downloadprovider.launch.a.a.c();
            q.a().a(new k(this), true);
            LivePlugin.getInstance(BrothersApplication.getApplicationInstance());
            BrothersApplication.getSingletonInstance().registerBroadcastReceiver();
            WXAPIFactory.createWXAPI(BrothersApplication.getApplicationInstance(), "wx3e6556568beeebdd", false).registerApp("wx3e6556568beeebdd");
            g gVar = com.xunlei.downloadprovider.cooperation.c.a().c;
            if (gVar.d) {
                gVar.d = false;
                z = true;
            } else {
                z = false;
            }
            if (z) {
                gVar.b();
            }
            QbSdk.initX5Environment(BrothersApplication.getApplicationInstance(), new l(this));
            com.xunlei.downloadprovider.download.tasklist.list.feed.d a = com.xunlei.downloadprovider.download.tasklist.list.feed.d.a();
            SharedPreferences sharedPreferences = BrothersApplication.getApplicationInstance().getSharedPreferences("page_sp_name", 0);
            if (sharedPreferences != null) {
                a.a.put(Integer.valueOf(0), Integer.valueOf(sharedPreferences.getInt("DOWNLOAD_PAGE_1", 1)));
                a.a.put(Integer.valueOf(1), Integer.valueOf(sharedPreferences.getInt("DOWNLOAD_PAGE_2", 1)));
                a.a.put(Integer.valueOf(2), Integer.valueOf(sharedPreferences.getInt("DOWNLOAD_PAGE_3", 1)));
            }
            XLThreadPool.execute(new aa(v.a()));
            com.xunlei.downloadprovider.member.payment.activity.c.a().a(true);
            com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.a();
            com.xunlei.downloadprovider.download.tasklist.list.banner.a.e.c();
            a.a;
            this.c = true;
        }
        StringBuilder stringBuilder = new StringBuilder("End initInOtherThread costTime = ");
        stringBuilder.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuilder.append("ms");
    }

    public final boolean b() {
        return this.c && this.b;
    }

    static /* synthetic */ void c() {
        long currentTimeMillis = System.currentTimeMillis();
        com.xunlei.downloadprovider.download.create.m.a();
        XLThreadPool.execute(new com.xunlei.downloadprovider.ad.c.b.c(com.xunlei.downloadprovider.ad.c.b.b.a()));
        StringBuilder stringBuilder = new StringBuilder("End initInMainThreadDelayed costTime = ");
        stringBuilder.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuilder.append("ms");
    }
}
