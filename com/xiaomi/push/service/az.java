package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.google.protobuf.micro.c;
import com.xiaomi.channel.commonutils.android.h;
import com.xiaomi.channel.commonutils.misc.j.b;
import com.xiaomi.smack.util.e;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class az {
    private static String a;
    private static az e = new az();
    private List<a> b = new ArrayList();
    private com.xiaomi.push.protobuf.a.a c;
    private b d;

    public static abstract class a {
        public void a(com.xiaomi.push.protobuf.a.a aVar) {
        }

        public void a(com.xiaomi.push.protobuf.b.b bVar) {
        }
    }

    private az() {
    }

    public static az a() {
        return e;
    }

    public static synchronized String e() {
        String str;
        synchronized (az.class) {
            if (a == null) {
                SharedPreferences sharedPreferences = h.a().getSharedPreferences("XMPushServiceConfig", 0);
                String string = sharedPreferences.getString("DeviceUUID", null);
                a = string;
                if (string == null) {
                    string = h.b();
                    a = string;
                    if (string != null) {
                        sharedPreferences.edit().putString("DeviceUUID", a).commit();
                    }
                }
            }
            str = a;
        }
        return str;
    }

    private void f() {
        if (this.c == null) {
            h();
        }
    }

    private void g() {
        if (this.d == null) {
            this.d = new ba(this);
            e.a(this.d);
        }
    }

    private void h() {
        Exception exception;
        StringBuilder stringBuilder;
        Throwable th;
        InputStream inputStream = null;
        try {
            InputStream bufferedInputStream = new BufferedInputStream(h.a().openFileInput("XMCloudCfg"));
            try {
                this.c = com.xiaomi.push.protobuf.a.a.c(com.google.protobuf.micro.b.a(bufferedInputStream));
                bufferedInputStream.close();
                com.xiaomi.channel.commonutils.file.a.a(bufferedInputStream);
            } catch (Exception e) {
                exception = e;
                inputStream = bufferedInputStream;
                try {
                    stringBuilder = new StringBuilder("load config failure: ");
                    stringBuilder.append(exception.getMessage());
                    com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
                    com.xiaomi.channel.commonutils.file.a.a(inputStream);
                    if (this.c != null) {
                        this.c = new com.xiaomi.push.protobuf.a.a();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.xiaomi.channel.commonutils.file.a.a(inputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = bufferedInputStream;
                com.xiaomi.channel.commonutils.file.a.a(inputStream);
                throw th;
            }
        } catch (Exception e2) {
            exception = e2;
            stringBuilder = new StringBuilder("load config failure: ");
            stringBuilder.append(exception.getMessage());
            com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
            com.xiaomi.channel.commonutils.file.a.a(inputStream);
            if (this.c != null) {
                this.c = new com.xiaomi.push.protobuf.a.a();
            }
        }
        if (this.c != null) {
            this.c = new com.xiaomi.push.protobuf.a.a();
        }
    }

    private void i() {
        try {
            if (this.c != null) {
                OutputStream bufferedOutputStream = new BufferedOutputStream(h.a().openFileOutput("XMCloudCfg", 0));
                c a = c.a(bufferedOutputStream);
                this.c.a(a);
                a.a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("save config failure: ");
            stringBuilder.append(e.getMessage());
            com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
        }
    }

    void a(com.xiaomi.push.protobuf.b.b bVar) {
        if (bVar.i() && bVar.h() > c()) {
            g();
        }
        synchronized (this) {
        }
        for (a a : (a[]) this.b.toArray(new a[this.b.size()])) {
            a.a(bVar);
        }
    }

    public synchronized void a(a aVar) {
        this.b.add(aVar);
    }

    synchronized void b() {
        this.b.clear();
    }

    int c() {
        f();
        return this.c != null ? this.c.d() : 0;
    }

    public com.xiaomi.push.protobuf.a.a d() {
        f();
        return this.c;
    }
}
