package com.qihoo360.loader2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.qihoo360.replugin.model.PluginInfo;

/* compiled from: PmBase */
final class ak extends BroadcastReceiver {
    final /* synthetic */ String a;
    final /* synthetic */ aj b;

    ak(aj ajVar, String str) {
        this.b = ajVar;
        this.a = str;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.a.equals(intent.getAction()) != null) {
            PluginInfo pluginInfo = (PluginInfo) intent.getParcelableExtra("obj");
            if (pluginInfo != null) {
                String str = this.a;
                boolean z = true;
                int hashCode = str.hashCode();
                if (hashCode != 1244662841) {
                    if (hashCode == 2090633339) {
                        if (str.equals("ACTION_NEW_PLUGIN")) {
                            z = false;
                        }
                    }
                } else if (str.equals("ACTION_UNINSTALL_PLUGIN")) {
                    z = true;
                }
                switch (z) {
                    case false:
                        this.b.a(pluginInfo, intent.getBooleanExtra("persist_need_restart", false));
                        return;
                    case true:
                        this.b.a(pluginInfo);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
