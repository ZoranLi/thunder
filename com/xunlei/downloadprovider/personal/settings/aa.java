package com.xunlei.downloadprovider.personal.settings;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.qihoo360.replugin.RePlugin;
import com.xunlei.downloadprovider.plugin.q;
import com.xunlei.downloadprovider.plugin.q.a;
import com.xunlei.xllib.android.XLIntent;

/* compiled from: SettingsIndexActivity */
final class aa implements a {
    final /* synthetic */ SettingsIndexActivity a;

    public final void onPluginFail(int i) {
    }

    public final void onPluginProgressUpdate(int i) {
    }

    aa(SettingsIndexActivity settingsIndexActivity) {
        this.a = settingsIndexActivity;
    }

    public final void onPluginPrepared() {
        q.a();
        Context baseContext = this.a.getBaseContext();
        if (q.b()) {
            Intent xLIntent = new XLIntent();
            xLIntent.setComponent(new ComponentName("com.xunlei.plugin.speeddetector", "com.xunlei.plugin.speeddetector.SpeedDetectionActivity"));
            xLIntent.setFlags(268435456);
            RePlugin.startActivity(baseContext, xLIntent);
        }
    }
}
