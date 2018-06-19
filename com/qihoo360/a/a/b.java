package com.qihoo360.a.a;

import android.app.Application;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.utils.e;

/* compiled from: PatchClassLoaderUtils */
public final class b {
    public static boolean a(Application application) {
        try {
            Object baseContext = application.getBaseContext();
            if (baseContext == null) {
                new StringBuilder("pclu.p: nf mb. ap cl=").append(application.getClass());
                return false;
            }
            Object a = e.a(baseContext, "mPackageInfo");
            if (a == null) {
                new StringBuilder("pclu.p: nf mpi. mb cl=").append(baseContext.getClass());
                return false;
            }
            StringBuilder stringBuilder;
            if (c.a) {
                stringBuilder = new StringBuilder("patch: mBase cl=");
                stringBuilder.append(baseContext.getClass());
                stringBuilder.append("; mPackageInfo cl=");
                stringBuilder.append(a.getClass());
            }
            ClassLoader classLoader = (ClassLoader) e.a(a, "mClassLoader");
            if (classLoader == null) {
                stringBuilder = new StringBuilder("pclu.p: nf mpi. mb cl=");
                stringBuilder.append(baseContext.getClass());
                stringBuilder.append("; mpi cl=");
                stringBuilder.append(a.getClass());
                return false;
            }
            RePlugin.getConfig();
            Object eVar = new com.qihoo360.replugin.e(classLoader.getParent(), classLoader);
            e.a(a.getClass(), a, "mClassLoader", eVar);
            Thread.currentThread().setContextClassLoader(eVar);
            application = c.a;
            return true;
        } catch (Application application2) {
            application2.printStackTrace();
            return false;
        }
    }
}
