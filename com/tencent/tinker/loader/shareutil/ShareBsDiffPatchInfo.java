package com.tencent.tinker.loader.shareutil;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;

/* compiled from: BUGLY */
public class ShareBsDiffPatchInfo {
    public String md5;
    public String name;
    public String patchMd5;
    public String path;
    public String rawCrc;

    public ShareBsDiffPatchInfo(String str, String str2, String str3, String str4, String str5) {
        this.name = str;
        this.md5 = str2;
        this.rawCrc = str4;
        this.patchMd5 = str5;
        this.path = str3;
    }

    public static void parseDiffPatchInfo(String str, ArrayList<ShareBsDiffPatchInfo> arrayList) {
        if (str != null) {
            if (str.length() != 0) {
                for (String str2 : str.split("\n")) {
                    if (str2 != null && str2.length() > 0) {
                        String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP, 5);
                        if (split != null && split.length >= 5) {
                            arrayList.add(new ShareBsDiffPatchInfo(split[0].trim(), split[2].trim(), split[1].trim(), split[3].trim(), split[4].trim()));
                        }
                    }
                }
            }
        }
    }

    public static boolean checkDiffPatchInfo(ShareBsDiffPatchInfo shareBsDiffPatchInfo) {
        if (shareBsDiffPatchInfo == null) {
            return false;
        }
        String str = shareBsDiffPatchInfo.name;
        shareBsDiffPatchInfo = shareBsDiffPatchInfo.md5;
        if (!(str == null || str.length() <= 0 || shareBsDiffPatchInfo == null)) {
            if (shareBsDiffPatchInfo.length() == 32) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.name);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuffer.append(this.path);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuffer.append(this.md5);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuffer.append(this.rawCrc);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuffer.append(this.patchMd5);
        return stringBuffer.toString();
    }
}
