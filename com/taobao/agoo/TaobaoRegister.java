package com.taobao.agoo;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsClientConfig.Builder;
import com.taobao.accs.AccsClientConfig.ENV;
import com.taobao.accs.AccsException;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.a;
import com.taobao.agoo.a.b;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.CallBack;
import org.android.agoo.common.Config;
import org.android.agoo.common.MsgDO;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;

/* compiled from: Taobao */
public final class TaobaoRegister {
    private static final int EVENT_ID = 66001;
    static final String PREFERENCES = "Agoo_AppStore";
    static final String PROPERTY_APP_NOTIFICATION_CUSTOM_SOUND = "app_notification_custom_sound";
    static final String PROPERTY_APP_NOTIFICATION_ICON = "app_notification_icon";
    static final String PROPERTY_APP_NOTIFICATION_SOUND = "app_notification_sound";
    static final String PROPERTY_APP_NOTIFICATION_VIBRATE = "app_notification_vibrate";
    private static final String SERVICEID = "agooSend";
    protected static final String TAG = "TaobaoRegister";
    private static b mRequestListener;

    @Deprecated
    public static void setBuilderSound(Context context, String str) {
    }

    @Deprecated
    public static void setNotificationIcon(Context context, int i) {
    }

    @Deprecated
    public static void setNotificationSound(Context context, boolean z) {
    }

    @Deprecated
    public static void setNotificationVibrate(Context context, boolean z) {
    }

    private TaobaoRegister() {
        throw new UnsupportedOperationException();
    }

    public static synchronized void register(Context context, String str, String str2, String str3, IRegister iRegister) throws AccsException {
        synchronized (TaobaoRegister.class) {
            register(context, str, str, str2, str3, iRegister);
        }
    }

    public static synchronized void register(Context context, String str, String str2, String str3, String str4, IRegister iRegister) throws AccsException {
        Context context2 = context;
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        synchronized (TaobaoRegister.class) {
            if (context2 != null) {
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        if (!TextUtils.isEmpty(str5)) {
                            ALog.i(TAG, "register", "appKey", str6, Constants.KEY_CONFIG_TAG, str5);
                            Context applicationContext = context2.getApplicationContext();
                            Config.a = str5;
                            Config.setAgooAppKey(context2, str6);
                            a.b = str7;
                            if (!TextUtils.isEmpty(str3)) {
                                com.taobao.accs.client.a.a = 2;
                            }
                            if (AccsClientConfig.getConfigByTag(str5) == null) {
                                new Builder().setAppKey(str6).setAppSecret(str7).setTag(str5).build();
                            } else {
                                ALog.i(TAG, "config exist", "config", AccsClientConfig.getConfigByTag(str5).toString());
                            }
                            IACCSManager accsInstance = ACCSManager.getAccsInstance(context2, str6, str5);
                            accsInstance.bindApp(applicationContext, str6, str7, str4, new d(applicationContext, accsInstance, iRegister, str6, str4));
                            return;
                        }
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                }
            }
            ALog.e(TAG, "register params null", "appkey", str6, Constants.KEY_CONFIG_TAG, str5, "context", context2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void setAlias(android.content.Context r9, java.lang.String r10, com.taobao.agoo.ICallback r11) {
        /*
        r0 = com.taobao.agoo.TaobaoRegister.class;
        monitor-enter(r0);
        r1 = "TaobaoRegister";
        r2 = "setAlias";
        r3 = 2;
        r4 = new java.lang.Object[r3];	 Catch:{ all -> 0x00f3 }
        r5 = "alias";
        r6 = 0;
        r4[r6] = r5;	 Catch:{ all -> 0x00f3 }
        r5 = 1;
        r4[r5] = r10;	 Catch:{ all -> 0x00f3 }
        com.taobao.accs.utl.ALog.i(r1, r2, r4);	 Catch:{ all -> 0x00f3 }
        r1 = org.android.agoo.common.Config.g(r9);	 Catch:{ all -> 0x00f3 }
        r2 = org.android.agoo.common.Config.a(r9);	 Catch:{ all -> 0x00f3 }
        r4 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x00f3 }
        if (r4 != 0) goto L_0x00c0;
    L_0x0023:
        r4 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x00f3 }
        if (r4 != 0) goto L_0x00c0;
    L_0x0029:
        if (r9 == 0) goto L_0x00c0;
    L_0x002b:
        r4 = android.text.TextUtils.isEmpty(r10);	 Catch:{ all -> 0x00f3 }
        if (r4 == 0) goto L_0x0033;
    L_0x0031:
        goto L_0x00c0;
    L_0x0033:
        r4 = mRequestListener;	 Catch:{ Throwable -> 0x00b4 }
        if (r4 != 0) goto L_0x0042;
    L_0x0037:
        r4 = new com.taobao.agoo.a.b;	 Catch:{ Throwable -> 0x00b4 }
        r7 = r9.getApplicationContext();	 Catch:{ Throwable -> 0x00b4 }
        r4.<init>(r7);	 Catch:{ Throwable -> 0x00b4 }
        mRequestListener = r4;	 Catch:{ Throwable -> 0x00b4 }
    L_0x0042:
        r4 = com.taobao.agoo.a.b.b;	 Catch:{ Throwable -> 0x00b4 }
        r4 = r4.d(r10);	 Catch:{ Throwable -> 0x00b4 }
        if (r4 == 0) goto L_0x0060;
    L_0x004a:
        r9 = "TaobaoRegister";
        r1 = "Alias already set";
        r2 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x00b4 }
        r3 = "alias";
        r2[r6] = r3;	 Catch:{ Throwable -> 0x00b4 }
        r2[r5] = r10;	 Catch:{ Throwable -> 0x00b4 }
        com.taobao.accs.utl.ALog.i(r9, r1, r2);	 Catch:{ Throwable -> 0x00b4 }
        if (r11 == 0) goto L_0x005e;
    L_0x005b:
        r11.onSuccess();	 Catch:{ Throwable -> 0x00b4 }
    L_0x005e:
        monitor-exit(r0);
        return;
    L_0x0060:
        r3 = org.android.agoo.common.Config.b(r9);	 Catch:{ Throwable -> 0x00b4 }
        r3 = com.taobao.accs.ACCSManager.getAccsInstance(r9, r2, r3);	 Catch:{ Throwable -> 0x00b4 }
        r4 = com.taobao.agoo.a.b.b;	 Catch:{ Throwable -> 0x00b4 }
        r5 = r9.getPackageName();	 Catch:{ Throwable -> 0x00b4 }
        r4 = r4.b(r5);	 Catch:{ Throwable -> 0x00b4 }
        if (r4 == 0) goto L_0x00a9;
    L_0x0074:
        r4 = "AgooDeviceCmd";
        r5 = mRequestListener;	 Catch:{ Throwable -> 0x00b4 }
        r3.registerDataListener(r9, r4, r5);	 Catch:{ Throwable -> 0x00b4 }
        r1 = com.taobao.agoo.a.a.a.a(r2, r1, r10);	 Catch:{ Throwable -> 0x00b4 }
        r2 = new com.taobao.accs.ACCSManager$AccsRequest;	 Catch:{ Throwable -> 0x00b4 }
        r4 = "AgooDeviceCmd";
        r5 = 0;
        r2.<init>(r5, r4, r1, r5);	 Catch:{ Throwable -> 0x00b4 }
        r9 = r3.sendRequest(r9, r2);	 Catch:{ Throwable -> 0x00b4 }
        r1 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Throwable -> 0x00b4 }
        if (r1 == 0) goto L_0x009c;
    L_0x0091:
        if (r11 == 0) goto L_0x00a7;
    L_0x0093:
        r9 = "504.1";
        r10 = "accs channel disabled!";
        r11.onFailure(r9, r10);	 Catch:{ Throwable -> 0x00b4 }
        monitor-exit(r0);
        return;
    L_0x009c:
        if (r11 == 0) goto L_0x00a7;
    L_0x009e:
        r11.extra = r10;	 Catch:{ Throwable -> 0x00b4 }
        r10 = mRequestListener;	 Catch:{ Throwable -> 0x00b4 }
        r10 = r10.a;	 Catch:{ Throwable -> 0x00b4 }
        r10.put(r9, r11);	 Catch:{ Throwable -> 0x00b4 }
    L_0x00a7:
        monitor-exit(r0);
        return;
    L_0x00a9:
        if (r11 == 0) goto L_0x00b2;
    L_0x00ab:
        r9 = "504.1";
        r10 = "bindApp first!!";
        r11.onFailure(r9, r10);	 Catch:{ Throwable -> 0x00b4 }
    L_0x00b2:
        monitor-exit(r0);
        return;
    L_0x00b4:
        r9 = move-exception;
        r10 = "TaobaoRegister";
        r11 = "setAlias";
        r1 = new java.lang.Object[r6];	 Catch:{ all -> 0x00f3 }
        com.taobao.accs.utl.ALog.e(r10, r11, r9, r1);	 Catch:{ all -> 0x00f3 }
        monitor-exit(r0);
        return;
    L_0x00c0:
        if (r11 == 0) goto L_0x00c9;
    L_0x00c2:
        r4 = "504.1";
        r7 = "input params null!!";
        r11.onFailure(r4, r7);	 Catch:{ all -> 0x00f3 }
    L_0x00c9:
        r11 = "TaobaoRegister";
        r4 = "setAlias param null";
        r7 = 8;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x00f3 }
        r8 = "appkey";
        r7[r6] = r8;	 Catch:{ all -> 0x00f3 }
        r7[r5] = r2;	 Catch:{ all -> 0x00f3 }
        r2 = "deviceId";
        r7[r3] = r2;	 Catch:{ all -> 0x00f3 }
        r2 = 3;
        r7[r2] = r1;	 Catch:{ all -> 0x00f3 }
        r1 = 4;
        r2 = "alias";
        r7[r1] = r2;	 Catch:{ all -> 0x00f3 }
        r1 = 5;
        r7[r1] = r10;	 Catch:{ all -> 0x00f3 }
        r10 = 6;
        r1 = "context";
        r7[r10] = r1;	 Catch:{ all -> 0x00f3 }
        r10 = 7;
        r7[r10] = r9;	 Catch:{ all -> 0x00f3 }
        com.taobao.accs.utl.ALog.e(r11, r4, r7);	 Catch:{ all -> 0x00f3 }
        monitor-exit(r0);
        return;
    L_0x00f3:
        r9 = move-exception;
        monitor-exit(r0);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.TaobaoRegister.setAlias(android.content.Context, java.lang.String, com.taobao.agoo.ICallback):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void removeAlias(android.content.Context r8, com.taobao.agoo.ICallback r9) {
        /*
        r0 = com.taobao.agoo.TaobaoRegister.class;
        monitor-enter(r0);
        r1 = "TaobaoRegister";
        r2 = "removeAlias";
        r3 = 0;
        r4 = new java.lang.Object[r3];	 Catch:{ all -> 0x00b9 }
        com.taobao.accs.utl.ALog.i(r1, r2, r4);	 Catch:{ all -> 0x00b9 }
        r1 = org.android.agoo.common.Config.g(r8);	 Catch:{ Throwable -> 0x00ad }
        r2 = org.android.agoo.common.Config.h(r8);	 Catch:{ Throwable -> 0x00ad }
        r4 = org.android.agoo.common.Config.a(r8);	 Catch:{ Throwable -> 0x00ad }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x00ad }
        if (r5 != 0) goto L_0x0078;
    L_0x001f:
        r5 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x00ad }
        if (r5 != 0) goto L_0x0078;
    L_0x0025:
        if (r8 == 0) goto L_0x0078;
    L_0x0027:
        r5 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x00ad }
        if (r5 == 0) goto L_0x002e;
    L_0x002d:
        goto L_0x0078;
    L_0x002e:
        r5 = org.android.agoo.common.Config.b(r8);	 Catch:{ Throwable -> 0x00ad }
        r5 = com.taobao.accs.ACCSManager.getAccsInstance(r8, r4, r5);	 Catch:{ Throwable -> 0x00ad }
        r6 = mRequestListener;	 Catch:{ Throwable -> 0x00ad }
        if (r6 != 0) goto L_0x0045;
    L_0x003a:
        r6 = new com.taobao.agoo.a.b;	 Catch:{ Throwable -> 0x00ad }
        r7 = r8.getApplicationContext();	 Catch:{ Throwable -> 0x00ad }
        r6.<init>(r7);	 Catch:{ Throwable -> 0x00ad }
        mRequestListener = r6;	 Catch:{ Throwable -> 0x00ad }
    L_0x0045:
        r6 = "AgooDeviceCmd";
        r7 = mRequestListener;	 Catch:{ Throwable -> 0x00ad }
        r5.registerDataListener(r8, r6, r7);	 Catch:{ Throwable -> 0x00ad }
        r1 = com.taobao.agoo.a.a.a.b(r4, r1, r2);	 Catch:{ Throwable -> 0x00ad }
        r2 = new com.taobao.accs.ACCSManager$AccsRequest;	 Catch:{ Throwable -> 0x00ad }
        r4 = "AgooDeviceCmd";
        r6 = 0;
        r2.<init>(r6, r4, r1, r6);	 Catch:{ Throwable -> 0x00ad }
        r8 = r5.sendRequest(r8, r2);	 Catch:{ Throwable -> 0x00ad }
        r1 = android.text.TextUtils.isEmpty(r8);	 Catch:{ Throwable -> 0x00ad }
        if (r1 == 0) goto L_0x006d;
    L_0x0062:
        if (r9 == 0) goto L_0x0076;
    L_0x0064:
        r8 = "504.1";
        r1 = "accs channel disabled!";
        r9.onFailure(r8, r1);	 Catch:{ Throwable -> 0x00ad }
        monitor-exit(r0);
        return;
    L_0x006d:
        if (r9 == 0) goto L_0x0076;
    L_0x006f:
        r1 = mRequestListener;	 Catch:{ Throwable -> 0x00ad }
        r1 = r1.a;	 Catch:{ Throwable -> 0x00ad }
        r1.put(r8, r9);	 Catch:{ Throwable -> 0x00ad }
    L_0x0076:
        monitor-exit(r0);
        return;
    L_0x0078:
        if (r9 == 0) goto L_0x0081;
    L_0x007a:
        r5 = "504.1";
        r6 = "input params null!!";
        r9.onFailure(r5, r6);	 Catch:{ Throwable -> 0x00ad }
    L_0x0081:
        r9 = "TaobaoRegister";
        r5 = "setAlias param null";
        r6 = 8;
        r6 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x00ad }
        r7 = "appkey";
        r6[r3] = r7;	 Catch:{ Throwable -> 0x00ad }
        r7 = 1;
        r6[r7] = r4;	 Catch:{ Throwable -> 0x00ad }
        r4 = 2;
        r7 = "deviceId";
        r6[r4] = r7;	 Catch:{ Throwable -> 0x00ad }
        r4 = 3;
        r6[r4] = r1;	 Catch:{ Throwable -> 0x00ad }
        r1 = 4;
        r4 = "pushAliasToken";
        r6[r1] = r4;	 Catch:{ Throwable -> 0x00ad }
        r1 = 5;
        r6[r1] = r2;	 Catch:{ Throwable -> 0x00ad }
        r1 = 6;
        r2 = "context";
        r6[r1] = r2;	 Catch:{ Throwable -> 0x00ad }
        r1 = 7;
        r6[r1] = r8;	 Catch:{ Throwable -> 0x00ad }
        com.taobao.accs.utl.ALog.e(r9, r5, r6);	 Catch:{ Throwable -> 0x00ad }
        monitor-exit(r0);
        return;
    L_0x00ad:
        r8 = move-exception;
        r9 = "TaobaoRegister";
        r1 = "removeAlias";
        r2 = new java.lang.Object[r3];	 Catch:{ all -> 0x00b9 }
        com.taobao.accs.utl.ALog.e(r9, r1, r8, r2);	 Catch:{ all -> 0x00b9 }
        monitor-exit(r0);
        return;
    L_0x00b9:
        r8 = move-exception;
        monitor-exit(r0);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.TaobaoRegister.removeAlias(android.content.Context, com.taobao.agoo.ICallback):void");
    }

    @Deprecated
    public static void bindAgoo(Context context, String str, String str2, CallBack callBack) {
        bindAgoo(context, null);
    }

    @Deprecated
    public static void unBindAgoo(Context context, String str, String str2, CallBack callBack) {
        unbindAgoo(context, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void sendSwitch(android.content.Context r8, com.taobao.agoo.ICallback r9, boolean r10) {
        /*
        r0 = com.taobao.agoo.TaobaoRegister.class;
        monitor-enter(r0);
        r1 = 0;
        r2 = org.android.agoo.common.Config.g(r8);	 Catch:{ Throwable -> 0x00aa }
        r3 = org.android.agoo.common.Config.a(r8);	 Catch:{ Throwable -> 0x00aa }
        r4 = com.taobao.accs.utl.UtilityImpl.getDeviceId(r8);	 Catch:{ Throwable -> 0x00aa }
        r5 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x00aa }
        if (r5 != 0) goto L_0x006f;
    L_0x0016:
        if (r8 == 0) goto L_0x006f;
    L_0x0018:
        r5 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x00aa }
        if (r5 == 0) goto L_0x0025;
    L_0x001e:
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x00aa }
        if (r5 == 0) goto L_0x0025;
    L_0x0024:
        goto L_0x006f;
    L_0x0025:
        r5 = org.android.agoo.common.Config.b(r8);	 Catch:{ Throwable -> 0x00aa }
        r5 = com.taobao.accs.ACCSManager.getAccsInstance(r8, r3, r5);	 Catch:{ Throwable -> 0x00aa }
        r6 = mRequestListener;	 Catch:{ Throwable -> 0x00aa }
        if (r6 != 0) goto L_0x003c;
    L_0x0031:
        r6 = new com.taobao.agoo.a.b;	 Catch:{ Throwable -> 0x00aa }
        r7 = r8.getApplicationContext();	 Catch:{ Throwable -> 0x00aa }
        r6.<init>(r7);	 Catch:{ Throwable -> 0x00aa }
        mRequestListener = r6;	 Catch:{ Throwable -> 0x00aa }
    L_0x003c:
        r6 = "AgooDeviceCmd";
        r7 = mRequestListener;	 Catch:{ Throwable -> 0x00aa }
        r5.registerDataListener(r8, r6, r7);	 Catch:{ Throwable -> 0x00aa }
        r10 = com.taobao.agoo.a.a.d.a(r3, r2, r4, r10);	 Catch:{ Throwable -> 0x00aa }
        r2 = new com.taobao.accs.ACCSManager$AccsRequest;	 Catch:{ Throwable -> 0x00aa }
        r3 = "AgooDeviceCmd";
        r4 = 0;
        r2.<init>(r4, r3, r10, r4);	 Catch:{ Throwable -> 0x00aa }
        r8 = r5.sendRequest(r8, r2);	 Catch:{ Throwable -> 0x00aa }
        r10 = android.text.TextUtils.isEmpty(r8);	 Catch:{ Throwable -> 0x00aa }
        if (r10 == 0) goto L_0x0064;
    L_0x0059:
        if (r9 == 0) goto L_0x006d;
    L_0x005b:
        r8 = "503.2";
        r10 = "accs channel disabled!";
        r9.onFailure(r8, r10);	 Catch:{ Throwable -> 0x00aa }
        monitor-exit(r0);
        return;
    L_0x0064:
        if (r9 == 0) goto L_0x006d;
    L_0x0066:
        r10 = mRequestListener;	 Catch:{ Throwable -> 0x00aa }
        r10 = r10.a;	 Catch:{ Throwable -> 0x00aa }
        r10.put(r8, r9);	 Catch:{ Throwable -> 0x00aa }
    L_0x006d:
        monitor-exit(r0);
        return;
    L_0x006f:
        if (r9 == 0) goto L_0x0078;
    L_0x0071:
        r4 = "503.3";
        r5 = "input params null!!";
        r9.onFailure(r4, r5);	 Catch:{ Throwable -> 0x00aa }
    L_0x0078:
        r9 = "TaobaoRegister";
        r4 = "sendSwitch param null";
        r5 = 8;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x00aa }
        r6 = "appkey";
        r5[r1] = r6;	 Catch:{ Throwable -> 0x00aa }
        r6 = 1;
        r5[r6] = r3;	 Catch:{ Throwable -> 0x00aa }
        r3 = 2;
        r6 = "deviceId";
        r5[r3] = r6;	 Catch:{ Throwable -> 0x00aa }
        r3 = 3;
        r5[r3] = r2;	 Catch:{ Throwable -> 0x00aa }
        r2 = 4;
        r3 = "context";
        r5[r2] = r3;	 Catch:{ Throwable -> 0x00aa }
        r2 = 5;
        r5[r2] = r8;	 Catch:{ Throwable -> 0x00aa }
        r8 = 6;
        r2 = "enablePush";
        r5[r8] = r2;	 Catch:{ Throwable -> 0x00aa }
        r8 = 7;
        r10 = java.lang.Boolean.valueOf(r10);	 Catch:{ Throwable -> 0x00aa }
        r5[r8] = r10;	 Catch:{ Throwable -> 0x00aa }
        com.taobao.accs.utl.ALog.e(r9, r4, r5);	 Catch:{ Throwable -> 0x00aa }
        monitor-exit(r0);
        return;
    L_0x00a8:
        r8 = move-exception;
        goto L_0x00b6;
    L_0x00aa:
        r8 = move-exception;
        r9 = "TaobaoRegister";
        r10 = "sendSwitch";
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x00a8 }
        com.taobao.accs.utl.ALog.e(r9, r10, r8, r1);	 Catch:{ all -> 0x00a8 }
        monitor-exit(r0);
        return;
    L_0x00b6:
        monitor-exit(r0);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.TaobaoRegister.sendSwitch(android.content.Context, com.taobao.agoo.ICallback, boolean):void");
    }

    public static void bindAgoo(Context context, ICallback iCallback) {
        sendSwitch(context, iCallback, true);
        UTMini.getInstance().commitEvent(66001, "bindAgoo", UtilityImpl.getDeviceId(context));
    }

    public static void unbindAgoo(Context context, ICallback iCallback) {
        sendSwitch(context, iCallback, false);
        UTMini.getInstance().commitEvent(66001, MiPushClient.COMMAND_UNREGISTER, UtilityImpl.getDeviceId(context));
    }

    public static void clickMessage(Context context, String str, String str2) {
        NotifManager notifManager = new NotifManager();
        MsgDO msgDO = null;
        try {
            if (ALog.isPrintLog(Level.I)) {
                ALog.i(TAG, "clickMessage", MessageInfo.MSGID, str, AgooConstants.MESSAGE_EXT, str2);
            }
            String str3 = "accs";
            String str4 = "8";
            if (TextUtils.isEmpty(str)) {
                ALog.d(TAG, "messageId == null", new Object[0]);
                return;
            }
            notifManager.init(context);
            MsgDO msgDO2 = new MsgDO();
            try {
                msgDO2.msgIds = str;
                msgDO2.extData = str2;
                msgDO2.messageSource = str3;
                msgDO2.msgStatus = str4;
                str2 = new AgooFactory();
                str2.init(context, notifManager, null);
                str2.updateMsgStatus(str, "8");
                notifManager.reportNotifyMessage(msgDO2);
            } catch (Throwable th) {
                context = th;
                msgDO = msgDO2;
                if (msgDO != null) {
                    notifManager.reportNotifyMessage(msgDO);
                }
                throw context;
            }
        } catch (Throwable th2) {
            context = th2;
            str = TAG;
            str2 = new StringBuilder("clickMessage,error=");
            str2.append(context);
            ALog.e(str, str2.toString(), new Object[0]);
            if (msgDO != null) {
                notifManager.reportNotifyMessage(msgDO);
            }
        }
    }

    public static void dismissMessage(Context context, String str, String str2) {
        NotifManager notifManager = new NotifManager();
        MsgDO msgDO = null;
        try {
            if (ALog.isPrintLog(Level.I)) {
                ALog.i(TAG, "dismissMessage", MessageInfo.MSGID, str, AgooConstants.MESSAGE_EXT, str2);
            }
            String str3 = "accs";
            String str4 = "9";
            if (TextUtils.isEmpty(str)) {
                ALog.d(TAG, "messageId == null", new Object[0]);
                return;
            }
            notifManager.init(context);
            MsgDO msgDO2 = new MsgDO();
            try {
                msgDO2.msgIds = str;
                msgDO2.extData = str2;
                msgDO2.messageSource = str3;
                msgDO2.msgStatus = str4;
                str2 = new AgooFactory();
                str2.init(context, notifManager, null);
                str2.updateMsgStatus(str, "9");
                notifManager.reportNotifyMessage(msgDO2);
            } catch (Throwable th) {
                context = th;
                msgDO = msgDO2;
                if (msgDO != null) {
                    notifManager.reportNotifyMessage(msgDO);
                }
                throw context;
            }
        } catch (Throwable th2) {
            context = th2;
            str = TAG;
            str2 = new StringBuilder("clickMessage,error=");
            str2.append(context);
            ALog.e(str, str2.toString(), new Object[0]);
            if (msgDO != null) {
                notifManager.reportNotifyMessage(msgDO);
            }
        }
    }

    public static void pingApp(Context context, String str, String str2, String str3, int i) {
        NotifManager notifManager = new NotifManager();
        notifManager.init(context);
        notifManager.pingApp(str, str2, str3, i);
    }

    public static void isEnableDaemonServer(Context context, boolean z) {
        if (ALog.isPrintLog(Level.I)) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("isEnableDaemonServer begin,enable=");
            stringBuilder.append(z);
            ALog.i(str, stringBuilder.toString(), new Object[0]);
        }
        Config.a(context, z);
    }

    public static void setAgooMsgReceiveService(String str) {
        com.taobao.accs.client.a.b = str;
    }

    public static void setEnv(Context context, @ENV int i) {
        ACCSClient.setEnvironment(context, i);
    }

    @Deprecated
    public static void unregister(Context context, CallBack callBack) {
        unbindAgoo(context, null);
    }
}
