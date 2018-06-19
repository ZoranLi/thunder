package com.qq.e.ads.nativ;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.NADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

public class NativeAD {
    private NADI a;
    private NativeAdListener b;
    private boolean c;
    private boolean d;
    private List<Integer> e = new ArrayList();
    private boolean f = false;
    private BrowserType g;
    private DownAPPConfirmPolicy h;
    private List<String> i;

    public interface NativeAdListener {
        void onADError(NativeADDataRef nativeADDataRef, AdError adError);

        void onADLoaded(List<NativeADDataRef> list);

        void onADStatusChanged(NativeADDataRef nativeADDataRef);

        void onNoAD(AdError adError);
    }

    public NativeAD(final Context context, final String str, final String str2, NativeAdListener nativeAdListener) {
        if (!(StringUtil.isEmpty(str) || StringUtil.isEmpty(str2))) {
            if (context != null) {
                this.c = true;
                if (a.a(context)) {
                    this.d = true;
                    this.b = nativeAdListener;
                    GDTADManager.INIT_EXECUTOR.execute(new Runnable(this) {
                        final /* synthetic */ NativeAD d;

                        public void run() {
                            if (GDTADManager.getInstance().initWith(context, str)) {
                                try {
                                    final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                                    new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                                        private /* synthetic */ AnonymousClass1 b;

                                        public void run() {
                                            try {
                                                if (pOFactory != null) {
                                                    this.b.d.a = pOFactory.getNativeADDelegate(context, str, str2, new ADListenerAdapter(this.b.d, (byte) 0));
                                                    this.b.d.f = true;
                                                    if (this.b.d.g != null) {
                                                        this.b.d.setBrowserType(this.b.d.g);
                                                    }
                                                    if (this.b.d.h != null) {
                                                        this.b.d.setDownAPPConfirmPolicy(this.b.d.h);
                                                    }
                                                    if (this.b.d.i != null) {
                                                        this.b.d.setCategories(this.b.d.i);
                                                    }
                                                    for (Integer intValue : this.b.d.e) {
                                                        this.b.d.loadAD(intValue.intValue());
                                                    }
                                                }
                                            } catch (Throwable th) {
                                                this.b.d.f = true;
                                            }
                                            this.b.d.f = true;
                                        }
                                    });
                                    return;
                                } catch (Throwable th) {
                                    GDTLogger.e("Exception while init Native plugin", th);
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
        GDTLogger.e(String.format("GDTNativeAd Contructor paras error,appid=%s,posId=%s,context=%s", new Object[]{str, str2, context}));
    }

    public void loadAD(int i) {
        if (this.c) {
            if (this.d) {
                if (!this.f) {
                    this.e.add(Integer.valueOf(i));
                    return;
                } else if (this.a != null) {
                    this.a.loadAd(i);
                    return;
                } else {
                    GDTLogger.e("NativeAD Init error,See More Logs");
                    return;
                }
            }
        }
        GDTLogger.e("AD init Paras OR Context error,details in logs produced while init NativeAD");
    }

    public void setBrowserType(BrowserType browserType) {
        this.g = browserType;
        if (this.a != null && browserType != null) {
            this.a.setBrowserType(browserType.value());
        }
    }

    public void setCategories(List<String> list) {
        this.i = list;
        if (this.a != null && list != null) {
            this.a.setCategories(list);
        }
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.h = downAPPConfirmPolicy;
        if (this.a != null && downAPPConfirmPolicy != null) {
            this.a.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }
}
