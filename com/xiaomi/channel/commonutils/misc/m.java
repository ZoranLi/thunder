package com.xiaomi.channel.commonutils.misc;

import android.os.Looper;
import com.xiaomi.channel.commonutils.logger.b;

public class m {
    public static void a(boolean z) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread() && z) {
            StringBuilder stringBuilder = new StringBuilder("can't do this on ui thread when debug_switch:");
            stringBuilder.append(z);
            throw new RuntimeException(stringBuilder.toString());
        } else if (Looper.getMainLooper().getThread() == Thread.currentThread() && !z) {
            StringBuilder stringBuilder2 = new StringBuilder("can't do this on ui thread when debug_switch:");
            stringBuilder2.append(z);
            b.a(stringBuilder2.toString());
        }
    }
}
