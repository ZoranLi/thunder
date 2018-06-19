package com.xunlei.tdlive.sdk;

import android.content.Context;
import java.util.Map;

public interface IStator {
    void addCommonData(String str, String str2);

    boolean init(Context context);

    void onPageEnd(String str);

    void onPageStart(String str);

    void onPause();

    void onResume();

    void removeCommonData(String str);

    void setUid(String str);

    void traceEvent(String str, String str2, String str3, String str4, Map<String, String> map);

    void traceEvent(String str, String str2, String str3, Map<String, String> map);

    void traceValue(String str, Map<String, String> map, int i);

    void uninit();
}
