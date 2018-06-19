package com.xunlei.android.xlstat;

import android.content.Context;
import com.xunlei.android.xlstat.param.XLStatKey;
import com.xunlei.downloadlib.android.ReLinker;
import com.xunlei.downloadlib.android.XLLog;

public class XLStatLoader {
    public native int init(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i, XLStatKey xLStatKey);

    public native int trackEvent(int i, String str, String str2, String str3, int i2, int i3, int i4, int i5, String str4);

    public native int unInit(int i);

    public XLStatLoader(Context context) {
        XLLog.i("XLStatLoader", "---------- XLLoader()");
        ReLinker.loadLibrary(context, "xl_stat");
    }

    public XLStatLoader(String str) {
        StringBuilder stringBuilder = new StringBuilder("begin to load, libPath: ");
        stringBuilder.append(str);
        XLLog.i("XLStatLoader", stringBuilder.toString());
        if (str != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("libxl_stat.so");
            System.load(stringBuilder2.toString());
        }
    }
}
