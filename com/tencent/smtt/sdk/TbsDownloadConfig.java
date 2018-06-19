package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Map;

public class TbsDownloadConfig {
    public static final int CMD_ID_DOWNLOAD_FILE = 101;
    public static final int CMD_ID_FILE_UPLOAD = 100;
    public static final long DEFAULT_RETRY_INTERVAL_SEC = 86400;
    public static final int ERROR_DOWNLOAD = 2;
    public static final int ERROR_INSTALL = 5;
    public static final int ERROR_LOAD = 6;
    public static final int ERROR_NONE = 1;
    public static final int ERROR_REPORTED = 0;
    public static final int ERROR_UNZIP = 4;
    public static final int ERROR_VERIFY = 3;
    private static TbsDownloadConfig b;
    Map<String, Object> a = new HashMap();
    private Context c;
    public SharedPreferences mPreferences;

    public interface TbsConfigKey {
        public static final String KEY_APP_METADATA = "app_metadata";
        public static final String KEY_APP_VERSIONCODE = "app_versioncode";
        public static final String KEY_APP_VERSIONCODE_FOR_SWITCH = "app_versioncode_for_switch";
        public static final String KEY_APP_VERSIONNAME = "app_versionname";
        public static final String KEY_BACKUPCORE_DELFILELIST = "backupcore_delfilelist";
        public static final String KEY_DECOUPLECOREVERSION = "tbs_decouplecoreversion";
        public static final String KEY_DESkEY_TOKEN = "tbs_deskey_token";
        public static final String KEY_DEVICE_CPUABI = "device_cpuabi";
        public static final String KEY_DOWNLOADDECOUPLECORE = "tbs_downloaddecouplecore";
        public static final String KEY_DOWNLOADURL_LIST = "tbs_downloadurl_list";
        public static final String KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES = "tbs_download_failed_max_retrytimes";
        public static final String KEY_DOWNLOAD_FAILED_RETRYTIMES = "tbs_download_failed_retrytimes";
        public static final String KEY_DOWNLOAD_INTERRUPT_CODE = "tbs_download_interrupt_code";
        public static final String KEY_DOWNLOAD_INTERRUPT_CODE_REASON = "tbs_download_interrupt_code_reason";
        public static final String KEY_DOWNLOAD_INTERRUPT_TIME = "tbs_download_interrupt_time";
        public static final String KEY_DOWNLOAD_MAXFLOW = "tbs_download_maxflow";
        public static final String KEY_DOWNLOAD_MIN_FREE_SPACE = "tbs_download_min_free_space";
        public static final String KEY_DOWNLOAD_SINGLE_TIMEOUT = "tbs_single_timeout";
        public static final String KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES = "tbs_download_success_max_retrytimes";
        public static final String KEY_DOWNLOAD_SUCCESS_RETRYTIMES = "tbs_download_success_retrytimes";
        public static final String KEY_FULL_PACKAGE = "request_full_package";
        public static final String KEY_INSTALL_INTERRUPT_CODE = "tbs_install_interrupt_code";
        public static final String KEY_IS_OVERSEA = "is_oversea";
        public static final String KEY_LAST_CHECK = "last_check";
        public static final String KEY_LAST_DOWNLOAD_DECOUPLE_CORE = "last_download_decouple_core";
        public static final String KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION = "last_thirdapp_sendrequest_coreversion";
        public static final String KEY_NEEDDOWNLOAD = "tbs_needdownload";
        public static final String KEY_RESPONSECODE = "tbs_responsecode";
        public static final String KEY_RETRY_INTERVAL = "retry_interval";
        public static final String KEY_STOP_PRE_OAT = "tbs_stop_preoat";
        public static final String KEY_SWITCH_BACKUPCORE_ENABLE = "switch_backupcore_enable";
        public static final String KEY_TBSAPKFILESIZE = "tbs_apkfilesize";
        public static final String KEY_TBSAPK_MD5 = "tbs_apk_md5";
        public static final String KEY_TBSDOWNLOADURL = "tbs_downloadurl";
        public static final String KEY_TBSDOWNLOAD_FLOW = "tbs_downloadflow";
        public static final String KEY_TBSDOWNLOAD_STARTTIME = "tbs_downloadstarttime";
        public static final String KEY_TBS_DOWNLOAD_V = "tbs_download_version";
        public static final String KEY_TBS_DOWNLOAD_V_TYPE = "tbs_download_version_type";
        public static final String KEY_USE_BACKUP_VERSION = "use_backup_version";
        public static final String KEY_USE_BUGLY = "tbs_use_bugly";
    }

    private TbsDownloadConfig(Context context) {
        this.mPreferences = context.getSharedPreferences("tbs_download_config", 4);
        this.c = context.getApplicationContext();
    }

    public static synchronized TbsDownloadConfig getInstance() {
        TbsDownloadConfig tbsDownloadConfig;
        synchronized (TbsDownloadConfig.class) {
            tbsDownloadConfig = b;
        }
        return tbsDownloadConfig;
    }

    public static synchronized TbsDownloadConfig getInstance(Context context) {
        TbsDownloadConfig tbsDownloadConfig;
        synchronized (TbsDownloadConfig.class) {
            if (b == null) {
                b = new TbsDownloadConfig(context);
            }
            tbsDownloadConfig = b;
        }
        return tbsDownloadConfig;
    }

    public void clear() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.a;	 Catch:{ Exception -> 0x0011 }
        r0.clear();	 Catch:{ Exception -> 0x0011 }
        r0 = r1.mPreferences;	 Catch:{ Exception -> 0x0011 }
        r0 = r0.edit();	 Catch:{ Exception -> 0x0011 }
        r0.clear();	 Catch:{ Exception -> 0x0011 }
        r0.commit();	 Catch:{ Exception -> 0x0011 }
    L_0x0011:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloadConfig.clear():void");
    }

    public synchronized void commit() {
        try {
            Editor edit = this.mPreferences.edit();
            for (String str : this.a.keySet()) {
                Object obj = this.a.get(str);
                if (obj instanceof String) {
                    edit.putString(str, (String) obj);
                } else if (obj instanceof Boolean) {
                    edit.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Long) {
                    edit.putLong(str, ((Long) obj).longValue());
                } else if (obj instanceof Integer) {
                    edit.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Float) {
                    edit.putFloat(str, ((Float) obj).floatValue());
                }
            }
            edit.commit();
            this.a.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized int getDownloadFailedMaxRetrytimes() {
        int i = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, 0);
        return i == 0 ? 100 : i;
    }

    public synchronized int getDownloadInterruptCode() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = r7.mPreferences;	 Catch:{ all -> 0x00a5 }
        r1 = "tbs_download_interrupt_code";	 Catch:{ all -> 0x00a5 }
        r0 = r0.contains(r1);	 Catch:{ all -> 0x00a5 }
        if (r0 != 0) goto L_0x003b;
    L_0x000b:
        r0 = new java.io.File;	 Catch:{ Throwable -> 0x0038 }
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x0038 }
        r2 = r7.c;	 Catch:{ Throwable -> 0x0038 }
        r2 = r2.getFilesDir();	 Catch:{ Throwable -> 0x0038 }
        r3 = "shared_prefs";	 Catch:{ Throwable -> 0x0038 }
        r1.<init>(r2, r3);	 Catch:{ Throwable -> 0x0038 }
        r2 = "tbs_download_config";	 Catch:{ Throwable -> 0x0038 }
        r0.<init>(r1, r2);	 Catch:{ Throwable -> 0x0038 }
        r0 = r0.exists();	 Catch:{ Throwable -> 0x0038 }
        if (r0 != 0) goto L_0x0028;	 Catch:{ Throwable -> 0x0038 }
    L_0x0025:
        r0 = -97;	 Catch:{ Throwable -> 0x0038 }
        goto L_0x0070;	 Catch:{ Throwable -> 0x0038 }
    L_0x0028:
        r0 = r7.mPreferences;	 Catch:{ Throwable -> 0x0038 }
        r1 = "tbs_needdownload";	 Catch:{ Throwable -> 0x0038 }
        r0 = r0.contains(r1);	 Catch:{ Throwable -> 0x0038 }
        if (r0 != 0) goto L_0x0035;
    L_0x0032:
        r0 = -96;
        goto L_0x0070;
    L_0x0035:
        r0 = -101; // 0xffffffffffffff9b float:NaN double:NaN;
        goto L_0x0070;
    L_0x0038:
        r0 = -95;
        goto L_0x0070;
    L_0x003b:
        r0 = r7.mPreferences;	 Catch:{ all -> 0x00a5 }
        r1 = "tbs_download_interrupt_code";	 Catch:{ all -> 0x00a5 }
        r2 = -99;	 Catch:{ all -> 0x00a5 }
        r0 = r0.getInt(r1, r2);	 Catch:{ all -> 0x00a5 }
        r1 = -119; // 0xffffffffffffff89 float:NaN double:NaN;	 Catch:{ all -> 0x00a5 }
        if (r0 == r1) goto L_0x004d;	 Catch:{ all -> 0x00a5 }
    L_0x0049:
        r2 = -121; // 0xffffffffffffff87 float:NaN double:NaN;	 Catch:{ all -> 0x00a5 }
        if (r0 != r2) goto L_0x0055;	 Catch:{ all -> 0x00a5 }
    L_0x004d:
        r0 = r7.mPreferences;	 Catch:{ all -> 0x00a5 }
        r2 = "tbs_download_interrupt_code_reason";	 Catch:{ all -> 0x00a5 }
        r0 = r0.getInt(r2, r1);	 Catch:{ all -> 0x00a5 }
    L_0x0055:
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00a5 }
        r3 = r7.mPreferences;	 Catch:{ all -> 0x00a5 }
        r4 = "tbs_download_interrupt_time";	 Catch:{ all -> 0x00a5 }
        r5 = 0;	 Catch:{ all -> 0x00a5 }
        r3 = r3.getLong(r4, r5);	 Catch:{ all -> 0x00a5 }
        r5 = r1 - r3;	 Catch:{ all -> 0x00a5 }
        r1 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;	 Catch:{ all -> 0x00a5 }
        r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1));	 Catch:{ all -> 0x00a5 }
        if (r3 <= 0) goto L_0x0070;	 Catch:{ all -> 0x00a5 }
    L_0x006c:
        r1 = 98000; // 0x17ed0 float:1.37327E-40 double:4.84184E-319;	 Catch:{ all -> 0x00a5 }
        r0 = r0 - r1;	 Catch:{ all -> 0x00a5 }
    L_0x0070:
        r1 = r7.c;	 Catch:{ all -> 0x00a5 }
        if (r1 == 0) goto L_0x0098;	 Catch:{ all -> 0x00a5 }
    L_0x0074:
        r1 = "com.tencent.mobileqq";	 Catch:{ all -> 0x00a5 }
        r2 = r7.c;	 Catch:{ all -> 0x00a5 }
        r2 = r2.getApplicationInfo();	 Catch:{ all -> 0x00a5 }
        r2 = r2.packageName;	 Catch:{ all -> 0x00a5 }
        r1 = r1.equals(r2);	 Catch:{ all -> 0x00a5 }
        if (r1 == 0) goto L_0x0098;	 Catch:{ all -> 0x00a5 }
    L_0x0084:
        r1 = "CN";	 Catch:{ all -> 0x00a5 }
        r2 = java.util.Locale.getDefault();	 Catch:{ all -> 0x00a5 }
        r2 = r2.getCountry();	 Catch:{ all -> 0x00a5 }
        r1 = r1.equals(r2);	 Catch:{ all -> 0x00a5 }
        if (r1 != 0) goto L_0x0098;
    L_0x0094:
        r0 = -320; // 0xfffffffffffffec0 float:NaN double:NaN;
    L_0x0096:
        monitor-exit(r7);
        return r0;
    L_0x0098:
        r1 = r7.mPreferences;	 Catch:{ all -> 0x00a5 }
        r2 = "tbs_install_interrupt_code";	 Catch:{ all -> 0x00a5 }
        r3 = -1;	 Catch:{ all -> 0x00a5 }
        r1 = r1.getInt(r2, r3);	 Catch:{ all -> 0x00a5 }
        r0 = r0 * 1000;
        r0 = r0 + r1;
        goto L_0x0096;
    L_0x00a5:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloadConfig.getDownloadInterruptCode():int");
    }

    public synchronized long getDownloadMaxflow() {
        int i;
        i = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, 0);
        if (i == 0) {
            i = 20;
        }
        return ((long) (i * 1024)) * 1024;
    }

    public synchronized long getDownloadMinFreeSpace() {
        int i;
        i = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, 0);
        if (i == 0) {
            i = 0;
        }
        return ((long) (i * 1024)) * 1024;
    }

    public synchronized long getDownloadSingleTimeout() {
        long j = this.mPreferences.getLong(TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, 0);
        return j == 0 ? 1200000 : j;
    }

    public synchronized int getDownloadSuccessMaxRetrytimes() {
        int i = this.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, 0);
        return i == 0 ? 3 : i;
    }

    public synchronized long getRetryInterval() {
        if (TbsDownloader.getRetryIntervalInSeconds() >= 0) {
            return TbsDownloader.getRetryIntervalInSeconds();
        }
        return this.mPreferences.getLong(TbsConfigKey.KEY_RETRY_INTERVAL, DEFAULT_RETRY_INTERVAL_SEC);
    }

    public synchronized boolean isOverSea() {
        return this.mPreferences.getBoolean(TbsConfigKey.KEY_IS_OVERSEA, false);
    }

    public synchronized void setDownloadInterruptCode(int r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.mPreferences;	 Catch:{ Exception -> 0x001d, all -> 0x001a }
        r0 = r0.edit();	 Catch:{ Exception -> 0x001d, all -> 0x001a }
        r1 = "tbs_download_interrupt_code";	 Catch:{ Exception -> 0x001d, all -> 0x001a }
        r0.putInt(r1, r4);	 Catch:{ Exception -> 0x001d, all -> 0x001a }
        r4 = "tbs_download_interrupt_time";	 Catch:{ Exception -> 0x001d, all -> 0x001a }
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x001d, all -> 0x001a }
        r0.putLong(r4, r1);	 Catch:{ Exception -> 0x001d, all -> 0x001a }
        r0.commit();	 Catch:{ Exception -> 0x001d, all -> 0x001a }
        monitor-exit(r3);
        return;
    L_0x001a:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
    L_0x001d:
        monitor-exit(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloadConfig.setDownloadInterruptCode(int):void");
    }

    public synchronized void setInstallInterruptCode(int i) {
        Editor edit = this.mPreferences.edit();
        edit.putInt(TbsConfigKey.KEY_INSTALL_INTERRUPT_CODE, i);
        edit.commit();
    }
}
