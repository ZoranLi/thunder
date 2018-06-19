package android.support.v4.text;

import android.support.annotation.RequiresApi;
import java.lang.reflect.Method;
import java.util.Locale;

@RequiresApi(21)
class ICUCompatApi21 {
    private static final String TAG = "ICUCompatApi21";
    private static Method sAddLikelySubtagsMethod;

    ICUCompatApi21() {
    }

    static {
        try {
            sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public static java.lang.String maximizeAndGetScript(java.util.Locale r3) {
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
        r0 = 1;
        r0 = new java.lang.Object[r0];	 Catch:{ InvocationTargetException -> 0x0014, InvocationTargetException -> 0x0014 }
        r1 = 0;	 Catch:{ InvocationTargetException -> 0x0014, InvocationTargetException -> 0x0014 }
        r0[r1] = r3;	 Catch:{ InvocationTargetException -> 0x0014, InvocationTargetException -> 0x0014 }
        r1 = sAddLikelySubtagsMethod;	 Catch:{ InvocationTargetException -> 0x0014, InvocationTargetException -> 0x0014 }
        r2 = 0;	 Catch:{ InvocationTargetException -> 0x0014, InvocationTargetException -> 0x0014 }
        r0 = r1.invoke(r2, r0);	 Catch:{ InvocationTargetException -> 0x0014, InvocationTargetException -> 0x0014 }
        r0 = (java.util.Locale) r0;	 Catch:{ InvocationTargetException -> 0x0014, InvocationTargetException -> 0x0014 }
        r0 = r0.getScript();	 Catch:{ InvocationTargetException -> 0x0014, InvocationTargetException -> 0x0014 }
        return r0;
    L_0x0014:
        r3 = r3.getScript();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.text.ICUCompatApi21.maximizeAndGetScript(java.util.Locale):java.lang.String");
    }
}
