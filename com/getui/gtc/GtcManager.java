package com.getui.gtc;

import android.content.Context;
import com.getui.gtc.a.e;
import com.getui.gtc.a.f;
import com.getui.gtc.a.h;
import com.getui.gtc.c.d.a;
import com.getui.gtc.e.l;
import com.getui.gtc.entity.Ie;

public class GtcManager {
    private static final String TAG = "GtcManager_";

    class SdkInfo {
        private SdkInfo() {
        }

        private Ie getIe(int i) {
            return null;
        }

        private String getSdkAppId() {
            return l.b(h.a);
        }

        private int getSdkId() {
            return 1;
        }

        private String getSdkVersion() {
            return "GTC-1.1.1";
        }
    }

    public static void init(Context context) {
        e c = e.c();
        try {
            String[] strArr = new String[1];
            StringBuilder stringBuilder = new StringBuilder("thread id:");
            stringBuilder.append(Thread.currentThread().getId());
            strArr[0] = stringBuilder.toString();
            c.b = context;
            a.a.a(new f(c));
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
    }
}
