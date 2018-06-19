package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.aa;
import com.tencent.smtt.utils.k;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xunlei.common.androidutil.ApkHelper;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileLock;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class aj {
    public static ThreadLocal<Integer> a = new ak();
    static boolean b = false;
    private static aj c = null;
    private static final Lock h = new ReentrantLock();
    private static final Lock i = new ReentrantLock();
    private static Handler k = null;
    private static final Long[][] l;
    private static boolean m = false;
    private int d = 0;
    private FileLock e;
    private FileOutputStream f;
    private boolean g = false;
    private boolean j = false;

    static {
        r0 = new Long[7][];
        r0[0] = new Long[]{Long.valueOf(25413), Long.valueOf(11460320)};
        r0[1] = new Long[]{Long.valueOf(25436), Long.valueOf(12009376)};
        r0[2] = new Long[]{Long.valueOf(25437), Long.valueOf(11489180)};
        r0[3] = new Long[]{Long.valueOf(25438), Long.valueOf(11489180)};
        r0[4] = new Long[]{Long.valueOf(25439), Long.valueOf(12013472)};
        r0[5] = new Long[]{Long.valueOf(25440), Long.valueOf(11489180)};
        r0[6] = new Long[]{Long.valueOf(25442), Long.valueOf(11489180)};
        l = r0;
    }

    private aj() {
        if (k == null) {
            k = new al(this, ai.a().getLooper());
        }
    }

    static synchronized aj a() {
        aj ajVar;
        synchronized (aj.class) {
            if (c == null) {
                synchronized (aj.class) {
                    if (c == null) {
                        c = new aj();
                    }
                }
            }
            ajVar = c;
        }
        return ajVar;
    }

    private void a(int i, String str, Context context) {
        BufferedInputStream bufferedInputStream;
        OutputStream bufferedOutputStream;
        Throwable th;
        new File(str).delete();
        StringBuilder stringBuilder = new StringBuilder("Local tbs apk(");
        stringBuilder.append(str);
        stringBuilder.append(") is deleted!");
        TbsLog.i("TbsInstaller", stringBuilder.toString(), true);
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp");
        if (file.canRead()) {
            File file2 = new File(file, "tbs.conf");
            Properties properties = new Properties();
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                try {
                    properties.load(bufferedInputStream);
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        if (bufferedOutputStream2 != null) {
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (bufferedOutputStream2 != null) {
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                try {
                    properties.setProperty("tbs_local_installation", "true");
                    properties.store(bufferedOutputStream, null);
                    TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is set!", true);
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e2222) {
                        e2222.printStackTrace();
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e22222) {
                        e22222.printStackTrace();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedOutputStream2 != null) {
                        bufferedOutputStream2.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedInputStream = null;
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        }
    }

    public static void a(Context context) {
        if (!t(context)) {
            String str;
            String str2;
            if (d(context, "core_unzip_tmp")) {
                TbsCoreLoadStat.getInstance().a(context, ErrorCode.INFO_TEMP_CORE_EXIST_CONF_ERROR, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
                str = "TbsInstaller";
                str2 = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME";
            } else if (d(context, "core_share_backup_tmp")) {
                TbsCoreLoadStat.getInstance().a(context, ErrorCode.INFO_TEMP_CORE_EXIST_CONF_ERROR, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
                str = "TbsInstaller";
                str2 = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME";
            } else if (d(context, "core_copy_tmp")) {
                TbsCoreLoadStat.getInstance().a(context, ErrorCode.INFO_TEMP_CORE_EXIST_CONF_ERROR, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
                TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME");
            }
            TbsLog.e(str, str2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(11)
    private void a(android.content.Context r20, android.content.Context r21, int r22) {
        /*
        r19 = this;
        r1 = r19;
        r2 = r21;
        r3 = r22;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r20);
        r5 = -524; // 0xfffffffffffffdf4 float:NaN double:NaN;
        r4.setInstallInterruptCode(r5);
        r4 = r1.c(r2);
        if (r4 == 0) goto L_0x0016;
    L_0x0015:
        return;
    L_0x0016:
        r4 = "TbsInstaller";
        r5 = new java.lang.StringBuilder;
        r6 = "TbsInstaller-copyTbsCoreInThread start!  tbsCoreTargetVer is ";
        r5.<init>(r6);
        r5.append(r3);
        r5 = r5.toString();
        com.tencent.smtt.utils.TbsLog.i(r4, r5);
        r4 = android.os.Build.VERSION.SDK_INT;
        r5 = 4;
        r6 = 11;
        r7 = 0;
        if (r4 < r6) goto L_0x0038;
    L_0x0031:
        r4 = "tbs_preloadx5_check_cfg_file";
        r4 = r2.getSharedPreferences(r4, r5);
        goto L_0x003e;
    L_0x0038:
        r4 = "tbs_preloadx5_check_cfg_file";
        r4 = r2.getSharedPreferences(r4, r7);
    L_0x003e:
        r8 = "tbs_precheck_disable_version";
        r9 = -1;
        r4 = r4.getInt(r8, r9);
        if (r4 != r3) goto L_0x0069;
    L_0x0047:
        r2 = "TbsInstaller";
        r4 = new java.lang.StringBuilder;
        r5 = "TbsInstaller-copyTbsCoreInThread -- version:";
        r4.<init>(r5);
        r4.append(r3);
        r3 = " is disabled by preload_x5_check!";
        r4.append(r3);
        r3 = r4.toString();
        com.tencent.smtt.utils.TbsLog.e(r2, r3);
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r20);
        r3 = -525; // 0xfffffffffffffdf3 float:NaN double:NaN;
    L_0x0065:
        r2.setInstallInterruptCode(r3);
        return;
    L_0x0069:
        r4 = r1.s(r2);
        if (r4 != 0) goto L_0x0076;
    L_0x006f:
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r20);
        r3 = -526; // 0xfffffffffffffdf2 float:NaN double:NaN;
        goto L_0x0065;
    L_0x0076:
        r4 = i;
        r4 = r4.tryLock();
        r8 = "TbsInstaller";
        r10 = new java.lang.StringBuilder;
        r11 = "TbsInstaller-copyTbsCoreInThread #1 locked is ";
        r10.<init>(r11);
        r10.append(r4);
        r10 = r10.toString();
        com.tencent.smtt.utils.TbsLog.i(r8, r10);
        if (r4 == 0) goto L_0x051e;
    L_0x0091:
        r4 = h;
        r4.lock();
        r4 = com.tencent.smtt.sdk.af.a(r21);	 Catch:{ Exception -> 0x04ea }
        r8 = "copy_core_ver";
        r4 = r4.c(r8);	 Catch:{ Exception -> 0x04ea }
        r8 = com.tencent.smtt.sdk.af.a(r21);	 Catch:{ Exception -> 0x04ea }
        r10 = "copy_status";
        r8 = r8.b(r10);	 Catch:{ Exception -> 0x04ea }
        r10 = -528; // 0xfffffffffffffdf0 float:NaN double:NaN;
        r11 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
        if (r4 != r3) goto L_0x00ca;
    L_0x00b0:
        r3 = com.tencent.smtt.sdk.QbSdk.k;	 Catch:{ Exception -> 0x04ea }
        r3.onInstallFinish(r11);	 Catch:{ Exception -> 0x04ea }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r20);	 Catch:{ Exception -> 0x04ea }
        r3.setInstallInterruptCode(r10);	 Catch:{ Exception -> 0x04ea }
        r2 = h;
        r2.unlock();
        r2 = i;
        r2.unlock();
        r19.b();
        return;
    L_0x00ca:
        r12 = r1.g(r2);	 Catch:{ Exception -> 0x04ea }
        r13 = "TbsInstaller";
        r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04ea }
        r15 = "TbsInstaller-copyTbsCoreInThread tbsCoreInstalledVer=";
        r14.<init>(r15);	 Catch:{ Exception -> 0x04ea }
        r14.append(r12);	 Catch:{ Exception -> 0x04ea }
        r14 = r14.toString();	 Catch:{ Exception -> 0x04ea }
        com.tencent.smtt.utils.TbsLog.i(r13, r14);	 Catch:{ Exception -> 0x04ea }
        if (r12 != r3) goto L_0x0110;
    L_0x00e3:
        r3 = com.tencent.smtt.sdk.QbSdk.k;	 Catch:{ Exception -> 0x04ea }
        r3.onInstallFinish(r11);	 Catch:{ Exception -> 0x04ea }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r20);	 Catch:{ Exception -> 0x04ea }
        r3.setInstallInterruptCode(r10);	 Catch:{ Exception -> 0x04ea }
        r3 = "TbsInstaller";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04ea }
        r5 = "TbsInstaller-copyTbsCoreInThread return have same version is ";
        r4.<init>(r5);	 Catch:{ Exception -> 0x04ea }
        r4.append(r12);	 Catch:{ Exception -> 0x04ea }
        r4 = r4.toString();	 Catch:{ Exception -> 0x04ea }
        com.tencent.smtt.utils.TbsLog.i(r3, r4);	 Catch:{ Exception -> 0x04ea }
        r2 = h;
        r2.unlock();
        r2 = i;
        r2.unlock();
        r19.b();
        return;
    L_0x0110:
        r10 = com.tencent.smtt.sdk.af.a(r21);	 Catch:{ Exception -> 0x04ea }
        r10 = r10.b();	 Catch:{ Exception -> 0x04ea }
        if (r10 <= 0) goto L_0x011c;
    L_0x011a:
        if (r3 > r10) goto L_0x0120;
    L_0x011c:
        if (r4 <= 0) goto L_0x0123;
    L_0x011e:
        if (r3 <= r4) goto L_0x0123;
    L_0x0120:
        r1.k(r2);	 Catch:{ Exception -> 0x04ea }
    L_0x0123:
        r4 = 3;
        r10 = 1;
        if (r8 != r4) goto L_0x013b;
    L_0x0127:
        if (r12 <= 0) goto L_0x013b;
    L_0x0129:
        if (r3 > r12) goto L_0x0130;
    L_0x012b:
        r4 = 88888888; // 0x54c5638 float:9.60787E-36 double:4.3916946E-316;
        if (r3 != r4) goto L_0x013b;
    L_0x0130:
        r1.k(r2);	 Catch:{ Exception -> 0x04ea }
        r4 = "TbsInstaller";
        r8 = "TbsInstaller-copyTbsCoreInThread -- update TBS.....";
        com.tencent.smtt.utils.TbsLog.i(r4, r8, r10);	 Catch:{ Exception -> 0x04ea }
        r8 = r9;
    L_0x013b:
        r4 = com.tencent.smtt.utils.k.b(r21);	 Catch:{ Exception -> 0x04ea }
        if (r4 != 0) goto L_0x0183;
    L_0x0141:
        r3 = com.tencent.smtt.utils.aa.a();	 Catch:{ Exception -> 0x04ea }
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r21);	 Catch:{ Exception -> 0x04ea }
        r5 = r5.getDownloadMinFreeSpace();	 Catch:{ Exception -> 0x04ea }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r20);	 Catch:{ Exception -> 0x04ea }
        r8 = -529; // 0xfffffffffffffdef float:NaN double:NaN;
        r7.setInstallInterruptCode(r8);	 Catch:{ Exception -> 0x04ea }
        r7 = com.tencent.smtt.sdk.TbsLogReport.a(r21);	 Catch:{ Exception -> 0x04ea }
        r8 = 210; // 0xd2 float:2.94E-43 double:1.04E-321;
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04ea }
        r10 = "rom is not enough when copying tbs core! curAvailROM=";
        r9.<init>(r10);	 Catch:{ Exception -> 0x04ea }
        r9.append(r3);	 Catch:{ Exception -> 0x04ea }
        r3 = ",minReqRom=";
        r9.append(r3);	 Catch:{ Exception -> 0x04ea }
        r9.append(r5);	 Catch:{ Exception -> 0x04ea }
        r3 = r9.toString();	 Catch:{ Exception -> 0x04ea }
        r7.a(r8, r3);	 Catch:{ Exception -> 0x04ea }
        r2 = h;
        r2.unlock();
        r2 = i;
        r2.unlock();
        r19.b();
        return;
    L_0x0183:
        if (r8 <= 0) goto L_0x01c4;
    L_0x0185:
        r4 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r21);	 Catch:{ Exception -> 0x04ea }
        if (r4 != 0) goto L_0x019f;
    L_0x018b:
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r21);	 Catch:{ Exception -> 0x04ea }
        r4 = r4.mPreferences;	 Catch:{ Exception -> 0x04ea }
        r9 = "tbs_downloaddecouplecore";
        r4 = r4.getInt(r9, r7);	 Catch:{ Exception -> 0x04ea }
        if (r4 != r10) goto L_0x019f;
    L_0x0199:
        r4 = r1.f(r2);	 Catch:{ Exception -> 0x04ea }
        if (r3 != r4) goto L_0x01c4;
    L_0x019f:
        r3 = "TbsInstaller";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04ea }
        r5 = "TbsInstaller-copyTbsCoreInThread return have copied is ";
        r4.<init>(r5);	 Catch:{ Exception -> 0x04ea }
        r5 = r1.f(r2);	 Catch:{ Exception -> 0x04ea }
        r4.append(r5);	 Catch:{ Exception -> 0x04ea }
        r4 = r4.toString();	 Catch:{ Exception -> 0x04ea }
        com.tencent.smtt.utils.TbsLog.i(r3, r4);	 Catch:{ Exception -> 0x04ea }
        r2 = h;
        r2.unlock();
        r2 = i;
        r2.unlock();
        r19.b();
        return;
    L_0x01c4:
        if (r8 != 0) goto L_0x0200;
    L_0x01c6:
        r4 = com.tencent.smtt.sdk.af.a(r21);	 Catch:{ Exception -> 0x04ea }
        r8 = "copy_retry_num";
        r4 = r4.c(r8);	 Catch:{ Exception -> 0x04ea }
        r8 = 10;
        if (r4 <= r8) goto L_0x01f6;
    L_0x01d4:
        r3 = com.tencent.smtt.sdk.TbsLogReport.a(r21);	 Catch:{ Exception -> 0x04ea }
        r4 = 211; // 0xd3 float:2.96E-43 double:1.042E-321;
        r5 = "exceed copy retry num!";
        r3.a(r4, r5);	 Catch:{ Exception -> 0x04ea }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r20);	 Catch:{ Exception -> 0x04ea }
        r4 = -530; // 0xfffffffffffffdee float:NaN double:NaN;
        r3.setInstallInterruptCode(r4);	 Catch:{ Exception -> 0x04ea }
        r2 = h;
        r2.unlock();
        r2 = i;
        r2.unlock();
        r19.b();
        return;
    L_0x01f6:
        r8 = com.tencent.smtt.sdk.af.a(r21);	 Catch:{ Exception -> 0x04ea }
        r9 = "copy_retry_num";
        r4 = r4 + r10;
        r8.a(r9, r4);	 Catch:{ Exception -> 0x04ea }
    L_0x0200:
        r4 = r19.m(r20);	 Catch:{ Exception -> 0x04ea }
        r8 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r21);	 Catch:{ Exception -> 0x04ea }
        if (r8 != 0) goto L_0x021d;
    L_0x020a:
        r8 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r21);	 Catch:{ Exception -> 0x04ea }
        r8 = r8.mPreferences;	 Catch:{ Exception -> 0x04ea }
        r9 = "tbs_downloaddecouplecore";
        r8 = r8.getInt(r9, r7);	 Catch:{ Exception -> 0x04ea }
        if (r8 != r10) goto L_0x021d;
    L_0x0218:
        r8 = r1.l(r2);	 Catch:{ Exception -> 0x04ea }
        goto L_0x0221;
    L_0x021d:
        r8 = r1.r(r2);	 Catch:{ Exception -> 0x04ea }
    L_0x0221:
        if (r4 == 0) goto L_0x04ad;
    L_0x0223:
        if (r8 == 0) goto L_0x04ad;
    L_0x0225:
        r12 = com.tencent.smtt.sdk.af.a(r21);	 Catch:{ Exception -> 0x04ea }
        r12.a(r3, r7);	 Catch:{ Exception -> 0x04ea }
        r12 = new com.tencent.smtt.utils.z;	 Catch:{ Exception -> 0x04ea }
        r12.<init>();	 Catch:{ Exception -> 0x04ea }
        r12.a(r4);	 Catch:{ Exception -> 0x04ea }
        r13 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x04ea }
        r15 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r20);	 Catch:{ Exception -> 0x04ea }
        r5 = -551; // 0xfffffffffffffdd9 float:NaN double:NaN;
        r15.setInstallInterruptCode(r5);	 Catch:{ Exception -> 0x04ea }
        r5 = com.tencent.smtt.utils.k.b(r4, r8);	 Catch:{ Exception -> 0x04ea }
        r15 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r21);	 Catch:{ Exception -> 0x04ea }
        r15 = r15.mPreferences;	 Catch:{ Exception -> 0x04ea }
        r6 = "tbs_downloaddecouplecore";
        r6 = r15.getInt(r6, r7);	 Catch:{ Exception -> 0x04ea }
        if (r6 != r10) goto L_0x0256;
    L_0x0253:
        com.tencent.smtt.sdk.TbsShareManager.b(r21);	 Catch:{ Exception -> 0x04ea }
    L_0x0256:
        r6 = "TbsInstaller";
        r15 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04ea }
        r7 = "TbsInstaller-copyTbsCoreInThread time=";
        r15.<init>(r7);	 Catch:{ Exception -> 0x04ea }
        r16 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x04ea }
        r9 = r16 - r13;
        r15.append(r9);	 Catch:{ Exception -> 0x04ea }
        r7 = r15.toString();	 Catch:{ Exception -> 0x04ea }
        com.tencent.smtt.utils.TbsLog.i(r6, r7);	 Catch:{ Exception -> 0x04ea }
        if (r5 == 0) goto L_0x0485;
    L_0x0271:
        r12.b(r4);	 Catch:{ Exception -> 0x04ea }
        r4 = r12.a();	 Catch:{ Exception -> 0x04ea }
        if (r4 != 0) goto L_0x02a7;
    L_0x027a:
        r3 = "TbsInstaller";
        r4 = "TbsInstaller-copyTbsCoreInThread copy-verify fail!";
        com.tencent.smtt.utils.TbsLog.i(r3, r4);	 Catch:{ Exception -> 0x04ea }
        r3 = 1;
        com.tencent.smtt.utils.k.a(r8, r3);	 Catch:{ Exception -> 0x04ea }
        r3 = com.tencent.smtt.sdk.TbsLogReport.a(r21);	 Catch:{ Exception -> 0x04ea }
        r4 = "TbsCopy-Verify fail after copying tbs core!";
        r5 = 213; // 0xd5 float:2.98E-43 double:1.05E-321;
        r3.a(r5, r4);	 Catch:{ Exception -> 0x04ea }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r20);	 Catch:{ Exception -> 0x04ea }
        r4 = -531; // 0xfffffffffffffded float:NaN double:NaN;
        r3.setInstallInterruptCode(r4);	 Catch:{ Exception -> 0x04ea }
        r2 = h;
        r2.unlock();
        r2 = i;
        r2.unlock();
        r19.b();
        return;
    L_0x02a7:
        r4 = 0;
        r5 = new java.io.File;	 Catch:{ Exception -> 0x02df, all -> 0x02db }
        r6 = "1";
        r5.<init>(r8, r6);	 Catch:{ Exception -> 0x02df, all -> 0x02db }
        r6 = new java.util.Properties;	 Catch:{ Exception -> 0x02df, all -> 0x02db }
        r6.<init>();	 Catch:{ Exception -> 0x02df, all -> 0x02db }
        r7 = r5.exists();	 Catch:{ Exception -> 0x02d8, all -> 0x02db }
        if (r7 == 0) goto L_0x02cc;
    L_0x02ba:
        r7 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x02d8, all -> 0x02db }
        r7.<init>(r5);	 Catch:{ Exception -> 0x02d8, all -> 0x02db }
        r5 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x02d8, all -> 0x02db }
        r5.<init>(r7);	 Catch:{ Exception -> 0x02d8, all -> 0x02db }
        r6.load(r5);	 Catch:{ Exception -> 0x02ca }
        r4 = r5;
        r10 = 1;
        goto L_0x02cd;
    L_0x02ca:
        r0 = move-exception;
        goto L_0x02e2;
    L_0x02cc:
        r10 = 0;
    L_0x02cd:
        if (r4 == 0) goto L_0x02f1;
    L_0x02cf:
        r4.close();	 Catch:{ IOException -> 0x02d3 }
        goto L_0x02f1;
    L_0x02d3:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x04ea }
        goto L_0x02f1;
    L_0x02d8:
        r0 = move-exception;
        r5 = r4;
        goto L_0x02e2;
    L_0x02db:
        r0 = move-exception;
        r3 = r0;
        goto L_0x047a;
    L_0x02df:
        r0 = move-exception;
        r5 = r4;
        r6 = r5;
    L_0x02e2:
        r4 = r0;
        r4.printStackTrace();	 Catch:{ all -> 0x0477 }
        if (r5 == 0) goto L_0x02f0;
    L_0x02e8:
        r5.close();	 Catch:{ IOException -> 0x02ec }
        goto L_0x02f0;
    L_0x02ec:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x04ea }
    L_0x02f0:
        r10 = 1;
    L_0x02f1:
        if (r10 == 0) goto L_0x0385;
    L_0x02f3:
        r4 = r8.listFiles();	 Catch:{ Exception -> 0x04ea }
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r20);	 Catch:{ Exception -> 0x04ea }
        r7 = -552; // 0xfffffffffffffdd8 float:NaN double:NaN;
        r5.setInstallInterruptCode(r7);	 Catch:{ Exception -> 0x04ea }
        r5 = 0;
    L_0x0301:
        r7 = r4.length;	 Catch:{ Exception -> 0x04ea }
        if (r5 >= r7) goto L_0x0385;
    L_0x0304:
        r7 = r4[r5];	 Catch:{ Exception -> 0x04ea }
        r9 = "1";
        r12 = r7.getName();	 Catch:{ Exception -> 0x04ea }
        r9 = r9.equals(r12);	 Catch:{ Exception -> 0x04ea }
        if (r9 != 0) goto L_0x0381;
    L_0x0312:
        r9 = r7.getName();	 Catch:{ Exception -> 0x04ea }
        r12 = ".dex";
        r9 = r9.endsWith(r12);	 Catch:{ Exception -> 0x04ea }
        if (r9 != 0) goto L_0x0381;
    L_0x031e:
        r9 = "tbs.conf";
        r12 = r7.getName();	 Catch:{ Exception -> 0x04ea }
        r9 = r9.equals(r12);	 Catch:{ Exception -> 0x04ea }
        if (r9 != 0) goto L_0x0381;
    L_0x032a:
        r9 = com.tencent.smtt.utils.a.a(r7);	 Catch:{ Exception -> 0x04ea }
        r12 = r7.getName();	 Catch:{ Exception -> 0x04ea }
        r13 = "";
        r12 = r6.getProperty(r12, r13);	 Catch:{ Exception -> 0x04ea }
        r13 = "";
        r13 = r12.equals(r13);	 Catch:{ Exception -> 0x04ea }
        if (r13 != 0) goto L_0x0363;
    L_0x0340:
        r9 = r9.equals(r12);	 Catch:{ Exception -> 0x04ea }
        if (r9 == 0) goto L_0x0363;
    L_0x0346:
        r9 = "TbsInstaller";
        r12 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04ea }
        r13 = "md5_check_success for (";
        r12.<init>(r13);	 Catch:{ Exception -> 0x04ea }
        r7 = r7.getName();	 Catch:{ Exception -> 0x04ea }
        r12.append(r7);	 Catch:{ Exception -> 0x04ea }
        r7 = ")";
        r12.append(r7);	 Catch:{ Exception -> 0x04ea }
        r7 = r12.toString();	 Catch:{ Exception -> 0x04ea }
        com.tencent.smtt.utils.TbsLog.i(r9, r7);	 Catch:{ Exception -> 0x04ea }
        goto L_0x0381;
    L_0x0363:
        r4 = "TbsInstaller";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04ea }
        r6 = "md5_check_failure for (";
        r5.<init>(r6);	 Catch:{ Exception -> 0x04ea }
        r6 = r7.getName();	 Catch:{ Exception -> 0x04ea }
        r5.append(r6);	 Catch:{ Exception -> 0x04ea }
        r6 = ")";
        r5.append(r6);	 Catch:{ Exception -> 0x04ea }
        r5 = r5.toString();	 Catch:{ Exception -> 0x04ea }
        com.tencent.smtt.utils.TbsLog.e(r4, r5);	 Catch:{ Exception -> 0x04ea }
        r4 = 0;
        goto L_0x0386;
    L_0x0381:
        r5 = r5 + 1;
        goto L_0x0301;
    L_0x0385:
        r4 = 1;
    L_0x0386:
        r5 = "TbsInstaller";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04ea }
        r7 = "copyTbsCoreInThread - md5_check_success:";
        r6.<init>(r7);	 Catch:{ Exception -> 0x04ea }
        r6.append(r4);	 Catch:{ Exception -> 0x04ea }
        r6 = r6.toString();	 Catch:{ Exception -> 0x04ea }
        com.tencent.smtt.utils.TbsLog.i(r5, r6);	 Catch:{ Exception -> 0x04ea }
        if (r10 == 0) goto L_0x03ca;
    L_0x039b:
        if (r4 != 0) goto L_0x03ca;
    L_0x039d:
        r3 = "TbsInstaller";
        r4 = "copyTbsCoreInThread - md5 incorrect -> delete destTmpDir!";
        com.tencent.smtt.utils.TbsLog.e(r3, r4);	 Catch:{ Exception -> 0x04ea }
        r3 = 1;
        com.tencent.smtt.utils.k.a(r8, r3);	 Catch:{ Exception -> 0x04ea }
        r3 = com.tencent.smtt.sdk.TbsLogReport.a(r21);	 Catch:{ Exception -> 0x04ea }
        r4 = "TbsCopy-Verify md5 fail after copying tbs core!";
        r5 = 213; // 0xd5 float:2.98E-43 double:1.05E-321;
        r3.a(r5, r4);	 Catch:{ Exception -> 0x04ea }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r20);	 Catch:{ Exception -> 0x04ea }
        r4 = -532; // 0xfffffffffffffdec float:NaN double:NaN;
        r3.setInstallInterruptCode(r4);	 Catch:{ Exception -> 0x04ea }
        r2 = h;
        r2.unlock();
        r2 = i;
        r2.unlock();
        r19.b();
        return;
    L_0x03ca:
        r4 = "TbsInstaller";
        r5 = "TbsInstaller-copyTbsCoreInThread success!";
        com.tencent.smtt.utils.TbsLog.i(r4, r5);	 Catch:{ Exception -> 0x04ea }
        r4 = 1;
        r1.f(r2, r4);	 Catch:{ Exception -> 0x04ea }
        r4 = com.tencent.smtt.sdk.ad.b(r20);	 Catch:{ Exception -> 0x04ea }
        if (r4 == 0) goto L_0x03f4;
    L_0x03db:
        r5 = r4.exists();	 Catch:{ Exception -> 0x04ea }
        if (r5 == 0) goto L_0x03f4;
    L_0x03e1:
        r5 = new java.io.File;	 Catch:{ Exception -> 0x04ea }
        r6 = com.tencent.smtt.sdk.TbsDownloader.getOverSea(r21);	 Catch:{ Exception -> 0x04ea }
        if (r6 == 0) goto L_0x03ec;
    L_0x03e9:
        r6 = "x5.oversea.tbs.org";
        goto L_0x03ee;
    L_0x03ec:
        r6 = "x5.tbs.org";
    L_0x03ee:
        r5.<init>(r4, r6);	 Catch:{ Exception -> 0x04ea }
        com.tencent.smtt.sdk.ad.a(r5, r2);	 Catch:{ Exception -> 0x04ea }
    L_0x03f4:
        r4 = com.tencent.smtt.sdk.af.a(r21);	 Catch:{ Exception -> 0x04ea }
        r5 = 1;
        r4.a(r3, r5);	 Catch:{ Exception -> 0x04ea }
        r4 = r1.j;	 Catch:{ Exception -> 0x04ea }
        if (r4 == 0) goto L_0x040a;
    L_0x0400:
        r4 = com.tencent.smtt.sdk.TbsLogReport.a(r21);	 Catch:{ Exception -> 0x04ea }
        r5 = "continueInstallWithout core success";
    L_0x0406:
        r4.a(r11, r5);	 Catch:{ Exception -> 0x04ea }
        goto L_0x0411;
    L_0x040a:
        r4 = com.tencent.smtt.sdk.TbsLogReport.a(r21);	 Catch:{ Exception -> 0x04ea }
        r5 = "success";
        goto L_0x0406;
    L_0x0411:
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r20);	 Catch:{ Exception -> 0x04ea }
        r5 = -533; // 0xfffffffffffffdeb float:NaN double:NaN;
        r4.setInstallInterruptCode(r5);	 Catch:{ Exception -> 0x04ea }
        r4 = "TbsInstaller";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04ea }
        r6 = "TbsInstaller-copyTbsCoreInThread success -- version:";
        r5.<init>(r6);	 Catch:{ Exception -> 0x04ea }
        r5.append(r3);	 Catch:{ Exception -> 0x04ea }
        r5 = r5.toString();	 Catch:{ Exception -> 0x04ea }
        com.tencent.smtt.utils.TbsLog.i(r4, r5);	 Catch:{ Exception -> 0x04ea }
        r4 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x04ea }
        r5 = 11;
        if (r4 < r5) goto L_0x043c;
    L_0x0433:
        r4 = "tbs_preloadx5_check_cfg_file";
        r5 = 4;
        r4 = r2.getSharedPreferences(r4, r5);	 Catch:{ Exception -> 0x04ea }
        r5 = 0;
        goto L_0x0443;
    L_0x043c:
        r4 = "tbs_preloadx5_check_cfg_file";
        r5 = 0;
        r4 = r2.getSharedPreferences(r4, r5);	 Catch:{ Exception -> 0x04ea }
    L_0x0443:
        r4 = r4.edit();	 Catch:{ Throwable -> 0x045a }
        r6 = "tbs_preload_x5_counter";
        r4.putInt(r6, r5);	 Catch:{ Throwable -> 0x045a }
        r6 = "tbs_preload_x5_recorder";
        r4.putInt(r6, r5);	 Catch:{ Throwable -> 0x045a }
        r5 = "tbs_preload_x5_version";
        r4.putInt(r5, r3);	 Catch:{ Throwable -> 0x045a }
        r4.commit();	 Catch:{ Throwable -> 0x045a }
        goto L_0x0473;
    L_0x045a:
        r0 = move-exception;
        r3 = r0;
        r4 = "TbsInstaller";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04ea }
        r6 = "Init tbs_preload_x5_counter#2 exception:";
        r5.<init>(r6);	 Catch:{ Exception -> 0x04ea }
        r3 = android.util.Log.getStackTraceString(r3);	 Catch:{ Exception -> 0x04ea }
        r5.append(r3);	 Catch:{ Exception -> 0x04ea }
        r3 = r5.toString();	 Catch:{ Exception -> 0x04ea }
        com.tencent.smtt.utils.TbsLog.e(r4, r3);	 Catch:{ Exception -> 0x04ea }
    L_0x0473:
        com.tencent.smtt.utils.aa.a(r21);	 Catch:{ Exception -> 0x04ea }
        goto L_0x04d9;
    L_0x0477:
        r0 = move-exception;
        r3 = r0;
        r4 = r5;
    L_0x047a:
        if (r4 == 0) goto L_0x0484;
    L_0x047c:
        r4.close();	 Catch:{ IOException -> 0x0480 }
        goto L_0x0484;
    L_0x0480:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x04ea }
    L_0x0484:
        throw r3;	 Catch:{ Exception -> 0x04ea }
    L_0x0485:
        r4 = "TbsInstaller";
        r5 = "TbsInstaller-copyTbsCoreInThread fail!";
        com.tencent.smtt.utils.TbsLog.i(r4, r5);	 Catch:{ Exception -> 0x04ea }
        r4 = com.tencent.smtt.sdk.af.a(r21);	 Catch:{ Exception -> 0x04ea }
        r5 = 2;
        r4.a(r3, r5);	 Catch:{ Exception -> 0x04ea }
        r3 = 0;
        com.tencent.smtt.utils.k.a(r8, r3);	 Catch:{ Exception -> 0x04ea }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r20);	 Catch:{ Exception -> 0x04ea }
        r4 = -534; // 0xfffffffffffffdea float:NaN double:NaN;
        r3.setInstallInterruptCode(r4);	 Catch:{ Exception -> 0x04ea }
        r3 = com.tencent.smtt.sdk.TbsLogReport.a(r21);	 Catch:{ Exception -> 0x04ea }
        r4 = 212; // 0xd4 float:2.97E-43 double:1.047E-321;
        r5 = "copy fail!";
        r3.a(r4, r5);	 Catch:{ Exception -> 0x04ea }
        goto L_0x04d9;
    L_0x04ad:
        if (r4 != 0) goto L_0x04c3;
    L_0x04af:
        r3 = com.tencent.smtt.sdk.TbsLogReport.a(r21);	 Catch:{ Exception -> 0x04ea }
        r4 = "src-dir is null when copying tbs core!";
        r5 = 213; // 0xd5 float:2.98E-43 double:1.05E-321;
        r3.a(r5, r4);	 Catch:{ Exception -> 0x04ea }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r20);	 Catch:{ Exception -> 0x04ea }
        r4 = -535; // 0xfffffffffffffde9 float:NaN double:NaN;
        r3.setInstallInterruptCode(r4);	 Catch:{ Exception -> 0x04ea }
    L_0x04c3:
        if (r8 != 0) goto L_0x04d9;
    L_0x04c5:
        r3 = com.tencent.smtt.sdk.TbsLogReport.a(r21);	 Catch:{ Exception -> 0x04ea }
        r4 = 214; // 0xd6 float:3.0E-43 double:1.057E-321;
        r5 = "dst-dir is null when copying tbs core!";
        r3.a(r4, r5);	 Catch:{ Exception -> 0x04ea }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r20);	 Catch:{ Exception -> 0x04ea }
        r4 = -536; // 0xfffffffffffffde8 float:NaN double:NaN;
        r3.setInstallInterruptCode(r4);	 Catch:{ Exception -> 0x04ea }
    L_0x04d9:
        r2 = h;
        r2.unlock();
        r2 = i;
        r2.unlock();
        r19.b();
        return;
    L_0x04e7:
        r0 = move-exception;
        r2 = r0;
        goto L_0x0510;
    L_0x04ea:
        r0 = move-exception;
        r3 = r0;
        r2 = com.tencent.smtt.sdk.TbsLogReport.a(r21);	 Catch:{ all -> 0x04e7 }
        r4 = 215; // 0xd7 float:3.01E-43 double:1.06E-321;
        r3 = r3.toString();	 Catch:{ all -> 0x04e7 }
        r2.a(r4, r3);	 Catch:{ all -> 0x04e7 }
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r20);	 Catch:{ all -> 0x04e7 }
        r3 = -537; // 0xfffffffffffffde7 float:NaN double:NaN;
        r2.setInstallInterruptCode(r3);	 Catch:{ all -> 0x04e7 }
        r2 = h;
        r2.unlock();
        r2 = i;
        r2.unlock();
        r19.b();
        return;
    L_0x0510:
        r3 = h;
        r3.unlock();
        r3 = i;
        r3.unlock();
        r19.b();
        throw r2;
    L_0x051e:
        r19.b();
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r20);
        r3 = -538; // 0xfffffffffffffde6 float:NaN double:NaN;
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.aj.a(android.content.Context, android.content.Context, int):void");
    }

    private boolean a(Context context, File file) {
        return a(context, file, false);
    }

    private boolean a(android.content.Context r10, java.io.File r11, boolean r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-unzipTbs start";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        r0 = com.tencent.smtt.utils.k.c(r11);
        r1 = 0;
        if (r0 != 0) goto L_0x0023;
    L_0x000e:
        r11 = com.tencent.smtt.sdk.TbsLogReport.a(r10);
        r12 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
        r0 = "apk is invalid!";
        r11.a(r12, r0);
        r10 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r10);
        r11 = -520; // 0xfffffffffffffdf8 float:NaN double:NaN;
    L_0x001f:
        r10.setInstallInterruptCode(r11);
        return r1;
    L_0x0023:
        r0 = 1;
        r2 = "tbs";	 Catch:{ Throwable -> 0x0053 }
        r2 = r10.getDir(r2, r1);	 Catch:{ Throwable -> 0x0053 }
        if (r12 == 0) goto L_0x0034;	 Catch:{ Throwable -> 0x0053 }
    L_0x002c:
        r3 = new java.io.File;	 Catch:{ Throwable -> 0x0053 }
        r4 = "core_share_decouple";	 Catch:{ Throwable -> 0x0053 }
        r3.<init>(r2, r4);	 Catch:{ Throwable -> 0x0053 }
        goto L_0x003b;	 Catch:{ Throwable -> 0x0053 }
    L_0x0034:
        r3 = new java.io.File;	 Catch:{ Throwable -> 0x0053 }
        r4 = "core_unzip_tmp";	 Catch:{ Throwable -> 0x0053 }
        r3.<init>(r2, r4);	 Catch:{ Throwable -> 0x0053 }
    L_0x003b:
        r2 = r3.exists();	 Catch:{ Throwable -> 0x0053 }
        if (r2 == 0) goto L_0x006b;	 Catch:{ Throwable -> 0x0053 }
    L_0x0041:
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r10);	 Catch:{ Throwable -> 0x0053 }
        r2 = r2.mPreferences;	 Catch:{ Throwable -> 0x0053 }
        r4 = "tbs_downloaddecouplecore";	 Catch:{ Throwable -> 0x0053 }
        r2 = r2.getInt(r4, r1);	 Catch:{ Throwable -> 0x0053 }
        if (r2 == r0) goto L_0x006b;	 Catch:{ Throwable -> 0x0053 }
    L_0x004f:
        com.tencent.smtt.utils.k.b(r3);	 Catch:{ Throwable -> 0x0053 }
        goto L_0x006b;
    L_0x0053:
        r2 = move-exception;
        r3 = "TbsInstaller";
        r4 = new java.lang.StringBuilder;
        r5 = "TbsInstaller-unzipTbs -- delete unzip folder if exists exception";
        r4.<init>(r5);
        r2 = android.util.Log.getStackTraceString(r2);
        r4.append(r2);
        r2 = r4.toString();
        com.tencent.smtt.utils.TbsLog.e(r3, r2);
    L_0x006b:
        if (r12 == 0) goto L_0x0072;
    L_0x006d:
        r2 = r9.q(r10);
        goto L_0x0076;
    L_0x0072:
        r2 = r9.p(r10);
    L_0x0076:
        if (r2 != 0) goto L_0x008a;
    L_0x0078:
        r11 = com.tencent.smtt.sdk.TbsLogReport.a(r10);
        r12 = 205; // 0xcd float:2.87E-43 double:1.013E-321;
        r0 = "tmp unzip dir is null!";
        r11.a(r12, r0);
        r10 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r10);
        r11 = -521; // 0xfffffffffffffdf7 float:NaN double:NaN;
        goto L_0x001f;
    L_0x008a:
        r3 = -523; // 0xfffffffffffffdf5 float:NaN double:NaN;
        com.tencent.smtt.utils.k.a(r2);	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        if (r12 == 0) goto L_0x0094;	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
    L_0x0091:
        com.tencent.smtt.utils.k.a(r2, r0);	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
    L_0x0094:
        r11 = com.tencent.smtt.utils.k.a(r11, r2);	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        if (r12 == 0) goto L_0x00c9;	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
    L_0x009a:
        r4 = r2.list();	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        r5 = r1;	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
    L_0x009f:
        r6 = r4.length;	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        if (r5 >= r6) goto L_0x00bb;	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
    L_0x00a2:
        r6 = new java.io.File;	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        r7 = r4[r5];	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        r6.<init>(r2, r7);	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        r7 = r6.getName();	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        r8 = ".dex";	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        r7 = r7.endsWith(r8);	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        if (r7 == 0) goto L_0x00b8;	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
    L_0x00b5:
        r6.delete();	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
    L_0x00b8:
        r5 = r5 + 1;
        goto L_0x009f;
    L_0x00bb:
        r4 = o(r10);	 Catch:{ Exception -> 0x00c9, IOException -> 0x0166 }
        r5 = new java.io.File;	 Catch:{ Exception -> 0x00c9, IOException -> 0x0166 }
        r6 = "x5.tbs";	 Catch:{ Exception -> 0x00c9, IOException -> 0x0166 }
        r5.<init>(r4, r6);	 Catch:{ Exception -> 0x00c9, IOException -> 0x0166 }
        r5.delete();	 Catch:{ Exception -> 0x00c9, IOException -> 0x0166 }
    L_0x00c9:
        if (r11 != 0) goto L_0x00ef;
    L_0x00cb:
        com.tencent.smtt.utils.k.b(r2);	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        r12 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r10);	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        r4 = -522; // 0xfffffffffffffdf6 float:NaN double:NaN;	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        r12.setInstallInterruptCode(r4);	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        r12 = "TbsInstaller";	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        r5 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#1! exist:";	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        r4.<init>(r5);	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        r5 = r2.exists();	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        r4.append(r5);	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        r4 = r4.toString();	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        com.tencent.smtt.utils.TbsLog.e(r12, r4);	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        goto L_0x0101;	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
    L_0x00ef:
        r9.f(r10, r0);	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        if (r12 == 0) goto L_0x0101;	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
    L_0x00f4:
        r12 = r9.l(r10);	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        com.tencent.smtt.utils.k.a(r12, r0);	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        r2.renameTo(r12);	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
        com.tencent.smtt.sdk.TbsShareManager.b(r10);	 Catch:{ IOException -> 0x0166, Exception -> 0x010c }
    L_0x0101:
        r10 = "TbsInstaller";
        r12 = "TbsInstaller-unzipTbs done";
        com.tencent.smtt.utils.TbsLog.i(r10, r12);
        return r11;
    L_0x0109:
        r10 = move-exception;
        goto L_0x01c0;
    L_0x010c:
        r11 = move-exception;
        r12 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r10);	 Catch:{ all -> 0x0109 }
        r12.setInstallInterruptCode(r3);	 Catch:{ all -> 0x0109 }
        r10 = com.tencent.smtt.sdk.TbsLogReport.a(r10);	 Catch:{ all -> 0x0109 }
        r12 = 207; // 0xcf float:2.9E-43 double:1.023E-321;	 Catch:{ all -> 0x0109 }
        r10.a(r12, r11);	 Catch:{ all -> 0x0109 }
        if (r2 == 0) goto L_0x0126;	 Catch:{ all -> 0x0109 }
    L_0x011f:
        r10 = r2.exists();	 Catch:{ all -> 0x0109 }
        if (r10 == 0) goto L_0x0126;
    L_0x0125:
        goto L_0x0127;
    L_0x0126:
        r0 = r1;
    L_0x0127:
        if (r0 == 0) goto L_0x015e;
    L_0x0129:
        if (r2 == 0) goto L_0x015e;
    L_0x012b:
        com.tencent.smtt.utils.k.b(r2);	 Catch:{ Throwable -> 0x0146 }
        r10 = "TbsInstaller";	 Catch:{ Throwable -> 0x0146 }
        r11 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0146 }
        r12 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:";	 Catch:{ Throwable -> 0x0146 }
        r11.<init>(r12);	 Catch:{ Throwable -> 0x0146 }
        r12 = r2.exists();	 Catch:{ Throwable -> 0x0146 }
        r11.append(r12);	 Catch:{ Throwable -> 0x0146 }
        r11 = r11.toString();	 Catch:{ Throwable -> 0x0146 }
        com.tencent.smtt.utils.TbsLog.e(r10, r11);	 Catch:{ Throwable -> 0x0146 }
        goto L_0x015e;
    L_0x0146:
        r10 = move-exception;
        r11 = "TbsInstaller";
        r12 = new java.lang.StringBuilder;
        r0 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:";
        r12.<init>(r0);
        r10 = android.util.Log.getStackTraceString(r10);
        r12.append(r10);
        r10 = r12.toString();
        com.tencent.smtt.utils.TbsLog.e(r11, r10);
    L_0x015e:
        r10 = "TbsInstaller";
        r11 = "TbsInstaller-unzipTbs done";
        com.tencent.smtt.utils.TbsLog.i(r10, r11);
        return r1;
    L_0x0166:
        r11 = move-exception;
        r12 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r10);	 Catch:{ all -> 0x0109 }
        r12.setInstallInterruptCode(r3);	 Catch:{ all -> 0x0109 }
        r10 = com.tencent.smtt.sdk.TbsLogReport.a(r10);	 Catch:{ all -> 0x0109 }
        r12 = 206; // 0xce float:2.89E-43 double:1.02E-321;	 Catch:{ all -> 0x0109 }
        r10.a(r12, r11);	 Catch:{ all -> 0x0109 }
        if (r2 == 0) goto L_0x0180;	 Catch:{ all -> 0x0109 }
    L_0x0179:
        r10 = r2.exists();	 Catch:{ all -> 0x0109 }
        if (r10 == 0) goto L_0x0180;
    L_0x017f:
        goto L_0x0181;
    L_0x0180:
        r0 = r1;
    L_0x0181:
        if (r0 == 0) goto L_0x01b8;
    L_0x0183:
        if (r2 == 0) goto L_0x01b8;
    L_0x0185:
        com.tencent.smtt.utils.k.b(r2);	 Catch:{ Throwable -> 0x01a0 }
        r10 = "TbsInstaller";	 Catch:{ Throwable -> 0x01a0 }
        r11 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01a0 }
        r12 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:";	 Catch:{ Throwable -> 0x01a0 }
        r11.<init>(r12);	 Catch:{ Throwable -> 0x01a0 }
        r12 = r2.exists();	 Catch:{ Throwable -> 0x01a0 }
        r11.append(r12);	 Catch:{ Throwable -> 0x01a0 }
        r11 = r11.toString();	 Catch:{ Throwable -> 0x01a0 }
        com.tencent.smtt.utils.TbsLog.e(r10, r11);	 Catch:{ Throwable -> 0x01a0 }
        goto L_0x01b8;
    L_0x01a0:
        r10 = move-exception;
        r11 = "TbsInstaller";
        r12 = new java.lang.StringBuilder;
        r0 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:";
        r12.<init>(r0);
        r10 = android.util.Log.getStackTraceString(r10);
        r12.append(r10);
        r10 = r12.toString();
        com.tencent.smtt.utils.TbsLog.e(r11, r10);
    L_0x01b8:
        r10 = "TbsInstaller";
        r11 = "TbsInstaller-unzipTbs done";
        com.tencent.smtt.utils.TbsLog.i(r10, r11);
        return r1;
    L_0x01c0:
        r11 = "TbsInstaller";
        r12 = "TbsInstaller-unzipTbs done";
        com.tencent.smtt.utils.TbsLog.i(r11, r12);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.aj.a(android.content.Context, java.io.File, boolean):boolean");
    }

    @TargetApi(11)
    private void b(Context context, String str, int i) {
        aj ajVar = this;
        Context context2 = context;
        String str2 = str;
        int i2 = i;
        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-501);
        if (c(context)) {
            TbsLog.i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-502);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("TbsInstaller-installTbsCoreInThread tbsApkPath=");
        stringBuilder.append(str2);
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        stringBuilder = new StringBuilder("TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=");
        stringBuilder.append(i2);
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        stringBuilder = new StringBuilder("TbsInstaller-continueInstallTbsCore currentProcessName=");
        stringBuilder.append(context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        stringBuilder = new StringBuilder("TbsInstaller-installTbsCoreInThread currentProcessId=");
        stringBuilder.append(Process.myPid());
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        stringBuilder = new StringBuilder("TbsInstaller-installTbsCoreInThread currentThreadName=");
        stringBuilder.append(Thread.currentThread().getName());
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        if ((VERSION.SDK_INT >= 11 ? context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).getInt("tbs_precheck_disable_version", -1) == i2) {
            StringBuilder stringBuilder2 = new StringBuilder("TbsInstaller-installTbsCoreInThread -- version:");
            stringBuilder2.append(i2);
            stringBuilder2.append(" is disabled by preload_x5_check!");
            TbsLog.e("TbsInstaller", stringBuilder2.toString());
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-503);
        } else if (!k.b(context)) {
            long a = aa.a();
            long downloadMinFreeSpace = TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-504);
            TbsLogReport a2 = TbsLogReport.a(context);
            r8 = new StringBuilder("rom is not enough when installing tbs core! curAvailROM=");
            r8.append(a);
            r8.append(",minReqRom=");
            r8.append(downloadMinFreeSpace);
            a2.a(210, r8.toString());
        } else if (s(context)) {
            boolean tryLock = i.tryLock();
            StringBuilder stringBuilder3 = new StringBuilder("TbsInstaller-installTbsCoreInThread locked =");
            stringBuilder3.append(tryLock);
            TbsLog.i("TbsInstaller", stringBuilder3.toString());
            if (tryLock) {
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-507);
                h.lock();
                try {
                    boolean z;
                    int b;
                    int c = af.a(context).c("copy_core_ver");
                    int b2 = af.a(context).b();
                    StringBuilder stringBuilder4 = new StringBuilder("TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =");
                    stringBuilder4.append(c);
                    TbsLog.i("TbsInstaller", stringBuilder4.toString());
                    stringBuilder4 = new StringBuilder("TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =");
                    stringBuilder4.append(b2);
                    TbsLog.i("TbsInstaller", stringBuilder4.toString());
                    stringBuilder4 = new StringBuilder("TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =");
                    stringBuilder4.append(i2);
                    TbsLog.i("TbsInstaller", stringBuilder4.toString());
                    if ((b2 > 0 && i2 > b2) || (c > 0 && i2 > c)) {
                        k(context);
                    }
                    c = af.a(context).c();
                    b2 = g(context);
                    stringBuilder4 = new StringBuilder("TbsInstaller-installTbsCoreInThread installStatus1=");
                    stringBuilder4.append(c);
                    TbsLog.i("TbsInstaller", stringBuilder4.toString());
                    stringBuilder4 = new StringBuilder("TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=");
                    stringBuilder4.append(b2);
                    TbsLog.i("TbsInstaller", stringBuilder4.toString());
                    if (c >= 0 && c < 2) {
                        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
                        z = true;
                    } else if (c != 3 || b2 <= 0 || (i2 <= b2 && i2 != 88888888)) {
                        z = false;
                    } else {
                        k(context);
                        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
                        z = false;
                        c = -1;
                    }
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-508);
                    StringBuilder stringBuilder5 = new StringBuilder("TbsInstaller-installTbsCoreInThread installStatus2=");
                    stringBuilder5.append(c);
                    TbsLog.i("TbsInstaller", stringBuilder5.toString());
                    String d;
                    if (c <= 0) {
                        int c2;
                        TbsLog.i("TbsInstaller", "STEP 2/2 begin installation.....", true);
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-509);
                        if (z) {
                            c2 = af.a(context).c("unzip_retry_num");
                            if (c2 > 10) {
                                TbsLogReport.a(context).a(201, "exceed unzip retry num!");
                                z(context);
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-510);
                                h.unlock();
                                i.unlock();
                                b();
                                return;
                            }
                            af.a(context).b(c2 + 1);
                        }
                        if (str2 == null) {
                            d = af.a(context).d("install_apk_path");
                            if (d == null) {
                                TbsLogReport.a(context).a(202, "apk path is null!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-511);
                                h.unlock();
                                i.unlock();
                                b();
                                return;
                            }
                        }
                        d = str2;
                        stringBuilder3 = new StringBuilder("TbsInstaller-installTbsCoreInThread apkPath =");
                        stringBuilder3.append(d);
                        TbsLog.i("TbsInstaller", stringBuilder3.toString());
                        b = b(context2, d);
                        if (b == 0) {
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-512);
                            TbsLogReport.a(context).a(203, "apk version is 0!");
                            h.unlock();
                            i.unlock();
                            b();
                            return;
                        }
                        af.a(context).a("install_apk_path", d);
                        af.a(context).b(b, 0);
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-548);
                        if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                            if (!a(context2, new File(d), true)) {
                                TbsLogReport.a(context).a(207, "unzipTbsApk failed", EventType.TYPE_INSTALL_DECOUPLE);
                                h.unlock();
                                i.unlock();
                                b();
                                return;
                            }
                        } else if (!a(context2, new File(d))) {
                            TbsLogReport.a(context).a(207, "unzipTbsApk failed");
                            h.unlock();
                            i.unlock();
                            b();
                            return;
                        }
                        if (z) {
                            c2 = af.a(context).b("unlzma_status");
                            if (c2 > 5) {
                                TbsLogReport.a(context).a(223, "exceed unlzma retry num!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-553);
                                z(context);
                                ad.c(context);
                                TbsDownloadConfig.getInstance(context).a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                                TbsDownloadConfig.getInstance(context).a.put(TbsConfigKey.KEY_FULL_PACKAGE, Boolean.valueOf(true));
                                TbsDownloadConfig.getInstance(context).commit();
                                h.unlock();
                                i.unlock();
                                b();
                                return;
                            }
                            af.a(context).d(c2 + 1);
                        }
                        TbsLog.i("TbsInstaller", "unlzma begin");
                        c2 = TbsDownloadConfig.getInstance().mPreferences.getInt(TbsConfigKey.KEY_RESPONSECODE, 0);
                        if (g(context) != 0) {
                            Object a3 = QbSdk.a(context2, "can_unlzma", null);
                            boolean booleanValue = (a3 == null || !(a3 instanceof Boolean)) ? false : ((Boolean) a3).booleanValue();
                            if (booleanValue) {
                                String absolutePath;
                                TbsLogReport a4;
                                boolean z2;
                                Bundle bundle = new Bundle();
                                bundle.putInt("responseCode", c2);
                                if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                                    d = "unzip_temp_path";
                                    absolutePath = l(context).getAbsolutePath();
                                } else {
                                    d = "unzip_temp_path";
                                    absolutePath = p(context).getAbsolutePath();
                                }
                                bundle.putString(d, absolutePath);
                                Object a5 = QbSdk.a(context2, "unlzma", bundle);
                                if (a5 == null) {
                                    TbsLog.i("TbsInstaller", "unlzma return null");
                                    a4 = TbsLogReport.a(context);
                                    absolutePath = "unlzma is null";
                                } else {
                                    if (a5 instanceof Boolean) {
                                        if (((Boolean) a5).booleanValue()) {
                                            TbsLog.i("TbsInstaller", "unlzma success");
                                        } else {
                                            TbsLog.i("TbsInstaller", "unlzma return false");
                                            a4 = TbsLogReport.a(context);
                                            absolutePath = "unlzma return false";
                                        }
                                    } else if (!(a5 instanceof Bundle)) {
                                        if (a5 instanceof Throwable) {
                                            r8 = new StringBuilder("unlzma failure because Throwable");
                                            r8.append(Log.getStackTraceString((Throwable) a5));
                                            TbsLog.i("TbsInstaller", r8.toString());
                                            TbsLogReport.a(context).a(222, (Throwable) a5);
                                        }
                                        z2 = false;
                                        if (!z2) {
                                            h.unlock();
                                            i.unlock();
                                            b();
                                            return;
                                        }
                                    }
                                    z2 = true;
                                    if (z2) {
                                        h.unlock();
                                        i.unlock();
                                        b();
                                        return;
                                    }
                                }
                                a4.a(222, absolutePath);
                                z2 = false;
                                if (z2) {
                                    h.unlock();
                                    i.unlock();
                                    b();
                                    return;
                                }
                            }
                        }
                        TbsLog.i("TbsInstaller", "unlzma finished");
                        af.a(context).b(b, 1);
                    } else {
                        if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                            if (str2 == null) {
                                d = af.a(context).d("install_apk_path");
                                if (d == null) {
                                    TbsLogReport.a(context).a(202, "apk path is null!");
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-511);
                                    h.unlock();
                                    i.unlock();
                                    b();
                                    return;
                                }
                            }
                            d = str2;
                            a(context2, new File(d), true);
                        }
                        b = 0;
                    }
                    if (c < 2) {
                        if (z) {
                            c = af.a(context).c("dexopt_retry_num");
                            if (c > 10) {
                                TbsLogReport.a(context).a(208, "exceed dexopt retry num!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-514);
                                z(context);
                                h.unlock();
                                i.unlock();
                                b();
                                return;
                            }
                            af.a(context).a(c + 1);
                        }
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-549);
                        if (c(context2, 0)) {
                            TbsLogReport a6;
                            String str3;
                            af.a(context).b(b, 2);
                            TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
                            r8 = new StringBuilder("STEP 2/2 installation completed! you can restart! version:");
                            r8.append(i2);
                            TbsLog.i("TbsInstaller", r8.toString());
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-516);
                            Editor edit = (VERSION.SDK_INT >= 11 ? context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit();
                            edit.putInt("tbs_preload_x5_counter", 0);
                            edit.putInt("tbs_preload_x5_recorder", 0);
                            edit.putInt("tbs_preload_x5_version", i2);
                            edit.commit();
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-517);
                            if (i2 == 88888888) {
                                a(i2, str2, context2);
                            }
                            i2 = 221;
                            if (ajVar.j) {
                                a6 = TbsLogReport.a(context);
                                if (af.a(context).d() != 1) {
                                    i2 = 200;
                                }
                                str3 = "continueInstallWithout core success";
                            } else {
                                a6 = TbsLogReport.a(context);
                                if (af.a(context).d() != 1) {
                                    i2 = 200;
                                }
                                str3 = "success";
                            }
                            a6.a(i2, str3);
                        } else {
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-515);
                            h.unlock();
                            i.unlock();
                            b();
                            return;
                        }
                    } else if (c == 2) {
                        QbSdk.k.onInstallFinish(200);
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                    h.unlock();
                    i.unlock();
                    b();
                }
                h.unlock();
                i.unlock();
                b();
                return;
            }
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-519);
            b();
        } else {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-505);
        }
    }

    private boolean b(android.content.Context r10, java.io.File r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = 0;
        r1 = new com.tencent.smtt.sdk.aq;	 Catch:{ Exception -> 0x005d }
        r1.<init>(r9);	 Catch:{ Exception -> 0x005d }
        r1 = r11.listFiles(r1);	 Catch:{ Exception -> 0x005d }
        r2 = r1.length;	 Catch:{ Exception -> 0x005d }
        r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x005d }
        r4 = 16;	 Catch:{ Exception -> 0x005d }
        if (r3 >= r4) goto L_0x0028;	 Catch:{ Exception -> 0x005d }
    L_0x0011:
        r3 = r10.getPackageName();	 Catch:{ Exception -> 0x005d }
        if (r3 == 0) goto L_0x0028;	 Catch:{ Exception -> 0x005d }
    L_0x0017:
        r3 = r10.getPackageName();	 Catch:{ Exception -> 0x005d }
        r4 = "com.tencent.tbs";	 Catch:{ Exception -> 0x005d }
        r3 = r3.equalsIgnoreCase(r4);	 Catch:{ Exception -> 0x005d }
        if (r3 == 0) goto L_0x0028;
    L_0x0023:
        r3 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        java.lang.Thread.sleep(r3);	 Catch:{ Exception -> 0x0028 }
    L_0x0028:
        r3 = r10.getClassLoader();	 Catch:{ Exception -> 0x005d }
        r4 = r0;	 Catch:{ Exception -> 0x005d }
    L_0x002d:
        if (r4 >= r2) goto L_0x005b;	 Catch:{ Exception -> 0x005d }
    L_0x002f:
        r5 = "TbsInstaller";	 Catch:{ Exception -> 0x005d }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005d }
        r7 = "jarFile: ";	 Catch:{ Exception -> 0x005d }
        r6.<init>(r7);	 Catch:{ Exception -> 0x005d }
        r7 = r1[r4];	 Catch:{ Exception -> 0x005d }
        r7 = r7.getAbsolutePath();	 Catch:{ Exception -> 0x005d }
        r6.append(r7);	 Catch:{ Exception -> 0x005d }
        r6 = r6.toString();	 Catch:{ Exception -> 0x005d }
        com.tencent.smtt.utils.TbsLog.i(r5, r6);	 Catch:{ Exception -> 0x005d }
        r5 = new dalvik.system.DexClassLoader;	 Catch:{ Exception -> 0x005d }
        r6 = r1[r4];	 Catch:{ Exception -> 0x005d }
        r6 = r6.getAbsolutePath();	 Catch:{ Exception -> 0x005d }
        r7 = r11.getAbsolutePath();	 Catch:{ Exception -> 0x005d }
        r8 = 0;	 Catch:{ Exception -> 0x005d }
        r5.<init>(r6, r7, r8, r3);	 Catch:{ Exception -> 0x005d }
        r4 = r4 + 1;
        goto L_0x002d;
    L_0x005b:
        r10 = 1;
        return r10;
    L_0x005d:
        r11 = move-exception;
        r11.printStackTrace();
        r10 = com.tencent.smtt.sdk.TbsLogReport.a(r10);
        r1 = 209; // 0xd1 float:2.93E-43 double:1.033E-321;
        r11 = r11.toString();
        r10.a(r1, r11);
        r10 = "TbsInstaller";
        r11 = "TbsInstaller-doTbsDexOpt done";
        com.tencent.smtt.utils.TbsLog.i(r10, r11);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.aj.b(android.content.Context, java.io.File):boolean");
    }

    private boolean c(Context context, int i) {
        File p;
        boolean z;
        boolean z2;
        StringBuilder stringBuilder = new StringBuilder("TbsInstaller-doTbsDexOpt start - dirMode: ");
        stringBuilder.append(i);
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        boolean z3 = false;
        switch (i) {
            case 0:
                if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) != 1) {
                    p = p(context);
                    break;
                }
                return true;
            case 1:
                p = r(context);
                break;
            case 2:
                p = m(context);
                break;
            default:
                try {
                    String str = "TbsInstaller";
                    StringBuilder stringBuilder2 = new StringBuilder("doDexoptOrDexoat mode error: ");
                    stringBuilder2.append(i);
                    TbsLog.e(str, stringBuilder2.toString());
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                    TbsLogReport.a(context).a(209, e.toString());
                    TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
                    return true;
                }
        }
        try {
            str = System.getProperty("java.vm.version");
            if (str != null && str.startsWith("2")) {
                z = true;
                boolean z4 = VERSION.SDK_INT != 23;
                z2 = TbsDownloadConfig.getInstance(context).mPreferences.getBoolean(TbsConfigKey.KEY_STOP_PRE_OAT, false);
                if (z && z4 && !z2) {
                    z3 = true;
                }
                return (z3 || !c(context, p)) ? b(context, p) : true;
            }
        } catch (Throwable th) {
            TbsLogReport.a(context).a(226, th);
        }
        z = false;
        if (VERSION.SDK_INT != 23) {
        }
        z2 = TbsDownloadConfig.getInstance(context).mPreferences.getBoolean(TbsConfigKey.KEY_STOP_PRE_OAT, false);
        z3 = true;
        if (z3) {
        }
    }

    private boolean c(Context context, File file) {
        try {
            File file2 = new File(file, "tbs_sdk_extension_dex.jar");
            File file3 = new File(file, "tbs_sdk_extension_dex.dex");
            DexClassLoader dexClassLoader = new DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            Object a = c.a(context, file3.getAbsolutePath());
            if (TextUtils.isEmpty(a)) {
                TbsLogReport.a(context).a(226, "can not find oat command");
                return false;
            }
            for (File file4 : file.listFiles(new ar(this))) {
                String substring = file4.getName().substring(0, file4.getName().length() - 4);
                String replaceAll = a.replaceAll("tbs_sdk_extension_dex", substring);
                StringBuilder stringBuilder = new StringBuilder("/system/bin/dex2oat ");
                stringBuilder.append(replaceAll);
                stringBuilder.append(" --dex-location=");
                stringBuilder.append(a().m(context));
                stringBuilder.append(File.separator);
                stringBuilder.append(substring);
                stringBuilder.append(ShareConstants.JAR_SUFFIX);
                Runtime.getRuntime().exec(stringBuilder.toString()).waitFor();
            }
            return true;
        } catch (Throwable e) {
            e.printStackTrace();
            TbsLogReport.a(context).a(226, e);
            return false;
        }
    }

    private synchronized boolean c(Context context, boolean z) {
        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy");
        boolean z2 = false;
        try {
            if (!s(context)) {
                return false;
            }
            boolean tryLock = h.tryLock();
            StringBuilder stringBuilder = new StringBuilder("TbsInstaller-enableTbsCoreFromCopy Locked =");
            stringBuilder.append(tryLock);
            TbsLog.i("TbsInstaller", stringBuilder.toString());
            if (tryLock) {
                int b = af.a(context).b("copy_status");
                int a = a(false, context);
                StringBuilder stringBuilder2 = new StringBuilder("TbsInstaller-enableTbsCoreFromCopy copyStatus =");
                stringBuilder2.append(b);
                TbsLog.i("TbsInstaller", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder("TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer =");
                stringBuilder2.append(a);
                TbsLog.i("TbsInstaller", stringBuilder2.toString());
                if (b == 1) {
                    if (a == 0) {
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer = 0", true);
                    } else if (z) {
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer != 0", true);
                    }
                    v(context);
                    z2 = true;
                }
                h.unlock();
            }
            b();
        } catch (Throwable th) {
            TbsLogReport.a(context).a(215, th.toString());
            StringBuilder stringBuilder3 = new StringBuilder("TbsInstaller::enableTbsCoreFromCopy exception:");
            stringBuilder3.append(Log.getStackTraceString(th));
            QbSdk.a(context, stringBuilder3.toString());
        }
        return z2;
    }

    private Context d(Context context, int i) {
        StringBuilder stringBuilder = new StringBuilder("TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=");
        stringBuilder.append(i);
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        if (i <= 0) {
            return null;
        }
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        int i2 = 0;
        while (i2 < coreProviderAppList.length) {
            if (!context.getPackageName().equalsIgnoreCase(coreProviderAppList[i2]) && e(context, coreProviderAppList[i2])) {
                Context a = a(context, coreProviderAppList[i2]);
                if (a == null) {
                    continue;
                } else if (d(a)) {
                    int g = g(a);
                    StringBuilder stringBuilder2 = new StringBuilder("TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=");
                    stringBuilder2.append(g);
                    TbsLog.i("TbsInstaller", stringBuilder2.toString());
                    if (g != 0 && g == i) {
                        StringBuilder stringBuilder3 = new StringBuilder("TbsInstaller-getTbsCoreHostContext targetApp=");
                        stringBuilder3.append(coreProviderAppList[i2]);
                        TbsLog.i("TbsInstaller", stringBuilder3.toString());
                        return a;
                    }
                } else {
                    StringBuilder stringBuilder4 = new StringBuilder("TbsInstaller--getTbsCoreHostContext ");
                    stringBuilder4.append(coreProviderAppList[i2]);
                    stringBuilder4.append(" illegal signature go on next");
                    TbsLog.e("TbsInstaller", stringBuilder4.toString());
                }
            }
            i2++;
        }
        return null;
    }

    private static boolean d(Context context, String str) {
        File file = new File(context.getDir("tbs", 0), str);
        return file.exists() && new File(file, "tbs.conf").exists();
    }

    private synchronized boolean d(Context context, boolean z) {
        StringBuilder stringBuilder = new StringBuilder("TbsInstaller-enableTbsCoreFromUnzip canRenameTmpDir =");
        stringBuilder.append(z);
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        boolean z2 = false;
        try {
            if (!s(context)) {
                return false;
            }
            boolean tryLock = h.tryLock();
            StringBuilder stringBuilder2 = new StringBuilder("TbsInstaller-enableTbsCoreFromUnzip locked=");
            stringBuilder2.append(tryLock);
            TbsLog.i("TbsInstaller", stringBuilder2.toString());
            if (tryLock) {
                int c = af.a(context).c();
                stringBuilder2 = new StringBuilder("TbsInstaller-enableTbsCoreFromUnzip installStatus=");
                stringBuilder2.append(c);
                TbsLog.i("TbsInstaller", stringBuilder2.toString());
                int a = a(false, context);
                if (c == 2) {
                    if (a == 0) {
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
                    } else if (z) {
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
                    }
                    u(context);
                    z2 = true;
                }
                h.unlock();
            }
            b();
        } catch (Exception e) {
            stringBuilder = new StringBuilder("TbsInstaller::enableTbsCoreFromUnzip Exception: ");
            stringBuilder.append(e);
            QbSdk.a(context, stringBuilder.toString());
            e.printStackTrace();
        } catch (Throwable th) {
            h.unlock();
        }
        return z2;
    }

    private boolean e(android.content.Context r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = 0;
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x000a }
        r2 = r2.getPackageInfo(r3, r0);	 Catch:{ NameNotFoundException -> 0x000a }
        goto L_0x000b;
    L_0x000a:
        r2 = 0;
    L_0x000b:
        if (r2 == 0) goto L_0x000f;
    L_0x000d:
        r2 = 1;
        return r2;
    L_0x000f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.aj.e(android.content.Context, java.lang.String):boolean");
    }

    private synchronized boolean e(Context context, boolean z) {
        return false;
    }

    private void f(Context context, boolean z) {
        TbsLogReport a;
        String str;
        if (context == null) {
            a = TbsLogReport.a(context);
            str = "setTmpFolderCoreToRead context is null";
        } else {
            try {
                File file = new File(context.getDir("tbs", 0), "tmp_folder_core_to_read.conf");
                if (!z) {
                    k.b(file);
                } else if (!file.exists()) {
                    file.createNewFile();
                    return;
                }
                return;
            } catch (Exception e) {
                a = TbsLogReport.a(context);
                StringBuilder stringBuilder = new StringBuilder("setTmpFolderCoreToRead Exception message is ");
                stringBuilder.append(e.getMessage());
                stringBuilder.append(" Exception cause is ");
                stringBuilder.append(e.getCause());
                str = stringBuilder.toString();
            }
        }
        a.a(225, str);
    }

    static File o(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_private");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    private static boolean t(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 1;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = "tbs";	 Catch:{ Exception -> 0x001a }
        r2 = 0;	 Catch:{ Exception -> 0x001a }
        r4 = r4.getDir(r1, r2);	 Catch:{ Exception -> 0x001a }
        r1 = new java.io.File;	 Catch:{ Exception -> 0x001a }
        r3 = "tmp_folder_core_to_read.conf";	 Catch:{ Exception -> 0x001a }
        r1.<init>(r4, r3);	 Catch:{ Exception -> 0x001a }
        r4 = r1.exists();	 Catch:{ Exception -> 0x001a }
        if (r4 == 0) goto L_0x0019;
    L_0x0018:
        return r0;
    L_0x0019:
        return r2;
    L_0x001a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.aj.t(android.content.Context):boolean");
    }

    private void u(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
        if (bk.b().a() == null && bk.b().b(context) == null) {
            TbsLog.e("TbsInstaller", "generateNewTbsCoreFromUnzip -- failed to get rename fileLock#2!");
            return;
        }
        try {
            w(context);
            x(context);
            if (!TbsShareManager.isThirdPartyApp(context)) {
                TbsShareManager.a(context);
            }
            af.a(context).a(0);
            af.a(context).b(0);
            af.a(context).d(0);
            af.a(context).a("incrupdate_retry_num", 0);
            af.a(context).b(0, 3);
            af.a(context).a("");
            af.a(context).c(-1);
            if (!TbsShareManager.isThirdPartyApp(context)) {
                int i = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                if (i <= 0 || i == a().f(context) || i != a().g(context)) {
                    StringBuilder stringBuilder = new StringBuilder("TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is ");
                    stringBuilder.append(i);
                    stringBuilder.append(" getTbsCoreShareDecoupleCoreVersion is ");
                    stringBuilder.append(a().f(context));
                    stringBuilder.append(" getTbsCoreInstalledVerInNolock is ");
                    stringBuilder.append(a().g(context));
                    TbsLog.i("TbsInstaller", stringBuilder.toString());
                } else {
                    j(context);
                }
            }
            if (TbsShareManager.isThirdPartyApp(context)) {
                TbsShareManager.writeCoreInfoForThirdPartyApp(context, i(context), true);
            }
            a.set(Integer.valueOf(0));
        } catch (Throwable th) {
            th.printStackTrace();
            TbsLogReport a = TbsLogReport.a(context);
            StringBuilder stringBuilder2 = new StringBuilder("exception when renameing from unzip:");
            stringBuilder2.append(th.toString());
            a.a(219, stringBuilder2.toString());
            TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
        }
    }

    private void v(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
        if (bk.b().a() == null && bk.b().b(context) == null) {
            TbsLog.e("TbsInstaller", "generateNewTbsCoreFromCopy -- failed to get rename fileLock#2!");
            return;
        }
        try {
            w(context);
            y(context);
            TbsShareManager.a(context);
            af.a(context).a(0, 3);
            if (!TbsShareManager.isThirdPartyApp(context)) {
                int i = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                if (i <= 0 || i == a().f(context) || i != a().g(context)) {
                    StringBuilder stringBuilder = new StringBuilder("TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is ");
                    stringBuilder.append(i);
                    stringBuilder.append(" getTbsCoreShareDecoupleCoreVersion is ");
                    stringBuilder.append(a().f(context));
                    stringBuilder.append(" getTbsCoreInstalledVerInNolock is ");
                    stringBuilder.append(a().g(context));
                    TbsLog.i("TbsInstaller", stringBuilder.toString());
                } else {
                    j(context);
                }
            }
            a.set(Integer.valueOf(0));
        } catch (Exception e) {
            e.printStackTrace();
            TbsLogReport a = TbsLogReport.a(context);
            StringBuilder stringBuilder2 = new StringBuilder("exception when renameing from copy:");
            stringBuilder2.append(e.toString());
            a.a(219, stringBuilder2.toString());
        }
    }

    private void w(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
        k.a(m(context), false);
    }

    private void x(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
        File p = p(context);
        File m = m(context);
        if (p != null && m != null) {
            p.renameTo(m);
            f(context, false);
        }
    }

    private void y(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
        File r = r(context);
        File m = m(context);
        if (r != null && m != null) {
            r.renameTo(m);
            f(context, false);
        }
    }

    private void z(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
        File p = p(context);
        if (p != null) {
            k.a(p, false);
        }
        af.a(context).b(0, 5);
        af.a(context).c(-1);
        QbSdk.a(context, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
    }

    int a(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        r2 = new java.io.File;	 Catch:{ Exception -> 0x004f, all -> 0x0048 }
        r2.<init>(r5);	 Catch:{ Exception -> 0x004f, all -> 0x0048 }
        r5 = new java.io.File;	 Catch:{ Exception -> 0x004f, all -> 0x0048 }
        r3 = "tbs.conf";	 Catch:{ Exception -> 0x004f, all -> 0x0048 }
        r5.<init>(r2, r3);	 Catch:{ Exception -> 0x004f, all -> 0x0048 }
        r2 = r5.exists();	 Catch:{ Exception -> 0x004f, all -> 0x0048 }
        if (r2 != 0) goto L_0x0018;	 Catch:{ Exception -> 0x004f, all -> 0x0048 }
    L_0x0017:
        return r0;	 Catch:{ Exception -> 0x004f, all -> 0x0048 }
    L_0x0018:
        r2 = new java.util.Properties;	 Catch:{ Exception -> 0x004f, all -> 0x0048 }
        r2.<init>();	 Catch:{ Exception -> 0x004f, all -> 0x0048 }
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x004f, all -> 0x0048 }
        r3.<init>(r5);	 Catch:{ Exception -> 0x004f, all -> 0x0048 }
        r5 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x004f, all -> 0x0048 }
        r5.<init>(r3);	 Catch:{ Exception -> 0x004f, all -> 0x0048 }
        r2.load(r5);	 Catch:{ Exception -> 0x0050, all -> 0x0045 }
        r5.close();	 Catch:{ Exception -> 0x0050, all -> 0x0045 }
        r1 = "tbs_core_version";	 Catch:{ Exception -> 0x0050, all -> 0x0045 }
        r1 = r2.getProperty(r1);	 Catch:{ Exception -> 0x0050, all -> 0x0045 }
        if (r1 != 0) goto L_0x003b;
    L_0x0035:
        if (r5 == 0) goto L_0x003a;
    L_0x0037:
        r5.close();	 Catch:{ IOException -> 0x003a }
    L_0x003a:
        return r0;
    L_0x003b:
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ Exception -> 0x0050, all -> 0x0045 }
        if (r5 == 0) goto L_0x0044;
    L_0x0041:
        r5.close();	 Catch:{ IOException -> 0x0044 }
    L_0x0044:
        return r1;
    L_0x0045:
        r0 = move-exception;
        r1 = r5;
        goto L_0x0049;
    L_0x0048:
        r0 = move-exception;
    L_0x0049:
        if (r1 == 0) goto L_0x004e;
    L_0x004b:
        r1.close();	 Catch:{ IOException -> 0x004e }
    L_0x004e:
        throw r0;
    L_0x004f:
        r5 = r1;
    L_0x0050:
        if (r5 == 0) goto L_0x0055;
    L_0x0052:
        r5.close();	 Catch:{ IOException -> 0x0055 }
    L_0x0055:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.aj.a(java.lang.String):int");
    }

    public int a(boolean z, Context context) {
        if (z || ((Integer) a.get()).intValue() <= 0) {
            a.set(Integer.valueOf(g(context)));
        }
        return ((Integer) a.get()).intValue();
    }

    android.content.Context a(android.content.Context r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = 2;
        r2 = r2.createPackageContext(r3, r0);	 Catch:{ Exception -> 0x0006 }
        return r2;
    L_0x0006:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.aj.a(android.content.Context, java.lang.String):android.content.Context");
    }

    void a(Context context, Bundle bundle) {
        if (bundle != null && context != null) {
            Object obj = new Object[]{context, bundle};
            Message message = new Message();
            message.what = 3;
            message.obj = obj;
            k.sendMessage(message);
        }
    }

    void a(Context context, String str, int i) {
        StringBuilder stringBuilder = new StringBuilder("TbsInstaller-installTbsCore tbsApkPath=");
        stringBuilder.append(str);
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        stringBuilder = new StringBuilder("TbsInstaller-installTbsCore tbsCoreTargetVer=");
        stringBuilder.append(i);
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        stringBuilder = new StringBuilder("TbsInstaller-continueInstallTbsCore currentProcessName=");
        stringBuilder.append(context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        stringBuilder = new StringBuilder("TbsInstaller-installTbsCore currentProcessId=");
        stringBuilder.append(Process.myPid());
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        stringBuilder = new StringBuilder("TbsInstaller-installTbsCore currentThreadName=");
        stringBuilder.append(Thread.currentThread().getName());
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        Object obj = new Object[]{context, str, Integer.valueOf(i)};
        Message message = new Message();
        message.what = 1;
        message.obj = obj;
        k.sendMessage(message);
    }

    void a(Context context, boolean z) {
        int b;
        boolean z2 = true;
        if (z) {
            this.j = true;
        }
        StringBuilder stringBuilder = new StringBuilder("TbsInstaller-continueInstallTbsCore currentProcessName=");
        stringBuilder.append(context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        stringBuilder = new StringBuilder("TbsInstaller-continueInstallTbsCore currentProcessId=");
        stringBuilder.append(Process.myPid());
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        stringBuilder = new StringBuilder("TbsInstaller-continueInstallTbsCore currentThreadName=");
        stringBuilder.append(Thread.currentThread().getName());
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        if (s(context)) {
            int c;
            int b2;
            String tryLock = h.tryLock();
            int i = -1;
            if (tryLock == true) {
                try {
                    i = af.a(context).c();
                    b = af.a(context).b();
                    tryLock = af.a(context).d("install_apk_path");
                    c = af.a(context).c("copy_core_ver");
                    b2 = af.a(context).b("copy_status");
                } finally {
                    b = h;
                    b.unlock();
                }
            } else {
                tryLock = null;
                b2 = -1;
                b = 0;
                c = b;
            }
            b();
            StringBuilder stringBuilder2 = new StringBuilder("TbsInstaller-continueInstallTbsCore installStatus=");
            stringBuilder2.append(i);
            TbsLog.i("TbsInstaller", stringBuilder2.toString());
            stringBuilder2 = new StringBuilder("TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=");
            stringBuilder2.append(b);
            TbsLog.i("TbsInstaller", stringBuilder2.toString());
            stringBuilder2 = new StringBuilder("TbsInstaller-continueInstallTbsCore tbsApkPath=");
            stringBuilder2.append(tryLock);
            TbsLog.i("TbsInstaller", stringBuilder2.toString());
            stringBuilder2 = new StringBuilder("TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=");
            stringBuilder2.append(c);
            TbsLog.i("TbsInstaller", stringBuilder2.toString());
            stringBuilder2 = new StringBuilder("TbsInstaller-continueInstallTbsCore copyStatus=");
            stringBuilder2.append(b2);
            TbsLog.i("TbsInstaller", stringBuilder2.toString());
            if (TbsShareManager.isThirdPartyApp(context)) {
                b(context, TbsShareManager.a(context, false));
                return;
            }
            int i2 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_RESPONSECODE, 0);
            if (!(i2 == 1 || i2 == 2)) {
                if (i2 != 4) {
                    z2 = false;
                }
            }
            if (!(z2 || i2 == 0)) {
                Bundle bundle = new Bundle();
                bundle.putInt("operation", 10001);
                a(context, bundle);
            }
            if (i >= 0 && i < 2) {
                a(context, tryLock, b);
            }
            if (b2 == 0) {
                a(context, c);
            }
        }
    }

    boolean a(Context context, int i) {
        if (TbsDownloader.getOverSea(context)) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder("TbsInstaller-installLocalTbsCore targetTbsCoreVer=");
        stringBuilder.append(i);
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        stringBuilder = new StringBuilder("TbsInstaller-continueInstallTbsCore currentProcessName=");
        stringBuilder.append(context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        stringBuilder = new StringBuilder("TbsInstaller-installLocalTbsCore currentProcessId=");
        stringBuilder.append(Process.myPid());
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        stringBuilder = new StringBuilder("TbsInstaller-installLocalTbsCore currentThreadName=");
        stringBuilder.append(Thread.currentThread().getName());
        TbsLog.i("TbsInstaller", stringBuilder.toString());
        if (d(context, i) != null) {
            Object obj = new Object[]{d(context, i), context, Integer.valueOf(i)};
            Message message = new Message();
            message.what = 2;
            message.obj = obj;
            k.sendMessage(message);
            return true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
        return false;
    }

    public synchronized boolean a(Context context, Context context2) {
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp");
        if (m) {
            return true;
        }
        m = true;
        new am(this, context2, context).start();
        return true;
    }

    public boolean a(Context context, File[] fileArr) {
        return false;
    }

    int b(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        return packageArchiveInfo != null ? packageArchiveInfo.versionCode : 0;
    }

    File b(Context context, Context context2) {
        File file = new File(context2.getDir("tbs", 0), "core_share");
        return (file.isDirectory() || ((context != null && TbsShareManager.isThirdPartyApp(context)) || file.mkdir())) ? file : null;
    }

    synchronized void b() {
        int i = this.d;
        this.d = i - 1;
        if (i <= 1) {
            if (this.g) {
                TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
                k.a(this.e, this.f);
                this.g = false;
                return;
            }
        }
        TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
    }

    public void b(Context context) {
        f(context, true);
        af.a(context).b(f(context), 2);
    }

    void b(Context context, int i) {
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
        if (i > 0) {
            int g = g(context);
            if (g != i) {
                Context e = TbsShareManager.e(context);
                if (e == null) {
                    if (TbsShareManager.getHostCorePathAppDefined() == null) {
                        if (g <= 0) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
                            QbSdk.a(context, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
                        }
                        return;
                    }
                }
                TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
                a(context, e);
            }
        }
    }

    void b(Context context, Bundle bundle) {
        Throwable th;
        StringBuilder stringBuilder;
        TbsLogReport a;
        Bundle bundle2;
        StringBuilder stringBuilder2;
        if (c(context)) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-539);
            return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread");
        if (bundle != null && context != null) {
            if (!k.b(context)) {
                long a2 = aa.a();
                long downloadMinFreeSpace = TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
                TbsLogReport a3 = TbsLogReport.a(context);
                StringBuilder stringBuilder3 = new StringBuilder("rom is not enough when patching tbs core! curAvailROM=");
                stringBuilder3.append(a2);
                stringBuilder3.append(",minReqRom=");
                stringBuilder3.append(downloadMinFreeSpace);
                a3.a(210, stringBuilder3.toString());
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-540);
            } else if (s(context)) {
                boolean tryLock = i.tryLock();
                StringBuilder stringBuilder4 = new StringBuilder("TbsInstaller-installLocalTesCoreExInThread locked=");
                stringBuilder4.append(tryLock);
                TbsLog.i("TbsInstaller", stringBuilder4.toString());
                if (tryLock) {
                    Bundle bundle3 = null;
                    StringBuilder stringBuilder5;
                    try {
                        QbSdk.setTBSInstallingStatus(true);
                        if (g(context) > 0) {
                            if (af.a(context).d() != 1) {
                                boolean z;
                                Object string;
                                Object string2;
                                Object string3;
                                File o;
                                int i;
                                String string4;
                                int i2 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_RESPONSECODE, 0);
                                if (!(i2 == 1 || i2 == 2)) {
                                    if (i2 != 4) {
                                        z = false;
                                        if (!(z || i2 == 0)) {
                                            i2 = af.a(context).c("incrupdate_retry_num");
                                            if (i2 <= 5) {
                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread exceed incrupdate num");
                                                string = bundle.getString("old_apk_location");
                                                string2 = bundle.getString("new_apk_location");
                                                string3 = bundle.getString("diff_file_location");
                                                if (!TextUtils.isEmpty(string)) {
                                                    k.b(new File(string));
                                                }
                                                if (!TextUtils.isEmpty(string2)) {
                                                    k.b(new File(string2));
                                                }
                                                if (!TextUtils.isEmpty(string3)) {
                                                    k.b(new File(string3));
                                                }
                                                TbsDownloadConfig.getInstance(context).a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                                                TbsDownloadConfig.getInstance(context).commit();
                                                TbsLogReport.a(context).a(224, "incrUpdate exceed retry max num");
                                                i.unlock();
                                                b();
                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                                QbSdk.setTBSInstallingStatus(false);
                                                return;
                                            }
                                            af.a(context).a("incrupdate_retry_num", i2 + 1);
                                            o = o(context);
                                            if (o != null && new File(o, "x5.tbs").exists()) {
                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-550);
                                                bundle = QbSdk.a(context, bundle);
                                                if (bundle == null) {
                                                    try {
                                                    } catch (Throwable e) {
                                                        Throwable th2 = e;
                                                        bundle3 = bundle;
                                                        th = th2;
                                                        try {
                                                            stringBuilder = new StringBuilder("installLocalTbsCoreExInThread exception:");
                                                            stringBuilder.append(Log.getStackTraceString(th));
                                                            TbsLog.i("TbsInstaller", stringBuilder.toString());
                                                            th.printStackTrace();
                                                            try {
                                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                                                TbsLogReport.a(context).a(218, th.toString());
                                                                i.unlock();
                                                                b();
                                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                                                TbsDownloadConfig.getInstance(context).a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                                                                TbsDownloadConfig.getInstance(context).commit();
                                                                a = TbsLogReport.a(context);
                                                                stringBuilder5 = new StringBuilder("incrUpdate fail! patch ret=");
                                                                stringBuilder5.append(1);
                                                                a.a(217, stringBuilder5.toString());
                                                                QbSdk.setTBSInstallingStatus(false);
                                                                return;
                                                            } catch (Throwable th3) {
                                                                th = th3;
                                                                bundle2 = bundle3;
                                                                i = 1;
                                                                i.unlock();
                                                                b();
                                                                if (i != 0) {
                                                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                                                    af.a(context).a("incrupdate_retry_num", 0);
                                                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                                                    af.a(context).b(0, -1);
                                                                    af.a(context).c(1);
                                                                    string4 = bundle2.getString(ApkHelper.APK_PATH_PREF);
                                                                    ad.a(new File(string4), context);
                                                                    b(context, string4, bundle2.getInt("tbs_core_ver"));
                                                                } else if (i == 2) {
                                                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                                                } else {
                                                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                                                    TbsDownloadConfig.getInstance(context).a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                                                                    TbsDownloadConfig.getInstance(context).commit();
                                                                    a = TbsLogReport.a(context);
                                                                    stringBuilder2 = new StringBuilder("incrUpdate fail! patch ret=");
                                                                    stringBuilder2.append(i);
                                                                    a.a(217, stringBuilder2.toString());
                                                                }
                                                                QbSdk.setTBSInstallingStatus(false);
                                                                throw th;
                                                            }
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            bundle2 = bundle3;
                                                            i = 2;
                                                            i.unlock();
                                                            b();
                                                            if (i != 0) {
                                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                                                af.a(context).a("incrupdate_retry_num", 0);
                                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                                                af.a(context).b(0, -1);
                                                                af.a(context).c(1);
                                                                string4 = bundle2.getString(ApkHelper.APK_PATH_PREF);
                                                                ad.a(new File(string4), context);
                                                                b(context, string4, bundle2.getInt("tbs_core_ver"));
                                                            } else if (i == 2) {
                                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                                                TbsDownloadConfig.getInstance(context).a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                                                                TbsDownloadConfig.getInstance(context).commit();
                                                                a = TbsLogReport.a(context);
                                                                stringBuilder2 = new StringBuilder("incrUpdate fail! patch ret=");
                                                                stringBuilder2.append(i);
                                                                a.a(217, stringBuilder2.toString());
                                                            } else {
                                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                                            }
                                                            QbSdk.setTBSInstallingStatus(false);
                                                            throw th;
                                                        }
                                                    } catch (Throwable e2) {
                                                        bundle2 = bundle;
                                                        th = e2;
                                                        i = 2;
                                                        i.unlock();
                                                        b();
                                                        if (i != 0) {
                                                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                                            af.a(context).a("incrupdate_retry_num", 0);
                                                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                                            af.a(context).b(0, -1);
                                                            af.a(context).c(1);
                                                            string4 = bundle2.getString(ApkHelper.APK_PATH_PREF);
                                                            ad.a(new File(string4), context);
                                                            b(context, string4, bundle2.getInt("tbs_core_ver"));
                                                        } else if (i == 2) {
                                                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                                        } else {
                                                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                                            TbsDownloadConfig.getInstance(context).a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                                                            TbsDownloadConfig.getInstance(context).commit();
                                                            a = TbsLogReport.a(context);
                                                            stringBuilder2 = new StringBuilder("incrUpdate fail! patch ret=");
                                                            stringBuilder2.append(i);
                                                            a.a(217, stringBuilder2.toString());
                                                        }
                                                        QbSdk.setTBSInstallingStatus(false);
                                                        throw th;
                                                    }
                                                }
                                                i.unlock();
                                                b();
                                                if (i != 0) {
                                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                                    af.a(context).a("incrupdate_retry_num", 0);
                                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                                    af.a(context).b(0, -1);
                                                    af.a(context).c(1);
                                                    string4 = bundle.getString(ApkHelper.APK_PATH_PREF);
                                                    ad.a(new File(string4), context);
                                                    b(context, string4, bundle.getInt("tbs_core_ver"));
                                                } else if (i == 2) {
                                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                                } else {
                                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                                    TbsDownloadConfig.getInstance(context).a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                                                    TbsDownloadConfig.getInstance(context).commit();
                                                    a = TbsLogReport.a(context);
                                                    stringBuilder5 = new StringBuilder("incrUpdate fail! patch ret=");
                                                    stringBuilder5.append(i);
                                                    a.a(217, stringBuilder5.toString());
                                                }
                                                QbSdk.setTBSInstallingStatus(false);
                                                return;
                                            }
                                        }
                                        bundle = null;
                                        i = 2;
                                        i.unlock();
                                        b();
                                        if (i != 0) {
                                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                            af.a(context).a("incrupdate_retry_num", 0);
                                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                            af.a(context).b(0, -1);
                                            af.a(context).c(1);
                                            string4 = bundle.getString(ApkHelper.APK_PATH_PREF);
                                            ad.a(new File(string4), context);
                                            b(context, string4, bundle.getInt("tbs_core_ver"));
                                        } else if (i == 2) {
                                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                            TbsDownloadConfig.getInstance(context).a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                                            TbsDownloadConfig.getInstance(context).commit();
                                            a = TbsLogReport.a(context);
                                            stringBuilder5 = new StringBuilder("incrUpdate fail! patch ret=");
                                            stringBuilder5.append(i);
                                            a.a(217, stringBuilder5.toString());
                                        } else {
                                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                        }
                                        QbSdk.setTBSInstallingStatus(false);
                                        return;
                                    }
                                }
                                z = true;
                                i2 = af.a(context).c("incrupdate_retry_num");
                                if (i2 <= 5) {
                                    af.a(context).a("incrupdate_retry_num", i2 + 1);
                                    o = o(context);
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-550);
                                    bundle = QbSdk.a(context, bundle);
                                    i = bundle == null ? bundle.getInt("patch_result") : 1;
                                    i.unlock();
                                    b();
                                    if (i != 0) {
                                        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                        af.a(context).a("incrupdate_retry_num", 0);
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                        af.a(context).b(0, -1);
                                        af.a(context).c(1);
                                        string4 = bundle.getString(ApkHelper.APK_PATH_PREF);
                                        ad.a(new File(string4), context);
                                        b(context, string4, bundle.getInt("tbs_core_ver"));
                                    } else if (i == 2) {
                                        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                    } else {
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                        TbsDownloadConfig.getInstance(context).a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                                        TbsDownloadConfig.getInstance(context).commit();
                                        a = TbsLogReport.a(context);
                                        stringBuilder5 = new StringBuilder("incrUpdate fail! patch ret=");
                                        stringBuilder5.append(i);
                                        a.a(217, stringBuilder5.toString());
                                    }
                                    QbSdk.setTBSInstallingStatus(false);
                                    return;
                                }
                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread exceed incrupdate num");
                                string = bundle.getString("old_apk_location");
                                string2 = bundle.getString("new_apk_location");
                                string3 = bundle.getString("diff_file_location");
                                if (TextUtils.isEmpty(string)) {
                                    k.b(new File(string));
                                }
                                if (TextUtils.isEmpty(string2)) {
                                    k.b(new File(string2));
                                }
                                if (TextUtils.isEmpty(string3)) {
                                    k.b(new File(string3));
                                }
                                TbsDownloadConfig.getInstance(context).a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                                TbsDownloadConfig.getInstance(context).commit();
                                TbsLogReport.a(context).a(224, "incrUpdate exceed retry max num");
                                i.unlock();
                                b();
                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                QbSdk.setTBSInstallingStatus(false);
                                return;
                            }
                        }
                        QbSdk.setTBSInstallingStatus(false);
                        i.unlock();
                        b();
                        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                        QbSdk.setTBSInstallingStatus(false);
                        return;
                    } catch (Exception e3) {
                        th = e3;
                        stringBuilder = new StringBuilder("installLocalTbsCoreExInThread exception:");
                        stringBuilder.append(Log.getStackTraceString(th));
                        TbsLog.i("TbsInstaller", stringBuilder.toString());
                        th.printStackTrace();
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                        TbsLogReport.a(context).a(218, th.toString());
                        i.unlock();
                        b();
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                        TbsDownloadConfig.getInstance(context).a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                        TbsDownloadConfig.getInstance(context).commit();
                        a = TbsLogReport.a(context);
                        stringBuilder5 = new StringBuilder("incrUpdate fail! patch ret=");
                        stringBuilder5.append(1);
                        a.a(217, stringBuilder5.toString());
                        QbSdk.setTBSInstallingStatus(false);
                        return;
                    }
                }
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-547);
                b();
            } else {
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-541);
            }
        }
    }

    void b(android.content.Context r5, boolean r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = com.tencent.smtt.sdk.QbSdk.b;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 8;
        r2 = 1;
        if (r0 >= r1) goto L_0x0014;
    L_0x000c:
        r5 = "TbsInstaller";
        r6 = "android version < 2.1 no need install X5 core";
        com.tencent.smtt.utils.TbsLog.e(r5, r6, r2);
        return;
    L_0x0014:
        r0 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r5);	 Catch:{ Throwable -> 0x0038 }
        if (r0 != 0) goto L_0x0038;	 Catch:{ Throwable -> 0x0038 }
    L_0x001a:
        r0 = r4.q(r5);	 Catch:{ Throwable -> 0x0038 }
        if (r0 == 0) goto L_0x0038;	 Catch:{ Throwable -> 0x0038 }
    L_0x0020:
        r1 = r0.exists();	 Catch:{ Throwable -> 0x0038 }
        if (r1 == 0) goto L_0x0038;	 Catch:{ Throwable -> 0x0038 }
    L_0x0026:
        r1 = 0;	 Catch:{ Throwable -> 0x0038 }
        com.tencent.smtt.utils.k.a(r0, r1);	 Catch:{ Throwable -> 0x0038 }
        r0 = o(r5);	 Catch:{ Throwable -> 0x0038 }
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x0038 }
        r3 = "x5.tbs";	 Catch:{ Throwable -> 0x0038 }
        r1.<init>(r0, r3);	 Catch:{ Throwable -> 0x0038 }
        r1.delete();	 Catch:{ Throwable -> 0x0038 }
    L_0x0038:
        r0 = t(r5);
        if (r0 == 0) goto L_0x0087;
    L_0x003e:
        r0 = "core_unzip_tmp";
        r0 = d(r5, r0);
        if (r0 == 0) goto L_0x0054;
    L_0x0046:
        r0 = r4.d(r5, r6);
        if (r0 == 0) goto L_0x0054;
    L_0x004c:
        r5 = "TbsInstaller";
        r6 = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!";
        com.tencent.smtt.utils.TbsLog.i(r5, r6, r2);
        return;
    L_0x0054:
        r0 = "core_share_backup_tmp";
        r0 = d(r5, r0);
        if (r0 == 0) goto L_0x006a;
    L_0x005c:
        r0 = r4.e(r5, r6);
        if (r0 == 0) goto L_0x006a;
    L_0x0062:
        r5 = "TbsInstaller";
        r6 = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromBackup!!";
        com.tencent.smtt.utils.TbsLog.i(r5, r6, r2);
        return;
    L_0x006a:
        r0 = "core_copy_tmp";
        r0 = d(r5, r0);
        if (r0 == 0) goto L_0x0080;
    L_0x0072:
        r5 = r4.c(r5, r6);
        if (r5 == 0) goto L_0x0080;
    L_0x0078:
        r5 = "TbsInstaller";
        r6 = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!";
        com.tencent.smtt.utils.TbsLog.i(r5, r6, r2);
        return;
    L_0x0080:
        r5 = "TbsInstaller";
        r6 = "TbsInstaller-installTbsCoreIfNeeded, error !!";
        com.tencent.smtt.utils.TbsLog.i(r5, r6, r2);
    L_0x0087:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.aj.b(android.content.Context, boolean):void");
    }

    File c(Context context, Context context2) {
        File file = new File(context2.getDir("tbs", 0), "core_share_decouple");
        return (file.isDirectory() || ((context != null && TbsShareManager.isThirdPartyApp(context)) || file.mkdir())) ? file : null;
    }

    public java.lang.String c(android.content.Context r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = android.text.TextUtils.isEmpty(r5);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r4 = r3.m(r4);	 Catch:{ Exception -> 0x0043, all -> 0x003c }
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0043, all -> 0x003c }
        r2 = "tbs.conf";	 Catch:{ Exception -> 0x0043, all -> 0x003c }
        r0.<init>(r4, r2);	 Catch:{ Exception -> 0x0043, all -> 0x003c }
        r4 = r0.exists();	 Catch:{ Exception -> 0x0043, all -> 0x003c }
        if (r4 != 0) goto L_0x001a;	 Catch:{ Exception -> 0x0043, all -> 0x003c }
    L_0x0019:
        return r1;	 Catch:{ Exception -> 0x0043, all -> 0x003c }
    L_0x001a:
        r4 = new java.util.Properties;	 Catch:{ Exception -> 0x0043, all -> 0x003c }
        r4.<init>();	 Catch:{ Exception -> 0x0043, all -> 0x003c }
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0043, all -> 0x003c }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0043, all -> 0x003c }
        r0 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0043, all -> 0x003c }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0043, all -> 0x003c }
        r4.load(r0);	 Catch:{ Exception -> 0x0044, all -> 0x0039 }
        r0.close();	 Catch:{ Exception -> 0x0044, all -> 0x0039 }
        r4 = r4.getProperty(r5);	 Catch:{ Exception -> 0x0044, all -> 0x0039 }
        if (r0 == 0) goto L_0x0038;
    L_0x0035:
        r0.close();	 Catch:{ IOException -> 0x0038 }
    L_0x0038:
        return r4;
    L_0x0039:
        r4 = move-exception;
        r1 = r0;
        goto L_0x003d;
    L_0x003c:
        r4 = move-exception;
    L_0x003d:
        if (r1 == 0) goto L_0x0042;
    L_0x003f:
        r1.close();	 Catch:{ IOException -> 0x0042 }
    L_0x0042:
        throw r4;
    L_0x0043:
        r0 = r1;
    L_0x0044:
        if (r0 == 0) goto L_0x0049;
    L_0x0046:
        r0.close();	 Catch:{ IOException -> 0x0049 }
    L_0x0049:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.aj.c(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean c(android.content.Context r12) {
        /*
        r11 = this;
        r12 = r11.m(r12);
        r0 = new java.io.File;
        r1 = "tbs.conf";
        r0.<init>(r12, r1);
        r12 = r0.exists();
        r1 = 0;
        if (r12 != 0) goto L_0x0013;
    L_0x0012:
        return r1;
    L_0x0013:
        r12 = new java.util.Properties;
        r12.<init>();
        r2 = 0;
        r3 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x007e }
        r3.<init>(r0);	 Catch:{ Throwable -> 0x007e }
        r4 = new java.io.BufferedInputStream;	 Catch:{ Throwable -> 0x007e }
        r4.<init>(r3);	 Catch:{ Throwable -> 0x007e }
        r12.load(r4);	 Catch:{ Throwable -> 0x0077, all -> 0x0075 }
        r2 = "tbs_local_installation";
        r3 = "false";
        r12 = r12.getProperty(r2, r3);	 Catch:{ Throwable -> 0x0077, all -> 0x0075 }
        r12 = java.lang.Boolean.valueOf(r12);	 Catch:{ Throwable -> 0x0077, all -> 0x0075 }
        r12 = r12.booleanValue();	 Catch:{ Throwable -> 0x0077, all -> 0x0075 }
        r2 = 1;
        if (r12 == 0) goto L_0x004e;
    L_0x0039:
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x004c, all -> 0x0075 }
        r7 = r0.lastModified();	 Catch:{ Throwable -> 0x004c, all -> 0x0075 }
        r9 = r5 - r7;
        r5 = 259200000; // 0xf731400 float:1.1984677E-29 double:1.280618154E-315;
        r0 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1));
        if (r0 <= 0) goto L_0x004e;
    L_0x004a:
        r1 = r2;
        goto L_0x004e;
    L_0x004c:
        r0 = move-exception;
        goto L_0x0079;
    L_0x004e:
        r0 = "TbsInstaller";
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x004c, all -> 0x0075 }
        r5 = "TBS_LOCAL_INSTALLATION is:";
        r3.<init>(r5);	 Catch:{ Throwable -> 0x004c, all -> 0x0075 }
        r3.append(r12);	 Catch:{ Throwable -> 0x004c, all -> 0x0075 }
        r5 = " expired=";
        r3.append(r5);	 Catch:{ Throwable -> 0x004c, all -> 0x0075 }
        r3.append(r1);	 Catch:{ Throwable -> 0x004c, all -> 0x0075 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x004c, all -> 0x0075 }
        com.tencent.smtt.utils.TbsLog.i(r0, r3);	 Catch:{ Throwable -> 0x004c, all -> 0x0075 }
        r0 = r1 ^ 1;
        r12 = r12 & r0;
        r4.close();	 Catch:{ IOException -> 0x0070 }
        return r12;
    L_0x0070:
        r0 = move-exception;
        r0.printStackTrace();
        return r12;
    L_0x0075:
        r12 = move-exception;
        goto L_0x0089;
    L_0x0077:
        r0 = move-exception;
        r12 = r1;
    L_0x0079:
        r2 = r4;
        goto L_0x0080;
    L_0x007b:
        r12 = move-exception;
        r4 = r2;
        goto L_0x0089;
    L_0x007e:
        r0 = move-exception;
        r12 = r1;
    L_0x0080:
        r0.printStackTrace();	 Catch:{ all -> 0x007b }
        if (r2 == 0) goto L_0x0088;
    L_0x0085:
        r2.close();	 Catch:{ IOException -> 0x0070 }
    L_0x0088:
        return r12;
    L_0x0089:
        if (r4 == 0) goto L_0x0093;
    L_0x008b:
        r4.close();	 Catch:{ IOException -> 0x008f }
        goto L_0x0093;
    L_0x008f:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0093:
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.aj.c(android.content.Context):boolean");
    }

    boolean d(android.content.Context r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined();
        r1 = 1;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = 0;
        r2 = r6.getPackageManager();	 Catch:{ Exception -> 0x00b2 }
        r3 = r6.getPackageName();	 Catch:{ Exception -> 0x00b2 }
        r4 = 64;	 Catch:{ Exception -> 0x00b2 }
        r2 = r2.getPackageInfo(r3, r4);	 Catch:{ Exception -> 0x00b2 }
        r2 = r2.signatures;	 Catch:{ Exception -> 0x00b2 }
        r2 = r2[r0];	 Catch:{ Exception -> 0x00b2 }
        r3 = r6.getPackageName();	 Catch:{ Exception -> 0x00b2 }
        r4 = "com.tencent.mtt";	 Catch:{ Exception -> 0x00b2 }
        r3 = r3.equals(r4);	 Catch:{ Exception -> 0x00b2 }
        if (r3 == 0) goto L_0x0034;	 Catch:{ Exception -> 0x00b2 }
    L_0x0027:
        r6 = r2.toCharsString();	 Catch:{ Exception -> 0x00b2 }
        r2 = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";	 Catch:{ Exception -> 0x00b2 }
        r6 = r6.equals(r2);	 Catch:{ Exception -> 0x00b2 }
        if (r6 != 0) goto L_0x00b1;	 Catch:{ Exception -> 0x00b2 }
    L_0x0033:
        return r0;	 Catch:{ Exception -> 0x00b2 }
    L_0x0034:
        r3 = r6.getPackageName();	 Catch:{ Exception -> 0x00b2 }
        r4 = "com.tencent.mm";	 Catch:{ Exception -> 0x00b2 }
        r3 = r3.equals(r4);	 Catch:{ Exception -> 0x00b2 }
        if (r3 == 0) goto L_0x004d;	 Catch:{ Exception -> 0x00b2 }
    L_0x0040:
        r6 = r2.toCharsString();	 Catch:{ Exception -> 0x00b2 }
        r2 = "308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499";	 Catch:{ Exception -> 0x00b2 }
        r6 = r6.equals(r2);	 Catch:{ Exception -> 0x00b2 }
        if (r6 != 0) goto L_0x00b1;	 Catch:{ Exception -> 0x00b2 }
    L_0x004c:
        return r0;	 Catch:{ Exception -> 0x00b2 }
    L_0x004d:
        r3 = r6.getPackageName();	 Catch:{ Exception -> 0x00b2 }
        r4 = "com.tencent.mobileqq";	 Catch:{ Exception -> 0x00b2 }
        r3 = r3.equals(r4);	 Catch:{ Exception -> 0x00b2 }
        if (r3 == 0) goto L_0x0066;	 Catch:{ Exception -> 0x00b2 }
    L_0x0059:
        r6 = r2.toCharsString();	 Catch:{ Exception -> 0x00b2 }
        r2 = "30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049";	 Catch:{ Exception -> 0x00b2 }
        r6 = r6.equals(r2);	 Catch:{ Exception -> 0x00b2 }
        if (r6 != 0) goto L_0x00b1;	 Catch:{ Exception -> 0x00b2 }
    L_0x0065:
        return r0;	 Catch:{ Exception -> 0x00b2 }
    L_0x0066:
        r3 = r6.getPackageName();	 Catch:{ Exception -> 0x00b2 }
        r4 = "com.tencent.tbs";	 Catch:{ Exception -> 0x00b2 }
        r3 = r3.equals(r4);	 Catch:{ Exception -> 0x00b2 }
        if (r3 == 0) goto L_0x007f;	 Catch:{ Exception -> 0x00b2 }
    L_0x0072:
        r6 = r2.toCharsString();	 Catch:{ Exception -> 0x00b2 }
        r2 = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";	 Catch:{ Exception -> 0x00b2 }
        r6 = r6.equals(r2);	 Catch:{ Exception -> 0x00b2 }
        if (r6 != 0) goto L_0x00b1;	 Catch:{ Exception -> 0x00b2 }
    L_0x007e:
        return r0;	 Catch:{ Exception -> 0x00b2 }
    L_0x007f:
        r3 = r6.getPackageName();	 Catch:{ Exception -> 0x00b2 }
        r4 = "com.qzone";	 Catch:{ Exception -> 0x00b2 }
        r3 = r3.equals(r4);	 Catch:{ Exception -> 0x00b2 }
        if (r3 == 0) goto L_0x0098;	 Catch:{ Exception -> 0x00b2 }
    L_0x008b:
        r6 = r2.toCharsString();	 Catch:{ Exception -> 0x00b2 }
        r2 = "308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677";	 Catch:{ Exception -> 0x00b2 }
        r6 = r6.equals(r2);	 Catch:{ Exception -> 0x00b2 }
        if (r6 != 0) goto L_0x00b1;	 Catch:{ Exception -> 0x00b2 }
    L_0x0097:
        return r0;	 Catch:{ Exception -> 0x00b2 }
    L_0x0098:
        r6 = r6.getPackageName();	 Catch:{ Exception -> 0x00b2 }
        r3 = "com.tencent.qqpimsecure";	 Catch:{ Exception -> 0x00b2 }
        r6 = r6.equals(r3);	 Catch:{ Exception -> 0x00b2 }
        if (r6 == 0) goto L_0x00b1;	 Catch:{ Exception -> 0x00b2 }
    L_0x00a4:
        r6 = r2.toCharsString();	 Catch:{ Exception -> 0x00b2 }
        r2 = "30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8";	 Catch:{ Exception -> 0x00b2 }
        r6 = r6.equals(r2);	 Catch:{ Exception -> 0x00b2 }
        if (r6 != 0) goto L_0x00b1;
    L_0x00b0:
        return r0;
    L_0x00b1:
        return r1;
    L_0x00b2:
        r6 = "TbsInstaller";
        r1 = "TbsInstaller-installLocalTbsCore getPackageInfo fail";
        com.tencent.smtt.utils.TbsLog.i(r6, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.aj.d(android.content.Context):boolean");
    }

    int e(android.content.Context r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = 0;
        r6 = r5.p(r6);	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r2 = "TbsInstaller";	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r4 = "TbsInstaller--getTmpTbsCoreVersionUnzipDir  tbsShareDir is ";	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r3.append(r6);	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        com.tencent.smtt.utils.TbsLog.i(r2, r3);	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r3 = "tbs.conf";	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r2.<init>(r6, r3);	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r6 = r2.exists();	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        if (r6 != 0) goto L_0x0027;	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
    L_0x0026:
        return r0;	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
    L_0x0027:
        r6 = new java.util.Properties;	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r6.<init>();	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r2 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r6.load(r2);	 Catch:{ Exception -> 0x0057, all -> 0x0054 }
        r2.close();	 Catch:{ Exception -> 0x0057, all -> 0x0054 }
        r1 = "tbs_core_version";	 Catch:{ Exception -> 0x0057, all -> 0x0054 }
        r6 = r6.getProperty(r1);	 Catch:{ Exception -> 0x0057, all -> 0x0054 }
        if (r6 != 0) goto L_0x004a;
    L_0x0044:
        if (r2 == 0) goto L_0x0049;
    L_0x0046:
        r2.close();	 Catch:{ IOException -> 0x0049 }
    L_0x0049:
        return r0;
    L_0x004a:
        r6 = java.lang.Integer.parseInt(r6);	 Catch:{ Exception -> 0x0057, all -> 0x0054 }
        if (r2 == 0) goto L_0x0053;
    L_0x0050:
        r2.close();	 Catch:{ IOException -> 0x0053 }
    L_0x0053:
        return r6;
    L_0x0054:
        r6 = move-exception;
        r1 = r2;
        goto L_0x005a;
    L_0x0057:
        r1 = r2;
        goto L_0x0060;
    L_0x0059:
        r6 = move-exception;
    L_0x005a:
        if (r1 == 0) goto L_0x005f;
    L_0x005c:
        r1.close();	 Catch:{ IOException -> 0x005f }
    L_0x005f:
        throw r6;
    L_0x0060:
        if (r1 == 0) goto L_0x0065;
    L_0x0062:
        r1.close();	 Catch:{ IOException -> 0x0065 }
    L_0x0065:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.aj.e(android.content.Context):int");
    }

    int f(android.content.Context r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = 0;
        r5 = r4.l(r5);	 Catch:{ Exception -> 0x004d, all -> 0x0046 }
        r2 = new java.io.File;	 Catch:{ Exception -> 0x004d, all -> 0x0046 }
        r3 = "tbs.conf";	 Catch:{ Exception -> 0x004d, all -> 0x0046 }
        r2.<init>(r5, r3);	 Catch:{ Exception -> 0x004d, all -> 0x0046 }
        r5 = r2.exists();	 Catch:{ Exception -> 0x004d, all -> 0x0046 }
        if (r5 != 0) goto L_0x0014;	 Catch:{ Exception -> 0x004d, all -> 0x0046 }
    L_0x0013:
        return r0;	 Catch:{ Exception -> 0x004d, all -> 0x0046 }
    L_0x0014:
        r5 = new java.util.Properties;	 Catch:{ Exception -> 0x004d, all -> 0x0046 }
        r5.<init>();	 Catch:{ Exception -> 0x004d, all -> 0x0046 }
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x004d, all -> 0x0046 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x004d, all -> 0x0046 }
        r2 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x004d, all -> 0x0046 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x004d, all -> 0x0046 }
        r5.load(r2);	 Catch:{ Exception -> 0x0044, all -> 0x0041 }
        r2.close();	 Catch:{ Exception -> 0x0044, all -> 0x0041 }
        r1 = "tbs_core_version";	 Catch:{ Exception -> 0x0044, all -> 0x0041 }
        r5 = r5.getProperty(r1);	 Catch:{ Exception -> 0x0044, all -> 0x0041 }
        if (r5 != 0) goto L_0x0037;
    L_0x0031:
        if (r2 == 0) goto L_0x0036;
    L_0x0033:
        r2.close();	 Catch:{ IOException -> 0x0036 }
    L_0x0036:
        return r0;
    L_0x0037:
        r5 = java.lang.Integer.parseInt(r5);	 Catch:{ Exception -> 0x0044, all -> 0x0041 }
        if (r2 == 0) goto L_0x0040;
    L_0x003d:
        r2.close();	 Catch:{ IOException -> 0x0040 }
    L_0x0040:
        return r5;
    L_0x0041:
        r5 = move-exception;
        r1 = r2;
        goto L_0x0047;
    L_0x0044:
        r1 = r2;
        goto L_0x004d;
    L_0x0046:
        r5 = move-exception;
    L_0x0047:
        if (r1 == 0) goto L_0x004c;
    L_0x0049:
        r1.close();	 Catch:{ IOException -> 0x004c }
    L_0x004c:
        throw r5;
    L_0x004d:
        if (r1 == 0) goto L_0x0052;
    L_0x004f:
        r1.close();	 Catch:{ IOException -> 0x0052 }
    L_0x0052:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.aj.f(android.content.Context):int");
    }

    int g(Context context) {
        StringBuilder stringBuilder;
        Exception e;
        StringBuilder stringBuilder2;
        Throwable th;
        BufferedInputStream bufferedInputStream = null;
        try {
            File file = new File(m(context), "tbs.conf");
            if (!file.exists()) {
                return 0;
            }
            Properties properties = new Properties();
            InputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                properties.load(bufferedInputStream2);
                bufferedInputStream2.close();
                String property = properties.getProperty("tbs_core_version");
                if (property == null) {
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                            return 0;
                        } catch (IOException e2) {
                            stringBuilder = new StringBuilder("TbsInstaller--getTbsCoreInstalledVerInNolock IOException=");
                            stringBuilder.append(e2.toString());
                            TbsLog.i("TbsInstaller", stringBuilder.toString());
                        }
                    }
                    return 0;
                }
                int parseInt = Integer.parseInt(property);
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                        return parseInt;
                    } catch (IOException e3) {
                        stringBuilder = new StringBuilder("TbsInstaller--getTbsCoreInstalledVerInNolock IOException=");
                        stringBuilder.append(e3.toString());
                        TbsLog.i("TbsInstaller", stringBuilder.toString());
                    }
                }
                return parseInt;
            } catch (Exception e4) {
                e = e4;
                bufferedInputStream = bufferedInputStream2;
                try {
                    stringBuilder2 = new StringBuilder("TbsInstaller--getTbsCoreInstalledVerInNolock Exception=");
                    stringBuilder2.append(e.toString());
                    TbsLog.i("TbsInstaller", stringBuilder2.toString());
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                            return 0;
                        } catch (IOException e22) {
                            stringBuilder = new StringBuilder("TbsInstaller--getTbsCoreInstalledVerInNolock IOException=");
                            stringBuilder.append(e22.toString());
                            TbsLog.i("TbsInstaller", stringBuilder.toString());
                            return 0;
                        }
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e32) {
                            stringBuilder = new StringBuilder("TbsInstaller--getTbsCoreInstalledVerInNolock IOException=");
                            stringBuilder.append(e32.toString());
                            TbsLog.i("TbsInstaller", stringBuilder.toString());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            stringBuilder2 = new StringBuilder("TbsInstaller--getTbsCoreInstalledVerInNolock Exception=");
            stringBuilder2.append(e.toString());
            TbsLog.i("TbsInstaller", stringBuilder2.toString());
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
                return 0;
            }
            return 0;
        }
    }

    boolean h(Context context) {
        return new File(m(context), "tbs.conf").exists();
    }

    int i(Context context) {
        Exception e;
        StringBuilder stringBuilder;
        Throwable th;
        if (!s(context)) {
            return -1;
        }
        boolean tryLock = h.tryLock();
        StringBuilder stringBuilder2 = new StringBuilder("TbsInstaller--getTbsCoreInstalledVer locked=");
        stringBuilder2.append(tryLock);
        TbsLog.i("TbsInstaller", stringBuilder2.toString());
        if (tryLock) {
            BufferedInputStream bufferedInputStream = null;
            try {
                File file = new File(m(context), "tbs.conf");
                if (file.exists()) {
                    Properties properties = new Properties();
                    InputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        properties.load(bufferedInputStream2);
                        bufferedInputStream2.close();
                        String property = properties.getProperty("tbs_core_version");
                        if (property == null) {
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e2) {
                                    stringBuilder2 = new StringBuilder("TbsInstaller--getTbsCoreInstalledVer IOException=");
                                    stringBuilder2.append(e2.toString());
                                    TbsLog.i("TbsInstaller", stringBuilder2.toString());
                                }
                            }
                            h.unlock();
                            b();
                            return 0;
                        }
                        a.set(Integer.valueOf(Integer.parseInt(property)));
                        int intValue = ((Integer) a.get()).intValue();
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e3) {
                                stringBuilder2 = new StringBuilder("TbsInstaller--getTbsCoreInstalledVer IOException=");
                                stringBuilder2.append(e3.toString());
                                TbsLog.i("TbsInstaller", stringBuilder2.toString());
                            }
                        }
                        h.unlock();
                        b();
                        return intValue;
                    } catch (Exception e4) {
                        e = e4;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            stringBuilder = new StringBuilder("TbsInstaller--getTbsCoreInstalledVer Exception=");
                            stringBuilder.append(e.toString());
                            TbsLog.i("TbsInstaller", stringBuilder.toString());
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e22) {
                                    stringBuilder2 = new StringBuilder("TbsInstaller--getTbsCoreInstalledVer IOException=");
                                    stringBuilder2.append(e22.toString());
                                    TbsLog.i("TbsInstaller", stringBuilder2.toString());
                                }
                            }
                            h.unlock();
                            b();
                            return 0;
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e32) {
                                    stringBuilder2 = new StringBuilder("TbsInstaller--getTbsCoreInstalledVer IOException=");
                                    stringBuilder2.append(e32.toString());
                                    TbsLog.i("TbsInstaller", stringBuilder2.toString());
                                }
                            }
                            h.unlock();
                            b();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        h.unlock();
                        b();
                        throw th;
                    }
                }
                h.unlock();
                b();
                return 0;
            } catch (Exception e5) {
                e = e5;
                stringBuilder = new StringBuilder("TbsInstaller--getTbsCoreInstalledVer Exception=");
                stringBuilder.append(e.toString());
                TbsLog.i("TbsInstaller", stringBuilder.toString());
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                h.unlock();
                b();
                return 0;
            }
        }
        b();
        return 0;
    }

    public boolean j(android.content.Context r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = "TbsInstaller";
        r1 = "TbsInstaller--coreShareCopyToDecouple #0";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        r0 = r4.m(r5);
        r1 = r4.l(r5);
        r2 = 1;
        com.tencent.smtt.utils.k.a(r1, r2);	 Catch:{ Exception -> 0x0026 }
        r3 = new com.tencent.smtt.sdk.ap;	 Catch:{ Exception -> 0x0026 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0026 }
        com.tencent.smtt.utils.k.a(r0, r1, r3);	 Catch:{ Exception -> 0x0026 }
        com.tencent.smtt.sdk.TbsShareManager.b(r5);	 Catch:{ Exception -> 0x0026 }
        r5 = "TbsInstaller";
        r0 = "TbsInstaller--coreShareCopyToDecouple success!!!";
        com.tencent.smtt.utils.TbsLog.i(r5, r0);
        return r2;
    L_0x0026:
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.aj.j(android.content.Context):boolean");
    }

    void k(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
        af.a(context).a(0);
        af.a(context).b(0);
        af.a(context).d(0);
        af.a(context).a("incrupdate_retry_num", 0);
        if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) != 1) {
            af.a(context).b(0, -1);
            af.a(context).a("");
            af.a(context).a("copy_retry_num", 0);
            af.a(context).c(-1);
            af.a(context).a(0, -1);
            k.a(p(context), true);
            k.a(r(context), true);
        }
    }

    File l(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_share_decouple");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    File m(Context context) {
        return b(null, context);
    }

    File n(Context context) {
        File file = new File(context.getDir("tbs", 0), "share");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    File p(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    File q(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp_decouple");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    File r(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_copy_tmp");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    synchronized boolean s(Context context) {
        this.d++;
        if (this.g) {
            TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
            return true;
        }
        this.f = k.b(context, true, "tbslock.txt");
        if (this.f == null) {
            return false;
        }
        this.e = k.a(context, this.f);
        if (this.e == null) {
            return false;
        }
        TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
        this.g = true;
        return true;
    }
}
