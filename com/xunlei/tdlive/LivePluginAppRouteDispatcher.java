package com.xunlei.tdlive;

import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.model.PluginInfo;
import com.qihoo360.replugin.utils.b;
import com.qihoo360.replugin.utils.c;
import com.qq.e.comm.constants.Constants.KEYS;
import com.taobao.accs.utl.UTMini;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.d;
import com.xunlei.downloadprovider.member.login.b.g;
import com.xunlei.downloadprovider.member.login.b.h;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.plugin.q;
import com.xunlei.downloadprovider.plugin.q.a;
import com.xunlei.tdlive.route.IXLLiveRoute;
import com.xunlei.tdlive.route.IXLLiveRoute.Stub;
import com.xunlei.tdlive.route.util.UriBuilder;
import java.io.Closeable;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipFile;

public class LivePluginAppRouteDispatcher {
    private static final String PLUGIN_APP_NAME = "xllive.plugin.app";
    private static final String PLUGIN_APP_PACKAGE = "com.xunlei.tdlive.plugin.app";
    private static final String PLUGIN_APP_ROUTE = "xllive.plugin.app.route";
    private static ILivePluginCallback mILivePluginCallback;
    private static IXLLiveRoute mIXLLiveRoute;
    private static Runnable mInstallRunnable;
    private static boolean mInstalling;
    static d mLoginCompletedObservers = new d() {
        public final void onLoginCompleted(boolean z, int i, boolean z2) {
            if (i == 0) {
                LivePluginAppRouteDispatcher.fireLoginEvent(String.valueOf(LivePluginAppRouteDispatcher.mLoginHelper.g.c()), LivePluginAppRouteDispatcher.mLoginHelper.c(), LivePluginAppRouteDispatcher.mLoginHelper.a(UTMini.EVENTID_AGOO));
            }
        }
    };
    private static LoginHelper mLoginHelper;
    static g mLogoutObservers = new g() {
        public final void onLogout() {
            LivePluginAppRouteDispatcher.fireLogoutEvent();
        }
    };
    static h mRefreshUserInfoObservers = new h() {
        public final void onRefreshUserInfoCompleted(boolean z, int i) {
            if (i == 0) {
                LivePluginAppRouteDispatcher.fireSetUserInfoEvent(LivePluginAppRouteDispatcher.mLoginHelper.g.d(), LivePluginAppRouteDispatcher.mLoginHelper.g().toString(), "", LivePluginAppRouteDispatcher.mLoginHelper.i());
            }
        }
    };
    private static long mStatStartTime;

    public interface ILivePluginCallback {
        void onLivePluginLoaded(IXLLiveRoute iXLLiveRoute);
    }

    final class AnonymousClass1 implements a {
        final /* synthetic */ ILivePluginCallback val$callback;

        public final void onPluginProgressUpdate(int i) {
        }

        AnonymousClass1(ILivePluginCallback iLivePluginCallback) {
            this.val$callback = iLivePluginCallback;
        }

        public final void onPluginPrepared() {
            if (LivePluginAppRouteDispatcher.mInstallRunnable == null) {
                XLThreadPool.execute(LivePluginAppRouteDispatcher.mInstallRunnable = new Runnable() {
                    public void run() {
                        RePlugin.fetchBinder(LivePluginAppRouteDispatcher.PLUGIN_APP_NAME, LivePluginAppRouteDispatcher.PLUGIN_APP_ROUTE);
                        LivePluginAppRouteDispatcher.tryFixSoNoFound();
                        LivePluginAppRouteDispatcher.mInstalling = false;
                        LivePluginAppRouteDispatcher.mInstallRunnable = null;
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                IXLLiveRoute xLLiveRoute = LivePluginAppRouteDispatcher.getXLLiveRoute();
                                if (AnonymousClass1.this.val$callback != null) {
                                    AnonymousClass1.this.val$callback.onLivePluginLoaded(xLLiveRoute);
                                }
                            }
                        });
                    }
                });
                if (LivePluginAppRouteDispatcher.mStatStartTime != 0) {
                    Map hashMap = new HashMap();
                    hashMap.put(SocializeProtocolConstants.DURATION, String.valueOf(SystemClock.elapsedRealtime() - LivePluginAppRouteDispatcher.mStatStartTime));
                    ThunderStator.getInstance().traceEvent("perform_api_install_finish", null, null, hashMap);
                }
                LivePluginAppRouteDispatcher.mStatStartTime = 0;
            }
        }

        public final void onPluginFail(int i) {
            if (this.val$callback != null) {
                this.val$callback.onLivePluginLoaded(null);
            }
            if (LivePluginAppRouteDispatcher.mStatStartTime != 0) {
                Map hashMap = new HashMap();
                hashMap.put(SocializeProtocolConstants.DURATION, String.valueOf(SystemClock.elapsedRealtime() - LivePluginAppRouteDispatcher.mStatStartTime));
                hashMap.put("errcode", String.valueOf(i));
                ThunderStator.getInstance().traceEvent("perform_api_install_fail", null, null, hashMap);
            }
            LivePluginAppRouteDispatcher.mStatStartTime = 0;
        }
    }

    final class AnonymousClass2 implements ILivePluginCallback {
        final /* synthetic */ String val$url;

        AnonymousClass2(String str) {
            this.val$url = str;
        }

        public final void onLivePluginLoaded(com.xunlei.tdlive.route.IXLLiveRoute r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = "xllive.plugin.host";	 Catch:{ Throwable -> 0x0008 }
            r1 = r2.val$url;	 Catch:{ Throwable -> 0x0008 }
            r3.dispatch(r0, r1);	 Catch:{ Throwable -> 0x0008 }
            return;
        L_0x0008:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.LivePluginAppRouteDispatcher.2.onLivePluginLoaded(com.xunlei.tdlive.route.IXLLiveRoute):void");
        }
    }

    public static IXLLiveRoute getXLLiveRoute() {
        if (mIXLLiveRoute == null && !mInstalling) {
            IBinder fetchBinder = RePlugin.fetchBinder(PLUGIN_APP_NAME, PLUGIN_APP_ROUTE);
            if (fetchBinder != null) {
                mIXLLiveRoute = Stub.asInterface(fetchBinder);
            }
            if (!(mIXLLiveRoute == null || mILivePluginCallback == null)) {
                mILivePluginCallback.onLivePluginLoaded(mIXLLiveRoute);
            }
            if (mIXLLiveRoute != null) {
                q.a().a(PLUGIN_APP_PACKAGE, null, true);
            }
        }
        return mIXLLiveRoute;
    }

    public static int getLivePluginVersion() {
        return RePlugin.getPluginVersion(PLUGIN_APP_NAME);
    }

    public static void registerLivePluginCallback(ILivePluginCallback iLivePluginCallback) {
        mILivePluginCallback = iLivePluginCallback;
    }

    public static void livePlugin(ILivePluginCallback iLivePluginCallback) {
        livePlugin(false, iLivePluginCallback);
    }

    public static void livePlugin(boolean z, ILivePluginCallback iLivePluginCallback) {
        if (!(z || iLivePluginCallback == null || mLoginHelper != null)) {
            mLoginHelper = LoginHelper.a();
            if (l.b()) {
                mLoginCompletedObservers.onLoginCompleted(true, 0, true);
                mRefreshUserInfoObservers.onRefreshUserInfoCompleted(true, 0);
            }
            mLoginHelper.a(mRefreshUserInfoObservers);
            mLoginHelper.a(mLoginCompletedObservers);
            mLoginHelper.a(mLogoutObservers);
        }
        IXLLiveRoute xLLiveRoute = getXLLiveRoute();
        if (xLLiveRoute != null) {
            if (iLivePluginCallback != null) {
                iLivePluginCallback.onLivePluginLoaded(xLLiveRoute);
            }
            return;
        }
        a anonymousClass1 = new AnonymousClass1(iLivePluginCallback);
        mInstalling = true;
        if (iLivePluginCallback != null) {
            if (!z) {
                mStatStartTime = SystemClock.elapsedRealtime();
                ThunderStator.getInstance().traceEvent("perform_api_alert_show", null, null, null);
                q.a().a(AppStatusChgObserver.b().c(), PLUGIN_APP_PACKAGE, anonymousClass1);
                return;
            }
        }
        q.a().a(PLUGIN_APP_PACKAGE, anonymousClass1, true);
    }

    public static void dispatch(String str) {
        dispatch(false, str);
    }

    public static void dispatch(boolean z, String str) {
        livePlugin(z, new AnonymousClass2(str));
    }

    public static void fireInitEvent(String str, String str2) {
        dispatch(true, accessUri("fireInitEvent").addParam(com.xunlei.analytics.c.d.a, str).addParam("mainActivity", str2).toString());
    }

    public static void firePayEvent(int i, int i2, String str, String str2, String str3, int i3) {
        dispatch(1, accessUri("firePayEvent").addParam("payType", i).addParam("errorCode", i2).addParam("errorDesc", str).addParam("obj", str2).addParam("orderId", str3).addParam("taskId", i3).toString());
    }

    public static void fireShareEvent(int i, int i2) {
        dispatch(1, accessUri("fireShareEvent").addParam(KEYS.RET, i).addParam("platform", i2).toString());
    }

    public static void fireLogoutEvent() {
        dispatch(true, accessUri("fireLogoutEvent").toString());
    }

    public static void fireLoginEvent(String str, String str2, String str3) {
        dispatch(true, accessUri("fireLoginEvent").addParam("userid", str).addParam("sessionid", str2).addParam("jumpkey", str3).toString());
    }

    public static void fireSetUserInfoEvent(String str, String str2, String str3, String str4) {
        dispatch(true, accessUri("fireSetUserInfoEvent").addParam("nickname", str).addParam("sex", str2).addParam("sign", str3).addParam("phone", str4).toString());
    }

    public static void fireAuthPhoneEvent(int i, String str) {
        dispatch(true, accessUri("fireAuthPhoneEvent").addParam(KEYS.RET, i).addParam("msg", str).toString());
    }

    private static UriBuilder accessUri(String str) {
        return new UriBuilder(PLUGIN_APP_NAME, str);
    }

    private static void tryFixSoNoFound() {
        Closeable closeable;
        Throwable th;
        PluginInfo pluginInfo = RePlugin.getPluginInfo(PLUGIN_APP_NAME);
        if (pluginInfo != null) {
            File file = new File(pluginInfo.getNativeLibsDir(), "libNodeMediaClient.so");
            if (!file.isFile()) {
                ZipFile zipFile = null;
                try {
                    ZipFile zipFile2 = new ZipFile(pluginInfo.getApkFile());
                    try {
                        try {
                            Closeable inputStream = zipFile2.getInputStream(zipFile2.getEntry("lib/armeabi-v7a/libNodeMediaClient.so"));
                            try {
                                c.a(inputStream, file);
                                b.a(inputStream);
                                b.a(zipFile2);
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                closeable = inputStream;
                                th = th3;
                                b.a(closeable);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            b.a(closeable);
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        b.a(zipFile2);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    th.printStackTrace();
                    b.a(zipFile);
                }
            }
        }
    }
}
