package com.qq.e.ads.nativ;

import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.util.GDTLogger;
import com.umeng.message.proguard.k;
import java.util.List;

class NativeAD$ADListenerAdapter implements ADListener {
    private /* synthetic */ NativeAD a;

    private NativeAD$ADListenerAdapter(NativeAD nativeAD) {
        this.a = nativeAD;
    }

    public void onADEvent(ADEvent aDEvent) {
        if (NativeAD.f(this.a) == null) {
            GDTLogger.i("No DevADListener Binded");
            return;
        }
        StringBuilder stringBuilder;
        switch (aDEvent.getType()) {
            case 1:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    NativeAD.f(this.a).onNoAD(a.a(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                }
                stringBuilder = new StringBuilder("AdEvent.Paras error for NativeAD(");
                stringBuilder.append(aDEvent);
                stringBuilder.append(k.t);
                GDTLogger.e(stringBuilder.toString());
                return;
            case 2:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                    NativeAD.f(this.a).onADLoaded((List) aDEvent.getParas()[0]);
                    return;
                }
                stringBuilder = new StringBuilder("ADEvent.Paras error for NativeAD(");
                stringBuilder.append(aDEvent);
                stringBuilder.append(k.t);
                GDTLogger.e(stringBuilder.toString());
                return;
            case 3:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeADDataRef)) {
                    NativeAD.f(this.a).onADStatusChanged((NativeADDataRef) aDEvent.getParas()[0]);
                    return;
                }
                stringBuilder = new StringBuilder("ADEvent.Paras error for NativeAD(");
                stringBuilder.append(aDEvent);
                stringBuilder.append(k.t);
                GDTLogger.e(stringBuilder.toString());
                return;
            case 4:
                if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeADDataRef) && (aDEvent.getParas()[1] instanceof Integer)) {
                    NativeAD.f(this.a).onADError((NativeADDataRef) aDEvent.getParas()[0], a.a(((Integer) aDEvent.getParas()[1]).intValue()));
                    return;
                }
                stringBuilder = new StringBuilder("ADEvent.Paras error for NativeAD(");
                stringBuilder.append(aDEvent);
                stringBuilder.append(k.t);
                GDTLogger.e(stringBuilder.toString());
                return;
            default:
                return;
        }
    }
}
