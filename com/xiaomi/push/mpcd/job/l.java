package com.xiaomi.push.mpcd.job;

import android.net.wifi.ScanResult;
import java.util.Comparator;

class l implements Comparator<ScanResult> {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public int a(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((ScanResult) obj, (ScanResult) obj2);
    }
}
