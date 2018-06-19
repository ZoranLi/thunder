package com.xunlei.android.xlstat.param;

import com.xunlei.downloadlib.android.XLLog;

public class XLStatParam {
    private static final String TAG = "XLStatParam";
    public String mAppKey;
    public String mAppName;
    public String mAppVersion;
    public String mConfigBuffer;
    public String mConfigFileName;
    public String mConfigPath;
    public String mProductKey;
    public String mProductName;
    public String mProductVersion;
    public String mStoragePath;

    public boolean checkParam() {
        if (!(this.mAppKey == null || this.mAppName == null || this.mAppVersion == null || this.mProductKey == null || this.mProductName == null || this.mProductVersion == null || this.mStoragePath == null || this.mConfigPath == null || this.mConfigFileName == null)) {
            if (this.mConfigBuffer != null) {
                return true;
            }
        }
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("checkParam, mAppKey=");
        stringBuilder.append(this.mAppKey);
        XLLog.d(str, stringBuilder.toString());
        str = TAG;
        stringBuilder = new StringBuilder("checkParam, mAppName= ");
        stringBuilder.append(this.mAppName);
        XLLog.d(str, stringBuilder.toString());
        str = TAG;
        stringBuilder = new StringBuilder("checkParam, mAppVersion= ");
        stringBuilder.append(this.mAppVersion);
        XLLog.d(str, stringBuilder.toString());
        str = TAG;
        stringBuilder = new StringBuilder("checkParam, mProductKey= ");
        stringBuilder.append(this.mProductKey);
        XLLog.d(str, stringBuilder.toString());
        str = TAG;
        stringBuilder = new StringBuilder("checkParam, mProductName= ");
        stringBuilder.append(this.mProductName);
        XLLog.d(str, stringBuilder.toString());
        str = TAG;
        stringBuilder = new StringBuilder("checkParam, mProductVersion= ");
        stringBuilder.append(this.mProductVersion);
        XLLog.d(str, stringBuilder.toString());
        str = TAG;
        stringBuilder = new StringBuilder("checkParam, mStoragePath= ");
        stringBuilder.append(this.mStoragePath);
        XLLog.d(str, stringBuilder.toString());
        str = TAG;
        stringBuilder = new StringBuilder("checkParam, mConfigPath= ");
        stringBuilder.append(this.mConfigPath);
        XLLog.d(str, stringBuilder.toString());
        str = TAG;
        stringBuilder = new StringBuilder("checkParam, mConfigFileName= ");
        stringBuilder.append(this.mConfigFileName);
        XLLog.d(str, stringBuilder.toString());
        str = TAG;
        stringBuilder = new StringBuilder("checkParam, mConfigBuffer= ");
        stringBuilder.append(this.mConfigBuffer);
        XLLog.d(str, stringBuilder.toString());
        return false;
    }
}
