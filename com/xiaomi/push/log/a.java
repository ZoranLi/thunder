package com.xiaomi.push.log;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.az;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class a {
    private static String b = "/MiPushLog";
    @SuppressLint({"SimpleDateFormat"})
    private final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String c;
    private String d;
    private boolean e;
    private int f;
    private int g = 2097152;
    private ArrayList<File> h = new ArrayList();

    a() {
    }

    private void a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        int i = 0;
        while (read != -1 && r3 != 1) {
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i2 = 0;
            int i3 = i2;
            while (i2 < read && matcher.find(i2)) {
                i2 = matcher.start();
                String substring = str.substring(i2, this.c.length() + i2);
                if (this.e) {
                    if (substring.compareTo(this.d) > 0) {
                        i = true;
                        read = i2;
                        break;
                    }
                } else if (substring.compareTo(this.c) >= 0) {
                    this.e = true;
                    i3 = i2;
                }
                int indexOf = str.indexOf(10, i2);
                if (indexOf == -1) {
                    indexOf = this.c.length();
                }
                i2 += indexOf;
            }
            if (this.e) {
                read -= i3;
                this.f += read;
                if (i == 0) {
                    bufferedWriter.write(cArr, i3, read);
                    if (this.f > this.g) {
                        break;
                    }
                } else {
                    bufferedWriter.write(cArr, i3, read);
                    return;
                }
            }
            read = bufferedReader.read(cArr);
        }
    }

    private void b(File file) {
        FileNotFoundException e;
        IOException e2;
        Throwable th;
        Writer writer;
        StringBuilder stringBuilder;
        Pattern compile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        Reader reader = null;
        Writer bufferedWriter;
        Reader bufferedReader;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            try {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("model :");
                stringBuilder2.append(Build.MODEL);
                stringBuilder2.append("; os :");
                stringBuilder2.append(VERSION.INCREMENTAL);
                stringBuilder2.append("; uid :");
                stringBuilder2.append(az.e());
                stringBuilder2.append("; lng :");
                stringBuilder2.append(Locale.getDefault().toString());
                stringBuilder2.append("; sdk :31");
                stringBuilder2.append("; andver :");
                stringBuilder2.append(VERSION.SDK_INT);
                stringBuilder2.append("\n");
                bufferedWriter.write(stringBuilder2.toString());
                this.f = 0;
                Iterator it = this.h.iterator();
                while (it.hasNext()) {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream((File) it.next())));
                    try {
                        a(bufferedReader, bufferedWriter, compile);
                        bufferedReader.close();
                        reader = bufferedReader;
                    } catch (FileNotFoundException e3) {
                        e = e3;
                    } catch (IOException e4) {
                        e2 = e4;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                com.xiaomi.channel.commonutils.file.a.a(bufferedWriter);
                com.xiaomi.channel.commonutils.file.a.a(reader);
            } catch (FileNotFoundException e5) {
                e = e5;
                bufferedReader = null;
                writer = bufferedWriter;
                stringBuilder = new StringBuilder("LOG: filter error = ");
                stringBuilder.append(e.getMessage());
                b.c(stringBuilder.toString());
                com.xiaomi.channel.commonutils.file.a.a(writer);
                com.xiaomi.channel.commonutils.file.a.a(bufferedReader);
            } catch (IOException e6) {
                e2 = e6;
                bufferedReader = null;
                writer = bufferedWriter;
                try {
                    stringBuilder = new StringBuilder("LOG: filter error = ");
                    stringBuilder.append(e2.getMessage());
                    b.c(stringBuilder.toString());
                    com.xiaomi.channel.commonutils.file.a.a(writer);
                    com.xiaomi.channel.commonutils.file.a.a(bufferedReader);
                } catch (Throwable th3) {
                    th = th3;
                    bufferedWriter = writer;
                    reader = bufferedReader;
                    com.xiaomi.channel.commonutils.file.a.a(bufferedWriter);
                    com.xiaomi.channel.commonutils.file.a.a(reader);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                com.xiaomi.channel.commonutils.file.a.a(bufferedWriter);
                com.xiaomi.channel.commonutils.file.a.a(reader);
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            bufferedReader = null;
            stringBuilder = new StringBuilder("LOG: filter error = ");
            stringBuilder.append(e.getMessage());
            b.c(stringBuilder.toString());
            com.xiaomi.channel.commonutils.file.a.a(writer);
            com.xiaomi.channel.commonutils.file.a.a(bufferedReader);
        } catch (IOException e8) {
            e2 = e8;
            bufferedReader = null;
            stringBuilder = new StringBuilder("LOG: filter error = ");
            stringBuilder.append(e2.getMessage());
            b.c(stringBuilder.toString());
            com.xiaomi.channel.commonutils.file.a.a(writer);
            com.xiaomi.channel.commonutils.file.a.a(bufferedReader);
        } catch (Throwable th5) {
            th = th5;
            bufferedWriter = null;
            com.xiaomi.channel.commonutils.file.a.a(bufferedWriter);
            com.xiaomi.channel.commonutils.file.a.a(reader);
            throw th;
        }
    }

    a a(File file) {
        if (file.exists()) {
            this.h.add(file);
        }
        return this;
    }

    com.xiaomi.push.log.a a(java.util.Date r2, java.util.Date r3) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:6:0x0026 in {2, 4, 5} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = this;
        r0 = r2.after(r3);
        if (r0 == 0) goto L_0x0017;
    L_0x0006:
        r0 = r1.a;
        r3 = r0.format(r3);
        r1.c = r3;
        r3 = r1.a;
        r2 = r3.format(r2);
    L_0x0014:
        r1.d = r2;
        return r1;
    L_0x0017:
        r0 = r1.a;
        r2 = r0.format(r2);
        r1.c = r2;
        r2 = r1.a;
        r2 = r2.format(r3);
        goto L_0x0014;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.log.a.a(java.util.Date, java.util.Date):com.xiaomi.push.log.a");
    }

    File a(Context context, Date date, Date date2, File file) {
        File filesDir;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            filesDir = context.getFilesDir();
            a(new File(filesDir, "xmsf.log.1"));
            a(new File(filesDir, "xmsf.log"));
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getExternalFilesDir(null));
            stringBuilder.append(b);
            File file2 = new File(stringBuilder.toString());
            a(new File(file2, "log0.txt"));
            a(new File(file2, "log1.txt"));
            filesDir = file2;
        }
        if (!filesDir.isDirectory()) {
            return null;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(date.getTime());
        stringBuilder2.append("-");
        stringBuilder2.append(date2.getTime());
        stringBuilder2.append(".zip");
        filesDir = new File(file, stringBuilder2.toString());
        if (filesDir.exists()) {
            return null;
        }
        a(date, date2);
        long currentTimeMillis = System.currentTimeMillis();
        file2 = new File(file, "log.txt");
        b(file2);
        StringBuilder stringBuilder3 = new StringBuilder("LOG: filter cost = ");
        stringBuilder3.append(System.currentTimeMillis() - currentTimeMillis);
        b.c(stringBuilder3.toString());
        if (file2.exists()) {
            currentTimeMillis = System.currentTimeMillis();
            com.xiaomi.channel.commonutils.file.a.a(filesDir, file2);
            stringBuilder3 = new StringBuilder("LOG: zip cost = ");
            stringBuilder3.append(System.currentTimeMillis() - currentTimeMillis);
            b.c(stringBuilder3.toString());
            file2.delete();
            if (filesDir.exists()) {
                return filesDir;
            }
        }
        return null;
    }

    void a(int i) {
        if (i != 0) {
            this.g = i;
        }
    }
}
