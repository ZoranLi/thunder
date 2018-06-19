package com.xunlei.android.xlstat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;
import com.xunlei.android.xlstat.param.XLStatKey;
import com.xunlei.android.xlstat.param.XLStatParam;
import com.xunlei.androidvip.XLAndroidVipManager;
import com.xunlei.downloadlib.android.XLLog;
import com.xunlei.downloadlib.android.XLUtil;
import java.io.File;

/* compiled from: XLStatManager */
public class a {
    private static a e;
    public XLStatLoader a;
    public Context b;
    public a c = null;
    private final String d = "XLStatManager";

    /* compiled from: XLStatManager */
    class a extends BroadcastReceiver implements Runnable {
        int a;
        Thread b;
        final /* synthetic */ a c;

        private a(a aVar) {
            this.c = aVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onReceive(android.content.Context r3, android.content.Intent r4) {
            /*
            r2 = this;
            r0 = "TAG_VipNetReceiver";
            r1 = "call onReceive";
            com.xunlei.downloadlib.android.XLLog.d(r0, r1);
            r4 = r4.getAction();
            r0 = "android.net.conn.CONNECTIVITY_CHANGE";
            r4 = r4.equals(r0);
            if (r4 == 0) goto L_0x0044;
        L_0x0013:
            r3 = com.xunlei.downloadlib.android.XLUtil.getNetworkTypeSimple(r3);
            r4 = "TAG_VipNetReceiver";
            r0 = new java.lang.StringBuilder;
            r1 = "onReceive nettype=";
            r0.<init>(r1);
            r0.append(r3);
            r0 = r0.toString();
            com.xunlei.downloadlib.android.XLLog.d(r4, r0);
            monitor-enter(r2);
            r2.a = r3;	 Catch:{ all -> 0x0041 }
            r3 = r2.b;	 Catch:{ all -> 0x0041 }
            if (r3 == 0) goto L_0x0033;
        L_0x0031:
            monitor-exit(r2);	 Catch:{ all -> 0x0041 }
            return;
        L_0x0033:
            r3 = new java.lang.Thread;	 Catch:{ all -> 0x0041 }
            r3.<init>(r2);	 Catch:{ all -> 0x0041 }
            r2.b = r3;	 Catch:{ all -> 0x0041 }
            monitor-exit(r2);	 Catch:{ all -> 0x0041 }
            r3 = r2.b;
            r3.start();
            goto L_0x0044;
        L_0x0041:
            r3 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0041 }
            throw r3;
        L_0x0044:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.android.xlstat.a.a.onReceive(android.content.Context, android.content.Intent):void");
        }

        public final void run() {
            while (true) {
                int i = this.a;
                synchronized (this) {
                    if (i == this.a) {
                        this.b = null;
                        return;
                    }
                }
            }
        }
    }

    public static synchronized a a(Context context) {
        synchronized (a.class) {
            context = a(context, null);
        }
        return context;
    }

    public static synchronized a a(Context context, String str) {
        synchronized (a.class) {
            if (e == null) {
                e = new a(context, str);
            }
            context = e;
        }
        return context;
    }

    private a(Context context, String str) {
        if (context != null) {
            if (str == null) {
                this.a = new XLStatLoader(context);
            } else {
                this.a = new XLStatLoader(str);
            }
            this.b = context.getApplicationContext();
            XLLog.init(new File(Environment.getExternalStorageDirectory().getPath(), "xunlei_ds_log.ini").getPath());
        }
    }

    public final int a(XLStatParam xLStatParam, XLStatKey xLStatKey) {
        a aVar = this;
        XLStatParam xLStatParam2 = xLStatParam;
        if (xLStatKey != null) {
            if (xLStatParam.checkParam()) {
                if (aVar.a == null) {
                    XLLog.e("XLStatManager", "init mLoader is null");
                    return XLAndroidVipManager.NOT_INIT;
                }
                int networkTypeSimple = XLUtil.getNetworkTypeSimple(aVar.b);
                String str = XLUtil.generateGuid(aVar.b).b;
                XLStatLoader xLStatLoader = aVar.a;
                String str2 = xLStatParam2.mAppKey;
                String str3 = xLStatParam2.mAppName;
                String str4 = xLStatParam2.mAppVersion;
                String peerid = XLUtil.getPeerid(aVar.b);
                if (peerid == null) {
                    peerid = "000000000000000V";
                }
                int init = xLStatLoader.init(str2, str3, str4, peerid, str, xLStatParam2.mProductKey, xLStatParam2.mProductName, xLStatParam2.mProductVersion, xLStatParam2.mStoragePath, xLStatParam2.mConfigPath, xLStatParam2.mConfigFileName, xLStatParam2.mConfigBuffer, networkTypeSimple, xLStatKey);
                XLLog.i("XLStatManager", "doMonitorNetworkChange()");
                if (aVar.b != null && aVar.c == null) {
                    aVar.c = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
                    XLLog.i("XLStatManager", "register Receiver");
                    aVar.b.registerReceiver(aVar.c, intentFilter);
                }
                StringBuilder stringBuilder = new StringBuilder("init ret=");
                stringBuilder.append(init);
                stringBuilder.append(", key=");
                stringBuilder.append(xLStatKey.mKey);
                XLLog.d("XLStatManager", stringBuilder.toString());
                return init;
            }
        }
        XLLog.e("XLStatManager", "init param error");
        return XLAndroidVipManager.PARAM_ERROR;
    }

    public final int a(XLStatKey xLStatKey, String str, String str2) {
        if (!(xLStatKey == null || xLStatKey.mKey == 0 || TextUtils.isEmpty(str))) {
            if (!TextUtils.isEmpty(str2)) {
                if (this.a == null) {
                    XLLog.e("XLStatManager", "trackEvent mLoader is null");
                    return XLAndroidVipManager.NOT_INIT;
                }
                xLStatKey = this.a.trackEvent(xLStatKey.mKey, str, null, null, 0, 0, 0, 0, str2);
                StringBuilder stringBuilder = new StringBuilder("trackEvent ret=");
                stringBuilder.append(xLStatKey);
                stringBuilder.append(", event = ");
                stringBuilder.append(str);
                stringBuilder.append(", extraData = [");
                stringBuilder.append(str2);
                stringBuilder.append("]");
                XLLog.d("XLStatManager", stringBuilder.toString());
                return null;
            }
        }
        XLLog.e("XLStatManager", "trackEvent param is null");
        return XLAndroidVipManager.PARAM_ERROR;
    }
}
