package com.taobao.accs;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.SessionCenter;
import com.taobao.accs.ACCSManager.AccsRequest;
import com.taobao.accs.AccsClientConfig.Builder;
import com.taobao.accs.AccsClientConfig.ENV;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService$ExtraInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.l;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
public class ACCSClient {
    private static String TAG = "ACCSClient";
    public static Map<String, ACCSClient> mACCSClients = new ConcurrentHashMap(2);
    private static Context mContext;
    private String OTAG = TAG;
    protected IACCSManager mAccsManager;
    private AccsClientConfig mConfig;

    public ACCSClient(Context context, AccsClientConfig accsClientConfig) {
        this.mConfig = accsClientConfig;
        context = new StringBuilder();
        context.append(this.OTAG);
        context.append(accsClientConfig.getTag());
        this.OTAG = context.toString();
        this.mAccsManager = ACCSManager.getAccsInstance(mContext, accsClientConfig.getAppKey(), accsClientConfig.getTag());
    }

    public static synchronized String init(Context context, String str) throws AccsException {
        synchronized (ACCSClient.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
                    if (!AccsClientConfig.loadedStaticConfig) {
                        configByTag = new Builder().setAppKey(str).build();
                        ALog.i(TAG, "init", "create config, appkey as tag");
                    }
                    context = init(context, configByTag);
                }
            }
            throw new AccsException("params error");
        }
        return context;
    }

    public static synchronized String init(Context context, AccsClientConfig accsClientConfig) throws AccsException {
        synchronized (ACCSClient.class) {
            if (context != null) {
                if (accsClientConfig != null) {
                    mContext = context.getApplicationContext();
                    ALog.i(TAG, "init", "config", accsClientConfig.toString());
                    context = accsClientConfig.getTag();
                }
            }
            throw new AccsException("params error");
        }
        return context;
    }

    public static ACCSClient getAccsClient() throws AccsException {
        return getAccsClient(null);
    }

    public static synchronized ACCSClient getAccsClient(String str) throws AccsException {
        synchronized (ACCSClient.class) {
            if (TextUtils.isEmpty(str)) {
                str = AccsClientConfig.DEFAULT_CONFIGTAG;
                ALog.e(TAG, "configTag null, use default!", new Object[0]);
            }
            AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
            if (configByTag == null) {
                ALog.e(TAG, "configTag not exist, please init first!!", new Object[0]);
                throw new AccsException("tag not exist");
            }
            ALog.i(TAG, "getAccsClient", Constants.KEY_CONFIG_TAG, str);
            ACCSClient aCCSClient = (ACCSClient) mACCSClients.get(str);
            if (aCCSClient == null) {
                ALog.i(TAG, "getAccsClient create client", "config", configByTag.toString());
                ACCSClient aCCSClient2 = new ACCSClient(mContext, configByTag);
                mACCSClients.put(str, aCCSClient2);
                aCCSClient2.updateConfig(configByTag);
                return aCCSClient2;
            } else if (configByTag.equals(aCCSClient.mConfig) != null) {
                ALog.i(TAG, "getAccsClient exists", new Object[0]);
                return aCCSClient;
            } else {
                ALog.i(TAG, "getAccsClient update config", "old config", aCCSClient.mConfig.getTag(), "new config", configByTag.getTag());
                aCCSClient.updateConfig(configByTag);
                return aCCSClient;
            }
        }
    }

    private void updateConfig(AccsClientConfig accsClientConfig) {
        this.mConfig = accsClientConfig;
        this.mAccsManager = ACCSManager.getAccsInstance(mContext, accsClientConfig.getAppKey(), accsClientConfig.getTag());
        this.mAccsManager.updateConfig(accsClientConfig);
    }

    public static synchronized void setEnvironment(Context context, @ENV int i) {
        synchronized (ACCSClient.class) {
            if (i < 0 || i > 2) {
                try {
                    ALog.e(TAG, "env error", "env", Integer.valueOf(i));
                    i = 0;
                } catch (Throwable e) {
                    ALog.e(TAG, "setEnvironment update client", e, new Object[0]);
                } catch (Throwable th) {
                    try {
                        ALog.e(TAG, "setEnvironment", th, new Object[0]);
                        l.a(context, i);
                        return;
                    } catch (Throwable th2) {
                        l.a(context, i);
                    }
                }
            }
            int i2 = AccsClientConfig.mEnv;
            AccsClientConfig.mEnv = i;
            if (i2 != i && l.d(context)) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder("setEnvironment:");
                stringBuilder.append(i);
                ALog.i(str, stringBuilder.toString(), new Object[0]);
                l.b(context);
                l.e(context);
                l.c(context);
                if (i == 2) {
                    SessionCenter.switchEnvironment(anet.channel.entity.ENV.TEST);
                } else if (i == 1) {
                    SessionCenter.switchEnvironment(anet.channel.entity.ENV.PREPARE);
                }
                for (Entry key : mACCSClients.entrySet()) {
                    getAccsClient((String) key.getKey());
                }
            }
            l.a(context, i);
        }
    }

    public void bindApp(String str, IAppReceiver iAppReceiver) {
        if (this.mAccsManager == null) {
            ALog.e(this.OTAG, "bindApp mAccsManager null", new Object[0]);
        } else {
            this.mAccsManager.bindApp(mContext, this.mConfig.getAppKey(), this.mConfig.getAppSecret(), str, iAppReceiver);
        }
    }

    public void bindUser(String str) {
        if (this.mAccsManager == null) {
            ALog.e(this.OTAG, "bindUser mAccsManager null", new Object[0]);
        } else {
            this.mAccsManager.bindUser(mContext, str);
        }
    }

    public void bindUser(String str, boolean z) {
        if (this.mAccsManager == null) {
            ALog.e(this.OTAG, "bindUser mAccsManager null", new Object[0]);
        } else {
            this.mAccsManager.bindUser(mContext, str, z);
        }
    }

    public void unbindUser() {
        if (this.mAccsManager == null) {
            ALog.e(this.OTAG, "unbindUser mAccsManager null", new Object[0]);
        } else {
            this.mAccsManager.unbindUser(mContext);
        }
    }

    public void bindService(String str) {
        if (this.mAccsManager == null) {
            ALog.e(this.OTAG, "bindService mAccsManager null", new Object[0]);
        } else {
            this.mAccsManager.bindService(mContext, str);
        }
    }

    public void unbindService(String str) {
        if (this.mAccsManager == null) {
            ALog.e(this.OTAG, "unbindService mAccsManager null", new Object[0]);
        } else {
            this.mAccsManager.unbindService(mContext, str);
        }
    }

    public String sendData(AccsRequest accsRequest) {
        if (this.mAccsManager != null) {
            return this.mAccsManager.sendData(mContext, accsRequest);
        }
        ALog.e(this.OTAG, "sendData mAccsManager null", new Object[0]);
        return null;
    }

    public String sendRequest(AccsRequest accsRequest) {
        if (this.mAccsManager != null) {
            return this.mAccsManager.sendRequest(mContext, accsRequest);
        }
        ALog.e(this.OTAG, "sendRequest mAccsManager null", new Object[0]);
        return null;
    }

    public String sendPushResponse(AccsRequest accsRequest, TaoBaseService$ExtraInfo taoBaseService$ExtraInfo) {
        if (this.mAccsManager != null) {
            return this.mAccsManager.sendPushResponse(mContext, accsRequest, taoBaseService$ExtraInfo);
        }
        ALog.e(this.OTAG, "sendPushResponse mAccsManager null", new Object[0]);
        return null;
    }

    public boolean isNetworkReachable() {
        if (this.mAccsManager != null) {
            return this.mAccsManager.isNetworkReachable(mContext);
        }
        ALog.e(this.OTAG, "isNetworkReachable mAccsManager null", new Object[0]);
        return false;
    }

    public void forceDisableService() {
        if (this.mAccsManager == null) {
            ALog.e(this.OTAG, "forceDisableService mAccsManager null", new Object[0]);
        } else {
            this.mAccsManager.forceDisableService(mContext);
        }
    }

    public void forceEnableService() {
        if (this.mAccsManager == null) {
            ALog.e(this.OTAG, "forceEnableService mAccsManager null", new Object[0]);
        } else {
            this.mAccsManager.forceEnableService(mContext);
        }
    }

    public void startInAppConnection(String str, IAppReceiver iAppReceiver) {
        if (this.mAccsManager == null) {
            ALog.e(this.OTAG, "startInAppConnection mAccsManager null", new Object[0]);
        } else {
            this.mAccsManager.startInAppConnection(mContext, this.mConfig.getAppKey(), this.mConfig.getAppSecret(), str, iAppReceiver);
        }
    }

    public void setLoginInfo(ILoginInfo iLoginInfo) {
        if (this.mAccsManager == null) {
            ALog.e(this.OTAG, "setLoginInfo mAccsManager null", new Object[0]);
        } else {
            this.mAccsManager.setLoginInfo(mContext, iLoginInfo);
        }
    }

    public void clearLoginInfo() {
        if (this.mAccsManager == null) {
            ALog.e(this.OTAG, "clearLoginInfo mAccsManager null", new Object[0]);
        } else {
            this.mAccsManager.clearLoginInfo(mContext);
        }
    }

    public boolean cancel(String str) {
        if (this.mAccsManager != null) {
            return this.mAccsManager.cancel(mContext, str);
        }
        ALog.e(this.OTAG, "cancel mAccsManager null", new Object[0]);
        return false;
    }

    public boolean isChannelError(int i) {
        if (this.mAccsManager != null) {
            return this.mAccsManager.isChannelError(i);
        }
        ALog.e(this.OTAG, "isChannelError mAccsManager null", new Object[0]);
        return true;
    }

    public Map<String, Boolean> getChannelState() throws Exception {
        if (this.mAccsManager != null) {
            return this.mAccsManager.getChannelState();
        }
        ALog.e(this.OTAG, "getChannelState mAccsManager null", new Object[0]);
        return null;
    }

    public Map<String, Boolean> forceReConnectChannel() throws Exception {
        if (this.mAccsManager != null) {
            return this.mAccsManager.forceReConnectChannel();
        }
        ALog.e(this.OTAG, "forceReConnectChannel mAccsManager null", new Object[0]);
        return null;
    }

    public String getUserUnit() {
        if (this.mAccsManager != null) {
            return this.mAccsManager.getUserUnit();
        }
        ALog.e(this.OTAG, "getUserUnit mAccsManager null", new Object[0]);
        return null;
    }

    public void registerSerivce(String str, String str2) {
        if (this.mAccsManager == null) {
            ALog.e(this.OTAG, "registerSerivce mAccsManager null", new Object[0]);
        } else {
            this.mAccsManager.registerSerivce(mContext, str, str2);
        }
    }

    public void unRegisterSerivce(String str) {
        if (this.mAccsManager == null) {
            ALog.e(this.OTAG, "unRegisterSerivce mAccsManager null", new Object[0]);
        } else {
            this.mAccsManager.unRegisterSerivce(mContext, str);
        }
    }

    public void registerDataListener(String str, AccsAbstractDataListener accsAbstractDataListener) {
        if (this.mAccsManager == null) {
            ALog.e(this.OTAG, "registerDataListener mAccsManager null", new Object[0]);
        } else {
            this.mAccsManager.registerDataListener(mContext, str, accsAbstractDataListener);
        }
    }

    public void unRegisterDataListener(String str) {
        if (this.mAccsManager == null) {
            ALog.e(this.OTAG, "unRegisterDataListener mAccsManager null", new Object[0]);
        } else {
            this.mAccsManager.unRegisterDataListener(mContext, str);
        }
    }

    public void sendBusinessAck(String str, String str2, String str3, short s, String str4, Map<Integer, String> map) {
        if (this.mAccsManager == null) {
            ALog.e(this.OTAG, "sendBusinessAck mAccsManager null", new Object[null]);
        } else {
            this.mAccsManager.sendBusinessAck(str, str2, str3, s, str4, map);
        }
    }
}
