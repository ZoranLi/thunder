package com.tencent.tinker.lib.service;

import android.os.Process;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerLoadResult;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.lib.util.TinkerServiceInternals;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

/* compiled from: BUGLY */
public class DefaultTinkerResultService extends AbstractResultService {
    private static final String TAG = "Tinker.DefaultTinkerResultService";

    public void onPatchResult(PatchResult patchResult) {
        if (patchResult == null) {
            TinkerLog.e(TAG, "DefaultTinkerResultService received null result!!!!", new Object[0]);
            return;
        }
        TinkerLog.i(TAG, "DefaultTinkerResultService received a result:%s ", patchResult.toString());
        TinkerServiceInternals.killTinkerPatchServiceProcess(getApplicationContext());
        if (patchResult.isSuccess) {
            deleteRawPatchFile(new File(patchResult.rawPatchFilePath));
            if (checkIfNeedKill(patchResult) != null) {
                Process.killProcess(Process.myPid());
                return;
            }
            TinkerLog.i(TAG, "I have already install the newly patch version!", new Object[0]);
        }
    }

    public void deleteRawPatchFile(File file) {
        if (SharePatchFileUtil.isLegalFile(file)) {
            TinkerLog.w(TAG, "deleteRawPatchFile rawFile path: %s", file.getPath());
            String name = file.getName();
            if (name.startsWith(ShareConstants.PATCH_BASE_NAME)) {
                if (name.endsWith(ShareConstants.PATCH_SUFFIX)) {
                    File parentFile = file.getParentFile();
                    if (parentFile.getName().startsWith(ShareConstants.PATCH_BASE_NAME)) {
                        if (!parentFile.getParentFile().getName().equals(ShareConstants.PATCH_DIRECTORY_NAME)) {
                            SharePatchFileUtil.safeDeleteFile(file);
                        }
                        return;
                    }
                    SharePatchFileUtil.safeDeleteFile(file);
                    return;
                }
            }
            SharePatchFileUtil.safeDeleteFile(file);
        }
    }

    public boolean checkIfNeedKill(PatchResult patchResult) {
        Tinker with = Tinker.with(getApplicationContext());
        if (with.isTinkerLoaded()) {
            TinkerLoadResult tinkerLoadResultIfPresent = with.getTinkerLoadResultIfPresent();
            if (tinkerLoadResultIfPresent != null) {
                String str = tinkerLoadResultIfPresent.currentVersion;
                if (!(patchResult.patchVersion == null || patchResult.patchVersion.equals(str) == null)) {
                    return null;
                }
            }
        }
        return true;
    }
}
