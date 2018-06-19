package com.umeng.message;

import com.umeng.message.common.UmLog;
import org.json.JSONObject;

class UTrack$12 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ UTrack b;

    UTrack$12(UTrack uTrack, String str) {
        this.b = uTrack;
        this.a = str;
    }

    public void run() {
        if (MessageSharedPrefs.getInstance(UTrack.a(this.b)).getDaRegisterSendPolicy() == 1) {
            UmLog.d(UTrack.a(), "da_register_policy=1, skip sending da_register info.");
            return;
        }
        try {
            JSONObject b = UTrack.b(this.b);
            b.put("registerLog", this.a);
            UTrack.b().sendRegisterLog(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
