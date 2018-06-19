package com.qq.e.ads.contentad;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.nativ.NativeMediaADData;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.CAI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.umeng.message.proguard.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentAD {
    private BrowserType a;
    private DownAPPConfirmPolicy b;
    private CAI c;
    private boolean d;
    private ContentADListener e;
    private boolean f;
    private List<Map<String, Object>> g = new ArrayList();
    private boolean h = false;

    public interface ContentADListener {
        void onADVideoLoaded(ContentAdData contentAdData);

        void onContentADError(ContentAdData contentAdData, int i);

        void onContentADLoaded(List<ContentAdData> list);

        void onContentADStatusChanged(ContentAdData contentAdData);

        void onNoContentAD(int i);
    }

    class ADListenerAdapter implements ADListener {
        private /* synthetic */ ContentAD a;

        private ADListenerAdapter(ContentAD contentAD) {
            this.a = contentAD;
        }

        public void onADEvent(ADEvent aDEvent) {
            if (this.a.e == null) {
                GDTLogger.i("No DevADListener Binded");
                return;
            }
            StringBuilder stringBuilder;
            switch (aDEvent.getType()) {
                case 1:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        this.a.e.onNoContentAD(((Integer) aDEvent.getParas()[0]).intValue());
                        return;
                    }
                    stringBuilder = new StringBuilder("AdEvent.Paras error for ContentAD(");
                    stringBuilder.append(aDEvent);
                    stringBuilder.append(k.t);
                    GDTLogger.e(stringBuilder.toString());
                    return;
                case 2:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                        this.a.e.onContentADLoaded((List) aDEvent.getParas()[0]);
                        return;
                    }
                    stringBuilder = new StringBuilder("ADEvent.Paras error for ContentAD(");
                    stringBuilder.append(aDEvent);
                    stringBuilder.append(k.t);
                    GDTLogger.e(stringBuilder.toString());
                    return;
                case 3:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                        this.a.e.onContentADStatusChanged((NativeMediaADData) aDEvent.getParas()[0]);
                        return;
                    }
                    stringBuilder = new StringBuilder("ADEvent.Paras error for ContentAD(");
                    stringBuilder.append(aDEvent);
                    stringBuilder.append(k.t);
                    GDTLogger.e(stringBuilder.toString());
                    return;
                case 4:
                    if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof ContentAdData) && (aDEvent.getParas()[1] instanceof Integer)) {
                        this.a.e.onContentADError((ContentAdData) aDEvent.getParas()[0], ((Integer) aDEvent.getParas()[1]).intValue());
                        return;
                    }
                    stringBuilder = new StringBuilder("ADEvent.Paras error for ContentAD(");
                    stringBuilder.append(aDEvent);
                    stringBuilder.append(k.t);
                    GDTLogger.e(stringBuilder.toString());
                    return;
                case 5:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                        this.a.e.onADVideoLoaded((NativeMediaADData) aDEvent.getParas()[0]);
                        return;
                    }
                    stringBuilder = new StringBuilder("ADEvent.Paras error for ContentAD(");
                    stringBuilder.append(aDEvent);
                    stringBuilder.append(k.t);
                    GDTLogger.e(stringBuilder.toString());
                    return;
                default:
                    return;
            }
        }
    }

    public ContentAD(final Context context, final String str, final String str2, ContentADListener contentADListener) {
        if (!(StringUtil.isEmpty(str) || StringUtil.isEmpty(str2))) {
            if (context != null) {
                this.d = true;
                if (a.a(context)) {
                    this.f = true;
                    this.e = contentADListener;
                    GDTADManager.INIT_EXECUTOR.execute(new Runnable(this) {
                        final /* synthetic */ ContentAD d;

                        public void run() {
                            if (GDTADManager.getInstance().initWith(context, str)) {
                                try {
                                    final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                                    new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                                        private /* synthetic */ AnonymousClass1 b;

                                        public void run() {
                                            try {
                                                if (pOFactory != null) {
                                                    this.b.d.c = pOFactory.getContentAdDelegate(context, str, str2, new ADListenerAdapter());
                                                    this.b.d.h = true;
                                                    if (this.b.d.a != null) {
                                                        this.b.d.setBrowserType(this.b.d.a);
                                                    }
                                                    if (this.b.d.b != null) {
                                                        this.b.d.setDownAPPConfirmPolicy(this.b.d.b);
                                                    }
                                                    for (Map map : this.b.d.g) {
                                                        this.b.d.loadAD(((Integer) map.get("page_number")).intValue(), ((Integer) map.get("channel")).intValue(), ((Boolean) map.get("is_manual_operation")).booleanValue());
                                                    }
                                                }
                                            } catch (Throwable th) {
                                                this.b.d.h = true;
                                            }
                                            this.b.d.h = true;
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
        GDTLogger.e(String.format("GDTContentAd Contructor paras error,appid=%s,posId=%s,context=%s", new Object[]{str, str2, context}));
    }

    public void loadAD(int i, int i2, boolean z) {
        if (this.d) {
            if (this.f) {
                if (!this.h) {
                    Map hashMap = new HashMap();
                    hashMap.put("page_number", Integer.valueOf(i));
                    hashMap.put("channel", Integer.valueOf(i2));
                    hashMap.put("is_manual_operation", Boolean.valueOf(z));
                    this.g.add(hashMap);
                    return;
                } else if (this.c != null) {
                    this.c.loadAd(i, i2, z);
                    return;
                } else {
                    GDTLogger.e("ContentAD Init error,See More Logs");
                    return;
                }
            }
        }
        GDTLogger.e("AD init Paras OR Context error,details in logs produced while init ContentAD");
    }

    public void setBrowserType(BrowserType browserType) {
        this.a = browserType;
        if (this.c != null && browserType != null) {
            this.c.setBrowserType(browserType.value());
        }
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.b = downAPPConfirmPolicy;
        if (this.c != null && downAPPConfirmPolicy != null) {
            this.c.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }
}
