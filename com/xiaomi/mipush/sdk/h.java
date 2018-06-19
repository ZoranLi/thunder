package com.xiaomi.mipush.sdk;

import android.net.wifi.ScanResult;
import java.util.Comparator;

final class h implements Comparator<ScanResult> {
    h() {
    }

    public final int a(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return a((ScanResult) obj, (ScanResult) obj2);
    }
}
