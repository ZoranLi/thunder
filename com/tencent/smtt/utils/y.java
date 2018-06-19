package com.tencent.smtt.utils;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class y {
    private static y e;
    public boolean a = false;
    private Context b = null;
    private File c = null;
    private boolean d = false;
    private File f = null;

    private y(Context context) {
        this.b = context.getApplicationContext();
        b();
    }

    public static synchronized y a() {
        y yVar;
        synchronized (y.class) {
            yVar = e;
        }
        return yVar;
    }

    public static synchronized y a(Context context) {
        y yVar;
        synchronized (y.class) {
            if (e == null) {
                e = new y(context);
            }
            yVar = e;
        }
        return yVar;
    }

    private File d() {
        try {
            if (this.c == null) {
                this.c = new File(this.b.getDir("tbs", 0), "core_private");
                if (this.c == null || !this.c.isDirectory()) {
                    return null;
                }
            }
            File file = new File(this.c, "debug.conf");
            if (!file.exists()) {
                file.createNewFile();
            }
            return file;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void a(boolean z) {
        this.d = z;
        c();
    }

    public synchronized void b() {
        Throwable th;
        BufferedInputStream bufferedInputStream = null;
        try {
            if (this.f == null) {
                this.f = d();
            }
            if (this.f != null) {
                InputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(this.f));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    String property = properties.getProperty("setting_forceUseSystemWebview", "");
                    if (!"".equals(property)) {
                        this.a = Boolean.parseBoolean(property);
                    }
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
        }
    }

    public void c() {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream2;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            File d = d();
            if (d == null) {
                try {
                    bufferedOutputStream2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    bufferedOutputStream2.close();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(d));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                properties.setProperty("setting_forceUseSystemWebview", Boolean.toString(this.a));
                properties.setProperty("result_systemWebviewForceUsed", Boolean.toString(this.d));
                OutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(d));
                try {
                    properties.store(bufferedOutputStream3, bufferedOutputStream2);
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e22) {
                        e22.printStackTrace();
                    }
                    try {
                        bufferedOutputStream3.close();
                    } catch (Exception e222) {
                        e222.printStackTrace();
                    }
                } catch (Throwable th2) {
                    OutputStream outputStream = bufferedOutputStream3;
                    th = th2;
                    bufferedOutputStream2 = outputStream;
                    bufferedInputStream.close();
                    bufferedOutputStream2.close();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream.close();
                bufferedOutputStream2.close();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedInputStream = bufferedOutputStream2;
            bufferedInputStream.close();
            bufferedOutputStream2.close();
            throw th;
        }
    }
}
