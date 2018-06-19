package com.qq.e.ads.banner;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.qq.e.ads.cfg.BannerRollAnimation;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.BVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.umeng.message.proguard.k;

@SuppressLint({"ViewConstructor"})
public class BannerView extends FrameLayout {
    private BVI a;
    private BannerADListener b;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private Integer f;
    private BannerRollAnimation g;
    private DownAPPConfirmPolicy h;
    private Boolean i;
    private volatile int j = 0;

    class ADListenerAdapter implements ADListener {
        private /* synthetic */ BannerView a;

        private ADListenerAdapter(BannerView bannerView) {
            this.a = bannerView;
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
                    StringBuilder stringBuilder = new StringBuilder("AdEvent.Paras error for Banner(");
                    stringBuilder.append(aDEvent);
                    stringBuilder.append(k.t);
                    GDTLogger.e(stringBuilder.toString());
                    return;
                case 2:
                    this.a.b.onADReceiv();
                    return;
                case 3:
                    this.a.b.onADExposure();
                    return;
                case 4:
                    this.a.b.onADClosed();
                    return;
                case 5:
                    this.a.b.onADClicked();
                    return;
                case 6:
                    this.a.b.onADLeftApplication();
                    return;
                case 7:
                    this.a.b.onADOpenOverlay();
                    return;
                case 8:
                    this.a.b.onADCloseOverlay();
                    return;
                default:
                    return;
            }
        }
    }

    public BannerView(Activity activity, ADSize aDSize, String str, String str2) {
        super(activity);
        if (!(StringUtil.isEmpty(str) || StringUtil.isEmpty(str2))) {
            if (activity != null) {
                this.c = true;
                if (a.a(activity)) {
                    this.d = true;
                    setLayoutParams(new LayoutParams(-1, -2));
                    final Activity activity2 = activity;
                    final String str3 = str;
                    final ADSize aDSize2 = aDSize;
                    final String str4 = str2;
                    GDTADManager.INIT_EXECUTOR.execute(new Runnable(this) {
                        final /* synthetic */ BannerView e;

                        public void run() {
                            if (GDTADManager.getInstance().initWith(activity2, str3)) {
                                try {
                                    final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                                    new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                                        private /* synthetic */ AnonymousClass1 b;

                                        public void run() {
                                            try {
                                                if (pOFactory != null) {
                                                    this.b.e.a = pOFactory.getBannerView(activity2, aDSize2, str3, str4);
                                                    this.b.e.a.setAdListener(new ADListenerAdapter());
                                                    this.b.e.addView(this.b.e.a.getView());
                                                    this.b.e.e = true;
                                                    if (this.b.e.h != null) {
                                                        this.b.e.setDownConfirmPilicy(this.b.e.h);
                                                    }
                                                    if (this.b.e.f != null) {
                                                        this.b.e.setRefresh(this.b.e.f.intValue());
                                                    }
                                                    if (this.b.e.g != null) {
                                                        this.b.e.setRollAnimation(this.b.e.g);
                                                    }
                                                    if (this.b.e.i != null) {
                                                        this.b.e.setShowClose(this.b.e.i.booleanValue());
                                                    }
                                                    while (this.b.e.j = this.b.e.j - 1 > 0) {
                                                        this.b.e.loadAD();
                                                    }
                                                }
                                            } catch (Throwable th) {
                                                this.b.e.e = true;
                                            }
                                            this.b.e.e = true;
                                        }
                                    });
                                    return;
                                } catch (Throwable th) {
                                    GDTLogger.e("Exception while init Banner plugin", th);
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
        GDTLogger.e(String.format("Banner ADView Constructor params error, appid=%s,posId=%s,context=%s", new Object[]{str, str2, activity}));
    }

    public void destroy() {
        if (this.a != null) {
            this.a.destroy();
        }
    }

    public void loadAD() {
        if (this.c) {
            if (this.d) {
                if (!this.e) {
                    this.j++;
                    return;
                } else if (this.a != null) {
                    this.a.fetchAd();
                    return;
                } else {
                    GDTLogger.e("Banner Init error,See More Logs");
                    return;
                }
            }
        }
        GDTLogger.e("Banner init Paras OR Context error,See More logs while new BannerView");
    }

    public void setADListener(BannerADListener bannerADListener) {
        this.b = bannerADListener;
    }

    public void setDownConfirmPilicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.h = downAPPConfirmPolicy;
        if (downAPPConfirmPolicy != null && this.a != null) {
            this.a.setDownAPPConfirmPolicy(downAPPConfirmPolicy.value());
        }
    }

    public void setRefresh(int i) {
        this.f = Integer.valueOf(i);
        if (i < 30 && i != 0) {
            i = 30;
        } else if (i > 120) {
            i = 120;
        }
        if (this.a != null) {
            this.a.setRefresh(i);
        }
    }

    public void setRollAnimation(BannerRollAnimation bannerRollAnimation) {
        this.g = bannerRollAnimation;
        if (bannerRollAnimation != null && this.a != null) {
            this.a.setRollAnimation(bannerRollAnimation.value());
        }
    }

    public void setShowClose(boolean z) {
        this.i = Boolean.valueOf(z);
        if (this.a != null) {
            this.a.setShowCloseButton(z);
        }
    }
}
