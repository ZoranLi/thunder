package com.qq.e.comm.services;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.qihoo360.i.IPluginManager;
import com.qq.e.comm.constants.Constants.KEYS;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.DeviceStatus;
import com.qq.e.comm.net.NetworkCallBack;
import com.qq.e.comm.net.NetworkClient.Priority;
import com.qq.e.comm.net.NetworkClientImpl;
import com.qq.e.comm.net.rr.S2SSRequest;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static final a a = new a();
    private volatile Boolean b = Boolean.valueOf(false);

    public static a a() {
        return a;
    }

    private static String a(Context context) {
        int myPid = Process.myPid();
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    private static String a(SM sm, PM pm, DeviceStatus deviceStatus, APPStatus aPPStatus, Context context, long j) {
        JSONObject a;
        Throwable e;
        JSONObject jSONObject = new JSONObject();
        try {
            a = com.qq.e.comm.a.a(sm);
            try {
                String str = INoCaptchaComponent.sig;
                JSONObject jSONObject2 = new JSONObject();
                if (sm != null) {
                    jSONObject2.putOpt("app", sm.getDevCloudSettingSig());
                    jSONObject2.putOpt("sdk", sm.getSdkCloudSettingSig());
                }
                if (pm != null) {
                    jSONObject2.putOpt(ShareConstants.DEXMODE_JAR, pm.getLocalSig());
                    jSONObject2.putOpt(KEYS.PLUGIN_VERSION, Integer.valueOf(pm.getPluginVersion()));
                }
                a.put(str, jSONObject2);
                String str2 = "dev";
                jSONObject = new JSONObject();
                if (deviceStatus != null) {
                    jSONObject.putOpt("did", deviceStatus.getPlainDid());
                    jSONObject.putOpt(IXAdRequestInfo.TEST_MODE, deviceStatus.model);
                    jSONObject.putOpt("lg", deviceStatus.getLanguage());
                    jSONObject.putOpt(IXAdRequestInfo.WIDTH, Integer.valueOf(deviceStatus.getDeviceWidth()));
                    jSONObject.putOpt(IXAdRequestInfo.HEIGHT, Integer.valueOf(deviceStatus.getDeviceHeight()));
                    jSONObject.putOpt("dd", Integer.valueOf(deviceStatus.getDeviceDensity()));
                    jSONObject.putOpt("apil", Integer.valueOf(deviceStatus.getVersion()));
                    jSONObject.putOpt("os", DispatchConstants.ANDROID);
                    jSONObject.putOpt("op", deviceStatus.getOperator());
                    jSONObject.putOpt("mf", Build.MANUFACTURER);
                }
                a.put(str2, jSONObject);
                a.put("app", com.qq.e.comm.a.a(aPPStatus));
                JSONObject a2 = com.qq.e.comm.a.a(deviceStatus);
                a2.putOpt(IPluginManager.KEY_PROCESS, a(context));
                a.put(c.a, a2);
                a.put("sdk", com.qq.e.comm.a.a(pm));
                a2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("sdk_init_time", (System.nanoTime() - j) / 1000000);
                a2.put("performance", jSONObject3);
                a.put("biz", a2);
            } catch (JSONException e2) {
                e = e2;
                GDTLogger.e("JSONException while build init req", e);
                return a.toString();
            }
        } catch (JSONException e3) {
            e = e3;
            a = jSONObject;
            GDTLogger.e("JSONException while build init req", e);
            return a.toString();
        }
        return a.toString();
    }

    public static void a(String str, Throwable th) {
        if (GDTADManager.getInstance() == null || !GDTADManager.getInstance().isInitialized()) {
            GDTLogger.w("Report Not Work while  ADManager  not Inited");
            return;
        }
        try {
            JSONObject a = com.qq.e.comm.a.a(GDTADManager.getInstance().getSM());
            a.put(c.a, com.qq.e.comm.a.a(GDTADManager.getInstance().getDeviceStatus()));
            a.put("app", com.qq.e.comm.a.a(GDTADManager.getInstance().getAppStatus()));
            Map hashMap = new HashMap();
            if (th != null) {
                hashMap.put("extype", th.getClass().getName());
                String str2 = SocializeProtocolConstants.PROTOCOL_KEY_EXTEND;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("\r");
                stringBuilder.append(th.getMessage());
                stringBuilder.append("\r");
                stringBuilder.append(Arrays.toString(th.getStackTrace()));
                hashMap.put(str2, stringBuilder.toString());
            } else {
                hashMap.put("extype", "");
                hashMap.put("ex", str);
            }
            a.put("biz", new JSONObject(hashMap));
            NetworkClientImpl.getInstance().submit(new S2SSRequest("http://sdk.e.qq.com/err", a.toString().getBytes()));
        } catch (Throwable th2) {
            GDTLogger.w("Exception While build s2ss error report req", th2);
        }
    }

    public final void a(Context context, SM sm, PM pm, DeviceStatus deviceStatus, APPStatus aPPStatus, long j) {
        if (!this.b.booleanValue()) {
            synchronized (this.b) {
                if (this.b.booleanValue()) {
                    return;
                }
                String a = a(sm, pm, deviceStatus, aPPStatus, context, j);
                StringBuilder stringBuilder = new StringBuilder("launch request: ");
                stringBuilder.append(a);
                GDTLogger.d(stringBuilder.toString());
                String str = "http://sdk.e.qq.com/activate";
                if (!StringUtil.isEmpty(sm.getSuid())) {
                    str = "http://sdk.e.qq.com/launch";
                }
                NetworkCallBack 1 = new 1(sm, pm, System.currentTimeMillis());
                NetworkClientImpl.getInstance().submit(new S2SSRequest(str, a.getBytes()), Priority.High, 1);
                this.b = Boolean.valueOf(true);
            }
        }
    }
}
