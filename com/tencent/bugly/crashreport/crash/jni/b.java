package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.umeng.message.proguard.k;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
public class b {
    private static String a;

    protected static Map<String, Integer> a(String str) {
        if (str == null) {
            return null;
        }
        try {
            Map<String, Integer> hashMap = new HashMap();
            for (String split : str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                String[] split2 = split.split(Constants.COLON_SEPARATOR);
                if (split2.length != 2) {
                    an.e("error format at %s", split);
                    return null;
                }
                hashMap.put(split2[0], Integer.valueOf(Integer.parseInt(split2[1])));
            }
            return hashMap;
        } catch (Exception e) {
            an.e("error format intStateStr %s", str);
            e.printStackTrace();
            return null;
        }
    }

    protected static String b(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\n");
        if (split != null) {
            if (split.length != 0) {
                str = new StringBuilder();
                for (String str2 : split) {
                    if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                        str.append(str2);
                        str.append("\n");
                    }
                }
                return str.toString();
            }
        }
        return str;
    }

    protected static CrashDetailBean a(Context context, Map<String, String> map, NativeExceptionHandler nativeExceptionHandler) {
        Throwable th;
        Map<String, String> map2 = map;
        if (map2 == null) {
            return null;
        }
        if (a.a(context) == null) {
            an.e("abnormal com info not created", new Object[0]);
            return null;
        }
        String str = (String) map2.get("intStateStr");
        if (str != null) {
            if (str.trim().length() > 0) {
                Map a = a(str);
                if (a == null) {
                    an.e("parse intSateMap fail", Integer.valueOf(map.size()));
                    return null;
                }
                try {
                    ((Integer) a.get("sino")).intValue();
                    ((Integer) a.get("sud")).intValue();
                    String str2 = (String) map2.get("soVersion");
                    if (str2 == null) {
                        an.e("error format at version", new Object[0]);
                        return null;
                    }
                    StringBuilder stringBuilder;
                    String str3;
                    String str4;
                    StringBuilder stringBuilder2;
                    Map map3;
                    String str5 = (String) map2.get("errorAddr");
                    if (str5 == null) {
                        str5 = "unknown";
                    }
                    String str6 = str5;
                    str5 = (String) map2.get("codeMsg");
                    if (str5 == null) {
                        str5 = "unknown";
                    }
                    String str7 = (String) map2.get("tombPath");
                    if (str7 == null) {
                        str7 = "unknown";
                    }
                    String str8 = str7;
                    str7 = (String) map2.get("signalName");
                    if (str7 == null) {
                        str7 = "unknown";
                    }
                    map2.get("errnoMsg");
                    String str9 = (String) map2.get("stack");
                    if (str9 == null) {
                        str9 = "unknown";
                    }
                    String str10 = (String) map2.get("jstack");
                    if (str10 != null) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str9);
                        stringBuilder.append("java:\n");
                        stringBuilder.append(str10);
                        str9 = stringBuilder.toString();
                    }
                    Integer num = (Integer) a.get("sico");
                    if (num == null || num.intValue() <= 0) {
                        str3 = str5;
                        str4 = str7;
                    } else {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str7);
                        stringBuilder2.append(k.s);
                        stringBuilder2.append(str5);
                        stringBuilder2.append(k.t);
                        str4 = stringBuilder2.toString();
                        str3 = "KERNEL";
                    }
                    str5 = (String) map2.get("nativeLog");
                    byte[] a2 = (str5 == null || str5.isEmpty()) ? null : ap.a(null, str5, "BuglyNativeLog.txt");
                    str5 = (String) map2.get("sendingProcess");
                    if (str5 == null) {
                        str5 = "unknown";
                    }
                    Integer num2 = (Integer) a.get("spd");
                    if (num2 != null) {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str5);
                        stringBuilder2.append(k.s);
                        stringBuilder2.append(num2);
                        stringBuilder2.append(k.t);
                        str5 = stringBuilder2.toString();
                    }
                    String str11 = str5;
                    str5 = (String) map2.get("threadName");
                    if (str5 == null) {
                        str5 = "unknown";
                    }
                    num2 = (Integer) a.get("et");
                    if (num2 != null) {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str5);
                        stringBuilder2.append(k.s);
                        stringBuilder2.append(num2);
                        stringBuilder2.append(k.t);
                        str5 = stringBuilder2.toString();
                    }
                    str10 = str5;
                    str5 = (String) map2.get("processName");
                    if (str5 == null) {
                        str5 = "unknown";
                    }
                    num2 = (Integer) a.get("ep");
                    if (num2 != null) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str5);
                        stringBuilder.append(k.s);
                        stringBuilder.append(num2);
                        stringBuilder.append(k.t);
                        str5 = stringBuilder.toString();
                    }
                    str7 = (String) map2.get("key-value");
                    if (str7 != null) {
                        Map hashMap = new HashMap();
                        String[] split = str7.split("\n");
                        int length = split.length;
                        int i = 0;
                        while (i < length) {
                            String[] split2 = split[i].split("=");
                            String[] strArr = split;
                            if (split2.length == 2) {
                                hashMap.put(split2[0], split2[1]);
                            }
                            i++;
                            split = strArr;
                        }
                        map3 = hashMap;
                    } else {
                        map3 = null;
                    }
                    CrashDetailBean packageCrashDatas = nativeExceptionHandler.packageCrashDatas(str5, str10, (((long) ((Integer) a.get("ets")).intValue()) * 1000) + (((long) ((Integer) a.get("etms")).intValue()) / 1000), str4, str6, b(str9), str3, str11, str8, (String) map2.get("sysLogPath"), str2, a2, map3, false);
                    if (packageCrashDatas != null) {
                        str = (String) map2.get("userId");
                        if (str != null) {
                            an.c("[Native record info] userId: %s", str);
                            packageCrashDatas.m = str;
                        }
                        str = (String) map2.get("sysLog");
                        if (str != null) {
                            packageCrashDatas.w = str;
                        }
                        str = (String) map2.get("appVersion");
                        if (str != null) {
                            an.c("[Native record info] appVersion: %s", str);
                            packageCrashDatas.f = str;
                        }
                        str = (String) map2.get("isAppForeground");
                        if (str != null) {
                            an.c("[Native record info] isAppForeground: %s", str);
                            packageCrashDatas.N = str.equalsIgnoreCase("true");
                        }
                        String str12 = (String) map2.get("launchTime");
                        if (str12 != null) {
                            an.c("[Native record info] launchTime: %s", str12);
                            packageCrashDatas.M = Long.parseLong(str12);
                        }
                        packageCrashDatas.y = null;
                        packageCrashDatas.k = true;
                    }
                    return packageCrashDatas;
                } catch (Throwable e) {
                    th = e;
                    if (!an.a(th)) {
                        th.printStackTrace();
                    }
                } catch (Throwable e2) {
                    th = e2;
                    an.e("error format", new Object[0]);
                    th.printStackTrace();
                    return null;
                }
            }
        }
        CrashDetailBean crashDetailBean = null;
        an.e("no intStateStr", new Object[0]);
        return crashDetailBean;
    }

    protected static String a(BufferedInputStream bufferedInputStream) throws IOException {
        if (bufferedInputStream == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int read = bufferedInputStream.read();
            if (read == -1) {
                return null;
            }
            if (read == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append((char) read);
        }
    }

    public static CrashDetailBean a(Context context, String str, NativeExceptionHandler nativeExceptionHandler) {
        if (!(context == null || str == null)) {
            if (nativeExceptionHandler != null) {
                File file = new File(str, "rqd_record.eup");
                if (file.exists() != null) {
                    if (file.canRead() != null) {
                        try {
                            str = new BufferedInputStream(new FileInputStream(file));
                            try {
                                String a = a((BufferedInputStream) str);
                                if (a != null) {
                                    if (a.equals("NATIVE_RQD_REPORT")) {
                                        Object obj;
                                        Map hashMap = new HashMap();
                                        loop0:
                                        while (true) {
                                            String a2;
                                            obj = null;
                                            while (true) {
                                                a2 = a((BufferedInputStream) str);
                                                if (a2 != null) {
                                                    if (obj != null) {
                                                        break;
                                                    }
                                                    String str2 = a2;
                                                } else {
                                                    break loop0;
                                                }
                                            }
                                            hashMap.put(obj, a2);
                                        }
                                        if (obj != null) {
                                            an.e("record not pair! drop! %s", new Object[]{obj});
                                            try {
                                                str.close();
                                            } catch (Context context2) {
                                                context2.printStackTrace();
                                            }
                                            return null;
                                        }
                                        context2 = a(context2, hashMap, nativeExceptionHandler);
                                        try {
                                            str.close();
                                        } catch (String str3) {
                                            str3.printStackTrace();
                                        }
                                        return context2;
                                    }
                                }
                                an.e("record read fail! %s", new Object[]{a});
                                try {
                                    str3.close();
                                } catch (Context context22) {
                                    context22.printStackTrace();
                                }
                                return null;
                            } catch (IOException e) {
                                context22 = e;
                                try {
                                    context22.printStackTrace();
                                    if (str3 != null) {
                                        try {
                                            str3.close();
                                        } catch (Context context222) {
                                            context222.printStackTrace();
                                        }
                                    }
                                    return null;
                                } catch (Throwable th) {
                                    context222 = th;
                                    if (str3 != null) {
                                        try {
                                            str3.close();
                                        } catch (String str32) {
                                            str32.printStackTrace();
                                        }
                                    }
                                    throw context222;
                                }
                            }
                        } catch (IOException e2) {
                            context222 = e2;
                            str32 = null;
                            context222.printStackTrace();
                            if (str32 != null) {
                                str32.close();
                            }
                            return null;
                        } catch (Throwable th2) {
                            context222 = th2;
                            str32 = null;
                            if (str32 != null) {
                                str32.close();
                            }
                            throw context222;
                        }
                    }
                }
                return null;
            }
        }
        an.e("get eup record file args error", new Object[0]);
        return null;
    }

    private static String b(String str, String str2) {
        str = ap.a(str, "reg_record.txt");
        if (str == null) {
            return null;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String readLine = str.readLine();
            if (readLine != null) {
                if (readLine.startsWith(str2) != null) {
                    str2 = "                ";
                    int i = 18;
                    int i2 = 0;
                    int i3 = i2;
                    while (true) {
                        String readLine2 = str.readLine();
                        if (readLine2 == null) {
                            break;
                        }
                        if (i2 % 4 == 0) {
                            if (i2 > 0) {
                                stringBuilder.append("\n");
                            }
                            stringBuilder.append("  ");
                        } else {
                            if (readLine2.length() > 16) {
                                i = 28;
                            }
                            stringBuilder.append(str2.substring(0, i - i3));
                        }
                        i3 = readLine2.length();
                        stringBuilder.append(readLine2);
                        i2++;
                    }
                    stringBuilder.append("\n");
                    str2 = stringBuilder.toString();
                    if (str != null) {
                        try {
                            str.close();
                        } catch (String str3) {
                            an.a(str3);
                        }
                    }
                    return str2;
                }
            }
            if (str3 != null) {
                try {
                    str3.close();
                } catch (String str32) {
                    an.a(str32);
                }
            }
            return null;
        } catch (Throwable th) {
            if (str32 != null) {
                try {
                    str32.close();
                } catch (String str322) {
                    an.a(str322);
                }
            }
        }
    }

    private static String c(String str, String str2) {
        str = ap.a(str, "map_record.txt");
        if (str == null) {
            return null;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String readLine = str.readLine();
            if (readLine != null) {
                if (readLine.startsWith(str2) != null) {
                    while (true) {
                        str2 = str.readLine();
                        if (str2 == null) {
                            break;
                        }
                        stringBuilder.append("  ");
                        stringBuilder.append(str2);
                        stringBuilder.append("\n");
                    }
                    str2 = stringBuilder.toString();
                    if (str != null) {
                        try {
                            str.close();
                        } catch (String str3) {
                            an.a(str3);
                        }
                    }
                    return str2;
                }
            }
            if (str3 != null) {
                try {
                    str3.close();
                } catch (String str32) {
                    an.a(str32);
                }
            }
            return null;
        } catch (Throwable th) {
            if (str32 != null) {
                try {
                    str32.close();
                } catch (String str322) {
                    an.a(str322);
                }
            }
        }
    }

    public static String a(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                StringBuilder stringBuilder = new StringBuilder();
                String b = b(str, str2);
                if (!(b == null || b.isEmpty())) {
                    stringBuilder.append("Register infos:\n");
                    stringBuilder.append(b);
                }
                str = c(str, str2);
                if (str != null && str.isEmpty() == null) {
                    if (stringBuilder.length() > null) {
                        stringBuilder.append("\n");
                    }
                    stringBuilder.append("System SO infos:\n");
                    stringBuilder.append(str);
                }
                return stringBuilder.toString();
            }
        }
        return null;
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists() != null) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static void a(boolean z, String str) {
        if (str != null) {
            File file = new File(str, "rqd_record.eup");
            if (file.exists() && file.canWrite()) {
                file.delete();
                an.c("delete record file %s", file.getAbsoluteFile());
            }
            file = new File(str, "reg_record.txt");
            if (file.exists() && file.canWrite()) {
                file.delete();
                an.c("delete record file %s", file.getAbsoluteFile());
            }
            file = new File(str, "map_record.txt");
            if (file.exists() && file.canWrite()) {
                file.delete();
                an.c("delete record file %s", file.getAbsoluteFile());
            }
            file = new File(str, "backup_record.txt");
            if (file.exists() && file.canWrite()) {
                file.delete();
                an.c("delete record file %s", file.getAbsoluteFile());
            }
            if (a != null) {
                file = new File(a);
                if (file.exists() && file.canWrite()) {
                    file.delete();
                    an.c("delete record file %s", file.getAbsoluteFile());
                }
            }
            if (z) {
                z = new File(str);
                if (z.canRead() != null && z.isDirectory() != null) {
                    z = z.listFiles();
                    if (z) {
                        for (File file2 : z) {
                            if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                                file2.delete();
                                an.c("delete invalid record file %s", file2.getAbsoluteFile());
                            }
                        }
                    }
                }
            }
        }
    }

    public static String a(String str, int i, String str2) {
        if (str != null) {
            if (i > 0) {
                File file = new File(str);
                if (file.exists()) {
                    if (file.canRead()) {
                        a = str;
                        an.a("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                        if (str2 == null) {
                            str = ap.a(new File(str));
                        } else {
                            BufferedReader bufferedReader;
                            try {
                                str = new StringBuilder();
                                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                                while (true) {
                                    try {
                                        Object readLine = bufferedReader.readLine();
                                        if (readLine == null) {
                                            break;
                                        }
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append(str2);
                                        stringBuilder.append("[ ]*:");
                                        if (Pattern.compile(stringBuilder.toString()).matcher(readLine).find()) {
                                            str.append(readLine);
                                            str.append("\n");
                                        }
                                    } catch (Throwable th) {
                                        str = th;
                                    }
                                }
                                str = str.toString();
                                try {
                                    bufferedReader.close();
                                } catch (String str22) {
                                    an.a(str22);
                                }
                            } catch (Throwable th2) {
                                str = th2;
                                bufferedReader = null;
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                throw str;
                            }
                        }
                        if (str != null && str.length() > i) {
                            str = str.substring(str.length() - i);
                        }
                        return str;
                    }
                }
                return null;
            }
        }
        return null;
    }
}
