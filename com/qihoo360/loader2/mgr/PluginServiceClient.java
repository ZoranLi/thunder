package com.qihoo360.loader2.mgr;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

public class PluginServiceClient {
    public static ComponentName startService(Context context, Intent intent) {
        return com.qihoo360.replugin.component.service.PluginServiceClient.startService(context, intent);
    }

    public static boolean stopService(Context context, Intent intent) {
        return com.qihoo360.replugin.component.service.PluginServiceClient.stopService(context, intent);
    }

    public static boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return com.qihoo360.replugin.component.service.PluginServiceClient.bindService(context, intent, serviceConnection, i);
    }

    public static boolean unbindService(Context context, ServiceConnection serviceConnection) {
        return com.qihoo360.replugin.component.service.PluginServiceClient.unbindService(context, serviceConnection);
    }

    public static void stopSelf(Service service) {
        com.qihoo360.replugin.component.service.PluginServiceClient.stopSelf(service);
    }
}
