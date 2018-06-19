package com.qihoo360.replugin.component.service.server;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;

public class PluginPitService extends Service {
    private static WeakReference<PluginPitService> a;

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public PluginPitService() {
        a = new WeakReference(this);
    }

    public static ComponentName a(Context context, int i) {
        context = context.getPackageName();
        String name = PluginPitService.class.getName();
        if (i == -1) {
            i = new StringBuilder();
            i.append(name);
            i.append("UI");
            i = i.toString();
        } else if (i == -2) {
            i = new StringBuilder();
            i.append(name);
            i.append("Guard");
            i = i.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(name);
            stringBuilder.append("P");
            stringBuilder.append(100 + i);
            i = stringBuilder.toString();
        }
        return new ComponentName(context, i);
    }
}
