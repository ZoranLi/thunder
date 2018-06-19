package com.ut.mini.plugin;

public abstract class UTPluginMsgDispatchDelegate {
    private Object f = null;

    public boolean isMatchPlugin(UTPlugin uTPlugin) {
        return true;
    }

    public final Object getMsgObj() {
        return this.f;
    }

    public UTPluginMsgDispatchDelegate(Object obj) {
        this.f = obj;
    }

    public Object getDispatchObject(UTPlugin uTPlugin) {
        return this.f;
    }
}
