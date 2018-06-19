package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

@Deprecated
public final class ViewConfigurationCompat {
    private static final String TAG = "ViewConfigCompat";
    private static Method sGetScaledScrollFactorMethod;

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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 25;
        if (r0 != r1) goto L_0x0014;
    L_0x0006:
        r0 = android.view.ViewConfiguration.class;	 Catch:{ Exception -> 0x0014 }
        r1 = "getScaledScrollFactor";	 Catch:{ Exception -> 0x0014 }
        r2 = 0;	 Catch:{ Exception -> 0x0014 }
        r2 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0014 }
        r0 = r0.getDeclaredMethod(r1, r2);	 Catch:{ Exception -> 0x0014 }
        sGetScaledScrollFactorMethod = r0;	 Catch:{ Exception -> 0x0014 }
        return;
    L_0x0014:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewConfigurationCompat.<clinit>():void");
    }

    @Deprecated
    public static int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    @Deprecated
    public static boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
        return viewConfiguration.hasPermanentMenuKey();
    }

    public static float getScaledHorizontalScrollFactor(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        if (VERSION.SDK_INT >= 26) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }
        return getLegacyScrollFactor(viewConfiguration, context);
    }

    public static float getScaledVerticalScrollFactor(@NonNull ViewConfiguration viewConfiguration, @NonNull Context context) {
        if (VERSION.SDK_INT >= 26) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
        return getLegacyScrollFactor(viewConfiguration, context);
    }

    private static float getLegacyScrollFactor(android.view.ViewConfiguration r3, android.content.Context r4) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 25;
        if (r0 < r1) goto L_0x001b;
    L_0x0006:
        r0 = sGetScaledScrollFactorMethod;
        if (r0 == 0) goto L_0x001b;
    L_0x000a:
        r0 = sGetScaledScrollFactorMethod;	 Catch:{ Exception -> 0x001b }
        r1 = 0;	 Catch:{ Exception -> 0x001b }
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x001b }
        r3 = r0.invoke(r3, r1);	 Catch:{ Exception -> 0x001b }
        r3 = (java.lang.Integer) r3;	 Catch:{ Exception -> 0x001b }
        r3 = r3.intValue();	 Catch:{ Exception -> 0x001b }
        r3 = (float) r3;
        return r3;
    L_0x001b:
        r3 = new android.util.TypedValue;
        r3.<init>();
        r0 = r4.getTheme();
        r1 = 16842829; // 0x101004d float:2.3693774E-38 double:8.321463E-317;
        r2 = 1;
        r0 = r0.resolveAttribute(r1, r3, r2);
        if (r0 == 0) goto L_0x003b;
    L_0x002e:
        r4 = r4.getResources();
        r4 = r4.getDisplayMetrics();
        r3 = r3.getDimension(r4);
        return r3;
    L_0x003b:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewConfigurationCompat.getLegacyScrollFactor(android.view.ViewConfiguration, android.content.Context):float");
    }

    private ViewConfigurationCompat() {
    }
}
