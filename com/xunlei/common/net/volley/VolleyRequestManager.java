package com.xunlei.common.net.volley;

import android.annotation.SuppressLint;
import android.content.Context;
import com.android.volley.l;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class VolleyRequestManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    @SuppressLint({"StaticFieldLeak"})
    private static Impl sImpl = new Impl();

    private static class Impl {
        private Context mApplicationContext;
        private Executor mDeliveryExecutor;
        private volatile ExecutorService mDeliveryExecutorService;
        private l mMainThreadRequestQueue;
        private l mRequestQueue;

        private Impl() {
            this.mMainThreadRequestQueue = null;
            this.mRequestQueue = null;
            this.mApplicationContext = null;
            this.mDeliveryExecutor = new Executor() {
                public void execute(Runnable runnable) {
                    if (runnable != null) {
                        Impl.this.getExecutorService().execute(runnable);
                    }
                }
            };
        }

        Context getApplicationContext() {
            return this.mApplicationContext;
        }

        void setApplicationContext(Context context) {
            this.mApplicationContext = context;
        }

        private ExecutorService getExecutorService() {
            if (this.mDeliveryExecutorService == null) {
                synchronized (this) {
                    if (this.mDeliveryExecutorService == null) {
                        this.mDeliveryExecutorService = Executors.newFixedThreadPool(8);
                    }
                }
            }
            return this.mDeliveryExecutorService;
        }

        private synchronized l getRequestQueueImpl() {
            if (this.mRequestQueue == null) {
                this.mRequestQueue = VolleyModule.newRequestQueue(getApplicationContext(), this.mDeliveryExecutor);
            }
            return this.mRequestQueue;
        }

        private synchronized l getMainThreadRequestQueueImpl() {
            if (this.mMainThreadRequestQueue == null) {
                this.mMainThreadRequestQueue = VolleyModule.newRequestQueue(getApplicationContext(), null);
            }
            return this.mMainThreadRequestQueue;
        }
    }

    public static void init(Context context) {
        sImpl.setApplicationContext(context.getApplicationContext());
    }

    public static l getRequestQueue() {
        return sImpl.getRequestQueueImpl();
    }

    public static l getMainThreadRequestQueue() {
        return sImpl.getMainThreadRequestQueueImpl();
    }

    private VolleyRequestManager() {
    }
}
