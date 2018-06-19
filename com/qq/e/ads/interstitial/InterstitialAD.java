package com.qq.e.ads.interstitial;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.IADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.umeng.message.proguard.k;

@SuppressLint({"ViewConstructor"})
public class InterstitialAD {
    private IADI a;
    private InterstitialADListener b;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private volatile int f = 0;

    class ADListenerAdapter implements ADListener {
        private /* synthetic */ InterstitialAD a;

        private ADListenerAdapter(InterstitialAD interstitialAD) {
            this.a = interstitialAD;
        }

        public void onADEvent(ADEvent aDEvent) {
            if (this.a.b == null) {
                GDTLogger.i("No DevADListener Binded");
                return;
            }
            switch (aDEvent.getType()) {
                case 1:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        this.a.b.onNoAD(a.a(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder("AdEvent.Paras error for InterstitialAD(");
                    stringBuilder.append(aDEvent);
                    stringBuilder.append(k.t);
                    GDTLogger.e(stringBuilder.toString());
                    return;
                case 2:
                    this.a.b.onADReceive();
                    return;
                case 3:
                    this.a.b.onADExposure();
                    return;
                case 4:
                    this.a.b.onADOpened();
                    return;
                case 5:
                    this.a.b.onADClicked();
                    return;
                case 6:
                    this.a.b.onADLeftApplication();
                    return;
                case 7:
                    this.a.b.onADClosed();
                    return;
                default:
                    return;
            }
        }
    }

    public InterstitialAD(final Activity activity, final String str, final String str2) {
        if (!(StringUtil.isEmpty(str) || StringUtil.isEmpty(str2))) {
            if (activity != null) {
                this.c = true;
                if (a.a(activity)) {
                    this.d = true;
                    GDTADManager.INIT_EXECUTOR.execute(new Runnable(this) {
                        final /* synthetic */ InterstitialAD d;

                        public void run() {
                            if (GDTADManager.getInstance().initWith(activity, str)) {
                                try {
                                    final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                                    new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                                        private /* synthetic */ AnonymousClass1 b;

                                        public void run() {
                                            try {
                                                if (pOFactory != null) {
                                                    this.b.d.a = pOFactory.getIADView(activity, str, str2);
                                                    this.b.d.a.setAdListener(new ADListenerAdapter());
                                                    this.b.d.e = true;
                                                    while (this.b.d.f = this.b.d.f - 1 > 0) {
                                                        this.b.d.loadAD();
                                                    }
                                                }
                                            } catch (Throwable th) {
                                                this.b.d.e = true;
                                            }
                                            this.b.d.e = true;
                                        }
                                    });
                                    return;
                                } catch (Throwable th) {
                                    GDTLogger.e("Exception while init IAD plugin", th);
                                    return;
                                }
                            }
                            GDTLogger.e("Fail to init ADManager");
                        }
                    });
                    return;
                }
                GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
                return;
            }
        }
        GDTLogger.e(String.format("Interstitial Constructor paras error, appid=%s,posId=%s,context=%s", new Object[]{str, str2, activity}));
    }

    public void closePopupWindow() {
        if (this.a != null) {
            this.a.closePopupWindow();
        }
    }

    public void destroy() {
        if (this.a != null) {
            this.a.destory();
        }
    }

    public void loadAD() {
        if (this.c) {
            if (this.d) {
                if (!this.e) {
                    this.f++;
                    return;
                } else if (this.a != null) {
                    this.a.loadAd();
                    return;
                } else {
                    GDTLogger.e("InterstitialAD Init error,See More Logs");
                    return;
                }
            }
        }
        GDTLogger.e("InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD");
    }

    public void setADListener(InterstitialADListener interstitialADListener) {
        this.b = interstitialADListener;
    }

    public synchronized void show() {
        if (this.a != null) {
            this.a.show();
        }
    }

    public synchronized void show(Activity activity) {
        if (this.a != null) {
            this.a.show(activity);
        }
    }

    public synchronized void showAsPopupWindow() {
        if (this.a != null) {
            this.a.showAsPopupWindown();
        }
    }

    public synchronized void showAsPopupWindow(Activity activity) {
        if (this.a != null) {
            this.a.showAsPopupWindown(activity);
        }
    }
}
