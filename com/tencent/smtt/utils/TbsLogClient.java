package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;

public class TbsLogClient {
    static TbsLogClient a = null;
    static File c = null;
    static String d = null;
    static byte[] e = null;
    private static boolean i = true;
    TextView b;
    private SimpleDateFormat f = null;
    private Context g = null;
    private StringBuffer h = new StringBuffer();

    private class a implements Runnable {
        String a = null;
        final /* synthetic */ TbsLogClient b;

        a(TbsLogClient tbsLogClient, String str) {
            this.b = tbsLogClient;
            this.a = str;
        }

        public void run() {
            if (this.b.b != null) {
                TextView textView = this.b.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.a);
                stringBuilder.append("\n");
                textView.append(stringBuilder.toString());
            }
        }
    }

    public TbsLogClient(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r2.<init>();
        r0 = 0;
        r2.f = r0;
        r2.g = r0;
        r0 = new java.lang.StringBuffer;
        r0.<init>();
        r2.h = r0;
        r3 = r3.getApplicationContext();	 Catch:{ Exception -> 0x0021 }
        r2.g = r3;	 Catch:{ Exception -> 0x0021 }
        r3 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x0021 }
        r0 = "yyyy-MM-dd_HH:mm:ss.SSS";	 Catch:{ Exception -> 0x0021 }
        r1 = java.util.Locale.US;	 Catch:{ Exception -> 0x0021 }
        r3.<init>(r0, r1);	 Catch:{ Exception -> 0x0021 }
        r2.f = r3;	 Catch:{ Exception -> 0x0021 }
        return;
    L_0x0021:
        r3 = new java.text.SimpleDateFormat;
        r0 = "yyyy-MM-dd_HH:mm:ss.SSS";
        r3.<init>(r0);
        r2.f = r3;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.TbsLogClient.<init>(android.content.Context):void");
    }

    private void a() {
        try {
            if (c == null) {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    String a = k.a(this.g, 6);
                    if (a == null) {
                        c = null;
                        return;
                    }
                    c = new File(a, "tbslog.txt");
                    d = LogFileUtils.createKey();
                    e = LogFileUtils.createHeaderText(c.getName(), d);
                    return;
                }
                c = null;
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
    }

    public static void setWriteLogJIT(boolean z) {
        i = z;
    }

    public void d(String str, String str2) {
    }

    public void e(String str, String str2) {
    }

    public void i(String str, String str2) {
    }

    public void setLogView(TextView textView) {
        this.b = textView;
    }

    public void showLog(String str) {
        if (this.b != null) {
            this.b.post(new a(this, str));
        }
    }

    public void v(String str, String str2) {
    }

    public void w(String str, String str2) {
    }

    public void writeLog(String str) {
        try {
            String format = this.f.format(Long.valueOf(System.currentTimeMillis()));
            StringBuffer stringBuffer = this.h;
            stringBuffer.append(format);
            stringBuffer.append(" pid=");
            stringBuffer.append(Process.myPid());
            stringBuffer.append(" tid=");
            stringBuffer.append(Process.myTid());
            stringBuffer.append(str);
            stringBuffer.append("\n");
            if (Thread.currentThread() != Looper.getMainLooper().getThread() || i) {
                writeLogToDisk();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeLogToDisk() {
        a();
        if (c != null) {
            LogFileUtils.writeDataToStorage(c, d, e, this.h.toString(), true);
            this.h.delete(0, this.h.length());
        }
    }
}
