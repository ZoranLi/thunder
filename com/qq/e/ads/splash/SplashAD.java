package com.qq.e.ads.splash;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.aplayer.aplayerandroid.APlayerAndroid.CONFIGID;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;

public final class SplashAD {
    private NSPVI a;
    private SplashADListener b;

    class ADListenerAdapter implements ADListener {
        private /* synthetic */ SplashAD a;

        private ADListenerAdapter(SplashAD splashAD) {
            this.a = splashAD;
        }

        public void onADEvent(ADEvent aDEvent) {
            if (this.a.b == null) {
                GDTLogger.e("SplashADListener == null");
                return;
            }
            switch (aDEvent.getType()) {
                case 1:
                    this.a.b.onADDismissed();
                    return;
                case 2:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        this.a.b.onNoAD(a.a(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    } else {
                        GDTLogger.e("Splash onNoAD event get params error.");
                        return;
                    }
                case 3:
                    this.a.b.onADPresent();
                    return;
                case 4:
                    this.a.b.onADClicked();
                    return;
                case 5:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Long)) {
                        this.a.b.onADTick(((Long) aDEvent.getParas()[0]).longValue());
                        return;
                    } else {
                        GDTLogger.e("Splash onADTick event get param error.");
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public SplashAD(Activity activity, ViewGroup viewGroup, View view, String str, String str2, SplashADListener splashADListener, int i) {
        int i2;
        this.b = splashADListener;
        if (!(StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || viewGroup == null)) {
            if (activity != null) {
                if (a.a(activity)) {
                    try {
                        if (GDTADManager.getInstance().initWith(activity, str)) {
                            this.a = GDTADManager.getInstance().getPM().getPOFactory().getNativeSplashAdView(activity, str, str2);
                            if (this.a != null) {
                                this.a.setFetchDelay(i);
                                this.a.setAdListener(new ADListenerAdapter());
                                this.a.setSkipView(view);
                                this.a.fetchAndShowIn(viewGroup);
                                return;
                            }
                            GDTLogger.e("SplashAdView created by factory return null");
                            a(splashADListener, 200103);
                            return;
                        }
                        GDTLogger.e("Fail to Init GDT AD SDK, report logcat info filter by gdt_ad_mob");
                        a(splashADListener, 200101);
                        return;
                    } catch (Throwable e) {
                        GDTLogger.e("Fail to init splash plugin", e);
                        i2 = 200102;
                    } catch (Throwable e2) {
                        GDTLogger.e("Unknown Exception", e2);
                        i2 = 605;
                    }
                } else {
                    GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
                    i2 = CONFIGID.RECORD_HEIGHT;
                    a(splashADListener, i2);
                }
            }
        }
        GDTLogger.e(String.format("SplashAD Constructor params error, appid=%s,posId=%s,context=%s", new Object[]{str, str2, activity}));
        i2 = PushResult.OFFLINE_DOWNLOAD_DONE;
        a(splashADListener, i2);
    }

    public SplashAD(Activity activity, ViewGroup viewGroup, String str, String str2, SplashADListener splashADListener) {
        this(activity, viewGroup, str, str2, splashADListener, 0);
    }

    public SplashAD(Activity activity, ViewGroup viewGroup, String str, String str2, SplashADListener splashADListener, int i) {
        this(activity, viewGroup, null, str, str2, splashADListener, i);
    }

    private static void a(SplashADListener splashADListener, int i) {
        if (splashADListener != null) {
            splashADListener.onNoAD(a.a(i));
        }
    }
}
