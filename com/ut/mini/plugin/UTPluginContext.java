package com.ut.mini.plugin;

import android.content.Context;

public class UTPluginContext {
    public static final int DEBUG_LOG_SWITCH = 1;
    private boolean Q = false;
    private boolean R = false;
    private Context mContext = null;

    public void setContext(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setDebugLogFlag(boolean z) {
        this.Q = z;
    }

    public boolean isDebugLogEnable() {
        return this.Q;
    }

    public void enableRealtimeDebug() {
        this.R = true;
    }

    public boolean isRealtimeDebugEnable() {
        return this.R;
    }
}
