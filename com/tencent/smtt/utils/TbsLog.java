package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import com.tencent.connect.common.Constants;
import com.tencent.smtt.sdk.TbsConfig;
import java.util.LinkedList;
import java.util.List;

public class TbsLog {
    public static final int TBSLOG_CODE_SDK_BASE = 1000;
    public static final int TBSLOG_CODE_SDK_CONFLICT_X5CORE = 993;
    public static final int TBSLOG_CODE_SDK_INIT = 999;
    public static final int TBSLOG_CODE_SDK_INVOKE_ERROR = 997;
    public static final int TBSLOG_CODE_SDK_LOAD_ERROR = 998;
    public static final int TBSLOG_CODE_SDK_NO_SHARE_X5CORE = 994;
    public static final int TBSLOG_CODE_SDK_SELF_MODE = 996;
    public static final int TBSLOG_CODE_SDK_THIRD_MODE = 995;
    public static final int TBSLOG_CODE_SDK_UNAVAIL_X5CORE = 992;
    public static final String X5LOGTAG = "x5logtag";
    private static boolean a = false;
    private static boolean b = true;
    private static TbsLogClient c = null;
    public static int sLogMaxCount = 10;
    public static List<String> sTbsLogList = new LinkedList();

    public static void addLog(int r6, java.lang.String r7, java.lang.Object... r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = sTbsLogList;
        monitor-enter(r0);
        r1 = sTbsLogList;	 Catch:{ Exception -> 0x006b }
        r1 = r1.size();	 Catch:{ Exception -> 0x006b }
        r2 = sLogMaxCount;	 Catch:{ Exception -> 0x006b }
        r3 = 0;	 Catch:{ Exception -> 0x006b }
        if (r1 <= r2) goto L_0x002a;	 Catch:{ Exception -> 0x006b }
    L_0x000e:
        r1 = sTbsLogList;	 Catch:{ Exception -> 0x006b }
        r1 = r1.size();	 Catch:{ Exception -> 0x006b }
        r2 = sLogMaxCount;	 Catch:{ Exception -> 0x006b }
        r1 = r1 - r2;	 Catch:{ Exception -> 0x006b }
    L_0x0017:
        r2 = r1 + -1;	 Catch:{ Exception -> 0x006b }
        if (r1 <= 0) goto L_0x002a;	 Catch:{ Exception -> 0x006b }
    L_0x001b:
        r1 = sTbsLogList;	 Catch:{ Exception -> 0x006b }
        r1 = r1.size();	 Catch:{ Exception -> 0x006b }
        if (r1 <= 0) goto L_0x002a;	 Catch:{ Exception -> 0x006b }
    L_0x0023:
        r1 = sTbsLogList;	 Catch:{ Exception -> 0x006b }
        r1.remove(r3);	 Catch:{ Exception -> 0x006b }
        r1 = r2;
        goto L_0x0017;
    L_0x002a:
        r1 = 0;
        if (r7 == 0) goto L_0x0032;
    L_0x002d:
        r7 = java.lang.String.format(r7, r8);	 Catch:{ Exception -> 0x0032 }
        r1 = r7;
    L_0x0032:
        if (r1 != 0) goto L_0x0036;
    L_0x0034:
        r1 = "";	 Catch:{ Exception -> 0x006b }
    L_0x0036:
        r7 = "[%d][%d][%c][%d]%s";	 Catch:{ Exception -> 0x006b }
        r8 = 5;	 Catch:{ Exception -> 0x006b }
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x006b }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x006b }
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x006b }
        r8[r3] = r2;	 Catch:{ Exception -> 0x006b }
        r2 = 1;	 Catch:{ Exception -> 0x006b }
        r3 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x006b }
        r8[r2] = r3;	 Catch:{ Exception -> 0x006b }
        r2 = 2;	 Catch:{ Exception -> 0x006b }
        r3 = 48;	 Catch:{ Exception -> 0x006b }
        r3 = java.lang.Character.valueOf(r3);	 Catch:{ Exception -> 0x006b }
        r8[r2] = r3;	 Catch:{ Exception -> 0x006b }
        r2 = 3;	 Catch:{ Exception -> 0x006b }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x006b }
        r8[r2] = r6;	 Catch:{ Exception -> 0x006b }
        r6 = 4;	 Catch:{ Exception -> 0x006b }
        r8[r6] = r1;	 Catch:{ Exception -> 0x006b }
        r6 = java.lang.String.format(r7, r8);	 Catch:{ Exception -> 0x006b }
        r7 = sTbsLogList;	 Catch:{ Exception -> 0x006b }
        r7.add(r6);	 Catch:{ Exception -> 0x006b }
        goto L_0x006f;
    L_0x0069:
        r6 = move-exception;
        goto L_0x0071;
    L_0x006b:
        r6 = move-exception;
        r6.printStackTrace();	 Catch:{ all -> 0x0069 }
    L_0x006f:
        monitor-exit(r0);	 Catch:{ all -> 0x0069 }
        return;	 Catch:{ all -> 0x0069 }
    L_0x0071:
        monitor-exit(r0);	 Catch:{ all -> 0x0069 }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.TbsLog.addLog(int, java.lang.String, java.lang.Object[]):void");
    }

    public static void app_extra(String str, Context context) {
        try {
            StringBuilder stringBuilder;
            context = context.getApplicationContext();
            r1 = new String[6];
            int i = 0;
            r1[0] = TbsConfig.APP_DEMO;
            r1[1] = TbsConfig.APP_QB;
            r1[2] = "com.tencent.mm";
            r1[3] = "com.tencent.mobileqq";
            r1[4] = TbsConfig.APP_DEMO_TEST;
            r1[5] = "com.qzone";
            String[] strArr = new String[]{"DEMO", "QB", "WX", Constants.SOURCE_QQ, "TEST", "QZ"};
            while (i < 6) {
                if (context.getPackageName().contains(r1[i])) {
                    stringBuilder = new StringBuilder("app_extra pid:");
                    stringBuilder.append(Process.myPid());
                    stringBuilder.append("; APP_TAG:");
                    stringBuilder.append(strArr[i]);
                    stringBuilder.append("!");
                    i(str, stringBuilder.toString());
                    break;
                }
                i++;
            }
            if (i == 6) {
                stringBuilder = new StringBuilder("app_extra pid:");
                stringBuilder.append(Process.myPid());
                stringBuilder.append("; APP_TAG:OTHER!");
                i(str, stringBuilder.toString());
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder2 = new StringBuilder("app_extra exception:");
            stringBuilder2.append(Log.getStackTraceString(th));
            w(str, stringBuilder2.toString());
        }
    }

    public static void d(String str, String str2) {
        if (c != null) {
        }
    }

    public static void d(String str, String str2, boolean z) {
        d(str, str2);
        if (c != null && a && z) {
            TbsLogClient tbsLogClient = c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
            tbsLogClient.showLog(stringBuilder.toString());
        }
    }

    public static void e(String str, String str2) {
        if (c != null) {
            TbsLogClient tbsLogClient = c;
            StringBuilder stringBuilder = new StringBuilder("(E)-");
            stringBuilder.append(str);
            stringBuilder.append("-TBS:");
            stringBuilder.append(str2);
            tbsLogClient.writeLog(stringBuilder.toString());
        }
    }

    public static void e(String str, String str2, boolean z) {
        e(str, str2);
        if (c != null && a && z) {
            TbsLogClient tbsLogClient = c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
            tbsLogClient.showLog(stringBuilder.toString());
        }
    }

    public static String getTbsLogFilePath() {
        return TbsLogClient.c != null ? TbsLogClient.c.getAbsolutePath() : null;
    }

    public static void i(String str, String str2) {
        if (c != null) {
            TbsLogClient tbsLogClient = c;
            StringBuilder stringBuilder = new StringBuilder("(I)-");
            stringBuilder.append(str);
            stringBuilder.append("-TBS:");
            stringBuilder.append(str2);
            tbsLogClient.writeLog(stringBuilder.toString());
        }
    }

    public static void i(String str, String str2, boolean z) {
        i(str, str2);
        if (c != null && a && z) {
            TbsLogClient tbsLogClient = c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
            tbsLogClient.showLog(stringBuilder.toString());
        }
    }

    public static synchronized void initIfNeed(Context context) {
        synchronized (TbsLog.class) {
            if (c == null) {
                setTbsLogClient(new TbsLogClient(context));
            }
        }
    }

    public static void setLogView(TextView textView) {
        if (textView != null && c != null) {
            c.setLogView(textView);
        }
    }

    public static boolean setTbsLogClient(TbsLogClient tbsLogClient) {
        if (tbsLogClient == null) {
            return false;
        }
        c = tbsLogClient;
        TbsLogClient.setWriteLogJIT(b);
        return true;
    }

    public static void setWriteLogJIT(boolean z) {
        b = z;
        if (c != null) {
            TbsLogClient.setWriteLogJIT(z);
        }
    }

    public static void v(String str, String str2) {
        if (c != null) {
        }
    }

    public static void v(String str, String str2, boolean z) {
        v(str, str2);
        if (c != null && a && z) {
            TbsLogClient tbsLogClient = c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
            tbsLogClient.showLog(stringBuilder.toString());
        }
    }

    public static void w(String str, String str2) {
        if (c != null) {
            TbsLogClient tbsLogClient = c;
            StringBuilder stringBuilder = new StringBuilder("(W)-");
            stringBuilder.append(str);
            stringBuilder.append("-TBS:");
            stringBuilder.append(str2);
            tbsLogClient.writeLog(stringBuilder.toString());
        }
    }

    public static void w(String str, String str2, boolean z) {
        w(str, str2);
        if (c != null && a && z) {
            TbsLogClient tbsLogClient = c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
            tbsLogClient.showLog(stringBuilder.toString());
        }
    }

    public static synchronized void writeLogToDisk() {
        synchronized (TbsLog.class) {
            if (c != null) {
                c.writeLogToDisk();
            }
        }
    }
}
