package com.qq.e.ads.nativ;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.umeng.message.proguard.k;
import java.util.ArrayList;
import java.util.List;

public class NativeExpressAD {
    private NEADI a;
    private NativeExpressADListener b;
    private boolean c;
    private boolean d;
    private List<Integer> e = new ArrayList();
    private boolean f = false;
    private BrowserType g;
    private DownAPPConfirmPolicy h;
    private VideoOption i;

    public interface NativeExpressADListener {
        void onADClicked(NativeExpressADView nativeExpressADView);

        void onADCloseOverlay(NativeExpressADView nativeExpressADView);

        void onADClosed(NativeExpressADView nativeExpressADView);

        void onADExposure(NativeExpressADView nativeExpressADView);

        void onADLeftApplication(NativeExpressADView nativeExpressADView);

        void onADLoaded(List<NativeExpressADView> list);

        void onADOpenOverlay(NativeExpressADView nativeExpressADView);

        void onNoAD(AdError adError);

        void onRenderFail(NativeExpressADView nativeExpressADView);

        void onRenderSuccess(NativeExpressADView nativeExpressADView);
    }

    class ADListenerAdapter implements ADListener {
        private /* synthetic */ NativeExpressAD a;

        private ADListenerAdapter(NativeExpressAD nativeExpressAD) {
            this.a = nativeExpressAD;
        }

        public void onADEvent(ADEvent aDEvent) {
            if (this.a.b == null) {
                GDTLogger.i("No DevADListener Binded");
                return;
            }
            StringBuilder stringBuilder;
            switch (aDEvent.getType()) {
                case 1:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        this.a.b.onNoAD(a.a(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    }
                    stringBuilder = new StringBuilder("AdEvent.Params error for NativeExpressAD(");
                    stringBuilder.append(aDEvent);
                    stringBuilder.append(k.t);
                    GDTLogger.e(stringBuilder.toString());
                    return;
                case 2:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                        this.a.b.onADLoaded((List) aDEvent.getParas()[0]);
                        return;
                    }
                    stringBuilder = new StringBuilder("ADEvent.Params error for NativeExpressAD(");
                    stringBuilder.append(aDEvent);
                    stringBuilder.append(k.t);
                    GDTLogger.e(stringBuilder.toString());
                    return;
                case 3:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        this.a.b.onRenderFail((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    }
                    stringBuilder = new StringBuilder("ADEvent.Params error for NativeExpressAD(");
                    stringBuilder.append(aDEvent);
                    stringBuilder.append(k.t);
                    GDTLogger.e(stringBuilder.toString());
                    return;
                case 4:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        this.a.b.onRenderSuccess((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    }
                    stringBuilder = new StringBuilder("ADEvent.Params error for NativeExpressAD(");
                    stringBuilder.append(aDEvent);
                    stringBuilder.append(k.t);
                    GDTLogger.e(stringBuilder.toString());
                    return;
                case 5:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        this.a.b.onADExposure((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    }
                    stringBuilder = new StringBuilder("ADEvent.Params error for NativeExpressAD(");
                    stringBuilder.append(aDEvent);
                    stringBuilder.append(k.t);
                    GDTLogger.e(stringBuilder.toString());
                    return;
                case 6:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        this.a.b.onADClicked((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    }
                    stringBuilder = new StringBuilder("ADEvent.Params error for NativeExpressAD(");
                    stringBuilder.append(aDEvent);
                    stringBuilder.append(k.t);
                    GDTLogger.e(stringBuilder.toString());
                    return;
                case 7:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        this.a.b.onADClosed((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    }
                    stringBuilder = new StringBuilder("ADEvent.Params error for NativeExpressAD(");
                    stringBuilder.append(aDEvent);
                    stringBuilder.append(k.t);
                    GDTLogger.e(stringBuilder.toString());
                    return;
                case 8:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        this.a.b.onADLeftApplication((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    }
                    stringBuilder = new StringBuilder("ADEvent.Params error for NativeExpressAD(");
                    stringBuilder.append(aDEvent);
                    stringBuilder.append(k.t);
                    GDTLogger.e(stringBuilder.toString());
                    return;
                case 9:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        this.a.b.onADOpenOverlay((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    }
                    stringBuilder = new StringBuilder("ADEvent.Params error for NativeExpressAD(");
                    stringBuilder.append(aDEvent);
                    stringBuilder.append(k.t);
                    GDTLogger.e(stringBuilder.toString());
                    return;
                case 10:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeExpressADView)) {
                        this.a.b.onADCloseOverlay((NativeExpressADView) aDEvent.getParas()[0]);
                        return;
                    }
                    stringBuilder = new StringBuilder("ADEvent.Params error for NativeExpressAD(");
                    stringBuilder.append(aDEvent);
                    stringBuilder.append(k.t);
                    GDTLogger.e(stringBuilder.toString());
                    return;
                default:
                    return;
            }
        }
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, String str2, NativeExpressADListener nativeExpressADListener) {
        if (!(StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || aDSize == null)) {
            if (context != null) {
                this.c = true;
                if (a.a(context)) {
                    this.d = true;
                    this.b = nativeExpressADListener;
                    final Context context2 = context;
                    final String str3 = str;
                    final ADSize aDSize2 = aDSize;
                    final String str4 = str2;
                    GDTADManager.INIT_EXECUTOR.execute(new Runnable(this) {
                        final /* synthetic */ NativeExpressAD e;

                        public void run() {
                            if (GDTADManager.getInstance().initWith(context2, str3)) {
                                try {
                                    final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                                    new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                                        private /* synthetic */ AnonymousClass1 b;

                                        public void run() {
                                            try {
                                                if (pOFactory != null) {
                                                    this.b.e.a = pOFactory.getNativeExpressADDelegate(context2, aDSize2, str3, str4, new ADListenerAdapter());
                                                    this.b.e.f = true;
                                                    if (this.b.e.g != null) {
                                                        this.b.e.setBrowserType(this.b.e.g);
                                                    }
                                                    if (this.b.e.h != null) {
                                                        this.b.e.setDownAPPConfirmPolicy(this.b.e.h);
                                                    }
                                                    if (this.b.e.i != null) {
                                                        this.b.e.setVideoOption(this.b.e.i);
                                                    }
                                                    for (Integer intValue : this.b.e.e) {
                                                        this.b.e.loadAD(intValue.intValue());
                                                    }
                                                }
                                            } catch (Throwable th) {
                                                this.b.e.f = true;
                                            }
                                            this.b.e.f = true;
                                        }
                                    });
                                    return;
                                } catch (Throwable th) {
                                    GDTLogger.e("Exception while init Native Express AD plugin", th);
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
        GDTLogger.e(String.format("NativeExpressAD Constructor params error, adSize=%s, appid=%s, posId=%s, context=%s", new Object[]{aDSize, str, str2, context}));
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
                    GDTLogger.e("Native Express AD Init error, see more logs");
                    return;
                }
            }
        }
        GDTLogger.e("AD init Params OR Context error, details in logs produced while init NativeExpressAD");
    }

    public void setBrowserType(BrowserType browserType) {
        this.g = browserType;
        if (this.a != null && browserType != null) {
            this.a.setBrowserType(browserType.value());
        }
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.h = downAPPConfirmPolicy;
        if (this.a != null && downAPPConfirmPolicy != null) {
            this.a.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.i = videoOption;
        if (this.a != null && videoOption != null) {
            this.a.setVideoOption(videoOption);
        }
    }
}
