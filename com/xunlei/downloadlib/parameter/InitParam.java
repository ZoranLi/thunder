package com.xunlei.downloadlib.parameter;

public class InitParam {
    public String mAppVersion;
    public int mPermissionLevel;
    public String mStatCfgSavePath;
    public String mStatSavePath;

    public InitParam(String str, String str2, String str3, int i) {
        this.mAppVersion = str;
        this.mStatSavePath = str2;
        this.mStatCfgSavePath = str3;
        this.mPermissionLevel = i;
    }

    public boolean checkMemberVar() {
        if (this.mAppVersion == null || this.mStatSavePath == null || this.mStatCfgSavePath == null) {
            return false;
        }
        return true;
    }
}
