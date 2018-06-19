package com.xunlei.common.accelerator.utils;

import android.os.Handler;
import android.os.SystemClock;

public abstract class CountDownTimer {
    private static final int MSG = 1;
    private boolean mCancelled = false;
    private final long mCountdownInterval;
    private Handler mHandler = new Handler() {
        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r11) {
            /*
            r10 = this;
            r11 = com.xunlei.common.accelerator.utils.CountDownTimer.this;
            monitor-enter(r11);
            r0 = com.xunlei.common.accelerator.utils.CountDownTimer.this;	 Catch:{ all -> 0x0066 }
            r0 = r0.mCancelled;	 Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x000d;
        L_0x000b:
            monitor-exit(r11);	 Catch:{ all -> 0x0066 }
            return;
        L_0x000d:
            r0 = com.xunlei.common.accelerator.utils.CountDownTimer.this;	 Catch:{ all -> 0x0066 }
            r0 = r0.mStopTimeInFuture;	 Catch:{ all -> 0x0066 }
            r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0066 }
            r4 = r0 - r2;
            r0 = 0;
            r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
            if (r2 > 0) goto L_0x0025;
        L_0x001f:
            r0 = com.xunlei.common.accelerator.utils.CountDownTimer.this;	 Catch:{ all -> 0x0066 }
            r0.onFinish();	 Catch:{ all -> 0x0066 }
            goto L_0x0064;
        L_0x0025:
            r2 = com.xunlei.common.accelerator.utils.CountDownTimer.this;	 Catch:{ all -> 0x0066 }
            r2 = r2.mCountdownInterval;	 Catch:{ all -> 0x0066 }
            r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
            r2 = 1;
            if (r6 >= 0) goto L_0x0038;
        L_0x0030:
            r0 = r10.obtainMessage(r2);	 Catch:{ all -> 0x0066 }
            r10.sendMessageDelayed(r0, r4);	 Catch:{ all -> 0x0066 }
            goto L_0x0064;
        L_0x0038:
            r6 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0066 }
            r3 = com.xunlei.common.accelerator.utils.CountDownTimer.this;	 Catch:{ all -> 0x0066 }
            r3.onTick(r4);	 Catch:{ all -> 0x0066 }
            r3 = com.xunlei.common.accelerator.utils.CountDownTimer.this;	 Catch:{ all -> 0x0066 }
            r3 = r3.mCountdownInterval;	 Catch:{ all -> 0x0066 }
            r8 = r6 + r3;
            r3 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0066 }
            r5 = r8 - r3;
        L_0x004f:
            r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
            if (r3 >= 0) goto L_0x005d;
        L_0x0053:
            r3 = com.xunlei.common.accelerator.utils.CountDownTimer.this;	 Catch:{ all -> 0x0066 }
            r3 = r3.mCountdownInterval;	 Catch:{ all -> 0x0066 }
            r7 = r5 + r3;
            r5 = r7;
            goto L_0x004f;
        L_0x005d:
            r0 = r10.obtainMessage(r2);	 Catch:{ all -> 0x0066 }
            r10.sendMessageDelayed(r0, r5);	 Catch:{ all -> 0x0066 }
        L_0x0064:
            monitor-exit(r11);	 Catch:{ all -> 0x0066 }
            return;
        L_0x0066:
            r0 = move-exception;
            monitor-exit(r11);	 Catch:{ all -> 0x0066 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.accelerator.utils.CountDownTimer.1.handleMessage(android.os.Message):void");
        }
    };
    private final long mMillisInFuture;
    private long mStopTimeInFuture;

    public abstract void onFinish();

    public abstract void onTick(long j);

    public CountDownTimer(long j, long j2) {
        this.mMillisInFuture = j;
        this.mCountdownInterval = j2;
    }

    public final synchronized void cancel() {
        this.mCancelled = true;
        this.mHandler.removeMessages(1);
    }

    public final synchronized CountDownTimer start() {
        this.mCancelled = false;
        if (this.mMillisInFuture <= 0) {
            onFinish();
            return this;
        }
        this.mStopTimeInFuture = SystemClock.elapsedRealtime() + this.mMillisInFuture;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
        return this;
    }
}
