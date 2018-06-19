package com.umeng.socialize.net.stats.cache;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.Log;
import java.io.File;

/* compiled from: StatsCacheApis */
public class b {
    static String a = "b";
    private HandlerThread b;
    private Handler c;
    private c d;

    /* compiled from: StatsCacheApis */
    private static class a {
        private static final b a = new b();

        private a() {
        }
    }

    public static final b a() {
        return a.a;
    }

    private b() {
        this.b = new HandlerThread(Log.TAG, 10);
        this.b.start();
        this.c = new Handler(this.b.getLooper());
        Object b = b();
        if (!TextUtils.isEmpty(b)) {
            this.d = new c(b);
        }
    }

    public void a(final String str, final UMCacheListener uMCacheListener) {
        if (this.d != null) {
            this.c.post(new Runnable(this) {
                final /* synthetic */ b c;

                public void run() {
                    String str = b.a;
                    StringBuilder stringBuilder = new StringBuilder("save:");
                    stringBuilder.append(Thread.currentThread().getId());
                    Log.d(str, stringBuilder.toString());
                    boolean a = this.c.d.a(str);
                    if (uMCacheListener != null) {
                        uMCacheListener.onResult(a, null);
                    }
                }
            });
        }
    }

    public void a(final UMCacheListener uMCacheListener) {
        if (this.d != null) {
            this.c.post(new Runnable(this) {
                final /* synthetic */ b b;

                public void run() {
                    String str = b.a;
                    StringBuilder stringBuilder = new StringBuilder("read:");
                    stringBuilder.append(Thread.currentThread().getId());
                    Log.d(str, stringBuilder.toString());
                    com.umeng.socialize.net.stats.cache.c.a a = this.b.d.a();
                    if (uMCacheListener != null) {
                        uMCacheListener.onResult(a != null, a);
                    }
                }
            });
        }
    }

    public void b(final String str, final UMCacheListener uMCacheListener) {
        if (this.d != null) {
            this.c.post(new Runnable(this) {
                final /* synthetic */ b c;

                public void run() {
                    String str = b.a;
                    StringBuilder stringBuilder = new StringBuilder(ShareConstants.RES_DEL_TITLE);
                    stringBuilder.append(Thread.currentThread().getId());
                    Log.d(str, stringBuilder.toString());
                    boolean b = this.c.d.b(str);
                    if (uMCacheListener != null) {
                        uMCacheListener.onResult(b, null);
                    }
                }
            });
        }
    }

    private String b() {
        if (ContextUtil.getContext() == null) {
            return null;
        }
        Object packageName = ContextUtil.getContext().getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(File.separator);
        stringBuilder.append("data");
        stringBuilder.append(File.separator);
        stringBuilder.append("data");
        stringBuilder.append(File.separator);
        stringBuilder.append(packageName);
        stringBuilder.append(File.separator);
        stringBuilder.append("files");
        stringBuilder.append(File.separator);
        stringBuilder.append("umSocialStateLog");
        return stringBuilder.toString();
    }
}
