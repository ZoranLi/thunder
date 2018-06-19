package com.xunlei.downloadlib.proguard;

import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import com.umeng.message.proguard.k;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: XLLog */
public final class e {
    private static final SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    private final c a;
    private File c;
    private int d;
    private int e;
    private final Handler f;

    public e(c cVar) {
        this.a = cVar;
        cVar = new HandlerThread("DownloadLib-XLLog");
        cVar.start();
        this.f = new Handler(cVar.getLooper());
    }

    public final void a(final d dVar, final String str, String str2) {
        str2 = b(dVar, str, str2);
        if (dVar.a() >= this.a.c.a() && this.a.a()) {
            this.f.post(new Runnable(this) {
                final /* synthetic */ e d;

                public void run() {
                    this.d.c(dVar, str, str2);
                }
            });
        }
    }

    public final void a(final Throwable th) {
        this.f.post(new Runnable(this) {
            final /* synthetic */ e b;

            public void run() {
                try {
                    Writer fileWriter = new FileWriter(this.b.a(), true);
                    Writer bufferedWriter = new BufferedWriter(fileWriter);
                    th.printStackTrace(new PrintWriter(bufferedWriter));
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static String b(d dVar, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(b.format(new Date()));
        stringBuilder2.append(": ");
        stringBuilder2.append(dVar.toString());
        stringBuilder.append(stringBuilder2.toString());
        dVar = new StringBuilder("/");
        dVar.append(str);
        dVar.append(k.s);
        dVar.append(Thread.currentThread().getId());
        dVar.append("):\t");
        stringBuilder.append(dVar.toString());
        stringBuilder.append(str2);
        stringBuilder.append("\r\n");
        return stringBuilder.toString();
    }

    private void c(com.xunlei.downloadlib.proguard.d r2, java.lang.String r3, java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r2 = new java.io.FileWriter;	 Catch:{ Exception -> 0x001c }
        r3 = r1.a();	 Catch:{ Exception -> 0x001c }
        r0 = 1;	 Catch:{ Exception -> 0x001c }
        r2.<init>(r3, r0);	 Catch:{ Exception -> 0x001c }
        r3 = new java.io.BufferedWriter;	 Catch:{ Exception -> 0x001c }
        r3.<init>(r2);	 Catch:{ Exception -> 0x001c }
        r3.write(r4);	 Catch:{ Exception -> 0x001c }
        r3.newLine();	 Catch:{ Exception -> 0x001c }
        r3.close();	 Catch:{ Exception -> 0x001c }
        r2.close();	 Catch:{ Exception -> 0x001c }
        return;
    L_0x001c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadlib.proguard.e.c(com.xunlei.downloadlib.proguard.d, java.lang.String, java.lang.String):void");
    }

    private File a() {
        if ("mounted".equalsIgnoreCase(Environment.getExternalStorageState())) {
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(Environment.getExternalStorageDirectory().getPath());
            stringBuilder2.append(File.separator);
            stringBuilder2.append(this.a.a);
            File file = new File(stringBuilder2.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            while (this.c == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(file.getPath());
                stringBuilder.append(File.separator);
                stringBuilder.append(new SimpleDateFormat("yyyyMMdd").format(new Date()));
                stringBuilder.append(".R");
                stringBuilder.append(this.e);
                stringBuilder.append(".0.");
                stringBuilder.append(this.a.b);
                this.c = new File(stringBuilder.toString());
                if (!this.c.exists()) {
                    break;
                }
                this.e++;
                this.c = null;
            }
            if (b() >= this.a.d) {
                this.d++;
                stringBuilder = new StringBuilder();
                stringBuilder.append(file.getPath());
                stringBuilder.append(File.separator);
                stringBuilder.append(new SimpleDateFormat("yyyyMMdd").format(new Date()));
                stringBuilder.append(".R");
                stringBuilder.append(this.e);
                stringBuilder.append(".");
                stringBuilder.append(this.d);
                stringBuilder.append(".");
                stringBuilder.append(this.a.b);
                this.c = new File(stringBuilder.toString());
                this.c.delete();
            }
        }
        return this.c;
    }

    private long b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.c;
        r1 = -1;
        if (r0 == 0) goto L_0x0015;
    L_0x0006:
        r0 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0015 }
        r3 = r4.c;	 Catch:{ Exception -> 0x0015 }
        r0.<init>(r3);	 Catch:{ Exception -> 0x0015 }
        r3 = r0.available();	 Catch:{ Exception -> 0x0015 }
        r1 = (long) r3;	 Catch:{ Exception -> 0x0015 }
        r0.close();	 Catch:{ Exception -> 0x0015 }
    L_0x0015:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadlib.proguard.e.b():long");
    }
}
