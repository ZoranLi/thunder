package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import anet.channel.util.ErrorConstant;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.k;
import java.io.File;
import org.json.JSONArray;

public class TbsDownloader {
    public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
    public static boolean DOWNLOAD_OVERSEA_TBS = false;
    public static final String LOGTAG = "TbsDownload";
    static boolean a = false;
    private static String b = null;
    private static Context c = null;
    private static Handler d = null;
    private static String e = null;
    private static Object f = new byte[0];
    private static ad g = null;
    private static HandlerThread h = null;
    private static boolean i = false;
    private static boolean j = false;
    private static boolean k = false;
    private static long l = -1;

    public interface TbsDownloaderCallback {
        void onNeedDownloadFinish(boolean z, int i);
    }

    protected static File a(int i) {
        File file = null;
        for (String str : TbsShareManager.getCoreProviderAppList()) {
            String str2;
            if (!str2.equals(c.getApplicationInfo().packageName)) {
                String str3;
                file = new File(k.a(c, str2, 4, false), getOverSea(c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                if (!file.exists()) {
                    str2 = LOGTAG;
                    str3 = "can not find local backup core file";
                } else if (a.a(c, file) == i) {
                    String str4 = LOGTAG;
                    StringBuilder stringBuilder = new StringBuilder("local tbs version fond,path = ");
                    stringBuilder.append(file.getAbsolutePath());
                    TbsLog.i(str4, stringBuilder.toString());
                    return file;
                } else {
                    str2 = LOGTAG;
                    str3 = "version is not match";
                }
                TbsLog.i(str2, str3);
            }
        }
        return file;
    }

    static java.lang.String a(android.content.Context r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = b;
        r5 = android.text.TextUtils.isEmpty(r5);
        if (r5 != 0) goto L_0x000b;
    L_0x0008:
        r5 = b;
        return r5;
    L_0x000b:
        r5 = java.util.Locale.getDefault();
        r0 = new java.lang.StringBuffer;
        r0.<init>();
        r1 = android.os.Build.VERSION.RELEASE;
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x0024 }
        r3 = "UTF-8";	 Catch:{ Exception -> 0x0024 }
        r3 = r1.getBytes(r3);	 Catch:{ Exception -> 0x0024 }
        r4 = "ISO8859-1";	 Catch:{ Exception -> 0x0024 }
        r2.<init>(r3, r4);	 Catch:{ Exception -> 0x0024 }
        r1 = r2;
    L_0x0024:
        r2 = r1.length();
        if (r2 <= 0) goto L_0x002e;
    L_0x002a:
        r0.append(r1);
        goto L_0x0031;
    L_0x002e:
        r1 = "1.0";
        goto L_0x002a;
    L_0x0031:
        r1 = "; ";
        r0.append(r1);
        r1 = r5.getLanguage();
        if (r1 == 0) goto L_0x0053;
    L_0x003c:
        r1 = r1.toLowerCase();
        r0.append(r1);
        r5 = r5.getCountry();
        if (r5 == 0) goto L_0x0058;
    L_0x0049:
        r1 = "-";
        r0.append(r1);
        r5 = r5.toLowerCase();
        goto L_0x0055;
    L_0x0053:
        r5 = "en";
    L_0x0055:
        r0.append(r5);
    L_0x0058:
        r5 = "REL";
        r1 = android.os.Build.VERSION.CODENAME;
        r5 = r5.equals(r1);
        if (r5 == 0) goto L_0x0080;
    L_0x0062:
        r5 = android.os.Build.MODEL;
        r1 = new java.lang.String;	 Catch:{ Exception -> 0x0072 }
        r2 = "UTF-8";	 Catch:{ Exception -> 0x0072 }
        r2 = r5.getBytes(r2);	 Catch:{ Exception -> 0x0072 }
        r3 = "ISO8859-1";	 Catch:{ Exception -> 0x0072 }
        r1.<init>(r2, r3);	 Catch:{ Exception -> 0x0072 }
        r5 = r1;
    L_0x0072:
        r1 = r5.length();
        if (r1 <= 0) goto L_0x0080;
    L_0x0078:
        r1 = "; ";
        r0.append(r1);
        r0.append(r5);
    L_0x0080:
        r5 = android.os.Build.ID;
        r1 = "[一-龥]";
        r2 = "";
        r5 = r5.replaceAll(r1, r2);
        r1 = r5.length();
        if (r1 <= 0) goto L_0x0098;
    L_0x0090:
        r1 = " Build/";
        r0.append(r1);
        r0.append(r5);
    L_0x0098:
        r5 = "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r1[r2] = r0;
        r5 = java.lang.String.format(r5, r1);
        b = r5;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.a(android.content.Context):java.lang.String");
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    private static void a(boolean z, TbsDownloaderCallback tbsDownloaderCallback) {
        TbsLog.i(LOGTAG, "[TbsDownloader.queryConfig]");
        d.removeMessages(100);
        Message obtain = Message.obtain(d, 100);
        if (tbsDownloaderCallback != null) {
            obtain.obj = tbsDownloaderCallback;
        }
        obtain.arg1 = 0;
        obtain.arg1 = z;
        obtain.sendToTarget();
    }

    private static boolean a(android.content.Context r5, boolean r6, com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 0;
        r3 = 8;
        if (r1 >= r3) goto L_0x0011;
    L_0x000b:
        r5 = -102; // 0xffffffffffffff9a float:NaN double:NaN;
    L_0x000d:
        r0.setDownloadInterruptCode(r5);
        return r2;
    L_0x0011:
        r1 = com.tencent.smtt.sdk.QbSdk.c;
        if (r1 != 0) goto L_0x0029;
    L_0x0015:
        r1 = c;
        r1 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r1);
        if (r1 == 0) goto L_0x0029;
    L_0x001d:
        r1 = c();
        if (r1 != 0) goto L_0x0029;
    L_0x0023:
        if (r7 == 0) goto L_0x0028;
    L_0x0025:
        r7.onNeedDownloadFinish(r2, r2);
    L_0x0028:
        return r2;
    L_0x0029:
        r1 = r0.mPreferences;
        r3 = "is_oversea";
        r1 = r1.contains(r3);
        if (r1 != 0) goto L_0x006e;
    L_0x0033:
        if (r6 == 0) goto L_0x004b;
    L_0x0035:
        r1 = "com.tencent.mm";
        r3 = r5.getApplicationInfo();
        r3 = r3.packageName;
        r1 = r1.equals(r3);
        if (r1 != 0) goto L_0x004b;
    L_0x0043:
        r6 = "TbsDownload";
        r1 = "needDownload-oversea is true, but not WX";
        com.tencent.smtt.utils.TbsLog.i(r6, r1);
        r6 = r2;
    L_0x004b:
        r1 = r0.a;
        r3 = "is_oversea";
        r4 = java.lang.Boolean.valueOf(r6);
        r1.put(r3, r4);
        r0.commit();
        j = r6;
        r1 = "TbsDownload";
        r3 = new java.lang.StringBuilder;
        r4 = "needDownload-first-called--isoversea = ";
        r3.<init>(r4);
        r3.append(r6);
        r6 = r3.toString();
        com.tencent.smtt.utils.TbsLog.i(r1, r6);
    L_0x006e:
        r5 = getOverSea(r5);
        if (r5 == 0) goto L_0x00a9;
    L_0x0074:
        r5 = android.os.Build.VERSION.SDK_INT;
        r6 = 16;
        if (r5 == r6) goto L_0x00a9;
    L_0x007a:
        r5 = android.os.Build.VERSION.SDK_INT;
        r6 = 17;
        if (r5 == r6) goto L_0x00a9;
    L_0x0080:
        r5 = android.os.Build.VERSION.SDK_INT;
        r6 = 18;
        if (r5 == r6) goto L_0x00a9;
    L_0x0086:
        r5 = "TbsDownload";
        r6 = new java.lang.StringBuilder;
        r1 = "needDownload- return false,  because of  version is ";
        r6.<init>(r1);
        r1 = android.os.Build.VERSION.SDK_INT;
        r6.append(r1);
        r1 = ", and overea";
        r6.append(r1);
        r6 = r6.toString();
        com.tencent.smtt.utils.TbsLog.i(r5, r6);
        if (r7 == 0) goto L_0x00a5;
    L_0x00a2:
        r7.onNeedDownloadFinish(r2, r2);
    L_0x00a5:
        r5 = -103; // 0xffffffffffffff99 float:NaN double:NaN;
        goto L_0x000d;
    L_0x00a9:
        r5 = r0.mPreferences;
        r6 = "device_cpuabi";
        r1 = 0;
        r5 = r5.getString(r6, r1);
        e = r5;
        r5 = android.text.TextUtils.isEmpty(r5);
        if (r5 != 0) goto L_0x00d9;
    L_0x00ba:
        r5 = "i686|mips|x86_64";	 Catch:{ Exception -> 0x00c7 }
        r5 = java.util.regex.Pattern.compile(r5);	 Catch:{ Exception -> 0x00c7 }
        r6 = e;	 Catch:{ Exception -> 0x00c7 }
        r5 = r5.matcher(r6);	 Catch:{ Exception -> 0x00c7 }
        goto L_0x00c8;
    L_0x00c7:
        r5 = r1;
    L_0x00c8:
        if (r5 == 0) goto L_0x00d9;
    L_0x00ca:
        r5 = r5.find();
        if (r5 == 0) goto L_0x00d9;
    L_0x00d0:
        if (r7 == 0) goto L_0x00d5;
    L_0x00d2:
        r7.onNeedDownloadFinish(r2, r2);
    L_0x00d5:
        r5 = -104; // 0xffffffffffffff98 float:NaN double:NaN;
        goto L_0x000d;
    L_0x00d9:
        r5 = 1;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.a(android.content.Context, boolean, com.tencent.smtt.sdk.TbsDownloader$TbsDownloaderCallback):boolean");
    }

    private static boolean a(Context context, boolean z, boolean z2) {
        String str;
        boolean z3;
        TbsLogInfo a;
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
        if (!z) {
            StringBuilder stringBuilder;
            String string = instance.mPreferences.getString(TbsConfigKey.KEY_APP_VERSIONNAME, null);
            int i = instance.mPreferences.getInt(TbsConfigKey.KEY_APP_VERSIONCODE, 0);
            String string2 = instance.mPreferences.getString(TbsConfigKey.KEY_APP_METADATA, null);
            String a2 = b.a(c);
            int b = b.b(c);
            String a3 = b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
            String str2 = LOGTAG;
            StringBuilder stringBuilder2 = new StringBuilder("[TbsDownloader.needSendQueryRequest] appVersionName=");
            stringBuilder2.append(a2);
            stringBuilder2.append(" oldAppVersionName=");
            stringBuilder2.append(string);
            stringBuilder2.append(" appVersionCode=");
            stringBuilder2.append(b);
            stringBuilder2.append(" oldAppVersionCode=");
            stringBuilder2.append(i);
            stringBuilder2.append(" appMetadata=");
            stringBuilder2.append(a3);
            stringBuilder2.append(" oldAppVersionMetadata=");
            stringBuilder2.append(string2);
            TbsLog.i(str2, stringBuilder2.toString());
            long currentTimeMillis = System.currentTimeMillis();
            long j = instance.mPreferences.getLong(TbsConfigKey.KEY_LAST_CHECK, 0);
            String str3 = LOGTAG;
            StringBuilder stringBuilder3 = new StringBuilder("[TbsDownloader.needSendQueryRequest] timeLastCheck=");
            stringBuilder3.append(j);
            stringBuilder3.append(" timeNow=");
            stringBuilder3.append(currentTimeMillis);
            TbsLog.i(str3, stringBuilder3.toString());
            if (z2) {
                boolean contains = instance.mPreferences.contains(TbsConfigKey.KEY_LAST_CHECK);
                str = LOGTAG;
                stringBuilder = new StringBuilder("[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=");
                stringBuilder.append(contains);
                TbsLog.i(str, stringBuilder.toString());
                if (contains && j == 0) {
                    j = currentTimeMillis;
                }
            }
            long retryInterval = instance.getRetryInterval();
            str = LOGTAG;
            stringBuilder = new StringBuilder("retryInterval = ");
            stringBuilder.append(retryInterval);
            stringBuilder.append(" s");
            TbsLog.i(str, stringBuilder.toString());
            long j2 = currentTimeMillis - j;
            if (j2 <= retryInterval * 1000) {
                if (TbsShareManager.isThirdPartyApp(c) && TbsShareManager.findCoreForThirdPartyApp(c) == 0 && !e()) {
                    k.b(c.getDir("tbs", 0));
                    aj.a.set(Integer.valueOf(0));
                } else {
                    if (a2 == null || b == 0 || a3 == null) {
                        if (TbsShareManager.isThirdPartyApp(c)) {
                            StringBuilder stringBuilder4 = new StringBuilder("timeNow - timeLastCheck is ");
                            stringBuilder4.append(j2);
                            stringBuilder4.append(" TbsShareManager.findCoreForThirdPartyApp(sAppContext) is ");
                            stringBuilder4.append(TbsShareManager.findCoreForThirdPartyApp(c));
                            stringBuilder4.append(" sendRequestWithSameHostCoreVersion() is ");
                            stringBuilder4.append(e());
                            stringBuilder4.append(" appVersionName is ");
                            stringBuilder4.append(a2);
                            stringBuilder4.append(" appVersionCode is ");
                            stringBuilder4.append(b);
                            stringBuilder4.append(" appMetadata is ");
                            stringBuilder4.append(a3);
                            stringBuilder4.append(" oldAppVersionName is ");
                            stringBuilder4.append(string);
                            stringBuilder4.append(" oldAppVersionCode is ");
                            stringBuilder4.append(i);
                            stringBuilder4.append(" oldAppVersionMetadata is ");
                            stringBuilder4.append(string2);
                            str = stringBuilder4.toString();
                            z3 = false;
                            if (!z3 && TbsShareManager.isThirdPartyApp(c)) {
                                a = TbsLogReport.a(c).a();
                                a.setErrorCode(-119);
                                a.setFailDetail(str);
                                TbsLogReport.a(c).a(EventType.TYPE_DOWNLOAD, a);
                            }
                            return z3;
                        }
                    } else if (a2.equals(string) && b == i) {
                        if (!a3.equals(string2)) {
                        }
                    }
                    str = null;
                    z3 = false;
                    a = TbsLogReport.a(c).a();
                    a.setErrorCode(-119);
                    a.setFailDetail(str);
                    TbsLogReport.a(c).a(EventType.TYPE_DOWNLOAD, a);
                    return z3;
                }
            }
        }
        str = null;
        z3 = true;
        a = TbsLogReport.a(c).a();
        a.setErrorCode(-119);
        a.setFailDetail(str);
        TbsLogReport.a(c).a(EventType.TYPE_DOWNLOAD, a);
        return z3;
    }

    @android.annotation.TargetApi(11)
    private static boolean a(java.lang.String r30, int r31, boolean r32, boolean r33) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:7:0x0031
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:248)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = r30;
        r2 = r31;
        r4 = r33;
        r5 = "TbsDownload";
        r6 = new java.lang.StringBuilder;
        r7 = "[TbsDownloader.readResponse] response=";
        r6.<init>(r7);
        r6.append(r1);
        r6 = r6.toString();
        com.tencent.smtt.utils.TbsLog.i(r5, r6);
        r5 = c;
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);
        r6 = android.text.TextUtils.isEmpty(r30);
        r7 = 0;
        if (r6 == 0) goto L_0x0032;
    L_0x0026:
        if (r32 == 0) goto L_0x002e;
    L_0x0028:
        r1 = -108; // 0xffffffffffffff94 float:NaN double:NaN;
    L_0x002a:
        r5.setDownloadInterruptCode(r1);
        return r7;
    L_0x002e:
        r1 = -208; // 0xffffffffffffff30 float:NaN double:NaN;
        goto L_0x002a;
        return r7;
    L_0x0032:
        r6 = new org.json.JSONObject;
        r6.<init>(r1);
        r1 = "RET";
        r1 = r6.getInt(r1);
        if (r1 == 0) goto L_0x004b;
    L_0x003f:
        if (r32 == 0) goto L_0x0047;
    L_0x0041:
        r1 = -109; // 0xffffffffffffff93 float:NaN double:NaN;
    L_0x0043:
        r5.setDownloadInterruptCode(r1);
        return r7;
    L_0x0047:
        r1 = -209; // 0xffffffffffffff2f float:NaN double:NaN;
        goto L_0x0043;
        return r7;
    L_0x004b:
        r1 = "RESPONSECODE";
        r1 = r6.getInt(r1);
        r8 = "DOWNLOADURL";
        r8 = r6.getString(r8);
        r9 = "URLLIST";
        r10 = "";
        r9 = r6.optString(r9, r10);
        r10 = "TBSAPKSERVERVERSION";
        r10 = r6.getInt(r10);
        r11 = "DOWNLOADMAXFLOW";
        r11 = r6.getInt(r11);
        r12 = "DOWNLOAD_MIN_FREE_SPACE";
        r12 = r6.getInt(r12);
        r13 = "DOWNLOAD_SUCCESS_MAX_RETRYTIMES";
        r13 = r6.getInt(r13);
        r14 = "DOWNLOAD_FAILED_MAX_RETRYTIMES";
        r14 = r6.getInt(r14);
        r15 = "DOWNLOAD_SINGLE_TIMEOUT";
        r16 = r8;
        r7 = r6.getLong(r15);
        r15 = "TBSAPKFILESIZE";
        r17 = r7;
        r7 = r6.getLong(r15);
        r15 = "RETRY_INTERVAL";
        r19 = r7;
        r7 = 0;
        r21 = r6.optLong(r15, r7);
        r15 = "FLOWCTR";
        r7 = -1;
        r7 = r6.optInt(r15, r7);
        r8 = "USEBBACKUPVER";	 Catch:{ Exception -> 0x00a5 }
        r8 = r6.getInt(r8);	 Catch:{ Exception -> 0x00a5 }
        goto L_0x00a6;
    L_0x00a5:
        r8 = 0;
    L_0x00a6:
        r15 = r5.a;
        r4 = "use_backup_version";
        r8 = java.lang.Integer.valueOf(r8);
        r15.put(r4, r8);
        if (r32 == 0) goto L_0x0100;
    L_0x00b3:
        r8 = com.tencent.smtt.sdk.QbSdk.i;
        if (r8 == 0) goto L_0x0100;
    L_0x00b7:
        r8 = c;
        r8 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r8);
        if (r8 == 0) goto L_0x0100;
    L_0x00bf:
        r8 = "BUGLY";	 Catch:{ Throwable -> 0x00e2 }
        r15 = 0;	 Catch:{ Throwable -> 0x00e2 }
        r8 = r6.optInt(r8, r15);	 Catch:{ Throwable -> 0x00e2 }
        r15 = com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance();	 Catch:{ Throwable -> 0x00e2 }
        r4 = c;	 Catch:{ Throwable -> 0x00e2 }
        r23 = r14;
        r14 = "bugly_switch.txt";	 Catch:{ Throwable -> 0x00de }
        r24 = r13;
        r13 = 1;
        if (r8 != r13) goto L_0x00d7;
    L_0x00d5:
        r8 = 1;
        goto L_0x00d8;
    L_0x00d7:
        r8 = 0;
    L_0x00d8:
        r15.setFunctionEnable(r4, r14, r8);	 Catch:{ Throwable -> 0x00dc }
        goto L_0x0104;
    L_0x00dc:
        r0 = move-exception;
        goto L_0x00e7;
    L_0x00de:
        r0 = move-exception;
        r24 = r13;
        goto L_0x00e7;
    L_0x00e2:
        r0 = move-exception;
        r24 = r13;
        r23 = r14;
    L_0x00e7:
        r4 = r0;
        r8 = "qbsdk";
        r13 = new java.lang.StringBuilder;
        r14 = "throwable:";
        r13.<init>(r14);
        r4 = r4.toString();
        r13.append(r4);
        r4 = r13.toString();
        com.tencent.smtt.utils.TbsLog.i(r8, r4);
        goto L_0x0104;
    L_0x0100:
        r24 = r13;
        r23 = r14;
    L_0x0104:
        if (r32 == 0) goto L_0x014c;
    L_0x0106:
        r4 = "TEMPLATESWITCH";	 Catch:{ Throwable -> 0x0133 }
        r8 = 0;	 Catch:{ Throwable -> 0x0133 }
        r4 = r6.optInt(r4, r8);	 Catch:{ Throwable -> 0x0133 }
        r8 = 1;	 Catch:{ Throwable -> 0x0133 }
        r4 = r4 & r8;	 Catch:{ Throwable -> 0x0133 }
        if (r4 == 0) goto L_0x0113;	 Catch:{ Throwable -> 0x0133 }
    L_0x0111:
        r4 = 1;	 Catch:{ Throwable -> 0x0133 }
        goto L_0x0114;	 Catch:{ Throwable -> 0x0133 }
    L_0x0113:
        r4 = 0;	 Catch:{ Throwable -> 0x0133 }
    L_0x0114:
        r8 = com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance();	 Catch:{ Throwable -> 0x0133 }
        r13 = c;	 Catch:{ Throwable -> 0x0133 }
        r14 = "cookie_switch.txt";	 Catch:{ Throwable -> 0x0133 }
        r8.setFunctionEnable(r13, r14, r4);	 Catch:{ Throwable -> 0x0133 }
        r8 = "TbsDownload";	 Catch:{ Throwable -> 0x0133 }
        r13 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0133 }
        r14 = "useCookieCompatiable:";	 Catch:{ Throwable -> 0x0133 }
        r13.<init>(r14);	 Catch:{ Throwable -> 0x0133 }
        r13.append(r4);	 Catch:{ Throwable -> 0x0133 }
        r4 = r13.toString();	 Catch:{ Throwable -> 0x0133 }
        com.tencent.smtt.utils.TbsLog.w(r8, r4);	 Catch:{ Throwable -> 0x0133 }
        goto L_0x014c;
    L_0x0133:
        r0 = move-exception;
        r4 = r0;
        r8 = "qbsdk";
        r13 = new java.lang.StringBuilder;
        r14 = "throwable:";
        r13.<init>(r14);
        r4 = r4.toString();
        r13.append(r4);
        r4 = r13.toString();
        com.tencent.smtt.utils.TbsLog.i(r8, r4);
    L_0x014c:
        r4 = "";
        r13 = "PKGMD5";	 Catch:{ Exception -> 0x0199 }
        r13 = r6.getString(r13);	 Catch:{ Exception -> 0x0199 }
        r14 = "RESETX5";	 Catch:{ Exception -> 0x0195 }
        r14 = r6.getInt(r14);	 Catch:{ Exception -> 0x0195 }
        r15 = "UPLOADLOG";	 Catch:{ Exception -> 0x0191 }
        r15 = r6.getInt(r15);	 Catch:{ Exception -> 0x0191 }
        r8 = "RESETTOKEN";	 Catch:{ Exception -> 0x018d }
        r8 = r6.has(r8);	 Catch:{ Exception -> 0x018d }
        if (r8 == 0) goto L_0x0176;	 Catch:{ Exception -> 0x018d }
    L_0x0168:
        r8 = "RESETTOKEN";	 Catch:{ Exception -> 0x018d }
        r8 = r6.getInt(r8);	 Catch:{ Exception -> 0x018d }
        if (r8 == 0) goto L_0x0172;
    L_0x0170:
        r8 = 1;
        goto L_0x0173;
    L_0x0172:
        r8 = 0;
    L_0x0173:
        r25 = r4;
        goto L_0x0179;
    L_0x0176:
        r25 = r4;
        r8 = 0;
    L_0x0179:
        r4 = "SETTOKEN";	 Catch:{ Exception -> 0x019f }
        r4 = r6.has(r4);	 Catch:{ Exception -> 0x019f }
        if (r4 == 0) goto L_0x0188;	 Catch:{ Exception -> 0x019f }
    L_0x0181:
        r4 = "SETTOKEN";	 Catch:{ Exception -> 0x019f }
        r4 = r6.getString(r4);	 Catch:{ Exception -> 0x019f }
        goto L_0x018a;
    L_0x0188:
        r4 = r25;
    L_0x018a:
        r26 = r13;
        goto L_0x01a3;
    L_0x018d:
        r25 = r4;
        r8 = 0;
        goto L_0x019f;
    L_0x0191:
        r25 = r4;
        r8 = 0;
        goto L_0x019e;
    L_0x0195:
        r25 = r4;
        r8 = 0;
        goto L_0x019d;
    L_0x0199:
        r25 = r4;
        r8 = 0;
        r13 = 0;
    L_0x019d:
        r14 = 0;
    L_0x019e:
        r15 = 0;
    L_0x019f:
        r26 = r13;
        r4 = r25;
    L_0x01a3:
        r13 = "RESETDECOUPLECORE";	 Catch:{ Exception -> 0x01aa }
        r13 = r6.getInt(r13);	 Catch:{ Exception -> 0x01aa }
        goto L_0x01ab;
    L_0x01aa:
        r13 = 0;
    L_0x01ab:
        r27 = r12;
        r12 = "RESETTODECOUPLECORE";	 Catch:{ Exception -> 0x01b4 }
        r12 = r6.getInt(r12);	 Catch:{ Exception -> 0x01b4 }
        goto L_0x01b5;
    L_0x01b4:
        r12 = 0;
    L_0x01b5:
        r25 = f;
        monitor-enter(r25);
        if (r8 == 0) goto L_0x01cc;
    L_0x01ba:
        r8 = r5.a;	 Catch:{ all -> 0x01c8 }
        r28 = r11;	 Catch:{ all -> 0x01c8 }
        r11 = "tbs_deskey_token";	 Catch:{ all -> 0x01c8 }
        r29 = r9;	 Catch:{ all -> 0x01c8 }
        r9 = "";	 Catch:{ all -> 0x01c8 }
        r8.put(r11, r9);	 Catch:{ all -> 0x01c8 }
        goto L_0x01d0;	 Catch:{ all -> 0x01c8 }
    L_0x01c8:
        r0 = move-exception;	 Catch:{ all -> 0x01c8 }
        r1 = r0;	 Catch:{ all -> 0x01c8 }
        goto L_0x063a;	 Catch:{ all -> 0x01c8 }
    L_0x01cc:
        r29 = r9;	 Catch:{ all -> 0x01c8 }
        r28 = r11;	 Catch:{ all -> 0x01c8 }
    L_0x01d0:
        r8 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x01c8 }
        if (r8 != 0) goto L_0x01fd;	 Catch:{ all -> 0x01c8 }
    L_0x01d6:
        r8 = r4.length();	 Catch:{ all -> 0x01c8 }
        r9 = 96;	 Catch:{ all -> 0x01c8 }
        if (r8 != r9) goto L_0x01fd;	 Catch:{ all -> 0x01c8 }
    L_0x01de:
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01c8 }
        r8.<init>();	 Catch:{ all -> 0x01c8 }
        r8.append(r4);	 Catch:{ all -> 0x01c8 }
        r4 = "&";	 Catch:{ all -> 0x01c8 }
        r8.append(r4);	 Catch:{ all -> 0x01c8 }
        r4 = com.tencent.smtt.utils.p.c();	 Catch:{ all -> 0x01c8 }
        r8.append(r4);	 Catch:{ all -> 0x01c8 }
        r4 = r8.toString();	 Catch:{ all -> 0x01c8 }
        r8 = r5.a;	 Catch:{ all -> 0x01c8 }
        r9 = "tbs_deskey_token";	 Catch:{ all -> 0x01c8 }
        r8.put(r9, r4);	 Catch:{ all -> 0x01c8 }
    L_0x01fd:
        monitor-exit(r25);	 Catch:{ all -> 0x01c8 }
        r4 = 1;
        if (r14 != r4) goto L_0x0217;
    L_0x0201:
        if (r32 == 0) goto L_0x0209;
    L_0x0203:
        r1 = -110; // 0xffffffffffffff92 float:NaN double:NaN;
    L_0x0205:
        r5.setDownloadInterruptCode(r1);
        goto L_0x020c;
    L_0x0209:
        r1 = -210; // 0xffffffffffffff2e float:NaN double:NaN;
        goto L_0x0205;
    L_0x020c:
        r1 = c;
        if (r12 != r4) goto L_0x0211;
    L_0x0210:
        goto L_0x0212;
    L_0x0211:
        r4 = 0;
    L_0x0212:
        com.tencent.smtt.sdk.QbSdk.reset(r1, r4);
        r1 = 0;
        return r1;
    L_0x0217:
        if (r13 != r4) goto L_0x021e;
    L_0x0219:
        r8 = c;
        com.tencent.smtt.sdk.QbSdk.resetDecoupleCore(r8);
    L_0x021e:
        if (r15 != r4) goto L_0x0230;
    L_0x0220:
        r8 = d;
        r9 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        r8.removeMessages(r9);
        r8 = d;
        r8 = android.os.Message.obtain(r8, r9);
        r8.sendToTarget();
    L_0x0230:
        r8 = 86400; // 0x15180 float:1.21072E-40 double:4.26873E-319;
        if (r7 != r4) goto L_0x0246;
    L_0x0235:
        r11 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
        r4 = (r21 > r11 ? 1 : (r21 == r11 ? 0 : -1));
        if (r4 <= 0) goto L_0x023d;
    L_0x023c:
        goto L_0x023f;
    L_0x023d:
        r11 = r21;
    L_0x023f:
        r13 = 0;
        r4 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1));
        if (r4 <= 0) goto L_0x0248;
    L_0x0245:
        goto L_0x0249;
    L_0x0246:
        r13 = 0;
    L_0x0248:
        r11 = r8;
    L_0x0249:
        r7 = getRetryIntervalInSeconds();
        r4 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1));
        if (r4 < 0) goto L_0x0255;
    L_0x0251:
        r11 = getRetryIntervalInSeconds();
    L_0x0255:
        r4 = r5.a;
        r7 = "retry_interval";
        r8 = java.lang.Long.valueOf(r11);
        r4.put(r7, r8);
        if (r32 == 0) goto L_0x0269;
    L_0x0262:
        r4 = "DECOUPLECOREVERSION";	 Catch:{ Exception -> 0x0279 }
        r7 = r6.getInt(r4);	 Catch:{ Exception -> 0x0279 }
        goto L_0x027a;	 Catch:{ Exception -> 0x0279 }
    L_0x0269:
        r4 = c;	 Catch:{ Exception -> 0x0279 }
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);	 Catch:{ Exception -> 0x0279 }
        r4 = r4.mPreferences;	 Catch:{ Exception -> 0x0279 }
        r7 = "tbs_decouplecoreversion";	 Catch:{ Exception -> 0x0279 }
        r8 = 0;	 Catch:{ Exception -> 0x0279 }
        r7 = r4.getInt(r7, r8);	 Catch:{ Exception -> 0x0279 }
        goto L_0x027a;
    L_0x0279:
        r7 = 0;
    L_0x027a:
        r4 = c;	 Catch:{ Exception -> 0x028a }
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);	 Catch:{ Exception -> 0x028a }
        r4 = r4.mPreferences;	 Catch:{ Exception -> 0x028a }
        r8 = "tbs_downloaddecouplecore";	 Catch:{ Exception -> 0x028a }
        r9 = 0;	 Catch:{ Exception -> 0x028a }
        r4 = r4.getInt(r8, r9);	 Catch:{ Exception -> 0x028a }
        goto L_0x028b;
    L_0x028a:
        r4 = 0;
    L_0x028b:
        if (r32 == 0) goto L_0x02a1;
    L_0x028d:
        r8 = c;
        r8 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r8);
        if (r8 != 0) goto L_0x02a1;
    L_0x0295:
        if (r7 != 0) goto L_0x02a1;
    L_0x0297:
        r7 = com.tencent.smtt.sdk.aj.a();
        r8 = c;
        r7 = r7.f(r8);
    L_0x02a1:
        r8 = "TbsDownload";
        r9 = new java.lang.StringBuilder;
        r11 = "in response decoupleCoreVersion is ";
        r9.<init>(r11);
        r9.append(r7);
        r9 = r9.toString();
        com.tencent.smtt.utils.TbsLog.i(r8, r9);
        r8 = r5.a;
        r9 = "tbs_decouplecoreversion";
        r11 = java.lang.Integer.valueOf(r7);
        r8.put(r9, r11);
        r8 = r5.a;
        r9 = "tbs_downloaddecouplecore";
        r11 = java.lang.Integer.valueOf(r4);
        r8.put(r9, r11);
        r8 = c;
        r8 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r8);
        if (r8 != 0) goto L_0x0305;
    L_0x02d2:
        if (r7 <= 0) goto L_0x02f6;
    L_0x02d4:
        r8 = com.tencent.smtt.sdk.aj.a();
        r9 = c;
        r8 = r8.f(r9);
        if (r7 == r8) goto L_0x02f6;
    L_0x02e0:
        r8 = com.tencent.smtt.sdk.aj.a();
        r9 = c;
        r8 = r8.g(r9);
        if (r7 != r8) goto L_0x02f6;
    L_0x02ec:
        r7 = com.tencent.smtt.sdk.aj.a();
        r8 = c;
        r7.j(r8);
        goto L_0x0305;
    L_0x02f6:
        if (r7 != 0) goto L_0x0305;
    L_0x02f8:
        r7 = com.tencent.smtt.sdk.aj.a();	 Catch:{ Throwable -> 0x0305 }
        r8 = c;	 Catch:{ Throwable -> 0x0305 }
        r7 = r7.l(r8);	 Catch:{ Throwable -> 0x0305 }
        com.tencent.smtt.utils.k.b(r7);	 Catch:{ Throwable -> 0x0305 }
    L_0x0305:
        r7 = r16;
        r8 = android.text.TextUtils.isEmpty(r7);
        if (r8 == 0) goto L_0x032c;
    L_0x030d:
        r8 = c;
        r8 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r8);
        if (r8 == 0) goto L_0x032c;
    L_0x0315:
        r1 = r5.a;
        r2 = "tbs_needdownload";
        r4 = 0;
        r6 = java.lang.Boolean.valueOf(r4);
        r1.put(r2, r6);
        r5.commit();
        if (r32 == 0) goto L_0x032b;
    L_0x0326:
        r1 = c;
        com.tencent.smtt.sdk.TbsShareManager.writeCoreInfoForThirdPartyApp(r1, r10, r4);
    L_0x032b:
        return r4;
    L_0x032c:
        r8 = "TbsDownload";
        r9 = new java.lang.StringBuilder;
        r11 = "in response responseCode is ";
        r9.<init>(r11);
        r9.append(r1);
        r9 = r9.toString();
        com.tencent.smtt.utils.TbsLog.i(r8, r9);
        if (r1 != 0) goto L_0x0388;
    L_0x0341:
        r2 = r5.a;
        r4 = "tbs_responsecode";
        r1 = java.lang.Integer.valueOf(r1);
        r2.put(r4, r1);
        r1 = r5.a;
        r2 = "tbs_needdownload";
        r4 = 0;
        r6 = java.lang.Boolean.valueOf(r4);
        r1.put(r2, r6);
        if (r32 == 0) goto L_0x0368;
    L_0x035a:
        r1 = r5.a;
        r2 = "tbs_download_interrupt_code_reason";
        r3 = -111; // 0xffffffffffffff91 float:NaN double:NaN;
        r3 = java.lang.Integer.valueOf(r3);
        r1.put(r2, r3);
        goto L_0x0378;
    L_0x0368:
        r1 = r5.a;
        r2 = "tbs_download_interrupt_code_reason";
        r3 = -211; // 0xffffffffffffff2d float:NaN double:NaN;
        r4 = java.lang.Integer.valueOf(r3);
        r1.put(r2, r4);
        r5.setDownloadInterruptCode(r3);
    L_0x0378:
        r5.commit();
        r1 = c;
        r1 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r1);
        if (r1 != 0) goto L_0x0386;
    L_0x0383:
        startDecoupleCoreIfNeeded();
    L_0x0386:
        r8 = 0;
        return r8;
    L_0x0388:
        r8 = 0;
        r9 = c;
        r9 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r9);
        r9 = r9.mPreferences;
        r11 = "tbs_download_version";
        r9 = r9.getInt(r11, r8);
        if (r9 <= r10) goto L_0x03a7;
    L_0x0399:
        r8 = g;
        r8.c();
        r8 = com.tencent.smtt.sdk.aj.a();
        r11 = c;
        r8.k(r11);
    L_0x03a7:
        r8 = c;
        r8 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r8);
        if (r8 != 0) goto L_0x03da;
    L_0x03af:
        r8 = com.tencent.smtt.sdk.aj.a();
        r11 = c;
        r8 = r8.e(r11);
        if (r8 < r10) goto L_0x03bd;
    L_0x03bb:
        r11 = 1;
        goto L_0x03be;
    L_0x03bd:
        r11 = 0;
    L_0x03be:
        r12 = "TbsDownload";
        r13 = new java.lang.StringBuilder;
        r14 = "tmpCoreVersion is ";
        r13.<init>(r14);
        r13.append(r8);
        r8 = " tbsDownloadVersion is";
        r13.append(r8);
        r13.append(r10);
        r8 = r13.toString();
        com.tencent.smtt.utils.TbsLog.i(r12, r8);
        goto L_0x03db;
    L_0x03da:
        r11 = 0;
    L_0x03db:
        if (r2 >= r10) goto L_0x03e5;
    L_0x03dd:
        r8 = android.text.TextUtils.isEmpty(r7);
        if (r8 != 0) goto L_0x03e5;
    L_0x03e3:
        if (r11 == 0) goto L_0x0475;
    L_0x03e5:
        r8 = 1;
        if (r4 == r8) goto L_0x0475;
    L_0x03e8:
        r1 = r5.a;
        r4 = "tbs_needdownload";
        r6 = 0;
        r8 = java.lang.Boolean.valueOf(r6);
        r1.put(r4, r8);
        if (r32 == 0) goto L_0x0423;
    L_0x03f6:
        r1 = android.text.TextUtils.isEmpty(r7);
        if (r1 == 0) goto L_0x040a;
    L_0x03fc:
        r1 = r5.a;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -124; // 0xffffffffffffff84 float:NaN double:NaN;
    L_0x0402:
        r4 = java.lang.Integer.valueOf(r4);
        r1.put(r3, r4);
        goto L_0x0445;
    L_0x040a:
        if (r10 > 0) goto L_0x0413;
    L_0x040c:
        r1 = r5.a;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -125; // 0xffffffffffffff83 float:NaN double:NaN;
        goto L_0x0402;
    L_0x0413:
        if (r2 < r10) goto L_0x041c;
    L_0x0415:
        r1 = r5.a;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -127; // 0xffffffffffffff81 float:NaN double:NaN;
        goto L_0x0402;
    L_0x041c:
        r1 = r5.a;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -112; // 0xffffffffffffff90 float:NaN double:NaN;
        goto L_0x0402;
    L_0x0423:
        r1 = -212; // 0xffffffffffffff2c float:NaN double:NaN;
        r3 = android.text.TextUtils.isEmpty(r7);
        if (r3 == 0) goto L_0x042e;
    L_0x042b:
        r1 = -217; // 0xffffffffffffff27 float:NaN double:NaN;
        goto L_0x0437;
    L_0x042e:
        if (r10 > 0) goto L_0x0433;
    L_0x0430:
        r1 = -218; // 0xffffffffffffff26 float:NaN double:NaN;
        goto L_0x0437;
    L_0x0433:
        if (r2 < r10) goto L_0x0437;
    L_0x0435:
        r1 = -219; // 0xffffffffffffff25 float:NaN double:NaN;
    L_0x0437:
        r3 = r5.a;
        r4 = "tbs_download_interrupt_code_reason";
        r6 = java.lang.Integer.valueOf(r1);
        r3.put(r4, r6);
        r5.setDownloadInterruptCode(r1);
    L_0x0445:
        r5.commit();
        r1 = "TbsDownload";
        r3 = new java.lang.StringBuilder;
        r4 = "version error or downloadUrl empty ,return ahead tbsLocalVersion=";
        r3.<init>(r4);
        r3.append(r2);
        r2 = " tbsDownloadVersion=";
        r3.append(r2);
        r3.append(r10);
        r2 = " tbsLastDownloadVersion=";
        r3.append(r2);
        r3.append(r9);
        r2 = " downloadUrl=";
        r3.append(r2);
        r3.append(r7);
        r2 = r3.toString();
        com.tencent.smtt.utils.TbsLog.i(r1, r2);
        r2 = 0;
        return r2;
    L_0x0475:
        r2 = 0;
        r8 = r5.mPreferences;
        r9 = "tbs_downloadurl";
        r11 = 0;
        r8 = r8.getString(r9, r11);
        r8 = r7.equals(r8);
        if (r8 != 0) goto L_0x04a0;
    L_0x0485:
        r8 = g;
        r8.c();
        r8 = r5.a;
        r9 = "tbs_download_failed_retrytimes";
        r11 = java.lang.Integer.valueOf(r2);
        r8.put(r9, r11);
        r8 = r5.a;
        r9 = "tbs_download_success_retrytimes";
        r11 = java.lang.Integer.valueOf(r2);
        r8.put(r9, r11);
    L_0x04a0:
        r2 = r5.a;
        r8 = "tbs_download_version";
        r9 = java.lang.Integer.valueOf(r10);
        r2.put(r8, r9);
        r2 = "TbsDownload";
        r8 = new java.lang.StringBuilder;
        r9 = "put KEY_TBS_DOWNLOAD_V is ";
        r8.<init>(r9);
        r8.append(r10);
        r8 = r8.toString();
        com.tencent.smtt.utils.TbsLog.i(r2, r8);
        if (r10 <= 0) goto L_0x04ee;
    L_0x04c0:
        r2 = 1;
        if (r4 != r2) goto L_0x04cf;
    L_0x04c3:
        r8 = r5.a;
        r9 = "tbs_download_version_type";
        r11 = java.lang.Integer.valueOf(r2);
        r8.put(r9, r11);
        goto L_0x04db;
    L_0x04cf:
        r2 = r5.a;
        r8 = "tbs_download_version_type";
        r9 = 0;
        r11 = java.lang.Integer.valueOf(r9);
        r2.put(r8, r11);
    L_0x04db:
        r2 = "TbsDownload";
        r8 = new java.lang.StringBuilder;
        r9 = "put KEY_TBS_DOWNLOAD_V_TYPE is ";
        r8.<init>(r9);
        r8.append(r4);
        r4 = r8.toString();
        com.tencent.smtt.utils.TbsLog.i(r2, r4);
    L_0x04ee:
        r2 = r5.a;
        r4 = "tbs_downloadurl";
        r2.put(r4, r7);
        r2 = r5.a;
        r4 = "tbs_downloadurl_list";
        r7 = r29;
        r2.put(r4, r7);
        r2 = r5.a;
        r4 = "tbs_responsecode";
        r7 = java.lang.Integer.valueOf(r1);
        r2.put(r4, r7);
        r2 = r5.a;
        r4 = "tbs_download_maxflow";
        r7 = r28;
        r7 = java.lang.Integer.valueOf(r7);
        r2.put(r4, r7);
        r2 = r5.a;
        r4 = "tbs_download_min_free_space";
        r7 = r27;
        r7 = java.lang.Integer.valueOf(r7);
        r2.put(r4, r7);
        r2 = r5.a;
        r4 = "tbs_download_success_max_retrytimes";
        r7 = r24;
        r7 = java.lang.Integer.valueOf(r7);
        r2.put(r4, r7);
        r2 = r5.a;
        r4 = "tbs_download_failed_max_retrytimes";
        r7 = r23;
        r7 = java.lang.Integer.valueOf(r7);
        r2.put(r4, r7);
        r2 = r5.a;
        r4 = "tbs_single_timeout";
        r7 = r17;
        r7 = java.lang.Long.valueOf(r7);
        r2.put(r4, r7);
        r2 = r5.a;
        r4 = "tbs_apkfilesize";
        r7 = r19;
        r7 = java.lang.Long.valueOf(r7);
        r2.put(r4, r7);
        r5.commit();
        if (r26 == 0) goto L_0x0565;
    L_0x055c:
        r2 = r5.a;
        r4 = "tbs_apk_md5";
        r13 = r26;
        r2.put(r4, r13);
    L_0x0565:
        r2 = r33;
        if (r2 != 0) goto L_0x05a4;
    L_0x0569:
        r4 = com.tencent.smtt.sdk.aj.a();
        r7 = c;
        r4 = r4.a(r7, r10);
        if (r4 == 0) goto L_0x05a4;
    L_0x0575:
        if (r32 == 0) goto L_0x0585;
    L_0x0577:
        r1 = r5.a;
        r2 = "tbs_download_interrupt_code_reason";
        r3 = -113; // 0xffffffffffffff8f float:NaN double:NaN;
        r3 = java.lang.Integer.valueOf(r3);
        r1.put(r2, r3);
        goto L_0x0595;
    L_0x0585:
        r1 = r5.a;
        r2 = "tbs_download_interrupt_code_reason";
        r3 = -213; // 0xffffffffffffff2b float:NaN double:NaN;
        r4 = java.lang.Integer.valueOf(r3);
        r1.put(r2, r4);
        r5.setDownloadInterruptCode(r3);
    L_0x0595:
        r1 = r5.a;
        r2 = "tbs_needdownload";
        r3 = 0;
        r4 = java.lang.Boolean.valueOf(r3);
        r1.put(r2, r4);
    L_0x05a1:
        r3 = 1;
        goto L_0x0622;
    L_0x05a4:
        if (r2 != 0) goto L_0x060f;
    L_0x05a6:
        r4 = g;
        r7 = 1;
        if (r1 == r7) goto L_0x05b1;
    L_0x05ab:
        r7 = 2;
        if (r1 != r7) goto L_0x05af;
    L_0x05ae:
        goto L_0x05b1;
    L_0x05af:
        r1 = 0;
        goto L_0x05b2;
    L_0x05b1:
        r1 = 1;
    L_0x05b2:
        r1 = r4.a(r2, r1);
        if (r1 == 0) goto L_0x060f;
    L_0x05b8:
        r1 = r5.a;
        r2 = "tbs_needdownload";
        r3 = 0;
        r4 = java.lang.Boolean.valueOf(r3);
        r1.put(r2, r4);
        r1 = c;
        r1 = com.tencent.smtt.sdk.TbsLogReport.a(r1);
        r1 = r1.a();
        r2 = 100;
        r1.setErrorCode(r2);
        r2 = new java.lang.StringBuilder;
        r3 = "use local backup apk in needDownload";
        r2.<init>(r3);
        r3 = g;
        r3 = r3.a;
        r2.append(r3);
        r2 = r2.toString();
        r1.setFailDetail(r2);
        r2 = c;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r2 = r2.mPreferences;
        r3 = "tbs_downloaddecouplecore";
        r4 = 0;
        r2 = r2.getInt(r3, r4);
        r3 = 1;
        if (r2 != r3) goto L_0x0606;
    L_0x05fa:
        r2 = c;
        r2 = com.tencent.smtt.sdk.TbsLogReport.a(r2);
        r3 = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
    L_0x0602:
        r2.a(r3, r1);
        goto L_0x05a1;
    L_0x0606:
        r2 = c;
        r2 = com.tencent.smtt.sdk.TbsLogReport.a(r2);
        r3 = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD;
        goto L_0x0602;
    L_0x060f:
        if (r32 != 0) goto L_0x0616;
    L_0x0611:
        r1 = -216; // 0xffffffffffffff28 float:NaN double:NaN;
        r5.setDownloadInterruptCode(r1);
    L_0x0616:
        r1 = r5.a;
        r2 = "tbs_needdownload";
        r3 = 1;
        r4 = java.lang.Boolean.valueOf(r3);
        r1.put(r2, r4);
    L_0x0622:
        r1 = "stop_pre_oat";
        r2 = 0;
        r1 = r6.optInt(r1, r2);
        if (r1 != r3) goto L_0x0636;
    L_0x062b:
        r1 = r5.a;
        r2 = "tbs_stop_preoat";
        r4 = java.lang.Boolean.valueOf(r3);
        r1.put(r2, r4);
    L_0x0636:
        r5.commit();
        return r3;
    L_0x063a:
        monitor-exit(r25);	 Catch:{ all -> 0x01c8 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.a(java.lang.String, int, boolean, boolean):boolean");
    }

    private static org.json.JSONObject b(boolean r12, boolean r13, boolean r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "TbsDownload";
        r1 = new java.lang.StringBuilder;
        r2 = "[TbsDownloader.postJsonData]isQuery: ";
        r1.<init>(r2);
        r1.append(r12);
        r2 = " forDecoupleCore is ";
        r1.append(r2);
        r1.append(r14);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        r0 = c;
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r0);
        r1 = c;
        r1 = a(r1);
        r2 = c;
        r2 = com.tencent.smtt.utils.b.d(r2);
        r3 = c;
        r3 = com.tencent.smtt.utils.b.c(r3);
        r4 = c;
        r4 = com.tencent.smtt.utils.b.f(r4);
        r5 = "";
        r6 = "";
        r7 = java.util.TimeZone.getDefault();
        r7 = r7.getID();
        if (r7 == 0) goto L_0x0048;
    L_0x0047:
        r5 = r7;
    L_0x0048:
        r8 = c;	 Catch:{ Exception -> 0x005a }
        r9 = "phone";	 Catch:{ Exception -> 0x005a }
        r8 = r8.getSystemService(r9);	 Catch:{ Exception -> 0x005a }
        r8 = (android.telephony.TelephonyManager) r8;	 Catch:{ Exception -> 0x005a }
        if (r8 == 0) goto L_0x005e;	 Catch:{ Exception -> 0x005a }
    L_0x0054:
        r8 = r8.getSimCountryIso();	 Catch:{ Exception -> 0x005a }
        r7 = r8;
        goto L_0x005e;
    L_0x005a:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x005e:
        if (r7 == 0) goto L_0x0061;
    L_0x0060:
        r6 = r7;
    L_0x0061:
        r7 = new org.json.JSONObject;
        r7.<init>();
        r8 = "TIMEZONEID";	 Catch:{ Exception -> 0x0232 }
        r7.put(r8, r5);	 Catch:{ Exception -> 0x0232 }
        r5 = "COUNTRYISO";	 Catch:{ Exception -> 0x0232 }
        r7.put(r5, r6);	 Catch:{ Exception -> 0x0232 }
        r5 = "PROTOCOLVERSION";	 Catch:{ Exception -> 0x0232 }
        r6 = 1;	 Catch:{ Exception -> 0x0232 }
        r7.put(r5, r6);	 Catch:{ Exception -> 0x0232 }
        r5 = c;	 Catch:{ Exception -> 0x0232 }
        r5 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r5);	 Catch:{ Exception -> 0x0232 }
        r8 = 0;	 Catch:{ Exception -> 0x0232 }
        if (r5 == 0) goto L_0x0099;	 Catch:{ Exception -> 0x0232 }
    L_0x007f:
        r5 = com.tencent.smtt.sdk.QbSdk.c;	 Catch:{ Exception -> 0x0232 }
        if (r5 == 0) goto L_0x008a;	 Catch:{ Exception -> 0x0232 }
    L_0x0083:
        r5 = c;	 Catch:{ Exception -> 0x0232 }
        r5 = com.tencent.smtt.sdk.TbsShareManager.a(r5, r8);	 Catch:{ Exception -> 0x0232 }
        goto L_0x00dd;	 Catch:{ Exception -> 0x0232 }
    L_0x008a:
        r5 = c;	 Catch:{ Exception -> 0x0232 }
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);	 Catch:{ Exception -> 0x0232 }
        r5 = r5.mPreferences;	 Catch:{ Exception -> 0x0232 }
        r9 = "tbs_download_version";	 Catch:{ Exception -> 0x0232 }
        r5 = r5.getInt(r9, r8);	 Catch:{ Exception -> 0x0232 }
        goto L_0x00dd;	 Catch:{ Exception -> 0x0232 }
    L_0x0099:
        r5 = com.tencent.smtt.sdk.aj.a();	 Catch:{ Exception -> 0x0232 }
        r9 = c;	 Catch:{ Exception -> 0x0232 }
        r5 = r5.i(r9);	 Catch:{ Exception -> 0x0232 }
        if (r5 != 0) goto L_0x00b2;	 Catch:{ Exception -> 0x0232 }
    L_0x00a5:
        r9 = com.tencent.smtt.sdk.aj.a();	 Catch:{ Exception -> 0x0232 }
        r10 = c;	 Catch:{ Exception -> 0x0232 }
        r9 = r9.h(r10);	 Catch:{ Exception -> 0x0232 }
        if (r9 == 0) goto L_0x00b2;	 Catch:{ Exception -> 0x0232 }
    L_0x00b1:
        r5 = -1;	 Catch:{ Exception -> 0x0232 }
    L_0x00b2:
        r9 = "TbsDownload";	 Catch:{ Exception -> 0x0232 }
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0232 }
        r11 = "[TbsDownloader.postJsonData] tbsLocalVersion=";	 Catch:{ Exception -> 0x0232 }
        r10.<init>(r11);	 Catch:{ Exception -> 0x0232 }
        r10.append(r5);	 Catch:{ Exception -> 0x0232 }
        r11 = " isDownloadForeground=";	 Catch:{ Exception -> 0x0232 }
        r10.append(r11);	 Catch:{ Exception -> 0x0232 }
        r10.append(r13);	 Catch:{ Exception -> 0x0232 }
        r10 = r10.toString();	 Catch:{ Exception -> 0x0232 }
        com.tencent.smtt.utils.TbsLog.i(r9, r10);	 Catch:{ Exception -> 0x0232 }
        if (r13 == 0) goto L_0x00dd;	 Catch:{ Exception -> 0x0232 }
    L_0x00cf:
        r9 = com.tencent.smtt.sdk.aj.a();	 Catch:{ Exception -> 0x0232 }
        r10 = c;	 Catch:{ Exception -> 0x0232 }
        r9 = r9.h(r10);	 Catch:{ Exception -> 0x0232 }
        if (r9 == 0) goto L_0x00dc;	 Catch:{ Exception -> 0x0232 }
    L_0x00db:
        goto L_0x00dd;	 Catch:{ Exception -> 0x0232 }
    L_0x00dc:
        r5 = r8;	 Catch:{ Exception -> 0x0232 }
    L_0x00dd:
        if (r12 == 0) goto L_0x00e6;	 Catch:{ Exception -> 0x0232 }
    L_0x00df:
        r9 = "FUNCTION";	 Catch:{ Exception -> 0x0232 }
        r10 = 2;	 Catch:{ Exception -> 0x0232 }
        r7.put(r9, r10);	 Catch:{ Exception -> 0x0232 }
        goto L_0x00f0;	 Catch:{ Exception -> 0x0232 }
    L_0x00e6:
        r9 = "FUNCTION";	 Catch:{ Exception -> 0x0232 }
        if (r5 != 0) goto L_0x00ec;	 Catch:{ Exception -> 0x0232 }
    L_0x00ea:
        r10 = r8;	 Catch:{ Exception -> 0x0232 }
        goto L_0x00ed;	 Catch:{ Exception -> 0x0232 }
    L_0x00ec:
        r10 = r6;	 Catch:{ Exception -> 0x0232 }
    L_0x00ed:
        r7.put(r9, r10);	 Catch:{ Exception -> 0x0232 }
    L_0x00f0:
        r9 = c;	 Catch:{ Exception -> 0x0232 }
        r9 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r9);	 Catch:{ Exception -> 0x0232 }
        if (r9 == 0) goto L_0x0119;	 Catch:{ Exception -> 0x0232 }
    L_0x00f8:
        r12 = f();	 Catch:{ Exception -> 0x0232 }
        r9 = "TBSVLARR";	 Catch:{ Exception -> 0x0232 }
        r7.put(r9, r12);	 Catch:{ Exception -> 0x0232 }
        r9 = r0.a;	 Catch:{ Exception -> 0x0232 }
        r10 = "last_thirdapp_sendrequest_coreversion";	 Catch:{ Exception -> 0x0232 }
        r12 = r12.toString();	 Catch:{ Exception -> 0x0232 }
        r9.put(r10, r12);	 Catch:{ Exception -> 0x0232 }
        r0.commit();	 Catch:{ Exception -> 0x0232 }
        r12 = com.tencent.smtt.sdk.QbSdk.c;	 Catch:{ Exception -> 0x0232 }
        if (r12 == 0) goto L_0x0135;	 Catch:{ Exception -> 0x0232 }
    L_0x0113:
        r12 = "THIRDREQ";	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r6);	 Catch:{ Exception -> 0x0232 }
        goto L_0x0135;	 Catch:{ Exception -> 0x0232 }
    L_0x0119:
        r9 = h();	 Catch:{ Exception -> 0x0232 }
        r10 = c;	 Catch:{ Exception -> 0x0232 }
        r10 = com.tencent.smtt.utils.Apn.getApnType(r10);	 Catch:{ Exception -> 0x0232 }
        r11 = 3;	 Catch:{ Exception -> 0x0232 }
        if (r10 == r11) goto L_0x0135;	 Catch:{ Exception -> 0x0232 }
    L_0x0126:
        r10 = r9.length();	 Catch:{ Exception -> 0x0232 }
        if (r10 == 0) goto L_0x0135;	 Catch:{ Exception -> 0x0232 }
    L_0x012c:
        if (r5 != 0) goto L_0x0135;	 Catch:{ Exception -> 0x0232 }
    L_0x012e:
        if (r12 == 0) goto L_0x0135;	 Catch:{ Exception -> 0x0232 }
    L_0x0130:
        r12 = "TBSBACKUPARR";	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r9);	 Catch:{ Exception -> 0x0232 }
    L_0x0135:
        r12 = c;	 Catch:{ Exception -> 0x0232 }
        r12 = r12.getPackageName();	 Catch:{ Exception -> 0x0232 }
        r9 = "APPN";	 Catch:{ Exception -> 0x0232 }
        r7.put(r9, r12);	 Catch:{ Exception -> 0x0232 }
        r12 = "APPVN";	 Catch:{ Exception -> 0x0232 }
        r9 = r0.mPreferences;	 Catch:{ Exception -> 0x0232 }
        r10 = "app_versionname";	 Catch:{ Exception -> 0x0232 }
        r11 = 0;	 Catch:{ Exception -> 0x0232 }
        r9 = r9.getString(r10, r11);	 Catch:{ Exception -> 0x0232 }
        r9 = a(r9);	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r9);	 Catch:{ Exception -> 0x0232 }
        r12 = "APPVC";	 Catch:{ Exception -> 0x0232 }
        r9 = r0.mPreferences;	 Catch:{ Exception -> 0x0232 }
        r10 = "app_versioncode";	 Catch:{ Exception -> 0x0232 }
        r9 = r9.getInt(r10, r8);	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r9);	 Catch:{ Exception -> 0x0232 }
        r12 = "APPMETA";	 Catch:{ Exception -> 0x0232 }
        r9 = r0.mPreferences;	 Catch:{ Exception -> 0x0232 }
        r10 = "app_metadata";	 Catch:{ Exception -> 0x0232 }
        r9 = r9.getString(r10, r11);	 Catch:{ Exception -> 0x0232 }
        r9 = a(r9);	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r9);	 Catch:{ Exception -> 0x0232 }
        r12 = "TBSSDKV";	 Catch:{ Exception -> 0x0232 }
        r9 = 43500; // 0xa9ec float:6.0956E-41 double:2.1492E-319;	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r9);	 Catch:{ Exception -> 0x0232 }
        r12 = "TBSV";	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r5);	 Catch:{ Exception -> 0x0232 }
        r12 = "DOWNLOADDECOUPLECORE";	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r14);	 Catch:{ Exception -> 0x0232 }
        r12 = r0.a;	 Catch:{ Exception -> 0x0232 }
        r9 = "tbs_downloaddecouplecore";	 Catch:{ Exception -> 0x0232 }
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ Exception -> 0x0232 }
        r12.put(r9, r14);	 Catch:{ Exception -> 0x0232 }
        r0.commit();	 Catch:{ Exception -> 0x0232 }
        if (r5 == 0) goto L_0x019d;	 Catch:{ Exception -> 0x0232 }
    L_0x0192:
        r12 = "TBSBACKUPV";	 Catch:{ Exception -> 0x0232 }
        r14 = g;	 Catch:{ Exception -> 0x0232 }
        r14 = r14.a();	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r14);	 Catch:{ Exception -> 0x0232 }
    L_0x019d:
        r12 = "CPU";	 Catch:{ Exception -> 0x0232 }
        r14 = e;	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r14);	 Catch:{ Exception -> 0x0232 }
        r12 = "UA";	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r1);	 Catch:{ Exception -> 0x0232 }
        r12 = "IMSI";	 Catch:{ Exception -> 0x0232 }
        r14 = a(r2);	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r14);	 Catch:{ Exception -> 0x0232 }
        r12 = "IMEI";	 Catch:{ Exception -> 0x0232 }
        r14 = a(r3);	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r14);	 Catch:{ Exception -> 0x0232 }
        r12 = "ANDROID_ID";	 Catch:{ Exception -> 0x0232 }
        r14 = a(r4);	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r14);	 Catch:{ Exception -> 0x0232 }
        r12 = c;	 Catch:{ Exception -> 0x0232 }
        r12 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r12);	 Catch:{ Exception -> 0x0232 }
        if (r12 != 0) goto L_0x01ef;	 Catch:{ Exception -> 0x0232 }
    L_0x01cc:
        if (r5 == 0) goto L_0x01db;	 Catch:{ Exception -> 0x0232 }
    L_0x01ce:
        r12 = "STATUS";	 Catch:{ Exception -> 0x0232 }
        r14 = c;	 Catch:{ Exception -> 0x0232 }
        r14 = com.tencent.smtt.sdk.QbSdk.a(r14, r5);	 Catch:{ Exception -> 0x0232 }
        r14 = r14 ^ r6;	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r14);	 Catch:{ Exception -> 0x0232 }
        goto L_0x01e0;	 Catch:{ Exception -> 0x0232 }
    L_0x01db:
        r12 = "STATUS";	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r8);	 Catch:{ Exception -> 0x0232 }
    L_0x01e0:
        r12 = "TBSDV";	 Catch:{ Exception -> 0x0232 }
        r14 = com.tencent.smtt.sdk.aj.a();	 Catch:{ Exception -> 0x0232 }
        r0 = c;	 Catch:{ Exception -> 0x0232 }
        r14 = r14.f(r0);	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r14);	 Catch:{ Exception -> 0x0232 }
    L_0x01ef:
        r12 = c;	 Catch:{ Exception -> 0x0232 }
        r12 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r12);	 Catch:{ Exception -> 0x0232 }
        r12 = r12.mPreferences;	 Catch:{ Exception -> 0x0232 }
        r14 = "request_full_package";	 Catch:{ Exception -> 0x0232 }
        r12 = r12.getBoolean(r14, r8);	 Catch:{ Exception -> 0x0232 }
        r14 = c;	 Catch:{ Exception -> 0x0232 }
        r0 = "can_unlzma";	 Catch:{ Exception -> 0x0232 }
        r14 = com.tencent.smtt.sdk.QbSdk.a(r14, r0, r11);	 Catch:{ Exception -> 0x0232 }
        if (r14 == 0) goto L_0x0212;	 Catch:{ Exception -> 0x0232 }
    L_0x0207:
        r0 = r14 instanceof java.lang.Boolean;	 Catch:{ Exception -> 0x0232 }
        if (r0 == 0) goto L_0x0212;	 Catch:{ Exception -> 0x0232 }
    L_0x020b:
        r14 = (java.lang.Boolean) r14;	 Catch:{ Exception -> 0x0232 }
        r14 = r14.booleanValue();	 Catch:{ Exception -> 0x0232 }
        goto L_0x0213;	 Catch:{ Exception -> 0x0232 }
    L_0x0212:
        r14 = r8;	 Catch:{ Exception -> 0x0232 }
    L_0x0213:
        if (r14 == 0) goto L_0x0217;	 Catch:{ Exception -> 0x0232 }
    L_0x0215:
        r8 = r12 ^ 1;	 Catch:{ Exception -> 0x0232 }
    L_0x0217:
        if (r8 == 0) goto L_0x021e;	 Catch:{ Exception -> 0x0232 }
    L_0x0219:
        r12 = "REQUEST_LZMA";	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r6);	 Catch:{ Exception -> 0x0232 }
    L_0x021e:
        r12 = c;	 Catch:{ Exception -> 0x0232 }
        r12 = getOverSea(r12);	 Catch:{ Exception -> 0x0232 }
        if (r12 == 0) goto L_0x022b;	 Catch:{ Exception -> 0x0232 }
    L_0x0226:
        r12 = "OVERSEA";	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r6);	 Catch:{ Exception -> 0x0232 }
    L_0x022b:
        if (r13 == 0) goto L_0x0232;	 Catch:{ Exception -> 0x0232 }
    L_0x022d:
        r12 = "DOWNLOAD_FOREGROUND";	 Catch:{ Exception -> 0x0232 }
        r7.put(r12, r6);	 Catch:{ Exception -> 0x0232 }
    L_0x0232:
        r12 = "TbsDownload";
        r13 = new java.lang.StringBuilder;
        r14 = "[TbsDownloader.postJsonData] jsonData=";
        r13.<init>(r14);
        r14 = r7.toString();
        r13.append(r14);
        r13 = r13.toString();
        com.tencent.smtt.utils.TbsLog.i(r12, r13);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.b(boolean, boolean, boolean):org.json.JSONObject");
    }

    @TargetApi(11)
    static void b(Context context) {
        TbsDownloadConfig.getInstance(context).clear();
        TbsLogReport.a(context).d();
        ad.c(context);
        (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_extension_config", 4) : context.getSharedPreferences("tbs_extension_config", 0)).edit().clear().commit();
        (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit().clear().commit();
    }

    private static boolean b(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    private static boolean c() {
        try {
            for (String sharedTbsCoreVersion : TbsShareManager.getCoreProviderAppList()) {
                if (TbsShareManager.getSharedTbsCoreVersion(c, sharedTbsCoreVersion) > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean c(boolean r9, boolean r10, boolean r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "TbsDownload";
        r1 = new java.lang.StringBuilder;
        r2 = "[TbsDownloader.sendRequest]isQuery: ";
        r1.<init>(r2);
        r1.append(r9);
        r2 = " forDecoupleCore is ";
        r1.append(r2);
        r1.append(r11);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        r0 = com.tencent.smtt.sdk.aj.a();
        r1 = c;
        r0 = r0.c(r1);
        r1 = 0;
        if (r0 == 0) goto L_0x0030;
    L_0x0028:
        r9 = "TbsDownload";
        r10 = "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!";
        com.tencent.smtt.utils.TbsLog.i(r9, r10);
        return r1;
    L_0x0030:
        r0 = c;
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r0);
        r2 = new java.io.File;
        r3 = c;
        r4 = 1;
        r3 = com.tencent.smtt.utils.k.a(r3, r4);
        r5 = c;
        r5 = getOverSea(r5);
        if (r5 == 0) goto L_0x004a;
    L_0x0047:
        r5 = "x5.oversea.tbs.org";
        goto L_0x004c;
    L_0x004a:
        r5 = "x5.tbs.org";
    L_0x004c:
        r2.<init>(r3, r5);
        r3 = new java.io.File;
        r5 = c;
        r6 = 2;
        r5 = com.tencent.smtt.utils.k.a(r5, r6);
        r6 = c;
        r6 = getOverSea(r6);
        if (r6 == 0) goto L_0x0063;
    L_0x0060:
        r6 = "x5.oversea.tbs.org";
        goto L_0x0065;
    L_0x0063:
        r6 = "x5.tbs.org";
    L_0x0065:
        r3.<init>(r5, r6);
        r5 = new java.io.File;
        r6 = c;
        r7 = 3;
        r6 = com.tencent.smtt.utils.k.a(r6, r7);
        r7 = c;
        r7 = getOverSea(r7);
        if (r7 == 0) goto L_0x007c;
    L_0x0079:
        r7 = "x5.oversea.tbs.org";
        goto L_0x007e;
    L_0x007c:
        r7 = "x5.tbs.org";
    L_0x007e:
        r5.<init>(r6, r7);
        r6 = new java.io.File;
        r7 = c;
        r8 = 4;
        r7 = com.tencent.smtt.utils.k.a(r7, r8);
        r8 = c;
        r8 = getOverSea(r8);
        if (r8 == 0) goto L_0x0095;
    L_0x0092:
        r8 = "x5.oversea.tbs.org";
        goto L_0x0097;
    L_0x0095:
        r8 = "x5.tbs.org";
    L_0x0097:
        r6.<init>(r7, r8);
        r7 = r6.exists();
        if (r7 != 0) goto L_0x00bd;
    L_0x00a0:
        r7 = r5.exists();
        if (r7 == 0) goto L_0x00aa;
    L_0x00a6:
        r5.renameTo(r6);
        goto L_0x00bd;
    L_0x00aa:
        r5 = r3.exists();
        if (r5 == 0) goto L_0x00b4;
    L_0x00b0:
        r3.renameTo(r6);
        goto L_0x00bd;
    L_0x00b4:
        r3 = r2.exists();
        if (r3 == 0) goto L_0x00bd;
    L_0x00ba:
        r2.renameTo(r6);
    L_0x00bd:
        r2 = e;
        if (r2 != 0) goto L_0x00d3;
    L_0x00c1:
        r2 = com.tencent.smtt.utils.b.a();
        e = r2;
        r2 = r0.a;
        r3 = "device_cpuabi";
        r5 = e;
        r2.put(r3, r5);
        r0.commit();
    L_0x00d3:
        r2 = e;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x013f;
    L_0x00db:
        r2 = 0;
        r3 = "i686|mips|x86_64";	 Catch:{ Exception -> 0x00e9 }
        r3 = java.util.regex.Pattern.compile(r3);	 Catch:{ Exception -> 0x00e9 }
        r5 = e;	 Catch:{ Exception -> 0x00e9 }
        r3 = r3.matcher(r5);	 Catch:{ Exception -> 0x00e9 }
        r2 = r3;
    L_0x00e9:
        if (r2 == 0) goto L_0x013f;
    L_0x00eb:
        r2 = r2.find();
        if (r2 == 0) goto L_0x013f;
    L_0x00f1:
        r2 = c;
        r2 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r2);
        r3 = -205; // 0xffffffffffffff33 float:NaN double:NaN;
        r5 = -104; // 0xffffffffffffff98 float:NaN double:NaN;
        if (r2 == 0) goto L_0x0135;
    L_0x00fd:
        r2 = c;
        r2 = com.tencent.smtt.sdk.TbsLogReport.a(r2);
        r2 = r2.a();
        if (r9 == 0) goto L_0x0110;
    L_0x0109:
        r0.setDownloadInterruptCode(r5);
        r2.setErrorCode(r5);
        goto L_0x0116;
    L_0x0110:
        r0.setDownloadInterruptCode(r3);
        r2.setErrorCode(r3);
    L_0x0116:
        r3 = new java.lang.StringBuilder;
        r5 = "mycpu is ";
        r3.<init>(r5);
        r5 = e;
        r3.append(r5);
        r3 = r3.toString();
        r2.setFailDetail(r3);
        r3 = c;
        r3 = com.tencent.smtt.sdk.TbsLogReport.a(r3);
        r5 = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD;
        r3.a(r5, r2);
        goto L_0x0140;
    L_0x0135:
        if (r9 == 0) goto L_0x013b;
    L_0x0137:
        r0.setDownloadInterruptCode(r5);
        goto L_0x0140;
    L_0x013b:
        r0.setDownloadInterruptCode(r3);
        goto L_0x0140;
    L_0x013f:
        r4 = r1;
    L_0x0140:
        r11 = b(r9, r10, r11);
        r2 = -1;
        r3 = "TBSV";	 Catch:{ Exception -> 0x014c }
        r3 = r11.getInt(r3);	 Catch:{ Exception -> 0x014c }
        goto L_0x014d;
    L_0x014c:
        r3 = r2;
    L_0x014d:
        if (r4 != 0) goto L_0x0151;
    L_0x014f:
        if (r3 == r2) goto L_0x0193;
    L_0x0151:
        r5 = java.lang.System.currentTimeMillis();
        r7 = r0.a;
        r8 = "last_check";
        r5 = java.lang.Long.valueOf(r5);
        r7.put(r8, r5);
        r5 = r0.a;
        r6 = "app_versionname";
        r7 = c;
        r7 = com.tencent.smtt.utils.b.a(r7);
        r5.put(r6, r7);
        r5 = r0.a;
        r6 = "app_versioncode";
        r7 = c;
        r7 = com.tencent.smtt.utils.b.b(r7);
        r7 = java.lang.Integer.valueOf(r7);
        r5.put(r6, r7);
        r5 = r0.a;
        r6 = "app_metadata";
        r7 = c;
        r8 = "com.tencent.mm.BuildInfo.CLIENT_VERSION";
        r7 = com.tencent.smtt.utils.b.a(r7, r8);
        r5.put(r6, r7);
        r0.commit();
        if (r4 == 0) goto L_0x0193;
    L_0x0192:
        return r1;
    L_0x0193:
        if (r3 == r2) goto L_0x01d9;
    L_0x0195:
        r2 = c;	 Catch:{ Throwable -> 0x01ca }
        r2 = com.tencent.smtt.utils.x.a(r2);	 Catch:{ Throwable -> 0x01ca }
        r2 = r2.d();	 Catch:{ Throwable -> 0x01ca }
        r4 = "TbsDownload";	 Catch:{ Throwable -> 0x01ca }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01ca }
        r6 = "[TbsDownloader.sendRequest] postUrl=";	 Catch:{ Throwable -> 0x01ca }
        r5.<init>(r6);	 Catch:{ Throwable -> 0x01ca }
        r5.append(r2);	 Catch:{ Throwable -> 0x01ca }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x01ca }
        com.tencent.smtt.utils.TbsLog.i(r4, r5);	 Catch:{ Throwable -> 0x01ca }
        r11 = r11.toString();	 Catch:{ Throwable -> 0x01ca }
        r4 = "utf-8";	 Catch:{ Throwable -> 0x01ca }
        r11 = r11.getBytes(r4);	 Catch:{ Throwable -> 0x01ca }
        r4 = new com.tencent.smtt.sdk.ah;	 Catch:{ Throwable -> 0x01ca }
        r4.<init>(r9, r0);	 Catch:{ Throwable -> 0x01ca }
        r11 = com.tencent.smtt.utils.n.a(r2, r11, r4, r1);	 Catch:{ Throwable -> 0x01ca }
        r10 = a(r11, r3, r9, r10);	 Catch:{ Throwable -> 0x01ca }
        return r10;
    L_0x01ca:
        r10 = move-exception;
        r10.printStackTrace();
        if (r9 == 0) goto L_0x01d6;
    L_0x01d0:
        r9 = -106; // 0xffffffffffffff96 float:NaN double:NaN;
    L_0x01d2:
        r0.setDownloadInterruptCode(r9);
        goto L_0x01d9;
    L_0x01d6:
        r9 = -206; // 0xffffffffffffff32 float:NaN double:NaN;
        goto L_0x01d2;
    L_0x01d9:
        r10 = r1;
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.c(boolean, boolean, boolean):boolean");
    }

    private static synchronized void d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.tencent.smtt.sdk.TbsDownloader.class;
        monitor-enter(r0);
        r1 = h;	 Catch:{ all -> 0x0032 }
        if (r1 != 0) goto L_0x0030;	 Catch:{ all -> 0x0032 }
    L_0x0007:
        r1 = com.tencent.smtt.sdk.ai.a();	 Catch:{ all -> 0x0032 }
        h = r1;	 Catch:{ all -> 0x0032 }
        r1 = new com.tencent.smtt.sdk.ad;	 Catch:{ Exception -> 0x0024 }
        r2 = c;	 Catch:{ Exception -> 0x0024 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0024 }
        g = r1;	 Catch:{ Exception -> 0x0024 }
        r1 = new com.tencent.smtt.sdk.ag;	 Catch:{ all -> 0x0032 }
        r2 = h;	 Catch:{ all -> 0x0032 }
        r2 = r2.getLooper();	 Catch:{ all -> 0x0032 }
        r1.<init>(r2);	 Catch:{ all -> 0x0032 }
        d = r1;	 Catch:{ all -> 0x0032 }
        goto L_0x0030;	 Catch:{ all -> 0x0032 }
    L_0x0024:
        r1 = 1;	 Catch:{ all -> 0x0032 }
        i = r1;	 Catch:{ all -> 0x0032 }
        r1 = "TbsDownload";	 Catch:{ all -> 0x0032 }
        r2 = "TbsApkDownloader init has Exception";	 Catch:{ all -> 0x0032 }
        com.tencent.smtt.utils.TbsLog.e(r1, r2);	 Catch:{ all -> 0x0032 }
        monitor-exit(r0);
        return;
    L_0x0030:
        monitor-exit(r0);
        return;
    L_0x0032:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.d():void");
    }

    private static boolean e() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = f();	 Catch:{ Exception -> 0x001d }
        r1 = c;	 Catch:{ Exception -> 0x001d }
        r1 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r1);	 Catch:{ Exception -> 0x001d }
        r1 = r1.mPreferences;	 Catch:{ Exception -> 0x001d }
        r2 = "last_thirdapp_sendrequest_coreversion";	 Catch:{ Exception -> 0x001d }
        r3 = "";	 Catch:{ Exception -> 0x001d }
        r1 = r1.getString(r2, r3);	 Catch:{ Exception -> 0x001d }
        r0 = r0.toString();	 Catch:{ Exception -> 0x001d }
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x001d }
        return r0;
    L_0x001d:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.e():boolean");
    }

    private static JSONArray f() {
        if (!TbsShareManager.isThirdPartyApp(c)) {
            return null;
        }
        int length;
        int i;
        JSONArray jSONArray = new JSONArray();
        Object coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        String packageName = c.getApplicationContext().getPackageName();
        int i2 = 0;
        if (packageName.equals(TbsShareManager.f(c))) {
            length = coreProviderAppList.length;
            Object obj = new String[(length + 1)];
            System.arraycopy(coreProviderAppList, 0, obj, 0, length);
            obj[length] = packageName;
            coreProviderAppList = obj;
        }
        int length2 = coreProviderAppList.length;
        length = 0;
        while (true) {
            int i3 = 1;
            if (length >= length2) {
                break;
            }
            Context a;
            String str = coreProviderAppList[length];
            int sharedTbsCoreVersion = TbsShareManager.getSharedTbsCoreVersion(c, str);
            if (sharedTbsCoreVersion > 0) {
                a = TbsShareManager.a(c, str);
                if (a == null || aj.a().d(a)) {
                    for (i = 0; i < jSONArray.length(); i++) {
                        if (jSONArray.optInt(i) == sharedTbsCoreVersion) {
                            break;
                        }
                    }
                    i3 = 0;
                    if (i3 == 0) {
                        jSONArray.put(sharedTbsCoreVersion);
                    }
                } else {
                    String str2 = LOGTAG;
                    StringBuilder stringBuilder = new StringBuilder("host check failed,packageName = ");
                    stringBuilder.append(str);
                    TbsLog.e(str2, stringBuilder.toString());
                }
            }
            length++;
        }
        for (String str3 : coreProviderAppList) {
            sharedTbsCoreVersion = TbsShareManager.getCoreShareDecoupleCoreVersion(c, str3);
            if (sharedTbsCoreVersion > 0) {
                a = TbsShareManager.a(c, str3);
                if (a == null || aj.a().d(a)) {
                    for (i = 0; i < jSONArray.length(); i++) {
                        if (jSONArray.optInt(i) == sharedTbsCoreVersion) {
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        jSONArray.put(sharedTbsCoreVersion);
                    }
                } else {
                    String str4 = LOGTAG;
                    StringBuilder stringBuilder2 = new StringBuilder("host check failed,packageName = ");
                    stringBuilder2.append(str3);
                    TbsLog.e(str4, stringBuilder2.toString());
                }
            }
        }
        if (TbsShareManager.getHostCorePathAppDefined() != null) {
            int a2 = aj.a().a(TbsShareManager.getHostCorePathAppDefined());
            for (length2 = 0; length2 < jSONArray.length(); length2++) {
                if (jSONArray.optInt(length2) == a2) {
                    i2 = 1;
                    break;
                }
            }
            if (i2 == 0) {
                jSONArray.put(a2);
            }
        }
        return jSONArray;
    }

    private static boolean g() {
        int i;
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(c);
        if (instance.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0) >= instance.getDownloadSuccessMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of success retrytimes", true);
            i = -115;
        } else if (instance.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0) >= instance.getDownloadFailedMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
            i = -116;
        } else if (k.b(c)) {
            if (System.currentTimeMillis() - instance.mPreferences.getLong(TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, 0) <= 86400000) {
                long j = instance.mPreferences.getLong(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, 0);
                String str = LOGTAG;
                StringBuilder stringBuilder = new StringBuilder("[TbsDownloader.needStartDownload] downloadFlow=");
                stringBuilder.append(j);
                TbsLog.i(str, stringBuilder.toString());
                if (j >= instance.getDownloadMaxflow()) {
                    TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
                    i = -120;
                }
            }
            return true;
        } else {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] local rom freespace limit", true);
            i = -117;
        }
        instance.setDownloadInterruptCode(i);
        return false;
    }

    public static int getCoreShareDecoupleCoreVersion() {
        return aj.a().f(c);
    }

    public static synchronized boolean getOverSea(Context context) {
        boolean z;
        synchronized (TbsDownloader.class) {
            if (!k) {
                String str;
                StringBuilder stringBuilder;
                k = true;
                TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
                if (instance.mPreferences.contains(TbsConfigKey.KEY_IS_OVERSEA)) {
                    j = instance.mPreferences.getBoolean(TbsConfigKey.KEY_IS_OVERSEA, false);
                    str = LOGTAG;
                    stringBuilder = new StringBuilder("[TbsDownloader.getOverSea]  first called. sOverSea = ");
                    stringBuilder.append(j);
                    TbsLog.i(str, stringBuilder.toString());
                }
                str = LOGTAG;
                stringBuilder = new StringBuilder("[TbsDownloader.getOverSea]  sOverSea = ");
                stringBuilder.append(j);
                TbsLog.i(str, stringBuilder.toString());
            }
            z = j;
        }
        return z;
    }

    public static long getRetryIntervalInSeconds() {
        return l;
    }

    public static HandlerThread getsTbsHandlerThread() {
        return h;
    }

    private static JSONArray h() {
        JSONArray jSONArray = new JSONArray();
        for (String a : TbsShareManager.getCoreProviderAppList()) {
            File file = new File(k.a(c, a, 4, false), getOverSea(c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            if (file.exists()) {
                long a2 = (long) a.a(c, file);
                if (a2 > 0) {
                    boolean z;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (((long) jSONArray.optInt(i)) == a2) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        jSONArray.put(a2);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static boolean isDownloadForeground() {
        return g != null && g.d();
    }

    public static synchronized boolean isDownloading() {
        boolean z;
        synchronized (TbsDownloader.class) {
            String str = LOGTAG;
            StringBuilder stringBuilder = new StringBuilder("[TbsDownloader.isDownloading] is ");
            stringBuilder.append(a);
            TbsLog.i(str, stringBuilder.toString());
            z = a;
        }
        return z;
    }

    public static boolean needDownload(Context context, boolean z) {
        return needDownload(context, z, false, null);
    }

    public static boolean needDownload(Context context, boolean z, boolean z2, TbsDownloaderCallback tbsDownloaderCallback) {
        TbsLog.initIfNeed(context);
        if (aj.b) {
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            return false;
        }
        TbsLog.app_extra(LOGTAG, context);
        Context applicationContext = context.getApplicationContext();
        c = applicationContext;
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(applicationContext);
        instance.setDownloadInterruptCode(-100);
        if (!a(c, z, tbsDownloaderCallback)) {
            return false;
        }
        d();
        if (i) {
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            instance.setDownloadInterruptCode(ErrorConstant.ERROR_ACCS_CUSTOM_FRAME_CB_NULL);
            return false;
        }
        boolean z3;
        int i;
        String str;
        StringBuilder stringBuilder;
        z = a(c, z2, false);
        if (z) {
            a(z2, tbsDownloaderCallback);
            instance.setDownloadInterruptCode(-114);
        }
        d.removeMessages(102);
        Message.obtain(d, 102).sendToTarget();
        if (!QbSdk.c) {
            if (TbsShareManager.isThirdPartyApp(context)) {
                z3 = false;
                if (z3) {
                    i = aj.a().i(c);
                    if (!z) {
                        if (i <= 0) {
                            i = -119;
                        }
                    }
                    d.removeMessages(103);
                    Message obtain = (i <= 0 || z) ? Message.obtain(d, 103, 1, 0, c) : Message.obtain(d, 103, 0, 0, c);
                    obtain.sendToTarget();
                    i = -121;
                } else if (g()) {
                    z3 = false;
                    if (!(z || tbsDownloaderCallback == null)) {
                        tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
                    }
                    str = LOGTAG;
                    stringBuilder = new StringBuilder("[TbsDownloader.needDownload] needDownload=");
                    stringBuilder.append(z3);
                    TbsLog.i(str, stringBuilder.toString());
                    return z3;
                } else {
                    i = -118;
                }
                instance.setDownloadInterruptCode(i);
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
                str = LOGTAG;
                stringBuilder = new StringBuilder("[TbsDownloader.needDownload] needDownload=");
                stringBuilder.append(z3);
                TbsLog.i(str, stringBuilder.toString());
                return z3;
            }
        }
        z2 = instance.mPreferences.contains(TbsConfigKey.KEY_NEEDDOWNLOAD);
        String str2 = LOGTAG;
        StringBuilder stringBuilder2 = new StringBuilder("[TbsDownloader.needDownload] hasNeedDownloadKey=");
        stringBuilder2.append(z2);
        TbsLog.i(str2, stringBuilder2.toString());
        z3 = (z2 || TbsShareManager.isThirdPartyApp(context)) ? instance.mPreferences.getBoolean(TbsConfigKey.KEY_NEEDDOWNLOAD, false) : true;
        if (z3) {
            i = aj.a().i(c);
            if (z) {
                if (i <= 0) {
                    i = -119;
                }
            }
            d.removeMessages(103);
            if (i <= 0) {
            }
            obtain.sendToTarget();
            i = -121;
        } else if (g()) {
            i = -118;
        } else {
            z3 = false;
            tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            str = LOGTAG;
            stringBuilder = new StringBuilder("[TbsDownloader.needDownload] needDownload=");
            stringBuilder.append(z3);
            TbsLog.i(str, stringBuilder.toString());
            return z3;
        }
        instance.setDownloadInterruptCode(i);
        tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
        str = LOGTAG;
        stringBuilder = new StringBuilder("[TbsDownloader.needDownload] needDownload=");
        stringBuilder.append(z3);
        TbsLog.i(str, stringBuilder.toString());
        return z3;
    }

    public static boolean needDownloadDecoupleCore() {
        if (TbsShareManager.isThirdPartyApp(c) || TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
            return false;
        }
        if (System.currentTimeMillis() - TbsDownloadConfig.getInstance(c).mPreferences.getLong(TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0) < TbsDownloadConfig.getInstance(c).getRetryInterval() * 1000) {
            return false;
        }
        int i = TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
        return (i <= 0 || i == aj.a().f(c) || TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) == i) ? false : true;
    }

    public static boolean needSendRequest(Context context, boolean z) {
        c = context.getApplicationContext();
        TbsLog.initIfNeed(context);
        if (!a(c, z, null)) {
            return false;
        }
        int i = aj.a().i(context);
        String str = LOGTAG;
        StringBuilder stringBuilder = new StringBuilder("[TbsDownloader.needSendRequest] localTbsVersion=");
        stringBuilder.append(i);
        TbsLog.i(str, stringBuilder.toString());
        if (i > 0) {
            return false;
        }
        z = true;
        if (a(c, false, true)) {
            return true;
        }
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(c);
        boolean contains = instance.mPreferences.contains(TbsConfigKey.KEY_NEEDDOWNLOAD);
        String str2 = LOGTAG;
        StringBuilder stringBuilder2 = new StringBuilder("[TbsDownloader.needSendRequest] hasNeedDownloadKey=");
        stringBuilder2.append(contains);
        TbsLog.i(str2, stringBuilder2.toString());
        boolean z2 = !contains ? true : instance.mPreferences.getBoolean(TbsConfigKey.KEY_NEEDDOWNLOAD, false);
        String str3 = LOGTAG;
        StringBuilder stringBuilder3 = new StringBuilder("[TbsDownloader.needSendRequest] needDownload=");
        stringBuilder3.append(z2);
        TbsLog.i(str3, stringBuilder3.toString());
        if (!z2 || !g()) {
            z = false;
        }
        String str4 = LOGTAG;
        StringBuilder stringBuilder4 = new StringBuilder("[TbsDownloader.needSendRequest] ret=");
        stringBuilder4.append(z);
        TbsLog.i(str4, stringBuilder4.toString());
        return z;
    }

    public static void setRetryIntervalInSeconds(Context context, long j) {
        if (context != null) {
            if (context.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
                l = j;
            }
            String str = LOGTAG;
            StringBuilder stringBuilder = new StringBuilder("mRetryIntervalInSeconds is ");
            stringBuilder.append(l);
            TbsLog.i(str, stringBuilder.toString());
        }
    }

    public static boolean startDecoupleCoreIfNeeded() {
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded ");
        if (TbsShareManager.isThirdPartyApp(c)) {
            return false;
        }
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #1");
        if (TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
            return false;
        }
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #2");
        long j = TbsDownloadConfig.getInstance(c).mPreferences.getLong(TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0);
        if (System.currentTimeMillis() - j < TbsDownloadConfig.getInstance(c).getRetryInterval() * 1000) {
            return false;
        }
        String str;
        StringBuilder stringBuilder;
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #3");
        int i = TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
        if (i <= 0 || i == aj.a().f(c)) {
            str = LOGTAG;
            stringBuilder = new StringBuilder("startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is ");
            stringBuilder.append(i);
            stringBuilder.append(" getTbsCoreShareDecoupleCoreVersion is ");
            i = aj.a().f(c);
        } else {
            if (TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) == i) {
                if (TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) != 1) {
                    str = LOGTAG;
                    stringBuilder = new StringBuilder("startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is ");
                    stringBuilder.append(TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                    stringBuilder.append(" deCoupleCoreVersion is ");
                    stringBuilder.append(i);
                    stringBuilder.append(" KEY_TBS_DOWNLOAD_V_TYPE is ");
                    i = TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0);
                }
            }
            TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #4");
            a = true;
            d.removeMessages(108);
            Message obtain = Message.obtain(d, 108, QbSdk.k);
            obtain.arg1 = 0;
            obtain.sendToTarget();
            TbsDownloadConfig.getInstance(c).a.put(TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, Long.valueOf(System.currentTimeMillis()));
            return true;
        }
        stringBuilder.append(i);
        TbsLog.i(str, stringBuilder.toString());
        return false;
    }

    public static void startDownload(Context context) {
        startDownload(context, false);
    }

    public static synchronized void startDownload(Context context, boolean z) {
        synchronized (TbsDownloader.class) {
            String str = LOGTAG;
            StringBuilder stringBuilder = new StringBuilder("[TbsDownloader.startDownload] sAppContext=");
            stringBuilder.append(c);
            TbsLog.i(str, stringBuilder.toString());
            if (aj.b) {
                return;
            }
            a = true;
            context = context.getApplicationContext();
            c = context;
            TbsDownloadConfig.getInstance(context).setDownloadInterruptCode(ErrorConstant.ERROR_NO_NETWORK);
            if (VERSION.SDK_INT < 8) {
                QbSdk.k.onDownloadFinish(110);
                TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(ErrorConstant.ERROR_REQUEST_FAIL);
                return;
            }
            d();
            if (i) {
                QbSdk.k.onDownloadFinish(121);
                TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(ErrorConstant.ERROR_REQUEST_TIME_OUT);
                return;
            }
            if (z) {
                stopDownload();
            }
            d.removeMessages(101);
            d.removeMessages(100);
            Message obtain = Message.obtain(d, 101, QbSdk.k);
            obtain.arg1 = z;
            obtain.sendToTarget();
        }
    }

    public static void stopDownload() {
        if (!i) {
            TbsLog.i(LOGTAG, "[TbsDownloader.stopDownload]");
            if (g != null) {
                g.b();
            }
            if (d != null) {
                d.removeMessages(100);
                d.removeMessages(101);
                d.removeMessages(108);
            }
        }
    }
}
