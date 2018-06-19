package com.qihoo360.replugin;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qihoo360.a.a.e;
import com.qihoo360.i.Factory;
import com.qihoo360.i.Factory2;
import com.qihoo360.loader2.ac;
import com.qihoo360.loader2.ah;
import com.qihoo360.loader2.aj;
import com.qihoo360.loader2.d;
import com.qihoo360.loader2.f;
import com.qihoo360.loader2.m;
import com.qihoo360.loader2.n;
import com.qihoo360.mobilesafe.svcmanager.QihooServiceManager;
import com.qihoo360.replugin.a.b;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.component.ComponentList;
import com.qihoo360.replugin.debugger.DebuggerReceivers;
import com.qihoo360.replugin.model.PluginInfo;
import com.qihoo360.replugin.packages.PluginRunningList;
import com.qihoo360.replugin.packages.g;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class RePlugin {
    public static final String PLUGIN_NAME_MAIN = "main";
    public static final String PROCESS_AUTO = "-2147483648";
    public static final String PROCESS_PERSIST = "-2";
    public static final String PROCESS_UI = "-1";
    private static f a;

    public static class a {
        static boolean a;

        public static void a(Application application, f fVar) {
            if (a) {
                if (c.a != null) {
                    c.a("RePlugin", "attachBaseContext: Already called");
                }
                return;
            }
            g.a(application);
            RePlugin.a = fVar;
            fVar = RePlugin.a;
            if (fVar.c == null) {
                fVar.c = application.getFilesDir();
            }
            if (fVar.a == null) {
                fVar.a = new d(application);
            }
            if (fVar.b == null) {
                fVar.b = new RePluginEventCallbacks(application);
            }
            b.a = e.a();
            b.b = Process.myPid();
            b.c = application.getApplicationInfo().packageName;
            if (com.qihoo360.replugin.b.a.a != null) {
                fVar = com.qihoo360.replugin.b.a.b;
                if (!TextUtils.isEmpty(fVar)) {
                    if (fVar.startsWith(Constants.COLON_SEPARATOR)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(b.c);
                        stringBuilder.append(fVar);
                        b.d = stringBuilder.toString();
                    } else {
                        b.d = fVar;
                    }
                }
            } else {
                b.d = b.c;
            }
            b.f = b.a.equals(b.c);
            b.e = b.a.equals(b.d);
            if (!(c.a == null || RePlugin.getConfig().g == null)) {
                c.e("RePlugin", "act=, init, flag=, Start, pn=, framework, func=, attachBaseContext, lib=, RePlugin");
            }
            com.qihoo360.replugin.b.a.a();
            com.qihoo360.mobilesafe.api.a.a = application;
            ah.a = application;
            n.a(application);
            n.a();
            a = true;
        }

        public static void a() {
            if (a) {
                com.qihoo360.mobilesafe.api.b.a();
                aj ajVar = n.b;
                if (b.e) {
                    ajVar.j = ac.d();
                }
                if (c.a) {
                    StringBuilder stringBuilder = new StringBuilder("initial local cookie=");
                    stringBuilder.append(ajVar.j);
                    c.a("ws001", stringBuilder.toString());
                }
                if (!b.e) {
                    ajVar.a("ACTION_NEW_PLUGIN");
                    ajVar.a("ACTION_UNINSTALL_PLUGIN");
                }
                if (!b.e) {
                    Context a = g.a();
                    LocalBroadcastManager.getInstance(a).registerReceiver(new PluginInfoUpdater$UpdateReceiver(), new IntentFilter("com.qihoo360.replugin.pms.ACTION_UPDATE_INFO"));
                }
                if (c.a && RePlugin.getConfig().g) {
                    c.e("RePlugin", "act=, init, flag=, End, pn=, framework, func=, onCreate, lib=, RePlugin");
                    return;
                }
                return;
            }
            throw new IllegalStateException();
        }

        public static void b() {
            if (VERSION.SDK_INT < 14) {
                com.qihoo360.replugin.component.a.a.a();
            }
        }
    }

    public static String getVersion() {
        return "2.2.4";
    }

    public static PluginInfo install(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        File file = new File(str);
        StringBuilder stringBuilder;
        if (!file.exists()) {
            if (c.a) {
                stringBuilder = new StringBuilder("install: File not exists. path=");
                stringBuilder.append(str);
                c.d("RePlugin", stringBuilder.toString());
            }
            return null;
        } else if (file.isFile()) {
            if (str.startsWith("p-n-")) {
                String absolutePath = getConfig().c.getAbsolutePath();
                if (!str.startsWith(absolutePath)) {
                    if (c.a) {
                        StringBuilder stringBuilder2 = new StringBuilder("install: Must be installed from the specified path. Path=");
                        stringBuilder2.append(str);
                        stringBuilder2.append("; Allowed=");
                        stringBuilder2.append(absolutePath);
                        c.d("RePlugin", stringBuilder2.toString());
                    }
                    return null;
                }
            }
            return m.a(str);
        } else {
            if (c.a) {
                stringBuilder = new StringBuilder("install: Not a valid file. path=");
                stringBuilder.append(str);
                c.d("RePlugin", stringBuilder.toString());
            }
            return null;
        }
    }

    public static boolean uninstall(String str) {
        if (!TextUtils.isEmpty(str)) {
            return m.b(str);
        }
        throw new IllegalArgumentException();
    }

    public static boolean preload(String str) {
        PluginInfo pluginInfo = getPluginInfo(str);
        if (pluginInfo != null) {
            return preload(pluginInfo);
        }
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("preload: Plugin not found! pn=");
            stringBuilder.append(str);
            c.d("RePlugin", stringBuilder.toString());
        }
        return null;
    }

    public static boolean preload(PluginInfo pluginInfo) {
        return pluginInfo == null ? null : com.qihoo360.replugin.packages.b.a(g.a(), pluginInfo);
    }

    public static boolean enableDebugger(Context context, boolean z) {
        if (context != null && z) {
            z = new DebuggerReceivers();
            if (z.f == null && context != null) {
                z.a = context.getPackageName();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(z.a);
                stringBuilder.append(".replugin.install");
                z.b = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(z.a);
                stringBuilder.append(".replugin.uninstall");
                z.c = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(z.a);
                stringBuilder.append(".replugin.install_with_pn");
                z.d = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(z.a);
                stringBuilder.append(".replugin.start_activity");
                z.e = stringBuilder.toString();
                z.f = new DebugerReceiver(z);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(z.b);
                intentFilter.addAction(z.c);
                intentFilter.addAction(z.d);
                intentFilter.addAction(z.e);
                context.registerReceiver(z.f, intentFilter);
            }
        }
        return true;
    }

    public static boolean startActivity(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            return null;
        }
        return Factory.startActivityWithNoInjectCN(context, intent, component.getPackageName(), component.getClassName(), Integer.MIN_VALUE);
    }

    public static boolean startActivity(Context context, Intent intent, String str, String str2) {
        return Factory.startActivity(context, intent, str, str2, Integer.MIN_VALUE);
    }

    public static boolean startActivityForResult(Activity activity, Intent intent, int i) {
        return Factory.startActivityForResult(activity, intent, i, null);
    }

    public static boolean startActivityForResult(Activity activity, Intent intent, int i, Bundle bundle) {
        return Factory.startActivityForResult(activity, intent, i, bundle);
    }

    public static Intent createIntent(String str, String str2) {
        Intent intent = new Intent();
        intent.setComponent(createComponentName(str, str2));
        return intent;
    }

    public static ComponentName createComponentName(String str, String str2) {
        return new ComponentName(str, str2);
    }

    public static void addCertSignature(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("arg is null");
        }
        d.a.add(str.toUpperCase());
    }

    public static boolean isForDev() {
        return g.a;
    }

    public static ComponentList fetchComponentList(String str) {
        return Factory.queryPluginComponentList(str);
    }

    public static PackageInfo fetchPackageInfo(String str) {
        return Factory.queryPluginPackageInfo(str);
    }

    public static Resources fetchResources(String str) {
        return Factory.queryPluginResouces(str);
    }

    public static ClassLoader fetchClassLoader(String str) {
        return Factory.queryPluginClassLoader(str);
    }

    public static Context fetchContext(String str) {
        return Factory.queryPluginContext(str);
    }

    public static IBinder fetchBinder(String str, String str2, String str3) {
        return Factory.query(str, str2, Integer.parseInt(str3));
    }

    public static IBinder fetchBinder(String str, String str2) {
        return Factory.query(str, str2);
    }

    public static String fetchPluginNameByClassLoader(ClassLoader classLoader) {
        return Factory.fetchPluginName(classLoader);
    }

    public static int fetchResourceIdByName(String str, String str2) {
        PackageInfo fetchPackageInfo = fetchPackageInfo(str);
        if (fetchPackageInfo == null) {
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("fetchResourceIdByName: Plugin not found. pn=");
                stringBuilder.append(str);
                stringBuilder.append("; resName=");
                stringBuilder.append(str2);
                c.d("RePlugin", stringBuilder.toString());
            }
            return 0;
        }
        Resources fetchResources = fetchResources(str);
        if (fetchResources == null) {
            if (c.a) {
                stringBuilder = new StringBuilder("fetchResourceIdByName: Plugin not found (fetchResources). pn=");
                stringBuilder.append(str);
                stringBuilder.append("; resName=");
                stringBuilder.append(str2);
                c.d("RePlugin", stringBuilder.toString());
            }
            return 0;
        }
        str = new StringBuilder();
        str.append(fetchPackageInfo.packageName);
        str.append(Constants.COLON_SEPARATOR);
        str.append(str2);
        return fetchResources.getIdentifier(str.toString(), null, null);
    }

    public static <T extends View> T fetchViewByLayoutName(String str, String str2, ViewGroup viewGroup) {
        Context fetchContext = fetchContext(str);
        if (fetchContext == null && c.a) {
            StringBuilder stringBuilder = new StringBuilder("fetchViewByLayoutName: Plugin not found. pn=");
            stringBuilder.append(str);
            stringBuilder.append("; layoutName=");
            stringBuilder.append(str2);
            c.d("RePlugin", stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder("layout/");
        stringBuilder2.append(str2);
        int fetchResourceIdByName = fetchResourceIdByName(str, stringBuilder2.toString());
        if (fetchResourceIdByName > 0) {
            return LayoutInflater.from(fetchContext).inflate(fetchResourceIdByName, viewGroup);
        }
        if (c.a != null) {
            StringBuilder stringBuilder3 = new StringBuilder("fetchViewByLayoutName: fetch failed! pn=");
            stringBuilder3.append(str);
            stringBuilder3.append("; layoutName=");
            stringBuilder3.append(str2);
            c.d("RePlugin", stringBuilder3.toString());
        }
        return null;
    }

    public static List<PluginInfo> getPluginInfoList() {
        return m.a(true);
    }

    public static PluginInfo getPluginInfo(String str) {
        return m.a(str, true);
    }

    public static int getPluginVersion(String str) {
        str = m.a(str, false);
        if (str == null) {
            return -1;
        }
        return str.getVersion();
    }

    public static boolean isPluginInstalled(String str) {
        return m.a(str, false) != null;
    }

    public static boolean isPluginUsed(String str) {
        str = m.a(str, false);
        if (str == null || str.isUsed() == null) {
            return false;
        }
        return true;
    }

    public static boolean isPluginDexExtracted(String str) {
        str = m.a(str, false);
        if (str == null || str.isDexExtracted() == null) {
            return false;
        }
        return true;
    }

    public static boolean isPluginRunning(String str) {
        try {
            return com.qihoo360.replugin.packages.c.b(str);
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public static boolean isPluginRunningInProcess(String str, String str2) {
        try {
            return com.qihoo360.replugin.packages.c.a(str, str2);
        } catch (String str3) {
            str3.printStackTrace();
            return null;
        }
    }

    public static PluginRunningList getRunningPlugins() {
        return com.qihoo360.replugin.packages.c.e();
    }

    public static String[] getRunningProcessesByPlugin(String str) {
        return com.qihoo360.replugin.packages.c.d(str);
    }

    public static f getConfig() {
        return a;
    }

    public static void registerInstalledReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver, new IntentFilter("com.qihoo360.loader2.ACTION_NEW_PLUGIN"));
    }

    public static boolean registerGlobalBinder(String str, IBinder iBinder) {
        return QihooServiceManager.addService(g.a(), str, iBinder);
    }

    public static boolean registerGlobalBinderDelayed(String str, IBinderGetter iBinderGetter) {
        return QihooServiceManager.addService(g.a(), str, iBinderGetter);
    }

    public static boolean unregisterGlobalBinder(String str) {
        return QihooServiceManager.removeService(g.a(), str, null);
    }

    public static IBinder getGlobalBinder(String str) {
        return QihooServiceManager.getService(g.a(), str);
    }

    public static void registerHookingClass(String str, ComponentName componentName, Class cls) {
        Factory2.registerDynamicClass(str, componentName.getPackageName(), componentName.getClassName(), cls);
    }

    public static boolean isHookingClass(ComponentName componentName) {
        return Factory2.isDynamicClass(componentName.getPackageName(), componentName.getClassName());
    }

    public static void unregisterHookingClass(String str) {
        Factory2.unregisterDynamicClass(str);
    }

    public static String convertToPnFile(String str) {
        Context a = g.a();
        File file = getConfig().c;
        File file2 = new File(str);
        if (file2.getName().startsWith("p-n-")) {
            str = g.a(file2, file);
        } else {
            PackageInfo packageArchiveInfo = a.getPackageManager().getPackageArchiveInfo(str, 128);
            StringBuilder stringBuilder;
            if (packageArchiveInfo != null) {
                PluginInfo parseFromPackageInfo = PluginInfo.parseFromPackageInfo(packageArchiveInfo, str);
                if (parseFromPackageInfo != null) {
                    StringBuilder stringBuilder2 = new StringBuilder("p-n-");
                    stringBuilder2.append(parseFromPackageInfo.getName());
                    stringBuilder2.append(ShareConstants.JAR_SUFFIX);
                    file2 = new File(file, stringBuilder2.toString());
                    if (com.qihoo360.replugin.packages.e.a(str, file2.getAbsolutePath(), parseFromPackageInfo.getLowInterfaceApi(), parseFromPackageInfo.getHighInterfaceApi(), parseFromPackageInfo.getVersion())) {
                        str = file2;
                    } else if (c.a) {
                        stringBuilder = new StringBuilder("covertToPnFile: Write to publish file error! path=");
                        stringBuilder.append(str);
                        stringBuilder.append("; publish=");
                        stringBuilder.append(file2.getAbsolutePath());
                        c.d("RePluginInstaller", stringBuilder.toString());
                    }
                } else if (c.a) {
                    stringBuilder = new StringBuilder("covertToPnFile: MetaData Invalid! Are you define com.qihoo360.plugin.name and others? path=");
                    stringBuilder.append(str);
                    c.d("RePluginInstaller", stringBuilder.toString());
                }
            } else if (c.a) {
                stringBuilder = new StringBuilder("covertToPnFile: Not a valid apk. path=");
                stringBuilder.append(str);
                c.d("RePluginInstaller", stringBuilder.toString());
            }
            str = null;
        }
        if (str != null) {
            return str.getAbsolutePath();
        }
        return null;
    }

    public static void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        f.a(printWriter);
    }

    public static boolean isCurrentPersistentProcess() {
        return b.e;
    }

    public static void registerHostBinder(b bVar) {
        String str = PLUGIN_NAME_MAIN;
        aj ajVar = n.b;
        synchronized (ajVar.f) {
            ajVar.f.put(str, bVar);
        }
    }
}
