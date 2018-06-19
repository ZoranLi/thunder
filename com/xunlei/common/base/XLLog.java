package com.xunlei.common.base;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.xunlei.download.proguard.c;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class XLLog {
    public static final boolean DEBUG_MODE = false;
    public static final int LOG_BOTH = 3;
    public static final int LOG_FILE = 2;
    public static final int LOG_LOGCAT = 1;
    private static final String LOG_NAME = "/acc-log";
    public static final int LOG_NO = 0;
    public static final String SD_FILE_PATH = "/xunlei/xl-acc-log";
    private static final String XL_ACC_LOG_TAG = "[xl-acc-log-tag]";
    private static LogHandler mLogHandler = null;
    private static int mLogLevel = 1;
    private static SimpleDateFormat mSdf;

    static class LogHandler extends Handler {
        private File mLogFile = null;
        private FileOutputStream mLogOutput = null;

        public LogHandler() {
            createLogFile();
        }

        public void handleMessage(Message message) {
            if (this.mLogFile != null) {
                try {
                    if (this.mLogOutput == null) {
                        this.mLogOutput = new FileOutputStream(this.mLogFile, true);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    if (!createLogFile()) {
                        return;
                    }
                }
                if (this.mLogOutput != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((String) message.obj);
                    stringBuilder.append("\n\n");
                    message = stringBuilder.toString();
                    if (message != null) {
                        message = message.getBytes();
                        try {
                            this.mLogOutput.write(message, 0, message.length);
                        } catch (Message message2) {
                            message2.printStackTrace();
                            this.mLogOutput = null;
                        }
                    }
                }
            }
        }

        public void flush() {
            if (this.mLogOutput != null) {
                try {
                    this.mLogOutput.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private boolean createLogFile() {
            if (XLLog.isExternalStorageAvailable()) {
                File access$100 = XLLog.getLogFileDirectory();
                if (!access$100.exists()) {
                    access$100.mkdirs();
                }
                this.mLogFile = getValidLogFile(access$100.getAbsolutePath());
                return true;
            }
            this.mLogFile = null;
            return false;
        }

        private File getValidLogFile(String str) {
            String str2 = c.n;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(XLLog.LOG_NAME);
            stringBuffer.append("-");
            stringBuffer.append(System.currentTimeMillis());
            stringBuffer.append(str2);
            str = new File(stringBuffer.toString());
            if (!str.exists()) {
                try {
                    str.createNewFile();
                } catch (IOException e) {
                    new StringBuilder("create log file error = ").append(e.getMessage());
                }
            }
            return str;
        }
    }

    public static void d(String str, String str2) {
    }

    public static void e(String str, String str2) {
    }

    public static void e(String str, Throwable th) {
    }

    public static void i(String str, String str2) {
    }

    public static void logfile() {
    }

    public static void v(String str, String str2) {
    }

    public static void w(String str, String str2) {
    }

    private XLLog() {
    }

    private static String appendTag(String str) {
        if (TextUtils.isEmpty(str)) {
            return XL_ACC_LOG_TAG;
        }
        StringBuilder stringBuilder = new StringBuilder(XL_ACC_LOG_TAG);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static void logHeapStats(String str, Context context) {
        str = new MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(str);
        context = new Debug.MemoryInfo();
        Debug.getMemoryInfo(context);
        long nativeHeapSize = Debug.getNativeHeapSize();
        long nativeHeapAllocatedSize = Debug.getNativeHeapAllocatedSize();
        long nativeHeapFreeSize = Debug.getNativeHeapFreeSize();
        DecimalFormat decimalFormat = new DecimalFormat("0.000");
        StringBuilder stringBuilder = new StringBuilder("heap_stats heap_size=");
        stringBuilder.append(decimalFormat.format((double) (((float) nativeHeapSize) / 1048576.0f)));
        stringBuilder.append("M allocated=");
        stringBuilder.append(decimalFormat.format((double) (((float) nativeHeapAllocatedSize) / 1048576.0f)));
        stringBuilder.append("M free=");
        stringBuilder.append(decimalFormat.format((double) (((float) nativeHeapFreeSize) / 1048576.0f)));
        stringBuilder.append("M memory_stats memory_usage=");
        stringBuilder.append(decimalFormat.format((double) (((float) context.getTotalPss()) / 1024.0f)));
        stringBuilder.append("M dalvik_usage=");
        stringBuilder.append(decimalFormat.format((double) (((float) context.dalvikPss) / 1024.0f)));
        stringBuilder.append("M native_usage=");
        stringBuilder.append(decimalFormat.format((double) (((float) context.nativePss) / 1024.0f)));
        stringBuilder.append("M other_usage=");
        stringBuilder.append(decimalFormat.format((double) (((float) context.otherPss) / 1149239296)));
        stringBuilder.append("M system_stats system_available=");
        stringBuilder.append(decimalFormat.format((double) (((float) str.availMem) / 1233125376)));
        stringBuilder.append("M");
    }

    public static void logStackTrace(String str) {
        for (StackTraceElement stackTraceElement : (StackTraceElement[]) Thread.getAllStackTraces().get(Thread.currentThread())) {
            stackTraceElement.toString();
        }
    }

    public static void flush() {
        mLogHandler.flush();
    }

    private static void initFileHandler() {
        if (mLogHandler == null) {
            mLogHandler = new LogHandler();
        }
    }

    private static void sendHandlerMsg(String str, String str2, String str3) {
        if (mSdf == null) {
            mSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mSdf.format(Calendar.getInstance().getTime()));
        stringBuilder.append(" [");
        stringBuilder.append("Thread-");
        stringBuilder.append(Thread.currentThread().getId());
        stringBuilder.append("] ");
        stringBuilder.append(str.toUpperCase());
        stringBuilder.append(" ");
        stringBuilder.append(str2);
        stringBuilder.append(" : ");
        stringBuilder.append(str3);
        str = mLogHandler.obtainMessage();
        str.obj = stringBuilder.toString();
        mLogHandler.sendMessage(str);
    }

    private static boolean isExternalStorageAvailable() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    private static File getLogFileDirectory() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        stringBuilder.append(SD_FILE_PATH);
        File file = new File(stringBuilder.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
