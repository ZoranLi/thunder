package com.sina.weibo.sdk.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

class LogReport {
    private static final int CONNECTION_TIMEOUT = 25000;
    private static final String PRIVATE_CODE = "dqwef1864il4c9m6";
    private static final int SOCKET_TIMEOUT = 20000;
    private static String UPLOADTIME = "uploadtime";
    private static String mAid = null;
    private static String mAppkey = null;
    private static String mBaseUrl = "https://api.weibo.com/2/proxy/sdk/statistic.json";
    private static String mChannel;
    private static String mKeyHash;
    public static LogReport mLogReport;
    private static String mPackageName;
    private static JSONObject mParams;
    private static String mVersionName;

    public LogReport(Context context) {
        try {
            if (mPackageName == null) {
                mPackageName = context.getPackageName();
            }
            mAppkey = StatisticConfig.getAppkey(context);
            checkAid(context);
            mKeyHash = Utility.getSign(context, mPackageName);
            mVersionName = LogBuilder.getVersion(context);
            mChannel = StatisticConfig.getChannel(context);
        } catch (Context context2) {
            LogUtil.e(WBAgent.TAG, context2.toString());
        }
        initCommonParams();
    }

    private static JSONObject initCommonParams() {
        if (mParams == null) {
            mParams = new JSONObject();
        }
        try {
            mParams.put("appkey", mAppkey);
            mParams.put("platform", "Android");
            mParams.put("packagename", mPackageName);
            mParams.put("key_hash", mKeyHash);
            mParams.put("version", mVersionName);
            mParams.put("channel", mChannel);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mParams;
    }

    private static void checkAid(Context context) {
        if (TextUtils.isEmpty(mAid)) {
            mAid = Utility.getAid(context, mAppkey);
        }
        if (mParams == null) {
            mParams = new JSONObject();
        }
        try {
            mParams.put("aid", mAid);
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public static void setPackageName(String str) {
        mPackageName = str;
    }

    public static String getPackageName() {
        return mPackageName;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void uploadAppLogs(android.content.Context r7, java.lang.String r8) {
        /*
        r0 = com.sina.weibo.sdk.statistic.LogReport.class;
        monitor-enter(r0);
        r1 = mLogReport;	 Catch:{ all -> 0x00a7 }
        if (r1 != 0) goto L_0x000e;
    L_0x0007:
        r1 = new com.sina.weibo.sdk.statistic.LogReport;	 Catch:{ all -> 0x00a7 }
        r1.<init>(r7);	 Catch:{ all -> 0x00a7 }
        mLogReport = r1;	 Catch:{ all -> 0x00a7 }
    L_0x000e:
        r1 = com.sina.weibo.sdk.net.NetStateManager.isNetworkConnected(r7);	 Catch:{ all -> 0x00a7 }
        r2 = 1;
        if (r1 != 0) goto L_0x0027;
    L_0x0015:
        r7 = "WBAgent";
        r1 = "network is not connected";
        com.sina.weibo.sdk.utils.LogUtil.i(r7, r1);	 Catch:{ all -> 0x00a7 }
        r7 = "app_logs";
        r7 = com.sina.weibo.sdk.statistic.LogFileUtil.getAppLogPath(r7);	 Catch:{ all -> 0x00a7 }
        com.sina.weibo.sdk.statistic.LogFileUtil.writeToFile(r7, r8, r2);	 Catch:{ all -> 0x00a7 }
        monitor-exit(r0);
        return;
    L_0x0027:
        r8 = com.sina.weibo.sdk.statistic.LogBuilder.getValidUploadLogs(r8);	 Catch:{ all -> 0x00a7 }
        if (r8 != 0) goto L_0x0036;
    L_0x002d:
        r7 = "WBAgent";
        r8 = "applogs is null";
        com.sina.weibo.sdk.utils.LogUtil.i(r7, r8);	 Catch:{ all -> 0x00a7 }
        monitor-exit(r0);
        return;
    L_0x0036:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x00a7 }
        r1.<init>();	 Catch:{ all -> 0x00a7 }
        checkAid(r7);	 Catch:{ all -> 0x00a7 }
        r8 = r8.iterator();	 Catch:{ all -> 0x00a7 }
    L_0x0042:
        r3 = r8.hasNext();	 Catch:{ all -> 0x00a7 }
        if (r3 == 0) goto L_0x0071;
    L_0x0048:
        r3 = r8.next();	 Catch:{ all -> 0x00a7 }
        r3 = (org.json.JSONArray) r3;	 Catch:{ all -> 0x00a7 }
        r4 = mBaseUrl;	 Catch:{ all -> 0x00a7 }
        r5 = "POST";
        r6 = mParams;	 Catch:{ all -> 0x00a7 }
        r4 = requestHttpExecute(r4, r5, r6, r3, r7);	 Catch:{ all -> 0x00a7 }
        if (r4 != 0) goto L_0x0065;
    L_0x005a:
        r1.add(r3);	 Catch:{ all -> 0x00a7 }
        r3 = "WBAgent";
        r4 = "upload applogs error";
        com.sina.weibo.sdk.utils.LogUtil.e(r3, r4);	 Catch:{ all -> 0x00a7 }
        goto L_0x0042;
    L_0x0065:
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00a7 }
        r3 = java.lang.Long.valueOf(r3);	 Catch:{ all -> 0x00a7 }
        updateTime(r7, r3);	 Catch:{ all -> 0x00a7 }
        goto L_0x0042;
    L_0x0071:
        r7 = "app_logs";
        r7 = com.sina.weibo.sdk.statistic.LogFileUtil.getAppLogPath(r7);	 Catch:{ all -> 0x00a7 }
        com.sina.weibo.sdk.statistic.LogFileUtil.delete(r7);	 Catch:{ all -> 0x00a7 }
        r7 = r1.size();	 Catch:{ all -> 0x00a7 }
        if (r7 <= 0) goto L_0x00a5;
    L_0x0080:
        r7 = r1.iterator();	 Catch:{ all -> 0x00a7 }
    L_0x0084:
        r8 = r7.hasNext();	 Catch:{ all -> 0x00a7 }
        if (r8 == 0) goto L_0x00a5;
    L_0x008a:
        r8 = r7.next();	 Catch:{ all -> 0x00a7 }
        r8 = (org.json.JSONArray) r8;	 Catch:{ all -> 0x00a7 }
        r1 = "app_logs";
        r1 = com.sina.weibo.sdk.statistic.LogFileUtil.getAppLogPath(r1);	 Catch:{ all -> 0x00a7 }
        r8 = r8.toString();	 Catch:{ all -> 0x00a7 }
        com.sina.weibo.sdk.statistic.LogFileUtil.writeToFile(r1, r8, r2);	 Catch:{ all -> 0x00a7 }
        r8 = "WBAgent";
        r1 = "save failed_log";
        com.sina.weibo.sdk.utils.LogUtil.d(r8, r1);	 Catch:{ all -> 0x00a7 }
        goto L_0x0084;
    L_0x00a5:
        monitor-exit(r0);
        return;
    L_0x00a7:
        r7 = move-exception;
        monitor-exit(r0);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.statistic.LogReport.uploadAppLogs(android.content.Context, java.lang.String):void");
    }

    private static boolean requestHttpExecute(java.lang.String r6, java.lang.String r7, org.json.JSONObject r8, org.json.JSONArray r9, android.content.Context r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = mAppkey;
        r7 = android.text.TextUtils.isEmpty(r7);
        r0 = 0;
        if (r7 == 0) goto L_0x0011;
    L_0x0009:
        r6 = "WBAgent";
        r7 = "unexpected null AppKey";
        com.sina.weibo.sdk.utils.LogUtil.e(r6, r7);
        return r0;
    L_0x0011:
        r7 = 0;
        if (r8 != 0) goto L_0x0022;
    L_0x0014:
        r8 = initCommonParams();	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        goto L_0x0022;
    L_0x0019:
        r6 = move-exception;
        goto L_0x010f;
    L_0x001c:
        r6 = move-exception;
        goto L_0x00ff;
    L_0x001f:
        r6 = move-exception;
        goto L_0x0108;
    L_0x0022:
        r1 = "time";	 Catch:{ JSONException -> 0x006f }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ JSONException -> 0x006f }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ JSONException -> 0x006f }
        r2 = r2 / r4;	 Catch:{ JSONException -> 0x006f }
        r8.put(r1, r2);	 Catch:{ JSONException -> 0x006f }
        r1 = "length";	 Catch:{ JSONException -> 0x006f }
        r2 = r9.length();	 Catch:{ JSONException -> 0x006f }
        r8.put(r1, r2);	 Catch:{ JSONException -> 0x006f }
        r1 = "sign";	 Catch:{ JSONException -> 0x006f }
        r2 = "aid";	 Catch:{ JSONException -> 0x006f }
        r2 = r8.getString(r2);	 Catch:{ JSONException -> 0x006f }
        r3 = "appkey";	 Catch:{ JSONException -> 0x006f }
        r3 = r8.getString(r3);	 Catch:{ JSONException -> 0x006f }
        r4 = "time";	 Catch:{ JSONException -> 0x006f }
        r4 = r8.getLong(r4);	 Catch:{ JSONException -> 0x006f }
        r2 = getSign(r2, r3, r4);	 Catch:{ JSONException -> 0x006f }
        r8.put(r1, r2);	 Catch:{ JSONException -> 0x006f }
        r1 = "content";	 Catch:{ JSONException -> 0x006f }
        r8.put(r1, r9);	 Catch:{ JSONException -> 0x006f }
        r9 = "WBAgent";	 Catch:{ JSONException -> 0x006f }
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x006f }
        r2 = "post content--- ";	 Catch:{ JSONException -> 0x006f }
        r1.<init>(r2);	 Catch:{ JSONException -> 0x006f }
        r2 = r8.toString();	 Catch:{ JSONException -> 0x006f }
        r1.append(r2);	 Catch:{ JSONException -> 0x006f }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x006f }
        com.sina.weibo.sdk.utils.LogUtil.d(r9, r1);	 Catch:{ JSONException -> 0x006f }
        goto L_0x0073;
    L_0x006f:
        r9 = move-exception;
        r9.printStackTrace();	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
    L_0x0073:
        r9 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r9.<init>();	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r9.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r6 = "?source=";	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r9.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r6 = mAppkey;	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r9.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r6 = r9.toString();	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r6 = com.sina.weibo.sdk.net.ConnectionFactory.createConnect(r6, r10);	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r9 = new java.io.ByteArrayOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r9.<init>();	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r7 = com.sina.weibo.sdk.statistic.StatisticConfig.isNeedGizp();	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        if (r7 == 0) goto L_0x00a4;	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
    L_0x0098:
        r7 = r8.toString();	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r7 = gzipLogs(r7);	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r9.write(r7);	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        goto L_0x00af;	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
    L_0x00a4:
        r7 = r8.toString();	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r7 = r7.getBytes();	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r9.write(r7);	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
    L_0x00af:
        setPost(r6);	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r6.connect();	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r7 = new java.io.DataOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r10 = r6.getOutputStream();	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r7.<init>(r10);	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r8 = r8.toString();	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r8 = gzipLogs(r8);	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r7.write(r8);	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r7.flush();	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r7.close();	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r7 = r6.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r8 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        if (r7 != r8) goto L_0x00df;	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
    L_0x00d7:
        r6.getResponseMessage();	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r9.close();	 Catch:{ IOException -> 0x00dd }
    L_0x00dd:
        r6 = 1;
        return r6;
    L_0x00df:
        r6 = "WBAgent";	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r8 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r10 = "status code = ";	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r8.<init>(r10);	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r8.append(r7);	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r7 = r8.toString();	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        com.sina.weibo.sdk.utils.LogUtil.i(r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x00fc, IOException -> 0x00f9, all -> 0x00f6 }
        r9.close();	 Catch:{ IOException -> 0x010e }
        goto L_0x010e;
    L_0x00f6:
        r6 = move-exception;
        r7 = r9;
        goto L_0x010f;
    L_0x00f9:
        r6 = move-exception;
        r7 = r9;
        goto L_0x00ff;
    L_0x00fc:
        r6 = move-exception;
        r7 = r9;
        goto L_0x0108;
    L_0x00ff:
        r6.printStackTrace();	 Catch:{ all -> 0x0019 }
        if (r7 == 0) goto L_0x010e;
    L_0x0104:
        r7.close();	 Catch:{ IOException -> 0x010e }
        goto L_0x010e;
    L_0x0108:
        r6.printStackTrace();	 Catch:{ all -> 0x0019 }
        if (r7 == 0) goto L_0x010e;
    L_0x010d:
        goto L_0x0104;
    L_0x010e:
        return r0;
    L_0x010f:
        if (r7 == 0) goto L_0x0114;
    L_0x0111:
        r7.close();	 Catch:{ IOException -> 0x0114 }
    L_0x0114:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.statistic.LogReport.requestHttpExecute(java.lang.String, java.lang.String, org.json.JSONObject, org.json.JSONArray, android.content.Context):boolean");
    }

    private static void setPost(java.net.HttpURLConnection r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 1;
        r2.setDoOutput(r0);	 Catch:{ Exception -> 0x0026 }
        r2.setDoInput(r0);	 Catch:{ Exception -> 0x0026 }
        r0 = 0;	 Catch:{ Exception -> 0x0026 }
        r2.setUseCaches(r0);	 Catch:{ Exception -> 0x0026 }
        r0 = "POST";	 Catch:{ Exception -> 0x0026 }
        r2.setRequestMethod(r0);	 Catch:{ Exception -> 0x0026 }
        r0 = "Content-Type";	 Catch:{ Exception -> 0x0026 }
        r1 = "application/x-www-form-urlencoded";	 Catch:{ Exception -> 0x0026 }
        r2.setRequestProperty(r0, r1);	 Catch:{ Exception -> 0x0026 }
        r0 = "Connection";	 Catch:{ Exception -> 0x0026 }
        r1 = "Keep-Alive";	 Catch:{ Exception -> 0x0026 }
        r2.setRequestProperty(r0, r1);	 Catch:{ Exception -> 0x0026 }
        r0 = "Charset";	 Catch:{ Exception -> 0x0026 }
        r1 = "UTF-8";	 Catch:{ Exception -> 0x0026 }
        r2.setRequestProperty(r0, r1);	 Catch:{ Exception -> 0x0026 }
        return;
    L_0x0026:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.statistic.LogReport.setPost(java.net.HttpURLConnection):void");
    }

    private static String getSign(String str, String str2, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append(str2);
        stringBuilder.append(PRIVATE_CODE);
        stringBuilder.append(j);
        str = MD5.hexdigest(stringBuilder.toString());
        str = str.substring(str.length() - 6);
        str2 = new StringBuilder();
        str2.append(str);
        str2.append(str.substring(0, 4));
        str2 = MD5.hexdigest(str2.toString());
        j = new StringBuilder();
        j.append(str);
        j.append(str2.substring(str2.length() - 1));
        return j.toString();
    }

    private static byte[] gzipLogs(String str) {
        if (str != null) {
            if (str.length() != 0) {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    str = str.getBytes("utf-8");
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    gZIPOutputStream.write(str);
                    gZIPOutputStream.close();
                } catch (String str2) {
                    str2.printStackTrace();
                }
                return byteArrayOutputStream.toByteArray();
            }
        }
        return null;
    }

    public static long getTime(Context context) {
        return context.getSharedPreferences(UPLOADTIME, 0).getLong("lasttime", 0);
    }

    private static void updateTime(Context context, Long l) {
        context = context.getSharedPreferences(UPLOADTIME, 0).edit();
        context.putLong("lasttime", l.longValue());
        context.commit();
    }
}
