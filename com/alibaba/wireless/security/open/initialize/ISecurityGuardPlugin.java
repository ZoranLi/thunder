package com.alibaba.wireless.security.open.initialize;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.alibaba.wireless.security.open.IRouterComponent;
import com.alibaba.wireless.security.open.SecException;
import java.util.HashMap;

public interface ISecurityGuardPlugin {
    public static final String METADATA_ACTIVITIES = "activities";
    public static final String METADATA_DEPENDENCIES = "dependencies";
    public static final String METADATA_HASHES = "hashes";
    public static final String METADATA_PLUGINID = "pluginid";

    Context getContext();

    <T> T getInterface(Class<T> cls);

    HashMap<Class, Object> getInterfaceToImplMaps();

    String getMetaData(String str);

    PackageInfo getPackageInfo();

    String getPluginName();

    IRouterComponent getRouter();

    String getVersion();

    void init(Context context, Object... objArr) throws SecException;

    IRouterComponent onPluginLoaded(Context context, IRouterComponent iRouterComponent, PackageInfo packageInfo, String str) throws SecException;

    void setContext(Context context);

    void setPackageInfo(PackageInfo packageInfo);

    void setRouter(IRouterComponent iRouterComponent);
}
