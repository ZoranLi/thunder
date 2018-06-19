package com.xunlei.common.accelerator.config;

public class Config {
    private static final String KEY_DEMO_TEST = "0.0";
    private static final String KEY_SHOULEI = "shoulei";
    private static final String KEY_SWJSQ = "swjsq";
    private static final String[] PARAM_SDK_KEYS = new String[]{KEY_SWJSQ, KEY_SHOULEI, KEY_DEMO_TEST};
    public static final int VASID_KUAINIAO = 14;
    public static final String VERSION = "3.1";
    public static String sCurrentKey = null;
    public static boolean sIsDebuggable = false;

    public static final boolean isKeyRegistered(String str) {
        if (str == null) {
            return false;
        }
        sCurrentKey = str;
        for (String equals : PARAM_SDK_KEYS) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isKnApp() {
        return KEY_SWJSQ.equals(sCurrentKey);
    }

    public static boolean isShoulei() {
        return KEY_SHOULEI.equals(sCurrentKey);
    }
}
