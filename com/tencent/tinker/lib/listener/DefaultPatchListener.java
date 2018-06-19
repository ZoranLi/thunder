package com.tencent.tinker.lib.listener;

import android.content.Context;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.util.TinkerServiceInternals;
import com.tencent.tinker.lib.util.UpgradePatchRetry;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

/* compiled from: BUGLY */
public class DefaultPatchListener implements PatchListener {
    protected final Context context;

    public DefaultPatchListener(Context context) {
        this.context = context;
    }

    public int onPatchReceived(String str) {
        int patchCheck = patchCheck(str, SharePatchFileUtil.getMD5(new File(str)));
        if (patchCheck == 0) {
            TinkerPatchService.runPatchService(this.context, str);
        } else {
            Tinker.with(this.context).getLoadReporter().onLoadPatchListenerReceiveFail(new File(str), patchCheck);
        }
        return patchCheck;
    }

    public int patchCheck(String str, String str2) {
        Tinker with = Tinker.with(this.context);
        if (with.isTinkerEnabled()) {
            if (ShareTinkerInternals.isTinkerEnableWithSharedPreferences(this.context)) {
                if (SharePatchFileUtil.isLegalFile(new File(str)) == null) {
                    return -2;
                }
                if (with.isPatchProcess() != null) {
                    return -4;
                }
                if (TinkerServiceInternals.isTinkerPatchServiceRunning(this.context) != null) {
                    return -3;
                }
                if (ShareTinkerInternals.isVmJit() != null) {
                    return -5;
                }
                str = Tinker.with(this.context);
                if (str.isTinkerLoaded()) {
                    str = str.getTinkerLoadResultIfPresent();
                    if (!(str == null || str.useInterpretMode || str2.equals(str.currentVersion) == null)) {
                        return -6;
                    }
                }
                return UpgradePatchRetry.getInstance(this.context).onPatchListenerCheck(str2) == null ? -7 : null;
            }
        }
        return -1;
    }
}
