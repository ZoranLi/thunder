package org.apache.commons.logging;

import java.lang.reflect.Constructor;
import java.util.Hashtable;

public class LogSource {
    protected static boolean jdk14IsAvailable = false;
    protected static boolean log4jIsAvailable = false;
    protected static Constructor logImplctor;
    protected static Hashtable logs = new Hashtable();

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.util.Hashtable;
        r0.<init>();
        logs = r0;
        r0 = 1;
        r1 = 0;
        r2 = "org.apache.log4j.Logger";	 Catch:{ Throwable -> 0x0017 }
        r2 = java.lang.Class.forName(r2);	 Catch:{ Throwable -> 0x0017 }
        if (r2 == 0) goto L_0x0014;	 Catch:{ Throwable -> 0x0017 }
    L_0x0011:
        log4jIsAvailable = r0;	 Catch:{ Throwable -> 0x0017 }
        goto L_0x0019;	 Catch:{ Throwable -> 0x0017 }
    L_0x0014:
        log4jIsAvailable = r1;	 Catch:{ Throwable -> 0x0017 }
        goto L_0x0019;
    L_0x0017:
        log4jIsAvailable = r1;
    L_0x0019:
        r2 = "java.util.logging.Logger";	 Catch:{ Throwable -> 0x002f }
        r2 = java.lang.Class.forName(r2);	 Catch:{ Throwable -> 0x002f }
        if (r2 == 0) goto L_0x002c;	 Catch:{ Throwable -> 0x002f }
    L_0x0021:
        r2 = "org.apache.commons.logging.impl.Jdk14Logger";	 Catch:{ Throwable -> 0x002f }
        r2 = java.lang.Class.forName(r2);	 Catch:{ Throwable -> 0x002f }
        if (r2 == 0) goto L_0x002c;	 Catch:{ Throwable -> 0x002f }
    L_0x0029:
        jdk14IsAvailable = r0;	 Catch:{ Throwable -> 0x002f }
        goto L_0x0031;	 Catch:{ Throwable -> 0x002f }
    L_0x002c:
        jdk14IsAvailable = r1;	 Catch:{ Throwable -> 0x002f }
        goto L_0x0031;
    L_0x002f:
        jdk14IsAvailable = r1;
    L_0x0031:
        r0 = 0;
        r1 = "org.apache.commons.logging.log";	 Catch:{ Throwable -> 0x0042 }
        r1 = java.lang.System.getProperty(r1);	 Catch:{ Throwable -> 0x0042 }
        if (r1 != 0) goto L_0x0041;
    L_0x003a:
        r0 = "org.apache.commons.logging.Log";	 Catch:{ Throwable -> 0x0041 }
        r0 = java.lang.System.getProperty(r0);	 Catch:{ Throwable -> 0x0041 }
        goto L_0x0042;
    L_0x0041:
        r0 = r1;
    L_0x0042:
        if (r0 == 0) goto L_0x004f;
    L_0x0044:
        setLogImplementation(r0);	 Catch:{ Throwable -> 0x0048 }
        return;
    L_0x0048:
        r0 = "org.apache.commons.logging.impl.NoOpLog";	 Catch:{ Throwable -> 0x004e }
        setLogImplementation(r0);	 Catch:{ Throwable -> 0x004e }
        return;
    L_0x004e:
        return;
    L_0x004f:
        r0 = log4jIsAvailable;	 Catch:{ Throwable -> 0x0069 }
        if (r0 == 0) goto L_0x0059;	 Catch:{ Throwable -> 0x0069 }
    L_0x0053:
        r0 = "org.apache.commons.logging.impl.Log4JLogger";	 Catch:{ Throwable -> 0x0069 }
        setLogImplementation(r0);	 Catch:{ Throwable -> 0x0069 }
        return;	 Catch:{ Throwable -> 0x0069 }
    L_0x0059:
        r0 = jdk14IsAvailable;	 Catch:{ Throwable -> 0x0069 }
        if (r0 == 0) goto L_0x0063;	 Catch:{ Throwable -> 0x0069 }
    L_0x005d:
        r0 = "org.apache.commons.logging.impl.Jdk14Logger";	 Catch:{ Throwable -> 0x0069 }
        setLogImplementation(r0);	 Catch:{ Throwable -> 0x0069 }
        return;	 Catch:{ Throwable -> 0x0069 }
    L_0x0063:
        r0 = "org.apache.commons.logging.impl.NoOpLog";	 Catch:{ Throwable -> 0x0069 }
        setLogImplementation(r0);	 Catch:{ Throwable -> 0x0069 }
        return;
    L_0x0069:
        r0 = "org.apache.commons.logging.impl.NoOpLog";	 Catch:{ Throwable -> 0x006f }
        setLogImplementation(r0);	 Catch:{ Throwable -> 0x006f }
        return;
    L_0x006f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.LogSource.<clinit>():void");
    }

    private LogSource() {
    }

    public static void setLogImplementation(java.lang.String r3) throws java.lang.LinkageError, java.lang.ExceptionInInitializerError, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.ClassNotFoundException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x0017 }
        r0 = 1;	 Catch:{ Throwable -> 0x0017 }
        r0 = new java.lang.Class[r0];	 Catch:{ Throwable -> 0x0017 }
        r1 = 0;	 Catch:{ Throwable -> 0x0017 }
        r2 = "";	 Catch:{ Throwable -> 0x0017 }
        r2 = r2.getClass();	 Catch:{ Throwable -> 0x0017 }
        r0[r1] = r2;	 Catch:{ Throwable -> 0x0017 }
        r3 = r3.getConstructor(r0);	 Catch:{ Throwable -> 0x0017 }
        logImplctor = r3;	 Catch:{ Throwable -> 0x0017 }
        return;
    L_0x0017:
        r3 = 0;
        logImplctor = r3;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.LogSource.setLogImplementation(java.lang.String):void");
    }

    public static void setLogImplementation(Class cls) throws LinkageError, ExceptionInInitializerError, NoSuchMethodException, SecurityException {
        logImplctor = cls.getConstructor(new Class[]{"".getClass()});
    }

    public static Log getInstance(String str) {
        Log log = (Log) logs.get(str);
        if (log != null) {
            return log;
        }
        log = makeNewLogInstance(str);
        logs.put(str, log);
        return log;
    }

    public static Log getInstance(Class cls) {
        return getInstance(cls.getName());
    }

    public static org.apache.commons.logging.Log makeNewLogInstance(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 1;
        r0 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x000f }
        r1 = 0;	 Catch:{ Throwable -> 0x000f }
        r0[r1] = r2;	 Catch:{ Throwable -> 0x000f }
        r1 = logImplctor;	 Catch:{ Throwable -> 0x000f }
        r0 = r1.newInstance(r0);	 Catch:{ Throwable -> 0x000f }
        r0 = (org.apache.commons.logging.Log) r0;	 Catch:{ Throwable -> 0x000f }
        goto L_0x0010;
    L_0x000f:
        r0 = 0;
    L_0x0010:
        if (r0 != 0) goto L_0x0017;
    L_0x0012:
        r0 = new org.apache.commons.logging.impl.NoOpLog;
        r0.<init>(r2);
    L_0x0017:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.LogSource.makeNewLogInstance(java.lang.String):org.apache.commons.logging.Log");
    }

    public static String[] getLogNames() {
        return (String[]) logs.keySet().toArray(new String[logs.size()]);
    }
}
