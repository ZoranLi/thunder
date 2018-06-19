package com.umeng.message;

import com.umeng.message.common.UmLog;
import com.umeng.message.proguard.l;
import com.umeng.message.proguard.l$b;
import java.util.ArrayList;

class UTrack$7 implements Runnable {
    final /* synthetic */ UTrack a;

    UTrack$7(UTrack uTrack) {
        this.a = uTrack;
    }

    public void run() {
        try {
            ArrayList c = l.a(UTrack.a(this.a)).c();
            for (int i = 0; i < c.size(); i++) {
                l$b com_umeng_message_proguard_l_b = (l$b) c.get(i);
                this.a.sendMsgLogForAgoo(com_umeng_message_proguard_l_b.a, com_umeng_message_proguard_l_b.b, com_umeng_message_proguard_l_b.c, com_umeng_message_proguard_l_b.d);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            UmLog.d(UTrack.a(), th.toString());
        } finally {
            UTrack.b(false);
        }
    }
}
