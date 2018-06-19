package com.qihoo360.i;

public interface IPluginManager {
    public static final String KEY_ACTIVITY = "activity";
    public static final String KEY_COMPATIBLE = "compatible";
    public static final String KEY_PLUGIN = "plugin";
    public static final String KEY_PROCESS = "process";
    public static final int PROCESS_AUTO = Integer.MIN_VALUE;
    public static final int PROCESS_PERSIST = -2;
    public static final int PROCESS_UI = -1;
}
