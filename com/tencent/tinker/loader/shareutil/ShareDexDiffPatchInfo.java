package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;

/* compiled from: BUGLY */
public class ShareDexDiffPatchInfo {
    public final String destMd5InArt;
    public final String destMd5InDvm;
    public final String dexDiffMd5;
    public final String dexMode;
    public final boolean isJarMode;
    public final String newDexCrC;
    public final String oldDexCrC;
    public final String path;
    public final String rawName;
    public final String realName;

    public ShareDexDiffPatchInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.rawName = str;
        this.path = str2;
        this.destMd5InDvm = str3;
        this.destMd5InArt = str4;
        this.dexDiffMd5 = str5;
        this.oldDexCrC = str6;
        this.newDexCrC = str7;
        this.dexMode = str8;
        if (str8.equals(ShareConstants.DEXMODE_JAR) != null) {
            this.isJarMode = true;
            if (SharePatchFileUtil.isRawDexFile(str) != null) {
                str2 = new StringBuilder();
                str2.append(str);
                str2.append(ShareConstants.JAR_SUFFIX);
                this.realName = str2.toString();
                return;
            }
            this.realName = str;
        } else if (str8.equals(ShareConstants.DEXMODE_RAW) != null) {
            this.isJarMode = null;
            this.realName = str;
        } else {
            str2 = new StringBuilder("can't recognize dex mode:");
            str2.append(str8);
            throw new TinkerRuntimeException(str2.toString());
        }
    }

    public static void parseDexDiffPatchInfo(String str, ArrayList<ShareDexDiffPatchInfo> arrayList) {
        if (str != null) {
            if (str.length() != 0) {
                for (String str2 : str.split("\n")) {
                    if (str2 != null && str2.length() > 0) {
                        String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP, 8);
                        if (split != null && split.length >= 8) {
                            arrayList.add(new ShareDexDiffPatchInfo(split[0].trim(), split[1].trim(), split[2].trim(), split[3].trim(), split[4].trim(), split[5].trim(), split[6].trim(), split[7].trim()));
                        }
                    }
                }
            }
        }
    }

    public static boolean checkDexDiffPatchInfo(ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
        if (shareDexDiffPatchInfo == null) {
            return false;
        }
        String str = shareDexDiffPatchInfo.rawName;
        shareDexDiffPatchInfo = ShareTinkerInternals.isVmArt() ? shareDexDiffPatchInfo.destMd5InArt : shareDexDiffPatchInfo.destMd5InDvm;
        if (!(str == null || str.length() <= 0 || shareDexDiffPatchInfo == null)) {
            if (shareDexDiffPatchInfo.length() == 32) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.rawName);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuffer.append(this.path);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuffer.append(this.destMd5InDvm);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuffer.append(this.destMd5InArt);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuffer.append(this.oldDexCrC);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuffer.append(this.newDexCrC);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuffer.append(this.dexDiffMd5);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuffer.append(this.dexMode);
        return stringBuffer.toString();
    }
}
