package com.taobao.accs.init;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.qihoo360.i.IPluginManager;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
public class Launcher_InitAccs implements Serializable {
    protected static final Map<String, String> a;
    public static String defaultAppkey = "21646297";
    public static IAppReceiver mAppReceiver = new d();
    public static String mAppkey = null;
    public static Context mContext = null;
    public static boolean mForceBindUser = false;
    public static boolean mIsInited = false;
    public static String mSid;
    public static String mTtid;
    public static String mUserId;

    /* compiled from: Taobao */
    static class a implements ILoginInfo {
        public boolean getCommentUsed() {
            return false;
        }

        public String getEcode() {
            return null;
        }

        public String getHeadPicLink() {
            return null;
        }

        public String getNick() {
            return null;
        }

        public String getSsoToken() {
            return null;
        }

        a() {
        }

        public String getSid() {
            return Launcher_InitAccs.mSid;
        }

        public String getUserId() {
            return Launcher_InitAccs.mUserId;
        }
    }

    public void init(Application application, HashMap<String, Object> hashMap) {
        Object obj;
        ALog.i("Launcher_InitAccs", "init", new Object[0]);
        try {
            int intValue;
            mContext = application.getApplicationContext();
            try {
                intValue = ((Integer) hashMap.get("envIndex")).intValue();
                mAppkey = (String) hashMap.get("onlineAppKey");
                if (intValue == 1) {
                    mAppkey = (String) hashMap.get("preAppKey");
                    intValue = 1;
                } else {
                    if (((intValue == 3 ? 1 : 0) | (intValue == 2 ? 1 : 0)) != 0) {
                        mAppkey = (String) hashMap.get("dailyAppkey");
                        intValue = 2;
                    } else {
                        intValue = 0;
                    }
                }
                try {
                    obj = (String) hashMap.get(IPluginManager.KEY_PROCESS);
                } catch (Throwable th) {
                    hashMap = th;
                    obj = null;
                    ALog.e("Launcher_InitAccs", "init get param error", hashMap, new Object[0]);
                    if (TextUtils.isEmpty(mAppkey) != null) {
                        ALog.e("Launcher_InitAccs", "init get appkey null！！", new Object[0]);
                        mAppkey = defaultAppkey;
                    }
                    if (TextUtils.isEmpty(obj) != null) {
                        ALog.e("Launcher_InitAccs", "init get process null！！", new Object[0]);
                        obj = com.taobao.accs.utl.a.a(mContext, Process.myPid());
                    }
                    ALog.i("Launcher_InitAccs", "init", new Object[]{"appkey", mAppkey, Constants.KEY_MODE, Integer.valueOf(intValue), IPluginManager.KEY_PROCESS, obj});
                    ACCSManager.setAppkey(mContext, mAppkey, intValue);
                    ACCSManager.setMode(mContext, intValue);
                    ACCSManager.setLoginInfoImpl(mContext, new a());
                    ACCSManager.startInAppConnection(mContext, mAppkey, mTtid, mAppReceiver);
                    ThreadPoolExecutorFactory.schedule(new c(this), 10, TimeUnit.SECONDS);
                }
                try {
                    mTtid = (String) hashMap.get(Constants.KEY_TTID);
                    mUserId = (String) hashMap.get("userId");
                    mSid = (String) hashMap.get("sid");
                } catch (Throwable th2) {
                    hashMap = th2;
                    ALog.e("Launcher_InitAccs", "init get param error", hashMap, new Object[0]);
                    if (TextUtils.isEmpty(mAppkey) != null) {
                        ALog.e("Launcher_InitAccs", "init get appkey null！！", new Object[0]);
                        mAppkey = defaultAppkey;
                    }
                    if (TextUtils.isEmpty(obj) != null) {
                        ALog.e("Launcher_InitAccs", "init get process null！！", new Object[0]);
                        obj = com.taobao.accs.utl.a.a(mContext, Process.myPid());
                    }
                    ALog.i("Launcher_InitAccs", "init", new Object[]{"appkey", mAppkey, Constants.KEY_MODE, Integer.valueOf(intValue), IPluginManager.KEY_PROCESS, obj});
                    ACCSManager.setAppkey(mContext, mAppkey, intValue);
                    ACCSManager.setMode(mContext, intValue);
                    ACCSManager.setLoginInfoImpl(mContext, new a());
                    ACCSManager.startInAppConnection(mContext, mAppkey, mTtid, mAppReceiver);
                    ThreadPoolExecutorFactory.schedule(new c(this), 10, TimeUnit.SECONDS);
                }
            } catch (Throwable th3) {
                hashMap = th3;
                obj = null;
                intValue = 0;
                ALog.e("Launcher_InitAccs", "init get param error", hashMap, new Object[0]);
                if (TextUtils.isEmpty(mAppkey) != null) {
                    ALog.e("Launcher_InitAccs", "init get appkey null！！", new Object[0]);
                    mAppkey = defaultAppkey;
                }
                if (TextUtils.isEmpty(obj) != null) {
                    ALog.e("Launcher_InitAccs", "init get process null！！", new Object[0]);
                    obj = com.taobao.accs.utl.a.a(mContext, Process.myPid());
                }
                ALog.i("Launcher_InitAccs", "init", new Object[]{"appkey", mAppkey, Constants.KEY_MODE, Integer.valueOf(intValue), IPluginManager.KEY_PROCESS, obj});
                ACCSManager.setAppkey(mContext, mAppkey, intValue);
                ACCSManager.setMode(mContext, intValue);
                ACCSManager.setLoginInfoImpl(mContext, new a());
                ACCSManager.startInAppConnection(mContext, mAppkey, mTtid, mAppReceiver);
                ThreadPoolExecutorFactory.schedule(new c(this), 10, TimeUnit.SECONDS);
            }
            if (TextUtils.isEmpty(mAppkey) != null) {
                ALog.e("Launcher_InitAccs", "init get appkey null！！", new Object[0]);
                mAppkey = defaultAppkey;
            }
            if (TextUtils.isEmpty(obj) != null) {
                ALog.e("Launcher_InitAccs", "init get process null！！", new Object[0]);
                obj = com.taobao.accs.utl.a.a(mContext, Process.myPid());
            }
            ALog.i("Launcher_InitAccs", "init", new Object[]{"appkey", mAppkey, Constants.KEY_MODE, Integer.valueOf(intValue), IPluginManager.KEY_PROCESS, obj});
            ACCSManager.setAppkey(mContext, mAppkey, intValue);
            ACCSManager.setMode(mContext, intValue);
            ACCSManager.setLoginInfoImpl(mContext, new a());
            if (TextUtils.isEmpty(obj) == null && obj.equals(mContext.getPackageName()) != null) {
                ACCSManager.startInAppConnection(mContext, mAppkey, mTtid, mAppReceiver);
            }
            ThreadPoolExecutorFactory.schedule(new c(this), 10, TimeUnit.SECONDS);
        } catch (Application application2) {
            ALog.e("Launcher_InitAccs", "init", application2, new Object[0]);
        }
    }

    static {
        Map hashMap = new HashMap();
        a = hashMap;
        hashMap.put(IXAdRequestInfo.IMSI, "com.taobao.tao.amp.remote.AccsReceiverCallback");
        a.put("powermsg", "com.taobao.appfrmbundle.mkt.AccsReceiverService");
        a.put("pmmonitor", "com.taobao.appfrmbundle.mkt.AccsReceiverService");
        a.put("motu-remote", "com.taobao.tao.log.collect.AccsTlogService");
        a.put("cloudsync", "com.taobao.datasync.network.accs.AccsCloudSyncService");
        a.put("acds", "com.taobao.acds.compact.AccsACDSService");
        a.put(GlobalClientInfo.AGOO_SERVICE_ID, "org.android.agoo.accs.AgooService");
        a.put(AgooConstants.AGOO_SERVICE_AGOOACK, "org.android.agoo.accs.AgooService");
        a.put("agooTokenReport", "org.android.agoo.accs.AgooService");
        a.put("AliLive", "com.taobao.playbudyy.gameplugin.danmu.DanmuCallbackService");
        a.put("orange", "com.taobao.orange.accssupport.OrangeAccsService");
        a.put("tsla", "com.taobao.android.festival.accs.HomepageAccsMassService");
        a.put("taobaoWaimaiAccsService", "com.taobao.takeout.order.detail.service.TakeoutOrderDetailACCSService");
        a.put("login", "com.taobao.android.sso.v2.service.LoginAccsService");
        a.put("ranger_abtest", "com.taobao.ranger3.RangerACCSService");
        a.put("accs_poplayer", "com.taobao.tbpoplayer.AccsPopLayerService");
        a.put("dm_abtest", "com.tmall.wireless.ant.accs.AntAccsService");
    }
}
