package com.taobao.accs.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.util.Base64;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.l;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: Taobao */
public class a implements Callback {
    public static final int ACT_START = 0;
    public static final int ACT_STOP = -1;
    public static final String AGOO_PID = "agoo.pid";
    public static final String EX_FILE_NAME = "DaemonServer";
    public static final String PROCESS_NAME = "runServer";
    public static String a = "startservice -n {packname}/com.taobao.accs.ChannelService";
    private static final String c = "com.taobao.accs.b.a";
    private static int g = 7200;
    private static int h = 2500;
    private static final ReentrantLock i = new ReentrantLock();
    private static a j;
    public boolean b = false;
    private Context d = null;
    private String e;
    private int f = 1800;
    private String k = "100001";
    private String l = "tb_accs_eudemon_1.1.3";
    private String m = "";
    private String n = "21646297";
    private int o = 0;
    private String p = "100.69.165.28";
    private String q = "http://100.69.165.28/agoo/report";
    private int r = 80;
    private boolean s = true;
    private Handler t = null;
    private HandlerThread u = null;

    public a(Context context, int i, boolean z) {
        b();
        a = "startservice -n {packname}/com.taobao.accs.ChannelService";
        this.d = context;
        this.f = i;
        this.b = z;
        this.e = a(new Build(), "CPU_ABI");
        i = new StringBuilder("/data/data/");
        i.append(context.getPackageName());
        this.m = i.toString();
        this.o = 221;
        i = UtilityImpl.getAppkey(this.d);
        if (i != 0) {
            if (i.length) {
                i = i[0];
                this.n = i;
                if (l.a(context) == 0) {
                    this.p = "agoodm.m.taobao.com";
                    this.r = 80;
                    this.q = "http://agoodm.m.taobao.com/agoo/report";
                    this.k = "1009527";
                } else if (l.a(context) != 1) {
                    this.p = "110.75.98.154";
                    this.r = 80;
                    this.q = "http://agoodm.wapa.taobao.com/agoo/report";
                    this.k = "1009527";
                } else {
                    this.p = "100.69.168.33";
                    this.r = 80;
                    this.q = "http://100.69.168.33/agoo/report";
                    this.f = 60;
                    this.k = "9527";
                }
            }
        }
        i = "";
        this.n = i;
        if (l.a(context) == 0) {
            this.p = "agoodm.m.taobao.com";
            this.r = 80;
            this.q = "http://agoodm.m.taobao.com/agoo/report";
            this.k = "1009527";
        } else if (l.a(context) != 1) {
            this.p = "100.69.168.33";
            this.r = 80;
            this.q = "http://100.69.168.33/agoo/report";
            this.f = 60;
            this.k = "9527";
        } else {
            this.p = "110.75.98.154";
            this.r = 80;
            this.q = "http://agoodm.wapa.taobao.com/agoo/report";
            this.k = "1009527";
        }
    }

    private void b() {
        this.u = new HandlerThread("soManager-threads");
        this.u.setPriority(5);
        this.u.start();
        this.t = new Handler(this.u.getLooper(), this);
    }

    private String c() {
        if (this.e.startsWith("arm")) {
            return "armeabi/";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.e);
        stringBuilder.append("/");
        return stringBuilder.toString();
    }

    private static java.lang.String a(android.os.Build r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.os.Build.class;	 Catch:{ Throwable -> 0x000f }
        r2 = r0.getField(r2);	 Catch:{ Throwable -> 0x000f }
        r1 = r2.get(r1);	 Catch:{ Throwable -> 0x000f }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x000f }
        return r1;
    L_0x000f:
        r1 = "Unknown";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.b.a.a(android.os.Build, java.lang.String):java.lang.String");
    }

    public static a a(Context context, int i, boolean z) {
        try {
            i.lock();
            if (j == null) {
                j = new a(context, i, z);
            }
        } catch (Context context2) {
            ALog.e(c, "getInstance", context2, new Object[0]);
        } catch (Throwable th) {
            i.unlock();
        }
        i.unlock();
        return j;
    }

    private String d() throws IOException {
        Throwable th;
        Throwable th2;
        File file = new File(this.d.getFilesDir(), EX_FILE_NAME);
        if (file.exists()) {
            file.delete();
        }
        String str = c;
        StringBuilder stringBuilder = new StringBuilder("open assets from = ");
        stringBuilder.append(c());
        stringBuilder.append(EX_FILE_NAME);
        ALog.w(str, stringBuilder.toString(), new Object[0]);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        InputStream inputStream = null;
        try {
            if (this.b) {
                AssetManager assets = this.d.getAssets();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(c());
                stringBuilder2.append(EX_FILE_NAME);
                InputStream open = assets.open(stringBuilder2.toString());
                try {
                    byte[] bArr = new byte[100];
                    while (true) {
                        int read = open.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    inputStream = open;
                } catch (Throwable e) {
                    InputStream inputStream2 = open;
                    th = e;
                    inputStream = inputStream2;
                    try {
                        ALog.e(c, "error in copy daemon files", th, new Object[0]);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e2) {
                                ALog.e(c, "error in close input file", e2, new Object[0]);
                            }
                        }
                        fileOutputStream.close();
                        return file.getCanonicalPath();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e22) {
                                ALog.e(c, "error in close input file", e22, new Object[0]);
                            }
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e3) {
                            ALog.e(c, "error in close io", e3, new Object[0]);
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    inputStream = open;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    fileOutputStream.close();
                    throw th2;
                }
            }
            a(fileOutputStream, file);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e222) {
                    ALog.e(c, "error in close input file", e222, new Object[0]);
                }
            }
            try {
                fileOutputStream.close();
            } catch (Throwable e32) {
                ALog.e(c, "error in close io", e32, new Object[0]);
            }
        } catch (Exception e4) {
            th = e4;
            ALog.e(c, "error in copy daemon files", th, new Object[0]);
            if (inputStream != null) {
                inputStream.close();
            }
            fileOutputStream.close();
            return file.getCanonicalPath();
        }
        return file.getCanonicalPath();
    }

    private void a(FileOutputStream fileOutputStream, File file) throws IOException {
        Throwable e;
        String a = b.a(this.e);
        String str = c;
        StringBuilder stringBuilder = new StringBuilder(">>>soDataSize:datasize:");
        stringBuilder.append(a.length());
        ALog.d(str, stringBuilder.toString(), new Object[0]);
        byte[] decode = Base64.decode(a.getBytes(), 0);
        str = c;
        stringBuilder = new StringBuilder(">>>soDataSize:");
        stringBuilder.append(decode.length);
        ALog.d(str, stringBuilder.toString(), new Object[0]);
        if (decode.length > 0 && fileOutputStream != null) {
            ByteArrayInputStream byteArrayInputStream = null;
            StatFs statFs = new StatFs(file.getCanonicalPath());
            if (((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks()) >= ((long) decode.length)) {
                try {
                    file = new ByteArrayInputStream(decode);
                    try {
                        byte[] bArr = new byte[100];
                        while (true) {
                            int read = file.read(bArr, 0, 100);
                            if (read >= 0) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                fileOutputStream.getFD().sync();
                                try {
                                    file.close();
                                    return;
                                } catch (FileOutputStream fileOutputStream2) {
                                    fileOutputStream2.printStackTrace();
                                    return;
                                }
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        byteArrayInputStream = file;
                        try {
                            ALog.e(c, "error in write files", e, new Object[0]);
                            fileOutputStream2.getFD().sync();
                            if (byteArrayInputStream != null) {
                                try {
                                    byteArrayInputStream.close();
                                } catch (FileOutputStream fileOutputStream22) {
                                    fileOutputStream22.printStackTrace();
                                }
                            }
                        } catch (Throwable th) {
                            e = th;
                            fileOutputStream22.getFD().sync();
                            if (byteArrayInputStream != null) {
                                try {
                                    byteArrayInputStream.close();
                                } catch (FileOutputStream fileOutputStream222) {
                                    fileOutputStream222.printStackTrace();
                                }
                            }
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        byteArrayInputStream = file;
                        fileOutputStream222.getFD().sync();
                        if (byteArrayInputStream != null) {
                            byteArrayInputStream.close();
                        }
                        throw e;
                    }
                } catch (IOException e3) {
                    e = e3;
                    ALog.e(c, "error in write files", e, new Object[0]);
                    fileOutputStream222.getFD().sync();
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                }
            }
        }
    }

    private void a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder("chmod 500 ");
        stringBuilder2.append(str);
        a("", stringBuilder2.toString(), stringBuilder);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(" ");
        stringBuilder2.append(e());
        a("", stringBuilder2.toString(), stringBuilder);
        String str2 = c;
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str);
        stringBuilder3.append(" ");
        stringBuilder3.append(e());
        ALog.w(str2, stringBuilder3.toString(), new Object[0]);
    }

    private String e() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder("/data/data/");
        stringBuilder2.append(this.d.getPackageName());
        String stringBuilder3 = stringBuilder2.toString();
        StringBuilder stringBuilder4 = new StringBuilder("-s \"");
        stringBuilder4.append(stringBuilder3);
        stringBuilder4.append("/lib/\" ");
        stringBuilder.append(stringBuilder4.toString());
        stringBuilder.append("-n \"runServer\" ");
        stringBuilder4 = new StringBuilder("-p \"");
        stringBuilder4.append(g());
        stringBuilder4.append("\" ");
        stringBuilder.append(stringBuilder4.toString());
        stringBuilder4 = new StringBuilder("-f \"");
        stringBuilder4.append(stringBuilder3);
        stringBuilder4.append("\" ");
        stringBuilder.append(stringBuilder4.toString());
        stringBuilder2 = new StringBuilder("-t \"");
        stringBuilder2.append(this.f);
        stringBuilder2.append("\" ");
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("-c \"agoo.pid\" ");
        if (this.m != null) {
            stringBuilder2 = new StringBuilder("-P ");
            stringBuilder2.append(this.m);
            stringBuilder2.append(" ");
            stringBuilder.append(stringBuilder2.toString());
        }
        if (this.k != null) {
            stringBuilder2 = new StringBuilder("-K ");
            stringBuilder2.append(this.k);
            stringBuilder2.append(" ");
            stringBuilder.append(stringBuilder2.toString());
        }
        if (this.l != null) {
            stringBuilder2 = new StringBuilder("-U ");
            stringBuilder2.append(this.l);
            stringBuilder2.append(" ");
            stringBuilder.append(stringBuilder2.toString());
        }
        if (this.q != null) {
            stringBuilder2 = new StringBuilder("-L ");
            stringBuilder2.append(this.q);
            stringBuilder2.append(" ");
            stringBuilder.append(stringBuilder2.toString());
        }
        stringBuilder2 = new StringBuilder("-D ");
        stringBuilder2.append(f());
        stringBuilder2.append(" ");
        stringBuilder.append(stringBuilder2.toString());
        if (this.p != null) {
            stringBuilder2 = new StringBuilder("-I ");
            stringBuilder2.append(this.p);
            stringBuilder2.append(" ");
            stringBuilder.append(stringBuilder2.toString());
        }
        if (this.r > 0) {
            stringBuilder2 = new StringBuilder("-O ");
            stringBuilder2.append(this.r);
            stringBuilder2.append(" ");
            stringBuilder.append(stringBuilder2.toString());
        }
        stringBuilder3 = UtilityImpl.getProxyHost(this.d);
        int proxyPort = UtilityImpl.getProxyPort(this.d);
        if (stringBuilder3 != null && proxyPort > 0) {
            StringBuilder stringBuilder5 = new StringBuilder("-X ");
            stringBuilder5.append(stringBuilder3);
            stringBuilder5.append(" ");
            stringBuilder.append(stringBuilder5.toString());
            stringBuilder2 = new StringBuilder("-Y ");
            stringBuilder2.append(proxyPort);
            stringBuilder2.append(" ");
            stringBuilder.append(stringBuilder2.toString());
        }
        if (this.s) {
            stringBuilder.append("-T ");
        }
        stringBuilder.append("-Z ");
        return stringBuilder.toString();
    }

    private java.lang.String f() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.d;
        r0 = com.taobao.accs.utl.UtilityImpl.getDeviceId(r0);
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 == 0) goto L_0x000e;
    L_0x000c:
        r0 = "null";
    L_0x000e:
        r1 = new java.lang.StringBuilder;
        r2 = "{\"package\":\"";
        r1.<init>(r2);
        r2 = r4.d;
        r2 = r2.getPackageName();
        r1.append(r2);
        r2 = "\",\"appKey\":\"";
        r1.append(r2);
        r2 = r4.n;
        r1.append(r2);
        r2 = "\",\"utdid\":\"";
        r1.append(r2);
        r1.append(r0);
        r0 = "\",\"sdkVersion\":\"";
        r1.append(r0);
        r0 = r4.o;
        r1.append(r0);
        r0 = "\"}";
        r1.append(r0);
        r0 = r1.toString();
        r1 = "UTF-8";	 Catch:{ Throwable -> 0x004a }
        r1 = java.net.URLEncoder.encode(r0, r1);	 Catch:{ Throwable -> 0x004a }
        return r1;
    L_0x004a:
        r1 = c;
        r2 = new java.lang.StringBuilder;
        r3 = "getReportData failed for url encode, data:";
        r2.<init>(r3);
        r2.append(r0);
        r2 = r2.toString();
        r3 = 0;
        r3 = new java.lang.Object[r3];
        com.taobao.accs.utl.ALog.e(r1, r2, r3);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.b.a.f():java.lang.String");
    }

    private String g() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.replaceAll("\\{packname\\}", this.d.getApplicationContext().getPackageName()));
        if (VERSION.SDK_INT > 15) {
            stringBuilder.append(" --user 0");
        }
        return stringBuilder.toString();
    }

    private void a(String str, int i, int i2, String str2, String str3, int i3) {
        StringBuilder stringBuilder = new StringBuilder("AndroidVer=");
        stringBuilder.append(VERSION.RELEASE);
        stringBuilder.append("&Model=");
        stringBuilder.append(Build.MODEL);
        stringBuilder.append("&AndroidSdk=");
        stringBuilder.append(VERSION.SDK_INT);
        stringBuilder.append("&AccsVer=221&Appkey=");
        stringBuilder.append(this.n);
        stringBuilder.append("&PullCount=");
        stringBuilder.append(str2);
        stringBuilder.append("&Pid=");
        stringBuilder.append(str);
        stringBuilder.append("&StartTime=");
        stringBuilder.append(i);
        stringBuilder.append("&EndTime=");
        stringBuilder.append(i2);
        stringBuilder.append("&ExitCode=");
        stringBuilder.append(str3);
        stringBuilder.append("&AliveTime=");
        stringBuilder.append(i3);
        UTMini.getInstance().commitEvent(66001, "EUDEMON_ENDSTAT", stringBuilder.toString());
    }

    private void h() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r18 = this;
        r8 = r18;
        r1 = new java.lang.StringBuilder;
        r2 = "/data/data/";
        r1.<init>(r2);
        r2 = r8.d;
        r2 = r2.getPackageName();
        r1.append(r2);
        r2 = "/eudemon";
        r1.append(r2);
        r9 = r1.toString();
        r1 = new java.io.File;
        r1.<init>(r9);
        r2 = r1.exists();
        if (r2 != 0) goto L_0x0027;
    L_0x0026:
        return;
    L_0x0027:
        r11 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x011b, all -> 0x0100 }
        r11.<init>(r1);	 Catch:{ Exception -> 0x011b, all -> 0x0100 }
        r12 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x00fe, all -> 0x00fa }
        r12.<init>(r11);	 Catch:{ Exception -> 0x00fe, all -> 0x00fa }
        r13 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
        r13.<init>(r12);	 Catch:{ Exception -> 0x00f8, all -> 0x00f4 }
        r1 = "";	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r14 = r1;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
    L_0x0039:
        r1 = r13.readLine();	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        if (r1 == 0) goto L_0x00ca;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
    L_0x003f:
        r2 = "\\|";	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r2 = r1.split(r2);	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r3 = r2.length;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r4 = 5;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        if (r3 != r4) goto L_0x0039;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
    L_0x0049:
        r3 = 0;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r3 = r2[r3];	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r3 = r3.trim();	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r4 = 1;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r4 = r2[r4];	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r4 = r4.trim();	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r4 = r4.intValue();	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r5 = 2;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r6 = r2[r5];	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r6 = r6.trim();	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r6 = r6.intValue();	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r7 = r6 - r4;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r15 = 3;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r15 = r2[r15];	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r15 = r15.trim();	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r16 = 4;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r2 = r2[r16];	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r2 = r2.trim();	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r10 = "0";	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r10 = r2.equals(r10);	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        if (r10 == 0) goto L_0x00bb;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
    L_0x0087:
        r10 = new java.io.File;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r5 = "/proc";	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r10.<init>(r5, r3);	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r17 = r2;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r2 = "pidfile:";	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r5.<init>(r2);	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r5.append(r10);	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r2 = r10.exists();	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        if (r2 == 0) goto L_0x00b5;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
    L_0x00a0:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r2.<init>();	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r2.append(r14);	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r2.append(r1);	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r1 = "\n";	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r2.append(r1);	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r14 = r2.toString();	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        goto L_0x0039;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
    L_0x00b5:
        r1 = r8.f;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r2 = 2;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r1 = r1 / r2;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r7 = r7 + r1;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        goto L_0x00bd;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
    L_0x00bb:
        r17 = r2;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
    L_0x00bd:
        r1 = r8;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r10 = r17;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r2 = r3;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r3 = r4;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r4 = r6;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r5 = r15;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r6 = r10;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r1.a(r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        goto L_0x0039;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
    L_0x00ca:
        r10 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r1 = new java.io.File;	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r1.<init>(r9);	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r10.<init>(r1);	 Catch:{ Exception -> 0x00f2, all -> 0x00ee }
        r1 = r14.getBytes();	 Catch:{ Exception -> 0x011f, all -> 0x00eb }
        r10.write(r1);	 Catch:{ Exception -> 0x011f, all -> 0x00eb }
        r13.close();	 Catch:{ Exception -> 0x011f, all -> 0x00eb }
        r13.close();	 Catch:{ Throwable -> 0x00e1 }
    L_0x00e1:
        r12.close();	 Catch:{ Throwable -> 0x00e4 }
    L_0x00e4:
        r11.close();	 Catch:{ IOException -> 0x00e7 }
    L_0x00e7:
        r10.close();	 Catch:{ IOException -> 0x00ea }
    L_0x00ea:
        return;
    L_0x00eb:
        r0 = move-exception;
        r1 = r0;
        goto L_0x0106;
    L_0x00ee:
        r0 = move-exception;
        r1 = r0;
        r10 = 0;
        goto L_0x0106;
    L_0x00f2:
        r10 = 0;
        goto L_0x011f;
    L_0x00f4:
        r0 = move-exception;
        r1 = r0;
        r10 = 0;
        goto L_0x0105;
    L_0x00f8:
        r10 = 0;
        goto L_0x011e;
    L_0x00fa:
        r0 = move-exception;
        r1 = r0;
        r10 = 0;
        goto L_0x0104;
    L_0x00fe:
        r10 = 0;
        goto L_0x011d;
    L_0x0100:
        r0 = move-exception;
        r1 = r0;
        r10 = 0;
        r11 = 0;
    L_0x0104:
        r12 = 0;
    L_0x0105:
        r13 = 0;
    L_0x0106:
        if (r13 == 0) goto L_0x010b;
    L_0x0108:
        r13.close();	 Catch:{ Throwable -> 0x010b }
    L_0x010b:
        if (r12 == 0) goto L_0x0110;
    L_0x010d:
        r12.close();	 Catch:{ Throwable -> 0x0110 }
    L_0x0110:
        if (r11 == 0) goto L_0x0115;
    L_0x0112:
        r11.close();	 Catch:{ IOException -> 0x0115 }
    L_0x0115:
        if (r10 == 0) goto L_0x011a;
    L_0x0117:
        r10.close();	 Catch:{ IOException -> 0x011a }
    L_0x011a:
        throw r1;
    L_0x011b:
        r10 = 0;
        r11 = 0;
    L_0x011d:
        r12 = 0;
    L_0x011e:
        r13 = 0;
    L_0x011f:
        if (r13 == 0) goto L_0x0124;
    L_0x0121:
        r13.close();	 Catch:{ Throwable -> 0x0124 }
    L_0x0124:
        if (r12 == 0) goto L_0x0129;
    L_0x0126:
        r12.close();	 Catch:{ Throwable -> 0x0129 }
    L_0x0129:
        if (r11 == 0) goto L_0x012e;
    L_0x012b:
        r11.close();	 Catch:{ IOException -> 0x012e }
    L_0x012e:
        if (r10 == 0) goto L_0x0134;
    L_0x0130:
        r10.close();	 Catch:{ IOException -> 0x0133 }
    L_0x0133:
        return;
    L_0x0134:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.b.a.h():void");
    }

    public void a() {
        Message obtain = Message.obtain();
        obtain.what = 0;
        this.t.sendMessage(obtain);
    }

    private void i() {
        String str = c;
        StringBuilder stringBuilder = new StringBuilder("api level is:");
        stringBuilder.append(VERSION.SDK_INT);
        ALog.d(str, stringBuilder.toString(), new Object[0]);
        b(this.d);
        if (VERSION.SDK_INT < 20) {
            try {
                str = d();
                h();
                a(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        UTMini.getInstance().commitEvent(66001, "EUDEMON_START", "");
    }

    private void j() {
        StringBuilder stringBuilder = new StringBuilder("/data/data/");
        stringBuilder.append(this.d.getPackageName());
        File file = new File(stringBuilder.toString(), "daemonserver.pid");
        if (file.exists()) {
            file.delete();
        }
    }

    public static final PendingIntent a(Context context) {
        Intent intent = new Intent();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getApplicationContext().getPackageName());
        stringBuilder.append(".intent.action.COCKROACH");
        intent.setAction(stringBuilder.toString());
        intent.putExtra("cockroach", "cockroach-PPreotect");
        intent.putExtra("pack", context.getApplicationContext().getPackageName());
        return PendingIntent.getService(context, 0, intent, 134217728);
    }

    public static void b(Context context) {
        int i = Calendar.getInstance().get(11);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (alarmManager != null) {
            PendingIntent a = a(context);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (i <= 23) {
                if (i >= 6) {
                    ALog.w(c, "time is daytime, wakeup cpu for keeping connecntion", new Object[0]);
                    a(alarmManager, a, elapsedRealtime);
                }
            }
            ALog.w(c, "time is night, do not wakeup cpu", new Object[0]);
            b(alarmManager, a, elapsedRealtime);
        }
    }

    private static void a(AlarmManager alarmManager, PendingIntent pendingIntent, long j) {
        if (pendingIntent != null) {
            alarmManager.cancel(pendingIntent);
            alarmManager.setRepeating(2, j + ((long) (h * 1000)), (long) (h * 1000), pendingIntent);
        }
    }

    private static void b(AlarmManager alarmManager, PendingIntent pendingIntent, long j) {
        alarmManager.cancel(pendingIntent);
        alarmManager.setRepeating(3, j + ((long) (g * 1000)), (long) (g * 1000), pendingIntent);
    }

    public static void c(Context context) {
        try {
            File file = new File(context.getFilesDir(), AGOO_PID);
            context = c;
            StringBuilder stringBuilder = new StringBuilder("pid path:");
            stringBuilder.append(file.getAbsolutePath());
            ALog.d(context, stringBuilder.toString(), new Object[0]);
            if (file.exists() != null) {
                file.delete();
            }
            file.createNewFile();
            FileWriter fileWriter;
            try {
                int myPid = Process.myPid();
                fileWriter = new FileWriter(file);
                try {
                    fileWriter.write(String.valueOf(myPid).toCharArray());
                    try {
                        fileWriter.close();
                    } catch (Context context2) {
                        ALog.e(c, "error", context2, new Object[0]);
                    }
                } catch (Throwable th) {
                    context2 = th;
                    try {
                        ALog.e(c, "save pid error", context2, new Object[0]);
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                    } catch (Throwable th2) {
                        context2 = th2;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (Throwable th3) {
                                ALog.e(c, "error", th3, new Object[0]);
                            }
                        }
                        throw context2;
                    }
                }
            } catch (Throwable th32) {
                fileWriter = null;
                context2 = th32;
                if (fileWriter != null) {
                    fileWriter.close();
                }
                throw context2;
            }
        } catch (Context context22) {
            ALog.e(c, "error in create file", context22, new Object[0]);
        }
    }

    public boolean handleMessage(Message message) {
        try {
            if (message.what == 0) {
                i();
            } else if (message.what == -1) {
                j();
            }
        } catch (Message message2) {
            ALog.e(c, "handleMessage error", message2, new Object[0]);
        }
        return true;
    }

    public static boolean a(String str, String str2, StringBuilder stringBuilder) {
        try {
            Process exec = Runtime.getRuntime().exec(IXAdRequestInfo.SCREEN_HEIGHT);
            DataInputStream dataInputStream = new DataInputStream(exec.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(exec.getOutputStream());
            if (!(str == null || "".equals(str.trim()))) {
                StringBuilder stringBuilder2 = new StringBuilder("cd ");
                stringBuilder2.append(str);
                stringBuilder2.append("\n");
                dataOutputStream.writeBytes(stringBuilder2.toString());
            }
            str = new StringBuilder();
            str.append(str2);
            str.append(" &\n");
            dataOutputStream.writeBytes(str.toString());
            dataOutputStream.writeBytes("exit \n");
            dataOutputStream.flush();
            exec.waitFor();
            str = new byte[dataInputStream.available()];
            dataInputStream.read(str);
            str2 = new String(str);
            if (str2.length() != null) {
                stringBuilder.append(str2);
            }
            return true;
        } catch (String str3) {
            str2 = new StringBuilder("Exception:");
            str2.append(str3.getMessage());
            stringBuilder.append(str2.toString());
            return null;
        }
    }
}
