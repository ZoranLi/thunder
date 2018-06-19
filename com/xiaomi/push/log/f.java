package com.xiaomi.push.log;

import android.content.Context;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.channel.commonutils.misc.j;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class f implements LoggerInterface {
    private static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");
    private static j b = new j(true);
    private static String c = "/MiPushLog";
    private static List<Pair<String, Throwable>> f = Collections.synchronizedList(new ArrayList());
    private String d;
    private Context e;

    public f(Context context) {
        this.e = context;
        if (context.getApplicationContext() != null) {
            this.e = context.getApplicationContext();
        }
        this.d = this.e.getPackageName();
    }

    private void b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        r2.<init>();	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        r3 = r10.e;	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        r3 = r3.getExternalFilesDir(r0);	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        r2.append(r3);	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        r3 = c;	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        r2.append(r3);	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        r2 = r1.exists();	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        if (r2 == 0) goto L_0x0029;	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
    L_0x0023:
        r2 = r1.isDirectory();	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        if (r2 != 0) goto L_0x0030;	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
    L_0x0029:
        r2 = r1.mkdirs();	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        if (r2 != 0) goto L_0x0030;	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
    L_0x002f:
        return;	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
    L_0x0030:
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        r3 = "log.lock";	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        r2.<init>(r1, r3);	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        r3 = r2.exists();	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        if (r3 == 0) goto L_0x0043;	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
    L_0x003d:
        r3 = r2.isDirectory();	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        if (r3 == 0) goto L_0x0046;	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
    L_0x0043:
        r2.createNewFile();	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
    L_0x0046:
        r3 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        r4 = "rw";	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        r3.<init>(r2, r4);	 Catch:{ Exception -> 0x0129, all -> 0x0110 }
        r2 = r3.getChannel();	 Catch:{ Exception -> 0x010e, all -> 0x010b }
        r2 = r2.lock();	 Catch:{ Exception -> 0x010e, all -> 0x010b }
        r4 = new java.io.BufferedWriter;	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        r5 = new java.io.OutputStreamWriter;	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        r6 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        r8 = "log1.txt";	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        r7.<init>(r1, r8);	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        r8 = 1;	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        r6.<init>(r7, r8);	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        r4.<init>(r5);	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
    L_0x006c:
        r5 = f;	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r5 = r5.isEmpty();	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        if (r5 != 0) goto L_0x00c2;	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
    L_0x0074:
        r5 = f;	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r6 = 0;	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r5 = r5.remove(r6);	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r5 = (android.util.Pair) r5;	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r6 = r5.first;	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r6 = (java.lang.String) r6;	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r7 = r5.second;	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        if (r7 == 0) goto L_0x00ad;	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
    L_0x0085:
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r7.<init>();	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r7.append(r6);	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r6 = "\n";	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r7.append(r6);	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r6 = r7.toString();	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r7.<init>();	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r7.append(r6);	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r5 = r5.second;	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r5 = (java.lang.Throwable) r5;	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r5 = android.util.Log.getStackTraceString(r5);	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r7.append(r5);	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r6 = r7.toString();	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
    L_0x00ad:
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r5.<init>();	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r5.append(r6);	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r6 = "\n";	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r5.append(r6);	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r4.write(r5);	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        goto L_0x006c;	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
    L_0x00c2:
        r4.flush();	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r4.close();	 Catch:{ Exception -> 0x0107, all -> 0x0104 }
        r4 = new java.io.File;	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        r5 = "log1.txt";	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        r4.<init>(r1, r5);	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        r5 = r4.length();	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        r7 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        if (r9 < 0) goto L_0x00f3;	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
    L_0x00da:
        r5 = new java.io.File;	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        r6 = "log0.txt";	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        r5.<init>(r1, r6);	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        r1 = r5.exists();	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        if (r1 == 0) goto L_0x00f0;	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
    L_0x00e7:
        r1 = r5.isFile();	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
        if (r1 == 0) goto L_0x00f0;	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
    L_0x00ed:
        r5.delete();	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
    L_0x00f0:
        r4.renameTo(r5);	 Catch:{ Exception -> 0x012b, all -> 0x0109 }
    L_0x00f3:
        if (r2 == 0) goto L_0x00fe;
    L_0x00f5:
        r0 = r2.isValid();
        if (r0 == 0) goto L_0x00fe;
    L_0x00fb:
        r2.release();	 Catch:{ IOException -> 0x00fe }
    L_0x00fe:
        if (r3 == 0) goto L_0x0103;
    L_0x0100:
        r3.close();	 Catch:{ IOException -> 0x0103 }
    L_0x0103:
        return;
    L_0x0104:
        r1 = move-exception;
        r0 = r4;
        goto L_0x0113;
    L_0x0107:
        r0 = r4;
        goto L_0x012b;
    L_0x0109:
        r1 = move-exception;
        goto L_0x0113;
    L_0x010b:
        r1 = move-exception;
        r2 = r0;
        goto L_0x0113;
    L_0x010e:
        r2 = r0;
        goto L_0x012b;
    L_0x0110:
        r1 = move-exception;
        r2 = r0;
        r3 = r2;
    L_0x0113:
        if (r0 == 0) goto L_0x0118;
    L_0x0115:
        r0.close();	 Catch:{ IOException -> 0x0118 }
    L_0x0118:
        if (r2 == 0) goto L_0x0123;
    L_0x011a:
        r0 = r2.isValid();
        if (r0 == 0) goto L_0x0123;
    L_0x0120:
        r2.release();	 Catch:{ IOException -> 0x0123 }
    L_0x0123:
        if (r3 == 0) goto L_0x0128;
    L_0x0125:
        r3.close();	 Catch:{ IOException -> 0x0128 }
    L_0x0128:
        throw r1;
    L_0x0129:
        r2 = r0;
        r3 = r2;
    L_0x012b:
        if (r0 == 0) goto L_0x0130;
    L_0x012d:
        r0.close();	 Catch:{ IOException -> 0x0130 }
    L_0x0130:
        if (r2 == 0) goto L_0x013b;
    L_0x0132:
        r0 = r2.isValid();
        if (r0 == 0) goto L_0x013b;
    L_0x0138:
        r2.release();	 Catch:{ IOException -> 0x013b }
    L_0x013b:
        if (r3 == 0) goto L_0x0140;
    L_0x013d:
        r3.close();	 Catch:{ IOException -> 0x0140 }
    L_0x0140:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.log.f.b():void");
    }

    public final void log(String str) {
        log(str, null);
    }

    public final void log(String str, Throwable th) {
        f.add(new Pair(String.format("%1$s %2$s %3$s ", new Object[]{a.format(new Date()), this.d, str}), th));
        b.a(new g(this));
    }

    public final void setTag(String str) {
        this.d = str;
    }
}
