package com.taobao.accs.utl;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders.UTHitBuilder;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: Taobao */
public final class UTMini implements UT {
    public static final int EVENTID_AGOO = 19999;
    public static final int EVENTID_EXCPTION = 66003;
    public static final String PAGE_AGOO = "Page_Push";
    public static final String PAGE_REQUEST_ERROR = "REQ_ERROR";
    private static final String TAG = "UTMini";
    private static UTMini instance = new UTMini();

    public final void onCaughException(Throwable th) {
    }

    public final void stop(Context context) {
    }

    public static UTMini getInstance() {
        return instance;
    }

    public final void start(Application application, String str, String str2, String str3) {
        try {
            UTAnalytics.getInstance().setAppApplicationInstance(application, new k(this, str3, str));
            ALog.d(TAG, "start success", new Object[0]);
        } catch (Application application2) {
            ALog.e(TAG, "start fail ", application2, new Object[0]);
        }
    }

    public final void commitEvent(int i, String str, Object obj) {
        try {
            UTAnalytics.getInstance().getTracker("accs").send(new UTOriginalCustomHitBuilder(str, i, convertObjectToString(obj), null, null, null).build());
        } catch (int i2) {
            str = TAG;
            obj = new StringBuilder("commitEvent fail ");
            obj.append(i2.toString());
            ALog.d(str, obj.toString(), new Object[null]);
        }
    }

    public final void commitEvent(int i, String str, Object obj, Object obj2) {
        try {
            UTAnalytics.getInstance().getTracker("accs").send(new UTOriginalCustomHitBuilder(str, i, convertObjectToString(obj), convertObjectToString(obj2), null, null).build());
        } catch (int i2) {
            str = TAG;
            obj = new StringBuilder("commitEvent fail ");
            obj.append(i2.toString());
            ALog.d(str, obj.toString(), new Object[null]);
        }
    }

    public final void commitEvent(int i, String str, Object obj, Object obj2, Object obj3) {
        try {
            UTAnalytics.getInstance().getTracker("accs").send(new UTOriginalCustomHitBuilder(str, i, convertObjectToString(obj), convertObjectToString(obj2), convertObjectToString(obj3), null).build());
        } catch (int i2) {
            str = TAG;
            obj = new StringBuilder("commitEvent fail ");
            obj.append(i2.toString());
            ALog.d(str, obj.toString(), new Object[null]);
        }
    }

    public final void commitEvent(int i, String str, Object obj, Object obj2, Object obj3, String... strArr) {
        try {
            UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(str, i, convertObjectToString(obj), convertObjectToString(obj2), convertObjectToString(obj3), null);
            uTOriginalCustomHitBuilder.setProperty(UTHitBuilder.FIELD_ARGS, _convertStringAToKVSString(strArr));
            UTAnalytics.getInstance().getTracker("accs").send(uTOriginalCustomHitBuilder.build());
        } catch (int i2) {
            str = TAG;
            obj = new StringBuilder("commitEvent fail ");
            obj.append(i2.toString());
            ALog.d(str, obj.toString(), new Object[null]);
        }
    }

    public final void commitEvent(int i, String str, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        try {
            commitEvent(i, str, obj, obj2, obj3, mapToArray(map));
        } catch (int i2) {
            str = TAG;
            obj = new StringBuilder("commitEvent fail ");
            obj.append(i2.toString());
            ALog.d(str, obj.toString(), new Object[null]);
        }
    }

    public final java.lang.String getUtdId(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r1 = com.ta.utdid2.device.UTDevice.getUtdid(r1);	 Catch:{ Throwable -> 0x0005 }
        return r1;
    L_0x0005:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.UTMini.getUtdId(android.content.Context):java.lang.String");
    }

    public static String convertObjectToString(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return ((String) obj).toString();
        }
        StringBuilder stringBuilder;
        if (obj instanceof Integer) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(((Integer) obj).intValue());
            return stringBuilder.toString();
        } else if (obj instanceof Long) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(((Long) obj).longValue());
            return stringBuilder.toString();
        } else if (obj instanceof Double) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(((Double) obj).doubleValue());
            return stringBuilder.toString();
        } else if (obj instanceof Float) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(((Float) obj).floatValue());
            return stringBuilder.toString();
        } else if (obj instanceof Short) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(((Short) obj).shortValue());
            return stringBuilder.toString();
        } else if (obj instanceof Byte) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(((Byte) obj).byteValue());
            return stringBuilder.toString();
        } else if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        } else {
            if (obj instanceof Character) {
                return ((Character) obj).toString();
            }
            return obj.toString();
        }
    }

    private String _convertStringAToKVSString(String... strArr) {
        if (strArr != null && strArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            int i2 = 0;
            while (i < strArr.length) {
                if (!TextUtils.isEmpty(strArr[i])) {
                    if (i2 != 0) {
                        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    stringBuffer.append(strArr[i]);
                    i2 = 1;
                }
                i++;
            }
        }
        return stringBuffer.toString();
    }

    private static String[] mapToArray(Map<String, String> map) {
        int i = 0;
        if (map != null) {
            if (!map.isEmpty()) {
                String[] strArr = new String[map.size()];
                map = map.entrySet().iterator();
                while (map.hasNext()) {
                    Entry entry = (Entry) map.next();
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    if (str == null) {
                        strArr[i] = "";
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("=");
                        stringBuilder.append(str2);
                        strArr[i] = stringBuilder.toString();
                    }
                    i++;
                }
                return strArr;
            }
        }
        return new String[0];
    }

    public static String getCommitInfo(int i, String str, String str2, String str3, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("eventId=");
        stringBuilder.append(i);
        stringBuilder.append(";arg1=");
        stringBuilder.append(str);
        stringBuilder.append(";arg2=");
        stringBuilder.append(str2);
        stringBuilder.append(";arg3=");
        stringBuilder.append(str3);
        if (map != null) {
            stringBuilder.append(";args=");
            stringBuilder.append(map.toString());
        }
        return stringBuilder.toString();
    }

    public static String getCommitInfo(int i, String str, String str2, String str3, String str4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("eventId=");
        stringBuilder.append(i);
        stringBuilder.append(";arg1=");
        stringBuilder.append(str);
        stringBuilder.append(";arg2=");
        stringBuilder.append(str2);
        stringBuilder.append(";arg3=");
        stringBuilder.append(str3);
        if (str4 != null) {
            stringBuilder.append(";args=");
            stringBuilder.append(str4);
        }
        return stringBuilder.toString();
    }
}
