package com.baidu.mobads;

import android.content.Context;
import android.os.Looper;

public class CpuInfoManager {

    public interface UrlListener {
        void onUrl(String str);
    }

    public static void getCpuInfoUrl(Context context, String str, int i, UrlListener urlListener) {
        a(new j(context, i, str, urlListener));
    }

    private static void a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread(new l(runnable)).start();
        } else {
            runnable.run();
        }
    }
}
