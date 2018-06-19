package com.xunlei.common.net.volley;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.android.volley.e;
import com.android.volley.h;
import com.android.volley.l;
import com.android.volley.toolbox.d;
import com.android.volley.toolbox.i;
import com.android.volley.toolbox.n;
import java.io.File;
import java.util.concurrent.Executor;

class VolleyModule {
    private static final String DEFAULT_CACHE_DIR = "volley_shoulei";
    private static final int DEFAULT_NETWORK_THREAD_POOL_SIZE = 6;
    private static volatile i sDiskBasedCache;

    VolleyModule() {
    }

    private static i getDiskBasedCache(Context context) {
        if (sDiskBasedCache == null) {
            synchronized (VolleyModule.class) {
                if (sDiskBasedCache == null) {
                    sDiskBasedCache = new i(new File(context.getCacheDir(), DEFAULT_CACHE_DIR), (byte) 0);
                }
            }
        }
        return sDiskBasedCache;
    }

    static l newRequestQueue(Context context, Executor executor) {
        h dVar = new d(new n());
        if (executor == null) {
            executor = new e(new Handler(Looper.getMainLooper()));
        } else {
            executor = new e(executor);
        }
        l lVar = new l(getDiskBasedCache(context), dVar, 6, executor);
        lVar.a();
        return lVar;
    }
}
