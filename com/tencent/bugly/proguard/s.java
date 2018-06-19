package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.download.b;
import com.tencent.bugly.beta.global.e;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: BUGLY */
public class s implements b {
    public static s a = new s();
    public ConcurrentHashMap<String, DownloadTask> b = new ConcurrentHashMap(3);
    private ScheduledExecutorService c = null;

    public s() {
        try {
            this.c = Executors.newScheduledThreadPool(3, new ThreadFactory(this) {
                final /* synthetic */ s a;

                {
                    this.a = r1;
                }

                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("BETA_SDK_DOWNLOAD");
                    return thread;
                }
            });
            if (this.c.isShutdown()) {
                throw new IllegalArgumentException("ScheduledExecutorService is not available!");
            }
        } catch (Throwable e) {
            an.a(e);
        }
    }

    public DownloadTask a(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            an.e("downloadUrl is null!", new Object[0]);
            return null;
        } else if (TextUtils.isEmpty(str2)) {
            an.e("saveDir is null!", new Object[0]);
            return null;
        } else if (this.b.get(str) != null) {
            return (DownloadTask) this.b.get(str);
        } else {
            DownloadTask downloadTask;
            ContentValues a = p.a.a(str);
            if (a == null || a.get("_dUrl") == null || a.getAsString("_sFile") == null || a.getAsLong("_sLen") == null || a.getAsLong("_tLen") == null || a.getAsString("_MD5") == null) {
                downloadTask = null;
            } else {
                DownloadTask tVar = new t((String) a.get("_dUrl"), a.getAsString("_sFile"), a.getAsLong("_sLen").longValue(), a.getAsLong("_tLen").longValue(), a.getAsString("_MD5"));
                if (a.getAsLong("_DLTIME") != null) {
                    tVar.k = a.getAsLong("_DLTIME").longValue();
                }
            }
            if (downloadTask == null) {
                downloadTask = new t(str, str2, str3, str4);
            }
            downloadTask.setDownloadType(e.E.ac);
            return downloadTask;
        }
    }

    public synchronized boolean a(Runnable runnable) {
        if (this.c != null) {
            if (!this.c.isShutdown()) {
                if (runnable == null) {
                    an.d("async task = null", new Object[0]);
                    return false;
                }
                an.d("task start %s", runnable.getClass().getName());
                this.c.execute(runnable);
                return true;
            }
        }
        an.d("async handler was closed , should not post task!", new Object[0]);
        return false;
    }
}
