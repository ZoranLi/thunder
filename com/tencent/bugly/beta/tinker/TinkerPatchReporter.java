package com.tencent.bugly.beta.tinker;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.reporter.DefaultPatchReporter;
import com.tencent.tinker.lib.reporter.PatchReporter;
import com.tencent.tinker.lib.util.UpgradePatchRetry;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.List;

/* compiled from: BUGLY */
public class TinkerPatchReporter extends DefaultPatchReporter {
    private final PatchReporter userPatchReporter = TinkerManager.userPatchReporter;

    public TinkerPatchReporter(Context context) {
        super(context);
    }

    public void onPatchServiceStart(Intent intent) {
        super.onPatchServiceStart(intent);
        if (this.userPatchReporter != null) {
            this.userPatchReporter.onPatchServiceStart(intent);
            return;
        }
        TinkerReport.onApplyPatchServiceStart();
        UpgradePatchRetry.getInstance(this.context).onPatchServiceStart(intent);
    }

    public void onPatchDexOptFail(File file, List<File> list, Throwable th) {
        super.onPatchDexOptFail(file, list, th);
        if (this.userPatchReporter != null) {
            this.userPatchReporter.onPatchDexOptFail(file, list, th);
        } else {
            TinkerReport.onApplyDexOptFail(th);
        }
    }

    public void onPatchException(File file, Throwable th) {
        super.onPatchException(file, th);
        if (this.userPatchReporter != null) {
            this.userPatchReporter.onPatchException(file, th);
        } else {
            TinkerReport.onApplyCrash(th);
        }
    }

    public void onPatchInfoCorrupted(File file, String str, String str2) {
        super.onPatchInfoCorrupted(file, str, str2);
        if (this.userPatchReporter != null) {
            this.userPatchReporter.onPatchInfoCorrupted(file, str, str2);
        } else {
            TinkerReport.onApplyInfoCorrupted();
        }
    }

    public void onPatchPackageCheckFail(File file, int i) {
        super.onPatchPackageCheckFail(file, i);
        if (this.userPatchReporter != null) {
            this.userPatchReporter.onPatchPackageCheckFail(file, i);
        } else {
            TinkerReport.onApplyPackageCheckFail(i);
        }
    }

    public void onPatchResult(File file, boolean z, long j) {
        super.onPatchResult(file, z, j);
        if (this.userPatchReporter != null) {
            this.userPatchReporter.onPatchResult(file, z, j);
            return;
        }
        TinkerReport.onApplied(j, z);
        UpgradePatchRetry.getInstance(this.context).onPatchServiceResult();
    }

    public void onPatchTypeExtractFail(File file, File file2, String str, int i) {
        super.onPatchTypeExtractFail(file, file2, str, i);
        if (this.userPatchReporter != null) {
            this.userPatchReporter.onPatchTypeExtractFail(file, file2, str, i);
        } else {
            TinkerReport.onApplyExtractFail(i);
        }
    }

    public void onPatchVersionCheckFail(File file, SharePatchInfo sharePatchInfo, String str) {
        super.onPatchVersionCheckFail(file, sharePatchInfo, str);
        if (this.userPatchReporter != null) {
            this.userPatchReporter.onPatchVersionCheckFail(file, sharePatchInfo, str);
        } else {
            TinkerReport.onApplyVersionCheckFail();
        }
    }
}
