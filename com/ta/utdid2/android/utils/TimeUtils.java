package com.ta.utdid2.android.utils;

public class TimeUtils {
    public static final String TAG = "com.ta.utdid2.android.utils.TimeUtils";
    public static final int TOTAL_M_S_ONE_DAY = 86400000;

    public static boolean isUpToDate(long j, int i) {
        i = (System.currentTimeMillis() - j) / 86400000 < ((long) i) ? 1 : 0;
        if (DebugUtils.DBG) {
            StringBuilder stringBuilder = new StringBuilder("isUpToDate: ");
            stringBuilder.append(i);
            stringBuilder.append("; oldTimestamp: ");
            stringBuilder.append(j);
            stringBuilder.append("; currentTimestamp");
            stringBuilder.append(System.currentTimeMillis());
        }
        return i;
    }
}
