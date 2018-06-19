package com.tencent.tinker.loader;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import java.io.File;

/* compiled from: BUGLY */
public class TinkerResourceLoader {
    protected static final String RESOURCE_FILE = "resources.apk";
    protected static final String RESOURCE_META_FILE = "assets/res_meta.txt";
    protected static final String RESOURCE_PATH = "res";
    private static final String TAG = "Tinker.ResourceLoader";
    private static ShareResPatchInfo resPatchInfo = new ShareResPatchInfo();

    private TinkerResourceLoader() {
    }

    public static boolean loadTinkerResources(com.tencent.tinker.loader.app.TinkerApplication r10, java.lang.String r11, android.content.Intent r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = resPatchInfo;
        r1 = 1;
        if (r0 == 0) goto L_0x00a3;
    L_0x0005:
        r0 = resPatchInfo;
        r0 = r0.resArscMd5;
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        goto L_0x00a3;
    L_0x000d:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r11);
        r11 = "/res/resources.apk";
        r0.append(r11);
        r11 = r0.toString();
        r0 = new java.io.File;
        r0.<init>(r11);
        r2 = java.lang.System.currentTimeMillis();
        r4 = r10.isTinkerLoadVerifyFlag();
        r5 = 0;
        if (r4 == 0) goto L_0x0074;
    L_0x002e:
        r4 = resPatchInfo;
        r4 = r4.resArscMd5;
        r4 = com.tencent.tinker.loader.shareutil.SharePatchFileUtil.checkResourceArscMd5(r0, r4);
        if (r4 != 0) goto L_0x0058;
    L_0x0038:
        r10 = new java.lang.StringBuilder;
        r11 = "Failed to load resource file, path: ";
        r10.<init>(r11);
        r11 = r0.getPath();
        r10.append(r11);
        r11 = ", expect md5: ";
        r10.append(r11);
        r11 = resPatchInfo;
        r11 = r11.resArscMd5;
        r10.append(r11);
        r10 = -24;
        com.tencent.tinker.loader.shareutil.ShareIntentUtil.setIntentReturnCode(r12, r10);
        return r5;
    L_0x0058:
        r4 = new java.lang.StringBuilder;
        r6 = "verify resource file:";
        r4.<init>(r6);
        r0 = r0.getPath();
        r4.append(r0);
        r0 = " md5, use time: ";
        r4.append(r0);
        r6 = java.lang.System.currentTimeMillis();
        r8 = r6 - r2;
        r4.append(r8);
    L_0x0074:
        com.tencent.tinker.loader.TinkerResourcePatcher.monkeyPatchExistingResources(r10, r11);	 Catch:{ Throwable -> 0x0090 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0090 }
        r4 = "monkeyPatchExistingResources resource file:";	 Catch:{ Throwable -> 0x0090 }
        r0.<init>(r4);	 Catch:{ Throwable -> 0x0090 }
        r0.append(r11);	 Catch:{ Throwable -> 0x0090 }
        r11 = ", use time: ";	 Catch:{ Throwable -> 0x0090 }
        r0.append(r11);	 Catch:{ Throwable -> 0x0090 }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0090 }
        r8 = r6 - r2;	 Catch:{ Throwable -> 0x0090 }
        r0.append(r8);	 Catch:{ Throwable -> 0x0090 }
        return r1;
    L_0x0090:
        r11 = move-exception;
        r10 = r10.getClassLoader();	 Catch:{ Throwable -> 0x0098 }
        com.tencent.tinker.loader.SystemClassLoaderAdder.uninstallPatchDex(r10);	 Catch:{ Throwable -> 0x0098 }
    L_0x0098:
        r10 = "intent_patch_exception";
        r12.putExtra(r10, r11);
        r10 = -23;
        com.tencent.tinker.loader.shareutil.ShareIntentUtil.setIntentReturnCode(r12, r10);
        return r5;
    L_0x00a3:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.TinkerResourceLoader.loadTinkerResources(com.tencent.tinker.loader.app.TinkerApplication, java.lang.String, android.content.Intent):boolean");
    }

    public static boolean checkComplete(Context context, String str, ShareSecurityCheck shareSecurityCheck, Intent intent) {
        String str2 = (String) shareSecurityCheck.getMetaContentMap().get("assets/res_meta.txt");
        if (str2 == null) {
            return true;
        }
        ShareResPatchInfo.parseResPatchInfoFirstLine(str2, resPatchInfo);
        if (resPatchInfo.resArscMd5 == null) {
            return true;
        }
        if (ShareResPatchInfo.checkResPatchInfo(resPatchInfo) == null) {
            intent.putExtra(ShareIntentUtil.INTENT_PATCH_PACKAGE_PATCH_CHECK, -8);
            ShareIntentUtil.setIntentReturnCode(intent, -8);
            return false;
        }
        shareSecurityCheck = new StringBuilder();
        shareSecurityCheck.append(str);
        shareSecurityCheck.append("/res/");
        str = shareSecurityCheck.toString();
        shareSecurityCheck = new File(str);
        if (shareSecurityCheck.exists()) {
            if (shareSecurityCheck.isDirectory() != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("resources.apk");
                if (SharePatchFileUtil.isLegalFile(new File(stringBuilder.toString())) == null) {
                    ShareIntentUtil.setIntentReturnCode(intent, -22);
                    return false;
                }
                try {
                    TinkerResourcePatcher.isResourceCanPatch(context);
                    return true;
                } catch (Context context2) {
                    intent.putExtra(ShareIntentUtil.INTENT_PATCH_EXCEPTION, context2);
                    ShareIntentUtil.setIntentReturnCode(intent, -23);
                    return false;
                }
            }
        }
        ShareIntentUtil.setIntentReturnCode(intent, -21);
        return false;
    }
}
