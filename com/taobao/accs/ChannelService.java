package com.taobao.accs;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.taobao.accs.base.BaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
public class ChannelService extends BaseService {
    public static final int DEFAULT_FORGROUND_V = 24;
    static final int NOTIFY_ID = 9371;
    public static int SDK_VERSION_CODE = 221;
    public static final String SUPPORT_FOREGROUND_VERSION_KEY = "support_foreground_v";
    static final String TAG = "ChannelService";
    private static ChannelService mInstance;
    private boolean mFristStarted = true;

    /* compiled from: Taobao */
    public static class KernelService extends Service {
        private static KernelService a;
        private Context b;

        public IBinder onBind(Intent intent) {
            return null;
        }

        public void onCreate() {
            super.onCreate();
            a = this;
            this.b = getApplicationContext();
        }

        public int onStartCommand(Intent intent, int i, int i2) {
            try {
                ThreadPoolExecutorFactory.execute(new a(this));
            } catch (Throwable th) {
                ALog.e(ChannelService.TAG, " onStartCommand", th, new Object[0]);
            }
            return super.onStartCommand(intent, i, i2);
        }

        public void onDestroy() {
            try {
                stopForeground(true);
            } catch (Throwable th) {
                ALog.e(ChannelService.TAG, "onDestroy", th, new Object[0]);
            }
            a = null;
            super.onDestroy();
        }
    }

    public static ChannelService getInstance() {
        return mInstance;
    }

    public void onCreate() {
        super.onCreate();
        mInstance = this;
        if (VERSION.SDK_INT < 18) {
            try {
                startForeground(NOTIFY_ID, new Notification());
            } catch (Throwable th) {
                ALog.e(TAG, "ChannelService onCreate", th, new Object[0]);
            }
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.mFristStarted) {
            this.mFristStarted = false;
            startKernel(getApplicationContext());
        }
        return super.onStartCommand(intent, i, i2);
    }

    public void onDestroy() {
        if (VERSION.SDK_INT < 18) {
            try {
                stopForeground(true);
            } catch (Throwable th) {
                ALog.e(TAG, "ChannelService onDestroy", th, new Object[0]);
            }
        }
        stopKernel(getApplicationContext());
        super.onDestroy();
    }

    static void startKernel(Context context) {
        try {
            if (VERSION.SDK_INT < getSupportForegroundVer(context)) {
                Intent intent = new Intent(context, KernelService.class);
                intent.setPackage(context.getPackageName());
                context.startService(intent);
            }
        } catch (Context context2) {
            ALog.e(TAG, "startKernel", context2, new Object[0]);
        }
    }

    static void stopKernel(Context context) {
        try {
            if (VERSION.SDK_INT < getSupportForegroundVer(context)) {
                Intent intent = new Intent(context, KernelService.class);
                intent.setPackage(context.getPackageName());
                context.stopService(intent);
            }
        } catch (Context context2) {
            ALog.e(TAG, "stopKernel", context2, new Object[0]);
        }
    }

    static int getSupportForegroundVer(Context context) {
        try {
            return context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getInt(SUPPORT_FOREGROUND_VERSION_KEY, 24);
        } catch (Context context2) {
            ALog.e(TAG, "getSupportForegroundVer fail:", context2, new Object[]{"key", SUPPORT_FOREGROUND_VERSION_KEY});
            return 24;
        }
    }
}
