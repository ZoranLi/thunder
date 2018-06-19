package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.Method;

public final class BundleCompat {

    static class BundleCompatBaseImpl {
        private static final String TAG = "BundleCompatBaseImpl";
        private static Method sGetIBinderMethod;
        private static boolean sGetIBinderMethodFetched;
        private static Method sPutIBinderMethod;
        private static boolean sPutIBinderMethodFetched;

        BundleCompatBaseImpl() {
        }

        public static android.os.IBinder getBinder(android.os.Bundle r6, java.lang.String r7) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r0 = sGetIBinderMethodFetched;
            r1 = 0;
            r2 = 1;
            if (r0 != 0) goto L_0x001b;
        L_0x0006:
            r0 = android.os.Bundle.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r3 = "getIBinder";	 Catch:{ NoSuchMethodException -> 0x0019 }
            r4 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0019 }
            r5 = java.lang.String.class;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r4[r1] = r5;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r0 = r0.getMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0019 }
            sGetIBinderMethod = r0;	 Catch:{ NoSuchMethodException -> 0x0019 }
            r0.setAccessible(r2);	 Catch:{ NoSuchMethodException -> 0x0019 }
        L_0x0019:
            sGetIBinderMethodFetched = r2;
        L_0x001b:
            r0 = sGetIBinderMethod;
            r3 = 0;
            if (r0 == 0) goto L_0x002f;
        L_0x0020:
            r0 = sGetIBinderMethod;	 Catch:{ InvocationTargetException -> 0x002d, InvocationTargetException -> 0x002d, InvocationTargetException -> 0x002d }
            r2 = new java.lang.Object[r2];	 Catch:{ InvocationTargetException -> 0x002d, InvocationTargetException -> 0x002d, InvocationTargetException -> 0x002d }
            r2[r1] = r7;	 Catch:{ InvocationTargetException -> 0x002d, InvocationTargetException -> 0x002d, InvocationTargetException -> 0x002d }
            r6 = r0.invoke(r6, r2);	 Catch:{ InvocationTargetException -> 0x002d, InvocationTargetException -> 0x002d, InvocationTargetException -> 0x002d }
            r6 = (android.os.IBinder) r6;	 Catch:{ InvocationTargetException -> 0x002d, InvocationTargetException -> 0x002d, InvocationTargetException -> 0x002d }
            return r6;
        L_0x002d:
            sGetIBinderMethod = r3;
        L_0x002f:
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.BundleCompat.BundleCompatBaseImpl.getBinder(android.os.Bundle, java.lang.String):android.os.IBinder");
        }

        public static void putBinder(android.os.Bundle r7, java.lang.String r8, android.os.IBinder r9) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r0 = sPutIBinderMethodFetched;
            r1 = 0;
            r2 = 2;
            r3 = 1;
            if (r0 != 0) goto L_0x0020;
        L_0x0007:
            r0 = android.os.Bundle.class;	 Catch:{ NoSuchMethodException -> 0x001e }
            r4 = "putIBinder";	 Catch:{ NoSuchMethodException -> 0x001e }
            r5 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x001e }
            r6 = java.lang.String.class;	 Catch:{ NoSuchMethodException -> 0x001e }
            r5[r1] = r6;	 Catch:{ NoSuchMethodException -> 0x001e }
            r6 = android.os.IBinder.class;	 Catch:{ NoSuchMethodException -> 0x001e }
            r5[r3] = r6;	 Catch:{ NoSuchMethodException -> 0x001e }
            r0 = r0.getMethod(r4, r5);	 Catch:{ NoSuchMethodException -> 0x001e }
            sPutIBinderMethod = r0;	 Catch:{ NoSuchMethodException -> 0x001e }
            r0.setAccessible(r3);	 Catch:{ NoSuchMethodException -> 0x001e }
        L_0x001e:
            sPutIBinderMethodFetched = r3;
        L_0x0020:
            r0 = sPutIBinderMethod;
            if (r0 == 0) goto L_0x0033;
        L_0x0024:
            r0 = sPutIBinderMethod;	 Catch:{ InvocationTargetException -> 0x0030, InvocationTargetException -> 0x0030, InvocationTargetException -> 0x0030 }
            r2 = new java.lang.Object[r2];	 Catch:{ InvocationTargetException -> 0x0030, InvocationTargetException -> 0x0030, InvocationTargetException -> 0x0030 }
            r2[r1] = r8;	 Catch:{ InvocationTargetException -> 0x0030, InvocationTargetException -> 0x0030, InvocationTargetException -> 0x0030 }
            r2[r3] = r9;	 Catch:{ InvocationTargetException -> 0x0030, InvocationTargetException -> 0x0030, InvocationTargetException -> 0x0030 }
            r0.invoke(r7, r2);	 Catch:{ InvocationTargetException -> 0x0030, InvocationTargetException -> 0x0030, InvocationTargetException -> 0x0030 }
            return;
        L_0x0030:
            r7 = 0;
            sPutIBinderMethod = r7;
        L_0x0033:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.BundleCompat.BundleCompatBaseImpl.putBinder(android.os.Bundle, java.lang.String, android.os.IBinder):void");
        }
    }

    private BundleCompat() {
    }

    public static IBinder getBinder(Bundle bundle, String str) {
        if (VERSION.SDK_INT >= 18) {
            return bundle.getBinder(str);
        }
        return BundleCompatBaseImpl.getBinder(bundle, str);
    }

    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        if (VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            BundleCompatBaseImpl.putBinder(bundle, str, iBinder);
        }
    }
}
