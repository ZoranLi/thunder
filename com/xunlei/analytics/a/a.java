package com.xunlei.analytics.a;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.xunlei.analytics.HubbleAgent;
import com.xunlei.analytics.c.b;
import com.xunlei.analytics.c.e;
import com.xunlei.analytics.c.f;
import java.util.List;

public class a {
    private static volatile a c = null;
    private static final int d = 3000;
    private static final int e = 3100;
    private HandlerThread a;
    private Handler b;
    private int f = 0;
    private Callback g = new Callback(this) {
        final /* synthetic */ a a;

        {
            this.a = r1;
        }

        public boolean handleMessage(Message message) {
            if (!this.a.b(HubbleAgent.getReportConfiguration().reportRule)) {
                return true;
            }
            int a = com.xunlei.analytics.dbstore.a.a().a(System.currentTimeMillis() - HubbleAgent.getReportConfiguration().deleteExpirationDayTime) + f.a(com.xunlei.analytics.config.a.d());
            List a2 = com.xunlei.analytics.dbstore.a.a().a(HubbleAgent.getReportConfiguration().batchUploadCount);
            if (a2 == null || a2.size() == 0) {
                return true;
            }
            this.a.a(a);
            if (b.a(a2, a)) {
                com.xunlei.analytics.dbstore.a.a().b(a2);
                f.b(com.xunlei.analytics.config.a.d());
                if (a > 0) {
                    f.a(com.xunlei.analytics.config.a.d(), 0);
                }
                this.a.f = 0;
            } else {
                this.a.f = this.a.f + 1;
                f.a(com.xunlei.analytics.config.a.d(), a);
            }
            this.a.a(true);
            return true;
        }
    };

    private a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("-QueryAndUploadThread");
        this.a = new HandlerThread(stringBuilder.toString());
        this.a.start();
        this.b = new Handler(this.a.getLooper(), this.g);
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    private void a(int i) {
        if (i > 0 && e.a()) {
            StringBuilder stringBuilder = new StringBuilder("delete expiration event count:");
            stringBuilder.append(i);
            e.a(stringBuilder.toString());
        }
    }

    private void b() {
        this.b.removeMessages(e);
        this.b.sendMessageDelayed(this.b.obtainMessage(e), HubbleAgent.getReportConfiguration().reportCheckInterval);
    }

    private boolean b(int i) {
        if (!com.xunlei.analytics.config.a.g() || !b.e(com.xunlei.analytics.config.a.d()) || this.f > HubbleAgent.getReportConfiguration().reportRetryCount) {
            return false;
        }
        int b = com.xunlei.analytics.dbstore.a.a().b();
        if (b > 0 && i == 0) {
            i = b.g(com.xunlei.analytics.config.a.d());
            if (HubbleAgent.getReportConfiguration().isWifiOnly && i != 1) {
                return false;
            }
            if (b >= HubbleAgent.getReportConfiguration().batchUploadCount || System.currentTimeMillis() - f.c(com.xunlei.analytics.config.a.d()) >= HubbleAgent.getReportConfiguration().reportCheckInterval) {
                return true;
            }
            if (!this.b.hasMessages(e)) {
                b();
            }
        }
        return false;
    }

    public void a(boolean z) {
        if (!z) {
            this.f = 0;
        }
        this.b.removeMessages(3000);
        this.b.obtainMessage(3000).sendToTarget();
    }
}
