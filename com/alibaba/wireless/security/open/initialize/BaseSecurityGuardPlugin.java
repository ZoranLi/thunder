package com.alibaba.wireless.security.open.initialize;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.alibaba.wireless.security.open.IRouterComponent;
import com.alibaba.wireless.security.open.SecException;

public abstract class BaseSecurityGuardPlugin implements ISecurityGuardPlugin {
    private Context a = null;
    private IRouterComponent b = null;
    private PackageInfo c = null;

    public Context getContext() {
        return this.a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized <T> T getInterface(java.lang.Class<T> r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = 0;
        if (r4 != 0) goto L_0x0006;
    L_0x0004:
        monitor-exit(r3);
        return r0;
    L_0x0006:
        r1 = r3.getInterfaceToImplMaps();	 Catch:{ all -> 0x001d }
        r1 = r1.get(r4);	 Catch:{ all -> 0x001d }
        if (r1 == 0) goto L_0x001b;
    L_0x0010:
        r2 = r1.getClass();	 Catch:{ all -> 0x001d }
        r4 = r4.isAssignableFrom(r2);	 Catch:{ all -> 0x001d }
        if (r4 == 0) goto L_0x001b;
    L_0x001a:
        r0 = r1;
    L_0x001b:
        monitor-exit(r3);
        return r0;
    L_0x001d:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.open.initialize.BaseSecurityGuardPlugin.getInterface(java.lang.Class):T");
    }

    public String getMetaData(String str) {
        PackageInfo packageInfo = getPackageInfo();
        return packageInfo != null ? packageInfo.applicationInfo.metaData.getString(str) : "";
    }

    public PackageInfo getPackageInfo() {
        return this.c;
    }

    public IRouterComponent getRouter() {
        return this.b;
    }

    public String getVersion() {
        return getPackageInfo().versionName;
    }

    public IRouterComponent onPluginLoaded(Context context, IRouterComponent iRouterComponent, PackageInfo packageInfo, String str) throws SecException {
        setContext(context);
        setRouter(iRouterComponent);
        setPackageInfo(packageInfo);
        return iRouterComponent;
    }

    public void setContext(Context context) {
        this.a = context;
    }

    public void setPackageInfo(PackageInfo packageInfo) {
        this.c = packageInfo;
    }

    public void setRouter(IRouterComponent iRouterComponent) {
        this.b = iRouterComponent;
    }
}
