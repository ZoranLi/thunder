package com.getui.gtc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Base64;
import com.getui.gtc.a.a;
import com.getui.gtc.a.e;
import java.util.concurrent.atomic.AtomicBoolean;

public class GtcService extends Service {
    private final AtomicBoolean a = new AtomicBoolean(false);

    private static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            e.c().a(str);
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        new String[1][0] = "onCreate";
    }

    public void onDestroy() {
        new String[1][0] = "gtc service on destroy.";
        e.c();
        e.b();
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        String str = null;
        if (intent != null) {
            try {
                if (intent.hasExtra(a.d)) {
                    str = new String(Base64.decode(intent.getByteArrayExtra(a.d), 0));
                }
            } catch (Throwable th) {
                new String[1][0] = th.toString();
                return 1;
            }
        }
        String[] strArr = new String[1];
        StringBuilder stringBuilder = new StringBuilder("gtc on start command schedule . is init:");
        stringBuilder.append(this.a.get());
        strArr[0] = stringBuilder.toString();
        if (!this.a.getAndSet(true)) {
            GtcManager.init(this);
        }
        a(str);
        return 1;
    }
}
