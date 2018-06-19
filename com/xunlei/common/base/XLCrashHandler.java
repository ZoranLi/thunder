package com.xunlei.common.base;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;
import com.umeng.message.MsgConstant;
import com.xunlei.download.proguard.c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class XLCrashHandler implements UncaughtExceptionHandler {
    private static XLCrashHandler INSTANCE = null;
    public static final String SD_FILE_PATH = "/xunlei/xl-acc-crash/";
    public static final String TAG = "CrashHandler";
    private Context mContext = null;
    private UncaughtExceptionHandler mDefaultHandler = null;
    private Map<String, String> mDevInfos = new HashMap();
    private DateFormat mFormatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

    private XLCrashHandler() {
    }

    public static XLCrashHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new XLCrashHandler();
        }
        return INSTANCE;
    }

    public void init(Context context) {
        this.mContext = context;
        this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (handleException(th) || this.mDefaultHandler == null) {
            try {
                Thread.sleep(3000);
            } catch (Thread thread2) {
                new StringBuilder("error : ").append(thread2.getMessage());
            }
            Process.killProcess(Process.myPid());
            System.exit(1);
            return;
        }
        this.mDefaultHandler.uncaughtException(thread2, th);
    }

    private boolean handleException(Throwable th) {
        if (th == null) {
            return false;
        }
        new Thread() {
            public void run() {
                Looper.prepare();
                Toast.makeText(XLCrashHandler.this.mContext, "很抱歉,程序出现异常,即将退出.", 1).show();
                Looper.loop();
            }
        }.start();
        collectDeviceInfo(this.mContext);
        try {
            int i = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).applicationInfo.targetSdkVersion;
            if (VERSION.SDK_INT >= 23 && i >= 23 && ContextCompat.checkSelfPermission(this.mContext, MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE) != 0) {
                return false;
            }
            saveCrashInfo2File(th);
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public void collectDeviceInfo(Context context) {
        try {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            if (context != null) {
                Object obj = context.versionName == null ? "null" : context.versionName;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(context.versionCode);
                context = stringBuilder.toString();
                this.mDevInfos.put("versionName", obj);
                this.mDevInfos.put("versionCode", context);
            }
        } catch (Context context2) {
            new StringBuilder("an error occured when collect package info = ").append(context2.getMessage());
        }
        for (Field field : Build.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                this.mDevInfos.put(field.getName(), field.get(null).toString());
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(field.getName());
                stringBuilder2.append(" : ");
                stringBuilder2.append(field.get(null));
            } catch (Exception e) {
                new StringBuilder("an error occured when collect crash info = ").append(e.getMessage());
            }
        }
    }

    private static String getCrashFileDirectory() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        stringBuilder.append(SD_FILE_PATH);
        return stringBuilder.toString();
    }

    private String saveCrashInfo2File(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry entry : this.mDevInfos.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("=");
            stringBuilder.append(str2);
            stringBuilder.append("\n");
            stringBuffer.append(stringBuilder.toString());
        }
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (th = th.getCause(); th != null; th = th.getCause()) {
            th.printStackTrace(printWriter);
        }
        printWriter.close();
        stringBuffer.append(stringWriter.toString());
        try {
            long currentTimeMillis = System.currentTimeMillis();
            th = this.mFormatter.format(new Date());
            StringBuilder stringBuilder2 = new StringBuilder("xl-acc-crash-");
            stringBuilder2.append(th);
            stringBuilder2.append("-");
            stringBuilder2.append(currentTimeMillis);
            stringBuilder2.append(c.n);
            th = stringBuilder2.toString();
            if (Environment.getExternalStorageState().equals("mounted")) {
                String crashFileDirectory = getCrashFileDirectory();
                File file = new File(crashFileDirectory);
                if (!file.exists()) {
                    file.mkdirs();
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(crashFileDirectory);
                stringBuilder2.append(th);
                FileOutputStream fileOutputStream = new FileOutputStream(stringBuilder2.toString());
                fileOutputStream.write(stringBuffer.toString().getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            return th;
        } catch (Throwable th2) {
            new StringBuilder("an error occured while writing file ").append(th2.getMessage());
            return null;
        }
    }
}
