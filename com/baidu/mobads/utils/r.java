package com.baidu.mobads.utils;

import android.net.wifi.ScanResult;
import java.util.Comparator;

class r implements Comparator<ScanResult> {
    final /* synthetic */ o a;

    r(o oVar) {
        this.a = oVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((ScanResult) obj, (ScanResult) obj2);
    }

    public int a(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }
}
