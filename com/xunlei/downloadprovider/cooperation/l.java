package com.xunlei.downloadprovider.cooperation;

import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: CooperationLocations */
public final class l {
    public static int a = Integer.MAX_VALUE;
    public static int b = Integer.MIN_VALUE;
    public static int c = Integer.MAX_VALUE;
    public static int d = Integer.MIN_VALUE;
    private static HashMap<Integer, String> e = new HashMap();

    public static boolean a(int i) {
        String str = (String) e.get(Integer.valueOf(i));
        return (TextUtils.isEmpty(str) || str.startsWith("SCENE") == 0) ? false : true;
    }

    public static boolean b(int i) {
        String str = (String) e.get(Integer.valueOf(i));
        return !TextUtils.isEmpty(str) && str.startsWith("SCENE") == 0;
    }

    public static String c(int i) {
        return e.containsKey(Integer.valueOf(i)) ? (String) e.get(Integer.valueOf(i)) : "UNKNOW_LOCATION";
    }

    static {
        a(1, "FINAL_GUID");
        a(2, "DEEP_CLEAN");
        a(3, "BROWSER_APK_PROTECT");
        a(4, "BROWSER_ADDRESS_BTN");
        a(5, "BTOWSER_BOTTOM_BTN5");
        a(6, "DL_DETAIL_SHARE_BTN4");
        a(7, "DL_SHARE_FLOAT_LAYER");
        a(8, "DL_OPEN_MV_1");
        a(9, "DL_OPEN_MV_2");
        a(10, "DL_OPEN_IMG_1");
        a(11, "DL_OPEN_IMG_2");
        a(12, "DL_OPEN_ZIP_1");
        a(13, "DL_OPEN_ZIP_2");
        a(14, "DL_OPEN_MUSIC_1");
        a(15, "DL_OPEN_MUSIC_2");
        a(16, "DL_TOPBAR_NET_FAILED");
        a(17, "DL_CONNECT_WIFI_AFTER_NET_FAILED");
        a(18, "DL_MOBILE_NET_TOPBAR");
        a(19, "DL_CONNECT_WIFI_AFTER_MOBILE_NET");
        a(20, "SHORT_MV_CONNECT_WIFI_AFTER_NET_FAILED");
        a(21, "SHORT_MV_CONNECT_WIFI_AFTER_MOBILE_NET");
        a(22, "DL_PLAY_SHARE_FLOAT_LAYER");
        a(23, "DL_DOWNLOAD_LIST_CARD");
        a(25, "BROWSER_CHECK_CONTENT");
        StringBuilder stringBuilder = new StringBuilder("Min Item loc:");
        stringBuilder.append(a);
        stringBuilder.append(" Max Item loc:");
        stringBuilder.append(b);
        b(1001, "SCENE_OOM_EXCEPT_PLAYER");
        b(1002, "SCENE_OOM_OPEN_AS_DOWNLOADING");
        b(1003, "SCENE_OOM_DL_BOTTOM_BAR");
        b(1004, "SCENE_OOM_DL_TOPBAR");
        b(1005, "SCENE_OOM_DL_CONTINUE_DL");
        b(1006, "SCENE_BROWSER_INTERCEPT_APK");
        b(1007, "SCENE_DL_NET_FAILED_CONTINUE_BTN");
        b(1008, "SCENE_DL_BY_MOBILE_NET");
        b(1009, "SCENE_SHORT_MV_NET_FAILED");
        b(1010, "SCENE_SHORT_MV_MOBILE_NET");
        b(1011, "SCENE_BROWSER_ADDRESS_FLOAT");
        b(1012, "SCENE_BROWSER_BOTTOM_BTN5_FLOAT");
        b(1013, "SCENE_DEEP_CLEAR_GUID");
        stringBuilder = new StringBuilder("Min Scene loc:");
        stringBuilder.append(c);
        stringBuilder.append("  Max Scene loc:");
        stringBuilder.append(d);
        e.put(Integer.valueOf(-1), "DEFAULT_LOCATION");
    }

    private static void a(int i, String str) {
        e.put(Integer.valueOf(i), str);
        a = i < a ? i : a;
        if (i <= b) {
            i = b;
        }
        b = i;
    }

    private static void b(int i, String str) {
        e.put(Integer.valueOf(i), str);
        c = i < c ? i : c;
        d = i > d ? i : d;
        StringBuilder stringBuilder = new StringBuilder("put scene des:");
        stringBuilder.append(i);
        stringBuilder.append("  ");
        stringBuilder.append(str);
    }
}
