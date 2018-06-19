package com.umeng.message;

import com.umeng.message.common.UmLog;
import com.umeng.message.util.HttpRequest$a;
import org.json.JSONObject;

class UTrack$10 implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ UTrack b;

    UTrack$10(UTrack uTrack, byte[] bArr) {
        this.b = uTrack;
        this.a = bArr;
    }

    public void run() {
        Exception e;
        JSONObject e2;
        try {
            e2 = UTrack.e(this.b);
            try {
                e2.put("location", HttpRequest$a.a(this.a));
                e2.put(MsgConstant.KEY_LOCATION_INTERVAL, PushAgent.getInstance(UTrack.a(this.b)).getLocationInterval());
                UmLog.d(UTrack.a(), e2.toString());
                UTrack.b().trackLocation(e2, true);
            } catch (Exception e3) {
                e = e3;
                try {
                    UTrack.b().trackLocation(e2, false);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Exception e5) {
            Exception exception = e5;
            e2 = null;
            e4 = exception;
            if (e4.getMessage() != null && e4.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                UTrack.b().trackLocation(e2, false);
            }
        }
    }
}
