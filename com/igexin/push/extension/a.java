package com.igexin.push.extension;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import com.igexin.push.core.bean.f;
import com.igexin.push.core.c.h;
import com.igexin.push.core.g;
import com.igexin.push.extension.stub.IPushExtension;
import com.igexin.push.util.e;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class a {
    private static String a = "com.igexin.push.extension.a";
    private static a c;
    private List<IPushExtension> b = new ArrayList();

    private a() {
    }

    public static a a() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    private void a(f fVar) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) g.f.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1 && activeNetworkInfo.isConnected()) {
            new Thread(new h(g.f, fVar, true)).start();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("|init ext not exist, is wifi state = false");
        com.igexin.b.a.c.a.b(stringBuilder.toString());
    }

    private void a(f fVar, File file) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(g.ab);
        stringBuilder.append("/");
        stringBuilder.append(fVar.c());
        File file2 = new File(stringBuilder.toString());
        if (file2.exists() && fVar.f().equals(com.igexin.b.b.a.a(g.f, file2.getAbsolutePath()))) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|public local file match the condition");
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            if (file.createNewFile()) {
                if (e.a(file2, file, fVar.f())) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(a);
                    stringBuilder2.append("|restart the service to load ext = ");
                    stringBuilder2.append(file.getAbsolutePath());
                    com.igexin.b.a.c.a.b(stringBuilder2.toString());
                    Process.killProcess(Process.myPid());
                    return;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append("|copy ");
                stringBuilder.append(file2.getAbsolutePath());
                stringBuilder.append(" to ");
                stringBuilder.append(file.getAbsolutePath());
                stringBuilder.append(" failed...");
                com.igexin.b.a.c.a.b(stringBuilder.toString());
                e.b(fVar.c());
            }
        }
    }

    private boolean a(Context context, f fVar, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (fVar.h() != 0) {
            if (fVar.i() + fVar.h() >= currentTimeMillis) {
            }
            e.b(fVar.c());
            return false;
        }
        if (a(context, str, fVar.d(), fVar.j(), fVar.c()) && fVar.i() != 0) {
            fVar.b(currentTimeMillis);
        }
        if (!fVar.g()) {
            return true;
        }
        e.b(fVar.c());
        return false;
    }

    private void b(Context context) {
        StringBuilder stringBuilder;
        List<String> arrayList = new ArrayList();
        arrayList.add("com.igexin.push.extension.distribution.basic.stub.PushExtension");
        arrayList.add("com.igexin.push.extension.distribution.gbd.stub.PushExtension");
        arrayList.add("com.igexin.push.extension.distribution.lbs.stub.PushExtension");
        arrayList.add("com.igexin.push.extension.distribution.diagnosis.stub.PushExtension");
        arrayList.add("com.igexin.push.extension.distribution.gks.stub.PushExtension");
        for (String str : arrayList) {
            try {
                IPushExtension iPushExtension = (IPushExtension) context.getClassLoader().loadClass(str).newInstance();
                iPushExtension.init(g.f);
                this.b.add(iPushExtension);
                stringBuilder = new StringBuilder("[main] extension loaded(mock): ");
                stringBuilder.append(str);
                com.igexin.b.a.c.a.b(stringBuilder.toString());
            } catch (Exception e) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append(e.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
            }
        }
    }

    public boolean a(android.content.Context r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = 1;
        r1 = com.igexin.push.config.m.s;	 Catch:{ Throwable -> 0x00ba }
        if (r1 != 0) goto L_0x0009;	 Catch:{ Throwable -> 0x00ba }
    L_0x0005:
        r9.b(r10);	 Catch:{ Throwable -> 0x00ba }
        return r0;	 Catch:{ Throwable -> 0x00ba }
    L_0x0009:
        r1 = com.igexin.push.config.m.s;	 Catch:{ Throwable -> 0x00ba }
        r1 = r1.b();	 Catch:{ Throwable -> 0x00ba }
        r2 = r1.entrySet();	 Catch:{ Throwable -> 0x00ba }
        r2 = r2.iterator();	 Catch:{ Throwable -> 0x00ba }
        r3 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x00ba }
        r3.<init>();	 Catch:{ Throwable -> 0x00ba }
    L_0x001c:
        r4 = r2.hasNext();	 Catch:{ Throwable -> 0x00ba }
        if (r4 == 0) goto L_0x007a;	 Catch:{ Throwable -> 0x00ba }
    L_0x0022:
        r4 = r2.next();	 Catch:{ Throwable -> 0x00ba }
        r4 = (java.util.Map.Entry) r4;	 Catch:{ Throwable -> 0x00ba }
        r5 = r4.getKey();	 Catch:{ Throwable -> 0x00ba }
        r5 = (java.lang.Integer) r5;	 Catch:{ Throwable -> 0x00ba }
        r5 = r5.intValue();	 Catch:{ Throwable -> 0x00ba }
        r4 = r4.getValue();	 Catch:{ Throwable -> 0x00ba }
        r4 = (com.igexin.push.core.bean.f) r4;	 Catch:{ Throwable -> 0x00ba }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00ba }
        r6.<init>();	 Catch:{ Throwable -> 0x00ba }
        r7 = com.igexin.push.core.g.ac;	 Catch:{ Throwable -> 0x00ba }
        r6.append(r7);	 Catch:{ Throwable -> 0x00ba }
        r7 = "/";	 Catch:{ Throwable -> 0x00ba }
        r6.append(r7);	 Catch:{ Throwable -> 0x00ba }
        r7 = r4.c();	 Catch:{ Throwable -> 0x00ba }
        r6.append(r7);	 Catch:{ Throwable -> 0x00ba }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x00ba }
        r7 = new java.io.File;	 Catch:{ Throwable -> 0x00ba }
        r7.<init>(r6);	 Catch:{ Throwable -> 0x00ba }
        r8 = r7.exists();	 Catch:{ Throwable -> 0x00ba }
        if (r8 == 0) goto L_0x006b;	 Catch:{ Throwable -> 0x00ba }
    L_0x005d:
        r4 = r9.a(r10, r4, r6);	 Catch:{ Throwable -> 0x00ba }
        if (r4 != 0) goto L_0x001c;	 Catch:{ Throwable -> 0x00ba }
    L_0x0063:
        r4 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x00ba }
        r3.add(r4);	 Catch:{ Throwable -> 0x00ba }
        goto L_0x001c;
    L_0x006b:
        r9.a(r4, r7);	 Catch:{ Throwable -> 0x006f }
        goto L_0x0076;
    L_0x006f:
        r5 = r4.c();	 Catch:{ Throwable -> 0x00ba }
        com.igexin.push.util.e.b(r5);	 Catch:{ Throwable -> 0x00ba }
    L_0x0076:
        r9.a(r4);	 Catch:{ Throwable -> 0x00ba }
        goto L_0x001c;	 Catch:{ Throwable -> 0x00ba }
    L_0x007a:
        r10 = r3.isEmpty();	 Catch:{ Throwable -> 0x00ba }
        if (r10 != 0) goto L_0x00d8;	 Catch:{ Throwable -> 0x00ba }
    L_0x0080:
        r10 = r3.iterator();	 Catch:{ Throwable -> 0x00ba }
    L_0x0084:
        r2 = r10.hasNext();	 Catch:{ Throwable -> 0x00ba }
        if (r2 == 0) goto L_0x009c;	 Catch:{ Throwable -> 0x00ba }
    L_0x008a:
        r2 = r10.next();	 Catch:{ Throwable -> 0x00ba }
        r2 = (java.lang.Integer) r2;	 Catch:{ Throwable -> 0x00ba }
        r2 = r2.intValue();	 Catch:{ Throwable -> 0x00ba }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Throwable -> 0x00ba }
        r1.remove(r2);	 Catch:{ Throwable -> 0x00ba }
        goto L_0x0084;	 Catch:{ Throwable -> 0x00ba }
    L_0x009c:
        r10 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00ba }
        r10.<init>();	 Catch:{ Throwable -> 0x00ba }
        r1 = a;	 Catch:{ Throwable -> 0x00ba }
        r10.append(r1);	 Catch:{ Throwable -> 0x00ba }
        r1 = "|ext info info changed, save new exts";	 Catch:{ Throwable -> 0x00ba }
        r10.append(r1);	 Catch:{ Throwable -> 0x00ba }
        r10 = r10.toString();	 Catch:{ Throwable -> 0x00ba }
        com.igexin.b.a.c.a.b(r10);	 Catch:{ Throwable -> 0x00ba }
        r10 = com.igexin.push.config.a.a();	 Catch:{ Throwable -> 0x00ba }
        r10.g();	 Catch:{ Throwable -> 0x00ba }
        return r0;
    L_0x00ba:
        r10 = move-exception;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = a;
        r1.append(r2);
        r2 = "|";
        r1.append(r2);
        r10 = r10.toString();
        r1.append(r10);
        r10 = r1.toString();
        com.igexin.b.a.c.a.b(r10);
    L_0x00d8:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.a.a(android.content.Context):boolean");
    }

    public boolean a(Context context, String str, String str2, String str3, String str4) {
        StringBuilder stringBuilder;
        File file = new File(str);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(ShareConstants.JAR_SUFFIX);
        File file2 = new File(stringBuilder2.toString());
        e.a(context.getFilesDir().getAbsolutePath(), str4, false);
        e.b(file, file2, str3);
        if (file2.exists()) {
            Class loadClass;
            try {
                loadClass = new DexClassLoader(file2.getAbsolutePath(), context.getFilesDir().getAbsolutePath(), null, context.getClassLoader()).loadClass(str2);
            } catch (Exception e) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(a);
                stringBuilder3.append("|");
                stringBuilder3.append(e.toString());
                com.igexin.b.a.c.a.b(stringBuilder3.toString());
                loadClass = null;
            } catch (Throwable th) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append("|");
                stringBuilder.append(th.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
                if (file2.exists()) {
                    file2.delete();
                }
            }
            file2.delete();
            e.a(context.getFilesDir().getAbsolutePath(), str4, true);
            if (loadClass == null) {
                return false;
            }
            IPushExtension iPushExtension = (IPushExtension) loadClass.newInstance();
            if (iPushExtension != null) {
                try {
                    iPushExtension.init(g.f);
                    this.b.add(iPushExtension);
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append(a);
                    stringBuilder4.append("| [main] extension loaded: ");
                    stringBuilder4.append(str);
                    com.igexin.b.a.c.a.b(stringBuilder4.toString());
                    return true;
                } catch (Exception e2) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(a);
                    stringBuilder.append("|");
                    stringBuilder.append(e2.toString());
                    com.igexin.b.a.c.a.b(stringBuilder.toString());
                    return false;
                }
            }
        }
        return false;
    }

    public void b() {
        for (IPushExtension onDestroy : this.b) {
            onDestroy.onDestroy();
        }
    }

    public List<IPushExtension> c() {
        return this.b;
    }
}
