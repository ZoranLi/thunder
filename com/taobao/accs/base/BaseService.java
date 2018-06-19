package com.taobao.accs.base;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
public class BaseService extends Service {
    private static final String TAG = "BaseService";
    IBaseService mBaseService = null;

    public void onCreate() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        super.onCreate();
        r0 = 1;
        r1 = 0;
        r2 = com.taobao.accs.d.a.a();	 Catch:{ Throwable -> 0x0050 }
        r3 = r6.getApplicationContext();	 Catch:{ Throwable -> 0x0050 }
        r2 = r2.a(r3);	 Catch:{ Throwable -> 0x0050 }
        r3 = "com.taobao.accs.internal.ServiceImpl";	 Catch:{ Throwable -> 0x0050 }
        r2 = r2.loadClass(r3);	 Catch:{ Throwable -> 0x0050 }
        r3 = new java.lang.Class[r0];	 Catch:{ Throwable -> 0x0050 }
        r4 = android.app.Service.class;	 Catch:{ Throwable -> 0x0050 }
        r3[r1] = r4;	 Catch:{ Throwable -> 0x0050 }
        r2 = r2.getDeclaredConstructor(r3);	 Catch:{ Throwable -> 0x0050 }
        r3 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x0050 }
        r3[r1] = r6;	 Catch:{ Throwable -> 0x0050 }
        r2 = r2.newInstance(r3);	 Catch:{ Throwable -> 0x0050 }
        r2 = (com.taobao.accs.base.IBaseService) r2;	 Catch:{ Throwable -> 0x0050 }
        r6.mBaseService = r2;	 Catch:{ Throwable -> 0x0050 }
        r2 = r6.mBaseService;
        if (r2 != 0) goto L_0x0071;
    L_0x0031:
        r2 = "com.taobao.accs.internal.ServiceImpl";	 Catch:{ Throwable -> 0x0071 }
        r2 = java.lang.Class.forName(r2);	 Catch:{ Throwable -> 0x0071 }
        r3 = new java.lang.Class[r0];	 Catch:{ Throwable -> 0x0071 }
        r4 = android.app.Service.class;	 Catch:{ Throwable -> 0x0071 }
        r3[r1] = r4;	 Catch:{ Throwable -> 0x0071 }
        r2 = r2.getDeclaredConstructor(r3);	 Catch:{ Throwable -> 0x0071 }
        r0 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x0071 }
        r0[r1] = r6;	 Catch:{ Throwable -> 0x0071 }
        r0 = r2.newInstance(r0);	 Catch:{ Throwable -> 0x0071 }
    L_0x0049:
        r0 = (com.taobao.accs.base.IBaseService) r0;	 Catch:{ Throwable -> 0x0071 }
        r6.mBaseService = r0;	 Catch:{ Throwable -> 0x0071 }
        goto L_0x0071;
    L_0x004e:
        r2 = move-exception;
        goto L_0x008e;
    L_0x0050:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ all -> 0x004e }
        r2 = r6.mBaseService;
        if (r2 != 0) goto L_0x0071;
    L_0x0058:
        r2 = "com.taobao.accs.internal.ServiceImpl";	 Catch:{ Throwable -> 0x0071 }
        r2 = java.lang.Class.forName(r2);	 Catch:{ Throwable -> 0x0071 }
        r3 = new java.lang.Class[r0];	 Catch:{ Throwable -> 0x0071 }
        r4 = android.app.Service.class;	 Catch:{ Throwable -> 0x0071 }
        r3[r1] = r4;	 Catch:{ Throwable -> 0x0071 }
        r2 = r2.getDeclaredConstructor(r3);	 Catch:{ Throwable -> 0x0071 }
        r0 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x0071 }
        r0[r1] = r6;	 Catch:{ Throwable -> 0x0071 }
        r0 = r2.newInstance(r0);	 Catch:{ Throwable -> 0x0071 }
        goto L_0x0049;
    L_0x0071:
        r0 = "BaseService";
        r2 = "onCreate";
        r3 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.d(r0, r2, r3);
        r0 = r6.mBaseService;
        if (r0 == 0) goto L_0x0084;
    L_0x007e:
        r0 = r6.mBaseService;
        r0.onCreate();
        return;
    L_0x0084:
        r0 = "BaseService";
        r2 = "cann't start ServiceImpl!";
        r1 = new java.lang.Object[r1];
        com.taobao.accs.utl.ALog.e(r0, r2, r1);
        return;
    L_0x008e:
        r3 = r6.mBaseService;
        if (r3 != 0) goto L_0x00ae;
    L_0x0092:
        r3 = "com.taobao.accs.internal.ServiceImpl";	 Catch:{ Throwable -> 0x00ae }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x00ae }
        r4 = new java.lang.Class[r0];	 Catch:{ Throwable -> 0x00ae }
        r5 = android.app.Service.class;	 Catch:{ Throwable -> 0x00ae }
        r4[r1] = r5;	 Catch:{ Throwable -> 0x00ae }
        r3 = r3.getDeclaredConstructor(r4);	 Catch:{ Throwable -> 0x00ae }
        r0 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x00ae }
        r0[r1] = r6;	 Catch:{ Throwable -> 0x00ae }
        r0 = r3.newInstance(r0);	 Catch:{ Throwable -> 0x00ae }
        r0 = (com.taobao.accs.base.IBaseService) r0;	 Catch:{ Throwable -> 0x00ae }
        r6.mBaseService = r0;	 Catch:{ Throwable -> 0x00ae }
    L_0x00ae:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.base.BaseService.onCreate():void");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.mBaseService != null) {
            return this.mBaseService.onStartCommand(intent, i, i2);
        }
        ALog.e(TAG, "onStartCommand mBaseService null", new Object[0]);
        return 2;
    }

    public IBinder onBind(Intent intent) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("onBind:");
        stringBuilder.append(intent);
        ALog.d(str, stringBuilder.toString(), new Object[0]);
        return this.mBaseService.onBind(intent);
    }

    public boolean onUnbind(Intent intent) {
        return this.mBaseService.onUnbind(intent);
    }

    public void onDestroy() {
        if (this.mBaseService != null) {
            this.mBaseService.onDestroy();
            this.mBaseService = null;
        }
        super.onDestroy();
    }
}
