package android.support.v4.text;

import android.support.annotation.RequiresApi;
import java.lang.reflect.Method;
import java.util.Locale;

@RequiresApi(14)
class ICUCompatIcs {
    private static final String TAG = "ICUCompatIcs";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    ICUCompatIcs() {
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
        r0 = "libcore.icu.ICU";	 Catch:{ Exception -> 0x0027 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0027 }
        if (r0 == 0) goto L_0x0026;	 Catch:{ Exception -> 0x0027 }
    L_0x0008:
        r1 = "getScript";	 Catch:{ Exception -> 0x0027 }
        r2 = 1;	 Catch:{ Exception -> 0x0027 }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0027 }
        r4 = java.lang.String.class;	 Catch:{ Exception -> 0x0027 }
        r5 = 0;	 Catch:{ Exception -> 0x0027 }
        r3[r5] = r4;	 Catch:{ Exception -> 0x0027 }
        r1 = r0.getMethod(r1, r3);	 Catch:{ Exception -> 0x0027 }
        sGetScriptMethod = r1;	 Catch:{ Exception -> 0x0027 }
        r1 = "addLikelySubtags";	 Catch:{ Exception -> 0x0027 }
        r2 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0027 }
        r3 = java.lang.String.class;	 Catch:{ Exception -> 0x0027 }
        r2[r5] = r3;	 Catch:{ Exception -> 0x0027 }
        r0 = r0.getMethod(r1, r2);	 Catch:{ Exception -> 0x0027 }
        sAddLikelySubtagsMethod = r0;	 Catch:{ Exception -> 0x0027 }
    L_0x0026:
        return;
    L_0x0027:
        r0 = 0;
        sGetScriptMethod = r0;
        sAddLikelySubtagsMethod = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.text.ICUCompatIcs.<clinit>():void");
    }

    public static String maximizeAndGetScript(Locale locale) {
        locale = addLikelySubtags(locale);
        return locale != null ? getScript(locale) : null;
    }

    private static java.lang.String getScript(java.lang.String r3) {
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
        r0 = 0;
        r1 = sGetScriptMethod;	 Catch:{ IllegalAccessException -> 0x0014, IllegalAccessException -> 0x0014 }
        if (r1 == 0) goto L_0x0014;	 Catch:{ IllegalAccessException -> 0x0014, IllegalAccessException -> 0x0014 }
    L_0x0005:
        r1 = 1;	 Catch:{ IllegalAccessException -> 0x0014, IllegalAccessException -> 0x0014 }
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x0014, IllegalAccessException -> 0x0014 }
        r2 = 0;	 Catch:{ IllegalAccessException -> 0x0014, IllegalAccessException -> 0x0014 }
        r1[r2] = r3;	 Catch:{ IllegalAccessException -> 0x0014, IllegalAccessException -> 0x0014 }
        r3 = sGetScriptMethod;	 Catch:{ IllegalAccessException -> 0x0014, IllegalAccessException -> 0x0014 }
        r3 = r3.invoke(r0, r1);	 Catch:{ IllegalAccessException -> 0x0014, IllegalAccessException -> 0x0014 }
        r3 = (java.lang.String) r3;	 Catch:{ IllegalAccessException -> 0x0014, IllegalAccessException -> 0x0014 }
        return r3;
    L_0x0014:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.text.ICUCompatIcs.getScript(java.lang.String):java.lang.String");
    }

    private static java.lang.String addLikelySubtags(java.util.Locale r3) {
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
        r3 = r3.toString();
        r0 = sAddLikelySubtagsMethod;	 Catch:{ IllegalAccessException -> 0x0018, IllegalAccessException -> 0x0018 }
        if (r0 == 0) goto L_0x0018;	 Catch:{ IllegalAccessException -> 0x0018, IllegalAccessException -> 0x0018 }
    L_0x0008:
        r0 = 1;	 Catch:{ IllegalAccessException -> 0x0018, IllegalAccessException -> 0x0018 }
        r0 = new java.lang.Object[r0];	 Catch:{ IllegalAccessException -> 0x0018, IllegalAccessException -> 0x0018 }
        r1 = 0;	 Catch:{ IllegalAccessException -> 0x0018, IllegalAccessException -> 0x0018 }
        r0[r1] = r3;	 Catch:{ IllegalAccessException -> 0x0018, IllegalAccessException -> 0x0018 }
        r1 = sAddLikelySubtagsMethod;	 Catch:{ IllegalAccessException -> 0x0018, IllegalAccessException -> 0x0018 }
        r2 = 0;	 Catch:{ IllegalAccessException -> 0x0018, IllegalAccessException -> 0x0018 }
        r0 = r1.invoke(r2, r0);	 Catch:{ IllegalAccessException -> 0x0018, IllegalAccessException -> 0x0018 }
        r0 = (java.lang.String) r0;	 Catch:{ IllegalAccessException -> 0x0018, IllegalAccessException -> 0x0018 }
        return r0;
    L_0x0018:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.text.ICUCompatIcs.addLikelySubtags(java.util.Locale):java.lang.String");
    }
}
