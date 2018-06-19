package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

public class x {
    private static x c;
    private Context a = null;
    private File b = null;
    private String d = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";
    private String e = "http://log.tbs.qq.com/ajax?c=pu&tk=";
    private String f = "http://wup.imtt.qq.com:8080";
    private String g = "http://log.tbs.qq.com/ajax?c=dl&k=";
    private String h = "http://cfg.imtt.qq.com/tbs?v=2&mk=";
    private String i = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";
    private String j = "http://mqqad.html5.qq.com/adjs";
    private String k = "http://log.tbs.qq.com/ajax?c=ucfu&k=";

    @TargetApi(11)
    private x(Context context) {
        TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
        this.a = context.getApplicationContext();
        g();
    }

    public static synchronized x a() {
        x xVar;
        synchronized (x.class) {
            xVar = c;
        }
        return xVar;
    }

    public static synchronized x a(Context context) {
        x xVar;
        synchronized (x.class) {
            if (c == null) {
                c = new x(context);
            }
            xVar = c;
        }
        return xVar;
    }

    private synchronized void g() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Writer stringWriter;
        StringBuilder stringBuilder;
        Throwable th2;
        try {
            File h = h();
            if (h == null) {
                TbsLog.e("TbsCommonConfig", "Config file is null, default values will be applied");
                return;
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(h));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                String property = properties.getProperty("pv_post_url", "");
                if (!"".equals(property)) {
                    this.d = property;
                }
                property = properties.getProperty("wup_proxy_domain", "");
                if (!"".equals(property)) {
                    this.f = property;
                }
                property = properties.getProperty("tbs_download_stat_post_url", "");
                if (!"".equals(property)) {
                    this.g = property;
                }
                property = properties.getProperty("tbs_downloader_post_url", "");
                if (!"".equals(property)) {
                    this.h = property;
                }
                property = properties.getProperty("tbs_log_post_url", "");
                if (!"".equals(property)) {
                    this.i = property;
                }
                property = properties.getProperty("tips_url", "");
                if (!"".equals(property)) {
                    this.j = property;
                }
                property = properties.getProperty("tbs_cmd_post_url", "");
                if (!"".equals(property)) {
                    this.k = property;
                }
                String property2 = properties.getProperty("pv_post_url_tk", "");
                if (!"".equals(property2)) {
                    this.e = property2;
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    stringBuilder = new StringBuilder("exceptions occurred1:");
                    stringBuilder.append(stringWriter.toString());
                    TbsLog.e("TbsCommonConfig", stringBuilder.toString());
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    return;
                } catch (Throwable th4) {
                    th = th4;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th5) {
            th2 = th5;
            bufferedInputStream = null;
            th = th2;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    private File h() {
        Throwable th;
        Writer stringWriter;
        StringBuilder stringBuilder;
        File file = null;
        try {
            if (this.b == null) {
                this.b = new File(k.a(this.a, 5));
                if (this.b == null || !this.b.isDirectory()) {
                    return null;
                }
            }
            File file2 = new File(this.b, "tbsnet.conf");
            if (file2.exists()) {
                try {
                    StringBuilder stringBuilder2 = new StringBuilder("pathc:");
                    stringBuilder2.append(file2.getCanonicalPath());
                    TbsLog.w("TbsCommonConfig", stringBuilder2.toString());
                    return file2;
                } catch (Throwable th2) {
                    File file3 = file2;
                    th = th2;
                    file = file3;
                    stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    stringBuilder = new StringBuilder("exceptions occurred2:");
                    stringBuilder.append(stringWriter.toString());
                    TbsLog.e("TbsCommonConfig", stringBuilder.toString());
                    return file;
                }
            }
            stringBuilder = new StringBuilder("Get file(");
            stringBuilder.append(file2.getCanonicalPath());
            stringBuilder.append(") failed!");
            TbsLog.e("TbsCommonConfig", stringBuilder.toString());
            return null;
        } catch (Throwable th3) {
            th = th3;
            stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            stringBuilder = new StringBuilder("exceptions occurred2:");
            stringBuilder.append(stringWriter.toString());
            TbsLog.e("TbsCommonConfig", stringBuilder.toString());
            return file;
        }
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.g;
    }

    public String d() {
        return this.h;
    }

    public String e() {
        return this.i;
    }

    public String f() {
        return this.e;
    }
}
