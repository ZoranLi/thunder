package com.tencent.tinker.loader;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: BUGLY */
public class TinkerUncaughtHandler implements UncaughtExceptionHandler {
    private static final String TAG = "Tinker.UncaughtHandler";
    private final Context context;
    private final File crashFile;
    private final UncaughtExceptionHandler ueh = Thread.getDefaultUncaughtExceptionHandler();

    public TinkerUncaughtHandler(Context context) {
        this.context = context;
        this.crashFile = SharePatchFileUtil.getPatchLastCrashFile(context);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        new StringBuilder("TinkerUncaughtHandler catch exception:").append(Log.getStackTraceString(th));
        this.ueh.uncaughtException(thread, th);
        if (!(this.crashFile == null || (Thread.getDefaultUncaughtExceptionHandler() instanceof TinkerUncaughtHandler) == null)) {
            thread = this.crashFile.getParentFile();
            if (thread.exists() || thread.mkdirs() != null) {
                Closeable printWriter;
                try {
                    printWriter = new PrintWriter(new FileWriter(this.crashFile, false));
                    try {
                        thread = new StringBuilder("process:");
                        thread.append(ShareTinkerInternals.getProcessName(this.context));
                        printWriter.println(thread.toString());
                        printWriter.println(ShareTinkerInternals.getExceptionCauseString(th));
                    } catch (IOException e) {
                        thread = e;
                        try {
                            new StringBuilder("print crash file error:").append(Log.getStackTraceString(thread));
                            SharePatchFileUtil.closeQuietly(printWriter);
                            Process.killProcess(Process.myPid());
                        } catch (Throwable th2) {
                            thread = th2;
                            SharePatchFileUtil.closeQuietly(printWriter);
                            throw thread;
                        }
                    }
                } catch (Throwable th3) {
                    printWriter = null;
                    thread = th3;
                    new StringBuilder("print crash file error:").append(Log.getStackTraceString(thread));
                    SharePatchFileUtil.closeQuietly(printWriter);
                    Process.killProcess(Process.myPid());
                } catch (Throwable th32) {
                    printWriter = null;
                    thread = th32;
                    SharePatchFileUtil.closeQuietly(printWriter);
                    throw thread;
                }
                SharePatchFileUtil.closeQuietly(printWriter);
                Process.killProcess(Process.myPid());
            }
        }
    }
}
