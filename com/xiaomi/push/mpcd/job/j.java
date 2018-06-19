package com.xiaomi.push.mpcd.job;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.aplayer.aplayerandroid.APlayerAndroid.CONFIGID;
import com.qihoo360.replugin.RePlugin;
import com.xiaomi.channel.commonutils.misc.c;
import com.xiaomi.channel.commonutils.misc.h.a;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.push.mpcd.b;
import com.xiaomi.push.service.am;
import com.xiaomi.xmpush.thrift.ac;
import com.xiaomi.xmpush.thrift.ai;
import com.xiaomi.xmpush.thrift.au;
import com.xiaomi.xmpush.thrift.g;
import com.xiaomi.xmpush.thrift.r;
import java.io.File;
import java.util.List;

public class j extends a {
    private Context a;
    private SharedPreferences b;
    private am c;

    public j(Context context) {
        this.a = context;
        this.b = context.getSharedPreferences("mipush_extra", 0);
        this.c = am.a(context);
    }

    private java.util.List<com.xiaomi.xmpush.thrift.k> a(java.io.File r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = com.xiaomi.push.mpcd.c.a();
        r0 = r0.b();
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r0 = "";
        goto L_0x0011;
    L_0x000d:
        r0 = r0.a();
    L_0x0011:
        r1 = android.text.TextUtils.isEmpty(r0);
        r2 = 0;
        if (r1 == 0) goto L_0x0019;
    L_0x0018:
        return r2;
    L_0x0019:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r3 = 4;
        r4 = new byte[r3];
        r5 = com.xiaomi.push.mpcd.f.a;
        monitor-enter(r5);
        r6 = new java.io.File;	 Catch:{ Exception -> 0x00a3, all -> 0x008e }
        r7 = r10.a;	 Catch:{ Exception -> 0x00a3, all -> 0x008e }
        r7 = r7.getExternalFilesDir(r2);	 Catch:{ Exception -> 0x00a3, all -> 0x008e }
        r8 = "push_cdata.lock";	 Catch:{ Exception -> 0x00a3, all -> 0x008e }
        r6.<init>(r7, r8);	 Catch:{ Exception -> 0x00a3, all -> 0x008e }
        com.xiaomi.channel.commonutils.file.a.a(r6);	 Catch:{ Exception -> 0x00a3, all -> 0x008e }
        r7 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x00a3, all -> 0x008e }
        r8 = "rw";	 Catch:{ Exception -> 0x00a3, all -> 0x008e }
        r7.<init>(r6, r8);	 Catch:{ Exception -> 0x00a3, all -> 0x008e }
        r6 = r7.getChannel();	 Catch:{ Exception -> 0x008c, all -> 0x0089 }
        r6 = r6.lock();	 Catch:{ Exception -> 0x008c, all -> 0x0089 }
        r8 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0086, all -> 0x0084 }
        r8.<init>(r11);	 Catch:{ Exception -> 0x0086, all -> 0x0084 }
    L_0x0048:
        r11 = r8.read(r4);	 Catch:{ Exception -> 0x0087, all -> 0x0081 }
        if (r11 != r3) goto L_0x006f;	 Catch:{ Exception -> 0x0087, all -> 0x0081 }
    L_0x004e:
        r11 = com.xiaomi.channel.commonutils.misc.b.a(r4);	 Catch:{ Exception -> 0x0087, all -> 0x0081 }
        r2 = new byte[r11];	 Catch:{ Exception -> 0x0087, all -> 0x0081 }
        r9 = r8.read(r2);	 Catch:{ Exception -> 0x0087, all -> 0x0081 }
        if (r9 != r11) goto L_0x006f;	 Catch:{ Exception -> 0x0087, all -> 0x0081 }
    L_0x005a:
        r11 = com.xiaomi.push.mpcd.e.a(r0, r2);	 Catch:{ Exception -> 0x0087, all -> 0x0081 }
        if (r11 == 0) goto L_0x0048;	 Catch:{ Exception -> 0x0087, all -> 0x0081 }
    L_0x0060:
        r2 = r11.length;	 Catch:{ Exception -> 0x0087, all -> 0x0081 }
        if (r2 == 0) goto L_0x0048;	 Catch:{ Exception -> 0x0087, all -> 0x0081 }
    L_0x0063:
        r2 = new com.xiaomi.xmpush.thrift.k;	 Catch:{ Exception -> 0x0087, all -> 0x0081 }
        r2.<init>();	 Catch:{ Exception -> 0x0087, all -> 0x0081 }
        com.xiaomi.xmpush.thrift.au.a(r2, r11);	 Catch:{ Exception -> 0x0087, all -> 0x0081 }
        r1.add(r2);	 Catch:{ Exception -> 0x0087, all -> 0x0081 }
        goto L_0x0048;
    L_0x006f:
        if (r6 == 0) goto L_0x007a;
    L_0x0071:
        r11 = r6.isValid();	 Catch:{ all -> 0x00b1 }
        if (r11 == 0) goto L_0x007a;
    L_0x0077:
        r6.release();	 Catch:{ IOException -> 0x007a }
    L_0x007a:
        com.xiaomi.channel.commonutils.file.a.a(r8);	 Catch:{ all -> 0x00b1 }
    L_0x007d:
        com.xiaomi.channel.commonutils.file.a.a(r7);	 Catch:{ all -> 0x00b1 }
        goto L_0x00b7;	 Catch:{ all -> 0x00b1 }
    L_0x0081:
        r11 = move-exception;	 Catch:{ all -> 0x00b1 }
        r2 = r8;	 Catch:{ all -> 0x00b1 }
        goto L_0x0091;	 Catch:{ all -> 0x00b1 }
    L_0x0084:
        r11 = move-exception;	 Catch:{ all -> 0x00b1 }
        goto L_0x0091;	 Catch:{ all -> 0x00b1 }
    L_0x0086:
        r8 = r2;	 Catch:{ all -> 0x00b1 }
    L_0x0087:
        r2 = r6;	 Catch:{ all -> 0x00b1 }
        goto L_0x00a5;	 Catch:{ all -> 0x00b1 }
    L_0x0089:
        r11 = move-exception;	 Catch:{ all -> 0x00b1 }
        r6 = r2;	 Catch:{ all -> 0x00b1 }
        goto L_0x0091;	 Catch:{ all -> 0x00b1 }
    L_0x008c:
        r8 = r2;	 Catch:{ all -> 0x00b1 }
        goto L_0x00a5;	 Catch:{ all -> 0x00b1 }
    L_0x008e:
        r11 = move-exception;	 Catch:{ all -> 0x00b1 }
        r6 = r2;	 Catch:{ all -> 0x00b1 }
        r7 = r6;	 Catch:{ all -> 0x00b1 }
    L_0x0091:
        if (r6 == 0) goto L_0x009c;	 Catch:{ all -> 0x00b1 }
    L_0x0093:
        r0 = r6.isValid();	 Catch:{ all -> 0x00b1 }
        if (r0 == 0) goto L_0x009c;
    L_0x0099:
        r6.release();	 Catch:{ IOException -> 0x009c }
    L_0x009c:
        com.xiaomi.channel.commonutils.file.a.a(r2);	 Catch:{ all -> 0x00b1 }
        com.xiaomi.channel.commonutils.file.a.a(r7);	 Catch:{ all -> 0x00b1 }
        throw r11;	 Catch:{ all -> 0x00b1 }
    L_0x00a3:
        r7 = r2;	 Catch:{ all -> 0x00b1 }
        r8 = r7;	 Catch:{ all -> 0x00b1 }
    L_0x00a5:
        if (r2 == 0) goto L_0x00b3;	 Catch:{ all -> 0x00b1 }
    L_0x00a7:
        r11 = r2.isValid();	 Catch:{ all -> 0x00b1 }
        if (r11 == 0) goto L_0x00b3;
    L_0x00ad:
        r2.release();	 Catch:{ IOException -> 0x00b3 }
        goto L_0x00b3;
    L_0x00b1:
        r11 = move-exception;
        goto L_0x00b9;
    L_0x00b3:
        com.xiaomi.channel.commonutils.file.a.a(r8);	 Catch:{ all -> 0x00b1 }
        goto L_0x007d;	 Catch:{ all -> 0x00b1 }
    L_0x00b7:
        monitor-exit(r5);	 Catch:{ all -> 0x00b1 }
        return r1;	 Catch:{ all -> 0x00b1 }
    L_0x00b9:
        monitor-exit(r5);	 Catch:{ all -> 0x00b1 }
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.job.j.a(java.io.File):java.util.List<com.xiaomi.xmpush.thrift.k>");
    }

    private boolean b() {
        return d.e(this.a) ? false : (!d.g(this.a) || d()) ? (d.h(this.a) && !c()) || d.i(this.a) : true;
    }

    private boolean c() {
        if (!this.c.a(g.L.a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.b.getLong("last_upload_data_timestamp", -1)) > ((long) Math.max(86400, this.c.a(g.M.a(), 432000)));
    }

    private boolean d() {
        if (!this.c.a(g.J.a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.b.getLong("last_upload_data_timestamp", -1)) > ((long) Math.max(86400, this.c.a(g.K.a(), 259200)));
    }

    private void e() {
        Editor edit = this.b.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    public int a() {
        return 1;
    }

    public void run() {
        File file = new File(this.a.getExternalFilesDir(null), "push_cdata.data");
        if (!d.d(this.a)) {
            if (file.length() > 1863680) {
                file.delete();
            }
        } else if (!b() && file.exists()) {
            List a = a(file);
            if (!c.a(a)) {
                int size = a.size();
                if (size > CONFIGID.RECORD_BIT) {
                    a = a.subList(size - 4000, size);
                }
                org.apache.thrift.a acVar = new ac();
                acVar.a(a);
                byte[] a2 = com.xiaomi.channel.commonutils.file.a.a(au.a(acVar));
                ai aiVar = new ai(RePlugin.PROCESS_UI, false);
                aiVar.c(r.q.W);
                aiVar.a(a2);
                b b = com.xiaomi.push.mpcd.c.a().b();
                if (b != null) {
                    b.a(aiVar, com.xiaomi.xmpush.thrift.a.i, null);
                }
                e();
            }
            file.delete();
            this.b.edit().remove("ltapn").commit();
        }
    }
}
