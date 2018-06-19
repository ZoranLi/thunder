package com.ta.utdid2.aid;

import android.content.Context;
import com.ta.utdid2.android.utils.NetworkUtils;
import com.ta.utdid2.android.utils.StringUtils;
import com.ta.utdid2.android.utils.TimeUtils;
import com.ut.device.AidCallback;

public class AidManager {
    private static final int NUM_DAY_OUT_OF_DATE = 1;
    private static final String TAG = "com.ta.utdid2.aid.AidManager";
    private static AidManager sAidManager;
    private Context mContext;

    public static synchronized AidManager getInstance(Context context) {
        synchronized (AidManager.class) {
            if (sAidManager == null) {
                sAidManager = new AidManager(context);
            }
            context = sAidManager;
        }
        return context;
    }

    private AidManager(Context context) {
        this.mContext = context;
    }

    public void requestAid(String str, String str2, String str3, AidCallback aidCallback) {
        if (aidCallback != null) {
            if (!(this.mContext == null || StringUtils.isEmpty(str))) {
                if (!StringUtils.isEmpty(str2)) {
                    String aidValueFromSP = AidStorageController.getAidValueFromSP(this.mContext, str, str2);
                    if (!StringUtils.isEmpty(aidValueFromSP) && TimeUtils.isUpToDate(AidStorageController.getAidGenTimeFromSP(this.mContext, str, str2), 1)) {
                        aidCallback.onAidEventChanged(1001, aidValueFromSP);
                        return;
                    } else if (NetworkUtils.isConnected(this.mContext)) {
                        AidRequester.getInstance(this.mContext).postRestAsync(str, str2, str3, aidValueFromSP, aidCallback);
                        return;
                    } else {
                        aidCallback.onAidEventChanged(1003, aidValueFromSP);
                        return;
                    }
                }
            }
            str3 = new StringBuilder("mContext:");
            str3.append(this.mContext);
            str3.append("; callback:");
            str3.append(aidCallback);
            str3.append("; has appName:");
            str3.append(StringUtils.isEmpty(str) ^ 1);
            str3.append("; has token:");
            str3.append(StringUtils.isEmpty(str2) ^ 1);
            aidCallback.onAidEventChanged(1002, "");
        }
    }

    public String getValue(String str, String str2, String str3) {
        if (!(this.mContext == null || StringUtils.isEmpty(str))) {
            if (!StringUtils.isEmpty(str2)) {
                String aidValueFromSP = AidStorageController.getAidValueFromSP(this.mContext, str, str2);
                if ((StringUtils.isEmpty(aidValueFromSP) || !TimeUtils.isUpToDate(AidStorageController.getAidGenTimeFromSP(this.mContext, str, str2), 1)) && NetworkUtils.isConnected(this.mContext)) {
                    return genAidValue(str, str2, str3);
                }
                return aidValueFromSP;
            }
        }
        str3 = new StringBuilder("mContext:");
        str3.append(this.mContext);
        str3.append("; has appName:");
        str3.append(StringUtils.isEmpty(str) ^ 1);
        str3.append("; has token:");
        str3.append(StringUtils.isEmpty(str2) ^ 1);
        return "";
    }

    private synchronized String genAidValue(String str, String str2, String str3) {
        if (this.mContext == null) {
            return "";
        }
        String str4 = "";
        if (NetworkUtils.isConnected(this.mContext)) {
            str4 = AidRequester.getInstance(this.mContext).postRest(str, str2, str3, AidStorageController.getAidValueFromSP(this.mContext, str, str2));
        }
        AidStorageController.setAidValueToSP(this.mContext, str, str4, str2);
        return str4;
    }
}
