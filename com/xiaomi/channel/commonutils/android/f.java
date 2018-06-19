package com.xiaomi.channel.commonutils.android;

import android.os.Environment;
import com.xiaomi.channel.commonutils.file.a;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class f {
    private static int a;

    public static synchronized boolean a() {
        synchronized (f.class) {
            if (c() == 1) {
                return true;
            }
            return false;
        }
    }

    public static synchronized boolean b() {
        boolean z;
        synchronized (f.class) {
            z = c() == 2;
        }
        return z;
    }

    public static synchronized int c() {
        StringBuilder stringBuilder;
        Throwable th;
        int i;
        Throwable th2;
        synchronized (f.class) {
            if (a == 0) {
                InputStream inputStream = null;
                try {
                    Properties properties = new Properties();
                    InputStream fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                    try {
                        int i2;
                        properties.load(fileInputStream);
                        int i3 = 1;
                        if (properties.getProperty("ro.miui.ui.version.code", null) == null) {
                            if (properties.getProperty("ro.miui.ui.version.name", null) == null) {
                                i2 = 0;
                                if (i2 != 0) {
                                    i3 = 2;
                                }
                                a = i3;
                                a.a(fileInputStream);
                                stringBuilder = new StringBuilder("isMIUI's value is: ");
                                stringBuilder.append(a);
                                b.b(stringBuilder.toString());
                            }
                        }
                        i2 = 1;
                        if (i2 != 0) {
                            i3 = 2;
                        }
                        a = i3;
                        a.a(fileInputStream);
                    } catch (Throwable th3) {
                        th2 = th3;
                        inputStream = fileInputStream;
                        a.a(inputStream);
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    b.a("get isMIUI failed", th);
                    a = 0;
                    a.a(inputStream);
                    stringBuilder = new StringBuilder("isMIUI's value is: ");
                    stringBuilder.append(a);
                    b.b(stringBuilder.toString());
                    i = a;
                    return i;
                }
                stringBuilder = new StringBuilder("isMIUI's value is: ");
                stringBuilder.append(a);
                b.b(stringBuilder.toString());
            }
            i = a;
        }
        return i;
    }
}
