package com.tencent.tinker.loader;

import android.content.Intent;
import com.tencent.tinker.loader.shareutil.ShareBsDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: BUGLY */
public class TinkerSoLoader {
    protected static final String SO_MEAT_FILE = "assets/so_meta.txt";
    protected static final String SO_PATH = "lib";
    private static final String TAG = "Tinker.TinkerSoLoader";

    public static boolean checkComplete(String str, ShareSecurityCheck shareSecurityCheck, Intent intent) {
        String str2 = (String) shareSecurityCheck.getMetaContentMap().get("assets/so_meta.txt");
        if (str2 == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        ShareBsDiffPatchInfo.parseDiffPatchInfo(str2, arrayList);
        if (arrayList.isEmpty() != null) {
            return true;
        }
        shareSecurityCheck = new StringBuilder();
        shareSecurityCheck.append(str);
        shareSecurityCheck.append("/lib/");
        str = shareSecurityCheck.toString();
        shareSecurityCheck = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ShareBsDiffPatchInfo shareBsDiffPatchInfo = (ShareBsDiffPatchInfo) it.next();
            if (ShareBsDiffPatchInfo.checkDiffPatchInfo(shareBsDiffPatchInfo)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(shareBsDiffPatchInfo.path);
                stringBuilder.append("/");
                stringBuilder.append(shareBsDiffPatchInfo.name);
                shareSecurityCheck.put(stringBuilder.toString(), shareBsDiffPatchInfo.md5);
            } else {
                intent.putExtra(ShareIntentUtil.INTENT_PATCH_PACKAGE_PATCH_CHECK, -4);
                ShareIntentUtil.setIntentReturnCode(intent, -8);
                return false;
            }
        }
        File file = new File(str);
        if (file.exists()) {
            if (file.isDirectory()) {
                for (String str3 : shareSecurityCheck.keySet()) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append(str3);
                    File file2 = new File(stringBuilder2.toString());
                    if (!SharePatchFileUtil.isLegalFile(file2)) {
                        ShareIntentUtil.setIntentReturnCode(intent, -18);
                        intent.putExtra(ShareIntentUtil.INTENT_PATCH_MISSING_LIB_PATH, file2.getAbsolutePath());
                        return false;
                    }
                }
                intent.putExtra(ShareIntentUtil.INTENT_PATCH_LIBS_PATH, shareSecurityCheck);
                return true;
            }
        }
        ShareIntentUtil.setIntentReturnCode(intent, -17);
        return false;
    }
}
