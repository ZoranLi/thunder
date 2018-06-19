package com.xunlei.downloadprovider.plugin.a;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.qihoo360.replugin.b;
import com.xunlei.a.c.b.a;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.androidutil.OSUtil;
import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.ad.notification.NotificationADInfo;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.cooperation.data.CooperationScene;
import com.xunlei.downloadprovider.cooperation.ui.g;
import com.xunlei.downloadprovider.d.l;
import com.xunlei.downloadprovider.download.c;
import com.xunlei.downloadprovider.download.downloadvod.h;
import com.xunlei.downloadprovider.download.engine.kernel.i;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.report.DLCenterEntry;
import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord;
import com.xunlei.downloadprovider.personal.playrecord.v;
import com.xunlei.downloadprovider.plugin.q;
import com.xunlei.downloadprovider.web.BrowserFrom;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ThunderHostFacadeImpl */
public class d extends a implements b {
    private static final String a = "d";

    public final IBinder a() {
        OSUtil.getCurProcessName(BrothersApplication.getApplicationInstance());
        return this;
    }

    public final void b() {
        com.xunlei.downloadprovider.download.report.a.e(NotificationADInfo.REPORT_STATUS_CLICK);
    }

    public final void a(String str) {
        com.xunlei.downloadprovider.download.report.a.e(str);
    }

    public final void a(long j) {
        com.xunlei.downloadprovider.download.a.a(BrothersApplication.getApplicationInstance(), j, DLCenterEntry.other.toString());
    }

    public final void a(String str, String str2, String str3, int i, boolean z) {
        StringBuilder stringBuilder = new StringBuilder("createTask url=");
        stringBuilder.append(str);
        stringBuilder.append(",refUrl=");
        stringBuilder.append(str2);
        n.a();
        if (n.b()) {
            TaskStatInfo taskStatInfo = new TaskStatInfo(str, str2);
            taskStatInfo.g = z;
            taskStatInfo.a = "manual/manual_codeScan";
            c.a(str, str3, 0, str2, taskStatInfo, null, new e(this));
            str = LocalBroadcastManager.getInstance(BrothersApplication.getApplicationInstance());
            str2 = new Intent();
            str2.setAction("ACTION_CAN_CREATE_TASK");
            str2.putExtra("canCreate", true);
            str2.putExtra("reportType", i);
            str.sendBroadcast(str2);
        }
    }

    public final void a(String str, boolean z) {
        com.xunlei.downloadprovider.web.a.a();
        com.xunlei.downloadprovider.web.a.a(BrothersApplication.getApplicationInstance(), str, z, BrowserFrom.SCAN_QRCODE);
    }

    public final void a(String str, Map map) throws RemoteException {
        if (!TextUtils.isEmpty(str)) {
            str = StatEvent.build(str);
            if (!(map == null || map.isEmpty())) {
                str.addAll(map);
            }
            ThunderReport.reportEvent(str);
        }
    }

    public final void c() {
        com.xunlei.downloadprovider.cooperation.ui.b a = com.xunlei.downloadprovider.cooperation.ui.b.a();
        try {
            if (!a.d) {
                CooperationScene b = com.xunlei.downloadprovider.cooperation.c.a().b(1002);
                if (!(b == null || TextUtils.isEmpty(b.getAttachment()) || (Long.parseLong(b.getAttachment()) * 1024) * 1024 <= DownloadConfig.getStorageAvailableSize(BrothersApplication.getApplicationInstance()))) {
                    a.a.post(new g(a));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final Map d() {
        Map hashMap = new HashMap();
        hashMap.put("KEY_BuildConfig_DEBUG", Boolean.valueOf(false));
        hashMap.put("KEY_IsShowAccelerateTipForPlayer", Boolean.valueOf(com.xunlei.downloadprovider.d.d.a().d.a()));
        com.xunlei.downloadprovider.d.b.c cVar = com.xunlei.downloadprovider.d.d.a().d;
        hashMap.put("KEY_IsBxbbSpeedUpFreeTrialEnable", Boolean.valueOf(com.xunlei.downloadprovider.d.b.c.b()));
        hashMap.put("KEY_IsBxbbSubtitleEnable", Boolean.valueOf(com.xunlei.downloadprovider.d.d.a().i.b()));
        hashMap.put("KEY_IsRecordSwitchEnable", Boolean.valueOf(com.xunlei.downloadprovider.d.d.a().i.a()));
        hashMap.put("KEY_IsLocalPlaySubtitleEnable", Boolean.valueOf(com.xunlei.downloadprovider.d.d.a().i.c()));
        hashMap.put("KEY_GetVipArrayForStalling", com.xunlei.downloadprovider.d.d.a().d.c());
        hashMap.put("KEY_IsNotificationSoundOn", Boolean.valueOf(SettingStateController.getInstance().isSoundOn()));
        hashMap.put("KEY_IsPublishAfterVideoRecord", Boolean.valueOf(l.a().f()));
        hashMap.put("KEY_GetDownloadTaskUrl", com.xunlei.downloadprovider.d.d.a().n.a());
        return hashMap;
    }

    public final void b(String str) {
        v.a().a(str, new f(this), null);
    }

    public final void a(boolean z) {
        SettingStateController.getInstance().setSound(z);
    }

    public final void c(String str, boolean z) {
        q.a().a(str, new g(this, str), z);
    }

    public final Bundle e() throws RemoteException {
        Bundle bundle = new Bundle(7);
        bundle.putString("hostAppBranch", "thunder");
        bundle.putInt("versionCode", 11100);
        bundle.putString("versionName", "5.60.2.5510");
        bundle.putInt("systemVersion", AndroidConfig.getAndroidVersion());
        bundle.putString("productID", AndroidConfig.getProductId());
        bundle.putString("partnerID", AndroidConfig.getPartnerId());
        bundle.putString("deviceGuid", AndroidConfig.getHubbleDeviceGUID());
        return bundle;
    }

    public final void b(long j) throws RemoteException {
        com.xunlei.downloadprovider.download.downloadvod.a.setDownloadVodAllowMobileNetwork(j);
    }

    public final void a(long j, long j2) throws RemoteException {
        n.a().a(j, j2);
    }

    public final String b(String str, boolean z) throws RemoteException {
        return i.a(BrothersApplication.getApplicationInstance(), str, z);
    }

    public final void a(String str, String str2, String str3, long j, String str4, String str5, String str6, boolean z) throws RemoteException {
        String str7 = str5;
        com.xunlei.downloadprovider.download.downloadvod.a.getInstance().obtainDownloadVodInfo(str, str2, str3, j, new h(str7), str7, str4, str6, z);
    }

    public final void a(Bundle bundle, boolean z) {
        if (bundle != null) {
            VideoPlayRecord videoPlayRecord = new VideoPlayRecord();
            if (bundle != null) {
                videoPlayRecord.c = bundle.getString("KEY_PlayerRecord_TypeTag", "");
                videoPlayRecord.d = bundle.getString("KEY_PlayerRecord_Name", "");
                videoPlayRecord.e = bundle.getString("KEY_PlayerRecord_PlayUrl", "");
                videoPlayRecord.f = bundle.getString("KEY_PlayerRecord_CoverUrl", "");
                videoPlayRecord.g = bundle.getLong("KEY_PlayerRecord_Duration");
                videoPlayRecord.h = bundle.getLong("KEY_PlayerRecord_PlayedTime");
                videoPlayRecord.i = bundle.getLong("KEY_PlayerRecord_MaxPlayedTime");
                videoPlayRecord.j = bundle.getLong("KEY_PlayerRecord_LastPlayTimestamp");
                videoPlayRecord.k = bundle.getLong("KEY_PlayerRecord_Size");
                videoPlayRecord.l = bundle.getString("KEY_PlayerRecord_DownloadUrl", "");
                videoPlayRecord.m = bundle.getString("KEY_PlayerRecord_Cid", "");
                videoPlayRecord.n = bundle.getString("KEY_PlayerRecord_Gcid", "");
                videoPlayRecord.o = bundle.getString("KEY_PlayerRecord_MovieId", "");
            }
            v.a().a(videoPlayRecord, z);
        }
    }

    static /* synthetic */ Bundle a(String str, String str2) {
        Bundle bundle = new Bundle(9);
        bundle.putString("KEY_Host_Plugin_Manager_Prepare_Callback", str);
        bundle.putString("KEY_Host_Plugin_Manager_Package_Name", str2);
        return bundle;
    }
}
