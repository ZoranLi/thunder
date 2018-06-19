package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.alipay.sdk.util.h;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n;
import com.tencent.smtt.utils.x;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONArray;

class TbsLogReport {
    private static TbsLogReport a;
    private Handler b = null;
    private Context c;
    private boolean d = false;

    public enum EventType {
        TYPE_DOWNLOAD(0),
        TYPE_INSTALL(1),
        TYPE_LOAD(2),
        TYPE_DOWNLOAD_DECOUPLE(3),
        TYPE_INSTALL_DECOUPLE(4),
        TYPE_COOKIE_DB_SWITCH(5);
        
        int a;

        private EventType(int i) {
            this.a = i;
        }
    }

    public static class TbsLogInfo implements Cloneable {
        int a;
        private long b;
        private String c;
        private String d;
        private int e;
        private int f;
        private int g;
        private int h;
        private String i;
        private int j;
        private int k;
        private long l;
        private long m;
        private int n;
        private String o;
        private String p;
        private long q;

        private TbsLogInfo() {
            resetArgs();
        }

        protected java.lang.Object clone() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r0 = super.clone();	 Catch:{ CloneNotSupportedException -> 0x0005 }
            return r0;
        L_0x0005:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo.clone():java.lang.Object");
        }

        public int getDownFinalFlag() {
            return this.k;
        }

        public void resetArgs() {
            this.b = 0;
            this.c = null;
            this.d = null;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 2;
            this.i = "unknown";
            this.j = 0;
            this.k = 2;
            this.l = 0;
            this.m = 0;
            this.n = 1;
            this.a = 0;
            this.o = null;
            this.p = null;
            this.q = 0;
        }

        public void setApn(String str) {
            this.i = str;
        }

        public void setCheckErrorDetail(String str) {
            setErrorCode(108);
            this.o = str;
        }

        public void setDownConsumeTime(long j) {
            this.m += j;
        }

        public void setDownFinalFlag(int i) {
            this.k = i;
        }

        public void setDownloadCancel(int i) {
            this.g = i;
        }

        public void setDownloadSize(long j) {
            this.q += j;
        }

        public void setDownloadUrl(String str) {
            if (this.c == null) {
                this.c = str;
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.c);
            stringBuilder.append(h.b);
            stringBuilder.append(str);
            this.c = stringBuilder.toString();
        }

        public void setErrorCode(int i) {
            if (!(i == 100 || i == 110 || i == 120 || i == 111 || i >= 400)) {
                String str = TbsDownloader.LOGTAG;
                StringBuilder stringBuilder = new StringBuilder("error occured, errorCode:");
                stringBuilder.append(i);
                TbsLog.i(str, stringBuilder.toString(), true);
            }
            if (i == 111) {
                TbsLog.i(TbsDownloader.LOGTAG, "you are not in wifi, downloading stoped", true);
            }
            this.a = i;
        }

        public void setEventTime(long j) {
            this.b = j;
        }

        public void setFailDetail(String str) {
            if (str != null) {
                if (str.length() > 1024) {
                    str = str.substring(0, 1024);
                }
                this.p = str;
            }
        }

        public void setFailDetail(Throwable th) {
            if (th == null) {
                this.p = "";
                return;
            }
            String stackTraceString = Log.getStackTraceString(th);
            if (stackTraceString.length() > 1024) {
                stackTraceString = stackTraceString.substring(0, 1024);
            }
            this.p = stackTraceString;
        }

        public void setHttpCode(int i) {
            this.e = i;
        }

        public void setNetworkChange(int i) {
            this.n = i;
        }

        public void setNetworkType(int i) {
            this.j = i;
        }

        public void setPatchUpdateFlag(int i) {
            this.f = i;
        }

        public void setPkgSize(long j) {
            this.l = j;
        }

        public void setResolveIp(String str) {
            this.d = str;
        }

        public void setUnpkgFlag(int i) {
            this.h = i;
        }
    }

    private static class a {
        private final String a;
        private final String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        private static void a(File file) {
            Exception e;
            Throwable th;
            RandomAccessFile randomAccessFile = null;
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
                try {
                    int parseInt = Integer.parseInt("00001000", 2);
                    randomAccessFile2.seek(7);
                    int read = randomAccessFile2.read();
                    if ((read & parseInt) > 0) {
                        randomAccessFile2.seek(7);
                        randomAccessFile2.write(((parseInt ^ -1) & 255) & read);
                    }
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    e = e3;
                    randomAccessFile = randomAccessFile2;
                    try {
                        e.printStackTrace();
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        randomAccessFile2 = randomAccessFile;
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (randomAccessFile2 != null) {
                        randomAccessFile2.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            }
        }

        public void a() {
            FileOutputStream fileOutputStream;
            ZipOutputStream zipOutputStream;
            FileInputStream fileInputStream;
            BufferedInputStream bufferedInputStream;
            Exception e;
            Exception exception;
            IOException e2;
            Throwable th;
            Throwable th2;
            try {
                fileOutputStream = new FileOutputStream(this.b);
                try {
                    zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
                    byte[] bArr = new byte[2048];
                    String str = this.a;
                    try {
                        fileInputStream = new FileInputStream(str);
                        try {
                            bufferedInputStream = new BufferedInputStream(fileInputStream, 2048);
                        } catch (Exception e3) {
                            e = e3;
                            bufferedInputStream = null;
                            exception = e;
                            try {
                                exception.printStackTrace();
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e22) {
                                        e22.printStackTrace();
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e4) {
                                        e22 = e4;
                                        try {
                                            e22.printStackTrace();
                                            a(new File(this.b));
                                            zipOutputStream.close();
                                            fileOutputStream.close();
                                        } catch (Exception e5) {
                                            exception = e5;
                                            try {
                                                exception.printStackTrace();
                                                if (zipOutputStream != null) {
                                                    try {
                                                        zipOutputStream.close();
                                                    } catch (IOException e222) {
                                                        e222.printStackTrace();
                                                    }
                                                }
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                    } catch (IOException e2222) {
                                                        e2222.printStackTrace();
                                                    }
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                if (zipOutputStream != null) {
                                                    try {
                                                        zipOutputStream.close();
                                                    } catch (IOException e6) {
                                                        e6.printStackTrace();
                                                    }
                                                }
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                    } catch (IOException e7) {
                                                        e7.printStackTrace();
                                                    }
                                                }
                                                throw th;
                                            }
                                        }
                                    }
                                }
                                a(new File(this.b));
                                zipOutputStream.close();
                                fileOutputStream.close();
                            } catch (Throwable th4) {
                                th = th4;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e8) {
                                        e8.printStackTrace();
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e82) {
                                        e82.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th2 = th5;
                            bufferedInputStream = null;
                            th = th2;
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(str.substring(str.lastIndexOf("/") + 1)));
                            while (true) {
                                int read = bufferedInputStream.read(bArr, 0, 2048);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            zipOutputStream.flush();
                            zipOutputStream.closeEntry();
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e22222) {
                                e22222.printStackTrace();
                            }
                            try {
                                fileInputStream.close();
                            } catch (IOException e9) {
                                e22222 = e9;
                                e22222.printStackTrace();
                                a(new File(this.b));
                                zipOutputStream.close();
                                fileOutputStream.close();
                            }
                        } catch (Exception e10) {
                            exception = e10;
                            exception.printStackTrace();
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            a(new File(this.b));
                            zipOutputStream.close();
                            fileOutputStream.close();
                        }
                    } catch (Exception e11) {
                        e = e11;
                        fileInputStream = null;
                        bufferedInputStream = fileInputStream;
                        exception = e;
                        exception.printStackTrace();
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        a(new File(this.b));
                        zipOutputStream.close();
                        fileOutputStream.close();
                    } catch (Throwable th6) {
                        th2 = th6;
                        fileInputStream = null;
                        bufferedInputStream = fileInputStream;
                        th = th2;
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                    a(new File(this.b));
                    try {
                        zipOutputStream.close();
                    } catch (IOException e222222) {
                        e222222.printStackTrace();
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2222222) {
                        e2222222.printStackTrace();
                    }
                } catch (Exception e12) {
                    Exception exception2 = e12;
                    zipOutputStream = null;
                    exception = exception2;
                    exception.printStackTrace();
                    if (zipOutputStream != null) {
                        zipOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th7) {
                    Throwable th8 = th7;
                    zipOutputStream = null;
                    th = th8;
                    if (zipOutputStream != null) {
                        zipOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e13) {
                zipOutputStream = null;
                exception = e13;
                fileOutputStream = zipOutputStream;
                exception.printStackTrace();
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th9) {
                zipOutputStream = null;
                th = th9;
                fileOutputStream = zipOutputStream;
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
    }

    private TbsLogReport(Context context) {
        this.c = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("TbsLogReportThread");
        handlerThread.start();
        this.b = new as(this, handlerThread.getLooper());
    }

    public static TbsLogReport a(Context context) {
        if (a == null) {
            synchronized (TbsLogReport.class) {
                if (a == null) {
                    a = new TbsLogReport(context);
                }
            }
        }
        return a;
    }

    private String a(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("|");
        return stringBuilder.toString();
    }

    private java.lang.String a(long r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x0015 }
        r1 = "yyyy-MM-dd HH:mm:ss";	 Catch:{ Exception -> 0x0015 }
        r2 = java.util.Locale.getDefault();	 Catch:{ Exception -> 0x0015 }
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x0015 }
        r1 = new java.util.Date;	 Catch:{ Exception -> 0x0015 }
        r1.<init>(r4);	 Catch:{ Exception -> 0x0015 }
        r4 = r0.format(r1);	 Catch:{ Exception -> 0x0015 }
        return r4;
    L_0x0015:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsLogReport.a(long):java.lang.String");
    }

    private String a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) {
            str = "";
        }
        stringBuilder.append(str);
        stringBuilder.append("|");
        return stringBuilder.toString();
    }

    private void a(int r7, com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r6.a(r7);
        r0.append(r1);
        r1 = r6.c;
        r1 = com.tencent.smtt.utils.b.c(r1);
        r1 = r6.a(r1);
        r0.append(r1);
        r1 = r6.c;
        r1 = com.tencent.smtt.utils.w.a(r1);
        r1 = r6.a(r1);
        r0.append(r1);
        r1 = com.tencent.smtt.sdk.aj.a();
        r2 = r6.c;
        r1 = r1.i(r2);
        r1 = r6.a(r1);
        r0.append(r1);
        r1 = android.os.Build.MODEL;
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x0047 }
        r3 = "UTF-8";	 Catch:{ Exception -> 0x0047 }
        r3 = r1.getBytes(r3);	 Catch:{ Exception -> 0x0047 }
        r4 = "ISO8859-1";	 Catch:{ Exception -> 0x0047 }
        r2.<init>(r3, r4);	 Catch:{ Exception -> 0x0047 }
        r1 = r2;
    L_0x0047:
        r1 = r6.a(r1);
        r0.append(r1);
        r1 = r6.c;
        r1 = r1.getPackageName();
        r2 = r6.a(r1);
        r0.append(r2);
        r2 = "com.tencent.mm";
        r1 = r2.equals(r1);
        if (r1 == 0) goto L_0x0073;
    L_0x0063:
        r1 = r6.c;
        r2 = "com.tencent.mm.BuildInfo.CLIENT_VERSION";
        r1 = com.tencent.smtt.utils.b.a(r1, r2);
        r1 = r6.a(r1);
    L_0x006f:
        r0.append(r1);
        goto L_0x007e;
    L_0x0073:
        r1 = r6.c;
        r1 = com.tencent.smtt.utils.b.b(r1);
        r1 = r6.a(r1);
        goto L_0x006f;
    L_0x007e:
        r1 = r8.b;
        r1 = r6.a(r1);
        r1 = r6.a(r1);
        r0.append(r1);
        r1 = r8.c;
        r1 = r6.a(r1);
        r0.append(r1);
        r1 = r8.d;
        r1 = r6.a(r1);
        r0.append(r1);
        r1 = r8.e;
        r1 = r6.a(r1);
        r0.append(r1);
        r1 = r8.f;
        r1 = r6.a(r1);
        r0.append(r1);
        r1 = r8.g;
        r1 = r6.a(r1);
        r0.append(r1);
        r1 = r8.h;
        r1 = r6.a(r1);
        r0.append(r1);
        r1 = r8.i;
        r1 = r6.a(r1);
        r0.append(r1);
        r1 = r8.j;
        r1 = r6.a(r1);
        r0.append(r1);
        r1 = r8.k;
        r1 = r6.a(r1);
        r0.append(r1);
        r1 = r8.q;
        r1 = r6.b(r1);
        r0.append(r1);
        r1 = r8.l;
        r1 = r6.b(r1);
        r0.append(r1);
        r1 = r8.m;
        r1 = r6.b(r1);
        r0.append(r1);
        r1 = r8.n;
        r1 = r6.a(r1);
        r0.append(r1);
        r1 = r8.a;
        r1 = r6.a(r1);
        r0.append(r1);
        r1 = r8.o;
        r1 = r6.a(r1);
        r0.append(r1);
        r8 = r8.p;
        r8 = r6.a(r8);
        r0.append(r8);
        r8 = r6.c;
        r8 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r8);
        r8 = r8.mPreferences;
        r1 = "tbs_download_version";
        r2 = 0;
        r8 = r8.getInt(r1, r2);
        r8 = r6.a(r8);
        r0.append(r8);
        r8 = r6.c;
        r8 = com.tencent.smtt.utils.b.f(r8);
        r8 = r6.a(r8);
        r0.append(r8);
        r8 = "3.3.0.1004_43500";
        r8 = r6.a(r8);
        r0.append(r8);
        r0.append(r2);
        r8 = r6.i();
        r1 = r6.f();
        r2 = new org.json.JSONArray;
        r2.<init>();
        r3 = r2.length();
        r4 = 5;
        if (r3 < r4) goto L_0x0199;
    L_0x017e:
        r3 = 4;
    L_0x017f:
        if (r3 <= 0) goto L_0x0198;
    L_0x0181:
        r4 = r2.length();	 Catch:{ Exception -> 0x018e }
        r4 = r4 - r3;	 Catch:{ Exception -> 0x018e }
        r4 = r1.get(r4);	 Catch:{ Exception -> 0x018e }
        r2.put(r4);	 Catch:{ Exception -> 0x018e }
        goto L_0x0195;
    L_0x018e:
        r4 = "upload";
        r5 = "JSONArray transform error!";
        com.tencent.smtt.utils.TbsLog.e(r4, r5);
    L_0x0195:
        r3 = r3 + -1;
        goto L_0x017f;
    L_0x0198:
        r1 = r2;
    L_0x0199:
        r0 = r0.toString();
        r1.put(r0);
        r8 = r8.edit();
        r0 = "tbs_download_upload";
        r1 = r1.toString();
        r8.putString(r0, r1);
        r8.commit();
        r8 = r6.d;
        if (r8 != 0) goto L_0x01ba;
    L_0x01b4:
        r8 = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_LOAD;
        r8 = r8.a;
        if (r7 == r8) goto L_0x01bd;
    L_0x01ba:
        r6.g();
    L_0x01bd:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsLogReport.a(int, com.tencent.smtt.sdk.TbsLogReport$TbsLogInfo):void");
    }

    private void a(int i, TbsLogInfo tbsLogInfo, EventType eventType) {
        tbsLogInfo.setErrorCode(i);
        tbsLogInfo.setEventTime(System.currentTimeMillis());
        QbSdk.k.onInstallFinish(i);
        a(eventType, tbsLogInfo);
    }

    private String b(long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j);
        stringBuilder.append("|");
        return stringBuilder.toString();
    }

    private org.json.JSONArray f() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.i();
        r1 = "tbs_download_upload";
        r2 = 0;
        r0 = r0.getString(r1, r2);
        if (r0 != 0) goto L_0x0013;
    L_0x000d:
        r0 = new org.json.JSONArray;
        r0.<init>();
        return r0;
    L_0x0013:
        r1 = new org.json.JSONArray;	 Catch:{ Exception -> 0x003b }
        r1.<init>(r0);	 Catch:{ Exception -> 0x003b }
        r0 = r1.length();	 Catch:{ Exception -> 0x003b }
        r2 = 5;	 Catch:{ Exception -> 0x003b }
        if (r0 <= r2) goto L_0x0039;	 Catch:{ Exception -> 0x003b }
    L_0x001f:
        r0 = new org.json.JSONArray;	 Catch:{ Exception -> 0x003b }
        r0.<init>();	 Catch:{ Exception -> 0x003b }
        r3 = r1.length();	 Catch:{ Exception -> 0x003b }
        r3 = r3 + -1;	 Catch:{ Exception -> 0x003b }
        r4 = r1.length();	 Catch:{ Exception -> 0x003b }
        r4 = r4 - r2;	 Catch:{ Exception -> 0x003b }
        if (r3 <= r4) goto L_0x0039;	 Catch:{ Exception -> 0x003b }
    L_0x0031:
        r1 = r1.get(r3);	 Catch:{ Exception -> 0x003b }
        r0.put(r1);	 Catch:{ Exception -> 0x003b }
        return r0;
    L_0x0039:
        r0 = r1;
        return r0;
    L_0x003b:
        r0 = new org.json.JSONArray;
        r0.<init>();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsLogReport.f():org.json.JSONArray");
    }

    private void g() {
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat]");
        JSONArray f = f();
        if (f != null) {
            if (f.length() != 0) {
                String str = TbsDownloader.LOGTAG;
                StringBuilder stringBuilder = new StringBuilder("[TbsApkDownloadStat.reportDownloadStat] jsonArray:");
                stringBuilder.append(f);
                TbsLog.i(str, stringBuilder.toString());
                try {
                    String a = n.a(x.a(this.c).c(), f.toString().getBytes("utf-8"), new au(this), true);
                    str = TbsDownloader.LOGTAG;
                    stringBuilder = new StringBuilder("[TbsApkDownloadStat.reportDownloadStat] response:");
                    stringBuilder.append(a);
                    stringBuilder.append(" testcase: -1");
                    TbsLog.i(str, stringBuilder.toString());
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] no data");
    }

    private void h() {
        Editor edit = i().edit();
        edit.remove("tbs_download_upload");
        edit.commit();
    }

    private SharedPreferences i() {
        return this.c.getSharedPreferences("tbs_download_stat", 4);
    }

    public TbsLogInfo a() {
        return new TbsLogInfo();
    }

    public void a(int i, String str) {
        a(i, str, EventType.TYPE_INSTALL);
    }

    public void a(int i, String str, EventType eventType) {
        if (!(i == 200 || i == 220 || i == 221)) {
            String str2 = TbsDownloader.LOGTAG;
            StringBuilder stringBuilder = new StringBuilder("error occured in installation, errorCode:");
            stringBuilder.append(i);
            TbsLog.i(str2, stringBuilder.toString(), true);
        }
        TbsLogInfo a = a();
        a.setFailDetail(str);
        a(i, a, eventType);
    }

    public void a(int i, Throwable th) {
        TbsLogInfo a = a();
        a.setFailDetail(th);
        a(i, a, EventType.TYPE_INSTALL);
    }

    public void a(EventType eventType, TbsLogInfo tbsLogInfo) {
        try {
            tbsLogInfo = (TbsLogInfo) tbsLogInfo.clone();
            Message obtainMessage = this.b.obtainMessage();
            obtainMessage.what = 600;
            obtainMessage.arg1 = eventType.a;
            obtainMessage.obj = tbsLogInfo;
            this.b.sendMessage(obtainMessage);
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("[TbsLogReport.eventReport] error, message=");
            stringBuilder.append(th.getMessage());
            TbsLog.w("upload", stringBuilder.toString());
        }
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void b() {
        this.b.sendEmptyMessage(601);
    }

    public void b(int i, String str) {
        TbsLogInfo a = a();
        a.setErrorCode(i);
        a.setEventTime(System.currentTimeMillis());
        a.setFailDetail(str);
        a(EventType.TYPE_LOAD, a);
    }

    public void b(int i, Throwable th) {
        String str = "NULL";
        if (th != null) {
            StringBuilder stringBuilder = new StringBuilder("msg: ");
            stringBuilder.append(th.getMessage());
            stringBuilder.append("; err: ");
            stringBuilder.append(th);
            stringBuilder.append("; cause: ");
            stringBuilder.append(Log.getStackTraceString(th.getCause()));
            String stringBuilder2 = stringBuilder.toString();
            if (stringBuilder2.length() > 1024) {
                stringBuilder2 = stringBuilder2.substring(0, 1024);
            }
            str = stringBuilder2;
        }
        b(i, str);
    }

    public void c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = r11.c;
        r0 = com.tencent.smtt.utils.Apn.getApnType(r0);
        r1 = 3;
        if (r0 == r1) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r0 = com.tencent.smtt.utils.TbsLog.getTbsLogFilePath();
        if (r0 != 0) goto L_0x0011;
    L_0x0010:
        return;
    L_0x0011:
        r1 = com.tencent.smtt.utils.p.a();
        r1 = r1.b();
        r2 = r11.c;
        r2 = com.tencent.smtt.utils.b.c(r2);
        r3 = r11.c;
        r3 = com.tencent.smtt.utils.b.f(r3);
        r2 = r2.getBytes();
        r3 = r3.getBytes();
        r4 = com.tencent.smtt.utils.p.a();	 Catch:{ Exception -> 0x003e }
        r4 = r4.a(r2);	 Catch:{ Exception -> 0x003e }
        r2 = com.tencent.smtt.utils.p.a();	 Catch:{ Exception -> 0x003f }
        r2 = r2.a(r3);	 Catch:{ Exception -> 0x003f }
        goto L_0x0040;
    L_0x003e:
        r4 = r2;
    L_0x003f:
        r2 = r3;
    L_0x0040:
        r3 = com.tencent.smtt.utils.p.b(r4);
        r2 = com.tencent.smtt.utils.p.b(r2);
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r11.c;
        r5 = com.tencent.smtt.utils.x.a(r5);
        r5 = r5.e();
        r4.append(r5);
        r4.append(r3);
        r3 = "&aid=";
        r4.append(r3);
        r4.append(r2);
        r2 = r4.toString();
        r3 = new java.util.HashMap;
        r3.<init>();
        r4 = "Content-Type";
        r5 = "application/octet-stream";
        r3.put(r4, r5);
        r4 = "Charset";
        r5 = "UTF-8";
        r3.put(r4, r5);
        r4 = "QUA2";
        r5 = r11.c;
        r5 = com.tencent.smtt.utils.w.a(r5);
        r3.put(r4, r5);
        r4 = 0;
        r5 = 0;
        r6 = new java.io.File;	 Catch:{ Exception -> 0x00f9, all -> 0x00f5 }
        r7 = com.tencent.smtt.utils.k.a;	 Catch:{ Exception -> 0x00f9, all -> 0x00f5 }
        r6.<init>(r7);	 Catch:{ Exception -> 0x00f9, all -> 0x00f5 }
        r6 = new com.tencent.smtt.sdk.TbsLogReport$a;	 Catch:{ Exception -> 0x00f9, all -> 0x00f5 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f9, all -> 0x00f5 }
        r7.<init>();	 Catch:{ Exception -> 0x00f9, all -> 0x00f5 }
        r8 = com.tencent.smtt.utils.k.a;	 Catch:{ Exception -> 0x00f9, all -> 0x00f5 }
        r7.append(r8);	 Catch:{ Exception -> 0x00f9, all -> 0x00f5 }
        r8 = "/tbslog_temp.zip";	 Catch:{ Exception -> 0x00f9, all -> 0x00f5 }
        r7.append(r8);	 Catch:{ Exception -> 0x00f9, all -> 0x00f5 }
        r7 = r7.toString();	 Catch:{ Exception -> 0x00f9, all -> 0x00f5 }
        r6.<init>(r0, r7);	 Catch:{ Exception -> 0x00f9, all -> 0x00f5 }
        r6.a();	 Catch:{ Exception -> 0x00f9, all -> 0x00f5 }
        r0 = new java.io.File;	 Catch:{ Exception -> 0x00f9, all -> 0x00f5 }
        r6 = com.tencent.smtt.utils.k.a;	 Catch:{ Exception -> 0x00f9, all -> 0x00f5 }
        r7 = "tbslog_temp.zip";	 Catch:{ Exception -> 0x00f9, all -> 0x00f5 }
        r0.<init>(r6, r7);	 Catch:{ Exception -> 0x00f9, all -> 0x00f5 }
        r6 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x00f2, all -> 0x00ef }
        r6.<init>(r0);	 Catch:{ Exception -> 0x00f2, all -> 0x00ef }
        r7 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r7 = new byte[r7];	 Catch:{ Exception -> 0x00ec, all -> 0x00e9 }
        r8 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x00ec, all -> 0x00e9 }
        r8.<init>();	 Catch:{ Exception -> 0x00ec, all -> 0x00e9 }
    L_0x00c2:
        r9 = r6.read(r7);	 Catch:{ Exception -> 0x00e7 }
        r10 = -1;	 Catch:{ Exception -> 0x00e7 }
        if (r9 == r10) goto L_0x00cd;	 Catch:{ Exception -> 0x00e7 }
    L_0x00c9:
        r8.write(r7, r4, r9);	 Catch:{ Exception -> 0x00e7 }
        goto L_0x00c2;	 Catch:{ Exception -> 0x00e7 }
    L_0x00cd:
        r8.flush();	 Catch:{ Exception -> 0x00e7 }
        r7 = com.tencent.smtt.utils.p.a();	 Catch:{ Exception -> 0x00e7 }
        r9 = r8.toByteArray();	 Catch:{ Exception -> 0x00e7 }
        r7 = r7.a(r9);	 Catch:{ Exception -> 0x00e7 }
        r6.close();	 Catch:{ Exception -> 0x00df }
    L_0x00df:
        r8.close();	 Catch:{ Exception -> 0x00e2 }
    L_0x00e2:
        r0.delete();
        r5 = r7;
        goto L_0x010f;
    L_0x00e7:
        r7 = move-exception;
        goto L_0x00fd;
    L_0x00e9:
        r1 = move-exception;
        r8 = r5;
        goto L_0x012d;
    L_0x00ec:
        r7 = move-exception;
        r8 = r5;
        goto L_0x00fd;
    L_0x00ef:
        r1 = move-exception;
        r8 = r5;
        goto L_0x012e;
    L_0x00f2:
        r7 = move-exception;
        r6 = r5;
        goto L_0x00fc;
    L_0x00f5:
        r1 = move-exception;
        r0 = r5;
        r8 = r0;
        goto L_0x012e;
    L_0x00f9:
        r7 = move-exception;
        r0 = r5;
        r6 = r0;
    L_0x00fc:
        r8 = r6;
    L_0x00fd:
        r7.printStackTrace();	 Catch:{ all -> 0x012c }
        if (r6 == 0) goto L_0x0105;
    L_0x0102:
        r6.close();	 Catch:{ Exception -> 0x0105 }
    L_0x0105:
        if (r8 == 0) goto L_0x010a;
    L_0x0107:
        r8.close();	 Catch:{ Exception -> 0x010a }
    L_0x010a:
        if (r0 == 0) goto L_0x010f;
    L_0x010c:
        r0.delete();
    L_0x010f:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r2);
        r2 = "&ek=";
        r0.append(r2);
        r0.append(r1);
        r0 = r0.toString();
        r1 = new com.tencent.smtt.sdk.at;
        r1.<init>(r11);
        com.tencent.smtt.utils.n.a(r0, r3, r5, r1, r4);
        return;
    L_0x012c:
        r1 = move-exception;
    L_0x012d:
        r5 = r6;
    L_0x012e:
        if (r5 == 0) goto L_0x0133;
    L_0x0130:
        r5.close();	 Catch:{ Exception -> 0x0133 }
    L_0x0133:
        if (r8 == 0) goto L_0x0138;
    L_0x0135:
        r8.close();	 Catch:{ Exception -> 0x0138 }
    L_0x0138:
        if (r0 == 0) goto L_0x013d;
    L_0x013a:
        r0.delete();
    L_0x013d:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsLogReport.c():void");
    }

    public void d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.i();	 Catch:{ Exception -> 0x000e }
        r0 = r0.edit();	 Catch:{ Exception -> 0x000e }
        r0.clear();	 Catch:{ Exception -> 0x000e }
        r0.commit();	 Catch:{ Exception -> 0x000e }
    L_0x000e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsLogReport.d():void");
    }

    public boolean e() {
        return this.d;
    }
}
