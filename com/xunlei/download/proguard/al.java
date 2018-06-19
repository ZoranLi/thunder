package com.xunlei.download.proguard;

import android.content.Context;
import com.umeng.message.MsgConstant;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: CrashHandler */
public class al implements UncaughtExceptionHandler {
    private static final String a = "CrashHandler";
    private static al c;
    private UncaughtExceptionHandler b;
    private Context d;
    private Map<String, String> e = new HashMap();
    private DateFormat f = new SimpleDateFormat("yyMMdd");
    private String g;

    private al() {
    }

    public static al a() {
        if (c == null) {
            c = new al();
        }
        return c;
    }

    public void a(Context context, String str) {
        this.d = context;
        this.b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.g = str;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        if (this.b != null) {
            this.b.uncaughtException(thread, th);
        }
    }

    public boolean a(Throwable th) {
        if (th == null) {
            return null;
        }
        a(this.d);
        b(th);
        return true;
    }

    public void a(android.content.Context r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = 1;
        r8 = r8.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0036 }
        r1 = r7.d;	 Catch:{ NameNotFoundException -> 0x0036 }
        r1 = r1.getPackageName();	 Catch:{ NameNotFoundException -> 0x0036 }
        r8 = r8.getPackageInfo(r1, r0);	 Catch:{ NameNotFoundException -> 0x0036 }
        if (r8 == 0) goto L_0x0036;	 Catch:{ NameNotFoundException -> 0x0036 }
    L_0x0011:
        r1 = r8.versionName;	 Catch:{ NameNotFoundException -> 0x0036 }
        if (r1 != 0) goto L_0x0018;	 Catch:{ NameNotFoundException -> 0x0036 }
    L_0x0015:
        r1 = "null";	 Catch:{ NameNotFoundException -> 0x0036 }
        goto L_0x001a;	 Catch:{ NameNotFoundException -> 0x0036 }
    L_0x0018:
        r1 = r8.versionName;	 Catch:{ NameNotFoundException -> 0x0036 }
    L_0x001a:
        r2 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x0036 }
        r2.<init>();	 Catch:{ NameNotFoundException -> 0x0036 }
        r8 = r8.versionCode;	 Catch:{ NameNotFoundException -> 0x0036 }
        r2.append(r8);	 Catch:{ NameNotFoundException -> 0x0036 }
        r8 = r2.toString();	 Catch:{ NameNotFoundException -> 0x0036 }
        r2 = r7.e;	 Catch:{ NameNotFoundException -> 0x0036 }
        r3 = "versionName";	 Catch:{ NameNotFoundException -> 0x0036 }
        r2.put(r3, r1);	 Catch:{ NameNotFoundException -> 0x0036 }
        r1 = r7.e;	 Catch:{ NameNotFoundException -> 0x0036 }
        r2 = "versionCode";	 Catch:{ NameNotFoundException -> 0x0036 }
        r1.put(r2, r8);	 Catch:{ NameNotFoundException -> 0x0036 }
    L_0x0036:
        r8 = android.os.Build.class;
        r8 = r8.getDeclaredFields();
        r1 = r8.length;
        r2 = 0;
    L_0x003e:
        if (r2 >= r1) goto L_0x005a;
    L_0x0040:
        r3 = r8[r2];
        r3.setAccessible(r0);	 Catch:{ Exception -> 0x0057 }
        r4 = r7.e;	 Catch:{ Exception -> 0x0057 }
        r5 = r3.getName();	 Catch:{ Exception -> 0x0057 }
        r6 = 0;	 Catch:{ Exception -> 0x0057 }
        r3 = r3.get(r6);	 Catch:{ Exception -> 0x0057 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0057 }
        r4.put(r5, r3);	 Catch:{ Exception -> 0x0057 }
    L_0x0057:
        r2 = r2 + 1;
        goto L_0x003e;
    L_0x005a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.al.a(android.content.Context):void");
    }

    public String b(Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : this.e.entrySet()) {
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append((String) entry.getValue());
            stringBuilder.append("\n");
        }
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (th = th.getCause(); th != null; th = th.getCause()) {
            th.printStackTrace(printWriter);
        }
        printWriter.close();
        stringBuilder.append(stringWriter.toString());
        stringBuilder.append("\n\n");
        StringBuilder stringBuilder2;
        try {
            th = this.f.format(new Date());
            stringBuilder2 = new StringBuilder("crash_log_");
            stringBuilder2.append(th);
            stringBuilder2.append(MsgConstant.CACHE_LOG_FILE_EXT);
            th = stringBuilder2.toString();
            if (this.g != null) {
                File file = new File(this.g);
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(new File(this.g, th), true);
                fileOutputStream.write(stringBuilder.toString().getBytes());
                fileOutputStream.close();
            }
            return th;
        } catch (Throwable th2) {
            stringBuilder2 = new StringBuilder("Error when save crash log to file: ");
            stringBuilder2.append(th2.getMessage());
            an.d("CrashHandler", stringBuilder2.toString());
            return null;
        }
    }
}
