package android.support.v7.app;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;
import java.lang.reflect.Method;

@RequiresApi(11)
class ActionBarDrawerToggleHoneycomb {
    private static final String TAG = "ActionBarDrawerToggleHoneycomb";
    private static final int[] THEME_ATTRS = new int[]{16843531};

    static class SetIndicatorInfo {
        public Method setHomeActionContentDescription;
        public Method setHomeAsUpIndicator;
        public ImageView upIndicatorView;

        SetIndicatorInfo(android.app.Activity r7) {
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
            r6 = this;
            r6.<init>();
            r0 = 0;
            r1 = 1;
            r2 = android.app.ActionBar.class;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r3 = "setHomeAsUpIndicator";	 Catch:{ NoSuchMethodException -> 0x0026 }
            r4 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x0026 }
            r5 = android.graphics.drawable.Drawable.class;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r4[r0] = r5;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0026 }
            r6.setHomeAsUpIndicator = r2;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r2 = android.app.ActionBar.class;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r3 = "setHomeActionContentDescription";	 Catch:{ NoSuchMethodException -> 0x0026 }
            r4 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x0026 }
            r5 = java.lang.Integer.TYPE;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r4[r0] = r5;	 Catch:{ NoSuchMethodException -> 0x0026 }
            r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0026 }
            r6.setHomeActionContentDescription = r2;	 Catch:{ NoSuchMethodException -> 0x0026 }
            return;
        L_0x0026:
            r2 = 16908332; // 0x102002c float:2.3877352E-38 double:8.353826E-317;
            r7 = r7.findViewById(r2);
            if (r7 != 0) goto L_0x0030;
        L_0x002f:
            return;
        L_0x0030:
            r7 = r7.getParent();
            r7 = (android.view.ViewGroup) r7;
            r3 = r7.getChildCount();
            r4 = 2;
            if (r3 == r4) goto L_0x003e;
        L_0x003d:
            return;
        L_0x003e:
            r0 = r7.getChildAt(r0);
            r7 = r7.getChildAt(r1);
            r1 = r0.getId();
            if (r1 != r2) goto L_0x004d;
        L_0x004c:
            goto L_0x004e;
        L_0x004d:
            r7 = r0;
        L_0x004e:
            r0 = r7 instanceof android.widget.ImageView;
            if (r0 == 0) goto L_0x0056;
        L_0x0052:
            r7 = (android.widget.ImageView) r7;
            r6.upIndicatorView = r7;
        L_0x0056:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo.<init>(android.app.Activity):void");
        }
    }

    ActionBarDrawerToggleHoneycomb() {
    }

    public static android.support.v7.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo setActionBarUpIndicator(android.support.v7.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo r4, android.app.Activity r5, android.graphics.drawable.Drawable r6, int r7) {
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
        r4 = new android.support.v7.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo;
        r4.<init>(r5);
        r0 = r4.setHomeAsUpIndicator;
        if (r0 == 0) goto L_0x0026;
    L_0x0009:
        r5 = r5.getActionBar();	 Catch:{ Exception -> 0x002f }
        r0 = r4.setHomeAsUpIndicator;	 Catch:{ Exception -> 0x002f }
        r1 = 1;	 Catch:{ Exception -> 0x002f }
        r2 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x002f }
        r3 = 0;	 Catch:{ Exception -> 0x002f }
        r2[r3] = r6;	 Catch:{ Exception -> 0x002f }
        r0.invoke(r5, r2);	 Catch:{ Exception -> 0x002f }
        r6 = r4.setHomeActionContentDescription;	 Catch:{ Exception -> 0x002f }
        r0 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x002f }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x002f }
        r0[r3] = r7;	 Catch:{ Exception -> 0x002f }
        r6.invoke(r5, r0);	 Catch:{ Exception -> 0x002f }
        goto L_0x002f;
    L_0x0026:
        r5 = r4.upIndicatorView;
        if (r5 == 0) goto L_0x002f;
    L_0x002a:
        r5 = r4.upIndicatorView;
        r5.setImageDrawable(r6);
    L_0x002f:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.ActionBarDrawerToggleHoneycomb.setActionBarUpIndicator(android.support.v7.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo, android.app.Activity, android.graphics.drawable.Drawable, int):android.support.v7.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo");
    }

    public static android.support.v7.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo setActionBarDescription(android.support.v7.app.ActionBarDrawerToggleHoneycomb.SetIndicatorInfo r3, android.app.Activity r4, int r5) {
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
        if (r3 != 0) goto L_0x0007;
    L_0x0002:
        r3 = new android.support.v7.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo;
        r3.<init>(r4);
    L_0x0007:
        r0 = r3.setHomeAsUpIndicator;
        if (r0 == 0) goto L_0x002b;
    L_0x000b:
        r4 = r4.getActionBar();	 Catch:{ Exception -> 0x002b }
        r0 = r3.setHomeActionContentDescription;	 Catch:{ Exception -> 0x002b }
        r1 = 1;	 Catch:{ Exception -> 0x002b }
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x002b }
        r2 = 0;	 Catch:{ Exception -> 0x002b }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x002b }
        r1[r2] = r5;	 Catch:{ Exception -> 0x002b }
        r0.invoke(r4, r1);	 Catch:{ Exception -> 0x002b }
        r5 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x002b }
        r0 = 19;	 Catch:{ Exception -> 0x002b }
        if (r5 > r0) goto L_0x002b;	 Catch:{ Exception -> 0x002b }
    L_0x0024:
        r5 = r4.getSubtitle();	 Catch:{ Exception -> 0x002b }
        r4.setSubtitle(r5);	 Catch:{ Exception -> 0x002b }
    L_0x002b:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.ActionBarDrawerToggleHoneycomb.setActionBarDescription(android.support.v7.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo, android.app.Activity, int):android.support.v7.app.ActionBarDrawerToggleHoneycomb$SetIndicatorInfo");
    }

    public static Drawable getThemeUpIndicator(Activity activity) {
        activity = activity.obtainStyledAttributes(THEME_ATTRS);
        Drawable drawable = activity.getDrawable(0);
        activity.recycle();
        return drawable;
    }
}
