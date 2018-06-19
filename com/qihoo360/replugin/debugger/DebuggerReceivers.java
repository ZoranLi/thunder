package com.qihoo360.replugin.debugger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qihoo360.i.IPluginManager;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.model.PluginInfo;

public final class DebuggerReceivers {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public BroadcastReceiver f;
    private final String g = ".replugin";
    private final String h = ".install";
    private final String i = ".install_with_pn";
    private final String j = ".uninstall";
    private final String k = ".start_activity";
    private final String l = "path";
    private final String m = "immediately";
    private final String n = IPluginManager.KEY_PLUGIN;
    private final String o = "activity";

    class DebugerReceiver extends BroadcastReceiver {
        final /* synthetic */ DebuggerReceivers a;

        public DebugerReceiver(DebuggerReceivers debuggerReceivers) {
            this.a = debuggerReceivers;
        }

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || !RePlugin.isCurrentPersistentProcess()) {
                return;
            }
            if (action.equals(this.a.b)) {
                a(intent.getStringExtra("path"), TextUtils.equals(intent.getStringExtra("immediately"), "true"));
            } else if (action.equals(this.a.c)) {
                context = intent.getStringExtra(IPluginManager.KEY_PLUGIN);
                if (TextUtils.isEmpty(context) == null) {
                    RePlugin.uninstall(context);
                }
            } else if (action.equals(this.a.d)) {
                context = intent.getStringExtra("path");
                intent = TextUtils.equals(intent.getStringExtra("immediately"), "true");
                context = RePlugin.convertToPnFile(context);
                if (TextUtils.isEmpty(context)) {
                    if (c.a != null) {
                        StringBuilder stringBuilder = new StringBuilder("onInstallByPn: Error! path=");
                        stringBuilder.append(context);
                        c.d("DebugReceivers", stringBuilder.toString());
                    }
                    return;
                }
                a(context, intent);
            } else {
                if (action.equals(this.a.e)) {
                    action = intent.getStringExtra(IPluginManager.KEY_PLUGIN);
                    if (!TextUtils.isEmpty(action)) {
                        intent = intent.getStringExtra("activity");
                        if (TextUtils.isEmpty(intent)) {
                            intent = new Intent("android.intent.action.MAIN");
                            intent.addFlags(268435456);
                            RePlugin.startActivity(context, intent, action, null);
                            return;
                        }
                        RePlugin.startActivity(context, RePlugin.createIntent(action, intent));
                    }
                }
            }
        }

        private static boolean a(String str, boolean z) {
            PluginInfo install = RePlugin.install(str);
            if (install != null) {
                if (c.a != null) {
                    StringBuilder stringBuilder = new StringBuilder("onInstall: Install Success! cur=");
                    stringBuilder.append(RePlugin.getPluginInfo(install.getName()));
                    c.b("DebugReceivers", stringBuilder.toString());
                }
                if (z) {
                    if (RePlugin.preload(install) != null) {
                        if (c.a != null) {
                            z = new StringBuilder("onInstall: Preload Success! pn=");
                            z.append(install.getName());
                            c.b("DebugReceivers", z.toString());
                        }
                        return true;
                    } else if (c.a != null) {
                        z = new StringBuilder("onInstall: Preload Error! pn=");
                        z.append(install.getName());
                        c.d("DebugReceivers", z.toString());
                    }
                }
            } else if (c.a) {
                StringBuilder stringBuilder2 = new StringBuilder("onInstall: Install Error! path=");
                stringBuilder2.append(str);
                c.d("DebugReceivers", stringBuilder2.toString());
            }
            return null;
        }
    }
}
