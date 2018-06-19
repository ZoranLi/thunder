package com.tencent.smtt.sdk;

import android.os.HandlerThread;

class ai extends HandlerThread {
    private static ai a;

    public ai(String str) {
        super(str);
    }

    public static synchronized ai a() {
        ai aiVar;
        synchronized (ai.class) {
            if (a == null) {
                aiVar = new ai("TbsHandlerThread");
                a = aiVar;
                aiVar.start();
            }
            aiVar = a;
        }
        return aiVar;
    }
}
