package org.apache.commons.logging.impl;

import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.android.agoo.common.AgooConstants;
import org.apache.commons.logging.Log;

public class SimpleLog implements Log {
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_DEBUG = 2;
    public static final int LOG_LEVEL_ERROR = 5;
    public static final int LOG_LEVEL_FATAL = 6;
    public static final int LOG_LEVEL_INFO = 3;
    public static final int LOG_LEVEL_OFF = 7;
    public static final int LOG_LEVEL_TRACE = 1;
    public static final int LOG_LEVEL_WARN = 4;
    static Class class$java$lang$Thread = null;
    static Class class$org$apache$commons$logging$impl$SimpleLog = null;
    protected static DateFormat dateFormatter = new SimpleDateFormat(getStringProperty("org.apache.commons.logging.simplelog.dateformat", "yyyy/MM/dd HH:mm:ss:SSS zzz"));
    protected static boolean showDateTime = getBooleanProperty("org.apache.commons.logging.simplelog.showdatetime", showDateTime);
    protected static boolean showLogName = false;
    protected static boolean showShortName = getBooleanProperty("org.apache.commons.logging.simplelog.showShortLogname", showShortName);
    protected static final Properties simpleLogProps = new Properties();
    protected static final String systemPrefix = "org.apache.commons.logging.simplelog.";
    protected int currentLogLevel;
    protected String logName = null;
    private String prefix = null;

    class AnonymousClass1 implements PrivilegedAction {
        private final String val$name;

        AnonymousClass1(String str) {
            this.val$name = str;
        }

        public Object run() {
            ClassLoader access$000 = SimpleLog.access$000();
            if (access$000 != null) {
                return access$000.getResourceAsStream(this.val$name);
            }
            return ClassLoader.getSystemResourceAsStream(this.val$name);
        }
    }

    static ClassLoader access$000() {
        return getContextClassLoader();
    }

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.util.Properties;
        r0.<init>();
        simpleLogProps = r0;
        r0 = "simplelog.properties";
        r0 = getResourceAsStream(r0);
        if (r0 == 0) goto L_0x0017;
    L_0x000f:
        r1 = simpleLogProps;	 Catch:{ IOException -> 0x0017 }
        r1.load(r0);	 Catch:{ IOException -> 0x0017 }
        r0.close();	 Catch:{ IOException -> 0x0017 }
    L_0x0017:
        r0 = "org.apache.commons.logging.simplelog.showlogname";
        r1 = showLogName;
        r0 = getBooleanProperty(r0, r1);
        showLogName = r0;
        r0 = "org.apache.commons.logging.simplelog.showShortLogname";
        r1 = showShortName;
        r0 = getBooleanProperty(r0, r1);
        showShortName = r0;
        r0 = "org.apache.commons.logging.simplelog.showdatetime";
        r1 = showDateTime;
        r0 = getBooleanProperty(r0, r1);
        showDateTime = r0;
        r0 = "org.apache.commons.logging.simplelog.showlogname";
        r1 = showLogName;
        r0 = getBooleanProperty(r0, r1);
        showLogName = r0;
        r0 = showDateTime;
        if (r0 == 0) goto L_0x0052;
    L_0x0043:
        r0 = new java.text.SimpleDateFormat;
        r1 = "org.apache.commons.logging.simplelog.dateformat";
        r2 = "yyyy/MM/dd HH:mm:ss:SSS zzz";
        r1 = getStringProperty(r1, r2);
        r0.<init>(r1);
        dateFormatter = r0;
    L_0x0052:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.impl.SimpleLog.<clinit>():void");
    }

    private static String getStringProperty(String str) {
        String property = System.getProperty(str);
        return property == null ? simpleLogProps.getProperty(str) : property;
    }

    private static String getStringProperty(String str, String str2) {
        str = getStringProperty(str);
        return str == null ? str2 : str;
    }

    private static boolean getBooleanProperty(String str, boolean z) {
        str = getStringProperty(str);
        if (str == null) {
            return z;
        }
        return "true".equalsIgnoreCase(str);
    }

    public SimpleLog(String str) {
        this.logName = str;
        setLevel(3);
        StringBuffer stringBuffer = new StringBuffer("org.apache.commons.logging.simplelog.log.");
        stringBuffer.append(this.logName);
        String stringProperty = getStringProperty(stringBuffer.toString());
        int lastIndexOf = String.valueOf(str).lastIndexOf(".");
        while (stringProperty == null) {
            if (lastIndexOf < 0) {
                break;
            }
            str = str.substring(0, lastIndexOf);
            stringBuffer = new StringBuffer("org.apache.commons.logging.simplelog.log.");
            stringBuffer.append(str);
            stringProperty = getStringProperty(stringBuffer.toString());
            lastIndexOf = String.valueOf(str).lastIndexOf(".");
        }
        if (stringProperty == null) {
            stringProperty = getStringProperty("org.apache.commons.logging.simplelog.defaultlog");
        }
        if ("all".equalsIgnoreCase(stringProperty) != null) {
            setLevel(0);
        } else if (AgooConstants.MESSAGE_TRACE.equalsIgnoreCase(stringProperty) != null) {
            setLevel(1);
        } else if ("debug".equalsIgnoreCase(stringProperty) != null) {
            setLevel(2);
        } else if ("info".equalsIgnoreCase(stringProperty) != null) {
            setLevel(3);
        } else if ("warn".equalsIgnoreCase(stringProperty) != null) {
            setLevel(4);
        } else if ("error".equalsIgnoreCase(stringProperty) != null) {
            setLevel(5);
        } else if ("fatal".equalsIgnoreCase(stringProperty) != null) {
            setLevel(6);
        } else {
            if ("off".equalsIgnoreCase(stringProperty) != null) {
                setLevel(7);
            }
        }
    }

    public void setLevel(int i) {
        this.currentLogLevel = i;
    }

    public int getLevel() {
        return this.currentLogLevel;
    }

    protected void log(int i, Object obj, Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        if (showDateTime) {
            stringBuffer.append(dateFormatter.format(new Date()));
            stringBuffer.append(" ");
        }
        switch (i) {
            case 1:
                stringBuffer.append("[TRACE] ");
                break;
            case 2:
                stringBuffer.append("[DEBUG] ");
                break;
            case 3:
                stringBuffer.append("[INFO] ");
                break;
            case 4:
                stringBuffer.append("[WARN] ");
                break;
            case 5:
                stringBuffer.append("[ERROR] ");
                break;
            case 6:
                stringBuffer.append("[FATAL] ");
                break;
            default:
                break;
        }
        if (showShortName != 0) {
            if (this.prefix == 0) {
                i = new StringBuffer();
                i.append(this.logName.substring(this.logName.lastIndexOf(".") + 1));
                i.append(" - ");
                this.prefix = i.toString();
                i = new StringBuffer();
                i.append(this.prefix.substring(this.prefix.lastIndexOf("/") + 1));
                i.append("-");
                this.prefix = i.toString();
            }
            stringBuffer.append(this.prefix);
        } else if (showLogName != 0) {
            stringBuffer.append(String.valueOf(this.logName));
            stringBuffer.append(" - ");
        }
        stringBuffer.append(String.valueOf(obj));
        if (th != null) {
            stringBuffer.append(" <");
            stringBuffer.append(th.toString());
            stringBuffer.append(">");
            i = new StringWriter(1024);
            obj = new PrintWriter(i);
            th.printStackTrace(obj);
            obj.close();
            stringBuffer.append(i.toString());
        }
        System.err.println(stringBuffer.toString());
    }

    protected boolean isLevelEnabled(int i) {
        return i >= this.currentLogLevel;
    }

    public final void debug(Object obj) {
        if (isLevelEnabled(2)) {
            log(2, obj, null);
        }
    }

    public final void debug(Object obj, Throwable th) {
        if (isLevelEnabled(2)) {
            log(2, obj, th);
        }
    }

    public final void trace(Object obj) {
        if (isLevelEnabled(1)) {
            log(1, obj, null);
        }
    }

    public final void trace(Object obj, Throwable th) {
        if (isLevelEnabled(1)) {
            log(1, obj, th);
        }
    }

    public final void info(Object obj) {
        if (isLevelEnabled(3)) {
            log(3, obj, null);
        }
    }

    public final void info(Object obj, Throwable th) {
        if (isLevelEnabled(3)) {
            log(3, obj, th);
        }
    }

    public final void warn(Object obj) {
        if (isLevelEnabled(4)) {
            log(4, obj, null);
        }
    }

    public final void warn(Object obj, Throwable th) {
        if (isLevelEnabled(4)) {
            log(4, obj, th);
        }
    }

    public final void error(Object obj) {
        if (isLevelEnabled(5)) {
            log(5, obj, null);
        }
    }

    public final void error(Object obj, Throwable th) {
        if (isLevelEnabled(5)) {
            log(5, obj, th);
        }
    }

    public final void fatal(Object obj) {
        if (isLevelEnabled(6)) {
            log(6, obj, null);
        }
    }

    public final void fatal(Object obj, Throwable th) {
        if (isLevelEnabled(6)) {
            log(6, obj, th);
        }
    }

    public final boolean isDebugEnabled() {
        return isLevelEnabled(2);
    }

    public final boolean isErrorEnabled() {
        return isLevelEnabled(5);
    }

    public final boolean isFatalEnabled() {
        return isLevelEnabled(6);
    }

    public final boolean isInfoEnabled() {
        return isLevelEnabled(3);
    }

    public final boolean isTraceEnabled() {
        return isLevelEnabled(1);
    }

    public final boolean isWarnEnabled() {
        return isLevelEnabled(4);
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (String str2) {
            throw new NoClassDefFoundError(str2.getMessage());
        }
    }

    private static java.lang.ClassLoader getContextClassLoader() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = class$java$lang$Thread;	 Catch:{ NoSuchMethodException -> 0x0037 }
        if (r1 != 0) goto L_0x000e;	 Catch:{ NoSuchMethodException -> 0x0037 }
    L_0x0005:
        r1 = "java.lang.Thread";	 Catch:{ NoSuchMethodException -> 0x0037 }
        r1 = class$(r1);	 Catch:{ NoSuchMethodException -> 0x0037 }
        class$java$lang$Thread = r1;	 Catch:{ NoSuchMethodException -> 0x0037 }
        goto L_0x0010;	 Catch:{ NoSuchMethodException -> 0x0037 }
    L_0x000e:
        r1 = class$java$lang$Thread;	 Catch:{ NoSuchMethodException -> 0x0037 }
    L_0x0010:
        r2 = "getContextClassLoader";	 Catch:{ NoSuchMethodException -> 0x0037 }
        r1 = r1.getMethod(r2, r0);	 Catch:{ NoSuchMethodException -> 0x0037 }
        r2 = java.lang.Thread.currentThread();	 Catch:{ InvocationTargetException -> 0x0022, NoSuchMethodException -> 0x0037 }
        r1 = r1.invoke(r2, r0);	 Catch:{ InvocationTargetException -> 0x0022, NoSuchMethodException -> 0x0037 }
        r1 = (java.lang.ClassLoader) r1;	 Catch:{ InvocationTargetException -> 0x0022, NoSuchMethodException -> 0x0037 }
        r0 = r1;
        goto L_0x0037;
    L_0x0022:
        r1 = move-exception;
        r2 = r1.getTargetException();	 Catch:{ NoSuchMethodException -> 0x0037 }
        r2 = r2 instanceof java.lang.SecurityException;	 Catch:{ NoSuchMethodException -> 0x0037 }
        if (r2 != 0) goto L_0x0037;	 Catch:{ NoSuchMethodException -> 0x0037 }
    L_0x002b:
        r2 = new org.apache.commons.logging.LogConfigurationException;	 Catch:{ NoSuchMethodException -> 0x0037 }
        r3 = "Unexpected InvocationTargetException";	 Catch:{ NoSuchMethodException -> 0x0037 }
        r1 = r1.getTargetException();	 Catch:{ NoSuchMethodException -> 0x0037 }
        r2.<init>(r3, r1);	 Catch:{ NoSuchMethodException -> 0x0037 }
        throw r2;	 Catch:{ NoSuchMethodException -> 0x0037 }
    L_0x0037:
        if (r0 != 0) goto L_0x004c;
    L_0x0039:
        r0 = class$org$apache$commons$logging$impl$SimpleLog;
        if (r0 != 0) goto L_0x0046;
    L_0x003d:
        r0 = "org.apache.commons.logging.impl.SimpleLog";
        r0 = class$(r0);
        class$org$apache$commons$logging$impl$SimpleLog = r0;
        goto L_0x0048;
    L_0x0046:
        r0 = class$org$apache$commons$logging$impl$SimpleLog;
    L_0x0048:
        r0 = r0.getClassLoader();
    L_0x004c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.impl.SimpleLog.getContextClassLoader():java.lang.ClassLoader");
    }

    private static InputStream getResourceAsStream(String str) {
        return (InputStream) AccessController.doPrivileged(new AnonymousClass1(str));
    }
}
