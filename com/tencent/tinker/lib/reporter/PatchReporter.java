package com.tencent.tinker.lib.reporter;

import android.content.Intent;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.List;

/* compiled from: BUGLY */
public interface PatchReporter {
    void onPatchDexOptFail(File file, List<File> list, Throwable th);

    void onPatchException(File file, Throwable th);

    void onPatchInfoCorrupted(File file, String str, String str2);

    void onPatchPackageCheckFail(File file, int i);

    void onPatchResult(File file, boolean z, long j);

    void onPatchServiceStart(Intent intent);

    void onPatchTypeExtractFail(File file, File file2, String str, int i);

    void onPatchVersionCheckFail(File file, SharePatchInfo sharePatchInfo, String str);
}
