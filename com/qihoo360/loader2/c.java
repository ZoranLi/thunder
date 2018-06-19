package com.qihoo360.loader2;

import android.content.Context;
import android.os.Build.VERSION;
import com.qihoo360.replugin.model.PluginInfo;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: Builder */
public final class c {

    /* compiled from: Builder */
    static final class a {
        final ArrayList<PluginInfo> a = new ArrayList();
        final HashSet<PluginInfo> b = new HashSet();
        final ArrayList<PluginInfo> c = new ArrayList();
        private final ArrayList<PluginInfo> d = new ArrayList();
        private final ArrayList<PluginInfo> e = new ArrayList();

        a() {
        }

        final boolean a(ArrayList<PluginInfo> arrayList, PluginInfo pluginInfo) {
            int i = 0;
            while (i < arrayList.size()) {
                PluginInfo pluginInfo2 = (PluginInfo) arrayList.get(i);
                if (!pluginInfo2.getName().equals(pluginInfo.getName())) {
                    i++;
                } else if (PluginInfo.VERSION_COMPARATOR.compare(pluginInfo2, pluginInfo) >= 0) {
                    return false;
                } else {
                    this.b.add(arrayList.get(i));
                    arrayList.set(i, pluginInfo);
                    return true;
                }
            }
            arrayList.add(pluginInfo);
            return true;
        }

        private final PluginInfo a(String str) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                PluginInfo pluginInfo = (PluginInfo) it.next();
                if (pluginInfo.getName().equals(str)) {
                    return pluginInfo;
                }
            }
            return null;
        }

        final void a(PluginInfo pluginInfo) {
            a(this.d, pluginInfo);
            a(this.c, pluginInfo);
        }

        final void b(PluginInfo pluginInfo) {
            PluginInfo pluginInfo2;
            String name = pluginInfo.getName();
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                pluginInfo2 = (PluginInfo) it.next();
                if (pluginInfo2.getName().equals(name)) {
                    break;
                }
            }
            pluginInfo2 = null;
            StringBuilder stringBuilder;
            if (pluginInfo2 == null || pluginInfo2.getVersionValue() != pluginInfo.getVersionValue()) {
                PluginInfo a = a(pluginInfo.getName());
                if (a == null || a.getVersionValue() != pluginInfo.getVersionValue()) {
                    this.b.add(pluginInfo);
                    return;
                } else if (com.qihoo360.replugin.b.c.a) {
                    stringBuilder = new StringBuilder("v5 plugin: normal=");
                    stringBuilder.append(pluginInfo);
                    com.qihoo360.replugin.b.c.a("ws001", stringBuilder.toString());
                }
            } else if (com.qihoo360.replugin.b.c.a) {
                stringBuilder = new StringBuilder("builtin plugin: normal=");
                stringBuilder.append(pluginInfo);
                com.qihoo360.replugin.b.c.a("ws001", stringBuilder.toString());
            }
            a(this.e, pluginInfo);
        }
    }

    static void a(Context context, a aVar) {
        HashSet hashSet = new HashSet();
        aVar = aVar.c.iterator();
        while (aVar.hasNext()) {
            PluginInfo pluginInfo = (PluginInfo) aVar.next();
            hashSet.add(pluginInfo.getDexFile().getName());
            if (com.qihoo360.replugin.b.c.a) {
                StringBuilder stringBuilder = new StringBuilder("dexFile:");
                stringBuilder.append(pluginInfo.getDexFile().getName());
                com.qihoo360.replugin.b.c.a("ws001", stringBuilder.toString());
            }
            if (VERSION.SDK_INT > 25) {
                String a = com.qihoo360.replugin.utils.c.a(pluginInfo.getDexFile().getAbsolutePath());
                if (com.qihoo360.replugin.b.c.a) {
                    StringBuilder stringBuilder2 = new StringBuilder("vdexFile:");
                    stringBuilder2.append(a);
                    stringBuilder2.append(".vdex");
                    com.qihoo360.replugin.b.c.a("ws001", stringBuilder2.toString());
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(a);
                stringBuilder3.append(".vdex");
                hashSet.add(stringBuilder3.toString());
            }
        }
        int i = 0;
        if (VERSION.SDK_INT > 25) {
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(context.getDir("plugins_v3", 0));
            stringBuilder3.append(File.separator);
            stringBuilder3.append(ShareConstants.ANDROID_O_DEX_OPTIMIZE_PATH);
            stringBuilder3.append(File.separator);
            stringBuilder3.append(at.b());
            aVar = new File(stringBuilder3.toString());
        } else {
            aVar = context.getDir("plugins_v3_odex", 0);
        }
        if (com.qihoo360.replugin.b.c.a != null) {
            stringBuilder3 = new StringBuilder("to delete dex dir:");
            stringBuilder3.append(aVar);
            com.qihoo360.replugin.b.c.a("ws001", stringBuilder3.toString());
        }
        context = aVar.listFiles();
        if (context != null) {
            aVar = context.length;
            while (i < aVar) {
                File file = context[i];
                if (!hashSet.contains(file.getName())) {
                    if (com.qihoo360.replugin.b.c.a) {
                        stringBuilder = new StringBuilder("delete unknown dex=");
                        stringBuilder.append(file.getAbsolutePath());
                        com.qihoo360.replugin.b.c.a("ws001", stringBuilder.toString());
                    }
                    try {
                        com.qihoo360.replugin.utils.c.c(file);
                    } catch (Throwable e) {
                        if (com.qihoo360.replugin.b.c.a) {
                            StringBuilder stringBuilder4 = new StringBuilder("can't delete unknown dex=");
                            stringBuilder4.append(file.getAbsolutePath());
                            com.qihoo360.replugin.b.c.a("ws001", stringBuilder4.toString(), e);
                        }
                    }
                } else if (com.qihoo360.replugin.b.c.a) {
                    stringBuilder = new StringBuilder("no need delete ");
                    stringBuilder.append(file.getAbsolutePath());
                    com.qihoo360.replugin.b.c.a("ws001", stringBuilder.toString());
                }
                i++;
            }
        }
    }

    static void b(Context context, a aVar) {
        HashSet hashSet = new HashSet();
        aVar = aVar.c.iterator();
        while (aVar.hasNext()) {
            hashSet.add(((PluginInfo) aVar.next()).getNativeLibsDir().getName());
        }
        int i = 0;
        context = context.getDir("plugins_v3_libs", 0).listFiles();
        if (context != null) {
            aVar = context.length;
            while (i < aVar) {
                File file = context[i];
                if (!hashSet.contains(file.getName())) {
                    if (com.qihoo360.replugin.b.c.a) {
                        StringBuilder stringBuilder = new StringBuilder("delete unknown libs=");
                        stringBuilder.append(file.getAbsolutePath());
                        com.qihoo360.replugin.b.c.a("ws001", stringBuilder.toString());
                    }
                    try {
                        com.qihoo360.replugin.utils.c.c(file);
                    } catch (Throwable e) {
                        if (com.qihoo360.replugin.b.c.a) {
                            StringBuilder stringBuilder2 = new StringBuilder("can't delete unknown libs=");
                            stringBuilder2.append(file.getAbsolutePath());
                            com.qihoo360.replugin.b.c.a("ws001", stringBuilder2.toString(), e);
                        }
                    }
                }
                i++;
            }
        }
    }
}
