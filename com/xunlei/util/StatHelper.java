package com.xunlei.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Base64;
import com.xunlei.android.xlstat.a;
import com.xunlei.android.xlstat.param.XLStatKey;
import com.xunlei.android.xlstat.param.XLStatParam;
import com.xunlei.download.proguard.an;
import com.xunlei.downloadlib.XLDownloadManager;
import com.xunlei.downloadlib.android.XLLog;
import com.xunlei.downloadlib.parameter.GetDownloadLibVersion;
import com.xunlei.downloadprovider.app.BrothersApplication;

public class StatHelper {
    private static final String a = "StatHelper";
    private static final String b = "eGxfZGxfc2RrX2FuZHJvaWQAEgAC";
    private static final String c = "xl_dl_sdk_android";
    private static final String d = "xl_dl_sdk_android";
    private static final String e = "download_sdk";
    private static final String f = "android_sdk_stat_config.xml";
    private static final String g = "<config><server><tcp host=\"dlandroid.rcv.sandai.net\" port=\"80\"/></server><priority><level id=\"0\" report_time=\"0\"/><level id=\"1\" report_time=\"0\"/><level id=\"2\" report_time=\"1\"/><level id=\"3\" report_time=\"-1\"/><level id=\"4\" report_time=\"-2\"/></priority><stat><event index=\"4711\" key=\"download_sdk\" priority=\"2\"/></stat><max_storage_records>2000</max_storage_records><max_send_records>200</max_send_records><storage_name>statstorage_andriod_sdk.xml</storage_name><seq_id_file_name>andriod_sdk_seq_id</seq_id_file_name></config>";
    private static StatHelper j;
    private Context h;
    private XLStatKey i = null;

    public static synchronized StatHelper instance(Context context) {
        synchronized (StatHelper.class) {
            if (j == null) {
                StatHelper statHelper = new StatHelper();
                j = statHelper;
                statHelper.h = context.getApplicationContext();
                j.a();
                an.b(a, "instance()");
            }
            context = j;
        }
        return context;
    }

    private void a() {
        PackageInfo packageInfo;
        try {
            packageInfo = this.h.getPackageManager().getPackageInfo(this.h.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        String str = (packageInfo == null || packageInfo.versionName == null) ? "android sdk" : packageInfo.packageName;
        String str2 = new String(Base64.encode(str.getBytes(), 0));
        GetDownloadLibVersion getDownloadLibVersion = new GetDownloadLibVersion();
        XLDownloadManager.getInstance(this.h).getDownloadLibVersion(getDownloadLibVersion);
        XLStatParam xLStatParam = new XLStatParam();
        xLStatParam.mAppKey = b;
        xLStatParam.mAppName = "xl_dl_sdk_android";
        xLStatParam.mAppVersion = getDownloadLibVersion.mVersion != null ? getDownloadLibVersion.mVersion : "1.0";
        String str3 = (packageInfo == null || packageInfo.versionName == null) ? "1.0" : packageInfo.versionName;
        xLStatParam.mProductVersion = str3;
        xLStatParam.mProductKey = "Y29tLnh1bmxlaS5kb3dubG9hZHByb3ZpZGVyAHkXAQ==";
        xLStatParam.mProductName = BrothersApplication.COM_XUNLEI_DOWNLOADPROVIDER;
        xLStatParam.mStoragePath = this.h.getFilesDir().getPath();
        xLStatParam.mConfigPath = this.h.getFilesDir().getPath();
        xLStatParam.mConfigFileName = f;
        xLStatParam.mConfigBuffer = g;
        this.i = new XLStatKey();
        int a = a.a(this.h).a(xLStatParam, this.i);
        String str4 = a;
        StringBuilder stringBuilder = new StringBuilder("init ret = ");
        stringBuilder.append(a);
        an.b(str4, stringBuilder.toString());
    }

    private void b() {
        a a = a.a(this.h);
        XLStatKey xLStatKey = this.i;
        if (xLStatKey != null) {
            if (xLStatKey.mKey != 0) {
                if (a.a == null) {
                    XLLog.e("XLStatManager", "unInit mLoader is null");
                    return;
                }
                int unInit = a.a.unInit(xLStatKey.mKey);
                XLLog.i("XLStatManager", "undoMonitorNetworkChange()");
                if (!(a.b == null || a.c == null)) {
                    a.b.unregisterReceiver(a.c);
                    XLLog.i("XLStatManager", "unregister Receiver");
                    a.c = null;
                }
                StringBuilder stringBuilder = new StringBuilder("unInit ret = ");
                stringBuilder.append(unInit);
                stringBuilder.append(", key=");
                stringBuilder.append(xLStatKey.mKey);
                XLLog.d("XLStatManager", stringBuilder.toString());
                return;
            }
        }
        XLLog.e("XLStatManager", "unInit key is null");
    }

    public void trackStatusChange(String str) {
        a(e, str);
    }

    private void a(String str, String str2) {
        a.a(this.h).a(this.i, str, str2);
    }
}
