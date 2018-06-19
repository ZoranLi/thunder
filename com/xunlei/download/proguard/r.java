package com.xunlei.download.proguard;

import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.NetworkInfo;

/* compiled from: SystemFacade */
public interface r {
    long a();

    NetworkInfo a(int i);

    void a(Intent intent);

    boolean a(int i, String str) throws NameNotFoundException;

    boolean b();

    boolean c();

    Long d();

    Long e();
}
