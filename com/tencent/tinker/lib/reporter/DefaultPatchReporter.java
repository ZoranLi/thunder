package com.tencent.tinker.lib.reporter;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.lib.util.UpgradePatchRetry;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.List;

/* compiled from: BUGLY */
public class DefaultPatchReporter implements PatchReporter {
    private static final String TAG = "Tinker.DefaultPatchReporter";
    private static boolean shouldRetry = false;
    protected final Context context;

    public DefaultPatchReporter(Context context) {
        this.context = context;
    }

    public void onPatchServiceStart(Intent intent) {
        TinkerLog.i(TAG, "patchReporter onPatchServiceStart: patch service start", new Object[0]);
        shouldRetry = false;
        UpgradePatchRetry.getInstance(this.context).onPatchServiceStart(intent);
    }

    public void onPatchPackageCheckFail(File file, int i) {
        TinkerLog.i(TAG, "patchReporter onPatchPackageCheckFail: package check failed. path: %s, code: %d", file.getAbsolutePath(), Integer.valueOf(i));
        if (i == -3 || i == -4 || i == -8) {
            Tinker.with(this.context).cleanPatchByVersion(file);
        }
    }

    public void onPatchVersionCheckFail(File file, SharePatchInfo sharePatchInfo, String str) {
        TinkerLog.i(TAG, "patchReporter onPatchVersionCheckFail: patch version exist. path: %s, version: %s", file.getAbsolutePath(), str);
    }

    public void onPatchTypeExtractFail(File file, File file2, String str, int i) {
        TinkerLog.i(TAG, "patchReporter onPatchTypeExtractFail: file extract fail type: %s, path: %s, extractTo: %s, filename: %s", ShareTinkerInternals.getTypeString(i), file.getPath(), file2.getPath(), str);
        Tinker.with(this.context).cleanPatchByVersion(file);
    }

    public void onPatchDexOptFail(File file, List<File> list, Throwable th) {
        TinkerLog.i(TAG, "patchReporter onPatchDexOptFail: dex opt fail path: %s, dex size: %d", file.getAbsolutePath(), Integer.valueOf(list.size()));
        TinkerLog.printErrStackTrace(TAG, th, "onPatchDexOptFail:", new Object[0]);
        if (!th.getMessage().contains(ShareConstants.CHECK_DEX_OAT_EXIST_FAIL)) {
            if (th.getMessage().contains(ShareConstants.CHECK_DEX_OAT_FORMAT_FAIL) == null) {
                Tinker.with(this.context).cleanPatchByVersion(file);
                return;
            }
        }
        shouldRetry = true;
        deleteOptFiles(list);
    }

    public void onPatchResult(File file, boolean z, long j) {
        TinkerLog.i(TAG, "patchReporter onPatchResult: patch all result path: %s, success: %b, cost: %d", file.getAbsolutePath(), Boolean.valueOf(z), Long.valueOf(j));
        if (shouldRetry == null) {
            UpgradePatchRetry.getInstance(this.context).onPatchServiceResult();
        }
    }

    public void onPatchInfoCorrupted(File file, String str, String str2) {
        TinkerLog.i(TAG, "patchReporter onPatchInfoCorrupted: patch info is corrupted. old: %s, new: %s", str, str2);
        Tinker.with(this.context).cleanPatch();
    }

    public void onPatchException(File file, Throwable th) {
        TinkerLog.i(TAG, "patchReporter onPatchException: patch exception path: %s, throwable: %s", file.getAbsolutePath(), th.getMessage());
        TinkerLog.e(TAG, "tinker patch exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
        TinkerLog.printErrStackTrace(TAG, th, "tinker patch exception", new Object[0]);
        Tinker.with(this.context).setTinkerDisable();
        Tinker.with(this.context).cleanPatchByVersion(file);
    }

    private void deleteOptFiles(List<File> list) {
        for (File safeDeleteFile : list) {
            SharePatchFileUtil.safeDeleteFile(safeDeleteFile);
        }
    }
}
