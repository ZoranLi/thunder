package com.umeng.message;

import com.umeng.message.common.UmLog;
import com.umeng.message.proguard.l;
import com.umeng.message.proguard.l$a;
import java.util.ArrayList;

class UTrack$6 implements Runnable {
    final /* synthetic */ UTrack a;

    UTrack$6(UTrack uTrack) {
        this.a = uTrack;
    }

    public void run() {
        try {
            ArrayList a = l.a(UTrack.a(this.a)).a();
            for (int i = 0; i < a.size(); i++) {
                l$a com_umeng_message_proguard_l_a = (l$a) a.get(i);
                UTrack.a(this.a, com_umeng_message_proguard_l_a.a, com_umeng_message_proguard_l_a.c, com_umeng_message_proguard_l_a.b);
            }
        } catch (Throwable th) {
            UmLog.d(UTrack.a(), "sendCachedMsgLog finished, clear cacheLogSending flag");
            UTrack.a(false);
        }
        UmLog.d(UTrack.a(), "sendCachedMsgLog finished, clear cacheLogSending flag");
        UTrack.a(false);
    }
}
