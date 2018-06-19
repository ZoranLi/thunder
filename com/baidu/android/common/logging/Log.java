package com.baidu.android.common.logging;

import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Log {
    public static final int FILE_LIMETE = 10485760;
    public static final int FILE_NUMBER = 2;
    private static Logger sFilelogger = null;
    private static boolean sLog2File = false;
    private static boolean sLogEnabled = true;

    private Log() {
    }

    public static void d(String str, String str2) {
        if (sLogEnabled && sLog2File && sFilelogger != null) {
            Logger logger = sFilelogger;
            Level level = Level.INFO;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
            logger.log(level, stringBuilder.toString());
        }
    }

    public static void d(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append('\n');
        stringBuilder.append(getStackTraceString(th));
        d(str, stringBuilder.toString());
    }

    public static void e(String str, String str2) {
        if (sLogEnabled && sLog2File && sFilelogger != null) {
            Logger logger = sFilelogger;
            Level level = Level.SEVERE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
            logger.log(level, stringBuilder.toString());
        }
    }

    public static void e(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append('\n');
        stringBuilder.append(getStackTraceString(th));
        e(str, stringBuilder.toString());
    }

    public static void e(String str, Throwable th) {
        e(str, getStackTraceString(th));
    }

    private static String getLogFileName() {
        String processNameForPid = getProcessNameForPid(Process.myPid());
        if (TextUtils.isEmpty(processNameForPid)) {
            processNameForPid = "BaiduFileLog";
        }
        return processNameForPid.replace(':', '_');
    }

    private static String getProcessNameForPid(int i) {
        StringBuilder stringBuilder = new StringBuilder("/proc/");
        stringBuilder.append(i);
        stringBuilder.append("/cmdline");
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder("/proc/");
        stringBuilder3.append(i);
        stringBuilder3.append("/status");
        String stringBuilder4 = stringBuilder3.toString();
        String str = "";
        try {
            BufferedReader bufferedReader;
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(new File(stringBuilder2)));
            String readLine = bufferedReader2.readLine();
            if (TextUtils.isEmpty(readLine)) {
                bufferedReader = new BufferedReader(new FileReader(new File(stringBuilder4)));
                do {
                    stringBuilder2 = bufferedReader.readLine();
                    if (stringBuilder2 == null) {
                        break;
                    }
                } while (!stringBuilder2.startsWith("Name:"));
                int indexOf = stringBuilder2.indexOf("\t");
                if (indexOf >= 0) {
                    str = stringBuilder2.substring(indexOf + 1);
                }
            } else {
                str = readLine.substring(0, readLine.indexOf(0));
                bufferedReader = bufferedReader2;
            }
            bufferedReader.close();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void i(String str, String str2) {
        if (sLogEnabled && sLog2File && sFilelogger != null) {
            Logger logger = sFilelogger;
            Level level = Level.INFO;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
            logger.log(level, stringBuilder.toString());
        }
    }

    public static void i(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append('\n');
        stringBuilder.append(getStackTraceString(th));
        i(str, stringBuilder.toString());
    }

    public static void setLog2File(boolean z) {
        sLog2File = z;
        if (z && sFilelogger == null) {
            String logFileName = getLogFileName();
            String absolutePath = new File(Environment.getExternalStorageDirectory(), logFileName).getAbsolutePath();
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(absolutePath);
                stringBuilder.append("_%g.log");
                Handler fileHandler = new FileHandler(stringBuilder.toString(), FILE_LIMETE, 2, true);
                fileHandler.setFormatter(new SimpleFormatter());
                Logger logger = Logger.getLogger(logFileName);
                sFilelogger = logger;
                logger.setLevel(Level.ALL);
                sFilelogger.addHandler(fileHandler);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void setLogEnabled(boolean z) {
        sLogEnabled = z;
    }

    public static void v(String str, String str2) {
        if (sLogEnabled && sLog2File && sFilelogger != null) {
            Logger logger = sFilelogger;
            Level level = Level.INFO;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
            logger.log(level, stringBuilder.toString());
        }
    }

    public static void v(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append('\n');
        stringBuilder.append(getStackTraceString(th));
        v(str, stringBuilder.toString());
    }

    public static void w(String str, String str2) {
        if (sLogEnabled && sLog2File && sFilelogger != null) {
            Logger logger = sFilelogger;
            Level level = Level.WARNING;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
            logger.log(level, stringBuilder.toString());
        }
    }

    public static void w(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append('\n');
        stringBuilder.append(getStackTraceString(th));
        w(str, stringBuilder.toString());
    }
}
