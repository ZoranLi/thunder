package com.qihoo360.loader2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import com.qihoo360.i.Factory2;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.a;
import com.qihoo360.replugin.b.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* compiled from: PluginContext */
public final class u extends ContextThemeWrapper {
    Factory a = new v(this);
    private final ClassLoader b;
    private final Resources c;
    private final String d;
    private final l e;
    private final Object f = new Object();
    private File g;
    private File h;
    private LayoutInflater i;
    private a j;

    public u(Context context, ClassLoader classLoader, Resources resources, String str, l lVar) {
        super(context, 16973829);
        this.b = classLoader;
        this.c = resources;
        this.d = str;
        this.e = lVar;
        RePlugin.getConfig();
        this.j = null;
    }

    public final ClassLoader getClassLoader() {
        if (this.b != null) {
            return this.b;
        }
        return super.getClassLoader();
    }

    public final Resources getResources() {
        if (this.c != null) {
            return this.c;
        }
        return super.getResources();
    }

    public final AssetManager getAssets() {
        if (this.c != null) {
            return this.c.getAssets();
        }
        return super.getAssets();
    }

    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return super.getSystemService(str);
        }
        if (this.i == null) {
            this.i = ((LayoutInflater) super.getSystemService(str)).cloneInContext(this);
            this.i.setFactory(this.a);
            this.i = this.i.cloneInContext(this);
        }
        return this.i;
    }

    public final SharedPreferences getSharedPreferences(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder("plugin_");
        stringBuilder.append(str);
        return super.getSharedPreferences(stringBuilder.toString(), i);
    }

    public final FileInputStream openFileInput(String str) throws FileNotFoundException {
        return new FileInputStream(a(getFilesDir(), str));
    }

    public final java.io.FileOutputStream openFileOutput(java.lang.String r5, int r6) throws java.io.FileNotFoundException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 32768; // 0x8000 float:4.5918E-41 double:1.61895E-319;
        r0 = r0 & r6;
        r1 = 0;
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        r0 = 1;
        goto L_0x000a;
    L_0x0009:
        r0 = r1;
    L_0x000a:
        r2 = r4.getFilesDir();
        r5 = a(r2, r5);
        r2 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x001f }
        r2.<init>(r5, r0);	 Catch:{ FileNotFoundException -> 0x001f }
        r3 = r5.getPath();	 Catch:{ FileNotFoundException -> 0x001f }
        a(r3, r6, r1);	 Catch:{ FileNotFoundException -> 0x001f }
        return r2;
    L_0x001f:
        r2 = r5.getParentFile();
        r2.mkdir();
        r2 = r2.getPath();
        r3 = 504; // 0x1f8 float:7.06E-43 double:2.49E-321;
        com.qihoo360.a.b.a.a(r2, r3);
        r2 = new java.io.FileOutputStream;
        r2.<init>(r5, r0);
        r5 = r5.getPath();
        a(r5, r6, r1);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.loader2.u.openFileOutput(java.lang.String, int):java.io.FileOutputStream");
    }

    public final boolean deleteFile(String str) {
        return a(getFilesDir(), str).delete();
    }

    public final File getFilesDir() {
        synchronized (this.f) {
            File file;
            if (this.g == null) {
                this.g = new File(a(), "files");
            }
            if (!this.g.exists()) {
                if (this.g.mkdirs()) {
                    com.qihoo360.a.b.a.a(this.g.getPath(), 505);
                } else if (this.g.exists()) {
                    file = this.g;
                    return file;
                } else {
                    new StringBuilder("Unable to create files directory ").append(this.g.getPath());
                    return null;
                }
            }
            file = this.g;
            return file;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.File getCacheDir() {
        /*
        r4 = this;
        r0 = r4.f;
        monitor-enter(r0);
        r1 = r4.h;	 Catch:{ all -> 0x0052 }
        if (r1 != 0) goto L_0x0014;
    L_0x0007:
        r1 = new java.io.File;	 Catch:{ all -> 0x0052 }
        r2 = r4.a();	 Catch:{ all -> 0x0052 }
        r3 = "cache";
        r1.<init>(r2, r3);	 Catch:{ all -> 0x0052 }
        r4.h = r1;	 Catch:{ all -> 0x0052 }
    L_0x0014:
        r1 = r4.h;	 Catch:{ all -> 0x0052 }
        r1 = r1.exists();	 Catch:{ all -> 0x0052 }
        if (r1 != 0) goto L_0x004e;
    L_0x001c:
        r1 = r4.h;	 Catch:{ all -> 0x0052 }
        r1 = r1.mkdirs();	 Catch:{ all -> 0x0052 }
        if (r1 != 0) goto L_0x0043;
    L_0x0024:
        r1 = r4.h;	 Catch:{ all -> 0x0052 }
        r1 = r1.exists();	 Catch:{ all -> 0x0052 }
        if (r1 == 0) goto L_0x0030;
    L_0x002c:
        r1 = r4.h;	 Catch:{ all -> 0x0052 }
        monitor-exit(r0);	 Catch:{ all -> 0x0052 }
        return r1;
    L_0x0030:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0052 }
        r2 = "Unable to create cache directory ";
        r1.<init>(r2);	 Catch:{ all -> 0x0052 }
        r2 = r4.h;	 Catch:{ all -> 0x0052 }
        r2 = r2.getAbsolutePath();	 Catch:{ all -> 0x0052 }
        r1.append(r2);	 Catch:{ all -> 0x0052 }
        r1 = 0;
        monitor-exit(r0);	 Catch:{ all -> 0x0052 }
        return r1;
    L_0x0043:
        r1 = r4.h;	 Catch:{ all -> 0x0052 }
        r1 = r1.getPath();	 Catch:{ all -> 0x0052 }
        r2 = 505; // 0x1f9 float:7.08E-43 double:2.495E-321;
        com.qihoo360.a.b.a.a(r1, r2);	 Catch:{ all -> 0x0052 }
    L_0x004e:
        monitor-exit(r0);	 Catch:{ all -> 0x0052 }
        r0 = r4.h;
        return r0;
    L_0x0052:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0052 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.loader2.u.getCacheDir():java.io.File");
    }

    public final File getFileStreamPath(String str) {
        return a(getFilesDir(), str);
    }

    public final File getDir(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder("app_");
        stringBuilder.append(str);
        str = a(a(), stringBuilder.toString());
        if (!str.exists()) {
            str.mkdir();
            a(str.getPath(), i, 505);
        }
        return str;
    }

    private static File a(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        StringBuilder stringBuilder = new StringBuilder("File ");
        stringBuilder.append(str);
        stringBuilder.append(" contains a path separator");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static void a(String str, int i, int i2) {
        i2 |= 432;
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("File ");
            stringBuilder.append(str);
            stringBuilder.append(": mode=0x");
            stringBuilder.append(Integer.toHexString(i));
            stringBuilder.append(", perms=0x");
            stringBuilder.append(Integer.toHexString(i2));
            c.a("ws001", stringBuilder.toString());
        }
        com.qihoo360.a.b.a.a(str, i2);
    }

    private final File a() {
        File file = new File(getBaseContext().getFilesDir(), "plugins_v3_data");
        if (!file.exists()) {
            if (file.mkdir()) {
                a(file.getPath(), 0, 505);
            } else {
                new StringBuilder("can't create dir: ").append(file.getAbsolutePath());
                return null;
            }
        }
        File a = a(file, this.d);
        if (!a.exists()) {
            if (a.mkdir()) {
                a(a.getPath(), 0, 505);
            } else {
                new StringBuilder("can't create dir: ").append(a.getAbsolutePath());
                return null;
            }
        }
        return a;
    }

    private final android.view.View a(java.lang.String r8, android.content.Context r9, android.util.AttributeSet r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r7.e;
        r0 = r0.n;
        r0 = r0.contains(r8);
        r1 = 0;
        if (r0 == 0) goto L_0x0035;
    L_0x000b:
        r9 = com.qihoo360.replugin.b.c.a;
        if (r9 == 0) goto L_0x0034;
    L_0x000f:
        r9 = com.qihoo360.replugin.RePlugin.getConfig();
        r9 = r9.g;
        if (r9 == 0) goto L_0x0034;
    L_0x0017:
        r9 = "ws001";
        r10 = new java.lang.StringBuilder;
        r0 = "layout.cache: ignore plugin=";
        r10.<init>(r0);
        r0 = r7.d;
        r10.append(r0);
        r0 = " name=";
        r10.append(r0);
        r10.append(r8);
        r8 = r10.toString();
        com.qihoo360.replugin.b.c.a(r9, r8);
    L_0x0034:
        return r1;
    L_0x0035:
        r0 = r7.e;
        r0 = r0.o;
        r0 = r0.get(r8);
        r0 = (java.lang.reflect.Constructor) r0;
        r2 = 2;
        r3 = 1;
        r4 = 0;
        if (r0 != 0) goto L_0x00e9;
    L_0x0044:
        r0 = r7.b;	 Catch:{ ClassNotFoundException -> 0x005d }
        r0 = r0.loadClass(r8);	 Catch:{ ClassNotFoundException -> 0x005d }
        if (r0 != 0) goto L_0x004d;
    L_0x004c:
        goto L_0x005e;
    L_0x004d:
        r5 = android.view.ViewStub.class;
        if (r0 == r5) goto L_0x005e;
    L_0x0051:
        r5 = r0.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x005e }
        r6 = r7.b;	 Catch:{ ClassNotFoundException -> 0x005e }
        if (r5 == r6) goto L_0x005a;
    L_0x0059:
        goto L_0x005e;
    L_0x005a:
        r5 = r0;
        r0 = r3;
        goto L_0x0060;
    L_0x005d:
        r0 = r1;
    L_0x005e:
        r5 = r0;
        r0 = r4;
    L_0x0060:
        if (r0 != 0) goto L_0x0093;
    L_0x0062:
        r9 = com.qihoo360.replugin.b.c.a;
        if (r9 == 0) goto L_0x008b;
    L_0x0066:
        r9 = com.qihoo360.replugin.RePlugin.getConfig();
        r9 = r9.g;
        if (r9 == 0) goto L_0x008b;
    L_0x006e:
        r9 = "ws001";
        r10 = new java.lang.StringBuilder;
        r0 = "layout.cache: new ignore plugin=";
        r10.<init>(r0);
        r0 = r7.d;
        r10.append(r0);
        r0 = " name=";
        r10.append(r0);
        r10.append(r8);
        r10 = r10.toString();
        com.qihoo360.replugin.b.c.a(r9, r10);
    L_0x008b:
        r9 = r7.e;
        r9 = r9.n;
        r9.add(r8);
        return r1;
    L_0x0093:
        r0 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x00ca }
        r1 = android.content.Context.class;	 Catch:{ Exception -> 0x00ca }
        r0[r4] = r1;	 Catch:{ Exception -> 0x00ca }
        r1 = android.util.AttributeSet.class;	 Catch:{ Exception -> 0x00ca }
        r0[r3] = r1;	 Catch:{ Exception -> 0x00ca }
        r0 = r5.getConstructor(r0);	 Catch:{ Exception -> 0x00ca }
        r1 = com.qihoo360.replugin.b.c.a;	 Catch:{ Exception -> 0x00ca }
        if (r1 == 0) goto L_0x00c2;	 Catch:{ Exception -> 0x00ca }
    L_0x00a5:
        r1 = "ws001";	 Catch:{ Exception -> 0x00ca }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ca }
        r6 = "layout.cache: new constructor. plugin=";	 Catch:{ Exception -> 0x00ca }
        r5.<init>(r6);	 Catch:{ Exception -> 0x00ca }
        r6 = r7.d;	 Catch:{ Exception -> 0x00ca }
        r5.append(r6);	 Catch:{ Exception -> 0x00ca }
        r6 = " name=";	 Catch:{ Exception -> 0x00ca }
        r5.append(r6);	 Catch:{ Exception -> 0x00ca }
        r5.append(r8);	 Catch:{ Exception -> 0x00ca }
        r5 = r5.toString();	 Catch:{ Exception -> 0x00ca }
        com.qihoo360.replugin.b.c.a(r1, r5);	 Catch:{ Exception -> 0x00ca }
    L_0x00c2:
        r1 = r7.e;	 Catch:{ Exception -> 0x00ca }
        r1 = r1.o;	 Catch:{ Exception -> 0x00ca }
        r1.put(r8, r0);	 Catch:{ Exception -> 0x00ca }
        goto L_0x00e9;
    L_0x00ca:
        r9 = move-exception;
        r0 = new android.view.InflateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r10 = r10.getPositionDescription();
        r1.append(r10);
        r10 = ": Error inflating mobilesafe class ";
        r1.append(r10);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8, r9);
        throw r0;
    L_0x00e9:
        r1 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x011f }
        r1[r4] = r9;	 Catch:{ Exception -> 0x011f }
        r1[r3] = r10;	 Catch:{ Exception -> 0x011f }
        r9 = r0.newInstance(r1);	 Catch:{ Exception -> 0x011f }
        r9 = (android.view.View) r9;	 Catch:{ Exception -> 0x011f }
        r0 = com.qihoo360.replugin.b.c.a;	 Catch:{ Exception -> 0x011f }
        if (r0 == 0) goto L_0x011e;	 Catch:{ Exception -> 0x011f }
    L_0x00f9:
        r0 = com.qihoo360.replugin.RePlugin.getConfig();	 Catch:{ Exception -> 0x011f }
        r0 = r0.g;	 Catch:{ Exception -> 0x011f }
        if (r0 == 0) goto L_0x011e;	 Catch:{ Exception -> 0x011f }
    L_0x0101:
        r0 = "ws001";	 Catch:{ Exception -> 0x011f }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x011f }
        r2 = "layout.cache: create view ok. plugin=";	 Catch:{ Exception -> 0x011f }
        r1.<init>(r2);	 Catch:{ Exception -> 0x011f }
        r2 = r7.d;	 Catch:{ Exception -> 0x011f }
        r1.append(r2);	 Catch:{ Exception -> 0x011f }
        r2 = " name=";	 Catch:{ Exception -> 0x011f }
        r1.append(r2);	 Catch:{ Exception -> 0x011f }
        r1.append(r8);	 Catch:{ Exception -> 0x011f }
        r1 = r1.toString();	 Catch:{ Exception -> 0x011f }
        com.qihoo360.replugin.b.c.a(r0, r1);	 Catch:{ Exception -> 0x011f }
    L_0x011e:
        return r9;
    L_0x011f:
        r9 = move-exception;
        r0 = new android.view.InflateException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r10 = r10.getPositionDescription();
        r1.append(r10);
        r10 = ": Error inflating mobilesafe class ";
        r1.append(r10);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8, r9);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.loader2.u.a(java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public final String getPackageName() {
        return super.getPackageName();
    }

    public final Context getApplicationContext() {
        if (this.e.c.h.getFrameworkVersion() <= 2) {
            return super.getApplicationContext();
        }
        if (this.e.c.p == null) {
            return this;
        }
        return this.e.c.p.c;
    }

    public final void startActivity(Intent intent) {
        if (!Factory2.startActivity((Context) this, intent)) {
            super.startActivity(intent);
        }
    }

    public final void startActivity(Intent intent, Bundle bundle) {
        if (!Factory2.startActivity((Context) this, intent)) {
            super.startActivity(intent, bundle);
        }
    }

    public final android.content.ComponentName startService(android.content.Intent r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.e;
        r0 = r0.c;
        r0 = r0.h;
        r0 = r0.getFrameworkVersion();
        r1 = 2;
        if (r0 > r1) goto L_0x0012;
    L_0x000d:
        r3 = super.startService(r3);
        return r3;
    L_0x0012:
        r0 = 1;
        r0 = com.qihoo360.replugin.component.service.PluginServiceClient.startService(r2, r3, r0);	 Catch:{ ShouldCallSystem -> 0x001a }
        return r0;
    L_0x0018:
        r3 = move-exception;
        goto L_0x001f;
    L_0x001a:
        r3 = super.startService(r3);	 Catch:{ all -> 0x0018 }
        return r3;
    L_0x001f:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.loader2.u.startService(android.content.Intent):android.content.ComponentName");
    }

    public final boolean stopService(android.content.Intent r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.e;
        r0 = r0.c;
        r0 = r0.h;
        r0 = r0.getFrameworkVersion();
        r1 = 2;
        if (r0 > r1) goto L_0x0012;
    L_0x000d:
        r3 = super.stopService(r3);
        return r3;
    L_0x0012:
        r0 = 1;
        r0 = com.qihoo360.replugin.component.service.PluginServiceClient.stopService(r2, r3, r0);	 Catch:{ ShouldCallSystem -> 0x0018 }
        return r0;
    L_0x0018:
        r3 = super.stopService(r3);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.loader2.u.stopService(android.content.Intent):boolean");
    }

    public final boolean bindService(android.content.Intent r3, android.content.ServiceConnection r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.e;
        r0 = r0.c;
        r0 = r0.h;
        r0 = r0.getFrameworkVersion();
        r1 = 2;
        if (r0 > r1) goto L_0x0012;
    L_0x000d:
        r3 = super.bindService(r3, r4, r5);
        return r3;
    L_0x0012:
        r0 = 1;
        r0 = com.qihoo360.replugin.component.service.PluginServiceClient.bindService(r2, r3, r4, r5, r0);	 Catch:{ ShouldCallSystem -> 0x0018 }
        return r0;
    L_0x0018:
        r3 = super.bindService(r3, r4, r5);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.loader2.u.bindService(android.content.Intent, android.content.ServiceConnection, int):boolean");
    }

    public final void unbindService(android.content.ServiceConnection r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.e;
        r0 = r0.c;
        r0 = r0.h;
        r0 = r0.getFrameworkVersion();
        r1 = 2;
        if (r0 > r1) goto L_0x0011;
    L_0x000d:
        super.unbindService(r3);
        return;
    L_0x0011:
        super.unbindService(r3);	 Catch:{ Throwable -> 0x0014 }
    L_0x0014:
        r0 = 0;
        com.qihoo360.replugin.component.service.PluginServiceClient.unbindService(r2, r3, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.loader2.u.unbindService(android.content.ServiceConnection):void");
    }

    public final String getPackageCodePath() {
        if (this.e.c.h.getFrameworkVersion() <= 2) {
            return super.getPackageCodePath();
        }
        return this.e.b;
    }

    public final ApplicationInfo getApplicationInfo() {
        if (this.e.c.h.getFrameworkVersion() <= 2) {
            return super.getApplicationInfo();
        }
        return this.e.h.getApplication();
    }
}
