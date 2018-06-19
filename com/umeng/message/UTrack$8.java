package com.umeng.message;

import com.umeng.message.common.UmLog;
import com.umeng.message.proguard.c;
import org.json.JSONArray;
import org.json.JSONObject;

class UTrack$8 implements Runnable {
    final /* synthetic */ UTrack a;

    UTrack$8(UTrack uTrack) {
        this.a = uTrack;
    }

    public void run() {
        Exception e;
        JSONObject b;
        try {
            b = UTrack.b(this.a);
            try {
                JSONArray c = UTrack.c(this.a);
                if (c != null) {
                    b.put(MsgConstant.KEY_UCODE, c.a(c.toString()));
                }
                UTrack.b().trackAppLaunch(b, true);
                UTrack.c(false);
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    UTrack.b().trackAppLaunch(b, false);
                } catch (Exception e3) {
                    e3.printStackTrace();
                } catch (Throwable th) {
                    UTrack.c(false);
                }
                UmLog.d(UTrack.a(), e.toString());
                UTrack.c(false);
            }
        } catch (Exception e32) {
            Exception exception = e32;
            b = null;
            e = exception;
            e.printStackTrace();
            if (e.getMessage() != null && e.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                UTrack.b().trackAppLaunch(b, false);
            }
            UmLog.d(UTrack.a(), e.toString());
            UTrack.c(false);
        }
    }
}
