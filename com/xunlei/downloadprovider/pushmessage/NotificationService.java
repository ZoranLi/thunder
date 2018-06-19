package com.xunlei.downloadprovider.pushmessage;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.h.l;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import com.xunlei.downloadprovider.pushmessage.notification.b;

public class NotificationService extends Service {
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static boolean a() {
        return l.e();
    }

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            i = intent.getStringExtra("notification_tag");
            boolean z = true;
            intent = intent.getIntExtra(PushResult.NOTIFICATION_ID, 1);
            i2 = b.a(i, intent);
            StringBuilder stringBuilder = new StringBuilder("notification ==null: ");
            if (i2 != 0) {
                z = false;
            }
            stringBuilder.append(z);
            stringBuilder.append(" tag: ");
            stringBuilder.append(i);
            stringBuilder.append(" id: ");
            stringBuilder.append(intent);
            if (i2 != 0) {
                startForeground(intent, i2);
                new Handler(Looper.getMainLooper()).postDelayed(new b(this), 500);
            }
        }
        return 2;
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
