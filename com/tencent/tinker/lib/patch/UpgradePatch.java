package com.tencent.tinker.lib.patch;

/* compiled from: BUGLY */
public class UpgradePatch extends AbstractPatch {
    private static final String TAG = "Tinker.UpgradePatch";

    public boolean tryPatch(android.content.Context r20, java.lang.String r21, com.tencent.tinker.lib.service.PatchResult r22) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r19 = this;
        r0 = r20;
        r1 = com.tencent.tinker.lib.tinker.Tinker.with(r20);
        r2 = new java.io.File;
        r3 = r21;
        r2.<init>(r3);
        r3 = r1.isTinkerEnabled();
        r4 = 0;
        if (r3 == 0) goto L_0x01f4;
    L_0x0014:
        r3 = com.tencent.tinker.loader.shareutil.ShareTinkerInternals.isTinkerEnableWithSharedPreferences(r20);
        if (r3 != 0) goto L_0x001c;
    L_0x001a:
        goto L_0x01f4;
    L_0x001c:
        r3 = com.tencent.tinker.loader.shareutil.SharePatchFileUtil.isLegalFile(r2);
        if (r3 != 0) goto L_0x002c;
    L_0x0022:
        r0 = "Tinker.UpgradePatch";
        r1 = "UpgradePatch tryPatch:patch file is not found, just return";
        r2 = new java.lang.Object[r4];
        com.tencent.tinker.lib.util.TinkerLog.e(r0, r1, r2);
        return r4;
    L_0x002c:
        r3 = new com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
        r3.<init>(r0);
        r5 = r1.getTinkerFlags();
        r5 = com.tencent.tinker.loader.shareutil.ShareTinkerInternals.checkTinkerPackage(r0, r5, r2, r3);
        if (r5 == 0) goto L_0x004c;
    L_0x003b:
        r0 = "Tinker.UpgradePatch";
        r3 = "UpgradePatch tryPatch:onPatchPackageCheckFail";
        r6 = new java.lang.Object[r4];
        com.tencent.tinker.lib.util.TinkerLog.e(r0, r3, r6);
        r0 = r1.getPatchReporter();
        r0.onPatchPackageCheckFail(r2, r5);
        return r4;
    L_0x004c:
        r5 = com.tencent.tinker.loader.shareutil.SharePatchFileUtil.getMD5(r2);
        if (r5 != 0) goto L_0x005c;
    L_0x0052:
        r0 = "Tinker.UpgradePatch";
        r1 = "UpgradePatch tryPatch:patch md5 is null, just return";
        r2 = new java.lang.Object[r4];
        com.tencent.tinker.lib.util.TinkerLog.e(r0, r1, r2);
        return r4;
    L_0x005c:
        r6 = r22;
        r6.patchVersion = r5;
        r6 = "Tinker.UpgradePatch";
        r7 = "UpgradePatch tryPatch:patchMd5:%s";
        r8 = 1;
        r9 = new java.lang.Object[r8];
        r9[r4] = r5;
        com.tencent.tinker.lib.util.TinkerLog.i(r6, r7, r9);
        r6 = r1.getPatchDirectory();
        r6 = r6.getAbsolutePath();
        r7 = com.tencent.tinker.loader.shareutil.SharePatchFileUtil.getPatchInfoLockFile(r6);
        r9 = com.tencent.tinker.loader.shareutil.SharePatchFileUtil.getPatchInfoFile(r6);
        r10 = com.tencent.tinker.loader.shareutil.SharePatchInfo.readAndCheckPropertyWithLock(r9, r7);
        if (r10 == 0) goto L_0x00d6;
    L_0x0082:
        r11 = r10.oldVersion;
        if (r11 == 0) goto L_0x00c1;
    L_0x0086:
        r11 = r10.newVersion;
        if (r11 == 0) goto L_0x00c1;
    L_0x008a:
        r11 = r10.oatDir;
        if (r11 != 0) goto L_0x008f;
    L_0x008e:
        goto L_0x00c1;
    L_0x008f:
        r11 = com.tencent.tinker.loader.shareutil.SharePatchFileUtil.checkIfMd5Valid(r5);
        if (r11 != 0) goto L_0x00a8;
    L_0x0095:
        r0 = "Tinker.UpgradePatch";
        r3 = "UpgradePatch tryPatch:onPatchVersionCheckFail md5 %s is valid";
        r6 = new java.lang.Object[r8];
        r6[r4] = r5;
        com.tencent.tinker.lib.util.TinkerLog.e(r0, r3, r6);
        r0 = r1.getPatchReporter();
        r0.onPatchVersionCheckFail(r2, r10, r5);
        return r4;
    L_0x00a8:
        r11 = r10.oatDir;
        r12 = "interpet";
        r11 = r11.equals(r12);
        if (r11 == 0) goto L_0x00b5;
    L_0x00b2:
        r11 = "changing";
        goto L_0x00b7;
    L_0x00b5:
        r11 = r10.oatDir;
    L_0x00b7:
        r12 = new com.tencent.tinker.loader.shareutil.SharePatchInfo;
        r10 = r10.oldVersion;
        r13 = android.os.Build.FINGERPRINT;
        r12.<init>(r10, r5, r13, r11);
        goto L_0x00e1;
    L_0x00c1:
        r0 = "Tinker.UpgradePatch";
        r3 = "UpgradePatch tryPatch:onPatchInfoCorrupted";
        r5 = new java.lang.Object[r4];
        com.tencent.tinker.lib.util.TinkerLog.e(r0, r3, r5);
        r0 = r1.getPatchReporter();
        r1 = r10.oldVersion;
        r3 = r10.newVersion;
        r0.onPatchInfoCorrupted(r2, r1, r3);
        return r4;
    L_0x00d6:
        r12 = new com.tencent.tinker.loader.shareutil.SharePatchInfo;
        r10 = "";
        r11 = android.os.Build.FINGERPRINT;
        r13 = "odex";
        r12.<init>(r10, r5, r11, r13);
    L_0x00e1:
        r10 = com.tencent.tinker.loader.shareutil.SharePatchFileUtil.getPatchVersionDirectory(r5);
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r11.append(r6);
        r6 = "/";
        r11.append(r6);
        r11.append(r10);
        r6 = r11.toString();
        r10 = "Tinker.UpgradePatch";
        r11 = "UpgradePatch tryPatch:patchVersionDirectory:%s";
        r13 = new java.lang.Object[r8];
        r13[r4] = r6;
        com.tencent.tinker.lib.util.TinkerLog.i(r10, r11, r13);
        r10 = new java.io.File;
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r11.append(r6);
        r13 = "/";
        r11.append(r13);
        r13 = com.tencent.tinker.loader.shareutil.SharePatchFileUtil.getPatchVersionFile(r5);
        r11.append(r13);
        r11 = r11.toString();
        r10.<init>(r11);
        r11 = 2;
        r13 = com.tencent.tinker.loader.shareutil.SharePatchFileUtil.getMD5(r10);	 Catch:{ IOException -> 0x01d2 }
        r5 = r5.equals(r13);	 Catch:{ IOException -> 0x01d2 }
        if (r5 != 0) goto L_0x0166;	 Catch:{ IOException -> 0x01d2 }
    L_0x012c:
        com.tencent.tinker.loader.shareutil.SharePatchFileUtil.copyFileUsingStream(r2, r10);	 Catch:{ IOException -> 0x01d2 }
        r5 = "Tinker.UpgradePatch";	 Catch:{ IOException -> 0x01d2 }
        r13 = "UpgradePatch copy patch file, src file: %s size: %d, dest file: %s size:%d";	 Catch:{ IOException -> 0x01d2 }
        r14 = 4;	 Catch:{ IOException -> 0x01d2 }
        r14 = new java.lang.Object[r14];	 Catch:{ IOException -> 0x01d2 }
        r15 = r2.getAbsolutePath();	 Catch:{ IOException -> 0x01d2 }
        r14[r4] = r15;	 Catch:{ IOException -> 0x01d2 }
        r16 = r5;
        r4 = r2.length();	 Catch:{ IOException -> 0x0163 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ IOException -> 0x0163 }
        r14[r8] = r4;	 Catch:{ IOException -> 0x0163 }
        r4 = r10.getAbsolutePath();	 Catch:{ IOException -> 0x0163 }
        r14[r11] = r4;	 Catch:{ IOException -> 0x0163 }
        r4 = 3;
        r17 = r9;
        r8 = r10.length();	 Catch:{ IOException -> 0x0161 }
        r5 = java.lang.Long.valueOf(r8);	 Catch:{ IOException -> 0x0161 }
        r14[r4] = r5;	 Catch:{ IOException -> 0x0161 }
        r4 = r16;	 Catch:{ IOException -> 0x0161 }
        com.tencent.tinker.lib.util.TinkerLog.w(r4, r13, r14);	 Catch:{ IOException -> 0x0161 }
        goto L_0x0168;
    L_0x0161:
        r0 = 1;
        goto L_0x0164;
    L_0x0163:
        r0 = r8;
    L_0x0164:
        r4 = 0;
        goto L_0x01d3;
    L_0x0166:
        r17 = r9;
    L_0x0168:
        r4 = com.tencent.tinker.lib.patch.DexDiffPatchInternal.tryRecoverDexFiles(r1, r3, r0, r6, r10);
        if (r4 != 0) goto L_0x0179;
    L_0x016e:
        r0 = "Tinker.UpgradePatch";
        r1 = "UpgradePatch tryPatch:new patch recover, try patch dex failed";
        r4 = 0;
        r2 = new java.lang.Object[r4];
        com.tencent.tinker.lib.util.TinkerLog.e(r0, r1, r2);
        return r4;
    L_0x0179:
        r4 = 0;
        r5 = com.tencent.tinker.lib.patch.BsDiffPatchInternal.tryRecoverLibraryFiles(r1, r3, r0, r6, r10);
        if (r5 != 0) goto L_0x018a;
    L_0x0180:
        r0 = "Tinker.UpgradePatch";
        r1 = "UpgradePatch tryPatch:new patch recover, try patch library failed";
        r2 = new java.lang.Object[r4];
        com.tencent.tinker.lib.util.TinkerLog.e(r0, r1, r2);
        return r4;
    L_0x018a:
        r0 = com.tencent.tinker.lib.patch.ResDiffPatchInternal.tryRecoverResourceFiles(r1, r3, r0, r6, r10);
        if (r0 != 0) goto L_0x019a;
    L_0x0190:
        r0 = "Tinker.UpgradePatch";
        r1 = "UpgradePatch tryPatch:new patch recover, try patch resource failed";
        r2 = new java.lang.Object[r4];
        com.tencent.tinker.lib.util.TinkerLog.e(r0, r1, r2);
        return r4;
    L_0x019a:
        r0 = com.tencent.tinker.lib.patch.DexDiffPatchInternal.waitAndCheckDexOptFile(r2, r1);
        if (r0 != 0) goto L_0x01aa;
    L_0x01a0:
        r0 = "Tinker.UpgradePatch";
        r1 = "UpgradePatch tryPatch:new patch recover, check dex opt file failed";
        r2 = new java.lang.Object[r4];
        com.tencent.tinker.lib.util.TinkerLog.e(r0, r1, r2);
        return r4;
    L_0x01aa:
        r0 = r17;
        r0 = com.tencent.tinker.loader.shareutil.SharePatchInfo.rewritePatchInfoFileWithLock(r0, r12, r7);
        if (r0 != 0) goto L_0x01c7;
    L_0x01b2:
        r0 = "Tinker.UpgradePatch";
        r3 = "UpgradePatch tryPatch:new patch recover, rewrite patch info failed";
        r5 = new java.lang.Object[r4];
        com.tencent.tinker.lib.util.TinkerLog.e(r0, r3, r5);
        r0 = r1.getPatchReporter();
        r1 = r12.oldVersion;
        r3 = r12.newVersion;
        r0.onPatchInfoCorrupted(r2, r1, r3);
        return r4;
    L_0x01c7:
        r0 = "Tinker.UpgradePatch";
        r1 = "UpgradePatch tryPatch: done, it is ok";
        r2 = new java.lang.Object[r4];
        com.tencent.tinker.lib.util.TinkerLog.w(r0, r1, r2);
        r0 = 1;
        return r0;
    L_0x01d2:
        r0 = r8;
    L_0x01d3:
        r3 = "Tinker.UpgradePatch";
        r5 = "UpgradePatch tryPatch:copy patch file fail from %s to %s";
        r6 = new java.lang.Object[r11];
        r7 = r2.getPath();
        r6[r4] = r7;
        r7 = r10.getPath();
        r6[r0] = r7;
        com.tencent.tinker.lib.util.TinkerLog.e(r3, r5, r6);
        r1 = r1.getPatchReporter();
        r3 = r2.getName();
        r1.onPatchTypeExtractFail(r2, r10, r3, r0);
        return r4;
    L_0x01f4:
        r0 = "Tinker.UpgradePatch";
        r1 = "UpgradePatch tryPatch:patch is disabled, just return";
        r2 = new java.lang.Object[r4];
        com.tencent.tinker.lib.util.TinkerLog.e(r0, r1, r2);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.patch.UpgradePatch.tryPatch(android.content.Context, java.lang.String, com.tencent.tinker.lib.service.PatchResult):boolean");
    }
}
