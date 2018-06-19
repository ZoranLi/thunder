package com.umeng.message;

import com.umeng.message.common.UmLog;
import com.umeng.message.proguard.h;
import org.json.JSONObject;

class UTrack$9 implements Runnable {
    final /* synthetic */ UTrack a;

    UTrack$9(UTrack uTrack) {
        this.a = uTrack;
    }

    public void run() {
        JSONObject b;
        Exception e;
        try {
            b = UTrack.b(this.a);
            try {
                String a = UTrack.a();
                StringBuilder stringBuilder = new StringBuilder("trackRegister-->request:");
                stringBuilder.append(b.toString());
                UmLog.i(a, stringBuilder.toString());
                a = UTrack.d(this.a);
                if (!h.d(a)) {
                    String a2 = UTrack.a();
                    StringBuilder stringBuilder2 = new StringBuilder("TestDevice sign =");
                    stringBuilder2.append(a);
                    UmLog.d(a2, stringBuilder2.toString());
                    b.put("TD", a);
                }
                UTrack.b().trackRegister(b, true);
                UTrack.d(false);
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    if (e.getMessage() != null && e.getMessage().contains(MsgConstant.HTTPS_ERROR)) {
                        UTrack.b().trackRegister(b, false);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                } catch (Throwable th) {
                    UTrack.d(false);
                }
                UTrack.d(false);
            }
        } catch (Exception e4) {
            Exception exception = e4;
            b = null;
            e3 = exception;
            e3.printStackTrace();
            UTrack.b().trackRegister(b, false);
            UTrack.d(false);
        }
    }
}
