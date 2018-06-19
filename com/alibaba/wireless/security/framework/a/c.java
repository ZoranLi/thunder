package com.alibaba.wireless.security.framework.a;

import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import dalvik.system.DexClassLoader;

public class c {
    public String a;
    public String b = a();
    public DexClassLoader c;
    public AssetManager d;
    public Resources e;
    public PackageInfo f;
    public ISecurityGuardPlugin g;

    public c(DexClassLoader dexClassLoader, Resources resources, PackageInfo packageInfo, ISecurityGuardPlugin iSecurityGuardPlugin) {
        this.a = packageInfo.packageName;
        this.c = dexClassLoader;
        this.d = resources.getAssets();
        this.e = resources;
        this.f = packageInfo;
        this.g = iSecurityGuardPlugin;
    }

    private final String a() {
        return (this.f.activities == null || this.f.activities.length <= 0) ? "" : this.f.activities[0].name;
    }
}
