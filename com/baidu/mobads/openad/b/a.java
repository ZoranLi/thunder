package com.baidu.mobads.openad.b;

import android.content.Context;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.BufferedInputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;

public class a extends Observable implements IOAdDownloader, Runnable {
    protected Context a;
    protected URL b;
    protected URL c;
    protected String d;
    protected int e;
    protected Boolean f = Boolean.valueOf(true);
    protected String g;
    protected int h;
    protected DownloadStatus i;
    protected volatile int j;
    protected int k;
    protected ArrayList<a> l;
    g m = null;
    private String n;
    private String o;
    private boolean p = false;

    protected class a implements Runnable {
        protected int a;
        protected URL b;
        protected String c;
        protected int d;
        protected int e;
        protected int f;
        protected boolean g;
        protected Thread h;
        final /* synthetic */ a i;
        private volatile boolean j = false;
        private volatile int k = 0;
        private HttpURLConnection l;

        public a(a aVar, int i, URL url, String str, int i2, int i3, int i4) {
            this.i = aVar;
            this.a = i;
            this.b = url;
            this.c = str;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = false;
        }

        public boolean a() {
            return this.g;
        }

        public synchronized void b() {
            this.j = false;
            this.h = new Thread(this);
            this.h.start();
        }

        public synchronized void c() {
            this.j = true;
            this.k++;
        }

        public void a(HttpURLConnection httpURLConnection) {
            this.l = httpURLConnection;
        }

        public void d() {
            if (this.h != null) {
                this.h.join();
                return;
            }
            XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", "Warning: mThread in DownloadThread.waitFinish is null");
        }

        public void run() {
            HttpURLConnection httpURLConnection;
            Exception e;
            HttpURLConnection httpURLConnection2;
            BufferedInputStream bufferedInputStream;
            StringBuilder stringBuilder;
            Throwable th;
            int i = this.k;
            RandomAccessFile randomAccessFile = null;
            StringBuilder stringBuilder2;
            try {
                BufferedInputStream bufferedInputStream2;
                if (this.d + this.f >= this.e) {
                    this.g = true;
                    httpURLConnection = null;
                    bufferedInputStream2 = httpURLConnection;
                } else {
                    int i2;
                    RandomAccessFile randomAccessFile2;
                    if (this.l == null) {
                        httpURLConnection = (HttpURLConnection) this.b.openConnection();
                        try {
                            if (this.i.f.booleanValue()) {
                                StringBuilder stringBuilder3 = new StringBuilder();
                                stringBuilder3.append(this.d + this.f);
                                stringBuilder3.append("-");
                                stringBuilder3.append(this.e);
                                String stringBuilder4 = stringBuilder3.toString();
                                StringBuilder stringBuilder5 = new StringBuilder("bytes=");
                                stringBuilder5.append(stringBuilder4);
                                httpURLConnection.setRequestProperty("Range", stringBuilder5.toString());
                            } else {
                                this.f = 0;
                            }
                            httpURLConnection.connect();
                            int responseCode = httpURLConnection.getResponseCode();
                            StringBuilder stringBuilder6;
                            if (i != this.k) {
                                stringBuilder6 = new StringBuilder("Thread[");
                                stringBuilder6.append(this.a);
                                stringBuilder6.append("] ver(");
                                stringBuilder6.append(i);
                                stringBuilder6.append(") executed end; isFinished=");
                                stringBuilder6.append(this.g);
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", stringBuilder6.toString());
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Exception e2) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e2.getMessage());
                                    }
                                }
                                return;
                            } else if (responseCode / 100 != 2) {
                                this.i.b();
                                stringBuilder6 = new StringBuilder("Thread[");
                                stringBuilder6.append(this.a);
                                stringBuilder6.append("] ver(");
                                stringBuilder6.append(i);
                                stringBuilder6.append(") executed end; isFinished=");
                                stringBuilder6.append(this.g);
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", stringBuilder6.toString());
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Exception e22) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e22.getMessage());
                                    }
                                }
                                return;
                            } else if (httpURLConnection.getContentType().equals("text/html")) {
                                this.i.b();
                                stringBuilder6 = new StringBuilder("Thread[");
                                stringBuilder6.append(this.a);
                                stringBuilder6.append("] ver(");
                                stringBuilder6.append(i);
                                stringBuilder6.append(") executed end; isFinished=");
                                stringBuilder6.append(this.g);
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", stringBuilder6.toString());
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Exception e222) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e222.getMessage());
                                    }
                                }
                                return;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            httpURLConnection2 = httpURLConnection;
                            bufferedInputStream = null;
                            try {
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", e.getMessage());
                                if (i == this.k) {
                                    this.i.b();
                                }
                                stringBuilder = new StringBuilder("Thread[");
                                stringBuilder.append(this.a);
                                stringBuilder.append("] ver(");
                                stringBuilder.append(i);
                                stringBuilder.append(") executed end; isFinished=");
                                stringBuilder.append(this.g);
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", stringBuilder.toString());
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (Exception e2222) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e2222.getMessage());
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (Exception e22222) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e22222.getMessage());
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    try {
                                        httpURLConnection2.disconnect();
                                    } catch (Exception e222222) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e222222.getMessage());
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                stringBuilder2 = new StringBuilder("Thread[");
                                stringBuilder2.append(this.a);
                                stringBuilder2.append("] ver(");
                                stringBuilder2.append(i);
                                stringBuilder2.append(") executed end; isFinished=");
                                stringBuilder2.append(this.g);
                                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", stringBuilder2.toString());
                                if (randomAccessFile != null) {
                                    try {
                                        randomAccessFile.close();
                                    } catch (Exception e2222222) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e2222222.getMessage());
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (Exception e22222222) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e22222222.getMessage());
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    try {
                                        httpURLConnection2.disconnect();
                                    } catch (Exception e222222222) {
                                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e222222222.getMessage());
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            httpURLConnection2 = httpURLConnection;
                            bufferedInputStream = null;
                            stringBuilder2 = new StringBuilder("Thread[");
                            stringBuilder2.append(this.a);
                            stringBuilder2.append("] ver(");
                            stringBuilder2.append(i);
                            stringBuilder2.append(") executed end; isFinished=");
                            stringBuilder2.append(this.g);
                            XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", stringBuilder2.toString());
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            throw th;
                        }
                    }
                    httpURLConnection = this.l;
                    this.l = null;
                    bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                    try {
                        i2 = this.d + this.f;
                        stringBuilder2 = new StringBuilder("tmpStartByte = ");
                        stringBuilder2.append(i2);
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", stringBuilder2.toString());
                        randomAccessFile2 = new RandomAccessFile(this.c, "rw");
                    } catch (Exception e4) {
                        Exception exception = e4;
                        httpURLConnection2 = httpURLConnection;
                        bufferedInputStream = bufferedInputStream2;
                        e = exception;
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", e.getMessage());
                        if (i == this.k) {
                            this.i.b();
                        }
                        stringBuilder = new StringBuilder("Thread[");
                        stringBuilder.append(this.a);
                        stringBuilder.append("] ver(");
                        stringBuilder.append(i);
                        stringBuilder.append(") executed end; isFinished=");
                        stringBuilder.append(this.g);
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", stringBuilder.toString());
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (Throwable th4) {
                        Throwable th5 = th4;
                        httpURLConnection2 = httpURLConnection;
                        bufferedInputStream = bufferedInputStream2;
                        th = th5;
                        stringBuilder2 = new StringBuilder("Thread[");
                        stringBuilder2.append(this.a);
                        stringBuilder2.append("] ver(");
                        stringBuilder2.append(i);
                        stringBuilder2.append(") executed end; isFinished=");
                        stringBuilder2.append(this.g);
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", stringBuilder2.toString());
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                    try {
                        randomAccessFile2.seek((long) i2);
                        byte[] bArr = new byte[ShareConstants.MD5_FILE_BUF_LENGTH];
                        while (this.i.i == DownloadStatus.DOWNLOADING) {
                            int read = bufferedInputStream2.read(bArr, 0, ShareConstants.MD5_FILE_BUF_LENGTH);
                            if (read == -1 || i2 >= this.e || i != this.k) {
                                break;
                            }
                            randomAccessFile2.write(bArr, 0, read);
                            this.f += read;
                            i2 += read;
                            this.i.a(read);
                            synchronized (this) {
                                if (this.j) {
                                }
                            }
                        }
                        if (i2 >= this.e) {
                            this.g = true;
                        }
                        randomAccessFile = randomAccessFile2;
                    } catch (Exception e5) {
                        httpURLConnection2 = httpURLConnection;
                        bufferedInputStream = bufferedInputStream2;
                        e = e5;
                        randomAccessFile = randomAccessFile2;
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", e.getMessage());
                        if (i == this.k) {
                            this.i.b();
                        }
                        stringBuilder = new StringBuilder("Thread[");
                        stringBuilder.append(this.a);
                        stringBuilder.append("] ver(");
                        stringBuilder.append(i);
                        stringBuilder.append(") executed end; isFinished=");
                        stringBuilder.append(this.g);
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", stringBuilder.toString());
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (Throwable th6) {
                        httpURLConnection2 = httpURLConnection;
                        bufferedInputStream = bufferedInputStream2;
                        th = th6;
                        randomAccessFile = randomAccessFile2;
                        stringBuilder2 = new StringBuilder("Thread[");
                        stringBuilder2.append(this.a);
                        stringBuilder2.append("] ver(");
                        stringBuilder2.append(i);
                        stringBuilder2.append(") executed end; isFinished=");
                        stringBuilder2.append(this.g);
                        XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", stringBuilder2.toString());
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                }
                stringBuilder = new StringBuilder("Thread[");
                stringBuilder.append(this.a);
                stringBuilder.append("] ver(");
                stringBuilder.append(i);
                stringBuilder.append(") executed end; isFinished=");
                stringBuilder.append(this.g);
                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", stringBuilder.toString());
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e2222222222) {
                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e2222222222.getMessage());
                    }
                }
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e22222222222) {
                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e22222222222.getMessage());
                    }
                }
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e222222222222) {
                        XAdSDKFoundationFacade.getInstance().getAdLogger().w("DownloadThread", e222222222222.getMessage());
                    }
                }
            } catch (Exception e6) {
                httpURLConnection2 = null;
                e = e6;
                bufferedInputStream = httpURLConnection2;
                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", e.getMessage());
                if (i == this.k) {
                    this.i.b();
                }
                stringBuilder = new StringBuilder("Thread[");
                stringBuilder.append(this.a);
                stringBuilder.append("] ver(");
                stringBuilder.append(i);
                stringBuilder.append(") executed end; isFinished=");
                stringBuilder.append(this.g);
                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", stringBuilder.toString());
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Throwable th7) {
                httpURLConnection2 = null;
                th = th7;
                bufferedInputStream = httpURLConnection2;
                stringBuilder2 = new StringBuilder("Thread[");
                stringBuilder2.append(this.a);
                stringBuilder2.append("] ver(");
                stringBuilder2.append(i);
                stringBuilder2.append(") executed end; isFinished=");
                stringBuilder2.append(this.g);
                XAdSDKFoundationFacade.getInstance().getAdLogger().d("DownloadThread", stringBuilder2.toString());
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        }
    }

    public boolean isPausedManually() {
        return this.p;
    }

    public void setPausedManually(boolean z) {
        this.p = z;
    }

    public a(Context context, URL url, String str, String str2, int i, String str3, String str4) {
        this.a = context;
        this.b = url;
        this.d = str;
        this.e = i;
        if (str2 == null || str2.trim().length() <= null) {
            context = url.getFile();
            this.g = context.substring(context.lastIndexOf(47) + 1);
        } else {
            this.g = str2;
        }
        this.h = -1;
        this.i = DownloadStatus.NONE;
        this.j = 0;
        this.k = 0;
        this.n = str3;
        this.o = str4;
        this.l = new ArrayList();
    }

    public void pause() {
        StringBuilder stringBuilder;
        try {
            stringBuilder = new StringBuilder("execute Pause; state = ");
            stringBuilder.append(this.i);
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", stringBuilder.toString());
            if (this.i == DownloadStatus.DOWNLOADING || this.i == DownloadStatus.ERROR || this.i == DownloadStatus.NONE) {
                if (this.l != null) {
                    for (int i = 0; i < this.l.size(); i++) {
                        if (!((a) this.l.get(i)).a()) {
                            ((a) this.l.get(i)).c();
                        }
                    }
                }
                a(DownloadStatus.PAUSED);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "pause exception");
            com.baidu.mobads.c.a a = com.baidu.mobads.c.a.a();
            stringBuilder = new StringBuilder("apk download pause failed: ");
            stringBuilder.append(e.toString());
            a.a(stringBuilder.toString());
        }
    }

    public void resume() {
        StringBuilder stringBuilder;
        try {
            stringBuilder = new StringBuilder("execute Resume; state = ");
            stringBuilder.append(this.i);
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", stringBuilder.toString());
            if (this.i == DownloadStatus.PAUSED || this.i == DownloadStatus.ERROR || this.i == DownloadStatus.CANCELLED) {
                a(DownloadStatus.INITING);
                setPausedManually(true);
                new Thread(this).start();
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "resume exception");
            com.baidu.mobads.c.a a = com.baidu.mobads.c.a.a();
            stringBuilder = new StringBuilder("apk download resume failed: ");
            stringBuilder.append(e.toString());
            a.a(stringBuilder.toString());
        }
    }

    public void cancel() {
        StringBuilder stringBuilder;
        try {
            stringBuilder = new StringBuilder("execute Cancel; state = ");
            stringBuilder.append(this.i);
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", stringBuilder.toString());
            if (this.i == DownloadStatus.PAUSED || this.i == DownloadStatus.DOWNLOADING) {
                if (this.l != null) {
                    for (int i = 0; i < this.l.size(); i++) {
                        if (!((a) this.l.get(i)).a()) {
                            ((a) this.l.get(i)).c();
                        }
                    }
                }
                a(DownloadStatus.CANCELLED);
            }
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", "cancel exception");
            com.baidu.mobads.c.a a = com.baidu.mobads.c.a.a();
            stringBuilder = new StringBuilder("apk download cancel failed: ");
            stringBuilder.append(e.toString());
            a.a(stringBuilder.toString());
        }
    }

    public String getURL() {
        return this.b.toString();
    }

    public int getFileSize() {
        return this.h;
    }

    public float getProgress() {
        return Math.abs((((float) this.j) / ((float) this.h)) * 100.0f);
    }

    public String getTitle() {
        return this.n;
    }

    public String getPackageName() {
        return this.o;
    }

    public DownloadStatus getState() {
        return this.i;
    }

    protected void a(DownloadStatus downloadStatus) {
        this.i = downloadStatus;
        a();
    }

    public void start() {
        StringBuilder stringBuilder = new StringBuilder("execute Start; state = ");
        stringBuilder.append(this.i);
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("Downloader", stringBuilder.toString());
        if (this.i == DownloadStatus.NONE) {
            a(DownloadStatus.INITING);
            setPausedManually(true);
            new Thread(this).start();
        }
    }

    protected synchronized void a(int i) {
        this.j += i;
        i = (int) getProgress();
        if (this.k < i) {
            this.k = i;
            a();
        }
    }

    protected void a() {
        setChanged();
        notifyObservers();
    }

    public String getOutputPath() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d);
        stringBuilder.append(this.g);
        return stringBuilder.toString();
    }

    protected synchronized void b() {
        this.i = DownloadStatus.ERROR;
        for (int i = 0; i < this.l.size(); i++) {
            if (!((a) this.l.get(i)).a()) {
                ((a) this.l.get(i)).c();
            }
        }
    }

    protected void a(java.net.HttpURLConnection r20) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r19 = this;
        r9 = r19;
        r1 = r9.c;
        r10 = r1.toString();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r9.d;
        r1.append(r2);
        r2 = r9.g;
        r1.append(r2);
        r1 = r1.toString();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r1);
        r1 = ".tmp";
        r2.append(r1);
        r11 = r2.toString();
        r1 = r9.l;
        r1 = r1.size();
        r13 = 1;
        if (r1 != 0) goto L_0x01ef;
    L_0x0035:
        r1 = new java.io.File;
        r2 = r9.d;
        r1.<init>(r2);
        r2 = r1.exists();
        if (r2 != 0) goto L_0x0045;
    L_0x0042:
        r1.mkdirs();
    L_0x0045:
        r1 = 0;
        r2 = new java.io.File;
        r2.<init>(r11);
        r3 = r9.f;
        r3 = r3.booleanValue();
        if (r3 == 0) goto L_0x00fc;
    L_0x0053:
        r3 = r2.exists();
        if (r3 == 0) goto L_0x00fc;
    L_0x0059:
        r3 = r2.length();
        r5 = r9.h;
        r5 = (long) r5;
        r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r7 != 0) goto L_0x00fc;
    L_0x0064:
        r3 = new com.baidu.mobads.openad.b.g;	 Catch:{ Exception -> 0x00eb }
        r4 = r9.a;	 Catch:{ Exception -> 0x00eb }
        r3.<init>(r4);	 Catch:{ Exception -> 0x00eb }
        r9.m = r3;	 Catch:{ Exception -> 0x00eb }
        r3 = r9.m;	 Catch:{ Exception -> 0x00eb }
        r3 = r3.b(r10, r11);	 Catch:{ Exception -> 0x00eb }
        if (r3 == 0) goto L_0x00fc;	 Catch:{ Exception -> 0x00eb }
    L_0x0075:
        r4 = r3.size();	 Catch:{ Exception -> 0x00eb }
        if (r4 <= 0) goto L_0x00fc;	 Catch:{ Exception -> 0x00eb }
    L_0x007b:
        r4 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00eb }
        r4.<init>();	 Catch:{ Exception -> 0x00eb }
        r1 = new java.util.HashSet;	 Catch:{ Exception -> 0x00e9 }
        r1.<init>();	 Catch:{ Exception -> 0x00e9 }
        r3 = r3.iterator();	 Catch:{ Exception -> 0x00e9 }
    L_0x0089:
        r5 = r3.hasNext();	 Catch:{ Exception -> 0x00e9 }
        if (r5 == 0) goto L_0x00fb;	 Catch:{ Exception -> 0x00e9 }
    L_0x008f:
        r5 = r3.next();	 Catch:{ Exception -> 0x00e9 }
        r5 = (com.baidu.mobads.openad.b.h) r5;	 Catch:{ Exception -> 0x00e9 }
        r6 = r5.c();	 Catch:{ Exception -> 0x00e9 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00e9 }
        r6 = r1.contains(r6);	 Catch:{ Exception -> 0x00e9 }
        if (r6 != 0) goto L_0x0089;	 Catch:{ Exception -> 0x00e9 }
    L_0x00a3:
        r6 = r5.c();	 Catch:{ Exception -> 0x00e9 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00e9 }
        r1.add(r6);	 Catch:{ Exception -> 0x00e9 }
        r4.add(r5);	 Catch:{ Exception -> 0x00e9 }
        r6 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x00e9 }
        r6 = r6.getAdLogger();	 Catch:{ Exception -> 0x00e9 }
        r7 = "Downloader";	 Catch:{ Exception -> 0x00e9 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00e9 }
        r14 = "resume from db: start=";	 Catch:{ Exception -> 0x00e9 }
        r8.<init>(r14);	 Catch:{ Exception -> 0x00e9 }
        r14 = r5.d();	 Catch:{ Exception -> 0x00e9 }
        r8.append(r14);	 Catch:{ Exception -> 0x00e9 }
        r14 = ";end =";	 Catch:{ Exception -> 0x00e9 }
        r8.append(r14);	 Catch:{ Exception -> 0x00e9 }
        r14 = r5.e();	 Catch:{ Exception -> 0x00e9 }
        r8.append(r14);	 Catch:{ Exception -> 0x00e9 }
        r14 = ";complete=";	 Catch:{ Exception -> 0x00e9 }
        r8.append(r14);	 Catch:{ Exception -> 0x00e9 }
        r5 = r5.a();	 Catch:{ Exception -> 0x00e9 }
        r8.append(r5);	 Catch:{ Exception -> 0x00e9 }
        r5 = r8.toString();	 Catch:{ Exception -> 0x00e9 }
        r6.d(r7, r5);	 Catch:{ Exception -> 0x00e9 }
        goto L_0x0089;
    L_0x00e9:
        r0 = move-exception;
        goto L_0x00ed;
    L_0x00eb:
        r0 = move-exception;
        r4 = r1;
    L_0x00ed:
        r1 = r0;
        r3 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r3 = r3.getAdLogger();
        r5 = "Downloader";
        r3.d(r5, r1);
    L_0x00fb:
        r1 = r4;
    L_0x00fc:
        if (r1 == 0) goto L_0x0104;
    L_0x00fe:
        r3 = r1.size();
        if (r3 > 0) goto L_0x0192;
    L_0x0104:
        r1 = r2.exists();
        if (r1 == 0) goto L_0x010d;
    L_0x010a:
        r2.delete();
    L_0x010d:
        r2.createNewFile();	 Catch:{ Exception -> 0x01da }
        r1 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x01da }
        r3 = "rwd";	 Catch:{ Exception -> 0x01da }
        r1.<init>(r2, r3);	 Catch:{ Exception -> 0x01da }
        r2 = r9.h;	 Catch:{ Exception -> 0x01da }
        r2 = (long) r2;	 Catch:{ Exception -> 0x01da }
        r1.setLength(r2);	 Catch:{ Exception -> 0x01da }
        r1.close();	 Catch:{ Exception -> 0x01da }
        r1 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x01da }
        r1 = r1.getAdLogger();	 Catch:{ Exception -> 0x01da }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01da }
        r3 = "Downloader.init():  建立完random文件 ts:";	 Catch:{ Exception -> 0x01da }
        r2.<init>(r3);	 Catch:{ Exception -> 0x01da }
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01da }
        r2.append(r3);	 Catch:{ Exception -> 0x01da }
        r2 = r2.toString();	 Catch:{ Exception -> 0x01da }
        r1.d(r2);	 Catch:{ Exception -> 0x01da }
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = -1;
        r3 = r9.e;
        if (r3 <= r13) goto L_0x0182;
    L_0x0147:
        r3 = r9.h;
        r3 = (float) r3;
        r4 = r9.e;
        r4 = (float) r4;
        r3 = r3 / r4;
        r4 = 1204289536; // 0x47c80000 float:102400.0 double:5.949980874E-315;
        r3 = r3 / r4;
        r3 = java.lang.Math.round(r3);
        r4 = 102400; // 0x19000 float:1.43493E-40 double:5.05923E-319;
        r14 = r3 * r4;
        r3 = 0;
    L_0x015b:
        r4 = r9.h;
        if (r2 >= r4) goto L_0x0192;
    L_0x015f:
        r6 = r2 + 1;
        r2 = r2 + r14;
        r4 = r9.h;
        if (r2 >= r4) goto L_0x0168;
    L_0x0166:
        r15 = r2;
        goto L_0x016b;
    L_0x0168:
        r2 = r9.h;
        goto L_0x0166;
    L_0x016b:
        r16 = r3 + 1;
        r8 = new com.baidu.mobads.openad.b.h;
        r17 = 0;
        r2 = r8;
        r3 = r16;
        r4 = r10;
        r5 = r11;
        r7 = r15;
        r12 = r8;
        r8 = r17;
        r2.<init>(r3, r4, r5, r6, r7, r8);
        r1.add(r12);
        r2 = r15;
        goto L_0x015b;
    L_0x0182:
        r7 = r9.h;
        r12 = new com.baidu.mobads.openad.b.h;
        r3 = 1;
        r6 = 0;
        r8 = 0;
        r2 = r12;
        r4 = r10;
        r5 = r11;
        r2.<init>(r3, r4, r5, r6, r7, r8);
        r1.add(r12);
    L_0x0192:
        r12 = r1.iterator();
    L_0x0196:
        r1 = r12.hasNext();
        if (r1 == 0) goto L_0x01ef;
    L_0x019c:
        r1 = r12.next();
        r14 = r1;
        r14 = (com.baidu.mobads.openad.b.h) r14;
        r15 = new com.baidu.mobads.openad.b.a$a;
        r3 = r14.c();
        r4 = r9.c;
        r5 = r14.f();
        r6 = r14.d();
        r7 = r14.e();
        r8 = r14.a();
        r1 = r15;
        r2 = r9;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8);
        r1 = r14.d();
        if (r1 != 0) goto L_0x01d2;
    L_0x01c6:
        r1 = r14.a();
        if (r1 != 0) goto L_0x01d2;
    L_0x01cc:
        r1 = r20;
        r15.a(r1);
        goto L_0x01d4;
    L_0x01d2:
        r1 = r20;
    L_0x01d4:
        r2 = r9.l;
        r2.add(r15);
        goto L_0x0196;
    L_0x01da:
        r1 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r1 = r1.getAdLogger();
        r2 = "Downloader";
        r3 = " 建立文件失败:";
        r1.d(r2, r3);
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;
        r9.a(r1);
        return;
    L_0x01ef:
        r1 = r9.f;
        r1 = r1.booleanValue();
        if (r1 == 0) goto L_0x020f;
    L_0x01f7:
        r1 = 0;
        r12 = 0;
    L_0x01f9:
        r2 = r9.l;
        r2 = r2.size();
        if (r1 >= r2) goto L_0x0210;
    L_0x0201:
        r2 = r9.l;
        r2 = r2.get(r1);
        r2 = (com.baidu.mobads.openad.b.a.a) r2;
        r2 = r2.f;
        r12 = r12 + r2;
        r1 = r1 + 1;
        goto L_0x01f9;
    L_0x020f:
        r12 = 0;
    L_0x0210:
        r9.j = r12;
        r1 = r19.getProgress();
        r1 = (int) r1;
        r9.k = r1;
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.DOWNLOADING;
        r9.a(r1);
        r1 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r1 = r1.getAdLogger();
        r2 = "Downloader";
        r3 = "Downloader starts unfinished threads and waits threads end";
        r1.d(r2, r3);
        r1 = 0;
    L_0x022e:
        r2 = r9.l;
        r2 = r2.size();
        if (r1 >= r2) goto L_0x0252;
    L_0x0236:
        r2 = r9.l;
        r2 = r2.get(r1);
        r2 = (com.baidu.mobads.openad.b.a.a) r2;
        r2 = r2.a();
        if (r2 != 0) goto L_0x024f;
    L_0x0244:
        r2 = r9.l;
        r2 = r2.get(r1);
        r2 = (com.baidu.mobads.openad.b.a.a) r2;
        r2.b();
    L_0x024f:
        r1 = r1 + 1;
        goto L_0x022e;
    L_0x0252:
        r1 = 0;
    L_0x0253:
        r2 = r9.l;
        r2 = r2.size();
        if (r1 >= r2) goto L_0x0277;
    L_0x025b:
        r2 = r9.l;
        r2 = r2.get(r1);
        r2 = (com.baidu.mobads.openad.b.a.a) r2;
        r2 = r2.a();
        if (r2 != 0) goto L_0x0274;
    L_0x0269:
        r2 = r9.l;
        r2 = r2.get(r1);
        r2 = (com.baidu.mobads.openad.b.a.a) r2;
        r2.d();
    L_0x0274:
        r1 = r1 + 1;
        goto L_0x0253;
    L_0x0277:
        r1 = r9.i;
        r2 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.DOWNLOADING;
        if (r1 != r2) goto L_0x02ac;
    L_0x027d:
        r1 = 0;
    L_0x027e:
        r2 = r9.l;
        r2 = r2.size();
        if (r1 >= r2) goto L_0x0298;
    L_0x0286:
        r2 = r9.l;
        r2 = r2.get(r1);
        r2 = (com.baidu.mobads.openad.b.a.a) r2;
        r2 = r2.a();
        if (r2 != 0) goto L_0x0295;
    L_0x0294:
        goto L_0x0299;
    L_0x0295:
        r1 = r1 + 1;
        goto L_0x027e;
    L_0x0298:
        r13 = 0;
    L_0x0299:
        if (r13 == 0) goto L_0x02a1;
    L_0x029b:
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;
        r9.a(r1);
        goto L_0x02e3;
    L_0x02a1:
        r1 = r9.l;
        r9.a(r1);
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.COMPLETED;
        r9.a(r1);
        goto L_0x02e3;
    L_0x02ac:
        r1 = r9.i;
        r2 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;
        if (r1 != r2) goto L_0x02b8;
    L_0x02b2:
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;
        r9.a(r1);
        goto L_0x02e3;
    L_0x02b8:
        r1 = r9.i;
        r2 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.CANCELLED;
        if (r1 != r2) goto L_0x02ce;
    L_0x02be:
        r1 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r1 = r1.getAdLogger();
        r2 = "Downloader";
        r3 = "Downloader is cancelled";
        r1.d(r2, r3);
        goto L_0x02e3;
    L_0x02ce:
        r1 = r9.i;
        r2 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.PAUSED;
        if (r1 != r2) goto L_0x02e3;
    L_0x02d4:
        r1 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r1 = r1.getAdLogger();
        r2 = "Downloader";
        r3 = "Downloader is paused";
        r1.d(r2, r3);
    L_0x02e3:
        r1 = r9.i;
        r2 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.COMPLETED;
        if (r1 == r2) goto L_0x038d;
    L_0x02e9:
        r1 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r1 = r1.getAdLogger();
        r2 = "Downloader";
        r3 = "save database now";
        r1.d(r2, r3);
        r1 = r9.f;
        r1 = r1.booleanValue();
        if (r1 == 0) goto L_0x038d;
    L_0x0300:
        r1 = r9.m;	 Catch:{ Exception -> 0x037e }
        if (r1 != 0) goto L_0x030d;	 Catch:{ Exception -> 0x037e }
    L_0x0304:
        r1 = new com.baidu.mobads.openad.b.g;	 Catch:{ Exception -> 0x037e }
        r2 = r9.a;	 Catch:{ Exception -> 0x037e }
        r1.<init>(r2);	 Catch:{ Exception -> 0x037e }
        r9.m = r1;	 Catch:{ Exception -> 0x037e }
    L_0x030d:
        r1 = new java.util.ArrayList;	 Catch:{ Exception -> 0x037e }
        r1.<init>();	 Catch:{ Exception -> 0x037e }
        r2 = r9.l;	 Catch:{ Exception -> 0x037e }
        r12 = r2.iterator();	 Catch:{ Exception -> 0x037e }
    L_0x0318:
        r2 = r12.hasNext();	 Catch:{ Exception -> 0x037e }
        if (r2 == 0) goto L_0x036a;	 Catch:{ Exception -> 0x037e }
    L_0x031e:
        r2 = r12.next();	 Catch:{ Exception -> 0x037e }
        r13 = r2;	 Catch:{ Exception -> 0x037e }
        r13 = (com.baidu.mobads.openad.b.a.a) r13;	 Catch:{ Exception -> 0x037e }
        r14 = new com.baidu.mobads.openad.b.h;	 Catch:{ Exception -> 0x037e }
        r3 = r13.a;	 Catch:{ Exception -> 0x037e }
        r6 = r13.d;	 Catch:{ Exception -> 0x037e }
        r7 = r13.e;	 Catch:{ Exception -> 0x037e }
        r8 = r13.f;	 Catch:{ Exception -> 0x037e }
        r2 = r14;	 Catch:{ Exception -> 0x037e }
        r4 = r10;	 Catch:{ Exception -> 0x037e }
        r5 = r11;	 Catch:{ Exception -> 0x037e }
        r2.<init>(r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x037e }
        r1.add(r14);	 Catch:{ Exception -> 0x037e }
        r2 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x037e }
        r2 = r2.getAdLogger();	 Catch:{ Exception -> 0x037e }
        r3 = "Downloader";	 Catch:{ Exception -> 0x037e }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x037e }
        r5 = "save to db: start=";	 Catch:{ Exception -> 0x037e }
        r4.<init>(r5);	 Catch:{ Exception -> 0x037e }
        r5 = r13.d;	 Catch:{ Exception -> 0x037e }
        r4.append(r5);	 Catch:{ Exception -> 0x037e }
        r5 = ";end =";	 Catch:{ Exception -> 0x037e }
        r4.append(r5);	 Catch:{ Exception -> 0x037e }
        r5 = r13.e;	 Catch:{ Exception -> 0x037e }
        r4.append(r5);	 Catch:{ Exception -> 0x037e }
        r5 = ";complete=";	 Catch:{ Exception -> 0x037e }
        r4.append(r5);	 Catch:{ Exception -> 0x037e }
        r5 = r13.f;	 Catch:{ Exception -> 0x037e }
        r4.append(r5);	 Catch:{ Exception -> 0x037e }
        r4 = r4.toString();	 Catch:{ Exception -> 0x037e }
        r2.d(r3, r4);	 Catch:{ Exception -> 0x037e }
        goto L_0x0318;	 Catch:{ Exception -> 0x037e }
    L_0x036a:
        r2 = r9.m;	 Catch:{ Exception -> 0x037e }
        r2 = r2.a(r10, r11);	 Catch:{ Exception -> 0x037e }
        if (r2 == 0) goto L_0x0378;	 Catch:{ Exception -> 0x037e }
    L_0x0372:
        r2 = r9.m;	 Catch:{ Exception -> 0x037e }
        r2.b(r1);	 Catch:{ Exception -> 0x037e }
        return;	 Catch:{ Exception -> 0x037e }
    L_0x0378:
        r2 = r9.m;	 Catch:{ Exception -> 0x037e }
        r2.a(r1);	 Catch:{ Exception -> 0x037e }
        return;
    L_0x037e:
        r0 = move-exception;
        r1 = r0;
        r2 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r2 = r2.getAdLogger();
        r3 = "Downloader";
        r2.d(r3, r1);
    L_0x038d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.openad.b.a.a(java.net.HttpURLConnection):void");
    }

    public void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = r10.c;
        r1 = 0;
        if (r0 == 0) goto L_0x0022;
    L_0x0005:
        r0 = r10.h;
        if (r0 > 0) goto L_0x000a;
    L_0x0009:
        goto L_0x0022;
    L_0x000a:
        r10.a(r1);	 Catch:{ Exception -> 0x000e }
        return;
    L_0x000e:
        r0 = move-exception;
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;
        r10.a(r1);
        r1 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r1 = r1.getAdLogger();
        r2 = "Downloader";
        r1.d(r2, r0);
        return;
    L_0x0022:
        r0 = 2;
        r2 = 0;
        r3 = 1;
        r4 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x01e1 }
        r4 = r4.getURIUitls();	 Catch:{ Exception -> 0x01e1 }
        r5 = r10.b;	 Catch:{ Exception -> 0x01e1 }
        r4 = r4.getHttpURLConnection(r5);	 Catch:{ Exception -> 0x01e1 }
        r1 = "Range";	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r5 = "bytes=0-";	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r4.setRequestProperty(r1, r5);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r4.setConnectTimeout(r1);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r4.setInstanceFollowRedirects(r3);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r4.connect();	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r1 = r4.getResponseCode();	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r5 = 302; // 0x12e float:4.23E-43 double:1.49E-321;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        if (r1 == r5) goto L_0x0051;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
    L_0x004d:
        r5 = 301; // 0x12d float:4.22E-43 double:1.487E-321;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        if (r1 != r5) goto L_0x005f;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
    L_0x0051:
        r4.setInstanceFollowRedirects(r2);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r1 = r10.b(r4);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r4 = r1.getResponseCode();	 Catch:{ Exception -> 0x01e1 }
        r9 = r4;
        r4 = r1;
        r1 = r9;
    L_0x005f:
        r1 = r1 / 100;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        if (r1 == r0) goto L_0x0087;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
    L_0x0063:
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r10.a(r1);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        if (r4 == 0) goto L_0x0086;
    L_0x006a:
        r4.disconnect();	 Catch:{ Exception -> 0x006e }
        goto L_0x0086;
    L_0x006e:
        r1 = move-exception;
        r4 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r4 = r4.getAdLogger();
        r0 = new java.lang.Object[r0];
        r5 = "Downloader";
        r0[r2] = r5;
        r1 = r1.getMessage();
        r0[r3] = r1;
        r4.w(r0);
    L_0x0086:
        return;
    L_0x0087:
        r1 = r4.getContentType();	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r5 = "text/html";	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r1 = r1.equals(r5);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        if (r1 == 0) goto L_0x00b7;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
    L_0x0093:
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r10.a(r1);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        if (r4 == 0) goto L_0x00b6;
    L_0x009a:
        r4.disconnect();	 Catch:{ Exception -> 0x009e }
        goto L_0x00b6;
    L_0x009e:
        r1 = move-exception;
        r4 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r4 = r4.getAdLogger();
        r0 = new java.lang.Object[r0];
        r5 = "Downloader";
        r0[r2] = r5;
        r1 = r1.getMessage();
        r0[r3] = r1;
        r4.w(r0);
    L_0x00b6:
        return;
    L_0x00b7:
        r1 = r4.getContentLength();	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        if (r1 > 0) goto L_0x00e1;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
    L_0x00bd:
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r10.a(r1);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        if (r4 == 0) goto L_0x00e0;
    L_0x00c4:
        r4.disconnect();	 Catch:{ Exception -> 0x00c8 }
        goto L_0x00e0;
    L_0x00c8:
        r1 = move-exception;
        r4 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r4 = r4.getAdLogger();
        r0 = new java.lang.Object[r0];
        r5 = "Downloader";
        r0[r2] = r5;
        r1 = r1.getMessage();
        r0[r3] = r1;
        r4.w(r0);
    L_0x00e0:
        return;
    L_0x00e1:
        r5 = 5120000; // 0x4e2000 float:7.174648E-39 double:2.529616E-317;
        if (r1 >= r5) goto L_0x00e8;
    L_0x00e6:
        r10.e = r3;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
    L_0x00e8:
        r5 = r4.getURL();	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r10.c = r5;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r5 = "mounted";	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r6 = android.os.Environment.getExternalStorageState();	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r5 = r5.equals(r6);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        if (r5 != 0) goto L_0x011e;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
    L_0x00fa:
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r10.a(r1);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        if (r4 == 0) goto L_0x011d;
    L_0x0101:
        r4.disconnect();	 Catch:{ Exception -> 0x0105 }
        goto L_0x011d;
    L_0x0105:
        r1 = move-exception;
        r4 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r4 = r4.getAdLogger();
        r0 = new java.lang.Object[r0];
        r5 = "Downloader";
        r0[r2] = r5;
        r1 = r1.getMessage();
        r0[r3] = r1;
        r4.w(r0);
    L_0x011d:
        return;
    L_0x011e:
        r5 = r10.a;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r5 = com.baidu.mobads.utils.k.a(r5);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r6.<init>();	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r7 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r7 = r7.getCommonUtils();	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r8 = r10.c;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r7 = r7.md5(r8);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r6.append(r7);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r7 = ".apk";	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r6.append(r7);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r10.d = r5;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r10.g = r6;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r7.<init>();	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r7.append(r5);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r7.append(r6);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r5 = r7.toString();	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r6 = new java.io.File;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r6.<init>(r5);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r5 = r6.exists();	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        if (r5 == 0) goto L_0x0189;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
    L_0x0165:
        r1 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.COMPLETED;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r10.a(r1);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        if (r4 == 0) goto L_0x0188;
    L_0x016c:
        r4.disconnect();	 Catch:{ Exception -> 0x0170 }
        goto L_0x0188;
    L_0x0170:
        r1 = move-exception;
        r4 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r4 = r4.getAdLogger();
        r0 = new java.lang.Object[r0];
        r5 = "Downloader";
        r0[r2] = r5;
        r1 = r1.getMessage();
        r0[r3] = r1;
        r4.w(r0);
    L_0x0188:
        return;
    L_0x0189:
        r5 = "Content-Range";	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r5 = r4.getHeaderField(r5);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        if (r5 != 0) goto L_0x01af;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
    L_0x0191:
        r5 = "Accept-Ranges";	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r5 = r4.getHeaderField(r5);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        if (r5 == 0) goto L_0x01a7;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
    L_0x0199:
        r5 = "Accept-Ranges";	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r5 = r4.getHeaderField(r5);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r6 = "none";	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r5 = r5.equalsIgnoreCase(r6);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        if (r5 == 0) goto L_0x01af;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
    L_0x01a7:
        r5 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r10.f = r5;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r10.e = r3;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
    L_0x01af:
        r5 = r10.h;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        r6 = -1;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        if (r5 != r6) goto L_0x01b6;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
    L_0x01b4:
        r10.h = r1;	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
    L_0x01b6:
        r10.a(r4);	 Catch:{ Exception -> 0x01da, all -> 0x01d8 }
        if (r4 == 0) goto L_0x01d7;
    L_0x01bb:
        r4.disconnect();	 Catch:{ Exception -> 0x01bf }
        goto L_0x01d7;
    L_0x01bf:
        r1 = move-exception;
        r4 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r4 = r4.getAdLogger();
        r0 = new java.lang.Object[r0];
        r5 = "Downloader";
        r0[r2] = r5;
        r1 = r1.getMessage();
        r0[r3] = r1;
        r4.w(r0);
    L_0x01d7:
        return;
    L_0x01d8:
        r1 = move-exception;
        goto L_0x0205;
    L_0x01da:
        r1 = r4;
        goto L_0x01e1;
    L_0x01dc:
        r4 = move-exception;
        r9 = r4;
        r4 = r1;
        r1 = r9;
        goto L_0x0205;
    L_0x01e1:
        r4 = com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus.ERROR;	 Catch:{ all -> 0x01dc }
        r10.a(r4);	 Catch:{ all -> 0x01dc }
        if (r1 == 0) goto L_0x0204;
    L_0x01e8:
        r1.disconnect();	 Catch:{ Exception -> 0x01ec }
        goto L_0x0204;
    L_0x01ec:
        r1 = move-exception;
        r4 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r4 = r4.getAdLogger();
        r0 = new java.lang.Object[r0];
        r5 = "Downloader";
        r0[r2] = r5;
        r1 = r1.getMessage();
        r0[r3] = r1;
        r4.w(r0);
    L_0x0204:
        return;
    L_0x0205:
        if (r4 == 0) goto L_0x0223;
    L_0x0207:
        r4.disconnect();	 Catch:{ Exception -> 0x020b }
        goto L_0x0223;
    L_0x020b:
        r4 = move-exception;
        r5 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r5 = r5.getAdLogger();
        r0 = new java.lang.Object[r0];
        r6 = "Downloader";
        r0[r2] = r6;
        r2 = r4.getMessage();
        r0[r3] = r2;
        r5.w(r0);
    L_0x0223:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.openad.b.a.run():void");
    }

    protected void a(ArrayList<a> arrayList) {
        arrayList = XAdSDKFoundationFacade.getInstance().getIoUtils();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d);
        stringBuilder.append(this.g);
        stringBuilder.append(".tmp");
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(this.d);
        stringBuilder3.append(this.g);
        arrayList.renameFile(stringBuilder2, stringBuilder3.toString());
    }

    private HttpURLConnection b(HttpURLConnection httpURLConnection) {
        Exception exception;
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    break;
                }
                this.b = new URL(httpURLConnection.getHeaderField("Location"));
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) this.b.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setInstanceFollowRedirects(null);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (HttpURLConnection httpURLConnection3) {
                    HttpURLConnection httpURLConnection4 = httpURLConnection2;
                    exception = httpURLConnection3;
                    httpURLConnection3 = httpURLConnection4;
                }
            } catch (Exception e) {
                exception = e;
            }
        }
        return httpURLConnection3;
        exception.printStackTrace();
        return httpURLConnection3;
    }

    public void removeObservers() {
        deleteObservers();
    }

    public String getTargetURL() {
        if (this.c == null) {
            return null;
        }
        return this.c.toString();
    }
}
