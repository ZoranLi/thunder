package com.tencent.bugly.beta.tinker;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.tinker.lib.reporter.DefaultLoadReporter;
import com.tencent.tinker.lib.reporter.LoadReporter;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.lib.util.UpgradePatchRetry;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

/* compiled from: BUGLY */
public class TinkerLoadReporter extends DefaultLoadReporter {
    private static final String TAG = "Tinker.TinkerLoadReporter";
    private final LoadReporter userLoadReporter = TinkerManager.userLoadReporter;

    public TinkerLoadReporter(Context context) {
        super(context);
    }

    public void onLoadPatchListenerReceiveFail(File file, int i) {
        super.onLoadPatchListenerReceiveFail(file, i);
        if (this.userLoadReporter != null) {
            this.userLoadReporter.onLoadPatchListenerReceiveFail(file, i);
        } else {
            TinkerReport.onTryApplyFail(i);
        }
    }

    public void onLoadResult(File file, int i, long j) {
        super.onLoadResult(file, i, j);
        if (this.userLoadReporter != null) {
            this.userLoadReporter.onLoadResult(file, i, j);
            return;
        }
        if (i == 0) {
            TinkerReport.onLoaded(j);
        }
        Looper.getMainLooper();
        Looper.myQueue().addIdleHandler(new IdleHandler() {
            public boolean queueIdle() {
                if (UpgradePatchRetry.getInstance(TinkerLoadReporter.this.context).onPatchRetryLoad()) {
                    TinkerReport.onReportRetryPatch();
                }
                return false;
            }
        });
    }

    public void onLoadException(Throwable th, int i) {
        super.onLoadException(th, i);
        if (this.userLoadReporter != null) {
            this.userLoadReporter.onLoadException(th, i);
        } else {
            TinkerReport.onLoadException(th, i);
        }
    }

    public void onLoadFileMd5Mismatch(File file, int i) {
        super.onLoadFileMd5Mismatch(file, i);
        if (this.userLoadReporter != null) {
            this.userLoadReporter.onLoadFileMd5Mismatch(file, i);
        } else {
            TinkerReport.onLoadFileMisMatch(i);
        }
    }

    public void onLoadFileNotFound(File file, int i, boolean z) {
        super.onLoadFileNotFound(file, i, z);
        if (this.userLoadReporter != null) {
            this.userLoadReporter.onLoadFileNotFound(file, i, z);
            return;
        }
        TinkerLog.i(TAG, "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType:%d, isDirectory:%b", file.getAbsolutePath(), Integer.valueOf(i), Boolean.valueOf(z));
        if (i == 4) {
            file = Tinker.with(this.context);
            if (file.isMainProcess()) {
                file = file.getTinkerLoadResultIfPresent().patchVersionFile;
                if (file != null) {
                    if (UpgradePatchRetry.getInstance(this.context).onPatchListenerCheck(SharePatchFileUtil.getMD5(file))) {
                        TinkerLog.i(TAG, "try to repair oat file on patch process", new Object[0]);
                        TinkerInstaller.onReceiveUpgradePatch(this.context, file.getAbsolutePath());
                    } else {
                        TinkerLog.i(TAG, "repair retry exceed must max time, just clean", new Object[0]);
                        checkAndCleanPatch();
                    }
                }
            }
        } else {
            checkAndCleanPatch();
        }
        TinkerReport.onLoadFileNotFound(i);
    }

    public void onLoadPackageCheckFail(File file, int i) {
        super.onLoadPackageCheckFail(file, i);
        if (this.userLoadReporter != null) {
            this.userLoadReporter.onLoadPackageCheckFail(file, i);
        } else {
            TinkerReport.onLoadPackageCheckFail(i);
        }
    }

    public void onLoadPatchInfoCorrupted(String str, String str2, File file) {
        super.onLoadPatchInfoCorrupted(str, str2, file);
        if (this.userLoadReporter != null) {
            this.userLoadReporter.onLoadPatchInfoCorrupted(str, str2, file);
        } else {
            TinkerReport.onLoadInfoCorrupted();
        }
    }

    public void onLoadInterpret(int i, Throwable th) {
        super.onLoadInterpret(i, th);
        if (this.userLoadReporter != null) {
            this.userLoadReporter.onLoadInterpret(i, th);
        } else {
            TinkerReport.onLoadInterpretReport(i, th);
        }
    }

    public void onLoadPatchVersionChanged(String str, String str2, File file, String str3) {
        super.onLoadPatchVersionChanged(str, str2, file, str3);
        if (this.userLoadReporter != null) {
            this.userLoadReporter.onLoadPatchVersionChanged(str, str2, file, str3);
        }
    }
}
