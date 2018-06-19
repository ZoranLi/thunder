package com.qihoo360.replugin.component;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.qihoo360.i.Factory;
import com.qihoo360.mobilesafe.parser.manifest.ManifestParser;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.component.utils.a;
import com.qihoo360.replugin.ext.parser.b;
import com.qihoo360.replugin.model.PluginInfo;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class ComponentList {
    final HashMap<String, ActivityInfo> a = new HashMap();
    final HashMap<String, ProviderInfo> b = new HashMap();
    final HashMap<String, ProviderInfo> c = new HashMap();
    final HashMap<String, ServiceInfo> d = new HashMap();
    ApplicationInfo e = null;
    final HashMap<String, ActivityInfo> f = new HashMap();

    public ComponentList(PackageInfo packageInfo, String str, PluginInfo pluginInfo) {
        int length;
        int i = 0;
        if (packageInfo.activities != null) {
            for (ActivityInfo activityInfo : packageInfo.activities) {
                if (c.a) {
                    StringBuilder stringBuilder = new StringBuilder("activity=");
                    stringBuilder.append(activityInfo.name);
                    c.a("ws001", stringBuilder.toString());
                }
                activityInfo.applicationInfo.sourceDir = str;
                if (activityInfo.processName == null) {
                    activityInfo.processName = activityInfo.applicationInfo.processName;
                }
                if (activityInfo.processName == null) {
                    activityInfo.processName = activityInfo.packageName;
                }
                this.a.put(activityInfo.name, activityInfo);
            }
        }
        if (packageInfo.providers != null) {
            for (ProviderInfo providerInfo : packageInfo.providers) {
                if (c.a) {
                    stringBuilder = new StringBuilder("provider=");
                    stringBuilder.append(providerInfo.name);
                    stringBuilder.append("; auth=");
                    stringBuilder.append(providerInfo.authority);
                    c.a("ws001", stringBuilder.toString());
                }
                if (providerInfo.processName == null) {
                    providerInfo.processName = providerInfo.applicationInfo.processName;
                }
                if (providerInfo.processName == null) {
                    providerInfo.processName = providerInfo.packageName;
                }
                this.b.put(providerInfo.name, providerInfo);
                this.c.put(providerInfo.authority, providerInfo);
            }
        }
        if (packageInfo.services != null) {
            for (ServiceInfo serviceInfo : packageInfo.services) {
                if (c.a) {
                    stringBuilder = new StringBuilder("service=");
                    stringBuilder.append(serviceInfo.name);
                    c.a("ws001", stringBuilder.toString());
                }
                if (serviceInfo.processName == null) {
                    serviceInfo.processName = serviceInfo.applicationInfo.processName;
                }
                if (serviceInfo.processName == null) {
                    serviceInfo.processName = serviceInfo.packageName;
                }
                this.d.put(serviceInfo.name, serviceInfo);
            }
        }
        if (packageInfo.receivers != null) {
            ActivityInfo[] activityInfoArr = packageInfo.receivers;
            length = activityInfoArr.length;
            while (i < length) {
                ActivityInfo activityInfo2 = activityInfoArr[i];
                if (c.a) {
                    StringBuilder stringBuilder2 = new StringBuilder("receiver=");
                    stringBuilder2.append(activityInfo2.name);
                    c.a("ws001", stringBuilder2.toString());
                }
                if (activityInfo2.processName == null) {
                    activityInfo2.processName = activityInfo2.applicationInfo.processName;
                }
                if (activityInfo2.processName == null) {
                    activityInfo2.processName = activityInfo2.packageName;
                }
                this.f.put(activityInfo2.name, activityInfo2);
                i++;
            }
        }
        String a = a(str);
        if (c.a) {
            StringBuilder stringBuilder3 = new StringBuilder("\n解析插件 ");
            stringBuilder3.append(pluginInfo.getName());
            stringBuilder3.append(" : ");
            stringBuilder3.append(str);
            stringBuilder3.append("\nAndroidManifest: \n");
            stringBuilder3.append(a);
            c.a("ws001", stringBuilder3.toString());
        }
        ManifestParser.INS.parse(pluginInfo, a);
        this.e = packageInfo.applicationInfo;
        if (this.e.dataDir == null) {
            packageInfo = this.e;
            str = new StringBuilder();
            str.append(Environment.getDataDirectory());
            str.append(File.separator);
            str.append("data");
            str.append(File.separator);
            str.append(this.e.packageName);
            packageInfo.dataDir = str.toString();
        }
        if (c.a != null) {
            str = new StringBuilder("mApplication: ");
            str.append(this.e);
            c.a("ws001", str.toString());
        }
    }

    private static String a(String str) {
        String a = a.a(str);
        if (TextUtils.isEmpty(a)) {
            b bVar = null;
            try {
                b bVar2 = new b(str);
                try {
                    if (c.a != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        str = bVar2.a();
                        long currentTimeMillis2 = System.currentTimeMillis();
                        StringBuilder stringBuilder = new StringBuilder("从 apk 中解析 xml 耗时 ");
                        stringBuilder.append(currentTimeMillis2 - currentTimeMillis);
                        stringBuilder.append(" 毫秒");
                        c.a("ws001", stringBuilder.toString());
                    } else {
                        str = bVar2.a();
                    }
                    try {
                        bVar2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return str;
                } catch (IOException e2) {
                    str = e2;
                    bVar = bVar2;
                    try {
                        str.printStackTrace();
                        if (bVar != null) {
                            try {
                                bVar.close();
                            } catch (String str2) {
                                str2.printStackTrace();
                            }
                        }
                        return "";
                    } catch (Throwable th) {
                        str2 = th;
                        bVar2 = bVar;
                        if (bVar2 != null) {
                            try {
                                bVar2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw str2;
                    }
                } catch (Throwable th2) {
                    str2 = th2;
                    if (bVar2 != null) {
                        bVar2.close();
                    }
                    throw str2;
                }
            } catch (IOException e4) {
                str2 = e4;
                str2.printStackTrace();
                if (bVar != null) {
                    bVar.close();
                }
                return "";
            }
        }
        if (c.a != null) {
            StringBuilder stringBuilder2 = new StringBuilder("从 apk comment 中解析 xml:\n ");
            stringBuilder2.append(a);
            c.a("ws001", stringBuilder2.toString());
        }
        return a;
    }

    public ServiceInfo getService(String str) {
        return (ServiceInfo) this.d.get(str);
    }

    public ServiceInfo[] getServices() {
        return (ServiceInfo[]) this.d.values().toArray(new ServiceInfo[0]);
    }

    public ActivityInfo getActivity(String str) {
        return (ActivityInfo) this.a.get(str);
    }

    public ActivityInfo[] getActivities() {
        return (ActivityInfo[]) this.a.values().toArray(new ActivityInfo[0]);
    }

    public ActivityInfo getReveiver(String str) {
        return (ActivityInfo) this.f.get(str);
    }

    public ActivityInfo[] getReceivers() {
        return (ActivityInfo[]) this.f.values().toArray(new ActivityInfo[0]);
    }

    public Pair<ServiceInfo, String> getServiceAndPluginByIntent(Context context, Intent intent) {
        Object action = intent.getAction();
        if (!TextUtils.isEmpty(action)) {
            Set<String> pluginsByActionWhenStartService = ManifestParser.INS.getPluginsByActionWhenStartService(action);
            if (pluginsByActionWhenStartService != null) {
                for (String str : pluginsByActionWhenStartService) {
                    ServiceInfo queryServiceInfo = Factory.queryServiceInfo(str, com.qihoo360.replugin.component.utils.b.a(context, intent, ManifestParser.INS.getServiceFilterMap(str)));
                    if (queryServiceInfo != null) {
                        return new Pair(queryServiceInfo, str);
                    }
                }
            }
        }
        return null;
    }

    public ProviderInfo getProvider(String str) {
        return (ProviderInfo) this.b.get(str);
    }

    public ProviderInfo getProviderByAuthority(String str) {
        return (ProviderInfo) this.c.get(str);
    }

    public ProviderInfo[] getProviders() {
        return (ProviderInfo[]) this.b.values().toArray(new ProviderInfo[0]);
    }

    public ApplicationInfo getApplication() {
        return this.e;
    }

    public HashMap<String, ActivityInfo> getActivityMap() {
        return this.a;
    }

    public HashMap<String, ServiceInfo> getServiceMap() {
        return this.d;
    }

    public HashMap<String, ActivityInfo> getReceiverMap() {
        return this.f;
    }

    public HashMap<String, ProviderInfo> getProviderMap() {
        return this.c;
    }
}
