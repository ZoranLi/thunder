package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.constants.Constants.PLUGIN;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.FileUtil;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Map;

public class PM {
    private static final Map<Class<?>, String> k = new 2();
    private final Context a;
    private String b;
    private File c;
    private int d;
    private DexClassLoader e;
    private RandomAccessFile f;
    private FileLock g;
    private boolean h;
    private a i;
    private a j = new 1(this);

    public interface a {
        void onLoadFail();

        void onLoadSuccess();
    }

    public PM(Context context, a aVar) {
        this.a = context.getApplicationContext();
        this.i = aVar;
        this.h = d();
        if (b()) {
            a();
        }
    }

    private void a() {
        StringBuilder stringBuilder = new StringBuilder("PluginFile:\t");
        stringBuilder.append(this.c == null ? "null" : this.c.getAbsolutePath());
        GDTLogger.d(stringBuilder.toString());
        if (this.b != null) {
            try {
                this.e = new DexClassLoader(this.c.getAbsolutePath(), this.a.getDir("e_qq_com_dex", 0).getAbsolutePath(), null, getClass().getClassLoader());
                if (this.i != null) {
                    this.i.onLoadSuccess();
                }
                return;
            } catch (Throwable th) {
                GDTLogger.e("exception while init plugin class loader", th);
                e();
                return;
            }
        }
        this.e = null;
    }

    static /* synthetic */ void a(PM pm) {
        try {
            if (pm.e == null && pm.c()) {
                pm.a();
            }
        } catch (Throwable e) {
            GDTLogger.report("Exception while init online plugin: ", e);
            pm.e();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b() {
        /*
        r5 = this;
        r0 = 0;
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x006a }
        r2 = "TimeStap_BEFORE_PLUGIN_INIT:";
        r1.<init>(r2);	 Catch:{ Throwable -> 0x006a }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x006a }
        r1.append(r2);	 Catch:{ Throwable -> 0x006a }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x006a }
        com.qq.e.comm.util.GDTLogger.d(r1);	 Catch:{ Throwable -> 0x006a }
        r1 = r5.c();	 Catch:{ Throwable -> 0x006a }
        r2 = 1;
        if (r1 != 0) goto L_0x0051;
    L_0x001d:
        r1 = r5.h;	 Catch:{ Throwable -> 0x006a }
        if (r1 != 0) goto L_0x0023;
    L_0x0021:
        r1 = r0;
        goto L_0x004f;
    L_0x0023:
        r1 = r5.a;	 Catch:{ Throwable -> 0x006a }
        r3 = r5.a;	 Catch:{ Throwable -> 0x006a }
        r3 = com.qq.e.comm.managers.plugin.PM.1.a(r3);	 Catch:{ Throwable -> 0x006a }
        r4 = r5.a;	 Catch:{ Throwable -> 0x006a }
        r4 = com.qq.e.comm.managers.plugin.PM.1.c(r4);	 Catch:{ Throwable -> 0x006a }
        r1 = com.qq.e.comm.a.a(r1, r3, r4);	 Catch:{ Throwable -> 0x006a }
        if (r1 == 0) goto L_0x0049;
    L_0x0037:
        r1 = "nnSQtz6g995yYAb5BWLTD3bIlltOHRcjfQc52+QATMdyuAmkxz4//PTywog6lpV93cz68I2BG7o5zWReG+qC28aEq1ajkSbuYhPDCik51f+tUKGQcsWqmnjEoAwlCNufWnqK1Vxx92SDQIV7U5Q+gOawaPUSGD6QOx/dYba16TU=";
        r5.b = r1;	 Catch:{ Throwable -> 0x006a }
        r1 = r5.a;	 Catch:{ Throwable -> 0x006a }
        r1 = com.qq.e.comm.managers.plugin.PM.1.a(r1);	 Catch:{ Throwable -> 0x006a }
        r5.c = r1;	 Catch:{ Throwable -> 0x006a }
        r1 = 559; // 0x22f float:7.83E-43 double:2.76E-321;
        r5.d = r1;	 Catch:{ Throwable -> 0x006a }
        r1 = r2;
        goto L_0x004f;
    L_0x0049:
        r1 = "Fail to prepair Defult plugin ";
        com.qq.e.comm.util.GDTLogger.e(r1);	 Catch:{ Throwable -> 0x006a }
        goto L_0x0021;
    L_0x004f:
        if (r1 == 0) goto L_0x0052;
    L_0x0051:
        r0 = r2;
    L_0x0052:
        r1 = new java.lang.StringBuilder;
        r2 = "TimeStap_AFTER_PLUGIN_INIT:";
        r1.<init>(r2);
    L_0x0059:
        r2 = java.lang.System.currentTimeMillis();
        r1.append(r2);
        r1 = r1.toString();
        com.qq.e.comm.util.GDTLogger.d(r1);
        return r0;
    L_0x0068:
        r0 = move-exception;
        goto L_0x0078;
    L_0x006a:
        r1 = move-exception;
        r2 = "Exception while init plugin manager";
        com.qq.e.comm.util.GDTLogger.report(r2, r1);	 Catch:{ all -> 0x0068 }
        r1 = new java.lang.StringBuilder;
        r2 = "TimeStap_AFTER_PLUGIN_INIT:";
        r1.<init>(r2);
        goto L_0x0059;
    L_0x0078:
        r1 = new java.lang.StringBuilder;
        r2 = "TimeStap_AFTER_PLUGIN_INIT:";
        r1.<init>(r2);
        r2 = java.lang.System.currentTimeMillis();
        r1.append(r2);
        r1 = r1.toString();
        com.qq.e.comm.util.GDTLogger.d(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.PM.b():boolean");
    }

    private boolean d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.a;	 Catch:{ Throwable -> 0x0046 }
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x0046 }
        r3 = "e_qq_com_plugin";	 Catch:{ Throwable -> 0x0046 }
        r1 = r1.getDir(r3, r0);	 Catch:{ Throwable -> 0x0046 }
        r3 = "update_lc";	 Catch:{ Throwable -> 0x0046 }
        r2.<init>(r1, r3);	 Catch:{ Throwable -> 0x0046 }
        r1 = r2.exists();	 Catch:{ Throwable -> 0x0046 }
        if (r1 != 0) goto L_0x001e;	 Catch:{ Throwable -> 0x0046 }
    L_0x0016:
        r2.createNewFile();	 Catch:{ Throwable -> 0x0046 }
        r1 = "lock";	 Catch:{ Throwable -> 0x0046 }
        com.qq.e.comm.util.StringUtil.writeTo(r1, r2);	 Catch:{ Throwable -> 0x0046 }
    L_0x001e:
        r1 = r2.exists();	 Catch:{ Throwable -> 0x0046 }
        if (r1 != 0) goto L_0x0025;	 Catch:{ Throwable -> 0x0046 }
    L_0x0024:
        return r0;	 Catch:{ Throwable -> 0x0046 }
    L_0x0025:
        r1 = new java.io.RandomAccessFile;	 Catch:{ Throwable -> 0x0046 }
        r3 = "rw";	 Catch:{ Throwable -> 0x0046 }
        r1.<init>(r2, r3);	 Catch:{ Throwable -> 0x0046 }
        r4.f = r1;	 Catch:{ Throwable -> 0x0046 }
        r1 = r4.f;	 Catch:{ Throwable -> 0x0046 }
        r1 = r1.getChannel();	 Catch:{ Throwable -> 0x0046 }
        r1 = r1.tryLock();	 Catch:{ Throwable -> 0x0046 }
        r4.g = r1;	 Catch:{ Throwable -> 0x0046 }
        r1 = r4.g;	 Catch:{ Throwable -> 0x0046 }
        if (r1 == 0) goto L_0x0046;	 Catch:{ Throwable -> 0x0046 }
    L_0x003e:
        r1 = r4.f;	 Catch:{ Throwable -> 0x0046 }
        r2 = 37;	 Catch:{ Throwable -> 0x0046 }
        r1.writeByte(r2);	 Catch:{ Throwable -> 0x0046 }
        r0 = 1;
    L_0x0046:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.PM.d():boolean");
    }

    private void e() {
        if (this.i != null) {
            this.i.onLoadFail();
        }
    }

    public <T> T getFactory(Class<T> cls) throws b {
        StringBuilder stringBuilder = new StringBuilder("GetFactoryInstaceforInterface:");
        stringBuilder.append(cls);
        GDTLogger.d(stringBuilder.toString());
        ClassLoader classLoader = this.e;
        StringBuilder stringBuilder2 = new StringBuilder("PluginClassLoader is parent");
        stringBuilder2.append(getClass().getClassLoader() == classLoader);
        GDTLogger.d(stringBuilder2.toString());
        if (classLoader == null) {
            stringBuilder2 = new StringBuilder("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:");
            stringBuilder2.append(cls);
            throw new b(stringBuilder2.toString());
        }
        try {
            String str = (String) k.get(cls);
            if (StringUtil.isEmpty(str)) {
                stringBuilder2 = new StringBuilder("factory  implemention name is not specified for interface:");
                stringBuilder2.append(cls.getName());
                throw new b(stringBuilder2.toString());
            }
            Class loadClass = classLoader.loadClass(str);
            T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", new Class[0]).invoke(loadClass, new Object[0]));
            stringBuilder2 = new StringBuilder("ServiceDelegateFactory =");
            stringBuilder2.append(cast);
            GDTLogger.d(stringBuilder2.toString());
            return cast;
        } catch (Throwable th) {
            StringBuilder stringBuilder3 = new StringBuilder("Fail to getfactory implement instance for interface:");
            stringBuilder3.append(cls.getName());
            b bVar = new b(stringBuilder3.toString(), th);
        }
    }

    public String getLocalSig() {
        return this.b;
    }

    public POFactory getPOFactory() throws b {
        return (POFactory) getFactory(POFactory.class);
    }

    public int getPluginVersion() {
        return this.d;
    }

    public void update(String str, String str2) {
        if (this.h) {
            a aVar = new a(this.a);
            aVar.a(this.j);
            aVar.a(str, str2);
        }
    }

    private boolean c() {
        c cVar;
        if (this.h) {
            cVar = new c(1.b(this.a), 1.d(this.a));
            if (cVar.a()) {
                boolean z;
                StringBuilder stringBuilder;
                File a = 1.a(this.a);
                File c = 1.c(this.a);
                if (a.equals(cVar.a) || FileUtil.renameTo(cVar.a, a)) {
                    if (!c.equals(cVar.b)) {
                        if (FileUtil.renameTo(cVar.b, c)) {
                        }
                    }
                    z = true;
                    stringBuilder = new StringBuilder("NextExist,Updated=");
                    stringBuilder.append(z);
                    GDTLogger.d(stringBuilder.toString());
                }
                z = false;
                stringBuilder = new StringBuilder("NextExist,Updated=");
                stringBuilder.append(z);
                GDTLogger.d(stringBuilder.toString());
            }
        }
        cVar = new c(1.a(this.a), 1.c(this.a));
        if (!cVar.a()) {
            return false;
        }
        if (cVar.d < PLUGIN.ASSET_PLUGIN_VERSION) {
            StringBuilder stringBuilder2 = new StringBuilder("last updated plugin version =");
            stringBuilder2.append(this.d);
            stringBuilder2.append(";asset plugin version=559");
            GDTLogger.d(stringBuilder2.toString());
            return false;
        }
        this.b = cVar.c;
        this.d = cVar.d;
        this.c = 1.a(this.a);
        return true;
    }
}
