package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener;
import com.igexin.sdk.PushConsts;

class DefaultConnectivityMonitor implements ConnectivityMonitor {
    private final BroadcastReceiver connectivityReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            intent = DefaultConnectivityMonitor.this.isConnected;
            DefaultConnectivityMonitor.this.isConnected = DefaultConnectivityMonitor.this.isConnected(context);
            if (intent != DefaultConnectivityMonitor.this.isConnected) {
                DefaultConnectivityMonitor.this.listener.onConnectivityChanged(DefaultConnectivityMonitor.this.isConnected);
            }
        }
    };
    private final Context context;
    private boolean isConnected;
    private boolean isRegistered;
    private final ConnectivityListener listener;

    public void onDestroy() {
    }

    public DefaultConnectivityMonitor(Context context, ConnectivityListener connectivityListener) {
        this.context = context.getApplicationContext();
        this.listener = connectivityListener;
    }

    private void register() {
        if (!this.isRegistered) {
            this.isConnected = isConnected(this.context);
            this.context.registerReceiver(this.connectivityReceiver, new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
            this.isRegistered = true;
        }
    }

    private void unregister() {
        if (this.isRegistered) {
            this.context.unregisterReceiver(this.connectivityReceiver);
            this.isRegistered = false;
        }
    }

    private boolean isConnected(Context context) {
        context = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (context == null || context.isConnected() == null) ? null : true;
    }

    public void onStart() {
        register();
    }

    public void onStop() {
        unregister();
    }
}
