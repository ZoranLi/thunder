package com.tencent.open.a;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;

/* compiled from: ProGuard */
public class c {
    public static int a = 62;
    public static int b = 60;
    public static String c = "OpenSDK.Client.File.Tracer";
    public static String d = null;
    public static String e = ".log";
    public static long f = 8388608;
    public static int g = 262144;
    public static int h = 1024;
    public static int i = 10000;
    public static String j = "debug.file.blockcount";
    public static String k = "debug.file.keepperiod";
    public static String l = "debug.file.tracelevel";
    public static int m = 24;
    public static long n = 604800000;

    static {
        StringBuilder stringBuilder = new StringBuilder("Tencent");
        stringBuilder.append(File.separator);
        stringBuilder.append("msflogs");
        stringBuilder.append(File.separator);
        stringBuilder.append("com");
        stringBuilder.append(File.separator);
        stringBuilder.append(SocializeProtocolConstants.PROTOCOL_KEY_TENCENT);
        stringBuilder.append(File.separator);
        stringBuilder.append("mobileqq");
        stringBuilder.append(File.separator);
        d = stringBuilder.toString();
    }
}
