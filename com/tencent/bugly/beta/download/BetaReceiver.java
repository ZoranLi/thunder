package com.tencent.bugly.beta.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.bugly.beta.global.a;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.ui.f;
import com.tencent.bugly.proguard.am;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: BUGLY */
public class BetaReceiver extends BroadcastReceiver {
    public static String CONNECTIVITY_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";
    public static ConcurrentHashMap<String, c> netListeners = new ConcurrentHashMap(3);
    public static int netStatus;

    public static synchronized void addTask(DownloadTask downloadTask) {
        synchronized (BetaReceiver.class) {
            netStatus = a.a(e.E.s);
            new f().n = downloadTask;
            netListeners.put(downloadTask.getDownloadUrl(), new c(2, new Object[]{downloadTask, Boolean.valueOf(false), r1}));
        }
    }

    public synchronized void onReceive(Context context, Intent intent) {
        am.a().a(new 1(this, intent, context));
    }
}
