package com.xunlei.downloadprovider.download.assistant.clipboardmonitor;

import android.app.IntentService;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.xunlei.download.proguard.c;

public class ClipboardService extends IntentService implements OnPrimaryClipChangedListener {
    private static final String b = "ClipboardService";
    ClipboardManager a;
    private String c = "";

    public ClipboardService() {
        super(b);
    }

    public static void a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x001e }
        r0.<init>();	 Catch:{ Exception -> 0x001e }
        r1 = new android.content.ComponentName;	 Catch:{ Exception -> 0x001e }
        r2 = "com.xunlei.downloadprovider";	 Catch:{ Exception -> 0x001e }
        r3 = "com.xunlei.downloadprovider.download.assistant.clipboardmonitor.ClipboardService";	 Catch:{ Exception -> 0x001e }
        r1.<init>(r2, r3);	 Catch:{ Exception -> 0x001e }
        r0.setComponent(r1);	 Catch:{ Exception -> 0x001e }
        r1 = "com.xunlei.downloadprovider";	 Catch:{ Exception -> 0x001e }
        r0.setPackage(r1);	 Catch:{ Exception -> 0x001e }
        r1 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();	 Catch:{ Exception -> 0x001e }
        r1.startService(r0);	 Catch:{ Exception -> 0x001e }
        return;
    L_0x001e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.assistant.clipboardmonitor.ClipboardService.a():void");
    }

    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            new Handler(getMainLooper()).post(new k(this));
            while (true) {
                try {
                    Thread.sleep(c.x);
                } catch (Intent intent2) {
                    intent2.printStackTrace();
                }
                b();
            }
        }
    }

    public void onPrimaryClipChanged() {
        b();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void b() {
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = r7.a;	 Catch:{ all -> 0x00d2 }
        r1 = 0;
        r2 = 0;
        if (r0 == 0) goto L_0x0030;
    L_0x0007:
        r0 = r0.getPrimaryClip();	 Catch:{ Throwable -> 0x000c }
        goto L_0x0011;
    L_0x000c:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00d2 }
        r0 = r2;
    L_0x0011:
        if (r0 == 0) goto L_0x0030;
    L_0x0013:
        r3 = r0.getItemCount();	 Catch:{ all -> 0x00d2 }
        if (r3 <= 0) goto L_0x0030;
    L_0x0019:
        r0 = r0.getItemAt(r1);	 Catch:{ all -> 0x00d2 }
        r3 = r0.getText();	 Catch:{ all -> 0x00d2 }
        if (r3 == 0) goto L_0x0030;
    L_0x0023:
        r0 = r0.getText();	 Catch:{ all -> 0x00d2 }
        r0 = r0.toString();	 Catch:{ all -> 0x00d2 }
        r0 = r0.trim();	 Catch:{ all -> 0x00d2 }
        goto L_0x0031;
    L_0x0030:
        r0 = r2;
    L_0x0031:
        r3 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x00d2 }
        if (r3 != 0) goto L_0x00d0;
    L_0x0037:
        r3 = r7.c;	 Catch:{ all -> 0x00d2 }
        r3 = r0.equals(r3);	 Catch:{ all -> 0x00d2 }
        if (r3 != 0) goto L_0x00d0;
    L_0x003f:
        r7.c = r0;	 Catch:{ all -> 0x00d2 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d2 }
        r4 = "handleClipboardTextChanged - Text{";
        r3.<init>(r4);	 Catch:{ all -> 0x00d2 }
        r3.append(r0);	 Catch:{ all -> 0x00d2 }
        r4 = "}";
        r3.append(r4);	 Catch:{ all -> 0x00d2 }
        r0 = com.xunlei.downloadprovider.h.k.a.a(r0);	 Catch:{ all -> 0x00d2 }
        r3 = r0.a;	 Catch:{ all -> 0x00d2 }
        if (r3 == 0) goto L_0x005e;
    L_0x0058:
        r2 = r0.a;	 Catch:{ all -> 0x00d2 }
        r2 = r2.trim();	 Catch:{ all -> 0x00d2 }
    L_0x005e:
        r0 = r0.b;	 Catch:{ all -> 0x00d2 }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x00d2 }
        r4 = 3;
        r5 = 1;
        if (r3 != 0) goto L_0x0086;
    L_0x0068:
        r3 = com.xunlei.downloadprovider.h.k.h(r2);	 Catch:{ all -> 0x00d2 }
        if (r5 != r3) goto L_0x0076;
    L_0x006e:
        r3 = com.xunlei.downloadprovider.h.k.c(r2);	 Catch:{ all -> 0x00d2 }
        if (r3 != 0) goto L_0x0086;
    L_0x0074:
        r3 = r5;
        goto L_0x0087;
    L_0x0076:
        r3 = com.xunlei.downloadprovider.h.k.a.d(r2);	 Catch:{ all -> 0x00d2 }
        if (r3 == 0) goto L_0x007e;
    L_0x007c:
        r3 = 2;
        goto L_0x0087;
    L_0x007e:
        r3 = com.xunlei.downloadprovidershare.q.a(r2);	 Catch:{ all -> 0x00d2 }
        if (r3 == 0) goto L_0x0086;
    L_0x0084:
        r3 = 4;
        goto L_0x0087;
    L_0x0086:
        r3 = r4;
    L_0x0087:
        r5 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x00d2 }
        if (r5 != 0) goto L_0x00d0;
    L_0x008d:
        r5 = r7.getApplicationContext();	 Catch:{ all -> 0x00d2 }
        r6 = "com.xunlei.downloadprovider";
        r5 = com.xunlei.common.androidutil.OSUtil.isAppRunning(r5, r6);	 Catch:{ all -> 0x00d2 }
        if (r5 != 0) goto L_0x00d0;
    L_0x0099:
        r5 = com.xunlei.downloadprovider.h.l.b();	 Catch:{ all -> 0x00d2 }
        if (r5 == 0) goto L_0x00ae;
    L_0x009f:
        if (r3 == r4) goto L_0x00ae;
    L_0x00a1:
        r4 = com.xunlei.downloadprovider.download.assistant.clipboardmonitor.f.b();	 Catch:{ all -> 0x00d2 }
        r4.a = r1;	 Catch:{ all -> 0x00d2 }
        r1 = "umeng";
        r4.b(r2, r0, r3, r1);	 Catch:{ all -> 0x00d2 }
        monitor-exit(r7);
        return;
    L_0x00ae:
        r1 = new android.content.Intent;	 Catch:{ all -> 0x00d2 }
        r4 = "com.xunlei.downloadprovider.clipboard";
        r1.<init>(r4);	 Catch:{ all -> 0x00d2 }
        r4 = "com.xunlei.downloadprovider";
        r1.setPackage(r4);	 Catch:{ all -> 0x00d2 }
        r4 = "url";
        r1.putExtra(r4, r2);	 Catch:{ all -> 0x00d2 }
        r2 = "isAutoComplemented";
        r1.putExtra(r2, r0);	 Catch:{ all -> 0x00d2 }
        r0 = "type";
        r1.putExtra(r0, r3);	 Catch:{ all -> 0x00d2 }
        r0 = r7.getApplicationContext();	 Catch:{ all -> 0x00d2 }
        r0.sendBroadcast(r1);	 Catch:{ all -> 0x00d2 }
    L_0x00d0:
        monitor-exit(r7);
        return;
    L_0x00d2:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.assistant.clipboardmonitor.ClipboardService.b():void");
    }
}
