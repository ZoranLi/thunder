package com.tencent.bugly.beta.tinker;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.tinker.lib.listener.DefaultPatchListener;
import com.tencent.tinker.lib.listener.PatchListener;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

/* compiled from: BUGLY */
public class TinkerPatchListener extends DefaultPatchListener {
    protected static final long NEW_PATCH_RESTRICTION_SPACE_SIZE_MIN = 62914560;
    private static final String TAG = "Tinker.TinkerPatchListener";
    private final int maxMemory;
    private final PatchListener userPatchListener = TinkerManager.userPatchListener;

    public TinkerPatchListener(Context context) {
        super(context);
        this.maxMemory = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        context = TAG;
        StringBuilder stringBuilder = new StringBuilder("application maxMemory:");
        stringBuilder.append(this.maxMemory);
        TinkerLog.i(context, stringBuilder.toString(), new Object[0]);
    }

    public int patchCheck(String str, String str2) {
        if (this.userPatchListener != null) {
            this.userPatchListener.onPatchReceived(str);
            return super.patchCheck(str, str2);
        }
        File file = new File(str);
        r3 = new Object[2];
        boolean z = false;
        r3[0] = str;
        r3[1] = Long.valueOf(SharePatchFileUtil.getFileOrDirectorySize(file));
        TinkerLog.i(TAG, "receive a patch file: %s, file size:%d", r3);
        str = super.patchCheck(str, str2);
        if (str == null) {
            str = TinkerUtils.checkForPatchRecover(NEW_PATCH_RESTRICTION_SPACE_SIZE_MIN, this.maxMemory);
        }
        if (str == null && this.context.getSharedPreferences(ShareConstants.TINKER_SHARE_PREFERENCE_CONFIG, 0).getInt(str2, 0) >= 3) {
            str = -23;
        }
        if (str == null) {
            str2 = ShareTinkerInternals.fastGetPatchPackageMeta(file);
            if (str2 == null) {
                str = -24;
            } else {
                str2 = str2.getProperty("platform");
                String str3 = TAG;
                StringBuilder stringBuilder = new StringBuilder("get platform:");
                stringBuilder.append(str2);
                TinkerLog.i(str3, stringBuilder.toString(), new Object[0]);
            }
        }
        if (str == null) {
            z = true;
        }
        TinkerReport.onTryApply(z);
        return str;
    }
}
