package com.qihoo360.replugin.b;

import com.qihoo360.replugin.utils.e;

/* compiled from: HostConfigHelper */
public final class a {
    public static boolean a = true;
    public static String b = ":GuardService";
    public static int c = 2;
    public static int d = 2;
    public static int e = 2;
    public static int f = 3;
    public static int g = 6;
    public static int h = 2;
    public static int i = 3;
    public static int j = 2;
    public static int k = 2;
    public static boolean l = false;
    public static int m = 10;
    public static int n = 12;
    private static Class<?> o;

    public static void a() {
    }

    private static <T> T a(String str) throws NoSuchFieldException {
        try {
            return e.a(o, null, str);
        } catch (String str2) {
            throw new IllegalStateException(str2);
        }
    }

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "com.qihoo360.replugin.gen.RePluginHostConfig";	 Catch:{ ClassNotFoundException -> 0x0008 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0008 }
        o = r0;	 Catch:{ ClassNotFoundException -> 0x0008 }
    L_0x0008:
        r0 = "PERSISTENT_ENABLE";	 Catch:{ NoSuchFieldException -> 0x0016 }
        r0 = a(r0);	 Catch:{ NoSuchFieldException -> 0x0016 }
        r0 = (java.lang.Boolean) r0;	 Catch:{ NoSuchFieldException -> 0x0016 }
        r0 = r0.booleanValue();	 Catch:{ NoSuchFieldException -> 0x0016 }
        a = r0;	 Catch:{ NoSuchFieldException -> 0x0016 }
    L_0x0016:
        r0 = "PERSISTENT_NAME";	 Catch:{ NoSuchFieldException -> 0x0020 }
        r0 = a(r0);	 Catch:{ NoSuchFieldException -> 0x0020 }
        r0 = (java.lang.String) r0;	 Catch:{ NoSuchFieldException -> 0x0020 }
        b = r0;	 Catch:{ NoSuchFieldException -> 0x0020 }
    L_0x0020:
        r0 = "ACTIVITY_PIT_USE_APPCOMPAT";	 Catch:{ NoSuchFieldException -> 0x002e }
        r0 = a(r0);	 Catch:{ NoSuchFieldException -> 0x002e }
        r0 = (java.lang.Boolean) r0;	 Catch:{ NoSuchFieldException -> 0x002e }
        r0 = r0.booleanValue();	 Catch:{ NoSuchFieldException -> 0x002e }
        l = r0;	 Catch:{ NoSuchFieldException -> 0x002e }
    L_0x002e:
        r0 = "ACTIVITY_PIT_COUNT_TS_STANDARD";	 Catch:{ NoSuchFieldException -> 0x003c }
        r0 = a(r0);	 Catch:{ NoSuchFieldException -> 0x003c }
        r0 = (java.lang.Integer) r0;	 Catch:{ NoSuchFieldException -> 0x003c }
        r0 = r0.intValue();	 Catch:{ NoSuchFieldException -> 0x003c }
        c = r0;	 Catch:{ NoSuchFieldException -> 0x003c }
    L_0x003c:
        r0 = "ACTIVITY_PIT_COUNT_TS_SINGLE_TOP";	 Catch:{ NoSuchFieldException -> 0x004a }
        r0 = a(r0);	 Catch:{ NoSuchFieldException -> 0x004a }
        r0 = (java.lang.Integer) r0;	 Catch:{ NoSuchFieldException -> 0x004a }
        r0 = r0.intValue();	 Catch:{ NoSuchFieldException -> 0x004a }
        d = r0;	 Catch:{ NoSuchFieldException -> 0x004a }
    L_0x004a:
        r0 = "ACTIVITY_PIT_COUNT_TS_SINGLE_TASK";	 Catch:{ NoSuchFieldException -> 0x0058 }
        r0 = a(r0);	 Catch:{ NoSuchFieldException -> 0x0058 }
        r0 = (java.lang.Integer) r0;	 Catch:{ NoSuchFieldException -> 0x0058 }
        r0 = r0.intValue();	 Catch:{ NoSuchFieldException -> 0x0058 }
        e = r0;	 Catch:{ NoSuchFieldException -> 0x0058 }
    L_0x0058:
        r0 = "ACTIVITY_PIT_COUNT_TS_SINGLE_INSTANCE";	 Catch:{ NoSuchFieldException -> 0x0066 }
        r0 = a(r0);	 Catch:{ NoSuchFieldException -> 0x0066 }
        r0 = (java.lang.Integer) r0;	 Catch:{ NoSuchFieldException -> 0x0066 }
        r0 = r0.intValue();	 Catch:{ NoSuchFieldException -> 0x0066 }
        f = r0;	 Catch:{ NoSuchFieldException -> 0x0066 }
    L_0x0066:
        r0 = "ACTIVITY_PIT_COUNT_NTS_STANDARD";	 Catch:{ NoSuchFieldException -> 0x0074 }
        r0 = a(r0);	 Catch:{ NoSuchFieldException -> 0x0074 }
        r0 = (java.lang.Integer) r0;	 Catch:{ NoSuchFieldException -> 0x0074 }
        r0 = r0.intValue();	 Catch:{ NoSuchFieldException -> 0x0074 }
        g = r0;	 Catch:{ NoSuchFieldException -> 0x0074 }
    L_0x0074:
        r0 = "ACTIVITY_PIT_COUNT_NTS_SINGLE_TOP";	 Catch:{ NoSuchFieldException -> 0x0082 }
        r0 = a(r0);	 Catch:{ NoSuchFieldException -> 0x0082 }
        r0 = (java.lang.Integer) r0;	 Catch:{ NoSuchFieldException -> 0x0082 }
        r0 = r0.intValue();	 Catch:{ NoSuchFieldException -> 0x0082 }
        h = r0;	 Catch:{ NoSuchFieldException -> 0x0082 }
    L_0x0082:
        r0 = "ACTIVITY_PIT_COUNT_NTS_SINGLE_TASK";	 Catch:{ NoSuchFieldException -> 0x0090 }
        r0 = a(r0);	 Catch:{ NoSuchFieldException -> 0x0090 }
        r0 = (java.lang.Integer) r0;	 Catch:{ NoSuchFieldException -> 0x0090 }
        r0 = r0.intValue();	 Catch:{ NoSuchFieldException -> 0x0090 }
        i = r0;	 Catch:{ NoSuchFieldException -> 0x0090 }
    L_0x0090:
        r0 = "ACTIVITY_PIT_COUNT_NTS_SINGLE_INSTANCE";	 Catch:{ NoSuchFieldException -> 0x009e }
        r0 = a(r0);	 Catch:{ NoSuchFieldException -> 0x009e }
        r0 = (java.lang.Integer) r0;	 Catch:{ NoSuchFieldException -> 0x009e }
        r0 = r0.intValue();	 Catch:{ NoSuchFieldException -> 0x009e }
        j = r0;	 Catch:{ NoSuchFieldException -> 0x009e }
    L_0x009e:
        r0 = "ACTIVITY_PIT_COUNT_TASK";	 Catch:{ NoSuchFieldException -> 0x00ac }
        r0 = a(r0);	 Catch:{ NoSuchFieldException -> 0x00ac }
        r0 = (java.lang.Integer) r0;	 Catch:{ NoSuchFieldException -> 0x00ac }
        r0 = r0.intValue();	 Catch:{ NoSuchFieldException -> 0x00ac }
        k = r0;	 Catch:{ NoSuchFieldException -> 0x00ac }
    L_0x00ac:
        r0 = "ADAPTER_COMPATIBLE_VERSION";	 Catch:{ NoSuchFieldException -> 0x00ba }
        r0 = a(r0);	 Catch:{ NoSuchFieldException -> 0x00ba }
        r0 = (java.lang.Integer) r0;	 Catch:{ NoSuchFieldException -> 0x00ba }
        r0 = r0.intValue();	 Catch:{ NoSuchFieldException -> 0x00ba }
        m = r0;	 Catch:{ NoSuchFieldException -> 0x00ba }
    L_0x00ba:
        r0 = "ADAPTER_CURRENT_VERSION";	 Catch:{ NoSuchFieldException -> 0x00c9 }
        r0 = a(r0);	 Catch:{ NoSuchFieldException -> 0x00c9 }
        r0 = (java.lang.Integer) r0;	 Catch:{ NoSuchFieldException -> 0x00c9 }
        r0 = r0.intValue();	 Catch:{ NoSuchFieldException -> 0x00c9 }
        n = r0;	 Catch:{ NoSuchFieldException -> 0x00c9 }
        return;
    L_0x00c9:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.b.a.<clinit>():void");
    }
}
