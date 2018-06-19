package com.qq.e.ads.nativ;

import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.util.GDTLogger;

public class MediaListenerAdapter implements ADListener {
    private MediaListener a;

    public MediaListenerAdapter(MediaListener mediaListener) {
        this.a = mediaListener;
    }

    public void onADEvent(ADEvent aDEvent) {
        switch (aDEvent.getType()) {
            case 1:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    this.a.onVideoReady((long) ((Integer) aDEvent.getParas()[0]).intValue());
                    return;
                } else {
                    GDTLogger.e("NativeMedia ADEvent Paras error!");
                    return;
                }
            case 2:
                this.a.onVideoStart();
                return;
            case 3:
                this.a.onVideoPause();
                return;
            case 4:
                this.a.onVideoComplete();
                return;
            case 5:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    this.a.onVideoError(a.a(((Integer) aDEvent.getParas()[0]).intValue()));
                    return;
                } else {
                    GDTLogger.e("NativeMedia ADEvent Paras error!");
                    return;
                }
            case 6:
                this.a.onReplayButtonClicked();
                return;
            case 7:
                this.a.onADButtonClicked();
                return;
            case 8:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Boolean)) {
                    this.a.onFullScreenChanged(((Boolean) aDEvent.getParas()[0]).booleanValue());
                    return;
                } else {
                    GDTLogger.e("NativeMedia ADEvent Paras error!");
                    return;
                }
            default:
                return;
        }
    }
}
