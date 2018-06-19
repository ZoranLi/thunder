package com.ta.utdid2.aid;

import android.content.Context;
import android.os.Build.VERSION;
import com.ta.utdid2.android.utils.Base64;
import com.ta.utdid2.android.utils.Base64Helper;
import com.ta.utdid2.android.utils.DebugUtils;
import com.ta.utdid2.android.utils.SharedPreferenceHelper;
import com.ta.utdid2.android.utils.StringUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AidStorageController {
    private static final String KEY_PREF_AID_GEN_TIME = "rKrMJgyAEbVtSQGi";
    private static final String KEY_PREF_AID_VALUE = "EvQwnbilKezpOJey";
    private static final String PREF_AID = "OfJbkLdFbPOMbGyP";
    private static final String TAG = "com.ta.utdid2.aid.AidStorageController";
    private static Map<String, Long> sAidGenTimeMapInSP = new ConcurrentHashMap();
    private static Map<String, String> sAidMapInSP = new ConcurrentHashMap();

    public static void setAidValueToSP(Context context, String str, String str2, String str3) {
        if (context != null) {
            str = getEncodedAppName(str, str3);
            long currentTimeMillis = System.currentTimeMillis();
            sAidMapInSP.put(str, str2);
            sAidGenTimeMapInSP.put(str, Long.valueOf(currentTimeMillis));
            context = context.getSharedPreferences(PREF_AID, 0);
            if (VERSION.SDK_INT >= 9) {
                SharedPreferenceHelper.apply(context.edit().putString(KEY_PREF_AID_VALUE.concat(str), str2));
                SharedPreferenceHelper.apply(context.edit().putLong(KEY_PREF_AID_GEN_TIME.concat(str), currentTimeMillis));
                return;
            }
            context.edit().putString(KEY_PREF_AID_VALUE.concat(str), str2).commit();
            context.edit().putLong(KEY_PREF_AID_GEN_TIME.concat(str), currentTimeMillis).commit();
        }
    }

    public static String getAidValueFromSP(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        str = getEncodedAppName(str, str2);
        str2 = (String) sAidMapInSP.get(str);
        boolean z = DebugUtils.DBG;
        if (StringUtils.isEmpty(str2)) {
            str2 = context.getSharedPreferences(PREF_AID, 0).getString(KEY_PREF_AID_VALUE.concat(str), "");
            sAidMapInSP.put(str, str2);
        }
        return str2;
    }

    public static long getAidGenTimeFromSP(Context context, String str, String str2) {
        if (context == null) {
            return 0;
        }
        str = getEncodedAppName(str, str2);
        str2 = Long.valueOf(sAidGenTimeMapInSP.containsKey(str) != null ? ((Long) sAidGenTimeMapInSP.get(str)).longValue() : 0);
        if (DebugUtils.DBG) {
            new StringBuilder("cache AIDGenTime:").append(str2);
        }
        if (str2.longValue() == 0) {
            str2 = Long.valueOf(context.getSharedPreferences(PREF_AID, 0).getLong(KEY_PREF_AID_GEN_TIME.concat(str), 0));
            sAidGenTimeMapInSP.put(str, str2);
        }
        return str2.longValue();
    }

    private static String getEncodedAppName(String str, String str2) {
        if (VERSION.SDK_INT >= 8) {
            str = Base64Helper.encodeToString(str.concat(str2).getBytes(), 2);
        } else {
            str = Base64.encodeToString(str.concat(str2).getBytes(), 2);
        }
        str2 = DebugUtils.DBG;
        return str;
    }
}
