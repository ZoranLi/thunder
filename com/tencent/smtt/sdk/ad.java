package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import anet.channel.util.ErrorConstant;
import com.tencent.bugly.BuglyStrategy.a;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.aa;
import com.tencent.smtt.utils.k;
import com.umeng.message.util.HttpRequest;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

class ad {
    private static int d = 5;
    private static int e = 1;
    private static final String[] f = new String[]{"tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone"};
    private Set<String> A;
    private int B = d;
    private boolean C;
    String a;
    String[] b = null;
    int c = 0;
    private Context g;
    private String h;
    private String i;
    private String j;
    private File k;
    private long l;
    private int m = a.MAX_USERDATA_VALUE_LENGTH;
    private int n = 20000;
    private boolean o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private HttpURLConnection t;
    private String u;
    private TbsLogInfo v;
    private String w;
    private int x;
    private boolean y;
    private Handler z;

    public ad(Context context) {
        this.g = context.getApplicationContext();
        this.v = TbsLogReport.a(this.g).a();
        this.A = new HashSet();
        StringBuilder stringBuilder = new StringBuilder("tbs_downloading_");
        stringBuilder.append(this.g.getPackageName());
        this.u = stringBuilder.toString();
        aj.a();
        this.k = aj.o(this.g);
        if (this.k == null) {
            throw new NullPointerException("TbsCorePrivateDir is null!");
        }
        e();
        this.w = null;
        this.x = -1;
    }

    private long a(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        this.v.setDownConsumeTime(currentTimeMillis - j);
        this.v.setDownloadSize(j2);
        return currentTimeMillis;
    }

    @TargetApi(8)
    static File a(Context context) {
        try {
            File file = VERSION.SDK_INT >= 8 ? new File(k.a(context, 4)) : null;
            if (!(file == null || file.exists() || file.isDirectory())) {
                file.mkdirs();
            }
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            String str = TbsDownloader.LOGTAG;
            StringBuilder stringBuilder = new StringBuilder("[TbsApkDownloader.backupApkPath] Exception is ");
            stringBuilder.append(e.getMessage());
            TbsLog.e(str, stringBuilder.toString());
            return null;
        }
    }

    private static File a(Context context, int i) {
        File file = new File(k.a(context, i));
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        return new File(file, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : "x5.tbs.org").exists() ? file : null;
    }

    private String a(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return stackTraceString.length() > 1024 ? stackTraceString.substring(0, 1024) : stackTraceString;
    }

    private String a(URL url) {
        String str = "";
        try {
            return InetAddress.getByName(url.getHost()).getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        } catch (Error e2) {
            e2.printStackTrace();
            return str;
        }
    }

    private void a(int i, String str, boolean z) {
        if (z || this.p > this.B) {
            this.v.setErrorCode(i);
            this.v.setFailDetail(str);
        }
    }

    private void a(long r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.p;
        r0 = r0 + 1;
        r3.p = r0;
        r0 = 0;
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r2 > 0) goto L_0x0010;
    L_0x000c:
        r4 = r3.l();	 Catch:{ Exception -> 0x0013 }
    L_0x0010:
        java.lang.Thread.sleep(r4);	 Catch:{ Exception -> 0x0013 }
    L_0x0013:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.ad.a(long):void");
    }

    private void a(java.io.Closeable r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        if (r1 == 0) goto L_0x0005;
    L_0x0002:
        r1.close();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.ad.a(java.io.Closeable):void");
    }

    public static void a(java.io.File r2, android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r2 == 0) goto L_0x0025;
    L_0x0002:
        r0 = r2.exists();
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = a(r3);	 Catch:{ Exception -> 0x0025 }
        if (r0 == 0) goto L_0x0025;	 Catch:{ Exception -> 0x0025 }
    L_0x000f:
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0025 }
        r3 = com.tencent.smtt.sdk.TbsDownloader.getOverSea(r3);	 Catch:{ Exception -> 0x0025 }
        if (r3 == 0) goto L_0x001a;	 Catch:{ Exception -> 0x0025 }
    L_0x0017:
        r3 = "x5.oversea.tbs.org";	 Catch:{ Exception -> 0x0025 }
        goto L_0x001c;	 Catch:{ Exception -> 0x0025 }
    L_0x001a:
        r3 = "x5.tbs.org";	 Catch:{ Exception -> 0x0025 }
    L_0x001c:
        r1.<init>(r0, r3);	 Catch:{ Exception -> 0x0025 }
        r1.delete();	 Catch:{ Exception -> 0x0025 }
        com.tencent.smtt.utils.k.b(r2, r1);	 Catch:{ Exception -> 0x0025 }
    L_0x0025:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.ad.a(java.io.File, android.content.Context):void");
    }

    private void a(String str) {
        URL url = new URL(str);
        if (this.t != null) {
            try {
                this.t.disconnect();
            } catch (Throwable th) {
                String str2 = TbsDownloader.LOGTAG;
                StringBuilder stringBuilder = new StringBuilder("[initHttpRequest] mHttpRequest.disconnect() Throwable:");
                stringBuilder.append(th.toString());
                TbsLog.e(str2, stringBuilder.toString());
            }
        }
        this.t = (HttpURLConnection) url.openConnection();
        this.t.setRequestProperty(HttpRequest.HEADER_USER_AGENT, TbsDownloader.a(this.g));
        this.t.setRequestProperty("Accept-Encoding", "identity");
        this.t.setRequestMethod("GET");
        this.t.setInstanceFollowRedirects(false);
        this.t.setConnectTimeout(this.n);
        this.t.setReadTimeout(this.m);
    }

    @TargetApi(8)
    static File b(Context context) {
        try {
            if (VERSION.SDK_INT < 8) {
                return null;
            }
            File a = a(context, 4);
            if (a == null) {
                a = a(context, 3);
            }
            if (a == null) {
                a = a(context, 2);
            }
            return a == null ? a(context, 1) : a;
        } catch (Exception e) {
            e.printStackTrace();
            String str = TbsDownloader.LOGTAG;
            StringBuilder stringBuilder = new StringBuilder("[TbsApkDownloader.backupApkPath] Exception is ");
            stringBuilder.append(e.getMessage());
            TbsLog.e(str, stringBuilder.toString());
            return null;
        }
    }

    private void b(boolean z) {
        aa.a(this.g);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(this.g);
        instance.a.put(TbsConfigKey.KEY_FULL_PACKAGE, Boolean.valueOf(false));
        instance.a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(false));
        instance.a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-123));
        instance.commit();
        QbSdk.k.onDownloadFinish(z ? 100 : 120);
        int i = instance.mPreferences.getInt(TbsConfigKey.KEY_RESPONSECODE, 0);
        boolean z2 = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1;
        if (i != 3) {
            if (i <= 10000) {
                aj.a().a(this.g, new File(this.k, "x5.tbs").getAbsolutePath(), instance.mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                if (!z2) {
                    a(new File(this.k, "x5.tbs"), this.g);
                }
                return;
            }
        }
        File a = a(this.g);
        if (a != null) {
            File file = new File(a, TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            int a2 = com.tencent.smtt.utils.a.a(this.g, file);
            File file2 = new File(this.k, "x5.tbs");
            String absolutePath = file2.exists() ? file2.getAbsolutePath() : null;
            int i2 = instance.mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            Bundle bundle = new Bundle();
            bundle.putInt("operation", i);
            bundle.putInt("old_core_ver", a2);
            bundle.putInt("new_core_ver", i2);
            bundle.putString("old_apk_location", file.getAbsolutePath());
            bundle.putString("new_apk_location", absolutePath);
            bundle.putString("diff_file_location", absolutePath);
            aj.a().b(this.g, bundle);
            return;
        }
        c();
        instance.a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
        instance.commit();
    }

    private boolean b(int i) {
        try {
            File file = new File(this.k, "x5.tbs");
            File a = a(this.g);
            if (a == null) {
                return false;
            }
            File file2 = new File(a, TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            file.delete();
            k.b(file2, file);
            if (com.tencent.smtt.utils.a.a(this.g, file, 0, i)) {
                return true;
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            String str = TbsDownloader.LOGTAG;
            StringBuilder stringBuilder = new StringBuilder("[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is ");
            stringBuilder.append(e.getMessage());
            TbsLog.e(str, stringBuilder.toString());
            return false;
        }
    }

    public static void c(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        com.tencent.smtt.sdk.aj.a();	 Catch:{ Exception -> 0x0035 }
        r0 = com.tencent.smtt.sdk.aj.o(r3);	 Catch:{ Exception -> 0x0035 }
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0035 }
        r2 = "x5.tbs";	 Catch:{ Exception -> 0x0035 }
        r1.<init>(r0, r2);	 Catch:{ Exception -> 0x0035 }
        r1.delete();	 Catch:{ Exception -> 0x0035 }
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0035 }
        r2 = "x5.tbs.temp";	 Catch:{ Exception -> 0x0035 }
        r1.<init>(r0, r2);	 Catch:{ Exception -> 0x0035 }
        r1.delete();	 Catch:{ Exception -> 0x0035 }
        r3 = a(r3);	 Catch:{ Exception -> 0x0035 }
        if (r3 == 0) goto L_0x0035;	 Catch:{ Exception -> 0x0035 }
    L_0x0021:
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0035 }
        r1 = "x5.tbs.org";	 Catch:{ Exception -> 0x0035 }
        r0.<init>(r3, r1);	 Catch:{ Exception -> 0x0035 }
        r0.delete();	 Catch:{ Exception -> 0x0035 }
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0035 }
        r1 = "x5.oversea.tbs.org";	 Catch:{ Exception -> 0x0035 }
        r0.<init>(r3, r1);	 Catch:{ Exception -> 0x0035 }
        r0.delete();	 Catch:{ Exception -> 0x0035 }
    L_0x0035:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.ad.c(android.content.Context):void");
    }

    private boolean c(boolean z) {
        String str = TbsDownloader.LOGTAG;
        StringBuilder stringBuilder = new StringBuilder("[TbsApkDownloader.deleteFile] isApk=");
        stringBuilder.append(z);
        TbsLog.i(str, stringBuilder.toString());
        File file = z ? new File(this.k, "x5.tbs") : new File(this.k, "x5.tbs.temp");
        return file.exists() ? file.delete() : true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(boolean r10, boolean r11) {
        /*
        r9 = this;
        r0 = "TbsDownload";
        r1 = new java.lang.StringBuilder;
        r2 = "[TbsApkDownloader.verifyTbsApk] isTempFile=";
        r1.<init>(r2);
        r1.append(r10);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        r0 = new java.io.File;
        r1 = r9.k;
        if (r10 != 0) goto L_0x001c;
    L_0x0019:
        r2 = "x5.tbs";
        goto L_0x001e;
    L_0x001c:
        r2 = "x5.tbs.temp";
    L_0x001e:
        r0.<init>(r1, r2);
        r1 = r0.exists();
        r2 = 0;
        if (r1 != 0) goto L_0x0029;
    L_0x0028:
        return r2;
    L_0x0029:
        r1 = r9.g;
        r1 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r1);
        r1 = r1.mPreferences;
        r3 = "tbs_apk_md5";
        r4 = 0;
        r1 = r1.getString(r3, r4);
        r3 = com.tencent.smtt.utils.a.a(r0);
        if (r1 == 0) goto L_0x01c1;
    L_0x003e:
        r1 = r1.equals(r3);
        if (r1 != 0) goto L_0x0046;
    L_0x0044:
        goto L_0x01c1;
    L_0x0046:
        r1 = "TbsDownload";
        r5 = new java.lang.StringBuilder;
        r6 = "[TbsApkDownloader.verifyTbsApk] md5(";
        r5.<init>(r6);
        r5.append(r3);
        r3 = ") successful!";
        r5.append(r3);
        r3 = r5.toString();
        com.tencent.smtt.utils.TbsLog.i(r1, r3);
        r5 = 0;
        if (r10 == 0) goto L_0x00b6;
    L_0x0062:
        r1 = r9.g;
        r1 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r1);
        r1 = r1.mPreferences;
        r3 = "tbs_apkfilesize";
        r7 = r1.getLong(r3, r5);
        r1 = r0.exists();
        if (r1 == 0) goto L_0x0082;
    L_0x0076:
        r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1));
        if (r1 <= 0) goto L_0x00b6;
    L_0x007a:
        r5 = r0.length();
        r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1));
        if (r1 == 0) goto L_0x00b6;
    L_0x0082:
        r11 = "TbsDownload";
        r0 = new java.lang.StringBuilder;
        r1 = "[TbsApkDownloader.verifyTbsApk] isTempFile=";
        r0.<init>(r1);
        r0.append(r10);
        r10 = " filelength failed";
        r0.append(r10);
        r10 = r0.toString();
        com.tencent.smtt.utils.TbsLog.i(r11, r10);
        r10 = r9.v;
        r11 = new java.lang.StringBuilder;
        r0 = "fileLength:";
        r11.<init>(r0);
        r11.append(r5);
        r0 = ",contentLength:";
        r11.append(r0);
        r11.append(r7);
        r11 = r11.toString();
        r10.setCheckErrorDetail(r11);
        return r2;
    L_0x00b6:
        r1 = "TbsDownload";
        r3 = new java.lang.StringBuilder;
        r7 = "[TbsApkDownloader.verifyTbsApk] length(";
        r3.<init>(r7);
        r3.append(r5);
        r5 = ") successful!";
        r3.append(r5);
        r3 = r3.toString();
        com.tencent.smtt.utils.TbsLog.i(r1, r3);
        r1 = -1;
        if (r11 == 0) goto L_0x011d;
    L_0x00d1:
        r1 = r9.g;
        r1 = com.tencent.smtt.utils.a.a(r1, r0);
        r3 = r9.g;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);
        r3 = r3.mPreferences;
        r5 = "tbs_download_version";
        r3 = r3.getInt(r5, r2);
        if (r3 == r1) goto L_0x011d;
    L_0x00e7:
        r11 = "TbsDownload";
        r0 = new java.lang.StringBuilder;
        r4 = "[TbsApkDownloader.verifyTbsApk] isTempFile=";
        r0.<init>(r4);
        r0.append(r10);
        r4 = " versionCode failed";
        r0.append(r4);
        r0 = r0.toString();
        com.tencent.smtt.utils.TbsLog.i(r11, r0);
        if (r10 == 0) goto L_0x011c;
    L_0x0101:
        r10 = r9.v;
        r11 = new java.lang.StringBuilder;
        r0 = "fileVersion:";
        r11.<init>(r0);
        r11.append(r1);
        r0 = ",configVersion:";
        r11.append(r0);
        r11.append(r3);
        r11 = r11.toString();
        r10.setCheckErrorDetail(r11);
    L_0x011c:
        return r2;
    L_0x011d:
        r3 = "TbsDownload";
        r5 = new java.lang.StringBuilder;
        r6 = "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(";
        r5.<init>(r6);
        r5.append(r1);
        r1 = ") successful!";
        r5.append(r1);
        r1 = r5.toString();
        com.tencent.smtt.utils.TbsLog.i(r3, r1);
        if (r11 == 0) goto L_0x0180;
    L_0x0137:
        r11 = r9.g;
        r11 = com.tencent.smtt.utils.b.a(r11, r0);
        r1 = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
        r1 = r1.equals(r11);
        if (r1 != 0) goto L_0x0180;
    L_0x0145:
        r0 = "TbsDownload";
        r1 = new java.lang.StringBuilder;
        r3 = "[TbsApkDownloader.verifyTbsApk] isTempFile=";
        r1.<init>(r3);
        r1.append(r10);
        r3 = " signature failed";
        r1.append(r3);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        if (r10 == 0) goto L_0x017f;
    L_0x015f:
        r10 = r9.v;
        r0 = new java.lang.StringBuilder;
        r1 = "signature:";
        r0.<init>(r1);
        if (r11 != 0) goto L_0x016d;
    L_0x016a:
        r11 = "null";
        goto L_0x0175;
    L_0x016d:
        r11 = r11.length();
        r11 = java.lang.Integer.valueOf(r11);
    L_0x0175:
        r0.append(r11);
        r11 = r0.toString();
        r10.setCheckErrorDetail(r11);
    L_0x017f:
        return r2;
    L_0x0180:
        r11 = "TbsDownload";
        r1 = "[TbsApkDownloader.verifyTbsApk] signature successful!";
        com.tencent.smtt.utils.TbsLog.i(r11, r1);
        r11 = 1;
        if (r10 == 0) goto L_0x01a7;
    L_0x018a:
        r10 = new java.io.File;	 Catch:{ Exception -> 0x0198 }
        r1 = r9.k;	 Catch:{ Exception -> 0x0198 }
        r3 = "x5.tbs";
        r10.<init>(r1, r3);	 Catch:{ Exception -> 0x0198 }
        r10 = r0.renameTo(r10);	 Catch:{ Exception -> 0x0198 }
        goto L_0x019b;
    L_0x0198:
        r10 = move-exception;
        r4 = r10;
        r10 = r2;
    L_0x019b:
        if (r10 != 0) goto L_0x01a8;
    L_0x019d:
        r10 = 109; // 0x6d float:1.53E-43 double:5.4E-322;
        r0 = r9.a(r4);
        r9.a(r10, r0, r11);
        return r2;
    L_0x01a7:
        r10 = r2;
    L_0x01a8:
        r0 = "TbsDownload";
        r1 = new java.lang.StringBuilder;
        r2 = "[TbsApkDownloader.verifyTbsApk] rename(";
        r1.<init>(r2);
        r1.append(r10);
        r10 = ") successful!";
        r1.append(r10);
        r10 = r1.toString();
        com.tencent.smtt.utils.TbsLog.i(r0, r10);
        return r11;
    L_0x01c1:
        r11 = "TbsDownload";
        r0 = new java.lang.StringBuilder;
        r1 = "[TbsApkDownloader.verifyTbsApk] isTempFile=";
        r0.<init>(r1);
        r0.append(r10);
        r1 = " md5 failed";
        r0.append(r1);
        r0 = r0.toString();
        com.tencent.smtt.utils.TbsLog.i(r11, r0);
        if (r10 == 0) goto L_0x01e2;
    L_0x01db:
        r10 = r9.v;
        r11 = "fileMd5 not match";
        r10.setCheckErrorDetail(r11);
    L_0x01e2:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.ad.c(boolean, boolean):boolean");
    }

    private void e() {
        this.p = 0;
        this.q = 0;
        this.l = -1;
        this.j = null;
        this.o = false;
        this.r = false;
        this.s = false;
        this.y = false;
    }

    private void f() {
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.closeHttpRequest]");
        if (this.t != null) {
            if (!this.r) {
                this.v.setResolveIp(a(this.t.getURL()));
            }
            try {
                this.t.disconnect();
            } catch (Throwable th) {
                String str = TbsDownloader.LOGTAG;
                StringBuilder stringBuilder = new StringBuilder("[closeHttpRequest] mHttpRequest.disconnect() Throwable:");
                stringBuilder.append(th.toString());
                TbsLog.e(str, stringBuilder.toString());
            }
            this.t = null;
        }
        int i = this.v.a;
        if (this.r || !this.y) {
            TbsDownloader.a = false;
            return;
        }
        TbsLogReport a;
        EventType eventType;
        this.v.setEventTime(System.currentTimeMillis());
        str = Apn.getApnInfo(this.g);
        if (str == null) {
            str = "";
        }
        int apnType = Apn.getApnType(this.g);
        this.v.setApn(str);
        this.v.setNetworkType(apnType);
        if (!(apnType == this.x && str.equals(this.w))) {
            this.v.setNetworkChange(0);
        }
        if ((this.v.a == 0 || this.v.a == 107) && this.v.getDownFinalFlag() == 0) {
            if (Apn.isNetworkAvailable(this.g)) {
                if (!k()) {
                }
            }
            a(101, null, true);
        }
        if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
            a = TbsLogReport.a(this.g);
            eventType = EventType.TYPE_DOWNLOAD_DECOUPLE;
        } else {
            a = TbsLogReport.a(this.g);
            eventType = EventType.TYPE_DOWNLOAD;
        }
        a.a(eventType, this.v);
        this.v.resetArgs();
        if (i != 100) {
            QbSdk.k.onDownloadFinish(i);
        }
    }

    private boolean g() {
        File file = new File(k.a(this.g, 4), TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        int i = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        if (i == 0) {
            i = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        }
        return com.tencent.smtt.utils.a.a(this.g, file, 0, i);
    }

    private void h() {
        try {
            if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) != 1) {
                File file = new File(k.a(this.g, 4), TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                if (file.exists()) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean i() {
        return new File(this.k, "x5.tbs.temp").exists();
    }

    private long j() {
        File file = new File(this.k, "x5.tbs.temp");
        return file.exists() ? file.length() : 0;
    }

    private boolean k() {
        Closeable inputStream;
        Closeable closeable;
        Throwable th;
        Throwable th2;
        Runtime runtime = Runtime.getRuntime();
        String str = "www.qq.com";
        boolean z = false;
        Closeable closeable2 = null;
        Reader inputStreamReader;
        try {
            StringBuilder stringBuilder = new StringBuilder("ping ");
            stringBuilder.append(str);
            inputStream = runtime.exec(stringBuilder.toString()).getInputStream();
            try {
                inputStreamReader = new InputStreamReader(inputStream);
            } catch (Throwable th3) {
                th2 = th3;
                closeable = null;
                a(inputStream);
                a(closeable2);
                a(closeable);
                throw th2;
            }
            try {
                closeable = new BufferedReader(inputStreamReader);
                int i = 0;
                do {
                    try {
                        String readLine = closeable.readLine();
                        if (readLine != null) {
                            if (!readLine.contains("TTL")) {
                                if (!readLine.contains("ttl")) {
                                    i++;
                                }
                            }
                            z = true;
                            break;
                        }
                        break;
                    } catch (Throwable th4) {
                        th2 = th4;
                    }
                } while (i < 5);
                a(inputStream);
            } catch (Throwable th5) {
                th2 = th5;
                closeable = null;
                closeable2 = inputStreamReader;
                a(inputStream);
                a(closeable2);
                a(closeable);
                throw th2;
            }
        } catch (Throwable th6) {
            th2 = th6;
            inputStream = null;
            closeable = inputStream;
            a(inputStream);
            a(closeable2);
            a(closeable);
            throw th2;
        }
        a(r1);
        a(closeable);
        return z;
    }

    private long l() {
        switch (this.p) {
            case 1:
            case 2:
                return 20000 * ((long) this.p);
            case 3:
            case 4:
                return 100000;
            default:
                return 200000;
        }
    }

    private boolean m() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r8.g;
        r0 = com.tencent.smtt.utils.Apn.getApnType(r0);
        r1 = 1;
        r2 = 0;
        r3 = 3;
        if (r0 != r3) goto L_0x000d;
    L_0x000b:
        r0 = r1;
        goto L_0x000e;
    L_0x000d:
        r0 = r2;
    L_0x000e:
        r3 = "TbsDownload";
        r4 = new java.lang.StringBuilder;
        r5 = "[TbsApkDwonloader.detectWifiNetworkAvailable] isWifi=";
        r4.<init>(r5);
        r4.append(r0);
        r4 = r4.toString();
        com.tencent.smtt.utils.TbsLog.i(r3, r4);
        r3 = 0;
        if (r0 == 0) goto L_0x0095;
    L_0x0024:
        r0 = r8.g;
        r0 = com.tencent.smtt.utils.Apn.getWifiSSID(r0);
        r4 = "TbsDownload";
        r5 = new java.lang.StringBuilder;
        r6 = "[TbsApkDwonloader.detectWifiNetworkAvailable] localBSSID=";
        r5.<init>(r6);
        r5.append(r0);
        r5 = r5.toString();
        com.tencent.smtt.utils.TbsLog.i(r4, r5);
        r4 = new java.net.URL;	 Catch:{ Throwable -> 0x0085 }
        r5 = "http://pms.mb.qq.com/rsp204";	 Catch:{ Throwable -> 0x0085 }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0085 }
        r4 = r4.openConnection();	 Catch:{ Throwable -> 0x0085 }
        r4 = (java.net.HttpURLConnection) r4;	 Catch:{ Throwable -> 0x0085 }
        r4.setInstanceFollowRedirects(r2);	 Catch:{ Throwable -> 0x007f, all -> 0x007d }
        r3 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ Throwable -> 0x007f, all -> 0x007d }
        r4.setConnectTimeout(r3);	 Catch:{ Throwable -> 0x007f, all -> 0x007d }
        r4.setReadTimeout(r3);	 Catch:{ Throwable -> 0x007f, all -> 0x007d }
        r4.setUseCaches(r2);	 Catch:{ Throwable -> 0x007f, all -> 0x007d }
        r4.getInputStream();	 Catch:{ Throwable -> 0x007f, all -> 0x007d }
        r3 = r4.getResponseCode();	 Catch:{ Throwable -> 0x007f, all -> 0x007d }
        r5 = "TbsDownload";	 Catch:{ Throwable -> 0x007f, all -> 0x007d }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x007f, all -> 0x007d }
        r7 = "[TbsApkDwonloader.detectWifiNetworkAvailable] responseCode=";	 Catch:{ Throwable -> 0x007f, all -> 0x007d }
        r6.<init>(r7);	 Catch:{ Throwable -> 0x007f, all -> 0x007d }
        r6.append(r3);	 Catch:{ Throwable -> 0x007f, all -> 0x007d }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x007f, all -> 0x007d }
        com.tencent.smtt.utils.TbsLog.i(r5, r6);	 Catch:{ Throwable -> 0x007f, all -> 0x007d }
        r5 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
        if (r3 != r5) goto L_0x0077;
    L_0x0076:
        r2 = r1;
    L_0x0077:
        if (r4 == 0) goto L_0x0096;
    L_0x0079:
        r4.disconnect();	 Catch:{ Exception -> 0x0096 }
        goto L_0x0096;
    L_0x007d:
        r0 = move-exception;
        goto L_0x008f;
    L_0x007f:
        r1 = move-exception;
        r3 = r4;
        goto L_0x0086;
    L_0x0082:
        r0 = move-exception;
        r4 = r3;
        goto L_0x008f;
    L_0x0085:
        r1 = move-exception;
    L_0x0086:
        r1.printStackTrace();	 Catch:{ all -> 0x0082 }
        if (r3 == 0) goto L_0x0096;
    L_0x008b:
        r3.disconnect();	 Catch:{ Exception -> 0x0096 }
        goto L_0x0096;
    L_0x008f:
        if (r4 == 0) goto L_0x0094;
    L_0x0091:
        r4.disconnect();	 Catch:{ Exception -> 0x0094 }
    L_0x0094:
        throw r0;
    L_0x0095:
        r0 = r3;
    L_0x0096:
        if (r2 != 0) goto L_0x00be;
    L_0x0098:
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x00be;
    L_0x009e:
        r1 = r8.A;
        r1 = r1.contains(r0);
        if (r1 != 0) goto L_0x00be;
    L_0x00a6:
        r1 = r8.A;
        r1.add(r0);
        r8.n();
        r1 = r8.z;
        r3 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r1 = r1.obtainMessage(r3, r0);
        r3 = r8.z;
        r4 = 120000; // 0x1d4c0 float:1.68156E-40 double:5.9288E-319;
        r3.sendMessageDelayed(r1, r4);
    L_0x00be:
        if (r2 == 0) goto L_0x00cd;
    L_0x00c0:
        r1 = r8.A;
        r1 = r1.contains(r0);
        if (r1 == 0) goto L_0x00cd;
    L_0x00c8:
        r1 = r8.A;
        r1.remove(r0);
    L_0x00cd:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.ad.m():boolean");
    }

    private void n() {
        if (this.z == null) {
            this.z = new ae(this, ai.a().getLooper());
        }
    }

    public int a() {
        File a = a(this.g);
        if (a == null) {
            return 0;
        }
        return com.tencent.smtt.utils.a.a(this.g, new File(a, TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
    }

    public void a(int r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0019 }
        r1 = r3.k;	 Catch:{ Exception -> 0x0019 }
        r2 = "x5.tbs";	 Catch:{ Exception -> 0x0019 }
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x0019 }
        r1 = r3.g;	 Catch:{ Exception -> 0x0019 }
        r1 = com.tencent.smtt.utils.a.a(r1, r0);	 Catch:{ Exception -> 0x0019 }
        r2 = -1;	 Catch:{ Exception -> 0x0019 }
        if (r2 == r1) goto L_0x0016;	 Catch:{ Exception -> 0x0019 }
    L_0x0012:
        if (r4 <= 0) goto L_0x0019;	 Catch:{ Exception -> 0x0019 }
    L_0x0014:
        if (r4 != r1) goto L_0x0019;	 Catch:{ Exception -> 0x0019 }
    L_0x0016:
        r0.delete();	 Catch:{ Exception -> 0x0019 }
    L_0x0019:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.ad.a(int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(boolean r4) {
        /*
        r3 = this;
        r0 = 0;
        if (r4 == 0) goto L_0x0018;
    L_0x0003:
        r4 = r3.m();
        if (r4 != 0) goto L_0x0018;
    L_0x0009:
        r4 = com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi();
        if (r4 == 0) goto L_0x0017;
    L_0x000f:
        r4 = r3.g;
        r4 = com.tencent.smtt.utils.Apn.isNetworkAvailable(r4);
        if (r4 != 0) goto L_0x0018;
    L_0x0017:
        return r0;
    L_0x0018:
        r4 = r3.b;
        if (r4 == 0) goto L_0x0045;
    L_0x001c:
        r4 = r3.c;
        if (r4 < 0) goto L_0x0045;
    L_0x0020:
        r4 = r3.c;
        r1 = r3.b;
        r1 = r1.length;
        if (r4 >= r1) goto L_0x0045;
    L_0x0027:
        r4 = r3.b;
        r1 = r3.c;
        r2 = r1 + 1;
        r3.c = r2;
        r4 = r4[r1];
        r3.j = r4;
        r3.p = r0;
        r3.q = r0;
        r1 = -1;
        r3.l = r1;
        r3.o = r0;
        r3.r = r0;
        r3.s = r0;
        r3.y = r0;
        r4 = 1;
        return r4;
    L_0x0045:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.ad.a(boolean):boolean");
    }

    public boolean a(boolean z, boolean z2) {
        String str;
        int i = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        int g = aj.a().g(this.g);
        if (i == 0) {
            i = TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            str = "by default key";
        } else {
            str = "by new key";
        }
        this.a = str;
        if (i == 0 || i == g) {
            return false;
        }
        if (z2) {
            boolean z3;
            StringBuilder stringBuilder;
            TbsLogReport a;
            EventType eventType;
            File a2 = TbsDownloader.a(i);
            if (a2 != null && a2.exists()) {
                try {
                    k.b(a2, new File(k.a(this.g, 4), TbsDownloader.getOverSea(this.g) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
                    z3 = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (g()) {
                    h();
                    if (!com.tencent.smtt.utils.a.a(this.g, a2, 0, i)) {
                        k.b(a2);
                    }
                } else if (b(i)) {
                    TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-214));
                    TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
                    b(false);
                    if (z3) {
                        stringBuilder = new StringBuilder("use local backup apk in startDownload");
                        stringBuilder.append(this.a);
                        a(100, stringBuilder.toString(), true);
                        if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) != 1) {
                            a = TbsLogReport.a(this.g);
                            eventType = EventType.TYPE_DOWNLOAD_DECOUPLE;
                        } else {
                            a = TbsLogReport.a(this.g);
                            eventType = EventType.TYPE_DOWNLOAD;
                        }
                        a.a(eventType, this.v);
                        this.v.resetArgs();
                    }
                    return true;
                }
            }
            z3 = false;
            if (g()) {
                h();
                if (com.tencent.smtt.utils.a.a(this.g, a2, 0, i)) {
                    k.b(a2);
                }
            } else if (b(i)) {
                TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-214));
                TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
                b(false);
                if (z3) {
                    stringBuilder = new StringBuilder("use local backup apk in startDownload");
                    stringBuilder.append(this.a);
                    a(100, stringBuilder.toString(), true);
                    if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) != 1) {
                        a = TbsLogReport.a(this.g);
                        eventType = EventType.TYPE_DOWNLOAD;
                    } else {
                        a = TbsLogReport.a(this.g);
                        eventType = EventType.TYPE_DOWNLOAD_DECOUPLE;
                    }
                    a.a(eventType, this.v);
                    this.v.resetArgs();
                }
                return true;
            }
        }
        if (c(false, z2)) {
            TbsDownloadConfig.getInstance(this.g).a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-214));
            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(-214);
            b(false);
            return true;
        }
        if (!(c(true) || c(true))) {
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader] delete file failed!");
            TbsDownloadConfig.getInstance(this.g).setDownloadInterruptCode(ErrorConstant.ERROR_SESSION_INVALID);
        }
        return false;
    }

    public void b() {
        this.r = true;
        if (TbsShareManager.isThirdPartyApp(this.g)) {
            TbsLogInfo a = TbsLogReport.a(this.g).a();
            a.setErrorCode(-309);
            a.setFailDetail(new Exception());
            if (TbsDownloadConfig.getInstance(this.g).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                TbsLogReport.a(this.g).a(EventType.TYPE_DOWNLOAD_DECOUPLE, a);
                return;
            }
            TbsLogReport.a(this.g).a(EventType.TYPE_DOWNLOAD, a);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(boolean r36, boolean r37) {
        /*
        r35 = this;
        r1 = r35;
        r2 = r36;
        r3 = com.tencent.smtt.sdk.aj.a();
        r4 = r1.g;
        r3 = r3.c(r4);
        r4 = 0;
        if (r3 == 0) goto L_0x0021;
    L_0x0011:
        if (r2 != 0) goto L_0x0021;
    L_0x0013:
        com.tencent.smtt.sdk.TbsDownloader.a = r4;
        r2 = r1.g;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r3 = -322; // 0xfffffffffffffebe float:NaN double:NaN;
    L_0x001d:
        r2.setDownloadInterruptCode(r3);
        return;
    L_0x0021:
        r3 = r1.g;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);
        r3 = r3.mPreferences;
        r5 = "tbs_responsecode";
        r3 = r3.getInt(r5, r4);
        r5 = 2;
        r6 = 1;
        if (r3 == r6) goto L_0x003b;
    L_0x0033:
        if (r3 == r5) goto L_0x003b;
    L_0x0035:
        r7 = 4;
        if (r3 != r7) goto L_0x0039;
    L_0x0038:
        goto L_0x003b;
    L_0x0039:
        r7 = r4;
        goto L_0x003c;
    L_0x003b:
        r7 = r6;
    L_0x003c:
        if (r37 != 0) goto L_0x0047;
    L_0x003e:
        r3 = r1.a(r2, r7);
        if (r3 == 0) goto L_0x0047;
    L_0x0044:
        com.tencent.smtt.sdk.TbsDownloader.a = r4;
        return;
    L_0x0047:
        r1.C = r2;
        r3 = r1.g;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);
        r3 = r3.mPreferences;
        r8 = "tbs_downloadurl";
        r9 = 0;
        r3 = r3.getString(r8, r9);
        r1.h = r3;
        r3 = r1.g;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);
        r3 = r3.mPreferences;
        r8 = "tbs_downloadurl_list";
        r3 = r3.getString(r8, r9);
        r8 = "TbsDownload";
        r10 = new java.lang.StringBuilder;
        r11 = "backupUrlStrings:";
        r10.<init>(r11);
        r10.append(r3);
        r10 = r10.toString();
        com.tencent.smtt.utils.TbsLog.i(r8, r10, r6);
        r1.b = r9;
        r1.c = r4;
        if (r2 != 0) goto L_0x009b;
    L_0x0081:
        if (r3 == 0) goto L_0x009b;
    L_0x0083:
        r8 = "";
        r10 = r3.trim();
        r8 = r8.equals(r10);
        if (r8 != 0) goto L_0x009b;
    L_0x008f:
        r8 = r3.trim();
        r10 = ";";
        r8 = r8.split(r10);
        r1.b = r8;
    L_0x009b:
        r8 = "TbsDownload";
        r10 = new java.lang.StringBuilder;
        r11 = "[TbsApkDownloader.startDownload] mDownloadUrl=";
        r10.<init>(r11);
        r11 = r1.h;
        r10.append(r11);
        r11 = " backupUrlStrings=";
        r10.append(r11);
        r10.append(r3);
        r3 = " mLocation=";
        r10.append(r3);
        r3 = r1.j;
        r10.append(r3);
        r3 = " mCanceled=";
        r10.append(r3);
        r3 = r1.r;
        r10.append(r3);
        r3 = " mHttpRequest=";
        r10.append(r3);
        r3 = r1.t;
        r10.append(r3);
        r3 = r10.toString();
        com.tencent.smtt.utils.TbsLog.i(r8, r3);
        r3 = r1.h;
        r8 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        if (r3 != 0) goto L_0x00ef;
    L_0x00dc:
        r3 = r1.j;
        if (r3 != 0) goto L_0x00ef;
    L_0x00e0:
        r2 = com.tencent.smtt.sdk.QbSdk.k;
        r2.onDownloadFinish(r8);
        r2 = r1.g;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r3 = -302; // 0xfffffffffffffed2 float:NaN double:NaN;
        goto L_0x001d;
    L_0x00ef:
        r3 = r1.t;
        if (r3 == 0) goto L_0x0106;
    L_0x00f3:
        r3 = r1.r;
        if (r3 != 0) goto L_0x0106;
    L_0x00f7:
        r2 = com.tencent.smtt.sdk.QbSdk.k;
        r2.onDownloadFinish(r8);
        r2 = r1.g;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r3 = -303; // 0xfffffffffffffed1 float:NaN double:NaN;
        goto L_0x001d;
    L_0x0106:
        r3 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        if (r2 != 0) goto L_0x012c;
    L_0x010a:
        r10 = r1.A;
        r11 = r1.g;
        r11 = com.tencent.smtt.utils.Apn.getWifiSSID(r11);
        r10 = r10.contains(r11);
        if (r10 == 0) goto L_0x012c;
    L_0x0118:
        r2 = "TbsDownload";
        r4 = "[TbsApkDownloader.startDownload] WIFI Unavailable";
        com.tencent.smtt.utils.TbsLog.i(r2, r4);
        r2 = com.tencent.smtt.sdk.QbSdk.k;
        r2.onDownloadFinish(r8);
        r2 = r1.g;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        goto L_0x001d;
    L_0x012c:
        r35.e();
        r8 = "TbsDownload";
        r10 = "STEP 1/2 begin downloading...";
        com.tencent.smtt.utils.TbsLog.i(r8, r10, r6);
        r8 = r1.g;
        r8 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r8);
        r10 = r8.getDownloadMaxflow();
        r8 = r1.g;
        r8 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r8);
        r8 = r8.mPreferences;
        r12 = "tbs_downloadflow";
        r13 = 0;
        r15 = r8.getLong(r12, r13);
        if (r2 == 0) goto L_0x0157;
    L_0x0152:
        r8 = e;
    L_0x0154:
        r1.B = r8;
        goto L_0x015a;
    L_0x0157:
        r8 = d;
        goto L_0x0154;
    L_0x015a:
        r8 = r4;
        r3 = r15;
    L_0x015c:
        r12 = r1.p;
        r15 = r1.B;
        if (r12 > r15) goto L_0x0ae8;
    L_0x0162:
        r12 = r1.q;
        r15 = 8;
        if (r12 <= r15) goto L_0x017a;
    L_0x0168:
        r2 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        r1.a(r2, r9, r6);
        r2 = r1.g;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r3 = -306; // 0xfffffffffffffece float:NaN double:NaN;
        r2.setDownloadInterruptCode(r3);
        goto L_0x0ae8;
    L_0x017a:
        r5 = java.lang.System.currentTimeMillis();
        if (r2 != 0) goto L_0x0247;
    L_0x0180:
        r12 = r1.g;	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r12 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r12);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r12 = r12.mPreferences;	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r9 = "tbs_downloadstarttime";
        r17 = r12.getLong(r9, r13);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r19 = r5 - r17;
        r17 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r9 = (r19 > r17 ? 1 : (r19 == r17 ? 0 : -1));
        if (r9 <= 0) goto L_0x01cb;
    L_0x0197:
        r9 = "TbsDownload";
        r12 = "[TbsApkDownloader.startDownload] OVER DOWNLOAD_PERIOD";
        com.tencent.smtt.utils.TbsLog.i(r9, r12);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r9 = r1.g;	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r9 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r9);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r9 = r9.a;	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r12 = "tbs_downloadstarttime";
        r15 = java.lang.Long.valueOf(r5);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r9.put(r12, r15);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r9 = r1.g;	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r9 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r9);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r9 = r9.a;	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r12 = "tbs_downloadflow";
        r15 = java.lang.Long.valueOf(r13);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r9.put(r12, r15);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r9 = r1.g;	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r9 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r9);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r9.commit();	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r3 = r13;
        goto L_0x0219;
    L_0x01cb:
        r9 = "TbsDownload";
        r12 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r15 = "[TbsApkDownloader.startDownload] downloadFlow=";
        r12.<init>(r15);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r12.append(r3);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r12 = r12.toString();	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        com.tencent.smtt.utils.TbsLog.i(r9, r12);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r9 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1));
        if (r9 < 0) goto L_0x0219;
    L_0x01e2:
        r5 = "TbsDownload";
        r6 = "STEP 1/2 begin downloading...failed because you exceeded max flow!";
        r9 = 1;
        com.tencent.smtt.utils.TbsLog.i(r5, r6, r9);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r5 = 0;
        r6 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r1.a(r6, r5, r9);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r5 = r1.g;	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r6 = -307; // 0xfffffffffffffecd float:NaN double:NaN;
        r5.setDownloadInterruptCode(r6);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        if (r2 != 0) goto L_0x0ae8;
    L_0x01fd:
        r2 = r1.g;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r2 = r2.a;
        r5 = "tbs_downloadflow";
        r3 = java.lang.Long.valueOf(r3);
        r2.put(r5, r3);
    L_0x020e:
        r2 = r1.g;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r2.commit();
        goto L_0x0ae8;
    L_0x0219:
        r9 = r1.g;	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r9 = com.tencent.smtt.utils.k.b(r9);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        if (r9 != 0) goto L_0x0247;
    L_0x0221:
        r5 = "TbsDownload";
        r6 = "DownloadBegin FreeSpace too small";
        r9 = 1;
        com.tencent.smtt.utils.TbsLog.i(r5, r6, r9);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r5 = 0;
        r6 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        r1.a(r6, r5, r9);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r5 = r1.g;	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r6 = -308; // 0xfffffffffffffecc float:NaN double:NaN;
        r5.setDownloadInterruptCode(r6);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        if (r2 != 0) goto L_0x0ae8;
    L_0x023c:
        goto L_0x01fd;
    L_0x023d:
        r0 = move-exception;
        r12 = r3;
    L_0x023f:
        r3 = r0;
        goto L_0x0b1c;
    L_0x0242:
        r0 = move-exception;
    L_0x0243:
        r12 = r3;
    L_0x0244:
        r3 = r0;
        goto L_0x0a7c;
    L_0x0247:
        r9 = 1;
        r1.y = r9;	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r9 = r1.j;	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        if (r9 == 0) goto L_0x0251;
    L_0x024e:
        r9 = r1.j;	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        goto L_0x0253;
    L_0x0251:
        r9 = r1.h;	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
    L_0x0253:
        r12 = "TbsDownload";
        r15 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r13 = "try url:";
        r15.<init>(r13);	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r15.append(r9);	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r13 = ",mRetryTimes:";
        r15.append(r13);	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r13 = r1.p;	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r15.append(r13);	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r13 = r15.toString();	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r14 = 1;
        com.tencent.smtt.utils.TbsLog.i(r12, r13, r14);	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r12 = r1.i;	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r12 = r9.equals(r12);	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        if (r12 != 0) goto L_0x027e;
    L_0x0279:
        r12 = r1.v;	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r12.setDownloadUrl(r9);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
    L_0x027e:
        r1.i = r9;	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r1.a(r9);	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r9 = r1.o;	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        if (r9 != 0) goto L_0x031d;
    L_0x0287:
        r13 = r35.j();	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r9 = "TbsDownload";
        r12 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r15 = "[TbsApkDownloader.startDownload] range=";
        r12.<init>(r15);	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r12.append(r13);	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r12 = r12.toString();	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        com.tencent.smtt.utils.TbsLog.i(r9, r12);	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r21 = r5;
        r5 = r1.l;	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r15 = 0;
        r9 = (r5 > r15 ? 1 : (r5 == r15 ? 0 : -1));
        if (r9 > 0) goto L_0x02db;
    L_0x02a8:
        r5 = "TbsDownload";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r9 = "STEP 1/2 begin downloading...current";
        r6.<init>(r9);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r6.append(r13);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r9 = 1;
        com.tencent.smtt.utils.TbsLog.i(r5, r6, r9);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r5 = r1.t;	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r6 = "Range";
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r12 = "bytes=";
        r9.<init>(r12);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r9.append(r13);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r12 = "-";
        r9.append(r12);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r5.setRequestProperty(r6, r9);	 Catch:{ Throwable -> 0x0242, all -> 0x023d }
        r23 = r8;
        r24 = r13;
        goto L_0x0323;
    L_0x02db:
        r5 = "TbsDownload";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r9 = "#1 STEP 1/2 begin downloading...current/total=";
        r6.<init>(r9);	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r6.append(r13);	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r9 = "/";
        r6.append(r9);	 Catch:{ Throwable -> 0x0a77, all -> 0x023d }
        r23 = r8;
        r8 = r1.l;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6.append(r8);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r8 = 1;
        com.tencent.smtt.utils.TbsLog.i(r5, r6, r8);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = r1.t;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = "Range";
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r9 = "bytes=";
        r8.<init>(r9);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r8.append(r13);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r9 = "-";
        r8.append(r9);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r24 = r13;
        r12 = r1.l;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r8.append(r12);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r8 = r8.toString();	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5.setRequestProperty(r6, r8);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        goto L_0x0323;
    L_0x031d:
        r21 = r5;
        r23 = r8;
        r24 = 0;
    L_0x0323:
        r5 = r1.v;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r8 = 0;
        r6 = (r24 > r8 ? 1 : (r24 == r8 ? 0 : -1));
        if (r6 != 0) goto L_0x032d;
    L_0x032b:
        r6 = 0;
        goto L_0x032e;
    L_0x032d:
        r6 = 1;
    L_0x032e:
        r5.setDownloadCancel(r6);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = r1.g;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = com.tencent.smtt.utils.Apn.getApnType(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = r1.g;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = com.tencent.smtt.utils.Apn.getApnInfo(r6);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r8 = r1.w;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r8 != 0) goto L_0x034b;
    L_0x0341:
        r8 = r1.x;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r9 = -1;
        if (r8 != r9) goto L_0x034b;
    L_0x0346:
        r1.w = r6;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
    L_0x0348:
        r1.x = r5;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        goto L_0x0360;
    L_0x034b:
        r8 = r1.x;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r5 != r8) goto L_0x0357;
    L_0x034f:
        r8 = r1.w;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r8 = r6.equals(r8);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r8 != 0) goto L_0x0360;
    L_0x0357:
        r8 = r1.v;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r9 = 0;
        r8.setNetworkChange(r9);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r1.w = r6;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        goto L_0x0348;
    L_0x0360:
        r5 = r1.p;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r5 <= 0) goto L_0x036d;
    L_0x0364:
        r5 = r1.t;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = "Referer";
        r8 = r1.h;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5.addRequestProperty(r6, r8);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
    L_0x036d:
        r5 = r1.t;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = r5.getResponseCode();	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = "TbsDownload";
        r8 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r9 = "[TbsApkDownloader.startDownload] responseCode=";
        r8.<init>(r9);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r8.append(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r8 = r8.toString();	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        com.tencent.smtt.utils.TbsLog.i(r6, r8);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = r1.v;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6.setHttpCode(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r8 = 3;
        if (r2 != 0) goto L_0x03c2;
    L_0x0390:
        r9 = r1.g;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r9 = com.tencent.smtt.sdk.TbsDownloader.getOverSea(r9);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r9 != 0) goto L_0x03c2;
    L_0x0398:
        r9 = r1.g;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r9 = com.tencent.smtt.utils.Apn.getApnType(r9);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r9 == r8) goto L_0x03a6;
    L_0x03a0:
        r9 = com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi();	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r9 == 0) goto L_0x03ae;
    L_0x03a6:
        r9 = r1.g;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r9 = com.tencent.smtt.utils.Apn.getApnType(r9);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r9 != 0) goto L_0x03c2;
    L_0x03ae:
        r35.b();	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r9 = com.tencent.smtt.sdk.QbSdk.k;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r9 == 0) goto L_0x03ba;
    L_0x03b5:
        r9 = com.tencent.smtt.sdk.QbSdk.k;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r9.onDownloadFinish(r6);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
    L_0x03ba:
        r9 = "TbsDownload";
        r12 = "Download is canceled due to NOT_WIFI error!";
        r13 = 0;
        com.tencent.smtt.utils.TbsLog.i(r9, r12, r13);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
    L_0x03c2:
        r9 = r1.r;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r9 == 0) goto L_0x03d5;
    L_0x03c6:
        r5 = r1.g;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = -309; // 0xfffffffffffffecb float:NaN double:NaN;
        r5.setDownloadInterruptCode(r6);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r2 != 0) goto L_0x0b39;
    L_0x03d3:
        goto L_0x0939;
    L_0x03d5:
        r9 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r5 == r9) goto L_0x0536;
    L_0x03d9:
        r9 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r5 != r9) goto L_0x03df;
    L_0x03dd:
        goto L_0x0536;
    L_0x03df:
        r6 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r5 < r6) goto L_0x0417;
    L_0x03e3:
        r6 = 307; // 0x133 float:4.3E-43 double:1.517E-321;
        if (r5 > r6) goto L_0x0417;
    L_0x03e7:
        r5 = r1.t;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = "Location";
        r5 = r5.getHeaderField(r6);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r6 != 0) goto L_0x0401;
    L_0x03f5:
        r1.j = r5;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = r1.q;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = 1;
        r5 = r5 + r6;
        r1.q = r5;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r2 != 0) goto L_0x05ba;
    L_0x03ff:
        goto L_0x0494;
    L_0x0401:
        r5 = 124; // 0x7c float:1.74E-43 double:6.13E-322;
        r6 = 1;
        r8 = 0;
        r1.a(r5, r8, r6);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = r1.g;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = -312; // 0xfffffffffffffec8 float:NaN double:NaN;
        r5.setDownloadInterruptCode(r6);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r2 != 0) goto L_0x0b39;
    L_0x0415:
        goto L_0x0939;
    L_0x0417:
        r6 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r8 = java.lang.String.valueOf(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r9 = 0;
        r1.a(r6, r8, r9);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = 416; // 0x1a0 float:5.83E-43 double:2.055E-321;
        if (r5 != r6) goto L_0x046f;
    L_0x0425:
        r6 = 1;
        r5 = r1.c(r6, r7);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r5 == 0) goto L_0x045c;
    L_0x042c:
        r5 = r1.g;	 Catch:{ Throwable -> 0x0457, all -> 0x023d }
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);	 Catch:{ Throwable -> 0x0457, all -> 0x023d }
        r6 = -214; // 0xffffffffffffff2a float:NaN double:NaN;
        r5.setDownloadInterruptCode(r6);	 Catch:{ Throwable -> 0x0457, all -> 0x023d }
        if (r2 != 0) goto L_0x0453;
    L_0x0439:
        r2 = r1.g;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r2 = r2.a;
        r5 = "tbs_downloadflow";
        r3 = java.lang.Long.valueOf(r3);
        r2.put(r5, r3);
        r2 = r1.g;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r2.commit();
    L_0x0453:
        r23 = 1;
        goto L_0x0b39;
    L_0x0457:
        r0 = move-exception;
        r12 = r3;
        r8 = 1;
        goto L_0x0244;
    L_0x045c:
        r5 = 0;
        r1.c(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = r1.g;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = -313; // 0xfffffffffffffec7 float:NaN double:NaN;
        r5.setDownloadInterruptCode(r6);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r2 != 0) goto L_0x0b39;
    L_0x046d:
        goto L_0x0939;
    L_0x046f:
        r6 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r5 == r6) goto L_0x0477;
    L_0x0473:
        r6 = 406; // 0x196 float:5.69E-43 double:2.006E-321;
        if (r5 != r6) goto L_0x048e;
    L_0x0477:
        r8 = r1.l;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r12 = -1;
        r6 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r6 != 0) goto L_0x048e;
    L_0x047f:
        r5 = r1.g;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = -314; // 0xfffffffffffffec6 float:NaN double:NaN;
        r5.setDownloadInterruptCode(r6);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r2 != 0) goto L_0x0b39;
    L_0x048c:
        goto L_0x0939;
    L_0x048e:
        r6 = 202; // 0xca float:2.83E-43 double:1.0E-321;
        if (r5 != r6) goto L_0x04b0;
    L_0x0492:
        if (r2 != 0) goto L_0x05ba;
    L_0x0494:
        r5 = r1.g;
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);
        r5 = r5.a;
        r6 = "tbs_downloadflow";
        r8 = java.lang.Long.valueOf(r3);
        r5.put(r6, r8);
        r5 = r1.g;
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);
        r5.commit();
        goto L_0x05ba;
    L_0x04b0:
        r6 = r1.p;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r8 = r1.B;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r6 >= r8) goto L_0x04df;
    L_0x04b6:
        r6 = 503; // 0x1f7 float:7.05E-43 double:2.485E-321;
        if (r5 != r6) goto L_0x04df;
    L_0x04ba:
        r5 = r1.t;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = "Retry-After";
        r5 = r5.getHeaderField(r6);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = java.lang.Long.parseLong(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r1.a(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = r1.r;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r5 == 0) goto L_0x04dc;
    L_0x04cd:
        r5 = r1.g;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = -309; // 0xfffffffffffffecb float:NaN double:NaN;
        r5.setDownloadInterruptCode(r6);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r2 != 0) goto L_0x0b39;
    L_0x04da:
        goto L_0x0939;
    L_0x04dc:
        if (r2 != 0) goto L_0x05ba;
    L_0x04de:
        goto L_0x0494;
    L_0x04df:
        r6 = r1.p;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r8 = r1.B;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r6 >= r8) goto L_0x050e;
    L_0x04e5:
        r6 = 408; // 0x198 float:5.72E-43 double:2.016E-321;
        if (r5 == r6) goto L_0x04f3;
    L_0x04e9:
        r8 = 504; // 0x1f8 float:7.06E-43 double:2.49E-321;
        if (r5 == r8) goto L_0x04f3;
    L_0x04ed:
        r8 = 502; // 0x1f6 float:7.03E-43 double:2.48E-321;
        if (r5 == r8) goto L_0x04f3;
    L_0x04f1:
        if (r5 != r6) goto L_0x050e;
    L_0x04f3:
        r5 = 0;
        r1.a(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = r1.r;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r5 == 0) goto L_0x050b;
    L_0x04fc:
        r5 = r1.g;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = -309; // 0xfffffffffffffecb float:NaN double:NaN;
        r5.setDownloadInterruptCode(r6);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r2 != 0) goto L_0x0b39;
    L_0x0509:
        goto L_0x0939;
    L_0x050b:
        if (r2 != 0) goto L_0x05ba;
    L_0x050d:
        goto L_0x0494;
    L_0x050e:
        r8 = r35.j();	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r12 = 0;
        r6 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1));
        if (r6 > 0) goto L_0x0527;
    L_0x0518:
        r6 = r1.o;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r6 != 0) goto L_0x0527;
    L_0x051c:
        r6 = 410; // 0x19a float:5.75E-43 double:2.026E-321;
        if (r5 == r6) goto L_0x0527;
    L_0x0520:
        r5 = 1;
        r1.o = r5;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r2 != 0) goto L_0x05ba;
    L_0x0525:
        goto L_0x0494;
    L_0x0527:
        r5 = r1.g;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = -315; // 0xfffffffffffffec5 float:NaN double:NaN;
        r5.setDownloadInterruptCode(r6);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r2 != 0) goto L_0x0b39;
    L_0x0534:
        goto L_0x0939;
    L_0x0536:
        r5 = r1.t;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = r5.getContentLength();	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r12 = (long) r5;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r14 = r12 + r24;
        r1.l = r14;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = "TbsDownload";
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r12 = "[TbsApkDownloader.startDownload] mContentLength=";
        r9.<init>(r12);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r12 = r1.l;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r9.append(r12);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        com.tencent.smtt.utils.TbsLog.i(r5, r9);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = r1.v;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r12 = r1.l;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5.setPkgSize(r12);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = r1.g;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = r5.mPreferences;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r9 = "tbs_apkfilesize";
        r12 = 0;
        r14 = r5.getLong(r9, r12);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1));
        if (r5 == 0) goto L_0x0604;
    L_0x0571:
        r12 = r1.l;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
        if (r5 == 0) goto L_0x0604;
    L_0x0577:
        r5 = "TbsDownload";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r8 = "DownloadBegin tbsApkFileSize=";
        r6.<init>(r8);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6.append(r14);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r8 = "  but contentLength=";
        r6.append(r8);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r8 = r1.l;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6.append(r8);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r8 = 1;
        com.tencent.smtt.utils.TbsLog.i(r5, r6, r8);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r2 != 0) goto L_0x05ed;
    L_0x0597:
        r5 = r35.m();	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r5 != 0) goto L_0x05ab;
    L_0x059d:
        r5 = com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi();	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r5 == 0) goto L_0x05ed;
    L_0x05a3:
        r5 = r1.g;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = com.tencent.smtt.utils.Apn.isNetworkAvailable(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r5 == 0) goto L_0x05ed;
    L_0x05ab:
        r5 = r1.b;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r5 == 0) goto L_0x05c3;
    L_0x05af:
        r5 = 0;
        r6 = r1.a(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r6 == 0) goto L_0x05c3;
    L_0x05b6:
        if (r2 != 0) goto L_0x05ba;
    L_0x05b8:
        goto L_0x0494;
    L_0x05ba:
        r8 = r23;
    L_0x05bc:
        r5 = 2;
        r6 = 1;
        r9 = 0;
        r13 = 0;
        goto L_0x015c;
    L_0x05c3:
        r5 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r8 = "tbsApkFileSize=";
        r6.<init>(r8);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6.append(r14);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r8 = "  but contentLength=";
        r6.append(r8);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r8 = r1.l;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6.append(r8);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r8 = 1;
        r1.a(r5, r6, r8);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = r1.g;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = -310; // 0xfffffffffffffeca float:NaN double:NaN;
        r5.setDownloadInterruptCode(r6);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        goto L_0x0600;
    L_0x05ed:
        r5 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r6 = "WifiNetworkUnAvailable";
        r8 = 1;
        r1.a(r5, r6, r8);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = r1.g;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        r5.setDownloadInterruptCode(r6);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
    L_0x0600:
        if (r2 != 0) goto L_0x0b39;
    L_0x0602:
        goto L_0x0939;
    L_0x0604:
        r5 = "TbsDownload";
        r9 = "[TbsApkDownloader.startDownload] begin readResponse";
        com.tencent.smtt.utils.TbsLog.i(r5, r9);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = r1.t;	 Catch:{ IOException -> 0x095e, all -> 0x0955 }
        r9 = r5.getInputStream();	 Catch:{ IOException -> 0x095e, all -> 0x0955 }
        if (r9 == 0) goto L_0x091a;
    L_0x0613:
        r5 = r1.t;	 Catch:{ IOException -> 0x0911, all -> 0x090b }
        r5 = r5.getContentEncoding();	 Catch:{ IOException -> 0x0911, all -> 0x090b }
        if (r5 == 0) goto L_0x063a;
    L_0x061b:
        r12 = "gzip";
        r12 = r5.contains(r12);	 Catch:{ IOException -> 0x062f, all -> 0x0629 }
        if (r12 == 0) goto L_0x063a;
    L_0x0623:
        r5 = new java.util.zip.GZIPInputStream;	 Catch:{ IOException -> 0x062f, all -> 0x0629 }
        r5.<init>(r9);	 Catch:{ IOException -> 0x062f, all -> 0x0629 }
        goto L_0x0651;
    L_0x0629:
        r0 = move-exception;
        r31 = r3;
        r6 = r9;
        goto L_0x090f;
    L_0x062f:
        r0 = move-exception;
        r13 = r3;
        r6 = r9;
        r8 = r23;
        r5 = 0;
        r9 = 0;
        r12 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        goto L_0x0967;
    L_0x063a:
        if (r5 == 0) goto L_0x0650;
    L_0x063c:
        r12 = "deflate";
        r5 = r5.contains(r12);	 Catch:{ IOException -> 0x062f, all -> 0x0629 }
        if (r5 == 0) goto L_0x0650;
    L_0x0644:
        r5 = new java.util.zip.InflaterInputStream;	 Catch:{ IOException -> 0x062f, all -> 0x0629 }
        r12 = new java.util.zip.Inflater;	 Catch:{ IOException -> 0x062f, all -> 0x0629 }
        r13 = 1;
        r12.<init>(r13);	 Catch:{ IOException -> 0x062f, all -> 0x0629 }
        r5.<init>(r9, r12);	 Catch:{ IOException -> 0x062f, all -> 0x0629 }
        goto L_0x0651;
    L_0x0650:
        r5 = r9;
    L_0x0651:
        r12 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r12 = new byte[r12];	 Catch:{ IOException -> 0x0903, all -> 0x08fe }
        r13 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0903, all -> 0x08fe }
        r14 = new java.io.File;	 Catch:{ IOException -> 0x0903, all -> 0x08fe }
        r15 = r1.k;	 Catch:{ IOException -> 0x0903, all -> 0x08fe }
        r6 = "x5.tbs.temp";
        r14.<init>(r15, r6);	 Catch:{ IOException -> 0x0903, all -> 0x08fe }
        r6 = 1;
        r13.<init>(r14, r6);	 Catch:{ IOException -> 0x0903, all -> 0x08fe }
        r14 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x08f4, all -> 0x08ee }
        r26 = r9;
        r8 = r21;
        r17 = r24;
    L_0x066e:
        r6 = r1.r;	 Catch:{ IOException -> 0x08ea, all -> 0x08e6 }
        if (r6 == 0) goto L_0x069e;
    L_0x0672:
        r6 = "TbsDownload";
        r8 = "STEP 1/2 begin downloading...Canceled!";
        r9 = 1;
        com.tencent.smtt.utils.TbsLog.i(r6, r8, r9);	 Catch:{ IOException -> 0x0694, all -> 0x068d }
        r6 = r1.g;	 Catch:{ IOException -> 0x0694, all -> 0x068d }
        r6 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r6);	 Catch:{ IOException -> 0x0694, all -> 0x068d }
        r8 = -309; // 0xfffffffffffffecb float:NaN double:NaN;
        r6.setDownloadInterruptCode(r8);	 Catch:{ IOException -> 0x0694, all -> 0x068d }
        r8 = r3;
        r29 = r13;
    L_0x0688:
        r3 = 0;
    L_0x0689:
        r12 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        goto L_0x084c;
    L_0x068d:
        r0 = move-exception;
        r31 = r3;
    L_0x0690:
        r6 = r26;
        goto L_0x095b;
    L_0x0694:
        r0 = move-exception;
        r9 = r13;
        r8 = r23;
    L_0x0698:
        r6 = r26;
        r12 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        goto L_0x08fb;
    L_0x069e:
        r6 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r27 = r14;
        r14 = 0;
        r6 = r5.read(r12, r14, r6);	 Catch:{ IOException -> 0x08ea, all -> 0x08e6 }
        if (r6 > 0) goto L_0x06f7;
    L_0x06a9:
        r6 = r1.b;	 Catch:{ IOException -> 0x0694, all -> 0x068d }
        if (r6 == 0) goto L_0x06ce;
    L_0x06ad:
        r6 = 1;
        r8 = r1.c(r6, r7);	 Catch:{ IOException -> 0x0694, all -> 0x068d }
        if (r8 != 0) goto L_0x06ce;
    L_0x06b4:
        if (r2 != 0) goto L_0x06c1;
    L_0x06b6:
        r6 = r1.a(r14);	 Catch:{ IOException -> 0x0694, all -> 0x068d }
        if (r6 == 0) goto L_0x06c1;
    L_0x06bc:
        r8 = r3;
        r29 = r13;
        r3 = 1;
        goto L_0x0689;
    L_0x06c1:
        r6 = 1;
        r1.s = r6;	 Catch:{ IOException -> 0x0694, all -> 0x068d }
        r8 = r3;
        r29 = r13;
        r3 = 0;
        r12 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        r23 = 0;
        goto L_0x084c;
    L_0x06ce:
        r6 = 1;
        r1.s = r6;	 Catch:{ IOException -> 0x0694, all -> 0x068d }
        r6 = r1.b;	 Catch:{ IOException -> 0x0694, all -> 0x068d }
        if (r6 == 0) goto L_0x06d7;
    L_0x06d5:
        r8 = 1;
        goto L_0x06d9;
    L_0x06d7:
        r8 = r23;
    L_0x06d9:
        r6 = r1.g;	 Catch:{ IOException -> 0x06f4, all -> 0x06ee }
        r6 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r6);	 Catch:{ IOException -> 0x06f4, all -> 0x06ee }
        r9 = -311; // 0xfffffffffffffec9 float:NaN double:NaN;
        r6.setDownloadInterruptCode(r9);	 Catch:{ IOException -> 0x06f4, all -> 0x06ee }
        r23 = r8;
        r29 = r13;
        r12 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        r8 = r3;
    L_0x06eb:
        r3 = 0;
        goto L_0x084c;
    L_0x06ee:
        r0 = move-exception;
        r31 = r3;
        r23 = r8;
        goto L_0x0690;
    L_0x06f4:
        r0 = move-exception;
        r9 = r13;
        goto L_0x0698;
    L_0x06f7:
        r13.write(r12, r14, r6);	 Catch:{ IOException -> 0x08ea, all -> 0x08e6 }
        r13.flush();	 Catch:{ IOException -> 0x08ea, all -> 0x08e6 }
        if (r2 != 0) goto L_0x079f;
    L_0x06ff:
        r14 = (long) r6;
        r30 = r12;
        r29 = r13;
        r12 = r3 + r14;
        r3 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));
        if (r3 < 0) goto L_0x0751;
    L_0x070a:
        r3 = "TbsDownload";
        r4 = "STEP 1/2 begin downloading...failed because you exceeded max flow!";
        r6 = 1;
        com.tencent.smtt.utils.TbsLog.i(r3, r4, r6);	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r4 = "downloadFlow=";
        r3.<init>(r4);	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r3.append(r12);	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r4 = " downloadMaxflow=";
        r3.append(r4);	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r3.append(r10);	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r3 = r3.toString();	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r4 = 1;
        r14 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r1.a(r14, r3, r4);	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r3 = r1.g;	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r15 = -307; // 0xfffffffffffffecd float:NaN double:NaN;
        r3.setDownloadInterruptCode(r15);	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        goto L_0x079a;
    L_0x073a:
        r0 = move-exception;
        r3 = r0;
        r31 = r12;
    L_0x073e:
        r6 = r26;
        r13 = r29;
        goto L_0x0a5a;
    L_0x0744:
        r0 = move-exception;
        r3 = r0;
        r13 = r12;
        r8 = r23;
        r6 = r26;
        r9 = r29;
    L_0x074d:
        r12 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        goto L_0x0968;
    L_0x0751:
        r14 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r15 = -307; // 0xfffffffffffffecd float:NaN double:NaN;
        r3 = r1.g;	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r3 = com.tencent.smtt.utils.k.b(r3);	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        if (r3 != 0) goto L_0x079d;
    L_0x075d:
        r3 = "TbsDownload";
        r4 = "DownloadEnd FreeSpace too small ";
        r6 = 1;
        com.tencent.smtt.utils.TbsLog.i(r3, r4, r6);	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r4 = "freespace=";
        r3.<init>(r4);	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r8 = com.tencent.smtt.utils.aa.a();	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r3.append(r8);	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r4 = ",and minFreeSpace=";
        r3.append(r4);	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r4 = r1.g;	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r8 = r4.getDownloadMinFreeSpace();	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r3.append(r8);	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r3 = r3.toString();	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r4 = 1;
        r6 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        r1.a(r6, r3, r4);	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r3 = r1.g;	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);	 Catch:{ IOException -> 0x0744, all -> 0x073a }
        r4 = -308; // 0xfffffffffffffecc float:NaN double:NaN;
        r3.setDownloadInterruptCode(r4);	 Catch:{ IOException -> 0x0744, all -> 0x073a }
    L_0x079a:
        r8 = r12;
        goto L_0x0688;
    L_0x079d:
        r3 = r12;
        goto L_0x07a7;
    L_0x079f:
        r30 = r12;
        r29 = r13;
        r14 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r15 = -307; // 0xfffffffffffffecd float:NaN double:NaN;
    L_0x07a7:
        r12 = (long) r6;
        r8 = r1.a(r8, r12);	 Catch:{ IOException -> 0x08d5, all -> 0x08cb }
        r19 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x08d5, all -> 0x08cb }
        r14 = r24 + r12;
        r12 = r19 - r27;
        r21 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = (r12 > r21 ? 1 : (r12 == r21 ? 0 : -1));
        if (r6 <= 0) goto L_0x08b2;
    L_0x07ba:
        r6 = "TbsDownload";
        r12 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x08d5, all -> 0x08cb }
        r13 = "#2 STEP 1/2 begin downloading...current/total=";
        r12.<init>(r13);	 Catch:{ IOException -> 0x08d5, all -> 0x08cb }
        r12.append(r14);	 Catch:{ IOException -> 0x08d5, all -> 0x08cb }
        r13 = "/";
        r12.append(r13);	 Catch:{ IOException -> 0x08d5, all -> 0x08cb }
        r31 = r3;
        r3 = r1.l;	 Catch:{ IOException -> 0x08b0, all -> 0x08ae }
        r12.append(r3);	 Catch:{ IOException -> 0x08b0, all -> 0x08ae }
        r3 = r12.toString();	 Catch:{ IOException -> 0x08b0, all -> 0x08ae }
        r4 = 1;
        com.tencent.smtt.utils.TbsLog.i(r6, r3, r4);	 Catch:{ IOException -> 0x08b0, all -> 0x08ae }
        r3 = com.tencent.smtt.sdk.QbSdk.k;	 Catch:{ IOException -> 0x08b0, all -> 0x08ae }
        if (r3 == 0) goto L_0x07fd;
    L_0x07de:
        r3 = (double) r14;
        r12 = r1.l;	 Catch:{ IOException -> 0x07f1, all -> 0x07ed }
        r12 = (double) r12;	 Catch:{ IOException -> 0x07f1, all -> 0x07ed }
        r3 = r3 / r12;
        r12 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r3 = r3 * r12;
        r3 = (int) r3;	 Catch:{ IOException -> 0x07f1, all -> 0x07ed }
        r4 = com.tencent.smtt.sdk.QbSdk.k;	 Catch:{ IOException -> 0x07f1, all -> 0x07ed }
        r4.onDownloadProgress(r3);	 Catch:{ IOException -> 0x07f1, all -> 0x07ed }
        goto L_0x07fd;
    L_0x07ed:
        r0 = move-exception;
        r3 = r0;
        goto L_0x073e;
    L_0x07f1:
        r0 = move-exception;
        r3 = r0;
        r8 = r23;
        r6 = r26;
        r9 = r29;
        r13 = r31;
        goto L_0x074d;
    L_0x07fd:
        if (r2 != 0) goto L_0x08a4;
    L_0x07ff:
        r3 = r14 - r17;
        r12 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        r6 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1));
        if (r6 <= 0) goto L_0x08a4;
    L_0x0808:
        r3 = r1.g;	 Catch:{ IOException -> 0x08b0, all -> 0x08ae }
        r3 = com.tencent.smtt.sdk.TbsDownloader.getOverSea(r3);	 Catch:{ IOException -> 0x08b0, all -> 0x08ae }
        if (r3 != 0) goto L_0x0898;
    L_0x0810:
        r3 = r1.g;	 Catch:{ IOException -> 0x08b0, all -> 0x08ae }
        r3 = com.tencent.smtt.utils.Apn.getApnType(r3);	 Catch:{ IOException -> 0x08b0, all -> 0x08ae }
        r4 = 3;
        if (r3 == r4) goto L_0x081f;
    L_0x0819:
        r3 = com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi();	 Catch:{ IOException -> 0x07f1, all -> 0x07ed }
        if (r3 == 0) goto L_0x0827;
    L_0x081f:
        r3 = r1.g;	 Catch:{ IOException -> 0x08b0, all -> 0x08ae }
        r3 = com.tencent.smtt.utils.Apn.getApnType(r3);	 Catch:{ IOException -> 0x08b0, all -> 0x08ae }
        if (r3 != 0) goto L_0x0893;
    L_0x0827:
        r35.b();	 Catch:{ IOException -> 0x08b0, all -> 0x08ae }
        r3 = com.tencent.smtt.sdk.QbSdk.k;	 Catch:{ IOException -> 0x08b0, all -> 0x08ae }
        if (r3 == 0) goto L_0x0835;
    L_0x082e:
        r3 = com.tencent.smtt.sdk.QbSdk.k;	 Catch:{ IOException -> 0x07f1, all -> 0x07ed }
        r6 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r3.onDownloadFinish(r6);	 Catch:{ IOException -> 0x07f1, all -> 0x07ed }
    L_0x0835:
        r3 = "TbsDownload";
        r4 = "Download is paused due to NOT_WIFI error!";
        r6 = 0;
        com.tencent.smtt.utils.TbsLog.i(r3, r4, r6);	 Catch:{ IOException -> 0x08b0, all -> 0x08ae }
        r3 = r1.g;	 Catch:{ IOException -> 0x08b0, all -> 0x08ae }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);	 Catch:{ IOException -> 0x08b0, all -> 0x08ae }
        r12 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        r3.setDownloadInterruptCode(r12);	 Catch:{ IOException -> 0x088d, all -> 0x08ae }
        r8 = r31;
        goto L_0x06eb;
    L_0x084c:
        if (r3 == 0) goto L_0x0886;
    L_0x084e:
        r13 = r29;
        r1.a(r13);	 Catch:{ Throwable -> 0x087f, all -> 0x087a }
        r1.a(r5);	 Catch:{ Throwable -> 0x087f, all -> 0x087a }
        r3 = r26;
        r1.a(r3);	 Catch:{ Throwable -> 0x087f, all -> 0x087a }
        if (r2 != 0) goto L_0x0877;
    L_0x085d:
        r3 = r1.g;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);
        r3 = r3.a;
        r4 = "tbs_downloadflow";
        r5 = java.lang.Long.valueOf(r8);
        r3.put(r4, r5);
        r3 = r1.g;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);
        r3.commit();
    L_0x0877:
        r3 = r8;
        goto L_0x05ba;
    L_0x087a:
        r0 = move-exception;
        r3 = r0;
        r12 = r8;
        goto L_0x0b1c;
    L_0x087f:
        r0 = move-exception;
        r3 = r0;
        r12 = r8;
        r8 = r23;
        goto L_0x0a7c;
    L_0x0886:
        r13 = r29;
        r3 = r8;
        r6 = r26;
        goto L_0x091f;
    L_0x088d:
        r0 = move-exception;
        r3 = r26;
        r13 = r29;
        goto L_0x08de;
    L_0x0893:
        r3 = r26;
        r13 = r29;
        goto L_0x089d;
    L_0x0898:
        r3 = r26;
        r13 = r29;
        r4 = 3;
    L_0x089d:
        r6 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r12 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        r17 = r14;
        goto L_0x08bf;
    L_0x08a4:
        r3 = r26;
        r13 = r29;
        r4 = 3;
        r6 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r12 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        goto L_0x08bf;
    L_0x08ae:
        r0 = move-exception;
        goto L_0x08ce;
    L_0x08b0:
        r0 = move-exception;
        goto L_0x08d8;
    L_0x08b2:
        r31 = r3;
        r3 = r26;
        r13 = r29;
        r4 = 3;
        r6 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r12 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        r19 = r27;
    L_0x08bf:
        r26 = r3;
        r24 = r14;
        r14 = r19;
        r12 = r30;
        r3 = r31;
        goto L_0x066e;
    L_0x08cb:
        r0 = move-exception;
        r31 = r3;
    L_0x08ce:
        r3 = r26;
        r13 = r29;
        r6 = r3;
        goto L_0x095b;
    L_0x08d5:
        r0 = move-exception;
        r31 = r3;
    L_0x08d8:
        r3 = r26;
        r13 = r29;
        r12 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
    L_0x08de:
        r6 = r3;
        r9 = r13;
        r8 = r23;
        r13 = r31;
        goto L_0x0967;
    L_0x08e6:
        r0 = move-exception;
        r6 = r26;
        goto L_0x08f0;
    L_0x08ea:
        r0 = move-exception;
        r6 = r26;
        goto L_0x08f6;
    L_0x08ee:
        r0 = move-exception;
        r6 = r9;
    L_0x08f0:
        r31 = r3;
        goto L_0x095b;
    L_0x08f4:
        r0 = move-exception;
        r6 = r9;
    L_0x08f6:
        r12 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        r9 = r13;
        r8 = r23;
    L_0x08fb:
        r13 = r3;
        goto L_0x0967;
    L_0x08fe:
        r0 = move-exception;
        r6 = r9;
        r31 = r3;
        goto L_0x095a;
    L_0x0903:
        r0 = move-exception;
        r6 = r9;
        r12 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        r13 = r3;
        r8 = r23;
        goto L_0x0966;
    L_0x090b:
        r0 = move-exception;
        r6 = r9;
        r31 = r3;
    L_0x090f:
        r5 = 0;
        goto L_0x095a;
    L_0x0911:
        r0 = move-exception;
        r6 = r9;
        r12 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        r13 = r3;
        r8 = r23;
        r5 = 0;
        goto L_0x0966;
    L_0x091a:
        r6 = r9;
        r12 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        r5 = 0;
        r13 = 0;
    L_0x091f:
        r1.a(r13);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r1.a(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r1.a(r6);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = r1.s;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        if (r5 != 0) goto L_0x0937;
    L_0x092c:
        r5 = r1.g;	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
        r6 = -319; // 0xfffffffffffffec1 float:NaN double:NaN;
        r5.setDownloadInterruptCode(r6);	 Catch:{ Throwable -> 0x0a71, all -> 0x023d }
    L_0x0937:
        if (r2 != 0) goto L_0x0b39;
    L_0x0939:
        r2 = r1.g;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r2 = r2.a;
        r5 = "tbs_downloadflow";
        r3 = java.lang.Long.valueOf(r3);
        r2.put(r5, r3);
        r2 = r1.g;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r2.commit();
        goto L_0x0b39;
    L_0x0955:
        r0 = move-exception;
        r31 = r3;
        r5 = 0;
        r6 = 0;
    L_0x095a:
        r13 = 0;
    L_0x095b:
        r3 = r0;
        goto L_0x0a5a;
    L_0x095e:
        r0 = move-exception;
        r12 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
        r13 = r3;
        r8 = r23;
        r5 = 0;
        r6 = 0;
    L_0x0966:
        r9 = 0;
    L_0x0967:
        r3 = r0;
    L_0x0968:
        r3.printStackTrace();	 Catch:{ all -> 0x0a52 }
        r4 = r3 instanceof java.net.SocketTimeoutException;	 Catch:{ all -> 0x0a52 }
        if (r4 != 0) goto L_0x0a10;
    L_0x096f:
        r4 = r3 instanceof java.net.SocketException;	 Catch:{ all -> 0x0a52 }
        if (r4 == 0) goto L_0x0975;
    L_0x0973:
        goto L_0x0a10;
    L_0x0975:
        if (r2 != 0) goto L_0x09e5;
    L_0x0977:
        r4 = r1.g;	 Catch:{ all -> 0x0a52 }
        r4 = com.tencent.smtt.utils.k.b(r4);	 Catch:{ all -> 0x0a52 }
        if (r4 != 0) goto L_0x09e5;
    L_0x097f:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0a52 }
        r4 = "freespace=";
        r3.<init>(r4);	 Catch:{ all -> 0x0a52 }
        r33 = r13;
        r12 = com.tencent.smtt.utils.aa.a();	 Catch:{ all -> 0x09e0 }
        r3.append(r12);	 Catch:{ all -> 0x09e0 }
        r4 = ",and minFreeSpace=";
        r3.append(r4);	 Catch:{ all -> 0x09e0 }
        r4 = r1.g;	 Catch:{ all -> 0x09e0 }
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);	 Catch:{ all -> 0x09e0 }
        r12 = r4.getDownloadMinFreeSpace();	 Catch:{ all -> 0x09e0 }
        r3.append(r12);	 Catch:{ all -> 0x09e0 }
        r3 = r3.toString();	 Catch:{ all -> 0x09e0 }
        r4 = 1;
        r12 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        r1.a(r12, r3, r4);	 Catch:{ all -> 0x09e0 }
        r3 = r1.g;	 Catch:{ all -> 0x09e0 }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);	 Catch:{ all -> 0x09e0 }
        r4 = -308; // 0xfffffffffffffecc float:NaN double:NaN;
        r3.setDownloadInterruptCode(r4);	 Catch:{ all -> 0x09e0 }
        r1.a(r9);	 Catch:{ Throwable -> 0x09db, all -> 0x09d6 }
        r1.a(r5);	 Catch:{ Throwable -> 0x09db, all -> 0x09d6 }
        r1.a(r6);	 Catch:{ Throwable -> 0x09db, all -> 0x09d6 }
        if (r2 != 0) goto L_0x0ae8;
    L_0x09c1:
        r2 = r1.g;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r2 = r2.a;
        r3 = "tbs_downloadflow";
        r12 = r33;
    L_0x09cd:
        r4 = java.lang.Long.valueOf(r12);
        r2.put(r3, r4);
        goto L_0x020e;
    L_0x09d6:
        r0 = move-exception;
        r12 = r33;
        goto L_0x023f;
    L_0x09db:
        r0 = move-exception;
        r12 = r33;
        goto L_0x0244;
    L_0x09e0:
        r0 = move-exception;
        r12 = r33;
        goto L_0x0a54;
    L_0x09e5:
        r12 = r13;
        r14 = 0;
        r1.a(r14);	 Catch:{ all -> 0x0a50 }
        r4 = r35.i();	 Catch:{ all -> 0x0a50 }
        if (r4 != 0) goto L_0x09fc;
    L_0x09f1:
        r4 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        r3 = r1.a(r3);	 Catch:{ all -> 0x0a50 }
        r14 = 0;
    L_0x09f8:
        r1.a(r4, r3, r14);	 Catch:{ all -> 0x0a50 }
        goto L_0x0a04;
    L_0x09fc:
        r14 = 0;
        r4 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        r3 = r1.a(r3);	 Catch:{ all -> 0x0a50 }
        goto L_0x09f8;
    L_0x0a04:
        r1.a(r9);	 Catch:{ Throwable -> 0x0a4d }
        r1.a(r5);	 Catch:{ Throwable -> 0x0a4d }
        r1.a(r6);	 Catch:{ Throwable -> 0x0a4d }
        if (r2 != 0) goto L_0x0a4a;
    L_0x0a0f:
        goto L_0x0a30;
    L_0x0a10:
        r12 = r13;
        r4 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        r1.m = r4;	 Catch:{ all -> 0x0a50 }
        r14 = 0;
        r1.a(r14);	 Catch:{ all -> 0x0a50 }
        r4 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        r3 = r1.a(r3);	 Catch:{ all -> 0x0a50 }
        r14 = 0;
        r1.a(r4, r3, r14);	 Catch:{ all -> 0x0a50 }
        r1.a(r9);	 Catch:{ Throwable -> 0x0a4d }
        r1.a(r5);	 Catch:{ Throwable -> 0x0a4d }
        r1.a(r6);	 Catch:{ Throwable -> 0x0a4d }
        if (r2 != 0) goto L_0x0a4a;
    L_0x0a30:
        r3 = r1.g;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);
        r3 = r3.a;
        r4 = "tbs_downloadflow";
        r5 = java.lang.Long.valueOf(r12);
        r3.put(r4, r5);
        r3 = r1.g;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);
        r3.commit();
    L_0x0a4a:
        r3 = r12;
        goto L_0x05bc;
    L_0x0a4d:
        r0 = move-exception;
        goto L_0x0244;
    L_0x0a50:
        r0 = move-exception;
        goto L_0x0a54;
    L_0x0a52:
        r0 = move-exception;
        r12 = r13;
    L_0x0a54:
        r3 = r0;
        r23 = r8;
        r31 = r12;
        r13 = r9;
    L_0x0a5a:
        r1.a(r13);	 Catch:{ Throwable -> 0x0a6a, all -> 0x0a64 }
        r1.a(r5);	 Catch:{ Throwable -> 0x0a6a, all -> 0x0a64 }
        r1.a(r6);	 Catch:{ Throwable -> 0x0a6a, all -> 0x0a64 }
        throw r3;	 Catch:{ Throwable -> 0x0a6a, all -> 0x0a64 }
    L_0x0a64:
        r0 = move-exception;
        r3 = r0;
        r12 = r31;
        goto L_0x0b1c;
    L_0x0a6a:
        r0 = move-exception;
        r3 = r0;
        r8 = r23;
        r12 = r31;
        goto L_0x0a7c;
    L_0x0a71:
        r0 = move-exception;
        r12 = r3;
        r8 = r23;
        goto L_0x0244;
    L_0x0a77:
        r0 = move-exception;
        r23 = r8;
        goto L_0x0243;
    L_0x0a7c:
        r4 = r3 instanceof javax.net.ssl.SSLHandshakeException;	 Catch:{ all -> 0x0b19 }
        if (r4 == 0) goto L_0x0ab8;
    L_0x0a80:
        if (r2 != 0) goto L_0x0ab8;
    L_0x0a82:
        r4 = r1.b;	 Catch:{ all -> 0x0b19 }
        if (r4 == 0) goto L_0x0ab8;
    L_0x0a86:
        r4 = 0;
        r5 = r1.a(r4);	 Catch:{ all -> 0x0b19 }
        if (r5 == 0) goto L_0x0ab8;
    L_0x0a8d:
        r4 = "TbsDownload";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0b19 }
        r6 = "[startdownload]url:";
        r5.<init>(r6);	 Catch:{ all -> 0x0b19 }
        r6 = r1.j;	 Catch:{ all -> 0x0b19 }
        r5.append(r6);	 Catch:{ all -> 0x0b19 }
        r6 = " download exception：";
        r5.append(r6);	 Catch:{ all -> 0x0b19 }
        r3 = r3.toString();	 Catch:{ all -> 0x0b19 }
        r5.append(r3);	 Catch:{ all -> 0x0b19 }
        r3 = r5.toString();	 Catch:{ all -> 0x0b19 }
        com.tencent.smtt.utils.TbsLog.e(r4, r3);	 Catch:{ all -> 0x0b19 }
        r3 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        r4 = 1;
        r5 = 0;
        r1.a(r3, r5, r4);	 Catch:{ all -> 0x0b19 }
        r14 = 0;
        goto L_0x0aeb;
    L_0x0ab8:
        r5 = 0;
        r3.printStackTrace();	 Catch:{ all -> 0x0b19 }
        r14 = 0;
        r1.a(r14);	 Catch:{ all -> 0x0b19 }
        r4 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        r3 = r1.a(r3);	 Catch:{ all -> 0x0b19 }
        r6 = 0;
        r1.a(r4, r3, r6);	 Catch:{ all -> 0x0b19 }
        r3 = r1.r;	 Catch:{ all -> 0x0b19 }
        if (r3 == 0) goto L_0x0aeb;
    L_0x0acf:
        r3 = r1.g;	 Catch:{ all -> 0x0b19 }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);	 Catch:{ all -> 0x0b19 }
        r4 = -309; // 0xfffffffffffffecb float:NaN double:NaN;
        r3.setDownloadInterruptCode(r4);	 Catch:{ all -> 0x0b19 }
        if (r2 != 0) goto L_0x0ae8;
    L_0x0adc:
        r2 = r1.g;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r2 = r2.a;
        r3 = "tbs_downloadflow";
        goto L_0x09cd;
    L_0x0ae8:
        r23 = r8;
        goto L_0x0b39;
    L_0x0aeb:
        r3 = r1.g;	 Catch:{ all -> 0x0b19 }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);	 Catch:{ all -> 0x0b19 }
        r4 = -316; // 0xfffffffffffffec4 float:NaN double:NaN;
        r3.setDownloadInterruptCode(r4);	 Catch:{ all -> 0x0b19 }
        if (r2 != 0) goto L_0x0b12;
    L_0x0af8:
        r3 = r1.g;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);
        r3 = r3.a;
        r4 = "tbs_downloadflow";
        r6 = java.lang.Long.valueOf(r12);
        r3.put(r4, r6);
        r3 = r1.g;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);
        r3.commit();
    L_0x0b12:
        r9 = r5;
        r3 = r12;
        r13 = r14;
        r5 = 2;
        r6 = 1;
        goto L_0x015c;
    L_0x0b19:
        r0 = move-exception;
        goto L_0x023f;
    L_0x0b1c:
        if (r2 != 0) goto L_0x0b38;
    L_0x0b1e:
        r2 = r1.g;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r2 = r2.a;
        r4 = "tbs_downloadflow";
        r5 = java.lang.Long.valueOf(r12);
        r2.put(r4, r5);
        r2 = r1.g;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r2.commit();
    L_0x0b38:
        throw r3;
    L_0x0b39:
        r2 = r1.r;
        if (r2 != 0) goto L_0x0bda;
    L_0x0b3d:
        r2 = r1.s;
        if (r2 == 0) goto L_0x0b8f;
    L_0x0b41:
        r2 = r1.b;
        if (r2 != 0) goto L_0x0b4c;
    L_0x0b45:
        if (r23 != 0) goto L_0x0b4c;
    L_0x0b47:
        r2 = 1;
        r23 = r1.c(r2, r7);
    L_0x0b4c:
        r2 = r1.v;
        if (r23 == 0) goto L_0x0b52;
    L_0x0b50:
        r3 = 1;
        goto L_0x0b53;
    L_0x0b52:
        r3 = 0;
    L_0x0b53:
        r2.setUnpkgFlag(r3);
        if (r7 != 0) goto L_0x0b60;
    L_0x0b58:
        r2 = r1.v;
        if (r23 == 0) goto L_0x0b5e;
    L_0x0b5c:
        r3 = 1;
        goto L_0x0b63;
    L_0x0b5e:
        r3 = 2;
        goto L_0x0b63;
    L_0x0b60:
        r2 = r1.v;
        r3 = 0;
    L_0x0b63:
        r2.setPatchUpdateFlag(r3);
        if (r23 == 0) goto L_0x0b7f;
    L_0x0b68:
        r2 = 1;
        r1.b(r2);
        r3 = r1.g;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);
        r4 = -317; // 0xfffffffffffffec3 float:NaN double:NaN;
        r3.setDownloadInterruptCode(r4);
        r3 = 100;
        r4 = "success";
        r1.a(r3, r4, r2);
        goto L_0x0b8f;
    L_0x0b7f:
        r2 = r1.g;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r3 = -318; // 0xfffffffffffffec2 float:NaN double:NaN;
        r2.setDownloadInterruptCode(r3);
        r2 = 0;
        r1.c(r2);
        goto L_0x0b90;
    L_0x0b8f:
        r2 = 0;
    L_0x0b90:
        r3 = r1.g;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);
        if (r23 == 0) goto L_0x0bae;
    L_0x0b98:
        r4 = r3.mPreferences;
        r5 = "tbs_download_success_retrytimes";
        r4 = r4.getInt(r5, r2);
        r5 = r3.a;
        r6 = "tbs_download_success_retrytimes";
        r9 = 1;
        r4 = r4 + r9;
        r4 = java.lang.Integer.valueOf(r4);
        r5.put(r6, r4);
        goto L_0x0bcf;
    L_0x0bae:
        r9 = 1;
        r4 = r3.mPreferences;
        r5 = "tbs_download_failed_retrytimes";
        r4 = r4.getInt(r5, r2);
        r5 = r3.a;
        r6 = "tbs_download_failed_retrytimes";
        r4 = r4 + r9;
        r7 = java.lang.Integer.valueOf(r4);
        r5.put(r6, r7);
        r5 = r3.getDownloadFailedMaxRetrytimes();
        if (r4 != r5) goto L_0x0bcf;
    L_0x0bc9:
        r4 = r1.v;
        r5 = 2;
        r4.setDownloadCancel(r5);
    L_0x0bcf:
        r3.commit();
        r3 = r1.v;
        if (r23 == 0) goto L_0x0bd7;
    L_0x0bd6:
        r2 = r9;
    L_0x0bd7:
        r3.setDownFinalFlag(r2);
    L_0x0bda:
        r35.f();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.ad.b(boolean, boolean):void");
    }

    public void c() {
        b();
        c(false);
        c(true);
    }

    public boolean d() {
        String str = TbsDownloader.LOGTAG;
        StringBuilder stringBuilder = new StringBuilder("[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=");
        stringBuilder.append(this.C);
        TbsLog.i(str, stringBuilder.toString());
        return this.C;
    }
}
