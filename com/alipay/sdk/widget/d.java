package com.alipay.sdk.widget;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.text.TextUtils;

public final class d {
    private static boolean a = (VERSION.SDK_INT >= 11);

    public static android.app.Dialog a(android.content.Context r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, android.content.DialogInterface.OnClickListener r5, java.lang.String r6, android.content.DialogInterface.OnClickListener r7) {
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
        r0 = new android.app.AlertDialog$Builder;
        r0.<init>(r1);
        r1 = a;
        if (r1 == 0) goto L_0x001c;
    L_0x0009:
        r1 = android.text.TextUtils.isEmpty(r6);
        if (r1 != 0) goto L_0x0012;
    L_0x000f:
        r0.setPositiveButton(r6, r7);
    L_0x0012:
        r1 = android.text.TextUtils.isEmpty(r4);
        if (r1 != 0) goto L_0x002e;
    L_0x0018:
        r0.setNegativeButton(r4, r5);
        goto L_0x002e;
    L_0x001c:
        r1 = android.text.TextUtils.isEmpty(r4);
        if (r1 != 0) goto L_0x0025;
    L_0x0022:
        r0.setPositiveButton(r4, r5);
    L_0x0025:
        r1 = android.text.TextUtils.isEmpty(r6);
        if (r1 != 0) goto L_0x002e;
    L_0x002b:
        r0.setNegativeButton(r6, r7);
    L_0x002e:
        r0.setTitle(r2);
        r0.setMessage(r3);
        r1 = r0.create();
        r2 = 0;
        r1.setCanceledOnTouchOutside(r2);
        r2 = new com.alipay.sdk.widget.e;
        r2.<init>();
        r1.setOnKeyListener(r2);
        r1.show();	 Catch:{ Throwable -> 0x0047 }
    L_0x0047:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.widget.d.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, android.content.DialogInterface$OnClickListener, java.lang.String, android.content.DialogInterface$OnClickListener):android.app.Dialog");
    }

    private static Builder a(Context context, String str, OnClickListener onClickListener, String str2, OnClickListener onClickListener2) {
        Builder builder = new Builder(context);
        if (a != null) {
            if (TextUtils.isEmpty(str2) == null && onClickListener2 != null) {
                builder.setPositiveButton(str2, onClickListener2);
            }
            if (TextUtils.isEmpty(str) == null && onClickListener != null) {
                builder.setNegativeButton(str, onClickListener);
            }
        } else {
            if (TextUtils.isEmpty(str) == null && onClickListener != null) {
                builder.setPositiveButton(str, onClickListener);
            }
            if (TextUtils.isEmpty(str2) == null && onClickListener2 != null) {
                builder.setNegativeButton(str2, onClickListener2);
            }
        }
        return builder;
    }
}
