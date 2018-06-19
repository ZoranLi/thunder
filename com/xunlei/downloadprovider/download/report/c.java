package com.xunlei.downloadprovider.download.report;

import android.text.TextUtils;

/* compiled from: DownloadOrigins */
public final class c {
    public static String a = "change_amount/predownload";
    public static String b = "change_amount/";
    public static String c = "game/game_red_packet/";
    public static String d = "/xlpasswd";

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str3 = "%s/%s";
        Object[] objArr = new Object[2];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b);
        stringBuilder.append(str);
        objArr[0] = stringBuilder.toString();
        if (str2 == null) {
            str2 = "";
        }
        objArr[1] = str2;
        return String.format(str3, objArr);
    }
}
