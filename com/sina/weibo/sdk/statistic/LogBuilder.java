package com.sina.weibo.sdk.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class LogBuilder {
    private static final String APPKEY = "WEIBO_APPKEY";
    private static final String CHANNEL = "WEIBO_CHANNEL";
    public static final String KEY_AID = "aid";
    public static final String KEY_APPKEY = "appkey";
    public static final String KEY_CHANNEL = "channel";
    private static final String KEY_DURATION = "duration";
    public static final String KEY_END_TIME = "endtime";
    private static final String KEY_EVENT_ID = "event_id";
    private static final String KEY_EXTEND = "extend";
    public static final String KEY_HASH = "key_hash";
    public static final String KEY_PACKAGE_NAME = "packagename";
    private static final String KEY_PAGE_ID = "page_id";
    public static final String KEY_PLATFORM = "platform";
    public static final String KEY_START_TIME = "starttime";
    private static final String KEY_TIME = "time";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VERSION = "version";
    private static final int MAX_COUNT = 500;
    public static final long MAX_INTERVAL = 86400000;

    private static boolean isDataValid(long j, long j2) {
        return j - j2 < 86400000;
    }

    public static String getAppKey(Context context) {
        String str;
        StringBuilder stringBuilder;
        try {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (context != null) {
                context = context.metaData.get(APPKEY);
                if (context != null) {
                    str = WBAgent.TAG;
                    stringBuilder = new StringBuilder("APPKEY: ");
                    stringBuilder.append(String.valueOf(context));
                    LogUtil.i(str, stringBuilder.toString());
                    return String.valueOf(context);
                }
                LogUtil.e(WBAgent.TAG, "Could not read WEIBO_APPKEY meta-data from AndroidManifest.xml.");
            }
        } catch (Context context2) {
            str = WBAgent.TAG;
            stringBuilder = new StringBuilder("Could not read WEIBO_APPKEY meta-data from AndroidManifest.xml.");
            stringBuilder.append(context2);
            LogUtil.e(str, stringBuilder.toString());
        }
        return null;
    }

    public static String getChannel(Context context) {
        String str;
        StringBuilder stringBuilder;
        try {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (context != null) {
                context = context.metaData.getString(CHANNEL);
                if (context != null) {
                    str = WBAgent.TAG;
                    stringBuilder = new StringBuilder("CHANNEL: ");
                    stringBuilder.append(context.trim());
                    LogUtil.i(str, stringBuilder.toString());
                    return context.trim();
                }
                LogUtil.e(WBAgent.TAG, "Could not read WEIBO_CHANNEL meta-data from AndroidManifest.xml.");
            }
        } catch (Context context2) {
            str = WBAgent.TAG;
            stringBuilder = new StringBuilder("Could not read WEIBO_CHANNEL meta-data from AndroidManifest.xml.");
            stringBuilder.append(context2);
            LogUtil.e(str, stringBuilder.toString());
        }
        return null;
    }

    public static String getVersion(Context context) {
        String str;
        StringBuilder stringBuilder;
        try {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            str = WBAgent.TAG;
            stringBuilder = new StringBuilder("versionName: ");
            stringBuilder.append(context.versionName);
            LogUtil.i(str, stringBuilder.toString());
            return context.versionName;
        } catch (Context context2) {
            str = WBAgent.TAG;
            stringBuilder = new StringBuilder("Could not read versionName from AndroidManifest.xml.");
            stringBuilder.append(context2);
            LogUtil.e(str, stringBuilder.toString());
            return null;
        }
    }

    public static String getPageLogs(CopyOnWriteArrayList<PageLog> copyOnWriteArrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        copyOnWriteArrayList = copyOnWriteArrayList.iterator();
        while (copyOnWriteArrayList.hasNext()) {
            stringBuilder.append(getLogInfo((PageLog) copyOnWriteArrayList.next()).toString());
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        return stringBuilder.toString();
    }

    private static JSONObject getLogInfo(PageLog pageLog) {
        JSONObject jSONObject = new JSONObject();
        try {
            switch (pageLog.getType()) {
                case SESSION_START:
                    jSONObject.put("type", 0);
                    jSONObject.put("time", pageLog.getStartTime() / 1000);
                    break;
                case SESSION_END:
                    jSONObject.put("type", 1);
                    jSONObject.put("time", pageLog.getEndTime() / 1000);
                    jSONObject.put("duration", pageLog.getDuration() / 1000);
                    break;
                case FRAGMENT:
                    jSONObject.put("type", 2);
                    jSONObject.put(KEY_PAGE_ID, pageLog.getPage_id());
                    jSONObject.put("time", pageLog.getStartTime() / 1000);
                    jSONObject.put("duration", pageLog.getDuration() / 1000);
                    break;
                case EVENT:
                    jSONObject.put("type", 3);
                    jSONObject.put(KEY_PAGE_ID, pageLog.getPage_id());
                    jSONObject.put("time", pageLog.getStartTime() / 1000);
                    addEventData(jSONObject, (EventLog) pageLog);
                    break;
                case ACTIVITY:
                    jSONObject.put("type", 4);
                    jSONObject.put(KEY_PAGE_ID, pageLog.getPage_id());
                    jSONObject.put("time", pageLog.getStartTime() / 1000);
                    jSONObject.put("duration", pageLog.getDuration() / 1000);
                    break;
                case APP_AD_START:
                    AdEventLog adEventLog = (AdEventLog) pageLog;
                    jSONObject.put("type", 0);
                    jSONObject.put(KEY_PAGE_ID, adEventLog.getmImei());
                    jSONObject.put("time", adEventLog.getStartTime());
                    jSONObject.put("aid", adEventLog.getmAid());
                    addEventData(jSONObject, adEventLog);
                    break;
                default:
                    break;
            }
        } catch (PageLog pageLog2) {
            String str = WBAgent.TAG;
            StringBuilder stringBuilder = new StringBuilder("get page log error.");
            stringBuilder.append(pageLog2);
            LogUtil.e(str, stringBuilder.toString());
        }
        return jSONObject;
    }

    private static JSONObject addEventData(JSONObject jSONObject, EventLog eventLog) {
        try {
            jSONObject.put(KEY_EVENT_ID, eventLog.getEvent_id());
            if (eventLog.getExtend() != null) {
                eventLog = eventLog.getExtend();
                StringBuilder stringBuilder = new StringBuilder();
                int i = 0;
                for (String str : eventLog.keySet()) {
                    if (i >= 10) {
                        break;
                    } else if (!TextUtils.isEmpty((CharSequence) eventLog.get(str))) {
                        if (stringBuilder.length() > 0) {
                            stringBuilder.append("|");
                        }
                        stringBuilder.append(str);
                        stringBuilder.append(Constants.COLON_SEPARATOR);
                        stringBuilder.append((String) eventLog.get(str));
                        i++;
                    }
                }
                jSONObject.put(KEY_EXTEND, stringBuilder.toString());
            }
        } catch (EventLog eventLog2) {
            String str2 = WBAgent.TAG;
            StringBuilder stringBuilder2 = new StringBuilder("add event log error.");
            stringBuilder2.append(eventLog2);
            LogUtil.e(str2, stringBuilder2.toString());
        }
        return jSONObject;
    }

    public static List<JSONArray> getValidUploadLogs(String str) {
        str = buildUploadLogs(str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<JSONArray> arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            str = new JSONObject(str).getJSONArray("applogs");
            JSONArray jSONArray2 = jSONArray;
            int i = 0;
            int i2 = i;
            while (i < str.length()) {
                JSONObject jSONObject = str.getJSONObject(i);
                if (isDataValid(currentTimeMillis, jSONObject.getLong("time") * 1000)) {
                    if (i2 < 500) {
                        jSONArray2.put(jSONObject);
                        i2++;
                    } else {
                        arrayList.add(jSONArray2);
                        jSONArray2 = new JSONArray();
                        i2 = 0;
                    }
                }
                i++;
            }
            if (jSONArray2.length() > null) {
                arrayList.add(jSONArray2);
            }
        } catch (String str2) {
            str2.printStackTrace();
        }
        return arrayList;
    }

    private static String buildUploadLogs(String str) {
        Object appLogs = LogFileUtil.getAppLogs(LogFileUtil.getAppLogPath(LogFileUtil.ANALYTICS_FILE_NAME));
        if (TextUtils.isEmpty(appLogs) && TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{applogs:[");
        if (!TextUtils.isEmpty(appLogs)) {
            stringBuilder.append(appLogs);
        }
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        if (stringBuilder.charAt(stringBuilder.length() - 1) == 44) {
            stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
        }
        stringBuilder.append("]}");
        return stringBuilder.toString();
    }
}
