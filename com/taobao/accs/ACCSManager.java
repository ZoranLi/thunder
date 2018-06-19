package com.taobao.accs;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.taobao.accs.AccsClientConfig.ENV;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService$ExtraInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.d.a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.l;
import java.io.Serializable;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
/* compiled from: Taobao */
public final class ACCSManager {
    private static final String TAG = "ACCSManager";
    public static Map<String, IACCSManager> mAccsInstances = new ConcurrentHashMap(2);
    public static Context mContext = null;
    public static String mDefaultAppkey = null;
    public static String mDefaultConfigTag = "default";
    public static int mEnv;

    /* compiled from: Taobao */
    public static class AccsRequest implements Serializable {
        public String businessId;
        public byte[] data;
        public String dataId;
        public URL host;
        public boolean isUnitBusiness = false;
        public String serviceId;
        public String tag;
        public String target;
        public String targetServiceName;
        public int timeout;
        public String userId;

        public AccsRequest(String str, String str2, byte[] bArr, String str3, String str4, URL url, String str5) {
            this.userId = str;
            this.serviceId = str2;
            this.data = bArr;
            this.dataId = str3;
            this.target = str4;
            this.host = url;
            this.businessId = str5;
        }

        public AccsRequest(String str, String str2, byte[] bArr, String str3) {
            this.userId = str;
            this.serviceId = str2;
            this.data = bArr;
            this.dataId = str3;
        }

        public void setTag(String str) {
            this.tag = str;
        }

        public void setTimeOut(int i) {
            this.timeout = i;
        }

        public void setIsUnitBusiness(boolean z) {
            this.isUnitBusiness = z;
        }

        public void setTarget(String str) {
            this.target = str;
        }

        public void setTargetServiceName(String str) {
            this.targetServiceName = str;
        }

        public void setHost(URL url) {
            this.host = url;
        }

        public void setBusinessId(String str) {
            this.businessId = str;
        }
    }

    @Deprecated
    public static void setServiceListener(Context context, String str, IServiceReceiver iServiceReceiver) {
    }

    @Deprecated
    public static void unbindApp(Context context) {
    }

    private ACCSManager() {
    }

    @Deprecated
    public static void setAppkey(Context context, String str, @ENV int i) {
        l.a(context, str);
        mContext = context.getApplicationContext();
        mDefaultAppkey = str;
        l.a(mContext, Constants.SP_KEY_DEFAULT_APPKEY, mDefaultAppkey);
        mEnv = i;
        AccsClientConfig.mEnv = i;
    }

    @Deprecated
    public static String getDefaultAppkey(Context context) {
        if (TextUtils.isEmpty(mDefaultAppkey)) {
            ALog.e(TAG, "old interface!!, please AccsManager.setAppkey() first!", new Object[0]);
            CharSequence b = l.b(context, Constants.SP_KEY_DEFAULT_APPKEY, null);
            mDefaultAppkey = b;
            if (TextUtils.isEmpty(b)) {
                try {
                    mDefaultAppkey = SecurityGuardManager.getInstance(context).getStaticDataStoreComp().getAppKeyByIndex(0, null);
                } catch (Context context2) {
                    ALog.e(TAG, "getDefaultAppkey", context2, new Object[0]);
                }
            }
            if (TextUtils.isEmpty(mDefaultAppkey) != null) {
                mDefaultAppkey = "0";
            }
        }
        return mDefaultAppkey;
    }

    @Deprecated
    public static void setDefaultConfig(Context context, String str) {
        if (TextUtils.isEmpty(str) == null) {
            ALog.i(TAG, "setDefaultConfig", Constants.KEY_CONFIG_TAG, str);
            mDefaultConfigTag = str;
        }
    }

    public static String getDefaultConfig(Context context) {
        return mDefaultConfigTag;
    }

    @Deprecated
    public static void bindApp(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver) {
        if (TextUtils.isEmpty(mDefaultAppkey) != null) {
            throw new RuntimeException("old interface!!, please AccsManager.setAppkey() first!");
        }
        l.a();
        getManagerImpl(context).bindApp(context, mDefaultAppkey, str2, str3, iAppReceiver);
    }

    @Deprecated
    public static void bindApp(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        bindApp(context, mDefaultAppkey, "", str2, iAppReceiver);
    }

    @Deprecated
    public static void bindUser(Context context, String str) {
        bindUser(context, str, false);
    }

    @Deprecated
    public static void bindUser(Context context, String str, boolean z) {
        if (TextUtils.isEmpty(mDefaultAppkey)) {
            throw new RuntimeException("old interface!!, please AccsManager.setAppkey() first!");
        }
        getManagerImpl(context).bindUser(context, str, z);
    }

    @Deprecated
    public static void unbindUser(Context context) {
        getManagerImpl(context).unbindUser(context);
    }

    @Deprecated
    public static void bindService(Context context, String str) {
        getManagerImpl(context).bindService(context, str);
    }

    @Deprecated
    public static void unbindService(Context context, String str) {
        getManagerImpl(context).unbindService(context, str);
    }

    @Deprecated
    public static String sendData(Context context, String str, String str2, byte[] bArr, String str3) {
        return getManagerImpl(context).sendData(context, str, str2, bArr, str3);
    }

    @Deprecated
    public static String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return getManagerImpl(context).sendData(context, str, str2, bArr, str3, str4, url);
    }

    @Deprecated
    public static String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return getManagerImpl(context).sendData(context, str, str2, bArr, str3, str4);
    }

    @Deprecated
    public static String sendData(Context context, AccsRequest accsRequest) {
        return getManagerImpl(context).sendData(context, accsRequest);
    }

    @Deprecated
    public static String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return getManagerImpl(context).sendRequest(context, str, str2, bArr, str3, str4, url);
    }

    @Deprecated
    public static String sendRequest(Context context, String str, String str2, byte[] bArr, String str3) {
        return sendRequest(context, str, str2, bArr, str3, null);
    }

    @Deprecated
    public static String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return getManagerImpl(context).sendRequest(context, str, str2, bArr, str3, str4);
    }

    @Deprecated
    public static String sendRequest(Context context, AccsRequest accsRequest) {
        return getManagerImpl(context).sendRequest(context, accsRequest);
    }

    @Deprecated
    public static String sendPushResponse(Context context, AccsRequest accsRequest, TaoBaseService$ExtraInfo taoBaseService$ExtraInfo) {
        return getManagerImpl(context).sendPushResponse(context, accsRequest, taoBaseService$ExtraInfo);
    }

    @Deprecated
    public static boolean isNetworkReachable(Context context) {
        return getManagerImpl(context).isNetworkReachable(context);
    }

    @Deprecated
    public static void setMode(Context context, int i) {
        mEnv = i;
        getManagerImpl(context).setMode(context, i);
    }

    @Deprecated
    public static void setProxy(Context context, String str, int i) {
        getManagerImpl(context).setProxy(context, str, i);
    }

    @Deprecated
    public static void startInAppConnection(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver) {
        l.a();
        getManagerImpl(context).startInAppConnection(context, mDefaultAppkey, str2, str3, iAppReceiver);
    }

    @Deprecated
    public static void startInAppConnection(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        startInAppConnection(context, mDefaultAppkey, "", str2, iAppReceiver);
    }

    @Deprecated
    public static void setLoginInfoImpl(Context context, ILoginInfo iLoginInfo) {
        getManagerImpl(context).setLoginInfo(context, iLoginInfo);
    }

    @Deprecated
    public static void clearLoginInfoImpl(Context context) {
        getManagerImpl(context).clearLoginInfo(context);
    }

    @Deprecated
    public static Map<String, Boolean> getChannelState(Context context) throws Exception {
        return getManagerImpl(context).getChannelState();
    }

    @Deprecated
    public static Map<String, Boolean> forceReConnectChannel(Context context) throws Exception {
        return getManagerImpl(context).forceReConnectChannel();
    }

    @Deprecated
    public static String getUserUnit(Context context) {
        return getManagerImpl(context).getUserUnit();
    }

    @Deprecated
    public static boolean isChannelError(Context context, int i) {
        return getManagerImpl(context).isChannelError(i);
    }

    @Deprecated
    public static void registerSerivce(Context context, String str, String str2) {
        getManagerImpl(context).registerSerivce(context, str, str2);
    }

    @Deprecated
    public static void unregisterService(Context context, String str) {
        getManagerImpl(context).unRegisterSerivce(context, str);
    }

    @Deprecated
    public static void registerDataListener(Context context, String str, AccsAbstractDataListener accsAbstractDataListener) {
        if (getManagerImpl(context) == null) {
            ALog.e(TAG, "getManagerImpl null, return", new Object[null]);
        } else {
            getManagerImpl(context).registerDataListener(context, str, accsAbstractDataListener);
        }
    }

    @Deprecated
    public static void unRegisterDataListener(Context context, String str) {
        getManagerImpl(context).unRegisterDataListener(context, str);
    }

    private static synchronized IACCSManager getManagerImpl(Context context) {
        synchronized (ACCSManager.class) {
            context = getAccsInstance(context, null, getDefaultConfig(context));
        }
        return context;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.taobao.accs.IACCSManager getAccsInstance(android.content.Context r5, java.lang.String r6, java.lang.String r7) {
        /*
        r6 = com.taobao.accs.ACCSManager.class;
        monitor-enter(r6);
        if (r5 == 0) goto L_0x0038;
    L_0x0005:
        r0 = android.text.TextUtils.isEmpty(r7);	 Catch:{ all -> 0x0036 }
        if (r0 == 0) goto L_0x000c;
    L_0x000b:
        goto L_0x0038;
    L_0x000c:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0036 }
        r0.<init>(r7);	 Catch:{ all -> 0x0036 }
        r1 = "|";
        r0.append(r1);	 Catch:{ all -> 0x0036 }
        r1 = com.taobao.accs.AccsClientConfig.mEnv;	 Catch:{ all -> 0x0036 }
        r0.append(r1);	 Catch:{ all -> 0x0036 }
        r0 = r0.toString();	 Catch:{ all -> 0x0036 }
        r1 = mAccsInstances;	 Catch:{ all -> 0x0036 }
        r1 = r1.get(r0);	 Catch:{ all -> 0x0036 }
        r1 = (com.taobao.accs.IACCSManager) r1;	 Catch:{ all -> 0x0036 }
        if (r1 != 0) goto L_0x0034;
    L_0x0029:
        r1 = createInner(r5, r7);	 Catch:{ all -> 0x0036 }
        if (r1 == 0) goto L_0x0034;
    L_0x002f:
        r5 = mAccsInstances;	 Catch:{ all -> 0x0036 }
        r5.put(r0, r1);	 Catch:{ all -> 0x0036 }
    L_0x0034:
        monitor-exit(r6);
        return r1;
    L_0x0036:
        r5 = move-exception;
        goto L_0x0055;
    L_0x0038:
        r0 = "ACCSManager";
        r1 = "getAccsInstance param null";
        r2 = 4;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0036 }
        r3 = 0;
        r4 = "configTag";
        r2[r3] = r4;	 Catch:{ all -> 0x0036 }
        r3 = 1;
        r2[r3] = r7;	 Catch:{ all -> 0x0036 }
        r7 = 2;
        r3 = "context";
        r2[r7] = r3;	 Catch:{ all -> 0x0036 }
        r7 = 3;
        r2[r7] = r5;	 Catch:{ all -> 0x0036 }
        com.taobao.accs.utl.ALog.e(r0, r1, r2);	 Catch:{ all -> 0x0036 }
        r5 = 0;
        monitor-exit(r6);
        return r5;
    L_0x0055:
        monitor-exit(r6);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.ACCSManager.getAccsInstance(android.content.Context, java.lang.String, java.lang.String):com.taobao.accs.IACCSManager");
    }

    protected static IACCSManager createInner(Context context, String str) {
        try {
            ALog.w(TAG, "new accs instance", Constants.KEY_CONFIG_TAG, str);
            IACCSManager iACCSManager = (IACCSManager) a.a().b().loadClass(Constants.ACCS_IMPL_NAME).getDeclaredConstructor(new Class[]{Context.class, String.class}).newInstance(new Object[]{context, str});
            if (iACCSManager != null) {
                return iACCSManager;
            }
            try {
                return (IACCSManager) Class.forName(Constants.ACCS_IMPL_NAME).getDeclaredConstructor(new Class[]{Context.class, String.class}).newInstance(new Object[]{context, str});
            } catch (Context context2) {
                ALog.e(TAG, "getAccsInstance", context2, new Object[0]);
                return iACCSManager;
            }
        } catch (Throwable e) {
            ALog.e(TAG, "getAccsInstance", e, new Object[0]);
            try {
                return (IACCSManager) Class.forName(Constants.ACCS_IMPL_NAME).getDeclaredConstructor(new Class[]{Context.class, String.class}).newInstance(new Object[]{context2, str});
            } catch (Context context22) {
                ALog.e(TAG, "getAccsInstance", context22, new Object[0]);
                return null;
            }
        } catch (Throwable th) {
            try {
                Class.forName(Constants.ACCS_IMPL_NAME).getDeclaredConstructor(new Class[]{Context.class, String.class}).newInstance(new Object[]{context22, str});
            } catch (Context context222) {
                ALog.e(TAG, "getAccsInstance", context222, new Object[0]);
            }
        }
    }

    public static void forceEnableService(Context context) {
        getManagerImpl(context).forceEnableService(context);
    }

    public static void forceDisableService(Context context) {
        getManagerImpl(context).forceDisableService(context);
    }

    public static String[] getAppkey(Context context) {
        try {
            context = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getString("appkey", null);
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("getAppkey:");
            stringBuilder.append(context);
            ALog.i(str, stringBuilder.toString(), new Object[0]);
            if (TextUtils.isEmpty(context)) {
                return null;
            }
            return context.split("\\|");
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        }
    }
}
