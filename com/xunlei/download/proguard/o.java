package com.xunlei.download.proguard;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.net.ConnectivityManagerCompat;
import android.telephony.TelephonyManager;
import com.xunlei.download.DownloadManager;

/* compiled from: RealSystemFacade */
public class o implements r {
    private Context a;

    public o(Context context) {
        this.a = context;
    }

    public long a() {
        return System.currentTimeMillis();
    }

    public NetworkInfo a(int i) {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        an.c("DownloadManager", "couldn't get connectivity manager");
        return 0;
    }

    public boolean b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
        if (connectivityManager != null) {
            return ConnectivityManagerCompat.isActiveNetworkMetered(connectivityManager);
        }
        an.c("DownloadManager", "couldn't get connectivity manager");
        return false;
    }

    public boolean c() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
        boolean z = false;
        if (connectivityManager == null) {
            an.c("DownloadManager", "couldn't get connectivity manager");
            return false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) this.a.getSystemService("phone");
        if (telephonyManager == null) {
            an.c("DownloadManager", "couldn't get tel manager");
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.getType() == 0;
        if (z2 && telephonyManager.isNetworkRoaming()) {
            z = true;
        }
        an.e("DownloadManager", "network is roaming");
        return z;
    }

    public Long d() {
        return DownloadManager.getMaxBytesOverMobile(this.a);
    }

    public Long e() {
        return DownloadManager.getRecommendedMaxBytesOverMobile(this.a);
    }

    public void a(Intent intent) {
        this.a.sendBroadcast(intent);
    }

    public boolean a(int i, String str) throws NameNotFoundException {
        return this.a.getPackageManager().getApplicationInfo(str, 0).uid == i;
    }
}
