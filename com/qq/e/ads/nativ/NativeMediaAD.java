package com.qq.e.ads.nativ;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.NVADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

public class NativeMediaAD {
    private volatile boolean a;
    private volatile boolean b;
    private List<Integer> c = new ArrayList();
    private volatile boolean d = false;
    private NVADI e;
    private NativeMediaADListener f;
    private BrowserType g;
    private DownAPPConfirmPolicy h;

    public interface NativeMediaADListener {
        void onADClicked(NativeMediaADData nativeMediaADData);

        void onADError(NativeMediaADData nativeMediaADData, AdError adError);

        void onADExposure(NativeMediaADData nativeMediaADData);

        void onADLoaded(List<NativeMediaADData> list);

        void onADStatusChanged(NativeMediaADData nativeMediaADData);

        void onADVideoLoaded(NativeMediaADData nativeMediaADData);

        void onNoAD(AdError adError);
    }

    public NativeMediaAD(final Context context, final String str, final String str2, NativeMediaADListener nativeMediaADListener) {
        if (!(StringUtil.isEmpty(str) || StringUtil.isEmpty(str2))) {
            if (context != null) {
                this.a = true;
                if (a.a(context)) {
                    this.b = true;
                    this.f = nativeMediaADListener;
                    GDTADManager.INIT_EXECUTOR.execute(new Runnable(this) {
                        final /* synthetic */ NativeMediaAD d;

                        public void run() {
                            if (GDTADManager.getInstance().initWith(context, str)) {
                                try {
                                    final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                                    new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                                        private /* synthetic */ AnonymousClass1 b;

                                        public void run() {
                                            try {
                                                if (pOFactory != null) {
                                                    this.b.d.e = pOFactory.getNativeVideoADDelegate(context, str, str2, new ADListenerAdapter(this.b.d, (byte) 0));
                                                    this.b.d.d = true;
                                                    if (this.b.d.g != null) {
                                                        this.b.d.setBrowserType(this.b.d.g);
                                                    }
                                                    if (this.b.d.h != null) {
                                                        this.b.d.setDownAPPConfirmPolicy(this.b.d.h);
                                                    }
                                                    for (Integer intValue : this.b.d.c) {
                                                        this.b.d.loadAD(intValue.intValue());
                                                    }
                                                }
                                            } catch (Throwable th) {
                                                this.b.d.d = true;
                                            }
                                            this.b.d.d = true;
                                        }
                                    });
                                    return;
                                } catch (Throwable th) {
                                    GDTLogger.e("Exception while init NativeMediaAD plugin", th);
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
        GDTLogger.e(String.format("NativeMediaAD Contructor paras error, appid=%s, posId=%s, context=%s", new Object[]{str, str2, context}));
    }

    public void loadAD(int i) {
        if (this.a) {
            if (this.b) {
                if (!this.d) {
                    this.c.add(Integer.valueOf(i));
                    return;
                } else if (this.e != null) {
                    this.e.loadAd(i);
                    return;
                } else {
                    GDTLogger.e("NativeMediaAD Init error, See More Logs");
                    return;
                }
            }
        }
        GDTLogger.e("AD init Paras OR Context error, details in logs produced while init NativeMediaAD");
    }

    public void setBrowserType(BrowserType browserType) {
        this.g = browserType;
        if (this.e != null && browserType != null) {
            this.e.setBrowserType(browserType.value());
        }
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.h = downAPPConfirmPolicy;
        if (this.e != null && downAPPConfirmPolicy != null) {
            this.e.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }
}
