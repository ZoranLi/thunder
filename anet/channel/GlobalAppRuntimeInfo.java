package anet.channel;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import anet.channel.util.Utils;
import anet.channel.util.d;

/* compiled from: Taobao */
public class GlobalAppRuntimeInfo {
    private static final String TAG = "awcn.GlobalAppRuntimeInfo";
    private static Context context = null;
    private static String currentProcess = "";
    private static ENV env = ENV.ONLINE;
    public static volatile boolean isBackground = true;
    public static String mConnToken = null;
    private static volatile d proxySetting = null;
    private static String targetProcess = "";
    private static String ttid;
    private static String userId;
    private static String utdid;

    @Deprecated
    public static void setUtdid(String str) {
    }

    public static void setContext(Context context) {
        context = context;
        if (context != null) {
            if (TextUtils.isEmpty(currentProcess)) {
                currentProcess = Utils.getProcessName(context, Process.myPid());
            }
            if (TextUtils.isEmpty(targetProcess)) {
                targetProcess = Utils.getMainProcessName(context);
            }
            ALog.e(TAG, "", null, "CurrentProcess", currentProcess, "TargetProcess", targetProcess);
        }
    }

    public static Context getContext() {
        return context;
    }

    public static void setTargetProcess(String str) {
        targetProcess = str;
    }

    public static boolean isTargetProcess() {
        if (!TextUtils.isEmpty(targetProcess)) {
            if (!TextUtils.isEmpty(currentProcess)) {
                return targetProcess.equalsIgnoreCase(currentProcess);
            }
        }
        return true;
    }

    public static String getCurrentProcess() {
        return currentProcess;
    }

    public static void setCurrentProcess(String str) {
        currentProcess = str;
    }

    public static void setEnv(ENV env) {
        env = env;
    }

    public static ENV getEnv() {
        return env;
    }

    public static void setTtid(String str) {
        ttid = str;
    }

    public static String getTtid() {
        return ttid;
    }

    public static void setUserId(String str) {
        if (userId == null || !userId.equals(str)) {
            userId = str;
            StrategyCenter.getInstance().forceRefreshStrategy(DispatchConstants.getAmdcServerDomain());
        }
    }

    public static String getUserId() {
        return userId;
    }

    public static String getUtdid() {
        if (utdid == null && context != null) {
            utdid = Utils.getDeviceId(context);
        }
        return utdid;
    }

    public static void setBackground(boolean z) {
        isBackground = z;
    }

    public static boolean isAppBackground() {
        if (context == null) {
            return true;
        }
        return isBackground;
    }

    public static void setProxySetting(d dVar) {
        proxySetting = dVar;
    }

    public static d getProxySetting() {
        return proxySetting;
    }
}
