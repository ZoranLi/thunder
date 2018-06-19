package com.ut.mini.internal;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.c.c;
import com.ut.device.UTDevice;
import com.ut.mini.base.UTMIVariables;
import java.util.Map;

public class UTTeamWork {
    private static UTTeamWork a;

    public void disableNetworkStatusChecker() {
    }

    public void dispatchLocalHits() {
    }

    public void initialized() {
    }

    public static synchronized UTTeamWork getInstance() {
        UTTeamWork uTTeamWork;
        synchronized (UTTeamWork.class) {
            if (a == null) {
                a = new UTTeamWork();
            }
            uTTeamWork = a;
        }
        return uTTeamWork;
    }

    public void turnOnRealTimeDebug(Map<String, String> map) {
        AppMonitor.a(map);
    }

    public void turnOffRealTimeDebug() {
        AppMonitor.b();
    }

    public void saveCacheDataToLocal() {
        c.a().b();
    }

    public void setToAliyunOsPlatform() {
        UTMIVariables.getInstance().setToAliyunOSPlatform();
    }

    public String getUtsid() {
        try {
            Object a = a.d() != null ? a.d().a() : null;
            Object utdid = UTDevice.getUtdid(b.a().a);
            long longValue = Long.valueOf(a.f).longValue();
            if (!(TextUtils.isEmpty(a) || TextUtils.isEmpty(utdid))) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(utdid);
                stringBuilder.append("_");
                stringBuilder.append(a);
                stringBuilder.append("_");
                stringBuilder.append(longValue);
                return stringBuilder.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeAuto1010Track() {
        com.alibaba.mtl.log.c.a().b();
    }
}
