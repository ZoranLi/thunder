package com.tencent.bugly.proguard;

import android.text.TextUtils;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.d;
import com.tencent.bugly.beta.ui.c;
import com.tencent.bugly.beta.utils.e;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
public class t extends DownloadTask implements Runnable {
    public long k = 0;
    private File l;
    private long m = 0;

    public t(String str, String str2, long j, long j2, String str3) {
        super(str, "", "", str3);
        this.l = new File(str2);
        this.b = this.l.getParent();
        this.c = this.l.getName();
        this.e = j;
        this.f = j2;
        getStatus();
    }

    public t(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
        getStatus();
    }

    public File getSaveFile() {
        return this.l;
    }

    public void download() {
        if (getStatus() == 1) {
            b();
        } else if (getStatus() != 2) {
            if (getSaveFile() != null) {
                if (getSaveFile().exists()) {
                    this.e = getSaveFile().length();
                    if (this.g) {
                        c.a.a(this);
                    }
                    this.m = System.currentTimeMillis();
                    this.i = 2;
                    s.a.b.put(getDownloadUrl(), this);
                    s.a.a(this);
                }
            }
            this.e = 0;
            this.f = 0;
            this.k = 0;
            if (this.g) {
                c.a.a(this);
            }
            this.m = System.currentTimeMillis();
            this.i = 2;
            s.a.b.put(getDownloadUrl(), this);
            s.a.a(this);
        }
    }

    public void delete(boolean z) {
        stop();
        if (z) {
            if (getSaveFile() && getSaveFile().exists() && !getSaveFile().isDirectory()) {
                getSaveFile().delete();
            }
            p.a.b((DownloadTask) this);
        }
        BetaReceiver.netListeners.remove(getDownloadUrl());
        this.c = false;
        this.e = 0;
        this.f = 0;
        this.i = true;
    }

    public void stop() {
        if (this.i != 5) {
            this.i = 3;
        }
    }

    public int getStatus() {
        if (getSaveFile() != null && getSaveFile().exists() && getSaveFile().length() == this.f && !s.a.b.contains(this)) {
            this.e = this.f;
            this.i = 1;
        }
        if (getSaveFile() != null && getSaveFile().exists() && getSaveFile().length() > 0 && getSaveFile().length() < this.f && !s.a.b.contains(this)) {
            this.e = getSaveFile().length();
            this.i = 3;
        }
        if ((getSaveFile() == null || !getSaveFile().exists()) && !s.a.b.contains(this)) {
            this.i = 0;
        }
        return this.i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r17 = this;
        r1 = r17;
        r2 = 0;
        r3 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x01cc }
        r4 = r17.getDownloadUrl();	 Catch:{ MalformedURLException -> 0x01cc }
        r3.<init>(r4);	 Catch:{ MalformedURLException -> 0x01cc }
        r4 = 0;
        r5 = r4;
        r6 = r5;
        r4 = r2;
    L_0x0010:
        r7 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r8 = 3;
        if (r4 >= r8) goto L_0x0184;
    L_0x0015:
        r4 = r4 + 1;
        r9 = r3.openConnection();	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r9 = (javax.net.ssl.HttpsURLConnection) r9;	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r10 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r9.setConnectTimeout(r10);	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r10 = "GET";
        r9.setRequestMethod(r10);	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r10 = "Referer";
        r11 = r3.toString();	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r9.setRequestProperty(r10, r11);	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r10 = "Charset";
        r11 = "UTF-8";
        r9.setRequestProperty(r10, r11);	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r10 = "Range";
        r11 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r12 = "bytes=";
        r11.<init>(r12);	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r12 = r1.e;	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r11.append(r12);	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r12 = "-";
        r11.append(r12);	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r11 = r11.toString();	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r9.setRequestProperty(r10, r11);	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r10 = "Connection";
        r11 = "Keep-Alive";
        r9.setRequestProperty(r10, r11);	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r9.connect();	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r10 = r1.a(r9);	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r1.c = r10;	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r10 = new java.io.File;	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r11 = r1.b;	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r10.<init>(r11);	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r11 = r10.exists();	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        if (r11 != 0) goto L_0x0071;
    L_0x006e:
        r10.mkdirs();	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
    L_0x0071:
        r11 = new java.io.File;	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r12 = r1.c;	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r11.<init>(r10, r12);	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r1.l = r11;	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r10 = r1.f;	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r12 = 0;
        r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r14 != 0) goto L_0x00a5;
    L_0x0082:
        r10 = r9.getContentLength();	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r10 = (long) r10;	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r1.f = r10;	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r10 = r1.f;	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r14 > 0) goto L_0x00a5;
    L_0x008f:
        r8 = "tLen <= 0 ";
        r1.a(r7, r8);	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        if (r5 == 0) goto L_0x0099;
    L_0x0096:
        r5.close();	 Catch:{ Exception -> 0x019b }
    L_0x0099:
        if (r6 == 0) goto L_0x00a4;
    L_0x009b:
        r6.close();	 Catch:{ Exception -> 0x009f }
        goto L_0x00a4;
    L_0x009f:
        r0 = move-exception;
        r0.printStackTrace();
        return;
    L_0x00a4:
        return;
    L_0x00a5:
        r10 = com.tencent.bugly.proguard.p.a;	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r10.a(r1);	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r9 = r9.getInputStream();	 Catch:{ IOException -> 0x015b, all -> 0x0158 }
        r6 = 307200; // 0x4b000 float:4.30479E-40 double:1.51777E-318;
        r6 = new byte[r6];	 Catch:{ IOException -> 0x0154, all -> 0x0150 }
        r10 = new java.io.RandomAccessFile;	 Catch:{ IOException -> 0x0154, all -> 0x0150 }
        r11 = r1.l;	 Catch:{ IOException -> 0x0154, all -> 0x0150 }
        r12 = "rwd";
        r10.<init>(r11, r12);	 Catch:{ IOException -> 0x0154, all -> 0x0150 }
        r11 = r1.e;	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r10.seek(r11);	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r5 = 0;
    L_0x00c2:
        r11 = r9.read(r6);	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r12 = -1;
        if (r11 == r12) goto L_0x0135;
    L_0x00c9:
        r12 = r1.e;	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r14 = (long) r11;	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r7 = r12 + r14;
        r1.e = r7;	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r7 = r1.e;	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r12 = r1.f;	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r14 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1));
        if (r14 <= 0) goto L_0x00f1;
    L_0x00d8:
        r17.b();	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r5 = "mSavedLength > mTotalLength,重新下载!";
        r6 = new java.lang.Object[r2];	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        com.tencent.bugly.proguard.an.e(r5, r6);	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r10.close();	 Catch:{ Exception -> 0x0143, all -> 0x013e }
        if (r9 == 0) goto L_0x00f0;
    L_0x00e7:
        r9.close();	 Catch:{ Exception -> 0x00eb }
        goto L_0x00f0;
    L_0x00eb:
        r0 = move-exception;
        r0.printStackTrace();
        return;
    L_0x00f0:
        return;
    L_0x00f1:
        r7 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
        r12 = r1.e;	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r8 = (float) r12;	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r12 = r1.f;	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r12 = (float) r12;	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r8 = r8 / r12;
        r7 = r7 * r8;
        r8 = r7 - r5;
        r12 = (double) r8;	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r14 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r8 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
        if (r8 < 0) goto L_0x0108;
    L_0x0104:
        r17.a();	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r5 = r7;
    L_0x0108:
        r10.write(r6, r2, r11);	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r7 = r17.getSaveFile();	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        if (r7 == 0) goto L_0x0126;
    L_0x0111:
        r7 = r17.getSaveFile();	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r7 = r7.exists();	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        if (r7 == 0) goto L_0x0126;
    L_0x011b:
        r7 = r17.getStatus();	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r8 = 3;
        if (r7 != r8) goto L_0x0123;
    L_0x0122:
        goto L_0x0126;
    L_0x0123:
        r7 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        goto L_0x00c2;
    L_0x0126:
        r10.close();	 Catch:{ Exception -> 0x0143, all -> 0x013e }
        if (r9 == 0) goto L_0x0134;
    L_0x012b:
        r9.close();	 Catch:{ Exception -> 0x012f }
        goto L_0x0134;
    L_0x012f:
        r0 = move-exception;
        r0.printStackTrace();
        return;
    L_0x0134:
        return;
    L_0x0135:
        r17.b();	 Catch:{ IOException -> 0x014c, all -> 0x0148 }
        r10.close();	 Catch:{ Exception -> 0x0143, all -> 0x013e }
        r6 = r9;
        r3 = 3;
        goto L_0x0185;
    L_0x013e:
        r0 = move-exception;
        r2 = r0;
        r6 = r9;
        goto L_0x01b5;
    L_0x0143:
        r0 = move-exception;
        r2 = r0;
        r6 = r9;
        goto L_0x019d;
    L_0x0148:
        r0 = move-exception;
        r2 = r0;
        r6 = r9;
        goto L_0x017d;
    L_0x014c:
        r0 = move-exception;
        r5 = r0;
        r6 = r9;
        goto L_0x015e;
    L_0x0150:
        r0 = move-exception;
        r2 = r0;
        r6 = r9;
        goto L_0x017e;
    L_0x0154:
        r0 = move-exception;
        r10 = r5;
        r6 = r9;
        goto L_0x015d;
    L_0x0158:
        r0 = move-exception;
        r2 = r0;
        goto L_0x017e;
    L_0x015b:
        r0 = move-exception;
        r10 = r5;
    L_0x015d:
        r5 = r0;
    L_0x015e:
        r5.printStackTrace();	 Catch:{ all -> 0x017b }
        r7 = 2020; // 0x7e4 float:2.83E-42 double:9.98E-321;
        r5 = r5.getMessage();	 Catch:{ all -> 0x017b }
        r1.a(r7, r5);	 Catch:{ all -> 0x017b }
        r5 = com.tencent.bugly.proguard.t.class;
        r7 = "IOException,stop download!";
        r8 = new java.lang.Object[r2];	 Catch:{ all -> 0x017b }
        com.tencent.bugly.proguard.an.b(r5, r7, r8);	 Catch:{ all -> 0x017b }
        if (r10 == 0) goto L_0x0178;
    L_0x0175:
        r10.close();	 Catch:{ Exception -> 0x019b }
    L_0x0178:
        r5 = r10;
        goto L_0x0010;
    L_0x017b:
        r0 = move-exception;
        r2 = r0;
    L_0x017d:
        r5 = r10;
    L_0x017e:
        if (r5 == 0) goto L_0x0183;
    L_0x0180:
        r5.close();	 Catch:{ Exception -> 0x019b }
    L_0x0183:
        throw r2;	 Catch:{ Exception -> 0x019b }
    L_0x0184:
        r3 = r8;
    L_0x0185:
        if (r4 < r3) goto L_0x01c0;
    L_0x0187:
        r4 = com.tencent.bugly.proguard.t.class;
        r5 = "have retry %d times";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x019b }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x019b }
        r7[r2] = r3;	 Catch:{ Exception -> 0x019b }
        com.tencent.bugly.proguard.an.b(r4, r5, r7);	 Catch:{ Exception -> 0x019b }
        goto L_0x01c0;
    L_0x0198:
        r0 = move-exception;
        r2 = r0;
        goto L_0x01b5;
    L_0x019b:
        r0 = move-exception;
        r2 = r0;
    L_0x019d:
        r3 = r2.getMessage();	 Catch:{ all -> 0x0198 }
        r4 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r1.a(r4, r3);	 Catch:{ all -> 0x0198 }
        r2.printStackTrace();	 Catch:{ all -> 0x0198 }
        if (r6 == 0) goto L_0x01b4;
    L_0x01ab:
        r6.close();	 Catch:{ Exception -> 0x01af }
        goto L_0x01b4;
    L_0x01af:
        r0 = move-exception;
        r0.printStackTrace();
        return;
    L_0x01b4:
        return;
    L_0x01b5:
        if (r6 == 0) goto L_0x01bf;
    L_0x01b7:
        r6.close();	 Catch:{ Exception -> 0x01bb }
        goto L_0x01bf;
    L_0x01bb:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x01bf:
        throw r2;
    L_0x01c0:
        if (r6 == 0) goto L_0x01cb;
    L_0x01c2:
        r6.close();	 Catch:{ Exception -> 0x01c6 }
        goto L_0x01cb;
    L_0x01c6:
        r0 = move-exception;
        r0.printStackTrace();
        return;
    L_0x01cb:
        return;
    L_0x01cc:
        r0 = move-exception;
        r3 = r0;
        r4 = r3.getMessage();
        r2 = new java.lang.Object[r2];
        com.tencent.bugly.proguard.an.a(r4, r2);
        r2 = 2010; // 0x7da float:2.817E-42 double:9.93E-321;
        r3 = r3.getMessage();
        r1.a(r2, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.t.run():void");
    }

    private String a(HttpURLConnection httpURLConnection) {
        try {
            if (!TextUtils.isEmpty(this.c)) {
                return this.c;
            }
            httpURLConnection = httpURLConnection.getHeaderFields();
            if (httpURLConnection != null) {
                for (String str : httpURLConnection.keySet()) {
                    if (str != null) {
                        List<String> list = (List) httpURLConnection.get(str);
                        if (list != null) {
                            for (String str2 : list) {
                                if (str2 != null && "content-disposition".equals(str.toLowerCase())) {
                                    Matcher matcher = Pattern.compile(".*filename=(.*)").matcher(str2.toLowerCase());
                                    if (matcher.find()) {
                                        return matcher.group(1);
                                    }
                                }
                            }
                            continue;
                        } else {
                            continue;
                        }
                    }
                }
            }
            httpURLConnection = getDownloadUrl().substring(getDownloadUrl().lastIndexOf(47) + 1);
            if (!TextUtils.isEmpty(httpURLConnection)) {
                return httpURLConnection;
            }
            httpURLConnection = new StringBuilder();
            httpURLConnection.append(UUID.randomUUID());
            httpURLConnection.append(ShareConstants.PATCH_SUFFIX);
            return httpURLConnection.toString();
        } catch (HttpURLConnection httpURLConnection2) {
            httpURLConnection2.printStackTrace();
        }
    }

    protected void a(int i, String str) {
        this.i = 5;
        c.a.a();
        s.a.b.remove(getDownloadUrl());
        e.a(new d(10, this.d, this, Integer.valueOf(i), str));
    }

    protected void a() {
        this.k += System.currentTimeMillis() - this.m;
        p.a.a((DownloadTask) this);
        this.m = System.currentTimeMillis();
        c.a.a();
        e.a(new d(9, this.d, this));
    }

    protected void b() {
        this.i = 1;
        a();
        s.a.b.remove(getDownloadUrl());
        BetaReceiver.netListeners.remove(getDownloadUrl());
        e.a(new d(8, this.d, this));
    }

    public long getCostTime() {
        return this.k;
    }
}
