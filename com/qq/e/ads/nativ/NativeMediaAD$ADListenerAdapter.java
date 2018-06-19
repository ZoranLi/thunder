package com.qq.e.ads.nativ;

import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.util.GDTLogger;
import com.umeng.message.proguard.k;
import java.util.List;

class NativeMediaAD$ADListenerAdapter implements ADListener {
    private /* synthetic */ NativeMediaAD a;

    private NativeMediaAD$ADListenerAdapter(NativeMediaAD nativeMediaAD) {
        this.a = nativeMediaAD;
    }

    public void onADEvent(ADEvent aDEvent) {
        if (NativeMediaAD.e(this.a) == null) {
            GDTLogger.i("No DevADListener Binded");
            return;
        }
        StringBuilder stringBuilder;
        switch (aDEvent.getType()) {
            case 1:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    NativeMediaAD.e(this.a).onNoAD(a.a(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                }
                stringBuilder = new StringBuilder("AdEvent.Paras error for NativeMediaAD(");
                stringBuilder.append(aDEvent);
                stringBuilder.append(k.t);
                GDTLogger.e(stringBuilder.toString());
                return;
            case 2:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                    NativeMediaAD.e(this.a).onADLoaded((List) aDEvent.getParas()[0]);
                    return;
                }
                stringBuilder = new StringBuilder("ADEvent.Paras error for NativeMediaAD(");
                stringBuilder.append(aDEvent);
                stringBuilder.append(k.t);
                GDTLogger.e(stringBuilder.toString());
                return;
            case 3:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                    NativeMediaAD.e(this.a).onADStatusChanged((NativeMediaADData) aDEvent.getParas()[0]);
                    return;
                }
                stringBuilder = new StringBuilder("ADEvent.Paras error for NativeMediaAD(");
                stringBuilder.append(aDEvent);
                stringBuilder.append(k.t);
                GDTLogger.e(stringBuilder.toString());
                return;
            case 4:
                if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeADDataRef) && (aDEvent.getParas()[1] instanceof Integer)) {
                    NativeMediaAD.e(this.a).onADError((NativeMediaADData) aDEvent.getParas()[0], a.a(((Integer) aDEvent.getParas()[1]).intValue()));
                    return;
                }
                stringBuilder = new StringBuilder("ADEvent.Paras error for NativeMediaAD(");
                stringBuilder.append(aDEvent);
                stringBuilder.append(k.t);
                GDTLogger.e(stringBuilder.toString());
                return;
            case 5:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                    NativeMediaAD.e(this.a).onADVideoLoaded((NativeMediaADData) aDEvent.getParas()[0]);
                    return;
                }
                stringBuilder = new StringBuilder("ADEvent.Paras error for NativeMediaAD(");
                stringBuilder.append(aDEvent);
                stringBuilder.append(k.t);
                GDTLogger.e(stringBuilder.toString());
                return;
            case 6:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                    NativeMediaAD.e(this.a).onADExposure((NativeMediaADData) aDEvent.getParas()[0]);
                    return;
                }
                stringBuilder = new StringBuilder("ADEvent.Paras error for NativeMediaAD(");
                stringBuilder.append(aDEvent);
                stringBuilder.append(k.t);
                GDTLogger.e(stringBuilder.toString());
                return;
            case 7:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                    NativeMediaAD.e(this.a).onADClicked((NativeMediaADData) aDEvent.getParas()[0]);
                    return;
                }
                stringBuilder = new StringBuilder("ADEvent.Paras error for NativeMediaAD(");
                stringBuilder.append(aDEvent);
                stringBuilder.append(k.t);
                GDTLogger.e(stringBuilder.toString());
                return;
            default:
                return;
        }
    }
}
