package com.umeng.message.common.impl.json;

import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.common.UmengMessageDeviceConfig;
import com.umeng.message.entity.Ucode;
import com.umeng.message.proguard.h;
import java.util.List;

class JUtrack$1 implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ JUtrack b;

    JUtrack$1(JUtrack jUtrack, List list) {
        this.b = jUtrack;
        this.a = list;
    }

    public void run() {
        try {
            Thread.sleep(10000);
            for (int i = 0; i < this.a.size(); i++) {
                Ucode ucode = (Ucode) this.a.get(i);
                ucode.b = UmengMessageDeviceConfig.getDataData(ucode.p);
            }
            MessageSharedPrefs.getInstance(JUtrack.a(this.b)).setUcode(h.a(this.a));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
